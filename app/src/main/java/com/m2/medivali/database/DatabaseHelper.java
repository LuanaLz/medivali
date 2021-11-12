package com.m2.medivali.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.m2.medivali.consulta.Consulta;
import com.m2.medivali.medico.Medico;
import com.m2.medivali.paciente.Paciente;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "medivali";
    private static final String TABLE_CONSULTA = "consulta";
    private static final String TABLE_MEDICO = "medico";
    private static final String TABLE_PACIENTE = "paciente";

    private static final String SQL_CREATE_CONSULTA = "CREATE TABLE " + TABLE_CONSULTA + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "paciente_id INTEGER, " +
            "medico_id INTEGER, " +
            "data_hora_inicio DATETIME, " +
            "data_hora_fim DATETIME, " +
            "observacao VARCHAR(200), " +
            "CONSTRAINT fk_consulta_paciente FOREIGN KEY (paciente_id) REFERENCES paciente (id), " +
            "CONSTRAINT fk_consulta_medico FOREIGN KEY (medico_id) REFERENCES medico (id))";
    private static final String SQL_CREATE_MEDICO = "CREATE TABLE " + TABLE_MEDICO + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome VARCHAR(50), " +
            "crm VARCHAR(20), " +
            "celular VARCHAR(20), " +
            "fixo VARCHAR(20))";
    private static final String SQL_CREATE_PACIENTE = "CREATE TABLE " + TABLE_PACIENTE + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome VARCHAR(50), " +
            "grp_sanguineo TINYINT(20), " +
            "celular VARCHAR(20), " +
            "fixo VARCHAR(20))";
    private static final String SQL_DELETE_CONSULTA = "DROP TABLE IF EXISTS " + TABLE_CONSULTA;
    private static final String SQL_DELETE_MEDICO = "DROP TABLE IF EXISTS " + TABLE_MEDICO;
    private static final String SQL_DELETE_PACIENTE = "DROP TABLE IF EXISTS " + TABLE_PACIENTE;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CONSULTA);
        db.execSQL(SQL_CREATE_MEDICO);
        db.execSQL(SQL_CREATE_PACIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_CONSULTA);
        db.execSQL(SQL_DELETE_MEDICO);
        db.execSQL(SQL_DELETE_PACIENTE);
    }
}
