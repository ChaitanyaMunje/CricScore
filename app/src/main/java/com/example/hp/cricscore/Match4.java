package com.example.hp.cricscore;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

/**
 * A simple {@link Fragment} subclass.
 */
public class Match4 extends Fragment {


    public Match4() {
    }


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_match4, container, false);


        final TextView toss=(TextView)v.findViewById(R.id.toss);
        final TextView score4=(TextView)v.findViewById(R.id.score4);
        final TextView batsman1=(TextView)v.findViewById(R.id.batsman1);
        final TextView batsman2=(TextView)v.findViewById(R.id.batsman2);
        final TextView bowler=(TextView)v.findViewById(R.id.bowler);
        final TextView partnership=(TextView)v.findViewById(R.id.partnership);
        final TextView bat1=(TextView)v.findViewById(R.id.bat1);
        final TextView bat2=(TextView)v.findViewById(R.id.bat2);
        final TextView bat3=(TextView)v.findViewById(R.id.bat3);
        final TextView bat4=(TextView)v.findViewById(R.id.bat4);
        final TextView bat5=(TextView)v.findViewById(R.id.bat5);
        final TextView bat6=(TextView)v.findViewById(R.id.bat6);
        final TextView bat7=(TextView)v.findViewById(R.id.bat7);
        final TextView bat8=(TextView)v.findViewById(R.id.bat8);
        final TextView bat9=(TextView)v.findViewById(R.id.bat9);
        final TextView bat10=(TextView)v.findViewById(R.id.bat10);
        final TextView bowl1=(TextView)v.findViewById(R.id.bowl1);
        final TextView bowl2=(TextView)v.findViewById(R.id.bowl2);
        final TextView bowl3=(TextView)v.findViewById(R.id.bowl3);
        final TextView bowl4=(TextView)v.findViewById(R.id.bowl4);
        final TextView bowl5=(TextView)v.findViewById(R.id.bowl5);
        final TextView bowl6=(TextView)v.findViewById(R.id.bowl6);


        final DocumentReference doccument=db.collection("Data").document("Match4");
        doccument.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e!=null)
                {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (documentSnapshot !=null && documentSnapshot.exists()){
                    toss.setText(documentSnapshot.getData().get("toss").toString());
                    score4.setText(documentSnapshot.getData().get("score").toString());
                    batsman1.setText(documentSnapshot.getData().get("batsman1").toString());
                    batsman2.setText(documentSnapshot.getData().get("batsman2").toString());
                    bowler.setText(documentSnapshot.getData().get("bowler").toString());
                    partnership.setText(documentSnapshot.getData().get("partnership").toString());
                    bat1.setText(documentSnapshot.getData().get("bat1").toString());
                    bat2.setText(documentSnapshot.getData().get("bat2").toString());
                    bat3.setText(documentSnapshot.getData().get("bat3").toString());
                    bat4.setText(documentSnapshot.getData().get("bat4").toString());
                    bat5.setText(documentSnapshot.getData().get("bat5").toString());
                    bat6.setText(documentSnapshot.getData().get("bat6").toString());
                    bat7.setText(documentSnapshot.getData().get("bat7").toString());
                    bat8.setText(documentSnapshot.getData().get("bat8").toString());
                    bat9.setText(documentSnapshot.getData().get("bat9").toString());
                    bat10.setText(documentSnapshot.getData().get("bat10").toString());
                    bowl1.setText(documentSnapshot.getData().get("bowl1").toString());
                    bowl2.setText(documentSnapshot.getData().get("bowl2").toString());
                    bowl3.setText(documentSnapshot.getData().get("bowl3").toString());
                    bowl4.setText(documentSnapshot.getData().get("bowl4").toString());
                    bowl5.setText(documentSnapshot.getData().get("bowl5").toString());
                   // bowl6.setText(documentSnapshot.getData().get("bowl6").toString());
                    bowl6.setText(documentSnapshot.getData().get("bowl6").toString());






                }
            }
        });

        return v;
    }

}
