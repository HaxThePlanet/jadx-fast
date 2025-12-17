package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.content.d.a;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.j;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConfigFetchHttpClient {

    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    private static final String ETAG_HEADER = "ETag";
    private static final Pattern GMP_APP_ID_PATTERN = null;
    private static final String IF_NONE_MATCH_HEADER = "If-None-Match";
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    private final String apiKey;
    private final String appId;
    private final long connectTimeoutInSeconds;
    private final Context context;
    private final String namespace;
    private final String projectNumber;
    private final long readTimeoutInSeconds;
    static {
        ConfigFetchHttpClient.GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    }

    public ConfigFetchHttpClient(Context context, String string2, String string3, String string4, long l5, long l6) {
        super();
        this.context = context;
        this.appId = string2;
        this.apiKey = string3;
        this.projectNumber = ConfigFetchHttpClient.extractProjectNumberFromAppId(string2);
        this.namespace = string4;
        this.connectTimeoutInSeconds = l5;
        this.readTimeoutInSeconds = obj7;
    }

    private boolean backendHasUpdates(JSONObject jSONObject) {
        return obj3 ^= i;
    }

    private JSONObject createFetchRequestBody(String string, String string2, Map<String, String> map3) {
        int i;
        String obj4;
        String obj5;
        HashMap hashMap = new HashMap();
        if (string == null) {
        } else {
            hashMap.put("appInstanceId", string);
            hashMap.put("appInstanceIdToken", string2);
            hashMap.put("appId", this.appId);
            obj4 = obj4.locale;
            hashMap.put("countryCode", obj4.getCountry());
            obj5 = Build.VERSION.SDK_INT;
            if (obj5 >= 21) {
                obj4 = obj4.toLanguageTag();
            } else {
                obj4 = obj4.toString();
            }
            hashMap.put("languageCode", obj4);
            hashMap.put("platformVersion", Integer.toString(obj5));
            hashMap.put("timeZone", TimeZone.getDefault().getID());
            obj4 = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            if (obj4 != null) {
                hashMap.put("appVersion", obj4.versionName);
                hashMap.put("appBuild", Long.toString(a.a(obj4)));
            }
            hashMap.put("packageName", this.context.getPackageName());
            hashMap.put("sdkVersion", "21.0.1");
            obj4 = new JSONObject(map3);
            hashMap.put("analyticsUserProperties", obj4);
            obj4 = new JSONObject(hashMap);
            return obj4;
        }
        obj4 = new FirebaseRemoteConfigClientException("Fetch failed: Firebase installation id is null.");
        throw obj4;
    }

    private static com.google.firebase.remoteconfig.internal.ConfigContainer extractConfigs(JSONObject jSONObject, Date date2) {
        JSONObject jSONObject2;
        org.json.JSONArray jSONArray;
        try {
            final com.google.firebase.remoteconfig.internal.ConfigContainer.Builder obj3 = ConfigContainer.newBuilder().withFetchTime(date2);
            int i = 0;
            jSONObject2 = jSONObject.getJSONObject("entries");
            String str2 = str;
            if (jSONObject2 != null) {
            }
            obj3.replaceConfigsWith(jSONObject2);
            jSONArray = jSONObject.getJSONArray("experimentDescriptions");
            str2 = str;
            if (jSONArray != null) {
            }
            obj3.withAbtExperiments(jSONArray);
        } catch (org.json.JSONException jSON) {
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("personalizationMetadata");
        if (jSONObject3 != null) {
            try {
                obj3.withPersonalizationMetadata(jSONObject3);
                return obj3.build();
                String str = "Fetch failed: fetch response could not be parsed.";
                date2 = new FirebaseRemoteConfigClientException(str, jSONObject);
                throw date2;
            }
        }
    }

    private static String extractProjectNumberFromAppId(String string) {
        int matches;
        String obj1;
        obj1 = ConfigFetchHttpClient.GMP_APP_ID_PATTERN.matcher(string);
        if (obj1.matches()) {
            obj1 = obj1.group(1);
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    private JSONObject getFetchResponseBody(URLConnection uRLConnection) {
        InputStreamReader inputStreamReader;
        String str;
        inputStreamReader = new InputStreamReader(uRLConnection.getInputStream(), "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder obj4 = new StringBuilder();
        int read = bufferedReader.read();
        while (read != -1) {
            obj4.append((char)read);
            read = bufferedReader.read();
        }
        JSONObject jSONObject = new JSONObject(obj4.toString());
        return jSONObject;
    }

    private String getFetchUrl(String string, String string2) {
        Object[] arr = new Object[2];
        return String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", string, string2);
    }

    private String getFingerprintHashForPackage() {
        Context context = this.context;
        byte[] bArr = a.a(context, context.getPackageName());
        if (bArr == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not get fingerprint hash for package: ");
            stringBuilder.append(this.context.getPackageName());
            Log.e("FirebaseRemoteConfig", stringBuilder.toString());
            return null;
        }
        return j.c(bArr, false);
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection, String string2) {
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.apiKey);
        httpURLConnection.setRequestProperty("X-Android-Package", this.context.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", getFingerprintHashForPackage());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("X-Goog-Firebase-Installations-Auth", string2);
        String str3 = "application/json";
        httpURLConnection.setRequestProperty("Content-Type", str3);
        httpURLConnection.setRequestProperty("Accept", str3);
    }

    private void setCustomRequestHeaders(HttpURLConnection httpURLConnection, Map<String, String> map2) {
        Object value;
        Object key;
        Iterator obj4 = map2.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            httpURLConnection.setRequestProperty((String)next2.getKey(), (String)next2.getValue());
        }
    }

    private void setFetchRequestBody(HttpURLConnection httpURLConnection, byte[] b2Arr2) {
        httpURLConnection.setFixedLengthStreamingMode(b2Arr2.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(b2Arr2);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    private void setUpUrlConnection(HttpURLConnection httpURLConnection, String string2, String string3, Map<String, String> map4) {
        httpURLConnection.setDoOutput(true);
        TimeUnit sECONDS = TimeUnit.SECONDS;
        httpURLConnection.setConnectTimeout((int)millis2);
        httpURLConnection.setReadTimeout((int)millis);
        httpURLConnection.setRequestProperty("If-None-Match", string2);
        setCommonRequestHeaders(httpURLConnection, string3);
        setCustomRequestHeaders(httpURLConnection, map4);
    }

    HttpURLConnection createHttpURLConnection() {
        try {
            URL url = new URL(getFetchUrl(this.projectNumber, this.namespace));
            return (HttpURLConnection)url.openConnection();
            Throwable message = message.getMessage();
            FirebaseRemoteConfigException firebaseRemoteConfigException = new FirebaseRemoteConfigException(message);
            throw firebaseRemoteConfigException;
        }
    }

    com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse fetch(HttpURLConnection httpURLConnection, String string2, String string3, Map<String, String> map4, String string5, Map<String, String> map6, Date date7) {
        setUpUrlConnection(httpURLConnection, string5, string3, map6);
        setFetchRequestBody(httpURLConnection, createFetchRequestBody(string2, string3, map4).toString().getBytes("utf-8"));
        httpURLConnection.connect();
        int obj2 = httpURLConnection.getResponseCode();
        if (obj2 != 200) {
        } else {
            JSONObject obj3 = getFetchResponseBody(httpURLConnection);
            httpURLConnection.disconnect();
            httpURLConnection.getInputStream().close();
            if (!backendHasUpdates(obj3)) {
                return ConfigFetchHandler.FetchResponse.forBackendHasNoUpdates(date7);
            }
            try {
                return ConfigFetchHandler.FetchResponse.forBackendUpdatesFetched(ConfigFetchHttpClient.extractConfigs(obj3, date7), httpURLConnection.getHeaderField("ETag"));
                obj3 = new FirebaseRemoteConfigServerException(obj2, httpURLConnection.getResponseMessage());
                throw obj3;
                map4 = "The client had an error while calling the backend!";
                string3 = new FirebaseRemoteConfigClientException(map4, string2);
                throw string3;
                httpURLConnection.disconnect();
                httpURLConnection = httpURLConnection.getInputStream();
                httpURLConnection.close();
                throw string2;
            } catch (java.io.IOException ioException) {
            }
        }
    }

    public long getConnectTimeoutInSeconds() {
        return this.connectTimeoutInSeconds;
    }

    public long getReadTimeoutInSeconds() {
        return this.readTimeoutInSeconds;
    }
}
