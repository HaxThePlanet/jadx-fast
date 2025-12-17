package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.layout.Arrangement.Vertical;
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
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\u0008\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u009a\u0001\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e¢\u0006\u0002\u0008\u001b2\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tH\u0003¢\u0006\u0002\u0010*¨\u0006+", d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyHeadersEnabled", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;ZLandroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyListKt {
    public static final void LazyList(Modifier modifier, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, boolean isVertical, FlingBehavior flingBehavior, boolean userScrollEnabled, int beyondBoundsItemCount, Alignment.Horizontal horizontalAlignment, Arrangement.Vertical verticalArrangement, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, Function1<? super androidx.compose.foundation.lazy.LazyListScope, Unit> content, Composer $composer, int $changed, int $changed1, int i17) {
        Object obj3;
        Object endRestartGroup;
        Object composer$iv;
        int $dirty;
        Object itemProviderLambda;
        Object compositionCoroutineScope;
        Object i12;
        Object obj4;
        Object obj5;
        Object obj6;
        int changedInstance;
        CoroutineScope i16;
        Object skipping;
        int beyondBoundsItemCount2;
        Object empty;
        int z3;
        int i6;
        boolean z2;
        int $dirty2;
        int $dirty4;
        int $dirty1;
        int i2;
        int i21;
        int horizontalAlignment2;
        Orientation horizontal;
        int i3;
        int i;
        Object obj2;
        int i29;
        boolean z;
        int i28;
        int i19;
        Object obj;
        int i14;
        int i8;
        int verticalArrangement2;
        int i9;
        int verticalAlignment2;
        Composer restartGroup;
        int i22;
        int horizontalArrangement2;
        Composer composer;
        int i25;
        int i23;
        int i10;
        int i13;
        int $dirty3;
        int i24;
        int i26;
        int i18;
        int i4;
        int i20;
        int i5;
        int rememberLazyListMeasurePolicy;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        int i15;
        int i27;
        int i7;
        int i11;
        boolean changed;
        Function0 function0;
        androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState lazyLayoutSemanticState;
        ScopeUpdateScope scopeUpdateScope;
        int obj36;
        int obj37;
        Function0 obj38;
        Object obj39;
        Composer obj40;
        itemProviderLambda = state;
        z3 = isVertical;
        obj3 = content;
        int i38 = $changed;
        int i45 = $changed1;
        i6 = i17;
        restartGroup = $composer.startRestartGroup(620764179);
        ComposerKt.sourceInformation(restartGroup, "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)81@3859L50,83@3935L48,84@4009L24,85@4081L7,86@4150L7,88@4183L395,109@4816L278,117@5164L153,123@5480L7,116@5108L481,128@5650L317,105@4671L1429:LazyList.kt#428nma");
        $dirty2 = $changed;
        $dirty1 = $changed1;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i38 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i3;
            }
        }
        if (i6 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i38 & 48 == 0) {
                i = restartGroup.changed(itemProviderLambda) ? 32 : 16;
                $dirty2 |= i;
            }
        }
        int i110 = 128;
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
            obj2 = contentPadding;
        } else {
            if (i38 & 384 == 0) {
                i25 = restartGroup.changed(contentPadding) ? i22 : i110;
                $dirty2 |= i25;
            } else {
                obj2 = contentPadding;
            }
        }
        if (i6 & 8 != 0) {
            $dirty2 |= 3072;
            z = reverseLayout;
        } else {
            if (i38 & 3072 == 0) {
                i23 = restartGroup.changed(reverseLayout) ? 2048 : 1024;
                $dirty2 |= i23;
            } else {
                z = reverseLayout;
            }
        }
        if (i6 & 16 != 0) {
            $dirty2 |= 24576;
        } else {
            if (i38 & 24576 == 0) {
                i19 = restartGroup.changed(z3) ? 16384 : 8192;
                $dirty2 |= i19;
            }
        }
        if (i6 & 32 != 0) {
            $dirty2 |= i101;
            obj = flingBehavior;
        } else {
            if (i99 &= i38 == 0) {
                i24 = restartGroup.changed(flingBehavior) ? 131072 : 65536;
                $dirty2 |= i24;
            } else {
                obj = flingBehavior;
            }
        }
        if (i6 & 64 != 0) {
            $dirty2 |= i26;
            z2 = userScrollEnabled;
        } else {
            if (i38 & i122 == 0) {
                i4 = restartGroup.changed(userScrollEnabled) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                z2 = userScrollEnabled;
            }
        }
        i8 = i6 & 128;
        i20 = 12582912;
        if (i8 != 0) {
            $dirty2 |= i20;
            i9 = beyondBoundsItemCount;
        } else {
            if (i38 & i20 == 0) {
                i5 = restartGroup.changed(beyondBoundsItemCount) ? 8388608 : 4194304;
                $dirty2 |= i5;
            } else {
                i9 = beyondBoundsItemCount;
            }
        }
        int i39 = i6 & 256;
        int i125 = 100663296;
        if (i39 != 0) {
            $dirty2 |= i125;
            rememberLazyListMeasurePolicy = i39;
            i12 = horizontalAlignment;
        } else {
            if ($changed & i125 == 0) {
                rememberLazyListMeasurePolicy = i39;
                i15 = restartGroup.changed(horizontalAlignment) ? 67108864 : 33554432;
                $dirty2 |= i15;
            } else {
                rememberLazyListMeasurePolicy = i39;
                i12 = horizontalAlignment;
            }
        }
        int i40 = i6 & 512;
        int i128 = 805306368;
        if (i40 != 0) {
            $dirty2 |= i128;
            i27 = i40;
            obj4 = verticalArrangement;
        } else {
            if ($changed & i128 == 0) {
                i27 = i40;
                i7 = restartGroup.changed(verticalArrangement) ? 536870912 : 268435456;
                $dirty2 |= i7;
            } else {
                i27 = i40;
                obj4 = verticalArrangement;
            }
        }
        int i41 = i6 & 1024;
        if (i41 != 0) {
            $dirty1 |= 6;
            i11 = i41;
            obj5 = verticalAlignment;
        } else {
            if (i45 & 6 == 0) {
                i11 = i41;
                i10 = restartGroup.changed(verticalAlignment) ? 4 : 2;
                $dirty1 |= i10;
            } else {
                i11 = i41;
                obj5 = verticalAlignment;
            }
        }
        int i42 = i6 & 2048;
        if (i42 != 0) {
            $dirty1 |= 48;
            i13 = i42;
            obj6 = horizontalArrangement;
        } else {
            if (i45 & 48 == 0) {
                i13 = i42;
                i4 = restartGroup.changed(horizontalArrangement) ? 32 : 16;
                $dirty1 |= i4;
            } else {
                i13 = i42;
                obj6 = horizontalArrangement;
            }
        }
        if (i6 & 4096 != 0) {
            $dirty1 |= 384;
        } else {
            if (i45 & 384 == 0) {
                if (restartGroup.changedInstance(obj3)) {
                } else {
                    i22 = i110;
                }
                $dirty1 |= i22;
            }
        }
        i16 = $dirty1;
        if ($dirty13 &= $dirty2 == 306783378 && i16 & 147 == 146) {
            if (i16 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    beyondBoundsItemCount2 = i8 != 0 ? 0 : i9;
                    horizontalAlignment2 = rememberLazyListMeasurePolicy != 0 ? 0 : horizontalAlignment;
                    verticalArrangement2 = i27 != 0 ? 0 : verticalArrangement;
                    verticalAlignment2 = i11 != 0 ? 0 : verticalAlignment;
                    horizontalArrangement2 = i13 != 0 ? 0 : horizontalArrangement;
                    if (ComposerKt.isTraceInProgress()) {
                        obj36 = beyondBoundsItemCount2;
                        ComposerKt.traceEventStart(620764179, $dirty2, i16, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                    } else {
                        obj36 = beyondBoundsItemCount2;
                    }
                    int i64 = 0;
                    int i113 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    Composer composer2 = restartGroup;
                    i18 = i16;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                    Composer composer3 = restartGroup;
                    int i123 = 0;
                    obj37 = i37;
                    compositionCoroutineScope = composer3.rememberedValue();
                    int i124 = 0;
                    if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                        empty = 0;
                        int i126 = 0;
                        obj39 = compositionCoroutineScope;
                        obj40 = composer2;
                        composer$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer2));
                        composer3.updateRememberedValue(composer$iv);
                    } else {
                        obj40 = composer2;
                        composer$iv = obj39;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i43 = 0;
                    int i48 = 0;
                    int i65 = 2023513938;
                    String str = "CC:CompositionLocal.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, i65, str);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i49 = 0;
                    int i114 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, i65, str);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i4 = 57344;
                    i20 = 458752;
                    int i84 = i79;
                    z2 = obj36;
                    CoroutineScope coroutineScope3 = coroutineScope;
                    obj36 = $dirty2;
                    int $dirty5 = horizontalAlignment2;
                    int i87 = verticalArrangement2;
                    int horizontalAlignment4 = verticalAlignment2;
                    Function0 coroutineScope2 = obj38;
                    Object verticalArrangement3 = this_$iv;
                    int verticalAlignment3 = i44;
                    androidx.compose.foundation.lazy.LazyListState stickyHeadersEnabled = state;
                    skipping = verticalArrangement3;
                    z3 = verticalAlignment3;
                    itemProviderLambda = stickyHeadersEnabled;
                    i16 = coroutineScope3;
                    horizontal = isVertical ? Orientation.Vertical : Orientation.Horizontal;
                    Function0 function03 = horizontalAlignment3;
                    Orientation orientation4 = orientation;
                    Composer composer5 = restartGroup;
                    androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState orientation2 = rememberLazyListSemanticState;
                    lazyLayoutSemanticState = orientation2;
                    Composer composer6 = composer5;
                    int i104 = 0;
                    int i108 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer6, 2023513938, str);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    $dirty = obj36;
                    Orientation orientation7 = orientation5;
                    Orientation orientation3 = orientation7;
                    i22 = composer6;
                    obj3 = orientation3;
                    Composer composer4 = restartGroup;
                    LazyLayoutKt.LazyLayout(function03, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then((Modifier)itemProviderLambda.getRemeasurementModifier$foundation_release()).then((Modifier)itemProviderLambda.getAwaitLayoutModifier$foundation_release()), function03, orientation2, orientation4, userScrollEnabled, reverseLayout, composer5, i97 |= i103), LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(itemProviderLambda, z2, composer6, i81 |= i89), itemProviderLambda.getBeyondBoundsInfo$foundation_release(), reverseLayout, (LayoutDirection)composer6.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()), orientation7, userScrollEnabled, composer6, i32 | i107).then(itemProviderLambda.getItemAnimator$foundation_release().getModifier()), (ScrollableState)itemProviderLambda, orientation3, userScrollEnabled, reverseLayout, flingBehavior, itemProviderLambda.getInternalInteractionSource$foundation_release(), 0, i22, i35 | i94, 64), itemProviderLambda.getPrefetchState$foundation_release(), LazyListKt.rememberLazyListMeasurePolicy(coroutineScope2, stickyHeadersEnabled, obj2, z, z3, z2, $dirty5, horizontalAlignment4, i84, i87, coroutineScope3, verticalArrangement3, verticalAlignment3, restartGroup, i57 |= i78, 0), composer4, 0, 0);
                    composer = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i2 = i6;
                    $dirty4 = z2;
                    i28 = i27;
                    i14 = i11;
                    i29 = changed;
                } else {
                    restartGroup.skipToGroupEnd();
                    i2 = horizontalAlignment;
                    i29 = verticalArrangement;
                    i28 = verticalAlignment;
                    i14 = horizontalArrangement;
                    i18 = i16;
                    $dirty = $dirty2;
                    $dirty4 = i9;
                    composer = restartGroup;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = $dirty;
            endRestartGroup = new LazyListKt.LazyList.1(modifier, itemProviderLambda, contentPadding, reverseLayout, isVertical, flingBehavior, userScrollEnabled, $dirty4, i2, i29, i28, i14, content, $changed, $changed1, i17);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty3 = $dirty;
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(Function0<? extends androidx.compose.foundation.lazy.LazyListItemProvider> itemProviderLambda, androidx.compose.foundation.lazy.LazyListState state, PaddingValues contentPadding, boolean reverseLayout, boolean isVertical, int beyondBoundsItemCount, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, CoroutineScope coroutineScope, GraphicsContext graphicsContext, boolean stickyHeadersEnabled, Composer $composer, int $changed, int $changed1) {
        Object empty;
        int changed5;
        int i5;
        boolean traceInProgress;
        int i13;
        int i7;
        boolean z2;
        Object obj;
        boolean changed2;
        boolean changed6;
        int i4;
        int i8;
        Object it$iv;
        Object obj3;
        int i11;
        Object obj6;
        Object obj7;
        boolean z;
        boolean changed4;
        int i3;
        Object obj4;
        int i2;
        int i9;
        Object obj8;
        int i12;
        boolean changed7;
        int i;
        int i6;
        Object obj9;
        boolean changed;
        int i10;
        boolean z3;
        boolean changed3;
        int it$iv2;
        boolean changed8;
        Object obj2;
        Object obj5;
        Object obj10;
        empty = $composer;
        final int i14 = $changed;
        final int i15 = $changed1;
        int i16 = 1972347046;
        ComposerKt.sourceInformationMarkerStart(empty, i16, "C(rememberLazyListMeasurePolicy)P(7,9,1,8,6!1,4,11,5,12)170@7305L8413:LazyList.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i16, i14, i15, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:170)");
        }
        ComposerKt.sourceInformationMarkerStart(empty, 581121742, "CC(remember):LazyList.kt#9igjgp");
        int i28 = 32;
        if (i18 ^= 48 > i28) {
            if (!empty.changed(state)) {
                i5 = i14 & 48 == i28 ? 1 : 0;
            } else {
            }
        } else {
            obj3 = state;
        }
        int i35 = 256;
        if (i29 ^= 384 > i35) {
            if (!empty.changed(contentPadding)) {
                i13 = i14 & 384 == i35 ? 1 : 0;
            } else {
            }
        } else {
            obj7 = contentPadding;
        }
        int i36 = 2048;
        if (i30 ^= 3072 > i36) {
            if (!empty.changed(reverseLayout)) {
                i7 = i14 & 3072 == i36 ? 1 : 0;
            } else {
            }
        } else {
            z = reverseLayout;
        }
        int i37 = 16384;
        if (i32 ^= 24576 > i37) {
            if (!empty.changed(isVertical)) {
                i11 = i14 & 24576 == i37 ? 1 : 0;
            } else {
            }
        } else {
            z2 = isVertical;
        }
        i2 = 1572864;
        int i44 = 1048576;
        if (i39 ^= i2 > i44) {
            if (!empty.changed(horizontalAlignment)) {
                i3 = i2 &= i14 == i44 ? 1 : 0;
            } else {
            }
        } else {
            obj6 = horizontalAlignment;
        }
        i12 = 12582912;
        int i48 = 8388608;
        if (i42 ^= i12 > i48) {
            if (!empty.changed(verticalAlignment)) {
                i9 = i12 &= i14 == i48 ? 1 : 0;
            } else {
            }
        } else {
            obj4 = verticalAlignment;
        }
        i = 100663296;
        int i52 = 67108864;
        if (i46 ^= i > i52) {
            if (!empty.changed(horizontalArrangement)) {
                i6 = i &= i14 == i52 ? 1 : 0;
            } else {
            }
        } else {
            obj8 = horizontalArrangement;
        }
        i10 = 805306368;
        int i34 = 536870912;
        if (i50 ^= i10 > i34) {
            if (!empty.changed(verticalArrangement)) {
                i4 = i10 &= i14 == i34 ? 1 : 0;
            } else {
            }
        } else {
            obj9 = verticalArrangement;
        }
        Object obj11 = graphicsContext;
        if (i53 ^= 384 > i35) {
            if (!empty.changed(stickyHeadersEnabled)) {
                it$iv2 = i15 & 384 == i35 ? 1 : 0;
            } else {
            }
        } else {
            z3 = stickyHeadersEnabled;
        }
        Composer composer = $composer;
        final int i55 = 0;
        it$iv = composer.rememberedValue();
        final int i56 = 0;
        if (i26 |= it$iv2 == 0) {
            if (it$iv == Composer.Companion.getEmpty()) {
                empty = 0;
                obj = obj12;
                it$iv = new LazyListKt.rememberLazyListMeasurePolicy.1.1(obj3, z2, obj7, z, itemProviderLambda, obj9, obj8, z3, beyondBoundsItemCount, coroutineScope, obj11, obj6, obj4);
                composer.updateRememberedValue((Function2)it$iv);
            } else {
                obj = it$iv;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Function2)it$iv;
    }
}
