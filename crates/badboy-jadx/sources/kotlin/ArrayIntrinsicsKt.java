package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a!\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000b\u0008\u0000\u0010\u0002\u0018\u0001¢\u0006\u0002\u0008\u0003H\u0086\u0008¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"emptyArray", "", "T", "Lkotlin/internal/PureReifiable;", "()[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ArrayIntrinsicsKt {
    public static final <T> T[] emptyArray() {
        final int i = 0;
        final int i2 = 0;
        Intrinsics.reifiedOperationMarker(i2, "T?");
        return new Object[i2];
    }
}
