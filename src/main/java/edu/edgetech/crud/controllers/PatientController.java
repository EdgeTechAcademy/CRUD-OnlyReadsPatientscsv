package edu.edgetech.crud.controllers;

import edu.edgetech.crud.models.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {
    //  this is going to be our database.
    //  the constructor for our controller will load this List on startup
    private List<Patient> patients;

    //  Constructor for our patients page Controller
    //  this Constructor is called by Spring and will read our 'Database' to have ready for us as needed
    public PatientController() {
        patients = Patient.loadRecords("C:/Projects/csv/patients.csv");
    }

    /**
     *      index
     *          endpoint will be: /patients/
     *
     *          This is the home page for the patient web pages
     *          initially it will display all patients in our roster
     *
     * @param model     model will hold the data that goes to the next page
     * @return          returns the name of the page to merge with the data in the model object
     *                  this will be the patientList page
     */
    @RequestMapping("/")                                    //  this code will be reached by /patients/
    public String index(Model model) {
        //  this means as long as we provide a list of patients
        //  to the "patients" attribute
        model.addAttribute("patients", patients);

        //  the the patientList page will be happy to display it
        return "patientList";
    }
}
