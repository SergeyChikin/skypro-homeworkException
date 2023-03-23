public class Main {
    public static void main(String[] args) {
        String login = "";
        String password = "";
        String confirmPassword = "";
        System.out.println(check(login, password, confirmPassword));
        System.out.println();
    }

    public static boolean checkSymbol(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char sym = str.charAt(i);
            if (!(sym == '_' || (sym >= 'A' && sym <= 'Z') || (sym >= 'a' && sym <= 'z') ||
                    (sym >= '0' && sym <= '9'))) {
                return false;
            }
        }
        return true;
    }


    public static boolean check(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20) {
                throw new WrongLoginException("Логин слишком длинный.");
            }

            boolean a = checkSymbol(login);
            if (!a) {
                throw new WrongLoginException("Логин не соответствует требованиям. ");
            }

            if (password.length() >= 20) {
                throw new WrongPasswordException("Пароль слишком длинный.");
            }

            boolean b = checkSymbol(password);
            if (!b) {
                throw new WrongLoginException("Пароль не соответствует требованиям. ");
            }

            if (!password.equals(confirmPassword)) throw new WrongPasswordException("Пароли не совпадают. ");
        } catch (WrongLoginException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (WrongPasswordException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            System.out.println("Работа метода закончена.");

        }
        System.out.println("Логин и пароль приняты.");
        return true;
    }
}