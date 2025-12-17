package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0014\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0007\u0018\u00002\u00020\u0001B;\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0003\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007\u0012\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010R\u001a\u00020\u00082\u0006\u0010S\u001a\u00020\u0003H\u0016J?\u0010T\u001a\u00020\u00082\u0006\u0010U\u001a\u00020V2'\u0010W\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080Y\u0012\u0006\u0012\u0004\u0018\u00010Z0X¢\u0006\u0002\u0008[H\u0096@¢\u0006\u0002\u0010\\J\u001a\u0010]\u001a\u00020\u00082\u0006\u0010^\u001a\u00020_H\u0000ø\u0001\u0000¢\u0006\u0004\u0008`\u0010aJ \u0010b\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u0003H\u0002J \u0010f\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u0003H\u0002J\u001d\u0010h\u001a\u00020\u00082\u0006\u0010i\u001a\u00020\u00032\u0006\u0010j\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008kR\u0014\u0010\u000c\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0018\"\u0004\u0008\u001f\u0010\u001aR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0008\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010\u0013\"\u0004\u0008'\u0010(R+\u0010)\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008-\u0010.\u001a\u0004\u0008*\u0010\u000e\"\u0004\u0008+\u0010,R+\u0010/\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u00082\u0010.\u001a\u0004\u00080\u0010\u000e\"\u0004\u00081\u0010,R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R+\u00107\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008:\u0010.\u001a\u0004\u00088\u0010\u000e\"\u0004\u00089\u0010,R\u0014\u0010;\u001a\u00020<X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010>R+\u0010?\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008C\u0010D\u001a\u0004\u0008@\u00106\"\u0004\u0008A\u0010BR+\u0010E\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008H\u0010.\u001a\u0004\u0008F\u0010\u000e\"\u0004\u0008G\u0010,R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008J\u0010\u000e\"\u0004\u0008K\u0010,R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010MR+\u0010N\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008Q\u0010.\u001a\u0004\u0008O\u0010\u000e\"\u0004\u0008P\u0010,\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006l", d2 = {"Landroidx/compose/material3/SliderState;", "Landroidx/compose/foundation/gestures/DraggableState;", "value", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;)V", "coercedValueAsFraction", "getCoercedValueAsFraction$material3_release", "()F", "dragScope", "Landroidx/compose/foundation/gestures/DragScope;", "gestureEndAction", "getGestureEndAction$material3_release", "()Lkotlin/jvm/functions/Function0;", "<set-?>", "", "isDragging", "isDragging$material3_release", "()Z", "setDragging", "(Z)V", "isDragging$delegate", "Landroidx/compose/runtime/MutableState;", "isRtl", "isRtl$material3_release", "setRtl$material3_release", "onValueChange", "Lkotlin/Function1;", "getOnValueChange$material3_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$material3_release", "(Lkotlin/jvm/functions/Function1;)V", "getOnValueChangeFinished", "setOnValueChangeFinished", "(Lkotlin/jvm/functions/Function0;)V", "pressOffset", "getPressOffset", "setPressOffset", "(F)V", "pressOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "rawOffset", "getRawOffset", "setRawOffset", "rawOffset$delegate", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "getSteps", "()I", "thumbWidth", "getThumbWidth$material3_release", "setThumbWidth$material3_release", "thumbWidth$delegate", "tickFractions", "", "getTickFractions$material3_release", "()[F", "totalWidth", "getTotalWidth", "setTotalWidth", "(I)V", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "trackHeight", "getTrackHeight$material3_release", "setTrackHeight$material3_release", "trackHeight$delegate", "newVal", "getValue", "setValue", "getValueRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "valueState", "getValueState", "setValueState", "valueState$delegate", "dispatchRawDelta", "delta", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPress", "pos", "Landroidx/compose/ui/geometry/Offset;", "onPress-k-4lQ0M$material3_release", "(J)V", "scaleToOffset", "minPx", "maxPx", "userValue", "scaleToUserValue", "offset", "updateDimensions", "newTrackHeight", "newTotalWidth", "updateDimensions$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SliderState implements DraggableState {

    public static final int $stable = 8;
    private final DragScope dragScope;
    private final Function0<Unit> gestureEndAction;
    private final MutableState isDragging$delegate;
    private boolean isRtl;
    private Function1<? super Float, Unit> onValueChange;
    private Function0<Unit> onValueChangeFinished;
    private final MutableFloatState pressOffset$delegate;
    private final MutableFloatState rawOffset$delegate;
    private final MutatorMutex scrollMutex;
    private final int steps;
    private final MutableFloatState thumbWidth$delegate;
    private final float[] tickFractions;
    private final MutableIntState totalWidth$delegate;
    private final MutableFloatState trackHeight$delegate;
    private final ClosedFloatingPointRange<Float> valueRange;
    private final MutableFloatState valueState$delegate;
    static {
        final int i = 8;
    }

    public SliderState() {
        super(0, 0, 0, 0, 15, 0);
    }

    public SliderState(float value, int steps, Function0<Unit> onValueChangeFinished, ClosedFloatingPointRange<Float> valueRange) {
        super();
        this.steps = steps;
        this.onValueChangeFinished = onValueChangeFinished;
        this.valueRange = valueRange;
        this.valueState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(value);
        this.tickFractions = SliderKt.access$stepsToTickFractions(this.steps);
        int i = 0;
        this.totalWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        int i2 = 0;
        this.trackHeight$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i2);
        this.thumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i2);
        int i3 = 0;
        this.isDragging$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i), i3, 2, i3);
        SliderState.gestureEndAction.1 anon = new SliderState.gestureEndAction.1(this);
        this.gestureEndAction = (Function0)anon;
        this.rawOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(scaleToOffset(i2, i2, value));
        this.pressOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i2);
        SliderState.dragScope.1 anon2 = new SliderState.dragScope.1(this);
        this.dragScope = (DragScope)anon2;
        MutatorMutex mutatorMutex = new MutatorMutex();
        this.scrollMutex = mutatorMutex;
    }

    public SliderState(float f, int i2, Function0 function03, ClosedFloatingPointRange closedFloatingPointRange4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj2;
        int obj3;
        int obj4;
        ClosedFloatingPointRange obj5;
        final int i = 0;
        obj2 = i5 & 1 != 0 ? i : obj2;
        obj3 = i5 & 2 != 0 ? 0 : obj3;
        obj4 = i5 & 4 != 0 ? 0 : obj4;
        if (i5 &= 8 != 0) {
            obj5 = RangesKt.rangeTo(i, 1065353216);
        }
        super(obj2, obj3, obj4, obj5);
    }

    public static final DragScope access$getDragScope$p(androidx.compose.material3.SliderState $this) {
        return $this.dragScope;
    }

    public static final MutatorMutex access$getScrollMutex$p(androidx.compose.material3.SliderState $this) {
        return $this.scrollMutex;
    }

    public static final void access$setDragging(androidx.compose.material3.SliderState $this, boolean <set-?>) {
        $this.setDragging(<set-?>);
    }

    private final float getPressOffset() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.pressOffset$delegate.getFloatValue();
    }

    private final float getRawOffset() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.rawOffset$delegate.getFloatValue();
    }

    private final int getTotalWidth() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.totalWidth$delegate.getIntValue();
    }

    private final float getValueState() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.valueState$delegate.getFloatValue();
    }

    private final float scaleToOffset(float minPx, float maxPx, float userValue) {
        return SliderKt.access$scale((Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    private final float scaleToUserValue(float minPx, float maxPx, float offset) {
        return SliderKt.access$scale(minPx, maxPx, offset, (Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue());
    }

    private final void setDragging(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isDragging$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setPressOffset(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.pressOffset$delegate.setFloatValue(<set-?>);
    }

    private final void setRawOffset(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.rawOffset$delegate.setFloatValue(<set-?>);
    }

    private final void setTotalWidth(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.totalWidth$delegate.setIntValue(<set-?>);
    }

    private final void setValueState(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.valueState$delegate.setFloatValue(<set-?>);
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public void dispatchRawDelta(float delta) {
        int onValueChange;
        int i;
        Float valueOf;
        float f4 = (float)i5;
        int i4 = 0;
        float f2 = Math.max(f -= i3, i4);
        float f5 = Math.min(thumbWidth$material3_release2 /= f4, f2);
        setRawOffset(i7 += pressOffset);
        setPressOffset(i4);
        float scaleToUserValue = scaleToUserValue(f5, f2, SliderKt.access$snapValueToTick(getRawOffset(), this.tickFractions, f5, f2));
        onValueChange = Float.compare(scaleToUserValue, value) == 0 ? 1 : 0;
        if (onValueChange == 0) {
            if (this.onValueChange != null) {
                onValueChange = this.onValueChange;
                if (onValueChange != null) {
                    i = 0;
                    onValueChange.invoke(Float.valueOf(scaleToUserValue));
                }
            } else {
                setValue(scaleToUserValue);
            }
        }
    }

    public Object drag(MutatePriority dragPriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        SliderState.drag.2 anon = new SliderState.drag.2(this, dragPriority, block, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final float getCoercedValueAsFraction$material3_release() {
        return SliderKt.access$calcFraction((Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue(), RangesKt.coerceIn(getValue(), (Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue()));
    }

    public final Function0<Unit> getGestureEndAction$material3_release() {
        return this.gestureEndAction;
    }

    public final Function1<Float, Unit> getOnValueChange$material3_release() {
        return this.onValueChange;
    }

    public final Function0<Unit> getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final int getSteps() {
        return this.steps;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final float getThumbWidth$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.thumbWidth$delegate.getFloatValue();
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final float[] getTickFractions$material3_release() {
        return this.tickFractions;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final float getTrackHeight$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.trackHeight$delegate.getFloatValue();
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final float getValue() {
        return getValueState();
    }

    public final ClosedFloatingPointRange<Float> getValueRange() {
        return this.valueRange;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final boolean isDragging$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isDragging$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final boolean isRtl$material3_release() {
        return this.isRtl;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final void onPress-k-4lQ0M$material3_release(long pos) {
        int x-impl;
        float x-impl2;
        if (this.isRtl) {
            f -= x-impl2;
        } else {
            x-impl = Offset.getX-impl(pos);
        }
        setPressOffset(x-impl - rawOffset);
    }

    public final void setOnValueChange$material3_release(Function1<? super Float, Unit> <set-?>) {
        this.onValueChange = <set-?>;
    }

    public final void setOnValueChangeFinished(Function0<Unit> <set-?>) {
        this.onValueChangeFinished = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final void setRtl$material3_release(boolean <set-?>) {
        this.isRtl = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final void setThumbWidth$material3_release(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.thumbWidth$delegate.setFloatValue(<set-?>);
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final void setTrackHeight$material3_release(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.trackHeight$delegate.setFloatValue(<set-?>);
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final void setValue(float newVal) {
        setValueState(SliderKt.access$snapValueToTick(RangesKt.coerceIn(newVal, (Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue()), this.tickFractions, (Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue()));
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final void updateDimensions$material3_release(float newTrackHeight, int newTotalWidth) {
        setTrackHeight$material3_release(newTrackHeight);
        setTotalWidth(newTotalWidth);
    }
}
