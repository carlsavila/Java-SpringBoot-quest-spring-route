package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {
    	switch (number) {
    		case 13:
    			return new Doctor(13,"Jodie Whittaker");
    		case 1:	case 2:
    		case 3:	case 4:
    		case 5:	case 6:
    		case 7:	case 8:
    		case 9: case 11:
    		case 12:
				throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Cf. autres");
			default:
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);				   			
    	}
    }

}
