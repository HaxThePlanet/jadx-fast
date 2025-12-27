package com.iterable.iterableapi;

/* compiled from: HealthMonitor.java */
/* loaded from: classes2.dex */
public class a implements w0.c {

    private boolean a = false;
    private w0 b;
    public a(w0 w0Var) {
        super();
        this.b = w0Var;
        w0Var.c(this);
    }

    public void a() {
        j0.h("HealthMonitor", "DB Ready notified to healthMonitor");
        this.a = false;
    }

    public void b() {
        j0.c("HealthMonitor", "DB Error notified to healthMonitor");
        this.a = true;
    }

    public boolean c() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Health monitor can process: ";
        int i2 = !this.a;
        str = str2 + i2;
        j0.a("HealthMonitor", str);
        return !this.a;
    }

    public boolean d() {
        boolean z2 = false;
        j0.a("HealthMonitor", "canSchedule");
        int i = 0;
        try {
            long l = this.b.j();
        } catch (java.lang.IllegalStateException ise) {
            Throwable ise2 = ise.getLocalizedMessage();
            j0.c(str, ise2);
            this.a = z3;
            return z;
        }
        if (this.b < 1000) {
            int i2 = 1;
        }
        return z2;
    }
}
