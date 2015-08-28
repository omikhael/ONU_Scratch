package com.example.ouliviamikhael.onu_scratch;

/**
 * Created by ouliviamikhael on 15-08-27.
 */
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class TravelListViewFragment extends Fragment implements OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static final String[] titles = new String[] { "Destination:",
            "Destination:", "Destination:", "Destination:" };

    public static final String[] descriptions = new String[] {
            "Toronto",
            "Ottawa", "Monteral",
            "Mississauga" };

    public static final Integer[] images = { R.drawable.toronto_hd, R.drawable.toronto_hd,
            R.drawable.toronto_hd, R.drawable.toronto_hd };

    ListView listView;
    List<RowItem> rowItems;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainPageListViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TravelListViewFragment newInstance(String param1, String param2) {
        TravelListViewFragment fragment = new TravelListViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TravelListViewFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.travel_listview, container, false);
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }

        listView = (ListView) view.findViewById(R.id.listView);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this.getActivity(),
                R.layout.travel_format, rowItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}

