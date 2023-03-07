package validator;

public class RemoveNonNameChars {

    public static String remove(String name) {
        return name.replaceAll("[^a-zA-Zà-úÀ-Ú\\s]|(?<=\\s)\\s+", "");
    }
}
