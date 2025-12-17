package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R+\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00068V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u0017\u0010\u0013\"\u0004\u0008\u0018\u0010\u0015R$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u001c\u0010\u000b\"\u0004\u0008\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0011R1\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020 8V@VX\u0096\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008$\u0010\u001a\u001a\u0004\u0008\"\u0010\u000b\"\u0004\u0008#\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/material3/TimePickerStateImpl;", "Landroidx/compose/material3/TimePickerState;", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "value", "hour", "getHour", "()I", "setHour", "(I)V", "hourState", "Landroidx/compose/runtime/MutableIntState;", "getHourState", "()Landroidx/compose/runtime/MutableIntState;", "is24hour", "()Z", "set24hour", "(Z)V", "<set-?>", "isAfternoon", "setAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/MutableState;", "minute", "getMinute", "setMinute", "minuteState", "getMinuteState", "Landroidx/compose/material3/TimePickerSelectionMode;", "selection", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "selection$delegate", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TimePickerStateImpl implements androidx.compose.material3.TimePickerState {

    public static final androidx.compose.material3.TimePickerStateImpl.Companion Companion;
    private final MutableIntState hourState;
    private boolean is24hour;
    private final MutableState isAfternoon$delegate;
    private final MutableIntState minuteState;
    private final MutableState selection$delegate;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u0004¨\u0006\u0006", d2 = {"Landroidx/compose/material3/TimePickerStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerStateImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material3.TimePickerStateImpl, ?> Saver() {
            return SaverKt.Saver((Function2)TimePickerStateImpl.Companion.Saver.1.INSTANCE, (Function1)TimePickerStateImpl.Companion.Saver.2.INSTANCE);
        }
    }
    static {
        TimePickerStateImpl.Companion companion = new TimePickerStateImpl.Companion(0);
        TimePickerStateImpl.Companion = companion;
    }

    public TimePickerStateImpl(int initialHour, int initialMinute, boolean is24Hour) {
        int i2;
        int i;
        int i3;
        int i4;
        super();
        i2 = 1;
        int i8 = 0;
        if (initialHour >= 0 && initialHour < 24) {
            i3 = initialHour < 24 ? i2 : i8;
        } else {
        }
        if (i3 == 0) {
        } else {
            if (initialMinute >= 0 && initialMinute < 60) {
                i4 = initialMinute < 60 ? i2 : i8;
            } else {
            }
            if (i4 == 0) {
            } else {
                this.is24hour = is24Hour;
                final int i10 = 0;
                final int i11 = 2;
                this.selection$delegate = SnapshotStateKt.mutableStateOf$default(TimePickerSelectionMode.box-impl(TimePickerSelectionMode.Companion.getHour-yecRtBI()), i10, i11, i10);
                if (initialHour >= 12) {
                } else {
                    i2 = i8;
                }
                this.isAfternoon$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i2), i10, i11, i10);
                this.hourState = SnapshotIntStateKt.mutableIntStateOf(initialHour % 12);
                this.minuteState = SnapshotIntStateKt.mutableIntStateOf(initialMinute);
            }
            int i6 = 0;
            IllegalArgumentException $i$a$RequireTimePickerStateImpl$2 = new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
            throw $i$a$RequireTimePickerStateImpl$2;
        }
        int i5 = 0;
        IllegalArgumentException $i$a$RequireTimePickerStateImpl$1 = new IllegalArgumentException("initialHour should in [0..23] range".toString());
        throw $i$a$RequireTimePickerStateImpl$1;
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHour() {
        int i;
        i = isAfternoon() ? 12 : 0;
        return intValue += i;
    }

    @Override // androidx.compose.material3.TimePickerState
    public final MutableIntState getHourState() {
        return this.hourState;
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinute() {
        return this.minuteState.getIntValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public final MutableIntState getMinuteState() {
        return this.minuteState;
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getSelection-yecRtBI() {
        final int i = 0;
        final int i2 = 0;
        return (TimePickerSelectionMode)(State)this.selection$delegate.getValue().unbox-impl();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean is24hour() {
        return this.is24hour;
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean isAfternoon() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isAfternoon$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void set24hour(boolean <set-?>) {
        this.is24hour = <set-?>;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setAfternoon(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isAfternoon$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHour(int value) {
        int i;
        i = value >= 12 ? 1 : 0;
        setAfternoon(i);
        this.hourState.setIntValue(value % 12);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinute(int value) {
        this.minuteState.setIntValue(value);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setSelection-6_8s6DQ(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.selection$delegate.setValue(TimePickerSelectionMode.box-impl(<set-?>));
    }
}
