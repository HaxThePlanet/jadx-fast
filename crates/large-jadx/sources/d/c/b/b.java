package d.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import c.a.a.a.a;
import c.a.a.b;

/* loaded from: classes.dex */
public class b {

    private final b a;
    private final ComponentName b;

    static class a extends d.c.b.d {

        final Context a;
        a(Context context) {
            this.a = context;
            super();
        }

        @Override // d.c.b.d
        public final void a(ComponentName componentName, d.c.b.b b2) {
            b2.d(0);
            this.a.unbindService(this);
        }

        @Override // d.c.b.d
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    class b extends a.a {

        private Handler a;
        final d.c.b.a b;
        b(d.c.b.b b, d.c.b.a a2) {
            super();
            Handler obj1 = new Handler(Looper.getMainLooper());
            this.a = obj1;
        }

        @Override // c.a.a.a$a
        public void T1(String string, Bundle bundle2) {
            if (this.b == null) {
            }
            b.b.d dVar = new b.b.d(this, string, bundle2);
            this.a.post(dVar);
        }

        @Override // c.a.a.a$a
        public void Z1(Bundle bundle) {
            if (this.b == null) {
            }
            b.b.c cVar = new b.b.c(this, bundle);
            this.a.post(cVar);
        }

        @Override // c.a.a.a$a
        public void c2(int i, Uri uri2, boolean z3, Bundle bundle4) {
            if (this.b == null) {
            }
            super(this, i, uri2, z3, bundle4);
            this.a.post(eVar2);
        }

        @Override // c.a.a.a$a
        public void p1(String string, Bundle bundle2) {
            if (this.b == null) {
            }
            b.b.b bVar = new b.b.b(this, string, bundle2);
            this.a.post(bVar);
        }

        @Override // c.a.a.a$a
        public void z1(int i, Bundle bundle2) {
            if (this.b == null) {
            }
            b.b.a aVar2 = new b.b.a(this, i, bundle2);
            this.a.post(aVar2);
        }
    }
    b(b b, ComponentName componentName2) {
        super();
        this.a = b;
        this.b = componentName2;
    }

    public static boolean a(Context context, String string2, d.c.b.d d3) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(string2)) {
            intent.setPackage(string2);
        }
        return context.bindService(intent, d3, 33);
    }

    public static boolean b(Context context, String string2) {
        if (string2 == null) {
            return 0;
        }
        Context obj2 = context.getApplicationContext();
        b.a aVar = new b.a(obj2);
        return b.a(obj2, string2, aVar);
    }

    public d.c.b.e c(d.c.b.a a) {
        b.b bVar = new b.b(this, a);
        if (!this.a.i1(bVar)) {
            return null;
        }
        e obj4 = new e(this.a, bVar, this.b);
        return obj4;
    }

    public boolean d(long l) {
        try {
            return this.a.y0(l);
            l = 0L;
            return l;
        }
    }
}
