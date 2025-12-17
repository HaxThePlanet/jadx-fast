package androidx.compose.material;

import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00082\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0007\u001a\u00020\u0008J*\u0010\u0012\u001a\u00020\u0008*\u00020\u00112\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00082\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013", d2 = {"Landroidx/compose/material/ScrollableTabData;", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/foundation/ScrollState;Lkotlinx/coroutines/CoroutineScope;)V", "selectedTab", "", "Ljava/lang/Integer;", "onLaidOut", "", "density", "Landroidx/compose/ui/unit/Density;", "edgeOffset", "tabPositions", "", "Landroidx/compose/material/TabPosition;", "calculateTabOffset", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScrollableTabData {

    private final CoroutineScope coroutineScope;
    private final ScrollState scrollState;
    private Integer selectedTab;
    public ScrollableTabData(ScrollState scrollState, CoroutineScope coroutineScope) {
        super();
        this.scrollState = scrollState;
        this.coroutineScope = coroutineScope;
    }

    public static final ScrollState access$getScrollState$p(androidx.compose.material.ScrollableTabData $this) {
        return $this.scrollState;
    }

    private final int calculateTabOffset(androidx.compose.material.TabPosition $this$calculateTabOffset, Density density, int edgeOffset, List<androidx.compose.material.TabPosition> tabPositions) {
        final Object obj = density;
        final int i = 0;
        roundToPx-0680j_4 += edgeOffset;
        int i3 = i2 - maxValue;
        int i9 = 0;
        return RangesKt.coerceIn(roundToPx-0680j_42 - i6, i9, RangesKt.coerceAtLeast(i2 - i3, i9));
    }

    public final void onLaidOut(Density density, int edgeOffset, List<androidx.compose.material.TabPosition> tabPositions, int selectedTab) {
        Object selectedTab2;
        int i5;
        int tabOffset;
        int value;
        CoroutineScope coroutineScope;
        int i4;
        int i3;
        androidx.compose.material.ScrollableTabData.onLaidOut.1.1 anon;
        int i;
        int i2;
        selectedTab2 = this.selectedTab;
        if (selectedTab2 == null) {
            this.selectedTab = Integer.valueOf(selectedTab);
            selectedTab2 = CollectionsKt.getOrNull(tabPositions, selectedTab);
            if ((TabPosition)selectedTab2 != null) {
                i5 = 0;
                tabOffset = calculateTabOffset((TabPosition)selectedTab2, density, edgeOffset, tabPositions);
                if (this.scrollState.getValue() != tabOffset) {
                    i4 = 0;
                    value = new ScrollableTabData.onLaidOut.1.1(this, tabOffset, i4);
                    BuildersKt.launch$default(this.coroutineScope, i4, 0, (Function2)value, 3, 0);
                }
            }
        } else {
            this.selectedTab = Integer.valueOf(selectedTab);
            selectedTab2 = CollectionsKt.getOrNull(tabPositions, selectedTab);
            i5 = 0;
            tabOffset = calculateTabOffset((TabPosition)selectedTab2, density, edgeOffset, tabPositions);
            if (selectedTab2.intValue() != selectedTab && selectedTab2 != null && this.scrollState.getValue() != tabOffset) {
            }
        }
    }
}
