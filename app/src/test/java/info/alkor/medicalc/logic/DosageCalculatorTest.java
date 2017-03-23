package info.alkor.medicalc.logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests of dosage calculator.
 * Created by Marlena on 2017-03-22.
 */
public class DosageCalculatorTest {
	@Test
	public void test() {
		DosageCalculator c = new DosageCalculator();
		Assert.assertEquals(8.1, c.getOneDose(), 0.1);
		Assert.assertEquals(113.99, c.getForTreatment(), 0.01);
	}
}
