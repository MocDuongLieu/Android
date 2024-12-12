package aaa.exe.nhom_12_chuong_trinh_android.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import aaa.exe.nhom_12_chuong_trinh_android.R;
import aaa.exe.nhom_12_chuong_trinh_android.main.statistic.BMIIndexStatisticActivity;
import aaa.exe.nhom_12_chuong_trinh_android.main.statistic.CaloriesStatistic;
import aaa.exe.nhom_12_chuong_trinh_android.main.statistic.ExercisePlanStatistic;
import aaa.exe.nhom_12_chuong_trinh_android.main.statistic.HeartHealthStatisticActivity;
import aaa.exe.nhom_12_chuong_trinh_android.main.statistic.QualitySleepStatisticActivity;

public class HealthStatisticActivity extends AppCompatActivity {

    ImageButton btnHeart,btnBMI,btnSleep,btnCalories,btnExercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vtt_activity_health_statistic);
        mapping();
    }
    public void mapping(){
        btnHeart = findViewById(R.id.imgBtnHeartHealth);
        btnBMI = findViewById(R.id.imgBtnBMI);
        btnSleep = findViewById(R.id.imgBtnQualitySleep);
        btnCalories = findViewById(R.id.imgBtnCalories);
        btnExercise = findViewById(R.id.imgBtnExercisePlan);
        btnHeart.setOnClickListener(new doSomeThing());
        btnBMI.setOnClickListener(new doSomeThing());
        btnSleep.setOnClickListener(new doSomeThing());
        btnCalories.setOnClickListener(new doSomeThing());
        btnExercise.setOnClickListener(new doSomeThing());
    }
    public class doSomeThing implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if(id == R.id.imgBtnHeartHealth){
                Intent intent = new Intent(HealthStatisticActivity.this, HeartHealthStatisticActivity.class);
                startActivity(intent);
            }
            else if(id == R.id.imgBtnBMI){
                Intent intent = new Intent(HealthStatisticActivity.this, BMIIndexStatisticActivity.class);
                startActivity(intent);
            }
            else if(id == R.id.imgBtnQualitySleep){
                Intent intent = new Intent(HealthStatisticActivity.this, QualitySleepStatisticActivity.class);
                startActivity(intent);
            }
            else if(id == R.id.imgBtnCalories){
                Intent intent = new Intent(HealthStatisticActivity.this, CaloriesStatistic.class);
                startActivity(intent);
            }
            else if(id == R.id.imgBtnExercisePlan){
                Intent intent = new Intent(HealthStatisticActivity.this, ExercisePlanStatistic.class);
                startActivity(intent);
            }
        }
    }
    public void back(View v){
        finish();
    }
}