package com.facebook.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import com.facebook.a;
import com.facebook.g;
import com.facebook.internal.c0;
import com.facebook.internal.d;
import com.facebook.internal.d.a;
import com.facebook.internal.d.c;
import com.facebook.internal.f;
import com.facebook.k;
import com.facebook.m;
import com.facebook.o;
import com.facebook.w;
import d.c.b.b;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class p {

    private static final Set<String> j;
    private static final String k;
    private static volatile com.facebook.login.p l;
    private com.facebook.login.k a;
    private com.facebook.login.c b;
    private final SharedPreferences c;
    private String d;
    private String e;
    private boolean f;
    private com.facebook.login.s g;
    private boolean h = false;
    private boolean i = false;

    static class b extends HashSet<String> {
        b() {
            super();
            add("ads_management");
            add("create_event");
            add("rsvp_event");
        }
    }

    private static class e {

        private static com.facebook.login.o a;
        static com.facebook.login.o a(Context context) {
            return p.e.b(context);
        }

        private static com.facebook.login.o b(Context context) {
            com.facebook.login.o oVar;
            String str;
            Context obj3;
            final Class<com.facebook.login.p.e> obj = p.e.class;
            synchronized (obj) {
                if (obj3 == null) {
                    return null;
                }
                if (p.e.a == null) {
                    try {
                        oVar = new o(obj3, o.g());
                        p.e.a = oVar;
                        return p.e.a;
                        throw context;
                    }
                }
            }
        }
    }

    class a implements d.a {

        final m a;
        final com.facebook.login.p b;
        a(com.facebook.login.p p, m m2) {
            this.b = p;
            this.a = m2;
            super();
        }

        @Override // com.facebook.internal.d$a
        public boolean a(int i, Intent intent2) {
            return this.b.m(i, intent2, this.a);
        }
    }

    class c implements d.a {

        final com.facebook.login.p a;
        c(com.facebook.login.p p) {
            this.a = p;
            super();
        }

        @Override // com.facebook.internal.d$a
        public boolean a(int i, Intent intent2) {
            return this.a.l(i, intent2);
        }
    }

    private static class d implements com.facebook.login.w {

        private final Activity a;
        d(Activity activity) {
            super();
            c0.j(activity, "activity");
            this.a = activity;
        }

        @Override // com.facebook.login.w
        public Activity a() {
            return this.a;
        }

        @Override // com.facebook.login.w
        public void startActivityForResult(Intent intent, int i2) {
            this.a.startActivityForResult(intent, i2);
        }
    }
    static {
        p.j = p.f();
        p.k = p.class.toString();
    }

    p() {
        boolean z;
        Object packageName;
        String str;
        super();
        this.a = k.NATIVE_WITH_FALLBACK;
        this.b = c.FRIENDS;
        this.d = "rerequest";
        this.g = s.FACEBOOK;
        c0.l();
        this.c = o.f().getSharedPreferences("com.facebook.loginManager", 0);
        if (o.o && f.a() != null) {
            if (f.a() != null) {
                b bVar = new b();
                b.a(o.f(), "com.android.chrome", bVar);
                b.b(o.f(), o.f().getPackageName());
            }
        }
    }

    static com.facebook.login.r a(com.facebook.login.l.d l$d, a a2, g g3) {
        Set set = d.k();
        HashSet hashSet = new HashSet(a2.k());
        if (d.p()) {
            hashSet.retainAll(set);
        }
        HashSet obj3 = new HashSet(set);
        obj3.removeAll(hashSet);
        r rVar = new r(a2, g3, hashSet, obj3);
        return rVar;
    }

    private void c(a a, g g2, com.facebook.login.l.d l$d3, FacebookException facebookException4, boolean z5, m<com.facebook.login.r> m6) {
        a obj1;
        Object obj2;
        com.facebook.login.l.d obj3;
        if (a != null) {
            a.q(a);
            w.b();
        }
        if (g2 != null) {
            g.b(g2);
        }
        if (m6 != null) {
            if (a != null) {
                obj2 = p.a(d3, a, g2);
            } else {
                obj2 = 0;
            }
            if (!z5) {
                if (obj2 != null && obj2.b().size() == 0) {
                    if (obj2.b().size() == 0) {
                        m6.a();
                    } else {
                        if (facebookException4 != null) {
                            m6.b(facebookException4);
                        } else {
                            if (a != null) {
                                p(true);
                                m6.onSuccess(obj2);
                            }
                        }
                    }
                } else {
                }
            } else {
            }
        }
    }

    public static com.facebook.login.p e() {
        com.facebook.login.p pVar;
        com.facebook.login.p pVar2;
        pVar = p.class;
        if (p.l == null && p.l == null) {
            pVar = p.class;
            synchronized (pVar) {
                pVar2 = new p();
                p.l = pVar2;
            }
        }
        return p.l;
    }

    private static Set<String> f() {
        p.b bVar = new p.b();
        return Collections.unmodifiableSet(bVar);
    }

    static boolean g(String string) {
        boolean startsWith;
        Object obj1;
        if (string != null) {
            if (!string.startsWith("publish") && !string.startsWith("manage")) {
                if (!string.startsWith("manage")) {
                    obj1 = p.j.contains(string) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private void h(Context context, com.facebook.login.l.e.b l$e$b2, Map<String, String> map3, Exception exception4, boolean z5, com.facebook.login.l.d l$d6) {
        String str2;
        HashMap hashMap;
        com.facebook.login.l.e.b bVar;
        Map map;
        Exception exc;
        String str;
        String obj8;
        String obj9;
        boolean obj12;
        final com.facebook.login.o oVar = p.e.a(context);
        if (oVar == null) {
        }
        if (d6 == null) {
            oVar.i("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
        } else {
            hashMap = new HashMap();
            obj12 = z5 ? "1" : "0";
            hashMap.put("try_login_activity", obj12);
            if (d6.n()) {
                obj8 = "foa_mobile_login_complete";
            }
            oVar.f(d6.b(), hashMap, b2, map3, exception4, obj8);
        }
    }

    private void k(Context context, com.facebook.login.l.d l$d2) {
        String str;
        final com.facebook.login.o obj2 = p.e.a(context);
        if (obj2 != null && d2 != null) {
            if (d2 != null) {
                str = d2.n() ? "foa_mobile_login_start" : "fb_mobile_login_start";
                obj2.h(d2, str);
            }
        }
    }

    private boolean o(Intent intent) {
        int i;
        if (o.f().getPackageManager().resolveActivity(intent, 0) != null) {
            i = 1;
        }
        return i;
    }

    private void p(boolean z) {
        SharedPreferences.Editor edit = this.c.edit();
        edit.putBoolean("express_login_allowed", z);
        edit.apply();
    }

    private void q(com.facebook.login.w w, com.facebook.login.l.d l$d2) {
        k(w.a(), d2);
        p.c cVar = new p.c(this);
        d.d(d.c.Login.toRequestCode(), cVar);
        if (!r(w, d2)) {
        } else {
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        this.h(w.a(), l.e.b.ERROR, 0, facebookException, false, d2);
        throw facebookException;
    }

    private boolean r(com.facebook.login.w w, com.facebook.login.l.d l$d2) {
        final Intent obj4 = d(d2);
        if (!o(obj4)) {
            return 0;
        }
        w.startActivityForResult(obj4, l.p());
        return 1;
    }

    private void s(Collection<String> collection) {
        Object next;
        boolean z;
        if (collection == null) {
        }
        Iterator obj4 = collection.iterator();
        for (String next : obj4) {
        }
    }

    protected com.facebook.login.l.d b(com.facebook.login.m m) {
        HashSet hashSet;
        Set set;
        if (m.b() != null) {
            hashSet = new HashSet(m.b());
        } else {
            hashSet = new HashSet();
        }
        super(this.a, Collections.unmodifiableSet(hashSet), this.b, this.d, o.g(), UUID.randomUUID().toString(), this.g, m.a());
        dVar2.t(a.o());
        dVar2.r(this.e);
        dVar2.u(this.f);
        dVar2.q(this.h);
        dVar2.v(this.i);
        return dVar2;
    }

    protected Intent d(com.facebook.login.l.d l$d) {
        Intent intent = new Intent();
        intent.setClass(o.f(), FacebookActivity.class);
        intent.setAction(d.g().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", d);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    public void i(Activity activity, com.facebook.login.m m2) {
        boolean z;
        String str;
        if (activity instanceof d) {
            Log.w(p.k, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        p.d dVar = new p.d(activity);
        q(dVar, b(m2));
    }

    public void j(Activity activity, Collection<String> collection2) {
        s(collection2);
        m mVar = new m(collection2);
        i(activity, mVar);
    }

    boolean l(int i, Intent intent2) {
        return m(i, intent2, 0);
    }

    boolean m(int i, Intent intent2, m<com.facebook.login.r> m3) {
        int i3;
        int i10;
        int i2;
        com.facebook.login.l.e.b eRROR;
        int i9;
        int facebookException;
        int str;
        int i4;
        int i5;
        com.facebook.login.l.e.b bVar;
        int i6;
        int i8;
        int i7;
        int i11 = i;
        Object obj = intent2;
        final int i12 = 1;
        facebookException = 0;
        str = 0;
        if (obj != null) {
            obj.setExtrasClassLoader(l.e.class.getClassLoader());
            android.os.Parcelable parcelableExtra = obj.getParcelableExtra("com.facebook.LoginFragment:Result");
            if ((l.e)parcelableExtra != null) {
                com.facebook.login.l.e.b bVar2 = parcelableExtra.a;
                if (i11 == -1) {
                    if (bVar2 == l.e.b.SUCCESS) {
                        i3 = parcelableExtra.b;
                        i5 = parcelableExtra.c;
                    } else {
                        FacebookAuthorizationException facebookAuthorizationException = new FacebookAuthorizationException(parcelableExtra.v);
                        facebookException = facebookAuthorizationException;
                        i3 = i5;
                    }
                } else {
                    if (i11 == 0) {
                        str = i12;
                    }
                    i5 = i3;
                }
                i10 = parcelableExtra.y;
                str = dVar;
                eRROR = bVar2;
                i4 = i7;
            } else {
                i4 = str;
                str = i5;
            }
            i6 = i10;
            i8 = i4;
            i2 = i5;
            bVar = eRROR;
            i9 = str;
        } else {
            if (i11 == 0) {
                bVar = cANCEL;
                i8 = i12;
                i6 = i9;
            } else {
                bVar = eRROR;
                i6 = i9;
                i8 = str;
            }
        }
        if (facebookException == null && i3 == 0 && i8 == 0) {
            if (i3 == 0) {
                if (i8 == 0) {
                    facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
                }
            }
        }
        final int i20 = facebookException;
        final int i19 = i9;
        this.h(0, bVar, i6, i20, true, i19);
        this.c(i3, i2, i19, i20, i8, m3);
        return i12;
    }

    public void n(k k, m<com.facebook.login.r> m2) {
        if (!k instanceof d) {
        } else {
            p.a aVar = new p.a(this, m2);
            (d)k.c(d.c.Login.toRequestCode(), aVar);
        }
        FacebookException obj3 = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        throw obj3;
    }
}
