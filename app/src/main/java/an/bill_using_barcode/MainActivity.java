package an.bill_using_barcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void csSide(View v)
    {
        Intent i=new Intent(this,CustomerLogin.class);
        startActivity(i);
    }
    public void emSide(View v)
    {
        Intent i=new Intent(this,EmployeeLogin.class);
        startActivity(i);
    }
}
