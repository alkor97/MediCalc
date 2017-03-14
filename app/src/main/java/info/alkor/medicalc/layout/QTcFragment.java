package info.alkor.medicalc.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import info.alkor.medicalc.R;
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

		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_qtc, container, false);
		setupSpeed(view);
		setupIntervalUnit(view);
		setupQTcIntervalUnit(view);
		return view;
	}

	private void setupSpeed(View view) {
		final Spinner spinner = (Spinner) view.findViewById(R.id.qtc_speed);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (spinner.isEnabled()) {
					String value = spinner.getSelectedItem().toString();
					calculator.setSpeed(cvt.toDouble(value));
				} else {
					calculator.setSpeed(null);
				}
				compute();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				calculator.setSpeed(null);
				compute();
			}
		});
	}

	private void setupIntervalUnit(final View view) {
		final Spinner spinner = (Spinner) view.findViewById(R.id.qtc_qt_interval_unit);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String value = spinner.getSelectedItem().toString();
				QTcCalculator.Unit unit = cvt.toQtcIntervalUnit(value);
				view.findViewById(R.id.qtc_speed).setEnabled(unit == QTcCalculator.Unit.box);
				calculator.setIntervalUnit(unit);
				compute();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				calculator.setIntervalUnit(null);
				compute();
			}
		});
	}

	private void setupQTcIntervalUnit(View view) {
		final Spinner spinner = (Spinner) view.findViewById(R.id.qtc_interval_unit);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String value = spinner.getSelectedItem().toString();
				calculator.setQtcUnit(cvt.toQtcIntervalUnit(value));
				compute();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				calculator.setQtcUnit(null);
				compute();
			}
		});
	}

	private void compute() {

	}
}
