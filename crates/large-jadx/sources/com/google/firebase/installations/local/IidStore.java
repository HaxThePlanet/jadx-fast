package com.google.firebase.installations.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IidStore {

    private static final String[] ALLOWABLE_SCOPES = null;
    private static final String IID_SHARED_PREFS_NAME = "com.google.android.gms.appid";
    private static final String JSON_ENCODED_PREFIX = "{";
    private static final String JSON_TOKEN_KEY = "token";
    private static final String STORE_KEY_ID = "|S|id";
    private static final String STORE_KEY_PUB = "|S||P|";
    private static final String STORE_KEY_SEPARATOR = "|";
    private static final String STORE_KEY_TOKEN = "|T|";
    private final String defaultSenderId;
    private final SharedPreferences iidPrefs;
    static {
        IidStore.ALLOWABLE_SCOPES = /* result */;
    }

    public IidStore(SharedPreferences sharedPreferences, String string2) {
        super();
        this.iidPrefs = sharedPreferences;
        this.defaultSenderId = string2;
    }

    public IidStore(FirebaseApp firebaseApp) {
        super();
        this.iidPrefs = firebaseApp.getApplicationContext().getSharedPreferences("com.google.android.gms.appid", 0);
        this.defaultSenderId = IidStore.getDefaultSenderId(firebaseApp);
    }

    private String createTokenKey(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|T|");
        stringBuilder.append(string);
        stringBuilder.append("|");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static String getDefaultSenderId(FirebaseApp firebaseApp) {
        boolean startsWith;
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String obj3 = firebaseApp.getOptions().getApplicationId();
        if (!obj3.startsWith("1:") && !obj3.startsWith("2:")) {
            if (!obj3.startsWith("2:")) {
                return obj3;
            }
        }
        obj3 = obj3.split(":");
        final int i3 = 0;
        if (obj3.length != 4) {
            return i3;
        }
        obj3 = obj3[1];
        if (obj3.isEmpty()) {
            return i3;
        }
        return obj3;
    }

    private static String getIdFromPublicKey(PublicKey publicKey) {
        byte[] obj3 = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
        int i = 0;
        obj3[i] = (byte)i4;
        return Base64.encodeToString(obj3, i, 8, 11);
    }

    private String parseIidTokenFromJson(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject.getString("token");
            string = null;
            return string;
        }
    }

    private PublicKey parseKey(String string) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(string, 8));
        return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    }

    private String readInstanceIdFromLocalStorage() {
        final SharedPreferences iidPrefs = this.iidPrefs;
        return this.iidPrefs.getString("|S|id", 0);
        synchronized (iidPrefs) {
            iidPrefs = this.iidPrefs;
            return this.iidPrefs.getString("|S|id", 0);
        }
    }

    private String readPublicKeyFromLocalStorageAndCalculateInstanceId() {
        final SharedPreferences iidPrefs = this.iidPrefs;
        final int i = 0;
        String string = this.iidPrefs.getString("|S||P|", i);
        synchronized (iidPrefs) {
            return i;
        }
    }

    public String readIid() {
        final SharedPreferences iidPrefs = this.iidPrefs;
        String instanceIdFromLocalStorage = readInstanceIdFromLocalStorage();
        synchronized (iidPrefs) {
            return instanceIdFromLocalStorage;
        }
    }

    public String readToken() {
        int i;
        String iidTokenFromJson;
        String tokenKey;
        SharedPreferences iidPrefs;
        final SharedPreferences iidPrefs2 = this.iidPrefs;
        String[] aLLOWABLE_SCOPES = IidStore.ALLOWABLE_SCOPES;
        i = 0;
        synchronized (iidPrefs2) {
            int i2 = 0;
            while (i < aLLOWABLE_SCOPES.length) {
                iidTokenFromJson = this.iidPrefs.getString(createTokenKey(this.defaultSenderId, aLLOWABLE_SCOPES[i]), i2);
                i++;
                i2 = 0;
            }
            return i2;
        }
    }
}
