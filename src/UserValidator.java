public class UserValidator {

    public static void validateUser(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        // Регулярное выражение для проверки допустимых символов
        String regex = "^[a-zA-Z0-9_]+$";

        // Проверка login
        if (login.length() > 20 || !login.matches(regex)) {
            throw new WrongLoginException("Login is invalid. It should be 20 characters or less and contain only letters, digits, and underscores.");
        }

        // Проверка password
        if (password.length() > 20 || !password.matches(regex)) {
            throw new WrongPasswordException("Password is invalid. It should be 20 characters or less and contain only letters, digits, and underscores.");
        }

        // Проверка совпадения password и confirmPassword
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and confirm password do not match.");
        }
    }

    public static void main(String[] args) {
        try {
            validateUser("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
            System.out.println("Validation successful!");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
