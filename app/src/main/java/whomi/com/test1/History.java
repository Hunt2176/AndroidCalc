package whomi.com.test1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        ListView list = (ListView) findViewById(R.id.listViewin);
        TextView NoHistory = (TextView) findViewById(R.id.NoHistoryText);
        Button buttonClearHistory = (Button) findViewById(R.id.buttonClearH);
        buttonClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.history.clear();
                reload();

            }
        });


        String[] History = new String[Main2Activity.history.size()];
        int count = 0;
        for (HistoryItem i : Main2Activity.history){
            History[count] = i.getContent();
            count++;
        }

        if (!Main2Activity.history.isEmpty()){
            NoHistory.setVisibility(View.INVISIBLE);
            buttonClearHistory.setVisibility(View.VISIBLE);
        }
        else {
            NoHistory.setVisibility(View.VISIBLE);
            buttonClearHistory.setVisibility(View.INVISIBLE);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.items,History);


        list.setAdapter(adapter);
    }

    void reload(){
        SharedPreferences historyCheck = getSharedPreferences("HISTORY_COUNT",0);
        SharedPreferences.Editor editor = historyCheck.edit();

        editor.putInt("COUNT",0);
        editor.commit();

        Intent intent = new Intent(this,History.class);
        startActivity(intent);
        finish();
    }
}
