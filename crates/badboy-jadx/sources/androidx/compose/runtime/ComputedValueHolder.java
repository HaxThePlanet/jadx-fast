package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001e\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0008\u0006HÆ\u0003J*\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0019\u0008\u0002\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0008\u0006HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00172\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0008\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u001c", d2 = {"Landroidx/compose/runtime/ComputedValueHolder;", "T", "Landroidx/compose/runtime/ValueHolder;", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getCompute", "()Lkotlin/jvm/functions/Function1;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "readValue", "map", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)Ljava/lang/Object;", "toProvided", "Landroidx/compose/runtime/ProvidedValue;", "local", "Landroidx/compose/runtime/CompositionLocal;", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComputedValueHolder<T>  implements androidx.compose.runtime.ValueHolder<T> {

    public static final int $stable;
    private final Function1<androidx.compose.runtime.CompositionLocalAccessorScope, T> compute;
    static {
    }

    public ComputedValueHolder(Function1<? super androidx.compose.runtime.CompositionLocalAccessorScope, ? extends T> compute) {
        super();
        this.compute = compute;
    }

    public static androidx.compose.runtime.ComputedValueHolder copy$default(androidx.compose.runtime.ComputedValueHolder computedValueHolder, Function1 function12, int i3, Object object4) {
        Function1 obj1;
        if (i3 &= 1 != 0) {
            obj1 = computedValueHolder.compute;
        }
        return computedValueHolder.copy(obj1);
    }

    public final Function1<androidx.compose.runtime.CompositionLocalAccessorScope, T> component1() {
        return this.compute;
    }

    public final androidx.compose.runtime.ComputedValueHolder<T> copy(Function1<? super androidx.compose.runtime.CompositionLocalAccessorScope, ? extends T> function1) {
        ComputedValueHolder computedValueHolder = new ComputedValueHolder(function1);
        return computedValueHolder;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ComputedValueHolder) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.compute, obj.compute)) {
            return i2;
        }
        return i;
    }

    public final Function1<androidx.compose.runtime.CompositionLocalAccessorScope, T> getCompute() {
        return this.compute;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public int hashCode() {
        return this.compute.hashCode();
    }

    public T readValue(androidx.compose.runtime.PersistentCompositionLocalMap map) {
        return this.compute.invoke(map);
    }

    public androidx.compose.runtime.ProvidedValue<T> toProvided(androidx.compose.runtime.CompositionLocal<T> local) {
        ProvidedValue providedValue = new ProvidedValue(local, 0, 0, 0, 0, this.compute, 0);
        return providedValue;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ComputedValueHolder(compute=").append(this.compute).append(')').toString();
    }
}
