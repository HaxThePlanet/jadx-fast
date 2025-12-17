package androidx.collection.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a6\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0004H\u0080\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0006", d2 = {"synchronized", "T", "Landroidx/collection/internal/Lock;", "block", "Lkotlin/Function0;", "(Landroidx/collection/internal/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LockExtKt {
    public static final <T> T synchronized(androidx.collection.internal.Lock $this$synchronized, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter($this$synchronized, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        final Object obj = $this$synchronized;
        final int i2 = 0;
        return block.invoke();
        synchronized (obj) {
            Intrinsics.checkNotNullParameter($this$synchronized, "<this>");
            Intrinsics.checkNotNullParameter(block, "block");
            i = 0;
            obj = $this$synchronized;
            i2 = 0;
            return block.invoke();
        }
    }
}
