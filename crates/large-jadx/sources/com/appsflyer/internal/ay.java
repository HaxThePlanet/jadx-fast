package com.appsflyer.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appsflyer.AFLogger;

/* loaded from: classes.dex */
public final class ay implements com.appsflyer.internal.bp {

    private final SharedPreferences values;
    public ay(SharedPreferences sharedPreferences) {
        super();
        this.values = sharedPreferences;
    }

    @Override // com.appsflyer.internal.bp
    public final void AFInAppEventType(String string, String string2) {
        this.values.edit().putString(string, string2).apply();
    }

    @Override // com.appsflyer.internal.bp
    public final boolean AFInAppEventType(String string) {
        return this.values.getBoolean(string, false);
    }

    @Override // com.appsflyer.internal.bp
    public final String AFKeystoreWrapper(String string) {
        return this.values.getString(string, 0);
    }

    @Override // com.appsflyer.internal.bp
    public final void AFKeystoreWrapper(String string, long l2) {
        this.values.edit().putLong(string, l2).apply();
    }

    @Override // com.appsflyer.internal.bp
    public final long valueOf(String string) {
        return this.values.getLong(string, 0);
    }

    @Override // com.appsflyer.internal.bp
    public final void values(String string) {
        this.values.edit().putBoolean(string, true).apply();
    }
}
