package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0007H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0016", d2 = {"Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "", "current", "", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "(FLkotlin/ranges/ClosedFloatingPointRange;I)V", "getCurrent", "()F", "getRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "getSteps", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProgressBarRangeInfo {

    public static final int $stable;
    public static final androidx.compose.ui.semantics.ProgressBarRangeInfo.Companion Companion;
    private static final androidx.compose.ui.semantics.ProgressBarRangeInfo Indeterminate;
    private final float current;
    private final ClosedFloatingPointRange<Float> range;
    private final int steps;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/semantics/ProgressBarRangeInfo$Companion;", "", "()V", "Indeterminate", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getIndeterminate", "()Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.semantics.ProgressBarRangeInfo getIndeterminate() {
            return ProgressBarRangeInfo.access$getIndeterminate$cp();
        }
    }
    static {
        ProgressBarRangeInfo.Companion companion = new ProgressBarRangeInfo.Companion(0);
        ProgressBarRangeInfo.Companion = companion;
        int i = 0;
        ProgressBarRangeInfo progressBarRangeInfo = new ProgressBarRangeInfo(0, RangesKt.rangeTo(i, i), 0, 4, 0);
        ProgressBarRangeInfo.Indeterminate = progressBarRangeInfo;
    }

    public ProgressBarRangeInfo(float current, ClosedFloatingPointRange<Float> range, int steps) {
        super();
        this.current = current;
        this.range = range;
        this.steps = steps;
        if (Float.isNaN(this.current)) {
        } else {
        }
        int i = 0;
        IllegalArgumentException $i$a$RequireProgressBarRangeInfo$1 = new IllegalArgumentException("current must not be NaN".toString());
        throw $i$a$RequireProgressBarRangeInfo$1;
    }

    public ProgressBarRangeInfo(float f, ClosedFloatingPointRange closedFloatingPointRange2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(f, closedFloatingPointRange2, obj3);
    }

    public static final androidx.compose.ui.semantics.ProgressBarRangeInfo access$getIndeterminate$cp() {
        return ProgressBarRangeInfo.Indeterminate;
    }

    public boolean equals(Object other) {
        int i;
        final int i2 = 1;
        if (this == other) {
            return i2;
        }
        final int i3 = 0;
        if (!other instanceof ProgressBarRangeInfo) {
            return i3;
        }
        i = Float.compare(current, current2) == 0 ? i2 : i3;
        if (i == 0) {
            return i3;
        }
        if (!Intrinsics.areEqual(this.range, obj2.range)) {
            return i3;
        }
        if (this.steps != obj3.steps) {
            return i3;
        }
        return i2;
    }

    public final float getCurrent() {
        return this.current;
    }

    public final ClosedFloatingPointRange<Float> getRange() {
        return this.range;
    }

    public final int getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return result += steps;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ProgressBarRangeInfo(current=").append(this.current).append(", range=").append(this.range).append(", steps=").append(this.steps).append(')').toString();
    }
}
