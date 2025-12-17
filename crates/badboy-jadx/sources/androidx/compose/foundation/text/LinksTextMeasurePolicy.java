package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J,\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0010", d2 = {"Landroidx/compose/foundation/text/LinksTextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LinksTextMeasurePolicy implements MeasurePolicy {

    private final Function0<Boolean> shouldMeasureLinks;
    public LinksTextMeasurePolicy(Function0<Boolean> shouldMeasureLinks) {
        super();
        this.shouldMeasureLinks = shouldMeasureLinks;
    }

    public static final Function0 access$getShouldMeasureLinks$p(androidx.compose.foundation.text.LinksTextMeasurePolicy $this) {
        return $this.shouldMeasureLinks;
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        LinksTextMeasurePolicy.measure.1 anon = new LinksTextMeasurePolicy.measure.1(measurables, this);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, Constraints.getMaxWidth-impl(constraints), Constraints.getMaxHeight-impl(constraints), 0, (Function1)anon, 4, 0);
    }
}
