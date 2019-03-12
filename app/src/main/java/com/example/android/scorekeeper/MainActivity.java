package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.scorekeeper.R;

public class MainActivity extends AppCompatActivity {
    public int count;
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    private CountDownTimer counttimer;
    private TextView time;
    private Button StartTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartTimer = (Button) findViewById(R.id.start_timer);
        time = (TextView) findViewById(R.id.timer);

        StartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                counttimer = new CountDownTimer(300000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        time.setText(String.valueOf(count));
                        count++;
                        if (count == 11) {
                            stopTimer();
                            win();
                        }
                    }
                    @Override
                    public void onFinish() {

                    }
                }.start();
            }
        });
    }


    public void stopTimer() {
        counttimer.cancel();
    }

    public void scoreThreeForA(View view) {
        if (count == 0) {
            display(0);
        } else {
            scoreTeamA = scoreTeamA + 3;
            display(scoreTeamA);
        }
    }

    public void scoreTwoForA(View view) {
        if (count == 0) {
            display(0);
        } else {
            scoreTeamA = scoreTeamA + 2;
            display(scoreTeamA);
        }
    }

    public void scoreFreeThrowForA(View view) {
        if (count == 0) {
            display(0);
        } else {
            scoreTeamA = scoreTeamA + 1;
            display(scoreTeamA);
        }
    }

    public void display(int number) {
        TextView countViewer = (TextView) findViewById(R.id.team_a_score);
        countViewer.setText("" + number);
    }

    public void scoreThreeForB(View view) {
        if (count == 0) {
            displays(0);
        } else {
            scoreTeamB = scoreTeamB + 3;
            displays(scoreTeamB);
        }
    }

    public void scoreTwoForB(View view) {
        if (count == 0) {
            displays(0);
        } else {
            scoreTeamB = scoreTeamB + 2;
            displays(scoreTeamB);
        }
    }

    public void scoreFreeThrowForB(View view) {
        if (count == 0) {
            displays(0);
        } else {
            scoreTeamB = scoreTeamB + 1;
            displays(scoreTeamB);
        }
    }

    public void displays(int number1) {
        TextView countViewer = (TextView) findViewById(R.id.team_b_score);
        countViewer.setText("" + number1);
    }

    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        display(0);
        displays(0);
        if (count != 0) {
            count=0;
            time.setText("0");
            counttimer.cancel();
        }
    }

    private void win() {
        if (scoreTeamA > scoreTeamB) {
            Toast.makeText(this, "Lakers won this match", Toast.LENGTH_SHORT).show();
        } else if (scoreTeamB > scoreTeamA) {
            Toast.makeText(this, "warriors won this match", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Match DRAW", Toast.LENGTH_SHORT).show();
        }
    }
}