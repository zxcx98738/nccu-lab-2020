package tw.edu.nccu.ctl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class GreetingCtl {

	@Value("${lab.student}")
	private String student;

	@GetMapping(path = "/", produces = "application/json; charset=UTF-8")
	public ResponseEntity<GreetingResponse> greeting() {
		log.info(student);
		StringBuilder sentence = new StringBuilder();
		sentence.append("Hello ").append(student).append(". Welcom to 2020 NCCU LAB!");
		GreetingResponse response = new GreetingResponse("200", "OK", sentence.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
