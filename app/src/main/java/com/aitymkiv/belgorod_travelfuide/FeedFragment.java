package com.aitymkiv.belgorod_travelfuide;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FeedFragment extends Fragment {
    private ArrayList<NewsItem> newsItems = new ArrayList<>();
    private View thisFragment;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance(String param1, String param2) {
        FeedFragment fragment = new FeedFragment();
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
        setInitialNews();
        // Inflate the layout for this fragment
        thisFragment = inflater.inflate(R.layout.fragment_feed, container, false);
        RecyclerView recyclerView = thisFragment.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false));
        NewsAdapter adapter = new NewsAdapter(newsItems);
        recyclerView.setAdapter(adapter);
        return thisFragment;
    }
    private void setInitialNews(){
        newsItems.add(new NewsItem(getResources().getString(R.string.news_heading_1),
                getResources().getString(R.string.news_item_1),
                getResources().getString(R.string.news_date_1),
                R.drawable.image_news_item_1, Uri.parse("https://www.go31.ru/news/3145180/v-voskresene-belgorodcam-obesaut-livni-i-silnyj-veter")));
        newsItems.add(new NewsItem(getResources().getString(R.string.news_heading_2),
                getResources().getString(R.string.news_item_2),
                getResources().getString(R.string.news_date_2),
                R.drawable.image_news_item_2, Uri.parse("https://www.go31.ru/news/3145140/v-belgorodskoj-oblasti-gruzovik-vehal-v-legkovusku-est-postradavsie")));
        newsItems.add(new NewsItem(getResources().getString(R.string.news_heading_3),
                getResources().getString(R.string.news_item_3),
                getResources().getString(R.string.news_date_3),
                R.drawable.image_news_item_3, Uri.parse("https://www.go31.ru/news/3145131/v-belgorodskoj-oblasti-lipovye-invalidy-ukrali-iz-budzeta-4-milliona-rublej")));
        newsItems.add(new NewsItem(getResources().getString(R.string.news_heading_4),
                getResources().getString(R.string.news_item_4),
                getResources().getString(R.string.news_date_4),
                R.drawable.image_news_item_4, Uri.parse("https://www.go31.ru/news/3145082/tri-zensiny-i-muzcina-umerli-ot-covid-19-v-belgorodskoj-oblasti-za-sutki")));
        newsItems.add(new NewsItem(getResources().getString(R.string.news_heading_5),
                getResources().getString(R.string.news_item_5),
                getResources().getString(R.string.news_date_5),
                R.drawable.image_news_item_5, Uri.parse("https://www.go31.ru/news/3145065/inace-etot-uzas-nikogda-ne-zakoncitsa-vpecatlenia-ot-kovid-gospitala-v-belgorode")));
   }
}