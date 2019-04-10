package com.example.bmicalculation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity implements View.OnClickListener {
    TextView height,weight;
    EditText et_height,et_weight,et_result;
    Button submit;
    String getheight,getweight,result,getHeightInMeters,bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        initializeViews();
    }

    public void initializeViews(){
        et_height=(EditText)findViewById(R.id.etheight);
        et_weight=(EditText)findViewById(R.id.etweight);
        et_result=(EditText)findViewById(R.id.result);
        submit=(Button)findViewById(R.id.btn_compute);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_compute:
                BMIModel bmiModel=new BMIModel(getheight,getweight);
                    bmiModel.setHeight(et_height.getText().toString());
                    bmiModel.setWeight(et_weight.getText().toString());
                    getheight=bmiModel.getHeight();
                    getHeightInMeters=Double.parseDouble(getheight)/100+"";
                    //System.out.println(getHeightInMeters);
                    getweight=bmiModel.getWeight();
                    //System.out.println(getweight);
                    //System.out.println(getheight);

                    bmi=Double.parseDouble(getweight)/((Double.parseDouble(getHeightInMeters))*
                            (Double.parseDouble(getHeightInMeters)))+"";
                    //System.out.println(bmi);
                    et_result.setText(bmi);
                    if (Double.parseDouble(bmi)<18.5){
                        Toast.makeText(BMIActivity.this,"Underweight",Toast.LENGTH_LONG).show();
                    }
                    else if (Double.parseDouble(bmi)>=18.5 && Double.parseDouble(bmi)<=24.9){
                        Toast.makeText(BMIActivity.this,"Normal Weight",Toast.LENGTH_LONG).show();
                    }
                    else if (Double.parseDouble(bmi)>=25 && Double.parseDouble(bmi)<=29.9){
                        Toast.makeText(BMIActivity.this,"Overweight",Toast.LENGTH_LONG).show();
                    }
                    else if (Double.parseDouble(bmi)>=30){
                        Toast.makeText(BMIActivity.this,"Obesity",Toast.LENGTH_LONG).show();
                    }
        }
    }

}
