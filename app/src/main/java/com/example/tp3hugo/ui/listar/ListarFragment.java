package com.example.tp3hugo.ui.listar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3hugo.R;

public class ListarFragment extends Fragment {

    private ProductoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        RecyclerView rv = v.findViewById(R.id.recyclerProductos); // <-- debe existir en el XML
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new ProductoAdapter();
        rv.setAdapter(adapter);

        // usar ListarViewModel (sin "owner:")
        ListarViewModel vm = new ViewModelProvider(this).get(ListarViewModel.class);
        vm.getProductos().observe(getViewLifecycleOwner(), adapter::submit);
    }
}


