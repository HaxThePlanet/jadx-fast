package com.appsflyer.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class x {

    public final byte[] AFInAppEventParameterName;
    public final String AFInAppEventType;
    public final Map<String, String> AFKeystoreWrapper;
    public int getLevel;
    public final boolean valueOf;
    public final String values;
    public x(String string, String string2) {
        HashMap hashMap = new HashMap();
        super(string, 0, string2, hashMap, 0);
    }

    public x(String string, byte[] b2Arr2, String string3, Map<String, String> map4, boolean z5) {
        super();
        this.getLevel = -1;
        this.values = string;
        this.AFInAppEventParameterName = b2Arr2;
        this.AFInAppEventType = string3;
        this.AFKeystoreWrapper = map4;
        this.valueOf = false;
    }

    static Map<String, String> AFKeystoreWrapper(Context context) {
        String valueOf;
        String obj4;
        HashMap hashMap = new HashMap();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        (WindowManager)context.getSystemService("window").getDefaultDisplay().getMetrics(displayMetrics);
        hashMap.put("x_px", String.valueOf(displayMetrics.widthPixels));
        hashMap.put("y_px", String.valueOf(displayMetrics.heightPixels));
        hashMap.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
        hashMap.put("size", String.valueOf(obj4 &= 15));
        hashMap.put("xdp", String.valueOf(displayMetrics.xdpi));
        hashMap.put("ydp", String.valueOf(displayMetrics.ydpi));
        return hashMap;
    }
}
