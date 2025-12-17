package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CouponTimer;", "Landroid/os/Parcelable;", "timeMs", "", "(J)V", "getTimeMs", "()J", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getDays", "getHours", "getMinutes", "getSeconds", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CouponTimer implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.CouponTimer> CREATOR;
    private final long timeMs;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.CouponTimer> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.CouponTimer createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            CouponTimer couponTimer = new CouponTimer(parcel.readLong(), obj2);
            return couponTimer;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.CouponTimer[] newArray(int i) {
            return new CouponTimer[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        CouponTimer.Creator creator = new CouponTimer.Creator();
        CouponTimer.CREATOR = creator;
    }

    public CouponTimer(long l) {
        super();
        this.timeMs = l;
    }

    public static app.dogo.com.dogo_android.repository.domain.CouponTimer copy$default(app.dogo.com.dogo_android.repository.domain.CouponTimer couponTimer, long l2, int i3, Object object4) {
        long obj1;
        if (object4 &= 1 != 0) {
            obj1 = couponTimer.timeMs;
        }
        return couponTimer.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final long component1() {
        return this.timeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.CouponTimer copy(long l) {
        CouponTimer couponTimer = new CouponTimer(l, obj3);
        return couponTimer;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CouponTimer) {
            return i2;
        }
        if (Long.compare(timeMs, timeMs2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final long getDays() {
        int days;
        final long timeMs = this.timeMs;
        if (Long.compare(timeMs, days) <= 0) {
        } else {
            days = TimeUnit.MILLISECONDS.toDays(timeMs);
        }
        return days;
    }

    @Override // android.os.Parcelable
    public final long getHours() {
        long timeMs;
        int hours;
        int i;
        timeMs = this.timeMs;
        final int cmp = Long.compare(timeMs, hours);
        if (cmp <= 0) {
        } else {
            hours = TimeUnit.MILLISECONDS.toHours(timeMs %= millis);
        }
        return hours;
    }

    @Override // android.os.Parcelable
    public final long getMinutes() {
        long timeMs;
        int minutes;
        int i;
        timeMs = this.timeMs;
        final int cmp = Long.compare(timeMs, minutes);
        if (cmp <= 0) {
        } else {
            minutes = TimeUnit.MILLISECONDS.toMinutes(timeMs %= millis);
        }
        return minutes;
    }

    @Override // android.os.Parcelable
    public final long getSeconds() {
        long timeMs;
        int seconds;
        int i;
        timeMs = this.timeMs;
        final int cmp = Long.compare(timeMs, seconds);
        if (cmp <= 0) {
        } else {
            seconds = TimeUnit.MILLISECONDS.toSeconds(timeMs %= millis);
        }
        return seconds;
    }

    @Override // android.os.Parcelable
    public final long getTimeMs() {
        return this.timeMs;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return Long.hashCode(this.timeMs);
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CouponTimer(timeMs=");
        stringBuilder.append(this.timeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeLong(this.timeMs);
    }
}
