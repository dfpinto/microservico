package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerRecource {

	private Logger logger = LoggerFactory.getLogger(WorkerRecource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@Autowired
	private Environment env;

	@GetMapping("/configs")
	public ResponseEntity<Void> getConfig() {
		logger.info("CONFIG: "+testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Integer id) {
		
		/* Interrompe o serviço de propósotio para teste de fluxo alternativo usando hystrix.
		int i = 0;
		if(i == 0) {
			throw new RuntimeException("Test");
		}
		*/
		
		/* Conta 3 segundos simulando demora na resposta do serviço.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		logger.info("PORT: " + env.getProperty("local.server.port"));
		
		Worker obj = workerRepository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
