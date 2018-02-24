package in.zappy.kashiftask;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<String> foodList;
    RecyclerView rvFoods;
    static JSONArray foods;
    static TextView tvFoods;
    Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        foods = new JSONArray();
        foodList = new ArrayList<>();
        foodList.add( "Pizza" );
        foodList.add( "Burger" );
        foodList.add( "Pasta" );

        tvFoods = (TextView) findViewById(R.id.tvProducts);
        rvFoods = (RecyclerView) findViewById(R.id.recyclerView);
        rvFoods.setHasFixedSize(true);
        rvFoods.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(this, foodList);
        rvFoods.setAdapter(myAdapter);

        btnCheckout = (Button) findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkout();
            }
        });


    }


    void checkout(){

        if( foods.length() > 0 ) {

            Intent intent = new Intent(this, AddressActivity.class);
            intent.putExtra("data", foods.toString());
            startActivity(intent);

        }else{
            Toast.makeText(this, "No items added", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed(){
        ActivityCompat.finishAffinity(this);
    }


    public static void addFood(String type, String size, String variety){

        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put( "FoodType", type );
            jsonObject.put( "FoodSize", size );
            jsonObject.put( "FoodVariety", variety );
            foods.put( jsonObject );
            tvFoods.setText( foods.length() + " Item(s) Added" );

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
