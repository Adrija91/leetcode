import java.lang.reflect.Array;
import java.util.*;

public class SeparateDigits {

    public static int[] separateDigits(int[] nums) {

        ArrayList<Integer> al = new ArrayList<>();

        for (int num : nums) {

            ArrayList<Integer> temp = new ArrayList<>();
            while (num > 0) {
                int digit = num % 10;
                temp.add(digit);
                num = num / 10;
            }
            Collections.reverse(temp);
            al.addAll(temp);
        }
        int[] res = new int[al.size()];

        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {13, 25, 83, 77};

        int[] result = separateDigits(nums);

        System.out.println(Arrays.toString(result));
    }
}