package com.sin.com.carpedia;

/**
 * Created by sin on 12/9/16.
 */


        import java.util.List;
        import com.sin.com.carpedia.R;
        import com.sin.com.carpedia.RowItem;
        import android.app.Activity;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

public class CustomList extends ArrayAdapter<RowItem> {

    Context context;

    public CustomList(Context context, int resourceId,
                                 List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageid;
        TextView company;
        TextView name;
        TextView price;
        TextView temp;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.single_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.company = (TextView) convertView.findViewById(R.id.company);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.imageid = (ImageView) convertView.findViewById(R.id.imageid);
            holder.temp = (TextView) convertView.findViewById(R.id.textView3);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.name.setText(rowItem.getname());
        holder.company.setText(rowItem.getcompany());
        holder.price.setText(rowItem.getprice());
        holder.imageid.setImageResource(rowItem.getimageid());
        holder.imageid.setTag(String.valueOf(rowItem.getimageid()));
        String resource = (String) holder.imageid.getTag();
        holder.temp.setText(resource);

        return convertView;
    }
}