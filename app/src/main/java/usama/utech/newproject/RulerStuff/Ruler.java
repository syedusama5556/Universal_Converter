package usama.utech.newproject.RulerStuff;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.kevalpatel2106.rulerpicker.RulerValuePicker;
import com.kevalpatel2106.rulerpicker.RulerValuePickerListener;

import usama.utech.newproject.MainActivity;
import usama.utech.newproject.R;

public class Ruler extends AppCompatActivity {


    private RulerValuePicker rulerPicker;
    private TextView rulerValue;
    private SeekBar seekBarIndicatorInterval;
    private SeekBar seekBarIndicatorWidth;
    private SeekBar seekBarRulerMaxValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler);

        rulerPicker = (RulerValuePicker) findViewById(R.id.ruler_picker);
        rulerValue = (TextView) findViewById(R.id.rulerValue);
        seekBarIndicatorInterval = (SeekBar) findViewById(R.id.seekBarIndicator_interval);


        seekBarIndicatorWidth = (SeekBar) findViewById(R.id.seekBarIndicator_width);
        seekBarRulerMaxValue = (SeekBar) findViewById(R.id.seekBarRulerMax_value);


        rulerPicker.setValuePickerListener(new RulerValuePickerListener() {
            @Override
            public void onValueChange(int selectedValue) {
                rulerValue.setText(selectedValue + "");
            }

            @Override
            public void onIntermediateValueChange(int selectedValue) {

            }
        });

        seekBarIndicatorInterval.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                try {


                    rulerPicker.setIndicatorIntervalDistance(i);



                } catch (Exception e) {

                  //  Toast.makeText(getApplicationContext(), "Error!, Kindly Run The App Again", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarIndicatorWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                rulerPicker.setIndicatorWidth(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarRulerMaxValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                rulerPicker.setMinMaxValue(0, i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}