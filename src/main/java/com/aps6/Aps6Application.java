package com.aps6;


import com.aps6.principal.Principal;
import com.aps6.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;

@SpringBootApplication
public class Aps6Application implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Aps6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal teste1 = new Principal(usuarioRepository);
		teste1.menu();
	}


}
