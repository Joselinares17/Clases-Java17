package Ejercicios.webscrapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class scrapping {
    public static void main(String[] args) throws IOException {

        List<String> links = new ArrayList<>();
        links.add("https://www.bbc.com/");
        links.add("https://es.wikipedia.org/wiki/Per%C3%BA");
        links.add("https://www.gob.pe/");
        links.add("https://elpais.com/noticias/peru/");

        Long timeStart = System.nanoTime();
        links.parallelStream().forEach(scrapping::getWebContent);

        Long timeEnd = System.nanoTime();

        System.out.println("Tiempo: " + (timeEnd - timeStart));

        String link = "https://www.bbc.com/";
        String result = getWebContent(link);
    }

    private synchronized static String getWebContent(String link) {
        System.out.println("INIT");
        System.out.println(link);
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();
            InputStream inputStream = conn.getInputStream();

            Stream<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                    .lines();
            System.out.println("END");

            return lines.collect(Collectors.joining());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
