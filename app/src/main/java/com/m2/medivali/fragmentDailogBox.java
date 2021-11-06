package com.m2.medivali;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.m2.medivali.consulta.consulta_fragment_adicionar;
import com.m2.medivali.medico.medico_fragment_adicionar;
import com.m2.medivali.paciente.paciente_fragment_adicionar;

public class fragmentDailogBox extends DialogFragment {
    //onCreate Fragment Dialog method


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Create Box Alert

        String [] element = getActivity().getResources().getStringArray(R.array.elements);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("");
        builder.setItems(element, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_view_itens, new
                                paciente_fragment_adicionar()).commit();
                        break;
                    case 1:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_view_itens, new
                                medico_fragment_adicionar()).commit();
                        break;
                    case 2:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_view_itens, new
                                consulta_fragment_adicionar()).commit();
                        break;
                }
            }
        });

        return builder.create();
    }
}
