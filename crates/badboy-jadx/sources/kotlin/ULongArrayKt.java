package kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\u0008\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\u0008¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u000c", d2 = {"ULongArray", "Lkotlin/ULongArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/ULong;", "(ILkotlin/jvm/functions/Function1;)[J", "ulongArrayOf", "elements", "ulongArrayOf-QwZRm1k", "([J)[J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ULongArrayKt {
    private static final long[] ULongArray(int size, Function1<? super Integer, kotlin.ULong> init) {
        int i;
        long unbox-impl;
        Intrinsics.checkNotNullParameter(init, "init");
        long[] lArr = new long[size];
        i = 0;
        while (i < size) {
            lArr[i] = (ULong)init.invoke(Integer.valueOf(i)).unbox-impl();
            i++;
        }
        return ULongArray.constructor-impl(lArr);
    }

    private static final long[] ulongArrayOf-QwZRm1k(long... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements;
    }
}
