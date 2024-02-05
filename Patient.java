package HospitalCode;

import java.util.*;

public class Patient implements Comparable <Patient> {
	private String name;
	private int dob;
	private String address;
	private String insurance;
	private ArrayList<String> medication = new ArrayList<>();
	private String email;

	public Patient(String name, int dob, String address, String email, String insurance) {
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.insurance = insurance;
		this.email = email;
		medication = new ArrayList<String>();

	}

	public String toString() {
		
		String x = "Name: " + this.name  + "\n" +"Date of Birth: "+this.dob+  
				"\n" +"Address: " + this.address  + "\n" + "Insurance: " +
				this.insurance + "\n"
		+ "Email :" + this.email + "\n" + "Medication: "+ medication.toString() ;
		return x;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDOB() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
public void addMedication(String perscription) {
	medication.add(perscription);
}
	public void removeMedication(String perscription) {
		medication.remove(perscription);
}
	public ArrayList<String> getMedication() {
		return medication;
	}

	public void setMedication(ArrayList<String> medication) {
		this.medication = medication;
	}
	public int compareTo(Patient p) {
		return name.compareTo(p.name);
	}
}
	