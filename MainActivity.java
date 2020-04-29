package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    private static final String TAG = "Whack-A-Mole";
    private Button leftBtn;
    private Button midBtn;
    private Button rightBtn;
    private TextView txtScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftBtn = (Button) findViewById(R.id.btnLeft);
        midBtn = (Button) findViewById(R.id.btnCenter);
        rightBtn = (Button) findViewById(R.id.btnRight);

        leftBtn.setOnClickListener(this);
        midBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);

        txtScore = (TextView) findViewById(R.id.txtScore);

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();

        setNewMole();

        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);

        List<Button> btnList = new ArrayList<Button>();
        btnList.add(leftBtn);
        btnList.add(midBtn);
        btnList.add(rightBtn);

        for (int i = 0;i<btnList.size();i++){
            btnList.get(i).setText("O");
        }
        //Reset

        btnList.get(randomLocation).setText("*");
    }

    int iScore = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLeft:
                Log.v(TAG,"Button Left Clicked!");
                calculateScore(leftBtn);
                break;

            case R.id.btnCenter:
                Log.v(TAG,"Button Middle Clicked!");
                calculateScore(midBtn);
                break;

            case R.id.btnRight:
                Log.v(TAG,"Button Right Clicked!");
                calculateScore(rightBtn);
                break;

        }
        txtScore.setText(Integer.toString(iScore));
        setNewMole();
    }

    public void calculateScore(Button button){
        if (button.getText() == "*")
        {
            iScore += 1;
            Log.v(TAG,"Hit, score added!");
        }
        else {
            iScore -= 1;
            Log.v(TAG,"Missed, score deducted");
        }
    }
}
