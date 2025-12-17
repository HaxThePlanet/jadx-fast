package androidx.compose.material3;

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
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
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
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u001aR\u0010%\u001a\u00020&2\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00010(2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020\u00052\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u00101\u001a\\\u0010%\u001a\u00020&2\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00010(2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020\u00052\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0008\u0008\u0002\u00102\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u00104\u001a0\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u00085\u00106\u001aD\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020\u00052\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\u00087\u00108\u001a8\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u00089\u0010:\u001aL\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020\u00052\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u0010;\u001aH\u0010<\u001a\u00020&2\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00010(2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>\u001am\u0010<\u001a\u00020&2\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00010(2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0008\u0008\u0002\u00102\u001a\u00020\u00052\u0019\u0008\u0002\u0010?\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020&0@¢\u0006\u0002\u0008BH\u0007ø\u0001\u0000¢\u0006\u0004\u0008C\u0010D\u001a0\u0010<\u001a\u00020&2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\u0008E\u0010F\u001a:\u0010<\u001a\u00020&2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\u0008G\u0010H\u001aD\u0010<\u001a\u00020&2\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0008\u0008\u0002\u00102\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008I\u0010J\u001a8\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\u0008K\u0010L\u001aB\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0008\u0008\u0002\u0010)\u001a\u00020\u00132\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\u0008=\u0010M\u001a6\u0010N\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\u0008S\u0010T\u001a&\u0010U\u001a\u00020&*\u00020A2\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\u0008V\u0010W\u001a6\u0010X\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010T\u001a>\u0010Z\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\u0008[\u0010\\\u001a>\u0010]\u001a\u00020&*\u00020A2\u0006\u0010^\u001a\u00020\u00012\u0006\u0010_\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\u0008`\u0010a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0016\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0017\u0010\u0007\"\u0016\u0010\u0018\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0019\u0010\u0007\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008\"\u000e\u0010$\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006b", d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "IncreaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "SemanticsBoundsPadding", "StartAngleOffset", "CircularProgressIndicator", "", "progress", "Lkotlin/Function0;", "modifier", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "gapSize", "CircularProgressIndicator-IyT6zlY", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "LinearProgressIndicator-GJbTh5U", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJIFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-rIrjwxo", "(Landroidx/compose/ui/Modifier;JJIFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
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
    private static final Modifier IncreaseSemanticsBounds = null;
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
    private static final float SemanticsBoundsPadding = 0f;
    private static final float StartAngleOffset = -90f;
    static {
        int i3 = 0;
        ProgressIndicatorKt.SemanticsBoundsPadding = Dp.constructor-impl((float)i);
        int i6 = 1;
        final int i15 = 0;
        ProgressIndicatorKt.IncreaseSemanticsBounds = PaddingKt.padding-VpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout((Modifier)Modifier.Companion, (Function3)ProgressIndicatorKt.IncreaseSemanticsBounds.1.INSTANCE), i6, (Function1)ProgressIndicatorKt.IncreaseSemanticsBounds.2.INSTANCE), i15, ProgressIndicatorKt.SemanticsBoundsPadding, i6, 0);
        int i4 = 0;
        ProgressIndicatorKt.LinearIndicatorWidth = Dp.constructor-impl((float)i2);
        ProgressIndicatorKt.LinearIndicatorHeight = ProgressIndicatorTokens.INSTANCE.getTrackThickness-D9Ej5fM();
        int i12 = 0;
        int i8 = 0;
        ProgressIndicatorKt.CircularIndicatorDiameter = Dp.constructor-impl(size-D9Ej5fM - arg0$iv2);
        int i5 = 1045220557;
        int i14 = 1065353216;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(i5, i15, 1061997773, i14);
        ProgressIndicatorKt.FirstLineHeadEasing = cubicBezierEasing;
        int i10 = 1053609165;
        CubicBezierEasing cubicBezierEasing2 = new CubicBezierEasing(i10, i15, i14, i14);
        ProgressIndicatorKt.FirstLineTailEasing = cubicBezierEasing2;
        CubicBezierEasing cubicBezierEasing3 = new CubicBezierEasing(i15, i15, 1059481190, i14);
        ProgressIndicatorKt.SecondLineHeadEasing = cubicBezierEasing3;
        CubicBezierEasing cubicBezierEasing4 = new CubicBezierEasing(1036831949, i15, 1055286886, i14);
        ProgressIndicatorKt.SecondLineTailEasing = cubicBezierEasing4;
        CubicBezierEasing cubicBezierEasing5 = new CubicBezierEasing(i10, i15, i5, i14);
        ProgressIndicatorKt.CircularEasing = cubicBezierEasing5;
    }

    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(...))
    public static final void CircularProgressIndicator-DUhRLBM(float progress, Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, int $changed, int i9) {
        boolean traceInProgress2;
        int defaultsInvalid;
        int circularStrokeWidth-D9Ej5fM;
        int iNSTANCE;
        int i13;
        int i4;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int i5;
        int i6;
        boolean traceInProgress;
        float f2;
        int str;
        Object obj;
        long l;
        int i14;
        long circularColor;
        int i3;
        int empty;
        int changed2;
        int anon;
        float f;
        int modifier2;
        Object strokeWidth2;
        int i10;
        long trackColor2;
        int changed;
        int i;
        int i7;
        int i15;
        int i8;
        int i11;
        Composer composer;
        int i2;
        int i12;
        final float f3 = progress;
        final int i37 = obj31;
        Composer restartGroup = i9.startRestartGroup(-1472321743);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)730@30011L13,732@30145L18,736@30302L12,735@30256L216:ProgressIndicator.kt#uh7d8r");
        $dirty2 = obj31;
        if (obj32 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i37 & 6 == 0) {
                i5 = restartGroup.changed(f3) ? 4 : 2;
                $dirty2 |= i5;
            }
        }
        i6 = obj32 & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i37 & 48 == 0) {
                i14 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i14;
            } else {
                obj = modifier;
            }
        }
        if (i37 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed2 = restartGroup.changed(color) ? 256 : 128;
            } else {
                circularColor = color;
            }
            $dirty2 |= changed2;
        } else {
            circularColor = color;
        }
        anon = obj32 & 8;
        if (anon != 0) {
            $dirty2 |= 3072;
            f = trackColor;
        } else {
            if (i37 & 3072 == 0) {
                i10 = restartGroup.changed(trackColor) ? 2048 : 1024;
                $dirty2 |= i10;
            } else {
                f = trackColor;
            }
        }
        if (i37 & 24576 == 0) {
            if (obj32 & 16 == 0) {
                changed = restartGroup.changed(strokeCap) ? 16384 : 8192;
            } else {
                trackColor2 = strokeCap;
            }
            $dirty2 |= changed;
        } else {
            trackColor2 = strokeCap;
        }
        i = obj32 & 32;
        int i41 = 196608;
        if (i != 0) {
            $dirty2 |= i41;
            i7 = $changed;
        } else {
            if (i41 &= i37 == 0) {
                i15 = restartGroup.changed($changed) ? 131072 : 65536;
                $dirty2 |= i15;
            } else {
                i7 = $changed;
            }
        }
        int i43 = 74899;
        if ($dirty2 & i43 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -57345;
                if (i37 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            obj = defaultsInvalid;
                        }
                        i6 = 6;
                        if (obj32 & 4 != 0) {
                            circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(restartGroup, i6);
                            $dirty2 &= -897;
                        }
                        if (anon != 0) {
                            f = circularStrokeWidth-D9Ej5fM;
                        }
                        if (obj32 & 16 != 0) {
                            trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(restartGroup, i6);
                            $dirty2 &= str;
                        }
                        if (i != 0) {
                            i8 = circularDeterminateStrokeCap-KaPHkGw;
                            i = f;
                            i7 = trackColor2;
                            i13 = -1472321743;
                            strokeWidth2 = obj;
                            trackColor2 = circularColor;
                        } else {
                            i = f;
                            i8 = i7;
                            i13 = -1472321743;
                            strokeWidth2 = obj;
                            i7 = trackColor2;
                            trackColor2 = circularColor;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj32 & 16 != 0) {
                            $dirty2 = i19;
                            i = f;
                            i8 = i7;
                            i13 = -1472321743;
                            strokeWidth2 = obj;
                            i7 = trackColor2;
                            trackColor2 = circularColor;
                        } else {
                            i = f;
                            i8 = i7;
                            i13 = -1472321743;
                            strokeWidth2 = obj;
                            i7 = trackColor2;
                            trackColor2 = circularColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i13, $dirty2, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:735)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -291425076, "CC(remember):ProgressIndicator.kt#9igjgp");
                i4 = $dirty2 & 14 == 4 ? 1 : 0;
                Composer composer2 = restartGroup;
                int i33 = 0;
                Object rememberedValue = composer2.rememberedValue();
                circularColor = 0;
                if (i4 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new ProgressIndicatorKt.CircularProgressIndicator.7.1(f3);
                        composer2.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ProgressIndicatorKt.CircularProgressIndicator-IyT6zlY((Function0)anon, strokeWidth2, trackColor2, obj13, i, i7, i43, i8, 0, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = strokeWidth2;
                f2 = i;
                l = i7;
                i3 = i8;
                modifier2 = $dirty2;
                $dirty = trackColor2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj;
                f2 = f;
                modifier2 = $dirty2;
                $dirty = circularColor;
                l = trackColor2;
                i3 = i7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.CircularProgressIndicator.8(f3, $composer2, $dirty, i6, f2, l, circularColor, i3, i37, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyCircularProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(...))
    public static final void CircularProgressIndicator-DUhRLBM(Function0 progress, Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier4;
        int modifier2;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i;
        int circularStrokeWidth-D9Ej5fM;
        int circularDeterminateStrokeCap-KaPHkGw;
        boolean traceInProgress;
        long l3;
        Object str;
        int i3;
        long circularColor;
        float f2;
        long l;
        int changed;
        float f;
        int i6;
        Object obj;
        int i11;
        long l4;
        Object trackColor2;
        int modifier3;
        long l5;
        int changed2;
        int i5;
        int i10;
        long i8;
        int i2;
        float circularIndicatorTrackGapSize-D9Ej5fM;
        Composer composer;
        int i4;
        int i7;
        long l2;
        final int i35 = obj33;
        restartGroup = i9.startRestartGroup(-761680467);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)529@21735L13,531@21869L29,534@21991L217:ProgressIndicator.kt#uh7d8r");
        $dirty2 = obj33;
        if (obj34 & 1 != 0) {
            $dirty2 |= 6;
            obj = progress;
        } else {
            if (i35 & 6 == 0) {
                i = restartGroup.changedInstance(progress) ? 4 : 2;
                $dirty2 |= i;
            } else {
                obj = progress;
            }
        }
        circularDeterminateStrokeCap-KaPHkGw = obj34 & 2;
        if (circularDeterminateStrokeCap-KaPHkGw != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i35 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                str = modifier;
            }
        }
        if (i35 & 384 == 0) {
            if (obj34 & 4 == 0) {
                changed = restartGroup.changed(color) ? 256 : 128;
            } else {
                circularColor = color;
            }
            $dirty2 |= changed;
        } else {
            circularColor = color;
        }
        int i33 = obj34 & 8;
        if (i33 != 0) {
            $dirty2 |= 3072;
            f = trackColor;
        } else {
            if (i35 & 3072 == 0) {
                i11 = restartGroup.changed(trackColor) ? 2048 : 1024;
                $dirty2 |= i11;
            } else {
                f = trackColor;
            }
        }
        if (i35 & 24576 == 0) {
            if (obj34 & 16 == 0) {
                changed2 = restartGroup.changed(strokeCap) ? 16384 : 8192;
            } else {
                l4 = strokeCap;
            }
            $dirty2 |= changed2;
        } else {
            l4 = strokeCap;
        }
        int i38 = obj34 & 32;
        int i39 = 196608;
        if (i38 != 0) {
            $dirty2 |= i39;
            i5 = $changed;
        } else {
            if (i39 &= i35 == 0) {
                i10 = restartGroup.changed($changed) ? 131072 : 65536;
                $dirty2 |= i10;
            } else {
                i5 = $changed;
            }
        }
        if (i41 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i42 = -57345;
                if (i35 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (circularDeterminateStrokeCap-KaPHkGw != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = str;
                        }
                        str = 6;
                        if (obj34 & 4 != 0) {
                            circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(restartGroup, str);
                            $dirty2 &= -897;
                        }
                        if (i33 != 0) {
                            f = circularStrokeWidth-D9Ej5fM;
                        }
                        if (obj34 & 16 != 0) {
                            $dirty2 &= i42;
                            l4 = circularDeterminateStrokeCap-KaPHkGw;
                        }
                        if (i38 != 0) {
                            i2 = circularDeterminateStrokeCap-KaPHkGw;
                            i5 = f;
                            i8 = l4;
                            trackColor2 = modifier4;
                            l5 = circularColor;
                            modifier2 = -761680467;
                        } else {
                            i8 = l4;
                            i2 = i5;
                            trackColor2 = modifier4;
                            l5 = circularColor;
                            i5 = f;
                            modifier2 = -761680467;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj34 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj34 & 16 != 0) {
                            $dirty2 = i21;
                            i8 = l4;
                            i2 = i5;
                            modifier2 = -761680467;
                            trackColor2 = str;
                            l5 = circularColor;
                            i5 = f;
                        } else {
                            i8 = l4;
                            i2 = i5;
                            modifier2 = -761680467;
                            trackColor2 = str;
                            l5 = circularColor;
                            i5 = f;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, $dirty2, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:533)");
                }
                ProgressIndicatorKt.CircularProgressIndicator-IyT6zlY(obj, trackColor2, l5, i38, i5, i8, obj16, i2, ProgressIndicatorDefaults.INSTANCE.getCircularIndicatorTrackGapSize-D9Ej5fM(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = $dirty2;
                $dirty = obj3;
                l3 = l5;
                f2 = i5;
                l = i8;
                i6 = i2;
            } else {
                restartGroup.skipToGroupEnd();
                modifier3 = $dirty2;
                $dirty = str;
                l3 = circularColor;
                l = l2;
                composer = restartGroup;
                f2 = f;
                i6 = i5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.CircularProgressIndicator.1(progress, $dirty, l3, str, f2, l, i33, i6, i35, obj34);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void CircularProgressIndicator-IyT6zlY(Function0<Float> progress, Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, float gapSize, Composer $composer, int $changed, int i10) {
        boolean traceInProgress2;
        int i7;
        Object invalid$iv;
        Object $i$a$CacheProgressIndicatorKt$CircularProgressIndicator$3;
        int obj;
        int $dirty3;
        Object $dirty;
        long $dirty2;
        int i;
        long l2;
        int circularDeterminateTrackColor;
        int companion;
        int circularStrokeWidth-D9Ej5fM;
        int skipping;
        int defaultsInvalid;
        Object obj2;
        float modifier2;
        int i2;
        int i6;
        long l;
        boolean traceInProgress;
        int changed4;
        long l6;
        long l5;
        int i4;
        int changed;
        float f;
        int str;
        Object $i$a$CacheProgressIndicatorKt$CircularProgressIndicator$2;
        boolean changed3;
        float empty;
        int i19;
        float i8;
        int i14;
        int i15;
        int i13;
        int i9;
        int i3;
        int i21;
        int i11;
        int i17;
        int changed5;
        int changed2;
        int rememberedValue;
        int i22;
        int i16;
        int i5;
        int i20;
        Composer.Companion companion2;
        int i23;
        int i12;
        int i18;
        androidx.compose.material3.ProgressIndicatorKt.CircularProgressIndicator.3.1 color2;
        Object coercedProgress;
        int i24;
        float f3;
        float f2;
        long l4;
        Stroke stroke;
        long l3;
        boolean obj32;
        int obj33;
        int obj34;
        int obj35;
        int obj36;
        int obj37;
        int obj38;
        int obj39;
        obj = progress;
        final int i39 = obj41;
        traceInProgress2 = -1798883595;
        final Composer restartGroup = i10.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(3,2,0:c#ui.graphics.Color,5:c#ui.unit.Dp,6:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap,1:c#ui.unit.Dp)575@23884L13,577@24018L29,581@24237L31,*582@24304L7,585@24446L102,589@24600L709,583@24373L936:ProgressIndicator.kt#uh7d8r");
        $dirty3 = obj41;
        if (obj42 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i39 & 6 == 0) {
                i = restartGroup.changedInstance(obj) ? 4 : 2;
                $dirty3 |= i;
            }
        }
        companion = obj42 & 2;
        if (companion != 0) {
            $dirty3 |= 48;
            obj2 = modifier;
        } else {
            if (i39 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i2;
            } else {
                obj2 = modifier;
            }
        }
        if (i39 & 384 == 0) {
            if (obj42 & 4 == 0) {
                i6 = restartGroup.changed(color) ? 256 : 128;
            } else {
                l5 = color;
            }
            $dirty3 |= i6;
        } else {
            l5 = color;
        }
        int i30 = obj42 & 8;
        if (i30 != 0) {
            $dirty3 |= 3072;
            i8 = trackColor;
        } else {
            if (i39 & 3072 == 0) {
                i15 = restartGroup.changed(trackColor) ? 2048 : 1024;
                $dirty3 |= i15;
            } else {
                i8 = trackColor;
            }
        }
        if (i39 & 24576 == 0) {
            if (obj42 & 16 == 0) {
                changed = restartGroup.changed(strokeCap) ? 16384 : 8192;
            } else {
                l6 = strokeCap;
            }
            $dirty3 |= changed;
        } else {
            l6 = strokeCap;
        }
        str = obj42 & 32;
        i5 = 196608;
        if (str != null) {
            $dirty3 |= i5;
            rememberedValue = $composer;
        } else {
            if (i39 & i5 == 0) {
                i20 = restartGroup.changed($composer) ? 131072 : 65536;
                $dirty3 |= i20;
            } else {
                rememberedValue = $composer;
            }
        }
        int i62 = obj42 & 64;
        i23 = 1572864;
        if (i62 != 0) {
            $dirty3 |= i23;
            empty = $changed;
        } else {
            if (i39 & i23 == 0) {
                i12 = restartGroup.changed($changed) ? 1048576 : 524288;
                $dirty3 |= i12;
            } else {
                empty = $changed;
            }
        }
        if ($dirty3 & i18 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i42 = -57345;
                if (i39 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (companion != 0) {
                            obj2 = companion;
                        }
                        int i28 = 6;
                        if (obj42 & 4 != 0) {
                            color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(restartGroup, i28);
                            $dirty3 &= -897;
                        } else {
                            color2 = color;
                        }
                        if (i30 != 0) {
                            i8 = circularStrokeWidth-D9Ej5fM;
                        }
                        if (obj42 & 16 != 0) {
                            $dirty3 &= i42;
                            l6 = circularDeterminateTrackColor;
                        }
                        if (str != null) {
                            rememberedValue = circularDeterminateTrackColor;
                        }
                        if (i62 != 0) {
                            skipping = $dirty3;
                            f3 = circularDeterminateTrackColor;
                            i24 = rememberedValue;
                            $dirty2 = color2;
                        } else {
                            skipping = $dirty3;
                            f3 = empty;
                            i24 = rememberedValue;
                            $dirty2 = color2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj42 & 4 != 0) {
                            $dirty3 &= -897;
                        }
                        if (obj42 & 16 != 0) {
                            $dirty3 &= i42;
                        }
                        skipping = $dirty3;
                        f3 = empty;
                        i24 = rememberedValue;
                        $dirty2 = color;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, skipping, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:580)");
                }
                String str4 = "CC(remember):ProgressIndicator.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -291619137, str4);
                i7 = skipping & 14 == 4 ? 1 : 0;
                Composer composer2 = restartGroup;
                int i56 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i63 = 0;
                if (i7 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj32 = i7;
                        invalid$iv = new ProgressIndicatorKt.CircularProgressIndicator.coercedProgress.1.1(obj);
                        composer2.updateRememberedValue((Function0)invalid$iv);
                    } else {
                        obj32 = i7;
                        invalid$iv = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i40 = 0;
                int i44 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i37 = 0;
                super((Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(i8), 0, i24, 0, 0, 26, 0);
                Stroke $this$CircularProgressIndicator_IyT6zlY_u24lambda_u247 = stroke2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -291612378, str4);
                changed3 = restartGroup.changed((Function0)invalid$iv);
                Composer composer = restartGroup;
                int i46 = 0;
                Object rememberedValue3 = composer.rememberedValue();
                i18 = 0;
                if (!changed3) {
                    obj32 = changed3;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        obj33 = invalid$iv2;
                        $i$a$CacheProgressIndicatorKt$CircularProgressIndicator$2 = new ProgressIndicatorKt.CircularProgressIndicator.2.1(invalid$iv);
                        composer.updateRememberedValue((Function1)$i$a$CacheProgressIndicatorKt$CircularProgressIndicator$2);
                    } else {
                        $i$a$CacheProgressIndicatorKt$CircularProgressIndicator$2 = rememberedValue3;
                    }
                } else {
                    obj32 = changed3;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i19 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -291606843, str4);
                i3 = i48 &= skipping == 131072 ? i19 : 0;
                i21 = i50 &= skipping == 1048576 ? i19 : 0;
                i11 = skipping & 7168 == 2048 ? i19 : 0;
                if (i54 ^= 24576 > 16384) {
                    if (!restartGroup.changed(l6)) {
                        i17 = skipping & 24576 == 16384 ? i19 : 0;
                    } else {
                    }
                } else {
                }
                if (i55 ^= 384 > 256) {
                    if (!restartGroup.changed($dirty2)) {
                        if (skipping & 384 == 256) {
                        } else {
                            i19 = 0;
                        }
                    } else {
                    }
                } else {
                }
                empty = restartGroup;
                i9 = 0;
                rememberedValue = empty.rememberedValue();
                i5 = 0;
                if (i35 |= i19 == 0) {
                    coercedProgress = invalid$iv;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int coercedProgress2 = 0;
                        color2 = new ProgressIndicatorKt.CircularProgressIndicator.3.1(coercedProgress, i24, f3, i8, l6, obj27, $this$CircularProgressIndicator_IyT6zlY_u24lambda_u247, $dirty2, obj30);
                        empty.updateRememberedValue((Function1)color2);
                    } else {
                        stroke = $this$CircularProgressIndicator_IyT6zlY_u24lambda_u247;
                        l3 = $dirty2;
                        l4 = l6;
                        f2 = i8;
                        $i$a$CacheProgressIndicatorKt$CircularProgressIndicator$3 = rememberedValue;
                    }
                } else {
                    coercedProgress = invalid$iv;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.size-3ABfNKs(SemanticsModifierKt.semantics(obj2, i19, (Function1)$i$a$CacheProgressIndicatorKt$CircularProgressIndicator$2), ProgressIndicatorKt.CircularIndicatorDiameter), (Function1)$i$a$CacheProgressIndicatorKt$CircularProgressIndicator$3, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i14 = skipping;
                $dirty = obj2;
                i4 = i24;
                f = f3;
                modifier2 = f2;
                l = l4;
                l2 = l3;
            } else {
                restartGroup.skipToGroupEnd();
                i14 = $dirty3;
                $dirty = obj2;
                modifier2 = f4;
                l2 = color;
                l = l6;
                f = empty;
                i4 = rememberedValue;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.CircularProgressIndicator.4(progress, $dirty, l2, skipping, modifier2, l, l6, i4, f, i39, obj42);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void CircularProgressIndicator-LxG7B9w(Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, int $changed, int i8) {
        int changed4;
        int i12;
        int i9;
        boolean changed;
        boolean traceInProgress2;
        int $dirty;
        float $dirty4;
        Object $i$a$CacheProgressIndicatorKt$CircularProgressIndicator$5;
        Object empty;
        Object $dirty3;
        Object modifier2;
        long l4;
        int skipping;
        int defaultsInvalid;
        int circularStrokeWidth-D9Ej5fM;
        int circularIndeterminateTrackColor;
        Object obj;
        float f;
        int i;
        int i11;
        long l5;
        long l;
        int changed3;
        int i7;
        int i19;
        int $dirty2;
        long circularColor;
        boolean traceInProgress;
        String str;
        int i17;
        float infiniteRepeatableSpec;
        int i10;
        int i16;
        int changed2;
        androidx.compose.runtime.State i2;
        long size-3ABfNKs;
        int i3;
        Composer composer;
        int i6;
        int i13;
        int i4;
        Composer.Companion companion;
        int i18;
        int anon;
        long l2;
        int i15;
        int i5;
        Stroke stroke;
        androidx.compose.runtime.State state2;
        androidx.compose.runtime.State state;
        androidx.compose.runtime.State state4;
        androidx.compose.runtime.State state3;
        float f2;
        long l3;
        int i14;
        Object obj2;
        int obj34;
        int obj35;
        int obj36;
        InfiniteRepeatableSpec obj37;
        int obj38;
        Composer obj39;
        int obj40;
        int obj41;
        final int i42 = obj42;
        traceInProgress2 = -115871647;
        final Composer restartGroup = i8.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,4:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)633@26429L13,635@26563L31,*638@26720L7,640@26807L28,643@26972L350,657@27444L208,666@27777L422,679@28240L431,691@28745L628,691@28676L697:ProgressIndicator.kt#uh7d8r");
        $dirty = obj42;
        int i35 = obj43 & 1;
        if (i35 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i42 & 6 == 0) {
                i = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i;
            } else {
                obj = modifier;
            }
        }
        if (i42 & 48 == 0) {
            if (obj43 & 2 == 0) {
                i11 = restartGroup.changed(color) ? 32 : 16;
            } else {
                circularColor = color;
            }
            $dirty |= i11;
        } else {
            circularColor = color;
        }
        int i39 = obj43 & 4;
        if (i39 != 0) {
            $dirty |= 384;
            infiniteRepeatableSpec = trackColor;
        } else {
            if (i42 & 384 == 0) {
                i10 = restartGroup.changed(trackColor) ? 256 : 128;
                $dirty |= i10;
            } else {
                infiniteRepeatableSpec = trackColor;
            }
        }
        if (i42 & 3072 == 0) {
            if (obj43 & 8 == 0) {
                i16 = restartGroup.changed(strokeCap) ? 2048 : 1024;
            } else {
                size-3ABfNKs = strokeCap;
            }
            $dirty |= i16;
        } else {
            size-3ABfNKs = strokeCap;
        }
        i2 = obj43 & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            i7 = $changed;
        } else {
            if (i42 & 24576 == 0) {
                i6 = restartGroup.changed($changed) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                i7 = $changed;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i42 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i35 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        obj = 6;
                        if (obj43 & 2 != 0) {
                            circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(restartGroup, obj);
                            $dirty &= -113;
                        }
                        if (i39 != 0) {
                            infiniteRepeatableSpec = circularStrokeWidth-D9Ej5fM;
                        }
                        if (obj43 & 8 != 0) {
                            $dirty &= -7169;
                            size-3ABfNKs = circularIndeterminateTrackColor;
                        }
                        if (i2 != 0) {
                            i19 = $dirty;
                            i5 = circularIndeterminateStrokeCap-KaPHkGw;
                            skipping = circularColor;
                            $dirty4 = infiniteRepeatableSpec;
                            l5 = size-3ABfNKs;
                        } else {
                            i19 = $dirty;
                            i5 = i7;
                            skipping = circularColor;
                            $dirty4 = infiniteRepeatableSpec;
                            l5 = size-3ABfNKs;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj43 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj43 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        i19 = $dirty;
                        modifier2 = obj;
                        i5 = i7;
                        skipping = circularColor;
                        $dirty4 = infiniteRepeatableSpec;
                        l5 = size-3ABfNKs;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i19, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:637)");
                }
                int i43 = 0;
                int i45 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i44 = 0;
                i15 = 0;
                Stroke stroke3 = new Stroke((Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4($dirty4), i15, i5, 0, 0, 26, 0);
                int $i$a$WithProgressIndicatorKt$CircularProgressIndicator$stroke$2 = 0;
                int i46 = 0;
                f2 = $dirty4;
                obj37 = i90;
                int i72 = 0;
                obj2 = modifier2;
                circularColor = rememberInfiniteTransition;
                anon = 1;
                empty = strokeCap3;
                androidx.compose.runtime.State state6 = animateValue;
                obj37 = infiniteRepeatable-9IiC70o$default2;
                androidx.compose.runtime.State state5 = animateFloat3;
                int i85 = 0;
                obj37 = infiniteRepeatable-9IiC70o$default3;
                infiniteRepeatableSpec = animateFloat;
                i2 = animateFloat2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -291474284, "CC(remember):ProgressIndicator.kt#9igjgp");
                int i78 = 2048;
                if (i21 ^= 3072 > i78) {
                    if (!restartGroup.changed(l5)) {
                        i12 = i19 & 3072 == i78 ? anon : 0;
                    } else {
                    }
                } else {
                }
                i9 = i19 & 896 == 256 ? anon : 0;
                if (i80 ^= 48 > 32) {
                    if (!restartGroup.changed(skipping)) {
                        if (i19 & 48 == 32) {
                        } else {
                            anon = 0;
                        }
                    } else {
                    }
                } else {
                }
                composer = restartGroup;
                i13 = 0;
                Object rememberedValue = composer.rememberedValue();
                i4 = 0;
                if (obj34 | anon == 0) {
                    stroke = empty;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int stroke2 = 0;
                        anon = new ProgressIndicatorKt.CircularProgressIndicator.5.1(l5, i15, stroke, state6, infiniteRepeatableSpec, i2, state5, f2, skipping, obj31);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        $i$a$CacheProgressIndicatorKt$CircularProgressIndicator$5 = rememberedValue;
                        state3 = state5;
                        l3 = skipping;
                        l2 = l5;
                        state2 = state6;
                        state = infiniteRepeatableSpec;
                        state4 = i2;
                    }
                } else {
                    stroke = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(obj2), ProgressIndicatorKt.CircularIndicatorDiameter), (Function1)$i$a$CacheProgressIndicatorKt$CircularProgressIndicator$5, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i17 = i19;
                l = l2;
                f = f2;
                l4 = l3;
                $dirty2 = i14;
                $dirty3 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                $dirty2 = i7;
                l4 = circularColor;
                l = size-3ABfNKs;
                i17 = $dirty;
                $dirty3 = obj;
                f = infiniteRepeatableSpec;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.CircularProgressIndicator.6($dirty3, l4, skipping, f, l, i7, $dirty2, i42, obj43);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void CircularProgressIndicator-MBs18nI(float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i7) {
        boolean traceInProgress;
        int $dirty;
        int i2;
        Object obj2;
        Object modifier2;
        boolean traceInProgress2;
        Object color2;
        long l3;
        int i3;
        long l;
        float f2;
        float circularStrokeWidth-D9Ej5fM;
        float f3;
        int changed;
        int modifier3;
        Object obj;
        float f;
        int i5;
        boolean defaultsInvalid;
        float i6;
        long circularTrackColor;
        int circularDeterminateStrokeCap-KaPHkGw;
        int i4;
        int i;
        long l2;
        final int i21 = i7;
        traceInProgress = 402841196;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)750@30727L13,758@30964L18,753@30818L247:ProgressIndicator.kt#uh7d8r");
        $dirty = i7;
        if (obj27 & 1 != 0) {
            $dirty |= 6;
            f3 = progress;
        } else {
            if (i21 & 6 == 0) {
                i2 = restartGroup.changed(progress) ? 4 : 2;
                $dirty |= i2;
            } else {
                f3 = progress;
            }
        }
        int i12 = obj27 & 2;
        if (i12 != 0) {
            $dirty |= 48;
            color2 = modifier;
        } else {
            if (i21 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                color2 = modifier;
            }
        }
        if (i21 & 384 == 0) {
            if (obj27 & 4 == 0) {
                changed = restartGroup.changed(color) ? 256 : 128;
            } else {
                l = color;
            }
            $dirty |= changed;
        } else {
            l = color;
        }
        int i22 = obj27 & 8;
        if (i22 != 0) {
            $dirty |= 3072;
            f = $composer;
        } else {
            if (i21 & 3072 == 0) {
                i5 = restartGroup.changed($composer) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                f = $composer;
            }
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i24 = 6;
                if (i21 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = color2;
                        }
                        if (obj27 & 4 != 0) {
                            color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(restartGroup, i24);
                            $dirty &= -897;
                        } else {
                            color2 = l;
                        }
                        if (i22 != 0) {
                            circularStrokeWidth-D9Ej5fM = ProgressIndicatorDefaults.INSTANCE.getCircularStrokeWidth-D9Ej5fM();
                            obj = modifier2;
                            f = color2;
                        } else {
                            obj = modifier2;
                            circularStrokeWidth-D9Ej5fM = f;
                            f = color2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj27 & 4 != 0) {
                            $dirty &= -897;
                        }
                        circularStrokeWidth-D9Ej5fM = f;
                        f = l2;
                        obj = color2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:753)");
                }
                i6 = circularStrokeWidth-D9Ej5fM;
                ProgressIndicatorKt.CircularProgressIndicator-DUhRLBM(f3, obj, f, defaultsInvalid, i6, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(restartGroup, i24), obj13, ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateStrokeCap-KaPHkGw(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj;
                l3 = f;
                f2 = i6;
                modifier3 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = color2;
                l3 = l;
                f2 = f;
                modifier3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ProgressIndicatorKt.CircularProgressIndicator.9(progress, obj2, l3, l, f2, i21, obj27);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void CircularProgressIndicator-aM-cp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty2;
        Object $dirty;
        Object modifier2;
        boolean traceInProgress;
        long l3;
        Object circularStrokeWidth-D9Ej5fM;
        int i3;
        int i;
        int changed;
        float f;
        long color2;
        long l2;
        int color3;
        float f2;
        int i2;
        int skipping;
        int defaultsInvalid;
        int circularTrackColor;
        int circularIndeterminateStrokeCap-KaPHkGw;
        int i4;
        int i5;
        long l;
        final int i15 = i6;
        traceInProgress2 = 947193756;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)767@31299L13,774@31518L18,770@31390L231:ProgressIndicator.kt#uh7d8r");
        $dirty2 = i6;
        int i10 = obj24 & 1;
        if (i10 != 0) {
            $dirty2 |= 6;
            circularStrokeWidth-D9Ej5fM = modifier;
        } else {
            if (i15 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                circularStrokeWidth-D9Ej5fM = modifier;
            }
        }
        if (i15 & 48 == 0) {
            if (obj24 & 2 == 0) {
                i = restartGroup.changed(color) ? 32 : 16;
            } else {
                color2 = color;
            }
            $dirty2 |= i;
        } else {
            color2 = color;
        }
        int i14 = obj24 & 4;
        if (i14 != 0) {
            $dirty2 |= 384;
            f2 = $composer;
        } else {
            if (i15 & 384 == 0) {
                i2 = restartGroup.changed($composer) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                f2 = $composer;
            }
        }
        if ($dirty2 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i17 = 6;
                if (i15 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = circularStrokeWidth-D9Ej5fM;
                        }
                        if (obj24 & 2 != 0) {
                            color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(restartGroup, i17);
                            $dirty2 &= -113;
                        }
                        if (i14 != 0) {
                            skipping = circularStrokeWidth-D9Ej5fM;
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
                            $dirty2 &= -113;
                        }
                        skipping = f2;
                        l2 = color2;
                        color2 = circularStrokeWidth-D9Ej5fM;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:770)");
                }
                ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w(color2, l2, f2, skipping, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(restartGroup, i17), obj11, ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateStrokeCap-KaPHkGw(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l3 = l2;
                f = skipping;
                color3 = $dirty2;
                $dirty = color2;
            } else {
                restartGroup.skipToGroupEnd();
                color3 = $dirty2;
                $dirty = circularStrokeWidth-D9Ej5fM;
                l3 = l;
                f = f2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.CircularProgressIndicator.10($dirty, l3, circularStrokeWidth-D9Ej5fM, f, i15, obj24);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyIndeterminateLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(...))
    public static final void LinearProgressIndicator-2cYBFYY(Modifier modifier, long color, long trackColor, int strokeCap, Composer $composer, int $changed, int i7) {
        boolean traceInProgress;
        int $dirty;
        Object $dirty2;
        Object modifier2;
        boolean traceInProgress2;
        long l2;
        Object color3;
        int i9;
        long l4;
        long l5;
        int linearStrokeCap-KaPHkGw;
        int changed;
        int i6;
        int i3;
        boolean changed2;
        long trackColor2;
        long l;
        int color2;
        int i;
        int i8;
        int skipping;
        int defaultsInvalid;
        int i2;
        float linearIndicatorTrackGapSize-D9Ej5fM;
        int i5;
        int i4;
        long l3;
        final int i24 = obj27;
        traceInProgress = -476865359;
        final Composer restartGroup = i7.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)214@9497L11,215@9560L16,218@9656L175:ProgressIndicator.kt#uh7d8r");
        $dirty = obj27;
        int i14 = obj28 & 1;
        if (i14 != 0) {
            $dirty |= 6;
            color3 = modifier;
        } else {
            if (i24 & 6 == 0) {
                i9 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i9;
            } else {
                color3 = modifier;
            }
        }
        if (i24 & 48 == 0) {
            if (obj28 & 2 == 0) {
                changed = restartGroup.changed(color) ? 32 : 16;
            } else {
                l4 = color;
            }
            $dirty |= changed;
        } else {
            l4 = color;
        }
        if (i24 & 384 == 0) {
            if (obj28 & 4 == 0) {
                i6 = restartGroup.changed(strokeCap) ? 256 : 128;
            } else {
                trackColor2 = strokeCap;
            }
            $dirty |= i6;
        } else {
            trackColor2 = strokeCap;
        }
        int i23 = obj28 & 8;
        if (i23 != 0) {
            $dirty |= 3072;
            i = $changed;
        } else {
            if (i24 & 3072 == 0) {
                i8 = restartGroup.changed($changed) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                i = $changed;
            }
        }
        final int i27 = 1170;
        if ($dirty & 1171 == i27) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i24 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = color3;
                        }
                        int i26 = 6;
                        if (obj28 & 2 != 0) {
                            color3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(restartGroup, i26);
                            $dirty &= -113;
                        } else {
                            color3 = l4;
                        }
                        if (obj28 & 4 != 0) {
                            trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(restartGroup, i26);
                            $dirty &= -897;
                        }
                        if (i23 != 0) {
                            i2 = linearStrokeCap-KaPHkGw;
                            skipping = trackColor2;
                            trackColor2 = modifier2;
                            l = color3;
                        } else {
                            skipping = trackColor2;
                            i2 = i;
                            trackColor2 = modifier2;
                            l = color3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj28 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj28 & 4 != 0) {
                            $dirty &= -897;
                        }
                        skipping = trackColor2;
                        i2 = i;
                        trackColor2 = color3;
                        l = l4;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:217)");
                }
                ProgressIndicatorKt.LinearProgressIndicator-rIrjwxo(trackColor2, l, i, skipping, i27, i2, ProgressIndicatorDefaults.INSTANCE.getLinearIndicatorTrackGapSize-D9Ej5fM(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l2 = l;
                l5 = skipping;
                i3 = i2;
                color2 = $dirty;
                $dirty2 = trackColor2;
            } else {
                restartGroup.skipToGroupEnd();
                color2 = $dirty;
                $dirty2 = color3;
                l2 = l4;
                l5 = l3;
                i3 = i;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ProgressIndicatorKt.LinearProgressIndicator.6($dirty2, l2, color3, l5, linearStrokeCap-KaPHkGw, i3, i24, obj28);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void LinearProgressIndicator-GJbTh5U(Function0<Float> progress, Modifier modifier, long color, long trackColor, int strokeCap, float gapSize, Function1<? super DrawScope, Unit> drawStopIndicator, Composer $composer, int $changed, int i10) {
        Object traceInProgress2;
        androidx.compose.material3.ProgressIndicatorKt.LinearProgressIndicator.2.1 it$iv;
        Object drawStopIndicator2;
        Object it$iv2;
        Object size-VpY3zN4;
        int $dirty2;
        Object $dirty;
        int i16;
        int i3;
        boolean traceInProgress;
        int empty2;
        Object $i$a$CacheProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1;
        int companion3;
        int iNSTANCE;
        int linearIndicatorTrackGapSize-D9Ej5fM;
        int i11;
        int changed5;
        long l;
        float str;
        int i17;
        Object modifier2;
        int i4;
        long l2;
        int i9;
        int i;
        int i2;
        boolean changed6;
        int i8;
        int i26;
        int i12;
        int i21;
        int changed4;
        boolean changed3;
        int changed;
        int i6;
        int i13;
        int i19;
        int changed2;
        int skipping;
        boolean defaultsInvalid;
        int i20;
        int i25;
        int i18;
        int i22;
        long linearColor;
        float f;
        Object anon3;
        int i15;
        long linearTrackColor;
        int i5;
        Object empty;
        int i24;
        Composer.Companion companion2;
        int i14;
        int i7;
        int i23;
        Composer.Companion companion;
        int changedInstance;
        int anon2;
        int companion4;
        float f2;
        androidx.compose.material3.ProgressIndicatorKt.LinearProgressIndicator.coercedProgress.1.1 anon;
        long l3;
        long l5;
        androidx.compose.material3.ProgressIndicatorKt.LinearProgressIndicator.2.1 anon4;
        long l4;
        int obj35;
        Object obj36;
        size-VpY3zN4 = progress;
        final int i58 = obj44;
        final Composer restartGroup = i10.startRestartGroup(-339970038);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(4,3,0:c#ui.graphics.Color,6:c#ui.graphics.Color,5:c#ui.graphics.StrokeCap,2:c#ui.unit.Dp)140@6419L11,141@6482L16,144@6689L214,153@6935L31,157@7087L102,161@7259L806,154@6971L1094:ProgressIndicator.kt#uh7d8r");
        $dirty2 = obj44;
        if (obj45 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i58 & 6 == 0) {
                i16 = restartGroup.changedInstance(size-VpY3zN4) ? 4 : 2;
                $dirty2 |= i16;
            }
        }
        companion3 = obj45 & 2;
        if (companion3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else {
            if (i58 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                modifier2 = modifier;
            }
        }
        if (i58 & 384 == 0) {
            if (obj45 & 4 == 0) {
                i = restartGroup.changed(color) ? 256 : 128;
            } else {
                linearColor = color;
            }
            $dirty2 |= i;
        } else {
            linearColor = color;
        }
        if (i58 & 3072 == 0) {
            if (obj45 & 8 == 0) {
                i2 = restartGroup.changed(strokeCap) ? 2048 : 1024;
            } else {
                linearTrackColor = strokeCap;
            }
            $dirty2 |= i2;
        } else {
            linearTrackColor = strokeCap;
        }
        i8 = obj45 & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            i15 = drawStopIndicator;
        } else {
            if (i58 & 24576 == 0) {
                i24 = restartGroup.changed(drawStopIndicator) ? 16384 : 8192;
                $dirty2 |= i24;
            } else {
                i15 = drawStopIndicator;
            }
        }
        int i62 = obj45 & 32;
        i14 = 196608;
        if (i62 != 0) {
            $dirty2 |= i14;
            str = $composer;
        } else {
            if (i58 & i14 == 0) {
                i7 = restartGroup.changed($composer) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                str = $composer;
            }
        }
        int i63 = 1572864;
        if (i58 & i63 == 0) {
            if (obj45 & 64 == 0) {
                changedInstance = restartGroup.changedInstance($changed) ? 1048576 : 524288;
            } else {
                traceInProgress2 = $changed;
            }
            $dirty2 |= changedInstance;
        } else {
            traceInProgress2 = $changed;
        }
        if ($dirty2 & i64 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                empty = "CC(remember):ProgressIndicator.kt#9igjgp";
                if (i58 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (companion3 != 0) {
                            modifier2 = companion3;
                        }
                        defaultsInvalid = 6;
                        if (obj45 & 4 != 0) {
                            linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(restartGroup, defaultsInvalid);
                            $dirty2 &= -897;
                        }
                        if (obj45 & 8 != 0) {
                            linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(restartGroup, defaultsInvalid);
                            $dirty2 &= -7169;
                        }
                        if (i8 != 0) {
                            i15 = linearIndicatorTrackGapSize-D9Ej5fM;
                        }
                        if (i62 != 0) {
                            str = linearIndicatorTrackGapSize-D9Ej5fM;
                        }
                        if (obj45 & 64 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 1144997616, empty);
                            if (i35 ^= 384 > 256) {
                                if (!restartGroup.changed(linearColor)) {
                                    i11 = $dirty2 & 384 == 256 ? 1 : 0;
                                } else {
                                }
                            } else {
                            }
                            i13 = i53 &= $dirty2 == 16384 ? 1 : 0;
                            i8 = restartGroup;
                            defaultsInvalid = 0;
                            it$iv = i8.rememberedValue();
                            anon2 = 0;
                            if (i11 |= i13 == 0) {
                                obj35 = $dirty2;
                                if (it$iv == Composer.Companion.getEmpty()) {
                                    $dirty2 = 0;
                                    obj36 = it$iv;
                                    it$iv = new ProgressIndicatorKt.LinearProgressIndicator.2.1(linearColor, obj9, i15);
                                    i8.updateRememberedValue((Function1)it$iv);
                                } else {
                                    obj36 = it$iv;
                                }
                            } else {
                                obj35 = $dirty2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty2 = obj35 & i28;
                            f2 = str;
                            companion4 = i15;
                        } else {
                            obj35 = $dirty2;
                            it$iv = $changed;
                            f2 = str;
                            companion4 = i15;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj45 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj45 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (obj45 & 64 != 0) {
                            $dirty2 &= i3;
                        }
                        it$iv = $changed;
                        f2 = str;
                        companion4 = i15;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-339970038, $dirty2, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:152)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1145005305, empty);
                empty2 = $dirty2 & 14 == 4 ? 1 : 0;
                Composer composer = restartGroup;
                int i45 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i60 = 0;
                if (empty2 == 0) {
                    obj35 = empty2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        obj36 = invalid$iv;
                        $i$a$CacheProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1 = new ProgressIndicatorKt.LinearProgressIndicator.coercedProgress.1.1(size-VpY3zN4);
                        composer.updateRememberedValue((Function0)$i$a$CacheProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1);
                    } else {
                        $i$a$CacheProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1 = rememberedValue;
                    }
                } else {
                    obj35 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1145010240, empty);
                Composer composer3 = restartGroup;
                int i61 = 0;
                it$iv2 = composer3.rememberedValue();
                companion2 = 0;
                if (!restartGroup.changed((Function0)$i$a$CacheProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1)) {
                    obj35 = modifier2;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        modifier2 = 0;
                        obj36 = it$iv2;
                        it$iv2 = new ProgressIndicatorKt.LinearProgressIndicator.3.1($i$a$CacheProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1);
                        composer3.updateRememberedValue((Function1)it$iv2);
                    } else {
                        obj36 = it$iv2;
                    }
                } else {
                    obj35 = modifier2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i4 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1145016448, empty);
                i17 = i38 &= $dirty2 == 16384 ? i4 : 0;
                i26 = i47 &= $dirty2 == 131072 ? i4 : 0;
                if (i49 ^= 3072 > 2048) {
                    if (!restartGroup.changed(linearTrackColor)) {
                        i12 = $dirty2 & 3072 == 2048 ? i4 : 0;
                    } else {
                    }
                } else {
                }
                if (i50 ^= 384 > 256) {
                    if (!restartGroup.changed(linearColor)) {
                        i21 = $dirty2 & 384 == 256 ? i4 : 0;
                    } else {
                    }
                } else {
                }
                if (i52 ^= i63 > 1048576) {
                    if (!restartGroup.changed(it$iv)) {
                        if ($dirty2 & i63 == 1048576) {
                        } else {
                            i4 = 0;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer2 = restartGroup;
                i19 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                i15 = 0;
                if (i43 |= i4 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon2 = new ProgressIndicatorKt.LinearProgressIndicator.4.1(companion4, f2, $i$a$CacheProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1, linearTrackColor, obj28, linearColor, obj30, it$iv);
                        composer2.updateRememberedValue((Function1)anon2);
                    } else {
                        anon4 = it$iv;
                        anon = $i$a$CacheProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1;
                        drawStopIndicator2 = rememberedValue2;
                        l5 = linearColor;
                        l3 = linearTrackColor;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.size-VpY3zN4(SemanticsModifierKt.semantics(modifier2.then(ProgressIndicatorKt.IncreaseSemanticsBounds), i4, (Function1)it$iv2), ProgressIndicatorKt.LinearIndicatorWidth, ProgressIndicatorKt.LinearIndicatorHeight), (Function1)drawStopIndicator2, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i5 = $dirty2;
                i22 = companion4;
                f = f2;
                l2 = l3;
                l = l5;
                anon3 = anon4;
                $dirty = obj35;
            } else {
                restartGroup.skipToGroupEnd();
                f = str;
                l = i19;
                i5 = $dirty2;
                $dirty = modifier2;
                l2 = l4;
                anon3 = traceInProgress2;
                i22 = i15;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.LinearProgressIndicator.5(progress, $dirty, l, str, l2, i19, i22, f, anon3, i58, obj45);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void LinearProgressIndicator-RIQooxk(Modifier modifier, long color, long trackColor, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty;
        Object $dirty2;
        Object modifier2;
        boolean traceInProgress;
        long l2;
        Object color2;
        int i4;
        long l3;
        long l;
        int iNSTANCE;
        int changed;
        long trackColor2;
        long l4;
        int color3;
        int changed2;
        int defaultsInvalid;
        long i;
        int linearStrokeCap-KaPHkGw;
        int i3;
        int i2;
        int i5;
        long l5;
        final int i18 = obj25;
        traceInProgress2 = 585576195;
        final Composer restartGroup = i6.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)418@16922L11,419@16985L16,421@17011L146:ProgressIndicator.kt#uh7d8r");
        $dirty = obj25;
        int i10 = obj26 & 1;
        if (i10 != 0) {
            $dirty |= 6;
            color2 = modifier;
        } else {
            if (i18 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i4;
            } else {
                color2 = modifier;
            }
        }
        if (i18 & 48 == 0) {
            if (obj26 & 2 == 0) {
                changed = restartGroup.changed(color) ? 32 : 16;
            } else {
                l3 = color;
            }
            $dirty |= changed;
        } else {
            l3 = color;
        }
        if (i18 & 384 == 0) {
            if (obj26 & 4 == 0) {
                changed2 = restartGroup.changed($composer) ? 256 : 128;
            } else {
                trackColor2 = $composer;
            }
            $dirty |= changed2;
        } else {
            trackColor2 = $composer;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i18 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = color2;
                        }
                        defaultsInvalid = 6;
                        if (obj26 & 2 != 0) {
                            color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(restartGroup, defaultsInvalid);
                            $dirty &= -113;
                        } else {
                            color2 = l3;
                        }
                        if (obj26 & 4 != 0) {
                            $dirty &= -897;
                            i = linearTrackColor;
                            trackColor2 = modifier2;
                            l4 = color2;
                        } else {
                            i = trackColor2;
                            trackColor2 = modifier2;
                            l4 = color2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj26 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj26 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i = trackColor2;
                        trackColor2 = color2;
                        l4 = l3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:421)");
                }
                ProgressIndicatorKt.LinearProgressIndicator-rIrjwxo(trackColor2, l4, defaultsInvalid, i, obj11, ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw(), 0, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l2 = l4;
                l = i;
                color3 = $dirty;
                $dirty2 = trackColor2;
            } else {
                restartGroup.skipToGroupEnd();
                color3 = $dirty;
                $dirty2 = color2;
                l2 = l3;
                l = l5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.LinearProgressIndicator.12($dirty2, l2, color2, l, iNSTANCE, i18, obj26);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(...))
    public static final void LinearProgressIndicator-_5eSR-E(float progress, Modifier modifier, long color, long trackColor, int strokeCap, Composer $composer, int $changed, int i8) {
        int i5;
        Object invalid$iv;
        boolean traceInProgress;
        Object $composer2;
        int $dirty;
        long $dirty2;
        int i;
        int linearStrokeCap-KaPHkGw;
        boolean traceInProgress2;
        int companion;
        int iNSTANCE;
        long l;
        Object rememberedValue;
        int i9;
        int i6;
        int i12;
        int i14;
        boolean changed2;
        boolean changed;
        long linearColor;
        Object obj;
        int modifier2;
        long trackColor2;
        int i7;
        int i3;
        int defaultsInvalid;
        int i13;
        int i10;
        int i4;
        Composer composer;
        int i2;
        int i11;
        long l2;
        int obj24;
        final float f = progress;
        final int i29 = obj31;
        traceInProgress = 905419617;
        Composer restartGroup = i8.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)385@15871L11,386@15934L16,390@16074L12,389@16030L179:ProgressIndicator.kt#uh7d8r");
        $dirty = obj31;
        int i24 = 4;
        if (obj32 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i29 & 6 == 0) {
                i = restartGroup.changed(f) ? i24 : 2;
                $dirty |= i;
            }
        }
        companion = obj32 & 2;
        if (companion != 0) {
            $dirty |= 48;
            rememberedValue = modifier;
        } else {
            if (i29 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i9;
            } else {
                rememberedValue = modifier;
            }
        }
        if (i29 & 384 == 0) {
            if (obj32 & 4 == 0) {
                i6 = restartGroup.changed(color) ? 256 : 128;
            } else {
                linearColor = color;
            }
            $dirty |= i6;
        } else {
            linearColor = color;
        }
        if (i29 & 3072 == 0) {
            if (obj32 & 8 == 0) {
                i12 = restartGroup.changed(strokeCap) ? 2048 : 1024;
            } else {
                trackColor2 = strokeCap;
            }
            $dirty |= i12;
        } else {
            trackColor2 = strokeCap;
        }
        int i27 = obj32 & 16;
        if (i27 != 0) {
            $dirty |= 24576;
            i7 = $changed;
        } else {
            if (i29 & 24576 == 0) {
                i3 = restartGroup.changed($changed) ? 16384 : 8192;
                $dirty |= i3;
            } else {
                i7 = $changed;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i29 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (companion != 0) {
                            rememberedValue = companion;
                        }
                        defaultsInvalid = 6;
                        if (obj32 & 4 != 0) {
                            linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(restartGroup, defaultsInvalid);
                            $dirty &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(restartGroup, defaultsInvalid);
                            $dirty &= -7169;
                        }
                        if (i27 != 0) {
                            i13 = linearStrokeCap-KaPHkGw;
                            i7 = trackColor2;
                            trackColor2 = linearColor;
                            obj = rememberedValue;
                        } else {
                            i13 = i7;
                            i7 = trackColor2;
                            trackColor2 = linearColor;
                            obj = rememberedValue;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        i13 = i7;
                        i7 = trackColor2;
                        trackColor2 = linearColor;
                        obj = rememberedValue;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:389)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1145297734, "CC(remember):ProgressIndicator.kt#9igjgp");
                i5 = $dirty & 14 == i24 ? 1 : 0;
                Composer composer2 = restartGroup;
                int i25 = 0;
                rememberedValue = composer2.rememberedValue();
                int i28 = 0;
                if (i5 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        linearColor = 0;
                        obj24 = i5;
                        invalid$iv = new ProgressIndicatorKt.LinearProgressIndicator.9.1(f);
                        composer2.updateRememberedValue((Function0)invalid$iv);
                    } else {
                        obj24 = i5;
                        invalid$iv = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U((Function0)invalid$iv, obj, trackColor2, obj12, i7, defaultsInvalid, i13, 0, 0, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj;
                l = i7;
                i14 = i13;
                modifier2 = $dirty;
                $dirty2 = trackColor2;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = $dirty;
                $dirty2 = l2;
                composer = restartGroup;
                $composer2 = rememberedValue;
                l = trackColor2;
                i14 = i7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ProgressIndicatorKt.LinearProgressIndicator.10(f, $composer2, $dirty2, companion, l, rememberedValue, i14, i29, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize` and `drawStopIndicator`, see `LegacyLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(...))
    public static final void LinearProgressIndicator-_5eSR-E(Function0 progress, Modifier modifier, long color, long trackColor, int strokeCap, Composer $composer, int $changed, int i8) {
        boolean traceInProgress2;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i2;
        Object modifier2;
        boolean traceInProgress;
        long l;
        Object color2;
        int i7;
        long l2;
        long l3;
        int linearStrokeCap-KaPHkGw;
        int changed2;
        int i10;
        int changed;
        int i9;
        Object obj;
        long linearTrackColor;
        Object trackColor2;
        int modifier3;
        long l4;
        int i11;
        int i4;
        int skipping;
        int defaultsInvalid;
        int i;
        float linearIndicatorTrackGapSize-D9Ej5fM;
        int i5;
        Composer composer;
        int i6;
        int i3;
        long l5;
        final int i30 = obj31;
        traceInProgress2 = -1796992155;
        restartGroup = i8.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)96@4380L11,97@4443L16,100@4539L192:ProgressIndicator.kt#uh7d8r");
        $dirty2 = obj31;
        if (obj32 & 1 != 0) {
            $dirty2 |= 6;
            obj = progress;
        } else {
            if (i30 & 6 == 0) {
                i2 = restartGroup.changedInstance(progress) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                obj = progress;
            }
        }
        int i17 = obj32 & 2;
        if (i17 != 0) {
            $dirty2 |= 48;
            color2 = modifier;
        } else {
            if (i30 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i7;
            } else {
                color2 = modifier;
            }
        }
        if (i30 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed2 = restartGroup.changed(color) ? 256 : 128;
            } else {
                l2 = color;
            }
            $dirty2 |= changed2;
        } else {
            l2 = color;
        }
        if (i30 & 3072 == 0) {
            if (obj32 & 8 == 0) {
                i10 = restartGroup.changed(strokeCap) ? 2048 : 1024;
            } else {
                linearTrackColor = strokeCap;
            }
            $dirty2 |= i10;
        } else {
            linearTrackColor = strokeCap;
        }
        int i29 = obj32 & 16;
        if (i29 != 0) {
            $dirty2 |= 24576;
            i11 = $changed;
        } else {
            if (i30 & 24576 == 0) {
                i4 = restartGroup.changed($changed) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                i11 = $changed;
            }
        }
        final int i33 = 9362;
        if ($dirty2 & 9363 == i33) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i30 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = color2;
                        }
                        int i32 = 6;
                        if (obj32 & 4 != 0) {
                            color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(restartGroup, i32);
                            $dirty2 &= -897;
                        } else {
                            color2 = l2;
                        }
                        if (obj32 & 8 != 0) {
                            linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(restartGroup, i32);
                            $dirty2 &= -7169;
                        }
                        if (i29 != 0) {
                            i = linearStrokeCap-KaPHkGw;
                            skipping = linearTrackColor;
                            trackColor2 = modifier2;
                            l4 = color2;
                        } else {
                            skipping = linearTrackColor;
                            i = i11;
                            trackColor2 = modifier2;
                            l4 = color2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        skipping = linearTrackColor;
                        i = i11;
                        trackColor2 = color2;
                        l4 = l2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:99)");
                }
                ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U(obj, trackColor2, l4, i11, skipping, i33, i, ProgressIndicatorDefaults.INSTANCE.getLinearIndicatorTrackGapSize-D9Ej5fM(), 0, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = $dirty2;
                $dirty = obj3;
                l = l4;
                l3 = skipping;
                i9 = i;
            } else {
                restartGroup.skipToGroupEnd();
                modifier3 = $dirty2;
                $dirty = color2;
                l = l2;
                l3 = l5;
                composer = restartGroup;
                i9 = i11;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.LinearProgressIndicator.1(progress, $dirty, l, color2, l3, linearStrokeCap-KaPHkGw, i9, i30, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void LinearProgressIndicator-eaDK9VM(float progress, Modifier modifier, long color, long trackColor, Composer $composer, int $changed, int i7) {
        boolean traceInProgress;
        int $dirty;
        int i5;
        Object modifier2;
        boolean traceInProgress2;
        Object obj2;
        Object color2;
        long l2;
        int i3;
        long l3;
        int linearTrackColor;
        long l4;
        int changed;
        int i4;
        int changed2;
        int defaultsInvalid;
        float f;
        long l6;
        Object obj;
        int modifier3;
        long l5;
        long l;
        int linearStrokeCap-KaPHkGw;
        int i;
        int i2;
        final int i20 = obj25;
        traceInProgress = -372717133;
        final Composer restartGroup = i7.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)403@16462L11,404@16525L16,406@16551L164:ProgressIndicator.kt#uh7d8r");
        $dirty = obj25;
        if (obj26 & 1 != 0) {
            $dirty |= 6;
            f = progress;
        } else {
            if (i20 & 6 == 0) {
                i5 = restartGroup.changed(progress) ? 4 : 2;
                $dirty |= i5;
            } else {
                f = progress;
            }
        }
        int i11 = obj26 & 2;
        if (i11 != 0) {
            $dirty |= 48;
            color2 = modifier;
        } else {
            if (i20 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                color2 = modifier;
            }
        }
        if (i20 & 384 == 0) {
            if (obj26 & 4 == 0) {
                changed = restartGroup.changed(color) ? 256 : 128;
            } else {
                l3 = color;
            }
            $dirty |= changed;
        } else {
            l3 = color;
        }
        if (i20 & 3072 == 0) {
            if (obj26 & 8 == 0) {
                i4 = restartGroup.changed($composer) ? 2048 : 1024;
            } else {
                l6 = $composer;
            }
            $dirty |= i4;
        } else {
            l6 = $composer;
        }
        final int i21 = 1170;
        if ($dirty & 1171 == i21) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i20 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = color2;
                        }
                        defaultsInvalid = 6;
                        if (obj26 & 4 != 0) {
                            color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(restartGroup, defaultsInvalid);
                            $dirty &= -897;
                        } else {
                            color2 = l3;
                        }
                        if (obj26 & 8 != 0) {
                            $dirty &= -7169;
                            obj = modifier2;
                            l5 = color2;
                            l = linearTrackColor;
                        } else {
                            l = l6;
                            obj = modifier2;
                            l5 = color2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj26 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj26 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        l = l6;
                        obj = color2;
                        l5 = l3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:406)");
                }
                ProgressIndicatorKt.LinearProgressIndicator-_5eSR-E(f, obj, l5, i21, l, obj13, ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw(), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj;
                l2 = l5;
                l4 = l;
                modifier3 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = color2;
                l2 = l3;
                l4 = l6;
                modifier3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ProgressIndicatorKt.LinearProgressIndicator.11(progress, obj2, l2, l3, l4, defaultsInvalid, i20, obj26);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void LinearProgressIndicator-rIrjwxo(Modifier modifier, long color, long trackColor, int strokeCap, float gapSize, Composer $composer, int $changed, int i8) {
        boolean traceInProgress2;
        int i3;
        Object $i$a$CacheProgressIndicatorKt$LinearProgressIndicator$7;
        int empty;
        Object $composer2;
        int $dirty2;
        long $dirty;
        Object modifier2;
        Object linearIndicatorTrackGapSize-D9Ej5fM;
        int iNSTANCE;
        boolean traceInProgress;
        long l2;
        int i;
        int i6;
        int i5;
        int str;
        int i13;
        int changed3;
        int i14;
        int changed;
        int i9;
        Composer composer2;
        boolean changed4;
        int changed2;
        int skipping;
        int defaultsInvalid;
        int i18;
        float f;
        long linearColor;
        int i2;
        long linearTrackColor;
        androidx.compose.runtime.State i19;
        int composer;
        Composer composer3;
        int i17;
        int i15;
        int i7;
        int i11;
        int i10;
        Composer.Companion companion;
        int i12;
        androidx.compose.material3.ProgressIndicatorKt.LinearProgressIndicator.7.1 anon;
        int i4;
        float f2;
        androidx.compose.runtime.State state3;
        long l3;
        int i16;
        androidx.compose.runtime.State state4;
        long l;
        androidx.compose.runtime.State state;
        androidx.compose.runtime.State state2;
        int obj30;
        int obj31;
        InfiniteTransition obj32;
        InfiniteRepeatableSpec obj33;
        int obj34;
        Composer obj35;
        int obj36;
        int obj37;
        final int i42 = obj38;
        traceInProgress2 = 567589233;
        Composer restartGroup = i8.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LinearProgressIndicator)P(2,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap,1:c#ui.unit.Dp)249@11000L11,250@11063L16,254@11257L28,259@11547L396,272@11995L396,285@12444L400,298@12897L400,315@13472L1839,310@13302L2009:ProgressIndicator.kt#uh7d8r");
        $dirty2 = obj38;
        modifier2 = obj39 & 1;
        if (modifier2 != 0) {
            $dirty2 |= 6;
            linearIndicatorTrackGapSize-D9Ej5fM = modifier;
        } else {
            if (i42 & 6 == 0) {
                i = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i;
            } else {
                linearIndicatorTrackGapSize-D9Ej5fM = modifier;
            }
        }
        if (i42 & 48 == 0) {
            if (obj39 & 2 == 0) {
                i6 = restartGroup.changed(color) ? 32 : 16;
            } else {
                linearColor = color;
            }
            $dirty2 |= i6;
        } else {
            linearColor = color;
        }
        if (i42 & 384 == 0) {
            if (obj39 & 4 == 0) {
                i5 = restartGroup.changed(strokeCap) ? 256 : 128;
            } else {
                linearTrackColor = strokeCap;
            }
            $dirty2 |= i5;
        } else {
            linearTrackColor = strokeCap;
        }
        str = obj39 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            composer = $composer;
        } else {
            if (i42 & 3072 == 0) {
                i17 = restartGroup.changed($composer) ? 2048 : 1024;
                $dirty2 |= i17;
            } else {
                composer = $composer;
            }
        }
        i11 = obj39 & 16;
        if (i11 != 0) {
            $dirty2 |= 24576;
            f = $changed;
        } else {
            if (i42 & 24576 == 0) {
                i12 = restartGroup.changed($changed) ? 16384 : 8192;
                $dirty2 |= i12;
            } else {
                f = $changed;
            }
        }
        if ($dirty2 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i42 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (modifier2 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = linearIndicatorTrackGapSize-D9Ej5fM;
                        }
                        defaultsInvalid = 6;
                        if (obj39 & 2 != 0) {
                            linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(restartGroup, defaultsInvalid);
                            $dirty2 &= -113;
                        }
                        if (obj39 & 4 != 0) {
                            linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(restartGroup, defaultsInvalid);
                            $dirty2 &= -897;
                        }
                        if (str != null) {
                            composer = linearIndicatorTrackGapSize-D9Ej5fM;
                        }
                        if (i11 != 0) {
                            f2 = linearIndicatorTrackGapSize-D9Ej5fM;
                            i4 = composer;
                        } else {
                            f2 = f;
                            i4 = composer;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj39 & 2 != 0) {
                            $dirty2 &= -113;
                        }
                        if (obj39 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        modifier2 = linearIndicatorTrackGapSize-D9Ej5fM;
                        f2 = f;
                        i4 = composer;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:253)");
                }
                int i58 = 0;
                obj30 = rememberInfiniteTransition;
                obj35 = restartGroup;
                obj33 = infiniteRepeatable-9IiC70o$default;
                InfiniteTransition infiniteTransition = obj30;
                Composer composer4 = obj35;
                androidx.compose.runtime.State state6 = animateFloat;
                int i70 = 0;
                obj33 = infiniteRepeatable-9IiC70o$default2;
                androidx.compose.runtime.State state7 = animateFloat2;
                int i78 = 0;
                obj33 = infiniteRepeatable-9IiC70o$default3;
                i19 = animateFloat3;
                i16 = 8;
                obj35 = composer4;
                composer3 = obj35;
                androidx.compose.runtime.State state5 = animateFloat4;
                ComposerKt.sourceInformationMarkerStart(composer3, 1145216297, "CC(remember):ProgressIndicator.kt#9igjgp");
                i13 = $dirty2 & 7168 == 2048 ? 1 : 0;
                obj32 = infiniteTransition;
                i3 = i67 &= $dirty2 == 16384 ? 1 : 0;
                if (i36 ^= 384 > 256) {
                    if (!composer3.changed(linearTrackColor)) {
                        i14 = $dirty2 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                if (i37 ^= 48 > 32) {
                    if (!composer3.changed(linearColor)) {
                        i9 = $dirty2 & 48 == 32 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i28 |= changed9;
                composer2 = composer3;
                i11 = 0;
                Object rememberedValue = composer2.rememberedValue();
                i10 = 0;
                if (empty == 0) {
                    obj30 = empty;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int invalid$iv = 0;
                        anon = new ProgressIndicatorKt.LinearProgressIndicator.7.1(i4, f2, state6, linearTrackColor, i16, state7, linearColor, obj27, i19, state5);
                        composer2.updateRememberedValue((Function1)anon);
                    } else {
                        $i$a$CacheProgressIndicatorKt$LinearProgressIndicator$7 = rememberedValue;
                        state3 = state6;
                        state4 = state7;
                        l = linearColor;
                        l3 = linearTrackColor;
                        state = i19;
                    }
                } else {
                    obj30 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                CanvasKt.Canvas(SizeKt.size-VpY3zN4(ProgressSemanticsKt.progressSemantics(modifier2.then(ProgressIndicatorKt.IncreaseSemanticsBounds)), ProgressIndicatorKt.LinearIndicatorWidth, ProgressIndicatorKt.LinearIndicatorHeight), (Function1)$i$a$CacheProgressIndicatorKt$LinearProgressIndicator$7, composer3, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i2 = $dirty2;
                $composer2 = modifier2;
                i18 = i4;
                f = f2;
                l2 = l3;
                $dirty = l;
            } else {
                restartGroup.skipToGroupEnd();
                i2 = $dirty2;
                $dirty = composer2;
                i18 = composer;
                composer3 = restartGroup;
                $composer2 = linearIndicatorTrackGapSize-D9Ej5fM;
                l2 = linearTrackColor;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProgressIndicatorKt.LinearProgressIndicator.8($composer2, $dirty, modifier2, l2, composer2, i18, f, i42, obj39);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$drawCircularIndicator-42QJj7c(DrawScope $receiver, float startAngle, float sweep, long color, Stroke stroke) {
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c($receiver, startAngle, sweep, color, stroke);
    }

    public static final void access$drawCircularIndicatorTrack-bw27NRU(DrawScope $receiver, long color, Stroke stroke) {
        ProgressIndicatorKt.drawCircularIndicatorTrack-bw27NRU($receiver, color, stroke);
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

    public static final float access$getSemanticsBoundsPadding$p() {
        return ProgressIndicatorKt.SemanticsBoundsPadding;
    }

    private static final void drawCircularIndicator-42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = (float)i2;
        width /= f;
        width-impl -= i3;
        DrawScope.drawArc-yD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, obj5, startAngle, sweep, 0, OffsetKt.Offset(i, i), obj10, SizeKt.Size(i4, i4), obj12, 0, (DrawStyle)obj24, 0);
    }

    private static final void drawCircularIndicatorTrack-bw27NRU(DrawScope $this$drawCircularIndicatorTrack_u2dbw27NRU, long color, Stroke stroke) {
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c($this$drawCircularIndicatorTrack_u2dbw27NRU, 0, 1135869952, color, obj4);
    }

    private static final void drawDeterminateCircularIndicator-42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    private static final void drawIndeterminateCircularIndicator-hrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        int i3;
        int butt-KaPHkGw;
        int i;
        int i2;
        if (StrokeCap.equals-impl0(obj13.getCap-KaPHkGw(), StrokeCap.Companion.getButt-KaPHkGw())) {
            i3 = 0;
        } else {
            i = 0;
            int i7 = 0;
            i4 /= butt-KaPHkGw;
        }
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, startAngle + i3, Math.max(sweep, 1036831949), color, obj5);
    }

    private static final void drawLinearIndicator-qYKTg0g(DrawScope $this$drawLinearIndicator_u2dqYKTg0g, float startFraction, float endFraction, long color, float strokeWidth, int strokeCap) {
        float i;
        int i3;
        int i22;
        int i2;
        boolean rangeTo;
        int i23;
        float adjustedBarStart;
        float floatValue;
        int cmp;
        int i9;
        long l2;
        int i5;
        int i15;
        int i20;
        int i13;
        int i18;
        int i17;
        int i4;
        int i8;
        float adjustedBarStart2;
        float f;
        int i19;
        DrawScope drawScope;
        long l3;
        long l;
        int i12;
        int i7;
        int i11;
        int i16;
        int i21;
        int i6;
        int i10;
        int i14;
        float width-impl = Size.getWidth-impl($this$drawLinearIndicator_u2dqYKTg0g.getSize-NH-jbRc());
        float height-impl = Size.getHeight-impl($this$drawLinearIndicator_u2dqYKTg0g.getSize-NH-jbRc());
        i = (float)i24;
        final int i25 = height-impl / i;
        i3 = $this$drawLinearIndicator_u2dqYKTg0g.getLayoutDirection() == LayoutDirection.Ltr ? 1 : 0;
        int i26 = 1065353216;
        i2 = i3 != 0 ? startFraction : i26 - endFraction;
        i2 *= width-impl;
        i22 = i3 != 0 ? endFraction : i26 - startFraction;
        i22 *= width-impl;
        i23 = obj46;
        if (!StrokeCap.equals-impl0(i23, StrokeCap.Companion.getButt-KaPHkGw())) {
            if (Float.compare(height-impl, width-impl) > 0) {
                DrawScope.drawLine-NGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, obj27, OffsetKt.Offset(i28, i25), obj29, OffsetKt.Offset(i27, i25), obj31, strokeCap, 0, 0, 0, 0);
            } else {
                i = strokeCap / i;
                rangeTo = RangesKt.rangeTo(i, width-impl - i);
                adjustedBarStart = (Number)RangesKt.coerceIn((Comparable)Float.valueOf(i28), rangeTo).floatValue();
                floatValue = (Number)RangesKt.coerceIn((Comparable)Float.valueOf(i27), rangeTo).floatValue();
                i9 = 0;
                if (Float.compare(f2, i9) > 0) {
                    adjustedBarStart2 = adjustedBarStart;
                    f = floatValue;
                    DrawScope.drawLine-NGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, floatValue, OffsetKt.Offset(adjustedBarStart, i25), i9, OffsetKt.Offset(floatValue, i25), obj14, strokeCap, i23, 0, 0, 0);
                } else {
                    adjustedBarStart2 = adjustedBarStart;
                    f = floatValue;
                }
            }
        } else {
        }
    }

    public static final float getCircularIndicatorDiameter() {
        return ProgressIndicatorKt.CircularIndicatorDiameter;
    }

    public static final float getLinearIndicatorHeight() {
        return ProgressIndicatorKt.LinearIndicatorHeight;
    }

    public static final float getLinearIndicatorWidth() {
        return ProgressIndicatorKt.LinearIndicatorWidth;
    }
}
