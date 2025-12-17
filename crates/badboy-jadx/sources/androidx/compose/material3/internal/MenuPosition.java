package androidx.compose.material3.internal;

import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008Á\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006¨\u0006\u0013", d2 = {"Landroidx/compose/material3/internal/MenuPosition;", "", "()V", "bottomToAnchorTop", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "offset", "", "bottomToWindowBottom", "margin", "centerToAnchorTop", "endToAnchorEnd", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "leftToWindowLeft", "rightToWindowRight", "startToAnchorStart", "topToAnchorBottom", "topToWindowTop", "Horizontal", "Vertical", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MenuPosition {

    public static final int $stable;
    public static final androidx.compose.material3.internal.MenuPosition INSTANCE;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008ç\u0080\u0001\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\rÀ\u0006\u0001", d2 = {"Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "", "position", "", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Horizontal {
        public abstract int position-95KtPRI(IntRect intRect, long l2, int i3, LayoutDirection layoutDirection4);
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008ç\u0080\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/material3/internal/MenuPosition$Vertical;", "", "position", "", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Vertical {
        public abstract int position-JVtK1S4(IntRect intRect, long l2, int i3);
    }
    static {
        MenuPosition menuPosition = new MenuPosition();
        MenuPosition.INSTANCE = menuPosition;
    }

    public static androidx.compose.material3.internal.MenuPosition.Vertical bottomToAnchorTop$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.bottomToAnchorTop(obj1);
    }

    public static androidx.compose.material3.internal.MenuPosition.Vertical bottomToWindowBottom$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.bottomToWindowBottom(obj1);
    }

    public static androidx.compose.material3.internal.MenuPosition.Vertical centerToAnchorTop$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.centerToAnchorTop(obj1);
    }

    public static androidx.compose.material3.internal.MenuPosition.Horizontal endToAnchorEnd$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.endToAnchorEnd(obj1);
    }

    public static androidx.compose.material3.internal.MenuPosition.Horizontal leftToWindowLeft$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.leftToWindowLeft(obj1);
    }

    public static androidx.compose.material3.internal.MenuPosition.Horizontal rightToWindowRight$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.rightToWindowRight(obj1);
    }

    public static androidx.compose.material3.internal.MenuPosition.Horizontal startToAnchorStart$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.startToAnchorStart(obj1);
    }

    public static androidx.compose.material3.internal.MenuPosition.Vertical topToAnchorBottom$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.topToAnchorBottom(obj1);
    }

    public static androidx.compose.material3.internal.MenuPosition.Vertical topToWindowTop$default(androidx.compose.material3.internal.MenuPosition menuPosition, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return menuPosition.topToWindowTop(obj1);
    }

    public final androidx.compose.material3.internal.MenuPosition.Vertical bottomToAnchorTop(int offset) {
        AnchorAlignmentOffsetPosition.Vertical vertical = new AnchorAlignmentOffsetPosition.Vertical(Alignment.Companion.getBottom(), Alignment.Companion.getTop(), offset);
        return (MenuPosition.Vertical)vertical;
    }

    public final androidx.compose.material3.internal.MenuPosition.Vertical bottomToWindowBottom(int margin) {
        WindowAlignmentMarginPosition.Vertical vertical = new WindowAlignmentMarginPosition.Vertical(Alignment.Companion.getBottom(), margin);
        return (MenuPosition.Vertical)vertical;
    }

    public final androidx.compose.material3.internal.MenuPosition.Vertical centerToAnchorTop(int offset) {
        AnchorAlignmentOffsetPosition.Vertical vertical = new AnchorAlignmentOffsetPosition.Vertical(Alignment.Companion.getCenterVertically(), Alignment.Companion.getTop(), offset);
        return (MenuPosition.Vertical)vertical;
    }

    public final androidx.compose.material3.internal.MenuPosition.Horizontal endToAnchorEnd(int offset) {
        AnchorAlignmentOffsetPosition.Horizontal horizontal = new AnchorAlignmentOffsetPosition.Horizontal(Alignment.Companion.getEnd(), Alignment.Companion.getEnd(), offset);
        return (MenuPosition.Horizontal)horizontal;
    }

    public final androidx.compose.material3.internal.MenuPosition.Horizontal leftToWindowLeft(int margin) {
        WindowAlignmentMarginPosition.Horizontal horizontal = new WindowAlignmentMarginPosition.Horizontal(AbsoluteAlignment.INSTANCE.getLeft(), margin);
        return (MenuPosition.Horizontal)horizontal;
    }

    public final androidx.compose.material3.internal.MenuPosition.Horizontal rightToWindowRight(int margin) {
        WindowAlignmentMarginPosition.Horizontal horizontal = new WindowAlignmentMarginPosition.Horizontal(AbsoluteAlignment.INSTANCE.getRight(), margin);
        return (MenuPosition.Horizontal)horizontal;
    }

    public final androidx.compose.material3.internal.MenuPosition.Horizontal startToAnchorStart(int offset) {
        AnchorAlignmentOffsetPosition.Horizontal horizontal = new AnchorAlignmentOffsetPosition.Horizontal(Alignment.Companion.getStart(), Alignment.Companion.getStart(), offset);
        return (MenuPosition.Horizontal)horizontal;
    }

    public final androidx.compose.material3.internal.MenuPosition.Vertical topToAnchorBottom(int offset) {
        AnchorAlignmentOffsetPosition.Vertical vertical = new AnchorAlignmentOffsetPosition.Vertical(Alignment.Companion.getTop(), Alignment.Companion.getBottom(), offset);
        return (MenuPosition.Vertical)vertical;
    }

    public final androidx.compose.material3.internal.MenuPosition.Vertical topToWindowTop(int margin) {
        WindowAlignmentMarginPosition.Vertical vertical = new WindowAlignmentMarginPosition.Vertical(Alignment.Companion.getTop(), margin);
        return (MenuPosition.Vertical)vertical;
    }
}
