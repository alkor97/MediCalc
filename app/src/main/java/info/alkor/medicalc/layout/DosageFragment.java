package info.alkor.medicalc.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.alkor.medicalc.databinding.FragmentDosageBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DosageFragment extends Fragment {

	public DosageFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
			savedInstanceState) {

		FragmentDosageBinding binding = FragmentDosageBinding.inflate(inflater, container, false);
		DosageViewModel model = new DosageViewModel();
		binding.setModel(model);

		return binding.getRoot();
	}
}
