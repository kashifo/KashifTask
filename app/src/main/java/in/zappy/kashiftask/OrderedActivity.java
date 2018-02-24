package in.zappy.kashiftask;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrderedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered);

        String data = getIntent().getExtras().getString("data");
        TextView tvOrders = (TextView) findViewById(R.id.tvOrders);
        tvOrders.setText( data );
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent( this, HomeActivity.class );
        startActivity( intent );
    }

}
