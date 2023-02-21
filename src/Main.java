import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Part1 p1=new Part1();
        String ans=p1.part1Exe();
        System.out.println(ans);
    }
}