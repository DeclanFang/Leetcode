public class MinimumInRotatedArray {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 4, 5, 1, 2};
        System.out.println(minArray(numbers));
    }

    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[left] > numbers[mid]) {
                right = mid;
            }
            else if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            }
            else {
                right --;
            }
        }

        return numbers[left];
    }
}
