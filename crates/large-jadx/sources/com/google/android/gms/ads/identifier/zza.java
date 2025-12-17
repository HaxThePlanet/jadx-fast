package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class zza extends Thread {

    private final Map zzl;
    zza(com.google.android.gms.ads.identifier.AdvertisingIdClient advertisingIdClient, Map map2) {
        this.zzl = map2;
        super();
    }

    @Override // java.lang.Thread
    public final void run() {
        Throwable th;
        Throwable message;
        String responseCode;
        String next;
        int str;
        String stringBuilder;
        final String str2 = ". ";
        zzc zzc = new zzc();
        Map zzl = this.zzl;
        Uri.Builder upon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        Iterator iterator = zzl.keySet().iterator();
        for (String next : iterator) {
            upon.appendQueryParameter(next, (String)zzl.get(next));
        }
        String string2 = upon.build().toString();
        URL url = new URL(string2);
        java.net.URLConnection connection = url.openConnection();
        responseCode = (HttpURLConnection)connection.getResponseCode();
        if (responseCode >= 200) {
            if (responseCode >= 300) {
                stringBuilder = new StringBuilder(length += 65);
                stringBuilder.append("Received non-success response code ");
                stringBuilder.append(responseCode);
                stringBuilder.append(" from pinging URL: ");
                stringBuilder.append(string2);
                Log.w("HttpUrlPinger", stringBuilder.toString());
            }
        } else {
        }
        connection.disconnect();
    }
}
