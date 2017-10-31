package py.edu.ucsa.rest.api.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.rest.api.core.dao.UsuarioDao;
import py.edu.ucsa.rest.api.core.model.Usuario;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
//	private static final AtomicLong counter = new AtomicLong();
//	private static List<UsuarioDTO> usuarios;
//	static {
//		usuarios = crearUsuariosEnMemoria();
//	}
	
	@Autowired
	private UsuarioDao dao;
	
	@Override
	public Usuario getById(long id) {
		return dao.getById((int)id);
	}

//	private static List<UsuarioDTO> crearUsuariosEnMemoria() {
////		return Arrays.asList(new UsuarioDTO(counter.incrementAndGet(), "JUAN", "SANCHEZ", "ASUNCION 234", 30, "jsanchez", "123" ), 
////				new UsuarioDTO(counter.incrementAndGet(), "Andres", "Planas", "Zurbaran 949", 26, "aplanas", "andres91*"),
////				new UsuarioDTO(counter.incrementAndGet(), "Agustina", "Trinidad", "Doctor Montero 985", 25, "atrinidad", "agustina92*"));
//		List<UsuarioDTO> usuarios = new ArrayList<>();
//		usuarios.add(new UsuarioDTO(counter.incrementAndGet(), "JUAN", "SANCHEZ", "ASUNCION 234", 30, "jsanchez", "123" ));
//		usuarios.add(new UsuarioDTO(counter.incrementAndGet(), "Andres", "Planas", "Zurbaran 949", 26, "aplanas", "andres91*"));
//		usuarios.add(new UsuarioDTO(counter.incrementAndGet(), "Agustina", "Trinidad", "Doctor Montero 985", 25, "atrinidad", "agustina92*"));
//		return usuarios;
//	}

	@Override
	public Usuario getByUsuario(String name) {
		return dao.getByUsuario(name);
	}

	@Override
	public void guardarUsuario(Usuario user) {
		if (user.getId() != null) {
			dao.insertar(user);
		}else {
			dao.actualizar(user);
		}

	}

//	@Override
//	public void actualizarUsuario(UsuarioDTO user) {
//		int index = usuarios.indexOf(user);
//		usuarios.set(index, user);
//
//	}

	@Override
	public void eliminarUsuarioById(long id) {	
	}

	@Override
	public List<Usuario> listarTodos() {
		return dao.listarTodos();
	}

	@Override
	public void eliminarTodos() {
	}

	@Override
	public boolean isExisteUsuario(Usuario user) {
		return getByUsuario(user.getUsuario())!= null;
	}

}
