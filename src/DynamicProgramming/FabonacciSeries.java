package DynamicProgramming;

import java.util.Arrays;

public class FabonacciSeries {
    public static void main(String[] args) {
        Arrays.stream(fib(10)).forEach(System.out::println);
    }
    public static int[] fib(int n) {

        int first = 0 ; int second = 1;
        int[] fab = new int[10];
        fab[0]=first; fab[1]=second;

        for(int i =2 ; i< n ; i++){
            fab[i] = fab[i-1]+fab[i-2];
        }

        return fab;
    }

}
