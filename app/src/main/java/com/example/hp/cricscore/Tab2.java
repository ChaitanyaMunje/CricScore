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
public class Tab2 extends Fragment {
    public Tab2() {
    }
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);

        final TextView country=(TextView)v.findViewById(R.id.country);
        final TextView rank=(TextView)v.findViewById(R.id.rank);
        final TextView rating=(TextView)v.findViewById(R.id.rating);
        final TextView pts=(TextView)v.findViewById(R.id.pts);


        final DocumentReference doccument=db.collection("Data").document("ODI");
        doccument.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e!=null)
                {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (documentSnapshot !=null && documentSnapshot.exists()) {
                    country.setText(documentSnapshot.getData().get("country").toString());
                    rank.setText(documentSnapshot.getData().get("rank").toString());
                    rating.setText(documentSnapshot.getData().get("rating").toString());
                    pts.setText(documentSnapshot.getData().get("points").toString());





                }
            }
        });

        return v;
    }



}
