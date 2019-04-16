package usama.utech.newproject;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class BmiCalculator extends AppCompatActivity {

    public char gender;
    TextView textViewAge, textViewHeight, textViewWeight, textViewBMI, textViewHealth;
    RadioButton radioButton1, radioButton2;
    Button bmiButton;
    Spinner spinner;
    int selectedId;
    private String text;
/*
    AdView adView;
    InterstitialAd interstitialAd;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        textViewAge = (TextView) findViewById(R.id.agetxt);
        textViewHeight = (TextView) findViewById(R.id.heighttxt);
        textViewWeight = (TextView) findViewById(R.id.weighttxt);
        textViewBMI = (TextView) findViewById(R.id.bmitxt);
        textViewHealth = (TextView) findViewById(R.id.healthtxt);

        radioButton1 = (RadioButton) findViewById(R.id.rd1);
        radioButton2 = (RadioButton) findViewById(R.id.rd2);
        radioButton2.setChecked(true);

        spinner = (Spinner) findViewById(R.id.bmiSpinner);

        bmiButton = (Button) findViewById(R.id.calBmi);


        /*//to show banner add
        MobileAds.initialize(this, "ca-app-pub-7307921528560396~8416692406");
        loadIntad();*/

        radiobuttonAction();


        bmibuttonclickevent();


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

    public void buttonMessageOnNotWorking() {
        if (!bmiButton.isEnabled()) {
            Toast.makeText(getApplicationContext(), "Click Refresh Before Using It Again", Toast.LENGTH_LONG).show();
        }
    }

    public void radiobuttonAction() {

        if (radioButton1.isChecked()) {
            gender = 'm';
        }
        if (radioButton2.isChecked()) {
            gender = 'f';
        }
    }

    public void bmibuttonclickevent() {

        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    double bmiindex = 0, height1 = 0, height2 = 0;

                    String arr[] = {"Foot", "Centimeter", "Meter"};
                    String a = (String) spinner.getSelectedItem();

                    if (!textViewHeight.getText().toString().isEmpty() && !textViewWeight.getText().toString().isEmpty() && !textViewAge.getText().toString().isEmpty()) {
                        double height = Double.parseDouble(textViewHeight.getText().toString());
                        double weight = Double.parseDouble(textViewWeight.getText().toString());

                        if (a.equals(arr[0])) {
                            height1 = height * 0.3048;
                            height2 = height1 * height1;
                            bmiindex = weight / height2;
                        }
                        if (a.equals(arr[1])) {
                            height1 = height / 100;
                            height2 = height1 * height1;
                            bmiindex = weight / height2;
                        }
                        if (a.equals(arr[2])) {
                            height1 = height;
                            height2 = height1 * height1;
                            bmiindex = weight / height2;
                        }

                        if (bmiindex < 18.5) {
                            new CountDownTimer(2000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {
                                    alertDialogUnderWeight();
                                }

                            }.start();


                            textViewHealth.setText("UnderWeight");

                        }

                        if (bmiindex >= 18.5 && bmiindex < 25.0) {
                            textViewBMI.setBackgroundResource(R.drawable.heartgreen);
                            textViewHealth.setText("Your BMI Is Normal");

                            new CountDownTimer(2000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {
                                    alertDialogNormalWeight();
                                }

                            }.start();

                        }

                        if (bmiindex > 25.0 && bmiindex < 30.0) {
                            new CountDownTimer(2000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {
                                    alertDialogOverWeight();
                                }

                            }.start();


                            textViewHealth.setText("OverWeight");

                        }

                        if (bmiindex > 30.0) {
                            new CountDownTimer(2000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {
                                    alertDialogObese();
                                }

                            }.start();


                            textViewHealth.setText("Obese");

                        }

                        textViewBMI.setText(String.format("%.2f", bmiindex));
                        bmiButton.setEnabled(false);
                        buttonMessageOnNotWorking();

                    } else {
                        Toast.makeText(getApplicationContext(), "Enter the missing value", Toast.LENGTH_LONG).show();

                    }


                } catch (Exception e) {

                }

            }
        });
    }

    public void alertDialogUnderWeight() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("UnderWeight");
        builder.setMessage("Being underweight may weaken your immune system and put you at risk of osteoporosis. Ask your doctor what you can do to achieve a healthier weight or to address unexpected weight loss. For better health:\n" +
                "\n 1) Embrace healthy eating by choosing a variety of nutrient-rich foods, including fruits, vegetables and whole grains, and energy-dense foods like olive oil, nuts and dried fruits.\n\n" +
                "2) Eat between-meal healthy snacks whole-grain crackers and nuts, for example to increase calories.\n\n" +
                "3) Exercise. Your doctor may recommend strength training to promote lean muscle development and increase your weight in a healthy way.");
        builder.show();
    }

    public void alertDialogNormalWeight() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("NormalWeight");
        builder.setMessage("Congratulations!\nYour healthy weight is well worth the effort. It reduces your risk of serious health conditions such as high blood pressure, heart disease, stroke and diabetes. To maintain a healthy weight:\n" +
                "\n" +
                "1) Embrace healthy eating by choosing a variety of nutrient-rich foods, including fruits, vegetables and whole grains, and small amounts of energy-dense foods like olive oil, nuts and dried fruits.\n\n" +
                "2) Exercise. Aim for 30 to 60 minutes of moderately intense activity daily.\n\n" +
                "3) Set action goals focused on specific healthy activities such as improving muscle tone through strength training or starting a daily food and activity diary.");
        builder.show();
    }

    public void alertDialogOverWeight() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("OverWeight");
        builder.setMessage("Consider the benefits of a healthy weight — a reduced risk of heart disease, stroke and diabetes, increased energy and improved self-esteem, for example. Then talk to your doctor about the best weight-loss approach for you. To start:\n" +
                "\n" +
                "1) Embrace healthy eating by choosing a variety of nutrient-rich foods, including fruits, vegetables and whole grains, and small amounts of energy-dense foods like olive oil, nuts and dried fruits.\n\n" +
                "2) Exercise. Ask your doctor about the right type of activities for you. Remember, even small amounts of activity provide immediate benefits.\n\n" +
                "3) Set action goals focused on specific healthy activities such as starting a daily food and activity diary.");
        builder.show();
    }

    public void alertDialogObese() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Obese");
        builder.setMessage("Consider the benefits of a healthy weight — a reduced risk of heart disease, stroke and diabetes, increased energy and improved self-esteem, for example. Then talk to your doctor about the best weight-loss approach for you. To start:\n" +
                "\n" +
                "1) Embrace healthy eating by choosing a variety of nutrient-rich foods, including fruits, vegetables and whole grains, and small amounts of energy-dense foods like olive oil, nuts and dried fruits.\n\n" +
                "2) Exercise. Ask your doctor about the right type of activities for you. Remember, even small amounts of activity provide immediate benefits.\n\n" +
                "3) Set action goals focused on specific healthy activities such as starting a daily food and activity diary.");
        builder.show();
    }

    public void refresh(View view) {
        textViewBMI.setText("");
        textViewWeight.setText("");
        textViewHeight.setText("");
        textViewAge.setText("");
        textViewHealth.setText("Health Pending");

        textViewBMI.setBackgroundResource(R.drawable.heart);
        bmiButton.setEnabled(true);


    }

    public void age(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Your Age");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_PHONE);
        builder.setView(input);


// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text = input.getText().toString();

                textViewAge.setText(text);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void weight(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Your Weight");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_PHONE);
        builder.setView(input);


// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text = input.getText().toString();

                textViewWeight.setText(text);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void height(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Your Height");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_PHONE);
        builder.setView(input);


// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text = input.getText().toString();

                textViewHeight.setText(text);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
