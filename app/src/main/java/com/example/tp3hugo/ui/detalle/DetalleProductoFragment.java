package com.example.tp3hugo.ui.detalle;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tp3hugo.R;

public class DetalleProductoFragment extends Fragment {

    private DetalleProductoViewModel mViewModel;

    public static DetalleProductoFragment newInstance() {
        return new DetalleProductoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_producto, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetalleProductoViewModel.class);
    }
    @Override
    public void onViewCreated(@NonNull View v,@Nullable Bundle s){
        super.onViewCreated(v,s);
        TextView tvDesc = v.findViewById(R.id.tvDetDescripcion);
        TextView tvCod = v.findViewById(R.id.tvDetCodigo);
        TextView tvPre = v.findViewById(R.id.tvDetPrecio);
        Bundle a = getArguments();
        tvDesc.setText(a.getString("Descripcion"));
        tvCod.setText(getString(R.string.codigo_fmt, a.getString("Codigo")));
        tvPre.setText(getString(R.string.precio_fmt, a.getDouble("Precio")));
    }
}