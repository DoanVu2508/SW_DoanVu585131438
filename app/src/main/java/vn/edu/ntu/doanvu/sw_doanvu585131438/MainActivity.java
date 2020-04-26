package vn.edu.ntu.doanvu.sw_doanvu585131438;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtDate, edtOthers;
    RadioGroup rdGGioiTinh, rdGSoThich;
    Button btnOK;
    CheckBox cb1,cb2,cb3,cb4,cb5;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        addViews();
        addEvents();
    }
    private void addViews(){
        edtName = findViewById(R.id.edtName);
        edtDate = findViewById(R.id.edtDate);
        edtOthers = findViewById(R.id.edtOthers);
        rdGGioiTinh = findViewById(R.id.rdGGioiTinh);
        rdGSoThich = findViewById(R.id.rdGSoThich);
        cb1 = findViewById(R.id.checkbox1);
        cb2 = findViewById(R.id.checkbox2);
        cb3 = findViewById(R.id.checkbox3);
        cb4 = findViewById(R.id.checkbox4);
        cb5 = findViewById(R.id.checkbox5);
        btnOK = findViewById(R.id.btnOK);
    }
    private void addEvents(){
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }
    private void sendMessage(){
        String name = edtName.getText().toString().trim();
        String date = edtDate.getText().toString().trim();
        String others = edtOthers.getText().toString().trim();
        String kq = null;
        if(name.length()>0)
//            Toast.makeText(context,"Tên : "+name,Toast.LENGTH_SHORT).show();
            kq= "Tên : "+name +" \n ";
        if (date.length()>0)
//            Toast.makeText(context,"Ngày sinh : "+birth,Toast.LENGTH_SHORT).show();
            kq += "Ngày sinh : "+date+"\n";
        switch (rdGGioiTinh.getCheckedRadioButtonId()){
            case R.id.rdbNam:
                kq += "Giới tính : Nam \n Sở thích : ";
                break;
            case R.id.rdbNu:
                kq += "Giới tính : Nữ \n Sở thích : ";
                break;
        }
        if(cb1.isChecked())
            kq +=cb1.getText()+", ";
        if(cb2.isChecked())
            kq +=cb2.getText()+", ";
        if(cb3.isChecked())
            kq +=cb3.getText()+", ";
        if(cb4.isChecked())
            kq +=cb4.getText()+", ";
        if(cb5.isChecked())
            kq +=cb5.getText()+", ";
        if(edtOthers.length()>0)
            kq += edtOthers.getText() ;
        Toast.makeText(context,kq,Toast.LENGTH_SHORT).show();
    }
}
