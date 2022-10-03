package pl.wgalka.lab1;

public class Main2 {
    public static void main(String[] args) {
        int cGrades = 10;
        String outString = "dsł";
        System.out.println(outString.charAt(2));
        System.out.println(outString.codePointAt(2));
        System.out.println(outString.contains("s"));
    }
}
