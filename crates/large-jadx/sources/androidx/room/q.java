package androidx.room;

/* loaded from: classes.dex */
public final class q implements Runnable {

    public final androidx.room.o0 a;
    public q(androidx.room.o0 o0) {
        super();
        this.a = o0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
    }
}
