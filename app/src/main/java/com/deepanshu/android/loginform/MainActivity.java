package com.deepanshu.android.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView img1, img2, img3, img4, img5, img6;
    private EditText name, email, pass, description;
    private Spinner spinner;
    private RadioButton rdb1, rdb2;
    private Button login;
    RadioGroup radio;
    private ArrayList<String> countries;
    private String country = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initWidgets();
//    }
//        private void initWidgets() {
        img1 = (ImageView) findViewById(R.id.back);
        img2 = (ImageView) findViewById(R.id.setting);
        img3 = (ImageView) findViewById(R.id.img1);
        img4 = (ImageView) findViewById(R.id.img2);
        img5 = (ImageView) findViewById(R.id.img3);
        img6 = (ImageView) findViewById(R.id.img4);

        name = (EditText) findViewById(R.id.edt1);
        email = (EditText) findViewById(R.id.edt2);
        pass = (EditText) findViewById(R.id.edt3);
        description = (EditText) findViewById(R.id.edt4);


        spinner = (Spinner) findViewById(R.id.spinner);
        rdb1 = (RadioButton) findViewById(R.id.radio1);
        rdb2 = (RadioButton) findViewById(R.id.radio2);

        radio = (RadioGroup) findViewById(R.id.radio);

        login = (Button) findViewById(R.id.login);
        String d = name.getText().toString();


        countries = new ArrayList<>();
        countries.add("INDIA");
        countries.add("u.k");
        countries.add("america");
        countries.add("australia");

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, countries);
        spinner.setAdapter(ad);
        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         a();
                                     }
                                     private void a(){
                                         String name1 = name.getText().toString();
                                         String email1 = name.getText().toString();
                                         String password = name.getText().toString();
                                         Toast.makeText(MainActivity.this, "" + name1 + " \n" + email + "\n" + password, Toast.LENGTH_SHORT).show();

                                         String gender = "";
                                         int checkbtn = radio.getCheckedRadioButtonId();
                                         switch (checkbtn) {
                                             case R.id.radio1:
                                                 gender = "Male";
                                                 break;
                                             case R.id.radio2:
                                                 gender = "female";
                                                 break;
                                             default:
                                                 break;

                                         }

                                         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                                               @Override
                                                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                                   country=countries.get(position);
                                                                               }

                                                                               @Override
                                                                               public void onNothingSelected(AdapterView<?> parent) {
                                                                                    country="no country selected";

                                                                               }
                                                                           }
                                         );

                                                 String s = "Name:" + name1 + "\t email:" + email1 + "\t pass:" + password + "\n" + "gender" + gender + "country:" + country;
                                            Toast.makeText(MainActivity.this,""+s,Toast.LENGTH_LONG).show();
                                            Log.d("deep",s);

                                     }
                                 }


        );



            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "back", Toast.LENGTH_LONG).show();
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_LONG).show();
                }
            });

        }

    }


