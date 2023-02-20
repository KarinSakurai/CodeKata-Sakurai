import com.sun.deploy.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Part1 {
    public String part1Exe(){
        String path="src/sampleFile/weather .dat";
        Integer minSpreadDay=0;

        try(BufferedReader weatherFile= Files.newBufferedReader(Paths.get(path));){
            Map<Integer,Integer> tempSpreadMap=new HashMap<>();
            String data;
            while((data=weatherFile.readLine())!=null){
                if(data.isEmpty()==true){
                    data="空行です";
                }
                String[] splitData=data.split(" ");
                List<String> splitDataList=new ArrayList<String>(Arrays.asList(splitData));

                splitDataList.removeIf(object -> object.isEmpty());
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
            }
            minSpreadDay=Collections.min(tempSpreadMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            String ans="温度差の最も小さい日付は"+String.valueOf(minSpreadDay)+"日です。";
            return ans;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}