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
public class Pointstable extends Fragment {
    public Pointstable() {}
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pointstable, container, false);
        final TextView team1=(TextView)v.findViewById(R.id.team1);
        final TextView team2=(TextView)v.findViewById(R.id.team2);
        final TextView team3=(TextView)v.findViewById(R.id.team3);
        final TextView team4=(TextView)v.findViewById(R.id.team4);
        final TextView team5=(TextView)v.findViewById(R.id.team5);
        final TextView team6=(TextView)v.findViewById(R.id.team6);
        final TextView team7=(TextView)v.findViewById(R.id.team7);
        final TextView team8=(TextView)v.findViewById(R.id.team8);


      DocumentReference documentReference=db.collection("Data").document("IPL");
       documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
           @Override
           public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
             if (e!=null){
                 Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
             return;}
             if (documentSnapshot!=null && documentSnapshot.exists())
             {
                 team1.setText(documentSnapshot.getData().get("team1").toString());
             team2.setText(documentSnapshot.getData().get("team2").toString());
                 team3.setText(documentSnapshot.getData().get("team3").toString());
              team4.setText(documentSnapshot.getData().get("team4").toString());
                 team5.setText(documentSnapshot.getData().get("team5").toString());
                 team6.setText(documentSnapshot.getData().get("team6").toString());
                team7.setText(documentSnapshot.getData().get("team7").toString());
                 team8.setText(documentSnapshot.getData().get("team8").toString());

             }
           }
       });
        return  v;
    }

}
