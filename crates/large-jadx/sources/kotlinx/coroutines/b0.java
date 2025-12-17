package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0000\u0008\u0010\u0018\u00002\u00020\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0002\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0008¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 5, 1}, xi = 48)
public class b0 {

    private static final AtomicIntegerFieldUpdater b;
    private volatile int _handled;
    public final Throwable a;
    static {
        b0.b = AtomicIntegerFieldUpdater.newUpdater(b0.class, "_handled");
    }

    public b0(Throwable throwable, boolean z2) {
        super();
        this.a = throwable;
        this._handled = z2;
    }

    public b0(Throwable throwable, boolean z2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(throwable, obj2);
    }

    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return b0.b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r0.a(this));
        stringBuilder.append('[');
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
