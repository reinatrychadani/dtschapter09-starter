package polinema.ac.id.dtsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import polinema.ac.id.dtsapp.data.AppDbProvider;
import polinema.ac.id.dtsapp.data.User;
import polinema.ac.id.dtsapp.data.UserDao;

public class RegisterActivity extends AppCompatActivity
{
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtEmail;
    private EditText edtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.initComponents();
    }

    private void initComponents()
    {
        this.edtUsername = this.findViewById(R.id.edt_username);
        this.edtPassword = this.findViewById(R.id.edt_password);
        this.edtEmail = this.findViewById(R.id.edt_email);
        this.edtPhoneNumber = this.findViewById(R.id.edt_phone_number);
    }

    public void onBtnRegisterNow_Click(View view)
    {
        // Mendapatkan DAO dari DTSAppDatabase
        UserDao daoUser = AppDbProvider.getInstance(this.getApplicationContext()).userDao();

        // Menggunakan DAO untuk melakukan INSERT data dalam objek dari class Entity User
        daoUser.insertAll(this.makeUser());

        // Tampilkan pesan konfirmasi
        Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show();

        // Kembali ke halaman login
        this.finish();
    }

    // Membuat Entity class User baru berdasarkan isian user pada EditText-EditText
    private User makeUser()
    {
        User u = new User();
        u.username = this.edtUsername.getText().toString();
        u.password = this.edtPassword.getText().toString();
        u.email = this.edtEmail.getText().toString();
        u.phoneNumber = this.edtPhoneNumber.getText().toString();

        return u;
    }
}
