package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ArrayAdapter;

public class SpinnersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinners);

        String[] stringArray = {"집주소", "직장 주소", "기타"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Spinner spinner = findViewById(R.id.spinner_addressType);
        spinner.setAdapter(adapter);

        View.OnClickListener listener1 = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Spinner spinner1 = findViewById(R.id.spinner_phoneType);
                int index1 = spinner1.getSelectedItemPosition();
                String text1 = spinner1.getSelectedItem().toString();

                Spinner spinner2 = findViewById(R.id.spinner_addressType);
                int index2 = spinner2.getSelectedItemPosition();
                String text2 = spinner2.getSelectedItem().toString();

                String s = String.format("전화:%s(%d)   주소:%s(%d)", text1, index1, text2, index2);
                Toast.makeText(SpinnersActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };
        Button button = findViewById(R.id.btnSave);
        button.setOnClickListener(listener1);
    }
}