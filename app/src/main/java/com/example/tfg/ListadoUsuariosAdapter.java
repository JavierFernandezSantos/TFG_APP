package com.example.tfg;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListadoUsuariosAdapter extends RecyclerView.Adapter<ListadoUsuariosAdapter.ViewHolder>{

    private List<ArrayList<String>> mData;
    private LayoutInflater mInflater;
    private ListadoAdapter.ItemClickListener mClickListener;


    ListadoUsuariosAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<ArrayList<String>>();
    }

    @NonNull
    @Override
    public ListadoUsuariosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_listado_usuarios_adapter, parent, false);
        return new ListadoUsuariosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<String> linea = mData.get(position);
        holder.tvNombre.setText(linea.get(0));
        holder.tvApellidos.setText(linea.get(1));
        holder.tvPuntos.setText(linea.get(2));
    }

    void setClickListener(ListadoAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(ArrayList<ArrayList<String>> info) {
        mData.addAll(info);
        notifyDataSetChanged();
    }

    public void removeData(ArrayList<ArrayList<String>> info) {
        mData.removeAll(info);
        notifyDataSetChanged();
    }

    ArrayList<String> getItem(int id) {
        return mData.get(id);
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNombre;
        TextView tvApellidos;
        TextView tvPuntos;

        ViewHolder(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellidos = itemView.findViewById(R.id.tvApellidos);
            tvPuntos = itemView.findViewById(R.id.tvPuntos);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}