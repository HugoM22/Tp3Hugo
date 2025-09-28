package com.example.tp3hugo.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3hugo.data.ProductoRepository;
import com.example.tp3hugo.modelo.Producto;

import java.util.List;

public class ListarViewModel extends ViewModel {
    public LiveData<List<Producto>>getProductos(){
        return ProductoRepository.get().getProductos();
    }
}