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

	public Integer toInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public String toString(Double value) {
		return value != null ? value.toString() : "";
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
