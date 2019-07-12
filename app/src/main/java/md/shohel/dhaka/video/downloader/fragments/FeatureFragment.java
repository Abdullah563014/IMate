package md.shohel.dhaka.video.downloader.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import md.shohel.dhaka.video.downloader.MainActivity;
import md.shohel.dhaka.video.downloader.R;
import md.shohel.dhaka.video.downloader.adapter.MainRecyclerViewAdapter;
import md.shohel.dhaka.video.downloader.model.MainModelClass;
import md.shohel.dhaka.video.downloader.model.SubModelClass;

public class FeatureFragment extends Fragment {


    public FeatureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_feature, container, false);

//        private void initializeAll(){
//            contentRootLayout=findViewById(R.id.rootContentLayoutId);
//            progressBarLayoutId=findViewById(R.id.mainActivityProgressBarId);
//            recyclerView=findViewById(R.id.mainActivityRecyclerViewId);
//            databaseReference= FirebaseDatabase.getInstance().getReference();
//        }
//
//
//
//        private void setUpRecyclerView(ArrayList< MainModelClass > mainList){
//            ArrayList<MainModelClass> demodList=new ArrayList<>();
//            demodList.addAll(mainList);
//            recyclerView.setHasFixedSize(true);
//            layoutManager = new LinearLayoutManager(this);
//            recyclerView.setLayoutManager(layoutManager);
//            mainRecyclerViewAdapter = new MainRecyclerViewAdapter(MainActivity.this,mainList);
//            recyclerView.setAdapter(mainRecyclerViewAdapter);
//
//        }
//
//
//        private void contentHide(){
//            contentRootLayout.setVisibility(View.GONE);
//            progressBarLayoutId.setVisibility(View.VISIBLE);
//        }
//
//
//        private void contentShow(){
//            progressBarLayoutId.setVisibility(View.GONE);
//            contentRootLayout.setVisibility(View.VISIBLE);
//        }
//
//        private void loadData(){
//            mainList.clear();
//
//            databaseReference.addChildEventListener(new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                    mainList.clear();
//                    String title;
//                    ArrayList<SubModelClass> list;
//                    title=dataSnapshot.getKey().toString();
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                    title=snapshot.getKey().toString();
//                        list=new ArrayList<>();
//                        for (DataSnapshot childSnapshot : snapshot.getChildren()){
//                            SubModelClass subModelClass=childSnapshot.getValue(SubModelClass.class);
//                            list.add(subModelClass);
//                        }
//                        MainModelClass mainModelClass=new MainModelClass(title,list);
//                        mainList.add(mainModelClass);
//                    }
//                    contentShow();
//                    setUpRecyclerView(mainList);
//                    Toast.makeText(MainActivity.this, "Total "+mainList.size(), Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                    String title;
//                    title=dataSnapshot.getKey().toString();
//                    mainList.clear();
//                    ArrayList<SubModelClass> list;
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                    title=snapshot.getKey().toString();
//                        list=new ArrayList<>();
//                        for (DataSnapshot childSnapshot : snapshot.getChildren()){
//                            SubModelClass subModelClass=childSnapshot.getValue(SubModelClass.class);
//                            list.add(subModelClass);
//                        }
//                        MainModelClass mainModelClass=new MainModelClass(title,list);
//                        mainList.add(mainModelClass);
//                    }
//                    contentShow();
//                    setUpRecyclerView(mainList);
//                    Toast.makeText(MainActivity.this, "Total "+mainList.size(), Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//                    Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }

        return view;
    }

}
