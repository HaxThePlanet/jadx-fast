package i.b.o0;

import i.b.j0.b;
import i.b.m0.j.s;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: BaseTestConsumer.java */
/* loaded from: classes3.dex */
public abstract class a<T, U extends a<T, U>> implements b {

    protected final CountDownLatch a = new CountDownLatch(1);
    protected final List<T> b = new s<>();
    protected final List<Throwable> c = new s<>();
    protected long v;
    protected boolean w;
    protected int x;
    protected int y;
    public a() {
        super();
        s sVar = new s();
        s sVar2 = new s();
        CountDownLatch countDownLatch = new CountDownLatch(1);
    }
}
