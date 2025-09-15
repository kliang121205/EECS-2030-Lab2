package model;

public class HealthRecord {
private String name;
private int max;
private int nod;
private int status;
private String site;
private String[] records = new String[0];

public HealthRecord(String name, int max) {
	this.name = name;
	this.max = max;
	records = new String[this.max];
}

public String getVaccinationReceipt() {
	String s = "";
	if(this.nod > 0) {
		for(int i = 0; i < this.nod; i++) {
			if(i == this.nod-1) {
				s += records[i];
			}else {
				s += records[i] + "; ";
			}
		}
		return String.format("Number of doses %s has received: %d [%s]", this.name, this.nod, s);
	}
	return String.format("%s has not yet received any doses.", this.name);
}

public void setStatus(int status, String site) {
	this.status = status;
	this.site = site;
}

public String getAppointmentStatus() {
	if(this.status == 1) {
		return String.format("Last vaccination appointment for %s with %s succeeded", this.name, this.site);
	}
	if(status == 2) {
		return String.format("Last vaccination appointment for %s with %s failed", this.name, this.site);
	}
	return String.format("No vaccination appointment for %s yet", this.name);
}

public void addRecord(Vaccine v1, String string, String string2) {
	this.records[this.nod] = String.format("Recognized vaccine: %s (RNA; %s) in %s on %s", v1.getName(), v1.getManu(), string, string2);
	this.nod++;
	
	
}





}
