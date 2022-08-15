package co.com.xmen.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.xmen.XmenApplication;
import co.com.xmen.controller.entity.ValidADNRequest;
import co.com.xmen.service.ADNService;

@RestController
@RequestMapping(XmenApplication.Version + "/adn")
@Validated
public class XMen implements IXMen {

	@Autowired
	private ADNService adnService;

	@PostMapping(path = "mutant", produces = "application/json")
	public ResponseEntity<?> validADN(@RequestBody ValidADNRequest validADNRequest) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(adnService.validADN(validADNRequest), OK);
	}

}
