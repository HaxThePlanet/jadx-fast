package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R.string;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aÄ\u0001\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00132\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0008\u0018\u00010\n¢\u0006\u0002\u0008\u00182\u0013\u0008\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u001a0\n¢\u0006\u0002\u0008\u00182\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00080\u001e¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008 H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\u001a0\u0010#\u001a\u00020\u00082\u0006\u0010$\u001a\u00020\u00132\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\n2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001a-\u0010)\u001a\u00020\u000e2\u0008\u0008\u0002\u0010*\u001a\u00020&2\u0014\u0008\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020&0\u001eH\u0007¢\u0006\u0002\u0010-\u001aó\u0001\u0010.\u001a\u00020\u0008*\u00020/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\u0006\u00104\u001a\u0002052\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u00080\n2!\u00107\u001a\u001d\u0012\u0013\u0012\u001102¢\u0006\u000c\u00088\u0012\u0008\u00089\u0012\u0004\u0008\u0008(:\u0012\u0004\u0012\u00020\u00080\u001e2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00042\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0008\u0018\u00010\n¢\u0006\u0002\u0008\u00182\u0013\u0008\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u001a0\n¢\u0006\u0002\u0008\u00182\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00080\u001e¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008 H\u0001ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<\u001a\u0014\u0010=\u001a\u000202*\u00020>2\u0006\u0010?\u001a\u000202H\u0002\u001a\u0014\u0010@\u001a\u000202*\u00020>2\u0006\u0010?\u001a\u000202H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u000202X\u008a\u0084\u0002", d2 = {"PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "PredictiveBackMaxScaleXDistance", "Landroidx/compose/ui/unit/Dp;", "F", "PredictiveBackMaxScaleYDistance", "ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scrim", "color", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "settleToDismiss", "Lkotlin/ParameterName;", "name", "velocity", "ModalBottomSheetContent-IQkwcL4", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "calculatePredictiveBackScaleY", "material3_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModalBottomSheetKt {

    private static final long PredictiveBackChildTransformOrigin;
    private static final float PredictiveBackMaxScaleXDistance;
    private static final float PredictiveBackMaxScaleYDistance;
    static {
        int i4 = 0;
        ModalBottomSheetKt.PredictiveBackMaxScaleXDistance = Dp.constructor-impl((float)i);
        int i5 = 0;
        ModalBottomSheetKt.PredictiveBackMaxScaleYDistance = Dp.constructor-impl((float)i2);
        ModalBottomSheetKt.PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(1056964608, 0);
    }

    public static final void ModalBottomSheet-dYc4hso(Function0<Unit> onDismissRequest, Modifier modifier, androidx.compose.material3.SheetState sheetState, float sheetMaxWidth, Shape shape, long containerColor, long contentColor, float tonalElevation, long scrimColor, Function2<? super Composer, ? super Integer, Unit> dragHandle, Function2<? super Composer, ? super Integer, ? extends WindowInsets> contentWindowInsets, androidx.compose.material3.ModalBottomSheetProperties properties, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i17) {
        float f4;
        boolean z;
        Object $dirty14;
        int $dirty3;
        float $dirty5;
        Object contentWindowInsets2;
        Object endRestartGroup;
        Object obj5;
        int skipping;
        int defaultsInvalid;
        int rememberModalBottomSheetState;
        float sheetMaxWidth2;
        int i13;
        int i18;
        int i16;
        int i;
        boolean traceInProgress;
        int compositionCoroutineScope;
        Composer composer;
        Object $composer3;
        Object compositionScopedCoroutineScopeCanceller;
        int changed3;
        int i20;
        int invalid$iv;
        boolean hasExpandedState;
        int changed7;
        Object obj9;
        Object obj8;
        int i2;
        int $dirty15;
        Object $dirty13;
        int i7;
        int i21;
        int changed;
        float $dirty1;
        Object rememberedValue2;
        Object $composer2;
        int $dirty7;
        long $dirty;
        Object obj10;
        int i23;
        long l5;
        boolean changedInstance;
        int str;
        int contentColor2;
        int i14;
        int i4;
        int expandedShape;
        Composer composer2;
        int i5;
        Composer empty2;
        long l6;
        long containerColor2;
        int i19;
        int i3;
        int changed5;
        int i30;
        int i11;
        int i29;
        int i28;
        int i26;
        Object rememberedValue;
        float f;
        long $dirty4;
        long l;
        float dragHandle2;
        Object obj;
        int empty;
        Object empty3;
        Object anon3;
        Function2 modifier2;
        int i10;
        Object obj4;
        androidx.compose.material3.ModalBottomSheetKt.ModalBottomSheet.1 sheetState2;
        Object obj7;
        Object empty4;
        Object anon6;
        Object anon4;
        androidx.compose.material3.ModalBottomSheetProperties modalBottomSheetProperties;
        int changed4;
        int i6;
        int i12;
        int properties2;
        int changed8;
        int i9;
        int i27;
        int changed9;
        int i8;
        int i24;
        int $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        Composer $composer4;
        int i22;
        int $dirty2;
        int scrimColor2;
        int $dirty6;
        int changed2;
        int $dirty12;
        int i15;
        int changedInstance2;
        int i25;
        boolean changed6;
        long l3;
        androidx.compose.material3.ModalBottomSheetKt.ModalBottomSheet.animateToDismiss.1.1 anon2;
        Object obj6;
        Object obj3;
        CoroutineScope coroutineScope;
        androidx.compose.material3.ModalBottomSheetKt.ModalBottomSheet.settleToDismiss.1.1 anon;
        Object obj2;
        float f2;
        Object obj11;
        long l4;
        long l2;
        float f3;
        Function2 function2;
        androidx.compose.material3.ModalBottomSheetKt.ModalBottomSheet.1 anon5;
        Object obj12;
        ScopeUpdateScope scopeUpdateScope;
        int obj48;
        androidx.compose.material3.ModalBottomSheetProperties obj49;
        Object obj50;
        androidx.compose.runtime.internal.ComposableLambda obj51;
        Composer obj52;
        int obj53;
        obj5 = onDismissRequest;
        int i31 = obj64;
        int i33 = obj65;
        int i36 = obj66;
        rememberedValue2 = i17.startRestartGroup(2132719801);
        ComposerKt.sourceInformation(rememberedValue2, "C(ModalBottomSheet)P(6,5,11,10:c#ui.unit.Dp,9,0:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.unit.Dp,8:c#ui.graphics.Color,4,3,7)121@6012L31,123@6143L13,124@6206L14,125@6248L31,127@6356L10,133@6697L24,134@6761L327,145@7142L149,151@7326L42,155@7458L708,167@8231L771,153@7374L1628,193@9077L21,193@9050L48:ModalBottomSheet.kt#uh7d8r");
        $dirty7 = obj64;
        changedInstance = obj65;
        if (i36 & 1 != 0) {
            $dirty7 |= 6;
        } else {
            if (i31 & 6 == 0) {
                i4 = rememberedValue2.changedInstance(obj5) ? 4 : 2;
                $dirty7 |= i4;
            }
        }
        expandedShape = i36 & 2;
        if (expandedShape != 0) {
            $dirty7 |= 48;
            obj = modifier;
        } else {
            if (i31 & 48 == 0) {
                i10 = rememberedValue2.changed(modifier) ? 32 : 16;
                $dirty7 |= i10;
            } else {
                obj = modifier;
            }
        }
        if (i31 & 384 == 0) {
            if (i36 & 4 == 0) {
                changed4 = rememberedValue2.changed(sheetState) ? 256 : 128;
            } else {
                obj4 = sheetState;
            }
            $dirty7 |= changed4;
        } else {
            obj4 = sheetState;
        }
        i6 = i36 & 8;
        if (i6 != 0) {
            $dirty7 |= 3072;
            dragHandle2 = sheetMaxWidth;
        } else {
            if (i31 & 3072 == 0) {
                properties2 = rememberedValue2.changed(sheetMaxWidth) ? 2048 : 1024;
                $dirty7 |= properties2;
            } else {
                dragHandle2 = sheetMaxWidth;
            }
        }
        if (i31 & 24576 == 0) {
            if (i36 & 16 == 0) {
                changed8 = rememberedValue2.changed(shape) ? 16384 : 8192;
            } else {
                obj7 = shape;
            }
            $dirty7 |= changed8;
        } else {
            obj7 = shape;
        }
        if (i31 & i94 == 0) {
            if (i36 & 32 == 0) {
                changed9 = rememberedValue2.changed(containerColor) ? 131072 : 65536;
            } else {
                containerColor2 = containerColor;
            }
            $dirty7 |= changed9;
        } else {
            containerColor2 = containerColor;
        }
        if (i31 & i95 == 0) {
            if (i36 & 64 == 0) {
                $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1 = rememberedValue2.changed(tonalElevation) ? 1048576 : 524288;
            } else {
                $dirty4 = tonalElevation;
            }
            $dirty7 |= $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        } else {
            $dirty4 = tonalElevation;
        }
        int i53 = i36 & 128;
        i22 = 12582912;
        if (i53 != 0) {
            $dirty7 |= i22;
            f4 = dragHandle;
        } else {
            if (i31 & i22 == 0) {
                i22 = rememberedValue2.changed(dragHandle) ? 8388608 : 4194304;
                $dirty7 |= i22;
            } else {
                f4 = dragHandle;
            }
        }
        if (obj64 & i97 == 0) {
            if (i36 & 256 == 0) {
                $dirty6 = $dirty7;
                z = changedInstance;
                changed2 = rememberedValue2.changed(contentWindowInsets) ? 67108864 : 33554432;
            } else {
                $dirty6 = $dirty7;
                z = changedInstance;
                $dirty = contentWindowInsets;
            }
            $dirty6 |= changed2;
        } else {
            $dirty2 = $dirty7;
            z = changedInstance;
            $dirty = contentWindowInsets;
        }
        $dirty14 = i36 & 512;
        int i99 = 805306368;
        if ($dirty14 != 0) {
            $dirty2 |= i99;
            i15 = $dirty14;
        } else {
            if (obj64 & i99 == 0) {
                i15 = $dirty14;
                changedInstance2 = rememberedValue2.changedInstance(content) ? 536870912 : 268435456;
                $dirty2 |= changedInstance2;
            } else {
                i15 = $dirty14;
                $dirty14 = content;
            }
        }
        $dirty3 = $dirty2;
        if (i33 & 6 == 0) {
            scrimColor2 = i53;
            if (i36 & 1024 == 0) {
                changedInstance2 = rememberedValue2.changedInstance($composer) ? 4 : 2;
            } else {
                obj8 = $composer;
            }
            $dirty12 |= changedInstance2;
        } else {
            scrimColor2 = i53;
            obj8 = $composer;
        }
        i2 = i36 & 2048;
        if (i2 != 0) {
            $dirty12 |= 48;
            i25 = i2;
        } else {
            if (i33 & 48 == 0) {
                i25 = i2;
                i12 = rememberedValue2.changed($changed) ? 32 : 16;
                $dirty12 |= i12;
            } else {
                i25 = i2;
                i2 = $changed;
            }
        }
        $dirty15 = $dirty12;
        if (i36 & 4096 != 0) {
            $dirty15 |= 384;
            obj10 = $changed1;
        } else {
            if (i33 & 384 == 0) {
                properties2 = rememberedValue2.changedInstance($changed1) ? 256 : 128;
                $dirty15 |= properties2;
            } else {
                obj10 = $changed1;
            }
        }
        if (i63 &= $dirty3 == 306783378 && $dirty15 & 147 == 146) {
            if ($dirty15 & 147 == 146) {
                if (!rememberedValue2.getSkipping()) {
                    rememberedValue2.startDefaults();
                    contentColor2 = 0;
                    if (obj64 & 1 != 0) {
                        if (rememberedValue2.getDefaultsInvalid()) {
                            if (expandedShape != 0) {
                                obj = defaultsInvalid;
                            }
                            if (i36 & 4 != 0) {
                                $dirty3 &= -897;
                                obj4 = rememberModalBottomSheetState;
                            }
                            if (i6 != 0) {
                                sheetMaxWidth2 = BottomSheetDefaults.INSTANCE.getSheetMaxWidth-D9Ej5fM();
                            } else {
                                sheetMaxWidth2 = sheetMaxWidth;
                            }
                            if (i36 & 16 != 0) {
                                i6 = contentColor2;
                                $dirty3 &= contentColor2;
                                obj7 = expandedShape;
                            } else {
                                i6 = contentColor2;
                            }
                            if (i36 & 32 != 0) {
                                containerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor(rememberedValue2, 6);
                                $dirty3 &= i14;
                            }
                            if (i36 & 64 != 0) {
                                contentColor2 = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, obj10, rememberedValue2);
                                $dirty3 &= $dirty4;
                            } else {
                                contentColor2 = $dirty4;
                            }
                            if (scrimColor2 != 0) {
                                dragHandle2 = 0;
                                obj48 = $dirty3;
                                $dirty5 = Dp.constructor-impl((float)$dirty4);
                            } else {
                                obj48 = $dirty3;
                                $dirty5 = dragHandle;
                            }
                            if (i36 & 256 != 0) {
                                scrimColor2 = BottomSheetDefaults.INSTANCE.getScrimColor(rememberedValue2, 6);
                                $dirty4 = obj48 & i83;
                            } else {
                                $dirty4 = obj48;
                                scrimColor2 = contentWindowInsets;
                            }
                            if (i15 != 0) {
                                dragHandle2 = ComposableSingletons.ModalBottomSheetKt.INSTANCE.getLambda-1$material3_release();
                            } else {
                                dragHandle2 = content;
                            }
                            obj48 = $dirty5;
                            if (i36 & 1024 != 0) {
                                contentWindowInsets2 = ModalBottomSheetKt.ModalBottomSheet.1.INSTANCE;
                                $dirty15 &= -15;
                            } else {
                                contentWindowInsets2 = $composer;
                            }
                            if (i25 != 0) {
                                properties2 = ModalBottomSheetDefaults.INSTANCE.getProperties();
                                f3 = obj48;
                                anon5 = contentWindowInsets2;
                                f2 = sheetMaxWidth2;
                                l2 = contentColor2;
                                l4 = containerColor2;
                                $dirty3 = $dirty4;
                                function2 = dragHandle2;
                                obj2 = obj;
                                obj11 = obj7;
                                l3 = scrimColor2;
                            } else {
                                f3 = obj48;
                                properties2 = $changed;
                                anon5 = contentWindowInsets2;
                                f2 = sheetMaxWidth2;
                                l2 = contentColor2;
                                l4 = containerColor2;
                                $dirty3 = $dirty4;
                                function2 = dragHandle2;
                                obj2 = obj;
                                obj11 = obj7;
                                l3 = scrimColor2;
                            }
                        } else {
                            rememberedValue2.skipToGroupEnd();
                            if (i36 & 4 != 0) {
                                $dirty3 &= -897;
                            }
                            if (i36 & 16 != 0) {
                                $dirty3 &= i13;
                            }
                            if (i36 & 32 != 0) {
                                $dirty3 &= i18;
                            }
                            if (i36 & 64 != 0) {
                                $dirty3 &= i16;
                            }
                            if (i36 & 256 != 0) {
                                $dirty3 &= i;
                            }
                            if (i36 & 1024 != 0) {
                                $dirty15 &= -15;
                            }
                            f2 = sheetMaxWidth;
                            f3 = dragHandle;
                            l3 = contentWindowInsets;
                            function2 = content;
                            anon5 = $composer;
                            properties2 = $changed;
                            i6 = contentColor2;
                            l4 = containerColor2;
                            l2 = $dirty4;
                            obj2 = obj;
                            obj11 = obj7;
                        }
                    } else {
                    }
                    rememberedValue2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132719801, $dirty3, $dirty15, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:132)");
                    }
                    compositionCoroutineScope = i6;
                    int i68 = 0;
                    ComposerKt.sourceInformationMarkerStart(rememberedValue2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(rememberedValue2, -954363344, "CC(remember):Effects.kt#9igjgp");
                    int i72 = 0;
                    Composer composer7 = rememberedValue2;
                    int i84 = 0;
                    Object rememberedValue6 = composer7.rememberedValue();
                    empty = 0;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        empty4 = 0;
                        int i96 = 0;
                        obj48 = compositionCoroutineScope;
                        compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, rememberedValue2));
                        composer7.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    } else {
                        obj48 = compositionCoroutineScope;
                        compositionScopedCoroutineScopeCanceller = rememberedValue6;
                    }
                    ComposerKt.sourceInformationMarkerEnd(rememberedValue2);
                    ComposerKt.sourceInformationMarkerEnd(rememberedValue2);
                    CoroutineScope wrapper$iv = coroutineScope2;
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(rememberedValue2, -2011393839, str);
                    if (i38 ^= 384 > 256) {
                        if (!rememberedValue2.changed(obj4)) {
                            i20 = $dirty3 & 384 == 256 ? 1 : i6;
                        } else {
                        }
                    } else {
                    }
                    i3 = $dirty3 & 14 == 4 ? 1 : i6;
                    Composer composer4 = rememberedValue2;
                    int i77 = 0;
                    Object rememberedValue3 = composer4.rememberedValue();
                    int i87 = 0;
                    if (i39 |= i3 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon6 = new ModalBottomSheetKt.ModalBottomSheet.animateToDismiss.1.1(obj4, wrapper$iv, obj5);
                            composer4.updateRememberedValue((Function0)anon6);
                        } else {
                            anon6 = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(rememberedValue2);
                    ComposerKt.sourceInformationMarkerStart(rememberedValue2, -2011381825, str);
                    if (i74 ^= 384 > 256) {
                        if (!rememberedValue2.changed(obj4)) {
                            i30 = $dirty3 & 384 == 256 ? 1 : i6;
                        } else {
                        }
                    } else {
                    }
                    i11 = $dirty3 & 14 == 4 ? 1 : i6;
                    Composer composer5 = rememberedValue2;
                    int i79 = 0;
                    Object rememberedValue4 = composer5.rememberedValue();
                    int i88 = 0;
                    if (i42 |= i11 == 0) {
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon4 = new ModalBottomSheetKt.ModalBottomSheet.settleToDismiss.1.1(wrapper$iv, obj4, obj5);
                            composer5.updateRememberedValue((Function1)anon4);
                        } else {
                            anon4 = rememberedValue4;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(rememberedValue2);
                    ComposerKt.sourceInformationMarkerStart(rememberedValue2, -2011376044, str);
                    invalid$iv = 0;
                    Composer composer6 = rememberedValue2;
                    int i80 = 0;
                    Object rememberedValue5 = composer6.rememberedValue();
                    dragHandle2 = 0;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty3 = 0;
                        obj48 = invalid$iv;
                        i9 = $dirty15;
                        composer6.updateRememberedValue(AnimatableKt.Animatable$default(0, 0, 2, 0));
                    } else {
                        obj48 = invalid$iv;
                        i9 = $dirty15;
                        $dirty13 = rememberedValue5;
                    }
                    Object obj14 = $dirty13;
                    ComposerKt.sourceInformationMarkerEnd(rememberedValue2);
                    ComposerKt.sourceInformationMarkerStart(rememberedValue2, -2011371154, str);
                    if (i55 ^= 384 > 256) {
                        if (!rememberedValue2.changed(obj4)) {
                            i7 = $dirty3 & 384 == 256 ? 1 : i6;
                        } else {
                        }
                    } else {
                    }
                    i5 = $dirty3 & 14 == 4 ? 1 : i6;
                    empty2 = rememberedValue2;
                    containerColor2 = 0;
                    rememberedValue = empty2.rememberedValue();
                    int i85 = 0;
                    if (i57 |= i5 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            dragHandle2 = 0;
                            anon3 = new ModalBottomSheetKt.ModalBottomSheet.2.1(obj4, wrapper$iv, obj14, obj5);
                            empty2.updateRememberedValue((Function0)anon3);
                        } else {
                            anon3 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(rememberedValue2);
                    obj3 = obj14;
                    changed6 = new ModalBottomSheetKt.ModalBottomSheet.3(l3, obj29, (Function0)anon6, obj4, obj3, wrapper$iv, (Function1)anon4, obj2, f2, obj11, l4, obj39, l2, obj41, f3, function2, anon5, obj10);
                    i23 = 1;
                    i12 = 6;
                    obj52 = rememberedValue2;
                    ModalBottomSheet_androidKt.ModalBottomSheetDialog((Function0)anon3, properties2, obj3, (Function2)ComposableLambdaKt.rememberComposableLambda(-314673510, i23, changed6, rememberedValue2, 54), obj52, i47 |= i21);
                    composer = obj52;
                    if (obj4.getHasExpandedState()) {
                        ComposerKt.sourceInformationMarkerStart(composer, -2011320033, str);
                        if (i50 ^= 384 > 256) {
                            if (!composer.changed(obj4)) {
                                str = $dirty3 & 384 == 256 ? i23 : i6;
                            } else {
                            }
                        } else {
                        }
                        Composer composer3 = composer;
                        i21 = 0;
                        rememberedValue2 = composer3.rememberedValue();
                        i23 = 0;
                        if (str == null) {
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                containerColor2 = new ModalBottomSheetKt.ModalBottomSheet.4.1(obj4, 0);
                                composer3.updateRememberedValue((Function2)containerColor2);
                            } else {
                                containerColor2 = rememberedValue2;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        EffectsKt.LaunchedEffect(obj4, (Function2)containerColor2, composer, i51 &= 14);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj9 = obj4;
                    modalBottomSheetProperties = properties2;
                    i24 = i9;
                    l = l3;
                    obj = obj2;
                    $dirty1 = f2;
                    $composer2 = obj11;
                    l5 = l4;
                    l6 = l2;
                    f = f3;
                    sheetState2 = anon5;
                    i27 = $dirty3;
                } else {
                    rememberedValue2.skipToGroupEnd();
                    function2 = content;
                    i24 = $dirty15;
                    composer = rememberedValue2;
                    l5 = containerColor2;
                    l6 = $dirty4;
                    obj9 = obj4;
                    $composer2 = obj7;
                    $dirty1 = sheetMaxWidth;
                    f = dragHandle;
                    l = contentWindowInsets;
                    sheetState2 = $composer;
                    modalBottomSheetProperties = $changed;
                    i27 = $dirty3;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $composer4 = composer;
            endRestartGroup = new ModalBottomSheetKt.ModalBottomSheet.5(obj5, obj, obj9, $dirty1, $composer2, l5, str, l6, containerColor2, f, l, dragHandle2, function2, sheetState2, modalBottomSheetProperties, $changed1, obj64, obj65, obj66);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer4 = composer;
            $composer3 = obj;
            modifier2 = function2;
        }
    }

    public static final void ModalBottomSheetContent-IQkwcL4(BoxScope $this$ModalBottomSheetContent_u2dIQkwcL4, Animatable<Float, AnimationVector1D> predictiveBackProgress, CoroutineScope scope, Function0<Unit> animateToDismiss, Function1<? super Float, Unit> settleToDismiss, Modifier modifier, androidx.compose.material3.SheetState sheetState, float sheetMaxWidth, Shape shape, long containerColor, long contentColor, float tonalElevation, Function2<? super Composer, ? super Integer, Unit> dragHandle, Function2<? super Composer, ? super Integer, ? extends WindowInsets> contentWindowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i19) {
        int i7;
        float $dirty12;
        int $dirty13;
        int $dirty16;
        Object $dirty1;
        int i18;
        Object invalid$iv2;
        Object endRestartGroup;
        Object obj9;
        int i22;
        int $dirty15;
        int i10;
        Object rememberedValue;
        Object $i$a$CacheModalBottomSheetKt$ModalBottomSheetContent$5;
        int changed4;
        int i17;
        Object invalid$iv;
        boolean changed2;
        int changed;
        int obj8;
        Object obj;
        int skipping;
        int defaultsInvalid;
        int sheetMaxWidth-D9Ej5fM;
        int expandedShape;
        int shape3;
        int i8;
        int i28;
        int i6;
        int iNSTANCE;
        boolean traceInProgress;
        int i21;
        int $i$f$cache;
        int str;
        Object sheetMaxWidth3;
        int $dirty;
        long $dirty3;
        long l5;
        Object obj11;
        int i33;
        long l;
        float containerColor3;
        int changed5;
        int i24;
        Object it$iv;
        int i9;
        int changedInstance3;
        Object obj10;
        Object obj6;
        Object obj2;
        float shape2;
        int i30;
        boolean changedInstance;
        int i11;
        Object obj3;
        long l3;
        int containerColor4;
        int i34;
        Object containerColor2;
        Object obj5;
        int $i$f$cache2;
        Object empty;
        long l2;
        float f;
        Object sheetMaxWidth2;
        Object obj4;
        long l4;
        Object shape4;
        int i20;
        int i12;
        int i5;
        float tonalElevation3;
        int tonalElevation2;
        float f2;
        Object obj7;
        int modifier2;
        Object function2;
        int i31;
        int i14;
        int changedInstance5;
        Object dragHandle2;
        androidx.compose.material3.ModalBottomSheetKt.ModalBottomSheetContent.1 anon;
        int changedInstance4;
        int contentColor2;
        long contentColor3;
        int i26;
        int changedInstance2;
        int companion3;
        int i;
        int i2;
        int companion2;
        Composer composer;
        int i3;
        int i13;
        int i32;
        int changed6;
        int companion;
        int i15;
        int i27;
        int changed7;
        int $dirty4;
        int $dirty2;
        float sheetMaxWidth4;
        int changed3;
        int $dirty14;
        int draggableState$material3_release;
        boolean vertical;
        boolean visible;
        int i16;
        boolean animationRunning;
        int i23;
        androidx.compose.material3.ModalBottomSheetKt.ModalBottomSheetContent.4.1 anon2;
        int i4;
        int i25;
        int i29;
        ScopeUpdateScope scopeUpdateScope;
        int obj45;
        int obj46;
        Object obj47;
        Object obj48;
        Object obj49;
        Function0 obj50;
        CoroutineScope obj51;
        Function3 obj52;
        Object obj53;
        obj8 = $this$ModalBottomSheetContent_u2dIQkwcL4;
        obj = predictiveBackProgress;
        final Object obj13 = settleToDismiss;
        int i35 = i19;
        int i54 = obj59;
        str = obj60;
        Composer restartGroup = $changed1.startRestartGroup(-1676960531);
        ComposerKt.sourceInformation(restartGroup, "C(ModalBottomSheetContent)P(7,8!1,9,6,12,11:c#ui.unit.Dp,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.unit.Dp,5,4)205@9432L31,207@9563L13,208@9626L14,209@9668L31,215@10018L48,224@10294L324,232@10728L1476,267@12552L23,269@12621L112,273@12765L612,288@13518L2623,217@10072L6069:ModalBottomSheet.kt#uh7d8r");
        $dirty = i19;
        int i76 = obj59;
        if (i88 &= str != 0) {
            $dirty |= 6;
        } else {
            if (i35 & 6 == 0) {
                i30 = restartGroup.changed(obj8) ? 4 : 2;
                $dirty |= i30;
            }
        }
        if (str & 1 != 0) {
            $dirty |= 48;
        } else {
            if (i35 & 48 == 0) {
                if (i35 & 64 == 0) {
                    changedInstance = restartGroup.changed(obj);
                } else {
                    changedInstance = restartGroup.changedInstance(obj);
                }
                i11 = changedInstance != null ? 32 : 16;
                $dirty |= i11;
            }
        }
        if (str & 2 != 0) {
            $dirty |= 384;
            obj3 = scope;
        } else {
            if (i35 & 384 == 0) {
                i31 = restartGroup.changedInstance(scope) ? 256 : 128;
                $dirty |= i31;
            } else {
                obj3 = scope;
            }
        }
        i26 = 1024;
        if (str & 4 != 0) {
            $dirty |= 3072;
            obj5 = animateToDismiss;
        } else {
            if (i35 & 3072 == 0) {
                i14 = restartGroup.changedInstance(animateToDismiss) ? changedInstance4 : i26;
                $dirty |= i14;
            } else {
                obj5 = animateToDismiss;
            }
        }
        if (str & 8 != 0) {
            $dirty |= 24576;
        } else {
            if (i35 & 24576 == 0) {
                i20 = restartGroup.changedInstance(obj13) ? 16384 : i;
                $dirty |= i20;
            }
        }
        i12 = str & 16;
        i2 = 196608;
        if (i12 != 0) {
            $dirty |= i2;
            obj7 = modifier;
        } else {
            if (i35 & i2 == 0) {
                i3 = restartGroup.changed(modifier) ? 131072 : 65536;
                $dirty |= i3;
            } else {
                obj7 = modifier;
            }
        }
        int i107 = 1572864;
        if (i35 & i107 == 0) {
            if (str & 32 == 0) {
                changed6 = restartGroup.changed(sheetState) ? 1048576 : 524288;
            } else {
                obj4 = sheetState;
            }
            $dirty |= changed6;
        } else {
            obj4 = sheetState;
        }
        companion = str & 64;
        i15 = 12582912;
        if (companion != 0) {
            $dirty |= i15;
            f = sheetMaxWidth;
        } else {
            if (i35 & i15 == 0) {
                i27 = restartGroup.changed(sheetMaxWidth) ? 8388608 : 4194304;
                $dirty |= i27;
            } else {
                f = sheetMaxWidth;
            }
        }
        if (i35 & i108 == 0) {
            if (str & 128 == 0) {
                changed7 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                shape4 = shape;
            }
            $dirty |= changed7;
        } else {
            shape4 = shape;
        }
        if (i35 & i110 == 0) {
            if (str & 256 == 0) {
                $dirty4 = $dirty;
                i7 = i76;
                changed3 = restartGroup.changed(containerColor) ? 536870912 : 268435456;
            } else {
                $dirty4 = $dirty;
                i7 = i76;
                $dirty3 = containerColor;
            }
            $dirty4 |= changed3;
        } else {
            $dirty2 = $dirty;
            i7 = i76;
            $dirty3 = containerColor;
        }
        if (i54 & 6 == 0) {
            if (str & 512 == 0) {
                i22 = restartGroup.changed(tonalElevation) ? 4 : 2;
            } else {
                l5 = tonalElevation;
            }
            $dirty14 = i7;
        } else {
            l5 = tonalElevation;
            $dirty14 = i7;
        }
        $dirty12 = str & 1024;
        if ($dirty12 != 0) {
            $dirty14 |= 48;
            draggableState$material3_release = $dirty12;
        } else {
            if (i54 & 48 == 0) {
                draggableState$material3_release = $dirty12;
                changedInstance2 = restartGroup.changed(contentWindowInsets) ? 32 : 16;
                $dirty14 |= changedInstance2;
            } else {
                draggableState$material3_release = $dirty12;
                $dirty12 = contentWindowInsets;
            }
        }
        $dirty13 = $dirty14;
        int i65 = str & 2048;
        if (i65 != 0) {
            $dirty13 |= 384;
            obj6 = content;
        } else {
            if (i54 & 384 == 0) {
                changedInstance5 = restartGroup.changedInstance(content) ? 256 : 128;
                $dirty13 |= changedInstance5;
            } else {
                obj6 = content;
            }
        }
        final int obj57 = $dirty13;
        if (i54 & 3072 == 0) {
            if (str & 4096 == 0) {
                if (restartGroup.changedInstance($composer)) {
                } else {
                    changedInstance4 = i26;
                }
            } else {
                obj9 = $composer;
            }
            $dirty16 = changedInstance5;
        } else {
            Object obj12 = $composer;
            $dirty16 = obj57;
        }
        if (str & 8192 != 0) {
            $dirty16 |= 24576;
            obj11 = $changed;
        } else {
            if (i54 & 24576 == 0) {
                if (restartGroup.changedInstance($changed)) {
                    i = 16384;
                }
                $dirty16 |= i;
            } else {
                obj11 = $changed;
            }
        }
        if ($dirty2 & contentColor2 == 306783378 && $dirty16 & 9363 == 9362) {
            if ($dirty16 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i67 = 0;
                    if (i19 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                obj7 = defaultsInvalid;
                            }
                            if (str & 32 != 0) {
                                $dirty2 &= i100;
                                obj4 = sheetMaxWidth-D9Ej5fM;
                            }
                            if (companion != 0) {
                                f = sheetMaxWidth-D9Ej5fM;
                            }
                            int i103 = 6;
                            if (str & 128 != 0) {
                                $dirty2 &= i101;
                                shape4 = expandedShape;
                            }
                            if (str & 256 != 0) {
                                $dirty2 &= shape3;
                                l = contentColor2;
                            } else {
                                l = containerColor;
                            }
                            if (str & 512 != 0) {
                                contentColor3 = ColorSchemeKt.contentColorFor-ek8zF_U(l, obj6, restartGroup);
                                $dirty16 &= -15;
                            } else {
                                contentColor3 = tonalElevation;
                            }
                            if (draggableState$material3_release != 0) {
                                tonalElevation3 = BottomSheetDefaults.INSTANCE.getElevation-D9Ej5fM();
                            } else {
                                tonalElevation3 = contentWindowInsets;
                            }
                            if (i65 != 0) {
                                dragHandle2 = ComposableSingletons.ModalBottomSheetKt.INSTANCE.getLambda-2$material3_release();
                            } else {
                                dragHandle2 = content;
                            }
                            if (str & 4096 != 0) {
                                l3 = l;
                                containerColor3 = f;
                                obj2 = shape4;
                                shape4 = tonalElevation3;
                                tonalElevation2 = $dirty18;
                                sheetMaxWidth2 = iNSTANCE;
                                $dirty1 = obj7;
                                modifier2 = $dirty2;
                            } else {
                                l3 = l;
                                containerColor3 = f;
                                obj2 = shape4;
                                shape4 = tonalElevation3;
                                sheetMaxWidth2 = $composer;
                                tonalElevation2 = $dirty16;
                                $dirty1 = obj7;
                                modifier2 = $dirty2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (str & 32 != 0) {
                                $dirty2 &= i8;
                            }
                            if (str & 128 != 0) {
                                $dirty2 &= i28;
                            }
                            if (str & 256 != 0) {
                                $dirty2 &= i6;
                            }
                            if (str & 512 != 0) {
                                $dirty16 &= -15;
                            }
                            if (str & 4096 != 0) {
                                $dirty16 &= -7169;
                            }
                            l3 = containerColor;
                            contentColor3 = tonalElevation;
                            tonalElevation2 = $dirty16;
                            dragHandle2 = obj6;
                            containerColor3 = f;
                            obj2 = shape4;
                            $dirty1 = obj7;
                            modifier2 = $dirty2;
                            shape4 = contentWindowInsets;
                            sheetMaxWidth2 = $composer;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1676960531, modifier2, tonalElevation2, "androidx.compose.material3.ModalBottomSheetContent (ModalBottomSheet.kt:214)");
                    }
                    androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
                    int i63 = 0;
                    str = string-2EP1pXo;
                    int i41 = 1;
                    int shape5 = 0;
                    String str3 = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1237857395, str3);
                    if (i60 ^= i107 > 1048576) {
                        if (!restartGroup.changed(obj4)) {
                            i10 = modifier2 & i107 == 1048576 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer3 = restartGroup;
                    int i106 = 0;
                    rememberedValue = composer3.rememberedValue();
                    companion2 = 0;
                    if (i10 == 0) {
                        sheetMaxWidth4 = containerColor3;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            containerColor3 = 0;
                            obj47 = rememberedValue;
                            composer3.updateRememberedValue(SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(obj4, Orientation.Vertical, obj13));
                        } else {
                            obj47 = rememberedValue;
                        }
                    } else {
                        sheetMaxWidth4 = containerColor3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i68 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1237872435, str3);
                    if (i71 ^= i107 > 1048576) {
                        if (!restartGroup.changed(obj4)) {
                            i24 = modifier2 & i107 == 1048576 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer6 = restartGroup;
                    $i$f$cache2 = 0;
                    it$iv = composer6.rememberedValue();
                    companion3 = 0;
                    if (i24 == 0) {
                        obj47 = $i$f$cache2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache2 = 0;
                            obj48 = it$iv;
                            it$iv = new ModalBottomSheetKt.ModalBottomSheetContent.3.1(obj4);
                            composer6.updateRememberedValue((Function2)it$iv);
                        } else {
                            obj48 = it$iv;
                        }
                    } else {
                        obj47 = $i$f$cache2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1237929350, str3);
                    i18 = i38 &= modifier2 == 16384 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    $i$f$cache = 0;
                    Object rememberedValue2 = composer2.rememberedValue();
                    int i91 = 0;
                    if (i18 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            $i$f$cache2 = 0;
                            obj46 = i18;
                            obj47 = $i$f$cache;
                            invalid$iv2 = new ModalBottomSheetKt.ModalBottomSheetContent.4.1(obj13, 0);
                            composer2.updateRememberedValue((Function3)invalid$iv2);
                        } else {
                            obj46 = i18;
                            obj47 = $i$f$cache;
                            invalid$iv2 = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1237931647, str3);
                    changed2 = restartGroup.changed(str);
                    Composer composer4 = restartGroup;
                    int i72 = 0;
                    Object rememberedValue4 = composer4.rememberedValue();
                    empty = 0;
                    if (!changed2) {
                        obj46 = changed2;
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            obj47 = invalid$iv3;
                            $i$a$CacheModalBottomSheetKt$ModalBottomSheetContent$5 = new ModalBottomSheetKt.ModalBottomSheetContent.5.1(str);
                            composer4.updateRememberedValue((Function1)$i$a$CacheModalBottomSheetKt$ModalBottomSheetContent$5);
                        } else {
                            $i$a$CacheModalBottomSheetKt$ModalBottomSheetContent$5 = rememberedValue4;
                        }
                    } else {
                        obj46 = changed2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i62 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1237936755, str3);
                    if (i46 ^= i107 > 1048576) {
                        if (!restartGroup.changed(obj4)) {
                            i17 = modifier2 & i107 == 1048576 ? 1 : i62;
                        } else {
                        }
                    } else {
                    }
                    if (modifier2 & 112 != 32) {
                        if (modifier2 & 64 != 0 && restartGroup.changedInstance(obj)) {
                            if (restartGroup.changedInstance(obj)) {
                                i9 = 1;
                            } else {
                                i9 = i62;
                            }
                        } else {
                        }
                    } else {
                    }
                    i17 |= i9;
                    Composer composer5 = restartGroup;
                    int i74 = 0;
                    Object rememberedValue3 = composer5.rememberedValue();
                    int i93 = 0;
                    if (i47 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            obj45 = i47;
                            invalid$iv = new ModalBottomSheetKt.ModalBottomSheetContent.6.1(obj4, obj);
                            composer5.updateRememberedValue((Function1)invalid$iv);
                        } else {
                            obj45 = i47;
                            invalid$iv = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj45 = anon3;
                    obj46 = sheetMaxWidth2;
                    obj49 = obj4;
                    obj48 = dragHandle2;
                    super(obj46, obj, obj48, obj49, animateToDismiss, scope, $changed);
                    int i98 = 1;
                    f = contentColor3;
                    contentColor2 = restartGroup;
                    Object $dirty19 = obj53;
                    $dirty2 = i96;
                    long $dirty5 = companion;
                    SurfaceKt.Surface-T9BRK9s(GraphicsLayerModifierKt.graphicsLayer(SemanticsModifierKt.semantics$default(DraggableKt.draggable$default(AnchoredDraggableKt.draggableAnchors(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxWidth$default(SizeKt.widthIn-VpY3zN4$default(obj8.align($dirty1, Alignment.Companion.getTopCenter()), 0, containerColor3, i41, shape5), 0, i41, shape5), (NestedScrollConnection)rememberedValue, i68, 2, i68), obj4.getAnchoredDraggableState$material3_release(), Orientation.Vertical, (Function2)it$iv), obj4.getAnchoredDraggableState$material3_release().getDraggableState$material3_release(), Orientation.Vertical, obj4.isVisible(), 0, obj4.getAnchoredDraggableState$material3_release().isAnimationRunning(), 0, (Function3)invalid$iv2, false, 168, 0), i62, (Function1)$i$a$CacheModalBottomSheetKt$ModalBottomSheetContent$5, 1, 0), (Function1)invalid$iv), $dirty19, $dirty5, i98, f, obj4, shape4, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-692668920, i98, obj45, restartGroup, 54), contentColor2);
                    composer = contentColor2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj10 = $dirty16;
                    i13 = obj8;
                    function2 = obj;
                    anon = skipping;
                    f2 = shape4;
                    l4 = f;
                    l2 = $dirty5;
                    containerColor2 = $dirty19;
                    shape2 = $composer2;
                    sheetMaxWidth3 = i;
                } else {
                    restartGroup.skipToGroupEnd();
                    f2 = contentWindowInsets;
                    anon = $composer;
                    i13 = $dirty16;
                    composer = restartGroup;
                    obj10 = obj4;
                    containerColor2 = shape4;
                    sheetMaxWidth3 = obj7;
                    l4 = tonalElevation;
                    function2 = obj6;
                    shape2 = f;
                    l2 = containerColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ModalBottomSheetKt.ModalBottomSheetContent.8($this$ModalBottomSheetContent_u2dIQkwcL4, predictiveBackProgress, scope, animateToDismiss, obj13, sheetMaxWidth3, obj10, shape2, containerColor2, l2, f, l4, shape4, f2, function2, anon, $changed, i19, obj59, obj60);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void Scrim-3J-VO9M(long color, Function0<Unit> onDismissRequest, boolean visible, Composer $composer, int $changed) {
        int traceInProgress2;
        int $i$f$isSpecified8_81llA;
        boolean anon;
        int $dirty;
        int i6;
        int i3;
        int i15;
        boolean string-2EP1pXo;
        boolean traceInProgress;
        int i2;
        int str;
        int empty;
        Composer cmp;
        int i12;
        int i;
        int i11;
        Object rememberedValue;
        int i4;
        int i10;
        Composer i7;
        int i8;
        int i14;
        int empty2;
        int empty3;
        int anon3;
        Object anon2;
        int $dirty2;
        int i13;
        int companion;
        int i9;
        int i5;
        int companion2;
        final long l = color;
        final Object obj = visible;
        anon = $composer;
        final int i18 = obj27;
        traceInProgress2 = 951870469;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(0:c#ui.graphics.Color)410@18376L87,411@18489L29,426@19112L79,426@19062L129:ModalBottomSheet.kt#uh7d8r");
        if (i18 & 6 == 0) {
            i6 = restartGroup.changed(l) ? 4 : 2;
            $dirty |= i6;
        }
        anon3 = 32;
        if (i18 & 48 == 0) {
            i3 = restartGroup.changedInstance(obj) ? anon3 : 16;
            $dirty |= i3;
        }
        if (i18 & 384 == 0) {
            i15 = restartGroup.changed(anon) ? 256 : 128;
            $dirty |= i15;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:407)");
                }
                int i16 = 0;
                i12 = 1;
                rememberedValue = 0;
                $i$f$isSpecified8_81llA = Long.compare(string-2EP1pXo, i27) != 0 ? i12 : rememberedValue;
                if ($i$f$isSpecified8_81llA != 0) {
                    i2 = anon ? 1065353216 : 0;
                    TweenSpec tweenSpec3 = new TweenSpec(0, 0, 0, 7, 0);
                    $dirty2 = $dirty;
                    int i17 = i13;
                    $dirty = AnimateAsStateKt.animateFloatAsState(i2, (AnimationSpec)tweenSpec3, 0, 0, 0, restartGroup, 48, 28);
                    androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
                    int i21 = 0;
                    string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.close_sheet), restartGroup, i17);
                    restartGroup.startReplaceGroup(-1785653838);
                    ComposerKt.sourceInformation(restartGroup, "414@18629L44,415@18730L263");
                    String str4 = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if (anon) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1785652017, str4);
                        i4 = $dirty2 & 112 == anon3 ? empty3 : i17;
                        Composer composer = restartGroup;
                        companion = 0;
                        Object rememberedValue2 = composer.rememberedValue();
                        i5 = 0;
                        if (i4 == 0) {
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                empty3 = 0;
                                anon2 = new ModalBottomSheetKt.Scrim.dismissSheet.1.1(obj, 0);
                                composer.updateRememberedValue((Function2)anon2);
                            } else {
                                anon2 = rememberedValue2;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1785648566, str4);
                        i10 = $dirty2 & 112 == 32 ? 1 : 0;
                        i7 = restartGroup;
                        i14 = 0;
                        Object rememberedValue3 = i7.rememberedValue();
                        anon3 = 0;
                        if (changed4 |= i10 == 0) {
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                empty = 0;
                                anon = new ModalBottomSheetKt.Scrim.dismissSheet.2.1(string-2EP1pXo, obj);
                                i7.updateRememberedValue((Function1)anon);
                            } else {
                                anon = rememberedValue3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        $i$f$isSpecified8_81llA = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon2), true, (Function1)anon);
                    } else {
                        $i$f$isSpecified8_81llA = Modifier.Companion;
                    }
                    restartGroup.endReplaceGroup();
                    empty2 = 1;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1785636526, str4);
                    i11 = $dirty2 & 14 == 4 ? empty2 : 0;
                    cmp = restartGroup;
                    i12 = 0;
                    rememberedValue = cmp.rememberedValue();
                    i8 = 0;
                    if (changed3 |= i11 == 0) {
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
                    CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, empty2, 0).then($i$f$isSpecified8_81llA), (Function1)anon3, restartGroup, 0);
                } else {
                    $dirty2 = $dirty;
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
            traceInProgress2 = new ModalBottomSheetKt.Scrim.2(l, obj2, obj, $composer, i18);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final float Scrim_3J_VO9M$lambda$10(State<Float> $alpha$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (Number)$alpha$delegate.getValue().floatValue();
    }

    public static final void access$Scrim-3J-VO9M(long color, Function0 onDismissRequest, boolean visible, Composer $composer, int $changed) {
        ModalBottomSheetKt.Scrim-3J-VO9M(color, onDismissRequest, visible, $composer, $changed);
    }

    public static final float access$Scrim_3J_VO9M$lambda$10(State $alpha$delegate) {
        return ModalBottomSheetKt.Scrim_3J_VO9M$lambda$10($alpha$delegate);
    }

    public static final float access$calculatePredictiveBackScaleX(GraphicsLayerScope $receiver, float progress) {
        return ModalBottomSheetKt.calculatePredictiveBackScaleX($receiver, progress);
    }

    public static final float access$calculatePredictiveBackScaleY(GraphicsLayerScope $receiver, float progress) {
        return ModalBottomSheetKt.calculatePredictiveBackScaleY($receiver, progress);
    }

    public static final long access$getPredictiveBackChildTransformOrigin$p() {
        return ModalBottomSheetKt.PredictiveBackChildTransformOrigin;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope $this$calculatePredictiveBackScaleX, float progress) {
        boolean naN;
        int i2;
        int i;
        float width-impl = Size.getWidth-impl($this$calculatePredictiveBackScaleX.getSize-NH-jbRc());
        if (!Float.isNaN(width-impl)) {
            naN = 0;
            i = Float.compare(width-impl, naN) == 0 ? 1 : 0;
            if (i != 0) {
            } else {
                i2 -= naN;
            }
        } else {
        }
        return i2;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope $this$calculatePredictiveBackScaleY, float progress) {
        boolean naN;
        int i;
        int i2;
        float height-impl = Size.getHeight-impl($this$calculatePredictiveBackScaleY.getSize-NH-jbRc());
        if (!Float.isNaN(height-impl)) {
            naN = 0;
            i2 = Float.compare(height-impl, naN) == 0 ? 1 : 0;
            if (i2 != 0) {
            } else {
                i -= naN;
            }
        } else {
        }
        return i;
    }

    public static final androidx.compose.material3.SheetState rememberModalBottomSheetState(boolean skipPartiallyExpanded, Function1<? super androidx.compose.material3.SheetValue, Boolean> confirmValueChange, Composer $composer, int $changed, int i5) {
        int i;
        androidx.compose.material3.ModalBottomSheetKt.rememberModalBottomSheetState.1 anon;
        int obj8;
        androidx.compose.material3.ModalBottomSheetKt.rememberModalBottomSheetState.1 obj9;
        final int i2 = -778250030;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberModalBottomSheetState)P(1)400@18058L160:ModalBottomSheet.kt#uh7d8r");
        i = i5 & 1 != 0 ? obj8 : skipPartiallyExpanded;
        if (i5 & 2 != 0) {
            anon = obj9;
        } else {
            anon = confirmValueChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:400)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SheetDefaultsKt.rememberSheetState(i, anon, SheetValue.Hidden, false, composer, obj8 | obj9, 8);
    }
}
