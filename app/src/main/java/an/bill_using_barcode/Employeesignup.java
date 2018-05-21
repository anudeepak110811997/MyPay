package an.bill_using_barcode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Employeesignup extends AppCompatActivity {
    EditText name,grade,username,password,con_password,code;
    MyDBHandler2 dbHandler;
    String a,b,c,d,e,f;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeesignup);
        name=(EditText)findViewById(R.id.name_edtext);
        grade=(EditText)findViewById(R.id.grade_edtext);
        code=(EditText)findViewById(R.id.scode_edtext);
        username=(EditText)findViewById(R.id.username_edtext);
        password=(EditText)findViewById(R.id.passwd_edtext);
        con_password=(EditText)findViewById(R.id.conpasswd_edtext);

        dbHandler =new MyDBHandler2(this,null,null,1);
    }
    public void reglogin(View view)

    {
        a=name.getText().toString();
        b=grade.getText().toString();
        c=username.getText().toString();
        d=password.getText().toString();
        e=con_password.getText().toString();
        f=code.getText().toString();
        if(f.equals("007")) {
            dbHandler.addDetails(a, b, c, d);
            Intent i = new Intent(this, EmployeeLogin.class);
            Toast.makeText(getApplicationContext(), "Registration is successful", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
        else{
            Toast.makeText(getApplicationContext(), "Secret code is wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
