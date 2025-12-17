package androidx.room;

/* loaded from: classes.dex */
public final class m implements Runnable {

    public final androidx.room.o0 a;
    public final String b;
    public m(androidx.room.o0 o0, String string2) {
        super();
        this.a = o0;
        this.b = string2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.m(this.b);
    }
}
