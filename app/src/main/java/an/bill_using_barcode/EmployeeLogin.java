package an.bill_using_barcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeLogin extends AppCompatActivity {
    Button b1;
    String a,b,c,id;
    EditText UsernameEt, PasswordEt;
    MyDBHandler2 dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        b1=(Button)findViewById(R.id.register_button);
        UsernameEt = (EditText) findViewById(R.id.username_edtext);
        PasswordEt = (EditText) findViewById(R.id.passwd_edtext);
        dbHandler = new MyDBHandler2(this,null,null,1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EmployeeLogin.this,Employeesignup.class);
                startActivity(i);
            }
        });
    }

    public void OnLogin(View view)
    {
        a=UsernameEt.getText().toString();
        b=PasswordEt.getText().toString();
        c=dbHandler.accessDetails(a);
        id=dbHandler.accessId(a);
        if(b.equals(c)) {
            Bundle b=new Bundle();
            b.putString("e_id",id);
            Intent i = new Intent(this, EmployeeHome.class);
            i.putExtras(b);
            startActivity(i);
        }
        else {
            Toast.makeText(getApplicationContext(), "Password is incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
