package com.example.testjava2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText firstWord = findViewById(R.id.first_word);
        final EditText secondWord = findViewById(R.id.second_word);
        final EditText lengthResult = findViewById(R.id.lengthResult);
        final EditText reverseResult = findViewById(R.id.reversedResult);
        final EditText commonLettersResult = findViewById(R.id.commonLettersResult);

             Button lengthBtn = findViewById(R.id.lengthBtn);
             Button reversedBtn = findViewById(R.id.reversedBtn);
             Button commonLettersBtn = findViewById(R.id.commonLettersBtn);

             // calculating length of both words
                lengthBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String firstWordStr = firstWord.getText().toString();
                        String secondWordStr = secondWord.getText().toString();

                        int l = firstWordStr.length() + secondWordStr.length();
                        String s = String.valueOf(l);
                        lengthResult.setText(s);


                    }
        });

        // Reversing words
        reversedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWordStr = firstWord.getText().toString();
                String secondWordStr = secondWord.getText().toString();
                String w1 = "" ;
                String w2 = "";
                String reversed;

                for(int i = firstWordStr.length() - 1; i >= 0; i--){
                    w1 = w1 + firstWordStr.charAt(i);
                }

                for(int i = secondWordStr.length() - 1; i >= 0; i--){
                    w2 = w2 + secondWordStr.charAt(i);
                }
                 reversed = w1 + w2;
                 reverseResult.setText(reversed);
            }


        });

      // calculating common letters
        commonLettersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWordStr = firstWord.getText().toString();
                String secondWordStr = secondWord.getText().toString();

                 /*    Array to save the common letters  */
                  String [] commonLetters = new String[firstWordStr.length()];
                 int counter = 0;
                 int tabIndex = 0;

                /*    Comparing both words to find the common letters  */
                for (int i = 0; i< firstWordStr.length();i++) {

                        for (int j = 0; j < secondWordStr.length(); j++){

                            /*   checking if letters are common then we have to save them in  commonLetters array */
                            if (firstWordStr.charAt(i) == secondWordStr.charAt(j)) {
                                commonLetters[tabIndex] = String.valueOf(firstWordStr.charAt(i));
                                tabIndex++;
                                    }
                                }
                            }
                /* removing all the repeated common letters in commonLetters array */
                int p= 0;
                for (int i = 0; i < tabIndex-1; i++ ){
                    for (int j = i+1;  j < tabIndex; j++){

                        if(commonLetters[i] == commonLetters[j] ){

                            commonLetters[j] = "/";

                        }
                        System.out.println("commonLetters[" + j +"]" + commonLetters[j]);

                    }
                }

                // counting unique common letters
                int b = 0;
                while (b < tabIndex && commonLetters[b] != "/"){
                        b++;
                        counter++;
                }
                String co = String.valueOf(counter);
                commonLettersResult.setText(co);


            }
        });

    }
}