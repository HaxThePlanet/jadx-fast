package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.ExitTransition.Companion;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material.icons.Icons.Filled;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015JA\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0013\u0008\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\u0008\u001b2\u0015\u0008\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a¢\u0006\u0002\u0008\u001bH\u0007¢\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$J\r\u0010%\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010&J\u008a\u0001\u0010%\u001a\u00020\u000f2\u0008\u0008\u0002\u0010'\u001a\u00020!2\u0008\u0008\u0002\u0010(\u001a\u00020!2\u0008\u0008\u0002\u0010)\u001a\u00020!2\u0008\u0008\u0002\u0010*\u001a\u00020!2\u0008\u0008\u0002\u0010+\u001a\u00020!2\u0008\u0008\u0002\u0010,\u001a\u00020!2\u0008\u0008\u0002\u0010-\u001a\u00020!2\u0008\u0008\u0002\u0010.\u001a\u00020!2\u0008\u0008\u0002\u0010/\u001a\u00020!2\u0008\u0008\u0002\u00100\u001a\u00020!2\u0008\u0008\u0002\u00101\u001a\u00020!2\u0008\u0008\u0002\u00102\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u00104J'\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010:R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006;", d2 = {"Landroidx/compose/material3/SegmentedButtonDefaults;", "", "()V", "BorderWidth", "Landroidx/compose/ui/unit/Dp;", "getBorderWidth-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "baseShape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "getBaseShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/CornerBasedShape;", "defaultSegmentedButtonColors", "Landroidx/compose/material3/SegmentedButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSegmentedButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SegmentedButtonColors;", "ActiveIcon", "", "(Landroidx/compose/runtime/Composer;I)V", "Icon", "active", "", "activeContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "inactiveContent", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "color", "Landroidx/compose/ui/graphics/Color;", "width", "borderStroke-l07J4OM", "(JF)Landroidx/compose/foundation/BorderStroke;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SegmentedButtonColors;", "activeContainerColor", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "colors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SegmentedButtonColors;", "itemShape", "Landroidx/compose/ui/graphics/Shape;", "index", "", "count", "(IILandroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Shape;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SegmentedButtonDefaults {

    public static final int $stable;
    private static final float BorderWidth;
    public static final androidx.compose.material3.SegmentedButtonDefaults INSTANCE;
    private static final float IconSize;
    static {
        SegmentedButtonDefaults segmentedButtonDefaults = new SegmentedButtonDefaults();
        SegmentedButtonDefaults.INSTANCE = segmentedButtonDefaults;
        SegmentedButtonDefaults.BorderWidth = OutlinedSegmentedButtonTokens.INSTANCE.getOutlineWidth-D9Ej5fM();
        SegmentedButtonDefaults.IconSize = OutlinedSegmentedButtonTokens.INSTANCE.getIconSize-D9Ej5fM();
    }

    public static BorderStroke borderStroke-l07J4OM$default(androidx.compose.material3.SegmentedButtonDefaults segmentedButtonDefaults, long l2, float f3, int i4, Object object5) {
        float obj3;
        if (object5 &= 2 != 0) {
            obj3 = SegmentedButtonDefaults.BorderWidth;
        }
        return segmentedButtonDefaults.borderStroke-l07J4OM(l2, f3);
    }

    public final void ActiveIcon(Composer $composer, int $changed) {
        int traceInProgress;
        int i3;
        int skipping;
        boolean traceInProgress2;
        int str;
        Modifier size-3ABfNKs;
        int i2;
        int i4;
        int i;
        int obj10;
        traceInProgress = -1273041460;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ActiveIcon)546@24428L147:SegmentedButton.kt#uh7d8r");
        str = 2;
        if ($changed & 6 == 0) {
            i3 = restartGroup.changed(this) ? 4 : str;
            obj10 |= i3;
        }
        if (obj10 & 3 == str) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, obj10, -1, "androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon (SegmentedButton.kt:545)");
                }
                IconKt.Icon-ww6aTOc(CheckKt.getCheck(Icons.Filled.INSTANCE), 0, SizeKt.size-3ABfNKs((Modifier)Modifier.Companion, SegmentedButtonDefaults.IconSize), 0, obj5, restartGroup, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new SegmentedButtonDefaults.ActiveIcon.1(this, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public final void Icon(boolean active, Function2<? super Composer, ? super Integer, Unit> activeContent, Function2<? super Composer, ? super Integer, Unit> inactiveContent, Composer $composer, int $changed, int i6) {
        Object rememberComposableLambda;
        int traceInProgress2;
        int $dirty2;
        int $dirty;
        boolean z;
        int i5;
        Object obj;
        int i4;
        Object inactiveContent2;
        Object obj2;
        boolean traceInProgress;
        int i;
        int str;
        Object plus;
        int i8;
        ExitTransition none;
        int i7;
        Composer restartGroup;
        Composer composer;
        int i3;
        int i2;
        Object obj18;
        final int i15 = $changed;
        traceInProgress2 = 683517296;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Icon):SegmentedButton.kt#uh7d8r");
        $dirty2 = $changed;
        int i12 = 2;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
            z = active;
        } else {
            if (i15 & 6 == 0) {
                i4 = restartGroup.changed(active) ? 4 : i12;
                $dirty2 |= i4;
            } else {
                z = active;
            }
        }
        int i14 = i6 & 2;
        if (i14 != 0) {
            $dirty2 |= 48;
            obj2 = activeContent;
        } else {
            if (i15 & 48 == 0) {
                i = restartGroup.changedInstance(activeContent) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj2 = activeContent;
            }
        }
        str = i6 & 4;
        if (str != null) {
            $dirty2 |= 384;
            plus = inactiveContent;
        } else {
            if (i15 & 384 == 0) {
                i8 = restartGroup.changedInstance(inactiveContent) ? 256 : 128;
                $dirty2 |= i8;
            } else {
                plus = inactiveContent;
            }
        }
        final int i28 = $dirty2;
        if (i28 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (i14 != 0) {
                    $dirty = ComposableSingletons.SegmentedButtonKt.INSTANCE.getLambda-1$material3_release();
                } else {
                    $dirty = obj2;
                }
                inactiveContent2 = str != null ? 0 : plus;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i28, -1, "androidx.compose.material3.SegmentedButtonDefaults.Icon (SegmentedButton.kt:566)");
                }
                int i17 = 1;
                if (inactiveContent2 == null) {
                    restartGroup.startReplaceGroup(1631306250);
                    ComposerKt.sourceInformation(restartGroup, "578@25645L47,568@25168L524");
                    int i20 = 350;
                    int i24 = 0;
                    i7 = 0;
                    int i25 = 6;
                    int i27 = 0;
                    SegmentedButtonDefaults.Icon.1 anon = new SegmentedButtonDefaults.Icon.1($dirty);
                    composer = restartGroup;
                    AnimatedVisibilityKt.AnimatedVisibility(z, 0, EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec)AnimationSpecKt.tween$default(i20, i24, i7, i25, i7), i27, i12, i7).plus(EnterExitTransitionKt.scaleIn-L8ZKh-E((FiniteAnimationSpec)AnimationSpecKt.tween$default(i20, i24, i7, i25, i7), i27, TransformOriginKt.TransformOrigin(i27, 1065353216))), ExitTransition.Companion.getNone(), i7, (Function3)ComposableLambdaKt.rememberComposableLambda(-750750819, i17, anon, restartGroup, 54), composer, i18 | i5, 18);
                    composer.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(1631842116);
                    ComposerKt.sourceInformation(restartGroup, "582@25754L50,582@25722L82");
                    SegmentedButtonDefaults.Icon.2 anon2 = new SegmentedButtonDefaults.Icon.2($dirty, inactiveContent2);
                    CrossfadeKt.Crossfade(Boolean.valueOf(active), 0, 0, 0, (Function3)ComposableLambdaKt.rememberComposableLambda(-1364873619, i17, anon2, restartGroup, 54), restartGroup, z | 24576, 14);
                    restartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                obj = obj2;
                inactiveContent2 = plus;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SegmentedButtonDefaults.Icon.3(this, active, obj, inactiveContent2, i15, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final BorderStroke borderStroke-l07J4OM(long color, float width) {
        return BorderStrokeKt.BorderStroke-cXLIe8U(obj4, color);
    }

    public final androidx.compose.material3.SegmentedButtonColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 679457321;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)431@18542L11:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:431)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultSegmentedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.SegmentedButtonColors colors-XqyqHi0(long activeContainerColor, long activeContentColor, long activeBorderColor, long inactiveContainerColor, long inactiveContentColor, long inactiveBorderColor, long disabledActiveContainerColor, long disabledActiveContentColor, long disabledActiveBorderColor, long disabledInactiveContainerColor, long disabledInactiveContentColor, long disabledInactiveBorderColor, Composer $composer, int $changed, int $changed1, int i16) {
        Color.Companion companion;
        String traceInProgress;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU11;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU7;
        int unspecified-0d7_KjU10;
        int unspecified-0d7_KjU4;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU9;
        long unspecified-0d7_KjU8;
        long unspecified-0d7_KjU6;
        int i2;
        int i;
        long l2;
        long l9;
        long l5;
        long l12;
        long l6;
        long l7;
        long l3;
        long l4;
        long l8;
        long l10;
        long l11;
        long l;
        final Composer composer = obj55;
        int i3 = obj58;
        int i4 = 132526205;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color,9:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color,6:c#ui.graphics.Color)467@20709L11:SegmentedButton.kt#uh7d8r");
        if (i3 & 1 != 0) {
            l2 = unspecified-0d7_KjU;
        } else {
            l2 = activeContainerColor;
        }
        if (i3 & 2 != 0) {
            l9 = unspecified-0d7_KjU11;
        } else {
            l9 = activeBorderColor;
        }
        if (i3 & 4 != 0) {
            l5 = unspecified-0d7_KjU5;
        } else {
            l5 = inactiveContentColor;
        }
        if (i3 & 8 != 0) {
            l12 = unspecified-0d7_KjU2;
        } else {
            l12 = disabledActiveContainerColor;
        }
        if (i3 & 16 != 0) {
            l6 = unspecified-0d7_KjU7;
        } else {
            l6 = disabledActiveBorderColor;
        }
        if (i3 & 32 != 0) {
            l7 = unspecified-0d7_KjU10;
        } else {
            l7 = disabledInactiveContentColor;
        }
        if (i3 & 64 != 0) {
            l3 = unspecified-0d7_KjU4;
        } else {
            l3 = $composer;
        }
        if (i3 & 128 != 0) {
            l4 = unspecified-0d7_KjU3;
        } else {
            l4 = $changed1;
        }
        if (i3 & 256 != 0) {
            l8 = unspecified-0d7_KjU9;
        } else {
            l8 = obj47;
        }
        if (i3 & 512 != 0) {
            l10 = unspecified-0d7_KjU8;
        } else {
            l10 = obj49;
        }
        if (i3 & 1024 != 0) {
            l11 = unspecified-0d7_KjU6;
        } else {
            l11 = obj51;
        }
        if (i3 &= 2048 != 0) {
            l = unspecified-0d7_KjU6;
        } else {
            l = obj53;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, obj56, obj57, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:467)");
        } else {
            i2 = obj56;
            i = obj57;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultSegmentedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-2qZNXz8(l2, obj7, l9, obj9, l5, obj11, l12, obj13, l6, obj15, l7, obj17);
    }

    public final CornerBasedShape getBaseShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1264240381;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C512@23272L5:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SegmentedButtonDefaults.<get-baseShape> (SegmentedButton.kt:512)");
        }
        Shape value = ShapesKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getShape(), $composer, 6);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (CornerBasedShape)value;
    }

    public final float getBorderWidth-D9Ej5fM() {
        return SegmentedButtonDefaults.BorderWidth;
    }

    public final androidx.compose.material3.SegmentedButtonColors getDefaultSegmentedButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultSegmentedButtonColors) {
        androidx.compose.material3.SegmentedButtonColors defaultSegmentedButtonColorsCached$material3_release;
        androidx.compose.material3.SegmentedButtonColors segmentedButtonColors;
        int i5;
        long token4;
        long token6;
        long surface-0d7_KjU2;
        long token7;
        long token2;
        long token;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i2;
        long surface-0d7_KjU;
        int i6;
        long token5;
        int i;
        long token3;
        int i3;
        int i4;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultSegmentedButtonColors;
        if (colorScheme.getDefaultSegmentedButtonColorsCached$material3_release() == null) {
            i2 = 0;
            i6 = 0;
            i3 = 0;
            i = 0;
            segmentedButtonColors = new SegmentedButtonColors(ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedContainerColor()), obj4, ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), obj8, colorScheme.getSurface-0d7_KjU(), obj10, ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getUnselectedLabelTextColor()), obj12, ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), obj14, ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedContainerColor()), obj16, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextColor()), obj18, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), i2, 0, i6, 14), obj18, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), i2, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledOutlineOpacity(), i6, 0, i, 14), i2, colorScheme.getSurface-0d7_KjU(), i6, ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextColor()), i, ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), i3, 0);
            i5 = 0;
            colorScheme.setDefaultSegmentedButtonColorsCached$material3_release(segmentedButtonColors);
        }
        return defaultSegmentedButtonColorsCached$material3_release;
    }

    public final float getIconSize-D9Ej5fM() {
        return SegmentedButtonDefaults.IconSize;
    }

    public final Shape itemShape(int index, int count, CornerBasedShape baseShape, Composer $composer, int $changed, int i6) {
        String str;
        CornerBasedShape obj5;
        int obj8;
        int i = -942072063;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(itemShape)P(2,1)528@23938L9:SegmentedButton.kt#uh7d8r");
        if (i6 &= 4 != 0) {
            obj5 = getBaseShape($composer, obj8 &= 14);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SegmentedButtonDefaults.itemShape (SegmentedButton.kt:528)");
        }
        if (count == 1 && ComposerKt.isTraceInProgress()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            return (Shape)obj5;
        }
        if (index == 0) {
            obj8 = ShapesKt.start(obj5);
        } else {
            if (index == count + -1) {
                obj8 = ShapesKt.end(obj5);
            } else {
                obj8 = RectangleShapeKt.getRectangleShape();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return obj8;
    }
}
