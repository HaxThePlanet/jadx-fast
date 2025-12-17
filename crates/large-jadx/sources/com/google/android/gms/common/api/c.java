package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.a1;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.i0;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.j.a;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.m0;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.api.internal.y;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.d.a;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.l;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import java.lang.reflect.Method;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* loaded from: classes2.dex */
public abstract class c<O extends com.google.android.gms.common.api.a.d>  {

    protected final g zaa;
    private final Context zab;
    private final String zac;
    private final com.google.android.gms.common.api.a<O> zad;
    private final O zae;
    private final c<O> zaf;
    private final Looper zag;
    private final int zah;
    @NotOnlyInitialized
    private final com.google.android.gms.common.api.d zai;
    private final r zaj;

    public static class a {

        public static final com.google.android.gms.common.api.c.a c;
        public final r a;
        public final Looper b;
        static {
            c.a.a aVar = new c.a.a();
            c.a.c = aVar.a();
        }

        private a(r r, Account account2, Looper looper3) {
            super();
            this.a = r;
            this.b = looper3;
        }

        a(r r, Account account2, Looper looper3, com.google.android.gms.common.api.n n4) {
            super(r, 0, looper3);
        }
    }
    public c(Activity activity, com.google.android.gms.common.api.a<O> a2, O o3, com.google.android.gms.common.api.c.a c$a4) {
        int mainLooper;
        boolean obj7;
        super();
        r.k(activity, "Null activity is not permitted.");
        r.k(a2, "Api must not be null.");
        r.k(a4, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = activity.getApplicationContext();
        this.zab = applicationContext;
        final String str4 = c.zaf(activity);
        this.zac = str4;
        this.zad = a2;
        this.zae = o3;
        this.zag = a4.b;
        final c obj5 = c.a(a2, o3, str4);
        this.zaf = obj5;
        m0 obj6 = new m0(this);
        this.zai = obj6;
        obj6 = g.n(applicationContext);
        this.zaa = obj6;
        this.zah = obj6.o();
        this.zaj = a4.a;
        if (activity instanceof GoogleApiActivity == null && Looper.myLooper() == Looper.getMainLooper()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                y.i(activity, obj6, obj5);
            }
        }
        obj6.p(this);
    }

    @Deprecated
    public c(Activity activity, com.google.android.gms.common.api.a<O> a2, O o3, r r4) {
        c.a.a aVar = new c.a.a();
        aVar.c(r4);
        aVar.b(activity.getMainLooper());
        super(activity, a2, o3, aVar.a());
    }

    @Deprecated
    public c(Context context, com.google.android.gms.common.api.a<O> a2, O o3, Looper looper4, r r5) {
        c.a.a aVar = new c.a.a();
        aVar.b(looper4);
        aVar.c(r5);
        super(context, a2, o3, aVar.a());
    }

    public c(Context context, com.google.android.gms.common.api.a<O> a2, O o3, com.google.android.gms.common.api.c.a c$a4) {
        super();
        r.k(context, "Null context is not permitted.");
        r.k(a2, "Api must not be null.");
        r.k(a4, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.zab = applicationContext;
        String obj3 = c.zaf(context);
        this.zac = obj3;
        this.zad = a2;
        this.zae = o3;
        this.zag = a4.b;
        this.zaf = c.a(a2, o3, obj3);
        obj3 = new m0(this);
        this.zai = obj3;
        obj3 = g.n(applicationContext);
        this.zaa = obj3;
        this.zah = obj3.o();
        this.zaj = a4.a;
        obj3.p(this);
    }

    @Deprecated
    public c(Context context, com.google.android.gms.common.api.a<O> a2, O o3, r r4) {
        c.a.a aVar = new c.a.a();
        aVar.c(r4);
        super(context, a2, o3, aVar.a());
    }

    private final <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e<? extends com.google.android.gms.common.api.i, A>> T zad(int i, T t2) {
        t2.i();
        this.zaa.v(this, i, t2);
        return t2;
    }

    private final <TResult, A extends com.google.android.gms.common.api.a.b> j<TResult> zae(int i, t<A, TResult> t2) {
        k kVar2 = new k();
        this.zaa.w(this, i, t2, kVar2, this.zaj);
        return kVar2.a();
    }

    private static String zaf(Object object) {
        if (l.k()) {
            final int i = 0;
            return (String)Context.class.getMethod("getAttributionTag", new Class[i]).invoke(object, new Object[i]);
        }
        return null;
    }

    public com.google.android.gms.common.api.d asGoogleApiClient() {
        return this.zai;
    }

    protected d.a createClientSettingsBuilder() {
        Object zae;
        int i;
        java.util.Set emptySet;
        boolean z;
        d.a aVar = new d.a();
        zae = this.zae;
        zae = (a.d.b)zae.L0();
        if (zae instanceof a.d.b && zae != null) {
            zae = (a.d.b)zae.L0();
            if (zae != null) {
                i = zae.b1();
            } else {
                com.google.android.gms.common.api.a.d zae2 = this.zae;
                if (zae2 instanceof a.d.a) {
                    i = (a.d.a)zae2.b1();
                } else {
                    i = 0;
                }
            }
        } else {
        }
        aVar.c(i);
        com.google.android.gms.common.api.a.d zae3 = this.zae;
        if (zae3 instanceof a.d.b) {
            GoogleSignInAccount googleSignInAccount = (a.d.b)zae3.L0();
            if (googleSignInAccount == null) {
                emptySet = Collections.emptySet();
            } else {
                emptySet = googleSignInAccount.m2();
            }
        } else {
            emptySet = Collections.emptySet();
        }
        aVar.d(emptySet);
        aVar.e(this.zab.getClass().getName());
        aVar.b(this.zab.getPackageName());
        return aVar;
    }

    protected j<Boolean> disconnectService() {
        return this.zaa.u(this);
    }

    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e<? extends com.google.android.gms.common.api.i, A>> T doBestEffortWrite(T t) {
        zad(2, t);
        return t;
    }

    public <TResult, A extends com.google.android.gms.common.api.a.b> j<TResult> doBestEffortWrite(t<A, TResult> t) {
        return zae(2, t);
    }

    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e<? extends com.google.android.gms.common.api.i, A>> T doRead(T t) {
        zad(0, t);
        return t;
    }

    public <TResult, A extends com.google.android.gms.common.api.a.b> j<TResult> doRead(t<A, TResult> t) {
        return zae(0, t);
    }

    @Deprecated
    public <A extends com.google.android.gms.common.api.a.b, T extends n<A, ?>, U extends v<A, ?>> j<Void> doRegisterEventListener(T t, U u2) {
        r.j(t);
        r.j(u2);
        String str = "Listener has already been released.";
        r.k(t.b(), str);
        r.k(u2.a(), str);
        r.b(p.a(t.b(), u2.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        this.zaa.y(this, t, u2, m.a);
        throw 0;
    }

    public <A extends com.google.android.gms.common.api.a.b> j<Void> doRegisterEventListener(o<A, ?> o) {
        r.j(o);
        String str = "Listener has already been released.";
        r.k(o.a.b(), str);
        r.k(o.b.a(), str);
        this.zaa.y(this, o.a, o.b, o.c);
        throw 0;
    }

    public j<Boolean> doUnregisterEventListener(j.a<?> j$a) {
        return doUnregisterEventListener(a, 0);
    }

    public j<Boolean> doUnregisterEventListener(j.a<?> j$a, int i2) {
        r.k(a, "Listener key cannot be null.");
        return this.zaa.z(this, a, i2);
    }

    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e<? extends com.google.android.gms.common.api.i, A>> T doWrite(T t) {
        zad(1, t);
        return t;
    }

    public <TResult, A extends com.google.android.gms.common.api.a.b> j<TResult> doWrite(t<A, TResult> t) {
        return zae(1, t);
    }

    public final c<O> getApiKey() {
        return this.zaf;
    }

    public O getApiOptions() {
        return this.zae;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    protected String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    protected String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zag;
    }

    public <L> j<L> registerListener(L l, String string2) {
        return k.a(l, this.zag, string2);
    }

    public final com.google.android.gms.common.api.a.f zaa(Looper looper, i0<O> i02) {
        com.google.android.gms.common.api.a.a aVar;
        aVar = this.zad.a();
        r.j(aVar);
        final com.google.android.gms.common.api.a.f obj9 = (a.a)aVar.buildClient(this.zab, looper, createClientSettingsBuilder().a(), this.zae, i02, i02);
        final String obj10 = getContextAttributionTag();
        if (obj10 != null && obj9 instanceof c) {
            if (obj9 instanceof c) {
                (c)obj9.setAttributionTag(obj10);
            }
        }
        if (obj10 != null && obj9 instanceof l) {
            if (obj9 instanceof l) {
                (l)obj9.c(obj10);
            }
        }
        return obj9;
    }

    public final int zab() {
        return this.zah;
    }

    public final a1 zac(Context context, Handler handler2) {
        a1 a1Var = new a1(context, handler2, createClientSettingsBuilder().a());
        return a1Var;
    }
}
