package py.edu.ucsa.rest.api.core.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import py.edu.ucsa.rest.api.core.model.UsuarioDTO;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	private static final AtomicLong counter = new AtomicLong();
	private static List<UsuarioDTO> usuarios;
	static {
		usuarios = crearUsuariosEnMemoria();
	}
	
	@Override
	public UsuarioDTO getById(long id) {
		for(UsuarioDTO user : usuarios) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	private static List<UsuarioDTO> crearUsuariosEnMemoria() {
//		return Arrays.asList(new UsuarioDTO(counter.incrementAndGet(), "JUAN", "SANCHEZ", "ASUNCION 234", 30, "jsanchez", "123" ), 
//				new UsuarioDTO(counter.incrementAndGet(), "Andres", "Planas", "Zurbaran 949", 26, "aplanas", "andres91*"),
//				new UsuarioDTO(counter.incrementAndGet(), "Agustina", "Trinidad", "Doctor Montero 985", 25, "atrinidad", "agustina92*"));
		List<UsuarioDTO> usuarios = new ArrayList<>();
		usuarios.add(new UsuarioDTO(counter.incrementAndGet(), "JUAN", "SANCHEZ", "ASUNCION 234", 30, "jsanchez", "123" ));
		usuarios.add(new UsuarioDTO(counter.incrementAndGet(), "Andres", "Planas", "Zurbaran 949", 26, "aplanas", "andres91*"));
		usuarios.add(new UsuarioDTO(counter.incrementAndGet(), "Agustina", "Trinidad", "Doctor Montero 985", 25, "atrinidad", "agustina92*"));
		return usuarios;
	}

	@Override
	public UsuarioDTO getByUsuario(String name) {
		for(UsuarioDTO u: usuarios) {
			if(u.getUsuario().equalsIgnoreCase(name)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public void crearUsuario(UsuarioDTO user) {
		user.setId(counter.incrementAndGet());
		usuarios.add(user);

	}

	@Override
	public void actualizarUsuario(UsuarioDTO user) {
		int index = usuarios.indexOf(user);
		usuarios.set(index, user);

	}

	@Override
	public void eliminarUsuarioById(long id) {
		for(Iterator<UsuarioDTO> iterator = usuarios.iterator(); iterator.hasNext();) {
			UsuarioDTO u = iterator.next();
			if(u.getId() == id) {
				iterator.remove();
			}
		}

	}

	@Override
	public List<UsuarioDTO> listarTodos() {
		return usuarios;
	}

	@Override
	public void eliminarTodos() {
		usuarios.clear();

	}

	@Override
	public boolean isExisteUsuario(UsuarioDTO user) {
		return getByUsuario(user.getUsuario())!= null;
	}

}
