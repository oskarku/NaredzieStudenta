package programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import programing.team.oskarkufel.pl.studenttools.Konwerter.ConwertAdapterWalute;
import programing.team.oskarkufel.pl.studenttools.R;

public class WeightAdapter extends RecyclerView.Adapter<WeightAdapter.CustomViewHolder> {
    private List<Weight> listWeight;

    public WeightAdapter (List<Weight> listW){
        this.listWeight = listW;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_position_list_value, parent, false);

        return new CustomViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        Weight weight = listWeight.get(position);
        holder.conwertString.setText(weight.getGoalConwertType());
        holder.value.setText(Float.toString(weight.getConwertNumber()));


    }

    @Override
    public int getItemCount() {
        return listWeight.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public TextView value, conwertString;
        public CustomViewHolder(@NonNull View view) {
            super(view);
            value = (TextView) view.findViewById(R.id.text_view_value);
            conwertString = (TextView) view.findViewById(R.id.text_view_unit);

        }
    }
}
