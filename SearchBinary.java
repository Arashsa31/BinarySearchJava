package LabProgram812;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class SearchBinary {
	// Read and return an ArrayList of integers.
	private static int recursions = 0, comparisons = 0;

	private static ArrayList<Integer> readNums(Scanner scnr) {
		int size = scnr.nextInt(); // Read size of ArrayList
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < size; ++i) { // Read the numbers
			nums.add(scnr.nextInt());
		}
		return nums;
	}

	static public int binarySearch(int target, ArrayList<Integer> integers, int lower, int upper) {
		int mid = 0;
		recursions++;
		comparisons++;
		mid = (upper + lower) / 2;

		if ((integers.get(mid) < target) && (lower < upper)) {
			comparisons++;
			return binarySearch(target, integers, mid + 1, upper);
		} else if (integers.get(mid) > target) {
			comparisons++;
			return binarySearch(target, integers, lower, mid - 1);
		} else if (integers.get(mid) == target) {
			return mid;
		}
		return -1; // not found
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		// Input a list of integers
		ArrayList<Integer> integers = readNums(scnr);

		// Input a target value for the search
		int target = scnr.nextInt();

		int index = binarySearch(target, integers, 0, integers.size() - 1);

		System.out.printf("index: %d, recursions: %d, comparisons: %d\n", index, recursions, comparisons);
	}
}
