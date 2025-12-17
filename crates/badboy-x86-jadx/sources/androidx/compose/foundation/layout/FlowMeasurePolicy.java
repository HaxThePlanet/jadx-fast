package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0082\u0008\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0008HÆ\u0003J\u0016\u0010+\u001a\u00020\nHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-J\t\u0010.\u001a\u00020\u000cHÆ\u0003J\u0016\u0010/\u001a\u00020\nHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00080\u0010-J\t\u00101\u001a\u00020\u000fHÂ\u0003J\t\u00102\u001a\u00020\u000fHÂ\u0003J\t\u00103\u001a\u00020\u0012HÂ\u0003Jm\u00104\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u00085\u00106J\u0013\u00107\u001a\u00020\u00042\u0008\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000fHÖ\u0001JD\u0010;\u001a\u00020\u000f2\u000c\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010@\u001a\u00020\u000f2\u000c\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fJD\u0010C\u001a\u00020\u000f2\u000c\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010E\u001a\u00020FHÖ\u0001J(\u0010G\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010I\u001a\u00020\u000fH\u0016J(\u0010J\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010A\u001a\u00020\u000fH\u0016J2\u0010K\u001a\u00020L*\u00020M2\u0012\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020N0=0=2\u0006\u0010O\u001a\u00020PH\u0016ø\u0001\u0000¢\u0006\u0004\u0008Q\u0010RJ(\u0010S\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010I\u001a\u00020\u000fH\u0016J(\u0010T\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010A\u001a\u00020\u000fH\u0016R\u0014\u0010\u000b\u001a\u00020\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0016\u0010\r\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0019R\u0016\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R.\u0010\u001a\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010 \u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u001fR.\u0010\"\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001fR.\u0010$\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006U", d2 = {"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "maxItemsInMainAxis", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "F", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "()Z", "maxCrossAxisIntrinsicItemSize", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "Lkotlin/ExtensionFunctionType;", "getMaxCrossAxisIntrinsicItemSize", "()Lkotlin/jvm/functions/Function3;", "maxMainAxisIntrinsicItemSize", "getMaxMainAxisIntrinsicItemSize", "minCrossAxisIntrinsicItemSize", "getMinCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "getMinMainAxisIntrinsicItemSize", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-QuyCDyQ", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "equals", "other", "", "hashCode", "intrinsicCrossAxisSize", "measurables", "", "mainAxisAvailable", "crossAxisSpacing", "maxIntrinsicMainAxisSize", "height", "arrangementSpacing", "minIntrinsicMainAxisSize", "crossAxisAvailable", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FlowMeasurePolicy implements MultiContentMeasurePolicy, androidx.compose.foundation.layout.FlowLineMeasurePolicy {

    private final androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final float mainAxisSpacing;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;
    private final androidx.compose.foundation.layout.FlowLayoutOverflowState overflow;
    private final androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement;
    private FlowMeasurePolicy(boolean isHorizontal, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, float mainAxisSpacing, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment, float crossAxisArrangementSpacing, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        kotlin.jvm.internal.Lambda iNSTANCE4;
        kotlin.jvm.internal.Lambda iNSTANCE2;
        kotlin.jvm.internal.Lambda iNSTANCE3;
        kotlin.jvm.internal.Lambda iNSTANCE;
        super();
        this.isHorizontal = isHorizontal;
        this.horizontalArrangement = horizontalArrangement;
        this.verticalArrangement = verticalArrangement;
        this.mainAxisSpacing = mainAxisSpacing;
        this.crossAxisAlignment = crossAxisAlignment;
        this.crossAxisArrangementSpacing = crossAxisArrangementSpacing;
        this.maxItemsInMainAxis = maxItemsInMainAxis;
        this.maxLines = maxLines;
        this.overflow = overflow;
        if (isHorizontal()) {
            iNSTANCE4 = FlowMeasurePolicy.maxMainAxisIntrinsicItemSize.1.INSTANCE;
        } else {
            iNSTANCE4 = FlowMeasurePolicy.maxMainAxisIntrinsicItemSize.2.INSTANCE;
        }
        this.maxMainAxisIntrinsicItemSize = iNSTANCE4;
        if (isHorizontal()) {
            iNSTANCE2 = FlowMeasurePolicy.maxCrossAxisIntrinsicItemSize.1.INSTANCE;
        } else {
            iNSTANCE2 = FlowMeasurePolicy.maxCrossAxisIntrinsicItemSize.2.INSTANCE;
        }
        this.maxCrossAxisIntrinsicItemSize = iNSTANCE2;
        if (isHorizontal()) {
            iNSTANCE3 = FlowMeasurePolicy.minCrossAxisIntrinsicItemSize.1.INSTANCE;
        } else {
            iNSTANCE3 = FlowMeasurePolicy.minCrossAxisIntrinsicItemSize.2.INSTANCE;
        }
        this.minCrossAxisIntrinsicItemSize = iNSTANCE3;
        if (isHorizontal()) {
            iNSTANCE = FlowMeasurePolicy.minMainAxisIntrinsicItemSize.1.INSTANCE;
        } else {
            iNSTANCE = FlowMeasurePolicy.minMainAxisIntrinsicItemSize.2.INSTANCE;
        }
        this.minMainAxisIntrinsicItemSize = iNSTANCE;
    }

    public FlowMeasurePolicy(boolean z, androidx.compose.foundation.layout.Arrangement.Horizontal arrangement$Horizontal2, androidx.compose.foundation.layout.Arrangement.Vertical arrangement$Vertical3, float f4, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment5, float f6, int i7, int i8, androidx.compose.foundation.layout.FlowLayoutOverflowState flowLayoutOverflowState9, DefaultConstructorMarker defaultConstructorMarker10) {
        super(z, horizontal2, vertical3, f4, crossAxisAlignment5, f6, i7, i8, flowLayoutOverflowState9);
    }

    private final float component4-D9Ej5fM() {
        return this.mainAxisSpacing;
    }

    private final float component6-D9Ej5fM() {
        return this.crossAxisArrangementSpacing;
    }

    private final int component7() {
        return this.maxItemsInMainAxis;
    }

    private final int component8() {
        return this.maxLines;
    }

    private final androidx.compose.foundation.layout.FlowLayoutOverflowState component9() {
        return this.overflow;
    }

    public static androidx.compose.foundation.layout.FlowMeasurePolicy copy-QuyCDyQ$default(androidx.compose.foundation.layout.FlowMeasurePolicy flowMeasurePolicy, boolean z2, androidx.compose.foundation.layout.Arrangement.Horizontal arrangement$Horizontal3, androidx.compose.foundation.layout.Arrangement.Vertical arrangement$Vertical4, float f5, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment6, float f7, int i8, int i9, androidx.compose.foundation.layout.FlowLayoutOverflowState flowLayoutOverflowState10, int i11, Object object12) {
        boolean obj1;
        androidx.compose.foundation.layout.Arrangement.Horizontal obj2;
        androidx.compose.foundation.layout.Arrangement.Vertical obj3;
        float obj4;
        androidx.compose.foundation.layout.CrossAxisAlignment obj5;
        float obj6;
        int obj7;
        int obj8;
        androidx.compose.foundation.layout.FlowLayoutOverflowState obj9;
        if (i11 & 1 != 0) {
            obj1 = flowMeasurePolicy.isHorizontal;
        }
        if (i11 & 2 != 0) {
            obj2 = flowMeasurePolicy.horizontalArrangement;
        }
        if (i11 & 4 != 0) {
            obj3 = flowMeasurePolicy.verticalArrangement;
        }
        if (i11 & 8 != 0) {
            obj4 = flowMeasurePolicy.mainAxisSpacing;
        }
        if (i11 & 16 != 0) {
            obj5 = flowMeasurePolicy.crossAxisAlignment;
        }
        if (i11 & 32 != 0) {
            obj6 = flowMeasurePolicy.crossAxisArrangementSpacing;
        }
        if (i11 & 64 != 0) {
            obj7 = flowMeasurePolicy.maxItemsInMainAxis;
        }
        if (i11 & 128 != 0) {
            obj8 = flowMeasurePolicy.maxLines;
        }
        if (i11 &= 256 != 0) {
            obj9 = flowMeasurePolicy.overflow;
        }
        return flowMeasurePolicy.copy-QuyCDyQ(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final boolean component1() {
        return this.isHorizontal;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final androidx.compose.foundation.layout.Arrangement.Horizontal component2() {
        return this.horizontalArrangement;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final androidx.compose.foundation.layout.Arrangement.Vertical component3() {
        return this.verticalArrangement;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final androidx.compose.foundation.layout.CrossAxisAlignment component5() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final androidx.compose.foundation.layout.FlowMeasurePolicy copy-QuyCDyQ(boolean z, androidx.compose.foundation.layout.Arrangement.Horizontal arrangement$Horizontal2, androidx.compose.foundation.layout.Arrangement.Vertical arrangement$Vertical3, float f4, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment5, float f6, int i7, int i8, androidx.compose.foundation.layout.FlowLayoutOverflowState flowLayoutOverflowState9) {
        FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(z, horizontal2, vertical3, f4, crossAxisAlignment5, f6, i7, i8, flowLayoutOverflowState9, 0);
        return flowMeasurePolicy;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FlowMeasurePolicy) {
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
        if (this.maxItemsInMainAxis != obj.maxItemsInMainAxis) {
            return i2;
        }
        if (this.maxLines != obj.maxLines) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.overflow, obj.overflow)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public androidx.compose.foundation.layout.CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public androidx.compose.foundation.layout.Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
        return this.maxCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
        return this.maxMainAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
        return this.minCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
        return this.minMainAxisIntrinsicItemSize;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public androidx.compose.foundation.layout.Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int hashCode() {
        return i8 += i25;
    }

    public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> measurables, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        final Function3 minCrossAxisIntrinsicItemSize = this.minCrossAxisIntrinsicItemSize;
        return IntIntPair.getFirst-impl(FlowLayoutKt.access$intrinsicCrossAxisSize(measurables, this.minMainAxisIntrinsicItemSize, minCrossAxisIntrinsicItemSize, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow));
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width) {
        Object firstOrNull3;
        Object firstOrNull2;
        int intrinsicCrossAxisSize;
        int firstOrNull;
        int roundToPx-0680j_4;
        int firstOrNull4;
        int horizontal;
        int maxItemsInMainAxis;
        int maxLines;
        androidx.compose.foundation.layout.FlowLayoutOverflowState overflow;
        int i;
        final Object obj = this;
        final Object obj2 = $this$maxIntrinsicHeight;
        final List list = measurables;
        Object orNull = CollectionsKt.getOrNull(list, 1);
        if ((List)orNull != null) {
            firstOrNull = CollectionsKt.firstOrNull((List)orNull);
        } else {
            firstOrNull = firstOrNull4;
        }
        Object orNull2 = CollectionsKt.getOrNull(list, 2);
        if ((List)orNull2 != null) {
            firstOrNull4 = CollectionsKt.firstOrNull((List)orNull2);
        }
        obj.overflow.setOverflowMeasurables--hBUhpc$foundation_layout_release(firstOrNull, firstOrNull4, obj.isHorizontal(), ConstraintsKt.Constraints$default(0, width, 0, 0, 13, 0));
        if (obj.isHorizontal()) {
            if ((List)CollectionsKt.firstOrNull(list) == null) {
                firstOrNull3 = CollectionsKt.emptyList();
            }
            intrinsicCrossAxisSize = obj.intrinsicCrossAxisSize(firstOrNull3, width, obj2.roundToPx-0680j_4(obj.mainAxisSpacing), obj2.roundToPx-0680j_4(obj.crossAxisArrangementSpacing), obj.maxItemsInMainAxis, obj.maxLines, obj.overflow);
            i = width;
        } else {
            if ((List)CollectionsKt.firstOrNull(list) == null) {
                firstOrNull2 = CollectionsKt.emptyList();
            }
            intrinsicCrossAxisSize = obj.maxIntrinsicMainAxisSize(firstOrNull2, width, obj2.roundToPx-0680j_4(obj.mainAxisSpacing));
        }
        return intrinsicCrossAxisSize;
    }

    public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int height, int arrangementSpacing) {
        return FlowLayoutKt.access$maxIntrinsicMainAxisSize(measurables, this.maxMainAxisIntrinsicItemSize, height, arrangementSpacing, this.maxItemsInMainAxis);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height) {
        Object firstOrNull;
        Object firstOrNull4;
        int maxIntrinsicMainAxisSize;
        int firstOrNull3;
        int roundToPx-0680j_4;
        int firstOrNull2;
        boolean horizontal;
        long maxItemsInMainAxis;
        int maxLines;
        androidx.compose.foundation.layout.FlowLayoutOverflowState overflow;
        int i;
        final Object obj = this;
        final Object obj2 = $this$maxIntrinsicWidth;
        final List list = measurables;
        Object orNull = CollectionsKt.getOrNull(list, 1);
        if ((List)orNull != null) {
            firstOrNull3 = CollectionsKt.firstOrNull((List)orNull);
        } else {
            firstOrNull3 = firstOrNull2;
        }
        Object orNull2 = CollectionsKt.getOrNull(list, 2);
        if ((List)orNull2 != null) {
            firstOrNull2 = CollectionsKt.firstOrNull((List)orNull2);
        }
        obj.overflow.setOverflowMeasurables--hBUhpc$foundation_layout_release(firstOrNull3, firstOrNull2, obj.isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, height, 7, 0));
        if (obj.isHorizontal()) {
            if ((List)CollectionsKt.firstOrNull(list) == null) {
                firstOrNull = CollectionsKt.emptyList();
            }
            maxIntrinsicMainAxisSize = obj.maxIntrinsicMainAxisSize(firstOrNull, height, obj2.roundToPx-0680j_4(obj.mainAxisSpacing));
        } else {
            if ((List)CollectionsKt.firstOrNull(list) == null) {
                firstOrNull4 = CollectionsKt.emptyList();
            }
            maxIntrinsicMainAxisSize = obj.intrinsicCrossAxisSize(firstOrNull4, height, obj2.roundToPx-0680j_4(obj.mainAxisSpacing), obj2.roundToPx-0680j_4(obj.crossAxisArrangementSpacing), obj.maxItemsInMainAxis, obj.maxLines, obj.overflow);
        }
        return maxIntrinsicMainAxisSize;
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends List<? extends Measurable>> measurables, long constraints) {
        int maxItemsInMainAxis;
        androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType visible;
        Object firstOrNull2;
        Object firstOrNull;
        int i;
        androidx.compose.foundation.layout.LayoutOrientation horizontal;
        final List list = measurables;
        if (this.maxLines != 0 && this.maxItemsInMainAxis != 0 && !list.isEmpty()) {
            if (this.maxItemsInMainAxis != 0) {
                if (!list.isEmpty()) {
                    if (Constraints.getMaxHeight-impl(constraints) == 0 && this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible) {
                        if (this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible) {
                        } else {
                            Object first = CollectionsKt.first(list);
                            if ((List)first.isEmpty()) {
                                return MeasureScope.layout$default($this$measure_u2d3p2s80s, 0, 0, 0, (Function1)FlowMeasurePolicy.measure.2.INSTANCE, 4, 0);
                            }
                            Object orNull = CollectionsKt.getOrNull(list, 1);
                            if ((List)orNull != null) {
                                firstOrNull2 = CollectionsKt.firstOrNull((List)orNull);
                            } else {
                                firstOrNull2 = i;
                            }
                            Object obj4 = firstOrNull2;
                            firstOrNull = CollectionsKt.getOrNull(list, 2);
                            if ((List)firstOrNull != null) {
                                i = firstOrNull;
                            }
                            int i10 = i;
                            this.overflow.setItemCount$foundation_layout_release(first.size());
                            this.overflow.setOverflowMeasurables--hBUhpc$foundation_layout_release((FlowLineMeasurePolicy)this, obj4, i10, constraints);
                            Object obj = obj4;
                            final int i15 = i10;
                            horizontal = isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
                        }
                    } else {
                    }
                    return FlowLayoutKt.breakDownItems-di9J0FM($this$measure_u2d3p2s80s, (FlowLineMeasurePolicy)this, first.iterator(), this.mainAxisSpacing, this.crossAxisArrangementSpacing, OrientationIndependentConstraints.constructor-impl(constraints, obj9), obj9, this.maxItemsInMainAxis, this.maxLines);
                }
            }
        }
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, 0, 0, 0, (Function1)FlowMeasurePolicy.measure.1.INSTANCE, 4, 0);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width) {
        Object firstOrNull;
        Object firstOrNull3;
        int intrinsicCrossAxisSize;
        int firstOrNull2;
        int i;
        int firstOrNull4;
        int roundToPx-0680j_4;
        int roundToPx-0680j_42;
        int maxItemsInMainAxis;
        int maxLines;
        androidx.compose.foundation.layout.FlowLayoutOverflowState overflow;
        final Object obj = this;
        final Object obj2 = $this$minIntrinsicHeight;
        final List list = measurables;
        Object orNull = CollectionsKt.getOrNull(list, 1);
        if ((List)orNull != null) {
            firstOrNull2 = CollectionsKt.firstOrNull((List)orNull);
        } else {
            firstOrNull2 = firstOrNull4;
        }
        Object orNull2 = CollectionsKt.getOrNull(list, 2);
        if ((List)orNull2 != null) {
            firstOrNull4 = CollectionsKt.firstOrNull((List)orNull2);
        }
        obj.overflow.setOverflowMeasurables--hBUhpc$foundation_layout_release(firstOrNull2, firstOrNull4, obj.isHorizontal(), ConstraintsKt.Constraints$default(0, width, 0, 0, 13, 0));
        if (obj.isHorizontal()) {
            if ((List)CollectionsKt.firstOrNull(list) == null) {
                firstOrNull = CollectionsKt.emptyList();
            }
            intrinsicCrossAxisSize = obj.intrinsicCrossAxisSize(firstOrNull, width, obj2.roundToPx-0680j_4(obj.mainAxisSpacing), obj2.roundToPx-0680j_4(obj.crossAxisArrangementSpacing), obj.maxItemsInMainAxis, obj.maxLines, obj.overflow);
        } else {
            if ((List)CollectionsKt.firstOrNull(list) == null) {
                firstOrNull3 = CollectionsKt.emptyList();
            }
            intrinsicCrossAxisSize = obj.minIntrinsicMainAxisSize(firstOrNull3, width, obj2.roundToPx-0680j_4(obj.mainAxisSpacing), obj2.roundToPx-0680j_4(obj.crossAxisArrangementSpacing), obj.maxItemsInMainAxis, obj.maxLines, obj.overflow);
        }
        return intrinsicCrossAxisSize;
    }

    public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        return FlowLayoutKt.access$minIntrinsicMainAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, crossAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height) {
        Object firstOrNull;
        Object firstOrNull4;
        int minIntrinsicMainAxisSize;
        int firstOrNull3;
        int i;
        int firstOrNull2;
        int roundToPx-0680j_4;
        int roundToPx-0680j_42;
        int maxItemsInMainAxis;
        int maxLines;
        androidx.compose.foundation.layout.FlowLayoutOverflowState overflow;
        final Object obj = this;
        final Object obj2 = $this$minIntrinsicWidth;
        final List list = measurables;
        Object orNull = CollectionsKt.getOrNull(list, 1);
        if ((List)orNull != null) {
            firstOrNull3 = CollectionsKt.firstOrNull((List)orNull);
        } else {
            firstOrNull3 = firstOrNull2;
        }
        Object orNull2 = CollectionsKt.getOrNull(list, 2);
        if ((List)orNull2 != null) {
            firstOrNull2 = CollectionsKt.firstOrNull((List)orNull2);
        }
        obj.overflow.setOverflowMeasurables--hBUhpc$foundation_layout_release(firstOrNull3, firstOrNull2, obj.isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, height, 7, 0));
        if (obj.isHorizontal()) {
            if ((List)CollectionsKt.firstOrNull(list) == null) {
                firstOrNull = CollectionsKt.emptyList();
            }
            minIntrinsicMainAxisSize = obj.minIntrinsicMainAxisSize(firstOrNull, height, obj2.roundToPx-0680j_4(obj.mainAxisSpacing), obj2.roundToPx-0680j_4(obj.crossAxisArrangementSpacing), obj.maxItemsInMainAxis, obj.maxLines, obj.overflow);
        } else {
            if ((List)CollectionsKt.firstOrNull(list) == null) {
                firstOrNull4 = CollectionsKt.emptyList();
            }
            minIntrinsicMainAxisSize = obj.intrinsicCrossAxisSize(firstOrNull4, height, obj2.roundToPx-0680j_4(obj.mainAxisSpacing), obj2.roundToPx-0680j_4(obj.crossAxisArrangementSpacing), obj.maxItemsInMainAxis, obj.maxLines, obj.overflow);
        }
        return minIntrinsicMainAxisSize;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FlowMeasurePolicy(isHorizontal=").append(this.isHorizontal).append(", horizontalArrangement=").append(this.horizontalArrangement).append(", verticalArrangement=").append(this.verticalArrangement).append(", mainAxisSpacing=").append(Dp.toString-impl(this.mainAxisSpacing)).append(", crossAxisAlignment=").append(this.crossAxisAlignment).append(", crossAxisArrangementSpacing=").append(Dp.toString-impl(this.crossAxisArrangementSpacing)).append(", maxItemsInMainAxis=").append(this.maxItemsInMainAxis).append(", maxLines=").append(this.maxLines).append(", overflow=").append(this.overflow).append(')').toString();
    }
}
