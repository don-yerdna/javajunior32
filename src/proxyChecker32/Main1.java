package proxyChecker32;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Main1 {
    public static int count = 0;

    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C://java/ip.txt");
            int i;
            String result = "";
            while ((i = fin.read()) != -1) {
                if (i == 13) continue;
                else if (i == 10) {
                    String ip = result.split(":")[0];
                    int port = Integer.parseInt(result.split(":")[1]);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            checkProxy(ip, port);
                        }
                    });
                    thread.start();
                    result = "";
                } else if (i == 9) {
                    result += ":";
                } else {
                    result += (char) i;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkProxy(String ip, int port) {
//        try {
//            String pathFile = "src/proxyChecker32/chet.txt";
//            File file = new File(pathFile);
//            FileOutputStream fos;
//            if (!file.exists()) {
//                file.createNewFile();
//                fos = new FileOutputStream(file);
//            } else {
//                fos = new FileOutputStream(pathFile, true);
//            }
//            if (count % 2 != 0) {
//                String content = ip + ":" + port + "\r\n";
//                byte[] contentInBytes = content.getBytes();
//                fos.write(contentInBytes, 0, contentInBytes.length);
//                fos.close();
//            }
//            count++;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection connection = url.openConnection(proxy);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.print("\r ip: " + ip + " порт: " + port + " работает");
        } catch (Exception e) {
            System.out.print("\r ip: " + ip + " порт: " + port + " не работает");
        }
    }
}
