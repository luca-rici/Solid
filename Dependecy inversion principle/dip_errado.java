public class LoginService {

    private AuthService authService;

    public User login(String username, String password) {
        User user = authService.authenticate(username, password);
        return user;
    }
}
