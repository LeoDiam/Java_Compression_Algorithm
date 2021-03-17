import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class CompressingDataGZIP {
    public static int sChunk = 8192;

    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Usage: GZip source");
//            return;
//        }
        // create output stream
        String name = "stackSpanProb";
        String zipname = name + ".gz";
        GZIPOutputStream zipout;
        try {
            FileOutputStream out = new FileOutputStream("C:\\Users\\leoni\\OneDrive\\Υπολογιστής\\stackSpanProdas.txt");
            zipout = new GZIPOutputStream(out);
        }
        catch (IOException e) {
            System.out.println("Couldn't create " + zipname + ".");
            return;
        }
        byte[] buffer = new byte[sChunk];
        // compress the file
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\leoni\\OneDrive\\Υπολογιστής\\stackSpanProb.txt");
            int length;
            while ((length = in.read(buffer, 0, sChunk)) != -1)
                zipout.write(buffer, 0, length);
            in.close( );
        }
        catch (IOException e) {
            System.out.println("Couldn't compress " + name + ".");
        }
        try { zipout.close( ); }
        catch (IOException e) {}
    }
}
