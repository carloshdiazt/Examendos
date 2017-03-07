package cl.carlos.examendos.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cl.carlos.examendos.R;
import cl.carlos.examendos.models.Supplies;

public class SuppliesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplies);

        long id = getIntent().getLongExtra("id", 0);
        Supplies supplies = Supplies.findById(Supplies.class, id);
        Toast.makeText(this, supplies.getName(), Toast.LENGTH_SHORT).show();

        }
}
