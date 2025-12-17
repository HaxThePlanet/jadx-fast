package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Deprecated(message = "Not necessary with the introduction of Slider state")
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016R7\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR+\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00068F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0015\u0010\u000f\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006\u001b", d2 = {"Landroidx/compose/material3/SliderPositions;", "", "initialActiveRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "initialTickFractions", "", "(Lkotlin/ranges/ClosedFloatingPointRange;[F)V", "<set-?>", "activeRange", "getActiveRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "setActiveRange$material3_release", "(Lkotlin/ranges/ClosedFloatingPointRange;)V", "activeRange$delegate", "Landroidx/compose/runtime/MutableState;", "tickFractions", "getTickFractions", "()[F", "setTickFractions$material3_release", "([F)V", "tickFractions$delegate", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SliderPositions {

    public static final int $stable;
    private final MutableState activeRange$delegate;
    private final MutableState tickFractions$delegate;
    static {
    }

    public SliderPositions() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public SliderPositions(ClosedFloatingPointRange<Float> initialActiveRange, float[] initialTickFractions) {
        super();
        int i = 0;
        final int i2 = 2;
        this.activeRange$delegate = SnapshotStateKt.mutableStateOf$default(initialActiveRange, i, i2, i);
        this.tickFractions$delegate = SnapshotStateKt.mutableStateOf$default(initialTickFractions, i, i2, i);
    }

    public SliderPositions(ClosedFloatingPointRange closedFloatingPointRange, float[] f2Arr2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        ClosedFloatingPointRange obj1;
        float[] obj2;
        int obj4;
        if (i3 & 1 != 0) {
            obj1 = RangesKt.rangeTo(0, 1065353216);
        }
        if (i3 &= 2 != 0) {
            obj2 = new float[0];
        }
        super(obj1, obj2);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SliderPositions) {
            return i2;
        }
        if (!Intrinsics.areEqual(getActiveRange(), (SliderPositions)other.getActiveRange())) {
            return i2;
        }
        if (!Arrays.equals(getTickFractions(), (SliderPositions)other.getTickFractions())) {
            return i2;
        }
        return i;
    }

    public final ClosedFloatingPointRange<Float> getActiveRange() {
        final int i = 0;
        final int i2 = 0;
        return (ClosedFloatingPointRange)(State)this.activeRange$delegate.getValue();
    }

    public final float[] getTickFractions() {
        final int i = 0;
        final int i2 = 0;
        return (float[])(State)this.tickFractions$delegate.getValue();
    }

    public int hashCode() {
        return i2 += i4;
    }

    public final void setActiveRange$material3_release(ClosedFloatingPointRange<Float> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.activeRange$delegate.setValue(<set-?>);
    }

    public final void setTickFractions$material3_release(float[] <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.tickFractions$delegate.setValue(<set-?>);
    }
}
