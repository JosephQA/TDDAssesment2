package com.qa.testdrivendevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Stream;

public class Questions {
	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string and a char, returns the position in the String where the char
	 * first appears. Ensure the positions are numbered correctly, please refer to
	 * the examples for guidance. <br>
	 * Do not ignore case <br>
	 * Ignore whitespace <br>
	 * If the char does not occur, return the number -1. <br>
	 * <br>
	 * For Example: <br>
	 * returnPosition("This is a Sentence",'s') → 4 <br>
	 * returnPosition("This is a Sentence",'S') → 8 <br>
	 * returnPosition("Fridge for sale",'z') → -1
	 */
	public int returnPosition(String input, char letter) {
		input = input.replace(" ", "");
		int i = input.indexOf(letter);
		if (i == -1) {
			i = i - 1;
		}
		return i + 1;
	}

	/**
	 * Given two Strings of equal length, 'merge' them into one String. Do this by
	 * 'zipping' the Strings together. <br>
	 * Start with the first char of the first String. <br>
	 * Then add the first char from the second String. <br>
	 * Then add the second char from the first String. <br>
	 * And so on. <br>
	 * Maintain case. <br>
	 * You will not encounter whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * zipped("String","Fridge") → "SFtrriidngge" <br>
	 * zipped("Dog","Cat") → "DCoagt"<br>
	 * zipped("True","Tree") → "TTrrueee" <br>
	 * zipped("return","letter") → "rleettutrenr" <br>
	 */
	public String zipped(String input1, String input2) {
		String resultStr = ""; // new empty string to add to
		for (int i = 0; i < input1.length(); i = i + 1) {
			resultStr = resultStr + input1.charAt(i) + input2.charAt(i);// add chars sequentially to string from both
																		// inputs
		}

		return resultStr;
	}

	/**
	 * Given an Array of Strings, remove any duplicate Strings that occur, then
	 * return the Array. <br>
	 * Do not ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * removeDuplicates({"Dog"}) → {"Dog"} <br>
	 * removeDuplicates({"Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","DoG","Cat"}) → {"Dog","DoG","Cat"}
	 */
	public String[] removeDuplicates(String[] strArr) {
//		ArrayList<String> strList = new ArrayList<String>();
//		for(String s : strArr) {strList.add(s);System.out.println(s);}
//		Stream<String>strStream =  strList.stream().sorted().distinct()  ;
//		
//		strList.clear();
//		ArrayList<String> strList2 = new ArrayList<String>();
//		strStream.forEach(ele -> {strList2.add(ele);
//		System.out.println(ele);
//		});
//		String[] resArr = new String[strList2.size()];
//		for(int i = 0; i < strList2.size(); i++) {
//			resArr[i] = strList2.get(i);
//		}
//		if(resArr.length == 0) {resArr = strArr;}
//		

		String placeholder = "";
		String[] resArr2 = new String[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			if (placeholder != strArr[i]) {
				placeholder = strArr[i];
				resArr2[i] = placeholder;
				System.out.println(placeholder + "__");
			}
		}
		List<String> tmp = new ArrayList<>();
		for (String ele : resArr2) {
			if (ele != null) {
				tmp.add(ele);
			}
		}
		String[] resArr3 = tmp.toArray(new String[tmp.size()]);
		return resArr3;
	}

	/**
	 * Given a large string that represents a csv (comma separated values), the
	 * structure of each record will be as follows:
	 * owner,nameOfFile,encrypted?,fileSize <br>
	 * <br>
	 * Example:
	 * "Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445"
	 * <br>
	 * <br>
	 * Where a comma separates out the fields, and the \n represents a new line.
	 * <br>
	 * For each record, if it is not encrypted, return the names of the owners of
	 * the files in a String Array. <br>
	 * Do not include duplicate names. <br>
	 * <br>
	 * For Example: <br>
	 * csvScan("Jeff,private.key,False,1445") → {"Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,True,1318\nJeff,private.key,False,1445")
	 * → {"Jeff"} <br>
	 * csvScan("Bert,private.key,False,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445")
	 * → {"Bert","Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445")
	 * → {"Bert","Jeff"}
	 */
	public String[] csvScan(String csvInput) {
		//organise input
		String[] tmpStr = csvInput.split("\n");
		 System.out.println(tmpStr[0]);
		if (tmpStr[0] == null) {
			tmpStr = new String[] { csvInput };
		}
		try { //account for single lines (yes its ugly i don't care string manipulation can jump off  A CLIFF
			String tst = tmpStr[0];
		} catch (Exception e) {
			tmpStr = new String[1];
			tmpStr[0] = csvInput;
		}
		String[] resArr = new String[tmpStr.length];
		for (int i = 0; i < tmpStr.length; i++) {
			// fetch first value from csv stringline
			String strline = tmpStr[i];
			// conditional check for false in line
			if (strline.contains("False")) {
				String[] nameArr = strline.split(",");
				 System.out.println(nameArr[0]+"__");
				resArr[i] = nameArr[0]; //pass only name into further processing
				System.out.println(resArr[i]);
			}
		} // array of names get
			// now trim size to pass test condition names not dupliicated
		List<String> tmp = new ArrayList<>();
		String eleprev = "";
		for (String ele : resArr) { System.out.println(ele+"++");
		if(ele == null) {}	//intentionally nothing
		else if (!ele.equals(eleprev)) {
				tmp.add(ele);
				eleprev = ele;
			}
		}
		String[] resArr2 = tmp.toArray(new String[tmp.size()]);

		System.out.println(resArr.length + "__" + resArr2.length);
		return resArr2;
	}

	/**
	 * Write a function to randomly generate a list with 5 even numbers between 100
	 * and 200 inclusive. <br>
	 * <br>
	 * For Example: <br>
	 * listGen() → {100,102,122,198,200} <br>
	 * listGen() → {108,104,106,188,200} <br>
	 * listGen() → {154,102,132,178,164}
	 */
	public int[] listGen() {
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			double b = Math.random() * 100;
			double c = Math.random() * 100;
			int a = (int) (b + c);
			if (a < 100) {
				a = a + 100;
			}
			arr[i] = a;
		}
		System.out.println("_" + arr[0] + "_" + arr[1] + "_" + arr[2] + "_" + arr[3] + "_" + arr[4]);
		return arr;
	}

	/**
	 * A prime number is one which is only divisible by one and itself. <br>
	 * Write a function which returns the boolean True if a number is prime, and the
	 * boolean False if not. <br>
	 * <br>
	 * For Example: <br>
	 * isPrime(3) → True <br>
	 * isPrime(8) → False
	 */
	public boolean isPrime(int num) {
		boolean bool = true; // numbers are assumed to be prime
		for (int i = 2; i <= num / 2; num++) { // numbers are prime when divisible by any number higher and one and
												// lower than half of that number
			if (num % i == 0) {
				bool = false;
				break;
			} // any 0 modulous indicates a divisor was found in the range above, the number
				// is not prime and we can stop looking
		}

		return bool;
	}

	/**
	 * Wrtie a function which returns the number of vowels in a given string. <br>
	 * You should ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * getVowel("Hello") → 2 <br>
	 * getVowel("hEelLoooO") → 6
	 */
	public int getVowel(String input) {
		int count = 0;
		System.out.println(input+ " "+input.length());
		for(int i = 0; i<input.length();i++) {
			System.out.println(String.valueOf(input.charAt(i)).toLowerCase());
			if(String.valueOf(input.charAt(i)).toLowerCase().equalsIgnoreCase("a")) {count+=1;}
			if(String.valueOf(input.charAt(i)).toLowerCase().equalsIgnoreCase("e")) {count+=1;}
			if(String.valueOf(input.charAt(i)).toLowerCase().equalsIgnoreCase("i")) {count+=1;}
			if(String.valueOf(input.charAt(i)).toLowerCase().equalsIgnoreCase("o")) {count+=1;}
			if(String.valueOf(input.charAt(i)).toLowerCase().equalsIgnoreCase("u")) {count+=1;}
		}
		return count;
	}

	/**
	 * Given two string inputs, if one can be made from the other return the boolean
	 * True, if not return the boolean False. <br>
	 * <br>
	 * For Example: <br>
	 * wordFinder("dog", "god") → True <br>
	 * wordFinder("tiredest", "tree") → True <br>
	 * wordFinder("dog", "cat") → False <br>
	 * wordFinder("tripping", "gin") → True
	 */
	public boolean wordFinder(String initialWord, String madeString) {
		//
		String[] initwordcharArr = new String[initialWord.length()];
		String[] madewordcharArr = new String[madeString.length()];
		//add values to array init
		for(int k= 0; k<madeString.length();k++) {
			System.out.println(String.valueOf(madeString.charAt(k))+"__STRINGVALOF");
			madewordcharArr[k] = String.valueOf(madeString.charAt(k));
		}
		//add values to arraymade
		for(int l = 0; l<initialWord.length();l++) {
			System.out.println(String.valueOf(initialWord.charAt(l))+"__STRINGVALOF");
			initwordcharArr[l] = String.valueOf(initialWord.charAt(l));
		}
		
		int count=0;
		//iterate over madwordarr
		for(int i = 0; i<madeString.length(); i++) {
			//iterate over initwordarr
			for(int j = 0;j<initialWord.length(); j++) {
				//if char exists in both remove from both and increment count
				System.out.println(initwordcharArr[j]+"?==?"+madewordcharArr[i]);
				if(initwordcharArr[j].equalsIgnoreCase(madewordcharArr[i])) {
					System.out.println(initwordcharArr[j] + madewordcharArr[i] +"arr");
					initwordcharArr[j] = ""; madewordcharArr[i] = "";
					count+=1;
					
				}
			}
		}
		System.out.println("COUNT"+count);
		if(madeString.length()<=count && count!=0) {return true;}
		return false;
	}

	/**
	 * There is a well known mnemonic which goes "I before E, except after C", which
	 * is used to determine which order "ei" or "ie" should be in a word. <br>
	 * <br>
	 * Write a function which returns the boolean True if a string follows the
	 * mnemonic, and returns the boolean False if not. <br>
	 * <br>
	 * For Example: <br>
	 * iBeforeE("ceiling") → True <br>
	 * iBeforeE("believe") → True <br>
	 * iBeforeE("glacier") → False <br>
	 * iBeforeE("height") → False
	 */
	public boolean iBeforeE(String input) {
		if(input.toLowerCase().contains("cei")) {return true;}
		if(input.toLowerCase().contains("cie")) {return false;}
		if(input.toLowerCase().contains("ie")) {return true;}
		
		return false;
	}

	/**
	 * A factorial is the product of itself and all previous numbers <br>
	 * eg 3 factorial is 1 x 2 x 3 = 6 <br>
	 * <br>
	 * Write a function which can compute the factorial of a given number between 1
	 * and 10 inclusive. <br>
	 * <br>
	 * For Example: <br>
	 * factorial(1) → 1 <br>
	 * factorial(4) → 24 <br>
	 * factorial(8) → 40320
	 */
	public int factorial(int number) {
		int result = 1;
		for (int i = 1; i <= number; i++) {
			if (i != 0) {
				result = result * i;
			}

		}
		if (result == 0) {
			result = 1;
		}
		return result;
	}

}
