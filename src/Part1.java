import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Part1 extends AbstractClass {
    public String fileReadExe(String path) throws IOException {

        try (BufferedReader weatherFile = Files.newBufferedReader(Paths.get(path));) {
            String data;
            Map<String, Integer> tempSpreadMap = new HashMap<>();
            while ((data = weatherFile.readLine()) != null) {
                if (data.isEmpty() == true) {
                    data = "空行です";
                }
                List<String> splitDataList = splitDataToList(data);
                tempSpreadMap = calcDataToMap(splitDataList, tempSpreadMap);

            }
            String minSpreadDay = minDataSelect(tempSpreadMap);
            String ans = "温度差の最も小さい日付は" + minSpreadDay + "日です。";
            return ans;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Map<String, Integer> calcDataToMap(List<String> splitDataList, Map<String, Integer> tempSpreadMap) {
        boolean isNumeric = splitDataList.get(0).chars().allMatch(Character::isDigit);
        if (isNumeric) {
            String strMax = splitDataList.get(1).replace("*", "");
            String strMin = splitDataList.get(2).replace("*", "");

            int max = Integer.parseInt(strMax);
            int min = Integer.parseInt(strMin);
            int spread = max - min;
            tempSpreadMap.put(splitDataList.get(0), spread);
        }
        return tempSpreadMap;
    }
}
