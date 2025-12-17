package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008B!\u0008\u0004\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R&\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0001\u0002\t\n¨\u0006\u000b", d2 = {"Landroidx/compose/ui/layout/AlignmentLine;", "", "merger", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;)V", "getMerger$ui_release", "()Lkotlin/jvm/functions/Function2;", "Companion", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AlignmentLine {

    public static final int $stable = 0;
    public static final androidx.compose.ui.layout.AlignmentLine.Companion Companion = null;
    public static final int Unspecified = Integer.MIN_VALUE;
    private final Function2<Integer, Integer, Integer> merger;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/ui/layout/AlignmentLine$Companion;", "", "()V", "Unspecified", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        AlignmentLine.Companion companion = new AlignmentLine.Companion(0);
        AlignmentLine.Companion = companion;
    }

    private AlignmentLine(Function2<? super Integer, ? super Integer, Integer> merger) {
        super();
        this.merger = merger;
    }

    public AlignmentLine(Function2 function2, DefaultConstructorMarker defaultConstructorMarker2) {
        super(function2);
    }

    public final Function2<Integer, Integer, Integer> getMerger$ui_release() {
        return this.merger;
    }
}
