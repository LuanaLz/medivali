package com.m2.medivali.consulta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.m2.medivali.R;
import com.m2.medivali.database.DatabaseHelper;
import com.m2.medivali.consulta.Consulta;

public class consulta_fragment_adicionar extends Fragment {

    EditText etNomePaciente;
    EditText etNomeMedico;
    EditText etDataInicio;
    EditText etDataFim;

    public consulta_fragment_adicionar() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_consulta_adicionar, container, false);

        etNomePaciente = v.findViewById(R.id.td_nome_paciente);
        etNomeMedico = v.findViewById(R.id.td_nome_medico);
        etDataInicio = v.findViewById(R.id.td_data_inicial);
        etDataFim = v.findViewById(R.id.td_data_fim);

        Button btnAdicionar = v.findViewById(R.id.bt_add_consulta);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar();
            }
        });

        return v;
    }

    private void adicionar () {
        if (etNomePaciente.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "!", Toast.LENGTH_LONG).show();
        } else if (etNomeMedico.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "!", Toast.LENGTH_LONG).show();
        } else if (etDataInicio.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "!", Toast.LENGTH_LONG).show();
        } else if (etDataFim.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "!", Toast.LENGTH_LONG).show();
        } else {
            DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
            Consulta c = new Consulta();
            c.setId(0);
            c.setData_hora_inicio(etDataInicio.getText().toString());
            c.setData_hora_fim(etDataFim.getText().toString());
            databaseHelper.createConstulta(c);
            Toast.makeText(getActivity(), "saved!", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.listViewConsulta, new consulta_fragment_listar()).commit();
        }
    }

}