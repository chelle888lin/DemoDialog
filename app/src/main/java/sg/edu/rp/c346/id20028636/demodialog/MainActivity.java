package sg.edu.rp.c346.id20028636.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    TextView tvDemo2;
    Button btnDemo2;
    TextView tvDemo3;
    Button btnDemo3;
    EditText etInput;
    TextView tvInput;
    Button btnEx3;
    TextView tvInputEx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        etInput = findViewById(R.id.editTextInput);
        tvInput = findViewById(R.id.textViewInput);
        btnEx3 = findViewById(R.id.exercise3);
        tvInputEx3 = findViewById(R.id.textView4);

        btnDemo1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the dialog details
//                myBuilder.setTitle("Demo 1-Simple Dialog");
//                myBuilder.setMessage("I can develop Android App");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("Close", null);

                // Set the dialog details
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the dialog details
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);

                // Configure the 'positive' button
                myBuilder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                // Configure the 'negative' button
                myBuilder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                //Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
    }

}