package com.management.personacovid.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.personacovid.config.SecurityConfiguration;
import com.management.personacovid.model.Appointment;
import com.management.personacovid.model.Doctor;
import com.management.personacovid.model.Patient;
import com.management.personacovid.repository.AppointmentRepository;
import com.management.personacovid.service.AppointmentService;
import com.management.personacovid.service.DoctorService;
import com.management.personacovid.service.PatientService;

@Controller
public class AppointmentController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorService docService;

	// create model attribute to bind form data
	@GetMapping("/showNewAppointmentForm")
	public String showNewAppointmentForm(Model model) {
		Patient user = patientService.getPatientByEmail(SecurityConfiguration.getLogUser());

		if (user.getAppointmentNO() == 0 || user.getAppointmentNO() == -1) {

			Appointment appointment = new Appointment();
			List<Doctor> doctor = docService.getAllDoctor();
			model.addAttribute("appointment", appointment);
			model.addAttribute("doctor", doctor);
			return "new_appoint";

		} else {
			model.addAttribute("error", "You have Already scheduled an Appointment");
			return "index";

		}

	}

	// save appointment to database
	@PostMapping("/saveAppointment")
	public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {

		Patient user = patientService.getPatientByEmail(SecurityConfiguration.getLogUser());

		appointment.setP_id(user.getId()); // To update patientId in the Appointment table
		appointmentService.saveAppointment(appointment);
		patientService.updatePatientAppDetails(appointment.getA_id(), user.getId()); // To update AppointmentNo in the
																						// Patient Table

		return "redirect:/";
	}

	// To view AppointmentDetails
	@GetMapping("/viewAppointmentDetails")
	public String viewAppointmentDetails(Model model) {

		Patient user = patientService.getPatientByEmail(SecurityConfiguration.getLogUser());

		if (user.getAppointmentNO() == 0 || user.getAppointmentNO() == -1) {

			model.addAttribute("error", "You have not scheduled an Appointment. Please schedule your Appointment!!");
			return "index";

		} else {

			Appointment listAppointment = appointmentService.viewAppointmentDetails(user.getId());
			model.addAttribute("listAppointment", listAppointment);
			return "view_appoint";

		}
		
	}

	@GetMapping("/showFormForUpdate/{a_id}")
	public String showFormForUpdate(@PathVariable(value = "a_id") long id, Model model) {

		Appointment appointment = appointmentService.getAppointmentById(id); // Get Appointment details from the service
		List<Doctor> doctor = docService.getAllDoctor();
		model.addAttribute("appointment", appointment); // Set Appointment as a model attribute to pre-populate the form
		model.addAttribute("doctor", doctor);

		return "update_appointment";
	}

	// Save updated appointment to database
	@PostMapping("/updateAppointment")
	public String updateAppointment(@ModelAttribute("appointment") Appointment appointment) {

		Patient user = patientService.getPatientByEmail(SecurityConfiguration.getLogUser());

		appointmentRepository.updateAppointment(user.getId(), appointment.getDate(),appointment.getDoctor().getD_id());

		return "redirect:/";
	}

	// To delete an Appointment
	@GetMapping("/deleteAppointment/{id}")
	public String deleteAppointment(@PathVariable(value = "id") long id) {

		Patient user = patientService.getPatientByEmail(SecurityConfiguration.getLogUser());

		appointmentRepository.deleteAppointment(user.getAppointmentNO());
		patientService.updatePatientAppDetails(-1, user.getId());

		return "redirect:/";
	}

}
