package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010!\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0001\u001aB\u0087\u0001\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u00120\u0008\u0002\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000f\u0018\u00010\u0008\u00120\u0008\u0002\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000f\u0018\u00010\u0008¢\u0006\u0002\u0010\u0011J.\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000c\u001a\u00020\t2\u0017\u0010\u0015\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000f0\u0016H\u0000¢\u0006\u0002\u0008\u0017J\r\u0010\u0018\u001a\u00020\tH\u0000¢\u0006\u0002\u0008\u0019R6\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000f\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000f\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0001\u0004\u001b\u001c\u001d\u001e¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", "name", "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getType$foundation_layout_release", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "addOverflowComposables", "list", "", "addOverflowComposables$foundation_layout_release", "createOverflowState", "createOverflowState$foundation_layout_release", "OverflowType", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class FlowLayoutOverflow {

    public static final int $stable;
    private final Function1<androidx.compose.foundation.layout.FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> collapseGetter;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private final Function1<androidx.compose.foundation.layout.FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> seeMoreGetter;
    private final androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType type;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "", "(Ljava/lang/String;I)V", "Visible", "Clip", "ExpandIndicator", "ExpandOrCollapseIndicator", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum OverflowType {

        Visible,
        Clip,
        ExpandIndicator,
        ExpandOrCollapseIndicator;
        private static final androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType[] $values() {
            return /* result */;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[FlowLayoutOverflow.OverflowType.ExpandIndicator.ordinal()] = 1;
            iArr[FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator.ordinal()] = 2;
            FlowLayoutOverflow.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
    }

    private FlowLayoutOverflow(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType type, int minLinesToShowCollapse, int minCrossAxisSizeToShowCollapse, Function1<? super androidx.compose.foundation.layout.FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> seeMoreGetter, Function1<? super androidx.compose.foundation.layout.FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> collapseGetter) {
        super();
        this.type = type;
        this.minLinesToShowCollapse = minLinesToShowCollapse;
        this.minCrossAxisSizeToShowCollapse = minCrossAxisSizeToShowCollapse;
        this.seeMoreGetter = seeMoreGetter;
        this.collapseGetter = collapseGetter;
    }

    public FlowLayoutOverflow(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType flowLayoutOverflow$OverflowType, int i2, int i3, Function1 function14, Function1 function15, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i;
        int i4;
        int i5;
        int i7;
        final int i8 = 0;
        i = i6 & 2 != 0 ? i8 : i2;
        i4 = i6 & 4 != 0 ? i8 : i3;
        final int obj11 = 0;
        i5 = i6 & 8 != 0 ? obj11 : function14;
        i7 = i6 & 16 != 0 ? obj11 : function15;
        super(overflowType, i, i4, i5, i7, 0);
    }

    public FlowLayoutOverflow(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType flowLayoutOverflow$OverflowType, int i2, int i3, Function1 function14, Function1 function15, DefaultConstructorMarker defaultConstructorMarker6) {
        super(overflowType, i2, i3, function14, function15);
    }

    public final void addOverflowComposables$foundation_layout_release(androidx.compose.foundation.layout.FlowLayoutOverflowState state, List<Function2<Composer, Integer, Unit>> list) {
        int i;
        int $i$a$LetFlowLayoutOverflow$addOverflowComposables$collapseIndicator$1;
        int invoke2;
        int[] $EnumSwitchMapping$0;
        int invoke;
        Function1 seeMoreGetter = this.seeMoreGetter;
        if (seeMoreGetter != null) {
            invoke2 = 0;
            invoke = seeMoreGetter.invoke(state);
        } else {
            invoke = $i$a$LetFlowLayoutOverflow$addOverflowComposables$collapseIndicator$1;
        }
        Function1 collapseGetter = this.collapseGetter;
        if (collapseGetter != null) {
            int i3 = 0;
            $i$a$LetFlowLayoutOverflow$addOverflowComposables$collapseIndicator$1 = invoke2;
        }
        switch (i) {
            case 1:
                i = invoke;
                $EnumSwitchMapping$0 = 0;
                list.add(invoke);
                break;
            case 2:
                i = invoke;
                $EnumSwitchMapping$0 = 0;
                list.add(invoke);
                i = $i$a$LetFlowLayoutOverflow$addOverflowComposables$collapseIndicator$1;
                $EnumSwitchMapping$0 = 0;
                list.add($i$a$LetFlowLayoutOverflow$addOverflowComposables$collapseIndicator$1);
                break;
            default:
        }
    }

    public final androidx.compose.foundation.layout.FlowLayoutOverflowState createOverflowState$foundation_layout_release() {
        FlowLayoutOverflowState flowLayoutOverflowState = new FlowLayoutOverflowState(this.type, this.minLinesToShowCollapse, this.minCrossAxisSizeToShowCollapse);
        return flowLayoutOverflowState;
    }

    public final androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType getType$foundation_layout_release() {
        return this.type;
    }
}
