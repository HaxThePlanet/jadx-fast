package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0008\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u0013", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "", "count", "", "(I)V", "getCount", "()I", "setCount", "component1", "copy", "equals", "", "other", "hashCode", "plusAssign", "", "that", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeltaCounter {

    public static final int $stable = 8;
    private int count;
    static {
        final int i = 8;
    }

    public DeltaCounter() {
        super(0, 1, 0);
    }

    public DeltaCounter(int count) {
        super();
        this.count = count;
    }

    public DeltaCounter(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter copy$default(androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter deltaCounter, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = deltaCounter.count;
        }
        return deltaCounter.copy(obj1);
    }

    public final int component1() {
        return this.count;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter copy(int i) {
        DeltaCounter deltaCounter = new DeltaCounter(i);
        return deltaCounter;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DeltaCounter) {
            return i2;
        }
        if (this.count != obj.count) {
            return i2;
        }
        return i;
    }

    public final int getCount() {
        return this.count;
    }

    public int hashCode() {
        return Integer.hashCode(this.count);
    }

    public final void plusAssign(int that) {
        this.count = count += that;
    }

    public final void setCount(int <set-?>) {
        this.count = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DeltaCounter(count=").append(this.count).append(')').toString();
    }
}
