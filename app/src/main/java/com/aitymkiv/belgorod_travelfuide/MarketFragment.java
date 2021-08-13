package com.aitymkiv.belgorod_travelfuide;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarketFragment extends Fragment {

    private ArrayList<Product> mProductList = new ArrayList<>();
    private View thisFragment;
    private final static int NUM_COLUMNS = 2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MarketFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarketFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarketFragment newInstance(String param1, String param2) {
        MarketFragment fragment = new MarketFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setProducts();
        thisFragment = inflater.inflate(R.layout.fragment_market, container, false);
        RecyclerView recyclerView = thisFragment.findViewById(R.id.recyclerViewMarket);
        MarketStaggeredRecyclerViewAdapter adapter =
                new MarketStaggeredRecyclerViewAdapter(getContext(), mProductList);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
        return thisFragment;
    }

    private void setProducts(){
        mProductList.add(new Product("FENDER CD-60 DREAD V3 DS BLK WN", 19700, R.drawable.guitar_1, Uri.parse("https://www.muztorg.ru/product/A091210")));
        mProductList.add(new Product("FENDER FA-125 DREADNOUGHT WALNUT", 13900, R.drawable.guitar_2, Uri.parse("https://www.muztorg.ru/produсt/A100170")));
        mProductList.add(new Product("YAMAHA F310 TBS", 12990, R.drawable.guitar_3, Uri.parse("https://www.muztorg.ru/produсt/A127852")));
        mProductList.add(new Product("ROCKDALE Aurora D1 C BK", 6400, R.drawable.guitar_4, Uri.parse("https://www.muztorg.ru/produсt/A112953")));
        mProductList.add(new Product("FENDER SQUIER SA-150 DREADNOUGHT, NAT", 11100, R.drawable.guitar_5, Uri.parse("https://www.muztorg.ru/product/A071556")));
        mProductList.add(new Product("VESTON F-38/BK", 7100, R.drawable.guitar_6, Uri.parse("https://www.muztorg.ru/product/A073576")));
    }
}