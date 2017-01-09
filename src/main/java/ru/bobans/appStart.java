package ru.bobans;

import org.codehaus.jackson.map.ObjectMapper;
import ru.bobans.Entity.Qst;
import ru.bobans.Entity.RootMailAnswers;
import ru.bobans.mail.Sender;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.prefs.Preferences;

/**
 * Created by bobans on 12.12.2016.
 */
public class appStart {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Preferences userPref = Preferences.userRoot();

        Sender sender = new Sender();
        Properties props;
        try {
            InputStream cfgFile = Sender.class.getResourceAsStream("/mail.properties");
            props = new Properties();
            props.load(new InputStreamReader(cfgFile, "UTF-8"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        String msg = "";
        int MAX_JUMPING = 100;
        int DELAY = 1;
        int lastid = 999999999;
        int last_id_ = 0;
        int lastid_from_settings = userPref.getInt("ru.bobans.mailru.answers.lastid", -65000);
        int jumping = 0;
        String last_url = "";
        //File file = new File(appStart.class.getResource("/wordslist.txt").toURI());
        InputStream in = appStart.class.getResourceAsStream("/wordslist.txt");
        BufferedReader file = new BufferedReader(new InputStreamReader(in));

        Scanner read_file = new Scanner(file);
        String words = read_file.next();

        while (lastid > lastid_from_settings) {
            jumping++;
            String s_url = "https://otvet.mail.ru/api/v2/questlist" + last_url;
            //System.out.println(s_url);
            URL url = new URL(s_url);
            Scanner reader = new Scanner(url.openStream(), "UTF-8");
            String response = reader.useDelimiter("\\Z").next();
            RootMailAnswers mailAnswers = new ObjectMapper().readValue(response, RootMailAnswers.class);
            Collections.sort(mailAnswers.getQst(), (o1, o2) -> o1.getId() - o2.getId());
            if (jumping == MAX_JUMPING) {
                System.out.println("Превышенно максимальное количество прыжков = " + MAX_JUMPING);
                break;
            }
            lastid = mailAnswers.getQst().get(0).getId();
            for (Qst qst : mailAnswers.getQst()) {
                for (String word : words.split(",")) {
                    if (qst.getQtext().toUpperCase().contains(word.toUpperCase())) {
                        msg += qst.getQtext() + "\r\n";
                        msg += "https://otvet.mail.ru/question/" + qst.getId() + "\r\n";
                        msg += "-------------------------------------------------------\r\n";
                    }
                }
            }
            if (jumping == 1) {
                last_id_ = lastid;
                userPref.putInt("ru.bobans.mailru.answers.lastid", lastid);
            }
            last_url = "?lastid=" + last_id_ + "ajax_id=" + jumping + "&n=100&state=A&p=" + 100 * jumping;
            if (DELAY > 0) Thread.sleep(DELAY * 1000);
        }
        System.out.println(msg);

        System.out.println("Время выполнения скрипта: " + (float) (System.currentTimeMillis() - start) / 1000 + " сек");
        if (msg.length() > 0) {
            sender.send(
                    props.getProperty("subject", "subject"),
                    msg,
                    props.getProperty("to_user", "to_user")
            );
        }
    }
}
