import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Part2Test {

    private Part2 targetPart2;

    @Before
    public void setUp() throws Exception {
        targetPart2=new Part2();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = IOException.class)
    public void ファイルの読み込み＿エラー() throws Exception{
        String path="src/sampleFile/footballFalse.dat";
        targetPart2.part2Exe(path);
    }

    @Test
    public void ファイルの読み込み＿成功() throws Exception{
        String path="src/sampleFile/football.dat";
        String result=targetPart2.part2Exe(path);
        String excepted="点数差が一番小さいチームはAston_Villaです。";

        assertEquals(excepted,result);
    }

    @Test
    public void 行データの分割テスト() throws Exception{
        String data="aaa bbb   ccc ddd  ";
        List<String> result=targetPart2.splitDataToList(data);
        String expected="[aaa, bbb, ccc, ddd]";

        assertEquals(expected,result.toString());
        assertEquals(4,result.size());
    }
    @Test
    public void 計算テスト＿数値なし() throws Exception{
        Map<String,Integer> scoreDiffMap=new HashMap<>();
        List<String> splitDataList=new ArrayList<>();
        splitDataList.add("aaa");
        splitDataList.add("bbb");
        splitDataList.add("ccc");
        scoreDiffMap=targetPart2.calcDataToMap(splitDataList,scoreDiffMap);

        assertEquals(0,scoreDiffMap.size());
    }

    @Test
    public void 計算テスト＿数値あり() throws Exception{
        Map<String,Integer> scoreDiffMap=new HashMap<>();
        List<String> splitDataList=new ArrayList<>();
        splitDataList.add("1.");
        splitDataList.add("テストチーム");
        splitDataList.add("");
        splitDataList.add("");
        splitDataList.add("");
        splitDataList.add("");
        splitDataList.add("20");
        splitDataList.add("-");
        splitDataList.add("10");
        scoreDiffMap=targetPart2.calcDataToMap(splitDataList,scoreDiffMap);
        int result=scoreDiffMap.get("テストチーム");

        assertEquals(10,result);
        assertEquals(1,scoreDiffMap.size());
    }
    @Test
    public void チーム取り出しテスト() throws Exception{
        Map<String,Integer> scoreDiffMap=new HashMap<>();
        scoreDiffMap.put("テストチーム１",10);
        scoreDiffMap.put("テストチーム２",20);
        scoreDiffMap.put("テストチーム３",30);
        String result=targetPart2.minDiffTeamSelect(scoreDiffMap);

        assertEquals("テストチーム１",result);
    }
}