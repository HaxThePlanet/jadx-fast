package kotlin.l0;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008Á\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0005H\u0014J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "()V", "read", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class e extends kotlin.l0.a implements kotlin.l0.g {

    public static final kotlin.l0.e b;
    static {
        e eVar = new e();
        e.b = eVar;
    }

    private e() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.l0.a
    protected long c() {
        return System.nanoTime();
    }

    @Override // kotlin.l0.a
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
