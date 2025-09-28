package com.example.tp3hugo.ui.cargar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp3hugo.R;

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cargar, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        //
        EditText etCodigo = view.findViewById(R.id.etCodigo);
        EditText etDescripcion = view.findViewById(R.id.etDescripcion);
        EditText etPrecio = view.findViewById(R.id.etPrecio);
        Button btnGuardar = view.findViewById(R.id.btnGuardar);

        mViewModel.getMensaje().observe(getViewLifecycleOwner(),msg->{
            if(msg != null && !msg.isEmpty()){
                Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show();
            }
        });
        mViewModel.getAltaOk().observe(getViewLifecycleOwner(),ok ->{
            if(Boolean.TRUE.equals(ok)){
                etCodigo.setText("");
                etDescripcion.setText("");
                etPrecio.setText("");
            }
        });
        btnGuardar.setOnClickListener(v ->
                mViewModel.agregar(
                        etCodigo.getText().toString(),
                        etDescripcion.getText().toString(),
                        etPrecio.getText().toString()
                )
        );
    }

}