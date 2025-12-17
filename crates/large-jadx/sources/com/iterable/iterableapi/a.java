package com.iterable.iterableapi;

/* loaded from: classes2.dex */
public class a implements com.iterable.iterableapi.w0.c {

    private boolean a = false;
    private com.iterable.iterableapi.w0 b;
    public a(com.iterable.iterableapi.w0 w0) {
        super();
        final int i = 0;
        this.b = w0;
        w0.c(this);
    }

    @Override // com.iterable.iterableapi.w0$c
    public void a() {
        j0.h("HealthMonitor", "DB Ready notified to healthMonitor");
        this.a = false;
    }

    @Override // com.iterable.iterableapi.w0$c
    public void b() {
        j0.c("HealthMonitor", "DB Error notified to healthMonitor");
        this.a = true;
    }

    @Override // com.iterable.iterableapi.w0$c
    public boolean c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Health monitor can process: ");
        stringBuilder.append(z2 ^= 1);
        j0.a("HealthMonitor", stringBuilder.toString());
        return z ^= 1;
    }

    @Override // com.iterable.iterableapi.w0$c
    public boolean d() {
        int i;
        j0.a("HealthMonitor", "canSchedule");
        i = 0;
        if (Long.compare(l, i3) < 0) {
            i = i2;
        }
        return i;
    }
}
