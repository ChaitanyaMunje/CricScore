package com.example.hp.cricscore;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class home1 extends Fragment {
    public home1() { }
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home1, container, false);
        CardView MATCH1=(CardView)v.findViewById(R.id.MATCH1);
        CardView MATCH2=(CardView)v.findViewById(R.id.MATCH2);
        CardView MATCH3=(CardView)v.findViewById(R.id.MATCH3);
        CardView MATCH4=(CardView)v.findViewById(R.id.MATCH4);
        CardView MATCH5=(CardView)v.findViewById(R.id.MATCH5);

        //Match No
       final TextView text_match1_no=(TextView)v.findViewById(R.id.text_match1_no);
        final TextView text_match2_no=(TextView)v.findViewById(R.id.text_match2_no);
        final TextView text_match3_no=(TextView)v.findViewById(R.id.text_match3_no);
        final TextView text_match4_no=(TextView)v.findViewById(R.id.text_match4_no);
        final TextView text_match5_no=(TextView)v.findViewById(R.id.text_match5_no);

        //Match Title
        final TextView  text_match1=(TextView)v.findViewById(R.id.text_match1);
        final TextView  text_match2=(TextView)v.findViewById(R.id.text_match2);
        final TextView text_match3=(TextView)v.findViewById(R.id.text_match3);
        final TextView text_match4=(TextView)v.findViewById(R.id.text_match4);
        final TextView text_match5=(TextView)v.findViewById(R.id.text_match5);

        //Team images
       final ImageView image1_team1=(ImageView)v.findViewById(R.id.image1_team_1);
        final ImageView  image1_team2=(ImageView)v.findViewById(R.id.image1_team_2);

        final ImageView  image2_team1=(ImageView)v.findViewById(R.id.image2_team_1);
        final ImageView image2_team2=(ImageView)v.findViewById(R.id.image2_team_2);

        final ImageView   image3_team1=(ImageView)v.findViewById(R.id.image3_team_1);
        final ImageView image3_team2=(ImageView)v.findViewById(R.id.image3_team_2);

        final ImageView image4_team1=(ImageView)v.findViewById(R.id.image4_team_1);
        final ImageView image4_team2=(ImageView)v.findViewById(R.id.image4_team_2);

        final ImageView image5_team1=(ImageView)v.findViewById(R.id.image5_team_1);
        final ImageView image5_team2=(ImageView)v.findViewById(R.id.image5_team_2);

        //SCORRE

        final TextView text1_score=(TextView)v.findViewById(R.id.text1_score);
        final TextView text2_score=(TextView)v.findViewById(R.id.text2_score);
        final TextView text3_score=(TextView)v.findViewById(R.id.text3_score);
        final TextView text4_score=(TextView)v.findViewById(R.id.text4_score);
        final TextView text5_score=(TextView)v.findViewById(R.id.text5_score);


        //Images Url
        final TextView image1url1=(TextView)v.findViewById(R.id.image1url1);
        final TextView image1url2=(TextView)v.findViewById(R.id.image1url2);

        final TextView image2url1=(TextView)v.findViewById(R.id.image2url1);
        final TextView image2url2=(TextView)v.findViewById(R.id.image2url2);

        final TextView image3url1=(TextView)v.findViewById(R.id.image3url1);
        final TextView image3url2=(TextView)v.findViewById(R.id.image3url2);

        final TextView image4url1=(TextView)v.findViewById(R.id.image4url1);
        final TextView image4url2=(TextView)v.findViewById(R.id.image4url2);

        final TextView image5url1=(TextView)v.findViewById(R.id.image5url1);
        final TextView image5url2=(TextView)v.findViewById(R.id.image5url2);

        final SwipeRefreshLayout home1=(SwipeRefreshLayout)v.findViewById(R.id.pullToRefresh1);
        home1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                home1.setRefreshing(false);

            }
        });

        final DocumentReference doccument=db.collection("Data").document("data");
        doccument.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e!=null)
                {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getActivity().this, "Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (documentSnapshot !=null && documentSnapshot.exists()){

                    //Match Title
                    text_match1_no.setText(documentSnapshot.getData().get("match1").toString());
                    text_match2_no.setText(documentSnapshot.getData().get("match2").toString());
                    text_match3_no.setText(documentSnapshot.getData().get("match3").toString());
                    text_match4_no.setText(documentSnapshot.getData().get("match4").toString());
                    text_match5_no.setText(documentSnapshot.getData().get("match5").toString());

                    //Match Heading
                    text_match1.setText(documentSnapshot.getData().get("head1").toString());
                    text_match2.setText(documentSnapshot.getData().get("head2").toString());
                    text_match3.setText(documentSnapshot.getData().get("head3").toString());
                    text_match4.setText(documentSnapshot.getData().get("head4").toString());
                    text_match5.setText(documentSnapshot.getData().get("head5").toString());

                    //Score
                    text1_score.setText(documentSnapshot.getData().get("score1").toString());
                    text2_score.setText(documentSnapshot.getData().get("score2").toString());
                    text3_score.setText(documentSnapshot.getData().get("score3").toString());
                    text4_score.setText(documentSnapshot.getData().get("score4").toString());
                    text5_score.setText(documentSnapshot.getData().get("score5").toString());


                   //Images
                    //Match 1
                    image1url1.setText(documentSnapshot.getData().get("1team1").toString());
                    String uri11=image1url1.getText().toString();
                    Picasso.get().load(uri11).into(image1_team1);
                    image1url2.setText(documentSnapshot.getData().get("1team2").toString());
                    String uri12=image1url2.getText().toString();
                   Picasso.get().load(uri12).into(image1_team2);


                   //Match 2
                    image2url1.setText(documentSnapshot.getData().get("2team1").toString());
                    String uri21=image2url1.getText().toString();
                    Picasso.get().load(uri21).into(image2_team1);

                    image2url2.setText(documentSnapshot.getData().get("2team2").toString());
                    String uri22=image2url2.getText().toString();
                    Picasso.get().load(uri22).into(image2_team2);

                    //Match 3
                    image3url1.setText(documentSnapshot.getData().get("3team1").toString());
                    String uri31=image3url1.getText().toString();
                    Picasso.get().load(uri31).into(image3_team1);


                    image3url2.setText(documentSnapshot.getData().get("3team2").toString());
                    String uri32=image3url2.getText().toString();
                    Picasso.get().load(uri32).into(image3_team2);

                    //MATCH 4
                    image4url1.setText(documentSnapshot.getData().get("4team1").toString());
                    String uri41=image4url1.getText().toString();
                    Picasso.get().load(uri41).into(image4_team1);

                    image4url2.setText(documentSnapshot.getData().get("4team2").toString());
                    String uri42=image4url2.getText().toString();
                    Picasso.get().load(uri42).into(image4_team2);

                    //MATCH 5
                    image5url1.setText(documentSnapshot.getData().get("5team1").toString());
                    String uri51=image5url1.getText().toString();
                    Picasso.get().load(uri51).into(image5_team1);

                    image5url2.setText(documentSnapshot.getData().get("5team2").toString());
                    String uri52=image5url2.getText().toString();
                    Picasso.get().load(uri52).into(image5_team2);




                }
            }
        });

        MATCH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Match1 fragmentmatch1 = new Match1();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.screen_area, fragmentmatch1, fragmentmatch1.getTag()).addToBackStack(null).commit();
            }
        });
       MATCH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Match2 fragmentmatch2=new Match2();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.screen_area,fragmentmatch2,fragmentmatch2.getTag()).addToBackStack(null).commit();

            }
        });
        MATCH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Match3 fragmentmatch3=new Match3();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.screen_area,fragmentmatch3,fragmentmatch3.getTag()).addToBackStack(null).commit();

            }
        });

        MATCH4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Match4 fragmentmatch4=new Match4();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.screen_area,fragmentmatch4,fragmentmatch4.getTag()).addToBackStack(null).commit();

            }
        });

        MATCH5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Match5 fragmentmatch5=new Match5();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.screen_area,fragmentmatch5,fragmentmatch5.getTag()).addToBackStack(null).commit();

            }
        });
        return  v;
    }

}
