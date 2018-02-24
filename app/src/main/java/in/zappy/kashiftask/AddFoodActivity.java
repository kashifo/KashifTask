package in.zappy.kashiftask;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddFoodActivity extends Activity {

    RadioGroup radioGroupSize, radioGroupVariety;
    Button btnAdd;
    String foodType, foodSize, foodVariety;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout);
        rootLayout.setBackgroundColor(Color.parseColor("#75000000"));
        radioGroupSize = (RadioGroup) findViewById(R.id.radioGroupSize);
        radioGroupVariety = (RadioGroup) findViewById(R.id.radioGroupVariety);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        foodType = getIntent().getExtras().getString("foodType");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFood();
            }
        });

    }

    void addFood(){

        int selectedRadioButtonIDSize = radioGroupSize.getCheckedRadioButtonId();

        // If nothing is selected from Radio Group, then it return -1
        if (selectedRadioButtonIDSize != -1) {

            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonIDSize);
            foodSize = selectedRadioButton.getText().toString();

        }
        else{
            Toast.makeText(this, "Please select size", Toast.LENGTH_SHORT).show();
        }


        int selectedRadioButtonIDVariety = radioGroupSize.getCheckedRadioButtonId();

        // If nothing is selected from Radio Group, then it return -1
        if (selectedRadioButtonIDVariety != -1) {

            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonIDVariety);
            foodVariety = selectedRadioButton.getText().toString();

        }
        else{
            Toast.makeText(this, "Please select variety", Toast.LENGTH_SHORT).show();
        }


        HomeActivity.addFood( foodType, foodSize, foodVariety );

        Toast.makeText(this, "Your selection added.", Toast.LENGTH_SHORT).show();
        finish();

    }

}
