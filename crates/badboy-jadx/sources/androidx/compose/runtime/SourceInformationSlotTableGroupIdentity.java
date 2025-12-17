package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0013", d2 = {"Landroidx/compose/runtime/SourceInformationSlotTableGroupIdentity;", "", "parentIdentity", "index", "", "(Ljava/lang/Object;I)V", "getIndex", "()I", "getParentIdentity", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SourceInformationSlotTableGroupIdentity {

    private final int index;
    private final Object parentIdentity;
    public SourceInformationSlotTableGroupIdentity(Object parentIdentity, int index) {
        super();
        this.parentIdentity = parentIdentity;
        this.index = index;
    }

    public static androidx.compose.runtime.SourceInformationSlotTableGroupIdentity copy$default(androidx.compose.runtime.SourceInformationSlotTableGroupIdentity sourceInformationSlotTableGroupIdentity, Object object2, int i3, int i4, Object object5) {
        Object obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = sourceInformationSlotTableGroupIdentity.parentIdentity;
        }
        if (i4 &= 2 != 0) {
            obj2 = sourceInformationSlotTableGroupIdentity.index;
        }
        return sourceInformationSlotTableGroupIdentity.copy(obj1, obj2);
    }

    public final Object component1() {
        return this.parentIdentity;
    }

    public final int component2() {
        return this.index;
    }

    public final androidx.compose.runtime.SourceInformationSlotTableGroupIdentity copy(Object object, int i2) {
        SourceInformationSlotTableGroupIdentity sourceInformationSlotTableGroupIdentity = new SourceInformationSlotTableGroupIdentity(object, i2);
        return sourceInformationSlotTableGroupIdentity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SourceInformationSlotTableGroupIdentity) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.parentIdentity, obj.parentIdentity)) {
            return i2;
        }
        if (this.index != obj.index) {
            return i2;
        }
        return i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getParentIdentity() {
        return this.parentIdentity;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SourceInformationSlotTableGroupIdentity(parentIdentity=").append(this.parentIdentity).append(", index=").append(this.index).append(')').toString();
    }
}
