package info.alkor.medicalc.logic;

/**
 * Conversion utilities.
 * Created by Marlena on 2017-03-14.
 */
public class Conversions {
	public Double toDouble(String value) {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public QTcCalculator.Unit toQtcIntervalUnit(String value) {
		try {
			return QTcCalculator.Unit.valueOf(value);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}
