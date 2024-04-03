package com.example.dashboardbottomrizzal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dashboardbottomrizzal.Item;
import com.example.dashboardbottomrizzal.Adapter;
import com.example.dashboardbottomrizzal.R;
import com.example.dashboardbottomrizzal.FragmentKalkulator1;
import com.example.dashboardbottomrizzal.FragmentKalkulator2;
import com.example.dashboardbottomrizzal.FragmentKalkulator3;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Bangun_Ruang extends Fragment implements Adapter.OnItemClickListener{

    RecyclerView recyclerView;
    List<Item> listData;
    Adapter adapter;

    public Fragment_Bangun_Ruang() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bangunruang, container, false);
        recyclerView = rootView.findViewById(R.id.rvDataRuang);
        listData = new ArrayList<>();

        // Menambahkan item dengan urutan yang diinginkan
        Item item1 = new Item();
        item1.setShape("Kubus");
        item1.setImage("https://cdn-icons-png.flaticon.com/512/73/73674.png");
        listData.add(item1);

        Item item2 = new Item();
        item2.setShape("Balok");
        item2.setImage("https://static.thenounproject.com/png/375209-200.png");
        listData.add(item2);

        Item item3 = new Item();
        item3.setShape("Kerucut");
        item3.setImage("https://static-00.iconduck.com/assets.00/cone-icon-2048x2046-7oncc3vw.png");
        listData.add(item3);

        Item item4 = new Item();
        item4.setShape("Bola");
        item4.setImage("https://static.thenounproject.com/png/104196-200.png");
        listData.add(item4);

        adapter = new Adapter(getContext(), listData);
        adapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    //Edit Gambar
    @Override
    public void onItemClick(int position) {
        // Menangani klik pada item dengan posisi yang sesuai
        if (position == 0 || position == 3) {
            String shape = listData.get(position).getShape();
            Intent intent = new Intent(requireContext(), FragmentKalkulator1.class);
            intent.putExtra("shape1", shape);
            String imageLink = (position == 0) ?
                    "https://cdn-icons-png.flaticon.com/512/73/73674.png" :
                    "https://static.thenounproject.com/png/104196-200.png";
            intent.putExtra("image1", imageLink);
            startActivity(intent);
        } else if (position == 1) {
            String shape = listData.get(position).getShape();
            Intent intent = new Intent(requireContext(), FragmentKalkulator3.class);
            intent.putExtra("shape3", shape);
            String imageLink = "https://static.thenounproject.com/png/375209-200.png";
            intent.putExtra("image3", imageLink);
            startActivity(intent);
        } else if (position == 2) {
            String shape = listData.get(position).getShape();
            Intent intent = new Intent(requireContext(), FragmentKalkulator2.class);
            intent.putExtra("shape2", shape);
            String imageLink = "https://static-00.iconduck.com/assets.00/cone-icon-2048x2046-7oncc3vw.png";
            intent.putExtra("image2", imageLink);
            startActivity(intent);
        } else {
            Toast.makeText(requireContext(), "Item clicked: " + position, Toast.LENGTH_SHORT).show();
        }
    }
}
