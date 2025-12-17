package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u000b\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0015\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0016\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u001e\u0010\u0017\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a*\u0010\u001a\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u0011\u001a\u001e\u0010\u001e\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010\u0019\u001a*\u0010 \u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008$\u0010\u0019\u001a&\u0010\"\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)\u001a>\u0010*\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010+\u001a\u00020\u000e2\u0008\u0008\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001a\u001e\u0010/\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u0010\u0019\u001a*\u00101\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u0010\u0019\u001a&\u0010#\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\u00085\u0010)\u001a>\u00106\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010+\u001a\u00020\u000e2\u0008\u0008\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u00087\u0010.\u001a\u001e\u0010%\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u00088\u0010\u0019\u001a*\u00109\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008:\u0010\u0011\u001a \u0010;\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010@\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010<\u001a\u00020A2\u0008\u0008\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010B\u001a\u00020\u000c*\u00020\u000c2\u0008\u0008\u0002\u0010<\u001a\u00020C2\u0008\u0008\u0002\u0010>\u001a\u00020?H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006D", d2 = {"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillElement;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "defaultMinSize", "Landroidx/compose/ui/Modifier;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fraction", "", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", "min", "max", "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", "size", "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "Landroidx/compose/ui/unit/DpSize;", "requiredSize-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "requiredSizeIn", "maxWidth", "maxHeight", "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "size-6HolHcs", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "wrapContentSize", "Landroidx/compose/ui/Alignment;", "wrapContentWidth", "Landroidx/compose/ui/Alignment$Horizontal;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SizeKt {

    private static final androidx.compose.foundation.layout.FillElement FillWholeMaxHeight;
    private static final androidx.compose.foundation.layout.FillElement FillWholeMaxSize;
    private static final androidx.compose.foundation.layout.FillElement FillWholeMaxWidth;
    private static final androidx.compose.foundation.layout.WrapContentElement WrapContentHeightCenter;
    private static final androidx.compose.foundation.layout.WrapContentElement WrapContentHeightTop;
    private static final androidx.compose.foundation.layout.WrapContentElement WrapContentSizeCenter;
    private static final androidx.compose.foundation.layout.WrapContentElement WrapContentSizeTopStart;
    private static final androidx.compose.foundation.layout.WrapContentElement WrapContentWidthCenter;
    private static final androidx.compose.foundation.layout.WrapContentElement WrapContentWidthStart;
    static {
        int i = 1065353216;
        SizeKt.FillWholeMaxWidth = FillElement.Companion.width(i);
        SizeKt.FillWholeMaxHeight = FillElement.Companion.height(i);
        SizeKt.FillWholeMaxSize = FillElement.Companion.size(i);
        final int i2 = 0;
        SizeKt.WrapContentWidthCenter = WrapContentElement.Companion.width(Alignment.Companion.getCenterHorizontally(), i2);
        SizeKt.WrapContentWidthStart = WrapContentElement.Companion.width(Alignment.Companion.getStart(), i2);
        SizeKt.WrapContentHeightCenter = WrapContentElement.Companion.height(Alignment.Companion.getCenterVertically(), i2);
        SizeKt.WrapContentHeightTop = WrapContentElement.Companion.height(Alignment.Companion.getTop(), i2);
        SizeKt.WrapContentSizeCenter = WrapContentElement.Companion.size(Alignment.Companion.getCenter(), i2);
        SizeKt.WrapContentSizeTopStart = WrapContentElement.Companion.size(Alignment.Companion.getTopStart(), i2);
    }

    public static final Modifier defaultMinSize-VpY3zN4(Modifier $this$defaultMinSize_u2dVpY3zN4, float minWidth, float minHeight) {
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = new UnspecifiedConstraintsElement(minWidth, minHeight, 0);
        return $this$defaultMinSize_u2dVpY3zN4.then((Modifier)unspecifiedConstraintsElement);
    }

    public static Modifier defaultMinSize-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i4 &= 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return SizeKt.defaultMinSize-VpY3zN4(modifier, obj1, obj2);
    }

    public static final Modifier fillMaxHeight(Modifier $this$fillMaxHeight, float fraction) {
        int i;
        androidx.compose.foundation.layout.FillElement fillWholeMaxHeight;
        i = Float.compare(fraction, i2) == 0 ? 1 : 0;
        if (i != 0) {
            fillWholeMaxHeight = SizeKt.FillWholeMaxHeight;
        } else {
            fillWholeMaxHeight = FillElement.Companion.height(fraction);
        }
        return $this$fillMaxHeight.then((Modifier)fillWholeMaxHeight);
    }

    public static Modifier fillMaxHeight$default(Modifier modifier, float f2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 1065353216;
        }
        return SizeKt.fillMaxHeight(modifier, obj1);
    }

    public static final Modifier fillMaxSize(Modifier $this$fillMaxSize, float fraction) {
        int i;
        androidx.compose.foundation.layout.FillElement fillWholeMaxSize;
        i = Float.compare(fraction, i2) == 0 ? 1 : 0;
        if (i != 0) {
            fillWholeMaxSize = SizeKt.FillWholeMaxSize;
        } else {
            fillWholeMaxSize = FillElement.Companion.size(fraction);
        }
        return $this$fillMaxSize.then((Modifier)fillWholeMaxSize);
    }

    public static Modifier fillMaxSize$default(Modifier modifier, float f2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 1065353216;
        }
        return SizeKt.fillMaxSize(modifier, obj1);
    }

    public static final Modifier fillMaxWidth(Modifier $this$fillMaxWidth, float fraction) {
        int i;
        androidx.compose.foundation.layout.FillElement fillWholeMaxWidth;
        i = Float.compare(fraction, i2) == 0 ? 1 : 0;
        if (i != 0) {
            fillWholeMaxWidth = SizeKt.FillWholeMaxWidth;
        } else {
            fillWholeMaxWidth = FillElement.Companion.width(fraction);
        }
        return $this$fillMaxWidth.then((Modifier)fillWholeMaxWidth);
    }

    public static Modifier fillMaxWidth$default(Modifier modifier, float f2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 1065353216;
        }
        return SizeKt.fillMaxWidth(modifier, obj1);
    }

    public static final Modifier height-3ABfNKs(Modifier $this$height_u2d3ABfNKs, float height) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.height-3ABfNKs$$inlined.debugInspectorInfo.1(height);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(0, height, 0, height, 1, noInspectorInfo, 5, 0);
        return $this$height_u2d3ABfNKs.then((Modifier)sizeElement);
    }

    public static final Modifier heightIn-VpY3zN4(Modifier $this$heightIn_u2dVpY3zN4, float min, float max) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.heightIn-VpY3zN4$$inlined.debugInspectorInfo.1(min, max);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(0, min, 0, max, 1, noInspectorInfo, 5, 0);
        return $this$heightIn_u2dVpY3zN4.then((Modifier)sizeElement);
    }

    public static Modifier heightIn-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i4 &= 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return SizeKt.heightIn-VpY3zN4(modifier, obj1, obj2);
    }

    public static final Modifier requiredHeight-3ABfNKs(Modifier $this$requiredHeight_u2d3ABfNKs, float height) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.requiredHeight-3ABfNKs$$inlined.debugInspectorInfo.1(height);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(0, height, 0, height, 0, noInspectorInfo, 5, 0);
        return $this$requiredHeight_u2d3ABfNKs.then((Modifier)sizeElement);
    }

    public static final Modifier requiredHeightIn-VpY3zN4(Modifier $this$requiredHeightIn_u2dVpY3zN4, float min, float max) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.requiredHeightIn-VpY3zN4$$inlined.debugInspectorInfo.1(min, max);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(0, min, 0, max, 0, noInspectorInfo, 5, 0);
        return $this$requiredHeightIn_u2dVpY3zN4.then((Modifier)sizeElement);
    }

    public static Modifier requiredHeightIn-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i4 &= 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return SizeKt.requiredHeightIn-VpY3zN4(modifier, obj1, obj2);
    }

    public static final Modifier requiredSize-3ABfNKs(Modifier $this$requiredSize_u2d3ABfNKs, float size) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.requiredSize-3ABfNKs$$inlined.debugInspectorInfo.1(size);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(size, size, size, size, 0, noInspectorInfo, 0);
        return $this$requiredSize_u2d3ABfNKs.then((Modifier)sizeElement);
    }

    public static final Modifier requiredSize-6HolHcs(Modifier $this$requiredSize_u2d6HolHcs, long size) {
        return SizeKt.requiredSize-VpY3zN4($this$requiredSize_u2d6HolHcs, DpSize.getWidth-D9Ej5fM(size), DpSize.getHeight-D9Ej5fM(size));
    }

    public static final Modifier requiredSize-VpY3zN4(Modifier $this$requiredSize_u2dVpY3zN4, float width, float height) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.requiredSize-VpY3zN4$$inlined.debugInspectorInfo.1(width, height);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(width, height, width, height, 0, noInspectorInfo, 0);
        return $this$requiredSize_u2dVpY3zN4.then((Modifier)sizeElement);
    }

    public static final Modifier requiredSizeIn-qDBjuR0(Modifier $this$requiredSizeIn_u2dqDBjuR0, float minWidth, float minHeight, float maxWidth, float maxHeight) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.requiredSizeIn-qDBjuR0$$inlined.debugInspectorInfo.1(minWidth, minHeight, maxWidth, maxHeight);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(minWidth, minHeight, maxWidth, maxHeight, 0, noInspectorInfo, 0);
        return $this$requiredSizeIn_u2dqDBjuR0.then((Modifier)sizeElement);
    }

    public static Modifier requiredSizeIn-qDBjuR0$default(Modifier modifier, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        if (i6 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i6 & 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i6 & 4 != 0) {
            obj3 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i6 &= 8 != 0) {
            obj4 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return SizeKt.requiredSizeIn-qDBjuR0(modifier, obj1, obj2, obj3, obj4);
    }

    public static final Modifier requiredWidth-3ABfNKs(Modifier $this$requiredWidth_u2d3ABfNKs, float width) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.requiredWidth-3ABfNKs$$inlined.debugInspectorInfo.1(width);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(width, 0, width, 0, 0, noInspectorInfo, 10, 0);
        return $this$requiredWidth_u2d3ABfNKs.then((Modifier)sizeElement);
    }

    public static final Modifier requiredWidthIn-VpY3zN4(Modifier $this$requiredWidthIn_u2dVpY3zN4, float min, float max) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.requiredWidthIn-VpY3zN4$$inlined.debugInspectorInfo.1(min, max);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(min, 0, max, 0, 0, noInspectorInfo, 10, 0);
        return $this$requiredWidthIn_u2dVpY3zN4.then((Modifier)sizeElement);
    }

    public static Modifier requiredWidthIn-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i4 &= 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return SizeKt.requiredWidthIn-VpY3zN4(modifier, obj1, obj2);
    }

    public static final Modifier size-3ABfNKs(Modifier $this$size_u2d3ABfNKs, float size) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.size-3ABfNKs$$inlined.debugInspectorInfo.1(size);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(size, size, size, size, 1, noInspectorInfo, 0);
        return $this$size_u2d3ABfNKs.then((Modifier)sizeElement);
    }

    public static final Modifier size-6HolHcs(Modifier $this$size_u2d6HolHcs, long size) {
        return SizeKt.size-VpY3zN4($this$size_u2d6HolHcs, DpSize.getWidth-D9Ej5fM(size), DpSize.getHeight-D9Ej5fM(size));
    }

    public static final Modifier size-VpY3zN4(Modifier $this$size_u2dVpY3zN4, float width, float height) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.size-VpY3zN4$$inlined.debugInspectorInfo.1(width, height);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(width, height, width, height, 1, noInspectorInfo, 0);
        return $this$size_u2dVpY3zN4.then((Modifier)sizeElement);
    }

    public static final Modifier sizeIn-qDBjuR0(Modifier $this$sizeIn_u2dqDBjuR0, float minWidth, float minHeight, float maxWidth, float maxHeight) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.sizeIn-qDBjuR0$$inlined.debugInspectorInfo.1(minWidth, minHeight, maxWidth, maxHeight);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(minWidth, minHeight, maxWidth, maxHeight, 1, noInspectorInfo, 0);
        return $this$sizeIn_u2dqDBjuR0.then((Modifier)sizeElement);
    }

    public static Modifier sizeIn-qDBjuR0$default(Modifier modifier, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        if (i6 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i6 & 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i6 & 4 != 0) {
            obj3 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i6 &= 8 != 0) {
            obj4 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return SizeKt.sizeIn-qDBjuR0(modifier, obj1, obj2, obj3, obj4);
    }

    public static final Modifier width-3ABfNKs(Modifier $this$width_u2d3ABfNKs, float width) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.width-3ABfNKs$$inlined.debugInspectorInfo.1(width);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(width, 0, width, 0, 1, noInspectorInfo, 10, 0);
        return $this$width_u2d3ABfNKs.then((Modifier)sizeElement);
    }

    public static final Modifier widthIn-VpY3zN4(Modifier $this$widthIn_u2dVpY3zN4, float min, float max) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SizeKt.widthIn-VpY3zN4$$inlined.debugInspectorInfo.1(min, max);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SizeElement sizeElement = new SizeElement(min, 0, max, 0, 1, noInspectorInfo, 10, 0);
        return $this$widthIn_u2dVpY3zN4.then((Modifier)sizeElement);
    }

    public static Modifier widthIn-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i4 &= 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return SizeKt.widthIn-VpY3zN4(modifier, obj1, obj2);
    }

    public static final Modifier wrapContentHeight(Modifier $this$wrapContentHeight, Alignment.Vertical align, boolean unbounded) {
        androidx.compose.foundation.layout.WrapContentElement wrapContentHeightTop;
        if (Intrinsics.areEqual(align, Alignment.Companion.getCenterVertically()) && !unbounded) {
            if (!unbounded) {
                wrapContentHeightTop = SizeKt.WrapContentHeightCenter;
            } else {
                if (Intrinsics.areEqual(align, Alignment.Companion.getTop()) && !unbounded) {
                    if (!unbounded) {
                        wrapContentHeightTop = SizeKt.WrapContentHeightTop;
                    } else {
                        wrapContentHeightTop = WrapContentElement.Companion.height(align, unbounded);
                    }
                } else {
                }
            }
        } else {
        }
        return $this$wrapContentHeight.then((Modifier)wrapContentHeightTop);
    }

    public static Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical alignment$Vertical2, boolean z3, int i4, Object object5) {
        Alignment.Vertical obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = Alignment.Companion.getCenterVertically();
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return SizeKt.wrapContentHeight(modifier, obj1, obj2);
    }

    public static final Modifier wrapContentSize(Modifier $this$wrapContentSize, Alignment align, boolean unbounded) {
        androidx.compose.foundation.layout.WrapContentElement wrapContentSizeTopStart;
        if (Intrinsics.areEqual(align, Alignment.Companion.getCenter()) && !unbounded) {
            if (!unbounded) {
                wrapContentSizeTopStart = SizeKt.WrapContentSizeCenter;
            } else {
                if (Intrinsics.areEqual(align, Alignment.Companion.getTopStart()) && !unbounded) {
                    if (!unbounded) {
                        wrapContentSizeTopStart = SizeKt.WrapContentSizeTopStart;
                    } else {
                        wrapContentSizeTopStart = WrapContentElement.Companion.size(align, unbounded);
                    }
                } else {
                }
            }
        } else {
        }
        return $this$wrapContentSize.then((Modifier)wrapContentSizeTopStart);
    }

    public static Modifier wrapContentSize$default(Modifier modifier, Alignment alignment2, boolean z3, int i4, Object object5) {
        Alignment obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = Alignment.Companion.getCenter();
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return SizeKt.wrapContentSize(modifier, obj1, obj2);
    }

    public static final Modifier wrapContentWidth(Modifier $this$wrapContentWidth, Alignment.Horizontal align, boolean unbounded) {
        androidx.compose.foundation.layout.WrapContentElement wrapContentWidthStart;
        if (Intrinsics.areEqual(align, Alignment.Companion.getCenterHorizontally()) && !unbounded) {
            if (!unbounded) {
                wrapContentWidthStart = SizeKt.WrapContentWidthCenter;
            } else {
                if (Intrinsics.areEqual(align, Alignment.Companion.getStart()) && !unbounded) {
                    if (!unbounded) {
                        wrapContentWidthStart = SizeKt.WrapContentWidthStart;
                    } else {
                        wrapContentWidthStart = WrapContentElement.Companion.width(align, unbounded);
                    }
                } else {
                }
            }
        } else {
        }
        return $this$wrapContentWidth.then((Modifier)wrapContentWidthStart);
    }

    public static Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal alignment$Horizontal2, boolean z3, int i4, Object object5) {
        Alignment.Horizontal obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = Alignment.Companion.getCenterHorizontally();
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return SizeKt.wrapContentWidth(modifier, obj1, obj2);
    }
}
