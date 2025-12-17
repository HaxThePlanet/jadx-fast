package androidx.collection.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\u0004\u0008\u0000\u0010\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0006H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0008", d2 = {"Landroidx/collection/internal/Lock;", "", "()V", "synchronizedImpl", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Lock {
    public final <T> T synchronizedImpl(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        return block.invoke();
        synchronized (this) {
            Intrinsics.checkNotNullParameter(block, "block");
            i = 0;
            return block.invoke();
        }
    }
}
