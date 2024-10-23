package com.cidead.pmdm.tarealistviewconstrings;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Array de nombres
    String[] nombres = {
            "Carlos", "María", "Pedro", "Lucía", "Javier", "Sofía",
            "Andrés", "Ana", "Juan", "Elena", "Luis", "Paula",
            "Miguel", "Sara", "José", "Laura", "Raúl", "Carmen",
            "Roberto", "Patricia"
    };

    // Array de teléfonos
    String[] telefonos = {
            "555-1234", "555-5678", "555-9012", "555-3456", "555-7890",
            "555-2345", "555-6789", "555-0123", "555-4567", "555-8901",
            "555-1122", "555-3344", "555-5566", "555-7788", "555-9900",
            "555-2233", "555-4455", "555-6677", "555-8899", "555-0011"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombres);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "El teléfono de "+ nombres[position] + " es " + telefonos[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}