package com.google.firebase.crashlytics.internal.settings.network;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DefaultSettingsSpiCall implements com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall {

    static final String ACCEPT_JSON_VALUE = "application/json";
    static final String ANDROID_CLIENT_TYPE = "android";
    static final String BUILD_VERSION_PARAM = "build_version";
    static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    static final String DISPLAY_VERSION_PARAM = "display_version";
    static final String HEADER_ACCEPT = "Accept";
    static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    static final String HEADER_DEVICE_MODEL = "X-CRASHLYTICS-DEVICE-MODEL";
    static final String HEADER_GOOGLE_APP_ID = "X-CRASHLYTICS-GOOGLE-APP-ID";
    static final String HEADER_INSTALLATION_ID = "X-CRASHLYTICS-INSTALLATION-ID";
    static final String HEADER_OS_BUILD_VERSION = "X-CRASHLYTICS-OS-BUILD-VERSION";
    static final String HEADER_OS_DISPLAY_VERSION = "X-CRASHLYTICS-OS-DISPLAY-VERSION";
    static final String HEADER_USER_AGENT = "User-Agent";
    static final String INSTANCE_PARAM = "instance";
    static final String SOURCE_PARAM = "source";
    private final Logger logger;
    private final HttpRequestFactory requestFactory;
    private final String url;
    public DefaultSettingsSpiCall(String string, HttpRequestFactory httpRequestFactory2) {
        super(string, httpRequestFactory2, Logger.getLogger());
    }

    DefaultSettingsSpiCall(String string, HttpRequestFactory httpRequestFactory2, Logger logger3) {
        super();
        if (string == null) {
        } else {
            this.logger = logger3;
            this.requestFactory = httpRequestFactory2;
            this.url = string;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("url must not be null.");
        throw obj1;
    }

    private HttpGetRequest applyHeadersTo(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest2) {
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", settingsRequest2.googleAppId);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getVersion());
        applyNonNullHeader(httpGetRequest, "Accept", "application/json");
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest2.deviceModel);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest2.osBuildVersion);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest2.osDisplayVersion);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest2.installIdProvider.getCrashlyticsInstallId());
        return httpGetRequest;
    }

    private void applyNonNullHeader(HttpGetRequest httpGetRequest, String string2, String string3) {
        if (string3 != null) {
            httpGetRequest.header(string2, string3);
        }
    }

    private JSONObject getJsonObjectFrom(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject;
            Logger stringBuilder = this.logger;
            StringBuilder str = new StringBuilder();
            String url = "Failed to parse settings JSON from ";
            str.append(url);
            url = this.url;
            str.append(url);
            str = str.toString();
            stringBuilder.w(str, logger);
            Throwable logger = this.logger;
            stringBuilder = new StringBuilder();
            str = "Settings response ";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = stringBuilder.toString();
            logger.w(string);
            string = null;
            return string;
        }
    }

    private Map<String, String> getQueryParamsFor(SettingsRequest settingsRequest) {
        boolean empty;
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.buildVersion);
        hashMap.put("display_version", settingsRequest.displayVersion);
        hashMap.put("source", Integer.toString(settingsRequest.source));
        final String obj4 = settingsRequest.instanceId;
        if (!TextUtils.isEmpty(obj4)) {
            hashMap.put("instance", obj4);
        }
        return hashMap;
    }

    protected HttpGetRequest createHttpGetRequest(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics Android SDK/");
        stringBuilder.append(CrashlyticsCore.getVersion());
        return this.requestFactory.buildHttpGetRequest(this.url, map).header("User-Agent", stringBuilder.toString()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    @Override // com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall
    JSONObject handleResponse(HttpResponse httpResponse) {
        int string2;
        boolean requestWasSuccessful;
        String string;
        JSONObject obj5;
        string2 = httpResponse.code();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Settings response code was: ");
        stringBuilder.append(string2);
        this.logger.v(stringBuilder.toString());
        if (requestWasSuccessful(string2)) {
            obj5 = getJsonObjectFrom(httpResponse.body());
        } else {
            requestWasSuccessful = new StringBuilder();
            requestWasSuccessful.append("Settings request failed; (status: ");
            requestWasSuccessful.append(string2);
            requestWasSuccessful.append(") from ");
            requestWasSuccessful.append(this.url);
            this.logger.e(requestWasSuccessful.toString());
            obj5 = 0;
        }
        return obj5;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall
    public JSONObject invoke(SettingsRequest settingsRequest, boolean z2) {
        Logger logger;
        JSONObject obj4;
        String obj5;
        if (z2 == null) {
        } else {
            obj5 = getQueryParamsFor(settingsRequest);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requesting settings from ");
            stringBuilder.append(this.url);
            this.logger.d(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Settings query params were: ");
            stringBuilder2.append(obj5);
            this.logger.v(stringBuilder2.toString());
            obj4 = handleResponse(applyHeadersTo(createHttpGetRequest(obj5), settingsRequest).execute());
            return obj4;
        }
        obj4 = new RuntimeException("An invalid data collection token was used.");
        throw obj4;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall
    boolean requestWasSuccessful(int i) {
        int i2;
        int obj2;
        if (i != 200 && i != 201 && i != 202) {
            if (i != 201) {
                if (i != 202) {
                    if (i == 203) {
                        obj2 = 1;
                    } else {
                        obj2 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }
}
