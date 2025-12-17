package androidx.room;

/* loaded from: classes.dex */
public final class k implements Runnable {

    public final androidx.room.o0 a;
    public k(androidx.room.o0 o0) {
        super();
        this.a = o0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f();
    }
}
