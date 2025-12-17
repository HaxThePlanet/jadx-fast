package kotlin.system;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001\u001a'\u0010\u0005\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0006", d2 = {"measureNanoTime", "", "block", "Lkotlin/Function0;", "", "measureTimeMillis", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TimingKt {
    public static final long measureNanoTime(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        block.invoke();
        return nanoTime2 -= nanoTime;
    }

    public static final long measureTimeMillis(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        block.invoke();
        return currentTimeMillis2 -= currentTimeMillis;
    }
}
