package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import d.q.a.a;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u0017\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001c\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0002J\u001a\u0010\u000c\u001a\u00020\u00142\u0008\u0010\t\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0008\u0010\u001f\u001a\u00020\u0014H\u0002J\u0008\u0010 \u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lcom/facebook/AccessTokenManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "accessTokenCache", "Lcom/facebook/AccessTokenCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/AccessTokenCache;)V", "value", "Lcom/facebook/AccessToken;", "currentAccessToken", "getCurrentAccessToken", "()Lcom/facebook/AccessToken;", "setCurrentAccessToken", "(Lcom/facebook/AccessToken;)V", "currentAccessTokenField", "lastAttemptedTokenExtendDate", "Ljava/util/Date;", "tokenRefreshInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentAccessTokenChanged", "", "extendAccessTokenIfNeeded", "loadCurrentAccessToken", "", "refreshCurrentAccessToken", "callback", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "refreshCurrentAccessTokenImpl", "sendCurrentAccessTokenChangedBroadcastIntent", "oldAccessToken", "saveToCache", "setTokenExpirationBroadcastAlarm", "shouldExtendAccessToken", "Companion", "FacebookRefreshTokenInfo", "InstagramRefreshTokenInfo", "RefreshResult", "RefreshTokenInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    private static com.facebook.d f;
    public static final com.facebook.d.a g;
    private com.facebook.a a;
    private final AtomicBoolean b;
    private Date c;
    private final a d;
    private final com.facebook.c e;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0016\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lcom/facebook/AccessTokenManager$Companion;", "", "()V", "ACTION_CURRENT_ACCESS_TOKEN_CHANGED", "", "EXTRA_NEW_ACCESS_TOKEN", "EXTRA_OLD_ACCESS_TOKEN", "ME_PERMISSIONS_GRAPH_PATH", "SHARED_PREFERENCES_NAME", "TAG", "TOKEN_EXTEND_RETRY_SECONDS", "", "TOKEN_EXTEND_THRESHOLD_SECONDS", "instanceField", "Lcom/facebook/AccessTokenManager;", "createExtendAccessTokenRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "callback", "Lcom/facebook/GraphRequest$Callback;", "createGrantedPermissionsRequest", "getInstance", "getRefreshTokenInfoForToken", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final com.facebook.p a(com.facebook.d.a d$a, com.facebook.a a2, com.facebook.p.b p$b3) {
            return a.c(a2, b3);
        }

        public static final com.facebook.p b(com.facebook.d.a d$a, com.facebook.a a2, com.facebook.p.b p$b3) {
            return a.d(a2, b3);
        }

        private final com.facebook.p c(com.facebook.a a, com.facebook.p.b p$b2) {
            com.facebook.d.e eVar = f(a);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", eVar.a());
            bundle.putString("client_id", a.c());
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            final com.facebook.p obj5 = p.t.v(a, eVar.b(), b2);
            obj5.F(bundle);
            obj5.E(t.GET);
            return obj5;
        }

        private final com.facebook.p d(com.facebook.a a, com.facebook.p.b p$b2) {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "permission,status");
            final com.facebook.p obj4 = p.t.v(a, "me/permissions", b2);
            obj4.F(bundle);
            obj4.E(t.GET);
            return obj4;
        }

        private final com.facebook.d.e f(com.facebook.a a) {
            String str;
            String obj3;
            if (a.i() != null) {
            } else {
                obj3 = "facebook";
            }
            if (obj3.hashCode() != 28903346) {
                obj3 = new d.b();
            } else {
                if (obj3.equals("instagram")) {
                    obj3 = new d.c();
                } else {
                }
            }
            return obj3;
        }

        public final com.facebook.d e() {
            com.facebook.d dVar2;
            com.facebook.c cVar;
            com.facebook.d dVar;
            com.facebook.d dVar3 = d.a();
            if (dVar3 == null && d.a() == null) {
                synchronized (this) {
                    a aVar = a.b(o.f());
                    n.e(aVar, "LocalBroadcastManager.ge…tance(applicationContext)");
                    cVar = new c();
                    dVar = new d(aVar, cVar);
                    d.d(dVar);
                    dVar2 = dVar;
                    return dVar2;
                }
            }
            return dVar3;
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013\"\u0004\u0008\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u0006\"\u0004\u0008\u001b\u0010\u0008¨\u0006\u001c", d2 = {"Lcom/facebook/AccessTokenManager$RefreshResult;", "", "()V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "dataAccessExpirationTime", "", "getDataAccessExpirationTime", "()Ljava/lang/Long;", "setDataAccessExpirationTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expiresAt", "", "getExpiresAt", "()I", "setExpiresAt", "(I)V", "expiresIn", "getExpiresIn", "setExpiresIn", "graphDomain", "getGraphDomain", "setGraphDomain", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class d {

        private String a;
        private int b;
        private int c;
        private Long d;
        private String e;
        public final String a() {
            return this.a;
        }

        public final Long b() {
            return this.d;
        }

        public final int c() {
            return this.b;
        }

        public final int d() {
            return this.c;
        }

        public final String e() {
            return this.e;
        }

        public final void f(String string) {
            this.a = string;
        }

        public final void g(Long long) {
            this.d = long;
        }

        public final void h(int i) {
            this.b = i;
        }

        public final void i(int i) {
            this.c = i;
        }

        public final void j(String string) {
            this.e = string;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005¨\u0006\u0008", d2 = {"Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface e {
        public abstract String a();

        public abstract String b();
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class f implements Runnable {

        final com.facebook.d a;
        final com.facebook.a.a b;
        f(com.facebook.d d, com.facebook.a.a a$a2) {
            this.a = d;
            this.b = a2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            d.c(this.a, this.b);
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\t", d2 = {"Lcom/facebook/AccessTokenManager$FacebookRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements com.facebook.d.e {

        private final String a;
        private final String b;
        public b() {
            super();
            this.a = "oauth/access_token";
            this.b = "fb_extend_sso_token";
        }

        @Override // com.facebook.d$e
        public String a() {
            return this.b;
        }

        @Override // com.facebook.d$e
        public String b() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\t", d2 = {"Lcom/facebook/AccessTokenManager$InstagramRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class c implements com.facebook.d.e {

        private final String a;
        private final String b;
        public c() {
            super();
            this.a = "refresh_access_token";
            this.b = "ig_refresh_token";
        }

        @Override // com.facebook.d$e
        public String a() {
            return this.b;
        }

        @Override // com.facebook.d$e
        public String b() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "it", "Lcom/facebook/GraphRequestBatch;", "onBatchCompleted"}, k = 3, mv = {1, 5, 1})
    static final class g implements com.facebook.r.a {

        final com.facebook.d a;
        final com.facebook.d.d b;
        final com.facebook.a c;
        final com.facebook.a.a d;
        final AtomicBoolean e;
        final Set f;
        final Set g;
        final Set h;
        g(com.facebook.d d, com.facebook.d.d d$d2, com.facebook.a a3, com.facebook.a.a a$a4, AtomicBoolean atomicBoolean5, Set set6, Set set7, Set set8) {
            this.a = d;
            this.b = d2;
            this.c = a3;
            this.d = a4;
            this.e = atomicBoolean5;
            this.f = set6;
            this.g = set7;
            this.h = set8;
            super();
        }

        @Override // com.facebook.r$a
        public final void a(com.facebook.r r) {
            String str;
            Set set3;
            Set set;
            Set set2;
            Date date2;
            com.facebook.d dVar;
            Date date;
            int facebookException;
            Object str4;
            String str2;
            com.facebook.a aVar2;
            int aVar;
            int i;
            String str3;
            long time;
            int i2;
            final Object obj = this;
            n.f(r, "it");
            str = obj.b.a();
            str4 = obj.b.b();
            final int i4 = 0;
            final com.facebook.d.a aVar16 = d.g;
            if (aVar16.e().g() != null) {
                com.facebook.a aVar17 = aVar16.e().g();
                if (aVar17 != null) {
                    aVar = aVar17.n();
                } else {
                    aVar = i3;
                }
                if (aVar != obj.c.n()) {
                } else {
                    com.facebook.a.a aVar12 = obj.d;
                    if (!obj.e.get() && str == null && obj.b.c() == 0 && aVar12 != null) {
                        if (str == null) {
                            if (obj.b.c() == 0) {
                                aVar12 = obj.d;
                                if (aVar12 != null) {
                                    facebookException = new FacebookException("Failed to refresh access token");
                                    aVar12.a(facebookException);
                                }
                                d.b(obj.a).set(i4);
                            }
                        }
                    }
                    date = obj.c.h();
                    int i6 = 1000;
                    if (obj.b.c() != 0) {
                        date = new Date(l *= i6, obj12);
                    } else {
                        if (obj.b.d() != 0) {
                            Date date3 = new Date();
                            date = new Date(i7 += time, obj14);
                        }
                    }
                    if (str == null) {
                        str = obj.c.m();
                    }
                    if (obj.e.get()) {
                        set3 = obj.f;
                    } else {
                        set3 = obj.c.k();
                    }
                    if (obj.e.get()) {
                        set = obj.g;
                    } else {
                        set = obj.c.f();
                    }
                    if (obj.e.get()) {
                        set2 = obj.h;
                    } else {
                        set2 = obj.c.g();
                    }
                    Date date5 = new Date();
                    if (str4 != null) {
                        date2 = new Date(longValue *= i6, obj12);
                    } else {
                        date2 = obj.c.e();
                    }
                    if (obj.b.e() == null) {
                        str2 = obj.c.i();
                    }
                    super(str, obj.c.c(), obj.c.n(), set3, set, set2, obj.c.l(), date, date5, date2, str2);
                    aVar16.e().l(aVar15);
                    d.b(obj.a).set(i4);
                    com.facebook.a.a aVar7 = obj.d;
                    if (aVar7 != null) {
                        try {
                            aVar7.b(aVar15);
                            aVar2 = dVar;
                            com.facebook.a.a aVar13 = obj.d;
                            if (aVar13 != null) {
                            }
                            facebookException = new FacebookException("No current access token to refresh");
                            aVar13.a(facebookException);
                            d.b(obj.a).set(i4);
                            dVar = obj1.a;
                            dVar = d.b(dVar);
                            dVar.set(obj6);
                            dVar = obj1.d;
                            if (dVar == null) {
                            } else {
                            }
                            if (aVar2 == null) {
                            } else {
                            }
                            dVar.b(aVar2);
                            throw th;
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class h implements com.facebook.p.b {

        final AtomicBoolean a;
        final Set b;
        final Set c;
        final Set d;
        h(AtomicBoolean atomicBoolean, Set set2, Set set3, Set set4) {
            this.a = atomicBoolean;
            this.b = set2;
            this.c = set3;
            this.d = set4;
            super();
        }

        @Override // com.facebook.p$b
        public final void b(com.facebook.s s) {
            int str;
            int length;
            JSONObject optJSONObject;
            String optString;
            String equals;
            boolean str2;
            Object obj7;
            n.f(s, "response");
            obj7 = s.d();
            obj7 = obj7.optJSONArray("data");
            if (obj7 != null && obj7 != null) {
                obj7 = obj7.optJSONArray("data");
                if (obj7 != null) {
                    this.a.set(true);
                    str = 0;
                    while (str < obj7.length()) {
                        optJSONObject = obj7.optJSONObject(str);
                        optString = optJSONObject.optString("permission");
                        equals = "status";
                        optJSONObject = optJSONObject.optString(equals);
                        if (optJSONObject != null && !b0.W(optString) && !b0.W(optJSONObject)) {
                        }
                        str++;
                        optString = optJSONObject.optString("permission");
                        equals = "status";
                        optJSONObject = optJSONObject.optString(equals);
                        if (!b0.W(optString)) {
                        }
                        if (!b0.W(optJSONObject)) {
                        }
                        n.e(optJSONObject, equals);
                        Locale uS = Locale.US;
                        n.e(uS, "Locale.US");
                        Objects.requireNonNull(optJSONObject, "null cannot be cast to non-null type java.lang.String");
                        String lowerCase = optJSONObject.toLowerCase(uS);
                        n.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        if (lowerCase == null) {
                        } else {
                        }
                        equals = lowerCase.hashCode();
                        if (equals != -1309235419) {
                        } else {
                        }
                        if (lowerCase.equals("expired")) {
                        } else {
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected status: ");
                        stringBuilder.append(lowerCase);
                        Log.w("AccessTokenManager", stringBuilder.toString());
                        this.d.add(optString);
                        if (equals != 280295099) {
                        } else {
                        }
                        if (lowerCase.equals("granted")) {
                        } else {
                        }
                        this.b.add(optString);
                        if (equals != 568196142) {
                        } else {
                        }
                        if (lowerCase.equals("declined")) {
                        } else {
                        }
                        this.c.add(optString);
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class i implements com.facebook.p.b {

        final com.facebook.d.d a;
        i(com.facebook.d.d d$d) {
            this.a = d;
            super();
        }

        @Override // com.facebook.p$b
        public final void b(com.facebook.s s) {
            Object str;
            int i;
            long str2;
            Object obj4;
            n.f(s, "response");
            obj4 = s.d();
            if (obj4 != null) {
                this.a.f(obj4.optString("access_token"));
                this.a.h(obj4.optInt("expires_at"));
                this.a.i(obj4.optInt("expires_in"));
                this.a.g(Long.valueOf(obj4.optLong("data_access_expiration_time")));
                this.a.j(obj4.optString("graph_domain", 0));
            }
        }
    }
    static {
        d.a aVar = new d.a(0);
        d.g = aVar;
    }

    public d(a a, com.facebook.c c2) {
        n.f(a, "localBroadcastManager");
        n.f(c2, "accessTokenCache");
        super();
        this.d = a;
        this.e = c2;
        AtomicBoolean obj3 = new AtomicBoolean(0);
        this.b = obj3;
        obj3 = new Date(0, obj1);
        this.c = obj3;
    }

    public static final com.facebook.d a() {
        return d.f;
    }

    public static final AtomicBoolean b(com.facebook.d d) {
        return d.b;
    }

    public static final void c(com.facebook.d d, com.facebook.a.a a$a2) {
        d.j(a2);
    }

    public static final void d(com.facebook.d d) {
        d.f = d;
    }

    private final void j(com.facebook.a.a a$a) {
        com.facebook.FacebookException facebookException;
        boolean facebookException2;
        String str;
        int str2;
        final com.facebook.a aVar = g();
        if (aVar == null && a != null) {
            if (a != null) {
                facebookException = new FacebookException("No current access token to refresh");
                a.a(facebookException);
            }
        }
        str2 = 0;
        int i2 = 1;
        if (!this.b.compareAndSet(str2, i2) && a != null) {
            if (a != null) {
                facebookException2 = new FacebookException("Refresh already in progress");
                a.a(facebookException2);
            }
        }
        Date date = new Date();
        this.c = date;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        AtomicBoolean atomicBoolean = new AtomicBoolean(str2);
        d.d dVar2 = new d.d();
        com.facebook.p[] arr = new p[2];
        com.facebook.d.a aVar3 = d.g;
        d.h hVar = new d.h(atomicBoolean, hashSet, hashSet2, hashSet3);
        arr[str2] = d.a.b(aVar3, aVar, hVar);
        d.i iVar = new d.i(dVar2);
        arr[i2] = d.a.a(aVar3, aVar, iVar);
        r rVar = new r(arr);
        super(this, dVar2, aVar, a, atomicBoolean, hashSet, hashSet2, hashSet3);
        rVar.g(gVar2);
        rVar.m();
    }

    private final void k(com.facebook.a a, com.facebook.a a2) {
        Intent intent = new Intent(o.f(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", a);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", a2);
        this.d.d(intent);
    }

    private final void m(com.facebook.a a, boolean z2) {
        Object obj6;
        final com.facebook.a aVar = this.a;
        this.a = a;
        this.b.set(false);
        Date date = new Date(0, obj3);
        this.c = date;
        if (z2 != null) {
            if (a != null) {
                this.e.g(a);
            } else {
                this.e.a();
                b0.h(o.f());
            }
        }
        if (!b0.c(aVar, a)) {
            k(aVar, a);
            n();
        }
    }

    private final void n() {
        Object broadcast;
        boolean z;
        Object aVar;
        long time;
        int sDK_INT;
        int i;
        int i2;
        broadcast = o.f();
        com.facebook.a.c cVar = a.H;
        aVar = cVar.e();
        Object systemService = broadcast.getSystemService("alarm");
        if (cVar.g()) {
            if (aVar != null) {
                z = aVar.h();
            } else {
                z = 0;
            }
            if (z != 0) {
                if ((AlarmManager)systemService == null) {
                } else {
                    Intent intent = new Intent(broadcast, CurrentAccessTokenExpirationBroadcastReceiver.class);
                    intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
                    i = 23;
                    i2 = 0;
                    if (Build.VERSION.SDK_INT >= i) {
                        broadcast = PendingIntent.getBroadcast(broadcast, i2, intent, 67108864);
                    } else {
                        broadcast = PendingIntent.getBroadcast(broadcast, i2, intent, i2);
                    }
                    (AlarmManager)systemService.set(1, aVar.h().getTime(), i);
                }
            }
        }
    }

    private final boolean o() {
        com.facebook.a cmp;
        int i;
        long time;
        boolean extendToken;
        long l;
        cmp = g();
        i = 0;
        Date date2 = new Date();
        time = date2.getTime();
        if (cmp != null && cmp.l().canExtendToken() && Long.compare(i3, l) > 0 && Long.compare(time, extendToken) > 0) {
            date2 = new Date();
            time = date2.getTime();
            if (cmp.l().canExtendToken()) {
                if (Long.compare(i3, l) > 0) {
                    if (Long.compare(time, extendToken) > 0) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    public final void e() {
        k(g(), g());
    }

    public final void f() {
        if (!o()) {
        }
        i(0);
    }

    public final com.facebook.a g() {
        return this.a;
    }

    public final boolean h() {
        com.facebook.a aVar = this.e.f();
        final int i2 = 0;
        if (aVar != null) {
            m(aVar, i2);
            return 1;
        }
        return i2;
    }

    public final void i(com.facebook.a.a a$a) {
        boolean handler;
        Object myLooper;
        if (n.b(Looper.getMainLooper(), Looper.myLooper())) {
            j(a);
        } else {
            handler = new Handler(Looper.getMainLooper());
            myLooper = new d.f(this, a);
            handler.post(myLooper);
        }
    }

    public final void l(com.facebook.a a) {
        m(a, true);
    }
}
