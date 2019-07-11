import java.io.IOException;
import java.util.Scanner;

//Given an array of integers and a target sum, determine the sum nearest to but not exceeding the target that can be created. 
//To create the sum, use any element of your array zero or more times.
public class UnboundedKnapsackBottomUp {

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
	 * Method to determine the sum nearest to but not exceeding the target that can
	 * be created.
	 * 
	 * @param int   k
	 * @param int[] arr
	 * @return
	 *
	 **/

	private static int unboundedKnapsack(int k, int[] arr) {
		// base checks
		if (k <= 0 || arr.length == 0) {
			return 0;
		}

		int n = arr.length;
		int[][] newArr = new int[n][k + 1];

		// populate the k=0 columns
		for (int i = 0; i < n; i++) {
			newArr[i][0] = 0;
		}

		// process all sub-arrays for all capacities
		for (int i = 0; i < n; i++) {
			for (int c = 1; c <= k; c++) {
				int value1 = 0, value2 = 0;
				if (arr[i] <= c)
					value1 = arr[i] + newArr[i][c - arr[i]];
				if (i > 0)
					value2 = newArr[i - 1][c];
				newArr[i][c] = max(value1, value2);
			}
		}

		// maximum value will be in the bottom-right corner.
		return newArr[n - 1][k];
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
