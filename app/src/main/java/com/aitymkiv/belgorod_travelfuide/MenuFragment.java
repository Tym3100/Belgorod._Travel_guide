package com.aitymkiv.belgorod_travelfuide;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {
    private ArrayList<Category> categoryCashbacks = new ArrayList<>();
    private View thisFragment;
    private SliderAdapterNews adapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        thisFragment = inflater.inflate(R.layout.fragment_menu, container, false);

        addCategoriesToRecyclerView();

        RecyclerView recyclerView = thisFragment.findViewById(R.id.recycler_view_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(categoryCashbacks);
        recyclerView.setAdapter(categoriesAdapter);

        adapter = new SliderAdapterNews(getContext());
        addNewItemsToSlider();
        SliderView sliderView = thisFragment.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4);
        sliderView.startAutoCycle();

        return thisFragment;
    }
    private void addNewItemsToSlider(){
        adapter.addItem(new SliderItem("Распродажа купальников", R.drawable.slide_1));
        adapter.addItem(new SliderItem("Распродажа \"Снежная королева\"", R.drawable.slide_2));
        adapter.addItem(new SliderItem("Скидки \"Ostin\"", R.drawable.slide_3));
        adapter.addItem(new SliderItem("Распродажа \"Colins\"", R.drawable.slide_4));
    }
    private void addCategoriesToRecyclerView(){
        categoryCashbacks.add(new Category(R.drawable.ic_baby, "Детские товары", 10));
        categoryCashbacks.add(new Category(R.drawable.ic_gas_station, "АЗС", 20));
        categoryCashbacks.add(new Category(R.drawable.ic_sport, "Спорт", 15));
        categoryCashbacks.add(new Category(R.drawable.ic_study, "Образование", 10));
        categoryCashbacks.add(new Category(R.drawable.ic_travel, "Путешествие", 5));
        categoryCashbacks.add(new Category(R.drawable.ic_coffee, "Кофе", 30));

        //create a cashback

        List<CashBack> cashBacks = new ArrayList<>();
        cashBacks.add( new CashBack("Газпром", R.drawable.ic_gas_station_gazprom, 21, 20));
        cashBacks.add( new CashBack("Лукойл", R.drawable.ic_gas_station_lukoil, 30, 25));
        cashBacks.add( new CashBack("Роснефть", R.drawable.ic_gas_station_rosneft, 15, 23));
        cashBacks.add( new CashBack("Татнефть", R.drawable.ic_gas_station_tatneft, 16, 22));

        //add cashback to category
        Category categoryCashback = categoryCashbacks.get(1);
        categoryCashback.addCashBack(cashBacks);
    }
}