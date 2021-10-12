import acm.program.*;
public class HexConversion extends ConsoleProgram {
	
	public void run() {
		while(true) {
			String input = readLine("Enter a Hexadecimal Number: ");
			if(input.equals("")) {
				println("Program Terminated");
				break;
			}
			else if(!input.startsWith("0x")) {
				println("" + input + " is not a valid entry");
			}
			else {
				String result = "";
				for (int i=2; i<input.length(); i++) {
					char ch = input.charAt(i);
					if (ch>='a'&& ch<='z') {
						ch=(char)((int)ch-'a'+'A');
						result+=ch;
					}
					else if ((ch>='A' && ch<='F')||(ch>='0' && ch<='9')) {
						result+=ch;
					}
					else {
						println("Illegal input."); 
						break;
					}
				}
				println(result);
				int convertedNum = hex2Int(result);
				println(convertedNum);
			}
		}
	}

	private int hex2Int(String entry) {
		int sum = 0; 
		int powerOfSixteen = 1; 
		for (int i=entry.length()-1; i>=0; i--) { 
				char conv = entry.charAt(i);
				int digit = (int)conv;
				if(conv>='A' && conv<='F') {
					digit = conv - 55;
				}
				else if ((conv>='0' && conv<='9')) {
					digit= conv-'0';
				}
				digit*=powerOfSixteen; 
				sum+=digit; 
				powerOfSixteen*=16;
			}
		 return sum;
	}
}
