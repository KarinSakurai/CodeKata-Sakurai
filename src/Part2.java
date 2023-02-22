import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public String part2Exe(String path) throws IOException{
        try(BufferedReader footBallFile= Files.newBufferedReader(Paths.get(path));){
            String data;
            Map<String,Integer> scoreDiffMap=new HashMap<>();

            while((data=footBallFile.readLine())!=null){
                List<String> splitDataList=splitDataToList(data);
                scoreDiffMap=calcDataToMap(splitDataList, scoreDiffMap);
            }
            String group=minDiffTeamSelect(scoreDiffMap);
            String ans="点数差が一番小さいチームは"+group+"です。";
            return ans;

        }catch(IOException e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<String> splitDataToList(String data){
        String[] splitData=data.split(" ");
        List<String> splitDataList=new ArrayList<>(Arrays.asList(splitData));
        splitDataList.removeIf(object -> object.isEmpty());
        return splitDataList;
    }

    public Map<String,Integer> calcDataToMap(List<String> splitDataList,Map<String,Integer> scoreDiffMap){
        String num="([0-9]+)(\\.)?";
        Pattern pattern=Pattern.compile(num);
        Matcher matcher=pattern.matcher(splitDataList.get(0));
        boolean isNumeric=matcher.matches();

        if(isNumeric){
            Integer strMax= Integer.valueOf(splitDataList.get(6));
            Integer strMin= Integer.valueOf(splitDataList.get(8));
            Integer def=Math.abs(strMax-strMin);
            scoreDiffMap.put(splitDataList.get(1),def);
        }
        return scoreDiffMap;
    }

    public String minDiffTeamSelect(Map<String,Integer> scoreDiffMap){
        String minDiffTeam=Collections.min(
                scoreDiffMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        return minDiffTeam;
    }

}

