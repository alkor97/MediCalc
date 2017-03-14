package info.alkor.medicalc.logic;

/**
 * Q-Tc calculator.
 * Created by Marlena on 2017-03-14.
 */
public class QTcCalculator {

	private Double speed;
	private Double qtInterval;
	private Double rrInterval;
	private Unit intervalUnit;
	private Double qtcInterval;
	private Unit qtcUnit;

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public void setQtInterval(Double qtInterval) {
		this.qtInterval = qtInterval;
	}

	public void setRrInterval(Double rrInterval) {
		this.rrInterval = rrInterval;
	}

	public void setIntervalUnit(Unit intervalUnit) {
		this.intervalUnit = intervalUnit;
	}

	public void setQtcUnit(Unit qtcUnit) {
		this.qtcUnit = qtcUnit;
	}

	public Double getQtcInterval() {
		if (intervalUnit == null || (intervalUnit == Unit.box && speed == null) || qtInterval ==
				null || rrInterval == null || qtcUnit == null) {
			return null;
		}
		double p = intervalUnit == Unit.box ? speed : 1;
		double qt = qtInterval * intervalUnit.getQuotient() / p;
		double rr = rrInterval * intervalUnit.getQuotient() / p;
		qtcInterval = qt / Math.sqrt(rr) / qtcUnit.getQuotient();

		return qtcInterval;
	}

	public enum Unit {
		ms(0.001), s(1), box(1);

		private final double quotient;

		Unit(double quotient) {
			this.quotient = quotient;
		}

		public double getQuotient() {
			return quotient;
		}
	}
}
