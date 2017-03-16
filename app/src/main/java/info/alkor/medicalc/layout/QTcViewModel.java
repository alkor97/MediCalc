package info.alkor.medicalc.layout;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import info.alkor.medicalc.BR;
import info.alkor.medicalc.logic.Conversions;
import info.alkor.medicalc.logic.QTcCalculator;

/**
 * QTc view model.
 * Created by Marlena on 2017-03-15.
 */
public class QTcViewModel extends BaseObservable {

	private final String[] speedEntries = new String[]{"20", "50"};
	private final String[] intervalUnitEntries = new String[]{QTcCalculator.Unit.box.name(),
			QTcCalculator.Unit.ms.name(), QTcCalculator.Unit.s.name()};
	private final String[] qtcUnitEntries = new String[]{QTcCalculator.Unit.ms.name(),
			QTcCalculator.Unit.s.name()};

	private final Conversions cvt = new Conversions();
	private final QTcCalculator calculator = new QTcCalculator();

	public String getSpeed() {
		return cvt.toString(calculator.getSpeed());
	}

	public void setSpeed(String speed) {
		calculator.setSpeed(cvt.toInteger(speed));
		notifyPropertyChanged(BR.qtcInterval);
	}

	public String getQtInterval() {
		return cvt.toString(calculator.getQtInterval());
	}

	public void setQtInterval(String qtInterval) {
		calculator.setQtInterval(cvt.toDouble(qtInterval));
		notifyPropertyChanged(BR.qtcInterval);
	}

	public String getRrInterval() {
		return cvt.toString(calculator.getRrInterval());
	}

	public void setRrInterval(String rrInterval) {
		calculator.setRrInterval(cvt.toDouble(rrInterval));
		notifyPropertyChanged(BR.qtcInterval);
	}

	public String getIntervalUnit() {
		return cvt.toString(calculator.getIntervalUnit());
	}

	public void setIntervalUnit(String intervalUnit) {
		calculator.setIntervalUnit(cvt.toQtcIntervalUnit(intervalUnit));
		notifyPropertyChanged(BR.qtcInterval);
		notifyPropertyChanged(BR.speedVisible);
	}

	@Bindable
	public String getQtcInterval() {
		return cvt.toString(calculator.getQtcInterval());
	}

	public String getQtcUnit() {
		return cvt.toString(calculator.getQtcUnit());
	}

	public void setQtcUnit(String qtcUnit) {
		calculator.setQtcUnit(cvt.toQtcIntervalUnit(qtcUnit));
		notifyPropertyChanged(BR.qtcInterval);
	}

	public int getSpeedIndex() {
		return indexOf(speedEntries, getSpeed());
	}

	public void setSpeedIndex(int speedIndex) {
		setSpeed(speedEntries[speedIndex]);
	}

	public int getIntervalUnitIndex() {
		return indexOf(intervalUnitEntries, getIntervalUnit());
	}

	public void setIntervalUnitIndex(int intervalUnitIndex) {
		setIntervalUnit(intervalUnitEntries[intervalUnitIndex]);
	}

	public int getQtcUnitIndex() {
		return indexOf(qtcUnitEntries, getQtcUnit());
	}

	public void setQtcUnitIndex(int qtcUnitIndex) {
		setQtcUnit(qtcUnitEntries[qtcUnitIndex]);
	}

	private int indexOf(String[] array, String value) {
		for (int i = 0; i < array.length; ++i) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public String[] getSpeedEntries() {
		return speedEntries;
	}

	public String[] getIntervalUnitEntries() {
		return intervalUnitEntries;
	}

	public String[] getQtcUnitEntries() {
		return qtcUnitEntries;
	}

	@Bindable
	public int getSpeedVisible() {
		boolean visible = QTcCalculator.Unit.box == calculator.getIntervalUnit();
		return visible ? View.VISIBLE : View.GONE;
	}
}
