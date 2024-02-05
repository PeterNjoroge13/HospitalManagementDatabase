package HospitalCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalGUI extends JFrame {
    private HospitalDatabase hospitalDatabase = new HospitalDatabase();
    private JTextArea outputTextArea;

    public HospitalGUI() {
        setTitle("Hospital Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GUI components
        JButton addPatientButton = new JButton("Add Patient");
        JButton addDoctorButton = new JButton("Add Doctor");
        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        // Set event handlers for buttons
        addPatientButton.addActionListener(e -> showAddPatientDialog());
        addDoctorButton.addActionListener(e -> showAddDoctorDialog());
        scheduleAppointmentButton.addActionListener(e -> showScheduleAppointmentDialog());

        // Layout setup
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(addPatientButton);
        panel.add(addDoctorButton);
        panel.add(scheduleAppointmentButton);
        panel.add(new JScrollPane(outputTextArea));

        // Add the panel to the frame
        add(panel);

        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void showAddPatientDialog() {
        String name = JOptionPane.showInputDialog("Enter patient name:");
        hospitalDatabase.addPatient(name, 0, "", "", "");
        updateOutputTextArea();
    }

    private void showAddDoctorDialog() {
        String name = JOptionPane.showInputDialog("Enter doctor name:");
        hospitalDatabase.addDoctor(name, 0, "");
        updateOutputTextArea();
    }

    private void showScheduleAppointmentDialog() {
        JTextField patientNameField = new JTextField();
        JTextField doctorNameField = new JTextField();
        JTextField timeField = new JTextField();

        Object[] message = {
                "Patient Name:", patientNameField,
                "Doctor Name:", doctorNameField,
                "Appointment Time:", timeField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Schedule Appointment", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String result = patientNameField.getText() + " with " + doctorNameField.getText() + " at " + timeField.getText();
            hospitalDatabase.addAppointment(patientNameField.getText(), doctorNameField.getText(), timeField.getText());
            updateOutputTextArea();
        }
    }

    private void updateOutputTextArea() {
        outputTextArea.setText(hospitalDatabase.getAllPatientInfo() + "\n" + hospitalDatabase.getAllDoctorsInfo());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalGUI());
    }
}