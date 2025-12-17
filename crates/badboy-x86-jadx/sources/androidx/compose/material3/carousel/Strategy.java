package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B/\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005¢\u0006\u0002\u0010\tBK\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\u0013\u0010\"\u001a\u00020\u001a2\u0008\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J'\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0008\u0008\u0002\u0010'\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0008(J\u0008\u0010)\u001a\u00020*H\u0016R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u000fR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0015R\u000e\u0010 \u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Landroidx/compose/material3/carousel/Strategy;", "", "defaultKeylines", "Landroidx/compose/material3/carousel/KeylineList;", "availableSpace", "", "itemSpacing", "beforeContentPadding", "afterContentPadding", "(Landroidx/compose/material3/carousel/KeylineList;FFFF)V", "startKeylineSteps", "", "endKeylineSteps", "(Landroidx/compose/material3/carousel/KeylineList;Ljava/util/List;Ljava/util/List;FFFF)V", "getAfterContentPadding", "()F", "getAvailableSpace", "getBeforeContentPadding", "getDefaultKeylines", "()Landroidx/compose/material3/carousel/KeylineList;", "getEndKeylineSteps", "()Ljava/util/List;", "endShiftDistance", "endShiftPoints", "Landroidx/collection/FloatList;", "isValid", "", "()Z", "itemMainAxisSize", "getItemMainAxisSize", "getItemSpacing", "getStartKeylineSteps", "startShiftDistance", "startShiftPoints", "equals", "other", "getKeylineListForScrollOffset", "scrollOffset", "maxScrollOffset", "roundToNearestStep", "getKeylineListForScrollOffset$material3_release", "hashCode", "", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Strategy {

    public static final int $stable = 8;
    public static final androidx.compose.material3.carousel.Strategy.Companion Companion;
    private static final androidx.compose.material3.carousel.Strategy Empty;
    private final float afterContentPadding;
    private final float availableSpace;
    private final float beforeContentPadding;
    private final androidx.compose.material3.carousel.KeylineList defaultKeylines;
    private final List<androidx.compose.material3.carousel.KeylineList> endKeylineSteps;
    private final float endShiftDistance;
    private final FloatList endShiftPoints;
    private final boolean isValid;
    private final float itemSpacing;
    private final List<androidx.compose.material3.carousel.KeylineList> startKeylineSteps;
    private final float startShiftDistance;
    private final FloatList startShiftPoints;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/material3/carousel/Strategy$Companion;", "", "()V", "Empty", "Landroidx/compose/material3/carousel/Strategy;", "getEmpty", "()Landroidx/compose/material3/carousel/Strategy;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.material3.carousel.Strategy getEmpty() {
            return Strategy.access$getEmpty$cp();
        }
    }
    static {
        Strategy.Companion companion = new Strategy.Companion(0);
        Strategy.Companion = companion;
        int i = 8;
        Strategy strategy = new Strategy(KeylineListKt.emptyKeylineList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0, 0, 0, 0);
        Strategy.Empty = strategy;
    }

    public Strategy(androidx.compose.material3.carousel.KeylineList defaultKeylines, float availableSpace, float itemSpacing, float beforeContentPadding, float afterContentPadding) {
        super(defaultKeylines, StrategyKt.access$getStartKeylineSteps(defaultKeylines, availableSpace, itemSpacing, beforeContentPadding), StrategyKt.access$getEndKeylineSteps(defaultKeylines, availableSpace, itemSpacing, afterContentPadding), availableSpace, itemSpacing, beforeContentPadding, afterContentPadding);
    }

    private Strategy(androidx.compose.material3.carousel.KeylineList defaultKeylines, List<androidx.compose.material3.carousel.KeylineList> startKeylineSteps, List<androidx.compose.material3.carousel.KeylineList> endKeylineSteps, float availableSpace, float itemSpacing, float beforeContentPadding, float afterContentPadding) {
        boolean empty;
        List endKeylineSteps2;
        int i;
        super();
        this.defaultKeylines = defaultKeylines;
        this.startKeylineSteps = startKeylineSteps;
        this.endKeylineSteps = endKeylineSteps;
        this.availableSpace = availableSpace;
        this.itemSpacing = itemSpacing;
        this.beforeContentPadding = beforeContentPadding;
        this.afterContentPadding = afterContentPadding;
        this.startShiftDistance = StrategyKt.access$getStartShiftDistance(this.startKeylineSteps, this.beforeContentPadding);
        this.endShiftDistance = StrategyKt.access$getEndShiftDistance(this.endKeylineSteps, this.afterContentPadding);
        i = 1;
        this.startShiftPoints = StrategyKt.access$getStepInterpolationPoints(this.startShiftDistance, this.startKeylineSteps, i);
        final int i2 = 0;
        this.endShiftPoints = StrategyKt.access$getStepInterpolationPoints(this.endShiftDistance, this.endKeylineSteps, i2);
        if (!(Collection)this.defaultKeylines.isEmpty()) {
            endKeylineSteps2 = 0;
            empty = Float.compare(availableSpace2, endKeylineSteps2) == 0 ? i : i2;
            if (empty == 0) {
                empty = Float.compare(itemMainAxisSize, endKeylineSteps2) == 0 ? i : i2;
                if (empty == 0) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        this.isValid = i;
    }

    public static final androidx.compose.material3.carousel.Strategy access$getEmpty$cp() {
        return Strategy.Empty;
    }

    public static androidx.compose.material3.carousel.KeylineList getKeylineListForScrollOffset$material3_release$default(androidx.compose.material3.carousel.Strategy strategy, float f2, float f3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return strategy.getKeylineListForScrollOffset$material3_release(f2, f3, obj3);
    }

    public boolean equals(Object other) {
        boolean isValid;
        int i;
        int i4;
        int i5;
        int i2;
        int i3;
        int i6;
        int i7;
        final int i8 = 1;
        if (this == other) {
            return i8;
        }
        final int i9 = 0;
        if (!other instanceof Strategy) {
            return i9;
        }
        if (!this.isValid && !obj.isValid) {
            if (!obj.isValid) {
                return i8;
            }
        }
        if (this.isValid != obj2.isValid) {
            return i9;
        }
        i = Float.compare(availableSpace, availableSpace2) == 0 ? i8 : i9;
        if (i == 0) {
            return i9;
        }
        i4 = Float.compare(itemSpacing, itemSpacing2) == 0 ? i8 : i9;
        if (i4 == 0) {
            return i9;
        }
        i5 = Float.compare(beforeContentPadding, beforeContentPadding2) == 0 ? i8 : i9;
        if (i5 == 0) {
            return i9;
        }
        i2 = Float.compare(afterContentPadding, afterContentPadding2) == 0 ? i8 : i9;
        if (i2 == 0) {
            return i9;
        }
        i3 = Float.compare(itemMainAxisSize, itemMainAxisSize2) == 0 ? i8 : i9;
        if (i3 == 0) {
            return i9;
        }
        i6 = Float.compare(startShiftDistance, startShiftDistance2) == 0 ? i8 : i9;
        if (i6 == 0) {
            return i9;
        }
        i7 = Float.compare(endShiftDistance, endShiftDistance2) == 0 ? i8 : i9;
        if (i7 == 0) {
            return i9;
        }
        if (!Intrinsics.areEqual(this.startShiftPoints, obj10.startShiftPoints)) {
            return i9;
        }
        if (!Intrinsics.areEqual(this.endShiftPoints, obj11.endShiftPoints)) {
            return i9;
        }
        if (!Intrinsics.areEqual(this.defaultKeylines, obj12.defaultKeylines)) {
            return i9;
        }
        return i8;
    }

    public final float getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final float getAvailableSpace() {
        return this.availableSpace;
    }

    public final float getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final androidx.compose.material3.carousel.KeylineList getDefaultKeylines() {
        return this.defaultKeylines;
    }

    public final List<androidx.compose.material3.carousel.KeylineList> getEndKeylineSteps() {
        return this.endKeylineSteps;
    }

    public final float getItemMainAxisSize() {
        return this.defaultKeylines.getFirstFocal().getSize();
    }

    public final float getItemSpacing() {
        return this.itemSpacing;
    }

    public final androidx.compose.material3.carousel.KeylineList getKeylineListForScrollOffset$material3_release(float scrollOffset, float maxScrollOffset, boolean roundToNearestStep) {
        int i;
        int cmp;
        int fromStepIndex;
        int i2;
        float interpolation;
        FloatList shiftPoints;
        List steps;
        i = 0;
        final float f = Math.max(i, scrollOffset);
        final float startShiftDistance = this.startShiftDistance;
        float f2 = Math.max(i, maxScrollOffset - endShiftDistance);
        i2 = 0;
        if (Float.compare(startShiftDistance, f) <= 0 && Float.compare(f, f2) <= 0) {
            if (Float.compare(f, f2) <= 0) {
                i2 = 1;
            }
        }
        if (i2 != 0) {
            return this.defaultKeylines;
        }
        int i4 = 1065353216;
        interpolation = StrategyKt.access$lerp(i4, i, i, startShiftDistance, f);
        shiftPoints = this.startShiftPoints;
        steps = this.startKeylineSteps;
        if (Float.compare(f, f2) > 0) {
            interpolation = i;
            shiftPoints = this.endShiftPoints;
            steps = this.endKeylineSteps;
        }
        androidx.compose.material3.carousel.ShiftPointRange shiftPointRange = StrategyKt.access$getShiftPointRange(steps.size(), shiftPoints, interpolation);
        if (roundToNearestStep) {
            if (MathKt.roundToInt(shiftPointRange.getSteppedInterpolation()) == 0) {
                fromStepIndex = shiftPointRange.getFromStepIndex();
            } else {
                fromStepIndex = shiftPointRange.getToStepIndex();
            }
            return (KeylineList)steps.get(fromStepIndex);
        }
        return KeylineListKt.lerp((KeylineList)steps.get(shiftPointRange.getFromStepIndex()), (KeylineList)steps.get(shiftPointRange.getToStepIndex()), shiftPointRange.getSteppedInterpolation());
    }

    public final List<androidx.compose.material3.carousel.KeylineList> getStartKeylineSteps() {
        return this.startKeylineSteps;
    }

    public int hashCode() {
        if (!this.isValid) {
            return Boolean.hashCode(this.isValid);
        }
        return result5 += i23;
    }

    public final boolean isValid() {
        return this.isValid;
    }
}
