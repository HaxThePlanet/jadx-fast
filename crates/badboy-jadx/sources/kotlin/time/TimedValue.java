package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u000e\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0008J*\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00028\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u001a", d2 = {"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration-UwyO8pc", "()J", "J", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-UwyO8pc", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TimedValue<T>  {

    private final long duration;
    private final T value;
    private TimedValue(T value, long duration) {
        super();
        this.value = value;
        this.duration = duration;
    }

    public TimedValue(Object object, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(object, l2, defaultConstructorMarker3);
    }

    public static kotlin.time.TimedValue copy-RFiDyg4$default(kotlin.time.TimedValue timedValue, Object object2, long l3, int i4, Object object5) {
        Object obj1;
        long obj2;
        if (object5 & 1 != 0) {
            obj1 = timedValue.value;
        }
        if (object5 &= 2 != 0) {
            obj2 = timedValue.duration;
        }
        return timedValue.copy-RFiDyg4(obj1, obj2);
    }

    public final T component1() {
        return this.value;
    }

    public final long component2-UwyO8pc() {
        return this.duration;
    }

    public final kotlin.time.TimedValue<T> copy-RFiDyg4(T t, long l2) {
        TimedValue timedValue = new TimedValue(t, l2, obj5, 0);
        return timedValue;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TimedValue) {
            return i2;
        }
        Object obj = object;
        final Object value2 = obj.value;
        if (!Intrinsics.areEqual(this.value, value2)) {
            return i2;
        }
        if (!Duration.equals-impl0(this.duration, value2)) {
            return i2;
        }
        return i;
    }

    public final long getDuration-UwyO8pc() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i;
        if (this.value == null) {
            i = 0;
        } else {
            i = this.value.hashCode();
        }
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TimedValue(value=").append(this.value).append(", duration=").append(Duration.toString-impl(this.duration)).append(')').toString();
    }
}
