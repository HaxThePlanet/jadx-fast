package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0008\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lcom/facebook/internal/FeatureManager;", "", "()V", "FEATURE_MANAGER_STORE", "", "featureMapping", "", "Lcom/facebook/internal/FeatureManager$Feature;", "", "checkFeature", "", "feature", "callback", "Lcom/facebook/internal/FeatureManager$Callback;", "defaultStatus", "", "disableFeature", "getFeature", "className", "getGKStatus", "initializeFeatureMapping", "isEnabled", "Callback", "Feature", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class l {

    private static final Map<com.facebook.internal.l.b, String[]> a;
    public static final com.facebook.internal.l b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lcom/facebook/internal/FeatureManager$Callback;", "", "onCompleted", "", "enabled", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract void a(boolean z);
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008 \u0008\u0086\u0001\u0018\u0000 (2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001(B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0008\u001a\u00020\tJ\u0008\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007j\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016j\u0002\u0008\u0017j\u0002\u0008\u0018j\u0002\u0008\u0019j\u0002\u0008\u001aj\u0002\u0008\u001bj\u0002\u0008\u001cj\u0002\u0008\u001dj\u0002\u0008\u001ej\u0002\u0008\u001fj\u0002\u0008 j\u0002\u0008!j\u0002\u0008\"j\u0002\u0008#j\u0002\u0008$j\u0002\u0008%j\u0002\u0008&j\u0002\u0008'¨\u0006)", d2 = {"Lcom/facebook/internal/FeatureManager$Feature;", "", "code", "", "(Ljava/lang/String;II)V", "parent", "getParent", "()Lcom/facebook/internal/FeatureManager$Feature;", "toKey", "", "toString", "Unknown", "Core", "AppEvents", "CodelessEvents", "RestrictiveDataFiltering", "AAM", "PrivacyProtection", "SuggestedEvents", "IntelligentIntegrity", "ModelRequest", "EventDeactivation", "OnDeviceEventProcessing", "OnDevicePostInstallEventProcessing", "IapLogging", "IapLoggingLib2", "Instrument", "CrashReport", "CrashShield", "ThreadCheck", "ErrorReport", "AnrReport", "Monitoring", "ServiceUpdateCompliance", "Login", "ChromeCustomTabsPrefetching", "IgnoreAppSwitchToLoggedOut", "BypassAppSwitch", "Share", "Places", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum b {

        Unknown(-1),
        Core(false),
        AppEvents(-1),
        CodelessEvents(-1),
        RestrictiveDataFiltering(-1),
        AAM(-1),
        PrivacyProtection(-1),
        SuggestedEvents(-1),
        IntelligentIntegrity(-1),
        ModelRequest(-1),
        EventDeactivation(-1),
        OnDeviceEventProcessing(-1),
        OnDevicePostInstallEventProcessing(-1),
        IapLogging(-1),
        IapLoggingLib2(-1),
        Instrument(-1),
        CrashReport(-1),
        CrashShield(-1),
        ThreadCheck(-1),
        ErrorReport(-1),
        AnrReport(-1),
        Monitoring(-1),
        ServiceUpdateCompliance(-1),
        Login(-1),
        ChromeCustomTabsPrefetching(-1),
        IgnoreAppSwitchToLoggedOut(-1),
        BypassAppSwitch(-1),
        Share(-1),
        Places(-1);

        private final int code;
        public static final int access$getCode$p(com.facebook.internal.l.b l$b) {
            return b.code;
        }

        @Override // java.lang.Enum
        public final com.facebook.internal.l.b getParent() {
            com.facebook.internal.l.b bVar;
            com.facebook.internal.l.b.a companion;
            int i;
            int code = this.code;
            if (code & 255 > 0) {
                bVar = l.b.Companion.a(code &= -256);
            } else {
                if (i6 &= code > 0) {
                    bVar = l.b.Companion.a(code &= i);
                } else {
                    if (i8 &= code > 0) {
                        bVar = l.b.Companion.a(code &= i);
                    } else {
                        bVar = l.b.Companion.a(0);
                    }
                }
            }
            return bVar;
        }

        @Override // java.lang.Enum
        public final String toKey() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FBSDKFeature");
            stringBuilder.append(this);
            return stringBuilder.toString();
        }

        @Override // java.lang.Enum
        public String toString() {
            String str;
            switch (i) {
                case 1:
                    str = "CoreKit";
                    break;
                case 2:
                    str = "AppEvents";
                    break;
                case 3:
                    str = "CodelessEvents";
                    break;
                case 4:
                    str = "RestrictiveDataFiltering";
                    break;
                case 5:
                    str = "Instrument";
                    break;
                case 6:
                    str = "CrashReport";
                    break;
                case 7:
                    str = "CrashShield";
                    break;
                case 8:
                    str = "ThreadCheck";
                    break;
                case 9:
                    str = "ErrorReport";
                    break;
                case 10:
                    str = "AnrReport";
                    break;
                case 11:
                    str = "AAM";
                    break;
                case 12:
                    str = "PrivacyProtection";
                    break;
                case 13:
                    str = "SuggestedEvents";
                    break;
                case 14:
                    str = "IntelligentIntegrity";
                    break;
                case 15:
                    str = "ModelRequest";
                    break;
                case 16:
                    str = "EventDeactivation";
                    break;
                case 17:
                    str = "OnDeviceEventProcessing";
                    break;
                case 18:
                    str = "OnDevicePostInstallEventProcessing";
                    break;
                case 19:
                    str = "IAPLogging";
                    break;
                case 20:
                    str = "IAPLoggingLib2";
                    break;
                case 21:
                    str = "Monitoring";
                    break;
                case 22:
                    str = "ServiceUpdateCompliance";
                    break;
                case 23:
                    str = "LoginKit";
                    break;
                case 24:
                    str = "ChromeCustomTabsPrefetching";
                    break;
                case 25:
                    str = "IgnoreAppSwitchToLoggedOut";
                    break;
                case 26:
                    str = "BypassAppSwitch";
                    break;
                case 27:
                    str = "ShareKit";
                    break;
                case 28:
                    str = "PlacesKit";
                    break;
                default:
                    str = "unknown";
            }
            return str;
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"com/facebook/internal/FeatureManager$checkFeature$1", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "onCompleted", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class c implements com.facebook.internal.o.a {

        final com.facebook.internal.l.a a;
        final com.facebook.internal.l.b b;
        c(com.facebook.internal.l.a l$a, com.facebook.internal.l.b l$b2) {
            this.a = a;
            this.b = b2;
            super();
        }

        @Override // com.facebook.internal.o$a
        public void a() {
            this.a.a(l.g(this.b));
        }
    }
    static {
        l lVar = new l();
        l.b = lVar;
        HashMap hashMap = new HashMap();
        l.a = hashMap;
    }

    public static final void a(com.facebook.internal.l.b l$b, com.facebook.internal.l.a l$a2) {
        n.f(b, "feature");
        n.f(a2, "callback");
        l.c cVar = new l.c(a2, b);
        o.j(cVar);
    }

    private final boolean b(com.facebook.internal.l.b l$b) {
        int obj2;
        obj2 = /* condition */ ? 0 : 1;
        return obj2;
    }

    public static final void c(com.facebook.internal.l.b l$b) {
        n.f(b, "feature");
        o.f().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit().putString(b.toKey(), o.u()).apply();
    }

    public static final com.facebook.internal.l.b d(String string) {
        Object value;
        Object key;
        int length;
        int i3;
        int i4;
        boolean z;
        int i;
        int i2;
        n.f(string, "className");
        l.b.f();
        Iterator iterator = l.a.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            value = next2.getValue();
            i3 = 0;
            i4 = i3;
            while (i4 < value.length) {
                i4++;
            }
            i4++;
        }
        return l.b.Unknown;
    }

    private final boolean e(com.facebook.internal.l.b l$b) {
        return o.f(b.toKey(), o.g(), b(b));
    }

    private final void f() {
        final Map map = l.a;
        synchronized (this) {
            try {
                map.put(l.b.AAM, /* result */);
                map.put(l.b.CodelessEvents, /* result */);
                map.put(l.b.ErrorReport, /* result */);
                map.put(l.b.AnrReport, /* result */);
                map.put(l.b.PrivacyProtection, /* result */);
                map.put(l.b.SuggestedEvents, /* result */);
                map.put(l.b.RestrictiveDataFiltering, /* result */);
                map.put(l.b.IntelligentIntegrity, /* result */);
                map.put(l.b.EventDeactivation, /* result */);
                map.put(l.b.OnDeviceEventProcessing, /* result */);
                map.put(l.b.IapLogging, /* result */);
                map.put(l.b.Monitoring, /* result */);
                throw th;
            }
        }
    }

    public static final boolean g(com.facebook.internal.l.b l$b) {
        String string;
        boolean z;
        int i;
        String key;
        Object obj5;
        n.f(b, "feature");
        i = 0;
        if (l.b.Unknown == b) {
            return i;
        }
        final int i2 = 1;
        if (l.b.Core == b) {
            return i2;
        }
        string = o.f().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", i).getString(b.toKey(), 0);
        if (string != null && n.b(string, o.u())) {
            if (n.b(string, o.u())) {
                return i;
            }
        }
        com.facebook.internal.l.b parent = b.getParent();
        if (parent == b) {
            i = l.b.e(b);
        } else {
            if (l.g(parent) && l.b.e(b)) {
                if (l.b.e(b)) {
                    i = i2;
                }
            }
        }
        return i;
    }
}
