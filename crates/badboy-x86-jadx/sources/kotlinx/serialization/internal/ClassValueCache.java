package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0005\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\u00122\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u0005H\u0016R)\u0010\u0003\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0005\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lkotlinx/serialization/internal/ClassValueCache;", "T", "Lkotlinx/serialization/internal/SerializerCache;", "compute", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getCompute", "()Lkotlin/jvm/functions/Function1;", "classValue", "Lkotlinx/serialization/internal/ClassValueReferences;", "Lkotlinx/serialization/internal/CacheEntry;", "get", "key", "", "isStored", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ClassValueCache<T>  implements kotlinx.serialization.internal.SerializerCache<T> {

    private final kotlinx.serialization.internal.ClassValueReferences<kotlinx.serialization.internal.CacheEntry<T>> classValue;
    private final Function1<KClass<?>, KSerializer<T>> compute;
    public ClassValueCache(Function1<? super KClass<?>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        super();
        this.compute = compute;
        ClassValueReferences classValueReferences = new ClassValueReferences();
        this.classValue = classValueReferences;
    }

    public KSerializer<T> get(KClass<Object> key) {
        Object orSetWithLock;
        int i;
        Intrinsics.checkNotNullParameter(key, "key");
        final int i2 = 0;
        final Object obj = this.classValue.get(JvmClassMappingKt.getJavaClass(key));
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        if (obj.reference.get() != null) {
            i = 0;
        } else {
            ClassValueCache.get$$inlined.getOrSet.1 it$iv = new ClassValueCache.get$$inlined.getOrSet.1(this, key);
            orSetWithLock = (MutableSoftReference)obj.getOrSetWithLock((Function0)it$iv);
        }
        return orSetWithLock.serializer;
    }

    public final Function1<KClass<?>, KSerializer<T>> getCompute() {
        return this.compute;
    }

    public boolean isStored(KClass<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.classValue.isStored(JvmClassMappingKt.getJavaClass(key));
    }
}
