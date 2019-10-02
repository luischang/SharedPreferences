package pe.edu.cibertec.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String KEY_PREFERENCES = "MisPreferenciasKey";
    final String KEY_USUARIO = "sp_usuario";
    final String KEY_CLAVE = "sp_clave";
    final String KEY_CHECK = "sp_check";

    final String USUARIO = "ADMIN";
    final String CLAVE = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Referencia a los Controles*/
        final EditText txtUsuario = (EditText) findViewById(R.id.txtUsuario_login);
        final EditText txtClave = (EditText) findViewById(R.id.txtClave_login);
        final CheckBox chkRecordar = (CheckBox) findViewById(R.id.chkRecordarme_login);
        Button btnLogin = (Button) findViewById(R.id.btnIngresar_login);

        /**Implementamos el Evento onClick del Botón*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**Obtenemos los valores de los EditText*/
                String usuario = txtUsuario.getText().toString();
                String clave = txtClave.getText().toString();

                /**Simulamos un Login, comparando los valores ingresados
                 * con valores declarados en el código */
                if (usuario.equals(USUARIO) && clave.equals(CLAVE)) {
                    /**Si está activo el CheckBox persistimos los valores*/
                    if (chkRecordar.isChecked()) {
                        /**Guardamos los valores de los datos ingresados*/
                        /**Creamos y/o llamamos a una referencia*/
                        SharedPreferences settings = getSharedPreferences(KEY_PREFERENCES, MODE_PRIVATE);
                        /**Abrimos el editor para agregar o modificar los valores*/
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString(KEY_USUARIO, usuario);
                        editor.putString(KEY_CLAVE, clave);
                        editor.putBoolean(KEY_CHECK, true);
                        /**Guardamos los cambios del editor*/
                        editor.apply();
                    } else {
                        /**Sino se ha seleccionado el Checkbox*/
                        /**Creamos y/o llamamos a una referencia*/
                        SharedPreferences settings = getSharedPreferences(KEY_PREFERENCES, MODE_PRIVATE);
                        /**Abrimos el editor para eliminar los valores*/
                        SharedPreferences.Editor editor = settings.edit();
                        editor.remove(KEY_USUARIO);
                        editor.remove(KEY_CLAVE);
                        editor.remove(KEY_CHECK);
                        /**Guardamos los cambios del editor*/
                        editor.apply();
                    }

                    /**Creamos un objeto Usuario*/
                    Usuario miUsuario = new Usuario(usuario, clave);
                    /**Asignamos el objeto a nuestra variable current_usuario
                     * A partir de este momento podremos utilizar este objeto
                     * desde cualquier parte de nuestro proyecto*/
                    ControlUsuario.getInstance().current_usuario = miUsuario;

                    /**Llamamos a la siguiente Actividad*/
                    Intent intent = new Intent().setClass(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                } else {
                    /**Enviamos un mensaje de no equivalencia*/
                    Toast.makeText(getApplicationContext(),
                            "Usuario o Contraseña Errados",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        /**Buscamos si existen los valores registrados*/
        SharedPreferences settings = getSharedPreferences(KEY_PREFERENCES, MODE_PRIVATE);
        String sp_usuario = settings.getString(KEY_USUARIO, "");
        String sp_clave = settings.getString(KEY_CLAVE, "");
        boolean sp_check = settings.getBoolean(KEY_CHECK, false);

        /**Asignamos los valores a los controles*/
        txtUsuario.setText(sp_usuario);
        txtClave.setText(sp_clave);
        chkRecordar.setChecked(sp_check);
    }
}
