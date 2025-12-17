package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Collection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ3\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010!J\u0096\u0001\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u0017\u001a\u00020\r2!\u0008\u0002\u0010\"\u001a\u001b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0012\u0018\u00010#¢\u0006\u0002\u0008&2%\u0008\u0002\u0010'\u001a\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\u0008&2\u0008\u0008\u0002\u0010*\u001a\u00020\u00042\u0008\u0008\u0002\u0010+\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-J3\u0010\u001e\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00100J3\u0010\u001e\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00103J\u0096\u0001\u0010\u001e\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u0017\u001a\u00020\r2!\u0008\u0002\u0010\"\u001a\u001b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0012\u0018\u00010#¢\u0006\u0002\u0008&2%\u0008\u0002\u0010'\u001a\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\u0008&2\u0008\u0008\u0002\u0010*\u001a\u00020\u00042\u0008\u0008\u0002\u0010+\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008,\u00104J\r\u0010\u0017\u001a\u00020\rH\u0007¢\u0006\u0002\u00105Jv\u0010\u0017\u001a\u00020\r2\u0008\u0008\u0002\u00106\u001a\u00020)2\u0008\u0008\u0002\u00107\u001a\u00020)2\u0008\u0008\u0002\u00108\u001a\u00020)2\u0008\u0008\u0002\u00109\u001a\u00020)2\u0008\u0008\u0002\u0010:\u001a\u00020)2\u0008\u0008\u0002\u0010;\u001a\u00020)2\u0008\u0008\u0002\u0010<\u001a\u00020)2\u0008\u0008\u0002\u0010=\u001a\u00020)2\u0008\u0008\u0002\u0010>\u001a\u00020)2\u0008\u0008\u0002\u0010?\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\u0008@\u0010AJ2\u0010\"\u001a\u00020\u00122\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\u0008F\u0010GJÄ\u0001\u0010H\u001a\u00020\u0012*\u00020$2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020L2\u0006\u00109\u001a\u00020)2\u0006\u00107\u001a\u00020)2\u0006\u0010:\u001a\u00020)2\u0006\u00108\u001a\u00020)2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u001f\u0010\"\u001a\u001b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0012\u0018\u00010#¢\u0006\u0002\u0008&2#\u0010'\u001a\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\u0008&2\u0006\u0010Q\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008R\u0010SJ>\u0010T\u001a\u00020\u0012*\u00020$2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020U2\u0006\u0010E\u001a\u00020)2\u0006\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020LH\u0002ø\u0001\u0000¢\u0006\u0004\u0008X\u0010YR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000c\u001a\u00020\r*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Z", d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "TickSize", "Landroidx/compose/ui/unit/Dp;", "getTickSize-D9Ej5fM", "()F", "F", "TrackStopIndicatorSize", "getTrackStopIndicatorSize-D9Ej5fM", "trackPath", "Landroidx/compose/ui/graphics/Path;", "defaultSliderColors", "Landroidx/compose/material3/SliderColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "drawTick", "Lkotlin/Function3;", "Landroidx/compose/ui/graphics/Color;", "thumbTrackGapSize", "trackInsideCornerSize", "Track-4EFweAY", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "drawScope", "offset", "size", "color", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "drawTrack", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "height", "startThumbWidth", "endThumbWidth", "isRangeSlider", "drawTrack-ngJ0SCU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Z)V", "drawTrackPath", "Landroidx/compose/ui/geometry/Size;", "startCornerRadius", "endCornerRadius", "drawTrackPath-Cx2C_VA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJJFF)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SliderDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.SliderDefaults INSTANCE;
    private static final float TickSize;
    private static final float TrackStopIndicatorSize;
    private static final Path trackPath;
    static {
        SliderDefaults sliderDefaults = new SliderDefaults();
        SliderDefaults.INSTANCE = sliderDefaults;
        SliderDefaults.TrackStopIndicatorSize = SliderTokens.INSTANCE.getStopIndicatorSize-D9Ej5fM();
        SliderDefaults.TickSize = SliderTokens.INSTANCE.getStopIndicatorSize-D9Ej5fM();
        SliderDefaults.trackPath = AndroidPath_androidKt.Path();
    }

    public static final void access$drawStopIndicator-x3O1jOs(androidx.compose.material3.SliderDefaults $this, DrawScope drawScope, long offset, float size, long color) {
        $this.drawStopIndicator-x3O1jOs(drawScope, offset, size, color);
    }

    public static final void access$drawTrack-ngJ0SCU(androidx.compose.material3.SliderDefaults $this, DrawScope $receiver, float[] tickFractions, float activeRangeStart, float activeRangeEnd, long inactiveTrackColor, long activeTrackColor, long inactiveTickColor, long activeTickColor, float height, float startThumbWidth, float endThumbWidth, float thumbTrackGapSize, float trackInsideCornerSize, Function2 drawStopIndicator, Function3 drawTick, boolean isRangeSlider) {
        $this.drawTrack-ngJ0SCU($receiver, tickFractions, activeRangeStart, activeRangeEnd, inactiveTrackColor, activeTrackColor, inactiveTickColor, activeTickColor, height, startThumbWidth, endThumbWidth, thumbTrackGapSize, trackInsideCornerSize, drawStopIndicator, drawTick, isRangeSlider);
    }

    private final void drawStopIndicator-x3O1jOs(DrawScope drawScope, long offset, float size, long color) {
        final Object obj = drawScope;
        final int i9 = 0;
        final int i = 1073741824;
        DrawScope.drawCircle-VaOC9Bg$default(obj, obj19, i, px-0680j_4 / i, offset, obj5, 0, 0, 0, 0);
    }

    private final void drawTrack-ngJ0SCU(DrawScope $this$drawTrack_u2dngJ0SCU, float[] tickFractions, float activeRangeStart, float activeRangeEnd, long inactiveTrackColor, long activeTrackColor, long inactiveTickColor, long activeTickColor, float height, float startThumbWidth, float endThumbWidth, float thumbTrackGapSize, float trackInsideCornerSize, Function2<? super DrawScope, ? super Offset, Unit> drawStopIndicator, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> drawTick, boolean isRangeSlider) {
        Offset box-impl;
        Offset start;
        int activeTrackStart;
        ClosedFloatingPointRange rangeTo;
        Object tickStartGap;
        long trackStrokeWidth2;
        long i11;
        int i8;
        int cmp;
        long contains;
        float box-impl2;
        long f;
        int startGap;
        int endGap;
        float f2;
        int $this$forEachIndexed$iv;
        int i5;
        float cornerSize3;
        int i7;
        int startCornerRadius;
        int cmp2;
        float cornerSize;
        float trackStrokeWidth;
        float f3;
        int i4;
        int activeTrackStart2;
        int i13;
        float x-impl;
        int i10;
        long l;
        int cornerSize2;
        int valueOf;
        int i;
        int i6;
        ClosedFloatingPointRange tick;
        int i2;
        int i12;
        int i9;
        int i3;
        long center;
        long l2;
        Object obj2;
        final DrawScope drawScope = $this$drawTrack_u2dngJ0SCU;
        float f5 = isRangeSlider;
        final Object obj = obj62;
        final long l6 = OffsetKt.Offset(0, Offset.getY-impl(drawScope.getCenter-F1C5BW0()));
        final long l7 = OffsetKt.Offset(Size.getWidth-impl(drawScope.getSize-NH-jbRc()), Offset.getY-impl(drawScope.getCenter-F1C5BW0()));
        trackStrokeWidth2 = drawScope.toPx-0680j_4(trackInsideCornerSize);
        float x-impl17 = Offset.getX-impl(l6);
        final long l8 = l3;
        float x-impl18 = Offset.getX-impl(l6);
        final long l9 = l4;
        box-impl2 = (float)i27;
        cornerSize3 = trackStrokeWidth2 / box-impl2;
        cornerSize = drawScope.toPx-0680j_4(obj61);
        int i40 = 0;
        if (Dp.compareTo-0680j_4(f5, Dp.constructor-impl((float)i36)) > 0) {
            i4 = startGap;
            i13 = endGap;
        } else {
            f3 = drawStopIndicator;
            f2 = drawTick;
            i4 = startGap;
            i13 = endGap;
        }
        if (obj64 != null && Float.compare(x-impl13, startGap) > 0) {
            if (Float.compare(x-impl13, startGap) > 0) {
                x-impl = Offset.getX-impl(l6);
                startGap = Offset.Companion.getZero-F1C5BW0();
                box-impl2 = i10 - x-impl;
                trackStrokeWidth = trackStrokeWidth2;
                this.drawTrackPath-Cx2C_VA(drawScope, startGap, box-impl2, SizeKt.Size(box-impl2, trackStrokeWidth2), startGap, inactiveTrackColor);
                if (obj != null) {
                    obj.invoke(drawScope, Offset.box-impl(OffsetKt.Offset(x-impl + cornerSize3, Offset.getY-impl(drawScope.getCenter-F1C5BW0()))));
                }
            } else {
                trackStrokeWidth = trackStrokeWidth2;
            }
        } else {
        }
        if (Float.compare(x-impl2, i11) < 0) {
            x-impl3 += i13;
            x-impl = Offset.getX-impl(l7);
            box-impl2 = OffsetKt.Offset(i14, 0);
            startGap = SizeKt.Size(x-impl - i14, trackStrokeWidth);
            int insideCornerSize = cornerSize3;
            cornerSize3 = f4;
            i10 = i14;
            this.drawTrackPath-Cx2C_VA(drawScope, box-impl2, box-impl2, startGap, startGap, inactiveTrackColor);
            cornerSize = cornerSize3;
            if (obj != null) {
                obj.invoke(drawScope, Offset.box-impl(OffsetKt.Offset(x-impl - cornerSize2, Offset.getY-impl(drawScope.getCenter-F1C5BW0()))));
            }
        } else {
            cornerSize2 = cornerSize3;
        }
        if (obj64 != null) {
            i8 = start + i4;
        } else {
            i8 = 0;
        }
        activeTrackStart = i8;
        int i42 = x-impl8 - i13;
        i7 = obj64 != null ? cornerSize : cornerSize2;
        if (Float.compare(i23, i7) > 0) {
            activeTrackStart2 = activeTrackStart;
            this.drawTrackPath-Cx2C_VA(drawScope, OffsetKt.Offset(activeTrackStart, 0), box-impl2, SizeKt.Size(i42 - activeTrackStart, trackStrokeWidth), startGap, inactiveTickColor);
        } else {
            activeTrackStart2 = activeTrackStart;
        }
        contains = OffsetKt.Offset(x-impl4 += cornerSize2, Offset.getY-impl(l6));
        rangeTo = RangesKt.rangeTo(x-impl6 -= i4, x-impl20 += i4);
        int[] iArr = tickFractions;
        int i43 = 0;
        valueOf = 0;
        final int i44 = i7;
        startCornerRadius = iArr.length;
        final int i45 = 0;
        $this$forEachIndexed$iv = i45;
        while ($this$forEachIndexed$iv < startCornerRadius) {
            int i46 = i;
            i2 = 0;
            i12 = 1;
            if (obj != null) {
            } else {
            }
            i9 = $this$forEachIndexed$iv;
            i3 = startCornerRadius;
            i5 = valueOf;
            if (Float.compare(i46, activeRangeEnd) <= 0) {
            }
            l2 = contains;
            box-impl2 = Offset.getY-impl(drawScope.getCenter-F1C5BW0());
            contains = OffsetKt.Offset(Offset.getX-impl(OffsetKt.lerp-Wko1d7g(contains, box-impl2, OffsetKt.Offset(x-impl5 -= cornerSize2, Offset.getY-impl(l7)))), box-impl2);
            if (obj64 != null) {
            } else {
            }
            center = contains;
            if (RangesKt.rangeTo(x-impl21 -= i13, x-impl22 += i13).contains((Comparable)Float.valueOf(Offset.getX-impl(center)))) {
            } else {
            }
            if (i12 != 0) {
            } else {
            }
            obj2 = endThumbWidth;
            tick = rangeTo;
            obj63.invoke(drawScope, Offset.box-impl(center), Color.box-impl(obj2));
            $this$forEachIndexed$iv = i9 + 1;
            valueOf = i6;
            rangeTo = tick;
            startCornerRadius = i3;
            contains = l2;
            obj2 = height;
            tick = rangeTo;
            tickStartGap = obj63;
            center = contains;
            if (!rangeTo.contains((Comparable)Float.valueOf(Offset.getX-impl(contains)))) {
            } else {
            }
            if (Float.compare(i46, activeRangeStart) < 0) {
            } else {
            }
            i12 = i45;
            if (obj64 != null) {
            } else {
            }
            i9 = $this$forEachIndexed$iv;
            i3 = startCornerRadius;
            if (valueOf == length--) {
            } else {
            }
            tick = rangeTo;
            l2 = contains;
            tickStartGap = obj63;
            if (valueOf != 0) {
            } else {
            }
            i9 = $this$forEachIndexed$iv;
            i3 = startCornerRadius;
            i5 = valueOf;
        }
    }

    private final void drawTrackPath-Cx2C_VA(DrawScope $this$drawTrackPath_u2dCx2C_VA, long offset, long size, long color, float startCornerRadius, float endCornerRadius) {
        final float f = obj29;
        final long l = CornerRadiusKt.CornerRadius(f, f);
        final float f2 = obj30;
        final long l2 = CornerRadiusKt.CornerRadius(f2, f2);
        final int i2 = 0;
        Path.addRoundRect$default(SliderDefaults.trackPath, RoundRectKt.RoundRect-ZAM2FJo(RectKt.Rect-tz77jQw(OffsetKt.Offset(Offset.getX-impl(offset), 0), obj7), l, obj3, l2, obj5), i2, 2, i2);
        DrawScope.drawPath-LG529CI$default($this$drawTrackPath_u2dCx2C_VA, SliderDefaults.trackPath, endCornerRadius, obj14, 0, 0, 0, 0, 60);
        SliderDefaults.trackPath.rewind();
    }

    public final void Thumb-9LiSoMs(MutableInteractionSource interactionSource, Modifier modifier, androidx.compose.material3.SliderColors colors, boolean enabled, long thumbSize, Composer $composer, int $changed, int i8) {
        Object invalid$iv;
        Object anon;
        boolean width-D9Ej5fM;
        boolean traceInProgress;
        int $dirty2;
        Object $dirty;
        int i3;
        int companion;
        int colors2;
        boolean traceInProgress2;
        int i11;
        long copy-DwJknco$default;
        Object obj2;
        int skipping;
        int defaultsInvalid;
        Object empty;
        boolean z;
        Composer composer;
        long l;
        Object obj3;
        int i9;
        Object obj;
        int changed;
        int i12;
        boolean z2;
        int i2;
        long thumbColor-vNxB06k$material3_release;
        long l2;
        Object $i$a$CacheSliderDefaults$Thumb$interactions$1;
        int i5;
        int i6;
        int i4;
        Composer.Companion companion2;
        long i;
        float constructor-impl;
        int i10;
        int i13;
        int i7;
        traceInProgress = this;
        final Object obj5 = interactionSource;
        final int i26 = i8;
        invalid$iv = -290277409;
        final Composer restartGroup = $changed.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)947@42562L8,951@42678L46,952@42767L658,952@42733L692,975@43824L5,971@43620L220:Slider.kt#uh7d8r");
        $dirty2 = i8;
        if (obj32 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i26 & 6 == 0) {
                i3 = restartGroup.changed(obj5) ? 4 : 2;
                $dirty2 |= i3;
            }
        }
        companion = obj32 & 2;
        if (companion != 0) {
            $dirty2 |= 48;
            obj3 = modifier;
        } else {
            if (i26 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                obj3 = modifier;
            }
        }
        if (i26 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed = restartGroup.changed(colors) ? 256 : 128;
            } else {
                obj = colors;
            }
            $dirty2 |= changed;
        } else {
            obj = colors;
        }
        int i29 = obj32 & 8;
        if (i29 != 0) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (i26 & 3072 == 0) {
                i2 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i2;
            } else {
                z2 = enabled;
            }
        }
        thumbColor-vNxB06k$material3_release = obj32 & 16;
        if (thumbColor-vNxB06k$material3_release != 0) {
            $dirty2 |= 24576;
            l2 = thumbSize;
        } else {
            if (i26 & 24576 == 0) {
                i6 = restartGroup.changed(thumbSize) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                l2 = thumbSize;
            }
        }
        i = 196608;
        if (obj32 & 32 != 0) {
            $dirty2 |= i;
        } else {
            if (i26 & i == 0) {
                i4 = restartGroup.changed(traceInProgress) ? 131072 : 65536;
                $dirty2 |= i4;
            }
        }
        if ($dirty2 & companion2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i26 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (companion != 0) {
                            obj3 = companion;
                        }
                        if (obj32 & 4 != 0) {
                            $dirty2 &= -897;
                            obj = colors2;
                        }
                        if (i29 != 0) {
                            z2 = colors2;
                        }
                        if (thumbColor-vNxB06k$material3_release != 0) {
                            i = colors2;
                        } else {
                            i = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        i = l2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, $dirty2, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
                }
                String str2 = "CC(remember):Slider.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1068636116, str2);
                int i15 = 0;
                Composer composer2 = restartGroup;
                int i22 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i33 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i35 = 0;
                    composer2.updateRememberedValue(SnapshotStateKt.mutableStateListOf());
                } else {
                    $i$a$CacheSliderDefaults$Thumb$interactions$1 = rememberedValue;
                }
                invalid$iv = $i$a$CacheSliderDefaults$Thumb$interactions$1;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1068632656, str2);
                i11 = $dirty2 & 14 == 4 ? 1 : 0;
                composer = restartGroup;
                int i30 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i36 = 0;
                if (i11 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new SliderDefaults.Thumb.1.1(obj5, (SnapshotStateList)invalid$iv, i36);
                        composer.updateRememberedValue((Function2)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(obj5, (Function2)anon, restartGroup, $dirty2 & 14);
                if (!(Collection)invalid$iv.isEmpty()) {
                    empty = 0;
                    copy-DwJknco$default = DpSize.copy-DwJknco$default(i, obj18, Dp.constructor-impl(width-D9Ej5fM / f), 0, 2);
                } else {
                    copy-DwJknco$default = i;
                }
                int i24 = 0;
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU(HoverableKt.hoverable$default(SizeKt.size-6HolHcs(obj3, copy-DwJknco$default), obj5, i24, 2, i36), obj.thumbColor-vNxB06k$material3_release(z2), 0), restartGroup, i24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i12 = $dirty2;
                $dirty = obj3;
                l = i;
                obj2 = obj;
                z = z2;
            } else {
                restartGroup.skipToGroupEnd();
                i12 = $dirty2;
                $dirty = obj3;
                l = l2;
                obj2 = obj;
                z = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            invalid$iv = new SliderDefaults.Thumb.2(this, obj5, $dirty, obj2, z, l, obj3, i26, obj32);
            endRestartGroup.updateScope((Function2)invalid$iv);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(...))
    public final void Track(androidx.compose.material3.RangeSliderState rangeSliderState, Modifier modifier, androidx.compose.material3.SliderColors colors, boolean enabled, Composer $composer, int $changed, int i7) {
        boolean traceInProgress;
        Object i6;
        int $dirty;
        int i8;
        Object enabled2;
        boolean z;
        int i;
        Object modifier2;
        Object modifier3;
        Object colors2;
        boolean z3;
        boolean traceInProgress2;
        int i2;
        Object str;
        int changed;
        float i3;
        boolean z2;
        int i4;
        int i5;
        int skipping;
        int defaultsInvalid;
        int i9;
        int i10;
        final int i35 = $changed;
        i6 = -1617869097;
        final Composer restartGroup = $composer.startRestartGroup(i6);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(3,2)1187@52807L8,1190@52865L218:Slider.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i35 & 6 == 0) {
                i = restartGroup.changedInstance(rangeSliderState) ? 4 : 2;
                $dirty |= i;
            }
        }
        int i16 = i7 & 2;
        if (i16 != 0) {
            $dirty |= 48;
            colors2 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i2;
            } else {
                colors2 = modifier;
            }
        }
        if (i35 & 384 == 0) {
            if (i7 & 4 == 0) {
                changed = restartGroup.changed(colors) ? 256 : 128;
            } else {
                str = colors;
            }
            $dirty |= changed;
        } else {
            str = colors;
        }
        i3 = i7 & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z2 = enabled;
        } else {
            if (i35 & 3072 == 0) {
                i4 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                z2 = enabled;
            }
        }
        if (i7 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i35 & 24576 == 0) {
                i5 = restartGroup.changed(this) ? 16384 : 8192;
                $dirty |= i5;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i35 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = colors2;
                        }
                        if (i7 & 4 != 0) {
                            colors2 = colors(restartGroup, i20 &= 14);
                            $dirty &= -897;
                        } else {
                            colors2 = str;
                        }
                        if (i3 != 0) {
                            i10 = $dirty;
                            $dirty = modifier3;
                            modifier2 = colors2;
                            z = str;
                        } else {
                            i10 = $dirty;
                            $dirty = modifier3;
                            modifier2 = colors2;
                            z = z2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i10 = $dirty;
                        $dirty = colors2;
                        modifier2 = str;
                        z = z2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i10, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1189)");
                }
                this.Track-4EFweAY(rangeSliderState, $dirty, z, modifier2, 0, 0, SliderKt.access$getThumbTrackGapSize$p(), SliderKt.access$getTrackInsideCornerSize$p(), restartGroup, i15 | i29, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z;
                enabled2 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i10 = $dirty;
                enabled2 = colors2;
                modifier2 = str;
                z3 = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SliderDefaults.Track.8(this, rangeSliderState, enabled2, modifier2, z3, i35, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(message = "Use version that supports slider state")
    public final void Track(androidx.compose.material3.SliderPositions sliderPositions, Modifier modifier, androidx.compose.material3.SliderColors colors, boolean enabled, Composer $composer, int $changed, int i7) {
        int activeTickColor2;
        boolean traceInProgress2;
        Composer obj2;
        int $dirty;
        int i3;
        Object modifier2;
        Object inactiveTickColor;
        Object obj3;
        Object obj6;
        Object obj;
        Object colors2;
        boolean colors3;
        int i2;
        Object enabled2;
        int changed;
        boolean traceInProgress;
        int i4;
        Object $this$cache$iv;
        int i8;
        boolean trackColor-WaAFU9c$material3_release2;
        int i5;
        int i6;
        int defaultsInvalid;
        Object obj5;
        long trackColor-WaAFU9c$material3_release;
        long it$iv;
        Composer.Companion companion;
        long activeTickColor;
        Object obj4;
        int i9;
        int i10;
        int i;
        long l;
        int obj27;
        int obj29;
        obj2 = this;
        final int i24 = $changed;
        traceInProgress2 = -1546713545;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(3,2)997@44755L8,1004@45160L1834,1004@45108L1886:Slider.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
            obj5 = sliderPositions;
        } else {
            if (i24 & 6 == 0) {
                i3 = restartGroup.changed(sliderPositions) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj5 = sliderPositions;
            }
        }
        int i14 = i7 & 2;
        if (i14 != 0) {
            $dirty |= 48;
            obj = modifier;
        } else {
            if (i24 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i2;
            } else {
                obj = modifier;
            }
        }
        if (i24 & 384 == 0) {
            if (i7 & 4 == 0) {
                changed = restartGroup.changed(colors) ? 256 : 128;
            } else {
                enabled2 = colors;
            }
            $dirty |= changed;
        } else {
            enabled2 = colors;
        }
        int i27 = i7 & 8;
        if (i27 != 0) {
            $dirty |= 3072;
            trackColor-WaAFU9c$material3_release2 = enabled;
        } else {
            if (i24 & 3072 == 0) {
                i5 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                trackColor-WaAFU9c$material3_release2 = enabled;
            }
        }
        if (i7 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i24 & 24576 == 0) {
                i6 = restartGroup.changed(obj2) ? 16384 : 8192;
                $dirty |= i6;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i24 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (i7 & 4 != 0) {
                            colors2 = obj2.colors(restartGroup, i22 &= 14);
                            $dirty &= -897;
                        } else {
                            colors2 = enabled2;
                        }
                        enabled2 = i27 != 0 ? 1 : trackColor-WaAFU9c$material3_release2;
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                        modifier2 = obj;
                        colors2 = enabled2;
                        enabled2 = trackColor-WaAFU9c$material3_release2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:999)");
                }
                int i11 = 0;
                trackColor-WaAFU9c$material3_release2 = colors2.trackColor-WaAFU9c$material3_release(enabled2, i11);
                int i28 = 1;
                trackColor-WaAFU9c$material3_release = colors2.trackColor-WaAFU9c$material3_release(enabled2, i28);
                obj27 = $dirty;
                long tickColor-WaAFU9c$material3_release = colors2.tickColor-WaAFU9c$material3_release(enabled2, i11);
                activeTickColor2 = colors2.tickColor-WaAFU9c$material3_release(enabled2, i28);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -801023075, "CC(remember):Slider.kt#9igjgp");
                i4 = obj27 & 14 == 4 ? 1 : 0;
                boolean changed4 = restartGroup.changed(trackColor-WaAFU9c$material3_release);
                long l2 = l3;
                Composer composer = restartGroup;
                i10 = 0;
                Object rememberedValue = composer.rememberedValue();
                i = 0;
                if (i30 | changed9 == 0) {
                    activeTickColor = activeTickColor2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        activeTickColor2 = 0;
                        inactiveTickColor = rememberedValue;
                        $this$cache$iv = new SliderDefaults.Track.1.1(trackColor-WaAFU9c$material3_release2, defaultsInvalid, obj5, trackColor-WaAFU9c$material3_release, obj14, l2, companion, activeTickColor, obj18);
                        composer.updateRememberedValue((Function1)$this$cache$iv);
                    } else {
                        obj2 = composer;
                        it$iv = l2;
                        inactiveTickColor = $this$cache$iv;
                    }
                } else {
                    activeTickColor = activeTickColor2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0, i28, 0), SliderKt.getTrackHeight()), (Function1)$this$cache$iv, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i8 = obj27;
                obj6 = colors2;
                colors3 = enabled2;
                obj3 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                i8 = $dirty;
                obj3 = obj;
                obj6 = enabled2;
                colors3 = trackColor-WaAFU9c$material3_release2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SliderDefaults.Track.2(this, sliderPositions, obj3, obj6, colors3, i24, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(...))
    public final void Track(androidx.compose.material3.SliderState sliderState, Modifier modifier, androidx.compose.material3.SliderColors colors, boolean enabled, Composer $composer, int $changed, int i7) {
        boolean traceInProgress2;
        Object i2;
        int $dirty;
        int i10;
        Object enabled2;
        boolean z3;
        int i4;
        Object modifier2;
        Object modifier3;
        Object colors2;
        boolean z;
        boolean traceInProgress;
        int i3;
        Object str;
        int changed;
        float i;
        boolean z2;
        int i9;
        int i6;
        int skipping;
        int defaultsInvalid;
        int i5;
        int i8;
        final int i35 = $changed;
        i2 = 593554206;
        final Composer restartGroup = $composer.startRestartGroup(i2);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(3,2)1079@48295L8,1082@48353L213:Slider.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i35 & 6 == 0) {
                i4 = restartGroup.changedInstance(sliderState) ? 4 : 2;
                $dirty |= i4;
            }
        }
        int i16 = i7 & 2;
        if (i16 != 0) {
            $dirty |= 48;
            colors2 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                colors2 = modifier;
            }
        }
        if (i35 & 384 == 0) {
            if (i7 & 4 == 0) {
                changed = restartGroup.changed(colors) ? 256 : 128;
            } else {
                str = colors;
            }
            $dirty |= changed;
        } else {
            str = colors;
        }
        i = i7 & 8;
        if (i != 0) {
            $dirty |= 3072;
            z2 = enabled;
        } else {
            if (i35 & 3072 == 0) {
                i9 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                z2 = enabled;
            }
        }
        if (i7 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i35 & 24576 == 0) {
                i6 = restartGroup.changed(this) ? 16384 : 8192;
                $dirty |= i6;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i35 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = colors2;
                        }
                        if (i7 & 4 != 0) {
                            colors2 = colors(restartGroup, i20 &= 14);
                            $dirty &= -897;
                        } else {
                            colors2 = str;
                        }
                        if (i != 0) {
                            i8 = $dirty;
                            $dirty = modifier3;
                            modifier2 = colors2;
                            z3 = str;
                        } else {
                            i8 = $dirty;
                            $dirty = modifier3;
                            modifier2 = colors2;
                            z3 = z2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i8 = $dirty;
                        $dirty = colors2;
                        modifier2 = str;
                        z3 = z2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i2, i8, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1081)");
                }
                this.Track-4EFweAY(sliderState, $dirty, z3, modifier2, 0, 0, SliderKt.access$getThumbTrackGapSize$p(), SliderKt.access$getTrackInsideCornerSize$p(), restartGroup, i15 | i29, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z = z3;
                enabled2 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i8 = $dirty;
                enabled2 = colors2;
                modifier2 = str;
                z = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SliderDefaults.Track.3(this, sliderState, enabled2, modifier2, z, i35, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final void Track-4EFweAY(androidx.compose.material3.RangeSliderState rangeSliderState, Modifier modifier, boolean enabled, androidx.compose.material3.SliderColors colors, Function2<? super DrawScope, ? super Offset, Unit> drawStopIndicator, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> drawTick, float thumbTrackGapSize, float trackInsideCornerSize, Composer $composer, int $changed, int i11) {
        int i17;
        int traceInProgress2;
        Object obj;
        int i23;
        int defaultsInvalid;
        int colors4;
        int colors3;
        int i7;
        Object empty2;
        int changed3;
        int i13;
        int i6;
        int i3;
        Composer it$iv;
        Object drawStopIndicator3;
        Composer $composer3;
        boolean changed2;
        Object empty;
        Object anon;
        boolean enabled2;
        int i14;
        Object obj5;
        float f2;
        Object thumbTrackGapSize2;
        long colors5;
        boolean z;
        Object $composer2;
        int $dirty2;
        long $dirty3;
        Object $dirty;
        int i19;
        int i10;
        boolean traceInProgress;
        int i9;
        int i16;
        Object obj4;
        Object str;
        long l2;
        float inactiveTickColor;
        int i21;
        int i22;
        float f;
        long i2;
        boolean trackColor-WaAFU9c$material3_release;
        int i15;
        Object obj6;
        float colors2;
        float inactiveTickColor2;
        Composer $composer4;
        int changed;
        Object obj7;
        Object obj3;
        int changedInstance;
        Object obj2;
        int drawStopIndicator2;
        int i4;
        int i5;
        int i18;
        int companion;
        int i24;
        int i;
        int i8;
        int i20;
        int i12;
        Composer.Companion companion2;
        long l;
        int obj29;
        int obj30;
        int obj31;
        Composer obj32;
        Object obj8 = this;
        anon = rangeSliderState;
        int i25 = $changed;
        int i58 = i11;
        Composer restartGroup = $composer.startRestartGroup(-541824132);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(5,4,3!3,6:c#ui.unit.Dp,7:c#ui.unit.Dp)1222@54320L8,1223@54389L232,1245@55370L7,1246@55426L706,1241@55223L909:Slider.kt#uh7d8r");
        $dirty2 = $changed;
        if (i58 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i25 & 6 == 0) {
                i19 = restartGroup.changedInstance(anon) ? 4 : 2;
                $dirty2 |= i19;
            }
        }
        i10 = i58 & 2;
        if (i10 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i25 & 48 == 0) {
                i21 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i21;
            } else {
                str = modifier;
            }
        }
        i22 = i58 & 4;
        if (i22 != 0) {
            $dirty2 |= 384;
            trackColor-WaAFU9c$material3_release = enabled;
        } else {
            if (i25 & 384 == 0) {
                i15 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i15;
            } else {
                trackColor-WaAFU9c$material3_release = enabled;
            }
        }
        if (i25 & 3072 == 0) {
            if (i58 & 8 == 0) {
                changed = restartGroup.changed(colors) ? 2048 : 1024;
            } else {
                obj6 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj6 = colors;
        }
        if (i25 & 24576 == 0) {
            if (i58 & 16 == 0) {
                changedInstance = restartGroup.changedInstance(drawStopIndicator) ? 16384 : 8192;
            } else {
                obj7 = drawStopIndicator;
            }
            $dirty2 |= changedInstance;
        } else {
            obj7 = drawStopIndicator;
        }
        int i73 = i58 & 32;
        i4 = 196608;
        if (i73 != 0) {
            $dirty2 |= i4;
            obj3 = drawTick;
        } else {
            if (i25 & i4 == 0) {
                i5 = restartGroup.changedInstance(drawTick) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                obj3 = drawTick;
            }
        }
        i18 = i58 & 64;
        i24 = 1572864;
        if (i18 != 0) {
            $dirty2 |= i24;
            f2 = thumbTrackGapSize;
        } else {
            if (i25 & i24 == 0) {
                i = restartGroup.changed(thumbTrackGapSize) ? 1048576 : 524288;
                $dirty2 |= i;
            } else {
                f2 = thumbTrackGapSize;
            }
        }
        i2 = i58 & 128;
        i20 = 12582912;
        if (i2 != 0) {
            $dirty2 |= i20;
            inactiveTickColor2 = trackInsideCornerSize;
        } else {
            if (i25 & i20 == 0) {
                i12 = restartGroup.changed(trackInsideCornerSize) ? 8388608 : 4194304;
                $dirty2 |= i12;
            } else {
                inactiveTickColor2 = trackInsideCornerSize;
            }
        }
        if (i58 & 256 != 0) {
            i17 = 100663296;
            $dirty2 |= i17;
        } else {
        }
        if (i27 &= $dirty2 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i22 != 0) {
                            trackColor-WaAFU9c$material3_release = defaultsInvalid;
                        }
                        if (i11 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj6 = colors4;
                        }
                        if (i11 & 16 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -800729349, "CC(remember):Slider.kt#9igjgp");
                            if (i33 ^= 3072 > 2048) {
                                if (!restartGroup.changed(obj6)) {
                                    i7 = $dirty2 & 3072 == 2048 ? 1 : 0;
                                } else {
                                }
                            } else {
                            }
                            i16 = $dirty2 & 896 == 256 ? 1 : 0;
                            i7 |= i16;
                            i10 = restartGroup;
                            i22 = 0;
                            Object rememberedValue2 = i10.rememberedValue();
                            i20 = 0;
                            if (empty2 == 0) {
                                obj29 = empty2;
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    obj30 = invalid$iv;
                                    colors3 = new SliderDefaults.Track.9.1(obj6, trackColor-WaAFU9c$material3_release);
                                    i10.updateRememberedValue((Function2)colors3);
                                } else {
                                    colors3 = rememberedValue2;
                                }
                            } else {
                                obj29 = empty2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty2 &= i14;
                            obj7 = colors3;
                        }
                        if (i73 != 0) {
                            obj3 = colors3;
                        }
                        if (i18 != 0) {
                            f2 = colors3;
                        }
                        if (i2 != 0) {
                            colors2 = f2;
                            thumbTrackGapSize2 = obj10;
                            inactiveTickColor2 = f3;
                            obj = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        } else {
                            colors2 = f2;
                            thumbTrackGapSize2 = trackInsideCornerSize2;
                            obj = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i11 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i11 & 16 != 0) {
                            colors2 = f2;
                            thumbTrackGapSize2 = obj9;
                            $dirty2 = i31;
                            obj = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        } else {
                            colors2 = f2;
                            thumbTrackGapSize2 = $dirty4;
                            obj = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-541824132, $dirty2, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1236)");
                }
                int i61 = 0;
                long trackColor-WaAFU9c$material3_release2 = thumbTrackGapSize2.trackColor-WaAFU9c$material3_release(enabled2, i61);
                obj29 = colors2;
                int i66 = 1;
                trackColor-WaAFU9c$material3_release = thumbTrackGapSize2.trackColor-WaAFU9c$material3_release(enabled2, i66);
                obj30 = inactiveTickColor2;
                Object obj12 = obj7;
                long tickColor-WaAFU9c$material3_release2 = thumbTrackGapSize2.tickColor-WaAFU9c$material3_release(enabled2, i61);
                long tickColor-WaAFU9c$material3_release = thumbTrackGapSize2.tickColor-WaAFU9c$material3_release(enabled2, i66);
                int i74 = 0;
                companion = 0;
                int i67 = 2023513938;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i67, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i23 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1127481344 : 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -800695691, "CC(remember):Slider.kt#9igjgp");
                long l3 = obj31;
                i13 = $dirty2 & i75 == 1048576 ? 1 : 0;
                i6 = i52 &= $dirty2 == 8388608 ? 1 : 0;
                if (i55 ^= 24576 > 16384) {
                    drawStopIndicator3 = obj12;
                    if (!restartGroup.changed(drawStopIndicator3)) {
                        obj2 = drawStopIndicator3;
                        i3 = $dirty2 & 24576 == 16384 ? 1 : 0;
                    } else {
                        obj2 = drawStopIndicator3;
                    }
                } else {
                    drawStopIndicator3 = obj12;
                }
                i8 = i56 &= $dirty2 == 131072 ? 1 : 0;
                empty = restartGroup;
                i4 = 0;
                Object rememberedValue = empty.rememberedValue();
                i18 = 0;
                if (obj31 | i8 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        companion = 0;
                        i24 = enabled2;
                        i = thumbTrackGapSize2;
                        obj29 = restartGroup;
                        obj30 = rememberedValue;
                        drawStopIndicator2 = $dirty2;
                        anon = new SliderDefaults.Track.11.1(rangeSliderState, l3, restartGroup, trackColor-WaAFU9c$material3_release, tickColor-WaAFU9c$material3_release, tickColor-WaAFU9c$material3_release2, l3, tickColor-WaAFU9c$material3_release, trackColor-WaAFU9c$material3_release, obj29, obj30, obj2, obj3);
                        obj32.updateRememberedValue((Function1)anon);
                    } else {
                        i24 = enabled2;
                        i = thumbTrackGapSize2;
                        it$iv = obj32;
                        obj6 = obj29;
                        obj29 = restartGroup;
                        colors5 = l3;
                        i2 = tickColor-WaAFU9c$material3_release;
                        l2 = tickColor-WaAFU9c$material3_release2;
                        obj7 = obj2;
                        inactiveTickColor2 = obj30;
                        obj30 = anon;
                        drawStopIndicator2 = $dirty2;
                        $dirty3 = l;
                    }
                } else {
                    obj32 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(obj29);
                CanvasKt.Canvas(RotateKt.rotate(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(obj, 0, i66, 0), SliderKt.getTrackHeight()), i23), (Function1)anon, obj29, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                inactiveTickColor = obj6;
                z = i24;
                $composer2 = i;
                obj5 = i20;
                f = inactiveTickColor2;
                $dirty = obj7;
                obj4 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                $composer3 = restartGroup;
                drawStopIndicator2 = $dirty2;
                obj5 = str;
                $composer2 = obj6;
                inactiveTickColor = f2;
                z = trackColor-WaAFU9c$material3_release;
                f = inactiveTickColor2;
                $dirty = obj7;
                obj4 = obj3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $composer4 = $composer3;
            traceInProgress2 = new SliderDefaults.Track.12(this, rangeSliderState, obj5, z, $composer2, $dirty, obj4, inactiveTickColor, f, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $composer4 = $composer3;
        }
    }

    public final void Track-4EFweAY(androidx.compose.material3.SliderState sliderState, Modifier modifier, boolean enabled, androidx.compose.material3.SliderColors colors, Function2<? super DrawScope, ? super Offset, Unit> drawStopIndicator, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> drawTick, float thumbTrackGapSize, float trackInsideCornerSize, Composer $composer, int $changed, int i11) {
        int i14;
        int traceInProgress2;
        Object obj6;
        int i22;
        int defaultsInvalid;
        int colors3;
        int colors4;
        int i12;
        Object empty;
        int changed3;
        int i7;
        int i16;
        int i5;
        Composer it$iv;
        Object drawStopIndicator3;
        Composer $composer3;
        boolean changed;
        Object empty2;
        Object anon;
        boolean enabled2;
        int i;
        Object obj5;
        float f;
        Object thumbTrackGapSize2;
        long colors2;
        boolean z;
        Object $composer2;
        int $dirty3;
        long $dirty;
        Object $dirty2;
        int i6;
        int i21;
        boolean traceInProgress;
        int i18;
        int i17;
        Object obj;
        Object str;
        long l2;
        float inactiveTickColor2;
        int i4;
        int i10;
        float f2;
        long i15;
        boolean trackColor-WaAFU9c$material3_release;
        int i3;
        Object obj3;
        float colors5;
        float inactiveTickColor;
        Composer $composer4;
        int changed2;
        Object obj2;
        Object obj7;
        int changedInstance;
        Object obj4;
        int drawStopIndicator2;
        int i23;
        int i9;
        int i2;
        int companion2;
        int i13;
        int i19;
        int i20;
        int i24;
        int i8;
        Composer.Companion companion;
        long l;
        int obj29;
        int obj30;
        int obj31;
        Composer obj32;
        Object obj8 = this;
        anon = sliderState;
        int i25 = $changed;
        int i58 = i11;
        Composer restartGroup = $composer.startRestartGroup(49984771);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(5,4,3!3,6:c#ui.unit.Dp,7:c#ui.unit.Dp)1114@49756L8,1115@49825L232,1137@50806L7,1138@50862L595,1133@50659L798:Slider.kt#uh7d8r");
        $dirty3 = $changed;
        if (i58 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i25 & 6 == 0) {
                i6 = restartGroup.changedInstance(anon) ? 4 : 2;
                $dirty3 |= i6;
            }
        }
        i21 = i58 & 2;
        if (i21 != 0) {
            $dirty3 |= 48;
            str = modifier;
        } else {
            if (i25 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i4;
            } else {
                str = modifier;
            }
        }
        i10 = i58 & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            trackColor-WaAFU9c$material3_release = enabled;
        } else {
            if (i25 & 384 == 0) {
                i3 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                trackColor-WaAFU9c$material3_release = enabled;
            }
        }
        if (i25 & 3072 == 0) {
            if (i58 & 8 == 0) {
                changed2 = restartGroup.changed(colors) ? 2048 : 1024;
            } else {
                obj3 = colors;
            }
            $dirty3 |= changed2;
        } else {
            obj3 = colors;
        }
        if (i25 & 24576 == 0) {
            if (i58 & 16 == 0) {
                changedInstance = restartGroup.changedInstance(drawStopIndicator) ? 16384 : 8192;
            } else {
                obj2 = drawStopIndicator;
            }
            $dirty3 |= changedInstance;
        } else {
            obj2 = drawStopIndicator;
        }
        int i73 = i58 & 32;
        i23 = 196608;
        if (i73 != 0) {
            $dirty3 |= i23;
            obj7 = drawTick;
        } else {
            if (i25 & i23 == 0) {
                i9 = restartGroup.changedInstance(drawTick) ? 131072 : 65536;
                $dirty3 |= i9;
            } else {
                obj7 = drawTick;
            }
        }
        i2 = i58 & 64;
        i13 = 1572864;
        if (i2 != 0) {
            $dirty3 |= i13;
            f = thumbTrackGapSize;
        } else {
            if (i25 & i13 == 0) {
                i19 = restartGroup.changed(thumbTrackGapSize) ? 1048576 : 524288;
                $dirty3 |= i19;
            } else {
                f = thumbTrackGapSize;
            }
        }
        i15 = i58 & 128;
        i24 = 12582912;
        if (i15 != 0) {
            $dirty3 |= i24;
            inactiveTickColor = trackInsideCornerSize;
        } else {
            if (i25 & i24 == 0) {
                i8 = restartGroup.changed(trackInsideCornerSize) ? 8388608 : 4194304;
                $dirty3 |= i8;
            } else {
                inactiveTickColor = trackInsideCornerSize;
            }
        }
        if (i58 & 256 != 0) {
            i14 = 100663296;
            $dirty3 |= i14;
        } else {
        }
        if (i27 &= $dirty3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i21 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i10 != 0) {
                            trackColor-WaAFU9c$material3_release = defaultsInvalid;
                        }
                        if (i11 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj3 = colors3;
                        }
                        if (i11 & 16 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -800875397, "CC(remember):Slider.kt#9igjgp");
                            if (i33 ^= 3072 > 2048) {
                                if (!restartGroup.changed(obj3)) {
                                    i12 = $dirty3 & 3072 == 2048 ? 1 : 0;
                                } else {
                                }
                            } else {
                            }
                            i17 = $dirty3 & 896 == 256 ? 1 : 0;
                            i12 |= i17;
                            i21 = restartGroup;
                            i10 = 0;
                            Object rememberedValue2 = i21.rememberedValue();
                            i24 = 0;
                            if (empty == 0) {
                                obj29 = empty;
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    obj30 = invalid$iv;
                                    colors4 = new SliderDefaults.Track.4.1(obj3, trackColor-WaAFU9c$material3_release);
                                    i21.updateRememberedValue((Function2)colors4);
                                } else {
                                    colors4 = rememberedValue2;
                                }
                            } else {
                                obj29 = empty;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty3 &= i;
                            obj2 = colors4;
                        }
                        if (i73 != 0) {
                            obj7 = colors4;
                        }
                        if (i2 != 0) {
                            f = colors4;
                        }
                        if (i15 != 0) {
                            colors5 = f;
                            thumbTrackGapSize2 = obj10;
                            inactiveTickColor = f3;
                            obj6 = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        } else {
                            colors5 = f;
                            thumbTrackGapSize2 = trackInsideCornerSize2;
                            obj6 = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i11 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i11 & 16 != 0) {
                            colors5 = f;
                            thumbTrackGapSize2 = obj9;
                            $dirty3 = i31;
                            obj6 = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        } else {
                            colors5 = f;
                            thumbTrackGapSize2 = $dirty4;
                            obj6 = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(49984771, $dirty3, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1128)");
                }
                int i61 = 0;
                long trackColor-WaAFU9c$material3_release2 = thumbTrackGapSize2.trackColor-WaAFU9c$material3_release(enabled2, i61);
                obj29 = colors5;
                int i66 = 1;
                trackColor-WaAFU9c$material3_release = thumbTrackGapSize2.trackColor-WaAFU9c$material3_release(enabled2, i66);
                obj30 = inactiveTickColor;
                Object obj12 = obj2;
                long tickColor-WaAFU9c$material3_release2 = thumbTrackGapSize2.tickColor-WaAFU9c$material3_release(enabled2, i61);
                long tickColor-WaAFU9c$material3_release = thumbTrackGapSize2.tickColor-WaAFU9c$material3_release(enabled2, i66);
                int i74 = 0;
                companion2 = 0;
                int i67 = 2023513938;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i67, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i22 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1127481344 : 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -800841850, "CC(remember):Slider.kt#9igjgp");
                long l3 = obj31;
                i7 = $dirty3 & i75 == 1048576 ? 1 : 0;
                i16 = i52 &= $dirty3 == 8388608 ? 1 : 0;
                if (i55 ^= 24576 > 16384) {
                    drawStopIndicator3 = obj12;
                    if (!restartGroup.changed(drawStopIndicator3)) {
                        obj4 = drawStopIndicator3;
                        i5 = $dirty3 & 24576 == 16384 ? 1 : 0;
                    } else {
                        obj4 = drawStopIndicator3;
                    }
                } else {
                    drawStopIndicator3 = obj12;
                }
                i20 = i56 &= $dirty3 == 131072 ? 1 : 0;
                empty2 = restartGroup;
                i23 = 0;
                Object rememberedValue = empty2.rememberedValue();
                i2 = 0;
                if (obj31 | i20 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        companion2 = 0;
                        i13 = enabled2;
                        i19 = thumbTrackGapSize2;
                        obj29 = restartGroup;
                        obj30 = rememberedValue;
                        drawStopIndicator2 = $dirty3;
                        anon = new SliderDefaults.Track.6.1(sliderState, l3, restartGroup, trackColor-WaAFU9c$material3_release, tickColor-WaAFU9c$material3_release, tickColor-WaAFU9c$material3_release2, l3, tickColor-WaAFU9c$material3_release, trackColor-WaAFU9c$material3_release, obj29, obj30, obj4, obj7);
                        obj32.updateRememberedValue((Function1)anon);
                    } else {
                        i13 = enabled2;
                        i19 = thumbTrackGapSize2;
                        it$iv = obj32;
                        obj3 = obj29;
                        obj29 = restartGroup;
                        colors2 = l3;
                        i15 = tickColor-WaAFU9c$material3_release;
                        l2 = tickColor-WaAFU9c$material3_release2;
                        obj2 = obj4;
                        inactiveTickColor = obj30;
                        obj30 = anon;
                        drawStopIndicator2 = $dirty3;
                        $dirty = l;
                    }
                } else {
                    obj32 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(obj29);
                CanvasKt.Canvas(RotateKt.rotate(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(obj6, 0, i66, 0), SliderKt.getTrackHeight()), i22), (Function1)anon, obj29, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                inactiveTickColor2 = obj3;
                z = i13;
                $composer2 = i19;
                obj5 = i24;
                f2 = inactiveTickColor;
                $dirty2 = obj2;
                obj = obj7;
            } else {
                restartGroup.skipToGroupEnd();
                $composer3 = restartGroup;
                drawStopIndicator2 = $dirty3;
                obj5 = str;
                $composer2 = obj3;
                inactiveTickColor2 = f;
                z = trackColor-WaAFU9c$material3_release;
                f2 = inactiveTickColor;
                $dirty2 = obj2;
                obj = obj7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $composer4 = $composer3;
            traceInProgress2 = new SliderDefaults.Track.7(this, sliderState, obj5, z, $composer2, $dirty2, obj, inactiveTickColor2, f2, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $composer4 = $composer3;
        }
    }

    public final androidx.compose.material3.SliderColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1376295968;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)845@36907L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:845)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.SliderColors colors-q0g_0yA(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor, Composer $composer, int $changed, int $changed1, int i14) {
        Color.Companion companion;
        String traceInProgress;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU8;
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU3;
        int unspecified-0d7_KjU2;
        long unspecified-0d7_KjU9;
        long unspecified-0d7_KjU7;
        int i2;
        int i;
        long l;
        long l2;
        long l7;
        long l4;
        long l6;
        long l10;
        long l5;
        long l3;
        long l8;
        long l9;
        final Composer composer = obj47;
        int i3 = obj50;
        int i4 = 885588574;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)887@39230L11:Slider.kt#uh7d8r");
        if (i3 & 1 != 0) {
            l = unspecified-0d7_KjU4;
        } else {
            l = thumbColor;
        }
        if (i3 & 2 != 0) {
            l2 = unspecified-0d7_KjU5;
        } else {
            l2 = activeTickColor;
        }
        if (i3 & 4 != 0) {
            l7 = unspecified-0d7_KjU8;
        } else {
            l7 = inactiveTickColor;
        }
        if (i3 & 8 != 0) {
            l4 = unspecified-0d7_KjU6;
        } else {
            l4 = disabledActiveTrackColor;
        }
        if (i3 & 16 != 0) {
            l6 = unspecified-0d7_KjU;
        } else {
            l6 = disabledInactiveTrackColor;
        }
        if (i3 & 32 != 0) {
            l10 = unspecified-0d7_KjU3;
        } else {
            l10 = $composer;
        }
        if (i3 & 64 != 0) {
            l5 = unspecified-0d7_KjU2;
        } else {
            l5 = $changed1;
        }
        if (i3 & 128 != 0) {
            l3 = unspecified-0d7_KjU9;
        } else {
            l3 = obj41;
        }
        if (i3 & 256 != 0) {
            l8 = unspecified-0d7_KjU7;
        } else {
            l8 = obj43;
        }
        if (i3 &= 512 != 0) {
            l9 = unspecified-0d7_KjU7;
        } else {
            l9 = obj45;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, obj48, obj49, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:887)");
        } else {
            i2 = obj48;
            i = obj49;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy--K518z4(l, obj7, l2, obj9, l7, obj11, l4, obj13, l6, obj15);
    }

    public final androidx.compose.material3.SliderColors getDefaultSliderColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultSliderColors) {
        androidx.compose.material3.SliderColors defaultSliderColorsCached$material3_release;
        int i4;
        long token4;
        long token2;
        long token3;
        long token;
        long token5;
        long compositeOver--OWjLjI;
        androidx.compose.material3.SliderColors sliderColors;
        SliderTokens iNSTANCE;
        long l3;
        float disabledActiveTrackOpacity;
        long l;
        int i3;
        long l2;
        int i2;
        int i9;
        int i5;
        float disabledActiveTrackOpacity2;
        int i8;
        int i6;
        int i10;
        int i;
        int i7;
        long l4;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultSliderColors;
        if (colorScheme.getDefaultSliderColorsCached$material3_release() == null) {
            int i12 = 0;
            disabledActiveTrackOpacity = SliderTokens.INSTANCE.getDisabledActiveTrackOpacity();
            i3 = 0;
            i2 = 0;
            i5 = 0;
            i8 = 0;
            iNSTANCE = SliderTokens.INSTANCE;
            androidx.compose.material3.SliderColors sliderColors3 = sliderColors4;
            sliderColors3 = new SliderColors(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getHandleColor()), obj4, ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), obj6, ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), obj8, ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), obj10, ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), obj12, ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledHandleColor()), obj14, SliderTokens.INSTANCE.getDisabledHandleOpacity(), 0, i12, 0, 14), obj14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), i12, disabledActiveTrackOpacity, 0, i3, 0, 14), iNSTANCE, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), i3, SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), i2, 0, i5, 14), disabledActiveTrackOpacity, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), i2, SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), i5, 0, i8, 14), i3, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, iNSTANCE.getDisabledActiveTrackColor()), i5, SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), i8, 0, 0, 14), i2, 0);
            i4 = 0;
            colorScheme.setDefaultSliderColorsCached$material3_release(sliderColors3);
        }
        return defaultSliderColorsCached$material3_release;
    }

    public final float getTickSize-D9Ej5fM() {
        return SliderDefaults.TickSize;
    }

    public final float getTrackStopIndicatorSize-D9Ej5fM() {
        return SliderDefaults.TrackStopIndicatorSize;
    }
}
