package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0014\u001a\u00020\u000eH&R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0012\u0010\u0008\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR'\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c¢\u0006\u0002\u0008\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0015À\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/MeasureResult;", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "placeChildren", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MeasureResult {
    public abstract Map<androidx.compose.ui.layout.AlignmentLine, Integer> getAlignmentLines();

    public abstract int getHeight();

    public Function1<androidx.compose.ui.layout.RulerScope, Unit> getRulers() {
        return 0;
    }

    public abstract int getWidth();

    public abstract void placeChildren();
}
