package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0093\u0001\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000c¢\u0006\u0002\u0008\u000e¢\u0006\u0002\u0008\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\u0008\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \u001a0\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001a2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010$\u001a\u00020\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001a\u0014\u0010'\u001a\u00020(2\n\u0010)\u001a\u0006\u0012\u0002\u0008\u00030*H\u0002\u001a\u0093\u0001\u0010+\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000c¢\u0006\u0002\u0008\u000e¢\u0006\u0002\u0008\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020,2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\u0008\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001a>\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00152\u000c\u00101\u001a\u0008\u0012\u0004\u0012\u00020\n0\u001e2\u000c\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\u00083\u00104\u001a \u00105\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002H\u0002\u001a;\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;2\u0014\u0008\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00150\u000c2\u000e\u0008\u0002\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00020>H\u0007¢\u0006\u0002\u0010?\u001a+\u0010@\u001a\u00020,2\u0006\u0010:\u001a\u00020A2\u0014\u0008\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u00150\u000cH\u0007¢\u0006\u0002\u0010B\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0008\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006C²\u0006\n\u0010D\u001a\u00020\u0002X\u008a\u0084\u0002", d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "DrawerVelocityThreshold", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawerKt {

    private static final TweenSpec<Float> AnimationSpec = null;
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float DrawerPositionalThreshold;
    private static final float DrawerVelocityThreshold;
    private static final float EndDrawerPadding;
    static {
        int i4 = 0;
        DrawerKt.EndDrawerPadding = Dp.constructor-impl((float)i);
        int i5 = 0;
        DrawerKt.DrawerPositionalThreshold = Dp.constructor-impl((float)i2);
        int i6 = 0;
        DrawerKt.DrawerVelocityThreshold = Dp.constructor-impl((float)i3);
        TweenSpec tweenSpec = new TweenSpec(256, 0, 0, 6, 0);
        DrawerKt.AnimationSpec = tweenSpec;
    }

    public static final void BottomDrawer-Gs3lGvM(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, androidx.compose.material.BottomDrawerState drawerState, boolean gesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long scrimColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int i4;
        int changed3;
        int i3;
        Object obj7;
        int $dirty6;
        int defaultsInvalid;
        androidx.compose.ui.Modifier.Companion modifier2;
        int $dirty5;
        Object endRestartGroup;
        int changed4;
        int $dirty;
        Object $dirty3;
        Object $dirty4;
        int i5;
        long l5;
        long l6;
        int $dirty2;
        boolean gesturesEnabled2;
        boolean traceInProgress;
        androidx.compose.ui.Modifier.Companion companion;
        Object drawerShape2;
        Object obj;
        boolean $composer2;
        int i9;
        int i;
        int changed;
        int i2;
        int i6;
        long l9;
        Object obj3;
        int changedInstance;
        int drawerElevation2;
        float f2;
        Object obj5;
        long l3;
        Object drawerBackgroundColor2;
        long l8;
        boolean drawerContentColor2;
        Object obj8;
        long l2;
        int scrimColor2;
        float compositionCoroutineScope;
        int changed2;
        Composer composer;
        int i8;
        boolean z;
        int gesturesEnabled3;
        Object obj2;
        Function2 function2;
        long l;
        int i7;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        Object obj6;
        long l7;
        long l4;
        float f;
        Object obj4;
        ScopeUpdateScope scopeUpdateScope;
        androidx.compose.ui.Modifier.Companion obj32;
        int obj33;
        int obj34;
        androidx.compose.runtime.internal.ComposableLambda obj35;
        Composer obj36;
        int obj37;
        int obj38;
        int obj39;
        int obj44;
        final int i50 = obj45;
        final int i51 = obj46;
        Composer restartGroup = obj44.startRestartGroup(625649286);
        ComposerKt.sourceInformation(restartGroup, "C(BottomDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)624@23676L33,626@23788L5,628@23897L15,629@23946L38,630@24025L10,633@24093L24,634@24165L4601,634@24122L4644:Drawer.kt#jmzs0o");
        $dirty = obj45;
        if (i51 & 1 != 0) {
            $dirty |= 6;
            obj5 = drawerContent;
        } else {
            if (i50 & 6 == 0) {
                i5 = restartGroup.changedInstance(drawerContent) ? 4 : 2;
                $dirty |= i5;
            } else {
                obj5 = drawerContent;
            }
        }
        int i21 = i51 & 2;
        if (i21 != 0) {
            $dirty |= 48;
            drawerShape2 = modifier;
        } else {
            if (i50 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i9;
            } else {
                drawerShape2 = modifier;
            }
        }
        if (i50 & 384 == 0) {
            if (i51 & 4 == 0) {
                i = restartGroup.changedInstance(drawerState) ? 256 : 128;
            } else {
                drawerBackgroundColor2 = drawerState;
            }
            $dirty |= i;
        } else {
            drawerBackgroundColor2 = drawerState;
        }
        int i43 = i51 & 8;
        if (i43 != 0) {
            $dirty |= 3072;
            drawerContentColor2 = gesturesEnabled;
        } else {
            if (i50 & 3072 == 0) {
                i = restartGroup.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty |= i;
            } else {
                drawerContentColor2 = gesturesEnabled;
            }
        }
        if (i50 & 24576 == 0) {
            if (i51 & 16 == 0) {
                i2 = restartGroup.changed(drawerShape) ? 16384 : 8192;
            } else {
                obj8 = drawerShape;
            }
            $dirty |= i2;
        } else {
            obj8 = drawerShape;
        }
        scrimColor2 = i51 & 32;
        i6 = 196608;
        if (scrimColor2 != 0) {
            $dirty |= i6;
            compositionCoroutineScope = drawerElevation;
        } else {
            if (i6 &= i50 == 0) {
                i6 = restartGroup.changed(drawerElevation) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                compositionCoroutineScope = drawerElevation;
            }
        }
        if (i31 &= i50 == 0) {
            if (i51 & 64 == 0) {
                changed2 = restartGroup.changed(drawerBackgroundColor) ? 1048576 : 524288;
            } else {
                l9 = drawerBackgroundColor;
            }
            $dirty |= changed2;
        } else {
            l9 = drawerBackgroundColor;
        }
        if (i50 & i52 == 0) {
            if (i51 & 128 == 0) {
                obj44 = i21;
                i4 = restartGroup.changed(scrimColor) ? 8388608 : 4194304;
            } else {
                obj44 = i21;
                l5 = scrimColor;
            }
            $dirty |= i4;
        } else {
            obj44 = i21;
            l5 = scrimColor;
        }
        if (i10 &= i50 == 0) {
            if (i51 & 256 == 0) {
                i3 = restartGroup.changed($composer) ? 67108864 : 33554432;
            } else {
                l6 = $composer;
            }
            $dirty |= i3;
        } else {
            l6 = $composer;
        }
        i8 = 805306368;
        if (i51 & 512 != 0) {
            $dirty |= i8;
            obj7 = i13;
        } else {
            if (i50 & i8 == 0) {
                i8 = restartGroup.changedInstance(i13) ? 536870912 : 268435456;
                $dirty |= i8;
            } else {
                obj7 = i13;
            }
        }
        if ($dirty & i54 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i55 = -234881025;
                int i56 = -29360129;
                int i57 = -3670017;
                int i58 = -57345;
                if (i50 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj44 != null) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i51 & 4 != 0) {
                            obj32 = modifier2;
                            $dirty3 = DrawerKt.rememberBottomDrawerState(BottomDrawerValue.Closed, 0, 0, restartGroup, 6, 6);
                            modifier3 &= -897;
                        } else {
                            obj32 = modifier2;
                            $dirty5 = $dirty;
                            $dirty3 = drawerBackgroundColor2;
                        }
                        gesturesEnabled2 = i43 != 0 ? 1 : drawerContentColor2;
                        l9 = 6;
                        if (i51 & 16 != 0) {
                            drawerShape2 = DrawerDefaults.INSTANCE.getShape(restartGroup, l9);
                            $dirty5 &= i58;
                        } else {
                            drawerShape2 = obj8;
                        }
                        if (scrimColor2 != 0) {
                            drawerElevation2 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                        } else {
                            drawerElevation2 = compositionCoroutineScope;
                        }
                        if (i51 & 64 != 0) {
                            drawerBackgroundColor2 = DrawerDefaults.INSTANCE.getBackgroundColor(restartGroup, l9);
                            $dirty5 &= i57;
                        } else {
                            drawerBackgroundColor2 = drawerBackgroundColor;
                        }
                        if (i51 & 128 != 0) {
                            drawerContentColor2 = ColorsKt.contentColorFor-ek8zF_U(drawerBackgroundColor2, i43, restartGroup);
                            $dirty5 &= i56;
                        } else {
                            drawerContentColor2 = scrimColor;
                        }
                        if (i51 & 256 != 0) {
                            obj2 = $dirty3;
                            z = gesturesEnabled2;
                            obj6 = drawerShape2;
                            f = drawerElevation2;
                            l7 = drawerBackgroundColor2;
                            l4 = drawerContentColor2;
                            l = scrimColor2;
                            $dirty = $dirty7;
                            $dirty6 = obj32;
                        } else {
                            l = $composer;
                            obj2 = $dirty3;
                            z = gesturesEnabled2;
                            obj6 = drawerShape2;
                            f = drawerElevation2;
                            l7 = drawerBackgroundColor2;
                            l4 = drawerContentColor2;
                            $dirty = $dirty5;
                            $dirty6 = obj32;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i51 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i51 & 16 != 0) {
                            $dirty &= i58;
                        }
                        if (i51 & 64 != 0) {
                            $dirty &= i57;
                        }
                        if (i51 & 128 != 0) {
                            $dirty &= i56;
                        }
                        if (i51 & 256 != 0) {
                            l4 = scrimColor;
                            l = $composer;
                            $dirty = i19;
                            l7 = l9;
                            obj2 = drawerBackgroundColor2;
                            z = drawerContentColor2;
                            obj6 = obj8;
                            f = compositionCoroutineScope;
                            $dirty6 = modifier;
                        } else {
                            $dirty6 = modifier;
                            l4 = scrimColor;
                            l = $composer;
                            l7 = l9;
                            obj2 = drawerBackgroundColor2;
                            z = drawerContentColor2;
                            obj6 = obj8;
                            f = compositionCoroutineScope;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, $dirty, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:632)");
                }
                int i23 = 0;
                int i28 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i38 = 0;
                drawerBackgroundColor2 = restartGroup;
                int i44 = 0;
                drawerContentColor2 = drawerBackgroundColor2.rememberedValue();
                int i48 = 0;
                if (drawerContentColor2 == Composer.Companion.getEmpty()) {
                    scrimColor2 = 0;
                    int i49 = 0;
                    obj39 = $dirty;
                    $dirty4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    drawerBackgroundColor2.updateRememberedValue($dirty4);
                } else {
                    obj39 = $dirty;
                    $dirty4 = drawerContentColor2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i29 = 1;
                DrawerKt.BottomDrawer.1 anon2 = new DrawerKt.BottomDrawer.1(z, obj2, i13, l, i7, (CompositionScopedCoroutineScopeCanceller)$dirty4.getCoroutineScope(), obj6, l7, obj25, l4, obj27, f, obj5);
                obj36 = restartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default($dirty6, 0, i29, 0), 0, false, (Function3)ComposableLambdaKt.rememberComposableLambda(1220102512, i29, anon2, restartGroup, 54), obj36, 3072, 6);
                composer = obj36;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                companion = $dirty6;
                $composer2 = z;
                obj = obj2;
                l2 = l;
                obj3 = obj6;
                l3 = l7;
                l8 = l4;
                f2 = f;
                gesturesEnabled3 = obj39;
            } else {
                restartGroup.skipToGroupEnd();
                companion = modifier;
                gesturesEnabled3 = $dirty;
                composer = restartGroup;
                obj = drawerBackgroundColor2;
                $composer2 = drawerContentColor2;
                l8 = scrimColor;
                l3 = l9;
                obj3 = obj8;
                f2 = compositionCoroutineScope;
                l2 = $composer;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new DrawerKt.BottomDrawer.2(drawerContent, companion, obj, $composer2, obj3, f2, l3, drawerBackgroundColor2, l8, drawerContentColor2, l2, scrimColor2, i13, i50, i51);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void BottomDrawerScrim-3J-VO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        int traceInProgress;
        int $i$f$isSpecified8_81llA;
        Modifier semantics;
        boolean anon2;
        int $dirty;
        int i10;
        int i12;
        int i7;
        boolean string-4foXLRw;
        boolean traceInProgress2;
        int i;
        int str;
        int empty;
        Composer cmp;
        int i6;
        int i3;
        int i15;
        Object rememberedValue;
        int i9;
        int i5;
        Composer i8;
        int i11;
        int i2;
        int empty3;
        int empty2;
        int anon3;
        Object anon;
        int $dirty2;
        int companion;
        int i13;
        int i4;
        int companion2;
        int i14;
        final long l = color;
        final Object obj = visible;
        anon2 = $composer;
        final int i19 = obj27;
        traceInProgress = -513067266;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color):Drawer.kt#jmzs0o");
        if (i19 & 6 == 0) {
            i10 = restartGroup.changed(l) ? 4 : 2;
            $dirty |= i10;
        }
        anon3 = 32;
        if (i19 & 48 == 0) {
            i12 = restartGroup.changedInstance(obj) ? anon3 : 16;
            $dirty |= i12;
        }
        if (i19 & 384 == 0) {
            i7 = restartGroup.changed(anon2) ? 256 : 128;
            $dirty |= i7;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:792)");
                }
                int i16 = 0;
                i6 = 0;
                rememberedValue = 1;
                $i$f$isSpecified8_81llA = Long.compare(string-4foXLRw, i25) != 0 ? rememberedValue : i6;
                if ($i$f$isSpecified8_81llA != 0) {
                    restartGroup.startReplaceGroup(1552727430);
                    ComposerKt.sourceInformation(restartGroup, "794@30102L121,798@30250L30,816@30803L62,812@30694L171");
                    i = anon2 ? 1065353216 : 0;
                    TweenSpec tweenSpec3 = new TweenSpec(0, 0, 0, 7, 0);
                    i13 = i34;
                    $dirty2 = $dirty;
                    $dirty = AnimateAsStateKt.animateFloatAsState(i, (AnimationSpec)tweenSpec3, 0, 0, 0, restartGroup, 48, 28);
                    string-4foXLRw = Strings_androidKt.getString-4foXLRw(Strings.Companion.getCloseDrawer-UdPEhr4(), restartGroup, 6);
                    String str4 = "CC(remember):Drawer.kt#9igjgp";
                    if (anon2) {
                        restartGroup.startReplaceGroup(1552955900);
                        ComposerKt.sourceInformation(restartGroup, "801@30388L73,804@30514L122");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1612470835, str4);
                        i9 = $dirty2 & 112 == anon3 ? empty2 : 0;
                        Composer composer = restartGroup;
                        companion = 0;
                        Object rememberedValue2 = composer.rememberedValue();
                        i4 = 0;
                        if (i9 == 0) {
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                anon = new DrawerKt.BottomDrawerScrim.dismissModifier.1.1(obj, 0);
                                composer.updateRememberedValue((Function2)anon);
                            } else {
                                anon = rememberedValue2;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1612466754, str4);
                        i5 = $dirty2 & 112 == 32 ? 1 : 0;
                        i8 = restartGroup;
                        i2 = 0;
                        Object rememberedValue3 = i8.rememberedValue();
                        anon3 = 0;
                        if (changed4 |= i5 == 0) {
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                empty = 0;
                                anon2 = new DrawerKt.BottomDrawerScrim.dismissModifier.2.1(string-4foXLRw, obj);
                                i8.updateRememberedValue((Function1)anon2);
                            } else {
                                anon2 = rememberedValue3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        semantics = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon), true, (Function1)anon2);
                        restartGroup.endReplaceGroup();
                    } else {
                        restartGroup.startReplaceGroup(1553272286);
                        restartGroup.endReplaceGroup();
                        semantics = Modifier.Companion;
                    }
                    empty3 = 1;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1612457566, str4);
                    i15 = $dirty2 & 14 == 4 ? empty3 : 0;
                    cmp = restartGroup;
                    i6 = 0;
                    rememberedValue = cmp.rememberedValue();
                    int i36 = 0;
                    if (changed3 |= i15 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty3 = 0;
                            anon3 = new DrawerKt.BottomDrawerScrim.1.1(l, obj2, $dirty);
                            cmp.updateRememberedValue((Function1)anon3);
                        } else {
                            anon3 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, empty3, 0).then(semantics), (Function1)anon3, restartGroup, 0);
                    restartGroup.endReplaceGroup();
                } else {
                    $dirty2 = $dirty;
                    restartGroup.startReplaceGroup(1553488542);
                    restartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                $dirty2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DrawerKt.BottomDrawerScrim.2(l, obj2, obj, $composer, i19);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final float BottomDrawerScrim_3J_VO9M$lambda$2(State<Float> $alpha$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$alpha$delegate.getValue().floatValue();
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(androidx.compose.material.AnchoredDraggableState<?> state) {
        DrawerKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1 anon = new DrawerKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1(state);
        return (NestedScrollConnection)anon;
    }

    public static final void ModalDrawer-Gs3lGvM(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, androidx.compose.material.DrawerState drawerState, boolean gesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long scrimColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int $dirty3;
        int $dirty7;
        Object obj8;
        int $dirty4;
        Object endRestartGroup;
        int i5;
        int $dirty;
        boolean traceInProgress;
        int $dirty6;
        long $dirty5;
        long l3;
        int skipping;
        int defaultsInvalid;
        Object modifier4;
        Object modifier3;
        boolean traceInProgress2;
        Object companion;
        Object obj;
        Object compositionScopedCoroutineScopeCanceller;
        Object obj6;
        long backgroundColor;
        boolean z;
        int i;
        int i2;
        Object obj2;
        Object gesturesEnabled2;
        int closed;
        boolean gesturesEnabled3;
        float modifier2;
        int i8;
        Object drawerShape2;
        long l2;
        int changed3;
        float drawerElevation2;
        boolean drawerContentColor2;
        int iNSTANCE;
        long l5;
        int i7;
        Object rememberedValue;
        boolean changed;
        int scrimColor2;
        long l6;
        float empty;
        int i6;
        int compositionCoroutineScope;
        int changed2;
        Composer composer;
        int changed4;
        int i4;
        int $dirty2;
        Object obj4;
        int drawerState2;
        int i3;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        long l7;
        Object obj3;
        long l;
        long l4;
        float f;
        Object obj7;
        Object obj5;
        ScopeUpdateScope scopeUpdateScope;
        androidx.compose.ui.Modifier.Companion obj32;
        int obj33;
        int obj34;
        androidx.compose.runtime.internal.ComposableLambda obj35;
        Composer obj36;
        int obj37;
        int obj38;
        final int i51 = obj45;
        final int i52 = obj46;
        traceInProgress = obj44.startRestartGroup(1305806945);
        ComposerKt.sourceInformation(traceInProgress, "C(ModalDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)491@17842L39,493@17960L5,495@18069L15,496@18118L38,497@18197L10,500@18265L24,501@18337L3449,501@18294L3492:Drawer.kt#jmzs0o");
        $dirty6 = obj45;
        if (i52 & 1 != 0) {
            $dirty6 |= 6;
            obj = drawerContent;
        } else {
            if (i51 & 6 == 0) {
                i = traceInProgress.changedInstance(drawerContent) ? 4 : 2;
                $dirty6 |= i;
            } else {
                obj = drawerContent;
            }
        }
        i2 = i52 & 2;
        if (i2 != 0) {
            $dirty6 |= 48;
            gesturesEnabled2 = modifier;
        } else {
            if (i51 & 48 == 0) {
                i8 = traceInProgress.changed(modifier) ? 32 : 16;
                $dirty6 |= i8;
            } else {
                gesturesEnabled2 = modifier;
            }
        }
        if (i51 & 384 == 0) {
            if (i52 & 4 == 0) {
                changed3 = traceInProgress.changed(drawerState) ? 256 : 128;
            } else {
                drawerShape2 = drawerState;
            }
            $dirty6 |= changed3;
        } else {
            drawerShape2 = drawerState;
        }
        drawerElevation2 = i52 & 8;
        if (drawerElevation2 != 0) {
            $dirty6 |= 3072;
            drawerContentColor2 = gesturesEnabled;
        } else {
            if (i51 & 3072 == 0) {
                i7 = traceInProgress.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty6 |= i7;
            } else {
                drawerContentColor2 = gesturesEnabled;
            }
        }
        if (i51 & 24576 == 0) {
            if (i52 & 16 == 0) {
                changed = traceInProgress.changed(drawerShape) ? 16384 : 8192;
            } else {
                rememberedValue = drawerShape;
            }
            $dirty6 |= changed;
        } else {
            rememberedValue = drawerShape;
        }
        scrimColor2 = i52 & 32;
        int i45 = 196608;
        if (scrimColor2 != 0) {
            $dirty6 |= i45;
            empty = drawerElevation;
        } else {
            if (i45 &= i51 == 0) {
                i6 = traceInProgress.changed(drawerElevation) ? 131072 : 65536;
                $dirty6 |= i6;
            } else {
                empty = drawerElevation;
            }
        }
        if (i47 &= i51 == 0) {
            if (i52 & 64 == 0) {
                compositionCoroutineScope = i2;
                changed2 = traceInProgress.changed(drawerBackgroundColor) ? 1048576 : 524288;
            } else {
                compositionCoroutineScope = i2;
                backgroundColor = drawerBackgroundColor;
            }
            $dirty6 |= changed2;
        } else {
            compositionCoroutineScope = i2;
            backgroundColor = drawerBackgroundColor;
        }
        if (i51 & i53 == 0) {
            if (i52 & 128 == 0) {
                $dirty3 = $dirty6;
                changed4 = traceInProgress.changed(scrimColor) ? 8388608 : 4194304;
            } else {
                $dirty3 = $dirty6;
                $dirty5 = scrimColor;
            }
            $dirty3 |= changed4;
        } else {
            $dirty7 = $dirty6;
            $dirty5 = scrimColor;
        }
        if (i51 & i55 == 0) {
            if (i52 & 256 == 0) {
                i5 = traceInProgress.changed($composer) ? 67108864 : 33554432;
            } else {
                l3 = $composer;
            }
            $dirty7 = i4 | i5;
        } else {
            l3 = $composer;
            i4 = $dirty7;
        }
        $dirty2 = $dirty7;
        i3 = 805306368;
        if (i52 & 512 != 0) {
            $dirty4 = $dirty2 | i3;
        } else {
            if (i51 & i3 == 0) {
                i3 = traceInProgress.changedInstance(i13) ? 536870912 : 268435456;
                $dirty2 |= i3;
            } else {
                obj8 = i13;
            }
            $dirty4 = $dirty2;
        }
        if ($dirty4 & $dirty10 == 306783378) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                int i57 = -29360129;
                int i58 = -3670017;
                int i59 = -57345;
                int i60 = -234881025;
                if (i51 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (compositionCoroutineScope != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = gesturesEnabled2;
                        }
                        compositionCoroutineScope = 6;
                        if (i52 & 4 != 0) {
                            obj32 = modifier4;
                            modifier3 = DrawerKt.rememberDrawerState(DrawerValue.Closed, 0, traceInProgress, compositionCoroutineScope, 2);
                            $dirty4 &= -897;
                        } else {
                            obj32 = modifier4;
                            modifier3 = drawerShape2;
                        }
                        gesturesEnabled3 = drawerElevation2 != 0 ? 1 : drawerContentColor2;
                        if (i52 & 16 != 0) {
                            drawerShape2 = DrawerDefaults.INSTANCE.getShape(traceInProgress, compositionCoroutineScope);
                            $dirty4 &= i59;
                        } else {
                            drawerShape2 = rememberedValue;
                        }
                        if (scrimColor2 != 0) {
                            drawerElevation2 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                        } else {
                            drawerElevation2 = empty;
                        }
                        if (i52 & 64 != 0) {
                            backgroundColor = DrawerDefaults.INSTANCE.getBackgroundColor(traceInProgress, compositionCoroutineScope);
                            $dirty4 &= i58;
                        }
                        if (i52 & 128 != 0) {
                            drawerContentColor2 = ColorsKt.contentColorFor-ek8zF_U(backgroundColor, i2, traceInProgress);
                            $dirty4 &= i57;
                        } else {
                            drawerContentColor2 = scrimColor;
                        }
                        if (i52 & 256 != 0) {
                            $dirty4 &= i60;
                            obj4 = modifier3;
                            l = backgroundColor;
                            i3 = gesturesEnabled3;
                            obj3 = drawerShape2;
                            f = drawerElevation2;
                            l4 = drawerContentColor2;
                            l7 = scrimColor2;
                            gesturesEnabled2 = obj32;
                        } else {
                            l7 = $composer;
                            obj4 = modifier3;
                            l = backgroundColor;
                            i3 = gesturesEnabled3;
                            obj3 = drawerShape2;
                            f = drawerElevation2;
                            l4 = drawerContentColor2;
                            gesturesEnabled2 = obj32;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i52 & 4 != 0) {
                            $dirty4 &= -897;
                        }
                        if (i52 & 16 != 0) {
                            $dirty4 &= i59;
                        }
                        if (i52 & 64 != 0) {
                            $dirty4 &= i58;
                        }
                        if (i52 & 128 != 0) {
                            $dirty4 &= i57;
                        }
                        if (i52 & 256 != 0) {
                            $dirty4 &= i60;
                        }
                        l4 = scrimColor;
                        l7 = $composer;
                        l = backgroundColor;
                        obj4 = drawerShape2;
                        i3 = drawerContentColor2;
                        obj3 = rememberedValue;
                        f = empty;
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, $dirty4, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:499)");
                }
                int i16 = 0;
                int i23 = 0;
                ComposerKt.sourceInformationMarkerStart(traceInProgress, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(traceInProgress, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i33 = 0;
                Composer composer3 = traceInProgress;
                int i40 = 0;
                rememberedValue = composer3.rememberedValue();
                int i44 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    int i50 = 0;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, traceInProgress));
                    composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(traceInProgress);
                ComposerKt.sourceInformationMarkerEnd(traceInProgress);
                int i21 = 1;
                DrawerKt.ModalDrawer.1 anon2 = new DrawerKt.ModalDrawer.1(obj4, i3, (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope(), l7, obj21, obj3, l, obj24, l4, obj26, f, i13, drawerContent);
                obj36 = traceInProgress;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(gesturesEnabled2, 0, i21, 0), 0, false, (Function3)ComposableLambdaKt.rememberComposableLambda(816674999, i21, anon2, traceInProgress, 54), obj36, 3072, 6);
                composer = obj36;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                companion = gesturesEnabled2;
                obj6 = obj4;
                z = i3;
                l6 = l7;
                obj2 = obj3;
                l2 = l;
                l5 = l4;
                modifier2 = f;
                drawerState2 = $dirty4;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                companion = gesturesEnabled2;
                obj6 = drawerShape2;
                modifier2 = empty;
                l6 = $composer;
                l2 = backgroundColor;
                z = drawerContentColor2;
                obj2 = rememberedValue;
                l5 = scrimColor;
                drawerState2 = $dirty4;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new DrawerKt.ModalDrawer.2(drawerContent, companion, obj6, z, obj2, modifier2, l2, drawerElevation2, l5, rememberedValue, l6, empty, i13, i51, i52);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void Scrim-Bx497Mc(boolean open, Function0<Unit> onClose, Function0<Float> fraction, long color, Composer $composer, int $changed) {
        Object closeDrawer;
        boolean traceInProgress2;
        Object anon2;
        Modifier companion;
        int $dirty;
        int i4;
        int i5;
        int i10;
        int i6;
        int skipping;
        boolean traceInProgress;
        int empty;
        Object anon;
        int pointerInput;
        int i2;
        int i11;
        int i;
        int i7;
        Composer composer2;
        int rememberedValue;
        int i9;
        Composer composer;
        Object rememberedValue2;
        String str;
        int i3;
        int companion3;
        int i8;
        Composer.Companion companion2;
        companion = open;
        final Object obj = onClose;
        final Object obj2 = fraction;
        final long l = color;
        final int i13 = obj27;
        traceInProgress2 = 1983403750;
        Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)829@31020L30,845@31464L51,841@31373L142:Drawer.kt#jmzs0o");
        if (i13 & 6 == 0) {
            i4 = restartGroup.changed(companion) ? 4 : 2;
            $dirty |= i4;
        }
        pointerInput = 32;
        if (i13 & 48 == 0) {
            i5 = restartGroup.changedInstance(obj) ? pointerInput : 16;
            $dirty |= i5;
        }
        if (i13 & 384 == 0) {
            i10 = restartGroup.changedInstance(obj2) ? 256 : 128;
            $dirty |= i10;
        }
        if (i13 & 3072 == 0) {
            i6 = restartGroup.changed(l) ? 2048 : 1024;
            $dirty |= i6;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.Scrim (Drawer.kt:828)");
                }
                String string-4foXLRw = Strings_androidKt.getString-4foXLRw(Strings.Companion.getCloseDrawer-UdPEhr4(), restartGroup, 6);
                String str3 = "CC(remember):Drawer.kt#9igjgp";
                if (companion) {
                    restartGroup.startReplaceGroup(487703622);
                    ComposerKt.sourceInformation(restartGroup, "832@31139L35,833@31223L108");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1262659875, str3);
                    i11 = $dirty & 112 == pointerInput ? 1 : 0;
                    Composer composer3 = restartGroup;
                    companion3 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    i8 = 0;
                    if (i11 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int i30 = 0;
                            anon = new DrawerKt.Scrim.dismissDrawer.1.1(obj, 0);
                            composer3.updateRememberedValue((Function2)anon);
                        } else {
                            anon = rememberedValue3;
                            composer = composer3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1262662636, str3);
                    i7 = $dirty & 112 == 32 ? 1 : 0;
                    composer2 = restartGroup;
                    i9 = 0;
                    rememberedValue2 = composer2.rememberedValue();
                    i3 = 0;
                    if (changed3 |= i7 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon2 = new DrawerKt.Scrim.dismissDrawer.2.1(string-4foXLRw, obj);
                            composer2.updateRememberedValue((Function1)anon2);
                        } else {
                            anon2 = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    companion = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon), true, (Function1)anon2);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(487952490);
                    restartGroup.endReplaceGroup();
                    companion = Modifier.Companion;
                }
                int i22 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1262670291, str3);
                i2 = $dirty & 7168 == 2048 ? i22 : 0;
                rememberedValue2 = $dirty & 896 == 256 ? i22 : 0;
                i = restartGroup;
                composer2 = 0;
                rememberedValue = i.rememberedValue();
                i9 = 0;
                if (i2 |= rememberedValue2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue2 = 0;
                        str = string-4foXLRw;
                        closeDrawer = new DrawerKt.Scrim.1.1(l, obj5, obj2);
                        i.updateRememberedValue((Function1)closeDrawer);
                    } else {
                        str = string-4foXLRw;
                        closeDrawer = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, i22, 0).then(companion), (Function1)closeDrawer, restartGroup, 0);
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
            traceInProgress2 = new DrawerKt.Scrim.2(open, obj, obj2, l, obj5, i13);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$BottomDrawerScrim-3J-VO9M(long color, Function0 onDismiss, boolean visible, Composer $composer, int $changed) {
        DrawerKt.BottomDrawerScrim-3J-VO9M(color, onDismiss, visible, $composer, $changed);
    }

    public static final float access$BottomDrawerScrim_3J_VO9M$lambda$2(State $alpha$delegate) {
        return DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$2($alpha$delegate);
    }

    public static final NestedScrollConnection access$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(androidx.compose.material.AnchoredDraggableState state) {
        return DrawerKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(state);
    }

    public static final void access$Scrim-Bx497Mc(boolean open, Function0 onClose, Function0 fraction, long color, Composer $composer, int $changed) {
        DrawerKt.Scrim-Bx497Mc(open, onClose, fraction, color, $composer, $changed);
    }

    public static final float access$calculateFraction(float a, float b, float pos) {
        return DrawerKt.calculateFraction(a, b, pos);
    }

    public static final TweenSpec access$getAnimationSpec$p() {
        return DrawerKt.AnimationSpec;
    }

    public static final float access$getDrawerPositionalThreshold$p() {
        return DrawerKt.DrawerPositionalThreshold;
    }

    public static final float access$getDrawerVelocityThreshold$p() {
        return DrawerKt.DrawerVelocityThreshold;
    }

    public static final float access$getEndDrawerPadding$p() {
        return DrawerKt.EndDrawerPadding;
    }

    private static final float calculateFraction(float a, float b, float pos) {
        int $this$fastCoerceAtLeast$iv$iv;
        int i4 = 0;
        final int i5 = 1065353216;
        final int i6 = 0;
        int i7 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i4) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i4;
        }
        int i8 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i5) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i5;
        }
        return $this$fastCoerceAtLeast$iv$iv;
    }

    public static final androidx.compose.material.BottomDrawerState rememberBottomDrawerState(androidx.compose.material.BottomDrawerValue initialValue, Function1<? super androidx.compose.material.BottomDrawerValue, Boolean> confirmStateChange, AnimationSpec<Float> animationSpec, Composer $composer, int $changed, int i6) {
        int i;
        boolean changed;
        int iNSTANCE;
        boolean changed2;
        String str;
        int i2;
        Object empty;
        Object anon;
        androidx.compose.material.DrawerKt.rememberBottomDrawerState.1 obj10;
        TweenSpec obj11;
        int obj14;
        int i3 = 1477366969;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberBottomDrawerState)P(2,1)448@15797L7,452@15941L91,449@15816L216:Drawer.kt#jmzs0o");
        if (i6 & 2 != 0) {
            obj10 = iNSTANCE;
        }
        int i11 = 4;
        if (i6 &= i11 != 0) {
            obj11 = obj14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:447)");
        }
        int i4 = 0;
        int i13 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        obj14 = consume;
        ComposerKt.sourceInformationMarkerStart($composer, -1985306787, "CC(remember):Drawer.kt#9igjgp");
        int i17 = 1;
        if (i7 ^= 6 > i11) {
            if (!$composer.changed(initialValue)) {
                i = $changed & 6 == i11 ? i17 : i2;
            } else {
            }
        } else {
        }
        int i18 = 32;
        if (i12 ^= 48 > i18) {
            if (!$composer.changed(obj10)) {
                if ($changed & 48 == i18) {
                    i2 = i17;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i15 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i19 = 0;
        if (i9 |= changedInstance == null) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new DrawerKt.rememberBottomDrawerState.2.1(initialValue, obj14, obj10, obj11);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (BottomDrawerState)RememberSaveableKt.rememberSaveable(/* result */, BottomDrawerState.Companion.Saver((Density)obj14, obj10, obj11), 0, (Function0)anon, composer2, 0, 4);
    }

    public static final androidx.compose.material.DrawerState rememberDrawerState(androidx.compose.material.DrawerValue initialValue, Function1<? super androidx.compose.material.DrawerValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i5) {
        String str;
        int changed;
        int i;
        int changed2;
        Object empty;
        Object anon;
        androidx.compose.material.DrawerKt.rememberDrawerState.1 obj9;
        int obj12;
        int i2 = -1435874229;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberDrawerState)P(1)429@15122L61,429@15058L125:Drawer.kt#jmzs0o");
        if (i5 &= 2 != 0) {
            obj9 = obj12;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:428)");
        }
        obj12 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -524629238, "CC(remember):Drawer.kt#9igjgp");
        int i7 = 1;
        int i9 = 4;
        if (i4 ^= 6 > i9) {
            if (!$composer.changed(initialValue)) {
                i = $changed & 6 == i9 ? i7 : obj12;
            } else {
            }
        } else {
        }
        int i11 = 32;
        if (i10 ^= 48 > i11) {
            if (!$composer.changed(obj9)) {
                if ($changed & 48 == i11) {
                    obj12 = i7;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (obj12 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new DrawerKt.rememberDrawerState.2.1(initialValue, obj9);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (DrawerState)RememberSaveableKt.rememberSaveable(new Object[obj12], DrawerState.Companion.Saver(obj9), 0, (Function0)anon, composer2, 0, 4);
    }
}
