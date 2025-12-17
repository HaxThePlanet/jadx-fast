package androidx.compose.material3;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u00085\u00106R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R$\u0010\n\u001a\u00020\u000b8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0011\u0010\u000eR$\u0010\u0012\u001a\u00020\u000b8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0016\u0010\u0006R$\u0010\u0017\u001a\u00020\u000b8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\u0008\u0018\u0010\u0002\u001a\u0004\u0008\u0019\u0010\u000eR\u0017\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020 8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0017\u0010#\u001a\u00020 8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008$\u0010\"R\u0017\u0010%\u001a\u00020 8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008&\u0010\"R \u0010'\u001a\u00020 8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008(\u0010\u0002\u001a\u0004\u0008)\u0010\"R\u0017\u0010*\u001a\u00020 8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008+\u0010\"R\u0017\u0010,\u001a\u00020 8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008-\u0010\"\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00067", d2 = {"Landroidx/compose/material3/ProgressIndicatorDefaults;", "", "()V", "CircularDeterminateStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getCircularDeterminateStrokeCap-KaPHkGw", "()I", "I", "CircularIndeterminateStrokeCap", "getCircularIndeterminateStrokeCap-KaPHkGw", "CircularIndicatorTrackGapSize", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorTrackGapSize-D9Ej5fM$annotations", "getCircularIndicatorTrackGapSize-D9Ej5fM", "()F", "F", "CircularStrokeWidth", "getCircularStrokeWidth-D9Ej5fM", "LinearIndicatorTrackGapSize", "getLinearIndicatorTrackGapSize-D9Ej5fM$annotations", "getLinearIndicatorTrackGapSize-D9Ej5fM", "LinearStrokeCap", "getLinearStrokeCap-KaPHkGw", "LinearTrackStopIndicatorSize", "getLinearTrackStopIndicatorSize-D9Ej5fM$annotations", "getLinearTrackStopIndicatorSize-D9Ej5fM", "ProgressAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getProgressAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "circularColor", "Landroidx/compose/ui/graphics/Color;", "getCircularColor", "(Landroidx/compose/runtime/Composer;I)J", "circularDeterminateTrackColor", "getCircularDeterminateTrackColor", "circularIndeterminateTrackColor", "getCircularIndeterminateTrackColor", "circularTrackColor", "getCircularTrackColor$annotations", "getCircularTrackColor", "linearColor", "getLinearColor", "linearTrackColor", "getLinearTrackColor", "drawStopIndicator", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "stopSize", "color", "strokeCap", "drawStopIndicator-EgI2THU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJI)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProgressIndicatorDefaults {

    public static final int $stable;
    private static final int CircularDeterminateStrokeCap;
    private static final int CircularIndeterminateStrokeCap;
    private static final float CircularIndicatorTrackGapSize;
    private static final float CircularStrokeWidth;
    public static final androidx.compose.material3.ProgressIndicatorDefaults INSTANCE;
    private static final float LinearIndicatorTrackGapSize;
    private static final int LinearStrokeCap;
    private static final float LinearTrackStopIndicatorSize;
    private static final SpringSpec<Float> ProgressAnimationSpec;
    static {
        ProgressIndicatorDefaults progressIndicatorDefaults = new ProgressIndicatorDefaults();
        ProgressIndicatorDefaults.INSTANCE = progressIndicatorDefaults;
        ProgressIndicatorDefaults.CircularStrokeWidth = ProgressIndicatorTokens.INSTANCE.getTrackThickness-D9Ej5fM();
        ProgressIndicatorDefaults.LinearStrokeCap = StrokeCap.Companion.getRound-KaPHkGw();
        ProgressIndicatorDefaults.CircularDeterminateStrokeCap = StrokeCap.Companion.getRound-KaPHkGw();
        ProgressIndicatorDefaults.CircularIndeterminateStrokeCap = StrokeCap.Companion.getRound-KaPHkGw();
        ProgressIndicatorDefaults.LinearTrackStopIndicatorSize = ProgressIndicatorTokens.INSTANCE.getStopSize-D9Ej5fM();
        ProgressIndicatorDefaults.LinearIndicatorTrackGapSize = ProgressIndicatorTokens.INSTANCE.getActiveTrackSpace-D9Ej5fM();
        ProgressIndicatorDefaults.CircularIndicatorTrackGapSize = ProgressIndicatorTokens.INSTANCE.getActiveTrackSpace-D9Ej5fM();
        SpringSpec springSpec = new SpringSpec(1065353216, 1112014848, 0.001f);
        ProgressIndicatorDefaults.ProgressAnimationSpec = springSpec;
    }

    public static void getCircularIndicatorTrackGapSize-D9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to circularDeterminateTrackColor or circularIndeterminateTrackColor", replaceWith = @ReplaceWith(...))
    public static void getCircularTrackColor$annotations() {
    }

    public static void getLinearIndicatorTrackGapSize-D9Ej5fM$annotations() {
    }

    public static void getLinearTrackStopIndicatorSize-D9Ej5fM$annotations() {
    }

    public final void drawStopIndicator-EgI2THU(DrawScope drawScope, float stopSize, long color, int strokeCap) {
        DrawScope drawScope2;
        int i7;
        long l;
        long l2;
        int i2;
        int i6;
        int i8;
        int i3;
        int i;
        int i4;
        int i5;
        final Object obj = drawScope;
        final int i20 = 0;
        float height-impl2 = Size.getHeight-impl(obj.getSize-NH-jbRc());
        final float f4 = f;
        final int i21 = i9 / f2;
        int i15 = 1073741824;
        if (StrokeCap.equals-impl0(obj22, StrokeCap.Companion.getRound-KaPHkGw())) {
            DrawScope.drawCircle-VaOC9Bg$default(obj, color, i15, f4 / i15, OffsetKt.Offset(i10 -= i21, height-impl4 /= i15), obj5, 0, 0, 0, 0);
        } else {
            DrawScope.drawRect-n-J9OG0$default(obj, color, i15, OffsetKt.Offset(i12 -= i21, i16 /= i15), obj4, SizeKt.Size(f4, f4), obj6, 0, 0, 0);
        }
    }

    public final long getCircularColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1803349725;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C847@34197L5:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularColor> (ProgressIndicator.kt:847)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), $composer, 6);
    }

    public final int getCircularDeterminateStrokeCap-KaPHkGw() {
        return ProgressIndicatorDefaults.CircularDeterminateStrokeCap;
    }

    public final long getCircularDeterminateTrackColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2143778381;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C864@34928L5:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularDeterminateTrackColor> (ProgressIndicator.kt:864)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), $composer, 6);
    }

    public final int getCircularIndeterminateStrokeCap-KaPHkGw() {
        return ProgressIndicatorDefaults.CircularIndeterminateStrokeCap;
    }

    public final long getCircularIndeterminateTrackColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1947901123;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularIndeterminateTrackColor> (ProgressIndicator.kt:868)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color.Companion.getTransparent-0d7_KjU();
    }

    public final float getCircularIndicatorTrackGapSize-D9Ej5fM() {
        return ProgressIndicatorDefaults.CircularIndicatorTrackGapSize;
    }

    public final float getCircularStrokeWidth-D9Ej5fM() {
        return ProgressIndicatorDefaults.CircularStrokeWidth;
    }

    public final long getCircularTrackColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -404222247;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularTrackColor> (ProgressIndicator.kt:860)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color.Companion.getTransparent-0d7_KjU();
    }

    public final long getLinearColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -914312983;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C843@34028L5:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearColor> (ProgressIndicator.kt:843)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), $composer, 6);
    }

    public final float getLinearIndicatorTrackGapSize-D9Ej5fM() {
        return ProgressIndicatorDefaults.LinearIndicatorTrackGapSize;
    }

    public final int getLinearStrokeCap-KaPHkGw() {
        return ProgressIndicatorDefaults.LinearStrokeCap;
    }

    public final long getLinearTrackColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1677541593;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C851@34363L5:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearTrackColor> (ProgressIndicator.kt:851)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), $composer, 6);
    }

    public final float getLinearTrackStopIndicatorSize-D9Ej5fM() {
        return ProgressIndicatorDefaults.LinearTrackStopIndicatorSize;
    }

    public final SpringSpec<Float> getProgressAnimationSpec() {
        return ProgressIndicatorDefaults.ProgressAnimationSpec;
    }
}
