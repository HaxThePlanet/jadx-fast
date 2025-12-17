package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00028\u00002\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nR\u0018\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/serialization/internal/MutableSoftReference;", "T", "", "<init>", "()V", "reference", "Ljava/lang/ref/SoftReference;", "getOrSetWithLock", "factory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MutableSoftReference<T>  {

    public volatile SoftReference<T> reference;
    public MutableSoftReference() {
        super();
        SoftReference softReference = new SoftReference(0);
        this.reference = softReference;
    }

    public final T getOrSetWithLock(Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Object obj = this.reference.get();
        synchronized (this) {
            try {
                int i = 0;
                return obj;
                Object invoke = factory.invoke();
                SoftReference softReference = new SoftReference(invoke);
                this.reference = softReference;
                return invoke;
                throw factory;
            }
        }
    }
}
