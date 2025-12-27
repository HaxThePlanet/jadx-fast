package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogSpecialProgramTrickDurationRequest.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u001a", d2 = {"Lapp/dogo/externalmodel/model/requests/DogSpecialProgramTrickDurationRequest;", "Landroid/os/Parcelable;", "dailyTrainingTimeGoalSec", "", "durationSec", "(JJ)V", "getDailyTrainingTimeGoalSec", "()J", "getDurationSec", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogSpecialProgramTrickDurationRequest implements Parcelable {

    public static final Parcelable.Creator<DogSpecialProgramTrickDurationRequest> CREATOR = new DogSpecialProgramTrickDurationRequest$Creator<>();
    private final long dailyTrainingTimeGoalSec;
    private final long durationSec;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogSpecialProgramTrickDurationRequest> {
        @Override // android.os.Parcelable$Creator
        public final DogSpecialProgramTrickDurationRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new DogSpecialProgramTrickDurationRequest(parcel.readLong(), r2, parcel.readLong(), r4);
        }

        @Override // android.os.Parcelable$Creator
        public final DogSpecialProgramTrickDurationRequest[] newArray(int i) {
            return new DogSpecialProgramTrickDurationRequest[i];
        }
    }
    public DogSpecialProgramTrickDurationRequest(long j, long j2) {
        super();
        this.dailyTrainingTimeGoalSec = j;
        this.durationSec = j2;
    }

    public final long getDailyTrainingTimeGoalSec() {
        return this.dailyTrainingTimeGoalSec;
    }

    public final long getDurationSec() {
        return this.durationSec;
    }


    public static /* synthetic */ DogSpecialProgramTrickDurationRequest copy$default(DogSpecialProgramTrickDurationRequest dogSpecialProgramTrickDurationRequest, long j, long j2, int i, Object object) {
        long dailyTrainingTimeGoalSec2;
        long durationSec2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return dogSpecialProgramTrickDurationRequest.copy(dailyTrainingTimeGoalSec2, durationSec2);
    }

    /* operator */ public final long component1() {
        return this.dailyTrainingTimeGoalSec;
    }

    /* operator */ public final long component2() {
        return this.durationSec;
    }

    public final DogSpecialProgramTrickDurationRequest copy(long dailyTrainingTimeGoalSec, long durationSec) {
        return new DogSpecialProgramTrickDurationRequest(dailyTrainingTimeGoalSec, r3, durationSec, r5);
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
        if (!(other instanceof DogSpecialProgramTrickDurationRequest)) {
            return false;
        }
        if (this.dailyTrainingTimeGoalSec != other.dailyTrainingTimeGoalSec) {
            return false;
        }
        return this.durationSec != other.durationSec ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (Long.hashCode(this.dailyTrainingTimeGoalSec) * 31) + Long.hashCode(this.durationSec);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogSpecialProgramTrickDurationRequest(dailyTrainingTimeGoalSec=";
        String str3 = ", durationSec=";
        str = str2 + this.dailyTrainingTimeGoalSec + str3 + this.durationSec + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeLong(this.dailyTrainingTimeGoalSec);
        parcel.writeLong(this.durationSec);
    }
}
