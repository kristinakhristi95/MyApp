package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutID, textInputLayoutUsername, textInputLayoutCourse;
    private EditText editTextID, editTextUsername, editTextCourse;
    private TextView textViewData;
    private Button buttonLoad, buttonStore, buttonReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Initialize views
        textInputLayoutID = findViewById(R.id.textInputLayoutID);
        textInputLayoutUsername = findViewById(R.id.textInputLayoutUsername);
        textInputLayoutCourse = findViewById(R.id.textInputLayoutCourse);

        editTextID = findViewById(R.id.editTextID);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextCourse = findViewById(R.id.editTextCourse);

        textViewData = findViewById(R.id.textViewData);

        buttonLoad = findViewById(R.id.buttonLoad);
        buttonStore = findViewById(R.id.buttonStore);
        buttonReset = findViewById(R.id.buttonReset);

        // Set click listeners for each button
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load action (you can customize this logic)
                String id = editTextID.getText().toString();
                String username = editTextUsername.getText().toString();
                String course = editTextCourse.getText().toString();

                // Display data in TextView
                textViewData.setText("ID: " + id + "\nUsername: " + username + "\nCourse: " + course);
            }
        });

        buttonStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Store action (you can customize this logic, like saving to a database or SharedPreferences)
                String id = editTextID.getText().toString();
                String username = editTextUsername.getText().toString();
                String course = editTextCourse.getText().toString();

                // Display message after storing
                textViewData.setText("Data Stored:\nID: " + id + "\nUsername: " + username + "\nCourse: " + course);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset action
                editTextID.setText("");
                editTextUsername.setText("");
                editTextCourse.setText("");
                textViewData.setText("Data has been reset.");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}