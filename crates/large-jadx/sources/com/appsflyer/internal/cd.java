package com.appsflyer.internal;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class cd extends com.appsflyer.internal.i {

    private final boolean onAppOpenAttributionNative;
    private final boolean onAttributionFailureNative;
    public boolean onResponseErrorNative;
    cd() {
        super(0, 0, 0, 0, 0, 0);
    }

    public cd(String string, String string2, Boolean boolean3, Boolean boolean4, Boolean boolean5, Context context6) {
        int obj1;
        int obj2;
        int obj5;
        if (boolean5 != null) {
            obj5 = boolean5.booleanValue();
        } else {
            obj5 = 0;
        }
        super(string, string2, Boolean.valueOf(obj5), context6);
        if (boolean3 != null) {
            obj2 = boolean3.booleanValue();
        } else {
            obj2 = obj1;
        }
        this.onAttributionFailureNative = obj2;
        if (boolean4 != null) {
            obj1 = boolean4.booleanValue();
        }
        this.onAppOpenAttributionNative = obj1;
    }

    @Override // com.appsflyer.internal.i
    public final boolean AFLogger$LogLevel() {
        return this.onAppOpenAttributionNative;
    }

    @Override // com.appsflyer.internal.i
    public final boolean AFVersionDeclaration() {
        return this.onAttributionFailureNative;
    }

    @Override // com.appsflyer.internal.i
    public final boolean AppsFlyer2dXConversionCallback() {
        return this.onResponseErrorNative;
    }

    @Override // com.appsflyer.internal.i
    public final String getLevel() {
        return n.values(AFKeystoreWrapper()).toString();
    }
}
