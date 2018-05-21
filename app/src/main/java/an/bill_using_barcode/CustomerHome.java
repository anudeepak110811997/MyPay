package an.bill_using_barcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
    }

    public void listing(View v)
    {
        Intent i= new Intent(this,ListingHome.class);
        startActivity(i);
    }
    public void billing(View v)
    {
        Intent i= new Intent(this,BillingHome.class);
        startActivity(i);
    }
}
