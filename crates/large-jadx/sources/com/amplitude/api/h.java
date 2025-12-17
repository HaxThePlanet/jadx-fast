package com.amplitude.api;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h {

    private static String b = "ingestionEndpoint";
    private static com.amplitude.api.h c;
    private String a;

    interface a {
        public abstract void a();
    }
    static {
    }

    private h() {
        super();
        this.a = "https://api2.amplitude.com/";
    }

    public static com.amplitude.api.h b() {
        com.amplitude.api.h hVar;
        if (h.c == null) {
            hVar = new h();
            h.c = hVar;
        }
        return h.c;
    }

    public String a() {
        return this.a;
    }

    public void c(com.amplitude.api.h.a h$a) {
        Object instrument;
        int responseCode;
        InputStreamReader inputStreamReader;
        try {
            URL url = new URL("https://regionconfig.amplitude.com/");
            instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
            if ((HttpURLConnection)(URLConnection)instrument.getResponseCode() == 200) {
            }
            inputStreamReader = new InputStreamReader(instrument.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            inputStreamReader = bufferedReader.readLine();
            while (inputStreamReader != null) {
                stringBuffer.append(inputStreamReader);
                inputStreamReader = bufferedReader.readLine();
            }
            stringBuffer.append(inputStreamReader);
            bufferedReader.close();
            responseCode = new JSONObject(stringBuffer.toString());
            if (responseCode.has(h.b)) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://");
            stringBuilder.append(responseCode.getString(h.b));
            this.a = stringBuilder.toString();
            a.a();
        }
    }
}
