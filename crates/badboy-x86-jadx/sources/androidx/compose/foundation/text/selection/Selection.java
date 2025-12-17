package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0081\u0008\u0018\u00002\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\u00002\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/text/selection/Selection;", "", "start", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "end", "handlesCrossed", "", "(Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Z)V", "getEnd", "()Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getHandlesCrossed", "()Z", "getStart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "merge", "toString", "", "toTextRange", "Landroidx/compose/ui/text/TextRange;", "toTextRange-d9O1mEE", "()J", "AnchorInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Selection {

    public static final int $stable;
    private final androidx.compose.foundation.text.selection.Selection.AnchorInfo end;
    private final boolean handlesCrossed;
    private final androidx.compose.foundation.text.selection.Selection.AnchorInfo start;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "", "selectableId", "", "(Landroidx/compose/ui/text/style/ResolvedTextDirection;IJ)V", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getOffset", "()I", "getSelectableId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnchorInfo {

        public static final int $stable;
        private final ResolvedTextDirection direction;
        private final int offset;
        private final long selectableId;
        static {
        }

        public AnchorInfo(ResolvedTextDirection direction, int offset, long selectableId) {
            super();
            this.direction = direction;
            this.offset = offset;
            this.selectableId = selectableId;
        }

        public static androidx.compose.foundation.text.selection.Selection.AnchorInfo copy$default(androidx.compose.foundation.text.selection.Selection.AnchorInfo selection$AnchorInfo, ResolvedTextDirection resolvedTextDirection2, int i3, long l4, int i5, Object object6) {
            ResolvedTextDirection obj1;
            int obj2;
            long obj3;
            if (object6 & 1 != 0) {
                obj1 = anchorInfo.direction;
            }
            if (object6 & 2 != 0) {
                obj2 = anchorInfo.offset;
            }
            if (object6 &= 4 != 0) {
                obj3 = anchorInfo.selectableId;
            }
            return anchorInfo.copy(obj1, obj2, obj3);
        }

        public final ResolvedTextDirection component1() {
            return this.direction;
        }

        public final int component2() {
            return this.offset;
        }

        public final long component3() {
            return this.selectableId;
        }

        public final androidx.compose.foundation.text.selection.Selection.AnchorInfo copy(ResolvedTextDirection resolvedTextDirection, int i2, long l3) {
            Selection.AnchorInfo anchorInfo = new Selection.AnchorInfo(resolvedTextDirection, i2, l3, obj5);
            return anchorInfo;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof Selection.AnchorInfo) {
                return i2;
            }
            Object obj = object;
            if (this.direction != obj.direction) {
                return i2;
            }
            if (this.offset != obj.offset) {
                return i2;
            }
            if (Long.compare(selectableId, selectableId2) != 0) {
                return i2;
            }
            return i;
        }

        public final ResolvedTextDirection getDirection() {
            return this.direction;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final long getSelectableId() {
            return this.selectableId;
        }

        public int hashCode() {
            return i2 += i7;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("AnchorInfo(direction=").append(this.direction).append(", offset=").append(this.offset).append(", selectableId=").append(this.selectableId).append(')').toString();
        }
    }
    static {
    }

    public Selection(androidx.compose.foundation.text.selection.Selection.AnchorInfo start, androidx.compose.foundation.text.selection.Selection.AnchorInfo end, boolean handlesCrossed) {
        super();
        this.start = start;
        this.end = end;
        this.handlesCrossed = handlesCrossed;
    }

    public Selection(androidx.compose.foundation.text.selection.Selection.AnchorInfo selection$AnchorInfo, androidx.compose.foundation.text.selection.Selection.AnchorInfo selection$AnchorInfo2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(anchorInfo, anchorInfo2, obj3);
    }

    public static androidx.compose.foundation.text.selection.Selection copy$default(androidx.compose.foundation.text.selection.Selection selection, androidx.compose.foundation.text.selection.Selection.AnchorInfo selection$AnchorInfo2, androidx.compose.foundation.text.selection.Selection.AnchorInfo selection$AnchorInfo3, boolean z4, int i5, Object object6) {
        androidx.compose.foundation.text.selection.Selection.AnchorInfo obj1;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo obj2;
        boolean obj3;
        if (i5 & 1 != 0) {
            obj1 = selection.start;
        }
        if (i5 & 2 != 0) {
            obj2 = selection.end;
        }
        if (i5 &= 4 != 0) {
            obj3 = selection.handlesCrossed;
        }
        return selection.copy(obj1, obj2, obj3);
    }

    public final androidx.compose.foundation.text.selection.Selection.AnchorInfo component1() {
        return this.start;
    }

    public final androidx.compose.foundation.text.selection.Selection.AnchorInfo component2() {
        return this.end;
    }

    public final boolean component3() {
        return this.handlesCrossed;
    }

    public final androidx.compose.foundation.text.selection.Selection copy(androidx.compose.foundation.text.selection.Selection.AnchorInfo selection$AnchorInfo, androidx.compose.foundation.text.selection.Selection.AnchorInfo selection$AnchorInfo2, boolean z3) {
        Selection selection = new Selection(anchorInfo, anchorInfo2, z3);
        return selection;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Selection) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.start, obj.start)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.end, obj.end)) {
            return i2;
        }
        if (this.handlesCrossed != obj.handlesCrossed) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.foundation.text.selection.Selection.AnchorInfo getEnd() {
        return this.end;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    public final androidx.compose.foundation.text.selection.Selection.AnchorInfo getStart() {
        return this.start;
    }

    public int hashCode() {
        return i2 += i7;
    }

    public final androidx.compose.foundation.text.selection.Selection merge(androidx.compose.foundation.text.selection.Selection other) {
        boolean handlesCrossed;
        androidx.compose.foundation.text.selection.Selection copy$default;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start2;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start;
        int i2;
        int i;
        if (other == null) {
            return this;
        }
        if (!this.handlesCrossed) {
            if (other.handlesCrossed) {
                start2 = other.handlesCrossed ? other.start : other.end;
                start = this.handlesCrossed ? this.end : this.start;
                copy$default = new Selection(start2, start, 1);
            } else {
                copy$default = Selection.copy$default(this, 0, other.end, false, 5, 0);
            }
        } else {
        }
        return copy$default;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Selection(start=").append(this.start).append(", end=").append(this.end).append(", handlesCrossed=").append(this.handlesCrossed).append(')').toString();
    }

    public final long toTextRange-d9O1mEE() {
        return TextRangeKt.TextRange(this.start.getOffset(), this.end.getOffset());
    }
}
