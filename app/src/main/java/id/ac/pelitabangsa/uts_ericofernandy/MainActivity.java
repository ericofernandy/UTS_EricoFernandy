package id.ac.pelitabangsa.uts_ericofernandy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    Button btnHome, btnAbout, btnContact, btnExit;

    public Button button2;
    public EditText editT;
    Home fragmentHome;
    About fragmentAbout;
    Contact fragmentContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btn_home);
        btnAbout = findViewById(R.id.btn_about);
        btnContact = findViewById(R.id.btn_contact);
        btnExit = findViewById(R.id.btn_exit);
        button2=(Button)findViewById(R.id.button1);
        editT=(EditText)findViewById(R.id.editText1);

        btnHome.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnContact.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    void menuHome() {
        fragmentHome = new Home();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentHome);
        ft.commit();
    }

    void menuAbout() {
        fragmentAbout = new About();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentAbout);
        ft.commit();
    }

    void menuContact() {
        fragmentContact = new Contact();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentContact);
        ft.commit();
    }

    void menuExit() {
        finish();
    }

    @Override
    public void onClick(View v) {
        int startSelection, andSelection;
        if (v == btnHome) {
            menuHome();
        }
        if (v == btnAbout) {
            menuAbout();
        }
        if (v == btnContact) {
            menuContact();
        }
        if (v == btnExit) {
            menuExit();
        }
        if (v == button2){
            startSelection=editT.getSelectionStart();
            andSelection=editT.getSelectionEnd();
            //String selectedText = editT.getText().toString().substring(startSelection,andSelection);
            //Intent intent=new Intent();
            //intent.setAction(ACTION_CHECK);
            //intent.putExtra("word",selectedText);
            //startActivity(intent);
            String url="http://www.pelitabangsa.ac.id";
            Intent web = new Intent(Intent.ACTION_VIEW);
            web.setData(Uri.parse(url));
            startActivity(web);
        }
    }


}