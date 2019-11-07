package edu.cascadia.mobas.northcreekforest


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

import java.util.Date

class BarcodeScanner : AppCompatActivity(), View.OnClickListener {

    lateinit var btnTakePicture: Button
    lateinit var btnScanBarcode: Button

    internal val starting_index_last4_URL = 53 //The index of the final "/" in the URL retrieved from QR Code
    internal val URL_length = 58 //The expected length of the URL retrieved from the QR Code


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode_scanner)
        initViews()

    }

    private fun initViews() {
        btnTakePicture = findViewById(R.id.btnTakePicture)
        btnScanBarcode = findViewById(R.id.btnScanBarcode)
        btnTakePicture.setOnClickListener(this)
        btnScanBarcode.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.btnTakePicture -> startActivity(Intent(this@BarcodeScanner, PictureBarcode::class.java))
            R.id.btnScanBarcode -> IntentIntegrator(this).initiateScan() // `this` is the current Activity
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        when (requestCode) {
            IntentIntegrator.REQUEST_CODE -> if (resultCode == Activity.RESULT_OK) {
                // Parsing bar code reader result into (expected) URL
                val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent)
                //Get last 4 digits of URL to identify plant
                if (result.contents.length == URL_length) {
                    val substr = result.contents.substring(starting_index_last4_URL)
                    //ForDebuging TODOne: Comment out next line
                    //Toast.makeText(this, "Scanned: " + substr, Toast.LENGTH_LONG).show();

                    //Start MainActivity with intent
                    val my_intent = Intent(this@BarcodeScanner, MainActivity::class.java)
                    my_intent.putExtra("ScannedPlant", substr)
                    startActivity(my_intent)
                } else
                //If this message appears then the QR Code is storing the URL in a different format or the URL may have changed
                    Toast.makeText(this, "Expected URL length:" + URL_length + ", Actual URL Length:" + result.contents.length, Toast.LENGTH_LONG).show()
            }
        }
    }


}
