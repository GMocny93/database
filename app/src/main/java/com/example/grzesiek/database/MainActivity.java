package com.example.grzesiek.database;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView newTxt = (TextView) findViewById(R.id.tekst);


        DatabaseHandler db = new DatabaseHandler(this);


        Log.d("Insert: ", "Inserting... ");
        db.addInformation(new information("Grzesiek", 184, 121.8 , 100.0, 25,2018 ));





        Log.d("Reading: ", "Reading all information... ");
        List<information> information = db.getAllInformation();

        for (information inf : information) {
            String log = "id: " + inf.getId() + ", name: " + inf.getName() + ", height"
                    + inf.getHeight() + ", weight: " + inf.getWeight() + ", target weight: "
                    + inf.getTargetWeight() + ", age: " + inf.getAge() + ", year: " + inf.getYear()  ;
            Log.d("Data", log);

            newTxt.setText("Witaj " + inf.getName() + "! \n Przy swoim wzroscie roznwym " + inf.getHeight()
                    + " w wieku " + inf.getAge() + " ważysz " + inf.getWeight() + ". Jednak Twoim celem jest waga rowna "
                    + inf.getTargetWeight() + ",\n \n rok " + inf.getYear() + ".");
        }



    }
}
