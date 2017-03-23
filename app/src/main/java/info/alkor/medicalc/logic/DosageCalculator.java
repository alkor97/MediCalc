package info.alkor.medicalc.logic;

/**
 * Dosage calculator.
 * Created by Marlena on 2017-03-22.
 */
public class DosageCalculator {

	private Integer dose = 30;
	private Integer mass = 27;
	private Integer suspensionMass = 250;
	private Integer suspensionVolume = 5;
	private Integer dosesPerDay = 2;
	private Integer days = 7;

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}

	public Integer getMass() {
		return mass;
	}

	public void setMass(Integer mass) {
		this.mass = mass;
	}

	public Integer getSuspensionMass() {
		return suspensionMass;
	}

	public void setSuspensionMass(Integer suspensionMass) {
		this.suspensionMass = suspensionMass;
	}

	public Integer getSuspensionVolume() {
		return suspensionVolume;
	}

	public void setSuspensionVolume(Integer suspensionVolume) {
		this.suspensionVolume = suspensionVolume;
	}

	public Integer getDosesPerDay() {
		return dosesPerDay;
	}

	public void setDosesPerDay(Integer dosesPerDay) {
		this.dosesPerDay = dosesPerDay;
	}

	public Double getOneDose() {
		if (dose == null || mass == null || suspensionVolume == null || suspensionMass == null ||
				dosesPerDay == null) {
			return null;
		}
		return dose * mass * suspensionVolume / (double) (suspensionMass * dosesPerDay);
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Double getForTreatment() {
		if (days == null || getOneDose() == null || dosesPerDay == null) {
			return null;
		}
		return days * getOneDose() * dosesPerDay;
	}
}
