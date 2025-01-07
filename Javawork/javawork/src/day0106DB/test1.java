package day0106DB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String[] arr = a.split("");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
		System.out.println(arr);
	}

}
