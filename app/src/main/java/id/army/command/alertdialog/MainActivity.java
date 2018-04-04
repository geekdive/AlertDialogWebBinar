package id.army.command.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.edtNama)
    EditText edtNama;
    @BindView(R.id.edtAlamat)
    EditText edtAlamat;
    @BindView(R.id.edtNoTelp)
    EditText edtNoTelp;
    @BindView(R.id.btnShowAlert)
    Button btnShowAlert;
    @BindView(R.id.btnExitAlert)
    Button btnExitAlert;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnShowAlert, R.id.btnExitAlert})
    public void onViewClicked(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (view.getId()) {
            case R.id.btnShowAlert:
                String Ambilnama = edtNama.getText().toString();
                String Ambilalamat = edtAlamat.getText().toString();
                String Ambiltelp = edtNoTelp.getText().toString();

                builder
                        .setTitle("Output Inputan User:")
                        .setMessage("Nama Lengkap " + Ambilnama + "\nAlamat " + Ambilalamat + "\nNotelp " + Ambiltelp)
                        .setPositiveButton("Clear Inputan", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edtNama.setText("");
                                edtAlamat.setText("");
                                edtNoTelp.setText("");
                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog dialogA = builder.create();
                dialogA.show();
                break;
            case R.id.btnExitAlert:
                builder.setTitle("Konfirm")
                        .setMessage("Apakah ingin keluar dari aplikasi?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Anda Masih dalam Aplikasi!", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialogB = builder.create();
                dialogB.show();
                break;
        }
    }
}
