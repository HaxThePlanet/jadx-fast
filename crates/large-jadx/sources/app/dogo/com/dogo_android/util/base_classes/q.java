package app.dogo.com.dogo_android.util.e0;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.os.Build.VERSION;
import androidx.core.app.j.e;

/* compiled from: BaseTaskService.java */
/* loaded from: classes.dex */
public abstract class q extends Service {

    private int a = 0;
    public q() {
        super();
    }

    private synchronized void a(int i) {
        this.a += i;
        if (this.a <= 0) {
            stopSelf();
        }
    }

    private void b() {
        int i = 26;
        if (Build.VERSION.SDK_INT >= 26) {
            int i2 = 2;
            str = "default";
            str2 = "Default";
            (NotificationManager)getSystemService("notification").createNotificationChannel(new NotificationChannel(str, str2, i2));
        }
    }

    @Override // android.app.Service
    protected void c() {
        (NotificationManager)getSystemService("notification").cancel(0);
    }

    @Override // android.app.Service
    protected void d() {
        b();
        j.e eVar = new j.e(this, "default");
        eVar.y(2131231341);
        eVar.m(getString(2131886080));
        eVar.l(getString(2131886573));
        boolean z = false;
        eVar.u(z);
        eVar.g(true);
        (NotificationManager)getSystemService("notification").notify(z, eVar.c());
    }

    @Override // android.app.Service
    protected void e(String str, long j, long j2) {
        int i;
        final boolean z = false;
        if (j2 > 0) {
            long l = 100L;
            i = (int)(j * l) / j2;
        } else {
            i = z;
        }
        b();
        final j.e eVar = new j.e(this, "default");
        eVar.y(2131231341);
        eVar.m(getString(2131886080));
        eVar.v(-2);
        eVar.l(str);
        eVar.w(100, i, z);
        eVar.u(true);
        eVar.g(z);
        (NotificationManager)getSystemService("notification").notify(z, eVar.c());
    }

    @Override // android.app.Service
    public void f() {
        a(-1);
    }

    @Override // android.app.Service
    public void g() {
        a(1);
    }
}
