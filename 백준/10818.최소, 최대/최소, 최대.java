import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 최소 , 최대
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }

        int min = arr[0];
        int max = arr[0];

        for (int j = 0; j < arr.length; j++){
            if (min >= arr[j]){
                min = arr[j];
            }
            if (max <= arr[j]){
                max = arr[j];
            }
        }
        System.out.println(min + " " + max);


    }
}
