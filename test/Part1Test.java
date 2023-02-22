import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Part1Test {
    private Part1 targetPart1;

    @Before
    public void setUp() throws Exception {
        targetPart1=new Part1();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected= IOException.class)
    public void ファイルの読み込みテスト＿エラー() throws Exception{
        String path="src/sampleFile/weatherFalse.dat";
        targetPart1.fileReadExe(path);
    }

    @Test
    public void ファイルの読み込みテスト＿成功() throws Exception{
        String path="src/sampleFile/weather.dat";
        String result=targetPart1.fileReadExe(path);
        String expected="温度差の最も小さい日付は14日です。";
        assertEquals(expected,result);
    }
    @Test
    public void 行データの分割テスト() throws Exception{
        String data="aaa    bbb ccc   ddd";
        List<String> result=targetPart1.splitDataToList(data);
        String expected="[aaa, bbb, ccc, ddd]";

        assertEquals(expected,result.toString());
        assertEquals(4,result.size());
    }
    @Test
    public void 温度差計算テスト＿数値なし() throws Exception{
        Map<String,Integer> tempSpreadMap=new HashMap<>();
        List<String> splitDataList=new ArrayList<>();
        splitDataList.add("aaa");
        splitDataList.add("bbb");
        splitDataList.add("ccc");
        tempSpreadMap=targetPart1.calcDataToMap(splitDataList,tempSpreadMap);

        assertEquals(0,tempSpreadMap.size());
    }

    @Test
    public void 温度差計算テスト＿数値あり() throws Exception{
        Map<String,Integer> tempSpreadMap=new HashMap<>();
        List<String> splitDataList=new ArrayList<>();
        splitDataList.add("1");
        splitDataList.add("35");
        splitDataList.add("10");
        tempSpreadMap=targetPart1.calcDataToMap(splitDataList,tempSpreadMap);
        int result=tempSpreadMap.get("1");

        assertEquals(25,result);
        assertEquals(1,tempSpreadMap.size());
    }

    @Test
    public void 最小温度差の取り出しテスト() throws Exception{
        Map<String,Integer> tempSpreadMap=new HashMap<>();
        tempSpreadMap.put("1",25);
        tempSpreadMap.put("2",10);
        tempSpreadMap.put("3",50);
        String result=targetPart1.minDataSelect(tempSpreadMap);

        assertEquals("2",result);
    }
}