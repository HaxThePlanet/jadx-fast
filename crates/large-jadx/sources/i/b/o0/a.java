package i.b.o0;

import i.b.j0.b;
import i.b.m0.j.s;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public abstract class a<T, U extends i.b.o0.a<T, U>>  implements b {

    protected final CountDownLatch a;
    protected final List<T> b;
    protected final List<Throwable> c;
    protected long v;
    protected boolean w;
    protected int x;
    protected int y;
    public a() {
        super();
        s sVar = new s();
        this.b = sVar;
        s sVar2 = new s();
        this.c = sVar2;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.a = countDownLatch;
    }
}
