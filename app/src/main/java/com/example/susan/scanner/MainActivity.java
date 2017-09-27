package com.example.susan.scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final int EDIT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView scanResult = (TextView)findViewById(R.id.textView3);
        scanResult.setText("");

        Button startBtn = (Button)findViewById(R.id.scanner);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ScanActivity.class);
                startActivityForResult(intent, EDIT);
            }
        });
    }

    @Override
    public void onStart()
    {
        super.onStart();




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case EDIT:
                if(resultCode == RESULT_OK) {
                    TextView scanResult = (TextView)findViewById(R.id.textView3);
                    Bundle scanBundle = data.getExtras();
                    String setText = scanBundle.getString("result") + "\n";
                    scanResult.append(setText);
                }
        }
    }

}
