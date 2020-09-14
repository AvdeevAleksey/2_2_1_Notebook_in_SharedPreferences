package ru.avdeev.android.a2_2_1_notebook_in_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNote;
    private final static String KEY = "key";
    private final static String TEXTNOTE = "text_note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNote = findViewById(R.id.notebookEditText);
        editTextNote.setText(loadNoteText());
    }

    public void btnSaveClicked (View view) {
        saveNoteText(editTextNote.getText().toString());
    }

    private void saveNoteText (String text) {
        getSharedPreferences(TEXTNOTE,MODE_PRIVATE)
                .edit()
                .putString(KEY,text)
                .apply();
    }

    private String loadNoteText() {
        return getSharedPreferences(TEXTNOTE,MODE_PRIVATE).getString(KEY,"");
    }
}