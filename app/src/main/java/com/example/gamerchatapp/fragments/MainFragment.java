package com.example.gamerchatapp.fragments;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gamerchatapp.R;
import com.example.gamerchatapp.activities.MainActivity;
import com.example.gamerchatapp.adapter.CustomAdapter;
import com.example.gamerchatapp.dm.Game;
import com.example.gamerchatapp.dm.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {


    private  static CustomAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private Response response;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        Bundle bundle = getArguments();
        if(bundle != null) {
            response = bundle.getParcelable("res");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView welcomeTextView = view.findViewById(R.id.welcomTextView);
        welcomeTextView.setText("welcome " +response.getBody().getUser().getName());
        Button b_menu = (Button) view.findViewById(R.id.menu_button);
        b_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.getHeader().setAction("menu_page");
                ((MainActivity) getActivity()).loadSetFragment(response);
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.sug_games_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        saveImages(response);
        adapter = new CustomAdapter(response.getBody().getGameList());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void saveImages(Response response) {
        File f;
        FileOutputStream fs;
        for(Game g : response.getBody().getGameList()) {
            try {
                f = new File("app/src/main/res/drawable/"+g.getName()+".jpg");
                if(f.exists())
                    f.delete();
                fs = new FileOutputStream(f.getPath());
                fs.write(g.getImageBlob());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}