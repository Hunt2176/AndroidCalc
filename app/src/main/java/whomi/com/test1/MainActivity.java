package whomi.com.test1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getHasRun()){
            goToSecondActivity();
        }
        Button button = (Button) findViewById(R.id.button);
        Button buttonSecret = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setHasRun();
                goToSecondActivity();
            }
        });
        buttonSecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }


    public void goToSecondActivity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }

    private void setHasRun(){
        SharedPreferences prefs = getSharedPreferences("hasRun",0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("hasRun",true);
        editor.apply();
    }
    private boolean getHasRun(){
        SharedPreferences prefs = getSharedPreferences("hasRun",0);
        return prefs.getBoolean("hasRun",false);
    }
}
