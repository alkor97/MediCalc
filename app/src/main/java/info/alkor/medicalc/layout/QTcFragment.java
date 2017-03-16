package info.alkor.medicalc.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.alkor.medicalc.databinding.FragmentQtcBinding;
import info.alkor.medicalc.logic.Conversions;
import info.alkor.medicalc.logic.QTcCalculator;

/**
 * A simple {@link Fragment} subclass.
 */
public class QTcFragment extends Fragment {

	private final Conversions cvt = new Conversions();
	private final QTcCalculator calculator = new QTcCalculator();

	public QTcFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
			savedInstanceState) {

		FragmentQtcBinding binding = FragmentQtcBinding.inflate(inflater, container, false);
		QTcViewModel model = new QTcViewModel();
		binding.setModel(model);

		return binding.getRoot();
	}
}
