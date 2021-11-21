package com.example.tfg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListadoAdapter extends RecyclerView.Adapter<ListadoAdapter.ViewHolder> {

    private List<ArrayList<String>> mData;
    private LayoutInflater mInflater;

    ListadoAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<ArrayList<String>>();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_listado_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<String> linea = mData.get(position);
        holder.tvInfoLocal.setText(linea.get(0));
        holder.tvScoreLocal.setText(linea.get(1));
        holder.tvScoreVisitante.setText(linea.get(2));
        holder.tvInfoVisitante.setText(linea.get(3));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(ArrayList<ArrayList<String>> info) {
        mData.addAll(info);
        notifyDataSetChanged();
    }

    ArrayList<String> getItem(int id) {
        return mData.get(id);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInfoLocal;
        TextView tvInfoVisitante;
        TextView tvScoreLocal;
        TextView tvScoreVisitante;

        ViewHolder(View itemView) {
            super(itemView);
            tvInfoLocal = itemView.findViewById(R.id.idEquipoLocal);
            tvInfoVisitante = itemView.findViewById(R.id.idEquipoVisitante);
            tvScoreLocal = itemView.findViewById(R.id.idScoreLocal);
            tvScoreVisitante = itemView.findViewById(R.id.idScoreVisitante);
            itemView.setOnClickListener((View.OnClickListener) this);
        }
    }
}