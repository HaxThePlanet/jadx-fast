package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u001621\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a\u0091\u0001\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001a}\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'\u001a\u0018\u0010(\u001a\u00020\u00082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0000\u001a\u0018\u0010+\u001a\u00020\u00082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0001\u001a \u0010,\u001a\u00020\u00082\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0008H\u0002\u001a\u0019\u00101\u001a\u00020\u0008*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00102\u001a\u0019\u00103\u001a\u00020\u0008*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00102\u001a:\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u00105\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006;", d2 = {"Carousel", "", "state", "Landroidx/compose/material3/carousel/CarouselState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "maxNonFocalVisibleItemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "content", "Landroidx/compose/material3/carousel/CarouselItemScope;", "itemIndex", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Carousel-V-95POc", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ILandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalMultiBrowseCarousel", "preferredItemWidth", "minSmallItemWidth", "maxSmallItemWidth", "HorizontalMultiBrowseCarousel-zCIJ0Nk", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;FFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "itemWidth", "HorizontalUncontainedCarousel-9QcgTRs", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateCurrentScrollOffset", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "calculateMaxScrollOffset", "getProgress", "before", "Landroidx/compose/material3/carousel/Keyline;", "after", "unadjustedOffset", "calculateAfterContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateBeforeContentPadding", "carouselItem", "index", "Lkotlin/Function0;", "carouselItemInfo", "Landroidx/compose/material3/carousel/CarouselItemInfoImpl;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CarouselKt {
    public static final void Carousel-V-95POc(androidx.compose.material3.carousel.CarouselState state, Orientation orientation, Function2<? super Float, ? super Float, androidx.compose.material3.carousel.KeylineList> keylineList, PaddingValues contentPadding, int maxNonFocalVisibleItemCount, Modifier modifier, float itemSpacing, TargetedFlingBehavior flingBehavior, Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        int $dirty;
        boolean traceInProgress;
        int $this$dp$iv2;
        boolean traceInProgress2;
        int i2;
        int $this$dp$iv;
        int i5;
        int i24;
        int i17;
        int i18;
        int i11;
        int i14;
        int afterContentPadding;
        Object restartGroup;
        Object modifier2;
        Object $i$a$CacheCarouselKt$Carousel$pageSize$1;
        int i22;
        int horizontal;
        int i4;
        Object modifier5;
        float f3;
        Object obj;
        int i15;
        int $dirty2;
        Object obj3;
        Composer $composer2;
        int modifier4;
        float f2;
        int i3;
        int changed;
        int i13;
        float modifier3;
        Object obj2;
        Composer.Companion companion;
        Object obj4;
        int i20;
        int i6;
        int i16;
        int i19;
        androidx.compose.foundation.gestures.snapping.SnapPosition snapPosition;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i7;
        int i8;
        int i;
        float f;
        float startPadding;
        int i9;
        float endPadding;
        int i10;
        int i23;
        int i21;
        PagerState obj43;
        Object obj44;
        int obj45;
        float obj47;
        Object obj6 = orientation;
        Object obj7 = keylineList;
        Object obj8 = contentPadding;
        final Object obj9 = content;
        final int i65 = $changed;
        final int i66 = i12;
        restartGroup = $composer.startRestartGroup(-2035733443);
        ComposerKt.sourceInformation(restartGroup, "C(Carousel)P(8,7,4,1,5,6,3:c#ui.unit.Dp,2)239@11411L41,242@11572L42,243@11660L41,245@11729L118:Carousel.kt#dcf9yb");
        $dirty = $changed;
        if (i66 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i65 & 6 == 0) {
                i24 = restartGroup.changedInstance(state) ? 4 : 2;
                $dirty |= i24;
            }
        }
        if (i66 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i65 & 48 == 0) {
                i17 = restartGroup.changed(obj6) ? 32 : 16;
                $dirty |= i17;
            }
        }
        if (i66 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i65 & 384 == 0) {
                i18 = restartGroup.changedInstance(obj7) ? 256 : 128;
                $dirty |= i18;
            }
        }
        if (i66 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i65 & 3072 == 0) {
                i11 = restartGroup.changed(obj8) ? 2048 : 1024;
                $dirty |= i11;
            }
        }
        if (i66 & 16 != 0) {
            $dirty |= 24576;
            modifier4 = maxNonFocalVisibleItemCount;
        } else {
            if (i65 & 24576 == 0) {
                i14 = restartGroup.changed(maxNonFocalVisibleItemCount) ? 16384 : 8192;
                $dirty |= i14;
            } else {
                modifier4 = maxNonFocalVisibleItemCount;
            }
        }
        afterContentPadding = i66 & 32;
        int i55 = 196608;
        if (afterContentPadding != 0) {
            $dirty |= i55;
            modifier2 = modifier;
        } else {
            if (i55 &= i65 == 0) {
                i22 = restartGroup.changed(modifier) ? 131072 : 65536;
                $dirty |= i22;
            } else {
                modifier2 = modifier;
            }
        }
        horizontal = i66 & 64;
        int i69 = 1572864;
        if (horizontal != 0) {
            $dirty |= i69;
            f2 = itemSpacing;
        } else {
            if (i69 &= i65 == 0) {
                i3 = restartGroup.changed(itemSpacing) ? 1048576 : 524288;
                $dirty |= i3;
            } else {
                f2 = itemSpacing;
            }
        }
        if (i65 & i73 == 0) {
            if (i66 & 128 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj3 = flingBehavior;
            }
            $dirty |= changed;
        } else {
            obj3 = flingBehavior;
        }
        i13 = 100663296;
        if (i66 & 256 != 0) {
            $dirty |= i13;
        } else {
            if (i65 & i13 == 0) {
                i15 = restartGroup.changedInstance(obj9) ? 67108864 : 33554432;
                $dirty |= i15;
            }
        }
        $dirty2 = $dirty;
        if ($dirty3 &= $dirty2 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i74 = -29360129;
                if (i65 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (afterContentPadding != 0) {
                            obj2 = $this$dp$iv;
                        } else {
                            obj2 = modifier2;
                        }
                        if (horizontal != 0) {
                            i5 = 0;
                            f2 = $this$dp$iv;
                        }
                        if (i66 & 128 != 0) {
                            $dirty2 &= i74;
                            obj4 = $this$dp$iv2;
                            modifier2 = obj2;
                            modifier3 = f2;
                        } else {
                            i5 = state;
                            obj4 = obj3;
                            modifier2 = obj2;
                            modifier3 = f2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i66 & 128 != 0) {
                            $dirty2 &= i74;
                            i5 = state;
                            obj4 = obj3;
                            modifier3 = f2;
                        } else {
                            i5 = state;
                            obj4 = obj3;
                            modifier3 = f2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2035733443, $dirty2, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:241)");
                }
                float beforeContentPadding = CarouselKt.calculateBeforeContentPadding(obj8, obj6, restartGroup, i26 |= i43);
                afterContentPadding = CarouselKt.calculateAfterContentPadding(obj8, obj6, restartGroup, i45 |= i58);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2025986753, "CC(remember):Carousel.kt#9igjgp");
                i4 = $dirty2 & 896 == 256 ? 1 : 0;
                f2 = restartGroup;
                changed = 0;
                Object rememberedValue = f2.rememberedValue();
                i13 = 0;
                if (i4 == 0) {
                    obj44 = modifier2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        obj45 = modifier6;
                        $i$a$CacheCarouselKt$Carousel$pageSize$1 = new CarouselPageSize(obj7, beforeContentPadding, afterContentPadding);
                        f2.updateRememberedValue($i$a$CacheCarouselKt$Carousel$pageSize$1);
                    } else {
                        $i$a$CacheCarouselKt$Carousel$pageSize$1 = rememberedValue;
                    }
                } else {
                    obj44 = modifier2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                snapPosition = KeylineSnapPositionKt.KeylineSnapPosition((CarouselPageSize)$i$a$CacheCarouselKt$Carousel$pageSize$1);
                if (obj6 == Orientation.Horizontal) {
                    restartGroup.startReplaceGroup(-1618653092);
                    ComposerKt.sourceInformation(restartGroup, "266@12589L1014,252@11960L1643");
                    CarouselKt.Carousel.1 anon2 = new CarouselKt.Carousel.1(i5, $i$a$CacheCarouselKt$Carousel$pageSize$1, obj9);
                    obj47 = beforeContentPadding;
                    f = afterContentPadding;
                    PagerKt.HorizontalPager-oI3XNZo(i5.getPagerState$material3_release(), obj44, PaddingKt.PaddingValues-a9UjIt4$default(0, obj8.calculateTopPadding-D9Ej5fM(), 0, obj8.calculateBottomPadding-D9Ej5fM(), 5, 0), (PageSize)$i$a$CacheCarouselKt$Carousel$pageSize$1, modifier4, modifier3, 0, obj4, false, false, 0, 0, snapPosition, (Function4)ComposableLambdaKt.rememberComposableLambda(687111200, true, anon2, restartGroup, 54), restartGroup, i2 | afterContentPadding, 3072, 3904);
                    restartGroup.endReplaceGroup();
                    $composer2 = restartGroup;
                } else {
                    obj47 = beforeContentPadding;
                    f = afterContentPadding;
                    if (obj6 == Orientation.Vertical) {
                        restartGroup.startReplaceGroup(-1616959128);
                        ComposerKt.sourceInformation(restartGroup, "300@13962L7,301@14054L7,309@14347L1014,295@13666L1695");
                        int i61 = 0;
                        int i72 = 2023513938;
                        obj44 = i47;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, i72, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        int i62 = 0;
                        obj44 = i48;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, i72, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        CarouselKt.Carousel.2 anon = new CarouselKt.Carousel.2(i5, $i$a$CacheCarouselKt$Carousel$pageSize$1, obj9);
                        composer = restartGroup;
                        PagerKt.VerticalPager-oI3XNZo(i5.getPagerState$material3_release(), obj44, PaddingKt.PaddingValues-a9UjIt4$default(PaddingKt.calculateStartPadding(obj8, (LayoutDirection)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection())), 0, PaddingKt.calculateEndPadding(obj8, (LayoutDirection)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection())), 0, 10, 0), (PageSize)$i$a$CacheCarouselKt$Carousel$pageSize$1, maxNonFocalVisibleItemCount, modifier3, 0, obj4, false, false, 0, 0, snapPosition, (Function4)ComposableLambdaKt.rememberComposableLambda(-817308503, true, anon, restartGroup, 54), composer, i2 | i5, 3072, 3904);
                        composer.endReplaceGroup();
                    } else {
                        $composer2 = restartGroup;
                        $composer2.startReplaceGroup(-1615314857);
                        $composer2.endReplaceGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                f3 = modifier3;
                obj = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                obj = obj3;
                f3 = f2;
                $composer2 = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CarouselKt.Carousel.3(state, obj6, keylineList, contentPadding, maxNonFocalVisibleItemCount, modifier2, f3, obj, obj9, i65, i66);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            modifier5 = modifier2;
        }
    }

    public static final void HorizontalMultiBrowseCarousel-zCIJ0Nk(androidx.compose.material3.carousel.CarouselState state, float preferredItemWidth, Modifier modifier, float itemSpacing, TargetedFlingBehavior flingBehavior, float minSmallItemWidth, float maxSmallItemWidth, PaddingValues contentPadding, Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        int $dirty;
        Object obj3;
        int traceInProgress;
        int i;
        int $this$dp$iv;
        TargetedFlingBehavior singleAdvanceFlingBehavior;
        androidx.compose.material3.carousel.CarouselState empty;
        Object $i$a$CacheCarouselKt$HorizontalMultiBrowseCarousel$1;
        int i15;
        int i3;
        int i18;
        int i5;
        boolean traceInProgress2;
        Object contentPadding2;
        Object obj2;
        int i9;
        int str;
        float f6;
        float obj5;
        Object obj;
        Object modifier2;
        Object f2;
        float f3;
        float itemSpacing2;
        Object obj7;
        float flingBehavior2;
        float f4;
        Object obj6;
        Object restartGroup;
        int i10;
        Object obj8;
        int i16;
        int i2;
        int changed;
        int i7;
        int i8;
        float maxSmallItemWidth2;
        float f;
        int i13;
        int i19;
        int i4;
        Composer composer;
        int companion;
        int i14;
        int i11;
        int $dirty2;
        int i17;
        int i6;
        Object obj4;
        float f5;
        androidx.compose.material3.carousel.CarouselKt.HorizontalMultiBrowseCarousel.1.1 obj26;
        Object obj27;
        float obj28;
        androidx.compose.material3.carousel.CarouselState obj29;
        float obj30;
        float obj31;
        final int i69 = $changed;
        final int i70 = i12;
        restartGroup = $composer.startRestartGroup(-1825706865);
        ComposerKt.sourceInformation(restartGroup, "C(HorizontalMultiBrowseCarousel)P(8,7:c#ui.unit.Dp,6,3:c#ui.unit.Dp,2,5:c#ui.unit.Dp,4:c#ui.unit.Dp,1)106@5374L41,112@5703L7,116@5816L554,113@5715L1048:Carousel.kt#dcf9yb");
        $dirty = $changed;
        if (i70 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i69 & 6 == 0) {
                i3 = restartGroup.changedInstance(state) ? 4 : 2;
                $dirty |= i3;
            }
        }
        if (i70 & 2 != 0) {
            $dirty |= 48;
            f4 = preferredItemWidth;
        } else {
            if (i69 & 48 == 0) {
                i18 = restartGroup.changed(preferredItemWidth) ? 32 : 16;
                $dirty |= i18;
            } else {
                f4 = preferredItemWidth;
            }
        }
        i5 = i70 & 4;
        if (i5 != 0) {
            $dirty |= 384;
            contentPadding2 = modifier;
        } else {
            if (i69 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i9;
            } else {
                contentPadding2 = modifier;
            }
        }
        str = i70 & 8;
        if (str != null) {
            $dirty |= 3072;
            obj5 = itemSpacing;
        } else {
            if (i69 & 3072 == 0) {
                i10 = restartGroup.changed(itemSpacing) ? 2048 : 1024;
                $dirty |= i10;
            } else {
                obj5 = itemSpacing;
            }
        }
        if (i69 & 24576 == 0) {
            if (i70 & 16 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 16384 : 8192;
            } else {
                obj8 = flingBehavior;
            }
            $dirty |= changed;
        } else {
            obj8 = flingBehavior;
        }
        i8 = i70 & 32;
        int i71 = 196608;
        if (i8 != 0) {
            $dirty |= i71;
            f = minSmallItemWidth;
        } else {
            if (i71 &= i69 == 0) {
                i13 = restartGroup.changed(minSmallItemWidth) ? 131072 : 65536;
                $dirty |= i13;
            } else {
                f = minSmallItemWidth;
            }
        }
        i19 = i70 & 64;
        i4 = 1572864;
        if (i19 != 0) {
            $dirty |= i4;
            maxSmallItemWidth2 = maxSmallItemWidth;
        } else {
            if (i69 & i4 == 0) {
                companion = restartGroup.changed(maxSmallItemWidth) ? 1048576 : 524288;
                $dirty |= companion;
            } else {
                maxSmallItemWidth2 = maxSmallItemWidth;
            }
        }
        int i52 = i70 & 128;
        i14 = 12582912;
        if (i52 != 0) {
            $dirty |= i14;
            f2 = contentPadding;
        } else {
            if (i69 & i14 == 0) {
                i11 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i11;
            } else {
                f2 = contentPadding;
            }
        }
        $dirty2 = $dirty;
        i17 = 100663296;
        if (i70 & 256 != 0) {
            $dirty2 = i29;
            obj3 = content;
        } else {
            if (i69 & i17 == 0) {
                i17 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
                $dirty2 |= i17;
            } else {
                obj3 = content;
            }
        }
        if ($dirty2 & i6 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i6 = -57345;
                if (i69 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i5 != 0) {
                            obj4 = $this$dp$iv;
                        } else {
                            obj4 = contentPadding2;
                        }
                        if (str != null) {
                            i15 = 0;
                            f5 = $this$dp$iv;
                        } else {
                            f5 = obj5;
                        }
                        if (i70 & 16 != 0) {
                            $dirty2 &= i6;
                            obj8 = singleAdvanceFlingBehavior;
                        } else {
                            empty = state;
                        }
                        if (i8 != 0) {
                            f = singleAdvanceFlingBehavior;
                        }
                        if (i19 != 0) {
                            maxSmallItemWidth2 = singleAdvanceFlingBehavior;
                        }
                        if (i52 != 0) {
                            i5 = 0;
                            obj2 = paddingValues;
                            obj7 = obj8;
                            i = $dirty2;
                            obj = obj4;
                            f3 = f5;
                        } else {
                            obj2 = f2;
                            obj7 = obj8;
                            i = $dirty2;
                            obj = obj4;
                            f3 = f5;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i70 & 16 != 0) {
                            $dirty2 &= i6;
                        }
                        obj = contentPadding2;
                        obj2 = f2;
                        f3 = f7;
                        empty = state;
                        obj7 = obj8;
                        i = $dirty2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1825706865, i, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:111)");
                }
                int i33 = 0;
                int i58 = 0;
                i19 = i;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1995157598, "CC(remember):Carousel.kt#9igjgp");
                i14 = 1;
                i16 = i19 & 112 == 32 ? i14 : 0;
                i2 = i19 & i60 == 131072 ? i14 : 0;
                i7 = i19 & i62 == 1048576 ? i14 : 0;
                Composer composer2 = restartGroup;
                int i68 = 0;
                obj27 = consume;
                Object rememberedValue = composer2.rememberedValue();
                int i73 = 0;
                if (i37 |= i7 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i30 = 0;
                        obj31 = maxSmallItemWidth2;
                        obj26 = anon;
                        super(obj27, f4, state, f, obj31);
                        maxSmallItemWidth2 = obj27;
                        companion = obj31;
                        composer2.updateRememberedValue((Function2)obj26);
                    } else {
                        $i$a$CacheCarouselKt$HorizontalMultiBrowseCarousel$1 = rememberedValue;
                        companion = maxSmallItemWidth2;
                        maxSmallItemWidth2 = obj27;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CarouselKt.Carousel-V-95POc(state, Orientation.Horizontal, (Function2)$i$a$CacheCarouselKt$HorizontalMultiBrowseCarousel$1, obj2, 2, obj, f3, obj7, content, restartGroup, i25 | i48, 0);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = obj2;
                contentPadding2 = obj;
                f6 = f3;
                modifier2 = obj7;
                $dirty2 = i19;
                flingBehavior2 = companion;
                itemSpacing2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                f6 = obj5;
                obj6 = f2;
                composer = restartGroup;
                modifier2 = obj8;
                flingBehavior2 = maxSmallItemWidth2;
                itemSpacing2 = f;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CarouselKt.HorizontalMultiBrowseCarousel.2(state, preferredItemWidth, contentPadding2, f6, modifier2, itemSpacing2, flingBehavior2, obj6, content, i69, i70);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void HorizontalUncontainedCarousel-9QcgTRs(androidx.compose.material3.carousel.CarouselState state, float itemWidth, Modifier modifier, float itemSpacing, TargetedFlingBehavior flingBehavior, PaddingValues contentPadding, Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int this_$iv;
        Composer traceInProgress2;
        Object $i$a$CacheCarouselKt$HorizontalUncontainedCarousel$1;
        int $dirty2;
        Object $dirty;
        int i7;
        int i;
        float f;
        int $this$dp$iv;
        boolean traceInProgress;
        int $this$dp$iv2;
        Object obj4;
        int skipping;
        boolean defaultsInvalid;
        int i9;
        Object obj5;
        Object obj7;
        int i14;
        int i8;
        Object obj8;
        float f2;
        int i12;
        int i5;
        Object obj6;
        int changed;
        int i6;
        Object obj2;
        int i4;
        Object obj;
        int i11;
        int i2;
        Object obj3;
        Object companion;
        Composer $composer2;
        int i13;
        int i3;
        int obj23;
        final float f3 = itemWidth;
        final int i45 = $changed;
        this_$iv = 529322840;
        traceInProgress2 = $composer.startRestartGroup(this_$iv);
        ComposerKt.sourceInformation(traceInProgress2, "C(HorizontalUncontainedCarousel)P(6,4:c#ui.unit.Dp,5,3:c#ui.unit.Dp,2,1)175@8483L21,179@8666L7,183@8779L337,180@8678L818:Carousel.kt#dcf9yb");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj8 = state;
        } else {
            if (i45 & 6 == 0) {
                i7 = traceInProgress2.changedInstance(state) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                obj8 = state;
            }
        }
        if (i10 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i45 & 48 == 0) {
                i = traceInProgress2.changed(f3) ? 32 : 16;
                $dirty2 |= i;
            }
        }
        $this$dp$iv2 = i10 & 4;
        if ($this$dp$iv2 != 0) {
            $dirty2 |= 384;
            obj5 = modifier;
        } else {
            if (i45 & 384 == 0) {
                i14 = traceInProgress2.changed(modifier) ? 256 : 128;
                $dirty2 |= i14;
            } else {
                obj5 = modifier;
            }
        }
        i8 = i10 & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            f2 = itemSpacing;
        } else {
            if (i45 & 3072 == 0) {
                i5 = traceInProgress2.changed(itemSpacing) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                f2 = itemSpacing;
            }
        }
        if (i45 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = traceInProgress2.changed(flingBehavior) ? 16384 : 8192;
            } else {
                obj6 = flingBehavior;
            }
            $dirty2 |= changed;
        } else {
            obj6 = flingBehavior;
        }
        i6 = i10 & 32;
        int i49 = 196608;
        if (i6 != 0) {
            $dirty2 |= i49;
            obj2 = contentPadding;
        } else {
            if (i49 &= i45 == 0) {
                i4 = traceInProgress2.changed(contentPadding) ? 131072 : 65536;
                $dirty2 |= i4;
            } else {
                obj2 = contentPadding;
            }
        }
        i11 = 1572864;
        if (i10 & 64 != 0) {
            $dirty2 |= i11;
            obj = content;
        } else {
            if (i45 & i11 == 0) {
                i11 = traceInProgress2.changedInstance(content) ? 1048576 : 524288;
                $dirty2 |= i11;
            } else {
                obj = content;
            }
        }
        if (i54 &= $dirty2 == 599186) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i55 = -57345;
                if (i45 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if ($this$dp$iv2 != 0) {
                            obj5 = $this$dp$iv2;
                        }
                        if (i8 != 0) {
                            defaultsInvalid = 0;
                            f2 = $this$dp$iv2;
                        }
                        if (i10 & 16 != 0) {
                            $dirty2 &= i55;
                            obj6 = $this$dp$iv;
                        }
                        if (i6 != 0) {
                            defaultsInvalid = 0;
                            i6 = $this$dp$iv;
                            i2 = f2;
                            obj3 = obj6;
                        } else {
                            i2 = f2;
                            obj3 = obj6;
                            i6 = obj2;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i55;
                        }
                        i2 = f2;
                        obj3 = obj6;
                        i6 = obj2;
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(this_$iv, $dirty2, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:178)");
                }
                int i21 = 0;
                int i36 = 0;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                this_$iv = consume;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 1883505148, "CC(remember):Carousel.kt#9igjgp");
                i9 = $dirty2 & 112 == 32 ? 1 : 0;
                Composer composer = traceInProgress2;
                i8 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i51 = 0;
                if (changed3 |= i9 == 0) {
                    $composer2 = traceInProgress2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        obj23 = $composer3;
                        $i$a$CacheCarouselKt$HorizontalUncontainedCarousel$1 = new CarouselKt.HorizontalUncontainedCarousel.1.1(this_$iv, f3);
                        composer.updateRememberedValue((Function2)$i$a$CacheCarouselKt$HorizontalUncontainedCarousel$1);
                    } else {
                        $i$a$CacheCarouselKt$HorizontalUncontainedCarousel$1 = rememberedValue;
                    }
                } else {
                    $composer2 = traceInProgress2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                obj = obj5;
                CarouselKt.Carousel-V-95POc(obj8, Orientation.Horizontal, (Function2)$i$a$CacheCarouselKt$HorizontalUncontainedCarousel$1, i6, 0, obj, i2, obj3, obj, $composer2, i20 | i33, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i12 = $dirty2;
                obj7 = i6;
                $dirty = obj;
                f = i2;
                obj4 = obj3;
            } else {
                traceInProgress2.skipToGroupEnd();
                $composer2 = traceInProgress2;
                f = f2;
                obj4 = obj6;
                i12 = $dirty2;
                $dirty = obj5;
                obj7 = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            this_$iv = new CarouselKt.HorizontalUncontainedCarousel.2(state, f3, $dirty, f, obj4, obj7, content, i45, i10);
            endRestartGroup.updateScope((Function2)this_$iv);
        }
    }

    public static final float access$getProgress(androidx.compose.material3.carousel.Keyline before, androidx.compose.material3.carousel.Keyline after, float unadjustedOffset) {
        return CarouselKt.getProgress(before, after, unadjustedOffset);
    }

    private static final float calculateAfterContentPadding(PaddingValues $this$calculateAfterContentPadding, Orientation orientation, Composer $composer, int $changed) {
        float bottomPadding-D9Ej5fM;
        boolean traceInProgress;
        String str;
        int i2;
        int i;
        Object consume;
        int i3 = 1018496720;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(calculateAfterContentPadding)*361@16056L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:353)");
        }
        $composer.startReplaceGroup(-587616383);
        ComposerKt.sourceInformation($composer, "358@16007L7");
        String str4 = "CC:CompositionLocal.kt#9igjgp";
        int i5 = 2023513938;
        if (orientation == Orientation.Vertical) {
            bottomPadding-D9Ej5fM = $this$calculateAfterContentPadding.calculateBottomPadding-D9Ej5fM();
        } else {
            i2 = 0;
            i = 0;
            ComposerKt.sourceInformationMarkerStart($composer, i5, str4);
            ComposerKt.sourceInformationMarkerEnd($composer);
            bottomPadding-D9Ej5fM = PaddingKt.calculateEndPadding($this$calculateAfterContentPadding, (LayoutDirection)$composer.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()));
        }
        $composer.endReplaceGroup();
        int i7 = 0;
        int i8 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i5, str4);
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i6 = 0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Density)$composer.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(bottomPadding-D9Ej5fM);
    }

    private static final float calculateBeforeContentPadding(PaddingValues $this$calculateBeforeContentPadding, Orientation orientation, Composer $composer, int $changed) {
        float topPadding-D9Ej5fM;
        boolean traceInProgress;
        String str;
        int i;
        int i2;
        Object consume;
        int i3 = 1896839347;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(calculateBeforeContentPadding)*349@15698L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:341)");
        }
        $composer.startReplaceGroup(295830617);
        ComposerKt.sourceInformation($composer, "346@15649L7");
        String str4 = "CC:CompositionLocal.kt#9igjgp";
        int i5 = 2023513938;
        if (orientation == Orientation.Vertical) {
            topPadding-D9Ej5fM = $this$calculateBeforeContentPadding.calculateTopPadding-D9Ej5fM();
        } else {
            i = 0;
            i2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, i5, str4);
            ComposerKt.sourceInformationMarkerEnd($composer);
            topPadding-D9Ej5fM = PaddingKt.calculateStartPadding($this$calculateBeforeContentPadding, (LayoutDirection)$composer.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()));
        }
        $composer.endReplaceGroup();
        int i7 = 0;
        int i8 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i5, str4);
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i6 = 0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Density)$composer.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(topPadding-D9Ej5fM);
    }

    public static final float calculateCurrentScrollOffset(androidx.compose.material3.carousel.CarouselState state, androidx.compose.material3.carousel.Strategy strategy) {
        itemMainAxisSize += itemSpacing;
        return i3 - f2;
    }

    public static final float calculateMaxScrollOffset(androidx.compose.material3.carousel.CarouselState state, androidx.compose.material3.carousel.Strategy strategy) {
        float f = (float)pageCount;
        return RangesKt.coerceAtLeast(i2 - availableSpace, 0);
    }

    public static final Modifier carouselItem(Modifier $this$carouselItem, int index, androidx.compose.material3.carousel.CarouselState state, Function0<androidx.compose.material3.carousel.Strategy> strategy, androidx.compose.material3.carousel.CarouselItemInfoImpl carouselItemInfo, Shape clipShape) {
        CarouselKt.carouselItem.1 anon = new CarouselKt.carouselItem.1(strategy, state, index, carouselItemInfo, clipShape);
        return LayoutModifierKt.layout($this$carouselItem, (Function3)anon);
    }

    private static final float getProgress(androidx.compose.material3.carousel.Keyline before, androidx.compose.material3.carousel.Keyline after, float unadjustedOffset) {
        if (Intrinsics.areEqual(before, after)) {
            return 1065353216;
        }
        return i3 /= i2;
    }
}
