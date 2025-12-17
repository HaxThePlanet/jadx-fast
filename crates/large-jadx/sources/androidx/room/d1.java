package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class d1 implements Executor {

    private final Executor a;
    private final ArrayDeque<Runnable> b;
    private Runnable c;

    class a implements Runnable {

        final Runnable a;
        final androidx.room.d1 b;
        a(androidx.room.d1 d1, Runnable runnable2) {
            this.b = d1;
            this.a = runnable2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
                this.b.a();
                this.b.a();
                throw th;
            }
        }
    }
    d1(Executor executor) {
        super();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.b = arrayDeque;
        this.a = executor;
    }

    @Override // java.util.concurrent.Executor
    void a() {
        Executor executor;
        Object poll = this.b.poll();
        this.c = (Runnable)poll;
        synchronized (this) {
            try {
                this.a.execute(poll);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        d1.a aVar = new d1.a(this, runnable);
        this.b.offer(aVar);
        synchronized (this) {
            try {
                a();
                throw runnable;
            }
        }
    }
}
