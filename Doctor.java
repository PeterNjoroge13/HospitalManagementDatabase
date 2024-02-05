package HospitalCode;

import java.util.*;



public class Doctor implements Comparable  <Doctor> {
	private String name;
	private int yearsExperince;
	private String specialization;
	private String email;
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	private ArrayList<String> appointment = new ArrayList<String>();



	public Doctor(String name, int yearsExperince, String email, String specialization) {
		this.name = name;
		this.yearsExperince = yearsExperince;
		this.specialization = specialization;
		this.email = email;
		patients = new ArrayList<Patient>();
		appointment = new ArrayList<String>();
		
	}

	public void addPatient(Patient name) {
		patients.add(name);
	}

	public String toString() {

		String x = "Name: " + this.name + "\n" + "Years of Experience: " + this.yearsExperince + "\n"
				+ "Specialization:  " + this.specialization + "\n" + "Email :" + this.email + "\n" + "Patients: "
				+ patients.toString();
		return x;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearsExperince() {
		return yearsExperince;
	}

	public void setYearsExperince(int yearsExperince) {
		this.yearsExperince = yearsExperince;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	public int compareTo(Doctor doc) {
		return name.compareTo(doc.name);
	}
	public ArrayList<String> getAppointment() {
		return appointment;
	}
	public void addAppointment(String patientName) {
		appointment.add(patientName);
	}
	public void removeAppointment(String patientName) {
		appointment.remove(patientName);
	}
	
}
