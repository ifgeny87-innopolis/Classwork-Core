package com.hackerrank;

import java.util.Scanner;

/**
 * Created by marina on 13.12.2016.
 */
public class Day29 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			int N = scanner.nextInt();
			int K = scanner.nextInt();
			System.out.println(test1(N, K) + " " + test2(N, K));
		}
	}

	static int test1(int N, int K) {
		int max = 0;

		for (int A = 1; A < N; A++) {
			for (int B = A + 1; B <= N; B++) {
				int C = A & B;
				if(C < K && C > max)
					max = C;
			}
		}

		return max;
	}

	static int test2(int N, int K) {
		return ((K-1) | K) > N && K % 2 == 0
				? K-2
				: K-1;
	}
}
