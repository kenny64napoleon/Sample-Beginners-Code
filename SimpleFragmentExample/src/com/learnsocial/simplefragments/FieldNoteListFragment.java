package com.learnsocial.simplefragments;

import android.app.*;
import android.view.*;
import android.widget.*;
import android.os.*;


/*public class SimpleFragmentExample extends Fragment 
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) 
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.exampleFragment, container, false);
    }
    
    
}*/

public class FieldNoteListFragment extends ListFragment implements FragmentManager.OnBackStackChangedListener 
{

	//variables
	private static final String DEBUG_TAG = "FieldNoteListFragment";
	int mCurPosition = - 1;
	boolean mShowTwoFragments;
	
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		String[] fieldNotes = getResources().getStringArray(R.array.fieldnotes_array);
		
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, fieldNotes));
		
		View detailsFrame = getActivity().findViewById(R.id.fieldentry);
		
		mShowTwoFragments = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
		
			if(savedInstanceState != null) {
				
				mCurPosition = savedInstanceState.getInt("curChoice", 0);
				
			}
			
			if(mShowTwoFragments == true || mCurPosition != -1) {
				
				viewAnimalInfo(mCurPosition);
				
			}
		
		
	}
	
		@Override
		public void onBackStackChanged() {
			// TODO Auto-generated method stub
			
		}
		
		
		private void viewAnimalInfo(int mCurPosition2) {
			// TODO Auto-generated method stub
			mCurPosition = index;
			
			if (mShowTwoFragments == true){
				FieldNoteWebViewFragment details = (FieldNoteWebViewFragment) getFragmentManager().findFragmentById(R.id.fieldentry);
				
				
			}
		}
	
		public void onSaveInstanceState(Bundle outState){
			super.onSaveInstanceState(outState);
			outState.putInt("curChoice", mCurPosition);
		}
	
		public void onListItemCLick(ListView 1, View v, int position, long id){
			viewAnimalInfo(position);
		}
		
   

}//end of class body