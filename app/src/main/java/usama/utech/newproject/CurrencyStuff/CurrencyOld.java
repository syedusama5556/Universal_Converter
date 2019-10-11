package usama.utech.newproject.CurrencyStuff;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import usama.utech.newproject.MainActivity;
import usama.utech.newproject.R;


public class CurrencyOld extends AppCompatActivity implements Callback<CurrencyExchange>, CurrencyItemClickListener {

    AlertDialog.Builder aBuilder;
    private ListView lvCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //code that displays the content in full screen mode
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_currency);


        lvCurrency = (ListView) findViewById(R.id.lvCurrency);


    }

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Loading Please Wait....", Toast.LENGTH_LONG).show();
        loadCurrencyExchangeData();
    }

    private void loadCurrencyExchangeData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://data.fixer.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CurrencyExchangeService service = retrofit.create(CurrencyExchangeService.class);

        Call<CurrencyExchange> call = service.loadCurrencyExchange();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<CurrencyExchange> call, Response<CurrencyExchange> response) {

        Toast.makeText(this, "Your Base Currency Is " + response.body().getBase(), Toast.LENGTH_SHORT).show();

        CurrencyExchange currencyExchange = response.body();
        lvCurrency.setAdapter(new CurrencyAdapter(this, currencyExchange.getCurrencyList(), this));

    }

    @Override
    public void onFailure(Call<CurrencyExchange> call, Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCurrencyItemClick(Currency c) {
        //Toast.makeText(this, c.getName(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("currency_name", c.getName());
        intent.putExtra("currency_rate", c.getRate());

        startActivity(intent);
    }
}
