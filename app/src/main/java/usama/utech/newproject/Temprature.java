package usama.utech.newproject;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import usama.utech.newproject.CurrencyStuff.CurrencyOld;
import usama.utech.newproject.RulerStuff.Ruler;
import usama.utech.newproject.SoundMeterStuff.MainActivitySound;

public class Temprature extends AppCompatActivity {

    TextView result;
    TextView editText;
    LinearLayout linearLayout;
    Spinner spinner1, spinner2;

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;

    Button button[];


    int numberFromIntent;
    String[] colorArray = {"#3f51b5", "#007ee5", "#ff3300", "#0097A7", "#34495e", "#3498db", "#8e44ad", "#699f55", "#2979FF", "#E91E63", "#f44336", "#6D4C41", "#78909C", "#009688", "#1A237E", "#DD2C00", "#d50000", "#1A237E"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temprature);


        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        editText = (TextView) findViewById(R.id.edittxt);
        result = (TextView) findViewById(R.id.result);
        buttonDecliration();
        button = new Button[]{button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14};


       /* result.setText(getIntent().getStringExtra("info"));
        linearLayout = (LinearLayout) findViewById(R.id.lin);
        linearLayout.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("info")));

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.RESULT_HIDDEN);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("usama");
            }
        });*/


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!(TextUtils.isEmpty(editText.getText().toString()))) {
                    actionToTakeOnTextChange();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        numberFromIntent = getIntent().getIntExtra("info", 1);

        whatToShowInSpinner();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitMessage = new AlertDialog.Builder(this);
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


    public void buttonDecliration() {
        button0 = findViewById(R.id.but0);
        button1 = findViewById(R.id.but1);
        button2 = findViewById(R.id.but2);
        button3 = findViewById(R.id.but3);
        button4 = findViewById(R.id.but4);
        button5 = findViewById(R.id.but5);
        button6 = findViewById(R.id.but6);
        button7 = findViewById(R.id.but7);
        button8 = findViewById(R.id.but8);
        button9 = findViewById(R.id.but9);
        button10 = findViewById(R.id.but10);
        button11 = findViewById(R.id.but11);
        button12 = findViewById(R.id.but12);
        button13 = findViewById(R.id.but13);
        button14 = findViewById(R.id.but14);


    }

    public void colorOfBut() {


        Random random = new Random();
        int index = random.nextInt(colorArray.length);
        for (int i = 0; i < button.length; i++) {
            button[i].setBackgroundColor(Color.parseColor(colorArray[index]));

            spinner1.setBackgroundColor(Color.parseColor(colorArray[index]));

            spinner2.setBackgroundColor(Color.parseColor(colorArray[index]));


        }
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            spinner1.setBackgroundColor(Color.parseColor("#03A9F4"));

        }*/

    }


    public void whatToShowInSpinner() {
        //temprature
        if (numberFromIntent == 1) {
            String sp1[] = {"Celsius", "Farenheit", "Kelvin", "Rankine"};

            methodeOfWhatToShowInSpinner(sp1);
        }
        //weight
        if (numberFromIntent == 2) {
            String sp1[] = {"Pounds", "Kilograms", "Ounces", "Metric Tons", "Grams", "Carats", "Milligrams"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //length
        if (numberFromIntent == 3) {
            String sp1[] = {"Miles", "Kilometers", "Meters", "Foot", "Inches", "Centimeters", "Millimeters", "Yards"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //speed
        if (numberFromIntent == 4) {
            String sp1[] = {"Miles/hour", "Kilometers/hour", "Meters/second", "Knots", "Mach"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //currency
        if (numberFromIntent == 5) {
            /*String sp1[] = {"USD", "PKR", "Yen", "Riyal", "Darham"};

            methodeOfWhatToShowInSpinner(sp1);*/
            ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected() == true) {
                Toast.makeText(getApplicationContext(), "Network Available", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), CurrencyOld.class));
                finish();

            } else {
                Toast.makeText(getApplicationContext(), "Network Not Available", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }


        }
        //volume
        if (numberFromIntent == 6) {
            String sp1[] = {"US-Gallons-(Liquid)", "US-Pints-(Liquid)", "Liters", "Centiliters", "Milliliters"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //time
        if (numberFromIntent == 7) {
            String sp1[] = {"MiliSeconds", "Seconds", "Minutes", "Hour", "Days", "Years"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //area
        if (numberFromIntent == 8) {
            String sp1[] = {"Square-Foot", "Hectares", "Square-Meters", "Acres", "Square-Kilometers", "Square-Miles"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //fule
        if (numberFromIntent == 9) {
            String sp1[] = {"US-Miles/gallon", "Kilometer/liter", "Liter/100-Kilometer"};

            methodeOfWhatToShowInSpinner(sp1);
        }
        //pressure
        if (numberFromIntent == 10) {
            String sp1[] = {"Pascals", "Bar", "Pound-force/sqrInch", "Atmospheres(atm)"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //energy
        if (numberFromIntent == 11) {
            String sp1[] = {"joule", "kilojoule", "watt-hour", "kilowatt-hour", "calorie", "horsepower"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //storage
        if (numberFromIntent == 12) {
            String sp1[] = {"Bits", "Nibble", "Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes", "Petabytes"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //luminance
        if (numberFromIntent == 13) {
            String sp1[] = {"Candela/cm²", "Candela/m²", "Foot-lambert", "Kilocandela/m²", "Lambert", "Nit", "Stilb"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //current
        if (numberFromIntent == 14) {
            String sp1[] = {"Ampere [A]", "milliampere [mA]", "biot [Bi]", "abAmpere [abA]", "KiloAmps [kA]"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //force
        if (numberFromIntent == 15) {
            String sp1[] = {"dyne", "kilonewton", "newton", "ponds-force"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //sound
        if (numberFromIntent == 16) {
            String sp1[] = {"Bel", "Decibel", "Neper"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //frequency
        if (numberFromIntent == 17) {
            String sp1[] = {"hertz(Hz)", "kilohertz(kHz)", "megahertz(MHz)", "gigahertz(GHz)", "terahertz(THz)"};

            methodeOfWhatToShowInSpinner(sp1);
        }
        //radiation
        if (numberFromIntent == 18) {
            String sp1[] = {"gray/second(Gy/s)", "exagray/second(EGy/s)", "petagray/second(PGy/s)", "teragray/second(TGy/s)"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //resistance
        if (numberFromIntent == 19) {
            String sp1[] = {"Microohm(µΩ)", "Ohms(Ω)", "Kiloohms(kΩ)", "Megaohm(MΩ)"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //power
        if (numberFromIntent == 20) {
            String sp1[] = {"watt[W]", "kilowatt[kW]", "megawatt[mW]", "gigawatt[GW]", "terawatt[TW]"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //bmi
        if (numberFromIntent == 21) {
            Intent intent = new Intent(getApplicationContext(), BmiCalculator.class);
            startActivity(intent);
            finish();

        }
        //solution
        if (numberFromIntent == 22) {
            String sp1[] = {"kilogram/liter", "gram/liter", "milligram/liter", "part-per-million(ppm)"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //angle
        if (numberFromIntent == 23) {
            String sp1[] = {"Degree", "Radian", "Miliradian", "Gradian"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //magnet
        if (numberFromIntent == 24) {
            String sp1[] = {"weber[Wb]", "milliweber[mWb]", "microweber[μWb]", "volt-second[V·s]"};

            methodeOfWhatToShowInSpinner(sp1);

        }
        //compass
        if (numberFromIntent == 25) {
            Intent intent = new Intent(getApplicationContext(), Compass.class);
            startActivity(intent);
            finish();

        }
        //cryptography
        if (numberFromIntent == 26) {
            Intent intent = new Intent(getApplicationContext(), Cryptography.class);
            startActivity(intent);
            finish();

        }
        //Ruler
        if (numberFromIntent == 27) {
            Intent intent = new Intent(getApplicationContext(), Ruler.class);
            startActivity(intent);
            finish();

        }

    }

    public void methodeOfWhatToShowInSpinner(String sp1[]) {

       /* ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_usama, sp1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);*/


        //this code fixses the old api 19 textColor issue for spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_usama, sp1) {
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
                tv.setTextColor(Color.WHITE);

                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position, convertView, parent);

                // Set the text color of drop down items
                tv.setTextColor(Color.BLACK);


                // Return the modified view
                return tv;
            }
        };

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);
        //color of but
        colorOfBut();
    }

    public void actionToTakeOnTextChange() {
        if (!(TextUtils.isEmpty(editText.getText().toString()))) {
            result.setText(editText.getText().toString());
        }

        if (numberFromIntent == 1) {
            tempratureCalculation();
        }
        if (numberFromIntent == 2) {

            weightCalculation();
        }
        if (numberFromIntent == 3) {

            lengthCalculation();
        }
        if (numberFromIntent == 4) {

            speedCalculation();
        }
        if (numberFromIntent == 5) {

            currencyCalculation();
        }
        if (numberFromIntent == 6) {

            volumeCalculation();
        }
        if (numberFromIntent == 7) {

            timeCalculation();
        }
        if (numberFromIntent == 8) {

            areaCalculation();
        }
        if (numberFromIntent == 9) {

            fuleCalculation();
        }
        if (numberFromIntent == 10) {

            pressureCalculation();
        }
        if (numberFromIntent == 11) {

            energyCalculation();
        }
        if (numberFromIntent == 12) {

            storageCalculation();
        }
        if (numberFromIntent == 13) {

            luminanceCalculation();
        }
        if (numberFromIntent == 14) {

            currentCalculation();
        }
        if (numberFromIntent == 15) {

            forceCalculation();
        }
        if (numberFromIntent == 16) {

            soundCalculation();
        }
        if (numberFromIntent == 17) {

            frequencyCalculation();
        }
        if (numberFromIntent == 18) {

            radiationCalculation();
        }
        if (numberFromIntent == 19) {

            resistanceCalculation();
        }
        if (numberFromIntent == 20) {

            powerCalculation();
        }
        if (numberFromIntent == 22) {

            solutionCalculation();
        }
        if (numberFromIntent == 23) {

            angleCalculation();
        }
        if (numberFromIntent == 24) {

            magnetCalculation();
        }

    }

    //all calculation methods
    public void tempratureCalculation() {
        result.setText(editText.getText().toString());

        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();


        //if differnet are selected
        if (sp1.equals("Celsius")) {
            if (sp1.equals("Celsius") && sp2.equals("Farenheit")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = (a * 1.8) + 32;

                result.setText(b + "F'");
            }

            if (sp1.equals("Celsius") && sp2.equals("Kelvin")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = a + 273.15;

                result.setText(b + "K'");
            }

            if (sp1.equals("Celsius") && sp2.equals("Rankine")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = (a + 273.15) * 1.8;

                result.setText(b + "'R");
            }

        }
        if (sp1.equals("Farenheit")) {
            if (sp1.equals("Farenheit") && sp2.equals("Celsius")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = (a - 32) / 1.8;

                result.setText(b + "C'");
            }

            if (sp1.equals("Farenheit") && sp2.equals("Kelvin")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = (a - 32) / 1.8;

                result.setText(b + "C'");
            }

            if (sp1.equals("Farenheit") && sp2.equals("Rankine")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = a + 459.67;

                result.setText(b + "'R");
            }
        }
        if (sp1.equals("Kelvin")) {

            if (sp1.equals("Kelvin") && sp2.equals("Celsius")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = a - 273.15;

                result.setText(b + "C'");
            }

            if (sp1.equals("Kelvin") && sp2.equals("Farenheit")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = (a * 9 / 5) - 459.67;

                result.setText(b + "F'");
            }

            if (sp1.equals("Kelvin") && sp2.equals("Rankine")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = a * 1.8;

                result.setText(b + "'R");
            }

        }
        if (sp1.equals("Rakine")) {
            if (sp1.equals("Rankine") && sp2.equals("Celsius")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = (a - 491.67) * 5 / 9;

                result.setText(b + "C'");
            }

            if (sp1.equals("Rankine") && sp2.equals("Farenheit")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = a - 459.67;

                result.setText(b + "F'");
            }

            if (sp1.equals("Rankine") && sp2.equals("Kelvin")) {
                double a = Double.parseDouble(editText.getText().toString());
                double b = a * 5 / 9;

                result.setText(b + "K'");
            }
        }
    }

    public void weightCalculation() {
        result.setText(editText.getText().toString());
        String units[] = {"Pounds", "Kilograms", "Ounces", "Metric Tons", "Grams", "Carats", "Milligrams"};


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //pounds
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.453592;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 16;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0005;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 453.592;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2267.96;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 453592;

                result.setText(b + "");
            }
        }
        //kilograms
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.20462;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 35.274;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00110231;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 5000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
        }
        //ounce
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0625;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.02834;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.125e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 28.3495;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 141.748;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 28349.5;

                result.setText(b + "");
            }
        }
        //metric ton
        if (sp1.equals(units[3])) {
            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 907.185;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 32000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 907185;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 4.536e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 9.072e+8;

                result.setText(b + "");
            }
        }
        //grams
        if (sp1.equals(units[4])) {
            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00220462;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.035274;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.1023e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 5;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
        }
        //carats
        if (sp1.equals(units[5])) {
            if (sp1.equals(units[5]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000440925;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0002;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00705479;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.2046e-7;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.2;

                result.setText(b + "");
            }


            if (sp1.equals(units[5]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 200;

                result.setText(b + "");
            }

        }

        //miligrams
        if (sp1.equals(units[6])) {
            if (sp1.equals(units[6]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.2046e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.5274e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.1023e-9;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.005;

                result.setText(b + "");
            }
        }
    }

    public void lengthCalculation() {
        result.setText(editText.getText().toString());
        String units[] = {"Miles", "Kilometers", "Meters", "Foot", "Inches", "Centimeters", "Millimeters", "Yards"};


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //Miles
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.60934;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1609.34;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 5280;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 63360;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 160934;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.609e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1760;

                result.setText(b + "");
            }
        }
        //kilometer
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.621371;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3280.84;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 39370.1;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1093.61;

                result.setText(b + "");
            }
        }
        //Meters
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000621371;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.28084;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 39.3701;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.09361;

                result.setText(b + "");
            }
        }

        //Feet
        if (sp1.equals(units[3])) {
            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000189394;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0003048;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.3048;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 12;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 30.48;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 304.8;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.333333;

                result.setText(b + "");
            }
        }
        //Inches
        if (sp1.equals(units[4])) {
            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.5783e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.54e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0254;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0833333;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.54;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 25.4;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0277778;

                result.setText(b + "");
            }
        }
        //centimeters
        if (sp1.equals(units[5])) {
            if (sp1.equals(units[5]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 6.2137e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.01;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0328084;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.393701;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0109361;

                result.setText(b + "");
            }
        }
        //milimeter
        if (sp1.equals(units[6])) {
            if (sp1.equals(units[6]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 6.2137e-7;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00328084;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0393701;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.1;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0109361;

                result.setText(b + "");
            }
        }
        //yards
        if (sp1.equals(units[7])) {
            if (sp1.equals(units[7]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000568182;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0009144;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.9144;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 36;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 91.44;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 914.4;

                result.setText(b + "");
            }
        }
    }

    public void speedCalculation() {
        result.setText(editText.getText().toString());
        String units[] = {"Miles/hour", "Kilometers/hour", "Meters/second", "Knots", "Mach"};


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //Miles/hour
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.60934;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.44704;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.868976;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00130332;

                result.setText(b + "");
            }
        }

        //Kilometers/hour
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.621371;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.277778;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.539957;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000809848;

                result.setText(b + "");
            }
        }
        //Meters/second
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.23694;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.6;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.94384;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00291545;

                result.setText(b + "");
            }
        }
        //knots
        if (sp1.equals(units[3])) {
            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.15078;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.852;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.514444;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00149984;

                result.setText(b + "");
            }
        }
        //mach
        if (sp1.equals(units[4])) {
            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 767.269;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1234.8;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 343;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 666.739;

                result.setText(b + "");
            }
        }

    }

    public void currencyCalculation() {

    }

    public void volumeCalculation() {
        result.setText(editText.getText().toString());
        String units[] = {"US-Gallons-(Liquid)", "US-Pints-(Liquid)", "Liters", "Centiliters", "Milliliters"};


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //gallon
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.78;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 378.541;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3785.41;

                result.setText(b + "");
            }
        }

        //pints
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.125;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.473176;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 47.3176;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 473.176;

                result.setText(b + "");
            }

        }
        //liters
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.264172;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.11338;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
        }
        //centiliter
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00264172;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0211338;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.01;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10;

                result.setText(b + "");
            }

        }
        //mililiters
        if (sp1.equals(units[4])) {

            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000264172;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00211338;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.1;

                result.setText(b + "");
            }
        }

    }

    public void timeCalculation() {
        String units[] = {"MiliSeconds", "Seconds", "Minutes", "Hour", "Days", "Years"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //milisecond
        if (sp1.equals(units[0])) {

            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.6667e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.7778e-7;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.1574e-8;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.171e-11;

                result.setText(b + "");
            }
        }

        //second
        if (sp1.equals(units[1])) {

            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0166667;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000277778;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.1574e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.171e-8;

                result.setText(b + "");
            }

        }
        //mimutes
        if (sp1.equals(units[2])) {

            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 60000;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 60;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0166667;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000694444;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.9026e-6;

                result.setText(b + "");
            }
        }

        //hour
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.6e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3600;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 60;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0416667;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000114155;

                result.setText(b + "");
            }
        }

        //days
        if (sp1.equals(units[4])) {

            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8.64e+7;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 86400;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1440;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 24;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00273973;

                result.setText(b + "");
            }
        }

        //year
        if (sp1.equals(units[5])) {

            if (sp1.equals(units[5]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.154e+10;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.154e+7;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 525600;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8760;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 365;

                result.setText(b + "");
            }
        }

    }

    public void areaCalculation() {

        String units[] = {"Square-Foot", "Hectares", "Square-Meters", "Acres", "Square-Kilometers", "Square-Miles"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //square foot
        if (sp1.equals(units[0])) {

            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 9.2903e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.092903;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.2957e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 9.2903e-8;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.587e-8;

                result.setText(b + "");
            }
        }

        //hectares
        if (sp1.equals(units[1])) {

            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 107639;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.47105;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.01;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00386102;

                result.setText(b + "");
            }

        }
        //square meter
        if (sp1.equals(units[2])) {

            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10.7639;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-4;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000247105;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.861e-7;

                result.setText(b + "");
            }
        }

        //acres
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 43560;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.404686;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 4046.86;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00404686;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0015625;

                result.setText(b + "");
            }
        }

        //square kilometer
        if (sp1.equals(units[4])) {

            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.076e+7;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 247.105;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.386102;

                result.setText(b + "");
            }
        }

        //square miles
        if (sp1.equals(units[5])) {

            if (sp1.equals(units[5]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.788e+7;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 258.999;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.59e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 640;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.58999;

                result.setText(b + "");
            }
        }


    }

    public void fuleCalculation() {
        result.setText(editText.getText().toString());
        String units[] = {"US-Miles/gallon", "Kilometer/liter", "Liter/100-Kilometer"};

        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //miles pre gallon
        if (sp1.equals(units[0])) {


            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.425144;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 235.215;

                result.setText(b + "");
            }

        }

        //kilometer pre liter
        if (sp1.equals(units[1])) {

            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.35215;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100;

                result.setText(b + "");
            }


        }
        //liter per 100 km
        if (sp1.equals(units[2])) {

            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 235.215;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100;

                result.setText(b + "");
            }

        }

    }

    public void pressureCalculation() {

        String units[] = {"Pascals", "Bar", "Pound-force/sqrInch", "Atmospheres(atm)"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //pascals
        if (sp1.equals(units[0])) {

            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000145038;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 9.8692e-6;

                result.setText(b + "");
            }

        }

        //Bar
        if (sp1.equals(units[1])) {

            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 14.5038;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.986923;

                result.setText(b + "");
            }


        }
        //pound force per square inch
        if (sp1.equals(units[2])) {

            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 6894.76;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0689476;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.068046;

                result.setText(b + "");
            }

        }

        //atmosphere
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 101325;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.01325;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 14.6959;

                result.setText(b + "");
            }

        }


    }

    public void energyCalculation() {
        String units[] = {"joule", "kilojoule", "watt-hour", "kilowatt-hour", "calorie", "horsepower"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //joule
        if (sp1.equals(units[0])) {

            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000277778;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.7778e-7;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000239006;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0013;

                result.setText(b + "");
            }
        }

        //kilojoule
        if (sp1.equals(units[1])) {

            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.277778;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000277778;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.239006;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.341022;

                result.setText(b + "");
            }

        }
        //watt-hour
        if (sp1.equals(units[2])) {

            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3600;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.6;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.860421;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0013;

                result.setText(b + "");
            }
        }

        //kilowatt-hour
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.6e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3600;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 860.421;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.34102;

                result.setText(b + "");
            }
        }

        //calorie
        if (sp1.equals(units[4])) {

            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 4184;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 4.184;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.16222;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00116222;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001558981233244;

                result.setText(b + "");
            }
        }

        //houresepower
        if (sp1.equals(units[5])) {

            if (sp1.equals(units[5]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 746;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.7456998716;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 745.69987;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.74570;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 641.19;

                result.setText(b + "");
            }
        }


    }

    //problem to fix in storage (magabyte or mebibit)
    public void storageCalculation() {
        result.setText(editText.getText().toString());
        String units[] = {"Bits", "Nibble", "Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes", "Petabytes"};


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //bit
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.25;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.125;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000125;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.25e-7;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.25e-10;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.25e-13;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.25e-16;

                result.setText(b + "");
            }
        }
        //nibble
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 4;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.5;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0005;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 5e-7;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 5e-10;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 5e-13;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 5e-16;

                result.setText(b + "");
            }
        }
        //byte
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-9;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-12;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-15;

                result.setText(b + "");
            }
        }

        //kilobyte
        if (sp1.equals(units[3])) {
            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-9;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-12;

                result.setText(b + "");
            }
        }
        //megabyte
        if (sp1.equals(units[4])) {
            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-9;

                result.setText(b + "");
            }
        }
        //gigabyte (to check for errors)
        if (sp1.equals(units[5])) {
            if (sp1.equals(units[5]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8e+9;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2e+9;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+9;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
        }
        //terabyte
        if (sp1.equals(units[6])) {
            if (sp1.equals(units[6]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8e+12;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2e+12;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+12;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+9;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[7])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
        }
        //petabyte
        if (sp1.equals(units[7])) {
            if (sp1.equals(units[7]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8e+15;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2e+15;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+15;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+12;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+9;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[7]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
        }

    }

    public void luminanceCalculation() {
        String units[] = {"Candela/cm²", "Candela/m²", "Foot-lambert", "Kilocandela/m²", "Lambert", "Nit", "Stilb"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //candela cm sqr
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2918.635079604;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.14159265359;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1;

                result.setText(b + "");
            }
        }
        //candela m sqr
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0001;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.2918635079604;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000314159265359;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0001;

                result.setText(b + "");
            }
        }
        //foot-lambart
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0003426259099632;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.426259099632;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.003426259099632;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00107639104167;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.426259099632;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0003426259099632;

                result.setText(b + "");
            }
        }
        //kilocandela m sqr
        if (sp1.equals(units[3])) {
            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.1;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 291.8635079604;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.314159265359;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.1;

                result.setText(b + "");
            }
        }
        //lambert
        if (sp1.equals(units[4])) {
            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.3183098861838;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3183.098861838;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 929.0304000008;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.183098861838;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3183.098861838;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.3183098861838;

                result.setText(b + "");
            }
        }
        //nit
        if (sp1.equals(units[5])) {
            if (sp1.equals(units[5]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0001;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.2918635079604;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[5]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000314159265359;

                result.setText(b + "");
            }


            if (sp1.equals(units[5]) && sp2.equals(units[6])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0001;

                result.setText(b + "");
            }

        }

        //stilb
        if (sp1.equals(units[6])) {
            if (sp1.equals(units[6]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10000;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2918.635079604;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 3.14159265359;

                result.setText(b + "");
            }
            if (sp1.equals(units[6]) && sp2.equals(units[5])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10000;

                result.setText(b + "");
            }
        }


    }

    public void currentCalculation() {
        String units[] = {"Ampere [A]", "milliampere [mA]", "biot [Bi]", "abAmpere [abA]", "KiloAmps [kA]"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //Ampere
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.100000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001000;

                result.setText(b + "");
            }
        }

        //miliamps
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000100;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000100;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000001;

                result.setText(b + "");
            }

        }
        //Biot
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10000.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.010000;

                result.setText(b + "");
            }
        }
        //abAmpere
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10000.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.010000;

                result.setText(b + "");
            }

        }
        //KiloAmpere
        if (sp1.equals(units[4])) {

            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100.0;

                result.setText(b + "");
            }
        }
    }

    public void forceCalculation() {

        String units[] = {"dyne", "kilonewton", "newton", "ponds-force"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //dyne
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-8;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-5;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 2.24809e-6;

                result.setText(b + "");
            }

        }

        //kilonewton
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+8;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 224.809;

                result.setText(b + "");
            }


        }
        //newton
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 100000;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0;

                result.setText(b + "");
            }
//            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
//                double a = editTextValueGetterInDouble();
//                double b = a * 0.224809;
//
//                result.setText(b + "");
//            }
        }
        //pounds
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 444822;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.00444822;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 4.44822;

                result.setText(b + "");
            }


        }


    }

    public void soundCalculation() {
        String units[] = {"Bel", "Decibel", "Neper"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //bel
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 10;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.151277918;

                result.setText(b + "");
            }


        }

        //decibel
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.1;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.1151277918;

                result.setText(b + "");
            }


        }
        //neper
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.8686000004;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 8.685889638;

                result.setText(b + "");
            }


        }


    }

    public void frequencyCalculation() {
        String units[] = {"hertz(Hz)", "kilohertz(kHz)", "megahertz(MHz)", "gigahertz(GHz)", "terahertz(THz)"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //hertz
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-9;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-12;

                result.setText(b + "");
            }
        }

        //kilohertz
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-9;

                result.setText(b + "");
            }

        }
        //megahertz
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-6;

                result.setText(b + "");
            }
        }
        //gigahertz
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+9;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }

        }
        //terahertz
        if (sp1.equals(units[4])) {

            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+12;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+9;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+6;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
        }

    }

    public void radiationCalculation() {

        String units[] = {"gray/second(Gy/s)", "exagray/second(EGy/s)", "petagray/second(PGy/s)", "teragray/second(TGy/s)"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //gray
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-18;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-15;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-12;

                result.setText(b + "");
            }

        }
        //exagray
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+18;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }


        }
        //petagray
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+15;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }

        }
        //teragray
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+12;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000001;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }


        }


    }

    public void resistanceCalculation() {

        String units[] = {"Microohm(µΩ)", "Ohms(Ω)", "Kiloohms(kΩ)", "Megaohm(MΩ)"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //microohm
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000001;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-9;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e-12;

                result.setText(b + "");
            }

        }

        //ohm
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000001;

                result.setText(b + "");
            }


        }
        //kiloohm
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }

        }
        //megaohm
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+12;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }


        }


    }

    public void powerCalculation() {

        String units[] = {"watt[W]", "kilowatt[kW]", "megawatt[mW]", "gigawatt[GW]", "terawatt[TW]"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //watt
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0e-9;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0e-12;

                result.setText(b + "");
            }
        }
        //kilowatt
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0e-6;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0e-9;

                result.setText(b + "");
            }

        }
        //megawatt
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0e-6;

                result.setText(b + "");
            }
        }
        //gigawatt
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[4])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }

        }
        //terawatt
        if (sp1.equals(units[4])) {

            if (sp1.equals(units[4]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1e+12;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[4]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
        }

    }

    public void solutionCalculation() {
        String units[] = {"kilogram/liter", "gram/liter", "milligram/liter", "part-per-million(ppm)"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //kilogram/lite
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000.002;

                result.setText(b + "");
            }

        }

        //gram/liter
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000.000002;

                result.setText(b + "");
            }


        }
        //milligram/liter
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.000000002;

                result.setText(b + "");
            }

        }
        //part-per-million(ppm)
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 9.99999998e-7;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000999999998;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.999999998;

                result.setText(b + "");
            }


        }


    }

    public void angleCalculation() {
        String units[] = {"Degree", "Radian", "Miliradian", "Gradian"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //degree
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0174533;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 17.4533;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.11111;

                result.setText(b + "");
            }

        }

        //radian
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 57.2958;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 63.662;

                result.setText(b + "");
            }


        }
        //miliradian
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.0572958;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.063662;

                result.setText(b + "");
            }

        }
        //gradian
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.9;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.015708;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 15.708;

                result.setText(b + "");
            }


        }

    }

    public void magnetCalculation() {
        String units[] = {"weber[Wb]", "milliweber[mWb]", "microweber[μWb]", "volt-second[V·s]"};

        result.setText(editText.getText().toString());


        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        //weber
        if (sp1.equals(units[0])) {
            if (sp1.equals(units[0]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }
            if (sp1.equals(units[0]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0;

                result.setText(b + "");
            }

        }

        //miliweber
        if (sp1.equals(units[1])) {
            if (sp1.equals(units[1]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[1]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }


        }
        //microweber
        if (sp1.equals(units[2])) {
            if (sp1.equals(units[2]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.000001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 0.001;

                result.setText(b + "");
            }
            if (sp1.equals(units[2]) && sp2.equals(units[3])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0;

                result.setText(b + "");
            }

        }
        //volot-second
        if (sp1.equals(units[3])) {

            if (sp1.equals(units[3]) && sp2.equals(units[0])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1.0;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[1])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000;

                result.setText(b + "");
            }
            if (sp1.equals(units[3]) && sp2.equals(units[2])) {
                double a = editTextValueGetterInDouble();
                double b = a * 1000000;

                result.setText(b + "");
            }


        }


    }


    //double edittext getter
    public double editTextValueGetterInDouble() {
        return Double.parseDouble(editText.getText().toString());
    }


    //all button click methods
    public void clickOnBut1(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 1));

    }

    public void clickOnBut2(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 2));
    }

    public void clickOnBut3(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 3));
    }

    public void clickOnButC(View view) {

        editText.setText("");


        result.setText("");

    }

    public void clickOnBut4(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 4));
    }

    public void clickOnBut5(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 5));
    }

    public void clickOnBut6(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 6));
    }

    public void clickOnButBackspace(View view) {
        if (!(TextUtils.isEmpty(editText.getText().toString()))) {
            String a = editText.getText().toString();
            try {
                String b = a.substring(0, a.length() - 1);
                editText.setText(b);

            } catch (Exception e) {

            }
        }
    }

    public void clickOnBut7(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 7));

    }

    public void clickOnBut8(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 8));

    }

    public void clickOnBut9(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 9));

    }

    public void clickOnButPlusMinus(View view) {
        if (!editText.getText().toString().isEmpty()) {
            String a = editText.getText().toString();
            String b = "-";
            if (!a.contains("-")) {
                editText.setText(new StringBuffer().append(b + a));
            }
        }
    }

    public void clickOnBut0(View view) {
        String a = editText.getText().toString();
        editText.setText(new StringBuffer().append(a + 0));

    }

    public void clickOnButEqual(View view) {


    }

    public void clickOnButDot(View view) {
        if (!editText.getText().toString().isEmpty()) {
            String a = editText.getText().toString();
            String b = ".";
            if (!a.contains(".")) {
                editText.setText(new StringBuffer().append(a + b));
            }
        }
    }


    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    Log.w("INTERNET:", String.valueOf(i));
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        Log.w("INTERNET:", "connected!");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
