public class lc167 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left ++;
            }
            else if (numbers[left] + numbers[right] > target) {
                right --;
            }
            else {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
        }
        return res;
    }

}
