package whomi.com.test1;


import java.util.ArrayList;

public class Calculator {
	
	
	ArrayList<Number> Calculate(ArrayList<Number> eq){
		char[] supportedOps = {'*','/','+','-'};
		int index = 0;
		int charDex = 0;


		while (index < supportedOps.length){
			charDex = 0;
			while (charDex < eq.size()){
				if (eq.get(charDex).isExp() && eq.get(charDex).getExp() == supportedOps[index]){
					System.out.println(eq.get(charDex-1).getNumber()+""+eq.get(charDex).getExp()+""+eq.get(charDex+1).getNumber());
					eq.get(charDex).setNumber(eq.get(charDex).performOp(eq.get(charDex-1),eq.get(charDex+1)));
					System.out.println(eq.get(charDex).getNumber());
					eq.remove(charDex+1);
					eq.remove(charDex-1);
					charDex = 0;
				}
				charDex++;
			}
			index++;
		}

		return eq;
	}
}
