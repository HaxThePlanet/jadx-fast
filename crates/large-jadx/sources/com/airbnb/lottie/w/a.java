package com.airbnb.lottie.w;

import com.airbnb.lottie.y.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* compiled from: DefaultLottieFetchResult.java */
/* loaded from: classes.dex */
public class a implements d {

    private final HttpURLConnection a;
    public a(HttpURLConnection httpURLConnection) {
        super();
        this.a = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append('\n');
            try {
                line = bufferedReader.readLine();
                stringBuilder.append(line);
                stringBuilder.append('\n');
            } catch (Exception unused) {
                return stringBuilder.toString();
            }
        }
        try {
            bufferedReader.close();
        } catch (Exception unused) {
            return stringBuilder.toString();
        }
    }

    public String D0() {
        return this.a.getContentType();
    }

    public InputStream T0() {
        return this.a.getInputStream();
    }

    public void close() {
        this.a.disconnect();
    }

    public boolean isSuccessful() {
        int i = 0;
        try {
        } catch (java.io.IOException unused) {
            return z;
        }
        if (this.a.getResponseCode() / 100 == 2) {
            int i2 = 1;
        }
    }

    public String l() {
        int i = 0;
        try {
            if (isSuccessful()) {
                i = 0;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Unable to fetch ";
                java.net.URL uRL = this.a.getURL();
                String str5 = ". Failed with ";
                int responseCode = this.a.getResponseCode();
                String str6 = "\n";
                String str = a(this.a);
                str2 = str4 + uRL + str5 + responseCode + str6 + str;
            }
        } catch (java.io.IOException ioException) {
            d.d("get error failed ", ioException);
            Throwable ioException2 = ioException.getMessage();
            return ioException2;
        }
        return i;
    }
}
