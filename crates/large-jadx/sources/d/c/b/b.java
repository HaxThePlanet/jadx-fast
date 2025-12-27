package d.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import c.a.a.a.a;
import c.a.a.b;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
public class b {

    private final b a;
    private final ComponentName b;

    static class a extends d {

        final /* synthetic */ Context a;
        a(Context context) {
            this.a = context;
            super();
        }

        @Override // d.c.b.d
        public final void a(ComponentName componentName, b bVar) {
            bVar.d(0L);
            this.a.unbindService(this);
        }

        @Override // d.c.b.d
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    class b extends a.a {

        private Handler a = new Handler();
        final /* synthetic */ a b;
        b(a aVar) {
            super();
            final Handler handler = new Handler(Looper.getMainLooper());
        }

        @Override // c.a.a.a$a
        public void T1(String str, Bundle bundle) {
            if (this.b == null) {
                return;
            }
            this.a.post(new b.b.d(this, str, bundle));
        }

        @Override // c.a.a.a$a
        public void Z1(Bundle bundle) {
            if (this.b == null) {
                return;
            }
            this.a.post(new b.b.c(this, bundle));
        }

        @Override // c.a.a.a$a
        public void c2(int i, Uri uri, boolean z, Bundle bundle) {
            if (this.b == null) {
                return;
            }
            b.b.e eVar = new b.b.e(this, i, uri, z, bundle);
            this.a.post(eVar);
        }

        @Override // c.a.a.a$a
        public void p1(String str, Bundle bundle) {
            if (this.b == null) {
                return;
            }
            this.a.post(new b.b.b(this, str, bundle));
        }

        @Override // c.a.a.a$a
        public void z1(int i, Bundle bundle) {
            if (this.b == null) {
                return;
            }
            this.a.post(new b.b.a(this, i, bundle));
        }
    }
    b(b bVar, ComponentName componentName) {
        super();
        this.a = bVar;
        this.b = componentName;
    }

    public static boolean a(Context context, String str, d dVar) {
        final Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, dVar, 33);
    }

    public static boolean b(Context context, String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
        } catch (java.lang.SecurityException unused) {
            return z;
        }
        return b.a(applicationContext, str, new b.a(applicationContext));
    }

    public e c(a aVar) {
        final d.c.b.b.b bVar = new b.b(this, aVar);
        try {
        } catch (android.os.RemoteException unused) {
            return eVar;
        }
        if (!this.a.i1(bVar)) {
            return null;
        }
    }

    public boolean d(long j) {
        try {
        } catch (android.os.RemoteException unused) {
            j = 0L;
            return j;
        }
        return this.a.y0(j);
    }
}
