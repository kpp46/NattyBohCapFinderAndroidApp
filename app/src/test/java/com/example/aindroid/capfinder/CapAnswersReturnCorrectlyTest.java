package com.example.aindroid.capfinder;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CapAnswersReturnCorrectlyTest {

    MainActivity mainActivity = new MainActivity();

    //TODO:fix this test maybe?
//    @Test
//    public void capAnswerFor_24_ReturnsCorrectAnswer(){
//
//        mainActivity.CapAnswersHashmap();
//        String capAnswerString = mainActivity.getAnswerForCapNumberFromHashmap("24");
//        System.out.println("cap answer is: " + capAnswerString);
//
//
//
//    }

    private static final Map<String, String> map = new HashMap<String, String>();  // it should be static - whereever you define


    public void CapAnswersHashmap() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/test/resources/NattyBohAnswers.txt"));

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

    @Before
    public void doBeforeTest(){
        CapAnswersHashmap();
    }

    @Test
    public void capAnswerFor_24_ReturnsCorrectAnswer(){
        getAnswerForCapNumberFromHashmap("24");


    }
}
