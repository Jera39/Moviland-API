package moviland.com.demo.Service;

import moviland.com.demo.Model.Celular;
import moviland.com.demo.Repository.CelularRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CelularService {
    HashMap<String,Object> data;
    private final CelularRepository celularRepository;

    public CelularService(CelularRepository celularRepository){
        this.celularRepository = celularRepository;
    }
    public List<Celular>getCelulars(){
		return this.celularRepository.findByEstadoTrue();
	}

	public Celular buscarCelular(Integer id){
		Optional<Celular> opcional = celularRepository.findById(id);
		Celular celular=null;
		if(opcional.isPresent()) {
			celular = opcional.get();
		}else {
			throw new RuntimeException("No existe celular con este ID: "+ id);
		}
		return celular;
	}

    public ResponseEntity<Object> nuevoCelular(Celular celular){
		data = new HashMap<>();
		Optional<Celular> cel = celularRepository.findById(celular.getId());
		if(cel.isPresent()&&  celular.getId() == null) {
			data.put("error", true);
			data.put("message","error de id");
			return new ResponseEntity(data,HttpStatus.CONFLICT);
		}
		data.put("message","Datos guardados");
		if(celular.getId() != null) {
			data.put("message","Datos actualizados");
		}
		celularRepository.save(celular);
		data.put("datos", celular);
		return new ResponseEntity(data,HttpStatus.CREATED);
	}

	public ResponseEntity<Object> desabilitarCelular(Integer id){
		data = new HashMap<>();
		boolean exists = this.celularRepository.existsById(id);
		if(!exists) {
			data.put("error", true);
			data.put("message", "ID no valido");
			return new ResponseEntity(data,HttpStatus.CONFLICT);
		}
		celularRepository.updateEstado(id,false);
		data.put("message", "Celular desabilitado con éxito");
		return new ResponseEntity(data,HttpStatus.ACCEPTED);
	}
   
	
   
}
