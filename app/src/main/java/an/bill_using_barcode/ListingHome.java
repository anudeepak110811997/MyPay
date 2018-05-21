package an.bill_using_barcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

public class ListingHome extends Activity implements
        AdapterView.OnItemSelectedListener{
    String[] country = {"1", "2", "3", "4", "5","6"};
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
    int n1=0,n2=0,n3=0,n4=0,n5=0,n6=0,n7=0,n8=0,n9=0,n10=0,n11=0,n12=0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_home);



        Spinner spin1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spin3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spin4 = (Spinner) findViewById(R.id.spinner4);
        Spinner spin5 = (Spinner) findViewById(R.id.spinner5);
        Spinner spin6 = (Spinner) findViewById(R.id.spinner6);
        Spinner spin7 = (Spinner) findViewById(R.id.spinner7);
        Spinner spin8 = (Spinner) findViewById(R.id.spinner8);
        Spinner spin9 = (Spinner) findViewById(R.id.spinner9);
        Spinner spin10 = (Spinner) findViewById(R.id.spinner10);
        Spinner spin11 = (Spinner) findViewById(R.id.spinner11);
        Spinner spin12 = (Spinner) findViewById(R.id.spinner12);

        c1=(CheckBox)findViewById(R.id.simpleCheckBox1);
        c2=(CheckBox)findViewById(R.id.simpleCheckBox2);
        c3=(CheckBox)findViewById(R.id.simpleCheckBox3);
        c4=(CheckBox)findViewById(R.id.simpleCheckBox4);
        c5=(CheckBox)findViewById(R.id.simpleCheckBox5);
        c6=(CheckBox)findViewById(R.id.simpleCheckBox6);
        c7=(CheckBox)findViewById(R.id.simpleCheckBox7);
        c8=(CheckBox)findViewById(R.id.simpleCheckBox8);
        c9=(CheckBox)findViewById(R.id.simpleCheckBox9);
        c10=(CheckBox)findViewById(R.id.simpleCheckBox10);
        c11=(CheckBox)findViewById(R.id.simpleCheckBox11);
        c12=(CheckBox)findViewById(R.id.simpleCheckBox12);
        //spin1.setOnItemSelectedListener(this);

        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin1.setAdapter(aa1);

        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin3.setAdapter(aa3);

        ArrayAdapter aa4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin4.setAdapter(aa4);

        ArrayAdapter aa5 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin5.setAdapter(aa5);

        ArrayAdapter aa6 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin6.setAdapter(aa6);

        ArrayAdapter aa7 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin7.setAdapter(aa7);

        ArrayAdapter aa8 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin8.setAdapter(aa8);

        ArrayAdapter aa9 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin9.setAdapter(aa9);

        ArrayAdapter aa10 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin10.setAdapter(aa10);

        ArrayAdapter aa11 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin11.setAdapter(aa11);

        ArrayAdapter aa12 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin12.setAdapter(aa12);

       /* AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 15);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);*/


    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //Toast.makeText(getApplicationContext(),country[position] ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public void create(View v){
        if(c1.isChecked()) {
            n1=1;
        }
        if(c2.isChecked()) {
            n2=1;
        }
        if(c3.isChecked()) {
            n3=1;
        }
        if(c4.isChecked()) {
            n4=1;
        }
        if(c5.isChecked()) {
            n5=1;
        }
        if(c6.isChecked()) {
            n6=1;
        }
        if(c7.isChecked()) {
            n7=1;
        }
        if(c8.isChecked()) {
            n8=1;
        }
        if(c9.isChecked()) {
            n9=1;
        }
        if(c10.isChecked()) {
            n10=1;
        }
        if(c11.isChecked()) {
            n11=1;
        }
        if(c12.isChecked()) {
            n12=1;
        }
        Bundle b = new Bundle();
        b.putInt("n1",n1);
        b.putInt("n2",n2);
        b.putInt("n3",n3);
        b.putInt("n4",n4);
        b.putInt("n5",n5);
        b.putInt("n6",n6);
        b.putInt("n7",n7);
        b.putInt("n8",n8);
        b.putInt("n9",n9);
        b.putInt("n10",n10);
        b.putInt("n11",n11);
        b.putInt("n12",n12);
        Intent in = new Intent(this,ShopMap.class);
        in.putExtras(b);
        startActivity(in);
    }
}
