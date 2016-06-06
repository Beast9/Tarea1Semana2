package beast9.com.tarea1semana2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ialejndragonzalez on 06/06/16.
 */
public class DatosActivity extends AppCompatActivity {

    TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    String nombre, fecha, email, telefono, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
        fecha = extras.getString("fecha");
        email= extras.getString("email");
        telefono = extras.getString("telefono");
        descripcion = extras.getString("descripcion");

        tvNombre = (TextView)findViewById(R.id.textViewNombre);
        tvFecha = (TextView)findViewById(R.id.textViewfecha);
        tvTelefono = (TextView)findViewById(R.id.textViewTelefono);
        tvEmail = (TextView)findViewById(R.id.textViewEmail);
        tvDescripcion = (TextView)findViewById(R.id.textViewDescripcion);

        tvNombre.setText("Nombre: " + nombre);
        tvFecha.setText("Fecha de nacimiento: " + fecha);
        tvEmail.setText("Email: " + email);
        tvTelefono.setText("Telefono: " + telefono);
        tvDescripcion.setText("Descripción: " + descripcion);

    }


    public void onClickEnviar(View v)
    {
        if(v.getId() == R.id.btnEditar) {
            Intent i = new Intent();
            i.putExtra("nombre", nombre);
            i.putExtra("fecha", fecha);
            i.putExtra("telefono", telefono);
            i.putExtra("email", email);
            i.putExtra("descripcion", descripcion);
            setResult(RESULT_OK, i);
            finish();
        }
    }

}