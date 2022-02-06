package com.wimonsiri.assign03_02_6206021621147;

//วิมลศิริ คำแดงใส 6206021621147

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText midScore , finalScore , hwScore ;
    private Button btnCal;
    private TextView totalScore , grade ;

    private final String totalString  = "คะแนนรวม : ";
    private final String gradeString = "เกรดที่ได้ : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        midScore = (EditText) findViewById(R.id.midScore);
        finalScore = (EditText) findViewById(R.id.finalScore);
        hwScore = (EditText) findViewById(R.id.hwScore);

        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(this);

        totalScore = (TextView) findViewById(R.id.totalScore);
        grade = (TextView) findViewById(R.id.grade);

    }

    @Override
    public void onClick(View view){

        int convertmidInt , convertfinalInt , converthomeworklInt;

        if(midScore.getText().toString().equals("")) {
            Toast.makeText(this, "คุณยังไม่ได้กรอกคะแนน", Toast.LENGTH_SHORT).show();
            return;
        } else {
            convertmidInt = Integer.parseInt(midScore.getText().toString());
            if (convertmidInt > 30){
                Toast.makeText(this,"กรุณากรอกคะแนนกลางภาคไม่เกิน 30 คะแนน" , Toast.LENGTH_SHORT).show();
            }
        }
        if(finalScore.getText().toString().equals("")) {
            Toast.makeText(this, "คุณยังไม่ได้กรอกคะแนนสอบปลายภาค", Toast.LENGTH_SHORT).show();
            return;
        }else {
            convertfinalInt = Integer.parseInt(finalScore.getText().toString());
            if (convertfinalInt > 40){
                Toast.makeText(this,"กรุณากรอกคะแนนปลายภาคไม่เกิน 40 คะแนน" , Toast.LENGTH_SHORT).show();
            }
        }

        if(hwScore.getText().toString().equals("")) {
            Toast.makeText(this, "คุณยังไม่ได้กรอกคะแนนการบ้าน", Toast.LENGTH_SHORT).show();
            return;
        }else {
            converthomeworklInt = Integer.parseInt(hwScore.getText().toString());
            if (convertmidInt > 30){
                Toast.makeText(this,"กรุณากรอกคะแนนการบ้านไม่เกิน 30 คะแนน" , Toast.LENGTH_SHORT).show();
            }
        }
        totalGrade(convertmidInt , convertfinalInt , converthomeworklInt);
    }

    public void totalGrade(int midScore , int finalScore , int homworkScore ){
        int calGrade = midScore + finalScore + homworkScore;
        String sumGrade;
        totalScore.setText(totalString + calGrade);
        if (calGrade >= 80){
            sumGrade = "A";
        }
        else if (calGrade >= 75){
            sumGrade = "B+";
        }
        else if (calGrade >= 70){
            sumGrade = "B";
        }
        else if (calGrade >= 65){
            sumGrade = "C+";
        }
        else if (calGrade >= 60){
            sumGrade = "C";
        }
        else if (calGrade >= 55){
            sumGrade = "D+";
        } else if (calGrade >= 50){
            sumGrade = "D";
        }
        else sumGrade = "F" ;

        grade.setText(gradeString + sumGrade);

    }
}