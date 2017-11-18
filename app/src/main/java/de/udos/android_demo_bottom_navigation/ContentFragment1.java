package de.udos.android_demo_bottom_navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment1 extends ListFragment {

    private String[] mCountries;
    private ArrayAdapter<String> mArrayAdapter;

    public ContentFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_content_1, container, false);

        mCountries = getResources().getStringArray(R.array.countries);
        mArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, mCountries);

        setListAdapter(mArrayAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        //v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }
}
