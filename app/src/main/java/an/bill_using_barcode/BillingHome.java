package an.bill_using_barcode;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class BillingHome extends AppCompatActivity {
    LinearLayout parentLinearLayout;
    TextView barcodeResult;
    MyDBHandler1 dbHandler;
    int m=0;
    int k=1;
    int b=0;
    String y1,m1,d1;
    int y,mm,d;
    //public static final String date = "yyyy-MM-dd HH:mm:ss";


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_home);
        dbHandler =new MyDBHandler1(this,null,null,1);
        barcodeResult=(TextView)findViewById(R.id.barcode_result);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        Calendar calendar = Calendar.getInstance();
        y=calendar.get(Calendar.YEAR);
        mm=calendar.get(Calendar.MONTH);
        mm++;
        d=calendar.get(Calendar.DATE);
        y1=Integer.toString(y);
        d1=Integer.toString(d);
        m1=Integer.toString(mm);
    }
    /*@RequiresApi(api = Build.VERSION_CODES.N)
    public static String now() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(date);
        return dateFormat.format(calendar.getTime());
    }*/
    /*public void scanBarcode(View v){
        Intent intent=new Intent(this,barcode_scanner.class);
        startActivityForResult(intent,0);
    }*/
    /*public void hello(View v){
        dbHandler.addDetails("rice","70","1200");
    }*/
    //@RequiresApi(api = Build.VERSION_CODES.N)
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addToBill(View view)
    {
        final String s,n,p,ed,edd1,edm1,edy1;
        s=barcodeResult.getText().toString();
        n=dbHandler.accessName(s);
        p=dbHandler.accessPrice(s);
        ed=dbHandler.accessDate(s);

       String namepass[] = ed.split(":");
        edd1 = namepass[0];
        edm1 = namepass[1];
        edy1 = namepass[2];

        int edd=Integer.parseInt(edd1);
        int edm=Integer.parseInt(edm1);
        int edy=Integer.parseInt(edy1);


        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.set(y, mm,d);
        cal2.set(edd, edm, edy);

        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();

        long diff = milis2 - milis1;

        long diffSeconds = diff / 1000;
        //Toast.makeText(getApplicationContext(),y1,Toast.LENGTH_LONG).show();
        Button b1=(Button)findViewById(R.id.name_edtext);
        b1.setText(n);
        final Button b2=(Button)findViewById(R.id.rate);
        b2.setText(p);
        Button b3=(Button)findViewById(R.id.s_no);
        b3.setText(Integer.toString(k));
        k++;
        final Button b4=(Button)findViewById(R.id.price);

        //Toast.makeText(getApplicationContext(),d1+" "+m1+" "+y1,Toast.LENGTH_LONG).show();


        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.SECOND, (int) diffSeconds);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i,j;
                EditText e1=(EditText)findViewById(R.id.quantity);
                e1.setId(m+1);
                String d=e1.getText().toString();
                i=Integer.parseInt(d);
                j=Integer.parseInt(p);
                b4.setText(Integer.toString(i*j));
                b4.setId(m+1);
                b=b+i*j;
                Toast.makeText(getApplicationContext(),"The total bill is "+b,Toast.LENGTH_LONG).show();
            }
        });

        b1.setId(m+1);
        b2.setId(m+1);
        b3.setId(m+1);
    }
    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
        Intent intent=new Intent(this,barcode_scanner.class);
        startActivityForResult(intent,0);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra("barcode");
                    barcodeResult.setText(  barcode.displayValue);
                } else {
                    barcodeResult.setText("No barcode found");
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
    }


}
