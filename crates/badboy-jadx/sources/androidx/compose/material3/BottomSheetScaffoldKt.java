package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
@Metadata(d1 = "\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u008a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000c2\u0015\u0008\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\u0008\u00052\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\u0008\u00052\u0019\u0008\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u00052\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\u001a\u008e\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00082\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\u0008\u00052\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\u0008\u00052\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\u0008\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\u0008\u00052\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a\u008d\u0001\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u000c2\u0006\u00100\u001a\u00020\u000c2\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\u0008\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\u00082\u00103\u001a!\u00104\u001a\u00020\n2\u0008\u0008\u0002\u00105\u001a\u00020(2\u0008\u0008\u0002\u00106\u001a\u00020\u001bH\u0007¢\u0006\u0002\u00107\u001a7\u00108\u001a\u00020(2\u0008\u0008\u0002\u00109\u001a\u00020:2\u0014\u0008\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00180\u00032\u0008\u0008\u0002\u0010<\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010=\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006>", d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "Landroidx/compose/material3/SheetState;", "BottomSheetScaffoldLayout-2E65NiM", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "state", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BottomSheetScaffoldKt {
    public static final void BottomSheetScaffold-sdMYb0k(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, Modifier modifier, androidx.compose.material3.BottomSheetScaffoldState scaffoldState, float sheetPeekHeight, float sheetMaxWidth, Shape sheetShape, long sheetContainerColor, long sheetContentColor, float sheetTonalElevation, float sheetShadowElevation, Function2<? super Composer, ? super Integer, Unit> sheetDragHandle, boolean sheetSwipeEnabled, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super androidx.compose.material3.SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, long containerColor, long contentColor, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i21) {
        Object it$iv;
        Object obj2;
        Object endRestartGroup;
        float f;
        float i8;
        int $dirty2;
        long l5;
        int skipping;
        int i15;
        int changed2;
        int defaultsInvalid;
        androidx.compose.ui.Modifier.Companion modifier2;
        int expandedShape;
        int sheetShape3;
        int i25;
        float sheetTonalElevation2;
        int i22;
        int i27;
        int i17;
        androidx.compose.ui.Modifier.Companion companion2;
        int i23;
        int i18;
        Object obj8;
        float $composer2;
        int $dirty3;
        long $dirty5;
        boolean z;
        Object obj7;
        Object obj3;
        long l;
        long l2;
        int i2;
        Function3 function3;
        int i29;
        int iNSTANCE;
        float snackbarHost3;
        Object obj9;
        float sheetShadowElevation3;
        int i10;
        int i19;
        Object obj;
        Object obj10;
        long sheetShadowElevation2;
        float i3;
        float f2;
        long sheetMaxWidth2;
        int i7;
        Object sheetDragHandle2;
        Object obj4;
        float sheetShape2;
        long containerColor2;
        float sheetContainerColor2;
        Object obj5;
        Function2 function2;
        int i14;
        Object obj6;
        int scaffoldState2;
        int $dirty13;
        long $dirty1;
        int $dirty12;
        int i11;
        int snackbarHost2;
        Function3 function32;
        int changed;
        long sheetContentColor3;
        long sheetContentColor2;
        int changed6;
        int i5;
        int changed4;
        int i24;
        long $dirty14;
        int i16;
        int sheetSwipeEnabled2;
        int topBar2;
        long contentColorFor-ek8zF_U;
        int i30;
        int i4;
        int i9;
        int i26;
        int i;
        int companion;
        Composer composer;
        int changed3;
        int $dirty6;
        int changedInstance;
        int i6;
        int changed7;
        int $dirty;
        int $dirty4;
        int i12;
        int changed8;
        int i13;
        int i28;
        int i20;
        int changed5;
        ScopeUpdateScope scopeUpdateScope;
        long l4;
        long l3;
        androidx.compose.ui.Modifier.Companion obj39;
        float obj40;
        int obj41;
        androidx.compose.runtime.internal.ComposableLambda obj42;
        androidx.compose.runtime.internal.ComposableLambda obj43;
        androidx.compose.material3.BottomSheetScaffoldKt.BottomSheetScaffold.4.1 obj44;
        androidx.compose.material3.SheetState obj45;
        long obj46;
        long obj47;
        long obj48;
        float obj49;
        float obj50;
        int obj51;
        float obj52;
        androidx.compose.ui.Modifier.Companion obj53;
        androidx.compose.material3.SheetState obj54;
        int obj59;
        obj2 = i21;
        int i34 = obj60;
        int i43 = obj61;
        i23 = obj62;
        Composer restartGroup = obj59.startRestartGroup(-1523924135);
        ComposerKt.sourceInformation(restartGroup, "C(BottomSheetScaffold)P(6,3,4,10:c#ui.unit.Dp,9:c#ui.unit.Dp,12,5:c#ui.graphics.Color,7:c#ui.graphics.Color,14:c#ui.unit.Dp,11:c#ui.unit.Dp,8,13,16,15,0:c#ui.graphics.Color,2:c#ui.graphics.Color)112@5992L34,115@6194L13,116@6262L14,117@6309L36,124@6741L11,125@6788L31,131@6974L52,137@7329L597,132@7051L49,133@7124L50,128@6878L1054:BottomSheetScaffold.kt#uh7d8r");
        $dirty3 = obj60;
        int i76 = obj61;
        if (i23 & 1 != 0) {
            $dirty3 |= 6;
            obj10 = sheetContent;
        } else {
            if (i34 & 6 == 0) {
                i7 = restartGroup.changedInstance(sheetContent) ? 4 : 2;
                $dirty3 |= i7;
            } else {
                obj10 = sheetContent;
            }
        }
        sheetDragHandle2 = i23 & 2;
        if (sheetDragHandle2 != 0) {
            $dirty3 |= 48;
            obj5 = modifier;
        } else {
            if (i34 & 48 == 0) {
                i14 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i14;
            } else {
                obj5 = modifier;
            }
        }
        if (i34 & 384 == 0) {
            if (i23 & 4 == 0) {
                changed = restartGroup.changed(scaffoldState) ? 256 : i11;
            } else {
                obj6 = scaffoldState;
            }
            $dirty3 |= changed;
        } else {
            obj6 = scaffoldState;
        }
        int i88 = i23 & 8;
        int i91 = 1024;
        if (i88 != 0) {
            $dirty3 |= 3072;
            i3 = sheetPeekHeight;
        } else {
            if (i34 & 3072 == 0) {
                i16 = restartGroup.changed(sheetPeekHeight) ? changed6 : i91;
                $dirty3 |= i16;
            } else {
                i3 = sheetPeekHeight;
            }
        }
        sheetSwipeEnabled2 = i23 & 16;
        contentColorFor-ek8zF_U = 16384;
        if (sheetSwipeEnabled2 != 0) {
            $dirty3 |= 24576;
            f2 = sheetMaxWidth;
        } else {
            if (i34 & 24576 == 0) {
                i9 = restartGroup.changed(sheetMaxWidth) ? contentColorFor-ek8zF_U : topBar2;
                $dirty3 |= i9;
            } else {
                f2 = sheetMaxWidth;
            }
        }
        companion = 65536;
        if (i34 & i94 == 0) {
            if (i23 & 32 == 0) {
                changed3 = restartGroup.changed(sheetShape) ? 131072 : companion;
            } else {
                obj4 = sheetShape;
            }
            $dirty3 |= changed3;
        } else {
            obj4 = sheetShape;
        }
        int i95 = 1572864;
        if (i34 & i95 == 0) {
            if (i23 & 64 == 0) {
                changed7 = restartGroup.changed(sheetContainerColor) ? 1048576 : 524288;
            } else {
                containerColor2 = sheetContainerColor;
            }
            $dirty3 |= changed7;
        } else {
            containerColor2 = sheetContainerColor;
        }
        if (i34 & i96 == 0) {
            if (i23 & 128 == 0) {
                $dirty = $dirty3;
                $dirty13 = i76;
                changed8 = restartGroup.changed(sheetTonalElevation) ? 8388608 : 4194304;
            } else {
                $dirty = $dirty3;
                $dirty13 = i76;
                $dirty5 = sheetTonalElevation;
            }
            $dirty |= changed8;
        } else {
            $dirty4 = $dirty3;
            $dirty13 = i76;
            $dirty5 = sheetTonalElevation;
        }
        int i35 = i23 & 256;
        int i99 = 100663296;
        if (i35 != 0) {
            $dirty4 |= i99;
            i13 = i35;
            f = sheetDragHandle;
        } else {
            if (obj60 & i99 == 0) {
                i13 = i35;
                i28 = restartGroup.changed(sheetDragHandle) ? 67108864 : 33554432;
                $dirty4 |= i28;
            } else {
                i13 = i35;
                f = sheetDragHandle;
            }
        }
        i8 = i23 & 512;
        int i101 = 805306368;
        if (i8 != 0) {
            $dirty4 |= i101;
            i20 = i8;
        } else {
            if (obj60 & i101 == 0) {
                i20 = i8;
                changed5 = restartGroup.changed(sheetSwipeEnabled) ? 536870912 : 268435456;
                $dirty4 |= changed5;
            } else {
                i20 = i8;
                i8 = sheetSwipeEnabled;
            }
        }
        $dirty2 = $dirty4;
        int i63 = i23 & 1024;
        if (i63 != 0) {
            $dirty13 = i79;
            obj9 = topBar;
        } else {
            if (i43 & 6 == 0) {
                i30 = restartGroup.changedInstance(topBar) ? 4 : 2;
                $dirty13 |= i30;
            } else {
                obj9 = topBar;
            }
        }
        int i64 = i23 & 2048;
        if (i64 != 0) {
            $dirty13 |= 48;
            i12 = i64;
            z = snackbarHost;
        } else {
            if (i43 & 48 == 0) {
                i12 = i64;
                i26 = restartGroup.changed(snackbarHost) ? 32 : 16;
                $dirty13 |= i26;
            } else {
                i12 = i64;
                z = snackbarHost;
            }
        }
        int i65 = i23 & 4096;
        if (i65 != 0) {
            $dirty13 |= 384;
            i = i65;
            obj7 = containerColor;
        } else {
            i = i65;
            if (i43 & 384 == 0) {
                if (restartGroup.changedInstance(containerColor)) {
                    i11 = 256;
                }
                $dirty13 |= i11;
            } else {
                obj7 = containerColor;
            }
        }
        int i67 = i23 & 8192;
        if (i67 != 0) {
            $dirty13 |= 3072;
            snackbarHost2 = i67;
            obj3 = contentColor;
        } else {
            snackbarHost2 = i67;
            if (i43 & 3072 == 0) {
                if (restartGroup.changedInstance(contentColor)) {
                } else {
                    changed6 = i91;
                }
                $dirty13 |= changed6;
            } else {
                obj3 = contentColor;
            }
        }
        if (i43 & 24576 == 0) {
            if (i23 & 16384 == 0) {
                if (restartGroup.changed(content)) {
                    topBar2 = contentColorFor-ek8zF_U;
                }
            } else {
                l = content;
            }
            $dirty13 |= topBar2;
        } else {
            l = content;
        }
        int i92 = 32768;
        if (i43 & i89 == 0) {
            if (i23 & i92 == 0) {
                i5 = restartGroup.changed($changed) ? 131072 : companion;
            } else {
                l2 = $changed;
            }
            $dirty13 |= i5;
        } else {
            l2 = $changed;
        }
        if (i23 & companion != 0) {
            $dirty13 |= i95;
        } else {
            if (i43 & i95 == 0) {
                i24 = restartGroup.changedInstance(obj2) ? 1048576 : 524288;
                $dirty13 |= i24;
            }
        }
        int i90 = 306783379;
        if ($dirty2 & i90 == 306783378 && i58 &= $dirty13 == 599186) {
            if (i58 &= $dirty13 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    i29 = -458753;
                    if (obj60 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (sheetDragHandle2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i23 & 4 != 0) {
                                obj59 = i29;
                                obj39 = modifier2;
                                $dirty2 &= -897;
                                obj6 = modifier2;
                            } else {
                                obj39 = modifier2;
                                obj59 = i29;
                            }
                            if (i88 != 0) {
                                i3 = modifier2;
                            }
                            if (sheetSwipeEnabled2 != 0) {
                                f2 = modifier2;
                            }
                            int i70 = 6;
                            if (i23 & 32 != 0) {
                                $dirty2 &= obj59;
                                obj4 = expandedShape;
                            }
                            if (i23 & 64 != 0) {
                                containerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor(restartGroup, i70);
                                $dirty2 &= sheetShape3;
                            }
                            if (i23 & 128 != 0) {
                                sheetContentColor3 = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj5, restartGroup);
                                $dirty2 &= i25;
                            } else {
                                sheetContentColor3 = sheetTonalElevation;
                            }
                            if (i13 != 0) {
                                i19 = 0;
                                sheetTonalElevation2 = Dp.constructor-impl((float)i52);
                            } else {
                                sheetTonalElevation2 = sheetDragHandle;
                            }
                            if (i20 != 0) {
                                sheetShadowElevation3 = BottomSheetDefaults.INSTANCE.getElevation-D9Ej5fM();
                            } else {
                                sheetShadowElevation3 = sheetSwipeEnabled;
                            }
                            if (i63 != 0) {
                                sheetDragHandle2 = ComposableSingletons.BottomSheetScaffoldKt.INSTANCE.getLambda-1$material3_release();
                            } else {
                                sheetDragHandle2 = topBar;
                            }
                            sheetSwipeEnabled2 = i12 != 0 ? 1 : snackbarHost;
                            topBar2 = i != 0 ? 0 : containerColor;
                            if (snackbarHost2 != 0) {
                                snackbarHost2 = ComposableSingletons.BottomSheetScaffoldKt.INSTANCE.getLambda-2$material3_release();
                            } else {
                                snackbarHost2 = contentColor;
                            }
                            if (i23 & 16384 != 0) {
                                obj41 = $dirty2;
                                $dirty13 &= i42;
                                obj40 = sheetTonalElevation2;
                                l5 = contentColorFor-ek8zF_U;
                            } else {
                                obj41 = $dirty2;
                                obj40 = sheetTonalElevation2;
                                l5 = content;
                            }
                            if (i23 & i92 != 0) {
                                contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(l5, sheetTonalElevation2, restartGroup);
                                i15 = i74;
                                function3 = snackbarHost2;
                                $dirty1 = l4;
                                obj53 = obj39;
                                obj49 = obj40;
                                $dirty2 = obj41;
                            } else {
                                obj53 = obj39;
                                obj49 = obj40;
                                contentColorFor-ek8zF_U = $changed;
                                function3 = snackbarHost2;
                                $dirty2 = obj41;
                                i15 = $dirty13;
                                $dirty1 = l4;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i23 & 4 != 0) {
                                $dirty2 &= -897;
                            }
                            if (i23 & 32 != 0) {
                                $dirty2 &= i29;
                            }
                            if (i23 & 64 != 0) {
                                $dirty2 &= i22;
                            }
                            if (i23 & 128 != 0) {
                                $dirty2 &= i27;
                            }
                            if (i23 & 16384 != 0) {
                                $dirty13 &= i17;
                            }
                            if (i23 & i92 != 0) {
                                i15 = $dirty13 & i29;
                                sheetContentColor3 = sheetTonalElevation;
                                sheetShadowElevation3 = sheetSwipeEnabled;
                                sheetDragHandle2 = topBar;
                                sheetSwipeEnabled2 = snackbarHost;
                                topBar2 = containerColor;
                                function3 = contentColor;
                                $dirty1 = content;
                                contentColorFor-ek8zF_U = $changed;
                                obj53 = modifier;
                                obj49 = sheetDragHandle;
                            } else {
                                sheetContentColor3 = sheetTonalElevation;
                                sheetShadowElevation3 = sheetSwipeEnabled;
                                sheetDragHandle2 = topBar;
                                sheetSwipeEnabled2 = snackbarHost;
                                topBar2 = containerColor;
                                function3 = contentColor;
                                contentColorFor-ek8zF_U = $changed;
                                i15 = $dirty13;
                                obj53 = modifier;
                                obj49 = sheetDragHandle;
                                $dirty1 = content;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj50 = sheetShadowElevation3;
                        ComposerKt.traceEventStart(-1523924135, $dirty2, i15, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:127)");
                    } else {
                        obj50 = sheetShadowElevation3;
                    }
                    BottomSheetScaffoldKt.BottomSheetScaffold.1 anon3 = new BottomSheetScaffoldKt.BottomSheetScaffold.1(obj2, i3);
                    int i93 = i15;
                    i18 = 1;
                    obj47 = sheetContentColor3;
                    super(obj6, i3, f2, sheetSwipeEnabled2, obj4, containerColor2, sheetTonalElevation, obj47, sheetDragHandle, obj49, obj50, sheetDragHandle2, obj10);
                    BottomSheetScaffoldKt.BottomSheetScaffold.3 anon2 = new BottomSheetScaffoldKt.BottomSheetScaffold.3(function3, obj6);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1349215175, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                    if (i45 ^= 384 > 256) {
                        if (!restartGroup.changed(obj6)) {
                            if ($dirty2 & 384 == 256) {
                            } else {
                                i18 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                    Composer composer2 = restartGroup;
                    int i78 = 0;
                    it$iv = composer2.rememberedValue();
                    i = 0;
                    if (i18 == 0) {
                        $dirty6 = $dirty2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $dirty2 = 0;
                            obj39 = it$iv;
                            it$iv = new BottomSheetScaffoldKt.BottomSheetScaffold.4.1(obj6);
                            composer2.updateRememberedValue((Function0)it$iv);
                        } else {
                            obj39 = it$iv;
                        }
                    } else {
                        $dirty6 = $dirty2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj39 = obj53;
                    obj50 = restartGroup;
                    obj46 = $dirty1;
                    BottomSheetScaffoldKt.BottomSheetScaffoldLayout-2E65NiM(obj39, topBar2, (Function2)ComposableLambdaKt.rememberComposableLambda(-459880832, i18, anon3, restartGroup, 54), (Function2)ComposableLambdaKt.rememberComposableLambda(1961872927, i18, anon, restartGroup, 54), (Function2)ComposableLambdaKt.rememberComposableLambda(88659390, i18, anon2, restartGroup, 54), (Function0)it$iv, obj6.getBottomSheetState(), obj46, obj47, contentColorFor-ek8zF_U, obj49);
                    composer = obj50;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function32 = function3;
                    $composer2 = i3;
                    snackbarHost3 = f2;
                    obj = obj4;
                    obj8 = obj6;
                    i6 = i93;
                    scaffoldState2 = sheetSwipeEnabled2;
                    $dirty12 = topBar2;
                    $dirty14 = contentColorFor-ek8zF_U;
                    sheetShape2 = obj52;
                    companion2 = obj2;
                    sheetContainerColor2 = f4;
                    function2 = sheetDragHandle2;
                    sheetShadowElevation2 = l3;
                    sheetMaxWidth2 = sheetContentColor3;
                    sheetContentColor2 = l4;
                } else {
                    restartGroup.skipToGroupEnd();
                    companion2 = modifier;
                    function32 = contentColor;
                    sheetContentColor2 = content;
                    $dirty14 = $changed;
                    $dirty6 = $dirty2;
                    composer = restartGroup;
                    $composer2 = i3;
                    snackbarHost3 = f2;
                    obj = obj4;
                    sheetShadowElevation2 = containerColor2;
                    obj8 = obj6;
                    i6 = $dirty13;
                    sheetMaxWidth2 = sheetTonalElevation;
                    sheetShape2 = sheetDragHandle;
                    sheetContainerColor2 = sheetSwipeEnabled;
                    function2 = topBar;
                    scaffoldState2 = snackbarHost;
                    $dirty12 = containerColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BottomSheetScaffoldKt.BottomSheetScaffold.5(sheetContent, companion2, obj8, $composer2, snackbarHost3, obj, sheetShadowElevation2, i3, sheetMaxWidth2, sheetDragHandle2, sheetShape2, sheetContainerColor2, function2, scaffoldState2, $dirty12, function32, sheetContentColor2, i90, $dirty14, sheetSwipeEnabled2, i21, obj60, obj61, obj62);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void BottomSheetScaffoldLayout-2E65NiM(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> topBar, Function2<? super Composer, ? super Integer, Unit> body, Function2<? super Composer, ? super Integer, Unit> bottomSheet, Function2<? super Composer, ? super Integer, Unit> snackbarHost, Function0<Float> sheetOffset, androidx.compose.material3.SheetState sheetState, long containerColor, long contentColor, Composer $composer, int $changed) {
        int traceInProgress2;
        Object $i$a$CacheLayoutKt$Layout$3$iv;
        Object listOf;
        int $dirty;
        Object setCompositeKeyHash;
        Function0 factory$iv$iv$iv;
        int i9;
        int i6;
        Object constructor-impl;
        int i20;
        Object valueOf;
        int i13;
        Object lambda-3$material3_release;
        int i7;
        boolean skipping;
        boolean traceInProgress;
        int anon;
        int i19;
        int i14;
        int i11;
        int i12;
        int i2;
        long companion2;
        int combineAsVirtualLayouts;
        long l;
        int i10;
        int changed;
        Object currentCompositionLocalMap;
        int empty;
        int i3;
        int i15;
        int i16;
        int i8;
        int i21;
        int i;
        Composer.Companion companion;
        java.util.List contents$iv;
        int i5;
        int i17;
        int i18;
        Function0 function0;
        Composer composer;
        int i4;
        Object measurePolicy$iv$iv;
        int obj38;
        setCompositeKeyHash = topBar;
        valueOf = bottomSheet;
        final Object obj2 = snackbarHost;
        final Object obj3 = sheetOffset;
        final Object obj4 = sheetState;
        combineAsVirtualLayouts = obj39;
        traceInProgress2 = -1651214892;
        final Composer restartGroup = obj38.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(BottomSheetScaffoldLayout)P(4,8!2,7,5,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color)359@16300L255,370@16635L1950,355@16183L2402:BottomSheetScaffold.kt#uh7d8r");
        i13 = 4;
        if (combineAsVirtualLayouts & 6 == 0) {
            i9 = restartGroup.changed(modifier) ? i13 : 2;
            $dirty |= i9;
        } else {
            currentCompositionLocalMap = modifier;
        }
        if (combineAsVirtualLayouts & 48 == 0) {
            i6 = restartGroup.changedInstance(setCompositeKeyHash) ? 32 : 16;
            $dirty |= i6;
        }
        if (combineAsVirtualLayouts & 384 == 0) {
            i19 = restartGroup.changedInstance(body) ? 256 : 128;
            $dirty |= i19;
        } else {
            constructor-impl = body;
        }
        if (combineAsVirtualLayouts & 3072 == 0) {
            i14 = restartGroup.changedInstance(valueOf) ? 2048 : 1024;
            $dirty |= i14;
        }
        if (combineAsVirtualLayouts & 24576 == 0) {
            i11 = restartGroup.changedInstance(obj2) ? 16384 : 8192;
            $dirty |= i11;
        }
        if (i42 &= combineAsVirtualLayouts == 0) {
            i12 = restartGroup.changedInstance(obj3) ? 131072 : 65536;
            $dirty |= i12;
        }
        if (i43 &= combineAsVirtualLayouts == 0) {
            i2 = restartGroup.changed(obj4) ? 1048576 : 524288;
            $dirty |= i2;
        }
        if (i44 &= combineAsVirtualLayouts == 0) {
            i15 = restartGroup.changed(containerColor) ? 8388608 : 4194304;
            $dirty |= i15;
        } else {
            l = containerColor;
        }
        if (combineAsVirtualLayouts & i53 == 0) {
            i8 = restartGroup.changed($composer) ? 67108864 : 33554432;
            $dirty |= i8;
        } else {
            companion2 = $composer;
        }
        i21 = 38347923;
        if ($dirty & i21 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:354)");
                }
                Function2[] arr = new Function2[i13];
                if (setCompositeKeyHash == null) {
                    lambda-3$material3_release = ComposableSingletons.BottomSheetScaffoldKt.INSTANCE.getLambda-3$material3_release();
                } else {
                    lambda-3$material3_release = setCompositeKeyHash;
                }
                int i40 = 0;
                arr[i40] = lambda-3$material3_release;
                BottomSheetScaffoldKt.BottomSheetScaffoldLayout.1 anon2 = new BottomSheetScaffoldKt.BottomSheetScaffoldLayout.1(modifier, containerColor, i21, companion2, obj19, constructor-impl);
                int i41 = 1;
                arr[i41] = ComposableLambdaKt.rememberComposableLambda(398963586, i41, anon2, restartGroup, 54);
                arr[2] = valueOf;
                arr[3] = obj2;
                listOf = CollectionsKt.listOf(arr);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1221133327, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                i20 = i32 &= $dirty == 1048576 ? i41 : i40;
                i7 = i38 &= $dirty == 131072 ? i41 : i40;
                Composer composer2 = restartGroup;
                int i47 = 0;
                Object rememberedValue3 = composer2.rememberedValue();
                int i49 = 0;
                if (i20 |= i7 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new BottomSheetScaffoldKt.BottomSheetScaffoldLayout.2.1(obj4, obj3);
                        composer2.updateRememberedValue((MultiContentMeasurePolicy)anon);
                    } else {
                        anon = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i35 = i40;
                i13 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -290761997, "CC(remember):Layout.kt#9igjgp");
                if (i51 ^= 384 > 256) {
                    if (!restartGroup.changed((MultiContentMeasurePolicy)anon)) {
                        i10 = i35 & 384 == 256 ? 1 : i40;
                    } else {
                    }
                } else {
                }
                Composer composer3 = restartGroup;
                int i55 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i56 = 0;
                if (i10 == 0) {
                    contents$iv = listOf;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        int contents$iv2 = 0;
                        composer3.updateRememberedValue(MultiContentMeasurePolicyKt.createMeasurePolicy(anon));
                    } else {
                        $i$a$CacheLayoutKt$Layout$3$iv = rememberedValue2;
                    }
                } else {
                    contents$iv = listOf;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                l = 0;
                i16 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj38 = currentCompositeKeyHash;
                Function0 function02 = constructor;
                i21 = 0;
                i17 = i35;
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
                i = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)$i$a$CacheLayoutKt$Layout$3$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i18 = 0;
                composer = constructor-impl;
                i4 = 0;
                if (!composer.getInserting()) {
                    measurePolicy$iv$iv = $i$a$CacheLayoutKt$Layout$3$iv;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(obj38))) {
                        composer.updateRememberedValue(Integer.valueOf(obj38));
                        constructor-impl.apply(Integer.valueOf(obj38), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        valueOf = composer;
                    }
                } else {
                    measurePolicy$iv$iv = $i$a$CacheLayoutKt$Layout$3$iv;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)Modifier.Companion), ComposeUiNode.Companion.getSetModifier());
                LayoutKt.combineAsVirtualLayouts(listOf).invoke(restartGroup, Integer.valueOf(i22 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i16 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new BottomSheetScaffoldKt.BottomSheetScaffoldLayout.3(modifier, topBar, body, bottomSheet, obj2, obj3, obj4, containerColor, skipping, $composer, companion2, obj39);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void StandardBottomSheet-w7I5h1o(androidx.compose.material3.SheetState state, float peekHeight, float sheetMaxWidth, boolean sheetSwipeEnabled, Shape shape, long containerColor, long contentColor, float tonalElevation, float shadowElevation, Function2<? super Composer, ? super Integer, Unit> dragHandle, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1) {
        Object compositionCoroutineScope;
        boolean traceInProgress;
        Object endRestartGroup;
        int obj;
        int skipping;
        boolean traceInProgress2;
        Object composer$iv;
        Object empty;
        Object it$iv;
        boolean z;
        Object $composer3;
        int $dirty;
        Modifier nestedScroll$default;
        Object rememberedValue;
        float f;
        int $dirty1;
        int i10;
        int i8;
        int i16;
        int i4;
        Object $composer2;
        int i;
        androidx.compose.ui.Modifier.Companion companion3;
        boolean i13;
        int i6;
        long l2;
        float f3;
        Object obj2;
        Object obj3;
        int i3;
        float f2;
        int i12;
        long l;
        androidx.compose.foundation.BorderStroke borderStroke;
        int i14;
        int i17;
        int i11;
        int i7;
        int i9;
        androidx.compose.runtime.internal.ComposableLambda i5;
        int i18;
        Composer composer;
        Composer.Companion companion2;
        Object obj4;
        int i15;
        int $dirty12;
        int i2;
        int scope;
        Composer composer2;
        Composer $composer4;
        float $composer5;
        Object it$iv$iv;
        Orientation orientation;
        Object companion;
        ScopeUpdateScope scopeUpdateScope;
        int obj40;
        obj = state;
        f = peekHeight;
        final float f5 = sheetMaxWidth;
        traceInProgress = obj41;
        $composer3 = $changed1.startRestartGroup(721467526);
        ComposerKt.sourceInformation($composer3, "C(StandardBottomSheet)P(9,4:c#ui.unit.Dp,7:c#ui.unit.Dp,8,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.unit.Dp,5:c#ui.unit.Dp,3)225@10249L24,*227@10358L7,248@11164L1938,294@13493L2297,242@10889L4901:BottomSheetScaffold.kt#uh7d8r");
        i13 = 2;
        if (traceInProgress & 6 == 0) {
            i10 = $composer3.changed(obj) ? 4 : i13;
            $dirty |= i10;
        }
        if (traceInProgress & 48 == 0) {
            i8 = $composer3.changed(f) ? 32 : 16;
            $dirty |= i8;
        }
        if (traceInProgress & 384 == 0) {
            i16 = $composer3.changed(f5) ? 256 : 128;
            $dirty |= i16;
        }
        if (traceInProgress & 3072 == 0) {
            i4 = $composer3.changed(sheetSwipeEnabled) ? 2048 : 1024;
            $dirty |= i4;
        }
        if (traceInProgress & 24576 == 0) {
            i6 = $composer3.changed(shape) ? 16384 : 8192;
            $dirty |= i6;
        } else {
            $composer2 = shape;
        }
        if (i54 &= traceInProgress == 0) {
            i12 = $composer3.changed(containerColor) ? 131072 : 65536;
            $dirty |= i12;
        } else {
            l2 = containerColor;
        }
        if (i59 &= traceInProgress == 0) {
            i14 = $composer3.changed(tonalElevation) ? 1048576 : 524288;
            $dirty |= i14;
        } else {
            l = tonalElevation;
        }
        i17 = 12582912;
        if (traceInProgress & i17 == 0) {
            i3 = $composer3.changed(dragHandle) ? 8388608 : 4194304;
            $dirty |= i3;
        } else {
            f3 = dragHandle;
        }
        if (i57 &= traceInProgress == 0) {
            i11 = $composer3.changed(content) ? 67108864 : 33554432;
            $dirty |= i11;
        } else {
            f2 = content;
        }
        if (traceInProgress & i63 == 0) {
            i7 = $composer3.changedInstance($composer) ? 536870912 : 268435456;
            $dirty |= i7;
        } else {
            obj2 = $composer;
        }
        if (obj42 & 6 == 0) {
            i9 = $composer3.changedInstance($changed) ? 4 : i13;
            $dirty1 |= i9;
        } else {
            obj3 = $changed;
        }
        if ($dirty & i5 == 306783378 && $dirty1 & 3 == i13) {
            if ($dirty1 & 3 == i13) {
                if (!$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(721467526, $dirty, $dirty1, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:224)");
                    }
                    int i48 = i35;
                    int i64 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    Composer composer3 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                    Composer composer7 = $composer3;
                    int i68 = 0;
                    int i70 = i19;
                    compositionCoroutineScope = composer7.rememberedValue();
                    i2 = 0;
                    if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                        empty = 0;
                        int i71 = 0;
                        it$iv$iv = compositionCoroutineScope;
                        composer2 = composer3;
                        composer$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer3));
                        composer7.updateRememberedValue(composer$iv);
                    } else {
                        composer2 = composer3;
                        composer$iv = it$iv$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    kotlinx.coroutines.CoroutineScope coroutineScope = (CompositionScopedCoroutineScopeCanceller)composer$iv.getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Orientation vertical = Orientation.Vertical;
                    companion3 = 0;
                    int i65 = i39;
                    int i69 = $dirty;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    int i40 = 0;
                    float $this$StandardBottomSheet_w7I5h1o_u24lambda_u243 = (Density)$composer3.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(f);
                    $composer3.startReplaceGroup(-1831611516);
                    ComposerKt.sourceInformation($composer3, "231@10496L326");
                    String str3 = "CC(remember):BottomSheetScaffold.kt#9igjgp";
                    if (sheetSwipeEnabled) {
                        $dirty12 = $dirty1;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1831609222, str3);
                        Composer composer4 = $composer3;
                        i2 = 0;
                        rememberedValue = composer4.rememberedValue();
                        it$iv$iv = 0;
                        if (!$composer3.changed(obj.getAnchoredDraggableState$material3_release())) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                $composer2 = 0;
                                companion = rememberedValue;
                                BottomSheetScaffoldKt.StandardBottomSheet.nestedScroll.1.1 it$iv2 = new BottomSheetScaffoldKt.StandardBottomSheet.nestedScroll.1.1(coroutineScope, obj);
                                composer4.updateRememberedValue(SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(obj, vertical, (Function1)it$iv2));
                            } else {
                                companion = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $dirty1 = 0;
                        nestedScroll$default = NestedScrollModifierKt.nestedScroll$default((Modifier)Modifier.Companion, (NestedScrollConnection)rememberedValue, $dirty1, 2, $dirty1);
                    } else {
                        $dirty12 = $dirty1;
                        nestedScroll$default = Modifier.Companion;
                    }
                    $composer3.endReplaceGroup();
                    int i45 = 0;
                    int i51 = 1;
                    int scope2 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1831586234, str3);
                    i18 = i69 & 14 == 4 ? 1 : 0;
                    Composer composer5 = $composer3;
                    int i53 = 0;
                    it$iv = composer5.rememberedValue();
                    int i67 = 0;
                    if (i18 | changed == 0) {
                        $composer4 = $composer3;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $composer3 = 0;
                            obj4 = it$iv;
                            it$iv = new BottomSheetScaffoldKt.StandardBottomSheet.1.1(obj, $this$StandardBottomSheet_w7I5h1o_u24lambda_u243);
                            composer5.updateRememberedValue((Function2)it$iv);
                        } else {
                            obj4 = it$iv;
                        }
                    } else {
                        $composer4 = $composer3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    f2 = 0;
                    i13 = sheetSwipeEnabled;
                    orientation = vertical;
                    companion = nestedScroll$default;
                    Composer composer6 = $composer4;
                    $composer5 = f4;
                    scope = i69;
                    BottomSheetScaffoldKt.StandardBottomSheet.2 peekHeightPx = new BottomSheetScaffoldKt.StandardBottomSheet.2($composer, obj, sheetSwipeEnabled, coroutineScope, $changed);
                    SurfaceKt.Surface-T9BRK9s(AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(SizeKt.requiredHeightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.widthIn-VpY3zN4$default((Modifier)Modifier.Companion, i45, f5, i51, scope2), i45, i51, scope2), f, i45, 2, scope2).then(nestedScroll$default), obj.getAnchoredDraggableState$material3_release(), vertical, (Function2)it$iv), obj.getAnchoredDraggableState$material3_release(), vertical, i13, false, f2, 24, 0), shape, containerColor, i13, tonalElevation, f2, dragHandle, content, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(390720907, true, peekHeightPx, composer6, 54), composer6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    composer = $composer3;
                    scope = $dirty;
                    $dirty12 = $dirty1;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BottomSheetScaffoldKt.StandardBottomSheet.3(state, f, f5, sheetSwipeEnabled, shape, containerColor, f5, tonalElevation, $composer2, dragHandle, content, $composer, $changed, obj41, obj42);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void access$BottomSheetScaffoldLayout-2E65NiM(Modifier modifier, Function2 topBar, Function2 body, Function2 bottomSheet, Function2 snackbarHost, Function0 sheetOffset, androidx.compose.material3.SheetState sheetState, long containerColor, long contentColor, Composer $composer, int $changed) {
        BottomSheetScaffoldKt.BottomSheetScaffoldLayout-2E65NiM(modifier, topBar, body, bottomSheet, snackbarHost, sheetOffset, sheetState, containerColor, contentColor, $composer, $changed);
    }

    public static final void access$StandardBottomSheet-w7I5h1o(androidx.compose.material3.SheetState state, float peekHeight, float sheetMaxWidth, boolean sheetSwipeEnabled, Shape shape, long containerColor, long contentColor, float tonalElevation, float shadowElevation, Function2 dragHandle, Function3 content, Composer $composer, int $changed, int $changed1) {
        BottomSheetScaffoldKt.StandardBottomSheet-w7I5h1o(state, peekHeight, sheetMaxWidth, sheetSwipeEnabled, shape, containerColor, contentColor, tonalElevation, shadowElevation, dragHandle, content, $composer, $changed, $changed1);
    }

    public static final androidx.compose.material3.BottomSheetScaffoldState rememberBottomSheetScaffoldState(androidx.compose.material3.SheetState bottomSheetState, androidx.compose.material3.SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i5) {
        int changed;
        int str;
        int i;
        int rememberedValue;
        int i2;
        Object bottomSheetScaffoldState;
        Composer $composer2;
        int empty;
        int snackbarHostState2;
        androidx.compose.material3.SheetState obj8;
        Object obj9;
        int obj10;
        int obj12;
        int i3 = -1474606134;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberBottomSheetScaffoldState)178@8695L34,179@8774L32,181@8848L196:BottomSheetScaffold.kt#uh7d8r");
        if (i5 & 1 != 0) {
            obj8 = BottomSheetScaffoldKt.rememberStandardBottomSheetState(0, 0, false, $composer, 0, 7);
        } else {
            $composer2 = $composer;
        }
        obj12 = "CC(remember):BottomSheetScaffold.kt#9igjgp";
        if (i5 & 2 != 0) {
            ComposerKt.sourceInformationMarkerStart($composer2, -787714761, obj12);
            obj10 = 0;
            str = $composer2;
            i = 0;
            rememberedValue = str.rememberedValue();
            i2 = 0;
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
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:180)");
        }
        ComposerKt.sourceInformationMarkerStart($composer2, -787712229, obj12);
        int i4 = 4;
        int i8 = 1;
        if (obj10 ^= 6 > i4) {
            if (!$composer2.changed(obj8)) {
                obj10 = $changed & 6 == i4 ? i8 : obj12;
            } else {
            }
        } else {
        }
        int i9 = 32;
        if (i6 ^= 48 > i9) {
            if (!$composer2.changed(obj9)) {
                if ($changed & 48 == i9) {
                    obj12 = i8;
                }
            } else {
            }
        } else {
        }
        obj12 = $composer2;
        int i7 = 0;
        Object rememberedValue2 = obj12.rememberedValue();
        int i10 = 0;
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

    public static final androidx.compose.material3.SheetState rememberStandardBottomSheetState(androidx.compose.material3.SheetValue initialValue, Function1<? super androidx.compose.material3.SheetValue, Boolean> confirmValueChange, boolean skipHiddenState, Composer $composer, int $changed, int i6) {
        androidx.compose.material3.BottomSheetScaffoldKt.rememberStandardBottomSheetState.1 anon;
        androidx.compose.material3.SheetValue sheetValue;
        int i;
        androidx.compose.material3.SheetValue obj8;
        androidx.compose.material3.BottomSheetScaffoldKt.rememberStandardBottomSheetState.1 obj9;
        int obj10;
        final int i2 = 678511581;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberStandardBottomSheetState)P(1)204@9680L154:BottomSheetScaffold.kt#uh7d8r");
        sheetValue = i6 & 1 != 0 ? obj8 : initialValue;
        if (i6 & 2 != 0) {
            anon = obj9;
        } else {
            anon = confirmValueChange;
        }
        i = i6 & 4 != 0 ? obj10 : skipHiddenState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:204)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SheetDefaultsKt.rememberSheetState(false, anon, sheetValue, i, composer, obj8 | obj9, 1);
    }
}
