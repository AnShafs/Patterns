import java.io.*;

/**
 * Created by AnShafs on 16.02.2016.
 * Pattern Decorator for FileInputStream. For txt files only.
 * Can return fileName(path)
 */
public class TxtFileInputStream extends InputStream {
    private String path;
    private FileInputStream fileInputStream = null;
    public final static String TXT = "txt";

    public TxtFileInputStream(String path) throws FileNotFoundException, UnsupportedFileNameException {
        if (getFileExtention(path).equals(TXT)) {
            this.path = path;
            fileInputStream = new FileInputStream(path);
        }
        else {
            throw new UnsupportedFileNameException();
        }
    }

    @Override
    public int read() throws IOException {
        return fileInputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return fileInputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return fileInputStream.read(b, off, len);
    }

    @Override
    public int available() throws IOException {
        return fileInputStream.available();
    }

    @Override
    public void close() throws IOException {
        fileInputStream.close();
    }

    public String getPath() {
        return path;
    }

    private static String getFileExtention(String filename){
        int dotPos = filename.lastIndexOf(".") + 1;
        return filename.substring(dotPos);
    }

    public static void main(String[] args) throws IOException {
        try {
            TxtFileInputStream test = new TxtFileInputStream("c:/temp.xml");
        }
        catch (UnsupportedFileNameException e) {
            System.out.println("Это был не " + TxtFileInputStream.TXT);
        }
    }

}
