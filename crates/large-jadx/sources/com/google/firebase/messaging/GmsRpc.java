package com.google.firebase.messaging;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.cloudmessaging.d;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
class GmsRpc {

    private final FirebaseApp app;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<HeartBeatInfo> heartbeatInfo;
    private final com.google.firebase.messaging.Metadata metadata;
    private final d rpc;
    private final Provider<UserAgentPublisher> userAgentPublisher;
    GmsRpc(FirebaseApp firebaseApp, com.google.firebase.messaging.Metadata metadata2, d d3, Provider<UserAgentPublisher> provider4, Provider<HeartBeatInfo> provider5, FirebaseInstallationsApi firebaseInstallationsApi6) {
        super();
        this.app = firebaseApp;
        this.metadata = metadata2;
        this.rpc = d3;
        this.userAgentPublisher = provider4;
        this.heartbeatInfo = provider5;
        this.firebaseInstallations = firebaseInstallationsApi6;
    }

    GmsRpc(FirebaseApp firebaseApp, com.google.firebase.messaging.Metadata metadata2, Provider<UserAgentPublisher> provider3, Provider<HeartBeatInfo> provider4, FirebaseInstallationsApi firebaseInstallationsApi5) {
        d dVar = new d(firebaseApp.getApplicationContext());
        super(firebaseApp, metadata2, dVar, provider3, provider4, firebaseInstallationsApi5);
    }

    private static String base64UrlSafe(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private j<String> extractResponseWhenComplete(j<Bundle> j) {
        GmsRpc$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new GmsRpc$$ExternalSyntheticLambda0(this);
        return j.continueWith(GmsRpc$$ExternalSyntheticLambda1.INSTANCE, externalSyntheticLambda0);
    }

    private String getHashedFirebaseAppName() {
        return GmsRpc.base64UrlSafe(MessageDigest.getInstance("SHA-1").digest(this.app.getName().getBytes()));
    }

    private String handleResponse(Bundle bundle) {
        String str = "SERVICE_NOT_AVAILABLE";
        if (bundle == null) {
        } else {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
            } else {
                if (string3 != null) {
                    IOException obj4 = new IOException(string3);
                    throw obj4;
                }
                Throwable throwable = new Throwable();
                Log.w("FirebaseMessaging", "Unexpected response: ".concat(bundle.toString()), throwable);
                obj4 = new IOException(str);
                throw obj4;
            }
            obj4 = new IOException("INSTANCE_ID_RESET");
            throw obj4;
        }
        obj4 = new IOException(str);
        throw obj4;
    }

    static boolean isErrorMessageForRetryableError(String string) {
        boolean equals;
        Object obj1;
        if (!"SERVICE_NOT_AVAILABLE".equals(string) && !"INTERNAL_SERVER_ERROR".equals(string) && "InternalServerError".equals(string)) {
            if (!"INTERNAL_SERVER_ERROR".equals(string)) {
                if ("InternalServerError".equals(string)) {
                }
                return 0;
            }
        }
        return 1;
    }

    private void setDefaultAttributesToBundle(String string, String string2, Bundle bundle3) {
        Object nONE;
        String obj3;
        boolean obj4;
        bundle3.putString("scope", string2);
        bundle3.putString("sender", string);
        bundle3.putString("subtype", string);
        bundle3.putString("gmp_app_id", this.app.getOptions().getApplicationId());
        bundle3.putString("gmsv", Integer.toString(this.metadata.getGmsVersionCode()));
        bundle3.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle3.putString("app_ver", this.metadata.getAppVersionCode());
        bundle3.putString("app_ver_name", this.metadata.getAppVersionName());
        bundle3.putString("firebase-app-name-hash", getHashedFirebaseAppName());
        obj3 = (InstallationTokenResult)m.a(this.firebaseInstallations.getToken(false)).getToken();
        if (!TextUtils.isEmpty(obj3)) {
            bundle3.putString("Goog-Firebase-Installations-Auth", obj3);
        } else {
            Log.w("FirebaseMessaging", "FIS auth token is empty");
        }
        bundle3.putString("appid", (String)m.a(this.firebaseInstallations.getId()));
        bundle3.putString("cliv", "fcm-23.0.0");
        obj3 = this.heartbeatInfo.get();
        obj4 = this.userAgentPublisher.get();
        obj3 = (HeartBeatInfo)obj3.getHeartBeatCode("fire-iid");
        if (obj3 != null && (UserAgentPublisher)obj4 != null && obj3 != HeartBeatInfo.HeartBeat.NONE) {
            if ((UserAgentPublisher)obj4 != null) {
                obj3 = obj3.getHeartBeatCode("fire-iid");
                if (obj3 != HeartBeatInfo.HeartBeat.NONE) {
                    bundle3.putString("Firebase-Client-Log-Type", Integer.toString(obj3.getCode()));
                    bundle3.putString("Firebase-Client", (UserAgentPublisher)obj4.getUserAgent());
                }
            }
        }
    }

    private j<Bundle> startRpc(String string, String string2, Bundle bundle3) {
        try {
            setDefaultAttributesToBundle(string, string2, bundle3);
            return this.rpc.a(bundle3);
        }
        string = m.d(string);
        return string;
    }

    j<?> deleteToken() {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return extractResponseWhenComplete(startRpc(Metadata.getDefaultSenderId(this.app), "*", bundle));
    }

    j<String> getToken() {
        Bundle bundle = new Bundle();
        return extractResponseWhenComplete(startRpc(Metadata.getDefaultSenderId(this.app), "*", bundle));
    }

    String lambda$extractResponseWhenComplete$0$com-google-firebase-messaging-GmsRpc(j j) {
        return handleResponse((Bundle)j.getResult(IOException.class));
    }

    j<?> subscribeToTopic(String string, String string2) {
        String concat;
        String obj6;
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(string2);
        final String str2 = "/topics/";
        if (valueOf.length() != 0) {
            concat = str2.concat(valueOf);
        } else {
            concat = new String(str2);
        }
        bundle.putString("gcm.topic", concat);
        obj6 = String.valueOf(string2);
        if (obj6.length() != 0) {
            obj6 = str2.concat(obj6);
        } else {
            obj6 = new String(str2);
        }
        return extractResponseWhenComplete(startRpc(string, obj6, bundle));
    }

    j<?> unsubscribeFromTopic(String string, String string2) {
        String concat;
        String obj6;
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(string2);
        final String str4 = "/topics/";
        if (valueOf.length() != 0) {
            concat = str4.concat(valueOf);
        } else {
            concat = new String(str4);
        }
        bundle.putString("gcm.topic", concat);
        bundle.putString("delete", "1");
        obj6 = String.valueOf(string2);
        if (obj6.length() != 0) {
            obj6 = str4.concat(obj6);
        } else {
            obj6 = new String(str4);
        }
        return extractResponseWhenComplete(startRpc(string, obj6, bundle));
    }
}
