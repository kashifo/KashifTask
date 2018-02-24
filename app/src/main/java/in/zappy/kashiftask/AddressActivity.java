package in.zappy.kashiftask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    String data;
    EditText etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        data = getIntent().getExtras().getString("data");
    }

    public void Order(View v){

        Intent intent = new Intent( this, OrderedActivity.class );
        intent.putExtra( "data", data );
        startActivity( intent );
    }

}
