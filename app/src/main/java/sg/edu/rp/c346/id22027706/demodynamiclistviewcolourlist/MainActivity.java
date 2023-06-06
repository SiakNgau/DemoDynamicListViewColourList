package sg.edu.rp.c346.id22027706.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTextColour;
    EditText etIndex;
    Button btnAdd;
    ListView lvColour;
    ArrayAdapter<String> aaColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTextColour = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndex = findViewById(R.id.editTextIndex);

        ArrayList<String> alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColours = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColours);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etIndex.getText().toString().isEmpty()) {
                    String colour = etTextColour.getText().toString();
                    alColours.add(colour);
                    aaColours.notifyDataSetChanged();
                } else {
                    String colour = etTextColour.getText().toString();
                    String indexStr = etIndex.getText().toString();
                    int index = Integer.parseInt(indexStr);
                    alColours.add(index, colour);
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String colour = alColours.get(position);

            Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();    }
        });

    }
}