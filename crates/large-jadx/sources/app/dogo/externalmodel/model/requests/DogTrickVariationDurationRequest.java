package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogTrickVariationDurationRequest.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/requests/DogTrickVariationDurationRequest;", "Landroid/os/Parcelable;", "variationId", "", "dailyTrainingTimeGoalSec", "", "durationSec", "(Ljava/lang/String;JJ)V", "getDailyTrainingTimeGoalSec", "()J", "getDurationSec", "getVariationId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogTrickVariationDurationRequest implements Parcelable {

    public static final Parcelable.Creator<DogTrickVariationDurationRequest> CREATOR = new DogTrickVariationDurationRequest$Creator<>();
    private final long dailyTrainingTimeGoalSec;
    private final long durationSec;
    private final String variationId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogTrickVariationDurationRequest> {
        @Override // android.os.Parcelable$Creator
        public final DogTrickVariationDurationRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogTrickVariationDurationRequest dogTrickVariationDurationRequest = new DogTrickVariationDurationRequest(parcel.readString(), parcel.readLong(), l, parcel.readLong(), obj);
            return dogTrickVariationDurationRequest;
        }

        @Override // android.os.Parcelable$Creator
        public final DogTrickVariationDurationRequest[] newArray(int i) {
            return new DogTrickVariationDurationRequest[i];
        }
    }
    public DogTrickVariationDurationRequest(String str, long j, long j2) {
        n.f(str, "variationId");
        super();
        this.variationId = str;
        this.dailyTrainingTimeGoalSec = j;
        this.durationSec = j2;
    }

    public final long getDailyTrainingTimeGoalSec() {
        return this.dailyTrainingTimeGoalSec;
    }

    public final long getDurationSec() {
        return this.durationSec;
    }

    public final String getVariationId() {
        return this.variationId;
    }


    public static /* synthetic */ DogTrickVariationDurationRequest copy$default(DogTrickVariationDurationRequest dogTrickVariationDurationRequest, String str, long j, long j2, int i, Object object) {
        String str22;
        long j32;
        long i52;
        if (i & 1 != 0) {
        }
        int i3 = i & 2;
        if (i3 != 0) {
        }
        if (i & 4 != 0) {
        }
        return dogTrickVariationDurationRequest.copy(str22, j32, i52);
    }

    /* operator */ public final String component1() {
        return this.variationId;
    }

    /* operator */ public final long component2() {
        return this.dailyTrainingTimeGoalSec;
    }

    /* operator */ public final long component3() {
        return this.durationSec;
    }

    public final DogTrickVariationDurationRequest copy(String variationId, long dailyTrainingTimeGoalSec, long durationSec) {
        n.f(variationId, "variationId");
        DogTrickVariationDurationRequest dogTrickVariationDurationRequest = new DogTrickVariationDurationRequest(variationId, dailyTrainingTimeGoalSec, l, durationSec, obj2);
        return dogTrickVariationDurationRequest;
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
        final boolean z4 = false;
        if (!(other instanceof DogTrickVariationDurationRequest)) {
            return false;
        }
        if (!n.b(this.variationId, other.variationId)) {
            return false;
        }
        if (this.dailyTrainingTimeGoalSec != other.dailyTrainingTimeGoalSec) {
            return false;
        }
        return this.durationSec != other.durationSec ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.variationId.hashCode() * 31) + Long.hashCode(this.dailyTrainingTimeGoalSec) * 31 + Long.hashCode(this.durationSec);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogTrickVariationDurationRequest(variationId=";
        String str3 = ", dailyTrainingTimeGoalSec=";
        String str4 = ", durationSec=";
        str = str2 + this.variationId + str3 + this.dailyTrainingTimeGoalSec + str4 + this.durationSec + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.variationId);
        parcel.writeLong(this.dailyTrainingTimeGoalSec);
        parcel.writeLong(this.durationSec);
    }
}
