package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t", d2 = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/LazyKt")
class LazyKt__LazyJVMKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            LazyKt__LazyJVMKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final <T> kotlin.Lazy<T> lazy(Object lock, Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(initializer, lock);
        return (Lazy)synchronizedLazyImpl;
    }

    public static final <T> kotlin.Lazy<T> lazy(kotlin.LazyThreadSafetyMode mode, Function0<? extends T> initializer) {
        Object safePublicationLazyImpl;
        int ordinal;
        int i;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        switch (i3) {
            case 1:
                i = 0;
                safePublicationLazyImpl = new SynchronizedLazyImpl(initializer, i, 2, i);
                break;
            case 2:
                safePublicationLazyImpl = new SafePublicationLazyImpl(initializer);
                break;
            case 3:
                safePublicationLazyImpl = new UnsafeLazyImpl(initializer);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return safePublicationLazyImpl;
    }

    public static final <T> kotlin.Lazy<T> lazy(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        final int i = 0;
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(initializer, i, 2, i);
        return (Lazy)synchronizedLazyImpl;
    }
}
