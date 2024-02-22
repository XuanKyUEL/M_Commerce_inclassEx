package mnxk.kotlintex.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mnxk.kotlintex.models.Beers;
import mnxk.kotlintex.view_ex3.R.id;

public class BeerAdapter extends BaseAdapter {

    Activity context;
    int item_Layout;
    List<Beers> list;

    // Constructor
    public BeerAdapter(
            Activity context,
            int item_Layout,
            List<Beers> list
    ) {
        this.context = context;
        this.item_Layout = item_Layout;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(
            int position,
            View convertView,
            ViewGroup parent
    ) {
        ViewHolder holder;
        if (convertView == null) {
            // Inflate the layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    context.LAYOUT_INFLATER_SERVICE
            );
            holder = new ViewHolder();
            convertView = inflater.inflate(item_Layout, null);
            holder.imgproduct =
                    convertView.findViewById(id.imgproduct);
            holder.tvproductname =
                    convertView.findViewById(id.tvproductname);
            holder.tvprodcutprice = convertView.findViewById(id.tvproductprice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // Set the data
        Beers beers = list.get(position);
        holder.imgproduct.setImageResource(beers.getBeerThumb());
        holder.tvproductname.setText(beers.getBeerName());
        holder.tvprodcutprice.setText(beers.getBeerPrice() + " VND");
        return convertView;
    }

    // Create a view holder
    static class ViewHolder {
        // Declare the views
        ImageView imgproduct;
        TextView tvproductname, tvprodcutprice;
    }
}
