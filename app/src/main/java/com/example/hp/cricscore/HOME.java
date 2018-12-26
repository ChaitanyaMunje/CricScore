package com.example.hp.cricscore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.squareup.picasso.Picasso;

public class HOME extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ScrollView main;
    private TextView text_match1_no,text_match2_no,text_match3_no,text_match4_no,text_match5_no;
    private TextView text_match1,text_match2,text_match3,text_match4,text_match5;
    private ImageView image1_team1,image1_team2,image2_team1,image2_team2,image3_team1,image3_team2,image4_team1,image4_team2,image5_team1,image5_team2;
    private TextView text1_score,text2_score,text3_score,text4_score,text5_score;
    private TextView image1url1,image1url2,image2url1,image2url2,image3url1,image3url2,image4url1,image4url2,image5url1,image5url2;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // main.setVisibility(View.INVISIBLE);
        FragmentManager fm=getSupportFragmentManager();
        home1 home1=new home1();
        fm.beginTransaction().replace(R.id.screen_area,home1).commit();
        main=(ScrollView)findViewById(R.id.main);

        //Match No
      /*  text_match1_no=(TextView)findViewById(R.id.text_match1_no);
        text_match2_no=(TextView)findViewById(R.id.text_match2_no);
        text_match3_no=(TextView)findViewById(R.id.text_match3_no);
        text_match4_no=(TextView)findViewById(R.id.text_match4_no);
        text_match5_no=(TextView)findViewById(R.id.text_match5_no);

        //Match Title
        text_match1=(TextView)findViewById(R.id.text_match1);
        text_match2=(TextView)findViewById(R.id.text_match2);
        text_match3=(TextView)findViewById(R.id.text_match3);
        text_match4=(TextView)findViewById(R.id.text_match4);
        text_match5=(TextView)findViewById(R.id.text_match5);

        //Team images
        image1_team1=(ImageView)findViewById(R.id.image1_team_1);
        image1_team2=(ImageView)findViewById(R.id.image1_team_2);

        image2_team1=(ImageView)findViewById(R.id.image2_team_1);
        image2_team2=(ImageView)findViewById(R.id.image2_team_2);

        image3_team1=(ImageView)findViewById(R.id.image3_team_1);
        image3_team2=(ImageView)findViewById(R.id.image3_team_2);

        image4_team1=(ImageView)findViewById(R.id.image4_team_1);
        image4_team2=(ImageView)findViewById(R.id.image4_team_2);

        image5_team1=(ImageView)findViewById(R.id.image5_team_1);
        image5_team2=(ImageView)findViewById(R.id.image5_team_2);

        //SCORRE

        text1_score=(TextView)findViewById(R.id.text1_score);
        text2_score=(TextView)findViewById(R.id.text2_score);
        text3_score=(TextView)findViewById(R.id.text3_score);
        text4_score=(TextView)findViewById(R.id.text4_score);
        text5_score=(TextView)findViewById(R.id.text5_score);


        //Images Url
        image1url1=(TextView)findViewById(R.id.image1url1);
        image1url2=(TextView)findViewById(R.id.image1url2);

        image2url1=(TextView)findViewById(R.id.image2url1);
        image2url2=(TextView)findViewById(R.id.image2url2);

        image3url1=(TextView)findViewById(R.id.image3url1);
        image3url2=(TextView)findViewById(R.id.image3url2);

        image4url1=(TextView)findViewById(R.id.image4url1);
        image4url2=(TextView)findViewById(R.id.image4url2);

        image5url1=(TextView)findViewById(R.id.image5url1);
        image5url2=(TextView)findViewById(R.id.image5url2);


         DocumentReference doccument=db.collection("Data").document("data");
        doccument.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e!=null)
                {
                    Toast.makeText(HOME.this, "Error", Toast.LENGTH_SHORT).show();
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

*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //main.setVisibility(View.INVISIBLE);
        int id = item.getItemId();
        Fragment fragment=null;
        if (id == R.id.nav_home) {
            fragment=new home1();

        } else if (id == R.id.nav_rankings) {
            fragment=new Rankings();

        } else if (id == R.id.nav_points_table) {
            fragment=new Pointstable();

        } else if (id == R.id.nav_share) {
            Intent myintent=new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plain");
            String sharebody="chaitanyamunje@gmail.com";
            String sharesub="Cric Score";
            myintent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
            myintent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myintent,"Share Using"));

        } else if (id == R.id.nav_rate_us) {
            fragment=new Rateus();

        }
        if (fragment!=null){
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction ft=fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area,fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
