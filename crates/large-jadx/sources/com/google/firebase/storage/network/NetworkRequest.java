package com.google.firebase.storage.network;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.internal.StorageReferenceUri;
import com.google.firebase.storage.network.connection.HttpURLConnectionFactory;
import com.google.firebase.storage.network.connection.HttpURLConnectionFactoryImpl;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class NetworkRequest {

    static final boolean $assertionsDisabled = false;
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_TYPE = "Content-Type";
    static final String DELETE = "DELETE";
    static final String GET = "GET";
    public static final int INITIALIZATION_EXCEPTION = -1;
    private static final int MAXIMUM_TOKEN_WAIT_TIME_MS = 30000;
    public static final int NETWORK_UNAVAILABLE = -2;
    static final String PATCH = "PATCH";
    static final String POST = "POST";
    public static final Uri PROD_BASE_URL = null;
    static final String PUT = "PUT";
    private static final String TAG = "NetworkRequest";
    private static final String UTF_8 = "UTF-8";
    private static final String X_FIREBASE_APPCHECK = "x-firebase-appcheck";
    private static final String X_FIREBASE_GMPID = "x-firebase-gmpid";
    static HttpURLConnectionFactory connectionFactory;
    private static String gmsCoreVersion;
    private HttpURLConnection connection;
    private Context context;
    protected Exception mException;
    private String rawStringResponse;
    private Map<String, String> requestHeaders;
    private int resultCode;
    private Map<String, List<String>> resultHeaders;
    private InputStream resultInputStream;
    private int resultingContentLength;
    private StorageReferenceUri storageReferenceUri;
    static {
        NetworkRequest.PROD_BASE_URL = Uri.parse("https://firebasestorage.googleapis.com/v0");
        HttpURLConnectionFactoryImpl httpURLConnectionFactoryImpl = new HttpURLConnectionFactoryImpl();
        NetworkRequest.connectionFactory = httpURLConnectionFactoryImpl;
    }

    public NetworkRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp2) {
        super();
        HashMap hashMap = new HashMap();
        this.requestHeaders = hashMap;
        r.j(storageReferenceUri);
        r.j(firebaseApp2);
        this.storageReferenceUri = storageReferenceUri;
        this.context = firebaseApp2.getApplicationContext();
        setCustomHeader("x-firebase-gmpid", firebaseApp2.getOptions().getApplicationId());
    }

    private void constructMessage(HttpURLConnection httpURLConnection, String string2, String string3) {
        String empty;
        boolean empty2;
        int outputRawSize;
        Object bufferedOutputStream;
        String str;
        int length2;
        int length;
        Object obj6;
        String obj7;
        String obj8;
        r.j(httpURLConnection);
        bufferedOutputStream = "NetworkRequest";
        if (!TextUtils.isEmpty(string2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Firebase ");
            stringBuilder.append(string2);
            httpURLConnection.setRequestProperty("Authorization", stringBuilder.toString());
        } else {
            Log.w(bufferedOutputStream, "no auth token for request");
        }
        if (!TextUtils.isEmpty(string3)) {
            httpURLConnection.setRequestProperty("x-firebase-appcheck", string3);
        } else {
            Log.w(bufferedOutputStream, "No App Check token for request.");
        }
        obj7 = new StringBuilder("Android/");
        obj8 = NetworkRequest.getGmsCoreVersion(this.context);
        if (!TextUtils.isEmpty(obj8)) {
            obj7.append(obj8);
        }
        httpURLConnection.setRequestProperty("X-Firebase-Storage-Version", obj7.toString());
        obj7 = this.requestHeaders.entrySet().iterator();
        for (Map.Entry obj8 : obj7) {
            httpURLConnection.setRequestProperty((String)obj8.getKey(), (String)obj8.getValue());
        }
        obj7 = getOutputJSON();
        if (obj7 != null) {
            outputRawSize = obj8.length;
        } else {
            obj8 = getOutputRaw();
            if (getOutputRawSize() == 0 && obj8 != null) {
                if (obj8 != null) {
                    outputRawSize = obj8.length;
                }
            }
        }
        length2 = 1;
        final String str3 = "Content-Length";
        if (obj8 != null && obj8.length > 0) {
            if (obj8.length > 0) {
                if (obj7 != null) {
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                }
                httpURLConnection.setDoOutput(length2);
                httpURLConnection.setRequestProperty(str3, Integer.toString(outputRawSize));
            } else {
                httpURLConnection.setRequestProperty(str3, "0");
            }
        } else {
        }
        obj7 = 0;
        httpURLConnection.setUseCaches(obj7);
        httpURLConnection.setDoInput(length2);
        if (obj8 != null && obj8.length > 0) {
            if (obj8.length > 0) {
                obj6 = httpURLConnection.getOutputStream();
                if (obj6 != null) {
                    bufferedOutputStream = new BufferedOutputStream(obj6);
                    bufferedOutputStream.write(obj8, obj7, outputRawSize);
                    bufferedOutputStream.close();
                } else {
                    Log.e(bufferedOutputStream, "Unable to write to the http request!");
                }
            }
        }
    }

    private HttpURLConnection createConnection() {
        Uri uRL;
        Object queryParameters;
        boolean value;
        Object key;
        queryParameters = getQueryParameters();
        if (queryParameters != null) {
            Uri.Builder upon = getURL().buildUpon();
            queryParameters = queryParameters.entrySet().iterator();
            for (Map.Entry next : queryParameters) {
                upon.appendQueryParameter((String)next.getKey(), (String)next.getValue());
            }
            uRL = upon.build();
        }
        URL url = new URL(uRL.toString());
        return NetworkRequest.connectionFactory.createInstance(url);
    }

    private boolean ensureNetworkAvailable(Context context) {
        NetworkInfo obj2;
        obj2 = (ConnectivityManager)context.getSystemService("connectivity").getActiveNetworkInfo();
        if (obj2 != null && !obj2.isConnected()) {
            if (!obj2.isConnected()) {
            }
            return 1;
        }
        obj2 = new SocketException("Network subsystem is unavailable");
        this.mException = obj2;
        this.resultCode = -2;
        return 0;
    }

    public static Uri getBaseUrl(EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(emulatedServiceSettings.getHost());
            stringBuilder.append(":");
            stringBuilder.append(emulatedServiceSettings.getPort());
            stringBuilder.append("/v0");
            return Uri.parse(stringBuilder.toString());
        }
        return Uri.parse("https://firebasestorage.googleapis.com/v0");
    }

    private static String getGmsCoreVersion(Context context) {
        String gmsCoreVersion;
        int str;
        String obj2;
        if (NetworkRequest.gmsCoreVersion == null) {
            NetworkRequest.gmsCoreVersion = obj2.versionName;
            if (NetworkRequest.gmsCoreVersion == null) {
                NetworkRequest.gmsCoreVersion = "[No Gmscore]";
            }
        }
        return NetworkRequest.gmsCoreVersion;
    }

    private static String getPathWithoutBucket(Uri uri) {
        boolean startsWith;
        String obj1;
        obj1 = uri.getPath();
        if (obj1 == null) {
            return "";
        }
        if (obj1.startsWith("/")) {
            obj1 = obj1.substring(1);
        }
        return obj1;
    }

    private void parseResponse(InputStream inputStream) {
        Object rawStringResponse;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        String str;
        InputStream obj5;
        rawStringResponse = new StringBuilder();
        if (inputStream != null) {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            obj5 = bufferedReader.readLine();
            while (obj5 != null) {
                rawStringResponse.append(obj5);
                obj5 = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        this.rawStringResponse = rawStringResponse.toString();
        if (!isResultSuccess()) {
            obj5 = new IOException(this.rawStringResponse);
            this.mException = obj5;
        }
    }

    private void parseResponse(HttpURLConnection httpURLConnection) {
        InputStream obj2;
        r.j(httpURLConnection);
        this.resultCode = httpURLConnection.getResponseCode();
        this.resultHeaders = httpURLConnection.getHeaderFields();
        this.resultingContentLength = httpURLConnection.getContentLength();
        if (isResultSuccess()) {
            this.resultInputStream = httpURLConnection.getInputStream();
        } else {
            this.resultInputStream = httpURLConnection.getErrorStream();
        }
    }

    private final void performRequest(String string, String string2) {
        String str;
        String obj2;
        String obj3;
        performRequestStart(string, string2);
        processResponseStream();
        performRequestEnd();
    }

    private void processResponseStream() {
        InputStream resultInputStream;
        if (isResultSuccess()) {
            parseSuccessulResponse(this.resultInputStream);
        } else {
            parseErrorResponse(this.resultInputStream);
        }
    }

    public <TResult> void completeTask(k<TResult> k, TResult tresult2) {
        Object obj4;
        final Exception exception = getException();
        if (isResultSuccess() && exception == null) {
            if (exception == null) {
                k.c(tresult2);
            } else {
                k.b(StorageException.fromExceptionAndHttpCode(exception, getResultCode()));
            }
        } else {
        }
    }

    protected abstract String getAction();

    public Exception getException() {
        return this.mException;
    }

    protected JSONObject getOutputJSON() {
        return null;
    }

    protected byte[] getOutputRaw() {
        return null;
    }

    protected int getOutputRawSize() {
        return 0;
    }

    String getPathWithoutBucket() {
        return NetworkRequest.getPathWithoutBucket(this.storageReferenceUri.getGsUri());
    }

    protected Map<String, String> getQueryParameters() {
        return 0;
    }

    public String getRawResult() {
        return this.rawStringResponse;
    }

    public JSONObject getResultBody() {
        JSONObject jSONObject;
        Object rawStringResponse;
        String str;
        if (!TextUtils.isEmpty(this.rawStringResponse)) {
            jSONObject = new JSONObject(this.rawStringResponse);
        } else {
            jSONObject = new JSONObject();
        }
        return jSONObject;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public Map<String, String> getResultHeaders() {
        return this.requestHeaders;
    }

    public Map<String, List<String>> getResultHeadersImpl() {
        return this.resultHeaders;
    }

    public String getResultString(String string) {
        Map resultHeadersImpl;
        Object obj2;
        resultHeadersImpl = getResultHeadersImpl();
        obj2 = resultHeadersImpl.get(string);
        if (resultHeadersImpl != null && obj2 != null && (List)obj2.size() > 0) {
            obj2 = resultHeadersImpl.get(string);
            if ((List)obj2 != null) {
                if ((List)obj2.size() > 0) {
                    return (String)obj2.get(0);
                }
            }
        }
        return null;
    }

    public int getResultingContentLength() {
        return this.resultingContentLength;
    }

    protected StorageReferenceUri getStorageReferenceUri() {
        return this.storageReferenceUri;
    }

    public InputStream getStream() {
        return this.resultInputStream;
    }

    public Uri getURL() {
        return this.storageReferenceUri.getHttpUri();
    }

    public boolean isResultSuccess() {
        int i;
        int i2;
        int resultCode = this.resultCode;
        if (resultCode >= 200 && resultCode < 300) {
            i = resultCode < 300 ? 1 : 0;
        } else {
        }
        return i;
    }

    protected void parseErrorResponse(InputStream inputStream) {
        parseResponse(inputStream);
    }

    protected void parseSuccessulResponse(InputStream inputStream) {
        parseResponse(inputStream);
    }

    public void performRequest(String string, String string2, Context context3) {
        if (!ensureNetworkAvailable(context3)) {
        }
        performRequest(string, string2);
    }

    public void performRequestEnd() {
        final HttpURLConnection connection = this.connection;
        if (connection != null) {
            connection.disconnect();
        }
    }

    public void performRequestStart(String string, String string2) {
        int i;
        boolean loggable;
        NetworkInfo activeNetworkInfo;
        Uri uRL;
        boolean obj7;
        String obj8;
        if (this.mException != null) {
            this.resultCode = -1;
        }
        String str = "NetworkRequest";
        i = 3;
        if (Log.isLoggable(str, i)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sending network request ");
            stringBuilder.append(getAction());
            stringBuilder.append(" ");
            stringBuilder.append(getURL());
            Log.d(str, stringBuilder.toString());
        }
        activeNetworkInfo = (ConnectivityManager)this.context.getSystemService("connectivity").getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (!activeNetworkInfo.isConnected()) {
            } else {
                HttpURLConnection connection = createConnection();
                this.connection = connection;
                connection.setRequestMethod(getAction());
                constructMessage(this.connection, string, string2);
                parseResponse(this.connection);
                if (Log.isLoggable(str, i)) {
                    obj7 = new StringBuilder();
                    obj7.append("network request result ");
                    obj7.append(this.resultCode);
                    Log.d(str, obj7.toString());
                }
            }
        }
        this.resultCode = -2;
        obj7 = new SocketException("Network subsystem is unavailable");
        this.mException = obj7;
    }

    public final void reset() {
        this.mException = 0;
        this.resultCode = 0;
    }

    public void setCustomHeader(String string, String string2) {
        this.requestHeaders.put(string, string2);
    }
}
