package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import app.dogo.com.dogo_android.g.r;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public abstract class ak implements Runnable {

    protected static String AFInAppEventParameterName = null;
    private static int[] AFLogger$LogLevel = null;
    private static int AFVersionDeclaration = 0;
    private static int onDeepLinkingNative = 1;
    private static String values;
    public String AFInAppEventType;
    public final String AFKeystoreWrapper;
    private final Context AppsFlyer2dXConversionCallback;
    public final Map<String, Object> getLevel;
    public final String init;
    private final com.appsflyer.internal.ah valueOf;

    public static class a implements Runnable {

        private final com.appsflyer.internal.cd AFInAppEventParameterName;
        public a(com.appsflyer.internal.cd cd) {
            super();
            this.AFInAppEventParameterName = cd;
        }

        @Override // java.lang.Runnable
        public HttpURLConnection AFKeystoreWrapper() {
            String string;
            int responseCode;
            String valueOf;
            String onInstallConversionDataLoadedNative;
            String str4;
            int i;
            com.appsflyer.internal.an anVar2;
            boolean values;
            boolean string2;
            boolean invoke;
            byte[] strArr2;
            String str6;
            int valueOf2;
            com.appsflyer.internal.an anVar;
            String str5;
            String str3;
            Object obj2;
            StringBuilder stringBuilder;
            String str;
            String str2;
            String[] strArr;
            Class<String> obj;
            int eastAsianWidth;
            final Object obj3 = this;
            valueOf = "";
            com.appsflyer.internal.cd aFInAppEventParameterName = obj3.AFInAppEventParameterName;
            string = aFInAppEventParameterName.getLevel();
            string2 = obj3.AFInAppEventParameterName.AFLogger$LogLevel();
            invoke = obj3.AFInAppEventParameterName.AFInAppEventParameterName();
            valueOf2 = 0;
            if (obj3.AFInAppEventParameterName.AppsFlyer2dXConversionCallback()) {
                return valueOf2;
            }
            i = 0;
            final int i10 = 1;
            URL url = new URL(aFInAppEventParameterName.onInstallConversionDataLoadedNative);
            if (string2 != null && an.values == null) {
                if (an.values == null) {
                    anVar = new an();
                    an.values = anVar;
                }
                strArr = new String[i10];
                strArr[i] = string;
                an.values.AFInAppEventType("server_request", url.toString(), strArr);
                int length = bytes.length;
                stringBuilder = new StringBuilder("call = ");
                stringBuilder.append(url);
                stringBuilder.append("; size = ");
                stringBuilder.append(length);
                stringBuilder.append(" byte");
                str5 = length > i10 ? "s" : valueOf;
                stringBuilder.append(str5);
                stringBuilder.append("; body = ");
                stringBuilder.append(string);
                aj.valueOf(stringBuilder.toString());
            }
            TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
            obj2 = instrument;
            int i3 = 30000;
            (HttpURLConnection)obj2.setReadTimeout(i3);
            obj2.setConnectTimeout(i3);
            obj2.setRequestMethod("POST");
            obj2.setDoInput(i10);
            obj2.setDoOutput(i10);
            str = invoke ? "application/octet-stream" : "application/json";
            obj2.setRequestProperty("Content-Type", str);
            OutputStream outputStream = obj2.getOutputStream();
            if (invoke) {
                Object[] arr = new Object[i10];
                arr[i] = aFInAppEventParameterName6.AFLogger$LogLevel;
                int i5 = 0;
                int i18 = 48;
                Class[] arr2 = new Class[i10];
                arr2[i] = String.class;
                valueOf2 = new Object[i10];
                valueOf2[i] = string.getBytes();
                str2 = new Class[i10];
                str2[i] = byte[].class;
                strArr2 = invoke;
            }
            outputStream.write(strArr2);
            outputStream.close();
            obj2.connect();
            responseCode = obj2.getResponseCode();
            if (obj3.AFInAppEventParameterName.AFVersionDeclaration()) {
                ah.AFKeystoreWrapper();
                valueOf = ah.valueOf(obj2);
            }
            if (string2 != null && an.values == null) {
                if (an.values == null) {
                    anVar2 = new an();
                    an.values = anVar2;
                }
                strArr2 = new String[2];
                strArr2[i] = String.valueOf(responseCode);
                strArr2[i10] = valueOf;
                an.values.AFInAppEventType("server_response", url.toString(), strArr2);
            }
            if (responseCode == 200) {
                AFLogger.AFInAppEventType("Status 200 ok");
            } else {
                i = i10;
            }
            StringBuilder stringBuilder2 = new StringBuilder("Connection ");
            str4 = i != 0 ? "error" : "call succeeded";
            stringBuilder2.append(str4);
            stringBuilder2.append(": ");
            stringBuilder2.append(valueOf);
            AFLogger.AFInAppEventType(stringBuilder2.toString());
            return obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            final HttpURLConnection connection = AFKeystoreWrapper();
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    static {
        ak.AFKeystoreWrapper();
        ak.values = "v2";
        StringBuilder stringBuilder = new StringBuilder("https://%sonelink.%s/shortlink-sdk/");
        stringBuilder.append(ak.values);
        ak.AFInAppEventParameterName = stringBuilder.toString();
        onDeepLinkingNative += 119;
        ak.AFVersionDeclaration = i % 128;
        i %= 2;
    }

    public ak(com.appsflyer.internal.ah ah, Context context2, String string3) {
        super();
        this.valueOf = ah;
        this.AppsFlyer2dXConversionCallback = context2;
        this.AFKeystoreWrapper = string3;
        this.init = UUID.randomUUID().toString();
        this.getLevel = AFInAppEventType();
    }

    private static String AFInAppEventParameterName(int[] iArr, int i2) {
        int i4;
        int i5;
        int i6;
        int i;
        char c2;
        int i3;
        int i7;
        char c;
        char[] cArr = new char[4];
        i4 = 1;
        char[] cArr2 = new char[length <<= i4];
        final int i11 = 0;
        i5 = i11;
        while (i5 < iArr.length) {
            i = i4;
            int i20 = 2;
            if (i != 0) {
            }
            aFVersionDeclaration += 7;
            ak.onDeepLinkingNative = i12 % 128;
            i12 %= i20;
            cArr[i11] = (char)i15;
            cArr[i4] = (char)i16;
            int i17 = i5 + 1;
            cArr[i20] = (char)i23;
            i3 = 3;
            cArr[i3] = (char)i18;
            cw.AFInAppEventType(cArr, (int[])ak.AFLogger$LogLevel.clone(), i11);
            int i19 = i5 << 1;
            cArr2[i19] = cArr[i11];
            cArr2[i19 + 1] = cArr[i4];
            cArr2[i19 + 2] = cArr[i20];
            cArr2[i19 += i3] = cArr[i3];
            i5 += 2;
            i = i11;
        }
        String obj11 = new String(cArr2, i11, i2);
        obj12 += 49;
        ak.onDeepLinkingNative = obj12 % 128;
        if (obj12 %= i20 == 0) {
        } else {
            i4 = i11;
        }
        if (i4 != 0) {
            obj12 /= i11;
            return obj11;
        }
        return obj11;
    }

    private Map<String, Object> AFInAppEventType() {
        int i;
        HashMap hashMap = new HashMap();
        hashMap.put("build_number", "6.5.0");
        final int i11 = 0;
        hashMap.put("counter", Integer.valueOf(ah.AFInAppEventType(ah.AFKeystoreWrapper(this.AppsFlyer2dXConversionCallback), "appsFlyerCount", i11)));
        hashMap.put("model", Build.MODEL);
        hashMap.put("brand", Build.BRAND);
        hashMap.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        hashMap.put("app_version_name", packageInfo.versionName);
        onDeepLinkingNative += 103;
        ak.AFVersionDeclaration = i3 % 128;
        i3 %= 2;
        hashMap.put("app_id", this.AppsFlyer2dXConversionCallback.getPackageName());
        am amVar = new am();
        hashMap.put("platformextension", amVar.AFInAppEventParameterName());
        onDeepLinkingNative2 += 19;
        ak.AFVersionDeclaration = i5 % 128;
        int i10 = 99;
        i = i5 %= 2 != 0 ? i10 : 5;
        if (i != i10) {
            return hashMap;
        }
        int length = i7.length;
        return hashMap;
    }

    static void AFKeystoreWrapper() {
        int[] iArr = new int[18];
        iArr = new int[]{
            1918731084, -310568723, -1652289190, -961615515, 1066613407, -1049983214, 179827086, 1212517371, 95740015, 2081147928,
            1143774037, 191737503, -400039645, 1882568412, 83919896, 171568870, -357347699, -28532183
        };
        ak.AFLogger$LogLevel = iArr;
    }

    @Override // java.lang.Runnable
    protected abstract void AFInAppEventParameterName();

    @Override // java.lang.Runnable
    protected final void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection, String... string2Arr2) {
        int obj7;
        ArrayList arrayList = new ArrayList(Arrays.asList(string2Arr2));
        arrayList.add(1, ak.values);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppsFlyerProperties.getInstance().getDevKey());
        stringBuilder.append(this.init);
        stringBuilder.append(ak.values);
        int[] iArr = new int[6];
        iArr = new int[]{-791064114, -181652417, -656289626, -1474981546, 97734436, 2084156823};
        httpsURLConnection.setRequestProperty(ak.AFInAppEventParameterName(iArr, packedPositionType += 12).intern(), ag.AFKeystoreWrapper(TextUtils.join("⁣", (String[])arrayList.toArray(new String[0])), stringBuilder.toString()));
        obj6 += 123;
        ak.AFVersionDeclaration = obj6 % 128;
        if (obj6 %= 2 != 0) {
        } else {
            obj7 = 4;
        }
        if (obj7 != null) {
        }
        int obj6 = obj6.length;
    }

    @Override // java.lang.Runnable
    protected abstract void AFInAppEventType(String string);

    @Override // java.lang.Runnable
    protected abstract void AFInAppEventType(HttpsURLConnection httpsURLConnection);

    @Override // java.lang.Runnable
    public void run() {
        String string;
        String valueOf2;
        int i;
        int i2;
        Throwable th3;
        String valueOf;
        String str;
        int str2;
        Throwable th;
        string = "";
        valueOf2 = valueOf();
        AFLogger.AFKeystoreWrapper("oneLinkUrl: ".concat(String.valueOf(valueOf2)));
        i2 = 0;
        int i8 = 1;
        URL url = new URL(valueOf2);
        Object instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
        (HttpsURLConnection)(URLConnection)instrument.setRequestProperty("content-type", "application/json");
        int i9 = 3000;
        instrument.setReadTimeout(i9);
        instrument.setConnectTimeout(i9);
        instrument.setRequestMethod(this.AFKeystoreWrapper);
        AFInAppEventType(instrument);
        int responseCode = instrument.getResponseCode();
        str2 = responseCode == 200 ? i8 : i2;
        if (str2 != i8) {
            StringBuilder stringBuilder = new StringBuilder("Response code = ");
            stringBuilder.append(responseCode);
            stringBuilder.append(" content = ");
            stringBuilder.append(ah.valueOf(instrument));
            string = stringBuilder.toString();
            onDeepLinkingNative += 109;
            ak.AFVersionDeclaration = i7 % 128;
            i7 %= 2;
        } else {
            AFLogger.AFInAppEventType("Status 200 ok");
        }
        i = TextUtils.isEmpty(string) ? i8 : i2;
        if (i != i8) {
            AFLogger.init("Connection error: ".concat(String.valueOf(string)));
            AFInAppEventParameterName();
        }
        AFLogger.AFInAppEventType("Connection call succeeded: ".concat(String.valueOf(valueOf)));
        AFInAppEventType(valueOf);
        aFVersionDeclaration += 19;
        ak.onDeepLinkingNative = i3 % 128;
        if (i3 %= 2 == 0) {
            i2 = i8;
        }
        if (i2 != 0) {
            super.hashCode();
        }
    }

    @Override // java.lang.Runnable
    protected abstract String valueOf();
}
