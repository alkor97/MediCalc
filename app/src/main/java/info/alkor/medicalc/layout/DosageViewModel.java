package info.alkor.medicalc.layout;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import info.alkor.medicalc.BR;
import info.alkor.medicalc.logic.Conversions;
import info.alkor.medicalc.logic.DosageCalculator;

/**
 * View model of dosage calculator.
 * Created by Marlena on 2017-03-22.
 */
public class DosageViewModel extends BaseObservable {

	private final Conversions cvt = new Conversions();
	private final DosageCalculator calculator = new DosageCalculator();

	public String getDose() {
		return cvt.toString(calculator.getDose());
	}

	public void setDose(String value) {
		calculator.setDose(cvt.toInteger(value));
		notifyPropertyChanged(BR.oneDose);
		notifyPropertyChanged(BR.forTreatment);
	}

	public String getMass() {
		return cvt.toString(calculator.getMass());
	}

	public void setMass(String value) {
		calculator.setMass(cvt.toInteger(value));
		notifyPropertyChanged(BR.oneDose);
		notifyPropertyChanged(BR.forTreatment);
	}

	public String getSuspensionMass() {
		return cvt.toString(calculator.getSuspensionMass());
	}

	public void setSuspensionMass(String value) {
		calculator.setSuspensionMass(cvt.toInteger(value));
		notifyPropertyChanged(BR.oneDose);
		notifyPropertyChanged(BR.forTreatment);
	}

	public String getSuspensionVolume() {
		return cvt.toString(calculator.getSuspensionVolume());
	}

	public void setSuspensionVolume(String value) {
		calculator.setSuspensionVolume(cvt.toInteger(value));
		notifyPropertyChanged(BR.oneDose);
		notifyPropertyChanged(BR.forTreatment);
	}

	public String getDosesPerDay() {
		return cvt.toString(calculator.getDosesPerDay());
	}

	public void setDosesPerDay(String value) {
		calculator.setDosesPerDay(cvt.toInteger(value));
		notifyPropertyChanged(BR.oneDose);
		notifyPropertyChanged(BR.forTreatment);
	}

	public String getDays() {
		return cvt.toString(calculator.getDays());
	}

	public void setDays(String value) {
		calculator.setDays(cvt.toInteger(value));
		notifyPropertyChanged(BR.forTreatment);
	}

	@Bindable
	public String getOneDose() {
		return cvt.toString(calculator.getOneDose());
	}

	@Bindable
	public String getForTreatment() {
		return cvt.toString(calculator.getForTreatment());
	}
}
