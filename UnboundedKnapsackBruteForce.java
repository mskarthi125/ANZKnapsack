import java.io.IOException;
import java.util.Scanner;

//Given an array of integers and a target sum, determine the sum nearest to but not exceeding the target that can be created. 
//To create the sum, use any element of your array zero or more times.
public class UnboundedKnapsackBruteForce {

	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * Method to find the max value
	 * 
	 * @param int value1
	 * @param int value2
	 * @return
	 */
	private static int max(int value1, int value2) {
		return (value1 > value2) ? value1 : value2;
	}

	/**
	 * Method to perform recursive logic
	 * 
	 * @param int[] arr
	 * @param int   k
	 * @param int   currentIndex
	 * @return int
	 */
	private static int knapsackRecursive(int[] arr, int k, int currentIndex) {
		// base checks
		if (k <= 0 || arr.length == 0 || currentIndex < 0 || currentIndex >= arr.length) {
			return 0;
		}

		// recursive call after choosing the items at the currentIndex
		// recursive call on all items as we did not increment currentIndex
		int value1 = 0;
		if (arr[currentIndex] <= k) {
			value1 = arr[currentIndex] + knapsackRecursive(arr, k - arr[currentIndex], currentIndex);
		}

		// recursive call after excluding the element at the currentIndex
		int value2 = knapsackRecursive(arr, k, currentIndex + 1);
		return max(value1, value2);
	}

	/**
	 * Method to determine the sum nearest to but not exceeding the target that can
	 * be created.
	 * 
	 * @param int   k
	 * @param int[] arr
	 * @return int
	 */
	private static int unboundedKnapsack(int k, int[] arr) {
		return knapsackRecursive(arr, k, 0);
	}

	/**
	 * Main method to call unboundedKnapsack
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		if (1 <= t && t <= 10) {

			for (int z = 0; z < t; z++) {
				// Reading the given input
				String[] nk = scanner.nextLine().split(" ");

				// Length of array
				int n = Integer.parseInt(nk[0]);

				// Target sum
				int k = Integer.parseInt(nk[1]);

				if (1 <= n && n <= 2000 && 1 <= k && k <= 2000) {

					int[] arr = new int[n];

					// Reading array of integers
					String[] arrItems = scanner.nextLine().split(" ");
					scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

					for (int i = 0; i < n; i++) {
						int arrItem = Integer.parseInt(arrItems[i]);
						arr[i] = arrItem;
					}

					int result = unboundedKnapsack(k, arr);
					System.out.println(result);
				} else {

				}
			}
		} else {

			System.out.println("Test case should be 1 <= t <= 10");
		}
		scanner.close();
	}
}
