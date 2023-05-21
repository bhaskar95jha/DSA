package AlgoUArray;

import java.util.*;
public class Test{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int noOfTestCases = scan.nextInt();

        int doorTarget = scan.nextInt();

        Integer[] bricks = new Integer[noOfTestCases];

        for (int i = 0; i < noOfTestCases; i++) {

            bricks[i] = scan.nextInt();

        }
        int first = -1;
        int second = -1;

        for (int i = 0; i < noOfTestCases; i++) {
            if(bricks[i] < doorTarget) {

                boolean test = Arrays.asList(bricks).contains(doorTarget - bricks[i]);
                if(test) {
                    first = i;
                    second = doorTarget - bricks[first];
                    break;
                }
            }
        }

        for(int i = 0; i < noOfTestCases; i++) {
            if(bricks[i] == second) {
                second = i+1;
                first = first+1;
                System.out.println(first+" "+second);
            }
            }

        if(first == -1 || second == -1){
            System.out.println(first);
        }

    }
}
