package model;

public class VaccinationSite {
private String name;
private int max;
private int nod;
private int nodd;
private int noa;
private boolean administer;
private static int total;
private Vaccine[] distributions = new Vaccine[0];
private Vaccine[] vaccines = new Vaccine[0];
//private Vaccine[] change = new Vaccine[0];
private int[] doses = new int[0]; 
private String[] line = new String[0];


public VaccinationSite(String name, int max) {
	this.name = name;
	this.max = max;
	this.doses = new int[this.max];
}

public int getNumberOfAvailableDoses() {
	
	return this.nod;
}

public int getNumberOfAvailableDoses(String string) {
	for(int i = 0; i < this.nodd; i++) {
		if(this.distributions[i].getName().equals(string)) {
			return this.doses[i];
		}
	}
	
	return 0;
}

public void addDistribution(Vaccine v1, int i) throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException{
	// TODO Auto-generated method stub
	if(v1.getRecognize() == false) {
		throw new UnrecognizedVaccineCodeNameException("");
	}
	
	
	else if(this.nod + i <= this.max) {
	String[] line = new String[this.nodd+1];
	Vaccine[] distributions = new Vaccine[this.nodd+1];
	for(int k = 0; k < this.nodd; k++) {
		line[k] = this.line[k];
		distributions[k] = this.distributions[k];
	}
	
	for(int k = 0; k < this.nodd; k++) {
		/* if(k == this.nodd-1) {
			line[this.nodd] = String.format("%d doses of %s", i, v1.getManu());
			distributions[this.nodd] = v1;
			this.doses[this.nodd] = i;
			this.nodd++;
		} */
		 if(distributions[k].getManu().equals(v1.getManu())) {
			line[k] = String.format("%d doses of %s", i + this.doses[k], v1.getManu());
			this.doses[k] += i;
			this.line = line;
			this.nod += i;
			return;
		 }
	}
			line[this.nodd] = String.format("%d doses of %s", i, v1.getManu());
			distributions[this.nodd] = v1;
			this.doses[this.nodd] = i;
			this.nodd++;
		
	
	this.distributions = distributions;
	this.line = line;
	this.nod += i;
	}else {
		throw new TooMuchDistributionException("");
	}
	
	
}

public void bookAppointment(HealthRecord alan) throws InsufficientVaccineDosesException{
	// TODO Auto-generated method stub
	if(this.noa == this.nod) {
		alan.setStatus(2, this.name);
		throw new InsufficientVaccineDosesException("");
	}
	else {
		alan.setStatus(1, this.name);
		this.noa++;
	}
	
}

public void administer(String string) {
	// TODO Auto-generated method stub
	int count = 0;
	String[] line = new String[this.nodd];
	Vaccine[] distributions = new Vaccine[this.nodd];
	for(int k = 0; k < this.nodd; k++) {
		if(k > this.noa) {
		line[count] = this.line[k];
		distributions[count] = this.distributions[k];
		count++;
		}
	}
	this.line = line;
	this.distributions = distributions;
	this.administer = true;
	this.nod = this.nod - this.noa;
	
	
}

public String toString() {
	String s = "<";
	if(this.nodd > 0) {
		for(int i = 0; i < this.nodd; i++) {
			if(i != this.nodd-1) {
				s += line[i] + ", ";
			}else {
				s += line[i];
			}
		}
		s += ">";
		//"North York General Hospital has 3 available doses: <3 doses of Moderna>"
		return String.format("%s has %d available doses: %s", this.name, this.nod, s);
		
	}
	return String.format("%s has 0 available doses: <>", this.name, this.nod);

}
}
