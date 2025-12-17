package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: classes.dex */
public class a0 implements androidx.lifecycle.q {

    private static final androidx.lifecycle.a0 A;
    private int a = 0;
    private int b = 0;
    private boolean c = true;
    private boolean v = true;
    private Handler w;
    private final androidx.lifecycle.s x;
    private Runnable y;
    androidx.lifecycle.b0.a z;

    class a implements Runnable {

        final androidx.lifecycle.a0 a;
        a(androidx.lifecycle.a0 a0) {
            this.a = a0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.f();
            this.a.g();
        }
    }

    class b implements androidx.lifecycle.b0.a {

        final androidx.lifecycle.a0 a;
        b(androidx.lifecycle.a0 a0) {
            this.a = a0;
            super();
        }

        @Override // androidx.lifecycle.b0$a
        public void a() {
        }

        @Override // androidx.lifecycle.b0$a
        public void b() {
            this.a.b();
        }

        @Override // androidx.lifecycle.b0$a
        public void onStart() {
            this.a.c();
        }
    }

    class c extends androidx.lifecycle.f {

        final androidx.lifecycle.a0 this$0;
        c(androidx.lifecycle.a0 a0) {
            this.this$0 = a0;
            super();
        }

        @Override // androidx.lifecycle.f
        public void onActivityCreated(Activity activity, Bundle bundle2) {
            Object obj2;
            int obj3;
            if (Build.VERSION.SDK_INT < 29) {
                b0.f(activity).h(obj3.z);
            }
        }

        @Override // androidx.lifecycle.f
        public void onActivityPaused(Activity activity) {
            this.this$0.a();
        }

        @Override // androidx.lifecycle.f
        public void onActivityPreCreated(Activity activity, Bundle bundle2) {
            a0.c.a obj2 = new a0.c.a(this);
            activity.registerActivityLifecycleCallbacks(obj2);
        }

        @Override // androidx.lifecycle.f
        public void onActivityStopped(Activity activity) {
            this.this$0.d();
        }
    }
    static {
        a0 a0Var = new a0();
        a0.A = a0Var;
    }

    private a0() {
        super();
        int i = 0;
        int i2 = 1;
        s sVar = new s(this);
        this.x = sVar;
        a0.a aVar = new a0.a(this);
        this.y = aVar;
        a0.b bVar = new a0.b(this);
        this.z = bVar;
    }

    public static androidx.lifecycle.q h() {
        return a0.A;
    }

    static void i(Context context) {
        a0.A.e(context);
    }

    @Override // androidx.lifecycle.q
    void a() {
        int i;
        Runnable runnable;
        int i2;
        i3--;
        this.b = i;
        if (i == 0) {
            this.w.postDelayed(this.y, 700);
        }
    }

    @Override // androidx.lifecycle.q
    void b() {
        int i;
        int oN_RESUME;
        oN_RESUME = 1;
        i2 += oN_RESUME;
        this.b = i;
        if (i == oN_RESUME) {
            if (this.c) {
                this.x.h(j.b.ON_RESUME);
                this.c = false;
            } else {
                this.w.removeCallbacks(this.y);
            }
        }
    }

    @Override // androidx.lifecycle.q
    void c() {
        int i;
        int oN_START;
        oN_START = 1;
        i2 += oN_START;
        this.a = i;
        if (i == oN_START && this.v) {
            if (this.v) {
                this.x.h(j.b.ON_START);
                this.v = false;
            }
        }
    }

    @Override // androidx.lifecycle.q
    void d() {
        this.a = i--;
        g();
    }

    @Override // androidx.lifecycle.q
    void e(Context context) {
        Handler handler = new Handler();
        this.w = handler;
        this.x.h(j.b.ON_CREATE);
        a0.c cVar = new a0.c(this);
        (Application)context.getApplicationContext().registerActivityLifecycleCallbacks(cVar);
    }

    @Override // androidx.lifecycle.q
    void f() {
        int i;
        androidx.lifecycle.j.b oN_PAUSE;
        if (this.b == 0) {
            this.c = true;
            this.x.h(j.b.ON_PAUSE);
        }
    }

    @Override // androidx.lifecycle.q
    void g() {
        int i;
        androidx.lifecycle.j.b oN_STOP;
        if (this.a == 0 && this.c) {
            if (this.c) {
                this.x.h(j.b.ON_STOP);
                this.v = true;
            }
        }
    }

    @Override // androidx.lifecycle.q
    public androidx.lifecycle.j getLifecycle() {
        return this.x;
    }
}
