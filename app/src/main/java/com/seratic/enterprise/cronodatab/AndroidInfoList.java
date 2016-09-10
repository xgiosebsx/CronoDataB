package com.seratic.enterprise.cronodatab;

import android.databinding.ObservableArrayList;
import android.view.View;

import com.seratic.enterprise.cronodatab.model.Product;

public class AndroidInfoList {
    public ObservableArrayList<Product> list = new ObservableArrayList<>();
    private int mTotalCount;

    public AndroidInfoList() {
        for (mTotalCount = 1; mTotalCount < 11; ++mTotalCount) {
            add(new Product("Producto DataBinding I" + mTotalCount++,"","Precio: "+mTotalCount,"marca: "+mTotalCount));
        }
    }

    public void add(View v) {
        list.add(new Product("Producto DataBinding" + mTotalCount++,"","Precio: "+mTotalCount,"marca: "+mTotalCount));
    }

    public void remove(View v) {
        if (!list.isEmpty()) {
            list.remove(0);
        }
    }

    private void add(Product info) {
        list.add(info);
    }

}
