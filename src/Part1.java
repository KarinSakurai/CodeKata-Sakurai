import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Part1 extends AbstractClass {
    List<Map<String, Object>> mapInList = new ArrayList<>();

    public String fileReadExe(String path) throws IOException {

        try (BufferedReader weatherFile = Files.newBufferedReader(Paths.get(path));) {
            String data;
            Map<String, Integer> tempSpreadMap = new HashMap<>();

            while ((data = weatherFile.readLine()) != null) {
                if (data.isEmpty()) {
                    data = "空行です";
                }
                List<String> splitDataList = splitDataToList(data);
                tempSpreadMap = calcDataToMap(splitDataList, tempSpreadMap);

            }
            String minSpreadDay = minDataSelect(tempSpreadMap);

            String ans = ansConversion(minSpreadDay, mapInList);
            return ans;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Map<String, Integer> calcDataToMap(List<String> splitDataList, Map<String, Integer> tempSpreadMap) {
        boolean isNumeric = splitDataList.get(0).chars().allMatch(Character::isDigit);
        Map<String, Object> map = new HashMap<>();
        if (isNumeric) {
            String strMax = splitDataList.get(1).replace("*", "");
            String strMin = splitDataList.get(2).replace("*", "");

            int max = Integer.parseInt(strMax);
            int min = Integer.parseInt(strMin);
            int spread = max - min;
            tempSpreadMap.put(splitDataList.get(0), spread);

            map.put("day", splitDataList.get(0));
            map.put("max", max);
            map.put("min", min);
            mapInList.add(map);
        }
        return tempSpreadMap;
    }

    public String ansConversion(String minSpreadDay, List<Map<String, Object>> mapInList) {
        Map<String, Object> answer = mapInList.stream()
                .filter(map -> (minSpreadDay.equals(map.get("day"))))
                .findAny().get();

        return answer.get("day") + " " + answer.get("max") + " " + answer.get("min");
    }

}
