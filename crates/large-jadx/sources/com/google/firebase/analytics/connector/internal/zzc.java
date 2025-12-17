package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.b;
import com.google.android.gms.measurement.internal.b6;
import com.google.android.gms.measurement.internal.o7;
import com.google.android.gms.measurement.internal.y5;
import com.google.android.gms.measurement.internal.z5;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzc {

    private static final Set<String> zza;
    private static final List<String> zzb;
    private static final List<String> zzc;
    private static final List<String> zzd;
    private static final List<String> zze;
    private static final List<String> zzf;
    static {
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        zzc.zza = hashSet;
        zzc.zzb = Arrays.asList(/* result */);
        zzc.zzc = Arrays.asList(/* result */);
        zzc.zzd = Arrays.asList(/* result */);
        String[][] strArr4 = new String[2];
        zzc.zze = Arrays.asList((String[])b.a(b6.a, b6.b));
        zzc.zzf = Arrays.asList(/* result */);
    }

    public static Bundle zza(AnalyticsConnector.ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        String str;
        Bundle bundle = new Bundle();
        String origin = conditionalUserProperty.origin;
        if (origin != null) {
            bundle.putString("origin", origin);
        }
        String name = conditionalUserProperty.name;
        if (name != null) {
            bundle.putString("name", name);
        }
        Object value = conditionalUserProperty.value;
        if (value != null) {
            y5.b(bundle, value);
        }
        String triggerEventName = conditionalUserProperty.triggerEventName;
        if (triggerEventName != null) {
            bundle.putString("trigger_event_name", triggerEventName);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.triggerTimeout);
        String timedOutEventName = conditionalUserProperty.timedOutEventName;
        if (timedOutEventName != null) {
            bundle.putString("timed_out_event_name", timedOutEventName);
        }
        Bundle timedOutEventParams = conditionalUserProperty.timedOutEventParams;
        if (timedOutEventParams != null) {
            bundle.putBundle("timed_out_event_params", timedOutEventParams);
        }
        String triggeredEventName = conditionalUserProperty.triggeredEventName;
        if (triggeredEventName != null) {
            bundle.putString("triggered_event_name", triggeredEventName);
        }
        Bundle triggeredEventParams = conditionalUserProperty.triggeredEventParams;
        if (triggeredEventParams != null) {
            bundle.putBundle("triggered_event_params", triggeredEventParams);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.timeToLive);
        String expiredEventName = conditionalUserProperty.expiredEventName;
        if (expiredEventName != null) {
            bundle.putString("expired_event_name", expiredEventName);
        }
        Bundle expiredEventParams = conditionalUserProperty.expiredEventParams;
        if (expiredEventParams != null) {
            bundle.putBundle("expired_event_params", expiredEventParams);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.creationTimestamp);
        String str2 = "active";
        bundle.putBoolean(str2, conditionalUserProperty.active);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.triggeredTimestamp);
        return bundle;
    }

    public static AnalyticsConnector.ConditionalUserProperty zzb(Bundle bundle) {
        Class<Long> obj = Long.class;
        Class<String> obj2 = String.class;
        r.j(bundle);
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        int i = 0;
        Object obj9 = y5.a(bundle, "origin", obj2, i);
        r.j((String)obj9);
        conditionalUserProperty.origin = (String)obj9;
        Object obj10 = y5.a(bundle, "name", obj2, i);
        r.j((String)obj10);
        conditionalUserProperty.name = (String)obj10;
        conditionalUserProperty.value = y5.a(bundle, "value", Object.class, i);
        conditionalUserProperty.triggerEventName = (String)y5.a(bundle, "trigger_event_name", obj2, i);
        Long valueOf = Long.valueOf(0);
        conditionalUserProperty.triggerTimeout = (Long)y5.a(bundle, "trigger_timeout", obj, valueOf).longValue();
        conditionalUserProperty.timedOutEventName = (String)y5.a(bundle, "timed_out_event_name", obj2, i);
        conditionalUserProperty.timedOutEventParams = (Bundle)y5.a(bundle, "timed_out_event_params", Bundle.class, i);
        conditionalUserProperty.triggeredEventName = (String)y5.a(bundle, "triggered_event_name", obj2, i);
        conditionalUserProperty.triggeredEventParams = (Bundle)y5.a(bundle, "triggered_event_params", Bundle.class, i);
        conditionalUserProperty.timeToLive = (Long)y5.a(bundle, "time_to_live", obj, valueOf).longValue();
        conditionalUserProperty.expiredEventName = (String)y5.a(bundle, "expired_event_name", obj2, i);
        conditionalUserProperty.expiredEventParams = (Bundle)y5.a(bundle, "expired_event_params", Bundle.class, i);
        conditionalUserProperty.active = (Boolean)y5.a(bundle, "active", Boolean.class, Boolean.FALSE).booleanValue();
        conditionalUserProperty.creationTimestamp = (Long)y5.a(bundle, "creation_timestamp", obj, valueOf).longValue();
        conditionalUserProperty.triggeredTimestamp = (Long)y5.a(bundle, "triggered_timestamp", obj, valueOf).longValue();
        return conditionalUserProperty;
    }

    public static String zzc(String string) {
        final String str = z5.a(string);
        if (str != null) {
            return str;
        }
        return string;
    }

    public static String zzd(String string) {
        final String str = z5.b(string);
        if (str != null) {
            return str;
        }
        return string;
    }

    public static void zze(String string, String string2, Bundle bundle3) {
        String str;
        boolean obj1;
        if ("clx".equals(string) && "_ae".equals(string2)) {
            if ("_ae".equals(string2)) {
                bundle3.putLong("_r", 1);
            }
        }
    }

    public static boolean zzf(String string) {
        int charCount;
        int charCount2;
        boolean letterOrDigit;
        final int i = 0;
        if (string == null) {
            return i;
        }
        if (string.length() == 0) {
            return i;
        }
        int codePointAt = string.codePointAt(i);
        final int i2 = 95;
        if (!Character.isLetter(codePointAt) && codePointAt == i2) {
            if (codePointAt == i2) {
            }
            return i;
        }
        charCount = Character.charCount(codePointAt);
        while (charCount < string.length()) {
            int codePointAt2 = string.codePointAt(charCount);
            charCount += charCount2;
        }
        return 1;
    }

    public static boolean zzg(String string) {
        int charCount2;
        int charCount;
        int letterOrDigit;
        final int i = 0;
        if (string == null) {
            return i;
        }
        if (string.length() == 0) {
            return i;
        }
        int codePointAt = string.codePointAt(i);
        if (!Character.isLetter(codePointAt)) {
            return i;
        }
        charCount2 = Character.charCount(codePointAt);
        while (charCount2 < string.length()) {
            int codePointAt2 = string.codePointAt(charCount2);
            charCount2 += charCount;
        }
        return 1;
    }

    public static boolean zzh(String string, String string2, Bundle bundle3) {
        boolean key;
        int i;
        boolean obj4;
        String obj5;
        int i2 = 1;
        if (!"_cmp".equals(string2)) {
            return i2;
        }
        final int i3 = 0;
        if (!zzc.zzl(string)) {
            return i3;
        }
        if (bundle3 == null) {
            return i3;
        }
        obj5 = zzc.zzd.iterator();
        for (String next2 : obj5) {
        }
        obj5 = string.hashCode();
        final int i4 = 2;
        if (obj5 != 101200) {
            if (obj5 != 101230) {
                if (obj5 != 3142703) {
                    obj4 = -1;
                } else {
                    if (string.equals("fiam")) {
                        obj4 = i4;
                    } else {
                    }
                }
            } else {
                if (string.equals("fdl")) {
                    obj4 = i2;
                } else {
                }
            }
        } else {
            if (string.equals("fcm")) {
                obj4 = i3;
            } else {
            }
        }
        obj5 = "_cis";
        if (obj4 != null && obj4 != i2 && obj4 != i4) {
            if (obj4 != i2) {
                if (obj4 != i4) {
                    return i3;
                }
                bundle3.putString(obj5, "fiam_integration");
                return i2;
            }
            bundle3.putString(obj5, "fdl_integration");
            return i2;
        }
        bundle3.putString(obj5, "fcm_integration");
        return i2;
    }

    public static boolean zzi(AnalyticsConnector.ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        Object value;
        String expiredEventName;
        String triggeredEventName;
        String timedOutEventName;
        boolean empty;
        Bundle triggeredEventParams;
        Object obj4;
        final int i = 0;
        if (conditionalUserProperty == null) {
            return i;
        }
        final String origin = conditionalUserProperty.origin;
        if (origin != null) {
            if (origin.isEmpty()) {
            } else {
                value = conditionalUserProperty.value;
                if (value != null && o7.a(value) != null) {
                    if (o7.a(value) != null) {
                    }
                    return i;
                }
                if (!zzc.zzl(origin)) {
                    return i;
                }
                if (!zzc.zzm(origin, conditionalUserProperty.name)) {
                    return i;
                }
                expiredEventName = conditionalUserProperty.expiredEventName;
                if (expiredEventName != null && !zzc.zzj(expiredEventName, conditionalUserProperty.expiredEventParams)) {
                    if (!zzc.zzj(expiredEventName, conditionalUserProperty.expiredEventParams)) {
                        return i;
                    }
                    if (zzc.zzh(origin, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams)) {
                    }
                    return i;
                }
                triggeredEventName = conditionalUserProperty.triggeredEventName;
                if (triggeredEventName != null && !zzc.zzj(triggeredEventName, conditionalUserProperty.triggeredEventParams)) {
                    if (!zzc.zzj(triggeredEventName, conditionalUserProperty.triggeredEventParams)) {
                        return i;
                    }
                    if (zzc.zzh(origin, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams)) {
                    }
                    return i;
                }
                timedOutEventName = conditionalUserProperty.timedOutEventName;
                if (timedOutEventName != null && !zzc.zzj(timedOutEventName, conditionalUserProperty.timedOutEventParams)) {
                    if (!zzc.zzj(timedOutEventName, conditionalUserProperty.timedOutEventParams)) {
                        return i;
                    }
                    if (!zzc.zzh(origin, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams)) {
                        return i;
                    }
                }
            }
            return 1;
        }
        return i;
    }

    public static boolean zzj(String string, Bundle bundle2) {
        boolean next;
        boolean obj2;
        int i = 0;
        if (zzc.zzb.contains(string)) {
            return i;
        }
        if (bundle2 != null) {
            obj2 = zzc.zzd.iterator();
            for (String next2 : obj2) {
            }
        }
        return 1;
    }

    public static boolean zzk(String string) {
        if (!zzc.zza.contains(string)) {
            return 1;
        }
        return 0;
    }

    public static boolean zzl(String string) {
        if (!zzc.zzc.contains(string)) {
            return 1;
        }
        return 0;
    }

    public static boolean zzm(String string, String string2) {
        boolean matches;
        boolean equals;
        boolean obj4;
        boolean obj5;
        final String str4 = "fcm";
        final int i = 1;
        final int i2 = 0;
        if (!"_ce1".equals(string2)) {
            if ("_ce2".equals(string2)) {
            } else {
                if ("_ln".equals(string2) && !string.equals(str4) && string.equals("fiam")) {
                    if (!string.equals(str4)) {
                        if (string.equals("fiam")) {
                        }
                        return i2;
                    }
                    return i;
                }
                if (zzc.zze.contains(string2)) {
                    return i2;
                }
                obj4 = zzc.zzf.iterator();
                for (String next2 : obj4) {
                }
            }
            return i;
        }
        if (!string.equals(str4) && string.equals("frc")) {
            if (string.equals("frc")) {
            }
            return i2;
        }
        return i;
    }
}
