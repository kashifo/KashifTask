package in.zappy.kashiftask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPhone;
    EditText etPassword;
    Button btnLogin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etPhone = (EditText) findViewById(R.id.etPhone);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
        
    }
    
    void checkLogin(){
        
        String phone = etPhone.getText().toString();
        String password = etPassword.getText().toString();
        
        if( phone != null && !phone.isEmpty() ){
            
            if( password!=null && !password.isEmpty() ){

                if( phone.length() > 9 ) {

                    if (phone.equals("1234567890") && password.equals("qwe")) {

                        Intent intent = new Intent( this, HomeActivity.class );
                        startActivity( intent );

                    } else {
                        Toast.makeText(this, "Invalid login", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this, "Pleae check your phone number", Toast.LENGTH_LONG).show();
                }
                
            }else{
                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            }
            
            
        }else{
            Toast.makeText(this, "Please enter phone number", Toast.LENGTH_LONG).show();
        }
        
    }


    
}
