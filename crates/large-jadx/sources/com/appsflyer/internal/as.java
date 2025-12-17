package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class as extends com.appsflyer.internal.ak {

    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    boolean valueOf;
    com.appsflyer.internal.as.d values;

    interface d {
        public abstract void AFInAppEventParameterName(Map<String, String> map);

        public abstract void AFInAppEventType(String string);
    }
    as(Uri uri, com.appsflyer.internal.ah ah2, Context context3) {
        String length;
        int i2;
        int contains2;
        int i;
        String host;
        boolean contains;
        Object obj7;
        int obj8;
        boolean obj9;
        super(ah2, context3, "GET");
        obj8 = 0;
        this.valueOf = obj8;
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            if (!TextUtils.isEmpty(uri.getPath())) {
                i2 = length;
                contains2 = 3;
                i = 1;
                while (length < contains2) {
                    if (uri.getHost().contains(/* result */[length])) {
                    }
                    length++;
                    contains2 = 3;
                    i = 1;
                    i2 = i;
                }
                if (h.AppsFlyer2dXConversionCallback != null) {
                    obj9 = new StringBuilder("Validate if link ");
                    obj9.append(uri);
                    obj9.append(" belongs to custom domains: ");
                    obj9.append(Arrays.asList(h.AppsFlyer2dXConversionCallback));
                    AFLogger.AFKeystoreWrapper(obj9.toString());
                    obj9 = h.AppsFlyer2dXConversionCallback;
                    while (obj8 < obj9.length) {
                        host = obj9[obj8];
                        if (uri.getHost().contains(host) && !TextUtils.isEmpty(host)) {
                        }
                        obj8++;
                        if (!TextUtils.isEmpty(host)) {
                        }
                        AFLogger.values("Link matches custom domain: ".concat(String.valueOf(host)));
                        this.valueOf = i;
                        i2 = i;
                    }
                }
                obj8 = uri.getPath().split("/");
                if (i2 != 0 && obj8.length == contains2) {
                    if (obj8.length == contains2) {
                        this.AFInAppEventType = obj8[i];
                        this.AFVersionDeclaration = obj8[2];
                        this.AFLogger$LogLevel = uri.toString();
                    }
                }
            }
        }
    }

    @Override // com.appsflyer.internal.ak
    final void AFInAppEventParameterName() {
        String aFLogger$LogLevel;
        if (this.AFLogger$LogLevel != null) {
        } else {
            aFLogger$LogLevel = "Can't get OneLink data";
        }
        this.values.AFInAppEventType(aFLogger$LogLevel);
    }

    @Override // com.appsflyer.internal.ak
    final void AFInAppEventType(String string) {
        Object next;
        String optString;
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(string);
            final Iterator keys = jSONObject.keys();
            for (String next : keys) {
                hashMap.put(next, jSONObject.optString(next));
            }
            next = keys.next();
            hashMap.put(next, jSONObject.optString((String)next));
            this.values.AFInAppEventParameterName(hashMap);
            com.appsflyer.internal.as.d str = this.values;
            str.AFInAppEventType("Can't parse OneLink data");
            string = String.valueOf(string);
            str = "Error while parsing to json ";
            string = str.concat(string);
            AFLogger.AFKeystoreWrapper(string, th);
        }
    }

    @Override // com.appsflyer.internal.ak
    final void AFInAppEventType(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestProperty("Af-UUID", this.init);
        String valueOf = String.valueOf(this.getLevel.get("build_number"));
        httpsURLConnection.setRequestProperty("Af-Meta-Sdk-Ver", valueOf);
        httpsURLConnection.setRequestProperty("Af-Meta-Counter", String.valueOf(this.getLevel.get("counter")));
        httpsURLConnection.setRequestProperty("Af-Meta-Model", String.valueOf(this.getLevel.get("model")));
        httpsURLConnection.setRequestProperty("Af-Meta-Platform", String.valueOf(this.getLevel.get("platformextension")));
        httpsURLConnection.setRequestProperty("Af-Meta-System-Version", String.valueOf(this.getLevel.get("sdk")));
        String[] strArr = new String[5];
        AFInAppEventParameterName(httpsURLConnection, this.AFKeystoreWrapper, this.init, this.AFInAppEventType, this.AFVersionDeclaration, valueOf);
    }

    @Override // com.appsflyer.internal.ak
    final String valueOf() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] arr = new Object[2];
        stringBuilder.append(String.format(ak.AFInAppEventParameterName, AppsFlyerLib.getInstance().getHostPrefix(), ah.AFKeystoreWrapper().getHostName()));
        stringBuilder.append("/");
        stringBuilder.append(this.AFInAppEventType);
        stringBuilder.append("?id=");
        stringBuilder.append(this.AFVersionDeclaration);
        return stringBuilder.toString();
    }

    @Override // com.appsflyer.internal.ak
    final boolean values() {
        boolean equals;
        String str;
        if (!TextUtils.isEmpty(this.AFInAppEventType) && !TextUtils.isEmpty(this.AFVersionDeclaration) && !this.AFInAppEventType.equals("app")) {
            if (!TextUtils.isEmpty(this.AFVersionDeclaration)) {
                if (!this.AFInAppEventType.equals("app")) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
