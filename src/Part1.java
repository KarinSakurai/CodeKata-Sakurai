import com.sun.deploy.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class Part1 {
    public String part1Exe(String path) throws IOException {

        try(BufferedReader weatherFile= Files.newBufferedReader(Paths.get(path));){
            String data;
            Map<Integer,Integer> tempSpreadMap=new HashMap<>();
            while((data=weatherFile.readLine())!=null){
                if(data.isEmpty()==true){
                    data="空行です";
                }
                List<String> splitDataList=splitDataToList(data);
                tempSpreadMap=calcDataToMap(splitDataList,tempSpreadMap);

            }
            Integer minSpreadDay=minSpreadDaySelect(tempSpreadMap);
            String ans="温度差の最も小さい日付は"+minSpreadDay+"日です。";
            return ans;
        } catch(IOException e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<String> splitDataToList(String data){
        String[] splitData=data.split(" ");
        List<String> splitDataList=new ArrayList<String>(Arrays.asList(splitData));

        splitDataList.removeIf(object -> object.isEmpty());
        return splitDataList;
    }

    public Map<Integer,Integer> calcDataToMap(List<String> splitDataList,Map<Integer,Integer> tempSpreadMap){
        boolean isNumeric= splitDataList.get(0).chars().allMatch(Character::isDigit);
        if(isNumeric==true){
            String strMax=splitDataList.get(1).replace("*","");
            String strMin=splitDataList.get(2).replace("*","");

            int day=Integer.parseInt(splitDataList.get(0));
            int max=Integer.parseInt(strMax);
            int min=Integer.parseInt(strMin);
            int spread=max-min;
            tempSpreadMap.put(day,spread);
        }
        return tempSpreadMap;
    }

    public Integer minSpreadDaySelect(Map<Integer,Integer> tempSpreadMap){
        Integer minSpreadDay=Collections.min(tempSpreadMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        return minSpreadDay;
    }
}
