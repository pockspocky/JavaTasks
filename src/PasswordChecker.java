public class PasswordChecker {
    public static boolean passChecker (String pass) {
        if (pass.length() < 8) {
            return false;
        }
        String all = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        for (int i = 0; i < pass.length(); i++) {
            String s = pass.substring(i, i + 1);
            if (!s.matches("[0-9][a-zA-Z]]")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (passChecker("asdfghjklrtyuiopasdfghjklzxcvb82745698726495876134nm")) {
            System.out.println("YES");
        }
    }
}
