package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.android.billingclient.api.Purchase;
import com.appsflyer.AFLogger;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class ab {

    public final List<Purchase> AFInAppEventParameterName;
    private final boolean AFInAppEventType;
    public final Map<String, String> AFKeystoreWrapper;
    private final boolean valueOf;
    public ab(boolean z, boolean z2, List<Purchase> list3, Map<String, String> map4) {
        super();
        this.AFInAppEventType = z;
        this.valueOf = z2;
        this.AFInAppEventParameterName = list3;
        this.AFKeystoreWrapper = 0;
    }

    public static String AFInAppEventParameterName(PackageManager packageManager, String string2) {
        Signature[] obj3 = obj3.signatures;
        if (obj3 == null) {
            return null;
        }
        final int i2 = 0;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(obj3[i2].toByteArray());
        MessageDigest obj4 = MessageDigest.getInstance("SHA256");
        obj4.update((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getEncoded());
        obj3 = 1;
        Object[] arr = new Object[obj3];
        BigInteger bigInteger = new BigInteger(obj3, obj4.digest());
        arr[i2] = bigInteger;
        return String.format("%032X", arr);
    }

    public static boolean AFInAppEventParameterName() {
        return Build.BRAND.equals("OPPO");
    }

    public static boolean AFInAppEventParameterName(Context context, String string2) {
        if (string2 == null) {
        } else {
            int obj2 = context.checkPermission(string2, Process.myPid(), Process.myUid());
            StringBuilder stringBuilder = new StringBuilder("is Permission Available: ");
            stringBuilder.append(string2);
            stringBuilder.append("; res: ");
            stringBuilder.append(obj2);
            AFLogger.AFKeystoreWrapper(stringBuilder.toString());
            if (obj2 == null) {
                return 1;
            }
            return 0;
        }
        obj2 = new IllegalArgumentException("permission is null");
        throw obj2;
    }

    public static long AFInAppEventType(Context context, String string2) {
        try {
            PackageInfo obj1 = context.getPackageManager().getPackageInfo(string2, 0);
            if (Build.VERSION.SDK_INT >= 28) {
            }
            return obj1.getLongVersionCode();
            return (long)obj1;
            string2 = context.getMessage();
            AFLogger.AFKeystoreWrapper(string2, context);
            context = null;
            return context;
        }
    }

    public static boolean AFKeystoreWrapper(Context context, Intent intent2) {
        final int i = 0;
        if (context.getPackageManager().queryIntentServices(intent2, i).size() > 0) {
            return 1;
        }
        return i;
    }

    static Map<String, String> valueOf(Context context, Map<String, String> map2, Uri uri3) {
        String str;
        boolean packageManager;
        Object next;
        boolean simpleDateFormat;
        int equals2;
        String str3;
        String str2;
        String firstInstallTime;
        int key;
        int equals;
        int i3;
        int i;
        int i2;
        Object obj12;
        String obj14;
        str = "install_time";
        Iterator iterator = uri3.getQueryParameterNames().iterator();
        str2 = "agency";
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!map2.containsKey(next)) {
            } else {
            }
            str3 = next;
            map2.put(str3, uri3.getQueryParameter((String)next));
            str2 = "agency";
            equals = next.hashCode();
            i = 2;
            i2 = 1;
            if (equals != -1420799080) {
            } else {
            }
            if (next.equals("af_prt")) {
            } else {
            }
            equals2 = key;
            if (equals2 != 0) {
            } else {
            }
            str3 = "campaign";
            if (equals2 != i2) {
            }
            if (equals2 != i) {
            } else {
            }
            str3 = str2;
            equals2 = i;
            if (equals != 99) {
            } else {
            }
            if (next.equals("c")) {
            } else {
            }
            if (equals != 110987) {
            } else {
            }
            if (next.equals("pid")) {
            } else {
            }
            equals2 = i2;
        }
        if (!map2.containsKey(str)) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            obj12 = new Date(obj12.firstInstallTime, key);
            map2.put(str, simpleDateFormat.format(obj12));
        }
        obj12 = "af_status";
        if (map2.containsKey("af_deeplink") && !map2.containsKey(obj12)) {
            obj12 = "af_status";
            if (!map2.containsKey(obj12)) {
                map2.put(obj12, "Non-organic");
            }
        }
        if (map2.containsKey(str2)) {
            map2.remove("media_source");
        }
        obj12 = uri3.getPath();
        if (obj12 != null) {
            map2.put("path", obj12);
        }
        obj12 = uri3.getScheme();
        if (obj12 != null) {
            map2.put("scheme", obj12);
        }
        obj12 = uri3.getHost();
        if (obj12 != null) {
            map2.put("host", obj12);
        }
        return map2;
    }

    public static String values(Context context, String string2) {
        try {
            return obj1.versionName;
            string2 = context.getMessage();
            AFLogger.AFKeystoreWrapper(string2, context);
            context = "";
            return context;
        }
    }

    public final boolean AFInAppEventType() {
        return this.valueOf;
    }

    public final boolean equals(Object object) {
        Class<com.appsflyer.internal.ab> aFKeystoreWrapper;
        Object aFInAppEventParameterName;
        Object obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (ab.class != object.getClass()) {
            } else {
                if (this.AFInAppEventType != object.AFInAppEventType) {
                    return i2;
                }
                if (this.valueOf != object.valueOf) {
                    return i2;
                }
                if (!this.AFInAppEventParameterName.equals(object.AFInAppEventParameterName)) {
                    return i2;
                }
                aFKeystoreWrapper = this.AFKeystoreWrapper;
                obj5 = object.AFKeystoreWrapper;
                if (aFKeystoreWrapper != null) {
                    return aFKeystoreWrapper.equals(obj5);
                }
                if (obj5 == null) {
                    return i;
                }
            }
        }
        return i2;
    }

    public final int hashCode() {
        int i;
        Map aFKeystoreWrapper = this.AFKeystoreWrapper;
        if (aFKeystoreWrapper != null) {
            i = aFKeystoreWrapper.hashCode();
        } else {
            i = 0;
        }
        return i6 += i;
    }

    public final boolean valueOf() {
        return this.AFInAppEventType;
    }
}
