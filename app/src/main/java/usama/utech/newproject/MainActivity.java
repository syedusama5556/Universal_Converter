package usama.utech.newproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.widget.LinearLayout;


import usama.utech.newproject.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> lstBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lstBook = new ArrayList<>();
        lstBook.add(new Book("Temprature", R.drawable.temp_round));
        lstBook.add(new Book("Weight", R.drawable.weight_round));
        lstBook.add(new Book("Length", R.drawable.length_round));
        lstBook.add(new Book("Speed", R.drawable.speed_round));
        lstBook.add(new Book("Currency", R.drawable.currency_round));
        lstBook.add(new Book("Volume", R.drawable.volume_round));
        lstBook.add(new Book("Time", R.drawable.time_round));
        lstBook.add(new Book("Area", R.drawable.area_round));
        lstBook.add(new Book("Fule", R.drawable.fuel_round));
        lstBook.add(new Book("Pressure", R.drawable.pressure_round));
        lstBook.add(new Book("Energy", R.drawable.energy_round));
        lstBook.add(new Book("Storage", R.drawable.storage_round));
        lstBook.add(new Book("Luminence", R.drawable.luminence_round));
        lstBook.add(new Book("Current", R.drawable.current_round));
        lstBook.add(new Book("Force", R.drawable.force_round));
        lstBook.add(new Book("Sound", R.drawable.sound_round));
        lstBook.add(new Book("Frequency", R.drawable.frequency_round));
        lstBook.add(new Book("Radiation", R.drawable.rediation_round));
        lstBook.add(new Book("Resistance", R.drawable.resistance_icon_round));
        lstBook.add(new Book("Power", R.drawable.power_round));
        lstBook.add(new Book("BMI", R.drawable.bmi_round));
        lstBook.add(new Book("Solution", R.drawable.solution_round));
        lstBook.add(new Book("Angle", R.drawable.angle_round));
        lstBook.add(new Book("Magnet", R.drawable.magnet_round));
        lstBook.add(new Book("Compass", R.drawable.compass2));
        //lstBook.add(new  Book("Sound Meter",R.drawable.soundmeterround));
        lstBook.add(new Book("Cryptography", R.drawable.cryptography_icon));
        lstBook.add(new Book("Ruler", R.drawable.ruler));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstBook);

        myrv.setLayoutManager(new GridLayoutManager(this, 4));

        myrv.setAdapter(myAdapter);


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitMessage = new AlertDialog.Builder(this);
        exitMessage.setTitle("Exit");
        exitMessage.setMessage("Are You Sure You Want To Exit ?");
        exitMessage.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);


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


    /*  public int getScreenOrientation()
    {
        Display getOrient = getWindowManager().getDefaultDisplay();
        int orientation = Configuration.ORIENTATION_UNDEFINED;
        if(getOrient.getWidth()==getOrient.getHeight()){
            orientation = Configuration.ORIENTATION_SQUARE;
        } else{
            if(getOrient.getWidth() < getOrient.getHeight()){
                orientation = Configuration.ORIENTATION_PORTRAIT;
            }else {
                orientation = Configuration.ORIENTATION_LANDSCAPE;
            }
        }
        return orientation;
    }*/
}
