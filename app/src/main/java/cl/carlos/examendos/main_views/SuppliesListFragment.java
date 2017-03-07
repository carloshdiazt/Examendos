package cl.carlos.examendos.main_views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.carlos.examendos.R;
import cl.carlos.examendos.adapters.SuppliesAdapters;
import cl.carlos.examendos.adapters.SuppliesClickListener;
import cl.carlos.examendos.details.SuppliesActivity;

import cl.carlos.examendos.models.Supplies;


/**
 * A placeholder fragment containing a simple view.
 */
public class SuppliesListFragment extends Fragment implements SuppliesClickListener {

    private SuppliesAdapters adapters;

    public SuppliesListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listingRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapters = new SuppliesAdapters(this);
        recyclerView.setAdapter(adapters);
    }

    public void addSupplies(Supplies supplies){
        adapters.addSupplies(supplies);
    }


    @Override
    public void clickId(long id) {
        Intent intent = new Intent(getActivity(), SuppliesActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);

    }

    @Override
    public void clickSupplies(Supplies supplies) {

    }
}
