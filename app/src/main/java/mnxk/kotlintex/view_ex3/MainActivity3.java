package mnxk.kotlintex.view_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import mnxk.kotlintex.adapters.BeerAdapter;
import mnxk.kotlintex.models.Beers;
import mnxk.kotlintex.view_ex3.databinding.ActivityMain3Binding;

public class MainActivity3
        extends AppCompatActivity {

    ActivityMain3Binding binding;

    BeerAdapter adapter;

    ArrayList<Beers> beers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
        loadData();
        addEvents();
    }

    private void initData() {
        beers = new ArrayList<>();
        beers.add(new Beers(R.drawable.beer333, "Beer 333",
                            20000.0));
        beers.add(new Beers(R.drawable.hanoi, "Beer " + "Hanoi", 25000.0));
        beers.add(new Beers(R.drawable.saigon, "Beer " + "Saigon", 30000.0));
        beers.add(new Beers(R.drawable.tiger, "Beer " + "Tiger", 35000.0));
        beers.add(new Beers(R.drawable.larue, "Beer " + "Larue", 40000.0));
        beers.add(new Beers(R.drawable.sapporo,
                            "Beer " + "Sapporo", 45000.0));
    }

    private void loadData() {
        adapter = new BeerAdapter(
                MainActivity3.this,
                R.layout.item_layout,
                beers
        );
        binding.listViewBeers.setAdapter(adapter);
    }

    private void addEvents() {
        binding.listViewBeers.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(
                    MainActivity3.this,
                    beers.get(position).getBeerName() + " - " + Math.round(beers.get(position).getBeerPrice()) + " VND",
                    Toast.LENGTH_SHORT).show();
        });
        binding.listViewBeers.setOnItemLongClickListener((parent, view, position, id) -> {
            adapter.remove(adapter.getItem(position));
            adapter.notifyDataSetChanged();
            Toast.makeText(
                    MainActivity3.this,
                    "Cleared " + beers.get(position).getBeerName(),
                    Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}