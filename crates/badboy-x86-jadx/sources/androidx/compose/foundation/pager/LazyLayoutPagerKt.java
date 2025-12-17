package androidx.compose.foundation.pager;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aÞ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"21\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\u0008'¢\u0006\u0002\u0008(H\u0001ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a\u0081\u0001\u0010+\u001a\u0008\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0004\u001a\u00020\u000521\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\u0008'¢\u0006\u0002\u0008(2#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u00100,H\u0003¢\u0006\u0002\u0010/\u001a\u0014\u00100\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00061", d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-uYRUAWA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZIFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutPagerKt {
    public static final void Pager-uYRUAWA(Modifier modifier, androidx.compose.foundation.pager.PagerState state, PaddingValues contentPadding, boolean reverseLayout, Orientation orientation, TargetedFlingBehavior flingBehavior, boolean userScrollEnabled, int beyondViewportPageCount, float pageSpacing, androidx.compose.foundation.pager.PageSize pageSize, NestedScrollConnection pageNestedScrollConnection, Function1<? super Integer, ? extends Object> key, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, SnapPosition snapPosition, Function4<? super androidx.compose.foundation.pager.PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i20) {
        float f2;
        Object obj4;
        int i2;
        Object obj7;
        Object obj2;
        Object obj3;
        Object obj;
        Object obj11;
        int $dirty3;
        int skipping;
        float pageSpacing2;
        int i22;
        Object it$iv2;
        int i11;
        ScopeUpdateScope endRestartGroup;
        boolean traceInProgress;
        int i18;
        Object obj8;
        Object pagerItemProvider;
        int $dirty4;
        Object compositionCoroutineScope;
        int i19;
        Object it$iv;
        int i9;
        int i6;
        int i17;
        int $dirty1;
        Object compositionScopedCoroutineScopeCanceller;
        int coroutineScope2;
        int i8;
        int i4;
        Object nestedScroll$default;
        boolean prefetchState$foundation_release;
        int i23;
        int i14;
        int i24;
        int i3;
        int $dirty2;
        int i;
        int i15;
        int empty2;
        float f;
        Object pagerBringIntoViewSpec;
        Object obj9;
        int empty;
        Object obj10;
        int coroutineScope;
        Object coroutineScope4;
        int rememberPagerMeasurePolicy-8u0NR3k;
        Composer $composer2;
        int changed2;
        int i10;
        int i21;
        int i12;
        Object obj5;
        int companion3;
        int i13;
        int i16;
        int changed;
        int companion2;
        Object obj6;
        kotlinx.coroutines.CoroutineScope coroutineScope3;
        int $dirty5;
        int $dirty6;
        Composer composer;
        Composer.Companion companion;
        int i7;
        int $dirty;
        int i5;
        int changedInstance;
        Object it$iv$iv;
        ScopeUpdateScope scopeUpdateScope;
        androidx.compose.foundation.pager.PagerBringIntoViewSpec obj34;
        Function0 obj35;
        int obj43;
        obj8 = state;
        Object obj19 = flingBehavior;
        obj9 = pageNestedScrollConnection;
        int i158 = $changed;
        coroutineScope = $changed1;
        int i160 = i20;
        $composer2 = $composer.startRestartGroup(538371694);
        ComposerKt.sourceInformation($composer2, "C(Pager)P(5,13,1,11,6,2,14!1,10:c#ui.unit.Dp,9,8,4!1,15,12)111@5277L19,107@5162L134,113@5323L24,128@5906L19,115@5373L558,131@5957L92,136@6083L94,140@6237L7,141@6278L147,152@6576L277,166@7108L154,172@7425L7,165@7052L482,176@7548L385,148@6431L1730:LazyLayoutPager.kt#g6yjnt");
        $dirty4 = $changed;
        $dirty1 = $changed1;
        if (i160 & 1 != 0) {
            $dirty4 |= 6;
        } else {
            if (i158 & 6 == 0) {
                i8 = $composer2.changed(modifier) ? 4 : 2;
                $dirty4 |= i8;
            }
        }
        if (i160 & 2 != 0) {
            $dirty4 |= 48;
        } else {
            if (i158 & 48 == 0) {
                i4 = $composer2.changed(obj8) ? 32 : 16;
                $dirty4 |= i4;
            }
        }
        i12 = 128;
        if (i160 & 4 != 0) {
            $dirty4 |= 384;
            nestedScroll$default = contentPadding;
        } else {
            if (i158 & 384 == 0) {
                i13 = $composer2.changed(contentPadding) ? changed2 : i12;
                $dirty4 |= i13;
            } else {
                nestedScroll$default = contentPadding;
            }
        }
        int i171 = 1024;
        if (i160 & 8 != 0) {
            $dirty4 |= 3072;
            prefetchState$foundation_release = reverseLayout;
        } else {
            if (i158 & 3072 == 0) {
                i16 = $composer2.changed(reverseLayout) ? companion2 : i171;
                $dirty4 |= i16;
            } else {
                prefetchState$foundation_release = reverseLayout;
            }
        }
        if (i160 & 16 != 0) {
            $dirty4 |= 24576;
        } else {
            if (i158 & 24576 == 0) {
                i14 = $composer2.changed(orientation) ? 16384 : 8192;
                $dirty4 |= i14;
            }
        }
        int i172 = 196608;
        if (i160 & 32 != 0) {
            $dirty4 |= i172;
        } else {
            if (i158 & i172 == 0) {
                i24 = $composer2.changed(obj19) ? 131072 : 65536;
                $dirty4 |= i24;
            }
        }
        if (i160 & 64 != 0) {
            i3 = 1572864;
            $dirty4 |= i3;
        } else {
        }
        $dirty2 = i160 & 128;
        i7 = 12582912;
        if ($dirty2 != 0) {
            $dirty4 |= i7;
            rememberPagerMeasurePolicy-8u0NR3k = beyondViewportPageCount;
        } else {
            if (i158 & i7 == 0) {
                i5 = $composer2.changed(beyondViewportPageCount) ? 8388608 : 4194304;
                $dirty4 |= i5;
            } else {
                rememberPagerMeasurePolicy-8u0NR3k = beyondViewportPageCount;
            }
        }
        int i41 = i160 & 256;
        changedInstance = 100663296;
        if (i41 != 0) {
            $dirty4 |= changedInstance;
            f2 = pageSpacing;
        } else {
            if (i158 & changedInstance == null) {
                changedInstance = $composer2.changed(pageSpacing) ? 67108864 : 33554432;
                $dirty4 |= changedInstance;
            } else {
                f2 = pageSpacing;
            }
        }
        if (i160 & 512 != 0) {
            $dirty4 |= i40;
            obj4 = pageSize;
        } else {
            if (i38 &= i158 == 0) {
                changedInstance = $composer2.changed(pageSize) ? 536870912 : 268435456;
                $dirty4 |= changedInstance;
            } else {
                obj4 = pageSize;
            }
        }
        if (i160 & 1024 != 0) {
            $dirty1 |= 6;
        } else {
            if (coroutineScope & 6 == 0) {
                i2 = $composer2.changedInstance(obj9) ? 4 : 2;
                $dirty1 |= i2;
            }
        }
        if (i160 & 2048 != 0) {
            $dirty1 |= 48;
            obj7 = key;
        } else {
            if (coroutineScope & 48 == 0) {
                changed = $composer2.changedInstance(key) ? 32 : 16;
                $dirty1 |= changed;
            } else {
                obj7 = key;
            }
        }
        if (i160 & 4096 != 0) {
            $dirty1 |= 384;
            obj2 = horizontalAlignment;
        } else {
            if (coroutineScope & 384 == 0) {
                if ($composer2.changed(horizontalAlignment)) {
                } else {
                    changed2 = i12;
                }
                $dirty1 |= changed2;
            } else {
                obj2 = horizontalAlignment;
            }
        }
        if (i160 & 8192 != 0) {
            $dirty1 |= 3072;
            obj3 = verticalAlignment;
        } else {
            if (coroutineScope & 3072 == 0) {
                if ($composer2.changed(verticalAlignment)) {
                } else {
                    companion2 = i171;
                }
                $dirty1 |= companion2;
            } else {
                obj3 = verticalAlignment;
            }
        }
        if (i160 & 16384 != 0) {
            $dirty1 |= 24576;
            obj = snapPosition;
        } else {
            if (coroutineScope & 24576 == 0) {
                changed2 = $composer2.changed(snapPosition) ? 16384 : 8192;
                $dirty1 |= changed2;
            } else {
                obj = snapPosition;
            }
        }
        if (i160 & i161 != 0) {
            $dirty1 |= i172;
            obj11 = pageContent;
        } else {
            if (coroutineScope & i172 == 0) {
                i10 = $composer2.changedInstance(pageContent) ? 131072 : 65536;
                $dirty1 |= i10;
            } else {
                obj11 = pageContent;
            }
        }
        if ($dirty4 & i162 == 306783378 && i33 &= $dirty1 == 74898) {
            if (i33 &= $dirty1 == 74898) {
                if (!$composer2.getSkipping()) {
                    if ($dirty2 != 0) {
                        rememberPagerMeasurePolicy-8u0NR3k = skipping;
                    }
                    if (i41 != 0) {
                        i11 = 0;
                        pageSpacing2 = Dp.constructor-impl((float)i36);
                    } else {
                        pageSpacing2 = pageSpacing;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(538371694, $dirty4, $dirty1, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:101)");
                    }
                    int i169 = 1;
                    i = rememberPagerMeasurePolicy-8u0NR3k >= 0 ? i169 : 0;
                    if (i == 0) {
                    } else {
                        obj34 = 0;
                        String str = "CC(remember):LazyLayoutPager.kt#9igjgp";
                        ComposerKt.sourceInformationMarkerStart($composer2, 1863502769, str);
                        i22 = $dirty4 & 112 == 32 ? i169 : obj34;
                        Composer composer7 = $composer2;
                        int i163 = 0;
                        it$iv2 = composer7.rememberedValue();
                        int i167 = 0;
                        if (i22 == 0) {
                            $dirty6 = $dirty4;
                            if (it$iv2 == Composer.Companion.getEmpty()) {
                                $dirty4 = 0;
                                obj6 = it$iv2;
                                it$iv2 = new LazyLayoutPagerKt.Pager.pagerItemProvider.1.1(obj8);
                                composer7.updateRememberedValue((Function0)it$iv2);
                            } else {
                                obj6 = it$iv2;
                            }
                        } else {
                            $dirty6 = $dirty4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        int i34 = $dirty6;
                        $dirty5 = $dirty1;
                        ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        obj43 = i53;
                        ComposerKt.sourceInformationMarkerStart($composer2, -954363344, "CC(remember):Effects.kt#9igjgp");
                        Composer composer8 = $composer2;
                        int i164 = 0;
                        companion3 = i54;
                        compositionCoroutineScope = composer8.rememberedValue();
                        int i170 = 0;
                        changedInstance = i67;
                        if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                            int i174 = 0;
                            it$iv$iv = compositionCoroutineScope;
                            companion = i86;
                            compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, $composer2));
                            composer8.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        } else {
                            compositionScopedCoroutineScopeCanceller = it$iv$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        coroutineScope2 = (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, 1863522897, str);
                        i19 = i34 & 112 == 32 ? i169 : obj34;
                        Composer composer5 = $composer2;
                        int i132 = 0;
                        it$iv = composer5.rememberedValue();
                        int i165 = 0;
                        if (i19 == 0) {
                            coroutineScope3 = coroutineScope2;
                            if (it$iv == Composer.Companion.getEmpty()) {
                                coroutineScope2 = 0;
                                obj5 = it$iv;
                                it$iv = new LazyLayoutPagerKt.Pager.measurePolicy.1.1(obj8);
                                composer5.updateRememberedValue((Function0)it$iv);
                            } else {
                                obj5 = it$iv;
                            }
                        } else {
                            coroutineScope3 = coroutineScope2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        int i173 = 458752;
                        Orientation orientation4 = orientation;
                        obj43 = i34;
                        int i137 = rememberPagerMeasurePolicy-8u0NR3k;
                        kotlinx.coroutines.CoroutineScope coroutineScope8 = coroutineScope3;
                        float f3 = obj35;
                        Object obj15 = obj8;
                        Function0 function0 = rememberPagerItemProviderLambda;
                        Orientation orientation3 = orientation4;
                        int i159 = i137;
                        kotlinx.coroutines.CoroutineScope coroutineScope7 = coroutineScope8;
                        coroutineScope4 = obj15;
                        i9 = orientation3 == Orientation.Vertical ? i169 : obj34;
                        androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState rememberPagerSemanticState = PagerSemanticsKt.rememberPagerSemanticState(coroutineScope4, i9, $composer2, i77 &= 14);
                        ComposerKt.sourceInformationMarkerStart($composer2, 1863528636, str);
                        i6 = obj43 & 112 == 32 ? i169 : obj34;
                        i23 = obj43 & i173 == 131072 ? i169 : obj34;
                        Composer composer6 = $composer2;
                        int i139 = 0;
                        Object rememberedValue2 = composer6.rememberedValue();
                        int i154 = 0;
                        if (i6 |= i23 == 0) {
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                empty = 0;
                                obj35 = function0;
                                pagerItemProvider = new PagerWrapperFlingBehavior(obj19, coroutineScope4);
                                composer6.updateRememberedValue(pagerItemProvider);
                            } else {
                                obj35 = function0;
                                pagerItemProvider = rememberedValue2;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        int i60 = 6;
                        int i115 = 0;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Object obj21 = consume2;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1863534929, str);
                        i18 = obj43 & 112 == 32 ? i169 : obj34;
                        Composer composer2 = $composer2;
                        int i61 = 0;
                        Object rememberedValue = composer2.rememberedValue();
                        int i141 = 0;
                        if (i18 |= changed3 == 0) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                pagerBringIntoViewSpec = new PagerBringIntoViewSpec(coroutineScope4, obj21);
                                composer2.updateRememberedValue(pagerBringIntoViewSpec);
                            } else {
                                pagerBringIntoViewSpec = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        boolean z2 = userScrollEnabled;
                        Function0 function02 = obj35;
                        i7 = rememberPagerSemanticState;
                        i17 = orientation3 == Orientation.Vertical ? i169 : obj34;
                        int i148 = 0;
                        int i156 = 0;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        int i146 = obj43;
                        i11 = obj20;
                        $dirty3 = i146;
                        changed = coroutineScope5;
                        Composer composer12 = $composer2;
                        Composer composer10 = composer12;
                        $dirty1 = companion2;
                        LazyLayoutKt.LazyLayout($dirty1, NestedScrollModifierKt.nestedScroll$default(LazyLayoutPagerKt.dragDirectionDetector(ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(PagerKt.pagerSemantics(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then((Modifier)coroutineScope4.getRemeasurementModifier$foundation_release()).then((Modifier)coroutineScope4.getAwaitLayoutModifier$foundation_release()), function02, rememberPagerSemanticState, orientation3, z2, reverseLayout, $composer2, i119 | i145), coroutineScope4, i17, coroutineScope7, z2), PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(coroutineScope4, i159, $composer2, i63 |= i80), coroutineScope4.getBeyondBoundsInfo$foundation_release(), reverseLayout, (LayoutDirection)$composer2.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()), orientation3, z2, $composer2, i46 |= i153), (ScrollableState)coroutineScope4, orientation, userScrollEnabled, reverseLayout, (FlingBehavior)(PagerWrapperFlingBehavior)pagerItemProvider, coroutineScope4.getInternalInteractionSource$foundation_release(), (BringIntoViewSpec)(PagerBringIntoViewSpec)pagerBringIntoViewSpec, composer12, i83 |= i93, 0), coroutineScope4), pageNestedScrollConnection, 0, 2, 0), coroutineScope4.getPrefetchState$foundation_release(), PagerMeasurePolicyKt.rememberPagerMeasurePolicy-8u0NR3k(function0, obj15, contentPadding, reverseLayout, orientation4, i137, f3, pageSize, horizontalAlignment, verticalAlignment, snapPosition, coroutineScope8, (Function0)it$iv, $composer2, i75 | i112, i76 & 14), composer10, 0, 0);
                        obj8 = $dirty1;
                        composer = composer10;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i15 = $composer2;
                        f = i21;
                        endRestartGroup = composer.endRestartGroup();
                        if (endRestartGroup != null) {
                            $dirty = i123;
                            $dirty3 = new LazyLayoutPagerKt.Pager.2(modifier, coroutineScope4, contentPadding, reverseLayout, orientation, flingBehavior, userScrollEnabled, i15, f, pageSize, obj10, key, horizontalAlignment, verticalAlignment, snapPosition, pageContent, $changed, $changed1, i20);
                            endRestartGroup.updateScope((Function2)$dirty3);
                        } else {
                            $dirty = $dirty3;
                        }
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    f = pageSpacing;
                    coroutineScope4 = obj8;
                    $dirty3 = $dirty4;
                    $dirty5 = $dirty1;
                    obj10 = obj9;
                    i15 = rememberPagerMeasurePolicy-8u0NR3k;
                    composer = $composer2;
                }
            } else {
            }
        } else {
        }
        float f4 = pageSpacing2;
        Composer composer13 = $composer2;
        int pageSpacing4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("beyondViewportPageCount should be greater than or equal to 0, you selected ").append(rememberPagerMeasurePolicy-8u0NR3k).toString().toString());
        throw illegalArgumentException;
    }

    private static final Modifier dragDirectionDetector(Modifier $this$dragDirectionDetector, androidx.compose.foundation.pager.PagerState state) {
        LazyLayoutPagerKt.dragDirectionDetector.1 anon = new LazyLayoutPagerKt.dragDirectionDetector.1(state, 0);
        return $this$dragDirectionDetector.then(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, state, (Function2)anon));
    }

    private static final Function0<androidx.compose.foundation.pager.PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(androidx.compose.foundation.pager.PagerState state, Function4<? super androidx.compose.foundation.pager.PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Function1<? super Integer, ? extends Object> key, Function0<Integer> pageCount, Composer $composer, int $changed) {
        Object derivedStateOf;
        boolean traceInProgress;
        String str;
        int changed;
        int i2;
        int i;
        int changed2;
        Object empty;
        androidx.compose.runtime.State derivedStateOf2;
        Object anon;
        final Object obj = state;
        derivedStateOf = pageCount;
        final Composer composer = $composer;
        final int i3 = $changed;
        int i4 = -1372505274;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(rememberPagerItemProviderLambda)P(3,1)259@10522L33,260@10576L25,261@10613L677:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i3, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:258)");
        }
        androidx.compose.runtime.State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(pageContent, composer, i5 &= 14);
        androidx.compose.runtime.State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(key, composer, i7 &= 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1578864961, "CC(remember):LazyLayoutPager.kt#9igjgp");
        int i14 = 1;
        int i16 = 4;
        if (i10 ^= 6 > i16) {
            if (!composer.changed(obj)) {
                i2 = i3 & 6 == i16 ? i14 : i;
            } else {
            }
        } else {
        }
        int i18 = 2048;
        if (i17 ^= 3072 > i18) {
            if (!composer.changed(derivedStateOf)) {
                if (i3 & 3072 == i18) {
                    i = i14;
                }
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i15 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i19 = 0;
        if (i12 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                LazyLayoutPagerKt.rememberPagerItemProviderLambda.1.intervalContentState.1 anon3 = new LazyLayoutPagerKt.rememberPagerItemProviderLambda.1.intervalContentState.1(rememberUpdatedState, rememberUpdatedState2, derivedStateOf);
                LazyLayoutPagerKt.rememberPagerItemProviderLambda.1.itemProviderState.1 anon2 = new LazyLayoutPagerKt.rememberPagerItemProviderLambda.1.itemProviderState.1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), (Function0)anon3), obj);
                anon = new LazyLayoutPagerKt.rememberPagerItemProviderLambda.1.1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), (Function0)anon2));
                composer2.updateRememberedValue((KProperty0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (Function0)(KProperty0)anon;
    }
}
