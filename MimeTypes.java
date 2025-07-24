import java.io.File;

/**
 * Créer le : lundi 21 juillet 2025
 * Auteur : Yoann Meclot (DevMyBits)
 * E-mail : devmybits@gmail.com
 */
public final class MimeTypes
{
    public static final int UNKNOWN = -1;
    public static final int IMAGE = 1;
    public static final int VIDEO = 2;
    public static final int MUSIC = 3;
    public static final int TEXT = 4;

    public static int getMimeType(File file)
    {
        return file.isDirectory() ? UNKNOWN : getMimeType(file.getAbsolutePath());
    }

    public static int getMimeType(String path)
    {
        String mimeType = MimeTypeMap.getMimeType(path);
        if (mimeType == null) return UNKNOWN;

        return getType(mimeType);
    }

    public static int getType(String mime)
    {
        if(check(mime, "text")) return TEXT;
        else if (check(mime, "image")) return IMAGE;
        else if (check(mime, "video")) return VIDEO;
        else if (check(mime, "audio")) return MUSIC;
        else return UNKNOWN;
    }

    private static boolean check(String name, String category)
    {
        return name.contains("/") && category.contains(name.substring(0, name.indexOf("/")));
    }
}
