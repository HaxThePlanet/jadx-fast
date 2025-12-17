package kotlin.l0;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001\u001a(\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001\u001a(\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001*\u001e\u0008\u0007\u0010\t\"\u00020\u00042\u00020\u0004B\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000cB\u0002\u0008\r¨\u0006\u000e", d2 = {"convertDurationUnit", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "", "convertDurationUnitOverflow", "DurationUnit", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/time/DurationUnitKt")
class d {
    public static final double a(double d, TimeUnit timeUnit2, TimeUnit timeUnit3) {
        n.f(timeUnit3, "sourceUnit");
        n.f(obj9, "targetUnit");
        int i = 1;
        final long convert = obj9.convert(i, obj1);
        if (Long.compare(convert, i2) > 0) {
            return d *= obj8;
        }
        return d /= obj8;
    }

    public static final long b(long l, TimeUnit timeUnit2, TimeUnit timeUnit3) {
        n.f(timeUnit3, "sourceUnit");
        n.f(obj4, "targetUnit");
        return obj4.convert(l, timeUnit2);
    }

    public static final long c(long l, TimeUnit timeUnit2, TimeUnit timeUnit3) {
        n.f(timeUnit3, "sourceUnit");
        n.f(obj4, "targetUnit");
        return obj4.convert(l, timeUnit2);
    }
}
