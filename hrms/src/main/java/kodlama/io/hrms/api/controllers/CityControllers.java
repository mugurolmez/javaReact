package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.business.dtos.requests.AddCityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Cities")
public class CityControllers {

    private CityService cityService;

    @Autowired
    public CityControllers(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddCityRequest addCityRequest) {

        return ResponseEntity.ok(this.cityService.add(addCityRequest));
    }
}
