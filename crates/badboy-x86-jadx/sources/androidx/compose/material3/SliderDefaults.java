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
        Offset box-impl2;
        Offset start;
        int activeTrackStart;
        ClosedFloatingPointRange rangeTo;
        Object tickStartGap;
        long trackStrokeWidth2;
        long i12;
        int i10;
        int cmp;
        long contains;
        float box-impl;
        long f2;
        int startGap;
        int endGap;
        float f;
        int $this$forEachIndexed$iv;
        int i3;
        float cornerSize;
        int i4;
        int startCornerRadius;
        int cmp2;
        float cornerSize2;
        float trackStrokeWidth;
        float f3;
        int i5;
        int activeTrackStart2;
        int i11;
        float x-impl;
        int i;
        long l2;
        int cornerSize3;
        int valueOf;
        int i2;
        int i13;
        ClosedFloatingPointRange tick;
        int i9;
        int i6;
        int i8;
        int i7;
        long center;
        long l;
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
        box-impl = (float)i27;
        cornerSize = trackStrokeWidth2 / box-impl;
        cornerSize2 = drawScope.toPx-0680j_4(obj61);
        int i40 = 0;
        if (Dp.compareTo-0680j_4(f5, Dp.constructor-impl((float)i36)) > 0) {
            i5 = startGap;
            i11 = endGap;
        } else {
            f3 = drawStopIndicator;
            f = drawTick;
            i5 = startGap;
            i11 = endGap;
        }
        if (obj64 != null && Float.compare(x-impl13, startGap) > 0) {
            if (Float.compare(x-impl13, startGap) > 0) {
                x-impl = Offset.getX-impl(l6);
                startGap = Offset.Companion.getZero-F1C5BW0();
                box-impl = i - x-impl;
                trackStrokeWidth = trackStrokeWidth2;
                this.drawTrackPath-Cx2C_VA(drawScope, startGap, box-impl, SizeKt.Size(box-impl, trackStrokeWidth2), startGap, inactiveTrackColor);
                if (obj != null) {
                    obj.invoke(drawScope, Offset.box-impl(OffsetKt.Offset(x-impl + cornerSize, Offset.getY-impl(drawScope.getCenter-F1C5BW0()))));
                }
            } else {
                trackStrokeWidth = trackStrokeWidth2;
            }
        } else {
        }
        if (Float.compare(x-impl2, i12) < 0) {
            x-impl3 += i11;
            x-impl = Offset.getX-impl(l7);
            box-impl = OffsetKt.Offset(i14, 0);
            startGap = SizeKt.Size(x-impl - i14, trackStrokeWidth);
            int insideCornerSize = cornerSize;
            cornerSize = f4;
            i = i14;
            this.drawTrackPath-Cx2C_VA(drawScope, box-impl, box-impl, startGap, startGap, inactiveTrackColor);
            cornerSize2 = cornerSize;
            if (obj != null) {
                obj.invoke(drawScope, Offset.box-impl(OffsetKt.Offset(x-impl - cornerSize3, Offset.getY-impl(drawScope.getCenter-F1C5BW0()))));
            }
        } else {
            cornerSize3 = cornerSize;
        }
        if (obj64 != null) {
            i10 = start + i5;
        } else {
            i10 = 0;
        }
        activeTrackStart = i10;
        int i42 = x-impl8 - i11;
        i4 = obj64 != null ? cornerSize2 : cornerSize3;
        if (Float.compare(i23, i4) > 0) {
            activeTrackStart2 = activeTrackStart;
            this.drawTrackPath-Cx2C_VA(drawScope, OffsetKt.Offset(activeTrackStart, 0), box-impl, SizeKt.Size(i42 - activeTrackStart, trackStrokeWidth), startGap, inactiveTickColor);
        } else {
            activeTrackStart2 = activeTrackStart;
        }
        contains = OffsetKt.Offset(x-impl4 += cornerSize3, Offset.getY-impl(l6));
        rangeTo = RangesKt.rangeTo(x-impl6 -= i5, x-impl20 += i5);
        int[] iArr = tickFractions;
        int i43 = 0;
        valueOf = 0;
        final int i44 = i4;
        startCornerRadius = iArr.length;
        final int i45 = 0;
        $this$forEachIndexed$iv = i45;
        while ($this$forEachIndexed$iv < startCornerRadius) {
            int i46 = i2;
            i9 = 0;
            i6 = 1;
            if (obj != null) {
            } else {
            }
            i8 = $this$forEachIndexed$iv;
            i7 = startCornerRadius;
            i3 = valueOf;
            if (Float.compare(i46, activeRangeEnd) <= 0) {
            }
            l = contains;
            box-impl = Offset.getY-impl(drawScope.getCenter-F1C5BW0());
            contains = OffsetKt.Offset(Offset.getX-impl(OffsetKt.lerp-Wko1d7g(contains, box-impl, OffsetKt.Offset(x-impl5 -= cornerSize3, Offset.getY-impl(l7)))), box-impl);
            if (obj64 != null) {
            } else {
            }
            center = contains;
            if (RangesKt.rangeTo(x-impl21 -= i11, x-impl22 += i11).contains((Comparable)Float.valueOf(Offset.getX-impl(center)))) {
            } else {
            }
            if (i6 != 0) {
            } else {
            }
            obj2 = endThumbWidth;
            tick = rangeTo;
            obj63.invoke(drawScope, Offset.box-impl(center), Color.box-impl(obj2));
            $this$forEachIndexed$iv = i8 + 1;
            valueOf = i13;
            rangeTo = tick;
            startCornerRadius = i7;
            contains = l;
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
            i6 = i45;
            if (obj64 != null) {
            } else {
            }
            i8 = $this$forEachIndexed$iv;
            i7 = startCornerRadius;
            if (valueOf == length--) {
            } else {
            }
            tick = rangeTo;
            l = contains;
            tickStartGap = obj63;
            if (valueOf != 0) {
            } else {
            }
            i8 = $this$forEachIndexed$iv;
            i7 = startCornerRadius;
            i3 = valueOf;
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
        int $dirty;
        Object $dirty2;
        int i3;
        int companion;
        int colors2;
        boolean traceInProgress2;
        int i4;
        long copy-DwJknco$default;
        Object obj;
        int skipping;
        int defaultsInvalid;
        Object empty;
        boolean z;
        Composer composer;
        long l2;
        Object obj3;
        int i12;
        Object obj2;
        int changed;
        int i;
        boolean z2;
        int i11;
        long thumbColor-vNxB06k$material3_release;
        long l;
        Object $i$a$CacheSliderDefaults$Thumb$interactions$1;
        int i6;
        int i10;
        int i13;
        Composer.Companion companion2;
        long i7;
        float constructor-impl;
        int i5;
        int i9;
        int i2;
        traceInProgress = this;
        final Object obj5 = interactionSource;
        final int i26 = i8;
        invalid$iv = -290277409;
        final Composer restartGroup = $changed.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)947@42562L8,951@42678L46,952@42767L658,952@42733L692,975@43824L5,971@43620L220:Slider.kt#uh7d8r");
        $dirty = i8;
        if (obj32 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i26 & 6 == 0) {
                i3 = restartGroup.changed(obj5) ? 4 : 2;
                $dirty |= i3;
            }
        }
        companion = obj32 & 2;
        if (companion != 0) {
            $dirty |= 48;
            obj3 = modifier;
        } else {
            if (i26 & 48 == 0) {
                i12 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i12;
            } else {
                obj3 = modifier;
            }
        }
        if (i26 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed = restartGroup.changed(colors) ? 256 : 128;
            } else {
                obj2 = colors;
            }
            $dirty |= changed;
        } else {
            obj2 = colors;
        }
        int i29 = obj32 & 8;
        if (i29 != 0) {
            $dirty |= 3072;
            z2 = enabled;
        } else {
            if (i26 & 3072 == 0) {
                i11 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i11;
            } else {
                z2 = enabled;
            }
        }
        thumbColor-vNxB06k$material3_release = obj32 & 16;
        if (thumbColor-vNxB06k$material3_release != 0) {
            $dirty |= 24576;
            l = thumbSize;
        } else {
            if (i26 & 24576 == 0) {
                i10 = restartGroup.changed(thumbSize) ? 16384 : 8192;
                $dirty |= i10;
            } else {
                l = thumbSize;
            }
        }
        i7 = 196608;
        if (obj32 & 32 != 0) {
            $dirty |= i7;
        } else {
            if (i26 & i7 == 0) {
                i13 = restartGroup.changed(traceInProgress) ? 131072 : 65536;
                $dirty |= i13;
            }
        }
        if ($dirty & companion2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i26 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (companion != 0) {
                            obj3 = companion;
                        }
                        if (obj32 & 4 != 0) {
                            $dirty &= -897;
                            obj2 = colors2;
                        }
                        if (i29 != 0) {
                            z2 = colors2;
                        }
                        if (thumbColor-vNxB06k$material3_release != 0) {
                            i7 = colors2;
                        } else {
                            i7 = l;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i7 = l;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, $dirty, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
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
                i4 = $dirty & 14 == 4 ? 1 : 0;
                composer = restartGroup;
                int i30 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i36 = 0;
                if (i4 == 0) {
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
                EffectsKt.LaunchedEffect(obj5, (Function2)anon, restartGroup, $dirty & 14);
                if (!(Collection)invalid$iv.isEmpty()) {
                    empty = 0;
                    copy-DwJknco$default = DpSize.copy-DwJknco$default(i7, obj18, Dp.constructor-impl(width-D9Ej5fM / f), 0, 2);
                } else {
                    copy-DwJknco$default = i7;
                }
                int i24 = 0;
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU(HoverableKt.hoverable$default(SizeKt.size-6HolHcs(obj3, copy-DwJknco$default), obj5, i24, 2, i36), obj2.thumbColor-vNxB06k$material3_release(z2), 0), restartGroup, i24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = $dirty;
                $dirty2 = obj3;
                l2 = i7;
                obj = obj2;
                z = z2;
            } else {
                restartGroup.skipToGroupEnd();
                i = $dirty;
                $dirty2 = obj3;
                l2 = l;
                obj = obj2;
                z = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            invalid$iv = new SliderDefaults.Thumb.2(this, obj5, $dirty2, obj, z, l2, obj3, i26, obj32);
            endRestartGroup.updateScope((Function2)invalid$iv);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(...))
    public final void Track(androidx.compose.material3.RangeSliderState rangeSliderState, Modifier modifier, androidx.compose.material3.SliderColors colors, boolean enabled, Composer $composer, int $changed, int i7) {
        boolean traceInProgress;
        Object i;
        int $dirty;
        int i3;
        Object enabled2;
        boolean z2;
        int i5;
        Object modifier2;
        Object modifier3;
        Object colors2;
        boolean z3;
        boolean traceInProgress2;
        int i2;
        Object str;
        int changed;
        float i6;
        boolean z;
        int i8;
        int i10;
        int skipping;
        int defaultsInvalid;
        int i9;
        int i4;
        final int i35 = $changed;
        i = -1617869097;
        final Composer restartGroup = $composer.startRestartGroup(i);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(3,2)1187@52807L8,1190@52865L218:Slider.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i35 & 6 == 0) {
                i5 = restartGroup.changedInstance(rangeSliderState) ? 4 : 2;
                $dirty |= i5;
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
        i6 = i7 & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else {
            if (i35 & 3072 == 0) {
                i8 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                z = enabled;
            }
        }
        if (i7 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i35 & 24576 == 0) {
                i10 = restartGroup.changed(this) ? 16384 : 8192;
                $dirty |= i10;
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
                        if (i6 != 0) {
                            i4 = $dirty;
                            $dirty = modifier3;
                            modifier2 = colors2;
                            z2 = str;
                        } else {
                            i4 = $dirty;
                            $dirty = modifier3;
                            modifier2 = colors2;
                            z2 = z;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i4 = $dirty;
                        $dirty = colors2;
                        modifier2 = str;
                        z2 = z;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i, i4, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1189)");
                }
                this.Track-4EFweAY(rangeSliderState, $dirty, z2, modifier2, 0, 0, SliderKt.access$getThumbTrackGapSize$p(), SliderKt.access$getTrackInsideCornerSize$p(), restartGroup, i15 | i29, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                enabled2 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i4 = $dirty;
                enabled2 = colors2;
                modifier2 = str;
                z3 = z;
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
        int activeTickColor;
        boolean traceInProgress;
        Composer obj;
        int $dirty;
        int i10;
        Object modifier2;
        Object inactiveTickColor;
        Object obj2;
        Object obj4;
        Object obj5;
        Object colors3;
        boolean colors2;
        int i;
        Object enabled2;
        int changed;
        boolean traceInProgress2;
        int i3;
        Object $this$cache$iv;
        int i8;
        boolean trackColor-WaAFU9c$material3_release;
        int i5;
        int i2;
        int defaultsInvalid;
        Object obj6;
        long trackColor-WaAFU9c$material3_release2;
        long it$iv;
        Composer.Companion companion;
        long activeTickColor2;
        Object obj3;
        int i9;
        int i6;
        int i4;
        long l;
        int obj27;
        int obj29;
        obj = this;
        final int i24 = $changed;
        traceInProgress = -1546713545;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(3,2)997@44755L8,1004@45160L1834,1004@45108L1886:Slider.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
            obj6 = sliderPositions;
        } else {
            if (i24 & 6 == 0) {
                i10 = restartGroup.changed(sliderPositions) ? 4 : 2;
                $dirty |= i10;
            } else {
                obj6 = sliderPositions;
            }
        }
        int i14 = i7 & 2;
        if (i14 != 0) {
            $dirty |= 48;
            obj5 = modifier;
        } else {
            if (i24 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i;
            } else {
                obj5 = modifier;
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
            trackColor-WaAFU9c$material3_release = enabled;
        } else {
            if (i24 & 3072 == 0) {
                i5 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                trackColor-WaAFU9c$material3_release = enabled;
            }
        }
        if (i7 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i24 & 24576 == 0) {
                i2 = restartGroup.changed(obj) ? 16384 : 8192;
                $dirty |= i2;
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
                            modifier2 = obj5;
                        }
                        if (i7 & 4 != 0) {
                            colors3 = obj.colors(restartGroup, i22 &= 14);
                            $dirty &= -897;
                        } else {
                            colors3 = enabled2;
                        }
                        enabled2 = i27 != 0 ? 1 : trackColor-WaAFU9c$material3_release;
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                        modifier2 = obj5;
                        colors3 = enabled2;
                        enabled2 = trackColor-WaAFU9c$material3_release;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:999)");
                }
                int i11 = 0;
                trackColor-WaAFU9c$material3_release = colors3.trackColor-WaAFU9c$material3_release(enabled2, i11);
                int i28 = 1;
                trackColor-WaAFU9c$material3_release2 = colors3.trackColor-WaAFU9c$material3_release(enabled2, i28);
                obj27 = $dirty;
                long tickColor-WaAFU9c$material3_release = colors3.tickColor-WaAFU9c$material3_release(enabled2, i11);
                activeTickColor = colors3.tickColor-WaAFU9c$material3_release(enabled2, i28);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -801023075, "CC(remember):Slider.kt#9igjgp");
                i3 = obj27 & 14 == 4 ? 1 : 0;
                boolean changed4 = restartGroup.changed(trackColor-WaAFU9c$material3_release2);
                long l2 = l3;
                Composer composer = restartGroup;
                i6 = 0;
                Object rememberedValue = composer.rememberedValue();
                i4 = 0;
                if (i30 | changed9 == 0) {
                    activeTickColor2 = activeTickColor;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        activeTickColor = 0;
                        inactiveTickColor = rememberedValue;
                        $this$cache$iv = new SliderDefaults.Track.1.1(trackColor-WaAFU9c$material3_release, defaultsInvalid, obj6, trackColor-WaAFU9c$material3_release2, obj14, l2, companion, activeTickColor2, obj18);
                        composer.updateRememberedValue((Function1)$this$cache$iv);
                    } else {
                        obj = composer;
                        it$iv = l2;
                        inactiveTickColor = $this$cache$iv;
                    }
                } else {
                    activeTickColor2 = activeTickColor;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0, i28, 0), SliderKt.getTrackHeight()), (Function1)$this$cache$iv, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i8 = obj27;
                obj4 = colors3;
                colors2 = enabled2;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                i8 = $dirty;
                obj2 = obj5;
                obj4 = enabled2;
                colors2 = trackColor-WaAFU9c$material3_release;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SliderDefaults.Track.2(this, sliderPositions, obj2, obj4, colors2, i24, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(...))
    public final void Track(androidx.compose.material3.SliderState sliderState, Modifier modifier, androidx.compose.material3.SliderColors colors, boolean enabled, Composer $composer, int $changed, int i7) {
        boolean traceInProgress2;
        Object i8;
        int $dirty;
        int i4;
        Object enabled2;
        boolean z3;
        int i5;
        Object modifier3;
        Object modifier2;
        Object colors2;
        boolean z;
        boolean traceInProgress;
        int i;
        Object str;
        int changed;
        float i2;
        boolean z2;
        int i3;
        int i9;
        int skipping;
        int defaultsInvalid;
        int i6;
        int i10;
        final int i35 = $changed;
        i8 = 593554206;
        final Composer restartGroup = $composer.startRestartGroup(i8);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(3,2)1079@48295L8,1082@48353L213:Slider.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i35 & 6 == 0) {
                i5 = restartGroup.changedInstance(sliderState) ? 4 : 2;
                $dirty |= i5;
            }
        }
        int i16 = i7 & 2;
        if (i16 != 0) {
            $dirty |= 48;
            colors2 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i;
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
        i2 = i7 & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            z2 = enabled;
        } else {
            if (i35 & 3072 == 0) {
                i3 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                z2 = enabled;
            }
        }
        if (i7 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i35 & 24576 == 0) {
                i9 = restartGroup.changed(this) ? 16384 : 8192;
                $dirty |= i9;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i35 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = colors2;
                        }
                        if (i7 & 4 != 0) {
                            colors2 = colors(restartGroup, i20 &= 14);
                            $dirty &= -897;
                        } else {
                            colors2 = str;
                        }
                        if (i2 != 0) {
                            i10 = $dirty;
                            $dirty = modifier2;
                            modifier3 = colors2;
                            z3 = str;
                        } else {
                            i10 = $dirty;
                            $dirty = modifier2;
                            modifier3 = colors2;
                            z3 = z2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i10 = $dirty;
                        $dirty = colors2;
                        modifier3 = str;
                        z3 = z2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i10, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1081)");
                }
                this.Track-4EFweAY(sliderState, $dirty, z3, modifier3, 0, 0, SliderKt.access$getThumbTrackGapSize$p(), SliderKt.access$getTrackInsideCornerSize$p(), restartGroup, i15 | i29, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z = z3;
                enabled2 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i10 = $dirty;
                enabled2 = colors2;
                modifier3 = str;
                z = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SliderDefaults.Track.3(this, sliderState, enabled2, modifier3, z, i35, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final void Track-4EFweAY(androidx.compose.material3.RangeSliderState rangeSliderState, Modifier modifier, boolean enabled, androidx.compose.material3.SliderColors colors, Function2<? super DrawScope, ? super Offset, Unit> drawStopIndicator, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> drawTick, float thumbTrackGapSize, float trackInsideCornerSize, Composer $composer, int $changed, int i11) {
        int i4;
        int traceInProgress2;
        Object obj7;
        int i17;
        int defaultsInvalid;
        int colors3;
        int colors2;
        int i8;
        Object empty;
        int changed3;
        int i6;
        int i15;
        int i22;
        Composer it$iv;
        Object drawStopIndicator3;
        Composer $composer4;
        boolean changed;
        Object empty2;
        Object anon;
        boolean enabled2;
        int i12;
        Object obj6;
        float f2;
        Object thumbTrackGapSize2;
        long colors5;
        boolean z;
        Object $composer2;
        int $dirty;
        long $dirty2;
        Object $dirty3;
        int i13;
        int i21;
        boolean traceInProgress;
        int i3;
        int i2;
        Object obj2;
        Object str;
        long l;
        float inactiveTickColor;
        int i23;
        int i19;
        float f;
        long i14;
        boolean trackColor-WaAFU9c$material3_release;
        int i10;
        Object obj4;
        float colors4;
        float inactiveTickColor2;
        Composer $composer3;
        int changed2;
        Object obj3;
        Object obj5;
        int changedInstance;
        Object obj;
        int drawStopIndicator2;
        int i20;
        int i5;
        int i24;
        int companion2;
        int i7;
        int i9;
        int i18;
        int i;
        int i16;
        Composer.Companion companion;
        long l2;
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
        $dirty = $changed;
        if (i58 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i25 & 6 == 0) {
                i13 = restartGroup.changedInstance(anon) ? 4 : 2;
                $dirty |= i13;
            }
        }
        i21 = i58 & 2;
        if (i21 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i25 & 48 == 0) {
                i23 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i23;
            } else {
                str = modifier;
            }
        }
        i19 = i58 & 4;
        if (i19 != 0) {
            $dirty |= 384;
            trackColor-WaAFU9c$material3_release = enabled;
        } else {
            if (i25 & 384 == 0) {
                i10 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i10;
            } else {
                trackColor-WaAFU9c$material3_release = enabled;
            }
        }
        if (i25 & 3072 == 0) {
            if (i58 & 8 == 0) {
                changed2 = restartGroup.changed(colors) ? 2048 : 1024;
            } else {
                obj4 = colors;
            }
            $dirty |= changed2;
        } else {
            obj4 = colors;
        }
        if (i25 & 24576 == 0) {
            if (i58 & 16 == 0) {
                changedInstance = restartGroup.changedInstance(drawStopIndicator) ? 16384 : 8192;
            } else {
                obj3 = drawStopIndicator;
            }
            $dirty |= changedInstance;
        } else {
            obj3 = drawStopIndicator;
        }
        int i73 = i58 & 32;
        i20 = 196608;
        if (i73 != 0) {
            $dirty |= i20;
            obj5 = drawTick;
        } else {
            if (i25 & i20 == 0) {
                i5 = restartGroup.changedInstance(drawTick) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                obj5 = drawTick;
            }
        }
        i24 = i58 & 64;
        i7 = 1572864;
        if (i24 != 0) {
            $dirty |= i7;
            f2 = thumbTrackGapSize;
        } else {
            if (i25 & i7 == 0) {
                i9 = restartGroup.changed(thumbTrackGapSize) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                f2 = thumbTrackGapSize;
            }
        }
        i14 = i58 & 128;
        i = 12582912;
        if (i14 != 0) {
            $dirty |= i;
            inactiveTickColor2 = trackInsideCornerSize;
        } else {
            if (i25 & i == 0) {
                i16 = restartGroup.changed(trackInsideCornerSize) ? 8388608 : 4194304;
                $dirty |= i16;
            } else {
                inactiveTickColor2 = trackInsideCornerSize;
            }
        }
        if (i58 & 256 != 0) {
            i4 = 100663296;
            $dirty |= i4;
        } else {
        }
        if (i27 &= $dirty == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i21 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i19 != 0) {
                            trackColor-WaAFU9c$material3_release = defaultsInvalid;
                        }
                        if (i11 & 8 != 0) {
                            $dirty &= -7169;
                            obj4 = colors3;
                        }
                        if (i11 & 16 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -800729349, "CC(remember):Slider.kt#9igjgp");
                            if (i33 ^= 3072 > 2048) {
                                if (!restartGroup.changed(obj4)) {
                                    i8 = $dirty & 3072 == 2048 ? 1 : 0;
                                } else {
                                }
                            } else {
                            }
                            i2 = $dirty & 896 == 256 ? 1 : 0;
                            i8 |= i2;
                            i21 = restartGroup;
                            i19 = 0;
                            Object rememberedValue2 = i21.rememberedValue();
                            i = 0;
                            if (empty == 0) {
                                obj29 = empty;
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    obj30 = invalid$iv;
                                    colors2 = new SliderDefaults.Track.9.1(obj4, trackColor-WaAFU9c$material3_release);
                                    i21.updateRememberedValue((Function2)colors2);
                                } else {
                                    colors2 = rememberedValue2;
                                }
                            } else {
                                obj29 = empty;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty &= i12;
                            obj3 = colors2;
                        }
                        if (i73 != 0) {
                            obj5 = colors2;
                        }
                        if (i24 != 0) {
                            f2 = colors2;
                        }
                        if (i14 != 0) {
                            colors4 = f2;
                            thumbTrackGapSize2 = obj10;
                            inactiveTickColor2 = f3;
                            obj7 = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        } else {
                            colors4 = f2;
                            thumbTrackGapSize2 = trackInsideCornerSize2;
                            obj7 = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i11 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i11 & 16 != 0) {
                            colors4 = f2;
                            thumbTrackGapSize2 = obj9;
                            $dirty = i31;
                            obj7 = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        } else {
                            colors4 = f2;
                            thumbTrackGapSize2 = $dirty4;
                            obj7 = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-541824132, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1236)");
                }
                int i61 = 0;
                long trackColor-WaAFU9c$material3_release2 = thumbTrackGapSize2.trackColor-WaAFU9c$material3_release(enabled2, i61);
                obj29 = colors4;
                int i66 = 1;
                trackColor-WaAFU9c$material3_release = thumbTrackGapSize2.trackColor-WaAFU9c$material3_release(enabled2, i66);
                obj30 = inactiveTickColor2;
                Object obj12 = obj3;
                long tickColor-WaAFU9c$material3_release2 = thumbTrackGapSize2.tickColor-WaAFU9c$material3_release(enabled2, i61);
                long tickColor-WaAFU9c$material3_release = thumbTrackGapSize2.tickColor-WaAFU9c$material3_release(enabled2, i66);
                int i74 = 0;
                companion2 = 0;
                int i67 = 2023513938;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i67, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i17 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1127481344 : 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -800695691, "CC(remember):Slider.kt#9igjgp");
                long l3 = obj31;
                i6 = $dirty & i75 == 1048576 ? 1 : 0;
                i15 = i52 &= $dirty == 8388608 ? 1 : 0;
                if (i55 ^= 24576 > 16384) {
                    drawStopIndicator3 = obj12;
                    if (!restartGroup.changed(drawStopIndicator3)) {
                        obj = drawStopIndicator3;
                        i22 = $dirty & 24576 == 16384 ? 1 : 0;
                    } else {
                        obj = drawStopIndicator3;
                    }
                } else {
                    drawStopIndicator3 = obj12;
                }
                i18 = i56 &= $dirty == 131072 ? 1 : 0;
                empty2 = restartGroup;
                i20 = 0;
                Object rememberedValue = empty2.rememberedValue();
                i24 = 0;
                if (obj31 | i18 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        companion2 = 0;
                        i7 = enabled2;
                        i9 = thumbTrackGapSize2;
                        obj29 = restartGroup;
                        obj30 = rememberedValue;
                        drawStopIndicator2 = $dirty;
                        anon = new SliderDefaults.Track.11.1(rangeSliderState, l3, restartGroup, trackColor-WaAFU9c$material3_release, tickColor-WaAFU9c$material3_release, tickColor-WaAFU9c$material3_release2, l3, tickColor-WaAFU9c$material3_release, trackColor-WaAFU9c$material3_release, obj29, obj30, obj, obj5);
                        obj32.updateRememberedValue((Function1)anon);
                    } else {
                        i7 = enabled2;
                        i9 = thumbTrackGapSize2;
                        it$iv = obj32;
                        obj4 = obj29;
                        obj29 = restartGroup;
                        colors5 = l3;
                        i14 = tickColor-WaAFU9c$material3_release;
                        l = tickColor-WaAFU9c$material3_release2;
                        obj3 = obj;
                        inactiveTickColor2 = obj30;
                        obj30 = anon;
                        drawStopIndicator2 = $dirty;
                        $dirty2 = l2;
                    }
                } else {
                    obj32 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(obj29);
                CanvasKt.Canvas(RotateKt.rotate(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(obj7, 0, i66, 0), SliderKt.getTrackHeight()), i17), (Function1)anon, obj29, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                inactiveTickColor = obj4;
                z = i7;
                $composer2 = i9;
                obj6 = i;
                f = inactiveTickColor2;
                $dirty3 = obj3;
                obj2 = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                $composer4 = restartGroup;
                drawStopIndicator2 = $dirty;
                obj6 = str;
                $composer2 = obj4;
                inactiveTickColor = f2;
                z = trackColor-WaAFU9c$material3_release;
                f = inactiveTickColor2;
                $dirty3 = obj3;
                obj2 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = $composer4;
            traceInProgress2 = new SliderDefaults.Track.12(this, rangeSliderState, obj6, z, $composer2, $dirty3, obj2, inactiveTickColor, f, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $composer3 = $composer4;
        }
    }

    public final void Track-4EFweAY(androidx.compose.material3.SliderState sliderState, Modifier modifier, boolean enabled, androidx.compose.material3.SliderColors colors, Function2<? super DrawScope, ? super Offset, Unit> drawStopIndicator, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> drawTick, float thumbTrackGapSize, float trackInsideCornerSize, Composer $composer, int $changed, int i11) {
        int i14;
        int traceInProgress2;
        Object obj;
        int i19;
        int defaultsInvalid;
        int colors4;
        int colors5;
        int i16;
        Object empty2;
        int changed;
        int i17;
        int i2;
        int i18;
        Composer it$iv;
        Object drawStopIndicator3;
        Composer $composer2;
        boolean changed3;
        Object empty;
        Object anon;
        boolean enabled2;
        int i15;
        Object obj4;
        float f;
        Object thumbTrackGapSize2;
        long colors3;
        boolean z;
        Object $composer4;
        int $dirty3;
        long $dirty2;
        Object $dirty;
        int i6;
        int i24;
        boolean traceInProgress;
        int i3;
        int i22;
        Object obj5;
        Object str;
        long l;
        float inactiveTickColor2;
        int i23;
        int i7;
        float f2;
        long i12;
        boolean trackColor-WaAFU9c$material3_release;
        int i;
        Object obj3;
        float colors2;
        float inactiveTickColor;
        Composer $composer3;
        int changed2;
        Object obj6;
        Object obj2;
        int changedInstance;
        Object obj7;
        int drawStopIndicator2;
        int i21;
        int i8;
        int i5;
        int companion2;
        int i20;
        int i4;
        int i13;
        int i9;
        int i10;
        Composer.Companion companion;
        long l2;
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
        i24 = i58 & 2;
        if (i24 != 0) {
            $dirty3 |= 48;
            str = modifier;
        } else {
            if (i25 & 48 == 0) {
                i23 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i23;
            } else {
                str = modifier;
            }
        }
        i7 = i58 & 4;
        if (i7 != 0) {
            $dirty3 |= 384;
            trackColor-WaAFU9c$material3_release = enabled;
        } else {
            if (i25 & 384 == 0) {
                i = restartGroup.changed(enabled) ? 256 : 128;
                $dirty3 |= i;
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
                obj6 = drawStopIndicator;
            }
            $dirty3 |= changedInstance;
        } else {
            obj6 = drawStopIndicator;
        }
        int i73 = i58 & 32;
        i21 = 196608;
        if (i73 != 0) {
            $dirty3 |= i21;
            obj2 = drawTick;
        } else {
            if (i25 & i21 == 0) {
                i8 = restartGroup.changedInstance(drawTick) ? 131072 : 65536;
                $dirty3 |= i8;
            } else {
                obj2 = drawTick;
            }
        }
        i5 = i58 & 64;
        i20 = 1572864;
        if (i5 != 0) {
            $dirty3 |= i20;
            f = thumbTrackGapSize;
        } else {
            if (i25 & i20 == 0) {
                i4 = restartGroup.changed(thumbTrackGapSize) ? 1048576 : 524288;
                $dirty3 |= i4;
            } else {
                f = thumbTrackGapSize;
            }
        }
        i12 = i58 & 128;
        i9 = 12582912;
        if (i12 != 0) {
            $dirty3 |= i9;
            inactiveTickColor = trackInsideCornerSize;
        } else {
            if (i25 & i9 == 0) {
                i10 = restartGroup.changed(trackInsideCornerSize) ? 8388608 : 4194304;
                $dirty3 |= i10;
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
                        if (i24 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i7 != 0) {
                            trackColor-WaAFU9c$material3_release = defaultsInvalid;
                        }
                        if (i11 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj3 = colors4;
                        }
                        if (i11 & 16 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -800875397, "CC(remember):Slider.kt#9igjgp");
                            if (i33 ^= 3072 > 2048) {
                                if (!restartGroup.changed(obj3)) {
                                    i16 = $dirty3 & 3072 == 2048 ? 1 : 0;
                                } else {
                                }
                            } else {
                            }
                            i22 = $dirty3 & 896 == 256 ? 1 : 0;
                            i16 |= i22;
                            i24 = restartGroup;
                            i7 = 0;
                            Object rememberedValue2 = i24.rememberedValue();
                            i9 = 0;
                            if (empty2 == 0) {
                                obj29 = empty2;
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    obj30 = invalid$iv;
                                    colors5 = new SliderDefaults.Track.4.1(obj3, trackColor-WaAFU9c$material3_release);
                                    i24.updateRememberedValue((Function2)colors5);
                                } else {
                                    colors5 = rememberedValue2;
                                }
                            } else {
                                obj29 = empty2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty3 &= i15;
                            obj6 = colors5;
                        }
                        if (i73 != 0) {
                            obj2 = colors5;
                        }
                        if (i5 != 0) {
                            f = colors5;
                        }
                        if (i12 != 0) {
                            colors2 = f;
                            thumbTrackGapSize2 = obj10;
                            inactiveTickColor = f3;
                            obj = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        } else {
                            colors2 = f;
                            thumbTrackGapSize2 = trackInsideCornerSize2;
                            obj = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i11 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i11 & 16 != 0) {
                            colors2 = f;
                            thumbTrackGapSize2 = obj9;
                            $dirty3 = i31;
                            obj = str;
                            enabled2 = trackColor-WaAFU9c$material3_release;
                        } else {
                            colors2 = f;
                            thumbTrackGapSize2 = $dirty4;
                            obj = str;
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
                obj29 = colors2;
                int i66 = 1;
                trackColor-WaAFU9c$material3_release = thumbTrackGapSize2.trackColor-WaAFU9c$material3_release(enabled2, i66);
                obj30 = inactiveTickColor;
                Object obj12 = obj6;
                long tickColor-WaAFU9c$material3_release2 = thumbTrackGapSize2.tickColor-WaAFU9c$material3_release(enabled2, i61);
                long tickColor-WaAFU9c$material3_release = thumbTrackGapSize2.tickColor-WaAFU9c$material3_release(enabled2, i66);
                int i74 = 0;
                companion2 = 0;
                int i67 = 2023513938;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i67, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i19 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1127481344 : 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -800841850, "CC(remember):Slider.kt#9igjgp");
                long l3 = obj31;
                i17 = $dirty3 & i75 == 1048576 ? 1 : 0;
                i2 = i52 &= $dirty3 == 8388608 ? 1 : 0;
                if (i55 ^= 24576 > 16384) {
                    drawStopIndicator3 = obj12;
                    if (!restartGroup.changed(drawStopIndicator3)) {
                        obj7 = drawStopIndicator3;
                        i18 = $dirty3 & 24576 == 16384 ? 1 : 0;
                    } else {
                        obj7 = drawStopIndicator3;
                    }
                } else {
                    drawStopIndicator3 = obj12;
                }
                i13 = i56 &= $dirty3 == 131072 ? 1 : 0;
                empty = restartGroup;
                i21 = 0;
                Object rememberedValue = empty.rememberedValue();
                i5 = 0;
                if (obj31 | i13 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        companion2 = 0;
                        i20 = enabled2;
                        i4 = thumbTrackGapSize2;
                        obj29 = restartGroup;
                        obj30 = rememberedValue;
                        drawStopIndicator2 = $dirty3;
                        anon = new SliderDefaults.Track.6.1(sliderState, l3, restartGroup, trackColor-WaAFU9c$material3_release, tickColor-WaAFU9c$material3_release, tickColor-WaAFU9c$material3_release2, l3, tickColor-WaAFU9c$material3_release, trackColor-WaAFU9c$material3_release, obj29, obj30, obj7, obj2);
                        obj32.updateRememberedValue((Function1)anon);
                    } else {
                        i20 = enabled2;
                        i4 = thumbTrackGapSize2;
                        it$iv = obj32;
                        obj3 = obj29;
                        obj29 = restartGroup;
                        colors3 = l3;
                        i12 = tickColor-WaAFU9c$material3_release;
                        l = tickColor-WaAFU9c$material3_release2;
                        obj6 = obj7;
                        inactiveTickColor = obj30;
                        obj30 = anon;
                        drawStopIndicator2 = $dirty3;
                        $dirty2 = l2;
                    }
                } else {
                    obj32 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(obj29);
                CanvasKt.Canvas(RotateKt.rotate(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(obj, 0, i66, 0), SliderKt.getTrackHeight()), i19), (Function1)anon, obj29, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                inactiveTickColor2 = obj3;
                z = i20;
                $composer4 = i4;
                obj4 = i9;
                f2 = inactiveTickColor;
                $dirty = obj6;
                obj5 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                $composer2 = restartGroup;
                drawStopIndicator2 = $dirty3;
                obj4 = str;
                $composer4 = obj3;
                inactiveTickColor2 = f;
                z = trackColor-WaAFU9c$material3_release;
                f2 = inactiveTickColor;
                $dirty = obj6;
                obj5 = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = $composer2;
            traceInProgress2 = new SliderDefaults.Track.7(this, sliderState, obj4, z, $composer4, $dirty, obj5, inactiveTickColor2, f2, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $composer3 = $composer2;
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
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU8;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU9;
        int unspecified-0d7_KjU4;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU7;
        int i;
        int i2;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l10;
        long l8;
        long l2;
        long l;
        long l9;
        final Composer composer = obj47;
        int i3 = obj50;
        int i4 = 885588574;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)887@39230L11:Slider.kt#uh7d8r");
        if (i3 & 1 != 0) {
            l3 = unspecified-0d7_KjU6;
        } else {
            l3 = thumbColor;
        }
        if (i3 & 2 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = activeTickColor;
        }
        if (i3 & 4 != 0) {
            l5 = unspecified-0d7_KjU8;
        } else {
            l5 = inactiveTickColor;
        }
        if (i3 & 8 != 0) {
            l6 = unspecified-0d7_KjU5;
        } else {
            l6 = disabledActiveTrackColor;
        }
        if (i3 & 16 != 0) {
            l7 = unspecified-0d7_KjU2;
        } else {
            l7 = disabledInactiveTrackColor;
        }
        if (i3 & 32 != 0) {
            l10 = unspecified-0d7_KjU9;
        } else {
            l10 = $composer;
        }
        if (i3 & 64 != 0) {
            l8 = unspecified-0d7_KjU4;
        } else {
            l8 = $changed1;
        }
        if (i3 & 128 != 0) {
            l2 = unspecified-0d7_KjU3;
        } else {
            l2 = obj41;
        }
        if (i3 & 256 != 0) {
            l = unspecified-0d7_KjU7;
        } else {
            l = obj43;
        }
        if (i3 &= 512 != 0) {
            l9 = unspecified-0d7_KjU7;
        } else {
            l9 = obj45;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, obj48, obj49, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:887)");
        } else {
            i = obj48;
            i2 = obj49;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy--K518z4(l3, obj7, l4, obj9, l5, obj11, l6, obj13, l7, obj15);
    }

    public final androidx.compose.material3.SliderColors getDefaultSliderColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultSliderColors) {
        androidx.compose.material3.SliderColors defaultSliderColorsCached$material3_release;
        int i5;
        long token3;
        long token2;
        long token5;
        long token4;
        long token;
        long compositeOver--OWjLjI;
        androidx.compose.material3.SliderColors sliderColors;
        SliderTokens iNSTANCE;
        long l4;
        float disabledActiveTrackOpacity;
        long l;
        int i8;
        long l3;
        int i2;
        int i10;
        int i4;
        float disabledActiveTrackOpacity2;
        int i3;
        int i6;
        int i;
        int i9;
        int i7;
        long l2;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultSliderColors;
        if (colorScheme.getDefaultSliderColorsCached$material3_release() == null) {
            int i12 = 0;
            disabledActiveTrackOpacity = SliderTokens.INSTANCE.getDisabledActiveTrackOpacity();
            i8 = 0;
            i2 = 0;
            i4 = 0;
            i3 = 0;
            iNSTANCE = SliderTokens.INSTANCE;
            androidx.compose.material3.SliderColors sliderColors3 = sliderColors4;
            sliderColors3 = new SliderColors(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getHandleColor()), obj4, ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), obj6, ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), obj8, ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), obj10, ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), obj12, ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledHandleColor()), obj14, SliderTokens.INSTANCE.getDisabledHandleOpacity(), 0, i12, 0, 14), obj14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), i12, disabledActiveTrackOpacity, 0, i8, 0, 14), iNSTANCE, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), i8, SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), i2, 0, i4, 14), disabledActiveTrackOpacity, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), i2, SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), i4, 0, i3, 14), i8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, iNSTANCE.getDisabledActiveTrackColor()), i4, SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), i3, 0, 0, 14), i2, 0);
            i5 = 0;
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
