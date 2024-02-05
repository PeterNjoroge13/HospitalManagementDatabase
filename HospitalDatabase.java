package HospitalCode;

import java.util.*;

public class HospitalDatabase {
	private ArrayList<Patient> allPatients = new ArrayList<Patient>();
	private ArrayList<Doctor> allDoctors = new ArrayList<Doctor>();


	public void addDoctor(String name, int yearsExperince, String email, String specialization) {
		Doctor doctor = new Doctor(name, yearsExperince, email, specialization);
		allDoctors.add(doctor);
	}

	public void addPatient(String name, int age, String address, String email, String insurance) {
		Patient patient = new Patient(name, age, address, email, insurance);
		allPatients.add(patient);
	}

	public String getAllPatientInfo() {
		Collections.sort(allPatients);
		String answer = "***** All Hospital Patients *****" + "\n";
		for (int i = 0; i < allPatients.size(); i++) {
			answer += allPatients.get(i) + "\n";
		}
		return answer;
	}

	public String getAllDoctorsInfo() {
		Collections.sort(allDoctors);
		String answer = "***** Doctor's Information *****" + "\n";
		for (int i = 0; i < allDoctors.size(); i++) {
			answer += allDoctors.get(i) + "\n";
		}
		return answer;
	}
	public String addAppointment(String patientName, String doctorName,String time ) {
		if (findPatient(patientName) != -1 && findDoctor(doctorName)!= -1) {
			allDoctors.get(findDoctor(doctorName)).addAppointment(patientName + time);
			return "Appointment Set for" + patientName+ " With Doctor "+ doctorName + "at" +time;
		}
		else {
		return "Invalid Patient/Doctor";
		}
	}

	public void addPerscription(String perscription, String patientName) {
		if (findPatient(patientName) != -1) {
		allPatients.get(findPatient(patientName)).addMedication(perscription);
		}
		else {
			System.out.println("No Patient avaliable");
		}
	}

	public void removePerscription(String perscription, String patientName) {
		if (findPatient(patientName) != -1) {
		allPatients.get(findPatient(patientName)).removeMedication(perscription);
		}
		else {
			System.out.println("No Patient avaliable");
		}
	}
	

	private int findDoctor(String doctorName) {
		if (doctorName == null || doctorName.isBlank()) {
			return -1;
		} else {
			for (int i = 0; i < allDoctors.size(); i++) {
				if (doctorName.equals(allDoctors.get(i).getName())) {
					return i;
				}
			}
		}
		return -1;
	}

	private int findPatient(String patientName) {
		if (patientName == null || patientName.isBlank()) {
			return -1;
		} else {
			for (int i = 0; i < allPatients.size(); i++) {
				if (patientName.equals(allPatients.get(i).getName())) {
					return i;
				}
			}
		}
		return -1;
	}

}
