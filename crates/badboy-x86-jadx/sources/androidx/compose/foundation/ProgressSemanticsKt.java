package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00052\u0008\u0008\u0003\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u0008", d2 = {"progressSemantics", "Landroidx/compose/ui/Modifier;", "value", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProgressSemanticsKt {
    public static final Modifier progressSemantics(Modifier $this$progressSemantics) {
        return SemanticsModifierKt.semantics($this$progressSemantics, true, (Function1)ProgressSemanticsKt.progressSemantics.2.INSTANCE);
    }

    public static final Modifier progressSemantics(Modifier $this$progressSemantics, float value, ClosedFloatingPointRange<Float> valueRange, int steps) {
        ProgressSemanticsKt.progressSemantics.1 anon = new ProgressSemanticsKt.progressSemantics.1(value, valueRange, steps);
        return SemanticsModifierKt.semantics($this$progressSemantics, true, (Function1)anon);
    }

    public static Modifier progressSemantics$default(Modifier modifier, float f2, ClosedFloatingPointRange closedFloatingPointRange3, int i4, int i5, Object object6) {
        ClosedFloatingPointRange obj2;
        int obj3;
        int obj5;
        if (i5 & 2 != 0) {
            obj2 = RangesKt.rangeTo(0, 1065353216);
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return ProgressSemanticsKt.progressSemantics(modifier, f2, obj2, obj3);
    }
}
