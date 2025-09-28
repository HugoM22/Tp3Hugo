package com.example.tp3hugo.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3hugo.R;
import com.example.tp3hugo.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.VH> {

    private final List<Producto> items = new ArrayList<>();

    public void submit(List<Producto> nuevos) {
        items.clear();
        if (nuevos != null) items.addAll(nuevos);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Producto p = items.get(position);
        h.tvDescripcion.setText(p.getDescripcion());
        h.tvCodigo.setText("Código: " + p.getCodigo());
        h.tvPrecio.setText(String.format("$ %.2f", p.getPrecio()));
    }

    @Override public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvDescripcion, tvCodigo, tvPrecio;
        VH(@NonNull View itemView) {
            super(itemView);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }
}

