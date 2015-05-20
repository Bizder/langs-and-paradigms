package bead01;


public class Tokenizer {
	private String str;
	private int index;

	public String getStr() {
		return str;
	}
	
	public String getCurrentChar() {
		
		return Character.toString(str.charAt(index));
		
	}
		
	public void First() {
		index = 0;
	}
	
	public void Next() {
		index++;
	}
	
	public Terminal Current() throws InvalidValueException {
		char ch = str.charAt(index);
		switch(ch) {
			case '+': case '-': 
				return Terminal.s;
			case '.': 
				return Terminal.p;
			case '0': 
				return Terminal.z;
			case '1': case '2':	case '3':
			case '4': case '5': case '6':
			case '7': case '8': case '9':
				return Terminal.d;
			case 'e':
				return Terminal.x;
		}
		throw new InvalidValueException();
	}
	
	public boolean End() {
		return (index == str.length());
	}
	
	public void AddLeadZero() {
		str = "0"+str;
	}
	
	public void AddEndZero() {
		str = str+".0";
	}
	
	public void AddESign() {
		str = str.substring(0, index) + "+" + str.substring(index, str.length());
	}
	public void RemoveLeadSign() {
		str = str.substring(index+1, str.length());
	}
	
	public Tokenizer(String input) {
		str = input.replace('E', 'e');;
	}
}