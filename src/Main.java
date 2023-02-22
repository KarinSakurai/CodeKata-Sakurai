import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception{
        String weatherPath="src/sampleFile/weather.dat";
        Part1 p1=new Part1();
        String part1Ans=p1.part1Exe(weatherPath);
        System.out.println(part1Ans);

        String footBallPath="src/sampleFile/football.dat";
        Part2 p2=new Part2();
        String part2Ans=p2.part2Exe(footBallPath);
        System.out.println(part2Ans);
    }
}
