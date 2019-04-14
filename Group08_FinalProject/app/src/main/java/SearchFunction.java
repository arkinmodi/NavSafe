import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.group08_finalproject.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchFunction extends AppCompatActivity {
    private static final String LOG_TAG = SearchFunction.class.getSimpleName();
    public static boolean press;
    public static String s;
    public static String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_function);

        Intersection[] intersections;
        List<String> strIntersection = new ArrayList<>();

        try {
            intersections = ReadIntersections.read();
            SortIntersectionDropDown.sort(intersections, intersections.length);

            for (int i = 0; i < intersections.length; i++) {
                strIntersection.add(intersections.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] dropdownList = new String[strIntersection.size()];
        dropdownList = strIntersection.toArray(dropdownList);

        Spinner dropdownSource = findViewById(R.id.spinner_source);
        Spinner dropdownDest = findViewById(R.id.spinner_dest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dropdownList);
        dropdownSource.setAdapter(adapter);
        dropdownDest.setAdapter(adapter);

        press = false;
    }

    public void readInfo(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        s = "a";
        d = "b";

        press = true;
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
