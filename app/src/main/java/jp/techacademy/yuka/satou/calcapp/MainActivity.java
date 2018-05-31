package jp.techacademy.yuka.satou.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            EditText edit1 = (EditText) findViewById(R.id.editText1);
            EditText edit2 = (EditText) findViewById(R.id.editText2);
            double value1 = Double.parseDouble(edit1.getText().toString());
            double value2 = Double.parseDouble(edit2.getText().toString());
            if (v.getId() == R.id.button1) {
                double result = value1 + value2;
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("VALUE", result);
                startActivity(intent);
            } else if (v.getId() == R.id.button2) {
                double result = value1 - value2;
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("VALUE", result);
                startActivity(intent);
            } else if (v.getId() == R.id.button3) {
                double result = value1 * value2;
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("VALUE", result);
                startActivity(intent);
            } else if (v.getId() == R.id.button4) {
                double result = value1 / value2;
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("VALUE", result);
                startActivity(intent);
            }
        }
        catch (Exception e) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("何か数値を入力してください！！！！");
        }

    }
}
