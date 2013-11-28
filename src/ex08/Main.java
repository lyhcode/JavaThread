package ex08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class Main {
    public static void main(String[] args) throws InterruptedException, MalformedURLException{
        String[] urls = {
            "http://ipv4.download.thinkbroadband.com/20MB.zip",
            "http://ipv4.download.thinkbroadband.com/10MB.zip"            
        };
        
        for (String url : urls) {
            new Thread(new Downloader(new URL(url), new File("."))).start();
        }
    }
}

class Downloader implements Runnable {
    
    private final URL url;
    private final File destPath;
    
    public Downloader(URL url, File destPath) {
        this.url = url;
        this.destPath = destPath;
    }

    @Override
    public void run() {
        try {
            URLConnection conn = url.openConnection();
            conn.connect();
            
            InputStream stream = conn.getInputStream();
            
            File saveToFile = new File(destPath, url.getFile());
            
            OutputStream outputStream = new FileOutputStream(saveToFile);
            
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = stream.read(bytes)) >= 0) {
                System.out.printf("Get %d bytes from %s\n", len, url);
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
