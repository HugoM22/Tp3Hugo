package com.example.tp3hugo.ui.busqueda;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3hugo.data.ProductoRepository;
import com.example.tp3hugo.modelo.Producto;

public class BusquedaViewModel extends AndroidViewModel {
    //
    private final ProductoRepository repo = ProductoRepository.get();
    private final MutableLiveData<String> _mensaje = new MutableLiveData<>();
    private final MutableLiveData<Bundle> _navDetalle = new MutableLiveData<>();
    public LiveData<String> mensaje = _mensaje;
    public LiveData<Bundle> navDetalle = _navDetalle;

    public BusquedaViewModel(@NonNull Application app){
        super(app);
    }
    public void resetNav() { _navDetalle.setValue(null); }
    public void buscar (String codigo){
        if(codigo==null || codigo.trim().isEmpty()){
            _mensaje.setValue("Ingresar un codigo.");
            return;
        }
        Producto p = repo.buscarPorCodigo(codigo.trim());
        if(p !=null){
            Bundle args = new Bundle();
            args.putString("Codigo", p.getCodigo());
            args.putString("Descripcion", p.getDescripcion());
            args.putDouble("Precio", p.getPrecio());
            _navDetalle.setValue(args);
        }else{
            _mensaje.setValue("No se encontro producto con ese codigo.");
        }
    }

}