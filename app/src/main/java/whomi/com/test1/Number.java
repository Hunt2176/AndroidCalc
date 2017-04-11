package whomi.com.test1;


public class Number {
	private Double Number;
	private char exp = '#';
	private boolean isNumber = true;
	
	Number (Double Number){
		this.Number = Number;
	}
	Number (String Number){
		
		if (!isNumber(Number)){
			this.isNumber = false;
			exp = Number.charAt(0);
			return;
		}
		
		this.Number = Double.valueOf(Number);
	}
	
	
	void setNumber (Double Number){
		this.Number = Number;
		this.isNumber = true;
	}
	void setNumber (Number Number){
		this.Number = Number.getNumber();
        this.isNumber = true;
	}
	Double getNumber (){
		if (isExp()){
			return null;
		}
		return this.Number;
	}
	
	
	Double add(Number Number){
		return this.Number+Number.getNumber();
	}
	Double sub(Number Number){
		return this.Number-Number.getNumber();
	}
	Double mul(Number Number){
		return this.Number*Number.getNumber();
	}
	Double div(Number Number){
		return this.Number/Number.getNumber();
	}
	
	
	Double add(Double Number){
		return this.Number+Number;
	}
	Double sub(Double Number){
		return this.Number-Number;
	}
	Double mul(Double Number){
		return this.Number*Number;
	}
	Double div(Double Number){
		return this.Number/Number;
	}
	
	
	Character getExp(){
		return exp;
	}
	
	boolean isNegative(){
        return this.Number < 0;
    }
	
	
	boolean isExp(){
        return isNumber == false;
    }
	
	Double performOp(Number num1,Number num2){
		if (exp == '*'){
			return num1.mul(num2);
		}
		else if (exp == '/'){
			return num1.div(num2);
		}
		else if (exp == '+'){
			return num1.add(num2);
		}
		else if (exp == '-'){
			return num1.sub(num2);
		}
		return null;
	}

	private boolean isNumber(String Number){
		for (int i = 0;i < Number.length();i++){
			if (!Character.isDigit(Number.charAt(i))){
				if (Number.charAt(i) == '-' && i == 0 && Number.length()>1){
					continue;
				}
				if (Number.charAt((i)) == '.'){
					continue;
				}
				return false;
			}
		}

		return true;
	}
	
}
