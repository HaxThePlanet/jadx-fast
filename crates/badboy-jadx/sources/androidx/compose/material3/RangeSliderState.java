package androidx.compose.material3;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0014\n\u0002\u0008\u001a\u0008\u0007\u0018\u00002\u00020\u0001BE\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0003\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\u000cJ\u001d\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020+2\u0006\u0010g\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0008hJ \u0010i\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u0010j\u001a\u00020\u0003H\u0002J*\u0010k\u001a\u00020>2\u0006\u00109\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u0010g\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\u0008l\u0010mJ\r\u0010n\u001a\u00020\tH\u0000¢\u0006\u0002\u0008oR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R+\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u000f\"\u0004\u0008\u0015\u0010\u0011R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0018\u0010\u000f\"\u0004\u0008\u0019\u0010\u0011R+\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001d\u0010\u0017\u001a\u0004\u0008\u001b\u0010\u000f\"\u0004\u0008\u001c\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u000fR\u0014\u0010 \u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\u000fR\u0014\u0010\"\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$R+\u0010%\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008(\u0010\u0017\u001a\u0004\u0008&\u0010\u000f\"\u0004\u0008'\u0010\u0011R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-R+\u0010.\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020+8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u00083\u00104\u001a\u0004\u0008/\u00100\"\u0004\u00081\u00102R+\u00105\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u00088\u0010\u0017\u001a\u0004\u00086\u0010\u000f\"\u0004\u00087\u0010\u0011R+\u00109\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008<\u0010\u0017\u001a\u0004\u0008:\u0010\u000f\"\u0004\u0008;\u0010\u0011R(\u0010=\u001a\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\t\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u0010-\"\u0004\u0008@\u0010AR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008B\u0010C\"\u0004\u0008D\u0010ER+\u0010F\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008I\u0010\u0017\u001a\u0004\u0008G\u0010\u000f\"\u0004\u0008H\u0010\u0011R+\u0010J\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008M\u0010\u0017\u001a\u0004\u0008K\u0010\u000f\"\u0004\u0008L\u0010\u0011R\u0014\u0010N\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008O\u0010$R+\u0010P\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008S\u0010\u0017\u001a\u0004\u0008Q\u0010\u000f\"\u0004\u0008R\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010$R\u0014\u0010U\u001a\u00020VX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010XR+\u0010Y\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008]\u0010^\u001a\u0004\u0008Z\u0010$\"\u0004\u0008[\u0010\\R+\u0010_\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008b\u0010\u0017\u001a\u0004\u0008`\u0010\u000f\"\u0004\u0008a\u0010\u0011R\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008c\u0010d\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006p", d2 = {"Landroidx/compose/material3/RangeSliderState;", "", "activeRangeStart", "", "activeRangeEnd", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;)V", "newVal", "getActiveRangeEnd", "()F", "setActiveRangeEnd", "(F)V", "<set-?>", "activeRangeEndState", "getActiveRangeEndState", "setActiveRangeEndState", "activeRangeEndState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getActiveRangeStart", "setActiveRangeStart", "activeRangeStartState", "getActiveRangeStartState", "setActiveRangeStartState", "activeRangeStartState$delegate", "coercedActiveRangeEndAsFraction", "getCoercedActiveRangeEndAsFraction$material3_release", "coercedActiveRangeStartAsFraction", "getCoercedActiveRangeStartAsFraction$material3_release", "endSteps", "getEndSteps$material3_release", "()I", "endThumbWidth", "getEndThumbWidth$material3_release", "setEndThumbWidth$material3_release", "endThumbWidth$delegate", "gestureEndAction", "Lkotlin/Function1;", "", "getGestureEndAction$material3_release", "()Lkotlin/jvm/functions/Function1;", "isRtl", "isRtl$material3_release", "()Z", "setRtl$material3_release", "(Z)V", "isRtl$delegate", "Landroidx/compose/runtime/MutableState;", "maxPx", "getMaxPx", "setMaxPx", "maxPx$delegate", "minPx", "getMinPx", "setMinPx", "minPx$delegate", "onValueChange", "Landroidx/compose/material3/SliderRange;", "getOnValueChange$material3_release", "setOnValueChange$material3_release", "(Lkotlin/jvm/functions/Function1;)V", "getOnValueChangeFinished", "()Lkotlin/jvm/functions/Function0;", "setOnValueChangeFinished", "(Lkotlin/jvm/functions/Function0;)V", "rawOffsetEnd", "getRawOffsetEnd$material3_release", "setRawOffsetEnd$material3_release", "rawOffsetEnd$delegate", "rawOffsetStart", "getRawOffsetStart$material3_release", "setRawOffsetStart$material3_release", "rawOffsetStart$delegate", "startSteps", "getStartSteps$material3_release", "startThumbWidth", "getStartThumbWidth$material3_release", "setStartThumbWidth$material3_release", "startThumbWidth$delegate", "getSteps", "tickFractions", "", "getTickFractions$material3_release", "()[F", "totalWidth", "getTotalWidth$material3_release", "setTotalWidth$material3_release", "(I)V", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "trackHeight", "getTrackHeight$material3_release", "setTrackHeight$material3_release", "trackHeight$delegate", "getValueRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "onDrag", "isStart", "offset", "onDrag$material3_release", "scaleToOffset", "userValue", "scaleToUserValue", "scaleToUserValue-owVgs5E", "(FFJ)J", "updateMinMaxPx", "updateMinMaxPx$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RangeSliderState {

    public static final int $stable = 8;
    private final MutableFloatState activeRangeEndState$delegate;
    private final MutableFloatState activeRangeStartState$delegate;
    private final MutableFloatState endThumbWidth$delegate;
    private final Function1<Boolean, Unit> gestureEndAction;
    private final MutableState isRtl$delegate;
    private final MutableFloatState maxPx$delegate;
    private final MutableFloatState minPx$delegate;
    private Function1<? super androidx.compose.material3.SliderRange, Unit> onValueChange;
    private Function0<Unit> onValueChangeFinished;
    private final MutableFloatState rawOffsetEnd$delegate;
    private final MutableFloatState rawOffsetStart$delegate;
    private final MutableFloatState startThumbWidth$delegate;
    private final int steps;
    private final float[] tickFractions;
    private final MutableIntState totalWidth$delegate;
    private final MutableFloatState trackHeight$delegate;
    private final ClosedFloatingPointRange<Float> valueRange;
    static {
        final int i = 8;
    }

    public RangeSliderState() {
        super(0, 0, 0, 0, 0, 31, 0);
    }

    public RangeSliderState(float activeRangeStart, float activeRangeEnd, int steps, Function0<Unit> onValueChangeFinished, ClosedFloatingPointRange<Float> valueRange) {
        super();
        this.steps = steps;
        this.onValueChangeFinished = onValueChangeFinished;
        this.valueRange = valueRange;
        this.activeRangeStartState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(activeRangeStart);
        this.activeRangeEndState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(activeRangeEnd);
        this.tickFractions = SliderKt.access$stepsToTickFractions(this.steps);
        int i = 0;
        this.trackHeight$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        this.startThumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        this.endThumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        int i2 = 0;
        this.totalWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(i2);
        this.rawOffsetStart$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        this.rawOffsetEnd$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        int i3 = 0;
        this.isRtl$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i2), i3, 2, i3);
        RangeSliderState.gestureEndAction.1 anon = new RangeSliderState.gestureEndAction.1(this);
        this.gestureEndAction = (Function1)anon;
        this.maxPx$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        this.minPx$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
    }

    public RangeSliderState(float f, float f2, int i3, Function0 function04, ClosedFloatingPointRange closedFloatingPointRange5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        ClosedFloatingPointRange obj7;
        ClosedFloatingPointRange obj8;
        final int i = 0;
        obj3 = i6 & 1 != 0 ? i : obj3;
        final int i2 = 1065353216;
        obj4 = i6 & 2 != 0 ? i2 : obj4;
        obj5 = i6 & 4 != 0 ? 0 : obj5;
        obj6 = i6 & 8 != 0 ? 0 : obj6;
        if (i6 &= 16 != 0) {
            obj8 = obj7;
        } else {
            obj8 = closedFloatingPointRange5;
        }
        super(obj3, obj4, obj5, obj6, obj8);
    }

    private final float getActiveRangeEndState() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.activeRangeEndState$delegate.getFloatValue();
    }

    private final float getActiveRangeStartState() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.activeRangeStartState$delegate.getFloatValue();
    }

    private final float getMaxPx() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.maxPx$delegate.getFloatValue();
    }

    private final float getMinPx() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.minPx$delegate.getFloatValue();
    }

    private final float scaleToOffset(float minPx, float maxPx, float userValue) {
        return SliderKt.access$scale((Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    private final long scaleToUserValue-owVgs5E(float minPx, float maxPx, long offset) {
        return SliderKt.access$scale-ziovWd0(minPx, maxPx, offset, obj4, (Number)this.valueRange.getStart().floatValue());
    }

    private final void setActiveRangeEndState(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.activeRangeEndState$delegate.setFloatValue(<set-?>);
    }

    private final void setActiveRangeStartState(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.activeRangeStartState$delegate.setFloatValue(<set-?>);
    }

    private final void setMaxPx(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.maxPx$delegate.setFloatValue(<set-?>);
    }

    private final void setMinPx(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.minPx$delegate.setFloatValue(<set-?>);
    }

    public final float getActiveRangeEnd() {
        return getActiveRangeEndState();
    }

    public final float getActiveRangeStart() {
        return getActiveRangeStartState();
    }

    public final float getCoercedActiveRangeEndAsFraction$material3_release() {
        return SliderKt.access$calcFraction((Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue(), getActiveRangeEnd());
    }

    public final float getCoercedActiveRangeStartAsFraction$material3_release() {
        return SliderKt.access$calcFraction((Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue(), getActiveRangeStart());
    }

    public final int getEndSteps$material3_release() {
        i3 -= coercedActiveRangeStartAsFraction$material3_release;
        return (int)f2;
    }

    public final float getEndThumbWidth$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.endThumbWidth$delegate.getFloatValue();
    }

    public final Function1<Boolean, Unit> getGestureEndAction$material3_release() {
        return this.gestureEndAction;
    }

    public final Function1<androidx.compose.material3.SliderRange, Unit> getOnValueChange$material3_release() {
        return this.onValueChange;
    }

    public final Function0<Unit> getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    public final float getRawOffsetEnd$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.rawOffsetEnd$delegate.getFloatValue();
    }

    public final float getRawOffsetStart$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.rawOffsetStart$delegate.getFloatValue();
    }

    public final int getStartSteps$material3_release() {
        final float coercedActiveRangeEndAsFraction$material3_release = getCoercedActiveRangeEndAsFraction$material3_release();
        return (int)f2;
    }

    public final float getStartThumbWidth$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.startThumbWidth$delegate.getFloatValue();
    }

    public final int getSteps() {
        return this.steps;
    }

    public final float[] getTickFractions$material3_release() {
        return this.tickFractions;
    }

    public final int getTotalWidth$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.totalWidth$delegate.getIntValue();
    }

    public final float getTrackHeight$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.trackHeight$delegate.getFloatValue();
    }

    public final ClosedFloatingPointRange<Float> getValueRange() {
        return this.valueRange;
    }

    public final boolean isRtl$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isRtl$delegate.getValue().booleanValue();
    }

    public final void onDrag$material3_release(boolean isStart, float offset) {
        long offsetStart;
        float offsetEnd;
        long tickFractions;
        float minPx;
        float maxPx;
        boolean endInclusive-impl;
        float activeRangeEnd;
        androidx.compose.material3.SliderRange box-impl;
        if (isStart) {
            setRawOffsetStart$material3_release(rawOffsetStart$material3_release2 += offset);
            setRawOffsetEnd$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeEnd()));
            float rawOffsetEnd$material3_release2 = getRawOffsetEnd$material3_release();
            offsetStart = SliderKt.SliderRange(SliderKt.access$snapValueToTick(RangesKt.coerceIn(getRawOffsetStart$material3_release(), getMinPx(), rawOffsetEnd$material3_release2), this.tickFractions, getMinPx(), getMaxPx()), rawOffsetEnd$material3_release2);
        } else {
            setRawOffsetEnd$material3_release(rawOffsetEnd$material3_release += offset);
            setRawOffsetStart$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeStart()));
            float rawOffsetStart$material3_release = getRawOffsetStart$material3_release();
            offsetStart = tickFractions;
        }
        float maxPx5 = getMaxPx();
        long scaleToUserValue-owVgs5E = scaleToUserValue-owVgs5E(getMinPx(), maxPx5, offsetStart);
        activeRangeEnd = getActiveRangeEnd();
        if (!SliderRange.equals-impl0(scaleToUserValue-owVgs5E, maxPx5)) {
            if (this.onValueChange != null) {
                endInclusive-impl = this.onValueChange;
                if (endInclusive-impl != null) {
                    activeRangeEnd = 0;
                    endInclusive-impl.invoke(SliderRange.box-impl(scaleToUserValue-owVgs5E));
                }
            } else {
                setActiveRangeStart(SliderRange.getStart-impl(scaleToUserValue-owVgs5E));
                setActiveRangeEnd(SliderRange.getEndInclusive-impl(scaleToUserValue-owVgs5E));
            }
        }
    }

    public final void setActiveRangeEnd(float newVal) {
        setActiveRangeEndState(SliderKt.access$snapValueToTick(RangesKt.coerceIn(newVal, getActiveRangeStart(), (Number)this.valueRange.getEndInclusive().floatValue()), this.tickFractions, (Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue()));
    }

    public final void setActiveRangeStart(float newVal) {
        setActiveRangeStartState(SliderKt.access$snapValueToTick(RangesKt.coerceIn(newVal, (Number)this.valueRange.getStart().floatValue(), getActiveRangeEnd()), this.tickFractions, (Number)this.valueRange.getStart().floatValue(), (Number)this.valueRange.getEndInclusive().floatValue()));
    }

    public final void setEndThumbWidth$material3_release(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.endThumbWidth$delegate.setFloatValue(<set-?>);
    }

    public final void setOnValueChange$material3_release(Function1<? super androidx.compose.material3.SliderRange, Unit> <set-?>) {
        this.onValueChange = <set-?>;
    }

    public final void setOnValueChangeFinished(Function0<Unit> <set-?>) {
        this.onValueChangeFinished = <set-?>;
    }

    public final void setRawOffsetEnd$material3_release(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.rawOffsetEnd$delegate.setFloatValue(<set-?>);
    }

    public final void setRawOffsetStart$material3_release(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.rawOffsetStart$delegate.setFloatValue(<set-?>);
    }

    public final void setRtl$material3_release(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isRtl$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setStartThumbWidth$material3_release(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.startThumbWidth$delegate.setFloatValue(<set-?>);
    }

    public final void setTotalWidth$material3_release(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.totalWidth$delegate.setIntValue(<set-?>);
    }

    public final void setTrackHeight$material3_release(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.trackHeight$delegate.setFloatValue(<set-?>);
    }

    public final void updateMinMaxPx$material3_release() {
        int scaleToOffset;
        float maxPx;
        float activeRangeEnd;
        float f4 = (float)i5;
        float f2 = Math.max(f -= i2, 0);
        float f3 = Math.min(startThumbWidth$material3_release /= f4, f2);
        activeRangeEnd = 0;
        scaleToOffset = Float.compare(minPx, f3) == 0 ? maxPx : activeRangeEnd;
        if (scaleToOffset != null) {
            if (Float.compare(maxPx2, f2) == 0) {
            } else {
                maxPx = activeRangeEnd;
            }
            if (maxPx == 0) {
                setMinPx(f3);
                setMaxPx(f2);
                setRawOffsetStart$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeStart()));
                setRawOffsetEnd$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeEnd()));
            }
        } else {
        }
    }
}
