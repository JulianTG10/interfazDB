package com.example.interfazdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.interfazdb.classes.User;
import com.example.interfazdb.model.UserDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();
        userList();
    }
    private void begin(){
        etDocumento = findViewById(R.id.etDocumento);
        etApellidos = findViewById(R.id.etApellidos);
        etNombres = findViewById(R.id.etNombres);
        etUsuario = findViewById(R.id.etUsuario);
        etContra = findViewById(R.id.etContra);
        listUsers = findViewById(R.id.lvLista);



    }
    private boolean checkFields(){
        documento = Integer.parseInt(etDocumento.getText.toString());
        usuario =etUsuario.getText().toString();
        nombres =etNombres.getText().toString();
        apellidos = etApellidos.getText().toString();
        contra= etContra.getText().toString();
        Log.i(TAG,"checkFields: "+documento);

        return true;





    }


    public void registerUser(View view){
        if(checkFields()){
            UserDAO userDAO = new UserDAO(this, view);
            User user = new User(documeto,usuario,nombres,apellidos,contra);
            userDAO.insertUser(user);
            userList();



        }

    }

    public void callUserList(View view){userList();}
    private void userList(){
        UserDAO userDAO =new UserDAO(this, listUsers);
        ArrayList<User> userArrayList = userDAO.getUserList();
        ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,userArrayList);
        listUsers.setAdapter(adapter);
    }

}
