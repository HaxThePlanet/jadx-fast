package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001ar\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a\u0080\u0002\u0010\u001b\u001a\u00020\u00062\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u00182\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0015\u0008\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\u0008\u00172\u0019\u0008\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\u0008\u00172\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00012\u0008\u0008\u0002\u0010&\u001a\u00020\u000f2\u0008\u0008\u0002\u0010'\u001a\u00020\u000f2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\u0008\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a\u009b\u0001\u0010+\u001a\u00020\u00062\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\u0008\u00172\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\u0008\u00172\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\u0008\u00172\u0013\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\u0008\u00172\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\u0008\u00172\u0006\u0010\u0011\u001a\u00020\u00012\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u00020/0 2\u0006\u0010$\u001a\u00020%2\u0006\u00100\u001a\u00020\u0008H\u0003ø\u0001\u0000¢\u0006\u0004\u00081\u00102\u001a\u001c\u00103\u001a\u0002042\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u0003052\u0006\u00106\u001a\u000207H\u0002\u001a!\u00108\u001a\u00020\u001e2\u0008\u0008\u0002\u00109\u001a\u00020\u00082\u0008\u0008\u0002\u0010:\u001a\u00020\"H\u0007¢\u0006\u0002\u0010;\u001a;\u0010<\u001a\u00020\u00082\u0006\u0010=\u001a\u00020>2\u000e\u0008\u0002\u0010?\u001a\u0008\u0012\u0004\u0012\u00020/0@2\u0014\u0008\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\n0\u0015H\u0007¢\u0006\u0002\u0010B\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006C", d2 = {"BottomSheetScaffoldPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffoldVelocityThreshold", "FabSpacing", "BottomSheet", "", "state", "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-dAqlCkY", "(Landroidx/compose/material/BottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "BottomSheetScaffoldLayout-HJHHjMs", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;ILandroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BottomSheetScaffoldKt {

    private static final float BottomSheetScaffoldPositionalThreshold;
    private static final float BottomSheetScaffoldVelocityThreshold;
    private static final float FabSpacing;
    static {
        int i4 = 0;
        BottomSheetScaffoldKt.FabSpacing = Dp.constructor-impl((float)i);
        int i5 = 0;
        BottomSheetScaffoldKt.BottomSheetScaffoldPositionalThreshold = Dp.constructor-impl((float)i2);
        int i6 = 0;
        BottomSheetScaffoldKt.BottomSheetScaffoldVelocityThreshold = Dp.constructor-impl((float)i3);
    }

    private static final void BottomSheet-dAqlCkY(androidx.compose.material.BottomSheetState state, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        int i8;
        float $this$BottomSheet_dAqlCkY_u24lambda_u243;
        Object composer$iv;
        boolean traceInProgress2;
        int $dirty;
        Object modifier2;
        int i9;
        boolean z;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        boolean traceInProgress;
        Object compositionCoroutineScope;
        long l;
        int i13;
        Object obj;
        Object empty2;
        int i15;
        int i19;
        float f;
        int i3;
        Object it$iv;
        int i4;
        int i11;
        int i18;
        int i6;
        int str;
        Object rememberedValue;
        Object obj3;
        long semantics$default;
        Object empty;
        Modifier modifier3;
        Object anon;
        int i16;
        boolean i;
        Composer composer;
        Composer composer$iv2;
        int i5;
        int companion;
        Object obj2;
        int i10;
        Object obj4;
        Function2 function2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i17;
        int i14;
        int i7;
        int i2;
        final Object obj5 = state;
        rememberedValue = content;
        final Object obj7 = $changed;
        final int i63 = obj39;
        final int i64 = obj40;
        traceInProgress2 = i12.startRestartGroup(-412323066);
        ComposerKt.sourceInformation(traceInProgress2, "C(BottomSheet)P(8,5,7,4:c#ui.unit.Dp,2:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.unit.Dp,1)408@16519L24,*409@16585L7,415@16779L792,436@17795L893,461@18852L29,410@16625L2262:BottomSheetScaffold.kt#jmzs0o");
        $dirty = obj39;
        if (i64 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i63 & 6 == 0) {
                i9 = traceInProgress2.changed(obj5) ? 4 : 2;
                $dirty |= i9;
            }
        }
        if (i64 & 2 != 0) {
            $dirty |= 48;
            z = sheetGesturesEnabled;
        } else {
            if (i63 & 48 == 0) {
                i13 = traceInProgress2.changed(sheetGesturesEnabled) ? 32 : 16;
                $dirty |= i13;
            } else {
                z = sheetGesturesEnabled;
            }
        }
        if (i64 & 4 != 0) {
            $dirty |= 384;
            obj = sheetShape;
        } else {
            if (i63 & 384 == 0) {
                i19 = traceInProgress2.changed(sheetShape) ? 256 : 128;
                $dirty |= i19;
            } else {
                obj = sheetShape;
            }
        }
        if (i64 & 8 != 0) {
            $dirty |= 3072;
            f = sheetElevation;
        } else {
            if (i63 & 3072 == 0) {
                i4 = traceInProgress2.changed(sheetElevation) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                f = sheetElevation;
            }
        }
        if (i64 & 16 != 0) {
            $dirty |= 24576;
            semantics$default = sheetBackgroundColor;
        } else {
            if (i63 & 24576 == 0) {
                i11 = traceInProgress2.changed(sheetBackgroundColor) ? 16384 : 8192;
                $dirty |= i11;
            } else {
                semantics$default = sheetBackgroundColor;
            }
        }
        int i59 = 196608;
        if (i64 & 32 != 0) {
            $dirty |= i59;
            l = sheetPeekHeight;
        } else {
            if (i63 & i59 == 0) {
                i18 = traceInProgress2.changed(sheetPeekHeight) ? 131072 : 65536;
                $dirty |= i18;
            } else {
                l = sheetPeekHeight;
            }
        }
        int i60 = 1572864;
        if (i64 & 64 != 0) {
            $dirty |= i60;
        } else {
            if (i63 & i60 == 0) {
                i6 = traceInProgress2.changed(rememberedValue) ? 1048576 : 524288;
                $dirty |= i6;
            }
        }
        str = i64 & 128;
        i16 = 12582912;
        if (str != null) {
            $dirty |= i16;
            i17 = i60;
            obj3 = $composer;
        } else {
            if (i63 & i16 == 0) {
                i17 = i60;
                i16 = traceInProgress2.changed($composer) ? 8388608 : 4194304;
                $dirty |= i16;
            } else {
                i17 = i60;
                obj3 = $composer;
            }
        }
        i = 100663296;
        if (i64 & 256 != 0) {
            $dirty |= i;
        } else {
            if (i63 & i == 0) {
                i8 = traceInProgress2.changedInstance(obj7) ? 67108864 : 33554432;
                $dirty |= i8;
            }
        }
        $this$BottomSheet_dAqlCkY_u24lambda_u243 = $dirty;
        if ($dirty3 &= $this$BottomSheet_dAqlCkY_u24lambda_u243 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                if (str != null) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-412323066, $this$BottomSheet_dAqlCkY_u24lambda_u243, -1, "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:407)");
                }
                int i53 = i23;
                int i61 = 0;
                i2 = $this$BottomSheet_dAqlCkY_u24lambda_u243;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                Composer composer2 = traceInProgress2;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, -954363344, "CC(remember):Effects.kt#9igjgp");
                Composer composer3 = traceInProgress2;
                int i65 = i26;
                compositionCoroutineScope = composer3.rememberedValue();
                int i67 = 0;
                companion = i35;
                if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    int i71 = 0;
                    obj4 = compositionCoroutineScope;
                    composer$iv2 = composer2;
                    composer$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer2));
                    composer3.updateRememberedValue(composer$iv);
                } else {
                    composer$iv2 = composer2;
                    composer$iv = obj4;
                }
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                coroutineScope = (CompositionScopedCoroutineScopeCanceller)composer$iv.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                int i27 = 0;
                int i36 = 0;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                int i28 = 0;
                $this$BottomSheet_dAqlCkY_u24lambda_u243 = (Density)traceInProgress2.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(rememberedValue);
                String str5 = "CC(remember):BottomSheetScaffold.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, -1416603834, str5);
                i3 = i2 & 14 == 4 ? 1 : 0;
                Composer composer5 = traceInProgress2;
                int i66 = 0;
                it$iv = composer5.rememberedValue();
                int i69 = 0;
                if (z2 | i3 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        rememberedValue = 0;
                        obj2 = it$iv;
                        it$iv = new BottomSheetScaffoldKt.BottomSheet.1.1(obj5, $this$BottomSheet_dAqlCkY_u24lambda_u243);
                        composer5.updateRememberedValue((Function2)it$iv);
                    } else {
                        obj2 = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                i5 = 0;
                i = sheetGesturesEnabled;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, -1416571221, str5);
                i15 = i2 & 14 == 4 ? 1 : 0;
                Composer composer4 = traceInProgress2;
                int i58 = 0;
                rememberedValue = composer4.rememberedValue();
                int i62 = 0;
                if (i15 |= changedInstance2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new BottomSheetScaffoldKt.BottomSheet.2.1(obj5, coroutineScope);
                        composer4.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                str = 1;
                BottomSheetScaffoldKt.BottomSheet.3 anon2 = new BottomSheetScaffoldKt.BottomSheet.3(obj7);
                i17 = traceInProgress2;
                SurfaceKt.Surface-F-jzlyU(SemanticsModifierKt.semantics$default(AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(modifier2, obj5.getAnchoredDraggableState$material_release(), Orientation.Vertical, (Function2)it$iv), obj5.getAnchoredDraggableState$material_release(), Orientation.Vertical, i, false, i5, false, 56, 0), false, (Function1)anon, str, 0), sheetShape, sheetBackgroundColor, i, sheetPeekHeight, i5, 0, sheetElevation, (Function2)ComposableLambdaKt.rememberComposableLambda(2055704138, str, anon2, traceInProgress2, 54), i17);
                composer = i17;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = modifier2;
            } else {
                traceInProgress2.skipToGroupEnd();
                i2 = $this$BottomSheet_dAqlCkY_u24lambda_u243;
                composer = traceInProgress2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $this$BottomSheet_dAqlCkY_u24lambda_u243 = new BottomSheetScaffoldKt.BottomSheet.4(obj5, sheetGesturesEnabled, sheetShape, sheetElevation, sheetBackgroundColor, obj, sheetPeekHeight, str, content, obj3, obj7, i63, i64);
            endRestartGroup.updateScope((Function2)$this$BottomSheet_dAqlCkY_u24lambda_u243);
        }
    }

    public static final void BottomSheetScaffold-HnlDQGw(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, Modifier modifier, androidx.compose.material.BottomSheetScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super androidx.compose.material.SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, int floatingActionButtonPosition, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, long backgroundColor, long contentColor, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj8;
        float f;
        int $dirty19;
        float function3;
        int changed3;
        long l;
        Object obj4;
        int skipping;
        int i10;
        int i22;
        int $dirty12;
        int defaultsInvalid;
        int rememberBottomSheetScaffoldState;
        Object topBar3;
        float sheetPeekHeight3;
        int sheetPeekHeight4;
        androidx.compose.foundation.shape.CornerBasedShape $dirty18;
        Object endRestartGroup;
        int $dirty14;
        int $dirty110;
        int i7;
        int i9;
        int colors;
        int $dirty13;
        float $dirty1;
        Object obj;
        Object $composer2;
        int $dirty5;
        long $dirty2;
        long $dirty4;
        Object $dirty;
        long $dirty17;
        long l3;
        long l2;
        Object sheetPeekHeight2;
        Object obj2;
        int i21;
        Object $dirty3;
        Object sheetShape3;
        androidx.compose.foundation.shape.CornerBasedShape sheetShape2;
        int topBar2;
        Object obj3;
        boolean snackbarHost2;
        int i8;
        int i25;
        int i24;
        long composer;
        int sheetBackgroundColor3;
        androidx.compose.foundation.shape.CornerBasedShape $dirty15;
        Object obj6;
        float floatingActionButton2;
        int i;
        long floatingActionButtonPosition2;
        Object obj5;
        int i2;
        Object obj7;
        long scaffoldState2;
        int sheetElevation2;
        boolean z;
        float sheetGesturesEnabled2;
        int changed7;
        int surface-0d7_KjU;
        long sheetContentColor2;
        long sheetBackgroundColor2;
        int changed;
        int i11;
        long contentColor2;
        long l4;
        int i12;
        int i6;
        int i14;
        int i5;
        boolean changed2;
        int $dirty16;
        int i18;
        int i16;
        Composer composer2;
        int i3;
        int i17;
        int i26;
        int i23;
        int i19;
        int i4;
        int i13;
        int i15;
        int changed5;
        int changed6;
        int changed4;
        ScopeUpdateScope scopeUpdateScope;
        Object obj34;
        int obj35;
        Object obj36;
        float obj37;
        int obj38;
        int obj39;
        int obj40;
        int obj41;
        androidx.compose.foundation.shape.CornerBasedShape obj42;
        Composer obj43;
        int obj44;
        int obj45;
        androidx.compose.foundation.shape.CornerBasedShape obj46;
        Object obj48;
        Object obj49;
        int obj53;
        int i27 = obj54;
        i7 = obj55;
        int i54 = obj56;
        Composer restartGroup = obj53.startRestartGroup(-423121424);
        ComposerKt.sourceInformation(restartGroup, "C(BottomSheetScaffold)P(8,5,6,15,14,3,4:c#material.FabPosition,11,13,10:c#ui.unit.Dp,7:c#ui.graphics.Color,9:c#ui.graphics.Color,12:c#ui.unit.Dp,0:c#ui.graphics.Color,2:c#ui.graphics.Color)333@13308L34,339@13677L6,341@13808L6,342@13855L37,344@14008L6,345@14053L32,353@14273L1864,348@14144L1993:BottomSheetScaffold.kt#jmzs0o");
        $dirty5 = obj54;
        int i61 = obj55;
        if (i54 & 1 != 0) {
            $dirty5 |= 6;
            obj2 = sheetContent;
        } else {
            if (i27 & 6 == 0) {
                i8 = restartGroup.changedInstance(sheetContent) ? 4 : 2;
                $dirty5 |= i8;
            } else {
                obj2 = sheetContent;
            }
        }
        i24 = i54 & 2;
        if (i24 != 0) {
            $dirty5 |= 48;
            obj5 = modifier;
        } else {
            if (i27 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty5 |= i2;
            } else {
                obj5 = modifier;
            }
        }
        if (i27 & 384 == 0) {
            if (i54 & 4 == 0) {
                changed7 = restartGroup.changed(scaffoldState) ? 256 : 128;
            } else {
                obj7 = scaffoldState;
            }
            $dirty5 |= changed7;
        } else {
            obj7 = scaffoldState;
        }
        surface-0d7_KjU = i54 & 8;
        int i75 = 1024;
        if (surface-0d7_KjU != 0) {
            $dirty5 |= 3072;
            sheetShape3 = topBar;
        } else {
            if (i27 & 3072 == 0) {
                i12 = restartGroup.changedInstance(topBar) ? changed : i75;
                $dirty5 |= i12;
            } else {
                sheetShape3 = topBar;
            }
        }
        int i76 = i54 & 16;
        i14 = 8192;
        if (i76 != 0) {
            $dirty5 |= 24576;
            obj3 = snackbarHost;
        } else {
            if (i27 & 24576 == 0) {
                i18 = restartGroup.changedInstance(snackbarHost) ? i6 : i14;
                $dirty5 |= i18;
            } else {
                obj3 = snackbarHost;
            }
        }
        i16 = i54 & 32;
        int i77 = 196608;
        if (i16 != 0) {
            $dirty5 |= i77;
            obj6 = floatingActionButton;
        } else {
            if (i27 & i77 == 0) {
                i26 = restartGroup.changedInstance(floatingActionButton) ? 131072 : 65536;
                $dirty5 |= i26;
            } else {
                obj6 = floatingActionButton;
            }
        }
        int i80 = i54 & 64;
        final int i81 = 1572864;
        if (i80 != 0) {
            $dirty5 |= i81;
            i = floatingActionButtonPosition;
        } else {
            if (i27 & i81 == 0) {
                i4 = restartGroup.changed(floatingActionButtonPosition) ? 1048576 : 524288;
                $dirty5 |= i4;
            } else {
                i = floatingActionButtonPosition;
            }
        }
        sheetElevation2 = i54 & 128;
        i13 = 12582912;
        if (sheetElevation2 != 0) {
            $dirty5 |= i13;
            z = sheetGesturesEnabled;
        } else {
            if (i27 & i13 == 0) {
                i15 = restartGroup.changed(sheetGesturesEnabled) ? 8388608 : 4194304;
                $dirty5 |= i15;
            } else {
                z = sheetGesturesEnabled;
            }
        }
        if (i27 & i82 == 0) {
            if (i54 & 256 == 0) {
                changed5 = restartGroup.changed(sheetShape) ? 67108864 : 33554432;
            } else {
                obj8 = sheetShape;
            }
            $dirty5 |= changed5;
        } else {
            obj8 = sheetShape;
        }
        if (obj54 & i83 == 0) {
            if (i54 & 512 == 0) {
                changed6 = restartGroup.changed(sheetElevation) ? 536870912 : 268435456;
            } else {
                f = sheetElevation;
            }
            $dirty5 |= changed6;
        } else {
            f = sheetElevation;
        }
        if (i7 & 6 == 0) {
            if (i54 & 1024 == 0) {
                $dirty110 = i61;
                i5 = restartGroup.changed(sheetBackgroundColor) ? 4 : 2;
            } else {
                $dirty110 = i61;
                $dirty17 = sheetBackgroundColor;
            }
            $dirty110 |= i5;
        } else {
            $dirty19 = i61;
            $dirty17 = sheetBackgroundColor;
        }
        if (i7 & 48 == 0) {
            if (i54 & 2048 == 0) {
                i3 = restartGroup.changed(sheetPeekHeight) ? 32 : 16;
            } else {
                l3 = sheetPeekHeight;
            }
            $dirty19 = obj53 | i3;
        } else {
            l3 = sheetPeekHeight;
            obj53 = $dirty19;
        }
        obj53 = $dirty19;
        if (i7 & 384 == 0) {
            if (i54 & 4096 == 0) {
                i4 = restartGroup.changed(contentColor) ? 256 : 128;
            } else {
                function3 = contentColor;
            }
            $dirty16 = obj53 | i4;
        } else {
            function3 = contentColor;
            $dirty16 = obj53;
        }
        if (i7 & 3072 == 0) {
            if (i54 & 8192 == 0) {
                if (restartGroup.changed(content)) {
                } else {
                    changed = i75;
                }
            } else {
                l2 = content;
            }
            $dirty16 |= changed;
        } else {
            l2 = content;
        }
        if (i7 & 24576 == 0) {
            if (i54 & 16384 == 0) {
                if (restartGroup.changed($changed)) {
                } else {
                    i6 = i14;
                }
            } else {
                l = $changed;
            }
            $dirty16 |= i6;
        } else {
            l = $changed;
        }
        if (i54 & i74 != 0) {
            $dirty16 |= i77;
            obj4 = i20;
        } else {
            if (obj55 & i77 == 0) {
                i7 = restartGroup.changedInstance(i20) ? 131072 : 65536;
                $dirty16 |= i7;
            } else {
                obj4 = i20;
            }
        }
        if (i46 &= $dirty5 == 306783378 && $dirty16 & i43 == 74898) {
            if ($dirty16 & i43 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i47 = 0;
                    if (obj54 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i24 != 0) {
                                obj5 = defaultsInvalid;
                            }
                            if (i54 & 4 != 0) {
                                $dirty5 &= -897;
                                obj7 = rememberBottomSheetScaffoldState;
                            }
                            topBar3 = surface-0d7_KjU != 0 ? 0 : sheetShape3;
                            if (i76 != 0) {
                                obj3 = sheetShape3;
                            }
                            if (i16 != 0) {
                                obj6 = sheetShape3;
                            }
                            if (i80 != 0) {
                                i = sheetShape3;
                            }
                            if (sheetElevation2 != 0) {
                                z = sheetShape3;
                            }
                            int i69 = 6;
                            if (i54 & 256 != 0) {
                                sheetShape2 = MaterialTheme.INSTANCE.getShapes(restartGroup, i69).getLarge();
                                $dirty5 &= sheetElevation2;
                            } else {
                                sheetShape2 = sheetShape;
                            }
                            if (i54 & 512 != 0) {
                                sheetElevation2 = BottomSheetScaffoldDefaults.INSTANCE.getSheetElevation-D9Ej5fM();
                                $dirty5 &= surface-0d7_KjU;
                            } else {
                                sheetElevation2 = sheetElevation;
                            }
                            if (i54 & 1024 != 0) {
                                $dirty16 &= -15;
                                obj34 = obj6;
                                composer = surface-0d7_KjU;
                            } else {
                                obj34 = obj6;
                                composer = sheetBackgroundColor;
                            }
                            if (i54 & 2048 != 0) {
                                sheetContentColor2 = ColorsKt.contentColorFor-ek8zF_U(composer, obj6, restartGroup);
                                $dirty13 = $dirty16;
                            } else {
                                sheetContentColor2 = sheetPeekHeight;
                                $dirty13 = $dirty16;
                            }
                            obj36 = topBar3;
                            if (i54 & 4096 != 0) {
                                sheetPeekHeight3 = BottomSheetScaffoldDefaults.INSTANCE.getSheetPeekHeight-D9Ej5fM();
                                $dirty13 &= -897;
                            } else {
                                sheetPeekHeight3 = contentColor;
                            }
                            obj37 = sheetPeekHeight3;
                            if (i54 & 8192 != 0) {
                                obj38 = $dirty5;
                                $dirty2 = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getBackground-0d7_KjU();
                                $dirty13 &= -7169;
                            } else {
                                obj38 = $dirty5;
                                $dirty2 = l2;
                            }
                            if (i54 & 16384 != 0) {
                                $dirty1 = obj37;
                                i21 = obj38;
                                i6 = contentColorFor-ek8zF_U;
                                contentColor2 = $dirty2;
                                $dirty4 = composer;
                                obj6 = obj34;
                                sheetBackgroundColor3 = i39;
                                $dirty18 = sheetShape2;
                                sheetShape3 = obj36;
                            } else {
                                i21 = obj38;
                                i6 = $changed;
                                contentColor2 = $dirty2;
                                $dirty18 = sheetShape2;
                                $dirty4 = composer;
                                obj6 = obj34;
                                sheetShape3 = obj36;
                                sheetBackgroundColor3 = $dirty13;
                                $dirty1 = obj37;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i54 & 4 != 0) {
                                $dirty5 &= -897;
                            }
                            if (i54 & 256 != 0) {
                                $dirty5 &= i10;
                            }
                            if (i54 & 512 != 0) {
                                $dirty5 &= i22;
                            }
                            if (i54 & 1024 != 0) {
                                $dirty16 &= -15;
                            }
                            if (i54 & 2048 != 0) {
                                $dirty16 &= -113;
                            }
                            if (i54 & 4096 != 0) {
                                $dirty12 &= -897;
                            }
                            if (i54 & 8192 != 0) {
                                $dirty12 &= -7169;
                            }
                            if (i54 & 16384 != 0) {
                                $dirty12 &= i25;
                            }
                            sheetElevation2 = sheetElevation;
                            sheetContentColor2 = sheetPeekHeight;
                            $dirty1 = contentColor;
                            i6 = $changed;
                            sheetBackgroundColor3 = $dirty12;
                            contentColor2 = l2;
                            $dirty18 = sheetShape;
                            i21 = $dirty5;
                            $dirty4 = sheetBackgroundColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj42 = $dirty18;
                        obj38 = $dirty1;
                        ComposerKt.traceEventStart(-423121424, i21, sheetBackgroundColor3, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:347)");
                    } else {
                        obj42 = $dirty18;
                        obj38 = $dirty1;
                    }
                    int i50 = 1;
                    obj44 = $dirty4;
                    obj37 = obj6;
                    obj39 = i;
                    obj46 = sheetContentColor2;
                    super(obj7, sheetShape3, obj37, obj38, obj39, i20, z, obj42, sheetElevation2, obj44, sheetPeekHeight, obj46, contentColor, sheetContent, obj3);
                    obj43 = restartGroup;
                    obj36 = contentColor2;
                    obj38 = i6;
                    SurfaceKt.Surface-F-jzlyU(SizeKt.fillMaxSize$default(obj5, 0, i50, 0), 0, obj36, obj37, obj38, obj39, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-131096268, i50, anon, restartGroup, 54), obj43);
                    l4 = obj38;
                    composer2 = obj43;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sheetGesturesEnabled2 = f2;
                    sheetPeekHeight2 = obj3;
                    snackbarHost2 = z2;
                    i17 = i21;
                    $dirty = sheetShape3;
                    i23 = sheetBackgroundColor3;
                    $dirty3 = obj6;
                    topBar2 = i;
                    obj = obj5;
                    $composer2 = obj7;
                    floatingActionButton2 = sheetElevation2;
                    floatingActionButtonPosition2 = l5;
                    scaffoldState2 = $dirty16;
                    $dirty15 = obj46;
                    sheetBackgroundColor2 = skipping;
                } else {
                    restartGroup.skipToGroupEnd();
                    $dirty15 = sheetShape;
                    l4 = $changed;
                    composer2 = restartGroup;
                    i17 = $dirty5;
                    sheetBackgroundColor2 = l2;
                    $dirty = sheetShape3;
                    sheetPeekHeight2 = obj3;
                    $dirty3 = obj6;
                    topBar2 = i;
                    obj = obj5;
                    $composer2 = obj7;
                    snackbarHost2 = z;
                    i23 = $dirty16;
                    floatingActionButton2 = sheetElevation;
                    floatingActionButtonPosition2 = sheetBackgroundColor;
                    scaffoldState2 = sheetPeekHeight;
                    sheetGesturesEnabled2 = contentColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BottomSheetScaffoldKt.BottomSheetScaffold.2(sheetContent, obj, $composer2, $dirty, sheetPeekHeight2, $dirty3, topBar2, snackbarHost2, $dirty15, floatingActionButton2, floatingActionButtonPosition2, obj5, scaffoldState2, sheetElevation2, sheetGesturesEnabled2, sheetBackgroundColor2, i11, l4, i76, i20, obj54, obj55, obj56);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void BottomSheetScaffoldLayout-HJHHjMs(Function2<? super Composer, ? super Integer, Unit> topBar, Function2<? super Composer, ? super Integer, Unit> body, Function2<? super Composer, ? super Integer, Unit> bottomSheet, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, Function2<? super Composer, ? super Integer, Unit> snackbarHost, float sheetPeekHeight, Function0<Float> sheetOffset, int floatingActionButtonPosition, androidx.compose.material.BottomSheetState sheetState, Composer $composer, int $changed) {
        Object it$iv;
        boolean traceInProgress2;
        int valueOf;
        Object $i$a$CacheLayoutKt$Layout$3$iv;
        Object empty;
        int i10;
        Function0 factory$iv$iv$iv;
        boolean changed;
        Object setCompositeKeyHash;
        int i15;
        Composer obj;
        Object currentCompositionLocalMap;
        Object constructor-impl;
        int $dirty;
        int i3;
        int i21;
        int i;
        int i17;
        int i20;
        int i2;
        int i11;
        int i9;
        int i14;
        int skipping;
        boolean traceInProgress;
        Object lambda-2$material_release;
        int i22;
        int i18;
        int i4;
        int i8;
        androidx.compose.ui.Modifier.Companion companion2;
        int combineAsVirtualLayouts;
        Object lambda-3$material_release;
        int i16;
        int i12;
        java.util.List list;
        int i5;
        Object companion;
        Composer.Companion companion3;
        int $changed$iv;
        int i6;
        int i7;
        int i13;
        Function0 function0;
        Composer composer;
        int i19;
        Object measurePolicy$iv$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffoldLayout.1.1 obj39;
        valueOf = topBar;
        setCompositeKeyHash = body;
        obj = bottomSheet;
        constructor-impl = floatingActionButton;
        final Object obj2 = snackbarHost;
        final float f = sheetPeekHeight;
        final Object obj3 = sheetOffset;
        final int i34 = floatingActionButtonPosition;
        final Object obj4 = sheetState;
        final int i35 = $changed;
        traceInProgress2 = 1411837005;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,4,3:c#material.FabPosition)509@20078L2668,501@19867L2879:BottomSheetScaffold.kt#jmzs0o");
        if (i35 & 6 == 0) {
            i3 = restartGroup.changedInstance(valueOf) ? 4 : 2;
            $dirty |= i3;
        }
        if (i35 & 48 == 0) {
            i21 = restartGroup.changedInstance(setCompositeKeyHash) ? 32 : 16;
            $dirty |= i21;
        }
        if (i35 & 384 == 0) {
            i = restartGroup.changedInstance(obj) ? 256 : 128;
            $dirty |= i;
        }
        if (i35 & 3072 == 0) {
            i17 = restartGroup.changedInstance(constructor-impl) ? 2048 : 1024;
            $dirty |= i17;
        }
        if (i35 & 24576 == 0) {
            i20 = restartGroup.changedInstance(obj2) ? 16384 : 8192;
            $dirty |= i20;
        }
        if (i36 &= i35 == 0) {
            i2 = restartGroup.changed(f) ? 131072 : 65536;
            $dirty |= i2;
        }
        companion2 = 1048576;
        if (i37 &= i35 == 0) {
            i11 = restartGroup.changedInstance(obj3) ? companion2 : 524288;
            $dirty |= i11;
        }
        if (i38 &= i35 == 0) {
            i9 = restartGroup.changed(i34) ? 8388608 : 4194304;
            $dirty |= i9;
        }
        if (i39 &= i35 == 0) {
            i14 = restartGroup.changed(obj4) ? 67108864 : 33554432;
            $dirty |= i14;
        }
        if (i40 &= $dirty == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:500)");
                }
                Function2[] arr = new Function2[5];
                if (valueOf == null) {
                    lambda-2$material_release = ComposableSingletons.BottomSheetScaffoldKt.INSTANCE.getLambda-2$material_release();
                } else {
                    lambda-2$material_release = valueOf;
                }
                int i55 = 0;
                arr[i55] = lambda-2$material_release;
                arr[1] = setCompositeKeyHash;
                arr[2] = obj;
                if (constructor-impl == null) {
                    lambda-3$material_release = ComposableSingletons.BottomSheetScaffoldKt.INSTANCE.getLambda-3$material_release();
                } else {
                    lambda-3$material_release = constructor-impl;
                }
                arr[3] = lambda-3$material_release;
                arr[4] = obj2;
                int i60 = i55;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 539800922, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                i22 = i43 &= $dirty == companion2 ? 1 : i60;
                i18 = i48 &= $dirty == 8388608 ? 1 : i60;
                i4 = i50 &= $dirty == 131072 ? 1 : i60;
                i8 = i52 &= $dirty == 67108864 ? 1 : i60;
                Composer composer3 = restartGroup;
                int i59 = 0;
                it$iv = composer3.rememberedValue();
                int i62 = 0;
                if (i46 |= i8 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        valueOf = 0;
                        companion = it$iv;
                        it$iv = new BottomSheetScaffoldKt.BottomSheetScaffoldLayout.1.1(obj3, i34, f, obj4);
                        composer3.updateRememberedValue((MultiContentMeasurePolicy)it$iv);
                    } else {
                        companion = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                empty = i60;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -290761997, "CC(remember):Layout.kt#9igjgp");
                if (i29 ^= 384 > 256) {
                    if (!restartGroup.changed((MultiContentMeasurePolicy)it$iv)) {
                        i10 = empty & 384 == 256 ? 1 : i60;
                    } else {
                    }
                } else {
                }
                Composer composer2 = restartGroup;
                int i61 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i63 = 0;
                if (i10 == 0) {
                    $changed$iv = empty;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int $changed$iv2 = 0;
                        composer2.updateRememberedValue(MultiContentMeasurePolicyKt.createMeasurePolicy(it$iv));
                    } else {
                        $i$a$CacheLayoutKt$Layout$3$iv = rememberedValue;
                    }
                } else {
                    $changed$iv = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                i16 = currentCompositeKeyHash;
                companion3 = i30;
                Function0 function02 = constructor;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                constructor-impl = Updater.constructor-impl(restartGroup);
                i6 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)$i$a$CacheLayoutKt$Layout$3$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i13 = 0;
                composer = constructor-impl;
                i19 = 0;
                if (!composer.getInserting()) {
                    measurePolicy$iv$iv = $i$a$CacheLayoutKt$Layout$3$iv;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i16))) {
                        composer.updateRememberedValue(Integer.valueOf(i16));
                        constructor-impl.apply(Integer.valueOf(i16), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        obj = composer;
                    }
                } else {
                    measurePolicy$iv$iv = $i$a$CacheLayoutKt$Layout$3$iv;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)Modifier.Companion), ComposeUiNode.Companion.getSetModifier());
                LayoutKt.combineAsVirtualLayouts(CollectionsKt.listOf(arr)).invoke(restartGroup, Integer.valueOf(i26 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
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
            traceInProgress2 = new BottomSheetScaffoldKt.BottomSheetScaffoldLayout.2(topBar, body, bottomSheet, floatingActionButton, obj2, f, obj3, i34, obj4, i35);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(androidx.compose.material.AnchoredDraggableState<?> state, Orientation orientation) {
        BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1 anon = new BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1(state, orientation);
        return (NestedScrollConnection)anon;
    }

    public static final void access$BottomSheet-dAqlCkY(androidx.compose.material.BottomSheetState state, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, Modifier modifier, Function3 content, Composer $composer, int $changed, int $default) {
        BottomSheetScaffoldKt.BottomSheet-dAqlCkY(state, sheetGesturesEnabled, sheetShape, sheetElevation, sheetBackgroundColor, sheetContentColor, sheetPeekHeight, modifier, content, $composer, $changed, $default);
    }

    public static final void access$BottomSheetScaffoldLayout-HJHHjMs(Function2 topBar, Function2 body, Function2 bottomSheet, Function2 floatingActionButton, Function2 snackbarHost, float sheetPeekHeight, Function0 sheetOffset, int floatingActionButtonPosition, androidx.compose.material.BottomSheetState sheetState, Composer $composer, int $changed) {
        BottomSheetScaffoldKt.BottomSheetScaffoldLayout-HJHHjMs(topBar, body, bottomSheet, floatingActionButton, snackbarHost, sheetPeekHeight, sheetOffset, floatingActionButtonPosition, sheetState, $composer, $changed);
    }

    public static final NestedScrollConnection access$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(androidx.compose.material.AnchoredDraggableState state, Orientation orientation) {
        return BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(state, orientation);
    }

    public static final float access$getBottomSheetScaffoldPositionalThreshold$p() {
        return BottomSheetScaffoldKt.BottomSheetScaffoldPositionalThreshold;
    }

    public static final float access$getBottomSheetScaffoldVelocityThreshold$p() {
        return BottomSheetScaffoldKt.BottomSheetScaffoldVelocityThreshold;
    }

    public static final float access$getFabSpacing$p() {
        return BottomSheetScaffoldKt.FabSpacing;
    }

    public static final androidx.compose.material.BottomSheetScaffoldState rememberBottomSheetScaffoldState(androidx.compose.material.BottomSheetState bottomSheetState, androidx.compose.material.SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i5) {
        int changed;
        int str;
        androidx.compose.material.BottomSheetValue collapsed;
        int rememberedValue;
        int i;
        Object bottomSheetScaffoldState;
        Composer $composer2;
        int empty;
        int snackbarHostState2;
        androidx.compose.material.BottomSheetState obj8;
        Object obj9;
        int obj10;
        int obj12;
        int i2 = -1022285988;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberBottomSheetScaffoldState)274@9912L35,275@9992L32,277@10066L196:BottomSheetScaffold.kt#jmzs0o");
        if (i5 & 1 != 0) {
            obj8 = BottomSheetScaffoldKt.rememberBottomSheetState(BottomSheetValue.Collapsed, 0, 0, $composer, 6, 6);
        } else {
            $composer2 = $composer;
        }
        obj12 = "CC(remember):BottomSheetScaffold.kt#9igjgp";
        if (i5 & 2 != 0) {
            ComposerKt.sourceInformationMarkerStart($composer2, 200088250, obj12);
            obj10 = 0;
            str = $composer2;
            collapsed = 0;
            rememberedValue = str.rememberedValue();
            i = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                snackbarHostState2 = new SnackbarHostState();
                str.updateRememberedValue(snackbarHostState2);
            } else {
                snackbarHostState2 = rememberedValue;
            }
            obj9 = snackbarHostState2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:276)");
        }
        ComposerKt.sourceInformationMarkerStart($composer2, 200090782, obj12);
        int i3 = 4;
        int i7 = 1;
        if (obj10 ^= 6 > i3) {
            if (!$composer2.changed(obj8)) {
                obj10 = $changed & 6 == i3 ? i7 : obj12;
            } else {
            }
        } else {
        }
        int i8 = 32;
        if (i4 ^= 48 > i8) {
            if (!$composer2.changed(obj9)) {
                if ($changed & 48 == i8) {
                    obj12 = i7;
                }
            } else {
            }
        } else {
        }
        obj12 = $composer2;
        int i6 = 0;
        Object rememberedValue2 = obj12.rememberedValue();
        int i9 = 0;
        if (obj10 |= obj12 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue = 0;
                bottomSheetScaffoldState = new BottomSheetScaffoldState(obj8, obj9);
                obj12.updateRememberedValue(bottomSheetScaffoldState);
            } else {
                bottomSheetScaffoldState = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return (BottomSheetScaffoldState)bottomSheetScaffoldState;
    }

    public static final androidx.compose.material.BottomSheetState rememberBottomSheetState(androidx.compose.material.BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.BottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i6) {
        int i2;
        boolean changed2;
        int iNSTANCE;
        boolean changed;
        String str;
        int i;
        Object empty;
        Object anon;
        AnimationSpec obj10;
        androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.1 obj11;
        int obj14;
        int i3 = 1808153344;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberBottomSheetState)P(2)236@8776L7,244@9018L210,237@8795L433:BottomSheetScaffold.kt#jmzs0o");
        if (i6 & 2 != 0) {
            obj10 = BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        int i11 = 4;
        if (i6 &= i11 != 0) {
            obj11 = obj14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:235)");
        }
        int i4 = 0;
        int i13 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        obj14 = consume;
        ComposerKt.sourceInformationMarkerStart($composer, -1916212862, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        int i17 = 1;
        if (i7 ^= 6 > i11) {
            if (!$composer.changed(initialValue)) {
                i2 = $changed & 6 == i11 ? i17 : i;
            } else {
            }
        } else {
        }
        int i18 = 256;
        if (i12 ^= 384 > i18) {
            if (!$composer.changed(obj11)) {
                if ($changed & 384 == i18) {
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
        if (i9 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new BottomSheetScaffoldKt.rememberBottomSheetState.2.1(initialValue, obj14, obj10, obj11);
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
        return (BottomSheetState)RememberSaveableKt.rememberSaveable(/* result */, BottomSheetState.Companion.Saver(obj10, obj11, (Density)obj14), 0, (Function0)anon, composer2, 0, 4);
    }
}
