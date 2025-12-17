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
        int i3;
        int $this$fastForEach$iv;
        int i5;
        IntProgression reversed;
        boolean empty;
        int i4;
        int i6;
        Object obj2;
        int index;
        int i;
        int index$iv2;
        int index$iv;
        int[] iArr2;
        int i2;
        int last;
        Object ltr;
        int[] iArr;
        int size;
        int mainAxisSizeWithSpacings;
        int i7;
        int i8;
        int size2;
        currentMainAxis2 = items;
        final int i12 = layoutWidth;
        final int i13 = layoutHeight;
        final boolean z = reverseLayout;
        i3 = isVertical ? i13 : i12;
        final int i21 = i3;
        int i20 = 0;
        i2 = 1;
        i5 = finalMainAxisOffset < Math.min(i21, maxOffset) ? i2 : i20;
        final int i24 = i5;
        if (i24 != 0) {
            i5 = itemsScrollOffset == null ? i2 : i20;
            if (i5 == 0) {
            } else {
            }
            int i16 = 0;
            IllegalStateException illegalStateException = new IllegalStateException("non-zero itemsScrollOffset".toString());
            throw illegalStateException;
        }
        ArrayList arrayList = new ArrayList(i22 += iArr);
        final ArrayList list = arrayList;
        if (i24 != 0) {
            if (extraItemsBefore.isEmpty() && extraItemsAfter.isEmpty()) {
                if (extraItemsAfter.isEmpty()) {
                } else {
                    i2 = i20;
                }
            } else {
            }
            if (i2 == 0) {
            } else {
                size = currentMainAxis2.size();
                iArr2 = new int[size];
                i4 = i20;
                while (i4 < size) {
                    iArr2[i4] = (LazyListMeasuredItem)currentMainAxis2.get(LazyListMeasureKt.calculateItemsOffsets$reverseAware(i4, z, size)).getSize();
                    i4++;
                }
                iArr = new int[size];
                i6 = i20;
                while (i6 < size) {
                    iArr[i6] = i20;
                    i6++;
                }
                if (isVertical) {
                    if (verticalArrangement == null) {
                    } else {
                        i = 0;
                        verticalArrangement.arrange(density, i21, iArr2, iArr);
                        if (!z) {
                        } else {
                            reversed = RangesKt.reversed((IntProgression)ArraysKt.getIndices(iArr));
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
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                    throw illegalArgumentException3;
                }
                Density density3 = density;
                if (horizontalArrangement == null) {
                } else {
                    mainAxisSizeWithSpacings = 0;
                    horizontalArrangement.arrange(density, i21, iArr2, LayoutDirection.Ltr, iArr);
                }
                int i10 = 0;
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
                throw illegalArgumentException2;
            }
            int i9 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("no extra items".toString());
            throw illegalArgumentException;
        }
        int i11 = 0;
        currentMainAxis = itemsScrollOffset;
        Object obj = extraItemsBefore;
        int i18 = 0;
        index$iv2 = 0;
        while (index$iv2 < obj.size()) {
            iArr = last;
            size = 0;
            iArr.position(currentMainAxis -= mainAxisSizeWithSpacings, i12, i13);
            list.add(iArr);
            index$iv2++;
        }
        currentMainAxis2 = itemsScrollOffset;
        int i14 = items;
        int i19 = 0;
        index$iv = 0;
        while (index$iv < i14.size()) {
            iArr = last;
            size = 0;
            (LazyListMeasuredItem)iArr.position(currentMainAxis2, i12, i13);
            list.add(iArr);
            currentMainAxis2 += mainAxisSizeWithSpacings;
            index$iv++;
        }
        $this$fastForEach$iv = extraItemsAfter;
        reversed = 0;
        index = 0;
        while (index < $this$fastForEach$iv.size()) {
            iArr = last;
            size = 0;
            (LazyListMeasuredItem)iArr.position(currentMainAxis2, i12, i13);
            list.add(iArr);
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
        int andMeasure-0kLqBqw$default;
        int emptyList;
        int andMeasure-0kLqBqw$default3;
        int mainAxisSizeWithSpacings;
        int index$iv;
        int found;
        int index;
        int i6;
        long i5;
        int andMeasure-0kLqBqw$default2;
        int i3;
        int index$iv$iv2;
        int index$iv$iv;
        int i7;
        int totalOffset;
        int size;
        Object obj;
        int i;
        int i4;
        Object obj2;
        int i8;
        int i2;
        final int i9 = itemsCount;
        list = 0;
        int i10 = 0;
        end = Math.min(end2 + beyondBoundsItemCount, i9 + -1);
        andMeasure-0kLqBqw$default3 = 1;
        index2 += andMeasure-0kLqBqw$default3;
        if (andMeasure-0kLqBqw$default <= end) {
            found = andMeasure-0kLqBqw$default;
            while (list == null) {
                andMeasure-0kLqBqw$default = new ArrayList();
                list = andMeasure-0kLqBqw$default;
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
                    size3 -= andMeasure-0kLqBqw$default3;
                    while (-1 < i6) {
                        if ((LazyListItemInfo)visibleItemsInfo2.get(i6).getIndex() > end) {
                            break;
                        } else {
                        }
                        i6--;
                    }
                    andMeasure-0kLqBqw$default = CollectionsKt.last(lastPostLookaheadLayoutInfo.getVisibleItemsInfo());
                    if (found != 0) {
                        i6 = found.getIndex();
                        totalOffset = Math.min((LazyListItemInfo)andMeasure-0kLqBqw$default.getIndex(), i9 + -1);
                        if (i6 <= totalOffset) {
                            i5 = i6;
                            while (list != null) {
                                andMeasure-0kLqBqw$default2 = 0;
                                i3 = i6;
                                index$iv$iv2 = 0;
                                index$iv$iv = 0;
                                while (index$iv$iv < i3.size()) {
                                    i4 = 0;
                                    i8 = 0;
                                    i2 = andMeasure-0kLqBqw$default3;
                                    if ((LazyListMeasuredItem)i3.get(index$iv$iv).getIndex() == i5) {
                                    } else {
                                    }
                                    andMeasure-0kLqBqw$default3 = 0;
                                    index$iv$iv++;
                                    andMeasure-0kLqBqw$default3 = i2;
                                    andMeasure-0kLqBqw$default3 = i2;
                                }
                                i2 = andMeasure-0kLqBqw$default3;
                                i = 0;
                                if (i == 0 && list == null) {
                                }
                                if (i5 != totalOffset) {
                                }
                                i5++;
                                andMeasure-0kLqBqw$default3 = i2;
                                i2 = andMeasure-0kLqBqw$default3;
                                i = 0;
                                if (list == null) {
                                }
                                list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, i5, 0, i3, 2));
                                andMeasure-0kLqBqw$default3 = new ArrayList();
                                list = andMeasure-0kLqBqw$default3;
                                i4 = 0;
                                i8 = 0;
                                i2 = andMeasure-0kLqBqw$default3;
                                if ((LazyListMeasuredItem)i3.get(index$iv$iv).getIndex() == i5) {
                                } else {
                                }
                                andMeasure-0kLqBqw$default3 = 0;
                                if (andMeasure-0kLqBqw$default3 != 0) {
                                } else {
                                }
                                index$iv$iv++;
                                andMeasure-0kLqBqw$default3 = i2;
                                andMeasure-0kLqBqw$default3 = i2;
                            }
                        } else {
                            i2 = andMeasure-0kLqBqw$default3;
                        }
                    } else {
                        i2 = andMeasure-0kLqBqw$default3;
                    }
                    f -= consumedScroll;
                    if (Float.compare(andMeasure-0kLqBqw$default3, i16) > 0) {
                        int i17 = 0;
                        index5++;
                        totalOffset = index;
                        while (i5 < i9) {
                            if (Float.compare(f2, andMeasure-0kLqBqw$default3) < 0) {
                            }
                            if (i5 <= end) {
                            } else {
                            }
                            if (list != null) {
                            } else {
                            }
                            i = 0;
                            if (i != 0) {
                            } else {
                            }
                            if (list == null) {
                            }
                            list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, i5, 0, i3, 2));
                            i5++;
                            totalOffset += mainAxisSizeWithSpacings;
                            mainAxisSizeWithSpacings = new ArrayList();
                            list = mainAxisSizeWithSpacings;
                            i5++;
                            totalOffset += mainAxisSizeWithSpacings;
                            index = 0;
                            andMeasure-0kLqBqw$default2 = mainAxisSizeWithSpacings;
                            i3 = 0;
                            index$iv$iv2 = 0;
                            while (index$iv$iv2 < andMeasure-0kLqBqw$default2.size()) {
                                i = 0;
                                obj2 = null;
                                if ((LazyListMeasuredItem)andMeasure-0kLqBqw$default2.get(index$iv$iv2).getIndex() == i5) {
                                } else {
                                }
                                i7 = 0;
                                index$iv$iv2++;
                                i7 = i2;
                            }
                            obj = 0;
                            i = obj;
                            i = 0;
                            obj2 = null;
                            if ((LazyListMeasuredItem)andMeasure-0kLqBqw$default2.get(index$iv$iv2).getIndex() == i5) {
                            } else {
                            }
                            i7 = 0;
                            if (i7 != 0) {
                            } else {
                            }
                            index$iv$iv2++;
                            i7 = i2;
                            andMeasure-0kLqBqw$default2 = 0;
                            i3 = index;
                            index$iv$iv2 = 0;
                            index$iv$iv = 0;
                            while (index$iv$iv < i3.size()) {
                                i4 = 0;
                                i8 = 0;
                                if ((LazyListMeasuredItem)i3.get(index$iv$iv).getIndex() == i5) {
                                } else {
                                }
                                mainAxisSizeWithSpacings = 0;
                                index$iv$iv++;
                                mainAxisSizeWithSpacings = i2;
                            }
                            i = 0;
                            i4 = 0;
                            i8 = 0;
                            if ((LazyListMeasuredItem)i3.get(index$iv$iv).getIndex() == i5) {
                            } else {
                            }
                            mainAxisSizeWithSpacings = 0;
                            if (mainAxisSizeWithSpacings != 0) {
                            } else {
                            }
                            index$iv$iv++;
                            mainAxisSizeWithSpacings = i2;
                        }
                    }
                }
            }
        }
        andMeasure-0kLqBqw$default = list;
        andMeasure-0kLqBqw$default3 = 0;
        if (list != null && (LazyListMeasuredItem)CollectionsKt.last(andMeasure-0kLqBqw$default).getIndex() > end) {
            andMeasure-0kLqBqw$default = list;
            andMeasure-0kLqBqw$default3 = 0;
            if ((LazyListMeasuredItem)CollectionsKt.last(andMeasure-0kLqBqw$default).getIndex() > end) {
                end = (LazyListMeasuredItem)CollectionsKt.last(andMeasure-0kLqBqw$default).getIndex();
            }
        }
        Object obj3 = pinnedItems;
        int i13 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i5 = (Number)obj3.get(index$iv).intValue();
            totalOffset = 0;
            if (i5 > end && list == null) {
            }
            index$iv++;
            if (list == null) {
            }
            list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, i5, 0, i3, 2));
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
        int i2;
        androidx.compose.foundation.lazy.LazyListMeasuredItem andMeasure-0kLqBqw$default;
        int i5;
        long arrayList2;
        int intValue;
        int andMeasure-0kLqBqw$default2;
        int i;
        int i3;
        int i4;
        Object obj;
        int i6;
        list = 0;
        int i7 = 0;
        int start2 = Math.max(0, start - beyondBoundsItemCount);
        arrayList = currentFirstItemIndex + -1;
        if (start2 <= arrayList) {
            i2 = arrayList;
            while (list == null) {
                arrayList = new ArrayList();
                list = arrayList;
                list.add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, i2, 0, obj5, 2));
                if (i2 != start2) {
                }
                i2--;
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
        int i9;
        int i16;
        ArrayList minSizeToFitDisappearingItems-YbymL2g2;
        int currentFirstItemIndex;
        int index6;
        int index4;
        int currentMainAxisOffset4;
        androidx.compose.foundation.lazy.LazyListMeasuredItemProvider index7;
        int size;
        List list3;
        boolean equal;
        int i3;
        int i12;
        List minSizeToFitDisappearingItems-YbymL2g;
        List list;
        int size2;
        int i31;
        Orientation horizontal2;
        int currentFirstItemScrollOffset3;
        int currentFirstItemScrollOffset4;
        int currentFirstItemScrollOffset;
        int currentFirstItemScrollOffset10;
        int currentFirstItemScrollOffset2;
        int scrollDelta;
        Object currentFirstItemScrollOffset9;
        int firstItem2;
        int index$iv;
        int i14;
        int index8;
        boolean height-impl;
        int $this$fastRoundToInt$iv;
        int measuredItem;
        int measuredItem2;
        int currentMainAxisOffset2;
        int index$iv2;
        int i28;
        int currentFirstItemIndex3;
        int mainAxisSizeWithSpacings;
        int constrainWidth-K40F9xA;
        int index5;
        List mutableState;
        int index3;
        int i17;
        int it$iv;
        Orientation horizontal3;
        int i;
        int currentMainAxisOffset;
        float sign;
        int i21;
        int i7;
        int visibleItemsScrollOffset;
        int maxCrossAxis2;
        int $this$fastFilter$iv;
        int index2;
        int i5;
        int indexInVisibleItems;
        float f;
        int constrainHeight-K40F9xA;
        int sign2;
        int scrollDelta2;
        int currentMainAxisOffset3;
        int i27;
        Object firstItem;
        int i18;
        int preScrollBackScrollDelta;
        Object obj5;
        int maxCrossAxis;
        int i29;
        int currentFirstItemScrollOffset5;
        int currentFirstItemScrollOffset6;
        int currentFirstItemScrollOffset7;
        int visibleItems;
        Object layoutWidth;
        int i36;
        int minOffset;
        int i2;
        int positionedItems;
        int anon;
        int remeasureNeeded;
        int i19;
        androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap keyIndexMap;
        int currentFirstItemIndex2;
        Object index$iv3;
        androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider lazyLayoutMeasuredItemProvider;
        List list2;
        int layoutWidth2;
        int i30;
        boolean disappearingItemsSize;
        int layoutHeight;
        int currentFirstItemScrollOffset8;
        int z3;
        int i11;
        int i13;
        int i4;
        int i35;
        boolean z2;
        int i8;
        int i6;
        int i25;
        int i15;
        int i23;
        int i20;
        Object context;
        int i10;
        int i22;
        Arrangement.Vertical vertical;
        Arrangement.Horizontal horizontal;
        boolean z;
        Density $this$fastForEach$iv$iv;
        int remeasureNeeded2;
        int i24;
        int maxMainAxis;
        int i32;
        int i33;
        int index;
        int i34;
        int i37;
        Object first;
        int i26;
        int i78 = itemsCount;
        preScrollBackScrollDelta = beforeContentPadding;
        Object obj4 = constraints;
        i29 = 0;
        int i94 = 1;
        i9 = preScrollBackScrollDelta >= 0 ? i94 : i29;
        if (i9 == 0) {
        } else {
            i16 = afterContentPadding >= 0 ? i94 : i29;
            if (i16 == 0) {
            } else {
                minSizeToFitDisappearingItems-YbymL2g2 = new ArrayList();
                beyondBoundsItemCount.onMeasured(0, Constraints.getMinWidth-impl(obj4), Constraints.getMinHeight-impl(obj4), (List)minSizeToFitDisappearingItems-YbymL2g2, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, headerIndexes, postLookaheadLayoutInfo, 1, isLookingAhead, 0, 0, placementScopeInvalidator, layout);
                minSizeToFitDisappearingItems-YbymL2g2 = beyondBoundsItemCount.getMinSizeToFitDisappearingItems-YbymL2g();
                if (i78 <= 0 && !postLookaheadLayoutInfo && !IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g2, obj1)) {
                    minSizeToFitDisappearingItems-YbymL2g2 = new ArrayList();
                    beyondBoundsItemCount.onMeasured(0, Constraints.getMinWidth-impl(obj4), Constraints.getMinHeight-impl(obj4), (List)minSizeToFitDisappearingItems-YbymL2g2, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, headerIndexes, postLookaheadLayoutInfo, 1, isLookingAhead, 0, 0, placementScopeInvalidator, layout);
                    if (!postLookaheadLayoutInfo) {
                        minSizeToFitDisappearingItems-YbymL2g2 = beyondBoundsItemCount.getMinSizeToFitDisappearingItems-YbymL2g();
                        if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g2, obj1)) {
                            layoutWidth2 = ConstraintsKt.constrainWidth-K40F9xA(obj4, obj10);
                            layoutHeight = ConstraintsKt.constrainHeight-K40F9xA(obj4, obj10);
                        }
                    }
                    horizontal2 = headerIndexes ? Orientation.Vertical : Orientation.Horizontal;
                    LazyListMeasureResult lazyListMeasureResult2 = new LazyListMeasureResult(0, 0, 0, 0, (MeasureResult)obj77.invoke(Integer.valueOf(layoutWidth2), Integer.valueOf(layoutHeight), LazyListMeasureKt.measureLazyList.3.INSTANCE), 0, 0, placementScopeInvalidator, itemAnimator, measuredItemProvider.getChildConstraints-msEJaDk(), obj31, CollectionsKt.emptyList(), -preScrollBackScrollDelta, mainAxisAvailableSize + afterContentPadding, 0, density, horizontal2, afterContentPadding, spaceBetweenItems, 0);
                    return lazyListMeasureResult2;
                }
                currentFirstItemScrollOffset3 = firstVisibleItemScrollOffset;
                if (firstVisibleItemIndex >= i78) {
                    currentFirstItemIndex = i78 + -1;
                    currentFirstItemScrollOffset3 = 0;
                }
                int i53 = 0;
                $this$fastRoundToInt$iv = Math.round(scrollToBeConsumed);
                currentFirstItemScrollOffset3 -= $this$fastRoundToInt$iv;
                if (currentFirstItemIndex == 0 && currentFirstItemScrollOffset4 < 0) {
                    if (currentFirstItemScrollOffset4 < 0) {
                        currentFirstItemScrollOffset4 = 0;
                        scrollDelta2 = $this$fastRoundToInt$iv;
                    } else {
                        scrollDelta2 = $this$fastRoundToInt$iv;
                    }
                } else {
                }
                ArrayDeque scrollDelta4 = new ArrayDeque();
                ArrayDeque queue2 = scrollDelta4;
                i28 = spaceBetweenItems < 0 ? spaceBetweenItems : i29;
                int i77 = i48 + i28;
                int i70 = mainAxisAvailableSize;
                currentFirstItemScrollOffset4 += i77;
                measuredItem = 0;
                remeasureNeeded = 0;
                currentFirstItemIndex2 = currentFirstItemIndex;
                while (currentFirstItemScrollOffset < 0) {
                    if (currentFirstItemIndex2 > 0) {
                    }
                    int currentFirstItemScrollOffset14 = currentFirstItemIndex2 + -1;
                    androidx.compose.foundation.lazy.LazyListMeasuredItem andMeasure-0kLqBqw$default2 = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, currentFirstItemScrollOffset14, 0, i28, 2);
                    queue2.add(i29, andMeasure-0kLqBqw$default2);
                    currentFirstItemIndex2 = currentFirstItemScrollOffset14;
                    measuredItem = currentFirstItemIndex;
                    currentFirstItemScrollOffset = i28;
                }
                int i60 = currentFirstItemScrollOffset;
                currentFirstItemIndex3 = measuredItem;
                currentFirstItemScrollOffset10 = i60 < i77 ? i77 : i60;
                currentFirstItemScrollOffset10 -= i77;
                index6 = currentFirstItemIndex2;
                currentMainAxisOffset = -currentFirstItemScrollOffset12;
                indexInVisibleItems = 0;
                while (indexInVisibleItems < queue2.size()) {
                    if (currentMainAxisOffset >= RangesKt.coerceAtLeast(i70 + afterContentPadding, i29)) {
                    } else {
                    }
                    index6++;
                    currentMainAxisOffset += mainAxisSizeWithSpacings5;
                    indexInVisibleItems++;
                    i29 = 0;
                    queue2.remove(indexInVisibleItems);
                    remeasureNeeded = 1;
                    i29 = 0;
                }
                currentFirstItemScrollOffset5 = currentFirstItemScrollOffset12;
                remeasureNeeded2 = remeasureNeeded;
                currentFirstItemScrollOffset2 = index6;
                index4 = currentMainAxisOffset;
                while (currentFirstItemScrollOffset2 < i78) {
                    int i74 = i11;
                    androidx.compose.foundation.lazy.LazyListMeasuredItem andMeasure-0kLqBqw$default = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, currentFirstItemScrollOffset2, 0, currentFirstItemIndex3, 2);
                    int i43 = currentFirstItemScrollOffset2;
                    mainAxisSizeWithSpacings2 += scrollDelta5;
                    if (i47 <= i77 && i43 != i78 + -1) {
                    } else {
                    }
                    currentFirstItemIndex3 = Math.max(i74, andMeasure-0kLqBqw$default.getCrossAxisSize());
                    queue2.add(andMeasure-0kLqBqw$default);
                    currentFirstItemScrollOffset2 = index10;
                    index4 = measuredItem3;
                    obj5 = obj77;
                    scrollDelta2 = i4;
                    measuredItem2 = i24;
                    indexInVisibleItems = i32;
                    if (i43 != i78 + -1) {
                    } else {
                    }
                    currentFirstItemScrollOffset5 -= mainAxisSizeWithSpacings4;
                    currentFirstItemIndex2 = i58;
                    remeasureNeeded2 = currentMainAxisOffset;
                    currentFirstItemIndex3 = i74;
                }
                maxMainAxis = measuredItem2;
                maxCrossAxis = currentFirstItemIndex3;
                i33 = indexInVisibleItems;
                i35 = scrollDelta2;
                currentMainAxisOffset3 = index4;
                currentMainAxisOffset4 = currentFirstItemScrollOffset2;
                if (currentMainAxisOffset3 < i70) {
                    remeasureNeeded = i70 - currentMainAxisOffset3;
                    currentFirstItemScrollOffset5 -= remeasureNeeded;
                    currentMainAxisOffset3 += remeasureNeeded;
                    while (currentFirstItemScrollOffset7 < preScrollBackScrollDelta) {
                        int preScrollBackScrollDelta3 = currentFirstItemIndex2 + -1;
                        measuredItem2 = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(measuredItemProvider, preScrollBackScrollDelta3, 0, currentFirstItemIndex3, 2);
                        queue2.add(0, measuredItem2);
                        maxCrossAxis = Math.max(maxCrossAxis, measuredItem2.getCrossAxisSize());
                        currentFirstItemScrollOffset7 += currentMainAxisOffset;
                        currentFirstItemIndex2 = preScrollBackScrollDelta3;
                        index8 = i71;
                        currentMainAxisOffset4 = i37;
                        preScrollBackScrollDelta = beforeContentPadding;
                    }
                    index = currentMainAxisOffset4;
                    i18 = index8;
                    mainAxisSizeWithSpacings = 0;
                    index7 = measuredItemProvider;
                    int preScrollBackScrollDelta2 = i35 + remeasureNeeded;
                    if (currentFirstItemScrollOffset7 < 0) {
                        currentFirstItemScrollOffset6 = scrollDelta3;
                        scrollDelta = i90;
                        i25 = i51;
                        currentMainAxisOffset2 = currentFirstItemIndex2;
                    } else {
                        currentFirstItemScrollOffset6 = preScrollBackScrollDelta2;
                        scrollDelta = currentMainAxisOffset6;
                        i25 = currentMainAxisOffset3;
                        currentMainAxisOffset2 = currentFirstItemIndex2;
                    }
                } else {
                    index = currentMainAxisOffset4;
                    i18 = index8;
                    mainAxisSizeWithSpacings = 0;
                    index7 = measuredItemProvider;
                    i25 = currentMainAxisOffset3;
                    scrollDelta = currentFirstItemScrollOffset5;
                    currentMainAxisOffset2 = currentFirstItemIndex2;
                    currentFirstItemScrollOffset6 = i35;
                }
                int i65 = 0;
                int i66 = 0;
                if (MathKt.getSign(Math.round(scrollToBeConsumed)) == MathKt.getSign(currentFirstItemScrollOffset6) && Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(currentFirstItemScrollOffset6)) {
                    i66 = 0;
                    f = Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(currentFirstItemScrollOffset6) ? sign : scrollToBeConsumed;
                } else {
                }
                final int i109 = scrollToBeConsumed - f;
                i21 = 0;
                if (postLookaheadLayoutInfo && currentFirstItemScrollOffset6 > i18 && Float.compare(i109, i21) <= 0) {
                    if (currentFirstItemScrollOffset6 > i18) {
                        if (Float.compare(i109, i21) <= 0) {
                            i27 = i21;
                        } else {
                            i27 = i21;
                        }
                    } else {
                    }
                } else {
                }
                i7 = scrollDelta >= 0 ? i94 : mainAxisSizeWithSpacings;
                if (i7 == 0) {
                } else {
                    visibleItemsScrollOffset = -scrollDelta;
                    if (beforeContentPadding <= 0) {
                        if (spaceBetweenItems < 0) {
                            mainAxisSizeWithSpacings = queue2.size();
                            i22 = visibleItemsScrollOffset;
                            visibleItemsScrollOffset = remeasureNeeded;
                            while (visibleItemsScrollOffset < mainAxisSizeWithSpacings) {
                                mainAxisSizeWithSpacings = (LazyListMeasuredItem)queue2.get(visibleItemsScrollOffset).getMainAxisSizeWithSpacings();
                                firstItem = obj2;
                                visibleItemsScrollOffset++;
                                scrollDelta = remeasureNeeded;
                                mainAxisSizeWithSpacings = currentFirstItemIndex2;
                            }
                            currentFirstItemScrollOffset8 = scrollDelta;
                            i6 = currentFirstItemScrollOffset8;
                            currentFirstItemScrollOffset9 = firstItem;
                        } else {
                            i6 = scrollDelta;
                            i22 = visibleItemsScrollOffset;
                            currentFirstItemScrollOffset9 = firstItem;
                        }
                    } else {
                    }
                    int i54 = pinnedItems;
                    List list7 = hasLookaheadPassOccurred;
                    List itemsBeforeList = LazyListMeasureKt.createItemsBeforeList(currentMainAxisOffset2, index7, i54, list7);
                    List list9 = itemsBeforeList;
                    i19 = 0;
                    size = list9.size();
                    firstItem2 = i113;
                    while (firstItem2 < size) {
                        i35 = 0;
                        maxCrossAxis = Math.max(maxCrossAxis, (LazyListMeasuredItem)list9.get(firstItem2).getCrossAxisSize());
                        firstItem2++;
                        size = i23;
                    }
                    int i111 = currentMainAxisOffset2;
                    i10 = i70;
                    int currentFirstItemIndex4 = i78;
                    Object obj8 = index$iv3;
                    int i83 = 0;
                    List itemsAfterList = LazyListMeasureKt.createItemsAfterList((List)queue2, measuredItemProvider, currentFirstItemIndex4, i54, list7, f, postLookaheadLayoutInfo, coroutineScope);
                    int i68 = currentFirstItemIndex4;
                    float f7 = f;
                    int i45 = 0;
                    index$iv2 = 0;
                    maxCrossAxis2 = maxCrossAxis;
                    while (index$iv2 < itemsAfterList.size()) {
                        i19 = 0;
                        maxCrossAxis2 = Math.max(maxCrossAxis2, (LazyListMeasuredItem)list3.get(index$iv2).getCrossAxisSize());
                        index$iv2++;
                        list3 = index$iv3;
                    }
                    List $this$fastForEach$iv = list3;
                    if (Intrinsics.areEqual(obj8, queue2.first()) && itemsBeforeList.isEmpty() && itemsAfterList.isEmpty()) {
                        if (itemsBeforeList.isEmpty()) {
                            constrainWidth-K40F9xA = itemsAfterList.isEmpty() ? i94 : i83;
                        } else {
                        }
                    } else {
                    }
                    i3 = headerIndexes ? maxCrossAxis2 : i25;
                    int constrainWidth-K40F9xA2 = ConstraintsKt.constrainWidth-K40F9xA(obj4, obj10);
                    i12 = headerIndexes ? i25 : maxCrossAxis2;
                    int constrainHeight-K40F9xA2 = ConstraintsKt.constrainHeight-K40F9xA(obj4, obj10);
                    index$iv = currentFirstItemScrollOffset6;
                    ArrayDeque layoutWidth3 = queue2;
                    visibleItems = i72;
                    int layoutHeight2 = i77;
                    minOffset = i73;
                    z3 = postLookaheadLayoutInfo;
                    int i102 = index$iv;
                    int i98 = i83;
                    List firstItem3 = minSizeToFitDisappearingItems-YbymL2g;
                    beyondBoundsItemCount.onMeasured((int)f7, visibleItems, minOffset, firstItem3, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, headerIndexes, z3, 1, isLookingAhead, i6, i25, placementScopeInvalidator, layout);
                    boolean z5 = z3;
                    int i75 = i25;
                    if (!z5) {
                        minSizeToFitDisappearingItems-YbymL2g = beyondBoundsItemCount.getMinSizeToFitDisappearingItems-YbymL2g();
                        if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, index$iv)) {
                            index$iv2 = headerIndexes ? minOffset : visibleItems;
                            constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(obj4, obj10);
                            i36 = headerIndexes ? constrainHeight-K40F9xA : constrainWidth-K40F9xA;
                            if (i36 != index$iv2) {
                                minOffset = firstItem3;
                                keyIndexMap = 0;
                                disappearingItemsSize = minSizeToFitDisappearingItems-YbymL2g;
                                minSizeToFitDisappearingItems-YbymL2g = minOffset.size();
                                index$iv = lazyLayoutMeasuredItemProvider;
                                while (index$iv < minSizeToFitDisappearingItems-YbymL2g) {
                                    z2 = false;
                                    (LazyListMeasuredItem)minOffset.get(index$iv).updateMainAxisLayoutSize(i36);
                                    index$iv++;
                                    minSizeToFitDisappearingItems-YbymL2g = i13;
                                }
                            } else {
                                disappearingItemsSize = minSizeToFitDisappearingItems-YbymL2g;
                            }
                            visibleItems = constrainWidth-K40F9xA;
                        } else {
                            disappearingItemsSize = minSizeToFitDisappearingItems-YbymL2g;
                            constrainHeight-K40F9xA = minOffset;
                        }
                    } else {
                    }
                    if (!(Collection)verticalArrangement.isEmpty()) {
                        constrainWidth-K40F9xA = beforeContentPadding;
                        i8 = maxCrossAxis2;
                        maxCrossAxis2 = visibleItems;
                        i2 = i10;
                        layoutWidth = obj77;
                        positionedItems = LazyListHeadersKt.findOrComposeLazyListHeader(firstItem3, measuredItemProvider, verticalArrangement, constrainWidth-K40F9xA, maxCrossAxis2, constrainHeight-K40F9xA);
                        i14 = constrainWidth-K40F9xA;
                        i15 = maxCrossAxis2;
                        i20 = constrainHeight-K40F9xA;
                    } else {
                        i14 = beforeContentPadding;
                        i8 = maxCrossAxis2;
                        i20 = constrainHeight-K40F9xA;
                        i15 = visibleItems;
                        list = firstItem3;
                        i2 = i10;
                        layoutWidth = obj77;
                        positionedItems = 0;
                    }
                    int i50 = positionedItems;
                    int i55 = index;
                    if (i55 >= i68) {
                        if (i75 > i2) {
                            i34 = i55;
                            index5 = i94;
                        } else {
                            i34 = i55;
                            index5 = i98;
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
                        i13 = positionedItems2;
                        size2 = list8.size();
                        context = list8;
                        $this$fastFilter$iv = z3;
                        while ($this$fastFilter$iv < size2) {
                            i10 = z3;
                            vertical = null;
                            i31 = i10;
                            z = false;
                            if ((LazyListMeasuredItem)i31.getIndex() >= (LazyListMeasuredItem)layoutWidth3.first().getIndex()) {
                            } else {
                            }
                            if (i31 == i50) {
                            } else {
                            }
                            i17 = i98;
                            if (i17 != 0) {
                            } else {
                            }
                            it$iv = i10;
                            $this$fastFilter$iv = i26 + 1;
                            size2 = horizontal;
                            mutableState = $this$fastForEach$iv$iv;
                            (Collection)i13.add(i10);
                            i17 = i94;
                            if (i31.getIndex() > (LazyListMeasuredItem)layoutWidth3.last().getIndex()) {
                            } else {
                            }
                        }
                        $this$fastForEach$iv$iv = mutableState;
                        i26 = $this$fastFilter$iv;
                        list = i13;
                    }
                    horizontal3 = headerIndexes ? Orientation.Vertical : Orientation.Horizontal;
                    int i99 = i50;
                    int i93 = i61;
                    float currentMainAxisOffset7 = f7;
                    List list11 = list2;
                    Object obj = obj12;
                    int currentFirstItemScrollOffset16 = i18;
                    LazyListMeasureResult lazyListMeasureResult = new LazyListMeasureResult(obj, i6, index5, currentMainAxisOffset7, (MeasureResult)layoutWidth.invoke(Integer.valueOf(i15), Integer.valueOf(i20), anon), i27, remeasureNeeded2, placementScopeInvalidator, itemAnimator, measuredItemProvider.getChildConstraints-msEJaDk(), z5, list, -i14, i104 + afterContentPadding, i68, density, horizontal3, afterContentPadding, spaceBetweenItems, 0);
                    Object obj9 = obj;
                    float f6 = currentMainAxisOffset7;
                    return lazyListMeasureResult;
                }
                int currentFirstItemIndex5 = currentMainAxisOffset2;
                int i42 = 0;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("negative currentFirstItemScrollOffset".toString());
                throw illegalArgumentException3;
            }
            int i39 = 0;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("invalid afterContentPadding".toString());
            throw illegalArgumentException2;
        }
        int i38 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid beforeContentPadding".toString());
        throw illegalArgumentException;
    }
}
