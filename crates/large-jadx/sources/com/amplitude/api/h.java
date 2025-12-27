package com.amplitude.api;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConfigManager.java */
/* loaded from: classes.dex */
public class h {

    private static String b = "ingestionEndpoint";
    private static h c;
    private String a = "https://api2.amplitude.com/";

    interface a {
        void a();
    }
    private h() {
        super();
    }

    public static h b() {
        if (h.c == null) {
            h.c = new h();
        }
        return h.c;
    }

    public String a() {
        return this.a;
    }

    public void c(h.a aVar) throws java.io.UnsupportedEncodingException {
        try {
            Object instrument = FirebasePerfUrlConnection.instrument(new URL("https://regionconfig.amplitude.com/").openConnection());
            if (instrument.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(instrument.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                Object line = bufferedReader.readLine();
                while (line != null) {
                    stringBuffer.append(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                if (jSONObject.has(h.b)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str5 = "https://";
                    String string = jSONObject.getString(h.b);
                    str3 = str5 + string;
                    this.a = str3;
                }
            }
        } catch (java.net.MalformedURLException | java.io.IOException | org.json.JSONException | Exception unused) {
            aVar.a();
            return;
        }
    }

}
