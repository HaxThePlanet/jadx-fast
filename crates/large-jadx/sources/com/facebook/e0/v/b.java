package com.facebook.e0.v;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0008\u001a\u00020\tH\u0007J\u0008\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\rH\u0007J\u0008\u0010\u000e\u001a\u00020\u0004H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0008\u0010\u0013\u001a\u00020\u0006H\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068CX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007¨\u0006\u0017", d2 = {"Lcom/facebook/appevents/internal/AppEventUtility;", "", "()V", "PRICE_REGEX", "", "isMainThread", "", "()Z", "assertIsMainThread", "", "assertIsNotMainThread", "bytesToHex", "bytes", "", "getAppVersion", "getRootView", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "isEmulator", "normalizePrice", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {
    static {
    }

    public static final void a() {
    }

    public static final void b() {
    }

    public static final String c(byte[] bArr) {
        int i;
        String format;
        String str;
        Object[] arr;
        n.f(bArr, "bytes");
        StringBuffer stringBuffer = new StringBuffer();
        final int i2 = 0;
        i = i2;
        while (i < bArr.length) {
            f0 f0Var = f0.a;
            int i3 = 1;
            arr = new Object[i3];
            arr[i2] = Byte.valueOf(bArr[i]);
            format = String.format("%02x", Arrays.copyOf(arr, i3));
            n.e(format, "java.lang.String.format(format, *args)");
            stringBuffer.append(format);
            i++;
        }
        final String obj7 = stringBuffer.toString();
        n.e(obj7, "sb.toString()");
        return obj7;
    }

    public static final String d() {
        String versionName;
        Context context = o.f();
        n.e(packageInfo.versionName, "packageInfo.versionName");
        return versionName;
    }

    public static final View e(Activity activity) {
        View obj3;
        int i = 0;
        if (a.d(b.class)) {
            return i;
        }
        if (activity == null) {
            return i;
        }
        obj3 = activity.getWindow();
        if (obj3 != null) {
            obj3 = obj3.getDecorView();
            n.e(obj3, "window.decorView");
            return obj3.getRootView();
        }
        return i;
    }

    public static final boolean f() {
        String fINGERPRINT;
        String str;
        int i;
        boolean str2;
        boolean z;
        fINGERPRINT = Build.FINGERPRINT;
        str = "Build.FINGERPRINT";
        n.e(fINGERPRINT, str);
        final String str4 = "generic";
        i = 0;
        final int i2 = 2;
        final int i3 = 0;
        n.e(fINGERPRINT, str);
        fINGERPRINT = Build.MODEL;
        str = "Build.MODEL";
        n.e(fINGERPRINT, str);
        str2 = "google_sdk";
        n.e(fINGERPRINT, str);
        n.e(fINGERPRINT, str);
        String mANUFACTURER = Build.MANUFACTURER;
        n.e(mANUFACTURER, "Build.MANUFACTURER");
        if (!l.M(fINGERPRINT, str4, i, i2, i3) && !l.M(fINGERPRINT, "unknown", i, i2, i3) && !l.R(fINGERPRINT, str2, i, i2, i3) && !l.R(fINGERPRINT, "Emulator", i, i2, i3) && !l.R(fINGERPRINT, "Android SDK built for x86", i, i2, i3) && !l.R(mANUFACTURER, "Genymotion", i, i2, i3)) {
            n.e(fINGERPRINT, str);
            if (!l.M(fINGERPRINT, "unknown", i, i2, i3)) {
                fINGERPRINT = Build.MODEL;
                str = "Build.MODEL";
                n.e(fINGERPRINT, str);
                str2 = "google_sdk";
                if (!l.R(fINGERPRINT, str2, i, i2, i3)) {
                    n.e(fINGERPRINT, str);
                    if (!l.R(fINGERPRINT, "Emulator", i, i2, i3)) {
                        n.e(fINGERPRINT, str);
                        if (!l.R(fINGERPRINT, "Android SDK built for x86", i, i2, i3)) {
                            mANUFACTURER = Build.MANUFACTURER;
                            n.e(mANUFACTURER, "Build.MANUFACTURER");
                            if (!l.R(mANUFACTURER, "Genymotion", i, i2, i3)) {
                                String bRAND = Build.BRAND;
                                n.e(bRAND, "Build.BRAND");
                                if (l.M(bRAND, str4, i, i2, i3)) {
                                    String dEVICE = Build.DEVICE;
                                    n.e(dEVICE, "Build.DEVICE");
                                    if (!l.M(dEVICE, str4, i, i2, i3)) {
                                        if (n.b(str2, Build.PRODUCT)) {
                                            i = 1;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final double g(String string) {
        int doubleValue;
        boolean numberInstance;
        Object obj4;
        doubleValue = 0;
        obj4 = Pattern.compile("[-+]*\\d+([.,]\\d+)*([.,]\\d+)?", 8).matcher(string);
        if (obj4.find()) {
            doubleValue = NumberFormat.getNumberInstance(b0.x()).parse(obj4.group(0)).doubleValue();
        }
        try {
            return doubleValue;
        }
    }
}
