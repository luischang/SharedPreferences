package pe.edu.cibertec.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /**Referencia al Control*/
        TextView lblNombre = (TextView) findViewById(R.id.lblNombre_segunda);

        /**Obtenemos el valor almacenado en nustra clase Singleton*/
        lblNombre.setText(ControlUsuario.getInstance().current_usuario.getUsuario());
    }
}
