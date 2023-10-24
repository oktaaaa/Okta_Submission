package com.example.okta_submission;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAnimalAdapter extends RecyclerView.Adapter<ListAnimalAdapter.ListViewHolder> {
        private ArrayList<Animal> listAnimal;

        public ListAnimalAdapter(ArrayList<Animal>list){
                this.listAnimal = list;
        }
        @NonNull
        @Override
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_animals, parent, false);
                return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
                Animal animal = listAnimal.get(position);
                holder.imgPhoto.setImageResource(animal.getPhoto());
                holder.tvName.setText(animal.getName());
                holder.tvDescription.setText(animal.getDescription());
        }

        @Override
        public int getItemCount() {

                return  listAnimal.size();
        }

        public class ListViewHolder extends RecyclerView.ViewHolder {
                ImageView imgPhoto;
                TextView tvName, tvDescription;
                public ListViewHolder(@NonNull View itemView) {
                        super(itemView);
                        imgPhoto = itemView.findViewById(R.id.img_item_photo);
                        tvName = itemView.findViewById(R.id.tv_item_name);
                        tvDescription = itemView.findViewById(R.id.tv_item_description);
                }
        }
}
