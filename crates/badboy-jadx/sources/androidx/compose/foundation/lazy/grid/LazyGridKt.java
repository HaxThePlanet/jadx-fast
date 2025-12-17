package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a~\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001a~\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\u0008\u00172\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010%¨\u0006&", d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridKt {
    public static final void LazyGrid(Modifier modifier, androidx.compose.foundation.lazy.grid.LazyGridState state, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider slots, PaddingValues contentPadding, boolean reverseLayout, boolean isVertical, FlingBehavior flingBehavior, boolean userScrollEnabled, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj6;
        Object obj;
        Object obj3;
        int i17;
        Object $dirty12;
        Object composer$iv;
        Object obj2;
        Object compositionCoroutineScope;
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        Orientation horizontal;
        int i2;
        int $dirty;
        Object $dirty2;
        Object empty;
        int $dirty1;
        Object obj5;
        int i;
        boolean z2;
        int i6;
        Object contentPadding3;
        boolean contentPadding2;
        Object $composer2;
        boolean z;
        boolean traceInProgress;
        boolean $composer3;
        Object flingBehavior2;
        int i7;
        int i11;
        int i13;
        int i3;
        boolean changedInstance;
        Object obj4;
        int i16;
        Object obj7;
        int i8;
        Composer composer;
        Object obj9;
        int i9;
        int i18;
        int i19;
        int changed;
        int i14;
        int i10;
        int i4;
        int i12;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        int i5;
        Function2 rememberLazyGridMeasurePolicy;
        CoroutineScope coroutineScope;
        Object obj8;
        Object obj10;
        androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState lazyLayoutSemanticState;
        int obj28;
        Object obj31;
        Object obj32;
        Object obj34;
        Object obj11 = state;
        Object obj12 = slots;
        boolean z4 = isVertical;
        obj4 = content;
        i16 = $changed;
        final int i102 = i15;
        Composer restartGroup = $composer.startRestartGroup(-649686062);
        ComposerKt.sourceInformation(restartGroup, "C(LazyGrid)P(5,8,7,1,6,4,2,9,10,3)68@3233L15,78@3657L50,80@3733L51,82@3811L24,83@3883L7,84@3915L269,102@4422L278,110@4770L48,113@4981L7,109@4714L376,118@5151L317,98@4277L1324:LazyGrid.kt#7791vq");
        $dirty = $changed;
        $dirty1 = $changed1;
        i6 = i102 & 1;
        if (i6 != 0) {
            $dirty |= 6;
            flingBehavior2 = modifier;
        } else {
            if (i16 & 6 == 0) {
                i7 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i7;
            } else {
                flingBehavior2 = modifier;
            }
        }
        if (i102 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i16 & 48 == 0) {
                i11 = restartGroup.changed(obj11) ? 32 : 16;
                $dirty |= i11;
            }
        }
        if (i102 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i16 & 384 == 0) {
                if (i16 & 512 == 0) {
                    changedInstance = restartGroup.changed(obj12);
                } else {
                    changedInstance = restartGroup.changedInstance(obj12);
                }
                i13 = changedInstance != null ? 256 : 128;
                $dirty |= i13;
            }
        }
        i3 = i102 & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            obj7 = contentPadding;
        } else {
            if (i16 & 3072 == 0) {
                i8 = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                obj7 = contentPadding;
            }
        }
        int i104 = i102 & 16;
        if (i104 != 0) {
            $dirty |= 24576;
            z = reverseLayout;
        } else {
            if (i16 & 24576 == 0) {
                i9 = restartGroup.changed(reverseLayout) ? 16384 : 8192;
                $dirty |= i9;
            } else {
                z = reverseLayout;
            }
        }
        if (i102 & 32 != 0) {
            i18 = 196608;
            $dirty |= i18;
        } else {
        }
        if (i16 & i106 == 0) {
            if (i102 & 64 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                obj6 = flingBehavior;
            }
            $dirty |= changed;
        } else {
            obj6 = flingBehavior;
        }
        if (i102 & 128 != 0) {
            $dirty |= i81;
            $composer3 = userScrollEnabled;
        } else {
            if (i79 &= i16 == 0) {
                i10 = restartGroup.changed(userScrollEnabled) ? 8388608 : 4194304;
                $dirty |= i10;
            } else {
                $composer3 = userScrollEnabled;
            }
        }
        if (i102 & 256 != 0) {
            $dirty |= i29;
            obj = verticalArrangement;
        } else {
            if (i27 &= i16 == 0) {
                i10 = restartGroup.changed(verticalArrangement) ? 67108864 : 33554432;
                $dirty |= i10;
            } else {
                obj = verticalArrangement;
            }
        }
        if (i102 & 512 != 0) {
            $dirty |= i25;
            obj3 = horizontalArrangement;
        } else {
            if (i23 &= i16 == 0) {
                i10 = restartGroup.changed(horizontalArrangement) ? 536870912 : 268435456;
                $dirty |= i10;
            } else {
                obj3 = horizontalArrangement;
            }
        }
        if (i102 & 1024 != 0) {
            $dirty1 |= 6;
        } else {
            if ($changed1 & 6 == 0) {
                i17 = restartGroup.changedInstance(obj4) ? 4 : 2;
                $dirty1 |= i17;
            }
        }
        int i26 = $dirty1;
        if ($dirty14 &= $dirty == 306783378 && i26 & 3 == 2) {
            if (i26 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (i16 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i6 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = flingBehavior2;
                            }
                            if (i3 != 0) {
                                flingBehavior2 = 0;
                                contentPadding3 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl((float)i51));
                            } else {
                                contentPadding3 = obj7;
                            }
                            if (i104 != 0) {
                                z = 0;
                            }
                            if (i102 & 64 != 0) {
                                obj7 = modifier3;
                                modifier2 = $dirty4;
                                $dirty2 = contentPadding3;
                                contentPadding2 = z;
                                obj9 = flingBehavior2;
                            } else {
                                obj9 = flingBehavior;
                                obj7 = modifier3;
                                modifier2 = $dirty;
                                $dirty2 = contentPadding3;
                                contentPadding2 = z;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i102 & 64 != 0) {
                                $dirty &= i2;
                            }
                            obj9 = flingBehavior;
                            modifier2 = $dirty;
                            contentPadding2 = z;
                            $dirty2 = obj7;
                            obj7 = flingBehavior2;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-649686062, modifier2, i26, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:77)");
                    }
                    int i90 = 0;
                    int i99 = 0;
                    i14 = i26;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    Composer composer2 = restartGroup;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                    Composer composer3 = restartGroup;
                    int i108 = 0;
                    obj28 = i30;
                    compositionCoroutineScope = composer3.rememberedValue();
                    int i109 = 0;
                    if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                        empty = 0;
                        int i110 = 0;
                        obj32 = compositionCoroutineScope;
                        obj34 = composer2;
                        composer$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer2));
                        composer3.updateRememberedValue(composer$iv);
                    } else {
                        obj34 = composer2;
                        composer$iv = obj32;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i32 = 0;
                    int i42 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i10 = 57344;
                    i4 = 458752;
                    Object obj14 = obj31;
                    Object obj15 = this_$iv;
                    i12 = modifier2;
                    boolean z3 = contentPadding2;
                    Composer composer10 = restartGroup;
                    Function0 graphicsContext = rememberLazyGridItemProviderLambda;
                    i5 = 6;
                    CoroutineScope itemProviderLambda3 = coroutineScope2;
                    androidx.compose.foundation.lazy.grid.LazyGridState coroutineScope3 = state;
                    $dirty12 = lazyGridState2;
                    coroutineScope = itemProviderLambda3;
                    obj8 = obj15;
                    horizontal = isVertical ? Orientation.Vertical : Orientation.Horizontal;
                    Function0 function03 = function0;
                    boolean z5 = z3;
                    Composer composer7 = composer4;
                    Orientation reverseLayout2 = orientation;
                    androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState orientation2 = rememberLazyGridSemanticState;
                    lazyLayoutSemanticState = orientation2;
                    boolean orientation4 = z5;
                    Composer composer5 = composer7;
                    Orientation orientation5 = semanticState;
                    int i67 = 0;
                    int i82 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    Composer composer8 = composer5;
                    Orientation orientation3 = orientation5;
                    Composer composer9 = composer6;
                    FlingBehavior flingBehavior3 = obj9;
                    boolean $composer6 = orientation4;
                    Composer reverseLayout4 = composer9;
                    $composer3 = orientation3;
                    LazyLayoutKt.LazyLayout(function03, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(obj7.then((Modifier)$dirty12.getRemeasurementModifier$foundation_release()).then((Modifier)$dirty12.getAwaitLayoutModifier$foundation_release()), function03, orientation2, reverseLayout2, userScrollEnabled, z5, composer7, i53 | i58), LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState($dirty12, composer5, itemProviderLambda2 &= 14), $dirty12.getBeyondBoundsInfo$foundation_release(), orientation4, (LayoutDirection)composer5.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()), orientation5, userScrollEnabled, composer8, i60 | i71).then($dirty12.getItemAnimator$foundation_release().getModifier()), (ScrollableState)$dirty12, orientation3, userScrollEnabled, $composer6, flingBehavior3, $dirty12.getInternalInteractionSource$foundation_release(), 0, composer9, i56 | i76, 64), $dirty12.getPrefetchState$foundation_release(), LazyGridKt.rememberLazyGridMeasurePolicy(graphicsContext, coroutineScope3, slots, obj14, z3, z4, horizontalArrangement, verticalArrangement, itemProviderLambda3, obj15, composer10, i38 | i50), reverseLayout4, 0, 0);
                    composer = reverseLayout4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2 = flingBehavior2;
                    obj2 = obj7;
                    obj5 = obj10;
                    z2 = z;
                } else {
                    restartGroup.skipToGroupEnd();
                    i14 = i26;
                    $dirty12 = obj11;
                    i12 = $dirty;
                    composer = restartGroup;
                    obj2 = flingBehavior2;
                    obj5 = obj7;
                    $composer2 = flingBehavior;
                    z2 = z;
                }
            } else {
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty12 = new LazyGridKt.LazyGrid.1(obj2, state, slots, obj5, z2, isVertical, $composer2, userScrollEnabled, verticalArrangement, horizontalArrangement, obj4, i16, $changed1, i102);
            endRestartGroup.updateScope((Function2)$dirty12);
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(Function0<? extends androidx.compose.foundation.lazy.grid.LazyGridItemProvider> itemProviderLambda, androidx.compose.foundation.lazy.grid.LazyGridState state, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider slots, PaddingValues contentPadding, boolean reverseLayout, boolean isVertical, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, CoroutineScope coroutineScope, GraphicsContext graphicsContext, Composer $composer, int $changed) {
        int changed;
        int i3;
        boolean traceInProgress;
        int i7;
        int i9;
        int i10;
        boolean z2;
        Object obj5;
        boolean changed4;
        boolean changed6;
        boolean changed5;
        String str;
        int i4;
        int i;
        int i5;
        int changed7;
        Object it$iv;
        int changed2;
        int i2;
        Object obj3;
        boolean it$iv2;
        Object obj7;
        boolean z;
        boolean changed3;
        Function0 i6;
        Object obj2;
        Object obj6;
        Object obj4;
        CoroutineScope coroutineScope2;
        Object obj;
        int i8;
        final Composer composer = $composer;
        final int i11 = $changed;
        int i12 = -1585069765;
        ComposerKt.sourceInformationMarkerStart(composer, i12, "C(rememberLazyGridMeasurePolicy)P(5,8,7!1,6,4,3,9)161@6721L9334:LazyGrid.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:161)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1026581015, "CC(remember):LazyGrid.kt#9igjgp");
        int i22 = 32;
        i4 = 0;
        int i30 = 1;
        if (i14 ^= 48 > i22) {
            if (!composer.changed(state)) {
                i3 = i11 & 48 == i22 ? i30 : i4;
            } else {
            }
        } else {
            obj3 = state;
        }
        int i31 = 256;
        if (i23 ^= 384 > i31) {
            if (!composer.changed(slots)) {
                i7 = i11 & 384 == i31 ? i30 : i4;
            } else {
            }
        } else {
            obj2 = slots;
        }
        int i32 = 2048;
        if (i24 ^= 3072 > i32) {
            if (!composer.changed(contentPadding)) {
                i9 = i11 & 3072 == i32 ? i30 : i4;
            } else {
            }
        } else {
            obj7 = contentPadding;
        }
        int i33 = 16384;
        if (i26 ^= 24576 > i33) {
            if (!composer.changed(reverseLayout)) {
                i10 = i11 & 24576 == i33 ? i30 : i4;
            } else {
            }
        } else {
            z = reverseLayout;
        }
        i2 = 196608;
        int i38 = 131072;
        if (i28 ^= i2 > i38) {
            if (!composer.changed(isVertical)) {
                i = i2 &= i11 == i38 ? i30 : i4;
            } else {
            }
        } else {
            z2 = isVertical;
        }
        int i39 = 1572864;
        int i40 = 1048576;
        if (i35 ^= i39 > i40) {
            if (!composer.changed(horizontalArrangement)) {
                i5 = i11 & i39 == i40 ? i30 : i4;
            } else {
            }
        } else {
            obj4 = horizontalArrangement;
        }
        it$iv2 = 12582912;
        i6 = 8388608;
        if (i37 ^= it$iv2 > i6) {
            if (!composer.changed(verticalArrangement)) {
                if (i11 & it$iv2 == i6) {
                    i4 = i30;
                }
            } else {
            }
        } else {
            obj6 = verticalArrangement;
        }
        Object obj8 = graphicsContext;
        Composer composer2 = $composer;
        final int i41 = 0;
        it$iv = composer2.rememberedValue();
        final int i42 = 0;
        if (i20 |= changed8 == 0) {
            if (it$iv == Composer.Companion.getEmpty()) {
                i8 = 0;
                obj5 = obj10;
                it$iv = new LazyGridKt.rememberLazyGridMeasurePolicy.1.1(obj3, z2, obj7, z, itemProviderLambda, obj2, obj6, obj4, coroutineScope, obj8);
                composer2.updateRememberedValue((Function2)it$iv);
            } else {
                obj5 = it$iv;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (Function2)it$iv;
    }
}
