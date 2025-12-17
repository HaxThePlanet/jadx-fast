package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0083@\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\u0008\u000c\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0003¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/lazy/layout/StableValue;", "T", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class StableValue<T>  {

    private final T value;
    private StableValue(Object value) {
        super();
        this.value = value;
    }

    public static final androidx.compose.foundation.lazy.layout.StableValue box-impl(Object object) {
        StableValue stableValue = new StableValue(object);
        return stableValue;
    }

    public static <T> Object constructor-impl(T t) {
        return t;
    }

    public static boolean equals-impl(Object object, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof StableValue) {
            return i2;
        }
        if (!Intrinsics.areEqual(object, (StableValue)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(Object object, Object object2) {
        return Intrinsics.areEqual(object, object2);
    }

    public static int hashCode-impl(Object object) {
        int i;
        if (object == null) {
            i = 0;
        } else {
            i = object.hashCode();
        }
        return i;
    }

    public static String toString-impl(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("StableValue(value=").append(object).append(')').toString();
    }

    public boolean equals(Object object) {
        return StableValue.equals-impl(this.value, object);
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        return StableValue.hashCode-impl(this.value);
    }

    public String toString() {
        return StableValue.toString-impl(this.value);
    }

    public final Object unbox-impl() {
        return this.value;
    }
}
