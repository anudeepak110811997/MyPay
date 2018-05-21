package an.bill_using_barcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeHome extends AppCompatActivity {
    MyDBHandler1 dbHandler;
    EditText e1,e2,e3,e4;
    String a1,b,c,d;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);
        dbHandler =new MyDBHandler1(this,null,null,1);
        e1=(EditText)findViewById(R.id.name_edtext);
        e2=(EditText)findViewById(R.id.grade_edtext);
        e3=(EditText)findViewById(R.id.username_edtext);
        e4=(EditText)findViewById(R.id.conpasswd_edtext);



    }
    public void add(View v)
    {
        a1=e1.getText().toString();
        b=e2.getText().toString();
        c=e3.getText().toString();
        d=e4.getText().toString();
        n=Integer.parseInt(a1);
        dbHandler.addDetails(n,b,c,d);
        Toast.makeText(getApplicationContext(),"Items added",Toast.LENGTH_SHORT).show();
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
    }
}
