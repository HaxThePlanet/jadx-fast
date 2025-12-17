package app.dogo.com.dogo_android.util.e0;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.os.Build.VERSION;
import androidx.core.app.j.e;

/* loaded from: classes.dex */
public abstract class q extends Service {

    private int a = 0;
    public q() {
        super();
        final int i = 0;
    }

    private void a(int i) {
        i2 += i;
        this.a = i3;
        synchronized (this) {
            try {
                stopSelf();
                throw i;
            }
        }
    }

    private void b() {
        int systemService;
        int notificationChannel;
        int i;
        String str2;
        String str;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationChannel = new NotificationChannel("default", "Default", 2);
            (NotificationManager)getSystemService("notification").createNotificationChannel(notificationChannel);
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
        int i4 = 0;
        eVar.u(i4);
        eVar.g(true);
        (NotificationManager)getSystemService("notification").notify(i4, eVar.c());
    }

    @Override // android.app.Service
    protected void e(String string, long l2, long l3) {
        int i;
        int obj6;
        final int i3 = 0;
        if (Long.compare(obj8, i2) > 0) {
            obj6 = (int)obj6;
        } else {
            obj6 = i3;
        }
        b();
        j.e obj7 = new j.e(this, "default");
        obj7.y(2131231341);
        obj7.m(getString(2131886080));
        obj7.v(-2);
        obj7.l(string);
        obj7.w(100, obj6, i3);
        obj7.u(true);
        obj7.g(i3);
        (NotificationManager)getSystemService("notification").notify(i3, obj7.c());
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
