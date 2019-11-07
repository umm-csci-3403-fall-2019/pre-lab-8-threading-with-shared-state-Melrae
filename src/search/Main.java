package search;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

// I completed this with help from Jackson Tenor and Aaron Walter
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Update this to make things go faster or take longer for timing studies.
        final int ARRAY_SIZE = 1000000;
        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < ARRAY_SIZE; ++i) {
            numbers.add(random.nextInt(ARRAY_SIZE));
        }

        Instant startTime = Instant.now();
//        System.out.println(searchArray(numbers.get(1), numbers));
//        System.out.println(searchArray(numbers.get(5), numbers));
//        System.out.println(searchArray(numbers.get(900), numbers));
//        System.out.println(searchArray(numbers.get(3200), numbers));
//        System.out.println(searchArray(numbers.get(7400), numbers));
//        System.out.println(searchArray(numbers.get(9876), numbers));
        Instant endTime = Instant.now();
        Duration totalTime = Duration.between(startTime, endTime);
        System.out.println("Total time was " + (totalTime.getNano() / 1000000) + " milliseconds");

        startTime = Instant.now();
        System.out.println(searchArray(200000, numbers));
        System.out.println(searchArray(-45, numbers));
        endTime = Instant.now();
        totalTime = Duration.between(startTime, endTime);
        System.out.println("Total time was " + (totalTime.getNano() / 1000000) + " milliseconds");
    }

    private static boolean searchArray(int target, ArrayList<Integer> list) throws InterruptedException {
        // You can replace ThreadedSearch with LinearSearch to see this work with
        // the given linear search code.
        Searcher<Integer> searcher = new LinearSearch<>();

        // This specifies 4 threads for the tests. It would be a good idea to play
        // with this and see how that changes things. Keep in mind that your number
        // of threads *may* need to evenly divide the length of the list being
        // searched (ARRAY_SIZE in this case).
        Searcher<Integer> searcher2 = new ThreadedSearch<>(4);

        System.out.println(searcher2.search(target, list));
        return searcher.search(target, list);
    }

}
