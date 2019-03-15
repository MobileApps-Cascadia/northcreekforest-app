
package edu.cascadia.mobas.northcreekforest;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class BarcodeScanner extends AppCompatActivity implements View.OnClickListener {

    Button btnTakePicture, btnScanBarcode;

    final Integer starting_index_last4_URL = 53; //The index of the final "/" in the URL retrieved from QR Code
    final Integer URL_length = 58; //The expected length of the URL retrieved from the QR Code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);
        initViews();
    }

    private void initViews() {
        btnTakePicture = findViewById(R.id.btnTakePicture);
        btnScanBarcode = findViewById(R.id.btnScanBarcode);
        btnTakePicture.setOnClickListener(this);
        btnScanBarcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnTakePicture:
                startActivity(new Intent(BarcodeScanner.this, PictureBarcode.class));
                break;
            case R.id.btnScanBarcode:
                new IntentIntegrator(this).initiateScan(); // `this` is the current Activity
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch (requestCode) {
            case IntentIntegrator.REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    // Parsing bar code reader result into (expected) URL
                    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
                    //Get last 4 digits of URL to identify plant
                    if(result.getContents().length() == URL_length) {
                        String substr = result.getContents().substring(starting_index_last4_URL);
                        //ForDebuging TODOne: Comment out next line
                        //Toast.makeText(this, "Scanned: " + substr, Toast.LENGTH_LONG).show();

                        //Start MainActivity with intent
                        Intent my_intent = new Intent(BarcodeScanner.this, MainActivity.class);
                        my_intent.putExtra("ScannedPlant", substr);
                        startActivity(my_intent);
                    }

                    else
                        //If this message appears then the QR Code is storing the URL in a different format or the URL may have changed
                        Toast.makeText(this, "Expected URL length:" + URL_length + ", Actual URL Length:" +result.getContents().length(), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


}
