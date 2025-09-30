package com.example.tp3hugo.ui.busqueda;

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

public class Busqueda_Fragment extends Fragment {

    private BusquedaViewModel mViewModel;

    public static Busqueda_Fragment newInstance() {
        return new Busqueda_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_busqueda_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BusquedaViewModel.class);
        //
    }
    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        BusquedaViewModel vm = new ViewModelProvider(
                this,
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())
        ).get(BusquedaViewModel.class);

        EditText etCodigo = v.findViewById(R.id.etBuscarCodigo);
        Button btnBuscar  = v.findViewById(R.id.btnBuscar);

        vm.mensaje.observe(getViewLifecycleOwner(),
                msg -> Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show());

        vm.navDetalle.observe(getViewLifecycleOwner(),
                args -> androidx.navigation.fragment.NavHostFragment
                        .findNavController(this).navigate(R.id.detalleProductoFragment, args));

        btnBuscar.setOnClickListener(x -> vm.buscar(etCodigo.getText().toString()));
    }

}