package sg.edu.rp.c346.id18015059.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnGo;

    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinnerCat);
        spn2 = findViewById(R.id.spinnerSCAT);
        btnGo = findViewById(R.id.buttonGo);

        alCategory = new ArrayList<>();
        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);

        spn2.setAdapter(aaCategory);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alCategory.clear();
                if (position == 0){
                    String[] strCAT = getResources().getStringArray(R.array.rp_types);
                    alCategory.addAll(Arrays.asList(strCAT));
                }
                else{
                    String[] strSCAT = getResources().getStringArray(R.array.soi_types);
                    alCategory.addAll(Arrays.asList(strSCAT));
                }
                aaCategory.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = null;

                if (spn1.getSelectedItemPosition() == 0)
                {
                    if (spn2.getSelectedItemPosition() == 0)
                    {
                        url = "https://www.rp.edu.sg/";
                    }
                    else
                    {
                        url = "https://www.rp.edu.sg/student-life";
                    }
                }
                else if (spn1.getSelectedItemPosition() == 1)
                {
                    if (spn2.getSelectedItemPosition() == 0)
                    {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    }
                    else
                    {
                        url = "https://www.rp.edu.sg/soi/full-time-diploma/details/r12";

                    }
                }
                Intent intent = new Intent(MainActivity.this, WebView.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });*/

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WebActivity.class);


                String[][] sites = {
                        {
                                "https://www.rp.edu.sg/",
                                "Homepage",
                        },
                        {
                                "https://www.rp.edu.sg/student-life",
                                "Student Life",
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "DMSD",
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12",
                                "DIT",
                        },
                };
                String getURL = sites[spn2.getSelectedItemPosition()][spn1.getSelectedItemPosition()];
                intent.putExtra("Value",getURL);
                startActivity(intent);
            }
        });
    }
}
