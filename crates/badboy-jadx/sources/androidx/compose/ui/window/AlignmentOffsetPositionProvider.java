package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u000c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/ui/window/AlignmentOffsetPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getOffset-nOcc-ac", "()J", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AlignmentOffsetPositionProvider implements androidx.compose.ui.window.PopupPositionProvider {

    public static final int $stable;
    private final Alignment alignment;
    private final long offset;
    static {
    }

    private AlignmentOffsetPositionProvider(Alignment alignment, long offset) {
        super();
        this.alignment = alignment;
        this.offset = offset;
    }

    public AlignmentOffsetPositionProvider(Alignment alignment, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(alignment, l2, defaultConstructorMarker3);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long calculatePosition-llwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        int i;
        long zero-YbymL2g = IntSize.Companion.getZero-YbymL2g();
        long zero-YbymL2g2 = IntSize.Companion.getZero-YbymL2g();
        final long l2 = popupContentSize;
        i = popupContentSize == LayoutDirection.Ltr ? 1 : -1;
        return IntOffset.plus-qkQi6aY(IntOffset.plus-qkQi6aY(IntOffset.plus-qkQi6aY(anchorBounds.getTopLeft-nOcc-ac(), obj9), obj9), obj9);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final long getOffset-nOcc-ac() {
        return this.offset;
    }
}
