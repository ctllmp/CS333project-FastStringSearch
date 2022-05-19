package project;
import java.util.ArrayList;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {

        System.out.println("Type the text: ");
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();
        System.out.println("Type the pat that will be searched in the text:");
        String pat = console.nextLine();

        ArrayList<algorithm> algList = new ArrayList<algorithm>();

        //create alg objects and add into the arrayList
        algList.add(new bruteForce());
        algList.add(new rabinKarp());
        algList.add(new boyerMoore());
        algList.add(new knuthMorrisPratt());


        for (algorithm alg : algList) {
            try {
                long startTime = System.currentTimeMillis();
                alg.search(pat, text); //search given pat in the given text
                long endTime = System.currentTimeMillis();
                double elapsedTimeInSec = (endTime - startTime) / 1000.0;
                System.out.println(alg.getName() + " elapsed time: " + elapsedTimeInSec + " seconds\n");
            } catch (Exception e) {
                System.out.println(alg.getName() + " has error/s\n");
            }
        }
    }
}
