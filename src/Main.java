public class Main {
    public static void main(String[] args) throws Exception {
        String weatherPath = "src/sampleFile/weather.dat";
        Part1 p1 = new Part1();
        String part1Ans = p1.fileReadExe(weatherPath);
        System.out.println(part1Ans);

        String footBallPath = "src/sampleFile/football.dat";
        Part2 p2 = new Part2();
        String part2Ans = p2.fileReadExe(footBallPath);
        System.out.println(part2Ans);
    }
}
