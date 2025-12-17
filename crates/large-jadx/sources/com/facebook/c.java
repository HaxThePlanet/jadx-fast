package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.internal.g0.i.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\u0008\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\tJ\u0008\u0010\u001a\u001a\u00020\u0016H\u0002R\u0016\u0010\u0008\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u000c\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lcom/facebook/AccessTokenCache;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "tokenCachingStrategyFactory", "Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "(Landroid/content/SharedPreferences;Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;)V", "cachedAccessToken", "Lcom/facebook/AccessToken;", "getCachedAccessToken", "()Lcom/facebook/AccessToken;", "legacyAccessToken", "getLegacyAccessToken", "tokenCachingStrategy", "Lcom/facebook/LegacyTokenHelper;", "getTokenCachingStrategy", "()Lcom/facebook/LegacyTokenHelper;", "tokenCachingStrategyField", "clear", "", "hasCachedAccessToken", "", "load", "save", "accessToken", "shouldCheckLegacyToken", "Companion", "SharedPreferencesTokenCachingStrategyFactory", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private com.facebook.u a;
    private final SharedPreferences b;
    private final com.facebook.c.a c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005", d2 = {"Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "", "()V", "create", "Lcom/facebook/LegacyTokenHelper;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public final com.facebook.u a() {
            final int i = 0;
            u uVar = new u(o.f(), i, 2, i);
            return uVar;
        }
    }
    static {
    }

    public c() {
        SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        n.e(sharedPreferences, "FacebookSdk.getApplicati…ME, Context.MODE_PRIVATE)");
        c.a aVar = new c.a();
        super(sharedPreferences, aVar);
    }

    public c(SharedPreferences sharedPreferences, com.facebook.c.a c$a2) {
        n.f(sharedPreferences, "sharedPreferences");
        n.f(a2, "tokenCachingStrategyFactory");
        super();
        this.b = sharedPreferences;
        this.c = a2;
    }

    private final com.facebook.a b() {
        Object string;
        Object jSONObject;
        int i;
        string = this.b.getString("com.facebook.AccessTokenManager.CachedAccessToken", 0);
        if (string != null) {
            jSONObject = new JSONObject(string);
            i = string;
        }
        return i;
    }

    private final com.facebook.a c() {
        int i;
        boolean z;
        android.os.Bundle bundle = d().c();
        if (bundle != null && u.d.g(bundle)) {
            if (u.d.g(bundle)) {
                i = a.H.c(bundle);
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final com.facebook.u d() {
        Object uVar2;
        com.facebook.u uVar;
        if (a.d(this)) {
            return null;
        }
        if (this.a == null && this.a == null) {
            synchronized (this) {
                this.a = this.c.a();
                uVar2 = w.a;
            }
        }
        com.facebook.u uVar3 = this.a;
        if (uVar3 == null) {
        } else {
            try {
                return uVar3;
                IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
                throw illegalStateException;
                a.b(th, this);
                return obj1;
            } catch (Throwable th) {
            }
        }
    }

    private final boolean e() {
        return this.b.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private final boolean h() {
        return o.z();
    }

    public final void a() {
        boolean z;
        this.b.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (h()) {
            d().a();
        }
    }

    public final com.facebook.a f() {
        com.facebook.a aVar;
        com.facebook.u uVar;
        if (e()) {
            aVar = b();
        } else {
            if (h()) {
                aVar = c();
                if (aVar != null) {
                    g(aVar);
                    d().a();
                }
            } else {
                aVar = 0;
            }
        }
        return aVar;
    }

    public final void g(com.facebook.a a) {
        n.f(a, "accessToken");
        this.b.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", a.r().toString()).apply();
    }
}
