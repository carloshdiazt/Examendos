package cl.carlos.examendos.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;


import cl.carlos.examendos.data.Queries;
import cl.carlos.examendos.R;
import cl.carlos.examendos.models.Supplies;

/**
 * Created by diazt on 28-02-2017.
 */

public class SuppliesAdapters extends RecyclerView.Adapter<SuppliesAdapters.ViewHolder> {

    private List<Supplies> suppliess = new Queries().notDone();
    private SuppliesClickListener listener;

    public SuppliesAdapters(SuppliesClickListener listener){
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.supplies_item_listing, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Supplies supplies = suppliess.get(position);

        holder.textView.setText(supplies.getName());
        holder.checkBox.setChecked(supplies.isDone());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    final int adapterPsoition = holder.getAdapterPosition();

                    Supplies auxSupplies = suppliess.get(adapterPsoition);
                    auxSupplies.setDone(true);
                    auxSupplies.save();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            suppliess.remove(adapterPsoition);
                            notifyItemRemoved(adapterPsoition);
                        }
                    },100);

                }
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Supplies auxSupplies = suppliess.get(holder.getAdapterPosition());
                listener.clickId(auxSupplies.getId());


            }
        });

    }

    @Override
    public int getItemCount() {
        return suppliess.size();
    }

    public void addSupplies(Supplies supplies){
        suppliess.add(supplies);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBox;
        private final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.listingCb);
            textView = (TextView) itemView.findViewById(R.id.listingTv);
        }
    }
}
