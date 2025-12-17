package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
public abstract class i implements Runnable {

    private final o<?> a;
    i() {
        super();
        this.a = 0;
    }

    public i(o<?> o) {
        super();
        this.a = o;
    }

    @Override // java.lang.Runnable
    protected abstract void a();

    final o<?> b() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public final void c(Exception exception) {
        final o oVar = this.a;
        if (oVar != null) {
            oVar.d(exception);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
            c(th);
        }
    }
}
