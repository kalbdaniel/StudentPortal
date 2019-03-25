package nl.hva.dka.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;

public class AddPortal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        View addButton = findViewById(R.id.buttonAdd);
        final EditText name = findViewById(R.id.editTextName);
        final EditText url = findViewById(R.id.editTextUrl);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.NAME, name.getText().toString());
                intent.putExtra(MainActivity.URL, url.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
