package an.bill_using_barcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;

public class ShopMap extends AppCompatActivity {
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12;
    int n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_map);
        r1=(RadioButton)findViewById(R.id.radioButton3);
        r2=(RadioButton)findViewById(R.id.radioButton4);
        r3=(RadioButton)findViewById(R.id.radioButton5);
        r4=(RadioButton)findViewById(R.id.radioButton6);
        r5=(RadioButton)findViewById(R.id.radioButton7);
        r6=(RadioButton)findViewById(R.id.radioButton8);
        r7=(RadioButton)findViewById(R.id.radioButton9);
        r8=(RadioButton)findViewById(R.id.radioButton10);
        r9=(RadioButton)findViewById(R.id.radioButton11);
        r10=(RadioButton)findViewById(R.id.radioButton12);
        r11=(RadioButton)findViewById(R.id.radioButton13);
        r12=(RadioButton)findViewById(R.id.radioButton14);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        n1= b.getInt("n1");
        n2= b.getInt("n2");
        n3= b.getInt("n3");
        n4= b.getInt("n4");
        n5= b.getInt("n5");
        n6= b.getInt("n6");
        n7= b.getInt("n7");
        n8= b.getInt("n8");
        n9= b.getInt("n9");
        n10= b.getInt("n10");
        n11= b.getInt("n11");
        n12= b.getInt("n12");
        if(n1==1) {
            r1.setChecked(true);
        }if(n1==1) {
            r1.setChecked(true);
        }
        if(n1==2) {
            r2.setChecked(true);
        }
        if(n3==1) {
            r3.setChecked(true);
        }
        if(n4==1) {
            r4.setChecked(true);
        }
        if(n5==1) {
            r5.setChecked(true);
        }
        if(n6==1) {
            r6.setChecked(true);
        }
        if(n7==1) {
            r7.setChecked(true);
        }
        if(n8==1) {
            r8.setChecked(true);
        }
        if(n9==1) {
            r9.setChecked(true);
        }
        if(n10==1) {
            r10.setChecked(true);
        }
        if(n11==1) {
            r11.setChecked(true);
        }
        if(n12==1) {
            r12.setChecked(true);
        }
    }
}
