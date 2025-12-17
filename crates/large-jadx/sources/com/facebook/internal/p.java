package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONArray;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008#\u0018\u0000 82\u00020\u0001:\u000289BÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u001e\u0010\u000c\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010 R)\u0010\u000c\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r0\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010 R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010 R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010+R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010+R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010+R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u00101R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010+R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010+R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010 ¨\u0006:", d2 = {"Lcom/facebook/internal/FetchedAppSettings;", "", "supportsImplicitLogging", "", "nuxContent", "", "nuxEnabled", "sessionTimeoutInSeconds", "", "smartLoginOptions", "Ljava/util/EnumSet;", "Lcom/facebook/internal/SmartLoginOption;", "dialogConfigurations", "", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "automaticLoggingEnabled", "errorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "smartLoginBookmarkIconURL", "smartLoginMenuIconURL", "iAPAutomaticLoggingEnabled", "codelessEventsEnabled", "eventBindings", "Lorg/json/JSONArray;", "sdkUpdateMessage", "trackUninstallEnabled", "monitorViaDialogEnabled", "rawAamRules", "suggestedEventsSetting", "restrictiveDataSetting", "(ZLjava/lang/String;ZILjava/util/EnumSet;Ljava/util/Map;ZLcom/facebook/internal/FacebookRequestErrorClassification;Ljava/lang/String;Ljava/lang/String;ZZLorg/json/JSONArray;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAutomaticLoggingEnabled", "()Z", "getCodelessEventsEnabled", "getDialogConfigurations", "()Ljava/util/Map;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "getEventBindings", "()Lorg/json/JSONArray;", "getIAPAutomaticLoggingEnabled", "getMonitorViaDialogEnabled", "getNuxContent", "()Ljava/lang/String;", "getNuxEnabled", "getRawAamRules", "getRestrictiveDataSetting", "getSdkUpdateMessage", "getSessionTimeoutInSeconds", "()I", "getSmartLoginBookmarkIconURL", "getSmartLoginMenuIconURL", "getSmartLoginOptions", "()Ljava/util/EnumSet;", "getSuggestedEventsSetting", "getTrackUninstallEnabled", "Companion", "DialogFeatureConfig", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class p {

    private final boolean a;
    private final int b;
    private final EnumSet<com.facebook.internal.a0> c;
    private final Map<String, Map<String, com.facebook.internal.p.a>> d;
    private final boolean e;
    private final com.facebook.internal.h f;
    private final boolean g;
    private final boolean h;
    private final JSONArray i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B+\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0012", d2 = {"Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "", "dialogName", "", "featureName", "fallbackUrl", "Landroid/net/Uri;", "versionSpec", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;[I)V", "getDialogName", "()Ljava/lang/String;", "getFallbackUrl", "()Landroid/net/Uri;", "getFeatureName", "getVersionSpec", "()[I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        public static final com.facebook.internal.p.a.a c;
        private final String a;
        private final String b;
        static {
            p.a.a aVar = new p.a.a(0);
            p.a.c = aVar;
        }

        private a(String string, String string2, Uri uri3, int[] i4Arr4) {
            super();
            this.a = string;
            this.b = string2;
        }

        public a(String string, String string2, Uri uri3, int[] i4Arr4, g g5) {
            super(string, string2, uri3, i4Arr4);
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }
    }
    static {
    }

    public p(boolean z, String string2, boolean z3, int i4, EnumSet<com.facebook.internal.a0> enumSet5, Map<String, ? extends Map<String, com.facebook.internal.p.a>> map6, boolean z7, com.facebook.internal.h h8, String string9, String string10, boolean z11, boolean z12, JSONArray jSONArray13, String string14, boolean z15, boolean z16, String string17, String string18, String string19) {
        final Object obj = this;
        final Object obj2 = string14;
        Object obj3 = string2;
        n.f(string2, "nuxContent");
        n.f(enumSet5, "smartLoginOptions");
        n.f(map6, "dialogConfigurations");
        n.f(h8, "errorClassification");
        n.f(string9, "smartLoginBookmarkIconURL");
        n.f(string10, "smartLoginMenuIconURL");
        n.f(obj2, "sdkUpdateMessage");
        super();
        obj.a = z;
        obj.b = i4;
        obj.c = enumSet5;
        obj.d = map6;
        obj.e = z7;
        obj.f = h8;
        obj.g = z11;
        obj.h = z12;
        obj.i = jSONArray13;
        obj.j = obj2;
        obj.k = string17;
        obj.l = string18;
        obj.m = string19;
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean b() {
        return this.h;
    }

    public final com.facebook.internal.h c() {
        return this.f;
    }

    public final JSONArray d() {
        return this.i;
    }

    public final boolean e() {
        return this.g;
    }

    public final String f() {
        return this.k;
    }

    public final String g() {
        return this.m;
    }

    public final String h() {
        return this.j;
    }

    public final int i() {
        return this.b;
    }

    public final EnumSet<com.facebook.internal.a0> j() {
        return this.c;
    }

    public final String k() {
        return this.l;
    }

    public final boolean l() {
        return this.a;
    }
}
