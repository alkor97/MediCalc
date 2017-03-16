package info.alkor.medicalc.logic;

/**
 * Q-Tc calculator.
 * Created by Marlena on 2017-03-14.
 */
public class QTcCalculator {

	private Integer speed = 25;
	private Double qtInterval = 5.0;
	private Double rrInterval = 3.0;
	private Unit intervalUnit = Unit.box;
	private Unit qtcUnit = Unit.ms;

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Double getQtInterval() {
		return qtInterval;
	}

	public void setQtInterval(Double qtInterval) {
		this.qtInterval = qtInterval;
	}

	public Double getRrInterval() {
		return rrInterval;
	}

	public void setRrInterval(Double rrInterval) {
		this.rrInterval = rrInterval;
	}

	public Unit getIntervalUnit() {
		return intervalUnit;
	}

	public void setIntervalUnit(Unit intervalUnit) {
		this.intervalUnit = intervalUnit;
	}

	public Unit getQtcUnit() {
		return qtcUnit;
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
		return qt / Math.sqrt(rr) / qtcUnit.getQuotient();
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
