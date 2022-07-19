package proxyChecker32;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String pathFile = "C://java/working.txt";
        File file = new File(pathFile);
        FileOutputStream fos;
        try {

            FileInputStream fin = new FileInputStream("C://java/ip.txt");
            int i;
            String result = "";
            while ((i = fin.read()) != -1) {
                if (i == 13) continue;
                else if (i == 10) {
                    String ip = result.split(":")[0];
                    int port = Integer.parseInt(result.split(":")[1]);
                    System.out.print("\033[H\033[J");
                    System.out.println("проверка: "+result);
                    if (checkProxy(ip, port)) {
                        String content = result+"\r\n";
                        byte[] contentInBytes = content.getBytes();
                        if (!file.exists()) {
                            file.createNewFile();
                            fos = new FileOutputStream(file);
                        } else {
                            fos = new FileOutputStream(pathFile, true);
                        }
                        fos.write(contentInBytes,0,contentInBytes.length);
                        //fos.flush();
                        fos.close();

                        System.out.println(result + " работает");
                    }
                    result = "";
                } else if (i == 9) {
                    result += ":";
                } else {
                    result += (char) i;
                }
                //             System.out.println(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkProxy(String ip, int port) {

        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection connection = url.openConnection(proxy);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//    public static void main(String[] args) {
//        String text = "Hello world!\n";
//        try {
//            FileOutputStream fos = new FileOutputStream("C://java/text.txt",true);
//            byte[] buffer = text.getBytes();
//            fos.write(buffer,0,buffer.length);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}