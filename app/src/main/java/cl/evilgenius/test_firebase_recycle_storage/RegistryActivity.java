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

public class RegistryActivity extends AppCompatActivity{

        private Button registry;
        private TextView login;
        private EditText mail, pass, name;

        FirebaseAuth firebaseAuth;
        String name1, email1, pass1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registry);

            registry= findViewById(R.id.BTN_registry);
            login = findViewById(R.id.TV_registry);
            mail = findViewById(R.id.ET_email_registry);
            pass = findViewById(R.id.ET_pass_registry);



            firebaseAuth = FirebaseAuth.getInstance();
            registry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //  name1= name.getText().toString();
                    pass1=pass.getText().toString();
                    email1=mail.getText().toString();


                    if (valid()){

                        firebaseAuth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    Toast.makeText(RegistryActivity.this, "Resgistro Completado", Toast.LENGTH_SHORT).show();
                                    //  name.setText("");
                                    pass.setText("");
                                    mail.setText("");
                                    finish();
                                    Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(RegistryActivity.this, "Error Al registrar", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }
                }
            });


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            });

        }

        private Boolean valid (){
            Boolean result = false;
            if (email1.equals("")||pass1.equals("")){
                Toast.makeText(this, "Debe llenar todo los campos, para registrar", Toast.LENGTH_SHORT).show();
            }else {
                result=true;
            }

            return result;
        }
}



