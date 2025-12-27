package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogWorkoutCompletedRequest.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000cJ2\u0010\u0012\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000e\u0010\t¨\u0006!", d2 = {"Lapp/dogo/externalmodel/model/responses/DogWorkoutCompletedRequest;", "Landroid/os/Parcelable;", "currentStreakCount", "", "longestStreakCount", "lastWorkoutTimeMs", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getCurrentStreakCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastWorkoutTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLongestStreakCount", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lapp/dogo/externalmodel/model/responses/DogWorkoutCompletedRequest;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogWorkoutCompletedRequest implements Parcelable {

    public static final Parcelable.Creator<DogWorkoutCompletedRequest> CREATOR = new DogWorkoutCompletedRequest$Creator<>();
    private final Integer currentStreakCount;
    private final Long lastWorkoutTimeMs;
    private final Integer longestStreakCount;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogWorkoutCompletedRequest> {
        @Override // android.os.Parcelable$Creator
        public final DogWorkoutCompletedRequest createFromParcel(Parcel parcel) {
            Integer num;
            Long num2 = null;
            Integer num3;
            n.f(parcel, "parcel");
            int i = 0;
            if (parcel.readInt() == 0) {
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            if (parcel.readInt() == 0) {
            } else {
                num3 = Integer.valueOf(parcel.readInt());
            }
            if (parcel.readInt() != 0) {
                num2 = Long.valueOf(parcel.readLong());
            }
            DogWorkoutCompletedRequest dogWorkoutCompletedRequest = new DogWorkoutCompletedRequest(num, num3, num2);
            return dogWorkoutCompletedRequest;
        }

        @Override // android.os.Parcelable$Creator
        public final DogWorkoutCompletedRequest[] newArray(int i) {
            return new DogWorkoutCompletedRequest[i];
        }
    }
    public DogWorkoutCompletedRequest(Integer integer, Integer integer2, Long long) {
        super();
        this.currentStreakCount = integer;
        this.longestStreakCount = integer2;
        this.lastWorkoutTimeMs = long;
    }

    public final Integer getCurrentStreakCount() {
        return this.currentStreakCount;
    }

    public final Long getLastWorkoutTimeMs() {
        return this.lastWorkoutTimeMs;
    }

    public final Integer getLongestStreakCount() {
        return this.longestStreakCount;
    }

    public /* synthetic */ DogWorkoutCompletedRequest(Integer integer, Integer integer2, Long long, int i, g gVar) {
        Integer num;
        Integer num2;
        Long l;
        i = 0;
        i = i & 1 != 0 ? i : i;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        this(num, num2, l);
    }


    public DogWorkoutCompletedRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DogWorkoutCompletedRequest copy$default(DogWorkoutCompletedRequest dogWorkoutCompletedRequest, Integer integer, Integer integer2, Long long, int i, Object object) {
        Integer currentStreakCount2;
        Integer longestStreakCount2;
        Long lastWorkoutTimeMs2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return dogWorkoutCompletedRequest.copy(currentStreakCount2, longestStreakCount2, lastWorkoutTimeMs2);
    }

    /* operator */ public final Integer component1() {
        return this.currentStreakCount;
    }

    /* operator */ public final Integer component2() {
        return this.longestStreakCount;
    }

    /* operator */ public final Long component3() {
        return this.lastWorkoutTimeMs;
    }

    public final DogWorkoutCompletedRequest copy(Integer currentStreakCount, Integer longestStreakCount, Long lastWorkoutTimeMs) {
        return new DogWorkoutCompletedRequest(currentStreakCount, longestStreakCount, lastWorkoutTimeMs);
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
        final boolean z5 = false;
        if (!(other instanceof DogWorkoutCompletedRequest)) {
            return false;
        }
        if (!n.b(this.currentStreakCount, other.currentStreakCount)) {
            return false;
        }
        if (!n.b(this.longestStreakCount, other.longestStreakCount)) {
            return false;
        }
        return !n.b(this.lastWorkoutTimeMs, other.lastWorkoutTimeMs) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.currentStreakCount == null) {
        } else {
            i = this.currentStreakCount.hashCode();
        }
        if (this.longestStreakCount == null) {
        } else {
            i = this.longestStreakCount.hashCode();
        }
        if (this.lastWorkoutTimeMs != null) {
            i = this.lastWorkoutTimeMs.hashCode();
        }
        return (i * 31) + i * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogWorkoutCompletedRequest(currentStreakCount=";
        String str3 = ", longestStreakCount=";
        String str4 = ", lastWorkoutTimeMs=";
        str = str2 + this.currentStreakCount + str3 + this.longestStreakCount + str4 + this.lastWorkoutTimeMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        int i = 0;
        final int i2 = 1;
        if (this.currentStreakCount == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.currentStreakCount.intValue());
        }
        if (this.longestStreakCount == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.longestStreakCount.intValue());
        }
        if (this.lastWorkoutTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.lastWorkoutTimeMs.longValue());
        }
    }
}
