package com.google.firebase.installations.remote;

import android.content.Context;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.j;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.FirebaseInstallationsException.Status;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseInstallationServiceClient {

    private static final String ACCEPT_HEADER_KEY = "Accept";
    private static final String API_KEY_HEADER = "x-goog-api-key";
    private static final String CACHE_CONTROL_DIRECTIVE = "no-cache";
    private static final String CACHE_CONTROL_HEADER_KEY = "Cache-Control";
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
    private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
    private static final Pattern EXPIRATION_TIMESTAMP_PATTERN = null;
    private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
    private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
    private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
    private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
    private static final String FIS_TAG = "Firebase-Installations";
    private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final String HEART_BEAT_HEADER = "x-firebase-client-log-type";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final int MAX_RETRIES = 1;
    private static final int NETWORK_TIMEOUT_MILLIS = 10000;
    static final String PARSING_EXPIRATION_TIME_ERROR_MESSAGE = "Invalid Expiration Timestamp.";
    private static final String SDK_VERSION_PREFIX = "a:";
    private static final int TRAFFIC_STATS_CREATE_INSTALLATION_TAG = 32769;
    private static final int TRAFFIC_STATS_DELETE_INSTALLATION_TAG = 32770;
    private static final int TRAFFIC_STATS_FIREBASE_INSTALLATIONS_TAG = 32768;
    private static final int TRAFFIC_STATS_GENERATE_AUTH_TOKEN_TAG = 32771;
    private static final String USER_AGENT_HEADER = "x-firebase-client";
    private static final Charset UTF_8 = null;
    private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
    private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
    private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
    private final Context context;
    private final Provider<HeartBeatInfo> heartbeatInfo;
    private final com.google.firebase.installations.remote.RequestLimiter requestLimiter;
    private boolean shouldServerErrorRetry;
    private final Provider<UserAgentPublisher> userAgentPublisher;
    static {
        FirebaseInstallationServiceClient.EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
        FirebaseInstallationServiceClient.UTF_8 = Charset.forName("UTF-8");
    }

    public FirebaseInstallationServiceClient(Context context, Provider<UserAgentPublisher> provider2, Provider<HeartBeatInfo> provider3) {
        super();
        this.context = context;
        this.userAgentPublisher = provider2;
        this.heartbeatInfo = provider3;
        RequestLimiter obj1 = new RequestLimiter();
        this.requestLimiter = obj1;
    }

    private static String availableFirebaseOptions(String string, String string2, String string3) {
        String obj2;
        boolean obj3;
        Object obj4;
        Object[] arr = new Object[3];
        if (TextUtils.isEmpty(string)) {
            obj2 = "";
        } else {
            obj3 = new StringBuilder();
            obj3.append(", ");
            obj3.append(string);
            obj2 = obj3.toString();
        }
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", string2, string3, obj2);
    }

    private static JSONObject buildCreateFirebaseInstallationRequestBody(String string, String string2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", string);
            jSONObject.put("appId", string2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:17.0.0");
            return jSONObject;
            string2 = new IllegalStateException(string);
            throw string2;
        }
    }

    private static JSONObject buildGenerateAuthTokenRequestBody() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:17.0.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
            IllegalStateException illegalStateException = new IllegalStateException(th);
            throw illegalStateException;
        }
    }

    private String getFingerprintHashForPackage() {
        Context context = this.context;
        byte[] bArr = a.a(context, context.getPackageName());
        if (bArr == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not get fingerprint hash for package: ");
            stringBuilder.append(this.context.getPackageName());
            Log.e("ContentValues", stringBuilder.toString());
            return null;
        }
        return j.c(bArr, false);
    }

    private URL getFullyQualifiedRequestUri(String string) {
        try {
            Object[] arr = new Object[3];
            URL url = new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", string));
            return url;
            string = string.getMessage();
            FirebaseInstallationsException firebaseInstallationsException = new FirebaseInstallationsException(string, FirebaseInstallationsException.Status.UNAVAILABLE);
            throw firebaseInstallationsException;
        }
    }

    private static byte[] getJsonBytes(JSONObject jSONObject) {
        return jSONObject.toString().getBytes("UTF-8");
    }

    private static boolean isSuccessfulResponseCode(int i) {
        int i2;
        int obj1;
        if (i >= 200 && i < 300) {
            obj1 = i < 300 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static void logBadConfigError() {
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    private static void logFisCommunicationError(HttpURLConnection httpURLConnection, String string2, String string3, String string4) {
        boolean empty;
        String obj1;
        obj1 = FirebaseInstallationServiceClient.readErrorResponse(httpURLConnection);
        if (!TextUtils.isEmpty(obj1)) {
            empty = "Firebase-Installations";
            Log.w(empty, obj1);
            Log.w(empty, FirebaseInstallationServiceClient.availableFirebaseOptions(string2, string3, string4));
        }
    }

    private HttpURLConnection openHttpURLConnection(URL uRL, String string2) {
        Object heartBeatCode;
        Object nONE;
        String str;
        try {
            final URLConnection obj4 = uRL.openConnection();
            int i = 10000;
            (HttpURLConnection)obj4.setConnectTimeout(i);
            obj4.setUseCaches(false);
            obj4.setReadTimeout(i);
            String str8 = "application/json";
            obj4.addRequestProperty("Content-Type", str8);
            obj4.addRequestProperty("Accept", str8);
            obj4.addRequestProperty("Content-Encoding", "gzip");
            obj4.addRequestProperty("Cache-Control", "no-cache");
            obj4.addRequestProperty("X-Android-Package", this.context.getPackageName());
            heartBeatCode = (HeartBeatInfo)this.heartbeatInfo.get().getHeartBeatCode("fire-installations-id");
            if (this.heartbeatInfo.get() != null && this.userAgentPublisher.get() != null && heartBeatCode != HeartBeatInfo.HeartBeat.NONE) {
            }
            if (this.userAgentPublisher.get() != null) {
            }
            heartBeatCode = (HeartBeatInfo)this.heartbeatInfo.get().getHeartBeatCode("fire-installations-id");
            if (heartBeatCode != HeartBeatInfo.HeartBeat.NONE) {
            }
            obj4.addRequestProperty("x-firebase-client", (UserAgentPublisher)this.userAgentPublisher.get().getUserAgent());
            obj4.addRequestProperty("x-firebase-client-log-type", Integer.toString(heartBeatCode.getCode()));
            obj4.addRequestProperty("X-Android-Cert", getFingerprintHashForPackage());
            obj4.addRequestProperty("x-goog-api-key", string2);
            return obj4;
            string2 = FirebaseInstallationsException.Status.UNAVAILABLE;
            uRL = new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", string2);
            throw uRL;
        }
    }

    static long parseTokenExpirationTimestamp(String string) {
        long long;
        boolean matches;
        int str;
        Object obj2;
        r.b(FirebaseInstallationServiceClient.EXPIRATION_TIMESTAMP_PATTERN.matcher(string).matches(), "Invalid Expiration Timestamp.");
        if (string != null) {
            if (string.length() == 0) {
                long = 0;
            } else {
                long = Long.parseLong(string.substring(0, length--));
            }
        } else {
        }
        return long;
    }

    private com.google.firebase.installations.remote.InstallationResponse readCreateResponse(HttpURLConnection httpURLConnection) {
        String tokenExpirationTimestamp;
        boolean equals;
        InputStream obj6 = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(obj6, FirebaseInstallationServiceClient.UTF_8);
        JsonReader jsonReader = new JsonReader(inputStreamReader);
        com.google.firebase.installations.remote.TokenResult.Builder builder = TokenResult.builder();
        com.google.firebase.installations.remote.InstallationResponse.Builder builder2 = InstallationResponse.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
            } else {
            }
            if (nextName.equals("fid")) {
            } else {
            }
            if (nextName.equals("refreshToken")) {
            } else {
            }
            if (nextName.equals("authToken")) {
            } else {
            }
            jsonReader.skipValue();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName2 = jsonReader.nextName();
                if (nextName2.equals("token") != null) {
                } else {
                }
                equals = "expiresIn";
                if (nextName2.equals(equals)) {
                } else {
                }
                jsonReader.skipValue();
                builder.setTokenExpirationTimestamp(FirebaseInstallationServiceClient.parseTokenExpirationTimestamp(jsonReader.nextString()));
                builder.setToken(jsonReader.nextString());
            }
            builder2.setAuthToken(builder.build());
            jsonReader.endObject();
            nextName2 = jsonReader.nextName();
            if (nextName2.equals("token") != null) {
            } else {
            }
            equals = "expiresIn";
            if (nextName2.equals(equals)) {
            } else {
            }
            jsonReader.skipValue();
            builder.setTokenExpirationTimestamp(FirebaseInstallationServiceClient.parseTokenExpirationTimestamp(jsonReader.nextString()));
            builder.setToken(jsonReader.nextString());
            builder2.setRefreshToken(jsonReader.nextString());
            builder2.setFid(jsonReader.nextString());
            builder2.setUri(jsonReader.nextString());
        }
        jsonReader.endObject();
        jsonReader.close();
        obj6.close();
        return builder2.setResponseCode(InstallationResponse.ResponseCode.OK).build();
    }

    private static String readErrorResponse(HttpURLConnection httpURLConnection) {
        InputStreamReader inputStreamReader;
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        inputStreamReader = new InputStreamReader(errorStream, FirebaseInstallationServiceClient.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        Object[] arr = new Object[3];
        bufferedReader.close();
        return String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), stringBuilder);
    }

    private com.google.firebase.installations.remote.TokenResult readGenerateAuthTokenResponse(HttpURLConnection httpURLConnection) {
        Charset tokenExpirationTimestamp;
        boolean equals;
        InputStream obj5 = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(obj5, FirebaseInstallationServiceClient.UTF_8);
        JsonReader jsonReader = new JsonReader(inputStreamReader);
        com.google.firebase.installations.remote.TokenResult.Builder builder = TokenResult.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
            } else {
            }
            equals = "expiresIn";
            if (nextName.equals(equals) != null) {
            } else {
            }
            jsonReader.skipValue();
            builder.setTokenExpirationTimestamp(FirebaseInstallationServiceClient.parseTokenExpirationTimestamp(jsonReader.nextString()));
            builder.setToken(jsonReader.nextString());
        }
        jsonReader.endObject();
        jsonReader.close();
        obj5.close();
        return builder.setResponseCode(TokenResult.ResponseCode.OK).build();
    }

    private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, String string2, String string3) {
        FirebaseInstallationServiceClient.writeRequestBodyToOutputStream(httpURLConnection, FirebaseInstallationServiceClient.getJsonBytes(FirebaseInstallationServiceClient.buildCreateFirebaseInstallationRequestBody(string2, string3)));
    }

    private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) {
        FirebaseInstallationServiceClient.writeRequestBodyToOutputStream(httpURLConnection, FirebaseInstallationServiceClient.getJsonBytes(FirebaseInstallationServiceClient.buildGenerateAuthTokenRequestBody()));
    }

    private static void writeRequestBodyToOutputStream(URLConnection uRLConnection, byte[] b2Arr2) {
        OutputStream obj1 = uRLConnection.getOutputStream();
        if (obj1 == null) {
        } else {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(obj1);
            gZIPOutputStream.write(b2Arr2);
            gZIPOutputStream.close();
            obj1.close();
        }
        obj1 = new IOException("Cannot send request to FIS servers. No OutputStream available.");
        throw obj1;
    }

    public com.google.firebase.installations.remote.InstallationResponse createFirebaseInstallation(String string, String string2, String string3, String string4, String string5) {
        int i;
        String httpURLConnection;
        int responseCode;
        String str;
        int i2;
        boolean successfulResponseCode;
        com.google.firebase.installations.remote.InstallationResponse obj9;
        final String str2 = "Firebase Installations Service is unavailable. Please try again later.";
        if (!this.requestLimiter.isRequestAllowed()) {
        } else {
            int i3 = 1;
            Object[] arr = new Object[i3];
            arr[0] = string3;
            while (i <= i3) {
                TrafficStats.setThreadStatsTag(32769);
                httpURLConnection = openHttpURLConnection(getFullyQualifiedRequestUri(String.format("projects/%s/installations", arr)), string);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(i3);
                if (string5 != null) {
                }
                writeFIDCreateRequestBodyToOutputStream(httpURLConnection, string2, string4);
                responseCode = httpURLConnection.getResponseCode();
                this.requestLimiter.setNextRequestTime(responseCode);
                FirebaseInstallationServiceClient.logFisCommunicationError(httpURLConnection, string4, string, string3);
                httpURLConnection.disconnect();
                TrafficStats.clearThreadStatsTag();
                i++;
                httpURLConnection.addRequestProperty("x-goog-fis-android-iid-migration-auth", string5);
            }
            obj9 = new FirebaseInstallationsException(str2, FirebaseInstallationsException.Status.UNAVAILABLE);
            throw obj9;
        }
        obj9 = new FirebaseInstallationsException(str2, FirebaseInstallationsException.Status.UNAVAILABLE);
        throw obj9;
    }

    public void deleteFirebaseInstallation(String string, String string2, String string3, String string4) {
        Object[] httpURLConnection;
        int i;
        int responseCode;
        int i3;
        int i2;
        String str;
        httpURLConnection = new Object[2];
        final int i6 = 1;
        httpURLConnection[i6] = string2;
        while (i <= i6) {
            TrafficStats.setThreadStatsTag(32770);
            httpURLConnection = openHttpURLConnection(getFullyQualifiedRequestUri(String.format("projects/%s/installations/%s", httpURLConnection)), string);
            httpURLConnection.setRequestMethod("DELETE");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FIS_v2 ");
            stringBuilder.append(string4);
            httpURLConnection.addRequestProperty("Authorization", stringBuilder.toString());
            responseCode = httpURLConnection.getResponseCode();
            FirebaseInstallationServiceClient.logFisCommunicationError(httpURLConnection, 0, string, string3);
            i++;
            httpURLConnection.disconnect();
            TrafficStats.clearThreadStatsTag();
        }
        FirebaseInstallationsException obj7 = new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        throw obj7;
    }

    public com.google.firebase.installations.remote.TokenResult generateAuthToken(String string, String string2, String string3, String string4) {
        Object[] httpURLConnection;
        int i3;
        int responseCode;
        int i;
        int i2;
        boolean successfulResponseCode;
        String str;
        com.google.firebase.installations.remote.TokenResult obj8;
        final String str2 = "Firebase Installations Service is unavailable. Please try again later.";
        if (!this.requestLimiter.isRequestAllowed()) {
        } else {
            httpURLConnection = new Object[2];
            final int i6 = 1;
            httpURLConnection[i6] = string2;
            while (i3 <= i6) {
                TrafficStats.setThreadStatsTag(32771);
                httpURLConnection = openHttpURLConnection(getFullyQualifiedRequestUri(String.format("projects/%s/installations/%s/authTokens:generate", httpURLConnection)), string);
                httpURLConnection.setRequestMethod("POST");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("FIS_v2 ");
                stringBuilder.append(string4);
                httpURLConnection.addRequestProperty("Authorization", stringBuilder.toString());
                httpURLConnection.setDoOutput(i6);
                writeGenerateAuthTokenRequestBodyToOutputStream(httpURLConnection);
                responseCode = httpURLConnection.getResponseCode();
                this.requestLimiter.setNextRequestTime(responseCode);
                FirebaseInstallationServiceClient.logFisCommunicationError(httpURLConnection, 0, string, string3);
                httpURLConnection.disconnect();
                TrafficStats.clearThreadStatsTag();
                i3++;
            }
            obj8 = new FirebaseInstallationsException(str2, FirebaseInstallationsException.Status.UNAVAILABLE);
            throw obj8;
        }
        obj8 = new FirebaseInstallationsException(str2, FirebaseInstallationsException.Status.UNAVAILABLE);
        throw obj8;
    }
}
