package layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.alkor.medicalc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DosageFragment extends Fragment {

	public DosageFragment() {
		// TODO: use Fragment.setArgumentsBundle
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
			savedInstanceState) {

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_dosage, container, false);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
