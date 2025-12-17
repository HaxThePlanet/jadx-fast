package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.security.MessageDigest;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ag {

    public final String AFKeystoreWrapper;
    private final boolean valueOf;
    public final String values;
    public ag(String string) {
        super();
        if (string == null) {
        } else {
            JSONObject jSONObject = new JSONObject(string);
            this.values = jSONObject.getString("ver");
            this.valueOf = jSONObject.optBoolean("test_mode");
            this.AFKeystoreWrapper = string;
        }
        JSONException obj3 = new JSONException("Failed to parse remote configuration JSON: originalJson is null");
        throw obj3;
    }

    public static String AFInAppEventParameterName(String string) {
        byte[] digest;
        byte[] bytes;
        String str;
        int i;
        String obj4;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(string.getBytes("UTF-8"));
            obj4 = ag.valueOf(instance.digest());
            str = "Error turning ";
            StringBuilder stringBuilder = new StringBuilder(str);
            str = null;
            string = string.substring(str, 6);
            stringBuilder.append(string);
            string = ".. to MD5";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            AFLogger.AFKeystoreWrapper(string, th);
            string = null;
            return obj4;
        }
    }

    public static String AFKeystoreWrapper(String string, String string2) {
        final String str = "HmacSHA256";
        final Mac instance = Mac.getInstance(str);
        SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), str);
        instance.init(secretKeySpec);
        return ag.values(instance.doFinal(string.getBytes())).toLowerCase();
    }

    public static String valueOf(String string) {
        byte[] digest;
        byte[] bytes;
        String str;
        int i;
        String obj4;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(string.getBytes());
            obj4 = ag.values(instance.digest());
            str = "Error turning ";
            StringBuilder stringBuilder = new StringBuilder(str);
            str = null;
            string = string.substring(str, 6);
            stringBuilder.append(string);
            string = ".. to SHA-256";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            AFLogger.AFKeystoreWrapper(string, th);
            string = null;
            return obj4;
        }
    }

    private static String valueOf(byte[] bArr) {
        int i;
        String str;
        Object[] arr;
        Formatter formatter = new Formatter();
        final int i2 = 0;
        i = i2;
        while (i < bArr.length) {
            arr = new Object[1];
            arr[i2] = Byte.valueOf(bArr[i]);
            formatter.format("%02x", arr);
            i++;
        }
        formatter.close();
        return formatter.toString();
    }

    public static String values(String string) {
        byte[] digest;
        byte[] bytes;
        String str;
        int i;
        String obj4;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.reset();
            instance.update(string.getBytes("UTF-8"));
            obj4 = ag.valueOf(instance.digest());
            str = "Error turning ";
            StringBuilder stringBuilder = new StringBuilder(str);
            str = null;
            string = string.substring(str, 6);
            stringBuilder.append(string);
            string = ".. to SHA1";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            AFLogger.AFKeystoreWrapper(string, th);
            string = null;
            return obj4;
        }
    }

    private static String values(byte[] bArr) {
        int i;
        String substring;
        int i2;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < bArr.length) {
            stringBuilder.append(Integer.toString(i3 += 256, 16).substring(1));
            i++;
        }
        return stringBuilder.toString();
    }

    public final boolean equals(Object object) {
        Class<com.appsflyer.internal.ag> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (ag.class != object.getClass()) {
            } else {
                if (this.valueOf != object.valueOf) {
                    return i;
                }
                if (!this.values.equals(object.values)) {
                    return i;
                }
            }
            return this.AFKeystoreWrapper.equals(object.AFKeystoreWrapper);
        }
        return i;
    }

    public final int hashCode() {
        return i3 += i6;
    }
}
