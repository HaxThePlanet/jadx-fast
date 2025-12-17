package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@LayoutScopeMarker
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008g\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J \u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H'J\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000cH'J \u0010\r\u001a\u00020\u0003*\u00020\u00032\u0008\u0008\u0001\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0011À\u0006\u0003", d2 = {"Landroidx/compose/foundation/layout/ColumnScope;", "", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "weight", "", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ColumnScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Modifier weight$default(androidx.compose.foundation.layout.ColumnScope columnScope, Modifier modifier2, float f3, boolean z4, int i5, Object object6) {
            return ColumnScope.weight$default(columnScope, modifier2, f3, z4, i5, object6);
        }
    }
    public static Modifier weight$default(androidx.compose.foundation.layout.ColumnScope columnScope, Modifier modifier2, float f3, boolean z4, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 2 != 0) {
                obj3 = 1;
            }
            return columnScope.weight(modifier2, f3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: weight");
        throw obj0;
    }

    public abstract Modifier align(Modifier modifier, Alignment.Horizontal alignment$Horizontal2);

    public abstract Modifier alignBy(Modifier modifier, VerticalAlignmentLine verticalAlignmentLine2);

    public abstract Modifier alignBy(Modifier modifier, Function1<? super Measured, Integer> function12);

    public abstract Modifier weight(Modifier modifier, float f2, boolean z3);
}
