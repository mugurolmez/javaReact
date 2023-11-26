package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.dtos.requests.UpdateCvRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllCvsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Cvs")
public class CvControllers {

}
