package programing.team.oskarkufel.pl.studenttools.Konwerter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.RETOFIT.Rate;
import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.RETOFIT.RateList;
import programing.team.oskarkufel.pl.studenttools.R;

public class ConwertAdapterWalute extends RecyclerView.Adapter<ConwertAdapterWalute.CustomViewHolder>  {
    private List<Rate> rateList;
    private List<RateList> rateListC;
    private float value;

    public ConwertAdapterWalute(List<Rate> rates, List<RateList> rateListC, float value){
        this.rateList = rates;
        this.rateListC=rateListC;
        this.value = value;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_position_list_value, parent, false);

        return new CustomViewHolder(itemView);




    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int index) {

        Rate rate = rateList.get(index);
        RateList rateListL = rateListC.get(index);
        holder.textViewCode.setText(rateListL.getCurrency()+"\n"+"kurrs: "+rate.getMid());

        if(rate.getMid()>1){
            holder.textViewValueWalute.setText(""+value/rate.getMid());
        }
        else if (rate.getMid()<1){

            holder.textViewValueWalute.setText(""+value*rate.getMid());

        }


    }

    @Override
    public int getItemCount() {
        return rateList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCode, textViewValueWalute;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCode = (TextView) itemView.findViewById(R.id.text_view_unit);
            textViewValueWalute = (TextView) itemView.findViewById(R.id.text_view_value);

        }
    }
}
