package com.seratic.enterprise.cronodatab;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.seratic.enterprise.cronodatab.Interface.OnClickListListener;
import com.seratic.enterprise.cronodatab.databinding.ItemListBinding;
import com.seratic.enterprise.cronodatab.model.Product;

public class ListAdapter extends BaseAdapter {
    private ObservableArrayList<Product> list;
    private LayoutInflater inflater;
    OnClickListListener onClickListListener;

    public ListAdapter(ObservableArrayList<Product> l,OnClickListListener onClickListListener) {
        list = l;
        this.onClickListListener = onClickListListener;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        ItemListBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_list, parent, false);
        binding.setProduct(list.get(position));

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListListener.OnRecyclerClickListener(position,list.get(position));
            }
        });

        return binding.getRoot();
    }
}
