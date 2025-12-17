package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a", d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridKt {
    public static final void LazyStaggeredGrid-LJWHXA8(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, Orientation orientation, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider slots, Modifier modifier, PaddingValues contentPadding, boolean reverseLayout, FlingBehavior flingBehavior, boolean userScrollEnabled, float mainAxisSpacing, float crossAxisSpacing, Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj5;
        boolean z;
        float f6;
        float i8;
        int i11;
        Object composer$iv;
        Object graphicsContext;
        Object compositionCoroutineScope;
        Object obj4;
        int $dirty;
        int $dirty2;
        int defaultsInvalid;
        Object modifier2;
        Object obj8;
        Object empty;
        boolean obj9;
        int $dirty1;
        int i24;
        float mainAxisSpacing2;
        boolean mainAxisSpacing3;
        Object userScrollEnabled3;
        int i6;
        Object obj2;
        float f;
        Object obj;
        boolean flingBehavior2;
        float reverseLayout2;
        FlingBehavior $composer2;
        int userScrollEnabled2;
        int userScrollEnabled4;
        int i14;
        int i16;
        int i19;
        Object contentPadding2;
        boolean traceInProgress;
        float f5;
        boolean changedInstance;
        Object flingBehavior3;
        float f2;
        int i13;
        int i9;
        Object obj6;
        int i4;
        Object $this$dp$iv;
        int i17;
        int i2;
        FlingBehavior $i$f$getDp;
        Composer composer;
        int i;
        int i3;
        int i10;
        int changed;
        int i7;
        int i20;
        int i12;
        int i5;
        int i21;
        int i22;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        int i23;
        int i18;
        kotlin.jvm.functions.Function2 rememberStaggeredGridMeasurePolicy-qKj4JfE;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        Object obj3;
        Object obj7;
        float f3;
        float f4;
        androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState lazyLayoutSemanticState;
        androidx.compose.ui.Modifier.Companion obj33;
        Modifier obj34;
        Object obj35;
        Composer obj36;
        Composer obj37;
        int obj38;
        int obj39;
        obj4 = state;
        obj9 = slots;
        obj6 = content;
        i4 = $changed;
        final int i115 = i15;
        Composer restartGroup = $composer.startRestartGroup(288295126);
        ComposerKt.sourceInformation(restartGroup, "C(LazyStaggeredGrid)P(9,6,8,5,1,7,3,10,4:c#ui.unit.Dp,2:c#ui.unit.Dp)51@2370L15,61@2769L55,62@2850L24,63@2922L7,64@2954L266,76@3245L60,82@3456L278,90@3804L57,93@4024L7,89@3748L385,98@4194L316,78@3311L1332:LazyStaggeredGrid.kt#fzvcnm");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (i115 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i4 & 6 == 0) {
                i6 = restartGroup.changedInstance(obj4) ? 4 : 2;
                $dirty |= i6;
            }
        }
        if (i115 & 2 != 0) {
            $dirty |= 48;
            obj2 = orientation;
        } else {
            if (i4 & 48 == 0) {
                i16 = restartGroup.changed(orientation) ? 32 : 16;
                $dirty |= i16;
            } else {
                obj2 = orientation;
            }
        }
        if (i115 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i4 & 384 == 0) {
                if (i4 & 512 == 0) {
                    changedInstance = restartGroup.changed(obj9);
                } else {
                    changedInstance = restartGroup.changedInstance(obj9);
                }
                i19 = changedInstance != null ? 256 : 128;
                $dirty |= i19;
            }
        }
        contentPadding2 = i115 & 8;
        if (contentPadding2 != 0) {
            $dirty |= 3072;
            flingBehavior3 = modifier;
        } else {
            if (i4 & 3072 == 0) {
                i13 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i13;
            } else {
                flingBehavior3 = modifier;
            }
        }
        i9 = i115 & 16;
        if (i9 != 0) {
            $dirty |= 24576;
            $this$dp$iv = contentPadding;
        } else {
            if (i4 & 24576 == 0) {
                i17 = restartGroup.changed(contentPadding) ? 16384 : 8192;
                $dirty |= i17;
            } else {
                $this$dp$iv = contentPadding;
            }
        }
        i2 = i115 & 32;
        i = 196608;
        if (i2 != 0) {
            $dirty |= i;
            flingBehavior2 = reverseLayout;
        } else {
            if (i4 & i == 0) {
                i = restartGroup.changed(reverseLayout) ? 131072 : 65536;
                $dirty |= i;
            } else {
                flingBehavior2 = reverseLayout;
            }
        }
        if (i4 & i119 == 0) {
            if (i115 & 64 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 1048576 : 524288;
            } else {
                obj5 = flingBehavior;
            }
            $dirty |= changed;
        } else {
            obj5 = flingBehavior;
        }
        int i85 = i115 & 128;
        i20 = 12582912;
        if (i85 != 0) {
            $dirty |= i20;
            z = userScrollEnabled;
        } else {
            if (i4 & i20 == 0) {
                i20 = restartGroup.changed(userScrollEnabled) ? 8388608 : 4194304;
                $dirty |= i20;
            } else {
                z = userScrollEnabled;
            }
        }
        int i26 = i115 & 256;
        int i120 = 100663296;
        if (i26 != 0) {
            $dirty |= i120;
            i12 = i26;
            f6 = mainAxisSpacing;
        } else {
            if (i4 & i120 == 0) {
                i12 = i26;
                i5 = restartGroup.changed(mainAxisSpacing) ? 67108864 : 33554432;
                $dirty |= i5;
            } else {
                i12 = i26;
                f6 = mainAxisSpacing;
            }
        }
        int i27 = i115 & 512;
        int i123 = 805306368;
        if (i27 != 0) {
            $dirty |= i123;
            i21 = i27;
            i8 = crossAxisSpacing;
        } else {
            if (i4 & i123 == 0) {
                i21 = i27;
                i22 = restartGroup.changed(crossAxisSpacing) ? 536870912 : 268435456;
                $dirty |= i22;
            } else {
                i21 = i27;
                i8 = crossAxisSpacing;
            }
        }
        if (i115 & 1024 != 0) {
            $dirty1 |= 6;
        } else {
            if ($changed1 & 6 == 0) {
                i11 = restartGroup.changedInstance(obj6) ? 4 : 2;
                $dirty1 |= i11;
            }
        }
        int i28 = $dirty1;
        final int obj41 = $dirty;
        if ($dirty13 &= $dirty == 306783378 && i28 & 3 == 2) {
            if (i28 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (i4 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (contentPadding2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = flingBehavior3;
                            }
                            if (i9 != 0) {
                                flingBehavior3 = 0;
                                contentPadding2 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl((float)i95));
                            } else {
                                contentPadding2 = $this$dp$iv;
                            }
                            if (i2 != 0) {
                                flingBehavior2 = 0;
                            }
                            if (i115 & 64 != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(restartGroup, 6);
                                i9 = obj41 & i112;
                            } else {
                                flingBehavior3 = flingBehavior;
                                i9 = obj41;
                            }
                            userScrollEnabled2 = i85 != 0 ? 1 : userScrollEnabled;
                            if (i12 != 0) {
                                i2 = 0;
                                mainAxisSpacing2 = Dp.constructor-impl((float)$this$dp$iv);
                            } else {
                                mainAxisSpacing2 = mainAxisSpacing;
                            }
                            if (i21 != 0) {
                                int i118 = 0;
                                $this$dp$iv = obj33;
                                f = mainAxisSpacing2;
                                mainAxisSpacing3 = flingBehavior2;
                                i7 = userScrollEnabled2;
                                $i$f$getDp = flingBehavior3;
                                userScrollEnabled4 = i9;
                                reverseLayout2 = constructor-impl;
                                obj8 = contentPadding2;
                            } else {
                                $this$dp$iv = obj33;
                                f = mainAxisSpacing2;
                                mainAxisSpacing3 = flingBehavior2;
                                i7 = userScrollEnabled2;
                                obj8 = contentPadding2;
                                $i$f$getDp = flingBehavior3;
                                userScrollEnabled4 = i9;
                                reverseLayout2 = crossAxisSpacing;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i115 & 64 != 0) {
                                $i$f$getDp = flingBehavior;
                                i7 = userScrollEnabled;
                                f = mainAxisSpacing;
                                userScrollEnabled4 = i33;
                                mainAxisSpacing3 = flingBehavior2;
                                obj8 = $this$dp$iv;
                                reverseLayout2 = crossAxisSpacing;
                                $this$dp$iv = flingBehavior3;
                            } else {
                                $i$f$getDp = flingBehavior;
                                i7 = userScrollEnabled;
                                f = mainAxisSpacing;
                                userScrollEnabled4 = obj41;
                                mainAxisSpacing3 = flingBehavior2;
                                obj8 = $this$dp$iv;
                                reverseLayout2 = crossAxisSpacing;
                                $this$dp$iv = flingBehavior3;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288295126, userScrollEnabled4, i28, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:60)");
                    }
                    int i105 = 0;
                    int i113 = 0;
                    i10 = i28;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    Composer composer2 = restartGroup;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                    Composer composer3 = restartGroup;
                    int i121 = 0;
                    obj34 = i30;
                    compositionCoroutineScope = composer3.rememberedValue();
                    int i125 = 0;
                    if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                        empty = 0;
                        int i126 = 0;
                        obj35 = compositionCoroutineScope;
                        obj36 = composer2;
                        composer$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer2));
                        composer3.updateRememberedValue(composer$iv);
                    } else {
                        obj36 = composer2;
                        composer$iv = obj35;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i34 = 0;
                    int i42 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i12 = 57344;
                    i21 = 458752;
                    Object obj11 = obj33;
                    boolean z2 = mainAxisSpacing3;
                    Composer composer7 = restartGroup;
                    i23 = userScrollEnabled4;
                    i18 = 6;
                    kotlinx.coroutines.CoroutineScope $composer3 = coroutineScope2;
                    kotlin.jvm.functions.Function0 coroutineScope3 = rememberStaggeredGridItemProviderLambda;
                    Object itemProviderLambda3 = this_$iv;
                    graphicsContext = state;
                    coroutineScope = $composer3;
                    obj3 = itemProviderLambda3;
                    Composer coroutineScope4 = composer7;
                    boolean z6 = z2;
                    int i64 = i7;
                    androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState reverseLayout3 = rememberLazyStaggeredGridSemanticState;
                    kotlin.jvm.functions.Function0 semanticState = coroutineScope3;
                    lazyLayoutSemanticState = reverseLayout3;
                    int i87 = 0;
                    int i98 = 0;
                    ComposerKt.sourceInformationMarkerStart(coroutineScope4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(coroutineScope4);
                    Composer composer5 = coroutineScope4;
                    int $composer4 = i58;
                    boolean userScrollEnabled5 = z4;
                    int reverseLayout6 = $composer4;
                    Composer userScrollEnabled6 = composer5;
                    Composer composer6 = composer5;
                    boolean z5 = z3;
                    FlingBehavior flingBehavior4 = $i$f$getDp;
                    obj37 = composer4;
                    obj33 = changed;
                    obj36 = rememberStaggeredGridMeasurePolicy-qKj4JfE;
                    LazyLayoutKt.LazyLayout(obj33, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics($this$dp$iv.then((Modifier)graphicsContext.getRemeasurementModifier$foundation_release()).then((Modifier)graphicsContext.getAwaitLayoutModifier$foundation_release()), semanticState, reverseLayout3, orientation, i64, z6, coroutineScope4, i63 | i73), LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(graphicsContext, coroutineScope4, i23 & 14), graphicsContext.getBeyondBoundsInfo$foundation_release(), userScrollEnabled5, (LayoutDirection)coroutineScope4.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()), orientation, $composer4, composer5, i76 | i93).then(graphicsContext.getItemAnimator$foundation_release().getModifier()), (ScrollableState)graphicsContext, orientation, reverseLayout6, z5, flingBehavior4, graphicsContext.getMutableInteractionSource$foundation_release(), 0, composer6, i69 | i84, 64), graphicsContext.getPrefetchState$foundation_release(), obj36, obj37, 0, 0);
                    obj4 = obj33;
                    $dirty2 = obj36;
                    composer = obj37;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i14 = reverseLayout6;
                    $composer2 = flingBehavior4;
                    userScrollEnabled3 = $this$dp$iv;
                    obj = obj7;
                    f5 = f3;
                    f2 = f4;
                    flingBehavior2 = obj9;
                } else {
                    restartGroup.skipToGroupEnd();
                    i14 = userScrollEnabled;
                    f5 = mainAxisSpacing;
                    i23 = obj41;
                    i10 = i28;
                    graphicsContext = obj4;
                    composer = restartGroup;
                    userScrollEnabled3 = flingBehavior3;
                    obj = $this$dp$iv;
                    $composer2 = flingBehavior;
                    f2 = crossAxisSpacing;
                }
            } else {
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            graphicsContext = new LazyStaggeredGridKt.LazyStaggeredGrid.1(state, orientation, slots, userScrollEnabled3, obj, flingBehavior2, $composer2, i14, f5, f2, obj6, i4, $changed1, i115);
            endRestartGroup.updateScope((Function2)graphicsContext);
        }
    }
}
