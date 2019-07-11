import java.io.IOException;
import java.util.Scanner;

//Given an array of integers and a target sum, determine the sum nearest to but not exceeding the target that can be created. 
//To create the sum, use any element of your array zero or more times.
public class UnboundedKnapsack {

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
	 */
	private static int unboundedKnapsack(int k, int[] arr) {

		// base checks
		if (k <= 0 || arr.length == 0) {
		 return 0;		
		}
		
		// Array Length
		int n = arr.length;

		// newArr[i] is used to store maximum value
		// with knapsack capacity
		int newArr[] = new int[k + 1];

		for (int i = 0; i <= k; i++) {
			for (int j = 0; j < n; j++) {

				// Array Value less than or equal to i
				if (arr[j] <= i) {
					newArr[i] = max(newArr[i], newArr[i - arr[j]] + arr[j]);
				}
			}
		}

		return newArr[k];

	}

	/**
	 * Main method to call unboundedKnapsack functionality
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

					// Calling unboundedKnapsack method
					int result = unboundedKnapsack(k, arr);

					// Printing the result
					System.out.println(result);
				} else {
					System.out.println("n and k should be 1 <= n,k <= 2000");
				}
			}
		} else {

			System.out.println("Test case should be 1 <= t <= 10");
		}
		scanner.close();
	}
}
