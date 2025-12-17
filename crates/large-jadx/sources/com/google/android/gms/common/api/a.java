package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.c.c;
import com.google.android.gms.common.internal.c.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.r;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a<O extends com.google.android.gms.common.api.a.d>  {

    private final com.google.android.gms.common.api.a.a<?, O> a;
    private final com.google.android.gms.common.api.a.g<?> b;
    private final String c;

    public interface b {
    }

    public static class c {
    }

    public interface d {

        public static final com.google.android.gms.common.api.a.d.c f;
        static {
            a.d.c cVar = new a.d.c(0);
            a.d.f = cVar;
        }
    }

    public static abstract class e {

        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;
        public List<com.google.android.gms.common.api.Scope> getImpliedScopes(O o) {
            return Collections.emptyList();
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static abstract class a extends com.google.android.gms.common.api.a.e<T, O> {
        @Deprecated
        public T buildClient(Context context, Looper looper2, d d3, O o4, com.google.android.gms.common.api.d.a d$a5, com.google.android.gms.common.api.d.b d$b6) {
            return buildClient(context, looper2, d3, o4, a5, b6);
        }

        public T buildClient(Context context, Looper looper2, d d3, O o4, f f5, m m6) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException("buildClient must be implemented");
            throw obj1;
        }
    }

    public interface f extends com.google.android.gms.common.api.a.b {
        @Override // com.google.android.gms.common.api.a$b
        public abstract void connect(c.c c$c);

        @Override // com.google.android.gms.common.api.a$b
        public abstract void disconnect();

        @Override // com.google.android.gms.common.api.a$b
        public abstract void disconnect(String string);

        public abstract d[] getAvailableFeatures();

        public abstract String getEndpointPackageName();

        public abstract String getLastDisconnectMessage();

        @Override // com.google.android.gms.common.api.a$b
        public abstract int getMinApkVersion();

        public abstract void getRemoteService(k k, Set<com.google.android.gms.common.api.Scope> set2);

        public abstract Set<com.google.android.gms.common.api.Scope> getScopesForConnectionlessNonSignIn();

        @Override // com.google.android.gms.common.api.a$b
        public abstract boolean isConnected();

        @Override // com.google.android.gms.common.api.a$b
        public abstract boolean isConnecting();

        @Override // com.google.android.gms.common.api.a$b
        public abstract void onUserSignOut(c.e c$e);

        @Override // com.google.android.gms.common.api.a$b
        public abstract boolean requiresGooglePlayServices();

        @Override // com.google.android.gms.common.api.a$b
        public abstract boolean requiresSignIn();
    }

    public static final class g extends com.google.android.gms.common.api.a.c<C> {
    }
    public a(String string, com.google.android.gms.common.api.a.a<C, O> a$a2, com.google.android.gms.common.api.a.g<C> a$g3) {
        super();
        r.k(a2, "Cannot construct an Api with a null ClientBuilder");
        r.k(g3, "Cannot construct an Api with a null ClientKey");
        this.c = string;
        this.a = a2;
        this.b = g3;
    }

    public final com.google.android.gms.common.api.a.a<?, O> a() {
        return this.a;
    }

    public final com.google.android.gms.common.api.a.c<?> b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
