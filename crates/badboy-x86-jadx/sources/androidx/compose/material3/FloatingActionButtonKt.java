package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\n\u001a|\u0010\n\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0002\u0008\u001c¢\u0006\u0002\u0008\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u008e\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u001c2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u001c2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%\u001aq\u0010&\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001aq\u0010)\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008*\u0010(\u001aq\u0010+\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008,\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006-", d2 = {"ExtendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "ExtendedFabEndIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "ExtendedFabMinimumWidth", "ExtendedFabStartIconPadding", "ExtendedFabTextPadding", "ExtendedFloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatingActionButtonKt {

    private static final ExitTransition ExtendedFabCollapseAnimation;
    private static final float ExtendedFabEndIconPadding;
    private static final EnterTransition ExtendedFabExpandAnimation;
    private static final float ExtendedFabMinimumWidth;
    private static final float ExtendedFabStartIconPadding;
    private static final float ExtendedFabTextPadding;
    static {
        int i5 = 0;
        FloatingActionButtonKt.ExtendedFabStartIconPadding = Dp.constructor-impl((float)i);
        int i6 = 0;
        FloatingActionButtonKt.ExtendedFabEndIconPadding = Dp.constructor-impl((float)i2);
        int i7 = 0;
        FloatingActionButtonKt.ExtendedFabTextPadding = Dp.constructor-impl((float)i3);
        int i8 = 0;
        FloatingActionButtonKt.ExtendedFabMinimumWidth = Dp.constructor-impl((float)i4);
        int i9 = 100;
        int i10 = 0;
        int i11 = 2;
        int i12 = 0;
        int i14 = 0;
        int i18 = 500;
        FloatingActionButtonKt.ExtendedFabCollapseAnimation = EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec)AnimationSpecKt.tween$default(i9, i10, (Easing)MotionTokens.INSTANCE.getEasingLinearCubicBezier(), i11, i12), i14, i11, i12).plus(EnterExitTransitionKt.shrinkHorizontally$default((FiniteAnimationSpec)AnimationSpecKt.tween$default(i18, i10, (Easing)MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), i11, i12), Alignment.Companion.getStart(), false, 0, 12, 0));
        FloatingActionButtonKt.ExtendedFabExpandAnimation = EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec)AnimationSpecKt.tween(200, i9, (Easing)MotionTokens.INSTANCE.getEasingLinearCubicBezier()), i14, i11, i12).plus(EnterExitTransitionKt.expandHorizontally$default((FiniteAnimationSpec)AnimationSpecKt.tween$default(i18, i10, (Easing)MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), i11, i12), Alignment.Companion.getStart(), false, 0, 12, 0));
    }

    public static final void ExtendedFloatingActionButton-ElI5-7k(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Function0<Unit> onClick, Modifier modifier, boolean expanded, Shape shape, long containerColor, long contentColor, androidx.compose.material3.FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        long l2;
        boolean traceInProgress2;
        Object endRestartGroup;
        int defaultsInvalid;
        Object modifier2;
        boolean traceInProgress;
        Function2 function2;
        int str;
        int $dirty2;
        Object elevation-xZ9-QkE;
        int i;
        int i12;
        int i2;
        Object obj7;
        Object obj;
        Object obj6;
        boolean z2;
        int extendedFabShape;
        long containerColor5;
        int i15;
        Object obj2;
        int containerColor2;
        boolean z3;
        long expanded2;
        int i14;
        int i8;
        Object contentColorFor-ek8zF_U;
        long l3;
        int changed4;
        long l;
        Object obj4;
        int $dirty3;
        int changed;
        int i3;
        Object obj10;
        Object obj5;
        Object obj3;
        int $dirty;
        int changed3;
        Object i4;
        int changed2;
        Object expanded3;
        boolean z;
        int i11;
        int i7;
        int i6;
        long l4;
        int i5;
        Object containerColor3;
        long containerColor4;
        Object obj8;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i9;
        int i10;
        Object obj9;
        int obj32;
        int obj41;
        Object obj11 = text;
        final Object obj12 = icon;
        final int i60 = obj42;
        final int i61 = obj43;
        final Composer restartGroup = i13.startRestartGroup(-1387401842);
        ComposerKt.sourceInformation(restartGroup, "C(ExtendedFloatingActionButton)P(9,4,7,6,3,8,0:c#ui.graphics.Color,1:c#ui.graphics.Color)359@17300L16,360@17375L14,361@17417L31,362@17526L11,373@17867L1053,365@17604L1316:FloatingActionButton.kt#uh7d8r");
        $dirty2 = obj42;
        if (i61 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i60 & 6 == 0) {
                i = restartGroup.changedInstance(obj11) ? 4 : 2;
                $dirty2 |= i;
            }
        }
        if (i61 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i60 & 48 == 0) {
                i12 = restartGroup.changedInstance(obj12) ? 32 : 16;
                $dirty2 |= i12;
            }
        }
        if (i61 & 4 != 0) {
            $dirty2 |= 384;
            obj3 = onClick;
        } else {
            if (i60 & 384 == 0) {
                i2 = restartGroup.changedInstance(onClick) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                obj3 = onClick;
            }
        }
        int i29 = i61 & 8;
        if (i29 != 0) {
            $dirty2 |= 3072;
            obj6 = modifier;
        } else {
            if (i60 & 3072 == 0) {
                i15 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i15;
            } else {
                obj6 = modifier;
            }
        }
        containerColor2 = i61 & 16;
        if (containerColor2 != 0) {
            $dirty2 |= 24576;
            z3 = expanded;
        } else {
            if (i60 & 24576 == 0) {
                i8 = restartGroup.changed(expanded) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                z3 = expanded;
            }
        }
        if (i52 &= i60 == 0) {
            if (i61 & 32 == 0) {
                changed4 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                contentColorFor-ek8zF_U = shape;
            }
            $dirty2 |= changed4;
        } else {
            contentColorFor-ek8zF_U = shape;
        }
        if (i56 &= i60 == 0) {
            if (i61 & 64 == 0) {
                changed = restartGroup.changed(containerColor) ? 1048576 : 524288;
            } else {
                l = containerColor;
            }
            $dirty2 |= changed;
        } else {
            l = containerColor;
        }
        i3 = 12582912;
        if (i60 & i3 == 0) {
            obj41 = i3;
            if (i61 & 128 == 0) {
                changed3 = restartGroup.changed(elevation) ? 8388608 : 4194304;
            } else {
                l2 = elevation;
            }
            $dirty2 |= changed3;
        } else {
            l2 = elevation;
            obj41 = i3;
        }
        if (i60 & i62 == 0) {
            if (i61 & 256 == 0) {
                changed2 = restartGroup.changed($composer) ? 67108864 : 33554432;
            } else {
                obj10 = $composer;
            }
            $dirty2 |= changed2;
        } else {
            obj10 = $composer;
        }
        int i30 = i61 & 512;
        int i63 = 805306368;
        if (i30 != 0) {
            $dirty2 |= i63;
            i11 = i30;
            obj7 = $changed;
        } else {
            if (i60 & i63 == 0) {
                i11 = i30;
                i7 = restartGroup.changed($changed) ? 536870912 : 268435456;
                $dirty2 |= i7;
            } else {
                i11 = i30;
                obj7 = $changed;
            }
        }
        if ($dirty2 & i6 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -234881025;
                i6 = -29360129;
                int i65 = -3670017;
                i5 = -458753;
                if (i60 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i29 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj6;
                        }
                        z = containerColor2 != 0 ? obj6 : z3;
                        containerColor2 = 6;
                        if (i61 & 32 != 0) {
                            $dirty2 &= i5;
                            i5 = extendedFabShape;
                        } else {
                            i5 = contentColorFor-ek8zF_U;
                        }
                        if (i61 & 64 != 0) {
                            containerColor5 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(restartGroup, containerColor2);
                            $dirty2 &= i65;
                        } else {
                            containerColor5 = l;
                        }
                        if (i61 & 128 != 0) {
                            i6 = contentColorFor-ek8zF_U;
                            $dirty3 = $dirty2;
                        } else {
                            i6 = elevation;
                            $dirty3 = $dirty2;
                        }
                        if (i61 & 256 != 0) {
                            containerColor4 = l5;
                            elevation-xZ9-QkE = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0, 0, 0, 0, restartGroup, 24576, 15);
                            $dirty3 &= str;
                        } else {
                            containerColor4 = containerColor5;
                            elevation-xZ9-QkE = obj10;
                        }
                        if (i11 != 0) {
                            obj6 = modifier2;
                            z3 = z;
                            expanded3 = i5;
                            l4 = i6;
                            i11 = containerColor4;
                            obj8 = str;
                            containerColor3 = elevation-xZ9-QkE;
                            $dirty2 = $dirty3;
                        } else {
                            obj6 = modifier2;
                            z3 = z;
                            expanded3 = i5;
                            l4 = i6;
                            i11 = containerColor4;
                            obj8 = $changed;
                            containerColor3 = elevation-xZ9-QkE;
                            $dirty2 = $dirty3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i61 & 32 != 0) {
                            $dirty2 &= i5;
                        }
                        if (i61 & 64 != 0) {
                            $dirty2 &= i65;
                        }
                        if (i61 & 128 != 0) {
                            $dirty2 &= i6;
                        }
                        if (i61 & 256 != 0) {
                            l4 = elevation;
                            $dirty2 = modifier2;
                            obj8 = obj7;
                            expanded3 = contentColorFor-ek8zF_U;
                            i11 = l;
                            containerColor3 = obj10;
                        } else {
                            l4 = elevation;
                            obj8 = obj7;
                            expanded3 = contentColorFor-ek8zF_U;
                            i11 = l;
                            containerColor3 = obj10;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1387401842, $dirty2, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:364)");
                }
                FloatingActionButtonKt.ExtendedFloatingActionButton.3 anon = new FloatingActionButtonKt.ExtendedFloatingActionButton.3(z3, obj12, text);
                i4 = obj6;
                FloatingActionButtonKt.FloatingActionButton-X-z6DiA(obj3, i4, expanded3, i11, i6, l4, i5, containerColor3, obj8, (Function2)ComposableLambdaKt.rememberComposableLambda(1172118032, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z3;
                obj = i4;
                obj2 = expanded3;
                expanded2 = i11;
                l3 = l4;
                obj4 = containerColor3;
                obj5 = obj8;
                $dirty = $dirty2;
            } else {
                restartGroup.skipToGroupEnd();
                function2 = text;
                composer = restartGroup;
                obj2 = contentColorFor-ek8zF_U;
                obj5 = obj7;
                obj = obj6;
                z2 = z3;
                expanded2 = l;
                obj4 = obj9;
                l3 = elevation;
                $dirty = $dirty2;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            obj32 = $dirty;
            endRestartGroup = new FloatingActionButtonKt.ExtendedFloatingActionButton.4(function2, obj12, onClick, obj, z2, obj2, expanded2, restartGroup, l3, l, obj4, obj5, i60, i61);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj32 = $dirty;
        }
    }

    public static final void ExtendedFloatingActionButton-X-z6DiA(Function0<Unit> onClick, Modifier modifier, Shape shape, long containerColor, long contentColor, androidx.compose.material3.FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i15;
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int $dirty2;
        long $dirty5;
        int i13;
        int containerColor3;
        int i2;
        Object obj2;
        Object $dirty;
        int extendedFabShape;
        int $dirty4;
        boolean traceInProgress;
        Object obj4;
        int i5;
        Object str;
        long l;
        int changed4;
        int i3;
        int changed2;
        int i9;
        int i6;
        Object obj;
        int changed;
        int changed3;
        long $composer2;
        long containerColor4;
        int i12;
        Object obj9;
        Object obj6;
        Object obj7;
        Object obj5;
        int i14;
        long contentColor2;
        Object obj8;
        long i7;
        int i10;
        long i16;
        int i8;
        Object obj3;
        Object shape2;
        int $dirty3;
        Object $dirty6;
        long containerColor2;
        Composer composer;
        int i4;
        int i;
        long l2;
        int obj38;
        final Object obj11 = $changed;
        final int i55 = obj39;
        final int i56 = obj40;
        Composer restartGroup = i11.startRestartGroup(-326283107);
        ComposerKt.sourceInformation(restartGroup, "C(ExtendedFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)285@13734L16,286@13809L14,287@13851L31,288@13960L11,300@14347L335,292@14084L598:FloatingActionButton.kt#uh7d8r");
        $dirty2 = obj39;
        if (i56 & 1 != 0) {
            $dirty2 |= 6;
            obj5 = onClick;
        } else {
            if (i55 & 6 == 0) {
                i13 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i13;
            } else {
                obj5 = onClick;
            }
        }
        int i31 = i56 & 2;
        if (i31 != 0) {
            $dirty2 |= 48;
            $dirty = modifier;
        } else {
            if (i55 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                $dirty = modifier;
            }
        }
        if (i55 & 384 == 0) {
            if (i56 & 4 == 0) {
                changed4 = restartGroup.changed(shape) ? 256 : 128;
            } else {
                str = shape;
            }
            $dirty2 |= changed4;
        } else {
            str = shape;
        }
        if (i55 & 3072 == 0) {
            if (i56 & 8 == 0) {
                i3 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                containerColor4 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor4 = containerColor;
        }
        if (i55 & 24576 == 0) {
            if (i56 & 16 == 0) {
                i9 = restartGroup.changed(elevation) ? 16384 : 8192;
            } else {
                contentColor2 = elevation;
            }
            $dirty2 |= i9;
        } else {
            contentColor2 = elevation;
        }
        if (i52 &= i55 == 0) {
            if (i56 & 32 == 0) {
                i6 = restartGroup.changed(content) ? 131072 : 65536;
            } else {
                obj6 = content;
            }
            $dirty2 |= i6;
        } else {
            obj6 = content;
        }
        i7 = i56 & 64;
        int i53 = 1572864;
        if (i7 != 0) {
            $dirty2 |= i53;
            obj = $composer;
        } else {
            if (i53 &= i55 == 0) {
                i10 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty2 |= i10;
            } else {
                obj = $composer;
            }
        }
        i16 = 12582912;
        if (i56 & 128 != 0) {
            $dirty2 |= i16;
        } else {
            if (i55 & i16 == 0) {
                i15 = restartGroup.changedInstance(obj11) ? 8388608 : 4194304;
                $dirty2 |= i15;
            }
        }
        if (i18 &= $dirty2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i8 = -458753;
                int i33 = -57345;
                if (i55 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = $dirty;
                        }
                        containerColor3 = 6;
                        if (i56 & 4 != 0) {
                            $dirty2 &= -897;
                            obj3 = extendedFabShape;
                        } else {
                            obj3 = str;
                        }
                        if (i56 & 8 != 0) {
                            $dirty4 = $dirty7;
                            $dirty5 = l2;
                        } else {
                            $dirty4 = $dirty2;
                            $dirty5 = containerColor4;
                        }
                        if (i56 & 16 != 0) {
                            contentColor2 = containerColor4;
                            $dirty3 = $dirty4;
                        } else {
                            $dirty3 = $dirty4;
                        }
                        if (i56 & 32 != 0) {
                            containerColor2 = l4;
                            $dirty3 &= i8;
                            obj6 = $dirty5;
                        } else {
                            containerColor2 = $dirty5;
                        }
                        if (i7 != 0) {
                            contentColor2 = modifier2;
                            modifier3 = i16;
                            i16 = l6;
                            $dirty6 = i30;
                            $dirty2 = i34;
                            obj8 = obj3;
                            i7 = containerColor2;
                            i2 = -326283107;
                            shape2 = obj6;
                        } else {
                            contentColor2 = modifier2;
                            modifier3 = i16;
                            i16 = interactionSource2;
                            obj8 = obj3;
                            $dirty2 = $dirty3;
                            i7 = containerColor2;
                            i2 = -326283107;
                            $dirty6 = $composer;
                            shape2 = obj6;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i56 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i56 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i56 & 16 != 0) {
                            $dirty2 &= i33;
                        }
                        if (i56 & 32 != 0) {
                            $dirty2 = i23;
                            $dirty6 = obj;
                            i7 = containerColor4;
                            shape2 = obj6;
                            modifier3 = i16;
                            i2 = -326283107;
                            i16 = contentColor2;
                            contentColor2 = $dirty;
                            obj8 = str;
                        } else {
                            $dirty6 = obj;
                            i7 = containerColor4;
                            shape2 = obj6;
                            modifier3 = i16;
                            i2 = -326283107;
                            i16 = contentColor2;
                            contentColor2 = $dirty;
                            obj8 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i2, $dirty2, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:291)");
                }
                FloatingActionButtonKt.ExtendedFloatingActionButton.1 anon = new FloatingActionButtonKt.ExtendedFloatingActionButton.1(obj11);
                FloatingActionButtonKt.FloatingActionButton-X-z6DiA(obj5, contentColor2, obj8, i7, i10, i16, i8, shape2, $dirty6, (Function2)ComposableLambdaKt.rememberComposableLambda(398457247, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = contentColor2;
                obj4 = obj8;
                l = i7;
                $composer2 = i16;
                obj9 = shape2;
                obj7 = $dirty6;
                i14 = $dirty2;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = $dirty;
                obj4 = str;
                composer = restartGroup;
                obj7 = obj;
                l = containerColor4;
                obj9 = l2;
                $composer2 = contentColor2;
                i14 = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new FloatingActionButtonKt.ExtendedFloatingActionButton.2(onClick, obj2, obj4, l, obj, $composer2, containerColor4, obj9, obj7, obj11, i55, i56);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void FloatingActionButton-X-z6DiA(Function0<Unit> onClick, Modifier modifier, Shape shape, long containerColor, long contentColor, androidx.compose.material3.FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i8;
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier3;
        int modifier4;
        Object str;
        int $dirty3;
        long $dirty5;
        int i;
        int containerColor4;
        boolean traceInProgress;
        Object obj4;
        Object obj7;
        int shape2;
        int $dirty4;
        int $dirty2;
        Object modifier2;
        int i2;
        Object str2;
        long l2;
        int changed2;
        int i3;
        int changed;
        int i9;
        int i10;
        Object obj6;
        int changed4;
        int changed3;
        long $composer2;
        long containerColor2;
        int i4;
        Object obj2;
        Object obj5;
        Object elevation2;
        Object obj3;
        int i7;
        long l3;
        int i12;
        Object i6;
        int i13;
        int i5;
        Object companion;
        int $dirty;
        long containerColor3;
        float unbox-impl;
        int i14;
        Object obj;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i16;
        int i15;
        int i17;
        long l;
        int obj33;
        int obj42;
        final Object obj10 = $changed;
        final int i57 = obj43;
        final int i58 = obj44;
        Composer restartGroup = i11.startRestartGroup(-731723913);
        ComposerKt.sourceInformation(restartGroup, "C(FloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)100@4948L5,101@5012L14,102@5054L31,103@5163L11,116@5678L54,118@5792L536,109@5399L929:FloatingActionButton.kt#uh7d8r");
        $dirty3 = obj43;
        if (i58 & 1 != 0) {
            $dirty3 |= 6;
            obj3 = onClick;
        } else {
            if (i57 & 6 == 0) {
                i = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty3 |= i;
            } else {
                obj3 = onClick;
            }
        }
        int i30 = i58 & 2;
        if (i30 != 0) {
            $dirty3 |= 48;
            obj7 = modifier;
        } else {
            if (i57 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i2;
            } else {
                obj7 = modifier;
            }
        }
        if (i57 & 384 == 0) {
            if (i58 & 4 == 0) {
                changed2 = restartGroup.changed(shape) ? 256 : 128;
            } else {
                str2 = shape;
            }
            $dirty3 |= changed2;
        } else {
            str2 = shape;
        }
        if (i57 & 3072 == 0) {
            if (i58 & 8 == 0) {
                i3 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                containerColor2 = containerColor;
            }
            $dirty3 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (i57 & 24576 == 0) {
            if (i58 & 16 == 0) {
                i9 = restartGroup.changed(elevation) ? 16384 : 8192;
            } else {
                l3 = elevation;
            }
            $dirty3 |= i9;
        } else {
            l3 = elevation;
        }
        if (i51 &= i57 == 0) {
            if (i58 & 32 == 0) {
                i10 = restartGroup.changed(content) ? 131072 : 65536;
            } else {
                obj5 = content;
            }
            $dirty3 |= i10;
        } else {
            obj5 = content;
        }
        i6 = i58 & 64;
        int i52 = 1572864;
        if (i6 != 0) {
            $dirty3 |= i52;
            obj6 = $composer;
        } else {
            if (i52 &= i57 == 0) {
                i13 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty3 |= i13;
            } else {
                obj6 = $composer;
            }
        }
        i5 = 12582912;
        if (i58 & 128 != 0) {
            $dirty3 |= i5;
        } else {
            if (i57 & i5 == 0) {
                i8 = restartGroup.changedInstance(obj10) ? 8388608 : 4194304;
                $dirty3 |= i8;
            }
        }
        if (i19 &= $dirty3 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i5 = -458753;
                containerColor4 = -57345;
                if (i57 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj7;
                        }
                        containerColor4 = 6;
                        if (i58 & 4 != 0) {
                            $dirty3 &= -897;
                            companion = shape2;
                        } else {
                            companion = str2;
                        }
                        if (i58 & 8 != 0) {
                            $dirty4 = $dirty6;
                            $dirty5 = l;
                        } else {
                            $dirty4 = $dirty3;
                            $dirty5 = containerColor2;
                        }
                        if (i58 & 16 != 0) {
                            l3 = containerColor2;
                            $dirty = $dirty4;
                        } else {
                            $dirty = $dirty4;
                        }
                        if (i58 & 32 != 0) {
                            containerColor3 = l5;
                            $dirty &= i5;
                            obj5 = $dirty5;
                        } else {
                            containerColor3 = $dirty5;
                        }
                        if (i6 != 0) {
                            obj7 = modifier3;
                            obj6 = i29;
                            i6 = companion;
                            $dirty3 = $dirty;
                            i13 = containerColor3;
                            modifier4 = -731723913;
                        } else {
                            obj6 = $composer;
                            obj7 = modifier3;
                            i6 = companion;
                            $dirty3 = $dirty;
                            i13 = containerColor3;
                            modifier4 = -731723913;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i58 & 4 != 0) {
                            $dirty3 &= -897;
                        }
                        if (i58 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i58 & 16 != 0) {
                            $dirty3 &= containerColor4;
                        }
                        if (i58 & 32 != 0) {
                            $dirty3 = i24;
                            i6 = str2;
                            i13 = containerColor2;
                            modifier4 = -731723913;
                        } else {
                            i6 = str2;
                            i13 = containerColor2;
                            modifier4 = -731723913;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier4, $dirty3, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:106)");
                }
                restartGroup.startReplaceGroup(519755085);
                ComposerKt.sourceInformation(restartGroup, "108@5355L39");
                if (obj6 == null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 519755736, "CC(remember):FloatingActionButton.kt#9igjgp");
                    traceInProgress = restartGroup;
                    str2 = 0;
                    containerColor2 = traceInProgress.rememberedValue();
                    i4 = 0;
                    obj33 = i27;
                    if (containerColor2 == Composer.Companion.getEmpty()) {
                        int i28 = 0;
                        traceInProgress.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        str = containerColor2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj = str;
                } else {
                    obj = obj6;
                }
                restartGroup.endReplaceGroup();
                int i54 = 1;
                FloatingActionButtonKt.FloatingActionButton.2 anon = new FloatingActionButtonKt.FloatingActionButton.2(l3, obj15, obj10);
                companion = l3;
                SurfaceKt.Surface-o_FOJdg(obj3, SemanticsModifierKt.semantics$default(obj7, false, (Function1)FloatingActionButtonKt.FloatingActionButton.1.INSTANCE, i54, 0), false, i6, i13, i5, companion, $dirty, obj5.tonalElevation-D9Ej5fM$material3_release(), (Dp)obj5.shadowElevation$material3_release((InteractionSource)obj, restartGroup, i41 &= 112).getValue().unbox-impl(), 0, obj, (Function2)ComposableLambdaKt.rememberComposableLambda(1249316354, i54, anon, restartGroup, 54), restartGroup, i35 | i49);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj7;
                obj2 = obj5;
                modifier2 = i6;
                $composer2 = companion;
                elevation2 = obj6;
                l2 = i13;
                i7 = $dirty3;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = obj7;
                modifier2 = str2;
                composer = restartGroup;
                elevation2 = obj6;
                l2 = containerColor2;
                obj2 = l;
                $composer2 = l3;
                i7 = $dirty3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new FloatingActionButtonKt.FloatingActionButton.3(onClick, obj4, modifier2, l2, obj6, $composer2, containerColor2, obj2, elevation2, obj10, i57, i58);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void LargeFloatingActionButton-X-z6DiA(Function0<Unit> onClick, Modifier modifier, Shape shape, long containerColor, long contentColor, androidx.compose.material3.FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj2;
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier4;
        int modifier3;
        int $dirty5;
        long $dirty4;
        int i9;
        int containerColor4;
        boolean traceInProgress;
        Object obj5;
        Object obj;
        int largeShape;
        int $dirty3;
        int $dirty2;
        Object modifier2;
        int i5;
        Object str;
        long l3;
        int changed3;
        int i13;
        int changed2;
        int i14;
        int i8;
        Object obj7;
        int changed;
        int changed4;
        long $composer2;
        long containerColor3;
        int i12;
        Object obj3;
        long l2;
        Object obj6;
        int i15;
        Object obj9;
        int i10;
        Object sizeIn-qDBjuR0$default;
        Object i;
        int i3;
        int i4;
        int i7;
        Object obj8;
        long shape2;
        int $dirty;
        long containerColor5;
        Object containerColor2;
        Object obj4;
        Composer composer;
        Composer composer2;
        int i6;
        int i2;
        long l;
        Object obj29;
        float obj30;
        float obj31;
        int obj32;
        int obj33;
        int obj34;
        int obj35;
        int obj38;
        final int i53 = obj39;
        final int i54 = obj40;
        Composer restartGroup = i11.startRestartGroup(-1650866856);
        ComposerKt.sourceInformation(restartGroup, "C(LargeFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)226@10910L10,227@10979L14,228@11021L31,229@11130L11,233@11245L455:FloatingActionButton.kt#uh7d8r");
        $dirty5 = obj39;
        if (i54 & 1 != 0) {
            $dirty5 |= 6;
            obj9 = onClick;
        } else {
            if (i53 & 6 == 0) {
                i9 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty5 |= i9;
            } else {
                obj9 = onClick;
            }
        }
        int i31 = i54 & 2;
        if (i31 != 0) {
            $dirty5 |= 48;
            obj = modifier;
        } else {
            if (i53 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty5 |= i5;
            } else {
                obj = modifier;
            }
        }
        if (i53 & 384 == 0) {
            if (i54 & 4 == 0) {
                changed3 = restartGroup.changed(shape) ? 256 : 128;
            } else {
                str = shape;
            }
            $dirty5 |= changed3;
        } else {
            str = shape;
        }
        if (i53 & 3072 == 0) {
            if (i54 & 8 == 0) {
                i13 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                containerColor3 = containerColor;
            }
            $dirty5 |= i13;
        } else {
            containerColor3 = containerColor;
        }
        if (i53 & 24576 == 0) {
            if (i54 & 16 == 0) {
                i14 = restartGroup.changed(elevation) ? 16384 : 8192;
            } else {
                l2 = elevation;
            }
            $dirty5 |= i14;
        } else {
            l2 = elevation;
        }
        if (i49 &= i53 == 0) {
            if (i54 & 32 == 0) {
                i8 = restartGroup.changed(content) ? 131072 : 65536;
            } else {
                sizeIn-qDBjuR0$default = content;
            }
            $dirty5 |= i8;
        } else {
            sizeIn-qDBjuR0$default = content;
        }
        i = i54 & 64;
        int i50 = 1572864;
        if (i != 0) {
            $dirty5 |= i50;
            obj7 = $composer;
        } else {
            if (i50 &= i53 == 0) {
                i3 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty5 |= i3;
            } else {
                obj7 = $composer;
            }
        }
        i4 = 12582912;
        if (i54 & 128 != 0) {
            $dirty5 |= i4;
            obj2 = $changed;
        } else {
            if (i53 & i4 == 0) {
                i4 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty5 |= i4;
            } else {
                obj2 = $changed;
            }
        }
        if ($dirty5 & i7 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i7 = -458753;
                containerColor4 = -57345;
                if (i53 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = obj;
                        }
                        containerColor4 = 6;
                        if (i54 & 4 != 0) {
                            $dirty5 &= -897;
                            obj8 = largeShape;
                        } else {
                            obj8 = str;
                        }
                        if (i54 & 8 != 0) {
                            $dirty3 = $dirty6;
                            $dirty4 = l;
                        } else {
                            $dirty3 = $dirty5;
                            $dirty4 = containerColor3;
                        }
                        if (i54 & 16 != 0) {
                            l2 = containerColor3;
                            $dirty = $dirty3;
                        } else {
                            $dirty = $dirty3;
                        }
                        if (i54 & 32 != 0) {
                            containerColor5 = l5;
                            $dirty &= i7;
                            sizeIn-qDBjuR0$default = $dirty4;
                        } else {
                            containerColor5 = $dirty4;
                        }
                        if (i != 0) {
                            obj = modifier4;
                            i = obj8;
                            i3 = containerColor5;
                            modifier3 = -1650866856;
                            obj4 = i30;
                            containerColor2 = sizeIn-qDBjuR0$default;
                            $dirty5 = $dirty;
                            shape2 = l2;
                        } else {
                            obj = modifier4;
                            i = obj8;
                            $dirty5 = $dirty;
                            i3 = containerColor5;
                            modifier3 = -1650866856;
                            obj4 = $composer;
                            shape2 = l2;
                            containerColor2 = sizeIn-qDBjuR0$default;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i54 & 4 != 0) {
                            $dirty5 &= -897;
                        }
                        if (i54 & 8 != 0) {
                            $dirty5 &= -7169;
                        }
                        if (i54 & 16 != 0) {
                            $dirty5 &= containerColor4;
                        }
                        if (i54 & 32 != 0) {
                            $dirty5 = i23;
                            i = str;
                            obj4 = obj7;
                            i3 = containerColor3;
                            shape2 = l2;
                            containerColor2 = sizeIn-qDBjuR0$default;
                            modifier3 = -1650866856;
                        } else {
                            i = str;
                            obj4 = obj7;
                            i3 = containerColor3;
                            shape2 = l2;
                            containerColor2 = sizeIn-qDBjuR0$default;
                            modifier3 = -1650866856;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier3, $dirty5, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:232)");
                }
                FloatingActionButtonKt.FloatingActionButton-X-z6DiA(obj9, SizeKt.sizeIn-qDBjuR0$default(obj, FabPrimaryLargeTokens.INSTANCE.getContainerWidth-D9Ej5fM(), FabPrimaryLargeTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 0, 0, 12, 0), i, i3, i7, shape2, $dirty, containerColor2, obj4, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj;
                modifier2 = i;
                l3 = i3;
                $composer2 = shape2;
                obj3 = containerColor2;
                obj6 = obj4;
                i10 = $dirty5;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = obj;
                modifier2 = str;
                composer2 = restartGroup;
                obj6 = obj7;
                l3 = containerColor3;
                $composer2 = l;
                obj3 = sizeIn-qDBjuR0$default;
                i10 = $dirty5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new FloatingActionButtonKt.LargeFloatingActionButton.1(onClick, obj5, modifier2, l3, obj7, $composer2, containerColor3, obj3, obj6, $changed, i53, i54);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void SmallFloatingActionButton-X-z6DiA(Function0<Unit> onClick, Modifier modifier, Shape shape, long containerColor, long contentColor, androidx.compose.material3.FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj8;
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int $dirty5;
        long $dirty4;
        int i4;
        int containerColor2;
        boolean traceInProgress;
        Object obj3;
        Object obj;
        int smallShape;
        int $dirty3;
        int $dirty;
        Object modifier4;
        int i3;
        Object str;
        long l;
        int changed4;
        int i5;
        int changed3;
        int i9;
        int i13;
        Object obj2;
        int changed2;
        int changed;
        long $composer2;
        long containerColor3;
        int i2;
        Object obj5;
        long l3;
        Object obj6;
        int i6;
        Object obj4;
        int i12;
        Object sizeIn-qDBjuR0$default;
        Object i15;
        int i7;
        int i8;
        int i14;
        Object obj9;
        long shape2;
        int $dirty2;
        long containerColor4;
        Object containerColor5;
        Object obj7;
        Composer composer;
        Composer composer2;
        int i10;
        int i;
        long l2;
        Object obj29;
        float obj30;
        float obj31;
        int obj32;
        int obj33;
        int obj34;
        int obj35;
        int obj38;
        final int i53 = obj39;
        final int i54 = obj40;
        Composer restartGroup = i11.startRestartGroup(1444748300);
        ComposerKt.sourceInformation(restartGroup, "C(SmallFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)170@8224L10,171@8293L14,172@8335L31,173@8444L11,177@8559L455:FloatingActionButton.kt#uh7d8r");
        $dirty5 = obj39;
        if (i54 & 1 != 0) {
            $dirty5 |= 6;
            obj4 = onClick;
        } else {
            if (i53 & 6 == 0) {
                i4 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty5 |= i4;
            } else {
                obj4 = onClick;
            }
        }
        int i31 = i54 & 2;
        if (i31 != 0) {
            $dirty5 |= 48;
            obj = modifier;
        } else {
            if (i53 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty5 |= i3;
            } else {
                obj = modifier;
            }
        }
        if (i53 & 384 == 0) {
            if (i54 & 4 == 0) {
                changed4 = restartGroup.changed(shape) ? 256 : 128;
            } else {
                str = shape;
            }
            $dirty5 |= changed4;
        } else {
            str = shape;
        }
        if (i53 & 3072 == 0) {
            if (i54 & 8 == 0) {
                i5 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                containerColor3 = containerColor;
            }
            $dirty5 |= i5;
        } else {
            containerColor3 = containerColor;
        }
        if (i53 & 24576 == 0) {
            if (i54 & 16 == 0) {
                i9 = restartGroup.changed(elevation) ? 16384 : 8192;
            } else {
                l3 = elevation;
            }
            $dirty5 |= i9;
        } else {
            l3 = elevation;
        }
        if (i49 &= i53 == 0) {
            if (i54 & 32 == 0) {
                i13 = restartGroup.changed(content) ? 131072 : 65536;
            } else {
                sizeIn-qDBjuR0$default = content;
            }
            $dirty5 |= i13;
        } else {
            sizeIn-qDBjuR0$default = content;
        }
        i15 = i54 & 64;
        int i50 = 1572864;
        if (i15 != 0) {
            $dirty5 |= i50;
            obj2 = $composer;
        } else {
            if (i50 &= i53 == 0) {
                i7 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty5 |= i7;
            } else {
                obj2 = $composer;
            }
        }
        i8 = 12582912;
        if (i54 & 128 != 0) {
            $dirty5 |= i8;
            obj8 = $changed;
        } else {
            if (i53 & i8 == 0) {
                i8 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty5 |= i8;
            } else {
                obj8 = $changed;
            }
        }
        if ($dirty5 & i14 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i14 = -458753;
                containerColor2 = -57345;
                if (i53 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        containerColor2 = 6;
                        if (i54 & 4 != 0) {
                            $dirty5 &= -897;
                            obj9 = smallShape;
                        } else {
                            obj9 = str;
                        }
                        if (i54 & 8 != 0) {
                            $dirty3 = $dirty6;
                            $dirty4 = l2;
                        } else {
                            $dirty3 = $dirty5;
                            $dirty4 = containerColor3;
                        }
                        if (i54 & 16 != 0) {
                            l3 = containerColor3;
                            $dirty2 = $dirty3;
                        } else {
                            $dirty2 = $dirty3;
                        }
                        if (i54 & 32 != 0) {
                            containerColor4 = l5;
                            $dirty2 &= i14;
                            sizeIn-qDBjuR0$default = $dirty4;
                        } else {
                            containerColor4 = $dirty4;
                        }
                        if (i15 != 0) {
                            obj = modifier2;
                            i15 = obj9;
                            i7 = containerColor4;
                            modifier3 = 1444748300;
                            obj7 = i30;
                            containerColor5 = sizeIn-qDBjuR0$default;
                            $dirty5 = $dirty2;
                            shape2 = l3;
                        } else {
                            obj = modifier2;
                            i15 = obj9;
                            $dirty5 = $dirty2;
                            i7 = containerColor4;
                            modifier3 = 1444748300;
                            obj7 = $composer;
                            shape2 = l3;
                            containerColor5 = sizeIn-qDBjuR0$default;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i54 & 4 != 0) {
                            $dirty5 &= -897;
                        }
                        if (i54 & 8 != 0) {
                            $dirty5 &= -7169;
                        }
                        if (i54 & 16 != 0) {
                            $dirty5 &= containerColor2;
                        }
                        if (i54 & 32 != 0) {
                            $dirty5 = i23;
                            i15 = str;
                            obj7 = obj2;
                            i7 = containerColor3;
                            shape2 = l3;
                            containerColor5 = sizeIn-qDBjuR0$default;
                            modifier3 = 1444748300;
                        } else {
                            i15 = str;
                            obj7 = obj2;
                            i7 = containerColor3;
                            shape2 = l3;
                            containerColor5 = sizeIn-qDBjuR0$default;
                            modifier3 = 1444748300;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier3, $dirty5, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:176)");
                }
                FloatingActionButtonKt.FloatingActionButton-X-z6DiA(obj4, SizeKt.sizeIn-qDBjuR0$default(obj, FabPrimarySmallTokens.INSTANCE.getContainerWidth-D9Ej5fM(), FabPrimarySmallTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 0, 0, 12, 0), i15, i7, i14, shape2, $dirty2, containerColor5, obj7, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj;
                modifier4 = i15;
                l = i7;
                $composer2 = shape2;
                obj5 = containerColor5;
                obj6 = obj7;
                i12 = $dirty5;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = obj;
                modifier4 = str;
                composer2 = restartGroup;
                obj6 = obj2;
                l = containerColor3;
                $composer2 = l2;
                obj5 = sizeIn-qDBjuR0$default;
                i12 = $dirty5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new FloatingActionButtonKt.SmallFloatingActionButton.1(onClick, obj3, modifier4, l, obj2, $composer2, containerColor3, obj5, obj6, $changed, i53, i54);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final ExitTransition access$getExtendedFabCollapseAnimation$p() {
        return FloatingActionButtonKt.ExtendedFabCollapseAnimation;
    }

    public static final float access$getExtendedFabEndIconPadding$p() {
        return FloatingActionButtonKt.ExtendedFabEndIconPadding;
    }

    public static final EnterTransition access$getExtendedFabExpandAnimation$p() {
        return FloatingActionButtonKt.ExtendedFabExpandAnimation;
    }

    public static final float access$getExtendedFabMinimumWidth$p() {
        return FloatingActionButtonKt.ExtendedFabMinimumWidth;
    }

    public static final float access$getExtendedFabStartIconPadding$p() {
        return FloatingActionButtonKt.ExtendedFabStartIconPadding;
    }

    public static final float access$getExtendedFabTextPadding$p() {
        return FloatingActionButtonKt.ExtendedFabTextPadding;
    }
}
