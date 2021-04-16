package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	//возращает сумму всех чисел от 10 до 100, содержащихся в строке
	static int num_parse(String s) {
		String[] strArray = new String[s.length()];
		Arrays.fill(strArray, "");
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.getNumericValue(s.charAt(i)) > 0 && Character.getNumericValue(s.charAt(i)) < 10) {
				if (i < s.length() - 1 && Character.getNumericValue(s.charAt(i+1)) > 1 && Character.getNumericValue(s.charAt(i+1)) < 10) {
					String temp = "";
					while (i < s.length() && Character.getNumericValue(s.charAt(i)) > - 1 && Character.getNumericValue(s.charAt(i)) < 10) {
						temp += s.charAt(i);
						i++;
					}
					if (temp != ""){
						strArray[k] = temp;
						k++;
					}
				}
			}
			}
		int ret = 0;
		for (int i=0; i < s.length(); i++) {
			if (strArray[i] != "") {
				if (Integer.parseInt(strArray[i]) <= 100)
					ret += Integer.parseInt(strArray[i]);
			}
		}
		return ret;
	}

	//возвращает массив слов без пробелов
	static String[] divider(String s){
		s.trim();
		String arr[] = new String[s.length()];
		Arrays.fill(arr, "");
		int index = 0;
		int k = 0;
		for (int i=0; i < s.length(); i++) {
			if (Character.toString(s.charAt(i)).equals(" ")) {
				arr[k] = s.substring(index, i);
				index = i+1;
				k++;
			}
			arr[k] = s.substring(index);
		}
		return arr;
	}

	//говорит, содержит ли строка числа
	static Boolean is_num(String s) {
		Boolean found = false;
		int i = 0;
		while(!found &&  i<s.length()){
			if(Character.getNumericValue(s.charAt(i)) < 10 && Character.getNumericValue(s.charAt(i)) >= 0) {
				found = true;
			}
			i++;
		}
		return found;
	}
	//убирает арифметические знаки
	static String ariph_remover(String s){
		int indexes[] = new int[s.length()];
		Arrays.fill(indexes, s.length() + 1);
		String s_mod = s;
		int k = 0;
		for (int i=0; i<s.length(); i++) {
			if ( ((int) s.charAt(i) > 32 && (int) s.charAt(i) < 46) || ((int) s.charAt(i) > 57 && (int) s.charAt(i) < 63)) {
				indexes[k] = i;
				k++;
			}
		}
		for (int i=s.length() - 1; i>-1; i--) {
			if (indexes[i] != s.length() + 1) {
				s_mod = s_mod.substring(0, indexes[i]) + s_mod.substring(indexes[i] + 1);
			}
		}
		return s_mod;
	}

    public static void main(String[] args) {
		System.out.println("Write sentence");
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		String arr[] = divider(string);
		int sum = 0;
		System.out.println("Words without numbers cleared of ariphmetic signs:");
		for (int i = 0; i < arr.length; i++) {
			if (is_num(arr[i])) {
				sum += num_parse(arr[i]);
			}
			else if (!arr[i].equals("")){
				arr[i] = ariph_remover(arr[i]);
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println("");
		System.out.println("sum = " + sum);
    }
}
