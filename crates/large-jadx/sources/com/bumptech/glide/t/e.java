package com.bumptech.glide.t;

import java.util.concurrent.Executor;

/* compiled from: Executors.java */
/* loaded from: classes.dex */
public final class e {

    private static final Executor a = new e$a();
    private static final Executor b = new e$b();

    class a implements Executor {
        a() {
            super();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            l.u(runnable);
        }
    }

    class b implements Executor {
        b() {
            super();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return e.b;
    }

    public static Executor b() {
        return e.a;
    }
}
