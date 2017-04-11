package whomi.com.test1;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Separates string input into an arrayList format usable by the calculator object.
 */
class Tokenizer {
    /**
     * ArrayList used to store the elements from the input string.
     */
    private ArrayList<String> allElem = new ArrayList<String>();

    Tokenizer() {}

    /**
     * Separates the input string into pieces which are then checked
     * on if they are operations or numbers and then assigned accordingly.
     * @param Input Text input passed passed to the tokenizer class for sorting into a usable arrayList.
     * @return string arrayList "allElem" - stored info split from the input string.
     */
    ArrayList<String> splitString(String Input) {
        allElem.clear();
        //Inserts a space in-between each character for sorting with the tokenizer
        Input = Input.replaceAll("", " ");
        String currentNum = "";
        char lastItem;
        char currentItem = '_';
        int count = 0;
        boolean decimalPresent = false;
        boolean complexPresent = false;

        StringTokenizer split = new StringTokenizer(Input);


        while (split.hasMoreTokens()) {
            count++;
            lastItem = currentItem;
            currentItem = split.nextToken().charAt(0);

            if (Character.isDigit(currentItem)) {
                //The string is added together to form a numbers with multiple digits
                //Operations within the other sorting statements will push the string into
                //the allElem arrayList since it would be a complete number by then
                currentNum = currentNum + currentItem;
            }

            //The following statements check for operation symbols that are used in the main
            //calculator object

            else if (currentItem == '+') {
                if (!currentNum.isEmpty()) {
                    allElem.add(currentNum);
                    currentNum = "";
                }
                allElem.add(Character.toString(currentItem));
                decimalPresent = false;
                complexPresent = false;
            }

            //The '-' statement is the only one that differs from the standard format due
            //to it being able to check if the digit string is empty and then being able to
            //create a negative number if so. An additional check is added for ')' due to
            //operations like (5+5)-10 resulting in an error due to it thinking the 5 was a '-5'
            else if (currentItem == '-') {
                if (!currentNum.isEmpty()) {
                    allElem.add(currentNum);
                    currentNum = "";
                    allElem.add(Character.toString(currentItem));
                    decimalPresent = false;
                    complexPresent = false;
                    }
                else if (lastItem == 'i'){
                    allElem.add(Character.toString(currentItem));
                    decimalPresent = false;
                    complexPresent = false;
                }
                else if (lastItem != ')') {

                    currentNum = currentNum + "-";
                }
                else {
                    allElem.add(Character.toString(currentItem));
                    decimalPresent = false;
                    complexPresent = false;
                }
            }

            else if (currentItem == '*' || currentItem == 'x' || currentItem == 'X' ) {
                if (!currentNum.isEmpty()) {
                    allElem.add(currentNum);
                    currentNum = "";
                }
                allElem.add(Character.toString('*'));
                decimalPresent = false;
                complexPresent = false;
            }

            else if (currentItem == '/') {
                if (!currentNum.isEmpty()) {
                    allElem.add(currentNum);
                    currentNum = "";
                }
                allElem.add(Character.toString(currentItem));
                decimalPresent = false;
                complexPresent = false;
            }

            else if (currentItem == '(') {
                if (!currentNum.isEmpty()) {
                    allElem.add(currentNum);
                    currentNum = "";
                }
                allElem.add(Character.toString(currentItem));
                decimalPresent = false;
                complexPresent = false;
            }

            else if (currentItem == ')') {
                if (!currentNum.isEmpty()) {
                    allElem.add(currentNum);
                    currentNum = "";
                 }
                allElem.add(Character.toString(currentItem));
                decimalPresent = false;
                complexPresent = false;
            }
            //Used to create decimal numbers. A check was added to stop an issue where the user
            //enter a number with two decimals causing issues. A boolean was set to create a gate where
            //another number would have to be made first before it could be called again
            else if (currentItem == '.') {
                if (decimalPresent == false){
                    currentNum = currentNum + '.';
                    decimalPresent = true;
                }
            }
            else if (currentItem == 'i'||currentItem == 'I'){
                currentItem = 'i';
                if (!currentNum.isEmpty() && !complexPresent){
                    if (lastItem == '.'){
                        allElem.add(currentNum + "0"+Character.toString(currentItem));
                        complexPresent = false;
                    }
                    else {
                        allElem.add(currentNum + Character.toString(currentItem));
                    }
                    currentNum = "";
                    complexPresent = false;
                }

                else if (currentNum.isEmpty() && !complexPresent){

                    allElem.add("1i");
                    complexPresent = false;

                }
                else {
                    throw new Error("Unexpected Imaginary");
                }
            }


            else {
                //Catch all for anything that isn't listed above due to it not being something
                //the calculator object could take

                throw new Error(currentItem + " is not supported by this tokenizer");
            }

        }
        //Finally adds the last number input to the arrayList
        if (!currentNum.isEmpty()) {
            allElem.add(currentNum);
        }

        return allElem;
    }

}
