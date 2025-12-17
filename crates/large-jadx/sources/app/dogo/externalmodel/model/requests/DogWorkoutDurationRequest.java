package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u001a", d2 = {"Lapp/dogo/externalmodel/model/requests/DogWorkoutDurationRequest;", "Landroid/os/Parcelable;", "dailyTrainingTimeGoalSec", "", "durationSec", "(JJ)V", "getDailyTrainingTimeGoalSec", "()J", "getDurationSec", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogWorkoutDurationRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest> CREATOR;
    private final long dailyTrainingTimeGoalSec;
    private final long durationSec;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogWorkoutDurationRequest dogWorkoutDurationRequest = new DogWorkoutDurationRequest(parcel.readLong(), obj2, parcel.readLong(), obj4);
            return dogWorkoutDurationRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest[] newArray(int i) {
            return new DogWorkoutDurationRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogWorkoutDurationRequest.Creator creator = new DogWorkoutDurationRequest.Creator();
        DogWorkoutDurationRequest.CREATOR = creator;
    }

    public DogWorkoutDurationRequest(long l, long l2) {
        super();
        this.dailyTrainingTimeGoalSec = l;
        this.durationSec = obj3;
    }

    public static app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest copy$default(app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest dogWorkoutDurationRequest, long l2, long l3, int i4, Object object5) {
        long obj1;
        long obj3;
        if (obj5 & 1 != 0) {
            obj1 = dogWorkoutDurationRequest.dailyTrainingTimeGoalSec;
        }
        if (obj5 &= 2 != 0) {
            obj3 = dogWorkoutDurationRequest.durationSec;
        }
        return dogWorkoutDurationRequest.copy(obj1, l3);
    }

    @Override // android.os.Parcelable
    public final long component1() {
        return this.dailyTrainingTimeGoalSec;
    }

    @Override // android.os.Parcelable
    public final long component2() {
        return this.durationSec;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest copy(long l, long l2) {
        DogWorkoutDurationRequest dogWorkoutDurationRequest = new DogWorkoutDurationRequest(l, l2, obj4, obj5);
        return dogWorkoutDurationRequest;
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
        if (object instanceof DogWorkoutDurationRequest == null) {
            return i2;
        }
        if (Long.compare(dailyTrainingTimeGoalSec, dailyTrainingTimeGoalSec2) != 0) {
            return i2;
        }
        if (Long.compare(durationSec, durationSec2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final long getDailyTrainingTimeGoalSec() {
        return this.dailyTrainingTimeGoalSec;
    }

    @Override // android.os.Parcelable
    public final long getDurationSec() {
        return this.durationSec;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogWorkoutDurationRequest(dailyTrainingTimeGoalSec=");
        stringBuilder.append(this.dailyTrainingTimeGoalSec);
        stringBuilder.append(", durationSec=");
        stringBuilder.append(this.durationSec);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeLong(this.dailyTrainingTimeGoalSec);
        parcel.writeLong(this.durationSec);
    }
}
