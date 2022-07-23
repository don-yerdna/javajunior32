package proxyChecker32;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;


public class Main1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            FileInputStream fin = new FileInputStream("src/proxyChecker32/ip.txt");
            int i;
            String result = "";
            while ((i = fin.read()) != -1) {
                if (i == 13) continue;
                else if (i == 10) {
                    String ip = result.split(":")[0];
                    int port = Integer.parseInt(result.split(":")[1]);
                    Thread thread = new Thread(new CheckProxyRunnable(ip,port,start));
                    thread.start();
                    result = "";
                } else if (i == 9) {
                    result += ":";
                } else {
                    result += (char) i;
                }
            }
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkProxy(String ip, int port, long start) {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection connection = url.openConnection(proxy);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String pathFile = "src/proxyChecker32/work_int.txt";
            File file = new File(pathFile);
            FileOutputStream fos;
            if (!file.exists()) {
                file.createNewFile();
                fos = new FileOutputStream(file);
            } else {
                fos = new FileOutputStream(pathFile, true);
            }

            String content = ip + ":" + port + "\r\n";
            byte[] contentInBytes = content.getBytes();
            fos.write(contentInBytes, 0, contentInBytes.length);
            fos.close();
            System.out.print("\r Прошло времени, мс: " + timeHasPassed(start)+" ip: " + ip + " порт: " + port + " работает \n");
        } catch (Exception e) {
            System.out.print("\r Прошло времени, мс: " + timeHasPassed(start));
        }
    }
    public static String timeHasPassed (long start){
        long finish = System.currentTimeMillis();
        long timePassed = finish - start;
        String hasPassed = String.format("%02d:%02d:%02d", timePassed / 1000 / 3600, timePassed / 1000 / 60 % 60, timePassed / 1000 % 60);;
        return hasPassed;
    }

    static class CheckProxyRunnable implements Runnable{
        String ip;
        int port;
        long start;
        public CheckProxyRunnable(String ip, int port, long start){
            this.ip = ip;
            this.port = port;
            this.start = start;
        }
        @Override
        public void run() {
            checkProxy(ip, port, start);
        }
    }
}
