package whomi.com.test1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private String text = "0";
    static public TextView OnFlyView;
    static boolean lastCharDigit;
    private TextView textView;
    private Button buttonBackspace;
    private Button buttonEqual;
    static ArrayList<HistoryItem> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Intent History = new Intent(this, History.class);

        this.history = new ArrayList<>();

        getHistory();
        Button buttonDecimal = (Button) findViewById(R.id.buttonDecimal);
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttonClear = (Button) findViewById(R.id.buttonClearH);
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        Button buttonSub = (Button) findViewById(R.id.buttonSub);
        Button buttonMul = (Button) findViewById(R.id.buttonMul);
        Button buttonDiv = (Button) findViewById(R.id.buttonDiv);
        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
        Button buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        Button buttonHistory = (Button) findViewById(R.id.buttonHistory);
        final TextView textView = (TextView) findViewById(R.id.testfield);
        this.textView = textView;

        this.buttonEqual = buttonEqual;
        this.buttonBackspace = buttonBackspace;
        this.buttonBackspace.setEnabled(false);

        this.textView.setCursorVisible(false);
        this.textView.setInputType(InputType.TYPE_NULL);
        this.textView.setTextIsSelectable(true);

        TextView OnFlyView = (TextView) findViewById(R.id.OnFly);
        this.OnFlyView = OnFlyView;
        textView.setText(this.text);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("9");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {UpdateView("CLEAR");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("+");
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("-");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("x");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateView("/");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {UpdateView("EQUALS");
            }
        });
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {UpdateView("BACKSPACE");
            }
        });
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {UpdateView(".");
            }
        });
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(History);
            }
        });
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                UpdateTextView(textView.getText().toString());
//                UpdateView("");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });{

        }


        UpdateView("");
    }

    void UpdateView(String append){

        if (!append.isEmpty()) {
            ChangeOutput(append);
        }
        if (this.text.length()>1) {
            if (Character.isDigit(this.text.charAt(this.text.length() - 1))) {
                this.lastCharDigit = true;
            } else {
                this.lastCharDigit = false;
            }
        }

        if (this.text.equals("0")){
            this.buttonBackspace.setEnabled(false);
        }
        else{
            this.buttonBackspace.setEnabled(true);
        }


        if (this.lastCharDigit){
            this.OnFlyView.setText(Calculate().getNumber()+ "");
            this.buttonEqual.setEnabled(true);
        }
        if (this.text.equals("0")){
            this.buttonEqual.setEnabled(false);
        }
        if (!lastCharDigit){
            this.buttonEqual.setEnabled(false);
        }

    }


    void ChangeOutput(String append){
        if (append.equals("CLEAR")){
            UpdateTextView("0");
            return;
        }
        if (append.equals("BACKSPACE") && GetTextView().length() > 1){

            String workingText = this.text;

            workingText = workingText.substring(0,this.text.length()-1);
            UpdateTextView(workingText);


            return;
        }
        else if (append.equals("BACKSPACE") && GetTextView().length() == 1){
            UpdateTextView("0");
            return;
        }



        if (append.equals("EQUALS") && getLastCharStatus()){
            Double result = Calculate().getNumber();
            AddToHistory(new HistoryItem(GetTextView(),result),false);
            UpdateTextView(result+"");
            return;
        }
        if (GetTextView().length()==15){
            return;
        }

        if (append.equals(".") && GetTextView().equals("0")){
            UpdateTextView("0.");
            return;
        }

        if (!GetTextView().equals("0")) {
            UpdateTextView(GetTextView() + append);
        }
        else {
            UpdateTextView(append);
        }
    }


    Number Calculate(){
        Tokenizer tokenizer = new Tokenizer();
        Calculator calculator = new Calculator();
        ArrayList<String> elems;
        ArrayList<Number> numbers = new ArrayList<>();

        elems = tokenizer.splitString(this.text);

        for (String i: elems){
            numbers.add(new Number(i));
        }

        numbers = calculator.Calculate(numbers);
        System.out.println(numbers.get(0).getNumber());
        return numbers.get(0);
    }




    ArrayList<HistoryItem> getResults(){
        return history;
    }

    void UpdateTextView(String newText){
        this.text = newText;
        this.textView.setText(newText);
    }

    String GetTextView(){
        return this.text;
    }

    boolean getLastCharStatus(){
        return this.lastCharDigit;
    }

    void AddToHistory(HistoryItem NewHistoryItem,boolean fromMemory){
        this.history.add(0,NewHistoryItem);
        if (!fromMemory){
            storeHistory(NewHistoryItem);
        }
    }

    void storeHistory(HistoryItem history){

        SharedPreferences historyCheck = getSharedPreferences("HISTORY_COUNT",0);
        SharedPreferences historySet = getSharedPreferences("HISTORY_STORE",0);

        int currentCount = historyCheck.getInt("COUNT",0);

        currentCount += 1;
        SharedPreferences.Editor editor = historySet.edit();
        SharedPreferences.Editor countEditor = historyCheck.edit();

        editor.putString(currentCount+"",history.getContent());
        editor.apply();


        countEditor.putInt("COUNT",currentCount);
        countEditor.apply();




    }

    void getHistory(){

        SharedPreferences historyCheck = getSharedPreferences("HISTORY_COUNT",0);
        SharedPreferences historySet = getSharedPreferences("HISTORY_STORE",0);

        int availableCount = historyCheck.getInt("COUNT",-1);
        if (availableCount == -1){
            return;
        }

        for (int i = 0; i <= availableCount;i++){

            String newEQ = historySet.getString(i+"","???");
            if (newEQ.equals("???")){
                continue;
            }
            AddToHistory(new HistoryItem(newEQ),true);
        }

    }


}
