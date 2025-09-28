package com.example.tp3hugo.ui.cargar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp3hugo.data.ProductoRepository;
import com.example.tp3hugo.modelo.Producto;

public class CargarViewModel extends AndroidViewModel {
    private final ProductoRepository repo = ProductoRepository.get();
    private final MutableLiveData<String> mensaje = new MutableLiveData<>();
    private final MutableLiveData<Boolean> altaOk = new MutableLiveData<>();

    public LiveData<String> getMensaje(){
        return mensaje;
    }
    public LiveData<Boolean> getAltaOk(){
        return altaOk;
    }
    public CargarViewModel(@NonNull Application app) {
        super(app);
    }
    public void agregar(String codigo, String descripcion, String preciosStr){
        try{
            if(codigo == null || codigo.trim().isEmpty()|| descripcion==null || descripcion.trim().isEmpty() || preciosStr == null || preciosStr.trim().isEmpty()){
                mensaje.postValue("Complete todos los campos.");
                return;
            }
            double precio = Double.parseDouble(preciosStr);
            repo.agregar(new Producto(codigo.trim(), descripcion.trim(), precio));
            altaOk.postValue(true);
            mensaje.postValue("Producto agregado.");
        } catch (NumberFormatException ex){
            mensaje.postValue("El precio debe ser numerico.");
        }catch (IllegalArgumentException ex){
            mensaje.postValue(ex.getMessage());
        }
    }

}