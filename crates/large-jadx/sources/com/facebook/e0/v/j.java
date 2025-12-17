package com.facebook.e0.v;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.o;
import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0019\u0008\u0002\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\n\u001a\u00020\u0003H\u0016J\u0006\u0010\u000b\u001a\u00020\u000cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\t¨\u0006\u000f", d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo;", "", "callingApplicationPackage", "", "isOpenedByAppLink", "", "(Ljava/lang/String;Z)V", "getCallingApplicationPackage", "()Ljava/lang/String;", "()Z", "toString", "writeSourceApplicationInfoToDisk", "", "Companion", "Factory", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class j {

    public static final com.facebook.e0.v.j.a c;
    private final String a;
    private final boolean b;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo$Companion;", "", "()V", "CALL_APPLICATION_PACKAGE_KEY", "", "OPENED_BY_APP_LINK_KEY", "SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT", "clearSavedSourceApplicationInfoFromDisk", "", "getStoredSourceApplicatioInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final void a() {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
            edit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
            edit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
            edit.apply();
        }

        public final com.facebook.e0.v.j b() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(o.f());
            String str = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
            final int i2 = 0;
            if (!defaultSharedPreferences.contains(str)) {
                return i2;
            }
            j jVar = new j(defaultSharedPreferences.getString(str, i2), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false), i2);
            return jVar;
        }
    }
    static {
        j.a aVar = new j.a(0);
        j.c = aVar;
    }

    private j(String string, boolean z2) {
        super();
        this.a = string;
        this.b = z2;
    }

    public j(String string, boolean z2, g g3) {
        super(string, z2);
    }

    public final void a() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
        edit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.a);
        edit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.b);
        edit.apply();
    }

    public String toString() {
        String string;
        Object stringBuilder;
        string = this.b ? "Applink" : "Unclassified";
        if (this.a != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append('(');
            stringBuilder.append(this.a);
            stringBuilder.append(')');
            string = stringBuilder.toString();
        }
        return string;
    }
}
