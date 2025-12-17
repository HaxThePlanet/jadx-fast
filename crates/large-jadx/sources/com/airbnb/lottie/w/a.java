package com.airbnb.lottie.w;

import com.airbnb.lottie.y.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public class a implements com.airbnb.lottie.w.d {

    private final HttpURLConnection a;
    public a(HttpURLConnection httpURLConnection) {
        super();
        this.a = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) {
        InputStreamReader inputStreamReader;
        inputStreamReader = new InputStreamReader(httpURLConnection.getErrorStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder obj3 = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            obj3.append(line);
            obj3.append('\n');
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return obj3.toString();
    }

    @Override // com.airbnb.lottie.w.d
    public String D0() {
        return this.a.getContentType();
    }

    @Override // com.airbnb.lottie.w.d
    public InputStream T0() {
        return this.a.getInputStream();
    }

    @Override // com.airbnb.lottie.w.d
    public void close() {
        this.a.disconnect();
    }

    @Override // com.airbnb.lottie.w.d
    public boolean isSuccessful() {
        int i;
        i = 0;
        if (responseCode /= 100 == 2) {
            try {
                i = 1;
                return i;
            }
        }
    }

    @Override // com.airbnb.lottie.w.d
    public String l() {
        int string;
        String str;
        try {
            if (isSuccessful()) {
            } else {
            }
            string = 0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to fetch ");
            stringBuilder.append(this.a.getURL());
            stringBuilder.append(". Failed with ");
            stringBuilder.append(this.a.getResponseCode());
            stringBuilder.append("\n");
            stringBuilder.append(a(this.a));
            string = stringBuilder.toString();
            return string;
            d.d("get error failed ", message);
            Throwable message = message.getMessage();
            return message;
        }
    }
}
