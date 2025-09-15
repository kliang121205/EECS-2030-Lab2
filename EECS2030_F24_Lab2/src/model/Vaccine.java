package model;

public class Vaccine {
private String codename;
private String type;
private String manufacturer;
private boolean recognize;
private String[] recognized = {"Moderna", "Pfizer/BioNTech", "Janssen", "Oxford/AstraZeneca"};

public Vaccine(String codename, String type, String manufacturer) {
	
	for(int i = 0; i < this.recognized.length; i++) {
		if(manufacturer.equals(this.recognized[i])) {
			this.recognize = true;
		}
	}
	this.codename = codename;
	this.type = type;
	this.manufacturer = manufacturer;
}

public String getName() {
	return this.codename;
}

public boolean getRecognize() {
	return this.recognize;
}

public String getManu() {
	return this.manufacturer;
}

public String toString() {
	if(this.recognize == true) {
		return String.format("Recognized vaccine: %s (%s; %s)", this.codename, this.type, this.manufacturer);
	}else {
		return String.format("Unrecognized vaccine: %s (%s; %s)", this.codename, this.type, this.manufacturer);
	}
	

	}
}
