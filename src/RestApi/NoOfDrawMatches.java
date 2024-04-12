package RestApi;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NoOfDrawMatches {
    static String endpoint = "https://jsonmock.hackerrank.com/api/football_matches?";
    static String endpoint1 = "https://jsonmock.hackerrank.com/api/football_competitions?";

    public static void main(String[] args) throws IOException, ScriptException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String compition = reader.readLine().replace(" ", "%20");
        String year = reader.readLine();
        // System.out.println(getNumDraws(Integer.parseInt(year)));
        System.out.println(getWinnerTotalGoals(compition, Integer.parseInt(year)));
    }

    static Integer getNumDraws(int year) {
        int currentPage = 1;
        AtomicInteger noOfDrawMatches = new AtomicInteger();
        int totalPages = 0;
        getDrawMatchCount(currentPage, year, noOfDrawMatches, totalPages);
        return noOfDrawMatches.get();
    }

    private static int getWinnerTotalGoals(String name, int year) throws IOException, ScriptException {
        String winner = null;
        AtomicInteger totalNoOfGoals = new AtomicInteger();
        URL url = new URL(endpoint1 + "name=" + name + "&year=" + year);
        System.out.println("url " + url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = 0;
        try {
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (responseCode == 200) {
            InputStreamReader iStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(iStreamReader);
            String output;
            while ((output = bufferedReader.readLine()) != null) {
                final ScriptEngineManager manager = new ScriptEngineManager();
                String scripting = "var obj = JSON.parse('" + output + "');";
                ScriptEngine engine = manager.getEngineByName("JavaScript");
                scripting += "var winner = obj.data[0].winner;";
                engine.eval(scripting);
                winner = (String) engine.get("winner");
            }
        }

        String url1 = "&team1=" + winner;
        String url2 = "&team2=" + winner;
        int goals = getGoalsForWinner(1, year, totalNoOfGoals, 0, name, winner, url1, "team1") +
                getGoalsForWinner(1, year, totalNoOfGoals, 0, name, winner, url2, "team2");
        return goals;
    }

    private static int getGoalsForWinner(int currentPage, int year, AtomicInteger totalNoOfGoals,
                                         int totalPages, String name, String winner, String urll, String TeamType) throws IOException, ScriptException {
        if (currentPage == totalPages) {
            return totalNoOfGoals.get();
        }
        URL url = new URL(endpoint + "&name=" + name + "&year=" + year + urll + "&page=" + currentPage);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = 0;
        try {
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (responseCode == 200) {
            InputStreamReader iStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(iStreamReader);
            String output;
            while ((output = bufferedReader.readLine()) != null) {
                final ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("JavaScript");
                String scripting = "var obj = JSON.parse('" + output + "');";
                scripting += "var page = obj.page;";
                scripting += "var per_page = obj.per_page;";
                scripting += "var total_pages = obj.total_pages;";
                scripting += "var total = obj.total;";

                scripting += "var data = obj.data;";
                engine.eval(scripting);

                int page = (int) engine.get("page");
                int perPage = (int) engine.get("per_page");
                Integer pageTotal = (Integer) engine.get("total_pages");
                Integer total = (Integer) engine.get("total");
                Map<Object, Map<String, Object>> map = (Map<Object, Map<String, Object>>) engine.get("data");
                map.forEach((key, value) -> {
                        int goals = Integer.parseInt((String) value.get(TeamType + "goals"));
                        totalNoOfGoals.set(totalNoOfGoals.get() + goals);
                });

                getGoalsForWinner(page + 1, year, totalNoOfGoals,
                        pageTotal, name, winner, urll, TeamType);
            }
        }
        return totalNoOfGoals.get();
    }


    private static int getDrawMatchCount(int currentPage, int year, AtomicInteger noOfDrawMatches, int totalPages) {
        if (currentPage == totalPages) {
            return noOfDrawMatches.get();
        }
        URL url = null;
        try {
            url = new URL(endpoint + "year=" + year + "&page=" + currentPage);
            System.out.println("url " + url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStreamReader iStreamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(iStreamReader);
                String output;
                while ((output = bufferedReader.readLine()) != null) {
                    final ScriptEngineManager manager = new ScriptEngineManager();
                    ScriptEngine engine = manager.getEngineByName("JavaScript");
                    String scripting = "var obj = JSON.parse('" + output + "');";
                    scripting += "var page = obj.page;";
                    scripting += "var per_page = obj.per_page;";
                    scripting += "var total_pages = obj.total_pages;";
                    scripting += "var total = obj.total;";

                    scripting += "var data = obj.data;";
                    engine.eval(scripting);

                    int page = (int) engine.get("page");
                    int perPage = (int) engine.get("per_page");
                    Integer pageTotal = (Integer) engine.get("total_pages");
                    Integer total = (Integer) engine.get("total");
                    Map<Object, Map<String, Object>> map = (Map<Object, Map<String, Object>>) engine.get("data");
                    map.forEach((key, value) -> {
                        if (value.get("team2goals").equals(value.get("team1goals")))
                            noOfDrawMatches.incrementAndGet();
                    });
                    System.out.println("noOfDrawMatches " + noOfDrawMatches);
                    getDrawMatchCount(page + 1, year, noOfDrawMatches, pageTotal);
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return noOfDrawMatches.get();
    }
}
