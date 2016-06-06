package beast9.com.tarea1semana2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNombre, edTelefono, edEmail, edDescripcion;
    TextView tvFecha;
    TextInputLayout inputName, inputTelefono, inputEmail, inputDescripcion;

    String nombre, fecha, email, telefono, descripcion;

    Snackbar snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = (EditText)findViewById(R.id.etName);
        tvFecha = (TextView)findViewById(R.id.textView);
        edTelefono = (EditText)findViewById(R.id.etTelefono);
        edEmail = (EditText)findViewById(R.id.etEmail);
        edDescripcion = (EditText)findViewById(R.id.etDescripcion);
    }

    public void showDatePickerDialog(View v)
    {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void onClickSig(View v)
    {
        if(v.getId() == R.id.btnSig)
        {
            nombre = edNombre.getText().toString();
            fecha = tvFecha.getText().toString();
            telefono = edTelefono.getText().toString();
            email = edEmail.getText().toString();
            descripcion = edDescripcion.getText().toString();

            Intent i = new Intent(MainActivity.this,DatosActivity.class);
            i.putExtra("nombre",nombre);
            i.putExtra("fecha",fecha);
            i.putExtra("telefono",telefono);
            i.putExtra("email",email);
            i.putExtra("descripcion",descripcion);
            startActivityForResult(i, 1234);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1234 && requestCode==RESULT_OK)
        {

            nombre = data.getExtras().getString("nombre");
            fecha = data.getExtras().getString("fecha");
            email= data.getExtras().getString("email");
            telefono = data.getExtras().getString("telefono");
            descripcion = data.getExtras().getString("descripcion");

            edNombre.setText(nombre);
            tvFecha.setText(fecha);
            edEmail.setText(email);
            edTelefono.setText(telefono);
            edDescripcion.setText(descripcion);
        }
    }
}
