package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u001b\u001a0\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001aD\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020\u00052\u0008\u0008\u0002\u0010'\u001a\u00020#2\u0008\u0008\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+\u001a8\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001aN\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0001\u0010,\u001a\u00020\u00012\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020\u00052\u0008\u0008\u0002\u0010'\u001a\u00020#2\u0008\u0008\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u00100\u001a0\u00101\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010'\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00103\u001a:\u00101\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010'\u001a\u00020#2\u0008\u0008\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u001a8\u00101\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010'\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\u00086\u00107\u001aD\u00101\u001a\u00020\u001f2\u0008\u0008\u0001\u0010,\u001a\u00020\u00012\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010'\u001a\u00020#2\u0008\u0008\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\u00088\u00109\u001a6\u0010:\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\u0008@\u0010A\u001a&\u0010B\u001a\u00020\u001f*\u00020;2\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\u0008C\u0010D\u001a6\u0010E\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\u0008F\u0010A\u001a>\u0010G\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\u0008H\u0010I\u001a>\u0010J\u001a\u00020\u001f*\u00020;2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\u0008M\u0010N\u001a.\u0010O\u001a\u00020\u001f*\u00020;2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\u0008P\u0010Q\u001a\u000c\u0010R\u001a\u00020!*\u00020!H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006S²\u0006\n\u0010T\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010U\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010V\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010W\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010X\u001a\u00020\u0008X\u008a\u0084\u0002²\u0006\n\u0010Y\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010Z\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020\u0001X\u008a\u0084\u0002", d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "LinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "backgroundColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorBackground", "drawCircularIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "increaseSemanticsBounds", "material_release", "firstLineHead", "firstLineTail", "secondLineHead", "secondLineTail", "currentRotation", "baseRotation", "endAngle"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProgressIndicatorKt {

    private static final float BaseRotationAngle = 286f;
    private static final CubicBezierEasing CircularEasing = null;
    private static final float CircularIndicatorDiameter = 0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final CubicBezierEasing FirstLineHeadEasing = null;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final CubicBezierEasing FirstLineTailEasing = null;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight = 0f;
    private static final float LinearIndicatorWidth = 0f;
    private static final float RotationAngleOffset = 216f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final CubicBezierEasing SecondLineHeadEasing = null;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final CubicBezierEasing SecondLineTailEasing = null;
    private static final float StartAngleOffset = -90f;
    static {
        ProgressIndicatorKt.LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.getStrokeWidth-D9Ej5fM();
        int i3 = 0;
        ProgressIndicatorKt.LinearIndicatorWidth = Dp.constructor-impl((float)i);
        int i4 = 0;
        ProgressIndicatorKt.CircularIndicatorDiameter = Dp.constructor-impl((float)i2);
        int i5 = 1045220557;
        int i6 = 0;
        final int i9 = 1065353216;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(i5, i6, 1061997773, i9);
        ProgressIndicatorKt.FirstLineHeadEasing = cubicBezierEasing;
        int i8 = 1053609165;
        CubicBezierEasing cubicBezierEasing2 = new CubicBezierEasing(i8, i6, i9, i9);
        ProgressIndicatorKt.FirstLineTailEasing = cubicBezierEasing2;
        CubicBezierEasing cubicBezierEasing3 = new CubicBezierEasing(i6, i6, 1059481190, i9);
        ProgressIndicatorKt.SecondLineHeadEasing = cubicBezierEasing3;
        CubicBezierEasing cubicBezierEasing4 = new CubicBezierEasing(1036831949, i6, 1055286886, i9);
        ProgressIndicatorKt.SecondLineTailEasing = cubicBezierEasing4;
        CubicBezierEasing cubicBezierEasing5 = new CubicBezierEasing(i8, i6, i5, i9);
        ProgressIndicatorKt.CircularEasing = cubicBezierEasing5;
    }

    public static final void CircularProgressIndicator-DUhRLBM(float progress, Modifier modifier, long color, float strokeWidth, long backgroundColor, int strokeCap, Composer $composer, int $changed, int i9) {
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier2;
        int $dirty;
        float empty;
        Object obj2;
        Object obj;
        int i6;
        long l2;
        int transparent-0d7_KjU;
        int butt-KaPHkGw;
        boolean traceInProgress;
        Object str;
        int i11;
        int i21;
        float f;
        int i22;
        boolean changed;
        int i5;
        long l4;
        int i12;
        int changed3;
        long l3;
        int i4;
        float f2;
        int i16;
        int $this$fastCoerceAtLeast$iv$iv;
        int i14;
        int i7;
        long l5;
        int i8;
        int i10;
        int i20;
        int i2;
        int changed2;
        int i17;
        Stroke stroke;
        long l;
        float companion;
        int i19;
        int i;
        int i18;
        int i13;
        int i3;
        int i15;
        Object obj27;
        int obj28;
        int obj29;
        int obj30;
        int obj31;
        int obj32;
        final int i48 = obj35;
        final Composer restartGroup = i9.startRestartGroup(1746618448);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(3,2,1:c#ui.graphics.Color,5:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap)322@13149L6,*328@13412L7,335@13617L251,331@13493L375:ProgressIndicator.kt#jmzs0o");
        $dirty = obj35;
        if (obj36 & 1 != 0) {
            $dirty |= 6;
            empty = progress;
        } else {
            if (i48 & 6 == 0) {
                i6 = restartGroup.changed(progress) ? 4 : 2;
                $dirty |= i6;
            } else {
                empty = progress;
            }
        }
        butt-KaPHkGw = obj36 & 2;
        if (butt-KaPHkGw != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i11 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i11;
            } else {
                str = modifier;
            }
        }
        if (i48 & 384 == 0) {
            if (obj36 & 4 == 0) {
                i21 = restartGroup.changed(color) ? 256 : 128;
            } else {
                l3 = color;
            }
            $dirty |= i21;
        } else {
            l3 = color;
        }
        i22 = obj36 & 8;
        if (i22 != 0) {
            $dirty |= 3072;
            f2 = backgroundColor;
        } else {
            if (i48 & 3072 == 0) {
                i16 = restartGroup.changed(backgroundColor) ? 2048 : 1024;
                $dirty |= i16;
            } else {
                f2 = backgroundColor;
            }
        }
        $this$fastCoerceAtLeast$iv$iv = obj36 & 16;
        if ($this$fastCoerceAtLeast$iv$iv != 0) {
            $dirty |= 24576;
            l5 = strokeCap;
        } else {
            if (i48 & 24576 == 0) {
                i8 = restartGroup.changed(strokeCap) ? 16384 : 8192;
                $dirty |= i8;
            } else {
                l5 = strokeCap;
            }
        }
        if (i48 & i56 == 0) {
            if (obj36 & 32 == 0) {
                i10 = restartGroup.changed($changed) ? 131072 : 65536;
            } else {
                i5 = $changed;
            }
            $dirty |= i10;
        } else {
            i5 = $changed;
        }
        if ($dirty & i57 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i50 = -458753;
                if (i48 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (butt-KaPHkGw != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = str;
                        }
                        if (obj36 & 4 != 0) {
                            $dirty &= -897;
                            l3 = transparent-0d7_KjU;
                        }
                        if (i22 != 0) {
                            f2 = transparent-0d7_KjU;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv != 0) {
                            l5 = transparent-0d7_KjU;
                        }
                        if (obj36 & 32 != 0) {
                            $dirty &= i50;
                            i = butt-KaPHkGw;
                        } else {
                            i = i5;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj36 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj36 & 32 != 0) {
                            $dirty = i26;
                            modifier2 = str;
                            i = i5;
                        } else {
                            modifier2 = str;
                            i = i5;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1746618448, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
                }
                int i30 = 0;
                int i32 = 1065353216;
                int i42 = 0;
                int i51 = 0;
                if (Float.compare($this$fastCoerceAtLeast$iv$iv, i30) < 0) {
                    $this$fastCoerceAtLeast$iv$iv = i30;
                }
                int i52 = 0;
                if (Float.compare($this$fastCoerceAtLeast$iv$iv, i32) > 0) {
                    $this$fastCoerceAtLeast$iv$iv = i32;
                }
                int i33 = 0;
                int i36 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i34 = 0;
                stroke = new Stroke((Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(f2), 0, i, 0, 0, 26, 0);
                Stroke $this$CircularProgressIndicator_DUhRLBM_u24lambda_u246 = stroke;
                obj27 = modifier2;
                obj30 = i53;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -973402056, "CC(remember):ProgressIndicator.kt#9igjgp");
                i12 = i45 &= $dirty == 16384 ? i2 : 0;
                if (i47 ^= 384 > 256) {
                    if (!restartGroup.changed(l3)) {
                        if ($dirty & 384 == 256) {
                        } else {
                            i2 = 0;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer = restartGroup;
                i14 = 0;
                i20 = $dirty;
                Object rememberedValue = composer.rememberedValue();
                i17 = 0;
                if (i40 |= i2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i29 = 0;
                        obj29 = l5;
                        obj27 = anon;
                        super($this$fastCoerceAtLeast$iv$iv, obj29, obj30, $this$CircularProgressIndicator_DUhRLBM_u24lambda_u246, l3, $changed);
                        l = obj29;
                        composer.updateRememberedValue((Function1)obj27);
                    } else {
                        obj = rememberedValue;
                        l = l5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics$default(obj27, $this$fastCoerceAtLeast$iv$iv, 0, obj30, 6, 0), ProgressIndicatorKt.CircularIndicatorDiameter), (Function1)obj, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = str;
                l2 = l3;
                l4 = l;
                i4 = i;
                f = f2;
            } else {
                restartGroup.skipToGroupEnd();
                i20 = $dirty;
                obj2 = str;
                l2 = l3;
                i4 = i5;
                l4 = l5;
                f = f2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.CircularProgressIndicator.2(progress, obj2, l2, str, f, l4, l3, i4, i48, obj36);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void CircularProgressIndicator-LxG7B9w(Modifier modifier, long color, float strokeWidth, long backgroundColor, int strokeCap, Composer $composer, int $changed, int i8) {
        boolean traceInProgress;
        int $dirty;
        float $dirty3;
        int i11;
        Object obj2;
        int empty;
        Object $dirty2;
        Object modifier2;
        int i7;
        int changed2;
        long l;
        int strokeCap2;
        int defaultsInvalid;
        int transparent-0d7_KjU;
        Object obj3;
        float f2;
        int i3;
        int i6;
        int i13;
        long $dirty4;
        int changed;
        int i12;
        boolean traceInProgress2;
        int str;
        int i10;
        long animateFloat2;
        int i15;
        float animateFloat;
        int i4;
        InfiniteTransition i9;
        long size-3ABfNKs;
        int i5;
        int i2;
        int changed3;
        int i14;
        Composer.Companion companion;
        int i;
        int anon;
        long l3;
        Stroke stroke;
        float f;
        long l2;
        int i16;
        State state2;
        State state3;
        State state;
        State state4;
        Object obj;
        int obj32;
        int obj33;
        int obj34;
        InfiniteRepeatableSpec obj35;
        int obj36;
        Composer obj37;
        int obj38;
        int obj39;
        final int i45 = obj40;
        traceInProgress = -1119119072;
        final Composer restartGroup = i8.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(2,1:c#ui.graphics.Color,4:c#ui.unit.Dp,0:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)361@14861L6,*366@15070L7,370@15169L28,372@15327L278,384@15720L230,395@16068L346,407@16449L355,422@16918L538,418@16809L647:ProgressIndicator.kt#jmzs0o");
        $dirty = obj40;
        int i27 = obj41 & 1;
        if (i27 != 0) {
            $dirty |= 6;
            obj3 = modifier;
        } else {
            if (i45 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj3 = modifier;
            }
        }
        if (i45 & 48 == 0) {
            if (obj41 & 2 == 0) {
                i6 = restartGroup.changed(color) ? 32 : 16;
            } else {
                animateFloat2 = color;
            }
            $dirty |= i6;
        } else {
            animateFloat2 = color;
        }
        int i37 = obj41 & 4;
        if (i37 != 0) {
            $dirty |= 384;
            animateFloat = backgroundColor;
        } else {
            if (i45 & 384 == 0) {
                i4 = restartGroup.changed(backgroundColor) ? 256 : 128;
                $dirty |= i4;
            } else {
                animateFloat = backgroundColor;
            }
        }
        i9 = obj41 & 8;
        if (i9 != 0) {
            $dirty |= 3072;
            size-3ABfNKs = strokeCap;
        } else {
            i5 = i45 & 3072;
            if (i5 == 0) {
                changed3 = restartGroup.changed(strokeCap) ? 2048 : 1024;
                $dirty |= changed3;
            } else {
                size-3ABfNKs = strokeCap;
            }
        }
        if (i45 & 24576 == 0) {
            if (obj41 & 16 == 0) {
                changed3 = restartGroup.changed($changed) ? 16384 : 8192;
            } else {
                i12 = $changed;
            }
            $dirty |= changed3;
        } else {
            i12 = $changed;
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -57345;
                if (i45 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i27 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj3;
                        }
                        if (obj41 & 2 != 0) {
                            $dirty &= -113;
                            animateFloat2 = transparent-0d7_KjU;
                        }
                        if (i37 != 0) {
                            animateFloat = transparent-0d7_KjU;
                        }
                        if (i9 != 0) {
                            size-3ABfNKs = transparent-0d7_KjU;
                        }
                        if (obj41 & 16 != 0) {
                            i13 = $dirty5;
                            i16 = square-KaPHkGw;
                            strokeCap2 = animateFloat2;
                            $dirty3 = animateFloat;
                            l3 = size-3ABfNKs;
                        } else {
                            i13 = $dirty;
                            i16 = i12;
                            strokeCap2 = animateFloat2;
                            $dirty3 = animateFloat;
                            l3 = size-3ABfNKs;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj41 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj41 & 16 != 0) {
                            i13 = $dirty6;
                            modifier2 = obj3;
                            i16 = i12;
                            strokeCap2 = animateFloat2;
                            $dirty3 = animateFloat;
                            l3 = size-3ABfNKs;
                        } else {
                            i13 = $dirty;
                            modifier2 = obj3;
                            i16 = i12;
                            strokeCap2 = animateFloat2;
                            $dirty3 = animateFloat;
                            l3 = size-3ABfNKs;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i13, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:365)");
                }
                int i39 = 0;
                int i43 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i40 = 0;
                Stroke stroke2 = new Stroke((Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4($dirty3), 0, i16, 0, 0, 26, 0);
                Stroke $this$CircularProgressIndicator_LxG7B9w_u24lambda_u248 = stroke2;
                int i44 = 0;
                int i47 = 0;
                int i48 = 1;
                int i53 = i48;
                f = $dirty3;
                obj = modifier2;
                int i90 = 0;
                obj35 = i90;
                int i73 = 0;
                InfiniteTransition infiniteTransition = rememberInfiniteTransition;
                anon = 1;
                State animateValue = InfiniteTransitionKt.animateValue(infiniteTransition, Integer.valueOf(i47), 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)AnimationSpecKt.tween$default(6660, i47, EasingKt.getLinearEasing(), 2, i44), 0, obj35, strokeCap, 6), i73, restartGroup, i29 | i55, 16);
                obj35 = infiniteRepeatable-9IiC70o$default2;
                State animateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransition, 0, 1133445120, obj35, i73, restartGroup, i51 |= i58, 8);
                int i85 = 0;
                obj32 = infiniteTransition;
                obj35 = infiniteRepeatable-9IiC70o$default3;
                animateFloat2 = InfiniteTransitionKt.animateFloat(obj32, 0, 1133576192, obj35, i85, restartGroup, i61 |= i68, 8);
                obj32 = infiniteTransition2;
                animateFloat = InfiniteTransitionKt.animateFloat(obj32, 0, 1133576192, AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)AnimationSpecKt.keyframes((Function1)ProgressIndicatorKt.CircularProgressIndicator.startAngle.2.INSTANCE), i85, i90, obj35, 6), 0, restartGroup, i71 |= i76, 8);
                i9 = obj32;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -973296137, "CC(remember):ProgressIndicator.kt#9igjgp");
                i11 = i13 & 7168 == 2048 ? anon : 0;
                i7 = i13 & 896 == 256 ? anon : 0;
                if (i32 ^= 48 > 32) {
                    if (!restartGroup.changed(strokeCap2)) {
                        if (i13 & 48 == 32) {
                        } else {
                            anon = 0;
                        }
                    } else {
                    }
                } else {
                }
                i26 |= anon;
                Composer composer = restartGroup;
                i5 = 0;
                Object rememberedValue = composer.rememberedValue();
                i14 = 0;
                if (empty == 0) {
                    obj32 = empty;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int invalid$iv = 0;
                        anon = new ProgressIndicatorKt.CircularProgressIndicator.3.1(l3, obj22, $this$CircularProgressIndicator_LxG7B9w_u24lambda_u248, f, strokeCap2, i16, animateValue, animateFloat2, animateFloat, animateFloat3);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        obj2 = rememberedValue;
                        l2 = strokeCap2;
                        state4 = animateFloat3;
                        state3 = animateFloat2;
                        state2 = animateValue;
                        state = animateFloat;
                    }
                } else {
                    obj32 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(obj), ProgressIndicatorKt.CircularIndicatorDiameter), (Function1)obj2, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i15 = i13;
                i10 = i12;
                $dirty4 = l3;
                f2 = f;
                l = l2;
                $dirty2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                i10 = i12;
                l = animateFloat2;
                $dirty4 = size-3ABfNKs;
                i15 = $dirty;
                $dirty2 = obj3;
                f2 = animateFloat;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ProgressIndicatorKt.CircularProgressIndicator.4($dirty2, l, strokeCap2, f2, $dirty4, i12, i10, i45, obj41);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void CircularProgressIndicator-MBs18nI(float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i7) {
        boolean traceInProgress2;
        int $dirty;
        int i;
        Object obj2;
        Object modifier2;
        boolean traceInProgress;
        Object color2;
        long l;
        int i6;
        long l2;
        float f2;
        float strokeWidth-D9Ej5fM;
        float f3;
        int changed;
        int modifier3;
        Object obj;
        float f;
        int i2;
        boolean defaultsInvalid;
        float i5;
        long transparent-0d7_KjU;
        int butt-KaPHkGw;
        int i3;
        int i4;
        final int i20 = i7;
        traceInProgress2 = -409649739;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)441@17676L6,443@17756L157:ProgressIndicator.kt#jmzs0o");
        $dirty = i7;
        if (obj25 & 1 != 0) {
            $dirty |= 6;
            f3 = progress;
        } else {
            if (i20 & 6 == 0) {
                i = restartGroup.changed(progress) ? 4 : 2;
                $dirty |= i;
            } else {
                f3 = progress;
            }
        }
        int i12 = obj25 & 2;
        if (i12 != 0) {
            $dirty |= 48;
            color2 = modifier;
        } else {
            if (i20 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i6;
            } else {
                color2 = modifier;
            }
        }
        if (i20 & 384 == 0) {
            if (obj25 & 4 == 0) {
                changed = restartGroup.changed(color) ? 256 : 128;
            } else {
                l2 = color;
            }
            $dirty |= changed;
        } else {
            l2 = color;
        }
        int i21 = obj25 & 8;
        if (i21 != 0) {
            $dirty |= 3072;
            f = $composer;
        } else {
            if (i20 & 3072 == 0) {
                i2 = restartGroup.changed($composer) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                f = $composer;
            }
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i20 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = color2;
                        }
                        if (obj25 & 4 != 0) {
                            color2 = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getPrimary-0d7_KjU();
                            $dirty &= -897;
                        } else {
                            color2 = l2;
                        }
                        if (i21 != 0) {
                            obj = modifier2;
                            f = color2;
                            i5 = strokeWidth-D9Ej5fM;
                        } else {
                            obj = modifier2;
                            i5 = f;
                            f = color2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj25 & 4 != 0) {
                            $dirty &= -897;
                        }
                        obj = color2;
                        i5 = f;
                        f = l2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:443)");
                }
                ProgressIndicatorKt.CircularProgressIndicator-DUhRLBM(f3, obj, f, defaultsInvalid, i5, Color.Companion.getTransparent-0d7_KjU(), obj13, StrokeCap.Companion.getButt-KaPHkGw(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj;
                l = f;
                f2 = i5;
                modifier3 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = color2;
                l = l2;
                f2 = f;
                modifier3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.CircularProgressIndicator.5(progress, obj2, l, l2, f2, i20, obj25);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void CircularProgressIndicator-aM-cp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty;
        Object $dirty2;
        Object modifier2;
        boolean traceInProgress;
        long l;
        Object strokeWidth-D9Ej5fM;
        int i4;
        int i3;
        int changed;
        float f;
        long color2;
        long l2;
        int color3;
        float f2;
        int i2;
        int skipping;
        int defaultsInvalid;
        int transparent-0d7_KjU;
        int square-KaPHkGw;
        int i;
        int i5;
        long l3;
        final int i15 = i6;
        traceInProgress2 = -392089979;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)456@18110L6,458@18190L145:ProgressIndicator.kt#jmzs0o");
        $dirty = i6;
        int i10 = obj24 & 1;
        if (i10 != 0) {
            $dirty |= 6;
            strokeWidth-D9Ej5fM = modifier;
        } else {
            if (i15 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i4;
            } else {
                strokeWidth-D9Ej5fM = modifier;
            }
        }
        if (i15 & 48 == 0) {
            if (obj24 & 2 == 0) {
                i3 = restartGroup.changed(color) ? 32 : 16;
            } else {
                color2 = color;
            }
            $dirty |= i3;
        } else {
            color2 = color;
        }
        int i14 = obj24 & 4;
        if (i14 != 0) {
            $dirty |= 384;
            f2 = $composer;
        } else {
            if (i15 & 384 == 0) {
                i2 = restartGroup.changed($composer) ? 256 : 128;
                $dirty |= i2;
            } else {
                f2 = $composer;
            }
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i15 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = strokeWidth-D9Ej5fM;
                        }
                        if (obj24 & 2 != 0) {
                            color2 = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getPrimary-0d7_KjU();
                            $dirty &= -113;
                        }
                        if (i14 != 0) {
                            skipping = strokeWidth-D9Ej5fM;
                            l2 = color2;
                            color2 = modifier2;
                        } else {
                            skipping = f2;
                            l2 = color2;
                            color2 = modifier2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj24 & 2 != 0) {
                            $dirty &= -113;
                        }
                        skipping = f2;
                        l2 = color2;
                        color2 = strokeWidth-D9Ej5fM;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:458)");
                }
                ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w(color2, l2, f2, skipping, Color.Companion.getTransparent-0d7_KjU(), obj11, StrokeCap.Companion.getSquare-KaPHkGw(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l = l2;
                f = skipping;
                color3 = $dirty;
                $dirty2 = color2;
            } else {
                restartGroup.skipToGroupEnd();
                color3 = $dirty;
                $dirty2 = strokeWidth-D9Ej5fM;
                l = l3;
                f = f2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.CircularProgressIndicator.6($dirty2, l, strokeWidth-D9Ej5fM, f, i15, obj24);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$10(State<Float> $baseRotation$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$baseRotation$delegate.getValue().floatValue();
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$11(State<Float> $endAngle$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$endAngle$delegate.getValue().floatValue();
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$12(State<Float> $startAngle$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$startAngle$delegate.getValue().floatValue();
    }

    private static final int CircularProgressIndicator_LxG7B9w$lambda$9(State<Integer> $currentRotation$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$currentRotation$delegate.getValue().intValue();
    }

    public static final void LinearProgressIndicator-2cYBFYY(Modifier modifier, long color, long backgroundColor, int strokeCap, Composer $composer, int $changed, int i7) {
        int $dirty2;
        boolean traceInProgress2;
        int $dirty3;
        int $dirty5;
        Object $dirty4;
        Object modifier2;
        long modifier3;
        Object color2;
        androidx.compose.material.Colors colors;
        long strokeCap3;
        int i;
        int i4;
        int i17;
        int i11;
        long l3;
        boolean changed2;
        int changed5;
        int i8;
        State state4;
        int i13;
        int i10;
        long $dirty;
        long backgroundColor2;
        int backgroundColor4;
        boolean traceInProgress;
        State animateFloat;
        long str2;
        long backgroundColor3;
        String str;
        int changed;
        int firstLineTail$delegate;
        int defaultsInvalid;
        boolean changed3;
        int changed4;
        long l;
        int i16;
        Composer $this$cache$iv;
        int companion;
        int strokeCap2;
        int i14;
        int i12;
        int i6;
        int animateFloat2;
        int animateFloat4;
        State animateFloat3;
        State state5;
        int i5;
        int i2;
        int i3;
        int i15;
        int i9;
        int i19;
        int i18;
        State state;
        State state3;
        State state2;
        long l2;
        androidx.compose.animation.core.KeyframesSpec obj37;
        int obj38;
        int obj39;
        int obj41;
        int obj42;
        final int i40 = obj44;
        traceInProgress2 = 1501635280;
        final Composer restartGroup = i7.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)140@6509L6,144@6678L28,148@6960L320,159@7325L320,170@7691L324,181@8061L324,197@8556L624,192@8390L790:ProgressIndicator.kt#jmzs0o");
        $dirty3 = obj44;
        int i25 = obj45 & 1;
        if (i25 != 0) {
            $dirty3 |= 6;
            color2 = modifier;
        } else {
            if (i40 & 6 == 0) {
                i = restartGroup.changed(modifier) ? 4 : 2;
                $dirty3 |= i;
            } else {
                color2 = modifier;
            }
        }
        if (i40 & 48 == 0) {
            if (obj45 & 2 == 0) {
                i4 = restartGroup.changed(color) ? 32 : 16;
            } else {
                $dirty = color;
            }
            $dirty3 |= i4;
        } else {
            $dirty = color;
        }
        int i39 = 256;
        if (i40 & 384 == 0) {
            if (obj45 & 4 == 0) {
                i17 = restartGroup.changed(strokeCap) ? i39 : 128;
            } else {
                str2 = strokeCap;
            }
            $dirty3 |= i17;
        } else {
            str2 = strokeCap;
        }
        str = 2048;
        if (i40 & 3072 == 0) {
            if (obj45 & 8 == 0) {
                changed = restartGroup.changed($changed) ? str : 1024;
            } else {
                i11 = $changed;
            }
            $dirty3 |= changed;
        } else {
            i11 = $changed;
        }
        $this$cache$iv = 1170;
        if ($dirty3 & 1171 == $this$cache$iv) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i40 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i25 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = color2;
                        }
                        if (obj45 & 2 != 0) {
                            $dirty3 &= -113;
                            defaultsInvalid = $dirty;
                        } else {
                            defaultsInvalid = $dirty;
                        }
                        if (obj45 & 4 != 0) {
                            backgroundColor2 = Color.copy-wmQWz5c$default(defaultsInvalid, $this$cache$iv, 1047904911, 0, 0, 0, 14);
                            $dirty3 &= -897;
                        } else {
                            backgroundColor2 = str2;
                        }
                        if (obj45 & 8 != 0) {
                            backgroundColor4 = $dirty6;
                            $dirty5 = butt-KaPHkGw;
                            strokeCap3 = defaultsInvalid;
                            l = l2;
                        } else {
                            backgroundColor4 = $dirty3;
                            $dirty5 = i11;
                            strokeCap3 = defaultsInvalid;
                            l = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj45 & 2 != 0) {
                            $dirty3 &= -113;
                        }
                        if (obj45 & 4 != 0) {
                            $dirty3 &= -897;
                        }
                        if (obj45 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        modifier2 = color2;
                        l = str2;
                        backgroundColor4 = $dirty3;
                        $dirty5 = i11;
                        strokeCap3 = l2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, backgroundColor4, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:143)");
                }
                int i41 = 0;
                int i49 = 1;
                int i71 = i41;
                i12 = i49;
                i6 = str;
                int i60 = 0;
                int backgroundColor5 = 8;
                $dirty = rememberInfiniteTransition;
                int infiniteTransition = i34;
                int i35 = i6;
                long l5 = l4;
                i19 = 6;
                i18 = 0;
                i15 = 0;
                i9 = 0;
                animateFloat = InfiniteTransitionKt.animateFloat($dirty, 0, 1065353216, AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)AnimationSpecKt.keyframes((Function1)ProgressIndicatorKt.LinearProgressIndicator.secondLineTail.2.INSTANCE), i15, i9, obj29, i19), i60, restartGroup, i47 | i55, backgroundColor5);
                str = "CC(remember):ProgressIndicator.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1318218425, str);
                if (i58 ^= 384 > i39) {
                    if (!restartGroup.changed(l5)) {
                        i13 = infiniteTransition & 384 == i39 ? i12 : 0;
                    } else {
                    }
                } else {
                    backgroundColor3 = l5;
                }
                if (i67 ^= 3072 > i35) {
                    if (!restartGroup.changed($dirty5)) {
                        i8 = infiniteTransition & 3072 == i35 ? i12 : 0;
                    } else {
                    }
                } else {
                }
                State state6 = state8;
                State state7 = state9;
                if (i68 ^= 48 > 32) {
                    if (!restartGroup.changed(strokeCap3)) {
                        if (i5 & 48 == 32) {
                        } else {
                            i12 = 0;
                        }
                    } else {
                    }
                } else {
                }
                state4 = state10;
                $this$cache$iv = restartGroup;
                i2 = 0;
                Object rememberedValue = $this$cache$iv.rememberedValue();
                i3 = 0;
                if (i22 |= changed10 == 0) {
                    strokeCap2 = $dirty5;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        $dirty5 = 0;
                        animateFloat3 = state4;
                        animateFloat2 = state6;
                        firstLineTail$delegate = new ProgressIndicatorKt.LinearProgressIndicator.3.1(backgroundColor3, companion, strokeCap2, strokeCap3, i6, animateFloat2, state7, animateFloat3, animateFloat);
                        state = animateFloat2;
                        state2 = animateFloat3;
                        $this$cache$iv.updateRememberedValue((Function1)firstLineTail$delegate);
                    } else {
                        i14 = strokeCap3;
                        state2 = state4;
                        state = state6;
                        state5 = animateFloat;
                        state3 = state7;
                        color2 = $this$cache$iv;
                        firstLineTail$delegate = rememberedValue;
                    }
                } else {
                    strokeCap2 = $dirty5;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.size-VpY3zN4(ProgressSemanticsKt.progressSemantics(ProgressIndicatorKt.increaseSemanticsBounds(modifier2)), ProgressIndicatorKt.LinearIndicatorWidth, ProgressIndicatorKt.LinearIndicatorHeight), (Function1)firstLineTail$delegate, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty4 = modifier2;
                l3 = backgroundColor3;
                i10 = strokeCap2;
                modifier3 = i14;
            } else {
                restartGroup.skipToGroupEnd();
                i5 = $dirty3;
                $dirty4 = color2;
                i10 = i11;
                modifier3 = $dirty;
                l3 = str2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.LinearProgressIndicator.4($dirty4, modifier3, color2, l3, state4, i10, i40, obj45);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void LinearProgressIndicator-RIQooxk(Modifier modifier, long color, long backgroundColor, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty;
        Object $dirty2;
        Object modifier2;
        boolean traceInProgress;
        long l;
        Object copy-wmQWz5c$default;
        long primary-0d7_KjU;
        int i4;
        long l4;
        long l3;
        int changed;
        long l7;
        long l2;
        int color2;
        int changed2;
        int defaultsInvalid;
        long i5;
        int butt-KaPHkGw;
        long l5;
        long i7;
        int i;
        int i2;
        int i9;
        int i8;
        int i3;
        int i10;
        long l6;
        final int i20 = obj30;
        traceInProgress2 = -819397058;
        final Composer restartGroup = i6.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)240@9807L6,242@9903L104:ProgressIndicator.kt#jmzs0o");
        $dirty = obj30;
        int i13 = obj31 & 1;
        if (i13 != 0) {
            $dirty |= 6;
            copy-wmQWz5c$default = modifier;
        } else {
            if (i20 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i4;
            } else {
                copy-wmQWz5c$default = modifier;
            }
        }
        if (i20 & 48 == 0) {
            if (obj31 & 2 == 0) {
                changed = restartGroup.changed(color) ? 32 : 16;
            } else {
                l4 = color;
            }
            $dirty |= changed;
        } else {
            l4 = color;
        }
        if (i20 & 384 == 0) {
            if (obj31 & 4 == 0) {
                changed2 = restartGroup.changed($composer) ? 256 : 128;
            } else {
                l7 = $composer;
            }
            $dirty |= changed2;
        } else {
            l7 = $composer;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i20 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = copy-wmQWz5c$default;
                        }
                        if (obj31 & 2 != 0) {
                            $dirty &= -113;
                            l5 = primary-0d7_KjU;
                        } else {
                            l5 = l4;
                        }
                        if (obj31 & 4 != 0) {
                            $dirty &= -897;
                            l7 = modifier2;
                            i5 = copy-wmQWz5c$default;
                            l2 = l5;
                        } else {
                            i5 = l7;
                            l2 = l5;
                            l7 = modifier2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj31 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj31 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i5 = l7;
                        l7 = copy-wmQWz5c$default;
                        l2 = l4;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:242)");
                }
                ProgressIndicatorKt.LinearProgressIndicator-2cYBFYY(l7, l2, defaultsInvalid, i5, obj11, StrokeCap.Companion.getButt-KaPHkGw(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l = l2;
                l3 = i5;
                color2 = $dirty;
                $dirty2 = l7;
            } else {
                restartGroup.skipToGroupEnd();
                color2 = $dirty;
                $dirty2 = copy-wmQWz5c$default;
                l = l4;
                l3 = l6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.LinearProgressIndicator.6($dirty2, l, copy-wmQWz5c$default, l3, obj5, i20, obj31);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void LinearProgressIndicator-_5eSR-E(float progress, Modifier modifier, long color, long backgroundColor, int strokeCap, Composer $composer, int $changed, int i8) {
        boolean traceInProgress;
        int $dirty2;
        float f;
        Object modifier4;
        int i9;
        Object modifier2;
        long modifier3;
        Object butt-KaPHkGw;
        int colors;
        boolean traceInProgress2;
        int changed4;
        int i2;
        int i10;
        int i19;
        int i11;
        int changed3;
        int i15;
        long l2;
        boolean changed;
        int rememberedValue;
        int defaultsInvalid;
        int changed5;
        int i7;
        int changed6;
        int i13;
        int i3;
        int i17;
        long backgroundColor2;
        long backgroundColor3;
        Object color2;
        long l;
        long l4;
        int i4;
        int changed2;
        int $i$f$fastCoerceIn;
        long l3;
        int $this$fastCoerceAtLeast$iv$iv;
        int companion;
        int i5;
        int i14;
        int i16;
        int $dirty;
        int i;
        int i6;
        int i18;
        int i12;
        Modifier obj25;
        int obj26;
        int obj27;
        int obj28;
        int obj29;
        int obj30;
        final int i42 = obj32;
        traceInProgress = -531984864;
        final Composer restartGroup = i8.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap)107@5008L6,117@5389L204,112@5208L385:ProgressIndicator.kt#jmzs0o");
        $dirty2 = obj32;
        if (obj33 & 1 != 0) {
            $dirty2 |= 6;
            f = progress;
        } else {
            if (i42 & 6 == 0) {
                i9 = restartGroup.changed(progress) ? 4 : 2;
                $dirty2 |= i9;
            } else {
                f = progress;
            }
        }
        int i23 = obj33 & 2;
        if (i23 != 0) {
            $dirty2 |= 48;
            butt-KaPHkGw = modifier;
        } else {
            if (i42 & 48 == 0) {
                i10 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i10;
            } else {
                butt-KaPHkGw = modifier;
            }
        }
        if (i42 & 384 == 0) {
            if (obj33 & 4 == 0) {
                i19 = restartGroup.changed(color) ? 256 : 128;
            } else {
                backgroundColor2 = color;
            }
            $dirty2 |= i19;
        } else {
            backgroundColor2 = color;
        }
        int i38 = 2048;
        if (i42 & 3072 == 0) {
            if (obj33 & 8 == 0) {
                i11 = restartGroup.changed(strokeCap) ? i38 : 1024;
            } else {
                l4 = strokeCap;
            }
            $dirty2 |= i11;
        } else {
            l4 = strokeCap;
        }
        i17 = 16384;
        if (i42 & 24576 == 0) {
            if (obj33 & 16 == 0) {
                changed2 = restartGroup.changed($changed) ? i17 : 8192;
            } else {
                i15 = $changed;
            }
            $dirty2 |= changed2;
        } else {
            i15 = $changed;
        }
        if ($dirty2 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i43 = -57345;
                if (i42 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = butt-KaPHkGw;
                        }
                        if (obj33 & 4 != 0) {
                            $dirty2 &= -897;
                            l3 = backgroundColor2;
                        } else {
                            l3 = backgroundColor2;
                        }
                        if (obj33 & 8 != 0) {
                            backgroundColor3 = Color.copy-wmQWz5c$default(l3, obj17, 1047904911, 0, 0, 0, 14);
                            $dirty2 &= -7169;
                        } else {
                            backgroundColor3 = l4;
                        }
                        if (obj33 & 16 != 0) {
                            $dirty2 &= i43;
                            i15 = butt-KaPHkGw;
                            l4 = backgroundColor3;
                            backgroundColor2 = l3;
                        } else {
                            l4 = backgroundColor3;
                            backgroundColor2 = l3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj33 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj33 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (obj33 & 16 != 0) {
                            $dirty2 &= i43;
                        }
                        modifier2 = butt-KaPHkGw;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:110)");
                }
                int i20 = 0;
                int i29 = 1065353216;
                int i44 = 0;
                int i46 = 0;
                if (Float.compare($this$fastCoerceAtLeast$iv$iv, i20) < 0) {
                    $this$fastCoerceAtLeast$iv$iv = i20;
                }
                int i47 = 0;
                if (Float.compare($this$fastCoerceAtLeast$iv$iv, i29) > 0) {
                    $this$fastCoerceAtLeast$iv$iv = i29;
                }
                $i$f$fastCoerceIn = $this$fastCoerceAtLeast$iv$iv;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1318320189, "CC(remember):ProgressIndicator.kt#9igjgp");
                companion = 1;
                if (i32 ^= 3072 > i38) {
                    if (!restartGroup.changed(l4)) {
                        i2 = $dirty2 & 3072 == i38 ? companion : 0;
                    } else {
                    }
                } else {
                }
                if (i40 ^= 24576 > i17) {
                    if (!restartGroup.changed(i15)) {
                        i7 = $dirty2 & 24576 == i17 ? companion : 0;
                    } else {
                    }
                } else {
                }
                if (i41 ^= 384 > 256) {
                    if (!restartGroup.changed(backgroundColor2)) {
                        if ($dirty2 & 384 == 256) {
                        } else {
                            companion = 0;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer = restartGroup;
                i17 = 0;
                rememberedValue = composer.rememberedValue();
                i14 = 0;
                if (i34 |= companion == 0) {
                    $dirty = $dirty2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        $dirty2 = 0;
                        color2 = new ProgressIndicatorKt.LinearProgressIndicator.1.1(l4, l4, i15, $i$f$fastCoerceIn, backgroundColor2, i5);
                        composer.updateRememberedValue((Function1)color2);
                    } else {
                        l3 = backgroundColor2;
                        l = l4;
                        i4 = i15;
                        color2 = rememberedValue;
                    }
                } else {
                    $dirty = $dirty2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.size-VpY3zN4(ProgressSemanticsKt.progressSemantics$default(ProgressIndicatorKt.increaseSemanticsBounds(modifier2), $i$f$fastCoerceIn, 0, i5, 6, 0), ProgressIndicatorKt.LinearIndicatorWidth, ProgressIndicatorKt.LinearIndicatorHeight), (Function1)color2, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l2 = l;
                i13 = i4;
                backgroundColor2 = l3;
            } else {
                restartGroup.skipToGroupEnd();
                $dirty = $dirty2;
                modifier2 = butt-KaPHkGw;
                i13 = i15;
                l2 = l4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ProgressIndicatorKt.LinearProgressIndicator.2(f, modifier2, backgroundColor2, butt-KaPHkGw, l2, rememberedValue, i13, i42, obj33);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            modifier4 = modifier2;
            modifier3 = backgroundColor2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void LinearProgressIndicator-eaDK9VM(float progress, Modifier modifier, long color, long backgroundColor, Composer $composer, int $changed, int i7) {
        boolean traceInProgress;
        int $dirty;
        int i6;
        Object modifier3;
        boolean traceInProgress2;
        Object obj2;
        Object copy-wmQWz5c$default;
        int primary-0d7_KjU;
        long l5;
        int i10;
        long l4;
        long l7;
        int changed2;
        int i5;
        int changed;
        int defaultsInvalid;
        float f;
        long l6;
        Object obj;
        int modifier2;
        long l;
        long l3;
        int butt-KaPHkGw;
        long l2;
        int i11;
        int i2;
        int i3;
        int i4;
        int i;
        int i8;
        int i9;
        final int i23 = obj31;
        traceInProgress = -850309746;
        final Composer restartGroup = i7.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)226@9398L6,228@9494L118:ProgressIndicator.kt#jmzs0o");
        $dirty = obj31;
        if (obj32 & 1 != 0) {
            $dirty |= 6;
            f = progress;
        } else {
            if (i23 & 6 == 0) {
                i6 = restartGroup.changed(progress) ? 4 : 2;
                $dirty |= i6;
            } else {
                f = progress;
            }
        }
        int i15 = obj32 & 2;
        if (i15 != 0) {
            $dirty |= 48;
            copy-wmQWz5c$default = modifier;
        } else {
            if (i23 & 48 == 0) {
                i10 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i10;
            } else {
                copy-wmQWz5c$default = modifier;
            }
        }
        if (i23 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed2 = restartGroup.changed(color) ? 256 : 128;
            } else {
                l4 = color;
            }
            $dirty |= changed2;
        } else {
            l4 = color;
        }
        if (i23 & 3072 == 0) {
            if (obj32 & 8 == 0) {
                i5 = restartGroup.changed($composer) ? 2048 : 1024;
            } else {
                l6 = $composer;
            }
            $dirty |= i5;
        } else {
            l6 = $composer;
        }
        final int i24 = 1170;
        if ($dirty & 1171 == i24) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i23 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = copy-wmQWz5c$default;
                        }
                        if (obj32 & 4 != 0) {
                            $dirty &= -897;
                            l2 = primary-0d7_KjU;
                        } else {
                            l2 = l4;
                        }
                        if (obj32 & 8 != 0) {
                            $dirty &= -7169;
                            obj = modifier3;
                            l3 = copy-wmQWz5c$default;
                            l = l2;
                        } else {
                            l3 = l6;
                            l = l2;
                            obj = modifier3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        l3 = l6;
                        obj = copy-wmQWz5c$default;
                        l = l4;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:228)");
                }
                ProgressIndicatorKt.LinearProgressIndicator-_5eSR-E(f, obj, l, i24, l3, obj13, StrokeCap.Companion.getButt-KaPHkGw(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj;
                l5 = l;
                l7 = l3;
                modifier2 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = copy-wmQWz5c$default;
                l5 = l4;
                l7 = l6;
                modifier2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ProgressIndicatorKt.LinearProgressIndicator.5(progress, obj2, l5, l4, l7, defaultsInvalid, i23, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$1(State<Float> $firstLineHead$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$firstLineHead$delegate.getValue().floatValue();
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$2(State<Float> $firstLineTail$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$firstLineTail$delegate.getValue().floatValue();
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$3(State<Float> $secondLineHead$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$secondLineHead$delegate.getValue().floatValue();
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$4(State<Float> $secondLineTail$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$secondLineTail$delegate.getValue().floatValue();
    }

    public static final float access$CircularProgressIndicator_LxG7B9w$lambda$10(State $baseRotation$delegate) {
        return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$10($baseRotation$delegate);
    }

    public static final float access$CircularProgressIndicator_LxG7B9w$lambda$11(State $endAngle$delegate) {
        return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$11($endAngle$delegate);
    }

    public static final float access$CircularProgressIndicator_LxG7B9w$lambda$12(State $startAngle$delegate) {
        return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$12($startAngle$delegate);
    }

    public static final int access$CircularProgressIndicator_LxG7B9w$lambda$9(State $currentRotation$delegate) {
        return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$9($currentRotation$delegate);
    }

    public static final float access$LinearProgressIndicator_2cYBFYY$lambda$1(State $firstLineHead$delegate) {
        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1($firstLineHead$delegate);
    }

    public static final float access$LinearProgressIndicator_2cYBFYY$lambda$2(State $firstLineTail$delegate) {
        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2($firstLineTail$delegate);
    }

    public static final float access$LinearProgressIndicator_2cYBFYY$lambda$3(State $secondLineHead$delegate) {
        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3($secondLineHead$delegate);
    }

    public static final float access$LinearProgressIndicator_2cYBFYY$lambda$4(State $secondLineTail$delegate) {
        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4($secondLineTail$delegate);
    }

    public static final void access$drawCircularIndicatorBackground-bw27NRU(DrawScope $receiver, long color, Stroke stroke) {
        ProgressIndicatorKt.drawCircularIndicatorBackground-bw27NRU($receiver, color, stroke);
    }

    public static final void access$drawDeterminateCircularIndicator-42QJj7c(DrawScope $receiver, float startAngle, float sweep, long color, Stroke stroke) {
        ProgressIndicatorKt.drawDeterminateCircularIndicator-42QJj7c($receiver, startAngle, sweep, color, stroke);
    }

    public static final void access$drawIndeterminateCircularIndicator-hrjfTZI(DrawScope $receiver, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        ProgressIndicatorKt.drawIndeterminateCircularIndicator-hrjfTZI($receiver, startAngle, strokeWidth, sweep, color, stroke);
    }

    public static final void access$drawLinearIndicator-qYKTg0g(DrawScope $receiver, float startFraction, float endFraction, long color, float strokeWidth, int strokeCap) {
        ProgressIndicatorKt.drawLinearIndicator-qYKTg0g($receiver, startFraction, endFraction, color, strokeWidth, strokeCap);
    }

    public static final void access$drawLinearIndicatorBackground-AZGd3zU(DrawScope $receiver, long color, float strokeWidth, int strokeCap) {
        ProgressIndicatorKt.drawLinearIndicatorBackground-AZGd3zU($receiver, color, strokeWidth, strokeCap);
    }

    public static final CubicBezierEasing access$getCircularEasing$p() {
        return ProgressIndicatorKt.CircularEasing;
    }

    public static final CubicBezierEasing access$getFirstLineHeadEasing$p() {
        return ProgressIndicatorKt.FirstLineHeadEasing;
    }

    public static final CubicBezierEasing access$getFirstLineTailEasing$p() {
        return ProgressIndicatorKt.FirstLineTailEasing;
    }

    public static final CubicBezierEasing access$getSecondLineHeadEasing$p() {
        return ProgressIndicatorKt.SecondLineHeadEasing;
    }

    public static final CubicBezierEasing access$getSecondLineTailEasing$p() {
        return ProgressIndicatorKt.SecondLineTailEasing;
    }

    private static final void drawCircularIndicator-42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = (float)i2;
        width /= f;
        width-impl -= i3;
        DrawScope.drawArc-yD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, obj5, startAngle, sweep, 0, OffsetKt.Offset(i, i), obj10, SizeKt.Size(i4, i4), obj12, 0, (DrawStyle)obj24, 0);
    }

    private static final void drawCircularIndicatorBackground-bw27NRU(DrawScope $this$drawCircularIndicatorBackground_u2dbw27NRU, long color, Stroke stroke) {
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c($this$drawCircularIndicatorBackground_u2dbw27NRU, 0, 1135869952, color, obj4);
    }

    private static final void drawDeterminateCircularIndicator-42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    private static final void drawIndeterminateCircularIndicator-hrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        int i;
        int butt-KaPHkGw;
        int i2;
        int i3;
        if (StrokeCap.equals-impl0(obj13.getCap-KaPHkGw(), StrokeCap.Companion.getButt-KaPHkGw())) {
            i = 0;
        } else {
            i2 = 0;
            int i7 = 0;
            i4 /= butt-KaPHkGw;
        }
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, startAngle + i, Math.max(sweep, 1036831949), color, obj5);
    }

    private static final void drawLinearIndicator-qYKTg0g(DrawScope $this$drawLinearIndicator_u2dqYKTg0g, float startFraction, float endFraction, long color, float strokeWidth, int strokeCap) {
        float i14;
        int i17;
        int i8;
        int i13;
        boolean rangeTo;
        int i5;
        float adjustedBarStart2;
        float floatValue;
        int cmp;
        int i23;
        long l3;
        int i;
        int i9;
        int i2;
        int i3;
        int i11;
        int i18;
        int i4;
        int i21;
        float adjustedBarStart;
        float f;
        int i10;
        DrawScope drawScope;
        long l2;
        long l;
        int i7;
        int i12;
        int i19;
        int i20;
        int i15;
        int i6;
        int i16;
        int i22;
        float width-impl = Size.getWidth-impl($this$drawLinearIndicator_u2dqYKTg0g.getSize-NH-jbRc());
        float height-impl = Size.getHeight-impl($this$drawLinearIndicator_u2dqYKTg0g.getSize-NH-jbRc());
        i14 = (float)i24;
        final int i25 = height-impl / i14;
        i17 = $this$drawLinearIndicator_u2dqYKTg0g.getLayoutDirection() == LayoutDirection.Ltr ? 1 : 0;
        int i26 = 1065353216;
        i13 = i17 != 0 ? startFraction : i26 - endFraction;
        i13 *= width-impl;
        i8 = i17 != 0 ? endFraction : i26 - startFraction;
        i8 *= width-impl;
        i5 = obj46;
        if (!StrokeCap.equals-impl0(i5, StrokeCap.Companion.getButt-KaPHkGw())) {
            if (Float.compare(height-impl, width-impl) > 0) {
                DrawScope.drawLine-NGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, obj27, OffsetKt.Offset(i28, i25), obj29, OffsetKt.Offset(i27, i25), obj31, strokeCap, 0, 0, 0, 0);
            } else {
                i14 = strokeCap / i14;
                rangeTo = RangesKt.rangeTo(i14, width-impl - i14);
                adjustedBarStart2 = (Number)RangesKt.coerceIn((Comparable)Float.valueOf(i28), rangeTo).floatValue();
                floatValue = (Number)RangesKt.coerceIn((Comparable)Float.valueOf(i27), rangeTo).floatValue();
                i23 = 0;
                if (Float.compare(f2, i23) > 0) {
                    adjustedBarStart = adjustedBarStart2;
                    f = floatValue;
                    DrawScope.drawLine-NGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, floatValue, OffsetKt.Offset(adjustedBarStart2, i25), i23, OffsetKt.Offset(floatValue, i25), obj14, strokeCap, i5, 0, 0, 0);
                } else {
                    adjustedBarStart = adjustedBarStart2;
                    f = floatValue;
                }
            }
        } else {
        }
    }

    private static final void drawLinearIndicatorBackground-AZGd3zU(DrawScope $this$drawLinearIndicatorBackground_u2dAZGd3zU, long color, float strokeWidth, int strokeCap) {
        ProgressIndicatorKt.drawLinearIndicator-qYKTg0g($this$drawLinearIndicatorBackground_u2dAZGd3zU, 0, 1065353216, color, obj4, strokeCap);
    }

    public static final Modifier increaseSemanticsBounds(Modifier $this$increaseSemanticsBounds) {
        int i2 = 0;
        float $this$dp$iv = Dp.constructor-impl((float)i);
        ProgressIndicatorKt.increaseSemanticsBounds.1 anon = new ProgressIndicatorKt.increaseSemanticsBounds.1($this$dp$iv);
        final int i4 = 1;
        return PaddingKt.padding-VpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout($this$increaseSemanticsBounds, (Function3)anon), i4, (Function1)ProgressIndicatorKt.increaseSemanticsBounds.2.INSTANCE), 0, $this$dp$iv, i4, 0);
    }
}
