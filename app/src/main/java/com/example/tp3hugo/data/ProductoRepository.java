package com.example.tp3hugo.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp3hugo.modelo.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductoRepository {
    private static ProductoRepository instancia;

    private final ArrayList<Producto> productos = new ArrayList<>();
    private final MutableLiveData<List<Producto>> productosEnVivo = new MutableLiveData<>();

    private ArrayList<Producto> mirror;

    private ProductoRepository(){
        publicar();
    }

    public static synchronized ProductoRepository get(){
        if (instancia == null) instancia = new ProductoRepository();
        return instancia;
    }

    public void setMirror(ArrayList<Producto> externo){
        this.mirror = externo;
        sincronizarmirror();
    }
    private void sincronizarmirror(){
        if(mirror!=null){
            mirror.clear();
            mirror.addAll(productos);
        }
    }
    private void publicar(){
        productosEnVivo.setValue(Collections.unmodifiableList(new ArrayList<>(productos)));
        sincronizarmirror();
    }
    public LiveData<List<Producto>> getProductos(){
        return productosEnVivo;
    }
    public boolean existeCodigo(String codigo){
        if(codigo ==null)return false;
        for(Producto producto : productos){
            if (codigo.equalsIgnoreCase(producto.getCodigo())){
                return true;
            }
        }return false;
    }
    public void agregar(Producto producto){
        if(producto == null){
            throw new IllegalArgumentException("Producto nulo.");
        }
        if(producto.getCodigo()==null|| producto.getCodigo().trim().isEmpty()){
            throw new IllegalArgumentException("El Codigo es obligatorio.");
        }
        if (producto.getDescripcion() == null || producto.getDescripcion().trim().isEmpty()) {
            throw  new IllegalArgumentException("La Descripcion es obligatoria.");
        }
        if(producto.getPrecio() <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        if (existeCodigo(producto.getCodigo())) {
            throw new IllegalArgumentException("Ya existe un producto con ese codigo.");
        }
        productos.add(producto);
        productos.sort(Comparator.comparing(Producto::getDescripcion, String.CASE_INSENSITIVE_ORDER));
        publicar();
    }
}
