package edu.cascadia.emilio.foncfphoto_points;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            button = (Button) findViewById(R.id.accountForm);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    accountForm();
                }
            });

    }

    public void accountForm(){
        Intent intent = new Intent(this,accountForm.class);
        startActivity(intent);

    }
}
