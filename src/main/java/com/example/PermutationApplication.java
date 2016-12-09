package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PermutationApplication {

	public static void main(String[] args) {

		int n = 2; //n = Number of Letters
		int l = 10; // l = Length of Sequence
		char[] set = new char[n];
		for(int i = 0; i < n; i++) {
			set[i] = (char)(i + 'a');
		}

		generate("", l, set);
		//
		// SpringApplication.run(PermutationApplication.class, args);
	}

	public static int count = 1;
	public static void generate(String output, int length, char[] set) {
		if(length == 0) {
			System.out.println(String.format("%4d. %s", count++, output));
		}
		else if(output.length() > 1 && output.charAt(output.length()-1) == output.charAt(output.length()-2)) {
			for(int i = 0; i < set.length; i++) {
				if(set[i] != output.charAt(output.length()-1))
					generate(output+set[i], length-1, set);
			}
		}
		else {
			for(int i = 0; i < set.length; i++) {
					generate(output+set[i], length-1, set);
			}
		}
	}
}
