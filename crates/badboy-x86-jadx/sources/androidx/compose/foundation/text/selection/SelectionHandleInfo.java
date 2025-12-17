package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0015\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0010J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "", "handle", "Landroidx/compose/foundation/text/Handle;", "position", "Landroidx/compose/ui/geometry/Offset;", "anchor", "Landroidx/compose/foundation/text/selection/SelectionHandleAnchor;", "visible", "", "(Landroidx/compose/foundation/text/Handle;JLandroidx/compose/foundation/text/selection/SelectionHandleAnchor;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnchor", "()Landroidx/compose/foundation/text/selection/SelectionHandleAnchor;", "getHandle", "()Landroidx/compose/foundation/text/Handle;", "getPosition-F1C5BW0", "()J", "J", "getVisible", "()Z", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "copy", "copy-ubNVwUQ", "(Landroidx/compose/foundation/text/Handle;JLandroidx/compose/foundation/text/selection/SelectionHandleAnchor;Z)Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "equals", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionHandleInfo {

    public static final int $stable;
    private final androidx.compose.foundation.text.selection.SelectionHandleAnchor anchor;
    private final Handle handle;
    private final long position;
    private final boolean visible;
    static {
    }

    private SelectionHandleInfo(Handle handle, long position, androidx.compose.foundation.text.selection.SelectionHandleAnchor anchor, boolean visible) {
        super();
        this.handle = handle;
        this.position = position;
        this.anchor = visible;
        this.visible = obj5;
    }

    public SelectionHandleInfo(Handle handle, long l2, androidx.compose.foundation.text.selection.SelectionHandleAnchor selectionHandleAnchor3, boolean z4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(handle, l2, selectionHandleAnchor3, z4, defaultConstructorMarker5);
    }

    public static androidx.compose.foundation.text.selection.SelectionHandleInfo copy-ubNVwUQ$default(androidx.compose.foundation.text.selection.SelectionHandleInfo selectionHandleInfo, Handle handle2, long l3, androidx.compose.foundation.text.selection.SelectionHandleAnchor selectionHandleAnchor4, boolean z5, int i6, Object object7) {
        Handle obj1;
        long obj2;
        androidx.compose.foundation.text.selection.SelectionHandleAnchor obj4;
        boolean obj5;
        if (object7 & 1 != 0) {
            obj1 = selectionHandleInfo.handle;
        }
        if (object7 & 2 != 0) {
            obj2 = selectionHandleInfo.position;
        }
        if (object7 & 4 != 0) {
            obj4 = selectionHandleInfo.anchor;
        }
        if (object7 &= 8 != 0) {
            obj5 = selectionHandleInfo.visible;
        }
        return selectionHandleInfo.copy-ubNVwUQ(obj1, obj2, obj5, obj4);
    }

    public final Handle component1() {
        return this.handle;
    }

    public final long component2-F1C5BW0() {
        return this.position;
    }

    public final androidx.compose.foundation.text.selection.SelectionHandleAnchor component3() {
        return this.anchor;
    }

    public final boolean component4() {
        return this.visible;
    }

    public final androidx.compose.foundation.text.selection.SelectionHandleInfo copy-ubNVwUQ(Handle handle, long l2, androidx.compose.foundation.text.selection.SelectionHandleAnchor selectionHandleAnchor3, boolean z4) {
        SelectionHandleInfo selectionHandleInfo = new SelectionHandleInfo(handle, l2, obj3, z4, obj12, 0);
        return selectionHandleInfo;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SelectionHandleInfo) {
            return i2;
        }
        Object obj = object;
        Handle handle2 = obj.handle;
        if (this.handle != handle2) {
            return i2;
        }
        if (!Offset.equals-impl0(this.position, handle2)) {
            return i2;
        }
        if (this.anchor != obj.anchor) {
            return i2;
        }
        if (this.visible != obj.visible) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.foundation.text.selection.SelectionHandleAnchor getAnchor() {
        return this.anchor;
    }

    public final Handle getHandle() {
        return this.handle;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SelectionHandleInfo(handle=").append(this.handle).append(", position=").append(Offset.toString-impl(this.position)).append(", anchor=").append(this.anchor).append(", visible=").append(this.visible).append(')').toString();
    }
}
