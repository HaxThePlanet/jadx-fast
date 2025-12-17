package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0000\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0003¨\u0006\u000b", d2 = {"FirstBaseline", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "getFirstBaseline", "()Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "LastBaseline", "getLastBaseline", "merge", "", "Landroidx/compose/ui/layout/AlignmentLine;", "position1", "position2", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AlignmentLineKt {

    private static final androidx.compose.ui.layout.HorizontalAlignmentLine FirstBaseline;
    private static final androidx.compose.ui.layout.HorizontalAlignmentLine LastBaseline;
    static {
        HorizontalAlignmentLine horizontalAlignmentLine = new HorizontalAlignmentLine((Function2)AlignmentLineKt.FirstBaseline.1.INSTANCE);
        AlignmentLineKt.FirstBaseline = horizontalAlignmentLine;
        HorizontalAlignmentLine horizontalAlignmentLine2 = new HorizontalAlignmentLine((Function2)AlignmentLineKt.LastBaseline.1.INSTANCE);
        AlignmentLineKt.LastBaseline = horizontalAlignmentLine2;
    }

    public static final androidx.compose.ui.layout.HorizontalAlignmentLine getFirstBaseline() {
        return AlignmentLineKt.FirstBaseline;
    }

    public static final androidx.compose.ui.layout.HorizontalAlignmentLine getLastBaseline() {
        return AlignmentLineKt.LastBaseline;
    }

    public static final int merge(androidx.compose.ui.layout.AlignmentLine $this$merge, int position1, int position2) {
        return (Number)$this$merge.getMerger$ui_release().invoke(Integer.valueOf(position1), Integer.valueOf(position2)).intValue();
    }
}
