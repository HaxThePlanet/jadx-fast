package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class NotificationParams {

    private final Bundle data;
    public NotificationParams(Bundle bundle) {
        super();
        Objects.requireNonNull(bundle, "data");
        Bundle bundle2 = new Bundle(bundle);
        this.data = bundle2;
    }

    private static int getLightColor(String string) {
        int obj1 = Color.parseColor(string);
        if (obj1 == -16777216) {
        } else {
            return obj1;
        }
        obj1 = new IllegalArgumentException("Transparent color is invalid");
        throw obj1;
    }

    private static boolean isAnalyticsKey(String string) {
        boolean startsWith;
        boolean obj1;
        if (!string.startsWith("google.c.a.") && string.equals("from")) {
            if (string.equals("from")) {
            }
            return 0;
        }
        return 1;
    }

    public static boolean isNotification(Bundle bundle) {
        String keyWithOldPrefix;
        boolean obj3;
        keyWithOldPrefix = "gcm.n.e";
        final String str = "1";
        if (!str.equals(bundle.getString(keyWithOldPrefix)) && str.equals(bundle.getString(NotificationParams.keyWithOldPrefix(keyWithOldPrefix)))) {
            if (str.equals(bundle.getString(NotificationParams.keyWithOldPrefix(keyWithOldPrefix)))) {
            }
            return 0;
        }
        return 1;
    }

    private static boolean isReservedKey(String string) {
        boolean startsWith;
        boolean obj1;
        if (!string.startsWith("google.c.") && !string.startsWith("gcm.n.") && string.startsWith("gcm.notification.")) {
            if (!string.startsWith("gcm.n.")) {
                if (string.startsWith("gcm.notification.")) {
                }
                return 0;
            }
        }
        return 1;
    }

    private static String keyWithOldPrefix(String string) {
        final String str = "gcm.n.";
        if (!string.startsWith(str)) {
            return string;
        }
        return string.replace(str, "gcm.notification.");
    }

    private String normalizePrefix(String string) {
        boolean keyWithOldPrefix;
        boolean key;
        keyWithOldPrefix = NotificationParams.keyWithOldPrefix(string);
        if (!this.data.containsKey(string) && string.startsWith("gcm.n.") && this.data.containsKey(keyWithOldPrefix)) {
            if (string.startsWith("gcm.n.")) {
                keyWithOldPrefix = NotificationParams.keyWithOldPrefix(string);
                if (this.data.containsKey(keyWithOldPrefix)) {
                    return keyWithOldPrefix;
                }
            }
        }
        return string;
    }

    private static String userFriendlyKey(String string) {
        boolean startsWith;
        String obj1;
        if (string.startsWith("gcm.n.")) {
            obj1 = string.substring(6);
        }
        return obj1;
    }

    public boolean getBoolean(String string) {
        String obj2;
        obj2 = getString(string);
        if (!"1".equals(obj2) && Boolean.parseBoolean(obj2)) {
            if (Boolean.parseBoolean(obj2)) {
            }
            return 0;
        }
        return 1;
    }

    public Integer getInteger(String string) {
        String string2;
        boolean empty;
        String length;
        StringBuilder stringBuilder;
        String obj5;
        string2 = getString(string);
        if (!TextUtils.isEmpty(string2)) {
            return Integer.valueOf(Integer.parseInt(string2));
        }
        return null;
    }

    public JSONArray getJSONArray(String string) {
        String string2;
        boolean empty;
        String length;
        StringBuilder stringBuilder;
        String obj5;
        string2 = getString(string);
        if (!TextUtils.isEmpty(string2)) {
            JSONArray jSONArray = new JSONArray(string2);
            return jSONArray;
        }
        return null;
    }

    int[] getLightSettings() {
        String string2;
        String str2;
        String string;
        Throwable stringBuilder;
        String str;
        StringBuilder stringBuilder2;
        int i;
        final String str3 = "NotificationParams";
        final String str4 = ". Skipping setting LightSettings";
        final String str5 = "LightSettings is invalid: ";
        JSONArray jSONArray = getJSONArray("gcm.n.light_settings");
        if (jSONArray == null) {
            return null;
        }
        int i3 = 3;
        int[] iArr = new int[i3];
        if (jSONArray.length() != i3) {
        } else {
            int i4 = 0;
            iArr[i4] = NotificationParams.getLightColor(jSONArray.optString(i4));
            int i5 = 1;
            iArr[i5] = jSONArray.optInt(i5);
            int i6 = 2;
            iArr[i6] = jSONArray.optInt(i6);
            return iArr;
        }
        JSONException jSONException = new JSONException("lightSettings don't have all three fields");
        throw jSONException;
    }

    public Uri getLink() {
        String string;
        if (TextUtils.isEmpty(getString("gcm.n.link_android"))) {
            string = getString("gcm.n.link");
        }
        if (!TextUtils.isEmpty(string)) {
            return Uri.parse(string);
        }
        return null;
    }

    public Object[] getLocalizationArgsForKey(String string) {
        int i;
        String optString;
        JSONArray obj5 = getJSONArray(String.valueOf(string).concat("_loc_args"));
        if (obj5 == null) {
            return null;
        }
        int length = obj5.length();
        final String[] strArr = new String[length];
        i = 0;
        while (i < length) {
            strArr[i] = obj5.optString(i);
            i++;
        }
        return strArr;
    }

    public String getLocalizationResourceForKey(String string) {
        return getString(String.valueOf(string).concat("_loc_key"));
    }

    public String getLocalizedString(Resources resources, String string2, String string3) {
        String localizationResourceForKey = getLocalizationResourceForKey(string3);
        final int i = 0;
        if (TextUtils.isEmpty(localizationResourceForKey)) {
            return i;
        }
        int obj8 = resources.getIdentifier(localizationResourceForKey, "string", string2);
        if (obj8 == null) {
            String obj7 = NotificationParams.userFriendlyKey(String.valueOf(string3).concat("_loc_key"));
            StringBuilder stringBuilder = new StringBuilder(obj8 += length);
            stringBuilder.append(obj7);
            stringBuilder.append(" resource not found: ");
            stringBuilder.append(string3);
            stringBuilder.append(" Default value will be used.");
            Log.w("NotificationParams", stringBuilder.toString());
            return i;
        }
        Object[] localizationArgsForKey = getLocalizationArgsForKey(string3);
        if (localizationArgsForKey == null) {
            return resources.getString(obj8);
        }
        return resources.getString(obj8, localizationArgsForKey);
    }

    public Long getLong(String string) {
        String string2;
        boolean empty;
        long length;
        StringBuilder stringBuilder;
        String obj5;
        string2 = getString(string);
        if (!TextUtils.isEmpty(string2)) {
            return Long.valueOf(Long.parseLong(string2));
        }
        return null;
    }

    public String getNotificationChannelId() {
        return getString("gcm.n.android_channel_id");
    }

    Integer getNotificationCount() {
        Integer integer = getInteger("gcm.n.notification_count");
        final int i = 0;
        if (integer == null) {
            return i;
        }
        if (integer.intValue() < 0) {
            String string = integer.toString();
            StringBuilder stringBuilder = new StringBuilder(length += 67);
            stringBuilder.append("notificationCount is invalid: ");
            stringBuilder.append(string);
            stringBuilder.append(". Skipping setting notificationCount.");
            Log.w("FirebaseMessaging", stringBuilder.toString());
            return i;
        }
        return integer;
    }

    Integer getNotificationPriority() {
        int intValue;
        int i;
        Integer integer = getInteger("gcm.n.notification_priority");
        final int i2 = 0;
        if (integer == null) {
            return i2;
        }
        if (integer.intValue() >= -2 && integer.intValue() > 2) {
            if (integer.intValue() > 2) {
            }
            return integer;
        }
        String string = integer.toString();
        StringBuilder stringBuilder = new StringBuilder(length += 72);
        stringBuilder.append("notificationPriority is invalid ");
        stringBuilder.append(string);
        stringBuilder.append(". Skipping setting notificationPriority.");
        Log.w("FirebaseMessaging", stringBuilder.toString());
        return i2;
    }

    public String getPossiblyLocalizedString(Resources resources, String string2, String string3) {
        final String string = getString(string3);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return getLocalizedString(resources, string2, string3);
    }

    public String getSoundResourceName() {
        String string;
        if (TextUtils.isEmpty(getString("gcm.n.sound2"))) {
            string = getString("gcm.n.sound");
        }
        return string;
    }

    public String getString(String string) {
        return this.data.getString(normalizePrefix(string));
    }

    public long[] getVibrateTimings() {
        int i;
        long optLong;
        JSONArray jSONArray = getJSONArray("gcm.n.vibrate_timings");
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
        } else {
            int length2 = jSONArray.length();
            long[] lArr = new long[length2];
            i = 0;
            while (i < length2) {
                lArr[i] = jSONArray.optLong(i);
                i++;
            }
            return lArr;
        }
        JSONException jSONException = new JSONException("vibrateTimings have invalid length");
        throw jSONException;
    }

    Integer getVisibility() {
        int intValue;
        int i;
        Integer integer = getInteger("gcm.n.visibility");
        final int i2 = 0;
        if (integer == null) {
            return i2;
        }
        if (integer.intValue() >= -1 && integer.intValue() > 1) {
            if (integer.intValue() > 1) {
            }
            return integer;
        }
        String string = integer.toString();
        StringBuilder stringBuilder = new StringBuilder(length += 53);
        stringBuilder.append("visibility is invalid: ");
        stringBuilder.append(string);
        stringBuilder.append(". Skipping setting visibility.");
        Log.w("NotificationParams", stringBuilder.toString());
        return i2;
    }

    public boolean hasImage() {
        if (!TextUtils.isEmpty(getString("gcm.n.image"))) {
            return 1;
        }
        return 0;
    }

    public boolean isNotification() {
        return getBoolean("gcm.n.e");
    }

    public Bundle paramsForAnalyticsIntent() {
        Object next;
        boolean analyticsKey;
        Bundle bundle = new Bundle(this.data);
        Iterator iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!NotificationParams.isAnalyticsKey((String)next)) {
            }
            bundle.remove(next);
        }
        return bundle;
    }

    public Bundle paramsWithReservedKeysRemoved() {
        Object next;
        boolean reservedKey;
        Bundle bundle = new Bundle(this.data);
        Iterator iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (NotificationParams.isReservedKey((String)next)) {
            }
            bundle.remove(next);
        }
        return bundle;
    }
}
