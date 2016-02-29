package com.aditya.girnar.androidactivitydemo.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.aditya.girnar.androidactivitydemo.Model.Vehicle;
import com.aditya.girnar.androidactivitydemo.Module.DaggerVehicleComponent;
import com.aditya.girnar.androidactivitydemo.Module.VehicleComponent;
import com.aditya.girnar.androidactivitydemo.Module.VehicleModule;
import com.aditya.girnar.androidactivitydemo.R;


public class MainActivity extends Activity {


    Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.edittext);
        editText.setText("");

        VehicleComponent component =
                DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();

        vehicle = component.provideVehicle();
        editText.setText("" + vehicle.getSpeed());
//        Button button = (Button) findViewById(R.id.click);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                editText.setText("sam");
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
//            }
//        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


}
