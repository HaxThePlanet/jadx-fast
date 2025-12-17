package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a*\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a2\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutUtilsKt {
    public static final long finalConstraints-tfFHcEY(long constraints, boolean softWrap, int overflow, float maxIntrinsicWidth) {
        final int i = 0;
        return Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(i, LayoutUtilsKt.finalMaxWidth-tfFHcEY(constraints, softWrap, overflow, maxIntrinsicWidth), i, Constraints.getMaxHeight-impl(constraints));
    }

    public static final int finalMaxLines-xdlQI24(boolean softWrap, int overflow, int maxLinesIn) {
        int coerceAtLeast;
        boolean equals-impl0;
        int i;
        coerceAtLeast = 1;
        if (!softWrap && TextOverflow.equals-impl0(overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
            i = TextOverflow.equals-impl0(overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8()) ? coerceAtLeast : 0;
        } else {
        }
        if (i != 0) {
        } else {
            coerceAtLeast = RangesKt.coerceAtLeast(maxLinesIn, coerceAtLeast);
        }
        return coerceAtLeast;
    }

    public static final int finalMaxWidth-tfFHcEY(long constraints, boolean softWrap, int overflow, float maxIntrinsicWidth) {
        int i;
        boolean equals-impl0;
        int maxWidth-impl;
        boolean hasBoundedWidth-impl;
        int coerceIn;
        int minWidth-impl;
        if (overflow == 0) {
            if (TextOverflow.equals-impl0(maxIntrinsicWidth, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        if (i != 0 && Constraints.getHasBoundedWidth-impl(constraints)) {
            if (Constraints.getHasBoundedWidth-impl(constraints)) {
                maxWidth-impl = Constraints.getMaxWidth-impl(constraints);
            } else {
                maxWidth-impl = Integer.MAX_VALUE;
            }
        } else {
        }
        if (Constraints.getMinWidth-impl(constraints) == maxWidth-impl) {
            coerceIn = maxWidth-impl;
        } else {
            coerceIn = RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(obj8), Constraints.getMinWidth-impl(constraints), maxWidth-impl);
        }
        return coerceIn;
    }
}
