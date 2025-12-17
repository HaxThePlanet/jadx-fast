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
        int i;
        int changed3;
        int i8;
        Object obj5;
        int $dirty4;
        int defaultsInvalid;
        androidx.compose.ui.Modifier.Companion modifier2;
        int $dirty3;
        Object endRestartGroup;
        int changed4;
        int $dirty2;
        Object $dirty5;
        Object $dirty;
        int i9;
        long l2;
        long l3;
        int $dirty6;
        boolean gesturesEnabled3;
        boolean traceInProgress;
        androidx.compose.ui.Modifier.Companion companion;
        Object drawerShape2;
        Object obj6;
        boolean $composer2;
        int i4;
        int i6;
        int changed2;
        int i7;
        int i3;
        long l;
        Object obj3;
        int changedInstance;
        int drawerElevation2;
        float f;
        Object obj;
        long l6;
        Object drawerBackgroundColor2;
        long l4;
        boolean drawerContentColor2;
        Object obj2;
        long l9;
        int scrimColor2;
        float compositionCoroutineScope;
        int changed;
        Composer composer;
        int i5;
        boolean z;
        int gesturesEnabled2;
        Object obj8;
        Function2 function2;
        long l5;
        int i2;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        Object obj4;
        long l8;
        long l7;
        float f2;
        Object obj7;
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
        $dirty2 = obj45;
        if (i51 & 1 != 0) {
            $dirty2 |= 6;
            obj = drawerContent;
        } else {
            if (i50 & 6 == 0) {
                i9 = restartGroup.changedInstance(drawerContent) ? 4 : 2;
                $dirty2 |= i9;
            } else {
                obj = drawerContent;
            }
        }
        int i21 = i51 & 2;
        if (i21 != 0) {
            $dirty2 |= 48;
            drawerShape2 = modifier;
        } else {
            if (i50 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                drawerShape2 = modifier;
            }
        }
        if (i50 & 384 == 0) {
            if (i51 & 4 == 0) {
                i6 = restartGroup.changedInstance(drawerState) ? 256 : 128;
            } else {
                drawerBackgroundColor2 = drawerState;
            }
            $dirty2 |= i6;
        } else {
            drawerBackgroundColor2 = drawerState;
        }
        int i43 = i51 & 8;
        if (i43 != 0) {
            $dirty2 |= 3072;
            drawerContentColor2 = gesturesEnabled;
        } else {
            if (i50 & 3072 == 0) {
                i6 = restartGroup.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                drawerContentColor2 = gesturesEnabled;
            }
        }
        if (i50 & 24576 == 0) {
            if (i51 & 16 == 0) {
                i7 = restartGroup.changed(drawerShape) ? 16384 : 8192;
            } else {
                obj2 = drawerShape;
            }
            $dirty2 |= i7;
        } else {
            obj2 = drawerShape;
        }
        scrimColor2 = i51 & 32;
        i3 = 196608;
        if (scrimColor2 != 0) {
            $dirty2 |= i3;
            compositionCoroutineScope = drawerElevation;
        } else {
            if (i3 &= i50 == 0) {
                i3 = restartGroup.changed(drawerElevation) ? 131072 : 65536;
                $dirty2 |= i3;
            } else {
                compositionCoroutineScope = drawerElevation;
            }
        }
        if (i31 &= i50 == 0) {
            if (i51 & 64 == 0) {
                changed = restartGroup.changed(drawerBackgroundColor) ? 1048576 : 524288;
            } else {
                l = drawerBackgroundColor;
            }
            $dirty2 |= changed;
        } else {
            l = drawerBackgroundColor;
        }
        if (i50 & i52 == 0) {
            if (i51 & 128 == 0) {
                obj44 = i21;
                i = restartGroup.changed(scrimColor) ? 8388608 : 4194304;
            } else {
                obj44 = i21;
                l2 = scrimColor;
            }
            $dirty2 |= i;
        } else {
            obj44 = i21;
            l2 = scrimColor;
        }
        if (i10 &= i50 == 0) {
            if (i51 & 256 == 0) {
                i8 = restartGroup.changed($composer) ? 67108864 : 33554432;
            } else {
                l3 = $composer;
            }
            $dirty2 |= i8;
        } else {
            l3 = $composer;
        }
        i5 = 805306368;
        if (i51 & 512 != 0) {
            $dirty2 |= i5;
            obj5 = i13;
        } else {
            if (i50 & i5 == 0) {
                i5 = restartGroup.changedInstance(i13) ? 536870912 : 268435456;
                $dirty2 |= i5;
            } else {
                obj5 = i13;
            }
        }
        if ($dirty2 & i54 == 306783378) {
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
                            $dirty5 = DrawerKt.rememberBottomDrawerState(BottomDrawerValue.Closed, 0, 0, restartGroup, 6, 6);
                            modifier3 &= -897;
                        } else {
                            obj32 = modifier2;
                            $dirty3 = $dirty2;
                            $dirty5 = drawerBackgroundColor2;
                        }
                        gesturesEnabled3 = i43 != 0 ? 1 : drawerContentColor2;
                        l = 6;
                        if (i51 & 16 != 0) {
                            drawerShape2 = DrawerDefaults.INSTANCE.getShape(restartGroup, l);
                            $dirty3 &= i58;
                        } else {
                            drawerShape2 = obj2;
                        }
                        if (scrimColor2 != 0) {
                            drawerElevation2 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                        } else {
                            drawerElevation2 = compositionCoroutineScope;
                        }
                        if (i51 & 64 != 0) {
                            drawerBackgroundColor2 = DrawerDefaults.INSTANCE.getBackgroundColor(restartGroup, l);
                            $dirty3 &= i57;
                        } else {
                            drawerBackgroundColor2 = drawerBackgroundColor;
                        }
                        if (i51 & 128 != 0) {
                            drawerContentColor2 = ColorsKt.contentColorFor-ek8zF_U(drawerBackgroundColor2, i43, restartGroup);
                            $dirty3 &= i56;
                        } else {
                            drawerContentColor2 = scrimColor;
                        }
                        if (i51 & 256 != 0) {
                            obj8 = $dirty5;
                            z = gesturesEnabled3;
                            obj4 = drawerShape2;
                            f2 = drawerElevation2;
                            l8 = drawerBackgroundColor2;
                            l7 = drawerContentColor2;
                            l5 = scrimColor2;
                            $dirty2 = $dirty7;
                            $dirty4 = obj32;
                        } else {
                            l5 = $composer;
                            obj8 = $dirty5;
                            z = gesturesEnabled3;
                            obj4 = drawerShape2;
                            f2 = drawerElevation2;
                            l8 = drawerBackgroundColor2;
                            l7 = drawerContentColor2;
                            $dirty2 = $dirty3;
                            $dirty4 = obj32;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i51 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i51 & 16 != 0) {
                            $dirty2 &= i58;
                        }
                        if (i51 & 64 != 0) {
                            $dirty2 &= i57;
                        }
                        if (i51 & 128 != 0) {
                            $dirty2 &= i56;
                        }
                        if (i51 & 256 != 0) {
                            l7 = scrimColor;
                            l5 = $composer;
                            $dirty2 = i19;
                            l8 = l;
                            obj8 = drawerBackgroundColor2;
                            z = drawerContentColor2;
                            obj4 = obj2;
                            f2 = compositionCoroutineScope;
                            $dirty4 = modifier;
                        } else {
                            $dirty4 = modifier;
                            l7 = scrimColor;
                            l5 = $composer;
                            l8 = l;
                            obj8 = drawerBackgroundColor2;
                            z = drawerContentColor2;
                            obj4 = obj2;
                            f2 = compositionCoroutineScope;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, $dirty2, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:632)");
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
                    obj39 = $dirty2;
                    $dirty = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    drawerBackgroundColor2.updateRememberedValue($dirty);
                } else {
                    obj39 = $dirty2;
                    $dirty = drawerContentColor2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i29 = 1;
                DrawerKt.BottomDrawer.1 anon2 = new DrawerKt.BottomDrawer.1(z, obj8, i13, l5, i2, (CompositionScopedCoroutineScopeCanceller)$dirty.getCoroutineScope(), obj4, l8, obj25, l7, obj27, f2, obj);
                obj36 = restartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default($dirty4, 0, i29, 0), 0, false, (Function3)ComposableLambdaKt.rememberComposableLambda(1220102512, i29, anon2, restartGroup, 54), obj36, 3072, 6);
                composer = obj36;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                companion = $dirty4;
                $composer2 = z;
                obj6 = obj8;
                l9 = l5;
                obj3 = obj4;
                l6 = l8;
                l4 = l7;
                f = f2;
                gesturesEnabled2 = obj39;
            } else {
                restartGroup.skipToGroupEnd();
                companion = modifier;
                gesturesEnabled2 = $dirty2;
                composer = restartGroup;
                obj6 = drawerBackgroundColor2;
                $composer2 = drawerContentColor2;
                l4 = scrimColor;
                l6 = l;
                obj3 = obj2;
                f = compositionCoroutineScope;
                l9 = $composer;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new DrawerKt.BottomDrawer.2(drawerContent, companion, obj6, $composer2, obj3, f, l6, drawerBackgroundColor2, l4, drawerContentColor2, l9, scrimColor2, i13, i50, i51);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void BottomDrawerScrim-3J-VO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        int traceInProgress2;
        int $i$f$isSpecified8_81llA;
        Modifier semantics;
        boolean anon;
        int $dirty;
        int i14;
        int i8;
        int i;
        boolean string-4foXLRw;
        boolean traceInProgress;
        int i10;
        int str;
        int empty3;
        Composer cmp;
        int i5;
        int i6;
        int i3;
        Object rememberedValue;
        int i13;
        int i4;
        Composer i12;
        int i2;
        int i15;
        int empty;
        int empty2;
        int anon2;
        Object anon3;
        int $dirty2;
        int companion;
        int i7;
        int i9;
        int companion2;
        int i11;
        final long l = color;
        final Object obj = visible;
        anon = $composer;
        final int i19 = obj27;
        traceInProgress2 = -513067266;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color):Drawer.kt#jmzs0o");
        if (i19 & 6 == 0) {
            i14 = restartGroup.changed(l) ? 4 : 2;
            $dirty |= i14;
        }
        anon2 = 32;
        if (i19 & 48 == 0) {
            i8 = restartGroup.changedInstance(obj) ? anon2 : 16;
            $dirty |= i8;
        }
        if (i19 & 384 == 0) {
            i = restartGroup.changed(anon) ? 256 : 128;
            $dirty |= i;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:792)");
                }
                int i16 = 0;
                i5 = 0;
                rememberedValue = 1;
                $i$f$isSpecified8_81llA = Long.compare(string-4foXLRw, i25) != 0 ? rememberedValue : i5;
                if ($i$f$isSpecified8_81llA != 0) {
                    restartGroup.startReplaceGroup(1552727430);
                    ComposerKt.sourceInformation(restartGroup, "794@30102L121,798@30250L30,816@30803L62,812@30694L171");
                    i10 = anon ? 1065353216 : 0;
                    TweenSpec tweenSpec3 = new TweenSpec(0, 0, 0, 7, 0);
                    i7 = i34;
                    $dirty2 = $dirty;
                    $dirty = AnimateAsStateKt.animateFloatAsState(i10, (AnimationSpec)tweenSpec3, 0, 0, 0, restartGroup, 48, 28);
                    string-4foXLRw = Strings_androidKt.getString-4foXLRw(Strings.Companion.getCloseDrawer-UdPEhr4(), restartGroup, 6);
                    String str4 = "CC(remember):Drawer.kt#9igjgp";
                    if (anon) {
                        restartGroup.startReplaceGroup(1552955900);
                        ComposerKt.sourceInformation(restartGroup, "801@30388L73,804@30514L122");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1612470835, str4);
                        i13 = $dirty2 & 112 == anon2 ? empty2 : 0;
                        Composer composer = restartGroup;
                        companion = 0;
                        Object rememberedValue2 = composer.rememberedValue();
                        i9 = 0;
                        if (i13 == 0) {
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                anon3 = new DrawerKt.BottomDrawerScrim.dismissModifier.1.1(obj, 0);
                                composer.updateRememberedValue((Function2)anon3);
                            } else {
                                anon3 = rememberedValue2;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1612466754, str4);
                        i4 = $dirty2 & 112 == 32 ? 1 : 0;
                        i12 = restartGroup;
                        i15 = 0;
                        Object rememberedValue3 = i12.rememberedValue();
                        anon2 = 0;
                        if (changed4 |= i4 == 0) {
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                empty3 = 0;
                                anon = new DrawerKt.BottomDrawerScrim.dismissModifier.2.1(string-4foXLRw, obj);
                                i12.updateRememberedValue((Function1)anon);
                            } else {
                                anon = rememberedValue3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        semantics = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon3), true, (Function1)anon);
                        restartGroup.endReplaceGroup();
                    } else {
                        restartGroup.startReplaceGroup(1553272286);
                        restartGroup.endReplaceGroup();
                        semantics = Modifier.Companion;
                    }
                    empty = 1;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1612457566, str4);
                    i3 = $dirty2 & 14 == 4 ? empty : 0;
                    cmp = restartGroup;
                    i5 = 0;
                    rememberedValue = cmp.rememberedValue();
                    int i36 = 0;
                    if (changed3 |= i3 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon2 = new DrawerKt.BottomDrawerScrim.1.1(l, obj2, $dirty);
                            cmp.updateRememberedValue((Function1)anon2);
                        } else {
                            anon2 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, empty, 0).then(semantics), (Function1)anon2, restartGroup, 0);
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
            traceInProgress2 = new DrawerKt.BottomDrawerScrim.2(l, obj2, obj, $composer, i19);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
        int $dirty5;
        int $dirty4;
        Object obj8;
        int $dirty;
        Object endRestartGroup;
        int i;
        int $dirty2;
        boolean traceInProgress2;
        int $dirty7;
        long $dirty3;
        long l2;
        int skipping;
        int defaultsInvalid;
        Object modifier2;
        Object modifier3;
        boolean traceInProgress;
        Object companion;
        Object obj7;
        Object compositionScopedCoroutineScopeCanceller;
        Object obj4;
        long backgroundColor;
        boolean z;
        int i7;
        int i3;
        Object obj3;
        Object gesturesEnabled3;
        int closed;
        boolean gesturesEnabled2;
        float modifier4;
        int i5;
        Object drawerShape2;
        long l5;
        int changed3;
        float drawerElevation2;
        boolean drawerContentColor2;
        int iNSTANCE;
        long l4;
        int i2;
        Object rememberedValue;
        boolean changed;
        int scrimColor2;
        long l6;
        float empty;
        int i8;
        int compositionCoroutineScope;
        int changed4;
        Composer composer;
        int changed2;
        int i6;
        int $dirty6;
        Object obj6;
        int drawerState2;
        int i4;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        long l;
        Object obj2;
        long l7;
        long l3;
        float f;
        Object obj;
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
        traceInProgress2 = obj44.startRestartGroup(1305806945);
        ComposerKt.sourceInformation(traceInProgress2, "C(ModalDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)491@17842L39,493@17960L5,495@18069L15,496@18118L38,497@18197L10,500@18265L24,501@18337L3449,501@18294L3492:Drawer.kt#jmzs0o");
        $dirty7 = obj45;
        if (i52 & 1 != 0) {
            $dirty7 |= 6;
            obj7 = drawerContent;
        } else {
            if (i51 & 6 == 0) {
                i7 = traceInProgress2.changedInstance(drawerContent) ? 4 : 2;
                $dirty7 |= i7;
            } else {
                obj7 = drawerContent;
            }
        }
        i3 = i52 & 2;
        if (i3 != 0) {
            $dirty7 |= 48;
            gesturesEnabled3 = modifier;
        } else {
            if (i51 & 48 == 0) {
                i5 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty7 |= i5;
            } else {
                gesturesEnabled3 = modifier;
            }
        }
        if (i51 & 384 == 0) {
            if (i52 & 4 == 0) {
                changed3 = traceInProgress2.changed(drawerState) ? 256 : 128;
            } else {
                drawerShape2 = drawerState;
            }
            $dirty7 |= changed3;
        } else {
            drawerShape2 = drawerState;
        }
        drawerElevation2 = i52 & 8;
        if (drawerElevation2 != 0) {
            $dirty7 |= 3072;
            drawerContentColor2 = gesturesEnabled;
        } else {
            if (i51 & 3072 == 0) {
                i2 = traceInProgress2.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty7 |= i2;
            } else {
                drawerContentColor2 = gesturesEnabled;
            }
        }
        if (i51 & 24576 == 0) {
            if (i52 & 16 == 0) {
                changed = traceInProgress2.changed(drawerShape) ? 16384 : 8192;
            } else {
                rememberedValue = drawerShape;
            }
            $dirty7 |= changed;
        } else {
            rememberedValue = drawerShape;
        }
        scrimColor2 = i52 & 32;
        int i45 = 196608;
        if (scrimColor2 != 0) {
            $dirty7 |= i45;
            empty = drawerElevation;
        } else {
            if (i45 &= i51 == 0) {
                i8 = traceInProgress2.changed(drawerElevation) ? 131072 : 65536;
                $dirty7 |= i8;
            } else {
                empty = drawerElevation;
            }
        }
        if (i47 &= i51 == 0) {
            if (i52 & 64 == 0) {
                compositionCoroutineScope = i3;
                changed4 = traceInProgress2.changed(drawerBackgroundColor) ? 1048576 : 524288;
            } else {
                compositionCoroutineScope = i3;
                backgroundColor = drawerBackgroundColor;
            }
            $dirty7 |= changed4;
        } else {
            compositionCoroutineScope = i3;
            backgroundColor = drawerBackgroundColor;
        }
        if (i51 & i53 == 0) {
            if (i52 & 128 == 0) {
                $dirty5 = $dirty7;
                changed2 = traceInProgress2.changed(scrimColor) ? 8388608 : 4194304;
            } else {
                $dirty5 = $dirty7;
                $dirty3 = scrimColor;
            }
            $dirty5 |= changed2;
        } else {
            $dirty4 = $dirty7;
            $dirty3 = scrimColor;
        }
        if (i51 & i55 == 0) {
            if (i52 & 256 == 0) {
                i = traceInProgress2.changed($composer) ? 67108864 : 33554432;
            } else {
                l2 = $composer;
            }
            $dirty4 = i6 | i;
        } else {
            l2 = $composer;
            i6 = $dirty4;
        }
        $dirty6 = $dirty4;
        i4 = 805306368;
        if (i52 & 512 != 0) {
            $dirty = $dirty6 | i4;
        } else {
            if (i51 & i4 == 0) {
                i4 = traceInProgress2.changedInstance(i13) ? 536870912 : 268435456;
                $dirty6 |= i4;
            } else {
                obj8 = i13;
            }
            $dirty = $dirty6;
        }
        if ($dirty & $dirty10 == 306783378) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i57 = -29360129;
                int i58 = -3670017;
                int i59 = -57345;
                int i60 = -234881025;
                if (i51 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (compositionCoroutineScope != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = gesturesEnabled3;
                        }
                        compositionCoroutineScope = 6;
                        if (i52 & 4 != 0) {
                            obj32 = modifier2;
                            modifier3 = DrawerKt.rememberDrawerState(DrawerValue.Closed, 0, traceInProgress2, compositionCoroutineScope, 2);
                            $dirty &= -897;
                        } else {
                            obj32 = modifier2;
                            modifier3 = drawerShape2;
                        }
                        gesturesEnabled2 = drawerElevation2 != 0 ? 1 : drawerContentColor2;
                        if (i52 & 16 != 0) {
                            drawerShape2 = DrawerDefaults.INSTANCE.getShape(traceInProgress2, compositionCoroutineScope);
                            $dirty &= i59;
                        } else {
                            drawerShape2 = rememberedValue;
                        }
                        if (scrimColor2 != 0) {
                            drawerElevation2 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                        } else {
                            drawerElevation2 = empty;
                        }
                        if (i52 & 64 != 0) {
                            backgroundColor = DrawerDefaults.INSTANCE.getBackgroundColor(traceInProgress2, compositionCoroutineScope);
                            $dirty &= i58;
                        }
                        if (i52 & 128 != 0) {
                            drawerContentColor2 = ColorsKt.contentColorFor-ek8zF_U(backgroundColor, i3, traceInProgress2);
                            $dirty &= i57;
                        } else {
                            drawerContentColor2 = scrimColor;
                        }
                        if (i52 & 256 != 0) {
                            $dirty &= i60;
                            obj6 = modifier3;
                            l7 = backgroundColor;
                            i4 = gesturesEnabled2;
                            obj2 = drawerShape2;
                            f = drawerElevation2;
                            l3 = drawerContentColor2;
                            l = scrimColor2;
                            gesturesEnabled3 = obj32;
                        } else {
                            l = $composer;
                            obj6 = modifier3;
                            l7 = backgroundColor;
                            i4 = gesturesEnabled2;
                            obj2 = drawerShape2;
                            f = drawerElevation2;
                            l3 = drawerContentColor2;
                            gesturesEnabled3 = obj32;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i52 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i52 & 16 != 0) {
                            $dirty &= i59;
                        }
                        if (i52 & 64 != 0) {
                            $dirty &= i58;
                        }
                        if (i52 & 128 != 0) {
                            $dirty &= i57;
                        }
                        if (i52 & 256 != 0) {
                            $dirty &= i60;
                        }
                        l3 = scrimColor;
                        l = $composer;
                        l7 = backgroundColor;
                        obj6 = drawerShape2;
                        i4 = drawerContentColor2;
                        obj2 = rememberedValue;
                        f = empty;
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, $dirty, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:499)");
                }
                int i16 = 0;
                int i23 = 0;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i33 = 0;
                Composer composer3 = traceInProgress2;
                int i40 = 0;
                rememberedValue = composer3.rememberedValue();
                int i44 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    int i50 = 0;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, traceInProgress2));
                    composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                int i21 = 1;
                DrawerKt.ModalDrawer.1 anon2 = new DrawerKt.ModalDrawer.1(obj6, i4, (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope(), l, obj21, obj2, l7, obj24, l3, obj26, f, i13, drawerContent);
                obj36 = traceInProgress2;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(gesturesEnabled3, 0, i21, 0), 0, false, (Function3)ComposableLambdaKt.rememberComposableLambda(816674999, i21, anon2, traceInProgress2, 54), obj36, 3072, 6);
                composer = obj36;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                companion = gesturesEnabled3;
                obj4 = obj6;
                z = i4;
                l6 = l;
                obj3 = obj2;
                l5 = l7;
                l4 = l3;
                modifier4 = f;
                drawerState2 = $dirty;
            } else {
                traceInProgress2.skipToGroupEnd();
                composer = traceInProgress2;
                companion = gesturesEnabled3;
                obj4 = drawerShape2;
                modifier4 = empty;
                l6 = $composer;
                l5 = backgroundColor;
                z = drawerContentColor2;
                obj3 = rememberedValue;
                l4 = scrimColor;
                drawerState2 = $dirty;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new DrawerKt.ModalDrawer.2(drawerContent, companion, obj4, z, obj3, modifier4, l5, drawerElevation2, l4, rememberedValue, l6, empty, i13, i51, i52);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void Scrim-Bx497Mc(boolean open, Function0<Unit> onClose, Function0<Float> fraction, long color, Composer $composer, int $changed) {
        Object closeDrawer;
        boolean traceInProgress;
        Object anon;
        Modifier companion3;
        int $dirty;
        int i;
        int i6;
        int i8;
        int i7;
        int skipping;
        boolean traceInProgress2;
        int empty;
        Object anon2;
        int pointerInput;
        int i4;
        int i11;
        int i3;
        int i9;
        Composer composer;
        int rememberedValue;
        int i10;
        Composer composer2;
        Object rememberedValue2;
        String str;
        int i2;
        int companion;
        int i5;
        Composer.Companion companion2;
        companion3 = open;
        final Object obj = onClose;
        final Object obj2 = fraction;
        final long l = color;
        final int i13 = obj27;
        traceInProgress = 1983403750;
        Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)829@31020L30,845@31464L51,841@31373L142:Drawer.kt#jmzs0o");
        if (i13 & 6 == 0) {
            i = restartGroup.changed(companion3) ? 4 : 2;
            $dirty |= i;
        }
        pointerInput = 32;
        if (i13 & 48 == 0) {
            i6 = restartGroup.changedInstance(obj) ? pointerInput : 16;
            $dirty |= i6;
        }
        if (i13 & 384 == 0) {
            i8 = restartGroup.changedInstance(obj2) ? 256 : 128;
            $dirty |= i8;
        }
        if (i13 & 3072 == 0) {
            i7 = restartGroup.changed(l) ? 2048 : 1024;
            $dirty |= i7;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.Scrim (Drawer.kt:828)");
                }
                String string-4foXLRw = Strings_androidKt.getString-4foXLRw(Strings.Companion.getCloseDrawer-UdPEhr4(), restartGroup, 6);
                String str3 = "CC(remember):Drawer.kt#9igjgp";
                if (companion3) {
                    restartGroup.startReplaceGroup(487703622);
                    ComposerKt.sourceInformation(restartGroup, "832@31139L35,833@31223L108");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1262659875, str3);
                    i11 = $dirty & 112 == pointerInput ? 1 : 0;
                    Composer composer3 = restartGroup;
                    companion = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    i5 = 0;
                    if (i11 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int i30 = 0;
                            anon2 = new DrawerKt.Scrim.dismissDrawer.1.1(obj, 0);
                            composer3.updateRememberedValue((Function2)anon2);
                        } else {
                            anon2 = rememberedValue3;
                            composer2 = composer3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1262662636, str3);
                    i9 = $dirty & 112 == 32 ? 1 : 0;
                    composer = restartGroup;
                    i10 = 0;
                    rememberedValue2 = composer.rememberedValue();
                    i2 = 0;
                    if (changed3 |= i9 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon = new DrawerKt.Scrim.dismissDrawer.2.1(string-4foXLRw, obj);
                            composer.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    companion3 = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon2), true, (Function1)anon);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(487952490);
                    restartGroup.endReplaceGroup();
                    companion3 = Modifier.Companion;
                }
                int i22 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1262670291, str3);
                i4 = $dirty & 7168 == 2048 ? i22 : 0;
                rememberedValue2 = $dirty & 896 == 256 ? i22 : 0;
                i3 = restartGroup;
                composer = 0;
                rememberedValue = i3.rememberedValue();
                i10 = 0;
                if (i4 |= rememberedValue2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue2 = 0;
                        str = string-4foXLRw;
                        closeDrawer = new DrawerKt.Scrim.1.1(l, obj5, obj2);
                        i3.updateRememberedValue((Function1)closeDrawer);
                    } else {
                        str = string-4foXLRw;
                        closeDrawer = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, i22, 0).then(companion3), (Function1)closeDrawer, restartGroup, 0);
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
            traceInProgress = new DrawerKt.Scrim.2(open, obj, obj2, l, obj5, i13);
            endRestartGroup.updateScope((Function2)traceInProgress);
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
        int i2;
        boolean changed2;
        int iNSTANCE;
        boolean changed;
        String str;
        int i;
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
                i2 = $changed & 6 == i11 ? i17 : i;
            } else {
            }
        } else {
        }
        int i18 = 32;
        if (i12 ^= 48 > i18) {
            if (!$composer.changed(obj10)) {
                if ($changed & 48 == i18) {
                    i = i17;
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
