package TextEditor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Commands2 {	
	public static void main (String args[]) throws FileNotFoundException {
		File file = new File("C:\\Users\\Wei\\Documents\\trial.txt");
		Scanner input = new Scanner(file);
		String inputStr ="";
		Vector<String> str_arr = new Vector<String>();
		while(input.hasNext())
		{
			int numOfc = 80;
			inputStr = input.nextLine();
			int idx = 0;
			int begin = 0; int end = 0;
			for (int i = numOfc-1; i < inputStr.length(); i--) {
				if(inputStr.charAt(i) == ' ') {
					end = i;
					str_arr.add(inputStr.substring(begin, end));
					begin = i+1;
					i += numOfc;
				}
			}
			str_arr.add(inputStr.substring(begin, inputStr.length()));
			str_arr.add("\n");
		}
		str_arr = eqaulDistribution(str_arr);
		for (int i = 0; i < str_arr.size(); i++) {
			System.out.println(str_arr.elementAt(i));
		}
		
		input.close();
	}
	
	public static Vector<String> center(Vector<String> str_arr) {
		for (int i = 0; i < str_arr.size(); i++) {
			int spaces = 80 - str_arr.elementAt(i).length();
			spaces = spaces/2;
			String temp ="";
			for (int j = 0; j < spaces; j++) {
				temp += " ";
			}
			temp += str_arr.elementAt(i);
			for (int j = 0; j < spaces; j++) {
				temp += " ";
			}
			str_arr.set(i, temp);
		}
		return str_arr;
	}
	
	public static Vector<String> rightJustify(Vector<String> str_arr) {
		for (int i = 0; i < str_arr.size(); i++) {
			int spaces = 80 - str_arr.elementAt(i).length();
			String temp ="";
			for (int j = 0; j < spaces; j++) {
				temp += " ";
			}
			temp += str_arr.elementAt(i);
			str_arr.set(i, temp);
		}
		return str_arr;
	}
	
	public static Vector<String> leftJustify(Vector<String> str_arr) {
		for (int i = 0; i < str_arr.size(); i++) {
			String temp ="";
			for (int j = 0; j < str_arr.elementAt(i).length(); j++) {
				if(str_arr.elementAt(i).charAt(j)!= ' ') {
					temp = str_arr.elementAt(i).substring(j);
					break;
				}
			}
			str_arr.set(i, temp);
		}
		return str_arr;
	}
	public static Vector<String> eqaulDistribution(Vector<String> str_arr) {
		for (int i = 0; i < str_arr.size(); i++) {
			StringBuilder temp = new StringBuilder();
			int countOfS =0;
			for (int j = 0; j < str_arr.elementAt(i).length(); j++) {
				if(str_arr.elementAt(i).charAt(j)== ' ') {
					countOfS++;
				}
			}
			int spaces = 80 - str_arr.elementAt(i).length();
			temp.append(str_arr.elementAt(i));
			
			int num = 0;
			if(countOfS != 0)
				num = spaces/countOfS;
			for (int j = 0; j < str_arr.elementAt(i).length(); j++) {
				if(str_arr.elementAt(i).charAt(j)== ' ') {
					for (int j2 = 0; j2 < num; j2++) {
						temp.insert(j, ' ');
					}
				}
			}
			if(countOfS!=0 && spaces%countOfS !=0) {
				int num2 = spaces%countOfS;
				for (int j = 0; j < str_arr.elementAt(i).length(); j++) {
					if(str_arr.elementAt(i).charAt(j)== ' '&&num2>0) {	
							temp.insert(j, ' ');
							num2--;
					}
				}
			}
			str_arr.set(i, temp.toString());
		}
			
		return str_arr;
	}
	
}