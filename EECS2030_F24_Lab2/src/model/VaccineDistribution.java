package model;

public class VaccineDistribution {
private Vaccine vaccine;
private int max;

public VaccineDistribution(Vaccine vaccine, int max) {
	this.vaccine = vaccine;
	this.max = max;
}

public String toString() {
	return String.format("%d doses of %s by %s", this.max, this.vaccine.getName(), this.vaccine.getManu());
}


}
