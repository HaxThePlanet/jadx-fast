package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0096\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u008c\u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\\\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00042\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00082\u0006\u0010\u001b\u001a\u00020\u00082\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0002\u001a4\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010#\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00082\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0004H\u0002\u001a£\u0002\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00082\u0006\u0010'\u001a\u00020\u00082\u0006\u0010(\u001a\u00020\u00082\u0006\u0010)\u001a\u00020\u00082\u0006\u0010*\u001a\u00020\u00082\u0006\u0010+\u001a\u00020\u00082\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00042\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u000c\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u0002012\u0006\u0010\u001b\u001a\u00020\u00082\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00042\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0008\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092/\u0010:\u001a+\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0008\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<¢\u0006\u0002\u0008?\u0012\u0004\u0012\u00020@0;H\u0000ø\u0001\u0000¢\u0006\u0004\u0008A\u0010B\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006C", d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "consumedScroll", "", "isLookingAhead", "lastPostLookaheadLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "hasLookaheadPassOccurred", "postLookaheadLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-x0Ok8Vo", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyListMeasureKt {
    private static final List<androidx.compose.foundation.lazy.LazyListMeasuredItem> calculateItemsOffsets(List<androidx.compose.foundation.lazy.LazyListMeasuredItem> items, List<androidx.compose.foundation.lazy.LazyListMeasuredItem> extraItemsBefore, List<androidx.compose.foundation.lazy.LazyListMeasuredItem> extraItemsAfter, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int itemsScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        int currentMainAxis2;
        int currentMainAxis;
        int i;
        int $this$fastForEach$iv;
        int i4;
        IntProgression reversed;
        boolean empty;
        int i7;
        int i2;
        Object obj2;
        int index;
        int i3;
        int index$iv;
        int index$iv2;
        int[] iArr;
        int i6;
        int last;
        Object ltr;
        int[] iArr2;
        int size;
        int mainAxisSizeWithSpacings;
        int i5;
        int i8;
        int size2;
        currentMainAxis2 = items;
        final int i12 = layoutWidth;
        final int i13 = layoutHeight;
        final boolean z = reverseLayout;
        i = isVertical ? i13 : i12;
        final int i21 = i;
        int i20 = 0;
        i6 = 1;
        i4 = finalMainAxisOffset < Math.min(i21, maxOffset) ? i6 : i20;
        final int i24 = i4;
        if (i24 != 0) {
            i4 = itemsScrollOffset == null ? i6 : i20;
            if (i4 == 0) {
            } else {
            }
            int i16 = 0;
            IllegalStateException $i$a$CheckLazyListMeasureKt$calculateItemsOffsets$1 = new IllegalStateException("non-zero itemsScrollOffset".toString());
            throw $i$a$CheckLazyListMeasureKt$calculateItemsOffsets$1;
        }
        ArrayList arrayList = new ArrayList(i22 += iArr2);
        final ArrayList list = arrayList;
        if (i24 != 0) {
            if (extraItemsBefore.isEmpty() && extraItemsAfter.isEmpty()) {
                if (extraItemsAfter.isEmpty()) {
                } else {
                    i6 = i20;
                }
            } else {
            }
            if (i6 == 0) {
            } else {
                size = currentMainAxis2.size();
                iArr = new int[size];
                i7 = i20;
                while (i7 < size) {
                    iArr[i7] = (LazyListMeasuredItem)currentMainAxis2.get(LazyListMeasureKt.calculateItemsOffsets$reverseAware(i7, z, size)).getSize();
                    i7++;
                }
                iArr2 = new int[size];
                i2 = i20;
                while (i2 < size) {
                    iArr2[i2] = i20;
                    i2++;
                }
                if (isVertical) {
                    if (verticalArrangement == null) {
                    } else {
                        i3 = 0;
                        verticalArrangement.arrange(density, i21, iArr, iArr2);
                        if (!z) {
                        } else {
                            reversed = RangesKt.reversed((IntProgression)ArraysKt.getIndices(iArr2));
                        }
                        index = reversed.getFirst();
                        last = reversed.getLast();
                        mainAxisSizeWithSpacings = reversed.getStep();
                        if (mainAxisSizeWithSpacings > 0) {
                            if (index > last && mainAxisSizeWithSpacings < 0 && last <= index) {
                                if (mainAxisSizeWithSpacings < 0) {
                                    if (last <= index) {
                                    }
                                }
                            }
                        } else {
                        }
                        return (List)list;
                    }
                    Density density2 = density;
                    int i17 = 0;
                    IllegalArgumentException $i$a$RequireNotNullLazyListMeasureKt$calculateItemsOffsets$3 = new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                    throw $i$a$RequireNotNullLazyListMeasureKt$calculateItemsOffsets$3;
                }
                Density density3 = density;
                if (horizontalArrangement == null) {
                } else {
                    mainAxisSizeWithSpacings = 0;
                    horizontalArrangement.arrange(density, i21, iArr, LayoutDirection.Ltr, iArr2);
                }
                int i10 = 0;
                IllegalArgumentException $i$a$RequireNotNullLazyListMeasureKt$calculateItemsOffsets$5 = new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
                throw $i$a$RequireNotNullLazyListMeasureKt$calculateItemsOffsets$5;
            }
            int i9 = 0;
            IllegalArgumentException $i$a$RequireLazyListMeasureKt$calculateItemsOffsets$2 = new IllegalArgumentException("no extra items".toString());
            throw $i$a$RequireLazyListMeasureKt$calculateItemsOffsets$2;
        }
        int i11 = 0;
        currentMainAxis = itemsScrollOffset;
        Object obj = extraItemsBefore;
        int i18 = 0;
        index$iv = 0;
        while (index$iv < obj.size()) {
            iArr2 = last;
            size = 0;
            iArr2.position(currentMainAxis -= mainAxisSizeWithSpacings, i12, i13);
            list.add(iArr2);
            index$iv++;
        }
        currentMainAxis2 = itemsScrollOffset;
        int i14 = items;
        int i19 = 0;
        index$iv2 = 0;
        while (index$iv2 < i14.size()) {
            iArr2 = last;
            size = 0;
            (LazyListMeasuredItem)iArr2.position(currentMainAxis2, i12, i13);
            list.add(iArr2);
            currentMainAxis2 += mainAxisSizeWithSpacings;
            index$iv2++;
        }
        $this$fastForEach$iv = extraItemsAfter;
        reversed = 0;
        index = 0;
        while (index < $this$fastForEach$iv.size()) {
            iArr2 = last;
            size = 0;
            (LazyListMeasuredItem)iArr2.position(currentMainAxis2, i12, i13);
            list.add(iArr2);
            currentMainAxis2 += mainAxisSizeWithSpacings;
            index++;
        }
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int itemsCount) {
        int i;
        i = !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : i2 + -1;
        return i;
    }

    private static final List<androidx.compose.foundation.lazy.LazyListMeasuredItem> createItemsAfterList(List<androidx.compose.foundation.lazy.LazyListMeasuredItem> visibleItems, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider measuredItemProvider, int itemsCount, int beyondBoundsItemCount, List<Integer> pinnedItems, float consumedScroll, boolean isLookingAhead, androidx.compose.foundation.lazy.LazyListLayoutInfo lastPostLookaheadLayoutInfo) {
        int list;
        int end;
        int andMeasure-0kLqBqw$default3;
        int emptyList;
        int andMeasure-0kLqBqw$default;
        int mainAxisSizeWithSpacings;
        int index$iv;
        int found;
        int index;
        int i;
        long i6;
        int andMeasure-0kLqBqw$default2;
        int i5;
        int index$iv$iv2;
        int index$iv$iv;
        int i3;
        int totalOffset;
        int size;
        Object obj;
        int i8;
        int i2;
        Object obj2;
        int i7;
        int i4;
        final int i9 = itemsCount;
        list = 0;
        int i10 = 0;
        end = Math.min(end2 + beyondBoundsItemCount, i9 + -1);
        andMeasure-0kLqBqw$default = 1;
        index2 += andMeasure-0kLqBqw$default;
        if (andMeasure-0kLqBqw$default3 <= end) {
            found = andMeasure-0kLqBqw$default3;
            while (list == null) {
                andMeasure-0kLqBqw$default3 = new ArrayList();
                list = andMeasure-0kLqBqw$default3;
                list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, found, 0, obj8, 2));
                if (found != end) {
                }
                found++;
            }
        }
        if (isLookingAhead && lastPostLookaheadLayoutInfo != null && !(Collection)lastPostLookaheadLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            if (lastPostLookaheadLayoutInfo != null) {
                if (!(Collection)lastPostLookaheadLayoutInfo.getVisibleItemsInfo().isEmpty()) {
                    List visibleItemsInfo2 = lastPostLookaheadLayoutInfo.getVisibleItemsInfo();
                    mainAxisSizeWithSpacings = 0;
                    found = 0;
                    size3 -= andMeasure-0kLqBqw$default;
                    while (-1 < i) {
                        if ((LazyListItemInfo)visibleItemsInfo2.get(i).getIndex() > end) {
                            break;
                        } else {
                        }
                        i--;
                    }
                    andMeasure-0kLqBqw$default3 = CollectionsKt.last(lastPostLookaheadLayoutInfo.getVisibleItemsInfo());
                    if (found != 0) {
                        i = found.getIndex();
                        totalOffset = Math.min((LazyListItemInfo)andMeasure-0kLqBqw$default3.getIndex(), i9 + -1);
                        if (i <= totalOffset) {
                            i6 = i;
                            while (list != null) {
                                andMeasure-0kLqBqw$default2 = 0;
                                i5 = i;
                                index$iv$iv2 = 0;
                                index$iv$iv = 0;
                                while (index$iv$iv < i5.size()) {
                                    i2 = 0;
                                    i7 = 0;
                                    i4 = andMeasure-0kLqBqw$default;
                                    if ((LazyListMeasuredItem)i5.get(index$iv$iv).getIndex() == i6) {
                                    } else {
                                    }
                                    andMeasure-0kLqBqw$default = 0;
                                    index$iv$iv++;
                                    andMeasure-0kLqBqw$default = i4;
                                    andMeasure-0kLqBqw$default = i4;
                                }
                                i4 = andMeasure-0kLqBqw$default;
                                i8 = 0;
                                if (i8 == 0 && list == null) {
                                }
                                if (i6 != totalOffset) {
                                }
                                i6++;
                                andMeasure-0kLqBqw$default = i4;
                                i4 = andMeasure-0kLqBqw$default;
                                i8 = 0;
                                if (list == null) {
                                }
                                list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, i6, 0, i5, 2));
                                andMeasure-0kLqBqw$default = new ArrayList();
                                list = andMeasure-0kLqBqw$default;
                                i2 = 0;
                                i7 = 0;
                                i4 = andMeasure-0kLqBqw$default;
                                if ((LazyListMeasuredItem)i5.get(index$iv$iv).getIndex() == i6) {
                                } else {
                                }
                                andMeasure-0kLqBqw$default = 0;
                                if (andMeasure-0kLqBqw$default != 0) {
                                } else {
                                }
                                index$iv$iv++;
                                andMeasure-0kLqBqw$default = i4;
                                andMeasure-0kLqBqw$default = i4;
                            }
                        } else {
                            i4 = andMeasure-0kLqBqw$default;
                        }
                    } else {
                        i4 = andMeasure-0kLqBqw$default;
                    }
                    f -= consumedScroll;
                    if (Float.compare(andMeasure-0kLqBqw$default, i16) > 0) {
                        int i17 = 0;
                        index5++;
                        totalOffset = index;
                        while (i6 < i9) {
                            if (Float.compare(f2, andMeasure-0kLqBqw$default) < 0) {
                            }
                            if (i6 <= end) {
                            } else {
                            }
                            if (list != null) {
                            } else {
                            }
                            i8 = 0;
                            if (i8 != 0) {
                            } else {
                            }
                            if (list == null) {
                            }
                            list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, i6, 0, i5, 2));
                            i6++;
                            totalOffset += mainAxisSizeWithSpacings;
                            mainAxisSizeWithSpacings = new ArrayList();
                            list = mainAxisSizeWithSpacings;
                            i6++;
                            totalOffset += mainAxisSizeWithSpacings;
                            index = 0;
                            andMeasure-0kLqBqw$default2 = mainAxisSizeWithSpacings;
                            i5 = 0;
                            index$iv$iv2 = 0;
                            while (index$iv$iv2 < andMeasure-0kLqBqw$default2.size()) {
                                i8 = 0;
                                obj2 = null;
                                if ((LazyListMeasuredItem)andMeasure-0kLqBqw$default2.get(index$iv$iv2).getIndex() == i6) {
                                } else {
                                }
                                i3 = 0;
                                index$iv$iv2++;
                                i3 = i4;
                            }
                            obj = 0;
                            i8 = obj;
                            i8 = 0;
                            obj2 = null;
                            if ((LazyListMeasuredItem)andMeasure-0kLqBqw$default2.get(index$iv$iv2).getIndex() == i6) {
                            } else {
                            }
                            i3 = 0;
                            if (i3 != 0) {
                            } else {
                            }
                            index$iv$iv2++;
                            i3 = i4;
                            andMeasure-0kLqBqw$default2 = 0;
                            i5 = index;
                            index$iv$iv2 = 0;
                            index$iv$iv = 0;
                            while (index$iv$iv < i5.size()) {
                                i2 = 0;
                                i7 = 0;
                                if ((LazyListMeasuredItem)i5.get(index$iv$iv).getIndex() == i6) {
                                } else {
                                }
                                mainAxisSizeWithSpacings = 0;
                                index$iv$iv++;
                                mainAxisSizeWithSpacings = i4;
                            }
                            i8 = 0;
                            i2 = 0;
                            i7 = 0;
                            if ((LazyListMeasuredItem)i5.get(index$iv$iv).getIndex() == i6) {
                            } else {
                            }
                            mainAxisSizeWithSpacings = 0;
                            if (mainAxisSizeWithSpacings != 0) {
                            } else {
                            }
                            index$iv$iv++;
                            mainAxisSizeWithSpacings = i4;
                        }
                    }
                }
            }
        }
        andMeasure-0kLqBqw$default3 = list;
        andMeasure-0kLqBqw$default = 0;
        if (list != null && (LazyListMeasuredItem)CollectionsKt.last(andMeasure-0kLqBqw$default3).getIndex() > end) {
            andMeasure-0kLqBqw$default3 = list;
            andMeasure-0kLqBqw$default = 0;
            if ((LazyListMeasuredItem)CollectionsKt.last(andMeasure-0kLqBqw$default3).getIndex() > end) {
                end = (LazyListMeasuredItem)CollectionsKt.last(andMeasure-0kLqBqw$default3).getIndex();
            }
        }
        Object obj3 = pinnedItems;
        int i13 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i6 = (Number)obj3.get(index$iv).intValue();
            totalOffset = 0;
            if (i6 > end && list == null) {
            }
            index$iv++;
            if (list == null) {
            }
            list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, i6, 0, i5, 2));
            index = new ArrayList();
            list = index;
        }
        if (list == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = list;
        }
        return emptyList;
    }

    private static final List<androidx.compose.foundation.lazy.LazyListMeasuredItem> createItemsBeforeList(int currentFirstItemIndex, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider measuredItemProvider, int beyondBoundsItemCount, List<Integer> pinnedItems) {
        int list;
        int arrayList;
        int emptyList;
        int i6;
        androidx.compose.foundation.lazy.LazyListMeasuredItem andMeasure-0kLqBqw$default2;
        int i3;
        long arrayList2;
        int intValue;
        int andMeasure-0kLqBqw$default;
        int i4;
        int i5;
        int i;
        Object obj;
        int i2;
        list = 0;
        int i7 = 0;
        int start2 = Math.max(0, start - beyondBoundsItemCount);
        arrayList = currentFirstItemIndex + -1;
        if (start2 <= arrayList) {
            i6 = arrayList;
            while (list == null) {
                arrayList = new ArrayList();
                list = arrayList;
                list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, i6, 0, obj5, 2));
                if (i6 != start2) {
                }
                i6--;
            }
        }
        Object obj2 = pinnedItems;
        int i9 = 0;
        if (size-- >= 0) {
        }
        if (list == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = list;
        }
        return emptyList;
    }

    public static final androidx.compose.foundation.lazy.LazyListMeasureResult measureLazyList-x0Ok8Vo(int itemsCount, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider measuredItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenItems, int firstVisibleItemIndex, int firstVisibleItemScrollOffset, float scrollToBeConsumed, long constraints, boolean isVertical, List<Integer> headerIndexes, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density, LazyLayoutItemAnimator<androidx.compose.foundation.lazy.LazyListMeasuredItem> itemAnimator, int beyondBoundsItemCount, List<Integer> pinnedItems, boolean hasLookaheadPassOccurred, boolean isLookingAhead, androidx.compose.foundation.lazy.LazyListLayoutInfo postLookaheadLayoutInfo, CoroutineScope coroutineScope, MutableState<Unit> placementScopeInvalidator, GraphicsContext graphicsContext, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int i11;
        int i18;
        ArrayList minSizeToFitDisappearingItems-YbymL2g;
        int currentFirstItemIndex2;
        int index3;
        int index6;
        int currentMainAxisOffset;
        androidx.compose.foundation.lazy.LazyListMeasuredItemProvider index5;
        int size2;
        List list3;
        boolean equal;
        int i31;
        int i32;
        List minSizeToFitDisappearingItems-YbymL2g2;
        List list;
        int size;
        int i16;
        Orientation horizontal;
        int currentFirstItemScrollOffset3;
        int currentFirstItemScrollOffset5;
        int currentFirstItemScrollOffset;
        int currentFirstItemScrollOffset4;
        int currentFirstItemScrollOffset10;
        int scrollDelta2;
        Object currentFirstItemScrollOffset7;
        int firstItem2;
        int index$iv;
        int i25;
        int index8;
        boolean height-impl;
        int $this$fastRoundToInt$iv;
        int measuredItem;
        int measuredItem2;
        int currentMainAxisOffset3;
        int index$iv3;
        int i19;
        int currentFirstItemIndex;
        int mainAxisSizeWithSpacings;
        int constrainWidth-K40F9xA;
        int index7;
        List mutableState;
        int index4;
        int i8;
        int it$iv;
        Orientation horizontal3;
        int i23;
        int currentMainAxisOffset2;
        float sign;
        int i;
        int i12;
        int visibleItemsScrollOffset;
        int maxCrossAxis2;
        int $this$fastFilter$iv;
        int index2;
        int i24;
        int indexInVisibleItems;
        float f;
        int constrainHeight-K40F9xA;
        int sign2;
        int scrollDelta;
        int currentMainAxisOffset4;
        int i5;
        Object firstItem;
        int i13;
        int preScrollBackScrollDelta;
        Object obj5;
        int maxCrossAxis;
        int i26;
        int currentFirstItemScrollOffset2;
        int currentFirstItemScrollOffset6;
        int currentFirstItemScrollOffset8;
        int visibleItems;
        Object layoutWidth2;
        int i36;
        int minOffset;
        int i21;
        int positionedItems;
        int anon;
        int remeasureNeeded;
        int i33;
        androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap keyIndexMap;
        int currentFirstItemIndex3;
        Object index$iv2;
        androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider lazyLayoutMeasuredItemProvider;
        List list2;
        int layoutWidth;
        int i28;
        boolean disappearingItemsSize;
        int layoutHeight;
        int currentFirstItemScrollOffset9;
        int z2;
        int i29;
        int i17;
        int i27;
        int i2;
        boolean z;
        int i3;
        int i34;
        int i10;
        int i4;
        int i20;
        int i6;
        Object context;
        int i9;
        int i14;
        Arrangement.Vertical vertical;
        Arrangement.Horizontal horizontal2;
        boolean z3;
        Density $this$fastForEach$iv$iv;
        int remeasureNeeded2;
        int i30;
        int maxMainAxis;
        int i37;
        int i22;
        int index;
        int i35;
        int i7;
        Object first;
        int i15;
        int i78 = itemsCount;
        preScrollBackScrollDelta = beforeContentPadding;
        Object obj4 = constraints;
        i26 = 0;
        int i94 = 1;
        i11 = preScrollBackScrollDelta >= 0 ? i94 : i26;
        if (i11 == 0) {
        } else {
            i18 = afterContentPadding >= 0 ? i94 : i26;
            if (i18 == 0) {
            } else {
                minSizeToFitDisappearingItems-YbymL2g = new ArrayList();
                beyondBoundsItemCount.onMeasured(0, Constraints.getMinWidth-impl(obj4), Constraints.getMinHeight-impl(obj4), (List)minSizeToFitDisappearingItems-YbymL2g, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, headerIndexes, postLookaheadLayoutInfo, 1, isLookingAhead, 0, 0, placementScopeInvalidator, layout);
                minSizeToFitDisappearingItems-YbymL2g = beyondBoundsItemCount.getMinSizeToFitDisappearingItems-YbymL2g();
                if (i78 <= 0 && !postLookaheadLayoutInfo && !IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, obj1)) {
                    minSizeToFitDisappearingItems-YbymL2g = new ArrayList();
                    beyondBoundsItemCount.onMeasured(0, Constraints.getMinWidth-impl(obj4), Constraints.getMinHeight-impl(obj4), (List)minSizeToFitDisappearingItems-YbymL2g, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, headerIndexes, postLookaheadLayoutInfo, 1, isLookingAhead, 0, 0, placementScopeInvalidator, layout);
                    if (!postLookaheadLayoutInfo) {
                        minSizeToFitDisappearingItems-YbymL2g = beyondBoundsItemCount.getMinSizeToFitDisappearingItems-YbymL2g();
                        if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, obj1)) {
                            layoutWidth = ConstraintsKt.constrainWidth-K40F9xA(obj4, obj10);
                            layoutHeight = ConstraintsKt.constrainHeight-K40F9xA(obj4, obj10);
                        }
                    }
                    horizontal = headerIndexes ? Orientation.Vertical : Orientation.Horizontal;
                    LazyListMeasureResult lazyListMeasureResult2 = new LazyListMeasureResult(0, 0, 0, 0, (MeasureResult)obj77.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), LazyListMeasureKt.measureLazyList.3.INSTANCE), 0, 0, placementScopeInvalidator, itemAnimator, measuredItemProvider.getChildConstraints-msEJaDk(), obj31, CollectionsKt.emptyList(), -preScrollBackScrollDelta, mainAxisAvailableSize + afterContentPadding, 0, density, horizontal, afterContentPadding, spaceBetweenItems, 0);
                    return lazyListMeasureResult2;
                }
                currentFirstItemScrollOffset3 = firstVisibleItemScrollOffset;
                if (firstVisibleItemIndex >= i78) {
                    currentFirstItemIndex2 = i78 + -1;
                    currentFirstItemScrollOffset3 = 0;
                }
                int i53 = 0;
                $this$fastRoundToInt$iv = Math.round(scrollToBeConsumed);
                currentFirstItemScrollOffset3 -= $this$fastRoundToInt$iv;
                if (currentFirstItemIndex2 == 0 && currentFirstItemScrollOffset5 < 0) {
                    if (currentFirstItemScrollOffset5 < 0) {
                        currentFirstItemScrollOffset5 = 0;
                        scrollDelta = $this$fastRoundToInt$iv;
                    } else {
                        scrollDelta = $this$fastRoundToInt$iv;
                    }
                } else {
                }
                ArrayDeque scrollDelta4 = new ArrayDeque();
                ArrayDeque queue2 = scrollDelta4;
                i19 = spaceBetweenItems < 0 ? spaceBetweenItems : i26;
                int i77 = i48 + i19;
                int i70 = mainAxisAvailableSize;
                currentFirstItemScrollOffset5 += i77;
                measuredItem = 0;
                remeasureNeeded = 0;
                currentFirstItemIndex3 = currentFirstItemIndex2;
                while (currentFirstItemScrollOffset < 0) {
                    if (currentFirstItemIndex3 > 0) {
                    }
                    int currentFirstItemScrollOffset14 = currentFirstItemIndex3 + -1;
                    androidx.compose.foundation.lazy.LazyListMeasuredItem andMeasure-0kLqBqw$default2 = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, currentFirstItemScrollOffset14, 0, i19, 2);
                    queue2.add(i26, andMeasure-0kLqBqw$default2);
                    currentFirstItemIndex3 = currentFirstItemScrollOffset14;
                    measuredItem = currentFirstItemIndex2;
                    currentFirstItemScrollOffset = i19;
                }
                int i60 = currentFirstItemScrollOffset;
                currentFirstItemIndex = measuredItem;
                currentFirstItemScrollOffset4 = i60 < i77 ? i77 : i60;
                currentFirstItemScrollOffset4 -= i77;
                index3 = currentFirstItemIndex3;
                currentMainAxisOffset2 = -currentFirstItemScrollOffset12;
                indexInVisibleItems = 0;
                while (indexInVisibleItems < queue2.size()) {
                    if (currentMainAxisOffset2 >= RangesKt.coerceAtLeast(i70 + afterContentPadding, i26)) {
                    } else {
                    }
                    index3++;
                    currentMainAxisOffset2 += mainAxisSizeWithSpacings5;
                    indexInVisibleItems++;
                    i26 = 0;
                    queue2.remove(indexInVisibleItems);
                    remeasureNeeded = 1;
                    i26 = 0;
                }
                currentFirstItemScrollOffset2 = currentFirstItemScrollOffset12;
                remeasureNeeded2 = remeasureNeeded;
                currentFirstItemScrollOffset10 = index3;
                index6 = currentMainAxisOffset2;
                while (currentFirstItemScrollOffset10 < i78) {
                    int i74 = i29;
                    androidx.compose.foundation.lazy.LazyListMeasuredItem andMeasure-0kLqBqw$default = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, currentFirstItemScrollOffset10, 0, currentFirstItemIndex, 2);
                    int i43 = currentFirstItemScrollOffset10;
                    mainAxisSizeWithSpacings2 += scrollDelta5;
                    if (i47 <= i77 && i43 != i78 + -1) {
                    } else {
                    }
                    currentFirstItemIndex = Math.max(i74, andMeasure-0kLqBqw$default.getCrossAxisSize());
                    queue2.add(andMeasure-0kLqBqw$default);
                    currentFirstItemScrollOffset10 = index10;
                    index6 = measuredItem3;
                    obj5 = obj77;
                    scrollDelta = i27;
                    measuredItem2 = i30;
                    indexInVisibleItems = i37;
                    if (i43 != i78 + -1) {
                    } else {
                    }
                    currentFirstItemScrollOffset2 -= mainAxisSizeWithSpacings4;
                    currentFirstItemIndex3 = i58;
                    remeasureNeeded2 = currentMainAxisOffset2;
                    currentFirstItemIndex = i74;
                }
                maxMainAxis = measuredItem2;
                maxCrossAxis = currentFirstItemIndex;
                i22 = indexInVisibleItems;
                i2 = scrollDelta;
                currentMainAxisOffset4 = index6;
                currentMainAxisOffset = currentFirstItemScrollOffset10;
                if (currentMainAxisOffset4 < i70) {
                    remeasureNeeded = i70 - currentMainAxisOffset4;
                    currentFirstItemScrollOffset2 -= remeasureNeeded;
                    currentMainAxisOffset4 += remeasureNeeded;
                    while (currentFirstItemScrollOffset8 < preScrollBackScrollDelta) {
                        int preScrollBackScrollDelta3 = currentFirstItemIndex3 + -1;
                        measuredItem2 = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, preScrollBackScrollDelta3, 0, currentFirstItemIndex, 2);
                        queue2.add(0, measuredItem2);
                        maxCrossAxis = Math.max(maxCrossAxis, measuredItem2.getCrossAxisSize());
                        currentFirstItemScrollOffset8 += currentMainAxisOffset2;
                        currentFirstItemIndex3 = preScrollBackScrollDelta3;
                        index8 = i71;
                        currentMainAxisOffset = i7;
                        preScrollBackScrollDelta = beforeContentPadding;
                    }
                    index = currentMainAxisOffset;
                    i13 = index8;
                    mainAxisSizeWithSpacings = 0;
                    index5 = measuredItemProvider;
                    int preScrollBackScrollDelta2 = i2 + remeasureNeeded;
                    if (currentFirstItemScrollOffset8 < 0) {
                        currentFirstItemScrollOffset6 = scrollDelta3;
                        scrollDelta2 = i90;
                        i10 = i51;
                        currentMainAxisOffset3 = currentFirstItemIndex3;
                    } else {
                        currentFirstItemScrollOffset6 = preScrollBackScrollDelta2;
                        scrollDelta2 = currentMainAxisOffset6;
                        i10 = currentMainAxisOffset4;
                        currentMainAxisOffset3 = currentFirstItemIndex3;
                    }
                } else {
                    index = currentMainAxisOffset;
                    i13 = index8;
                    mainAxisSizeWithSpacings = 0;
                    index5 = measuredItemProvider;
                    i10 = currentMainAxisOffset4;
                    scrollDelta2 = currentFirstItemScrollOffset2;
                    currentMainAxisOffset3 = currentFirstItemIndex3;
                    currentFirstItemScrollOffset6 = i2;
                }
                int i65 = 0;
                int i66 = 0;
                if (MathKt.getSign(Math.round(scrollToBeConsumed)) == MathKt.getSign(currentFirstItemScrollOffset6) && Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(currentFirstItemScrollOffset6)) {
                    i66 = 0;
                    f = Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(currentFirstItemScrollOffset6) ? sign : scrollToBeConsumed;
                } else {
                }
                final int i109 = scrollToBeConsumed - f;
                i = 0;
                if (postLookaheadLayoutInfo && currentFirstItemScrollOffset6 > i13 && Float.compare(i109, i) <= 0) {
                    if (currentFirstItemScrollOffset6 > i13) {
                        if (Float.compare(i109, i) <= 0) {
                            i5 = i;
                        } else {
                            i5 = i;
                        }
                    } else {
                    }
                } else {
                }
                i12 = scrollDelta2 >= 0 ? i94 : mainAxisSizeWithSpacings;
                if (i12 == 0) {
                } else {
                    visibleItemsScrollOffset = -scrollDelta2;
                    if (beforeContentPadding <= 0) {
                        if (spaceBetweenItems < 0) {
                            mainAxisSizeWithSpacings = queue2.size();
                            i14 = visibleItemsScrollOffset;
                            visibleItemsScrollOffset = remeasureNeeded;
                            while (visibleItemsScrollOffset < mainAxisSizeWithSpacings) {
                                mainAxisSizeWithSpacings = (LazyListMeasuredItem)queue2.get(visibleItemsScrollOffset).getMainAxisSizeWithSpacings();
                                firstItem = obj2;
                                visibleItemsScrollOffset++;
                                scrollDelta2 = remeasureNeeded;
                                mainAxisSizeWithSpacings = currentFirstItemIndex3;
                            }
                            currentFirstItemScrollOffset9 = scrollDelta2;
                            i34 = currentFirstItemScrollOffset9;
                            currentFirstItemScrollOffset7 = firstItem;
                        } else {
                            i34 = scrollDelta2;
                            i14 = visibleItemsScrollOffset;
                            currentFirstItemScrollOffset7 = firstItem;
                        }
                    } else {
                    }
                    int i54 = pinnedItems;
                    List list7 = hasLookaheadPassOccurred;
                    List itemsBeforeList = LazyListMeasureKt.createItemsBeforeList(currentMainAxisOffset3, index5, i54, list7);
                    List list9 = itemsBeforeList;
                    i33 = 0;
                    size2 = list9.size();
                    firstItem2 = i113;
                    while (firstItem2 < size2) {
                        i2 = 0;
                        maxCrossAxis = Math.max(maxCrossAxis, (LazyListMeasuredItem)list9.get(firstItem2).getCrossAxisSize());
                        firstItem2++;
                        size2 = i20;
                    }
                    int i111 = currentMainAxisOffset3;
                    i9 = i70;
                    int currentFirstItemIndex4 = i78;
                    Object obj8 = index$iv2;
                    int i83 = 0;
                    List itemsAfterList = LazyListMeasureKt.createItemsAfterList((List)queue2, measuredItemProvider, currentFirstItemIndex4, i54, list7, f, postLookaheadLayoutInfo, coroutineScope);
                    int i68 = currentFirstItemIndex4;
                    float f7 = f;
                    int i45 = 0;
                    index$iv3 = 0;
                    maxCrossAxis2 = maxCrossAxis;
                    while (index$iv3 < itemsAfterList.size()) {
                        i33 = 0;
                        maxCrossAxis2 = Math.max(maxCrossAxis2, (LazyListMeasuredItem)list3.get(index$iv3).getCrossAxisSize());
                        index$iv3++;
                        list3 = index$iv2;
                    }
                    List $this$fastForEach$iv = list3;
                    if (Intrinsics.areEqual(obj8, queue2.first()) && itemsBeforeList.isEmpty() && itemsAfterList.isEmpty()) {
                        if (itemsBeforeList.isEmpty()) {
                            constrainWidth-K40F9xA = itemsAfterList.isEmpty() ? i94 : i83;
                        } else {
                        }
                    } else {
                    }
                    i31 = headerIndexes ? maxCrossAxis2 : i10;
                    int constrainWidth-K40F9xA2 = ConstraintsKt.constrainWidth-K40F9xA(obj4, obj10);
                    i32 = headerIndexes ? i10 : maxCrossAxis2;
                    int constrainHeight-K40F9xA2 = ConstraintsKt.constrainHeight-K40F9xA(obj4, obj10);
                    index$iv = currentFirstItemScrollOffset6;
                    ArrayDeque layoutWidth3 = queue2;
                    visibleItems = i72;
                    int layoutHeight2 = i77;
                    minOffset = i73;
                    z2 = postLookaheadLayoutInfo;
                    int i102 = index$iv;
                    int i98 = i83;
                    List firstItem3 = minSizeToFitDisappearingItems-YbymL2g2;
                    beyondBoundsItemCount.onMeasured((int)f7, visibleItems, minOffset, firstItem3, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, headerIndexes, z2, 1, isLookingAhead, i34, i10, placementScopeInvalidator, layout);
                    boolean z5 = z2;
                    int i75 = i10;
                    if (!z5) {
                        minSizeToFitDisappearingItems-YbymL2g2 = beyondBoundsItemCount.getMinSizeToFitDisappearingItems-YbymL2g();
                        if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g2, index$iv)) {
                            index$iv3 = headerIndexes ? minOffset : visibleItems;
                            constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(obj4, obj10);
                            i36 = headerIndexes ? constrainHeight-K40F9xA : constrainWidth-K40F9xA;
                            if (i36 != index$iv3) {
                                minOffset = firstItem3;
                                keyIndexMap = 0;
                                disappearingItemsSize = minSizeToFitDisappearingItems-YbymL2g2;
                                minSizeToFitDisappearingItems-YbymL2g2 = minOffset.size();
                                index$iv = lazyLayoutMeasuredItemProvider;
                                while (index$iv < minSizeToFitDisappearingItems-YbymL2g2) {
                                    z = false;
                                    (LazyListMeasuredItem)minOffset.get(index$iv).updateMainAxisLayoutSize(i36);
                                    index$iv++;
                                    minSizeToFitDisappearingItems-YbymL2g2 = i17;
                                }
                            } else {
                                disappearingItemsSize = minSizeToFitDisappearingItems-YbymL2g2;
                            }
                            visibleItems = constrainWidth-K40F9xA;
                        } else {
                            disappearingItemsSize = minSizeToFitDisappearingItems-YbymL2g2;
                            constrainHeight-K40F9xA = minOffset;
                        }
                    } else {
                    }
                    if (!(Collection)verticalArrangement.isEmpty()) {
                        constrainWidth-K40F9xA = beforeContentPadding;
                        i3 = maxCrossAxis2;
                        maxCrossAxis2 = visibleItems;
                        i21 = i9;
                        layoutWidth2 = obj77;
                        positionedItems = LazyListHeadersKt.findOrComposeLazyListHeader(firstItem3, measuredItemProvider, verticalArrangement, constrainWidth-K40F9xA, maxCrossAxis2, constrainHeight-K40F9xA);
                        i25 = constrainWidth-K40F9xA;
                        i4 = maxCrossAxis2;
                        i6 = constrainHeight-K40F9xA;
                    } else {
                        i25 = beforeContentPadding;
                        i3 = maxCrossAxis2;
                        i6 = constrainHeight-K40F9xA;
                        i4 = visibleItems;
                        list = firstItem3;
                        i21 = i9;
                        layoutWidth2 = obj77;
                        positionedItems = 0;
                    }
                    int i50 = positionedItems;
                    int i55 = index;
                    if (i55 >= i68) {
                        if (i75 > i21) {
                            i35 = i55;
                            index7 = i94;
                        } else {
                            i35 = i55;
                            index7 = i98;
                        }
                    } else {
                    }
                    anon = new LazyListMeasureKt.measureLazyList.8(list, i50, z5, graphicsContext);
                    if (constrainWidth-K40F9xA != 0) {
                        list2 = list;
                    } else {
                        List list8 = list;
                        anon = 0;
                        list2 = list;
                        ArrayList positionedItems2 = new ArrayList(list8.size());
                        disappearingItemsSize = 0;
                        i17 = positionedItems2;
                        size = list8.size();
                        context = list8;
                        $this$fastFilter$iv = z2;
                        while ($this$fastFilter$iv < size) {
                            i9 = z2;
                            vertical = null;
                            i16 = i9;
                            z3 = false;
                            if ((LazyListMeasuredItem)i16.getIndex() >= (LazyListMeasuredItem)layoutWidth3.first().getIndex()) {
                            } else {
                            }
                            if (i16 == i50) {
                            } else {
                            }
                            i8 = i98;
                            if (i8 != 0) {
                            } else {
                            }
                            it$iv = i9;
                            $this$fastFilter$iv = i15 + 1;
                            size = horizontal2;
                            mutableState = $this$fastForEach$iv$iv;
                            (Collection)i17.add(i9);
                            i8 = i94;
                            if (i16.getIndex() > (LazyListMeasuredItem)layoutWidth3.last().getIndex()) {
                            } else {
                            }
                        }
                        $this$fastForEach$iv$iv = mutableState;
                        i15 = $this$fastFilter$iv;
                        list = i17;
                    }
                    horizontal3 = headerIndexes ? Orientation.Vertical : Orientation.Horizontal;
                    int i99 = i50;
                    int i93 = i61;
                    float currentMainAxisOffset7 = f7;
                    List list11 = list2;
                    Object obj = obj12;
                    int currentFirstItemScrollOffset16 = i13;
                    LazyListMeasureResult lazyListMeasureResult = new LazyListMeasureResult(obj, i34, index7, currentMainAxisOffset7, (MeasureResult)layoutWidth2.invoke(Integer.valueOf(i4), Integer.valueOf(i6), anon), i5, remeasureNeeded2, placementScopeInvalidator, itemAnimator, measuredItemProvider.getChildConstraints-msEJaDk(), z5, list, -i25, i104 + afterContentPadding, i68, density, horizontal3, afterContentPadding, spaceBetweenItems, 0);
                    Object obj9 = obj;
                    float f6 = currentMainAxisOffset7;
                    return lazyListMeasureResult;
                }
                int currentFirstItemIndex5 = currentMainAxisOffset3;
                int i42 = 0;
                IllegalArgumentException $i$a$RequireLazyListMeasureKt$measureLazyList$4 = new IllegalArgumentException("negative currentFirstItemScrollOffset".toString());
                throw $i$a$RequireLazyListMeasureKt$measureLazyList$4;
            }
            int i39 = 0;
            IllegalArgumentException $i$a$RequireLazyListMeasureKt$measureLazyList$2 = new IllegalArgumentException("invalid afterContentPadding".toString());
            throw $i$a$RequireLazyListMeasureKt$measureLazyList$2;
        }
        int i38 = 0;
        IllegalArgumentException $i$a$RequireLazyListMeasureKt$measureLazyList$1 = new IllegalArgumentException("invalid beforeContentPadding".toString());
        throw $i$a$RequireLazyListMeasureKt$measureLazyList$1;
    }
}
