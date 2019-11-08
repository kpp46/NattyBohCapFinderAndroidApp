package com.example.aindroid.nattybohcapfinder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private static final Map<String, String> map = new HashMap<String, String>();  // it should be static - whereever you define
    Button mButton;
    EditText mEdit;
    TextView answerText;
    TextView captionAnswerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CapAnswersHashmap();

        mButton = findViewById(R.id.button_submit);
        mEdit = findViewById(R.id.text_capNumber);
        answerText = findViewById(R.id.test_capAnswer);
        captionAnswerText = findViewById(R.id.text_yourAnswerIs);

        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.v("edit text: ", mEdit.getText().toString());
                        String answer = getAnswerForCapNumberFromHashmap(mEdit.getText().toString());
                        Log.v("your answer is ", answer);
                        captionAnswerText.setText("the answer to cap " + mEdit.getText().toString() + " is:");
                        answerText.setText(answer);
                    }
                }
        );

    }


    public void CapAnswersHashmap() {
        Log.v("capanswershashmap", "i got here");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("NattyBohAnswers.txt")));


            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("=")) {
                    String[] strings = line.split("=");
                    map.put(strings[0], strings[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAnswerForCapNumberFromHashmap(String key) {
        return map.get(key);
    }


}
