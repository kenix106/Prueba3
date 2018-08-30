package cl.evilgenius.test_firebase_recycle_storage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mail, pass;
   // private Button login;
    private TextView regis;

    FirebaseAuth firebaseAuth;
    String email1, pass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail = findViewById(R.id.ET_email);
        pass = findViewById(R.id.ET_pass);

      //  login = findViewById(R.id.BTN_Login);

        regis = findViewById(R.id.TV_login);

        firebaseAuth = FirebaseAuth.getInstance();
        //  setTitle("Notas Personales LOGIN");


        //--------------------------------------------
        Button login = (Button) findViewById(R.id.BTN_Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1 = mail.getText().toString();
                String pass1 = pass.getText().toString();

                if (valid()) {
                    firebaseAuth.signInWithEmailAndPassword(email1, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                //  String wtf = firebaseAuth.getUid().toString();
                                finish();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                //  Toast.makeText(LoginActivity.this, wtf, Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Contraseña o Correo Incorrecto", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }// final 1st IF
            }
        });
        //-----------------------------------------------

        // Button login= (Button) findViewById(R.id.BTN_Login);
     /*   login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email1 = mail.getText().toString();
                pass1 = pass.getText().toString();

                if (valid()) {
                    firebaseAuth.signInWithEmailAndPassword(email1, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                //  String wtf = firebaseAuth.getUid().toString();
                                finish();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                //  Toast.makeText(LoginActivity.this, wtf, Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Contraseña o Correo Incorrecto", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }// final 1st IF
            }         //final onclick
        });*/


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistryActivity.class);
                startActivity(intent);
            }
        });

    }//fin Oncreate

    private Boolean valid() {
        Boolean result = false;

        if (email1.equals("") || pass1.equals("")) {
            Toast.makeText(this, "Debe llenar los campos para Logearse", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }


}