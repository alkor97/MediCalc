package info.alkor.medicalc.logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests of Q-Tc calculator.
 * Created by Marlena on 2017-03-14.
 */
public class QTcCalculatorTest {

	private double getError(QTcCalculator.Unit unit) {
		if (unit == QTcCalculator.Unit.ms) {
			return 0.001;
		}
		return 0.000001;
	}

	@Test
	public void testAllDataAvailableWithBoxInput() {
		QTcCalculator c = new QTcCalculator();
		c.setSpeed(25);
		c.setQtInterval(5.0);
		c.setRrInterval(3.0);
		c.setIntervalUnit(QTcCalculator.Unit.box);

		c.setQtcUnit(QTcCalculator.Unit.s);
		Assert.assertEquals(0.5773502691896258, c.getQtcInterval(), getError(QTcCalculator.Unit
				.s));

		c.setQtcUnit(QTcCalculator.Unit.ms);
		Assert.assertEquals(577.3502691896258, c.getQtcInterval(), getError(QTcCalculator.Unit
				.ms));
	}

	@Test
	public void testAllDataAvailableWithMsInput() {
		QTcCalculator c = new QTcCalculator();
		c.setSpeed(null);
		c.setQtInterval(5.0);
		c.setRrInterval(3.0);
		c.setIntervalUnit(QTcCalculator.Unit.ms);

		c.setQtcUnit(QTcCalculator.Unit.s);
		Assert.assertEquals(0.09128709291752768, c.getQtcInterval(), getError(QTcCalculator.Unit
				.s));

		c.setQtcUnit(QTcCalculator.Unit.ms);
		Assert.assertEquals(91.28709291752767, c.getQtcInterval(), getError(QTcCalculator.Unit
				.ms));
	}

	@Test
	public void testAllDataAvailableWithSInput() {
		QTcCalculator c = new QTcCalculator();
		c.setSpeed(null);
		c.setQtInterval(5.0);
		c.setRrInterval(3.0);
		c.setIntervalUnit(QTcCalculator.Unit.s);

		c.setQtcUnit(QTcCalculator.Unit.s);
		Assert.assertEquals(2.886751345948129, c.getQtcInterval(), getError(QTcCalculator.Unit.s));

		c.setQtcUnit(QTcCalculator.Unit.ms);
		Assert.assertEquals(2886.7513459481293, c.getQtcInterval(), getError(QTcCalculator.Unit
				.ms));
	}

	@Test
	public void testNullInput() {
		QTcCalculator c = new QTcCalculator();
		Assert.assertNull(c.getQtcInterval());

		c.setSpeed(25);
		Assert.assertNull(c.getQtcInterval());

		c.setIntervalUnit(QTcCalculator.Unit.box);
		Assert.assertNull(c.getQtcInterval());

		c.setQtInterval(15.0);
		Assert.assertNull(c.getQtcInterval());

		c.setRrInterval(13.0);
		Assert.assertNull(c.getQtcInterval());

		c.setQtcUnit(QTcCalculator.Unit.ms);
		Assert.assertNotNull(c.getQtcInterval());
	}
}
