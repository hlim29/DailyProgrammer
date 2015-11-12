package fibonacciish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		int target = prompt("Please enter the target value: ");
		System.out.println();
		long startTime = System.nanoTime();
		List<Integer> array = generateFibSequence(0, 1, target, new ArrayList<Integer>());

		int factor = 1;

		// Searches the array for the highest common factor in the sequence
		Collections.reverse(array);
		for (int e : array) {
			if (target % e == 0 && e>1) {
				factor = target / e;
				break;
			}
		}

		List<Integer> output = generateFibSequence(0, factor, target, new ArrayList<Integer>());

		// The generated array is missing the first two numbers in the sequence.
		// This is a hack!
		output.add(0, factor);
		output.add(0, 0);

		System.out.println(output);

		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(String.format("The program ran for %d milliseconds", duration / 1000));

	}

	private static int prompt(String message) {
		System.out.print(message);
		return sc.nextInt();
	}

	private static List<Integer> generateFibSequence(int fib1, int fib2, int target, List<Integer> array) {
		if (fib1 == Math.min(fib1, fib2)) {
			fib1 = fib1 + fib2;
		} else {
			fib2 = fib1 + fib2;
		}

		array.add(Math.max(fib1, fib2));

		if (fib1 + fib2 == target) array.add(target);
		if (fib1 + fib2 >= target) return array;
		return generateFibSequence(fib1, fib2, target, array);
	}

}
