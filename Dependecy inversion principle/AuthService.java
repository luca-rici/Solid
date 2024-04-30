public interface AuthService {
    User authenticate(String username, String password);
}

public class LoginService {

    private AuthService authService; // Dependência de abstração (interface)
    public LoginService(AuthService authService) {
        this.authService = authService;
    }

    public User login(String username, String password) {
        User user = authService.authenticate(username, password);
        // Processa o login do usuário autenticado
        return user;
    }
}
