import java.util.*;

public class PasswordGenerator {
  boolean hasSpecials;
  int length;

  public PasswordGenerator(int length, boolean hasSpecials) {
    this.length = length;
    this.hasSpecials = hasSpecials;
  }

  private static char[] generatePassword(int length) {
    String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = caps.toLowerCase();
    String specialChars = "~`!@#$%^&*(){}-_";
    String nums = "1234567890";
    String allChars = caps + lower + specialChars + nums;
    Random rand = new Random();
    char[] password = new char[length];

    password[0] = lower.charAt(rand.nextInt(lower.length()));
    password[1] = caps.charAt(rand.nextInt(caps.length()));
    password[2] = specialChars.charAt(rand.nextInt(specialChars.length()));
    password[3] = nums.charAt(rand.nextInt(nums.length()));

    for (int i = 4; i < length; i++) {
      password[i] = allChars.charAt(rand.nextInt(allChars.length()));
    }
    shuffleArray(password);

    return password;
  }

  private static void shuffleArray(char[] array) {
    int index;
    char temp;
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      index = random.nextInt(i + 1);
      temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }

  public static void main(String[] args) {
    System.out.println(generatePassword(10));
  }
}
