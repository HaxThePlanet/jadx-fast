package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J`\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u00182\u0019\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\u0008\u001e2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\u0008\u001eH\u0016J\u0017\u0010!\u001a\u00020\u0015*\u00020\"H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$J\u0017\u0010!\u001a\u00020\u0015*\u00020%H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'J\u0017\u0010(\u001a\u00020\"*\u00020%H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*J\u001a\u0010(\u001a\u00020\"*\u00020\u0008H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J\u001a\u0010(\u001a\u00020\"*\u00020\u0015H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010-J\u0017\u0010.\u001a\u00020/*\u000200H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00081\u00102J\u0017\u00103\u001a\u00020\u0008*\u00020\"H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00084\u0010,J\u0017\u00103\u001a\u00020\u0008*\u00020%H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00085\u0010*J\r\u00106\u001a\u000207*\u000208H\u0097\u0001J\u0017\u00109\u001a\u000200*\u00020/H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008:\u00102J\u0017\u0010;\u001a\u00020%*\u00020\"H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J\u001a\u0010;\u001a\u00020%*\u00020\u0008H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008>\u0010=J\u001a\u0010;\u001a\u00020%*\u00020\u0015H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?R\u0014\u0010\u0007\u001a\u00020\u00088\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00088\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006@", d2 = {"Landroidx/compose/ui/layout/IntrinsicsMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasureScope", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/unit/LayoutDirection;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntrinsicsMeasureScope implements androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.IntrinsicMeasureScope {

    public static final int $stable;
    private final androidx.compose.ui.layout.IntrinsicMeasureScope $$delegate_0;
    private final LayoutDirection layoutDirection;
    static {
    }

    public IntrinsicsMeasureScope(androidx.compose.ui.layout.IntrinsicMeasureScope intrinsicMeasureScope, LayoutDirection layoutDirection) {
        super();
        this.layoutDirection = layoutDirection;
        this.$$delegate_0 = intrinsicMeasureScope;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public boolean isLookingAhead() {
        return this.$$delegate_0.isLookingAhead();
    }

    public androidx.compose.ui.layout.MeasureResult layout(int width, int height, Map<androidx.compose.ui.layout.AlignmentLine, Integer> alignmentLines, Function1<? super androidx.compose.ui.layout.RulerScope, Unit> rulers, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> placementBlock) {
        int i2;
        int i;
        int string;
        StringBuilder append;
        String str;
        i2 = 0;
        final int coerceAtLeast = RangesKt.coerceAtLeast(width, i2);
        final int coerceAtLeast2 = RangesKt.coerceAtLeast(height, i2);
        final int i3 = 0;
        i = -16777216;
        if (coerceAtLeast & i == 0 && i &= coerceAtLeast2 == 0) {
            if (i &= coerceAtLeast2 == 0) {
                i2 = 1;
            }
        }
        int i4 = 0;
        if (i2 == 0) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Size(").append(coerceAtLeast).append(" x ").append(coerceAtLeast2).append(") is out of range. Each dimension must be between 0 and 16777215.").toString());
        }
        IntrinsicsMeasureScope.layout.1 anon = new IntrinsicsMeasureScope.layout.1(coerceAtLeast, coerceAtLeast2, alignmentLines, rulers);
        return (MeasureResult)anon;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public int roundToPx--R2X_6o(long l) {
        return this.$$delegate_0.roundToPx--R2X_6o(l);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public int roundToPx-0680j_4(float f) {
        return this.$$delegate_0.roundToPx-0680j_4(f);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float toDp-GaN1DYA(long l) {
        return this.$$delegate_0.toDp-GaN1DYA(l);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float toDp-u2uoSUM(float f) {
        return this.$$delegate_0.toDp-u2uoSUM(f);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float toDp-u2uoSUM(int i) {
        return this.$$delegate_0.toDp-u2uoSUM(i);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public long toDpSize-k-rfVVM(long l) {
        return this.$$delegate_0.toDpSize-k-rfVVM(l);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float toPx--R2X_6o(long l) {
        return this.$$delegate_0.toPx--R2X_6o(l);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float toPx-0680j_4(float f) {
        return this.$$delegate_0.toPx-0680j_4(f);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public Rect toRect(DpRect dpRect) {
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public long toSize-XkaWNTQ(long l) {
        return this.$$delegate_0.toSize-XkaWNTQ(l);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public long toSp-0xMU5do(float f) {
        return this.$$delegate_0.toSp-0xMU5do(f);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public long toSp-kPz2Gy4(float f) {
        return this.$$delegate_0.toSp-kPz2Gy4(f);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public long toSp-kPz2Gy4(int i) {
        return this.$$delegate_0.toSp-kPz2Gy4(i);
    }
}
