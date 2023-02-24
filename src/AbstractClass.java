import java.io.IOException;
import java.util.*;

public abstract class AbstractClass {

    public abstract String fileReadExe(String path) throws IOException;

    public abstract Map<String, Integer> calcDataToMap(List<String> splitDataList, Map<String, Integer> map);

    public List<String> splitDataToList(String data) {
        String[] splitData = data.split(" ");
        List<String> splitDataList = new ArrayList<>(Arrays.asList(splitData));
        splitDataList.removeIf(object -> object.isEmpty());
        return splitDataList;
    }

    public String minDataSelect(Map<String, Integer> map) {
        String minData = Collections.min(
                map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        return minData;
    }
}