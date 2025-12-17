package com.appsflyer;

import android.content.Context;
import com.appsflyer.internal.ah;
import com.appsflyer.internal.ak;
import com.appsflyer.internal.n;
import com.appsflyer.share.LinkGenerator;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class CreateOneLinkHttpTask extends ak {

    private String AFLogger$LogLevel;
    private final Map<String, String> AFVersionDeclaration;
    private final String AppsFlyer2dXConversionCallback;
    public String valueOf;
    public com.appsflyer.CreateOneLinkHttpTask.ResponseListener values;

    public interface ResponseListener {
        public abstract void onResponse(String string);

        public abstract void onResponseError(String string);
    }
    public CreateOneLinkHttpTask(String string, Map<String, String> map2, ah ah3, Context context4) {
        String obj4;
        super(ah3, context4, "POST");
        this.AFLogger$LogLevel = "";
        if (context4 != null) {
            this.AFLogger$LogLevel = context4.getPackageName();
        } else {
            AFLogger.init("CreateOneLinkHttpTask: context can't be null");
        }
        this.AFInAppEventType = string;
        this.AppsFlyer2dXConversionCallback = "-1";
        this.AFVersionDeclaration = map2;
    }

    @Override // com.appsflyer.internal.ak
    public final void AFInAppEventParameterName() {
        LinkGenerator linkGenerator = new LinkGenerator("af_app_invites");
        LinkGenerator parameters = linkGenerator.setBaseURL(this.AFInAppEventType, AppsFlyerProperties.getInstance().getString("onelinkDomain"), this.AFLogger$LogLevel).addParameter("af_siteid", this.AFLogger$LogLevel).addParameters(this.AFVersionDeclaration);
        ah.AFKeystoreWrapper();
        String string2 = AppsFlyerProperties.getInstance().getString("AppUserId");
        if (string2 != null) {
            parameters.setReferrerCustomerId(string2);
        }
        this.values.onResponse(parameters.generateLink());
    }

    @Override // com.appsflyer.internal.ak
    public final void AFInAppEventType(String string) {
        String optString;
        com.appsflyer.CreateOneLinkHttpTask.ResponseListener values;
        try {
            JSONObject jSONObject = new JSONObject(string);
            final Iterator keys = jSONObject.keys();
            for (String next2 : keys) {
                this.values.onResponse(jSONObject.optString(next2));
            }
            this.values.onResponse(jSONObject.optString((String)keys.next()));
            com.appsflyer.CreateOneLinkHttpTask.ResponseListener str = this.values;
            str.onResponseError("Can't parse one link data");
            string = String.valueOf(string);
            str = "Error while parsing to json ";
            string = str.concat(string);
            AFLogger.AFKeystoreWrapper(string, th);
        }
    }

    @Override // com.appsflyer.internal.ak
    public final void AFInAppEventType(HttpsURLConnection httpsURLConnection) {
        String str;
        int i = 1;
        httpsURLConnection.setDoInput(i);
        httpsURLConnection.setDoOutput(i);
        final int i2 = 0;
        httpsURLConnection.setUseCaches(i2);
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", this.AppsFlyer2dXConversionCallback);
        hashMap.put("uuid", this.init);
        hashMap.put("data", this.AFVersionDeclaration);
        hashMap.put("meta", this.getLevel);
        String valueOf = this.valueOf;
        if (valueOf != null) {
            hashMap.put("brand_domain", valueOf);
        }
        String string = n.values(hashMap).toString();
        String[] strArr = new String[2];
        strArr[i2] = this.AFKeystoreWrapper;
        strArr[i] = string;
        AFInAppEventParameterName(httpsURLConnection, strArr);
        httpsURLConnection.connect();
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(string);
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    @Override // com.appsflyer.internal.ak
    public final String valueOf() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] arr = new Object[2];
        stringBuilder.append(String.format(ak.AFInAppEventParameterName, AppsFlyerLib.getInstance().getHostPrefix(), ah.AFKeystoreWrapper().getHostName()));
        stringBuilder.append("/");
        stringBuilder.append(this.AFInAppEventType);
        return stringBuilder.toString();
    }
}
