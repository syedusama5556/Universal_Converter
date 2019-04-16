package usama.utech.newproject;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;


public class Cryptography extends AppCompatActivity {

    MaterialEditText encodetxt, decodetxt;
    Button encodbtn, decodebtn, copy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptography);

        encodetxt = (MaterialEditText) findViewById(R.id.encodetxt);
        decodetxt = (MaterialEditText) findViewById(R.id.decodetxt);

        encodbtn = (Button) findViewById(R.id.encode);
        decodebtn = (Button) findViewById(R.id.decode);
        copy = (Button) findViewById(R.id.copybtn);


        encodbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enc = encryptString(encodetxt.getText().toString());
                decodetxt.setText(enc);
            }
        });

        decodebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String dec = decryptString(encodetxt.getText().toString());
                    decodetxt.setText(dec);
                } catch (Exception e) {
                    Toast.makeText(Cryptography.this, "Not Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String decodedTxt = decodetxt.getText().toString();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Text Coppied", decodedTxt);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(Cryptography.this, "Text Coppied", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void onBackPressed() {
        android.support.v7.app.AlertDialog.Builder exitMessage = new android.support.v7.app.AlertDialog.Builder(this);
        exitMessage.setTitle("Exit");
        exitMessage.setMessage("Are You Sure You Want To Exit To The MainMenu Your Values Will Be Lost ?");
        exitMessage.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }

        });
        exitMessage.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        exitMessage.show();


    }


    String encryptString(String text) {
        if (TextUtils.isEmpty(text)) {
            text = null;
        } else {
            text = Base64.encodeToString(text.getBytes(), Base64.DEFAULT);
        }
        return text;
    }

    String decryptString(String text) {
        if (!TextUtils.isEmpty(text)) {
            text = new String(Base64.decode(text, Base64.DEFAULT));
        }
        return text;
    }
}
