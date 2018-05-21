package an.bill_using_barcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Customersignup extends AppCompatActivity {
    EditText name,size,username,password,con_password;
    MyDBHandler dbHandler;
    String a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customersignup);
        name=(EditText)findViewById(R.id.name_edtext);
        size=(EditText)findViewById(R.id.grade_edtext);
        username=(EditText)findViewById(R.id.username_edtext);
        password=(EditText)findViewById(R.id.passwd_edtext);
        con_password=(EditText)findViewById(R.id.conpasswd_edtext);


        dbHandler =new MyDBHandler(this,null,null,1);
    }
    public void reglogin(View view)

    {
        a=name.getText().toString();
        b=size.getText().toString();
        c=username.getText().toString();
        d=password.getText().toString();
        e=con_password.getText().toString();
        dbHandler.addDetails(a,b,c,d);
        Intent i=new Intent(this,CustomerLogin.class);
        Toast.makeText(getApplicationContext(), "Registration is successful", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }


}
