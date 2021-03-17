import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Main {

    public static void compress(File source, File destination) throws IOException {
        byte [] bytes = new byte[1024];
        FileInputStream fileInputStream = new FileInputStream(source);
        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);
        int read;
        while ((read = fileInputStream.read(bytes)) != -1){
            gzipOutputStream.write(bytes,0,read);
        }
    }
    public static void main(String[] args) throws IOException {
        File source = new File("C:\\Users\\leoni\\OneDrive\\Υπολογιστής\\stackSpanProb.txt");
        File destination = new File("C:\\Users\\leoni\\OneDrive\\Υπολογιστής\\stackSpanPro.txt");
        compress(source,destination);


    }
}
