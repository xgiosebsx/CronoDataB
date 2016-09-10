package com.seratic.enterprise.cronodatab;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.seratic.enterprise.cronodatab.Interface.OnClickListListener;
import com.seratic.enterprise.cronodatab.databinding.ActivityDataBindingBinding;
import com.seratic.enterprise.cronodatab.model.Product;

public class DataBindActivity extends AppCompatActivity implements OnClickListListener{

    private AndroidInfoList infos;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        // Set the infos heading
        binding.setHeading(new ListHeading("List Heading"));

        // Set list items
        infos = new AndroidInfoList();
        binding.setInfos(infos);


    }

    @Override
    public void OnRecyclerClickListener(int pos, Product product) {
        startActivity(new Intent(this,DetailProduct.class)
                .putExtra("image",product.getImage())
                .putExtra("name",product.getName())
                .putExtra("price",product.getPrice())
                .putExtra("brand",product.getBrand())
        );
    }

    @BindingAdapter("bind:items")
    public static void bindList(ListView view, ObservableArrayList<Product> list) {
        OnClickListListener onClickListListener = new OnClickListListener() {
            @Override
            public void OnRecyclerClickListener(int pos, Product product) {
                System.out.println("Se preciono el producto:"+product.getName()+" con marca: "+product.getBrand()+" con precio: "+product.getPrice());
            }
        };
        ListAdapter adapter = new ListAdapter(list, onClickListListener);
        view.setAdapter(adapter);
    }
}
