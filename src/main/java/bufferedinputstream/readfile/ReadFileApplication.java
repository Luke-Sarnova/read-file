package bufferedinputstream.readfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class ReadFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadFileApplication.class, args);

        File file = new File("C:\\Users\\Luke.Brannigan\\newfile.txt");
        BufferedInputStream bis = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            while (bis.available() > 0) {
                System.out.println((char)bis.read());
            }
        } catch(IOException ioe) {
            System.out.println("I/O Exception: " + ioe);
        }
        finally {
            try {
                if(bis != null && fis != null) {
                    fis.close();
                    bis.close();
                }
            } catch(IOException ioe) {
                System.out.println("Error in InputStream close(): " + ioe);
            }
        }
    }

}
