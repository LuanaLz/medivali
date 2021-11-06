package com.m2.medivali;

import android.os.Bundle;

import androidx.core.widget.ListViewCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.m2.medivali.consulta.consulta_fragment_listar;
import com.m2.medivali.medico.medico_fragment_listar;
import com.m2.medivali.paciente.paciente_fragment_listar;

public class fragmentListButton extends Fragment {
    Button btListaPaciente, btListaMedico , btListaConsulta ;

    public fragmentListButton() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_button, container, false);

        btListaPaciente = (Button)v.findViewById(R.id.bt_list_paciente);
        btListaMedico = (Button)v.findViewById(R.id.bt_list_medico);
        btListaConsulta = (Button)v.findViewById(R.id.bt_list_consulta);



        btListaMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_view_itens, new medico_fragment_listar()).commit();
            }
        });

        btListaPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_view_itens, new paciente_fragment_listar()).commit();
            }
        });

        btListaConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_view_itens, new consulta_fragment_listar()).commit();
            }
        });

        return v;

    }


}