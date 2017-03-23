package info.alkor.medicalc.logic;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Conversion utilities.
 * Created by Marlena on 2017-03-14.
 */
public class Conversions {
	private final NumberFormat DOUBLE_FORMAT = new DecimalFormat("#.##");

	public Double toDouble(String value) {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public Integer toInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public String toString(Double value) {
		return toString(value, DOUBLE_FORMAT);
	}

	private String toString(Double value, @NonNull NumberFormat format) {
		return value != null ? format.format(value) : "";
	}

	public String toString(Integer value) {
		return value != null ? value.toString() : "";
	}

	public QTcCalculator.Unit toQtcIntervalUnit(String value) {
		try {
			return QTcCalculator.Unit.valueOf(value);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public String toString(QTcCalculator.Unit value) {
		return value != null ? value.name() : "";
	}
}
