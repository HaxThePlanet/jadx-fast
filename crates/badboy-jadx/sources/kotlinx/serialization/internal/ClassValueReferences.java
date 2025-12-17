package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0003\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008H\u0014J-\u0010\t\u001a\u00028\u00002\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u000e\u0008\u0004\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0008\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0010", d2 = {"Lkotlinx/serialization/internal/ClassValueReferences;", "T", "Ljava/lang/ClassValue;", "Lkotlinx/serialization/internal/MutableSoftReference;", "<init>", "()V", "computeValue", "type", "Ljava/lang/Class;", "getOrSet", "key", "factory", "Lkotlin/Function0;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isStored", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ClassValueReferences<T>  extends java.lang.ClassValue<kotlinx.serialization.internal.MutableSoftReference<T>> {
    @Override // java.lang.ClassValue
    public Object computeValue(Class p0) {
        return computeValue(p0);
    }

    protected kotlinx.serialization.internal.MutableSoftReference<T> computeValue(Class<?> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        MutableSoftReference mutableSoftReference = new MutableSoftReference();
        return mutableSoftReference;
    }

    public final T getOrSet(Class<?> key, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        int i = 0;
        final Object obj = get(key);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = obj.reference.get();
        if (obj2 != null) {
            final int i2 = 0;
            return obj2;
        }
        ClassValueReferences.getOrSet.2 it = new ClassValueReferences.getOrSet.2(factory);
        return (MutableSoftReference)obj.getOrSetWithLock((Function0)it);
    }

    public final boolean isStored(Class<?> key) {
        int i;
        Intrinsics.checkNotNullParameter(key, "key");
        i = obj.reference.get() != null ? 1 : 0;
        return i;
    }
}
