package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
final class b {

    private IntentFilter AFInAppEventParameterName;

    static final class b {

        final float AFInAppEventParameterName;
        final String AFInAppEventType;
        b(float f, String string2) {
            super();
            this.AFInAppEventParameterName = f;
            this.AFInAppEventType = string2;
        }
    }

    static final class d {

        static final com.appsflyer.internal.b valueOf;
        static {
            b bVar = new b();
            b.d.valueOf = bVar;
        }
    }
    b() {
        super();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        this.AFInAppEventParameterName = intentFilter;
    }

    final com.appsflyer.internal.b.b valueOf(Context context) {
        String str;
        int i2;
        int intExtra;
        IntentFilter aFInAppEventParameterName;
        int i4;
        int i3;
        String str2;
        int i;
        Intent obj7;
        i2 = 0;
        obj7 = context.registerReceiver(0, this.AFInAppEventParameterName);
        if (obj7 != null) {
            i4 = -1;
            i3 = 1;
            i = 2;
            if (i == obj7.getIntExtra("status", i4)) {
                try {
                    intExtra = i3;
                    intExtra = 0;
                    if (intExtra != 0) {
                    } else {
                    }
                    intExtra = obj7.getIntExtra("plugged", i4);
                    if (intExtra != i3) {
                    } else {
                    }
                    if (intExtra != i) {
                    } else {
                    }
                    if (intExtra != 4) {
                    } else {
                    }
                    str = "other";
                    str = "wireless";
                    str = "usb";
                    str = "ac";
                    str = "no";
                    aFInAppEventParameterName = obj7.getIntExtra("level", i4);
                    obj7 = obj7.getIntExtra("scale", i4);
                    if (i4 != aFInAppEventParameterName && i4 != obj7) {
                    }
                    if (i4 != obj7) {
                    }
                    i2 = aFInAppEventParameterName;
                    obj7 = new b.b(i2, str);
                    return obj7;
                }
            } else {
            }
        }
    }
}
