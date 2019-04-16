package usama.utech.newproject.CurrencyStuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import usama.utech.newproject.R;

public class SecondActivity extends AppCompatActivity {

    private TextView tvTitle, tvSubTitle, tvOutputName, tvOutputRate;
    private EditText etInput;
    private Button btnCalculate;

    private String currencyName;
    private double currencyRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        tvOutputName = (TextView) findViewById(R.id.tvOutputName);
        tvOutputRate = (TextView) findViewById(R.id.tvOutputRate);

        etInput = (EditText) findViewById(R.id.etInput);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        Intent intent = getIntent();
        currencyName = intent.getStringExtra("currency_name");
        currencyRate = intent.getDoubleExtra("currency_rate", 0);

        tvTitle.setText("EUR to " + currencyName.toUpperCase());
        tvSubTitle.setText("Rate of 1:" + currencyRate);
        tvOutputName.setText(currencyName.toUpperCase() + ": ");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etInput.getText().toString().length() == 0) {
                    return;
                }

                double input;
                try {
                    input = Double.parseDouble(etInput.getText().toString());
                } catch (NumberFormatException e) {
                    etInput.setText("");
                    return;
                }

                double output = input * currencyRate;
                DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
                tvOutputRate.setText(decimalFormat.format(output));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
