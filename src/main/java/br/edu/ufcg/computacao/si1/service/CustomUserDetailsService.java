package br.edu.ufcg.computacao.si1.service;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService /*implements UserDetailsService*/ {

  /*  private static final Logger LOGGER = LoggerFactory.getLogger(Serializable.class);
    private final UsuarioService userService;

    @Autowired
    public CustomUserDetailsService(UsuarioService userService) {
        this.userService = userService;
    }

    @Override
    public Usuario loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));

        Optional<Usuario> usuario = userService.getByEmail(email);

        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        }

    }*/

}