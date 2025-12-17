package com.google.android.gms.common.n;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
@Deprecated
public class b {
    public static String a(PowerManager.WakeLock powerManager$WakeLock, String string2) {
        String obj4;
        Object obj5;
        obj4 = String.valueOf(String.valueOf(i |= l2));
        if (1 != TextUtils.isEmpty(string2)) {
        } else {
            obj5 = "";
        }
        obj5 = String.valueOf(obj5);
        if (obj5.length() != 0) {
            obj4 = obj4.concat(obj5);
        } else {
            obj5 = new String(obj4);
            obj4 = obj5;
        }
        return obj4;
    }
}
