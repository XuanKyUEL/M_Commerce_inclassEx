package mnxk.kotlintex.view_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import mnxk.kotlintex.models.Product;
import mnxk.kotlintex.view_ex3.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    ArrayAdapter<Product> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAdapter();
        addEvents();
    }

    private void initAdapter() {
        adapter = new ArrayAdapter<>(
                MainActivity2.this,
                android.R.layout.simple_list_item_1
        );
        binding.pdlistView.setAdapter(adapter);
    }

    private void addEvents() {
        binding.btnaddproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get data from edit text
                String name = binding.edtproductname.getText().toString();
                double price = Double.parseDouble(binding.edtproductprice.getText().toString());

                // create a product
                Product product = new Product(name, price);
                adapter.add(product);
            }
        });

        binding.pdlistView.setOnItemClickListener((parent, view, position, id) -> {
            Product p = adapter.getItem(position);
            Toast.makeText(MainActivity2.this,
                           p.getName() + " - " + p.getPrice() + " VND",
                           Toast.LENGTH_SHORT).show();
        });

        binding.pdlistView.setOnItemLongClickListener((parent, view, position, id) -> {
            adapter.remove(adapter.getItem(position));
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}