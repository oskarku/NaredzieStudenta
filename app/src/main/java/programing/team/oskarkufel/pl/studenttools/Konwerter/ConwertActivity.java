package programing.team.oskarkufel.pl.studenttools.Konwerter;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.RETOFIT.API.ApiService;
import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.RETOFIT.Rate;
import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.RETOFIT.RateList;
import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.RETOFIT.RetroClient;
import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.Weight;
import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.WeightAdapter;
import programing.team.oskarkufel.pl.studenttools.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConwertActivity extends AppCompatActivity {
    private ViewModelConverter viewModelConverter;
    private List<String> listUnit = new ArrayList<String>();
    private ArrayList<Rate> rateList;
    private  ArrayList<RateList> arrayRateList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private ConwertAdapterWalute eAdapterWaluta;
    private List<Weight> listWeight;
    private EditText valueEdittext;

    private Button butonConvwerter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conwert);
        setTitle("StudentTool Konwerter");



        rateList = new ArrayList<Rate>();
        arrayRateList = new ArrayList<RateList>();
        listWeight = new ArrayList<Weight>();

        valueEdittext=(EditText) findViewById(R.id.edit_text_value);


        viewModelConverter =  ViewModelProviders.of(this).get(ViewModelConverter.class);

        butonConvwerter = (Button) findViewById(R.id.button_convert);



        Spinner spinnerChoceCategory = (Spinner) findViewById(R.id.spinner_category);

        // Spinner click listener
        spinnerChoceCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                String item = parent.getItemAtPosition(position).toString();

                Resources res = getResources();
                //dlugosc, waga, objetosc waluty
                String[] categoryList = res.getStringArray(R.array.category_option);

                if(item.equals(categoryList[0])){
                    viewModelConverter.setIsLenght(true);
                    viewModelConverter.setIsVolume(false);
                    viewModelConverter.setIsCorrengeWalute(false);
                    viewModelConverter.setIsWeight(false);

                }

                else if(item.equals(categoryList[1])){
                    viewModelConverter.setIsWeight(true);
                    viewModelConverter.setIsVolume(false);
                    viewModelConverter.setIsCorrengeWalute(false);
                    viewModelConverter.setIsLenght(false);

                }

                else if (item.equals(categoryList[2])){

                    viewModelConverter.setIsVolume(true);
                    viewModelConverter.setIsLenght(false);
                    viewModelConverter.setIsCorrengeWalute(false);
                    viewModelConverter.setIsWeight(false);

                }

                else if(item.equals(categoryList[3])){


                    viewModelConverter.setIsCorrengeWalute(true);
                    viewModelConverter.setIsWeight(false);
                    viewModelConverter.setIsLenght(false);
                    viewModelConverter.setIsVolume(false);







                }


                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });



        ArrayAdapter<CharSequence> adapterChangeCategory = ArrayAdapter.createFromResource(this,
                R.array.category_option, android.R.layout.simple_spinner_item);

        // Drop down layout style - list view with radio button
        adapterChangeCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerChoceCategory.setAdapter(adapterChangeCategory);


        Spinner spinnerChangeValue = (Spinner) findViewById(R.id.spinner_count);



        spinnerChangeValue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(),"Wybralem "+item, Toast.LENGTH_SHORT).show();


                //[gr,dag,kg,t]


                if(viewModelConverter.getIsWeight().getValue()!=null && viewModelConverter.getIsWeight().getValue()){


                    if(item.equalsIgnoreCase(getResources().getStringArray(R.array.unit_weight)[0])){

                        if(listWeight!=null && listWeight.isEmpty()==false){
                            listWeight.clear();
                        }


                        Weight weightG = new Weight(Weight.KEY_G,  Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_G );
                        Weight weightdag = new Weight(Weight.KEY_G, Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_DAG);
                        Weight weightKG = new Weight(Weight.KEY_G,Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_KG);
                        Weight weightT = new Weight(Weight.KEY_G,Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_T);

                        listWeight.add(weightG);
                        listWeight.add(weightdag);
                        listWeight.add(weightKG);
                        listWeight.add(weightT);

                    }

                    else if (item.equalsIgnoreCase(getResources().getStringArray(R.array.unit_weight)[1])){
                        if(listWeight!=null && listWeight.isEmpty()==false){
                            listWeight.clear();
                        }


                        Weight weightG = new Weight(Weight.KEY_DAG,  Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_G );
                        Weight weightdag = new Weight(Weight.KEY_DAG, Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_DAG);
                        Weight weightKG = new Weight(Weight.KEY_DAG,Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_KG);
                        Weight weightT = new Weight(Weight.KEY_DAG,Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_T);

                        listWeight.add(weightG);
                        listWeight.add(weightdag);
                        listWeight.add(weightKG);
                        listWeight.add(weightT);





                    }



                    else if (item.equalsIgnoreCase(getResources().getStringArray(R.array.unit_weight)[2])){
                        if(listWeight!=null && listWeight.isEmpty()==false){
                            listWeight.clear();
                        }


                        Weight weightG = new Weight(Weight.KEY_KG,  Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_G );
                        Weight weightdag = new Weight(Weight.KEY_KG, Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_DAG);
                        Weight weightKG = new Weight(Weight.KEY_KG,Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_KG);
                        Weight weightT = new Weight(Weight.KEY_KG,Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_T);

                        listWeight.add(weightG);
                        listWeight.add(weightdag);
                        listWeight.add(weightKG);
                        listWeight.add(weightT);

                    }


                    else if (item.equalsIgnoreCase(getResources().getStringArray(R.array.unit_weight)[3])){
                        if(listWeight!=null && listWeight.isEmpty()==false){
                            listWeight.clear();
                        }


                        Weight weightG = new Weight(Weight.KEY_T,  Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_G );
                        Weight weightdag = new Weight(Weight.KEY_T, Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_DAG);
                        Weight weightKG = new Weight(Weight.KEY_T,Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_KG);
                        Weight weightT = new Weight(Weight.KEY_T,Float.parseFloat(valueEdittext.getText().toString()), Weight.KEY_T);

                        listWeight.add(weightG);
                        listWeight.add(weightdag);
                        listWeight.add(weightKG);
                        listWeight.add(weightT);




                    }




                }

                else if(viewModelConverter.getIsCorrengeWalute().getValue()!=null && viewModelConverter.getIsCorrengeWalute().getValue()){
                    pDialog = new ProgressDialog(ConwertActivity.this);
                    pDialog.setIndeterminate(false);
                    pDialog.setCancelable(true);

                    ApiService api = RetroClient.getApiService();


                    if(item.equalsIgnoreCase(getResources().getStringArray(R.array.unit_walute)[0])){


                        pDialog.setMessage("Laduje dane z serwera NBP i przeliczam EUR");
                        pDialog.show();


                                                //Creating an object of our api interface


                        Call<RateList> callEur = api.getMyJSONeur();

                        callEur.enqueue(new Callback<RateList>() {
                            @Override
                            public void onResponse(Call<RateList> call, Response<RateList> response) {
                                pDialog.dismiss();

                                Log.d("loadingData", "caly czas sie locze");


                                if (response.isSuccessful()) {
                                    /**
                                     * Got Successfully
                                     */

                                    if((rateList!=null && rateList.isEmpty()==false) && (arrayRateList!=null && arrayRateList.isEmpty()==false)){
                                        rateList.clear();
                                        arrayRateList.clear();
                                    }

                                    rateList.addAll(response.body().getRates());
                                    arrayRateList.add(response.body());



                                }
                            }

                            @Override
                            public void onFailure(Call<RateList> call, Throwable t) {
                                pDialog.dismiss();
                                Log.d("requestLoczeniu", t.getMessage());

                            }
                        });






                    }


                    else if(item.equalsIgnoreCase(getResources().getStringArray(R.array.unit_walute)[1])){

                        pDialog.setMessage("Laduje dane z serwera NBP i przeliczam dolary");
                        pDialog.show();


                        Call<RateList> callUsd = api.getMyJSONusd();

                        callUsd.enqueue(new Callback<RateList>() {
                            @Override
                            public void onResponse(Call<RateList> call, Response<RateList> response) {
                                pDialog.dismiss();

                                Log.d("loadingData", "caly czas sie locze");


                                if (response.isSuccessful()) {
                                    /**
                                     * Got Successfully
                                     */

                                    if((rateList!=null && rateList.isEmpty()==false) && (arrayRateList!=null && arrayRateList.isEmpty()==false)){
                                        rateList.clear();
                                        arrayRateList.clear();
                                    }

                                    rateList.addAll(response.body().getRates());
                                    arrayRateList.add(response.body());



                                }
                            }

                            @Override
                            public void onFailure(Call<RateList> call, Throwable t) {
                                pDialog.dismiss();
                                Log.d("requestLoczeniu", t.getMessage());

                            }
                        });


                    }


                    else if (item.equalsIgnoreCase(getResources().getStringArray(R.array.unit_walute)[2])){



                        pDialog.setMessage("Laduje dane z serwera NBP i przeliczam franki");
                        pDialog.show();


                        Call<RateList> callChf = api.getMyJSONchf();

                        callChf.enqueue(new Callback<RateList>() {
                            @Override
                            public void onResponse(Call<RateList> call, Response<RateList> response) {
                                pDialog.dismiss();

                                Log.d("loadingData", "caly czas sie locze");


                                if (response.isSuccessful()) {
                                    /**
                                     * Got Successfully
                                     */

                                    if((rateList!=null && rateList.isEmpty()==false) && (arrayRateList!=null && arrayRateList.isEmpty()==false)){
                                        rateList.clear();
                                        arrayRateList.clear();
                                    }

                                    rateList.addAll(response.body().getRates());
                                    arrayRateList.add(response.body());



                                }
                            }

                            @Override
                            public void onFailure(Call<RateList> call, Throwable t) {
                                pDialog.dismiss();
                                Log.d("requestLoczeniu", t.getMessage());

                            }
                        });





                    }
                }









            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });















        int lenggtArray = getResources().getStringArray(R.array.unit_leight).length;

        for (int i = 0; i < lenggtArray ; i++) {
            listUnit.add(getResources().getStringArray(R.array.unit_leight)[i]);

        }





        final Observer<Boolean> correngeWaluteObserve = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
             if(aBoolean){

                 valueEdittext.setHint("wprowadz ilosc zlotowek");
                 listUnit.clear();
                 int lenggtArray = getResources().getStringArray(R.array.unit_walute).length;

                 for (int i = 0; i < lenggtArray ; i++) {
                     listUnit.add(getResources().getStringArray(R.array.unit_walute)[i]);

                 }



                butonConvwerter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        recyclerView = (RecyclerView) findViewById(R.id.recycrel_view_info);

                        if(valueEdittext.getText()!=null){
                            eAdapterWaluta = new ConwertAdapterWalute(rateList, arrayRateList, Float.parseFloat(valueEdittext.getText().toString()));
                            RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(eLayoutManager);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                            recyclerView.setAdapter(eAdapterWaluta);
                        }
                        else{

                            Context context = getApplicationContext();
                            CharSequence text = "Nie wprowadziles zadnej wartosci";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }






                    }
                });











             }

            }
        };


        viewModelConverter.getIsCorrengeWalute().observe(this,correngeWaluteObserve);



        final Observer<Boolean> unitLenghtObserve = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    listUnit.clear();
                    int lenggtArray = getResources().getStringArray(R.array.unit_leight).length;

                    for (int i = 0; i < lenggtArray ; i++) {
                        listUnit.add(getResources().getStringArray(R.array.unit_leight)[i]);

                    }


                }

            }
        };
        viewModelConverter.getIsLenght().observe(this,unitLenghtObserve);


        final Observer<Boolean> unitValuesObserve = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    listUnit.clear();
                    int lenggtArray = getResources().getStringArray(R.array.unit_volume).length;

                    for (int i = 0; i < lenggtArray ; i++) {
                        listUnit.add(getResources().getStringArray(R.array.unit_volume)[i]);

                    }


                }

            }
        };
        viewModelConverter.getIsVolume().observe(this,unitValuesObserve);



        final Observer<Boolean> unitWeightObserve = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    listUnit.clear();
                    int lenggtArray = getResources().getStringArray(R.array.unit_weight).length;

                    for (int i = 0; i < lenggtArray ; i++) {
                        listUnit.add(getResources().getStringArray(R.array.unit_weight)[i]);

                    }


                    butonConvwerter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            recyclerView = (RecyclerView) findViewById(R.id.recycrel_view_info);
                            WeightAdapter weightAdapter = new WeightAdapter(listWeight);

                            RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(eLayoutManager);
                            recyclerView.setAdapter(weightAdapter);


                            Context context = getApplicationContext();
                            CharSequence text = "Hello toast!"+ listWeight.get(0).getGoalConwertType();
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    });


                }

            }
        };
        viewModelConverter.getIsWeight().observe(this,unitWeightObserve);


        ArrayAdapter<String> adapterValueUnit = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listUnit);
        adapterValueUnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChangeValue.setAdapter(adapterValueUnit);


    }




}
