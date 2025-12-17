package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0008\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00162\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Landroidx/compose/runtime/StaticValueHolder;", "T", "Landroidx/compose/runtime/ValueHolder;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Landroidx/compose/runtime/StaticValueHolder;", "equals", "", "other", "", "hashCode", "", "readValue", "map", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)Ljava/lang/Object;", "toProvided", "Landroidx/compose/runtime/ProvidedValue;", "local", "Landroidx/compose/runtime/CompositionLocal;", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StaticValueHolder<T>  implements androidx.compose.runtime.ValueHolder<T> {

    public static final int $stable;
    private final T value;
    static {
    }

    public StaticValueHolder(T value) {
        super();
        this.value = value;
    }

    public static androidx.compose.runtime.StaticValueHolder copy$default(androidx.compose.runtime.StaticValueHolder staticValueHolder, Object object2, int i3, Object object4) {
        Object obj1;
        if (i3 &= 1 != 0) {
            obj1 = staticValueHolder.value;
        }
        return staticValueHolder.copy(obj1);
    }

    public final T component1() {
        return this.value;
    }

    public final androidx.compose.runtime.StaticValueHolder<T> copy(T t) {
        StaticValueHolder staticValueHolder = new StaticValueHolder(t);
        return staticValueHolder;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof StaticValueHolder) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.value, obj.value)) {
            return i2;
        }
        return i;
    }

    public final T getValue() {
        return this.value;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public int hashCode() {
        int i;
        if (this.value == null) {
            i = 0;
        } else {
            i = this.value.hashCode();
        }
        return i;
    }

    public T readValue(androidx.compose.runtime.PersistentCompositionLocalMap map) {
        return this.value;
    }

    public androidx.compose.runtime.ProvidedValue<T> toProvided(androidx.compose.runtime.CompositionLocal<T> local) {
        int i;
        i = this.value == null ? 1 : 0;
        ProvidedValue providedValue = new ProvidedValue(local, this.value, i, 0, 0, 0, 0);
        return providedValue;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("StaticValueHolder(value=").append(this.value).append(')').toString();
    }
}
