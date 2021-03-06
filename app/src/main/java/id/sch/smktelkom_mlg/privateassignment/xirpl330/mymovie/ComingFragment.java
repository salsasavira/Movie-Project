package id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie.adapter.ComingAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie.model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie.model.ResultsRespone;
import id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie.service.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComingFragment extends Fragment {


    ArrayList<Results> mlist = new ArrayList<>();
    ComingAdapter myComing;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_coming, container, false);

        RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.recycleComing);
        rv.setHasFixedSize(true);
        myComing = new ComingAdapter(this, mlist, getContext());
        rv.setAdapter(myComing);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        downloadDataResource();
        return rootview;
    }

    private void downloadDataResource() {
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=b56dd418a138d8facd6d2da920f65200&language=en-US&page=1\n";

        GsonGetRequest<ResultsRespone> myRequest = new GsonGetRequest<ResultsRespone>
                (url, ResultsRespone.class, null, new Response.Listener<ResultsRespone>() {

                    @Override
                    public void onResponse(ResultsRespone response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
                        mlist.addAll(response.results);
                        myComing.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(myRequest);
    }
}
