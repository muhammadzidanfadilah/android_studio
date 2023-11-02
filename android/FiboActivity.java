package com.example.latihanapp4;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FiboActivity extends AppCompatActivity {
    private Context context;
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }


    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            int fib1 = 0;
            int fib2 = 1;
            int result = 0;

            for(int i = 2; i<= n; i++){
                result= fib1+fib2;
                fib1 = fib2;
                fib2 =result;
            }
            return result;
        }
    }
    public void showToast(View view){
        String myString = "Hallo Toast";
        Toast toast = Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG);
        toast.show();
    }

    public void countUp(View view){
//        Hitung nilai saat ini
        int fibonacciValue = fibonacci(mCount);

//        Tambah nilai ke text
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(fibonacciValue));
//            ubah warna text
            if (fibonacciValue %2 == 0){
                mShowCount.setTextColor(getResources().getColor(R.color.black));
            }else{
                mShowCount.setTextColor(getResources().getColor(R.color.blue));
            }
        }
        mCount++;
    }
    public void resetCount(View view) {
        mCount = 0;
        mShowCount.setText("0");
        mShowCount.setTextColor(getResources().getColor(R.color.black));
    }
}