package moviland.com.demo.Service;

import moviland.com.demo.Model.Celular;
import moviland.com.demo.Repository.CelularRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CelularService {
    HashMap<String,Object> data;
    private final CelularRepository celularRepository;

    public CelularService(CelularRepository celularRepository){
        this.celularRepository = celularRepository;
    }
    public List<Celular>getCelulars(){
		return this.celularRepository.findByEstadoTrue();
	}

	public List<Celular>getCelularsPorMarca(String marca){
		return this.celularRepository.celularesPorMarca(marca);
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

    public Celular nuevoCelular(Celular celular){
		return celularRepository.save(celular);
	}

	public boolean desabilitarCelular(Integer id){
		try {
            celularRepository.updateEstado(id,false);
            return true;
        } catch (Exception errException) {
            return false;
        }
	}
	public Optional<Celular> obtenerPorId(Integer id) {
		return celularRepository.findById(id);
	}
   
	
   
}
