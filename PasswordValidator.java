/**
 * Evaluates password strength based on:
 * 1. Length of at least 8 characters
 * 2. Contains an uppercase letter
 * 3. Contains a number
 *
 * Maximum score: 3
 *
 * @author Nimai Desai
 */
public class PasswordValidator {

    /**
     * Returns a strength score from 0-3.
     *
     * @param password the password to evaluate
     * @return strength score
     */
    public int getStrengthScore(String password) {
        int score = 0;

        // Length requirement
        if (password.length() >= 8) {
            score++;
        }

        // Uppercase requirement
        boolean hasUppercase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUppercase = true;
                break;
            }
        }

        if (hasUppercase) {
            score++;
        }

        // Number requirement
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        if (hasDigit) {
            score++;
        }

        return score;
    }
}
