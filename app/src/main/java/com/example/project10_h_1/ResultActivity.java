package com.example.project10_h_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        setTitle("투표 결과");

        //mainActivity에서 전달한 데이터 수령
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("voteCount");
        String[] imageName = intent.getStringArrayExtra("imgName");

        Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        TextView tvTop = (TextView)findViewById(R.id.tvTop);
        ImageView ivTop = (ImageView)findViewById(R.id.ivTop);

        //투표수가 최대인 것
        int max_index=0;
        for(int i=0; i<voteResult.length; ++i) {
            //가장 큰값의 번지를 구하게 된다.
            if( voteResult[max_index] < voteResult[i] )
                max_index = i;
        }
        tvTop.setText(imageName[max_index]);
        ivTop.setImageResource(imageFileId[max_index]);
        //9개의 TextView, RatingBar 객체배열


        //초기값 설정 ------------------------------------------------------
        TextView[] tv = new TextView[imageName.length];
        RatingBar[] rbar = new RatingBar[imageName.length];

        Integer[] tvID = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer[] rbarID = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7,R.id.rbar8, R.id.rbar9};

        for( int i = 0; i < voteResult.length; i++ ) {
            tv[i] = (TextView)findViewById(tvID[i]);
            rbar[i] = (RatingBar)findViewById(rbarID[i]);
        }

        for( int i = 0; i < voteResult.length; i++ ) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float)voteResult[i]);
        }
        //초기값설정 ------------------------------------------------------


        // 버튼 ClickListener 정의
        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
