package com.haofan.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et_passwd = (EditText) findViewById(R.id.et_passwd);
        Button btn_validate = (Button) findViewById(R.id.btn_validate);
        final TextView tv_passwd_strength = (TextView) findViewById(R.id.tv_passwd_strength);

        final Validator validator = new Validator();

        btn_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int passed_num = 0;
                passed_num = validator.ifIsValid(et_passwd.getText().toString());

                //only when all the 5 rules are met, the password is shown as 'strong'
                if(passed_num == 5){
                    tv_passwd_strength.setText("The password is strong!");
                }else {
                    tv_passwd_strength.setText("The password is not strong!");
                }

            }
        });
    }
}
