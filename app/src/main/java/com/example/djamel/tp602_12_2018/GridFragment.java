package com.example.djamel.tp602_12_2018;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

public class GridFragment extends Fragment {
	
	protected static final String EXTRA_RES_ID = "POS";
	
	private List<Integer> mThumbNailIDs;
	private GridView mGridview;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mThumbNailIDs = getArguments().getIntegerArrayList(MainActivity.THUMBNAIL_IDS);

	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mGridview.setAdapter(new ImageAdapter(getActivity(), mThumbNailIDs));
	/*	mGridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Intent intent = new Intent(getActivity(),
						ImageViewActivity.class);
				intent.putExtra(EXTRA_RES_ID, (int) id);
				startActivity(intent);
			}
		});*/
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.grid_fragment, container, false);
		mGridview = (GridView) view.findViewById(R.id.gridview);  
		return view;	
	}
	
	
}