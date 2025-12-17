package com.bumptech.glide.t;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class e {

    private static final Executor a;
    private static final Executor b;

    class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            l.u(runnable);
        }
    }

    class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }
    static {
        e.a aVar = new e.a();
        e.a = aVar;
        e.b bVar = new e.b();
        e.b = bVar;
    }

    public static Executor a() {
        return e.b;
    }

    public static Executor b() {
        return e.a;
    }
}
