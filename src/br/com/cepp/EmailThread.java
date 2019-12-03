package br.com.cepp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class EmailThread {

    public static final String REPLY_STRING_INDICATOR = "---";

    public static void main(String[] args) {
        String[] threads = {
//                "abc@gmail.com, x@gmail.com, hello x, how are you?",
//                "c@gmail.com, abc@gmail.com, did you take a look at the event?",
//                "x@gmail.com, abc@gmail.com, i am great. how are you?---hello x, how are you?"
                "sv@outlook.com, gfdpdyf@gmail.com, n",
                "wl@hackerrank.com, tk@outlook.com, m",
                "gfdpdyf@gmail.com, sv@outlook.com, t.xg---n",
                "sv@outlook.com, gfdpdyf@gmail.com, i---t.xg---n",
                "tk@outlook.com, wl@hackerrank.com, o---m",
                "tk@outlook.com, wl@hackerrank.com, w---o---m",
                "tk@outlook.com, wl@hackerrank.com, nv---w---o---m",
                "sv@outlook.com, gfdpdyf@gmail.com, cyhf---i---t.xg---n"
        };
        System.out.println(getEmailThreads(Arrays.asList(threads)));
    }

    static List<List<Integer>> getEmailThreads(List<String> emails) {
        List<List<Integer>> threadEmails = new ArrayList<>();

        List<MailThread> threads = processThreads(emails);

        int i = 0;
        for(MailThread mailThread : threads) {
            threadEmails.add(i, new ArrayList<>());
            int position = mailThread.getPosition();
            int count = 1;
            if(mailThread.getMainThread() != null && !mailThread.getMainThread().isEmpty()) {
                MailThread mailThread1 = new MailThread();
                mailThread1.setBody(mailThread.getMainThread());
                int index = Optional.of(threads.indexOf(mailThread1)).orElse(null);
                position = threads.get(index).getPosition();
                count = mailThread.getDeepth();
            }

            threadEmails.get(i).addAll(Arrays.asList(position, count));
            i++;
        }

        return threadEmails;
    }

    static List<MailThread> processThreads(List<String> emails) {
        List<MailThread> mailThreads = new ArrayList<>();
        int i = 1;
        for(String email : emails) {
            String[] splitContent = email.split("\\.com, ");
            MailThread mailThread = new MailThread();
            mailThread.setPosition(i);
            mailThread.setFrom(splitContent[0].concat(".com"));
            mailThread.setTo(splitContent[1].concat(".com"));
            String body = splitContent[2];
            if(body.contains(REPLY_STRING_INDICATOR)) {
                mailThread.setMainThread(body.substring(body.lastIndexOf(REPLY_STRING_INDICATOR)+3).trim());
                mailThread.setBody(body.substring(0, body.indexOf(REPLY_STRING_INDICATOR)).trim());
                mailThread.setDeepth(body.split(REPLY_STRING_INDICATOR).length);
            } else {
                mailThread.setBody(body.trim());
            }
            i++;
            mailThreads.add(mailThread);
        }
        return mailThreads;
    }

    static class MailThread {
        int position;
        String from;
        String to;
        String body;
        String mainThread;
        int deepth;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getMainThread() {
            return mainThread;
        }

        public void setMainThread(String mainThread) {
            this.mainThread = mainThread;
        }

        public int getDeepth() {
            return deepth;
        }

        public void setDeepth(int deepth) {
            this.deepth = deepth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MailThread that = (MailThread) o;
            return Objects.equals(body, that.body);
        }

        @Override
        public int hashCode() {
            return Objects.hash(body);
        }
    }
}
