package com.basics.android.udacity.guiadeturismo;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ToursFragment extends Fragment {

    public ToursFragment() {
        // Contrutor público vazio requerido.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        Resources r = getActivity().getResources();

        // Cria um array de atrações culturais. Nome e endereço são obrigatórios.
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(r.getString(R.string.tours_name1), r.getString(R.string.tours_hours1),
                r.getString(R.string.tours_phone1), r.getString(R.string.tours_address1),
                r.getString(R.string.tours_web1), r.getString(R.string.tours_description1),
                R.drawable.img_tour1));
        attractions.add(new Attraction(r.getString(R.string.tours_name2), r.getString(R.string.tours_hours2),
                r.getString(R.string.tours_phone2), r.getString(R.string.tours_address2),
                r.getString(R.string.tours_web2), r.getString(R.string.tours_description2),
                R.drawable.img_tour2));
        attractions.add(new Attraction(r.getString(R.string.tours_name3), null, null,
                r.getString(R.string.tours_address3), null, r.getString(R.string.tours_description3),
                R.drawable.img_tour3));
        attractions.add(new Attraction(r.getString(R.string.tours_name4), null, null,
                r.getString(R.string.tours_address4), null, r.getString(R.string.tours_description4),
                R.drawable.img_tour4));
        attractions.add(new Attraction(r.getString(R.string.tours_name5), r.getString(R.string.tours_hours5),
                null, r.getString(R.string.tours_address5), r.getString(R.string.tours_web5),
                r.getString(R.string.tours_description5), R.drawable.img_tour5));
        attractions.add(new Attraction(r.getString(R.string.tours_name6), r.getString(R.string.tours_hours6),
                null, r.getString(R.string.tours_address6), null, r.getString(R.string.tours_description6),
                R.drawable.img_tour6));
        attractions.add(new Attraction(r.getString(R.string.tours_name7), null, null,
                r.getString(R.string.tours_address7), null, r.getString(R.string.tours_description7),
                R.drawable.img_tour7));
        attractions.add(new Attraction(r.getString(R.string.tours_name8), r.getString(R.string.tours_hours8),
                r.getString(R.string.tours_phone8), r.getString(R.string.tours_address8),
                r.getString(R.string.tours_web8), r.getString(R.string.tours_description8), R.drawable.img_tour8));

        // Cor de fundo para os cards da lista de atrações desta categoria a ser exibida.
        final int color = ContextCompat.getColor(getContext(), R.color.category_tours);

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, color);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Listener para exibir detalhes da atração quando um item da lista é clicado.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                // Adiciona todos os dados da atração clicada para serem exibidos em DetailsActivity.
                intent.putExtra("name", attractions.get(position).getName());
                intent.putExtra("hours", attractions.get(position).getHours());
                intent.putExtra("phone", attractions.get(position).getPhone());
                intent.putExtra("imageResourceId", attractions.get(position).getImageResourceId());
                intent.putExtra("address", attractions.get(position).getAddress());
                intent.putExtra("web", attractions.get(position).getWeb());
                intent.putExtra("description", attractions.get(position).getDescription());
                // Adiciona a mesma cor de fundo do card clicado para ser usado como fundo da tela
                // de detalhes
                intent.putExtra("color", color);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }
}
