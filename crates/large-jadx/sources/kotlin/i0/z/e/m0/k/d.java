package kotlin.i0.z.e.m0.k;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public class d implements kotlin.i0.z.e.m0.k.k {

    private final Lock b;
    public d(Lock lock) {
        n.f(lock, "lock");
        super();
        this.b = lock;
    }

    public d(Lock lock, int i2, g g3) {
        ReentrantLock obj1;
        if (i2 &= 1 != 0) {
            obj1 = new ReentrantLock();
        }
        super(obj1);
    }

    @Override // kotlin.i0.z.e.m0.k.k
    protected final Lock a() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.k.k
    public void lock() {
        this.b.lock();
    }

    @Override // kotlin.i0.z.e.m0.k.k
    public void unlock() {
        this.b.unlock();
    }
}
