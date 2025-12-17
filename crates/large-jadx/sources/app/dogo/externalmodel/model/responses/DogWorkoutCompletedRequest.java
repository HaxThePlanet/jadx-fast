package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000cJ2\u0010\u0012\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000e\u0010\t¨\u0006!", d2 = {"Lapp/dogo/externalmodel/model/responses/DogWorkoutCompletedRequest;", "Landroid/os/Parcelable;", "currentStreakCount", "", "longestStreakCount", "lastWorkoutTimeMs", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getCurrentStreakCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastWorkoutTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLongestStreakCount", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lapp/dogo/externalmodel/model/responses/DogWorkoutCompletedRequest;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogWorkoutCompletedRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest> CREATOR;
    private final Integer currentStreakCount;
    private final Long lastWorkoutTimeMs;
    private final Integer longestStreakCount;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest createFromParcel(Parcel parcel) {
            Integer valueOf;
            int valueOf2;
            Integer valueOf3;
            int long;
            n.f(parcel, "parcel");
            valueOf2 = 0;
            if (parcel.readInt() == 0) {
                valueOf = valueOf2;
            } else {
                valueOf = Integer.valueOf(parcel.readInt());
            }
            if (parcel.readInt() == 0) {
                valueOf3 = valueOf2;
            } else {
                valueOf3 = Integer.valueOf(parcel.readInt());
            }
            if (parcel.readInt() == 0) {
            } else {
                valueOf2 = Long.valueOf(parcel.readLong());
            }
            DogWorkoutCompletedRequest dogWorkoutCompletedRequest = new DogWorkoutCompletedRequest(valueOf, valueOf3, valueOf2);
            return dogWorkoutCompletedRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest[] newArray(int i) {
            return new DogWorkoutCompletedRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogWorkoutCompletedRequest.Creator creator = new DogWorkoutCompletedRequest.Creator();
        DogWorkoutCompletedRequest.CREATOR = creator;
    }

    public DogWorkoutCompletedRequest() {
        super(0, 0, 0, 7, 0);
    }

    public DogWorkoutCompletedRequest(Integer integer, Integer integer2, Long long3) {
        super();
        this.currentStreakCount = integer;
        this.longestStreakCount = integer2;
        this.lastWorkoutTimeMs = long3;
    }

    public DogWorkoutCompletedRequest(Integer integer, Integer integer2, Long long3, int i4, g g5) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 0;
        obj2 = i4 & 1 != 0 ? i : obj2;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(obj2, obj3, obj4);
    }

    public static app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest copy$default(app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest dogWorkoutCompletedRequest, Integer integer2, Integer integer3, Long long4, int i5, Object object6) {
        Integer obj1;
        Integer obj2;
        Long obj3;
        if (i5 & 1 != 0) {
            obj1 = dogWorkoutCompletedRequest.currentStreakCount;
        }
        if (i5 & 2 != 0) {
            obj2 = dogWorkoutCompletedRequest.longestStreakCount;
        }
        if (i5 &= 4 != 0) {
            obj3 = dogWorkoutCompletedRequest.lastWorkoutTimeMs;
        }
        return dogWorkoutCompletedRequest.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final Integer component1() {
        return this.currentStreakCount;
    }

    @Override // android.os.Parcelable
    public final Integer component2() {
        return this.longestStreakCount;
    }

    @Override // android.os.Parcelable
    public final Long component3() {
        return this.lastWorkoutTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest copy(Integer integer, Integer integer2, Long long3) {
        DogWorkoutCompletedRequest dogWorkoutCompletedRequest = new DogWorkoutCompletedRequest(integer, integer2, long3);
        return dogWorkoutCompletedRequest;
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
        if (object instanceof DogWorkoutCompletedRequest == null) {
            return i2;
        }
        if (!n.b(this.currentStreakCount, object.currentStreakCount)) {
            return i2;
        }
        if (!n.b(this.longestStreakCount, object.longestStreakCount)) {
            return i2;
        }
        if (!n.b(this.lastWorkoutTimeMs, object.lastWorkoutTimeMs)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final Integer getCurrentStreakCount() {
        return this.currentStreakCount;
    }

    @Override // android.os.Parcelable
    public final Long getLastWorkoutTimeMs() {
        return this.lastWorkoutTimeMs;
    }

    @Override // android.os.Parcelable
    public final Integer getLongestStreakCount() {
        return this.longestStreakCount;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i2;
        int i3;
        Integer currentStreakCount = this.currentStreakCount;
        i2 = 0;
        if (currentStreakCount == null) {
            i = i2;
        } else {
            i = currentStreakCount.hashCode();
        }
        Integer longestStreakCount = this.longestStreakCount;
        if (longestStreakCount == null) {
            i3 = i2;
        } else {
            i3 = longestStreakCount.hashCode();
        }
        Long lastWorkoutTimeMs = this.lastWorkoutTimeMs;
        if (lastWorkoutTimeMs == null) {
        } else {
            i2 = lastWorkoutTimeMs.hashCode();
        }
        return i6 += i2;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogWorkoutCompletedRequest(currentStreakCount=");
        stringBuilder.append(this.currentStreakCount);
        stringBuilder.append(", longestStreakCount=");
        stringBuilder.append(this.longestStreakCount);
        stringBuilder.append(", lastWorkoutTimeMs=");
        stringBuilder.append(this.lastWorkoutTimeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int longValue;
        int obj4;
        n.f(parcel, "out");
        obj4 = this.currentStreakCount;
        longValue = 0;
        final int i = 1;
        if (obj4 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeInt(obj4.intValue());
        }
        obj4 = this.longestStreakCount;
        if (obj4 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeInt(obj4.intValue());
        }
        obj4 = this.lastWorkoutTimeMs;
        if (obj4 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(obj4.longValue());
        }
    }
}
