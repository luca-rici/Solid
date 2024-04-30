public class LoginService {

    private AuthService authService; // Dependência direta do serviço de autenticação

    public User login(String username, String password) {
        User user = authService.authenticate(username, password);
        // Processa o login do usuário autenticado
        return user;
    }
}
