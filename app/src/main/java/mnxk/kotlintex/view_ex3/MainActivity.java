package mnxk.kotlintex.view_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mnxk.kotlintex.view_ex3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadList();
        holdDismiss();
    }

    private void loadList() {
        // Prepare the data
        String[] data = {"Laptop 1", "Laptop 2", "Laptop 3", "Laptop 4", "Laptop 5", "Laptop 6",
                "Laptop 7", "Laptop 8", "Laptop 9", "Laptop 10", "Laptop 11", "Laptop 12","Laptop 1",
                "Laptop 2", "Laptop 3", "Laptop 4", "Laptop 5", "Laptop 6",
                "Laptop 7", "Laptop 8", "Laptop 9", "Laptop 10", "Laptop 11", "Laptop 12"};
        String [] foodList = getResources().getStringArray(R.array.foodList);
        // add the data to the adapter
        List<String> modifiedList = new ArrayList<>(Arrays.asList(foodList));
        // create an adapter
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                modifiedList
        );

        // set the adapter
        binding.listView.setAdapter(adapter);
    }

//    private void holdDismiss() {
//        binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
////                binding.listView.setVisibility(View.GONE);
//                Toast.makeText(
//                        MainActivity.this,
//                        "Clear item: " + position,
//                        Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//        binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                adapter.remove(adapter.getItem(position));
//                adapter.notifyDataSetChanged();
//                return true;
//            }
//        });
//    }
    private void holdDismiss() {
        binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        "Clear item: " + position,
                        Toast.LENGTH_SHORT).show();
                adapter.remove(adapter.getItem(position));
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}