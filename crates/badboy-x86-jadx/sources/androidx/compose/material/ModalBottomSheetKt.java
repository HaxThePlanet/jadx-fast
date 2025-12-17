package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
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
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0093\u0001\u0010\u000b\u001a\u00020\u000c2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000c0\u000e¢\u0006\u0002\u0008\u0010¢\u0006\u0002\u0008\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001c2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u000c0 ¢\u0006\u0002\u0008\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\u001a0\u0010#\u001a\u00020\u000c2\u0006\u0010$\u001a\u00020\u001c2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u000c0 2\u0006\u0010&\u001a\u00020\u0017H\u0003ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001aE\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+2\u000e\u0008\u0002\u0010,\u001a\u0008\u0012\u0004\u0012\u00020.0-2\u0014\u0008\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00170\u000e2\u0008\u0008\u0002\u00100\u001a\u00020\u0017H\u0007¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00063²\u0006\n\u00104\u001a\u00020.X\u008a\u0084\u0002", d2 = {"MaxModalBottomSheetWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ModalBottomSheetPositionalThreshold", "ModalBottomSheetVelocityThreshold", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "modalBottomSheetAnchors", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModalBottomSheetKt {

    private static final float MaxModalBottomSheetWidth;
    private static final float ModalBottomSheetPositionalThreshold;
    private static final float ModalBottomSheetVelocityThreshold;
    static {
        int i4 = 0;
        ModalBottomSheetKt.ModalBottomSheetPositionalThreshold = Dp.constructor-impl((float)i);
        int i5 = 0;
        ModalBottomSheetKt.ModalBottomSheetVelocityThreshold = Dp.constructor-impl((float)i2);
        int i6 = 0;
        ModalBottomSheetKt.MaxModalBottomSheetWidth = Dp.constructor-impl((float)i3);
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(androidx.compose.material.AnchoredDraggableState<?> state, Orientation orientation) {
        ModalBottomSheetKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1 anon = new ModalBottomSheetKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1(state, orientation);
        return (NestedScrollConnection)anon;
    }

    public static final void ModalBottomSheetLayout-Gs3lGvM(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, Modifier modifier, androidx.compose.material.ModalBottomSheetState sheetState, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, long scrimColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        long i11;
        int i;
        boolean $dirty2;
        Object endRestartGroup;
        androidx.compose.ui.Modifier.Companion $dirty3;
        Function0 factory$iv$iv$iv2;
        Modifier nestedScroll$default;
        Modifier currentValue;
        Function3 function3;
        int skipping;
        int defaultsInvalid;
        androidx.compose.ui.Modifier.Companion modifier2;
        int modifier3;
        Object compositionCoroutineScope;
        Object anon;
        Object vertical;
        Modifier semantics$default;
        int i7;
        int i33;
        int i30;
        int i14;
        int i36;
        int $dirty;
        androidx.compose.ui.Modifier.Companion sheetState2;
        androidx.compose.material.ModalBottomSheetState rememberModalBottomSheetState;
        int i37;
        long l8;
        androidx.compose.material.ModalBottomSheetState $composer2;
        Composer composer;
        Object obj4;
        boolean scope;
        int i28;
        boolean sheetGesturesEnabled2;
        Object compositionScopedCoroutineScopeCanceller;
        int i39;
        int i17;
        Object obj2;
        Object sheetShape3;
        long sheetShape2;
        Integer currentCompositionLocalMap2;
        Function0 factory$iv$iv$iv;
        Object it$iv;
        int i10;
        Object fillMaxWidth$default;
        int changedInstance;
        float $composer3;
        Composer sheetElevation2;
        Integer currentCompositionLocalMap;
        int str;
        int changed5;
        float f2;
        long l7;
        long sheetBackgroundColor2;
        int sheetBackgroundColor3;
        int changed3;
        int i29;
        boolean changed;
        int i4;
        int changed4;
        int i35;
        boolean traceInProgress;
        Composer composer3;
        Composer composer5;
        Object maxModalBottomSheetWidth;
        Object materialized$iv$iv;
        int valueOf;
        long sheetContentColor2;
        long l2;
        Composer composer2;
        int i25;
        Object maybeCachedBoxMeasurePolicy2;
        Object obj3;
        Object $i$f$cache;
        long l6;
        int i34;
        boolean maybeCachedBoxMeasurePolicy;
        int i5;
        int i19;
        int changed2;
        int i21;
        Modifier scrimColor2;
        Composer.Companion companion2;
        Object obj;
        long l5;
        long l3;
        int i9;
        Object iNSTANCE;
        float f;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer6;
        int i18;
        int i12;
        int i2;
        int i41;
        int i16;
        int i27;
        int i20;
        int i40;
        int i22;
        int i26;
        int i32;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i23;
        int i31;
        int i15;
        Composer composer7;
        Modifier modifier5;
        int i3;
        int i6;
        int i24;
        int i38;
        Alignment alignment;
        BoxScopeInstance boxScopeInstance;
        Function0 function0;
        Composer composer4;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Modifier modifier4;
        long l;
        int i8;
        Composer.Companion companion;
        ScopeUpdateScope scopeUpdateScope;
        long l4;
        Object obj64;
        Orientation obj65;
        int obj66;
        Object obj67;
        Composer obj68;
        int obj69;
        boolean obj70;
        int obj71;
        androidx.compose.ui.Modifier.Companion obj72;
        Function0 obj73;
        int obj74;
        Object obj5 = sheetContent;
        final Object obj7 = i13;
        final int i126 = obj77;
        final int i127 = obj78;
        sheetElevation2 = obj76.startRestartGroup(-92970288);
        ComposerKt.sourceInformation(sheetElevation2, "C(ModalBottomSheetLayout)P(4,1,9,7,8,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color)352@14482L37,354@14601L6,356@14724L6,357@14771L37,358@14859L10,361@14927L24,363@14999L3822:ModalBottomSheet.kt#jmzs0o");
        $dirty = obj77;
        if (i127 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i126 & 6 == 0) {
                i37 = sheetElevation2.changedInstance(obj5) ? 4 : 2;
                $dirty |= i37;
            }
        }
        int i59 = i127 & 2;
        if (i59 != 0) {
            $dirty |= 48;
            obj4 = modifier;
        } else {
            if (i126 & 48 == 0) {
                i39 = sheetElevation2.changed(modifier) ? 32 : 16;
                $dirty |= i39;
            } else {
                obj4 = modifier;
            }
        }
        if (i126 & 384 == 0) {
            if (i127 & 4 == 0) {
                i17 = sheetElevation2.changedInstance(sheetState) ? 256 : 128;
            } else {
                obj3 = sheetState;
            }
            $dirty |= i17;
        } else {
            obj3 = sheetState;
        }
        i34 = i127 & 8;
        if (i34 != 0) {
            $dirty |= 3072;
            maybeCachedBoxMeasurePolicy = sheetGesturesEnabled;
        } else {
            if (i126 & 3072 == 0) {
                i17 = sheetElevation2.changed(sheetGesturesEnabled) ? 2048 : 1024;
                $dirty |= i17;
            } else {
                maybeCachedBoxMeasurePolicy = sheetGesturesEnabled;
            }
        }
        if (i126 & 24576 == 0) {
            if (i127 & 16 == 0) {
                changed5 = sheetElevation2.changed(sheetShape) ? 16384 : 8192;
            } else {
                obj2 = sheetShape;
            }
            $dirty |= changed5;
        } else {
            obj2 = sheetShape;
        }
        if (i91 &= i126 == 0) {
            if (i127 & 32 == 0) {
                changed3 = sheetElevation2.changed(sheetElevation) ? 131072 : 65536;
            } else {
                f2 = sheetElevation;
            }
            $dirty |= changed3;
        } else {
            f2 = sheetElevation;
        }
        i5 = 1572864;
        if (i126 & i5 == 0) {
            if (i127 & 64 == 0) {
                i29 = sheetElevation2.changed(sheetBackgroundColor) ? 1048576 : 524288;
            } else {
                sheetContentColor2 = sheetBackgroundColor;
            }
            $dirty |= i29;
        } else {
            sheetContentColor2 = sheetBackgroundColor;
        }
        if (i96 &= i126 == 0) {
            if (i127 & 128 == 0) {
                i4 = sheetElevation2.changed(scrimColor) ? 8388608 : 4194304;
            } else {
                i11 = scrimColor;
            }
            $dirty |= i4;
        } else {
            i11 = scrimColor;
        }
        if (i97 &= i126 == 0) {
            if (i127 & 256 == 0) {
                i35 = i59;
                changed2 = sheetElevation2.changed($composer) ? 67108864 : 33554432;
            } else {
                i35 = i59;
                l8 = $composer;
            }
            $dirty |= changed2;
        } else {
            i35 = i59;
            l8 = $composer;
        }
        int i54 = 805306368;
        if (i127 & 512 != 0) {
            $dirty |= i54;
        } else {
            if (i126 & i54 == 0) {
                i = sheetElevation2.changedInstance(obj7) ? 536870912 : 268435456;
                $dirty |= i;
            }
        }
        $dirty2 = $dirty;
        if (i55 &= $dirty2 == 306783378) {
            if (!sheetElevation2.getSkipping()) {
                sheetElevation2.startDefaults();
                int i60 = 6;
                if (i126 & 1 != 0) {
                    if (sheetElevation2.getDefaultsInvalid()) {
                        if (i35 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i127 & 4 != 0) {
                            i21 = i63;
                            obj64 = modifier2;
                            modifier3 = changed2;
                            rememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, 0, 0, false, sheetElevation2, 6, 14);
                            composer = sheetElevation2;
                            $dirty2 &= -897;
                        } else {
                            obj64 = modifier2;
                            modifier3 = i60;
                            composer = sheetElevation2;
                            rememberModalBottomSheetState = sheetState;
                        }
                        sheetGesturesEnabled2 = i34 != 0 ? 1 : maybeCachedBoxMeasurePolicy;
                        if (i127 & 16 != 0) {
                            sheetShape3 = MaterialTheme.INSTANCE.getShapes(composer, modifier3).getLarge();
                            $dirty2 &= sheetElevation2;
                        } else {
                            sheetShape3 = sheetShape;
                        }
                        if (i127 & 32 != 0) {
                            sheetElevation2 = ModalBottomSheetDefaults.INSTANCE.getElevation-D9Ej5fM();
                            $dirty2 &= f2;
                        } else {
                            sheetElevation2 = sheetElevation;
                        }
                        if (i127 & 64 != 0) {
                            sheetBackgroundColor2 = MaterialTheme.INSTANCE.getColors(composer, modifier3).getSurface-0d7_KjU();
                            $dirty2 &= sheetContentColor2;
                        } else {
                            sheetBackgroundColor2 = sheetContentColor2;
                        }
                        if (i127 & 128 != 0) {
                            sheetContentColor2 = ColorsKt.contentColorFor-ek8zF_U(sheetBackgroundColor2, i35, composer);
                            $dirty2 &= i34;
                        } else {
                            sheetContentColor2 = scrimColor;
                        }
                        if (i127 & 256 != 0) {
                            f = sheetElevation2;
                            l5 = sheetBackgroundColor2;
                            l3 = sheetContentColor2;
                            sheetBackgroundColor3 = $dirty4;
                            $dirty3 = obj64;
                            obj = sheetShape3;
                            sheetShape2 = l4;
                        } else {
                            obj = sheetShape3;
                            f = sheetElevation2;
                            l5 = sheetBackgroundColor2;
                            l3 = sheetContentColor2;
                            sheetShape2 = $composer;
                            sheetBackgroundColor3 = $dirty2;
                            $dirty3 = obj64;
                        }
                    } else {
                        sheetElevation2.skipToGroupEnd();
                        if (i127 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i127 & 16 != 0) {
                            $dirty2 &= i7;
                        }
                        if (i127 & 32 != 0) {
                            $dirty2 &= i33;
                        }
                        if (i127 & 64 != 0) {
                            $dirty2 &= i30;
                        }
                        if (i127 & 128 != 0) {
                            $dirty2 &= i14;
                        }
                        if (i127 & 256 != 0) {
                            $dirty2 &= i36;
                        }
                        rememberModalBottomSheetState = sheetState;
                        l3 = scrimColor;
                        modifier3 = i60;
                        obj = obj2;
                        composer = sheetElevation2;
                        f = f2;
                        l5 = sheetContentColor2;
                        sheetGesturesEnabled2 = maybeCachedBoxMeasurePolicy;
                        sheetShape2 = $composer;
                        sheetBackgroundColor3 = $dirty2;
                        $dirty3 = modifier;
                    }
                } else {
                }
                composer.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-92970288, sheetBackgroundColor3, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:360)");
                }
                int i99 = i21;
                int i113 = 0;
                ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i124 = 0;
                Composer composer15 = composer;
                int i128 = 0;
                int i130 = modifier3;
                compositionCoroutineScope = composer15.rememberedValue();
                int i131 = 0;
                obj70 = sheetGesturesEnabled2;
                if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                    int i133 = 0;
                    obj64 = compositionCoroutineScope;
                    obj65 = i64;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer));
                    composer15.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = obj64;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                kotlinx.coroutines.CoroutineScope coroutineScope = (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(composer);
                vertical = Orientation.Vertical;
                i100 &= 14;
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart2 = Alignment.Companion.getTopStart();
                i22 = 0;
                obj64 = sheetShape2;
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                obj71 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, $dirty3);
                obj73 = constructor;
                i26 = 0;
                i32 = sheetBackgroundColor3;
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(obj73);
                } else {
                    factory$iv$iv$iv2 = obj73;
                    composer.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(composer);
                int i132 = 0;
                obj73 = factory$iv$iv$iv2;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i134 = 0;
                obj66 = constructor-impl;
                int i136 = 0;
                if (!obj66.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    i23 = valueOf;
                    if (!Intrinsics.areEqual(obj66.rememberedValue(), Integer.valueOf(obj71))) {
                        obj66.updateRememberedValue(Integer.valueOf(obj71));
                        constructor-impl.apply(Integer.valueOf(obj71), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = obj66;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    i23 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = composer;
                i31 = i46;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance iNSTANCE2 = BoxScopeInstance.INSTANCE;
                i15 = 0;
                modifier5 = materializeModifier;
                i3 = i94;
                Composer composer10 = composer16;
                ComposerKt.sourceInformationMarkerStart(composer10, -893645859, "C364@15023L430,443@18761L54,376@15462L3353:ModalBottomSheet.kt#jmzs0o");
                i6 = i104;
                i24 = i114;
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, 1, 0);
                companion2 = 6;
                int i135 = 0;
                ComposerKt.sourceInformationMarkerStart(composer10, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                int i105 = 0;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i105);
                int i139 = 0;
                Alignment alignment2 = topStart;
                int i140 = i105;
                ComposerKt.sourceInformationMarkerStart(composer10, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = composer10.getCurrentCompositionLocalMap();
                int i141 = currentCompositeKeyHash2;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer10, fillMaxSize$default);
                Modifier modifier7 = fillMaxSize$default;
                Function0 function02 = constructor2;
                int i142 = 0;
                alignment = topStart2;
                ComposerKt.sourceInformationMarkerStart(composer10, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer10.startReusableNode();
                if (composer10.getInserting()) {
                    composer10.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    composer10.useNode();
                }
                Composer constructor-impl2 = Updater.constructor-impl(composer10);
                int i143 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i145 = 0;
                obj66 = constructor-impl2;
                int i146 = 0;
                if (!obj66.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(obj66.rememberedValue(), Integer.valueOf(i141))) {
                        obj66.updateRememberedValue(Integer.valueOf(i141));
                        constructor-impl2.apply(Integer.valueOf(i141), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = obj66;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer9 = composer10;
                int i115 = 0;
                int i144 = i72;
                ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i121 |= 6;
                changed2 = 0;
                boxScopeInstance = iNSTANCE4;
                modifier4 = materializeModifier2;
                materialized$iv$iv = obj68;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 925143060, "C365@15065L9,368@15158L188,366@15087L356:ModalBottomSheet.kt#jmzs0o");
                obj7.invoke(materialized$iv$iv, Integer.valueOf(i73 &= 14));
                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -1494174543, str);
                obj66 = materialized$iv$iv;
                int i147 = 0;
                it$iv = obj66.rememberedValue();
                i8 = 0;
                if (changedInstance4 |= changedInstance7 == 0) {
                    obj68 = materialized$iv$iv;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        int $composer4 = 0;
                        obj69 = it$iv;
                        it$iv = new ModalBottomSheetKt.ModalBottomSheetLayout.1.1.1.1(rememberModalBottomSheetState, coroutineScope);
                        obj66.updateRememberedValue((Function0)it$iv);
                    } else {
                        composer5 = obj66;
                        obj69 = it$iv;
                    }
                } else {
                    obj68 = materialized$iv$iv;
                }
                ComposerKt.sourceInformationMarkerEnd(obj68);
                i10 = rememberModalBottomSheetState.getAnchoredDraggableState$material_release().getTargetValue() != ModalBottomSheetValue.Hidden ? 1 : 0;
                ModalBottomSheetKt.Scrim-3J-VO9M(obj64, obj65, (Function0)it$iv, i10, obj68);
                ComposerKt.sourceInformationMarkerEnd(obj68);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer10.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                obj64 = iNSTANCE2;
                int $this$ModalBottomSheetLayout_Gs3lGvM_u24lambda_u245 = 1;
                i25 = 0;
                obj3 = 0;
                if (obj70 != null) {
                    composer10.startReplaceGroup(-893030355);
                    ComposerKt.sourceInformation(composer10, "384@15824L354");
                    ComposerKt.sourceInformationMarkerStart(composer10, -167352424, str);
                    Composer composer13 = composer10;
                    $i$f$cache = 0;
                    maxModalBottomSheetWidth = composer13.rememberedValue();
                    changed2 = 0;
                    if (!composer10.changed(rememberModalBottomSheetState.getAnchoredDraggableState$material_release())) {
                        obj66 = $i$f$cache;
                        if (maxModalBottomSheetWidth == Composer.Companion.getEmpty()) {
                            $i$f$cache = 0;
                            obj67 = maxModalBottomSheetWidth;
                            composer13.updateRememberedValue(ModalBottomSheetKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(rememberModalBottomSheetState.getAnchoredDraggableState$material_release(), vertical));
                        } else {
                            obj67 = maxModalBottomSheetWidth;
                        }
                    } else {
                        obj66 = $i$f$cache;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    obj3 = 0;
                    nestedScroll$default = NestedScrollModifierKt.nestedScroll$default((Modifier)Modifier.Companion, (NestedScrollConnection)maxModalBottomSheetWidth, obj3, 2, obj3);
                    composer10.endReplaceGroup();
                } else {
                    composer10.startReplaceGroup(-167339714);
                    composer10.endReplaceGroup();
                    nestedScroll$default = Modifier.Companion;
                }
                if (obj70 != null && rememberModalBottomSheetState.getAnchoredDraggableState$material_release().getCurrentValue() != ModalBottomSheetValue.Hidden) {
                    i2 = rememberModalBottomSheetState.getAnchoredDraggableState$material_release().getCurrentValue() != ModalBottomSheetValue.Hidden ? 1 : 0;
                } else {
                }
                if (obj70 != null) {
                    composer10.startReplaceGroup(-892060489);
                    ComposerKt.sourceInformation(composer10, "402@16726L1810");
                    ComposerKt.sourceInformationMarkerStart(composer10, -167322104, str);
                    Composer composer12 = composer10;
                    i25 = 0;
                    Object rememberedValue3 = composer12.rememberedValue();
                    changed2 = 0;
                    if (changedInstance5 |= changedInstance6 == 0) {
                        obj65 = vertical;
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            obj66 = orientation;
                            anon = new ModalBottomSheetKt.ModalBottomSheetLayout.1.3.1(rememberModalBottomSheetState, coroutineScope);
                            composer12.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue3;
                        }
                    } else {
                        obj65 = vertical;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    semantics$default = SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, false, (Function1)anon, 1, 0);
                    composer10.endReplaceGroup();
                } else {
                    obj65 = vertical;
                    composer10.startReplaceGroup(-167265090);
                    composer10.endReplaceGroup();
                    semantics$default = Modifier.Companion;
                }
                ModalBottomSheetKt.ModalBottomSheetLayout.1.4 anon2 = new ModalBottomSheetKt.ModalBottomSheetLayout.1.4(sheetContent);
                SurfaceKt.Surface-F-jzlyU(AnchoredDraggableKt.anchoredDraggable$default(ModalBottomSheetKt.modalBottomSheetAnchors(SizeKt.fillMaxWidth$default(SizeKt.widthIn-VpY3zN4$default((BoxScope)iNSTANCE2.align((Modifier)Modifier.Companion, Alignment.Companion.getTopCenter()), i25, ModalBottomSheetKt.MaxModalBottomSheetWidth, $this$ModalBottomSheetLayout_Gs3lGvM_u24lambda_u245, obj3), i25, $this$ModalBottomSheetLayout_Gs3lGvM_u24lambda_u245, obj3).then(nestedScroll$default), rememberModalBottomSheetState), rememberModalBottomSheetState.getAnchoredDraggableState$material_release(), vertical, i2, false, 0, false, 56, 0).then(semantics$default), obj, l5, obj23, l3, obj25, 0, f, (Function2)ComposableLambdaKt.rememberComposableLambda(17396558, true, anon2, composer10, 54), composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scope = obj70;
                composer7 = composer;
                obj2 = obj;
                l7 = l5;
                l2 = l3;
                $composer3 = f;
                l6 = l;
                $composer2 = rememberModalBottomSheetState;
                sheetState2 = obj72;
            } else {
                sheetElevation2.skipToGroupEnd();
                scope = maybeCachedBoxMeasurePolicy;
                l6 = l9;
                function3 = sheetContent;
                sheetState2 = modifier;
                $composer2 = sheetState;
                i32 = $dirty2;
                composer7 = sheetElevation2;
                $composer3 = f2;
                l7 = sheetContentColor2;
                l2 = scrimColor;
            }
        } else {
        }
        endRestartGroup = composer7.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ModalBottomSheetKt.ModalBottomSheetLayout.2(function3, sheetState2, $composer2, scope, obj2, $composer3, l7, i35, l2, obj3, l6, maybeCachedBoxMeasurePolicy, obj7, i126, i127);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void Scrim-3J-VO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        int traceInProgress2;
        int i8;
        Modifier semantics;
        boolean anon;
        int $dirty;
        int i11;
        int i7;
        int i9;
        boolean string-4foXLRw;
        boolean traceInProgress;
        int i;
        int str;
        int empty;
        Composer cmp;
        int i15;
        int i10;
        int i4;
        Object rememberedValue;
        int i3;
        int i13;
        Composer i5;
        int i16;
        int i12;
        int empty2;
        int empty3;
        int anon3;
        Object anon2;
        int $dirty2;
        int companion;
        int i14;
        int i2;
        int companion2;
        int i6;
        final long l = color;
        final Object obj = visible;
        anon = $composer;
        final int i20 = obj27;
        traceInProgress2 = -526532668;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(0:c#ui.graphics.Color):ModalBottomSheet.kt#jmzs0o");
        if (i20 & 6 == 0) {
            i11 = restartGroup.changed(l) ? 4 : 2;
            $dirty |= i11;
        }
        anon3 = 32;
        if (i20 & 48 == 0) {
            i7 = restartGroup.changedInstance(obj) ? anon3 : 16;
            $dirty |= i7;
        }
        if (i20 & 384 == 0) {
            i9 = restartGroup.changed(anon) ? 256 : 128;
            $dirty |= i9;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:495)");
                }
                int i17 = 0;
                i15 = 0;
                rememberedValue = 1;
                i8 = Long.compare(string-4foXLRw, i26) != 0 ? rememberedValue : i15;
                if (i8 != 0) {
                    restartGroup.startReplaceGroup(477259505);
                    ComposerKt.sourceInformation(restartGroup, "497@20564L121,501@20711L29,517@21226L62,513@21117L171");
                    i = anon ? 1065353216 : 0;
                    TweenSpec tweenSpec3 = new TweenSpec(0, 0, 0, 7, 0);
                    i14 = i35;
                    $dirty2 = $dirty;
                    $dirty = AnimateAsStateKt.animateFloatAsState(i, (AnimationSpec)tweenSpec3, 0, 0, 0, restartGroup, 48, 28);
                    string-4foXLRw = Strings_androidKt.getString-4foXLRw(Strings.Companion.getCloseSheet-UdPEhr4(), restartGroup, 6);
                    String str4 = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if (anon) {
                        restartGroup.startReplaceGroup(477486053);
                        ComposerKt.sourceInformation(restartGroup, "504@20848L37,505@20938L121");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1262330565, str4);
                        i3 = $dirty2 & 112 == anon3 ? empty3 : 0;
                        Composer composer = restartGroup;
                        companion = 0;
                        Object rememberedValue2 = composer.rememberedValue();
                        i2 = 0;
                        if (i3 == 0) {
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                empty3 = 0;
                                anon2 = new ModalBottomSheetKt.Scrim.dismissModifier.1.1(obj, 0);
                                composer.updateRememberedValue((Function2)anon2);
                            } else {
                                anon2 = rememberedValue2;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1262333529, str4);
                        i13 = $dirty2 & 112 == 32 ? 1 : 0;
                        i5 = restartGroup;
                        i12 = 0;
                        Object rememberedValue3 = i5.rememberedValue();
                        anon3 = 0;
                        if (changed4 |= i13 == 0) {
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                empty = 0;
                                anon = new ModalBottomSheetKt.Scrim.dismissModifier.2.1(string-4foXLRw, obj);
                                i5.updateRememberedValue((Function1)anon);
                            } else {
                                anon = rememberedValue3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        semantics = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon2), true, (Function1)anon);
                        restartGroup.endReplaceGroup();
                    } else {
                        restartGroup.startReplaceGroup(477766882);
                        restartGroup.endReplaceGroup();
                        semantics = Modifier.Companion;
                    }
                    empty2 = 1;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1262342686, str4);
                    i4 = $dirty2 & 14 == 4 ? empty2 : 0;
                    cmp = restartGroup;
                    i15 = 0;
                    rememberedValue = cmp.rememberedValue();
                    int i37 = 0;
                    if (changed3 |= i4 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty2 = 0;
                            anon3 = new ModalBottomSheetKt.Scrim.1.1(l, obj2, $dirty);
                            cmp.updateRememberedValue((Function1)anon3);
                        } else {
                            anon3 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, empty2, 0).then(semantics), (Function1)anon3, restartGroup, 0);
                    restartGroup.endReplaceGroup();
                } else {
                    $dirty2 = $dirty;
                    restartGroup.startReplaceGroup(477983138);
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
            traceInProgress2 = new ModalBottomSheetKt.Scrim.2(l, obj2, obj, $composer, i20);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final float Scrim_3J_VO9M$lambda$6(State<Float> $alpha$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$alpha$delegate.getValue().floatValue();
    }

    public static final void access$Scrim-3J-VO9M(long color, Function0 onDismiss, boolean visible, Composer $composer, int $changed) {
        ModalBottomSheetKt.Scrim-3J-VO9M(color, onDismiss, visible, $composer, $changed);
    }

    public static final float access$Scrim_3J_VO9M$lambda$6(State $alpha$delegate) {
        return ModalBottomSheetKt.Scrim_3J_VO9M$lambda$6($alpha$delegate);
    }

    public static final float access$getModalBottomSheetPositionalThreshold$p() {
        return ModalBottomSheetKt.ModalBottomSheetPositionalThreshold;
    }

    public static final float access$getModalBottomSheetVelocityThreshold$p() {
        return ModalBottomSheetKt.ModalBottomSheetVelocityThreshold;
    }

    private static final Modifier modalBottomSheetAnchors(Modifier $this$modalBottomSheetAnchors, androidx.compose.material.ModalBottomSheetState sheetState) {
        ModalBottomSheetKt.modalBottomSheetAnchors.1 anon = new ModalBottomSheetKt.modalBottomSheetAnchors.1(sheetState);
        return AnchoredDraggableKt.draggableAnchors($this$modalBottomSheetAnchors, sheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, (Function2)anon);
    }

    public static final androidx.compose.material.ModalBottomSheetState rememberModalBottomSheetState(androidx.compose.material.ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.ModalBottomSheetValue, Boolean> confirmValueChange, boolean skipHalfExpanded, Composer $composer, int $changed, int i7) {
        boolean changed2;
        int i6;
        Object anon;
        int empty;
        int animationSpec3;
        int iNSTANCE;
        int i4;
        boolean traceInProgress;
        androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState.1 anon3;
        AnimationSpec animationSpec2;
        int i5;
        String str;
        int i8;
        int changed;
        int i;
        boolean changed3;
        int i2;
        Object obj;
        AnimationSpec animationSpec4;
        androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState.1 anon2;
        int i3;
        Object obj2 = initialValue;
        Composer composer2 = $composer;
        final int i19 = $changed;
        int i9 = -126412120;
        ComposerKt.sourceInformationMarkerStart(composer2, i9, "C(rememberModalBottomSheetState)P(2)291@11506L7:ModalBottomSheet.kt#jmzs0o");
        if (i7 & 2 != 0) {
            animationSpec2 = animationSpec3;
        } else {
            animationSpec2 = animationSpec;
        }
        if (i7 & 4 != 0) {
            anon3 = iNSTANCE;
        } else {
            anon3 = confirmValueChange;
        }
        i5 = i7 & 8 != 0 ? i4 : skipHalfExpanded;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i19, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:290)");
        }
        int i15 = 0;
        int i20 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Object $changed$iv = consume;
        composer2.startMovableGroup(976449919, obj2);
        ComposerKt.sourceInformation(composer2, "304@12115L298,296@11767L646");
        ComposerKt.sourceInformationMarkerStart(composer2, 976461569, "CC(remember):ModalBottomSheet.kt#9igjgp");
        i8 = 0;
        int i23 = 1;
        int i24 = 4;
        if (i12 ^= 6 > i24) {
            if (!composer2.changed(obj2)) {
                i6 = i19 & 6 == i24 ? i23 : i8;
            } else {
            }
        } else {
        }
        int i28 = 256;
        if (i25 ^= 384 > i28) {
            if (!composer2.changed(anon3)) {
                i = i19 & 384 == i28 ? i23 : i8;
            } else {
            }
        } else {
        }
        int i29 = 2048;
        if (i26 ^= 3072 > i29) {
            if (!composer2.changed(i5)) {
                if (i19 & 3072 == i29) {
                    i8 = i23;
                }
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i27 = 0;
        Object rememberedValue = composer3.rememberedValue();
        final int i30 = 0;
        if (i8 |= empty == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i2 = 0;
                anon = new ModalBottomSheetKt.rememberModalBottomSheetState.2.1(obj2, $changed$iv, anon3, animationSpec2, i5);
                obj = $changed$iv;
                anon2 = anon3;
                animationSpec4 = animationSpec2;
                i3 = i5;
                composer3.updateRememberedValue((Function0)anon);
            } else {
                obj = $changed$iv;
                anon2 = anon3;
                animationSpec4 = animationSpec2;
                i3 = i5;
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (ModalBottomSheetState)RememberSaveableKt.rememberSaveable(/* result */, ModalBottomSheetState.Companion.Saver(animationSpec2, anon3, i5, (Density)$changed$iv), 0, (Function0)anon, $composer, 0, 4);
    }
}
