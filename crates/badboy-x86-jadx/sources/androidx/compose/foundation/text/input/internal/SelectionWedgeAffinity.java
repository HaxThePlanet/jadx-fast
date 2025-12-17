package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\t¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "", "affinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "startAffinity", "endAffinity", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "getEndAffinity", "()Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "getStartAffinity", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionWedgeAffinity {

    public static final int $stable;
    private final androidx.compose.foundation.text.input.internal.WedgeAffinity endAffinity;
    private final androidx.compose.foundation.text.input.internal.WedgeAffinity startAffinity;
    static {
    }

    public SelectionWedgeAffinity(androidx.compose.foundation.text.input.internal.WedgeAffinity affinity) {
        super(affinity, affinity);
    }

    public SelectionWedgeAffinity(androidx.compose.foundation.text.input.internal.WedgeAffinity startAffinity, androidx.compose.foundation.text.input.internal.WedgeAffinity endAffinity) {
        super();
        this.startAffinity = startAffinity;
        this.endAffinity = endAffinity;
    }

    public static androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity copy$default(androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity selectionWedgeAffinity, androidx.compose.foundation.text.input.internal.WedgeAffinity wedgeAffinity2, androidx.compose.foundation.text.input.internal.WedgeAffinity wedgeAffinity3, int i4, Object object5) {
        androidx.compose.foundation.text.input.internal.WedgeAffinity obj1;
        androidx.compose.foundation.text.input.internal.WedgeAffinity obj2;
        if (i4 & 1 != 0) {
            obj1 = selectionWedgeAffinity.startAffinity;
        }
        if (i4 &= 2 != 0) {
            obj2 = selectionWedgeAffinity.endAffinity;
        }
        return selectionWedgeAffinity.copy(obj1, obj2);
    }

    public final androidx.compose.foundation.text.input.internal.WedgeAffinity component1() {
        return this.startAffinity;
    }

    public final androidx.compose.foundation.text.input.internal.WedgeAffinity component2() {
        return this.endAffinity;
    }

    public final androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity copy(androidx.compose.foundation.text.input.internal.WedgeAffinity wedgeAffinity, androidx.compose.foundation.text.input.internal.WedgeAffinity wedgeAffinity2) {
        SelectionWedgeAffinity selectionWedgeAffinity = new SelectionWedgeAffinity(wedgeAffinity, wedgeAffinity2);
        return selectionWedgeAffinity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SelectionWedgeAffinity) {
            return i2;
        }
        Object obj = object;
        if (this.startAffinity != obj.startAffinity) {
            return i2;
        }
        if (this.endAffinity != obj.endAffinity) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.foundation.text.input.internal.WedgeAffinity getEndAffinity() {
        return this.endAffinity;
    }

    public final androidx.compose.foundation.text.input.internal.WedgeAffinity getStartAffinity() {
        return this.startAffinity;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SelectionWedgeAffinity(startAffinity=").append(this.startAffinity).append(", endAffinity=").append(this.endAffinity).append(')').toString();
    }
}
