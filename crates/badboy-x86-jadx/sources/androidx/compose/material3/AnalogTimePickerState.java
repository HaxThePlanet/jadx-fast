package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u000f\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010*\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0008\u0010/\u001a\u00020\u0018H\u0002J\u0010\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0002J\u000e\u00102\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,J \u00103\u001a\u00020+2\u0006\u00101\u001a\u00020\u00062\u0008\u0008\u0002\u00104\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u00105J\u0008\u00106\u001a\u00020+H\u0002J\u000c\u00107\u001a\u00020\u0006*\u00020\u0006H\u0002J\u000c\u00108\u001a\u00020\u0010*\u00020\u0006H\u0002J\u000c\u00109\u001a\u00020\u0010*\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\u00020\u0018X\u0096\u000f¢\u0006\u000c\u001a\u0004\u0008\u0017\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u0018X\u0096\u000f¢\u0006\u000c\u001a\u0004\u0008\u001c\u0010\u0019\"\u0004\u0008\u001d\u0010\u001bR$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u001f\u0010\u0013\"\u0004\u0008 \u0010\u0015R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%X\u0096\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008&\u0010\u0013\"\u0004\u0008'\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006:", d2 = {"Landroidx/compose/material3/AnalogTimePickerState;", "Landroidx/compose/material3/TimePickerState;", "state", "(Landroidx/compose/material3/TimePickerState;)V", "anim", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "clockFaceValues", "Landroidx/collection/IntList;", "getClockFaceValues", "()Landroidx/collection/IntList;", "currentAngle", "getCurrentAngle", "()F", "value", "", "hour", "getHour", "()I", "setHour", "(I)V", "hourAngle", "is24hour", "", "()Z", "set24hour", "(Z)V", "isAfternoon", "setAfternoon", "minute", "getMinute", "setMinute", "minuteAngle", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "getState", "()Landroidx/compose/material3/TimePickerState;", "animateToCurrent", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endValueForAnimation", "new", "isUpdated", "offsetAngle", "angle", "onGestureEnd", "rotateTo", "animate", "(FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBaseStateMinute", "normalize", "toHour", "toMinute", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnalogTimePickerState implements androidx.compose.material3.TimePickerState {

    public static final int $stable = 8;
    private Animatable<Float, AnimationVector1D> anim;
    private float hourAngle;
    private float minuteAngle;
    private final MutatorMutex mutex;
    private final androidx.compose.material3.TimePickerState state;
    static {
        final int i = 8;
    }

    public AnalogTimePickerState(androidx.compose.material3.TimePickerState state) {
        super();
        this.state = state;
        int i7 = 1070141403;
        this.hourAngle = i2 -= i7;
        this.minuteAngle = i4 -= i7;
        this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0, 2, 0);
        MutatorMutex mutatorMutex = new MutatorMutex();
        this.mutex = mutatorMutex;
    }

    public static final float access$endValueForAnimation(androidx.compose.material3.AnalogTimePickerState $this, float new) {
        return $this.endValueForAnimation(new);
    }

    public static final Animatable access$getAnim$p(androidx.compose.material3.AnalogTimePickerState $this) {
        return $this.anim;
    }

    public static final float access$getHourAngle$p(androidx.compose.material3.AnalogTimePickerState $this) {
        return $this.hourAngle;
    }

    public static final float access$getMinuteAngle$p(androidx.compose.material3.AnalogTimePickerState $this) {
        return $this.minuteAngle;
    }

    public static final float access$offsetAngle(androidx.compose.material3.AnalogTimePickerState $this, float angle) {
        return $this.offsetAngle(angle);
    }

    public static final void access$setHourAngle$p(androidx.compose.material3.AnalogTimePickerState $this, float <set-?>) {
        $this.hourAngle = <set-?>;
    }

    public static final void access$setMinuteAngle$p(androidx.compose.material3.AnalogTimePickerState $this, float <set-?>) {
        $this.minuteAngle = <set-?>;
    }

    public static final int access$toHour(androidx.compose.material3.AnalogTimePickerState $this, float $receiver) {
        return $this.toHour($receiver);
    }

    public static final int access$toMinute(androidx.compose.material3.AnalogTimePickerState $this, float $receiver) {
        return $this.toMinute($receiver);
    }

    private final float endValueForAnimation(float new) {
        int diff;
        int cmp;
        int i;
        floatValue -= new;
        i = 1086918619;
        while (Float.compare(diff, i2) > 0) {
            diff -= i;
            i = 1086918619;
        }
        while (Float.compare(diff, i3) <= 0) {
            diff += i;
        }
        return floatValue2 -= diff;
    }

    private final boolean isUpdated() {
        boolean equals-impl02;
        int equals-impl0;
        float normalize;
        int minute-yecRtBI;
        int i = 1;
        final int i2 = 0;
        if (TimePickerSelectionMode.equals-impl0(getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
            equals-impl02 = Float.compare(normalize3, normalize) == 0 ? i : i2;
            if (equals-impl02 != 0) {
                return i2;
            }
        }
        if (TimePickerSelectionMode.equals-impl0(getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
            equals-impl0 = Float.compare(normalize2, minute-yecRtBI) == 0 ? i : i2;
            if (equals-impl0 != 0) {
                return i2;
            }
        }
        return i;
    }

    private final float normalize(float $this$normalize) {
        int normalizedAngle;
        long l = 4618760256179416344L;
        d %= l;
        if (Double.compare(normalizedAngle, i) < 0) {
            normalizedAngle += l;
        }
        return (float)normalizedAngle;
    }

    private final float offsetAngle(float angle) {
        int i;
        i2 += angle;
        i = Float.compare(i3, i4) < 0 ? i5 + i3 : i3;
        return i;
    }

    public static Object rotateTo$default(androidx.compose.material3.AnalogTimePickerState analogTimePickerState, float f2, boolean z3, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return analogTimePickerState.rotateTo(f2, obj2, continuation4);
    }

    private final int toHour(float $this$toHour) {
        return i5 %= 12;
    }

    private final int toMinute(float $this$toMinute) {
        return i5 %= 60;
    }

    private final void updateBaseStateMinute() {
        kotlin.jvm.functions.Function1 readObserver;
        final Snapshot.Companion companion = Snapshot.Companion;
        final int i = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        int i2 = 0;
        this.state.setMinute(getMinute());
        Unit $i$a$WithoutReadObservationAnalogTimePickerState$updateBaseStateMinute$1 = Unit.INSTANCE;
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
    }

    public final Object animateToCurrent(Continuation<? super Unit> $completion) {
        float endValueForAnimation;
        if (!isUpdated()) {
            return Unit.INSTANCE;
        }
        if (TimePickerSelectionMode.equals-impl0(getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
            endValueForAnimation = endValueForAnimation(this.hourAngle);
        } else {
            endValueForAnimation = endValueForAnimation(this.minuteAngle);
        }
        AnalogTimePickerState.animateToCurrent.2 anon = new AnalogTimePickerState.animateToCurrent.2(this, endValueForAnimation, 0);
        Object mutate = this.mutex.mutate(MutatePriority.PreventUserInput, (Function1)anon, $completion);
        if (mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return mutate;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.TimePickerState
    public final IntList getClockFaceValues() {
        IntList list;
        if (TimePickerSelectionMode.equals-impl0(getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
            list = TimePickerKt.access$getMinutes$p();
        } else {
            list = TimePickerKt.access$getHours$p();
        }
        return list;
    }

    @Override // androidx.compose.material3.TimePickerState
    public final float getCurrentAngle() {
        return (Number)this.anim.getValue().floatValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHour() {
        return this.state.getHour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinute() {
        return this.state.getMinute();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getSelection-yecRtBI() {
        return this.state.getSelection-yecRtBI();
    }

    @Override // androidx.compose.material3.TimePickerState
    public final androidx.compose.material3.TimePickerState getState() {
        return this.state;
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean is24hour() {
        return this.state.is24hour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean isAfternoon() {
        return this.state.isAfternoon();
    }

    public final Object onGestureEnd(Continuation<? super Unit> $completion) {
        float minuteAngle;
        minuteAngle = TimePickerSelectionMode.equals-impl0(getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI()) ? this.hourAngle : this.minuteAngle;
        AnalogTimePickerState.onGestureEnd.2 anon = new AnalogTimePickerState.onGestureEnd.2(this, endValueForAnimation(minuteAngle), 0);
        Object mutate = this.mutex.mutate(MutatePriority.PreventUserInput, (Function1)anon, $completion);
        if (mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return mutate;
        }
        return Unit.INSTANCE;
    }

    public final Object rotateTo(float angle, boolean animate, Continuation<? super Unit> $completion) {
        AnalogTimePickerState.rotateTo.2 anon = new AnalogTimePickerState.rotateTo.2(this, angle, animate, 0);
        Object mutate = this.mutex.mutate(MutatePriority.UserInput, (Function1)anon, $completion);
        if (mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return mutate;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void set24hour(boolean z) {
        this.state.set24hour(z);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setAfternoon(boolean z) {
        this.state.setAfternoon(z);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHour(int value) {
        boolean equals-impl0;
        int hour-yecRtBI;
        int i;
        int i2;
        this.hourAngle = i4 -= i7;
        this.state.setHour(value);
        if (TimePickerSelectionMode.equals-impl0(getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
            this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0, 2, 0);
        }
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinute(int value) {
        boolean equals-impl0;
        int minute-yecRtBI;
        int i2;
        int i;
        this.minuteAngle = i5 -= i4;
        this.state.setMinute(value);
        if (TimePickerSelectionMode.equals-impl0(getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
            this.anim = AnimatableKt.Animatable$default(this.minuteAngle, 0, 2, 0);
        }
        updateBaseStateMinute();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setSelection-6_8s6DQ(int i) {
        this.state.setSelection-6_8s6DQ(i);
    }
}
