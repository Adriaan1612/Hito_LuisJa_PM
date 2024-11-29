package com.example.hito_luisja;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ContactUsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        EditText editTextName = findViewById(R.id.edit_text_name);
        EditText editTextEmail = findViewById(R.id.edit_text_email);
        EditText editTextSubject = findViewById(R.id.edit_text_subject);
        EditText editTextMessage = findViewById(R.id.edit_text_message);
        Button buttonSendMessage = findViewById(R.id.button_send_message);

        buttonSendMessage.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String subject = editTextSubject.getText().toString();
            String message = editTextMessage.getText().toString();

            if (!name.isEmpty() && !email.isEmpty() && !subject.isEmpty() && !message.isEmpty()) {
                Toast.makeText(this, "Message sent successfully!", Toast.LENGTH_SHORT).show();
                editTextName.getText().clear();
                editTextEmail.getText().clear();
                editTextSubject.getText().clear();
                editTextMessage.getText().clear();
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}