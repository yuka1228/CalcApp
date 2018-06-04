package jp.techacademy.yuka.satou.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
            //Snackbar.make(v, "数値を入力してください！！", Snackbar.LENGTH_INDEFINITE).show();

            showAlertDialog();
        }

    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //alertDialogBuilder.setTitle("title");
        alertDialogBuilder.setMessage("数値を入力してください！！");

//        alertDialogBuilder.setPositiveButton("OK",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.d("javatest", "ok");
//                    }
//                }
//        );

        alertDialogBuilder.setPositiveButton("OK", null);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
