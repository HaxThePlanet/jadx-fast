package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0082\u0008\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0017\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\u0008\u00170\u0014\u0012;\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0010\u001fJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0012HÂ\u0003J\u001a\u0010+\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\u0008\u00170\u0014HÂ\u0003JC\u0010,\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\u0008\u0017HÂ\u0003¢\u0006\u0002\u0010-J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\u0016\u00100\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00081\u00102J\t\u00103\u001a\u00020\u000bHÆ\u0003J\u0016\u00104\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00085\u00102J\t\u00106\u001a\u00020\u000eHÂ\u0003J\t\u00107\u001a\u00020\u000eHÂ\u0003J\t\u00108\u001a\u00020\u000eHÂ\u0003JÑ\u0001\u00109\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0019\u0008\u0002\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\u0008\u00170\u00142=\u0008\u0002\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\u0008\u0017HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008:\u0010;J\u0013\u0010<\u001a\u00020\u00032\u0008\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\u0018\u0010?\u001a\u0014\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B0\u0019J\t\u0010C\u001a\u00020\u000eHÖ\u0001J\t\u0010D\u001a\u00020EHÖ\u0001J\u001e\u0010F\u001a\u00020B*\u00020@2\u0006\u0010G\u001a\u00020AH\u0002ø\u0001\u0000¢\u0006\u0004\u0008H\u0010IR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0016\u0010\u000c\u001a\u00020\tX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"RE\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\u0008\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010&R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u00020\tX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\u0008\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006J", d2 = {"Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "itemCount", "", "maxLines", "maxItemsInMainAxis", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "F", "Lkotlin/jvm/functions/Function4;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "()Z", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "component1", "component10", "component11", "component12", "()Lkotlin/jvm/functions/Function4;", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-E4Q9ldg", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;)Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "equals", "other", "", "getMeasurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "hashCode", "toString", "", "measure", "constraints", "measure-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FlowMeasureLazyPolicy implements androidx.compose.foundation.layout.FlowLineMeasurePolicy {

    private final androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Function4<Integer, androidx.compose.foundation.layout.FlowLineInfo, Composer, Integer, Unit> getComposable;
    private final androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final int itemCount;
    private final float mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final androidx.compose.foundation.layout.FlowLayoutOverflowState overflow;
    private final List<Function2<Composer, Integer, Unit>> overflowComposables;
    private final androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement;
    private FlowMeasureLazyPolicy(boolean isHorizontal, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, float mainAxisSpacing, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment, float crossAxisArrangementSpacing, int itemCount, int maxLines, int maxItemsInMainAxis, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow, List<? extends Function2<? super Composer, ? super Integer, Unit>> overflowComposables, Function4<? super Integer, ? super androidx.compose.foundation.layout.FlowLineInfo, ? super Composer, ? super Integer, Unit> getComposable) {
        super();
        this.isHorizontal = isHorizontal;
        this.horizontalArrangement = horizontalArrangement;
        this.verticalArrangement = verticalArrangement;
        this.mainAxisSpacing = mainAxisSpacing;
        this.crossAxisAlignment = crossAxisAlignment;
        this.crossAxisArrangementSpacing = crossAxisArrangementSpacing;
        this.itemCount = itemCount;
        this.maxLines = maxLines;
        this.maxItemsInMainAxis = maxItemsInMainAxis;
        this.overflow = overflow;
        this.overflowComposables = overflowComposables;
        this.getComposable = getComposable;
    }

    public FlowMeasureLazyPolicy(boolean z, androidx.compose.foundation.layout.Arrangement.Horizontal arrangement$Horizontal2, androidx.compose.foundation.layout.Arrangement.Vertical arrangement$Vertical3, float f4, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment5, float f6, int i7, int i8, int i9, androidx.compose.foundation.layout.FlowLayoutOverflowState flowLayoutOverflowState10, List list11, Function4 function412, DefaultConstructorMarker defaultConstructorMarker13) {
        super(z, horizontal2, vertical3, f4, crossAxisAlignment5, f6, i7, i8, i9, flowLayoutOverflowState10, list11, function412);
    }

    public static final Function4 access$getGetComposable$p(androidx.compose.foundation.layout.FlowMeasureLazyPolicy $this) {
        return $this.getComposable;
    }

    public static final int access$getItemCount$p(androidx.compose.foundation.layout.FlowMeasureLazyPolicy $this) {
        return $this.itemCount;
    }

    public static final List access$getOverflowComposables$p(androidx.compose.foundation.layout.FlowMeasureLazyPolicy $this) {
        return $this.overflowComposables;
    }

    public static final MeasureResult access$measure-0kLqBqw(androidx.compose.foundation.layout.FlowMeasureLazyPolicy $this, SubcomposeMeasureScope $receiver, long constraints) {
        return $this.measure-0kLqBqw($receiver, constraints);
    }

    private final androidx.compose.foundation.layout.FlowLayoutOverflowState component10() {
        return this.overflow;
    }

    private final List<Function2<Composer, Integer, Unit>> component11() {
        return this.overflowComposables;
    }

    private final Function4<Integer, androidx.compose.foundation.layout.FlowLineInfo, Composer, Integer, Unit> component12() {
        return this.getComposable;
    }

    private final float component4-D9Ej5fM() {
        return this.mainAxisSpacing;
    }

    private final float component6-D9Ej5fM() {
        return this.crossAxisArrangementSpacing;
    }

    private final int component7() {
        return this.itemCount;
    }

    private final int component8() {
        return this.maxLines;
    }

    private final int component9() {
        return this.maxItemsInMainAxis;
    }

    public static androidx.compose.foundation.layout.FlowMeasureLazyPolicy copy-E4Q9ldg$default(androidx.compose.foundation.layout.FlowMeasureLazyPolicy flowMeasureLazyPolicy, boolean z2, androidx.compose.foundation.layout.Arrangement.Horizontal arrangement$Horizontal3, androidx.compose.foundation.layout.Arrangement.Vertical arrangement$Vertical4, float f5, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment6, float f7, int i8, int i9, int i10, androidx.compose.foundation.layout.FlowLayoutOverflowState flowLayoutOverflowState11, List list12, Function4 function413, int i14, Object object15) {
        boolean obj1;
        androidx.compose.foundation.layout.Arrangement.Horizontal obj2;
        androidx.compose.foundation.layout.Arrangement.Vertical obj3;
        float obj4;
        androidx.compose.foundation.layout.CrossAxisAlignment obj5;
        float obj6;
        int obj7;
        int obj8;
        int obj9;
        androidx.compose.foundation.layout.FlowLayoutOverflowState obj10;
        List obj11;
        Function4 obj12;
        if (i14 & 1 != 0) {
            obj1 = flowMeasureLazyPolicy.isHorizontal;
        }
        if (i14 & 2 != 0) {
            obj2 = flowMeasureLazyPolicy.horizontalArrangement;
        }
        if (i14 & 4 != 0) {
            obj3 = flowMeasureLazyPolicy.verticalArrangement;
        }
        if (i14 & 8 != 0) {
            obj4 = flowMeasureLazyPolicy.mainAxisSpacing;
        }
        if (i14 & 16 != 0) {
            obj5 = flowMeasureLazyPolicy.crossAxisAlignment;
        }
        if (i14 & 32 != 0) {
            obj6 = flowMeasureLazyPolicy.crossAxisArrangementSpacing;
        }
        if (i14 & 64 != 0) {
            obj7 = flowMeasureLazyPolicy.itemCount;
        }
        if (i14 & 128 != 0) {
            obj8 = flowMeasureLazyPolicy.maxLines;
        }
        if (i14 & 256 != 0) {
            obj9 = flowMeasureLazyPolicy.maxItemsInMainAxis;
        }
        if (i14 & 512 != 0) {
            obj10 = flowMeasureLazyPolicy.overflow;
        }
        if (i14 & 1024 != 0) {
            obj11 = flowMeasureLazyPolicy.overflowComposables;
        }
        if (i14 &= 2048 != 0) {
            obj12 = flowMeasureLazyPolicy.getComposable;
        }
        return flowMeasureLazyPolicy.copy-E4Q9ldg(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    private final MeasureResult measure-0kLqBqw(SubcomposeMeasureScope $this$measure_u2d0kLqBqw, long constraints) {
        int maxItemsInMainAxis;
        androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType visible;
        androidx.compose.foundation.layout.LayoutOrientation horizontal;
        final Object obj = this;
        final SubcomposeMeasureScope subcomposeMeasureScope = $this$measure_u2d0kLqBqw;
        final long l = constraints;
        if (obj.itemCount > 0 && obj.maxLines != 0 && obj.maxItemsInMainAxis != 0) {
            if (obj.maxLines != 0) {
                if (obj.maxItemsInMainAxis != 0) {
                    if (Constraints.getMaxHeight-impl(l) == 0 && obj.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible) {
                        if (obj.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible) {
                        } else {
                            FlowMeasureLazyPolicy.measure.measurablesIterator.1 anon = new FlowMeasureLazyPolicy.measure.measurablesIterator.1(subcomposeMeasureScope, obj);
                            ContextualFlowItemIterator contextualFlowItemIterator = new ContextualFlowItemIterator(obj.itemCount, (Function2)anon);
                            obj.overflow.setItemCount$foundation_layout_release(obj.itemCount);
                            FlowMeasureLazyPolicy.measure.2 anon2 = new FlowMeasureLazyPolicy.measure.2(obj, subcomposeMeasureScope);
                            obj.overflow.setOverflowMeasurables-VKLhPVY$foundation_layout_release((FlowLineMeasurePolicy)obj, l, obj3);
                            horizontal = obj.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
                        }
                    } else {
                    }
                    return FlowLayoutKt.breakDownItems-di9J0FM((MeasureScope)subcomposeMeasureScope, (FlowLineMeasurePolicy)obj, (Iterator)contextualFlowItemIterator, obj.mainAxisSpacing, obj.crossAxisArrangementSpacing, OrientationIndependentConstraints.constructor-impl(l, obj3), obj14, obj.maxItemsInMainAxis, obj.maxLines);
                }
            }
        }
        return MeasureScope.layout$default((MeasureScope)subcomposeMeasureScope, 0, 0, 0, (Function1)FlowMeasureLazyPolicy.measure.1.INSTANCE, 4, 0);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public final boolean component1() {
        return this.isHorizontal;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public final androidx.compose.foundation.layout.Arrangement.Horizontal component2() {
        return this.horizontalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public final androidx.compose.foundation.layout.Arrangement.Vertical component3() {
        return this.verticalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public final androidx.compose.foundation.layout.CrossAxisAlignment component5() {
        return this.crossAxisAlignment;
    }

    public final androidx.compose.foundation.layout.FlowMeasureLazyPolicy copy-E4Q9ldg(boolean z, androidx.compose.foundation.layout.Arrangement.Horizontal arrangement$Horizontal2, androidx.compose.foundation.layout.Arrangement.Vertical arrangement$Vertical3, float f4, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment5, float f6, int i7, int i8, int i9, androidx.compose.foundation.layout.FlowLayoutOverflowState flowLayoutOverflowState10, List<? extends Function2<? super Composer, ? super Integer, Unit>> list11, Function4<? super Integer, ? super androidx.compose.foundation.layout.FlowLineInfo, ? super Composer, ? super Integer, Unit> function412) {
        FlowMeasureLazyPolicy flowMeasureLazyPolicy = new FlowMeasureLazyPolicy(z, horizontal2, vertical3, f4, crossAxisAlignment5, f6, i7, i8, i9, flowLayoutOverflowState10, list11, function412, 0);
        return flowMeasureLazyPolicy;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FlowMeasureLazyPolicy) {
            return i2;
        }
        Object obj = object;
        if (this.isHorizontal != obj.isHorizontal) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.horizontalArrangement, obj.horizontalArrangement)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.verticalArrangement, obj.verticalArrangement)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.mainAxisSpacing, obj.mainAxisSpacing)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.crossAxisAlignment, obj.crossAxisAlignment)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.crossAxisArrangementSpacing, obj.crossAxisArrangementSpacing)) {
            return i2;
        }
        if (this.itemCount != obj.itemCount) {
            return i2;
        }
        if (this.maxLines != obj.maxLines) {
            return i2;
        }
        if (this.maxItemsInMainAxis != obj.maxItemsInMainAxis) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.overflow, obj.overflow)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.overflowComposables, obj.overflowComposables)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.getComposable, obj.getComposable)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public androidx.compose.foundation.layout.CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public androidx.compose.foundation.layout.Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> getMeasurePolicy() {
        FlowMeasureLazyPolicy.getMeasurePolicy.1 anon = new FlowMeasureLazyPolicy.getMeasurePolicy.1(this);
        return (Function2)anon;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public androidx.compose.foundation.layout.Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public int hashCode() {
        return i22 += i34;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FlowMeasureLazyPolicy(isHorizontal=").append(this.isHorizontal).append(", horizontalArrangement=").append(this.horizontalArrangement).append(", verticalArrangement=").append(this.verticalArrangement).append(", mainAxisSpacing=").append(Dp.toString-impl(this.mainAxisSpacing)).append(", crossAxisAlignment=").append(this.crossAxisAlignment).append(", crossAxisArrangementSpacing=").append(Dp.toString-impl(this.crossAxisArrangementSpacing)).append(", itemCount=").append(this.itemCount).append(", maxLines=").append(this.maxLines).append(", maxItemsInMainAxis=").append(this.maxItemsInMainAxis).append(", overflow=").append(this.overflow).append(", overflowComposables=").append(this.overflowComposables).append(", getComposable=");
        stringBuilder.append(this.getComposable).append(')');
        return stringBuilder.toString();
    }
}
