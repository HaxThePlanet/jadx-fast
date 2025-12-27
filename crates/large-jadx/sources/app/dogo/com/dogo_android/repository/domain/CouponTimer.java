package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: CouponTimer.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CouponTimer;", "Landroid/os/Parcelable;", "timeMs", "", "(J)V", "getTimeMs", "()J", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getDays", "getHours", "getMinutes", "getSeconds", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CouponTimer implements Parcelable {

    public static final Parcelable.Creator<CouponTimer> CREATOR = new CouponTimer$Creator<>();
    private final long timeMs;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CouponTimer> {
        @Override // android.os.Parcelable$Creator
        public final CouponTimer createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new CouponTimer(parcel.readLong(), r2);
        }

        @Override // android.os.Parcelable$Creator
        public final CouponTimer[] newArray(int i) {
            return new CouponTimer[i];
        }
    }
    public CouponTimer(long j) {
        super();
        this.timeMs = j;
    }

    public final long getDays() {
        long days = 0;
        days = 0L;
        if (this.timeMs > days) {
            days = TimeUnit.MILLISECONDS.toDays(this.timeMs);
        }
        return days;
    }

    public final long getHours() {
        long hours = 0;
        hours = 0L;
        if (this.timeMs > hours) {
            long l = 1L;
            timeMs2 = timeMs2 % TimeUnit.DAYS.toMillis(l);
            hours = TimeUnit.MILLISECONDS.toHours(timeMs2);
        }
        return hours;
    }

    public final long getMinutes() {
        long minutes = 0;
        minutes = 0L;
        if (this.timeMs > minutes) {
            long l = 1L;
            timeMs2 = timeMs2 % TimeUnit.HOURS.toMillis(l);
            minutes = TimeUnit.MILLISECONDS.toMinutes(timeMs2);
        }
        return minutes;
    }

    public final long getSeconds() {
        long seconds = 0;
        seconds = 0L;
        if (this.timeMs > seconds) {
            long l = 1L;
            timeMs2 = timeMs2 % TimeUnit.MINUTES.toMillis(l);
            seconds = TimeUnit.MILLISECONDS.toSeconds(timeMs2);
        }
        return seconds;
    }

    public final long getTimeMs() {
        return this.timeMs;
    }


    public static /* synthetic */ CouponTimer copy$default(CouponTimer couponTimer, long j, int i, Object object) {
        long timeMs2;
        if (i & 1 != 0) {
        }
        return couponTimer.copy(timeMs2);
    }

    /* operator */ public final long component1() {
        return this.timeMs;
    }

    public final CouponTimer copy(long timeMs) {
        return new CouponTimer(timeMs, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof CouponTimer)) {
            return false;
        }
        return this.timeMs != other.timeMs ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Long.hashCode(this.timeMs);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CouponTimer(timeMs=";
        str = str2 + this.timeMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeLong(this.timeMs);
    }
}
