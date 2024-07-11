package br.com.apeb.PeoplePlus.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.apeb.PeoplePlus.configuration.JwtTokenUtil;

@RestController
public class AuthContoller {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/token") //http://localhost:8081/token?username=NOME
	public ResponseEntity<?> createToken(@RequestParam String username){
		String token = jwtTokenUtil.createToken(username);
		return ResponseEntity.ok(token);
	}
	
}