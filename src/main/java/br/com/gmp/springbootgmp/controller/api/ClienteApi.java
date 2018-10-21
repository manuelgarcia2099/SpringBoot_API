package br.com.gmp.springbootgmp.controller.api;

import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gmp.springbootgmp.model.Cliente;
import br.com.gmp.springbootgmp.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteApi {
	
		@Autowired
		private ClienteService service;
		
		@GetMapping
		public ResponseEntity<List<Cliente>> clientes(){
			List<Cliente> clientes = service.clientes();
			
			if(clientes != null && !clientes.isEmpty()) {
				return  new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
			}
			
			return  new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT); //Status: 204
			
		
		}
		
		@RequestMapping(method= {PUT, POST, PATCH}) // Put mando todos los atributos del objeto / Patch, mudo sólo algunos atributos del objeto!!
		public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) { //@RequestBody, es sólo decirle que viene en formato JSon
			
			cliente = service.salvar(cliente);
			return new ResponseEntity<>(HttpStatus.OK); //Status: 200
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?>  deletar(@PathVariable Long id) { //PathVariable es que este long id es el id de arriba enel DeleteMapping
			service.deletar(id);
			return new ResponseEntity<>(HttpStatus.OK); //Status: 200 
			
		}
		
		@GetMapping("/{id}")
		public  ResponseEntity<?> buscar(@PathVariable Long id) {
			
			Cliente cliente = service.cliente(id);
			if(cliente!=null) {
				return new ResponseEntity<Cliente>(cliente, HttpStatus.OK); //Status: 200
			}
			return new ResponseEntity<Cliente>(cliente, HttpStatus.NO_CONTENT); //Status: 204
		}
		


}
