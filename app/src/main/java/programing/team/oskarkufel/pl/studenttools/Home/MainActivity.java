package programing.team.oskarkufel.pl.studenttools.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import programing.team.oskarkufel.pl.studenttools.Kalkulator.CalckActivity;
import programing.team.oskarkufel.pl.studenttools.Konwerter.ConwertActivity;
import programing.team.oskarkufel.pl.studenttools.Notatnik.NoteActivity;
import programing.team.oskarkufel.pl.studenttools.R;
import programing.team.oskarkufel.pl.studenttools.Setting.SettingActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private GridLayout mainGrid;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("StudentTool Menu");


        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);








        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent myIntent = new Intent(getBaseContext(),   MainActivity.class);
                                startActivity(myIntent);
                                break;
                            case R.id.navigation_dashboard:
                                Intent myIntentt = new Intent(getBaseContext(),   SettingActivity.class);
                                startActivity(myIntentt);
                                break;

                        }

                        return true;
                    }
                });



    }
    public void goToCalck(View v){
        Intent myIntent = new Intent(getBaseContext(),   CalckActivity.class);
        startActivity(myIntent);
    }
    public void goToConwert(View v){
        Intent myIntent = new Intent(getBaseContext(),   ConwertActivity.class);
        startActivity(myIntent);
    }
    public void goToNote(View v){
        Intent myIntent = new Intent(getBaseContext(),   NoteActivity.class);
        startActivity(myIntent);
    }


    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;


            if(cardView.getId()==R.id.calculator_view){
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getBaseContext(),   CalckActivity.class);
                        startActivity(myIntent);

                    }
                });



            }

            else if(cardView.getId() == R.id.notatnik_view){
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getBaseContext(),   NoteActivity.class);
                        startActivity(myIntent);

                    }
                });


            }

            else if(cardView.getId() == R.id.conwerter_view){
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent myIntent = new Intent(getBaseContext(),   ConwertActivity.class);
                        startActivity(myIntent);

                    }
                });



            }
        }
    }





    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}
