import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception{
        String path="src/sampleFile/weather.dat";
        Part1 p1=new Part1();
        String ans=p1.part1Exe(path);
        System.out.println(ans);
    }
}