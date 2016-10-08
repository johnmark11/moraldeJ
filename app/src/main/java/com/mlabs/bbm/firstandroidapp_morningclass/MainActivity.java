package com.mlabs.bbm.firstandroidapp_morningclass;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DataBaseAdapter sqlDB = new DataBaseAdapter(getApplicationContext());
        Button btn;
        final EditText emailAdd,passWord,Show;
 //       final Button  btnMenu = (Button) findViewById(R.id.button2);
        final Button btn3 = (Button) findViewById(R.id.buttonRegister);

        Show = (EditText)findViewById(R.id.editTextShow);
        emailAdd=(EditText)findViewById(R.id.editTextEmail);
        passWord=(EditText)findViewById(R.id.editTextPassword);
        btn = (Button)findViewById(R.id.button);
        if (btn!=null){
            btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public  void onClick(View v){

                    if (sqlDB.validateUserFromEmail(emailAdd.getText().toString(), passWord.getText().toString()) == true
                            || sqlDB.validateUserFromUName(emailAdd.getText().toString(), passWord.getText().toString()) == true) {
                        //Toast.makeText(getApplicationContext(), "Connecting...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);

                    } else {
                        AlertDialog alertDialog = new AlertDialog.Builder(
                                MainActivity.this).create();
                        alertDialog.setMessage("Invalid Email Address/Password");
                        alertDialog.show();
                    }


                }
            });


            Show.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent){
//                  if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
//                    {
//                        passWord.setTransformationMethod(null);
//                        Show.setText("Hide");
//                        return true;
//                    }
//                  else
//                  {
//                   passWord.setTransformationMethod(new PasswordTransformationMethod());
//                      return false;
//                  }
                    EditText et = (EditText)findViewById(R.id.editTextPassword);
                    et.setSelection(et.getText().length());

                    switch (motionEvent.getAction())
                    {
                        case MotionEvent.ACTION_DOWN:
                            passWord.setTransformationMethod(null);

                            return true;
                        case MotionEvent.ACTION_UP:

                            passWord.setTransformationMethod(new PasswordTransformationMethod());
                            return false;
                        default:
                            return false;


                    }

                }

            });






        }


        if (btn3!=null){
            btn3.setOnClickListener(new View.OnClickListener(){
                //@Override;
                public  void onClick(View v){
                    Intent intent = new Intent(MainActivity.this, SignupActivity3.class);
                    startActivity(intent);
                }





            });
        }


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
