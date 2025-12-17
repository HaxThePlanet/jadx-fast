package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/requests/DogSpecialProgramVariationDurationRequest;", "Landroid/os/Parcelable;", "variationId", "", "dailyTrainingTimeGoalSec", "", "durationSec", "(Ljava/lang/String;JJ)V", "getDailyTrainingTimeGoalSec", "()J", "getDurationSec", "getVariationId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogSpecialProgramVariationDurationRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest> CREATOR;
    private final long dailyTrainingTimeGoalSec;
    private final long durationSec;
    private final String variationId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readLong(), obj4, parcel.readLong(), obj6);
            return dogSpecialProgramVariationDurationRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest[] newArray(int i) {
            return new DogSpecialProgramVariationDurationRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogSpecialProgramVariationDurationRequest.Creator creator = new DogSpecialProgramVariationDurationRequest.Creator();
        DogSpecialProgramVariationDurationRequest.CREATOR = creator;
    }

    public DogSpecialProgramVariationDurationRequest(String string, long l2, long l3) {
        n.f(string, "variationId");
        super();
        this.variationId = string;
        this.dailyTrainingTimeGoalSec = l2;
        this.durationSec = obj5;
    }

    public static app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest copy$default(app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest dogSpecialProgramVariationDurationRequest, String string2, long l3, long l4, int i5, Object object6) {
        String obj3;
        long obj4;
        long obj6;
        if (obj8 & 1 != 0) {
            obj3 = dogSpecialProgramVariationDurationRequest.variationId;
        }
        int obj9 = obj8 & 2;
        if (obj9 != null) {
            obj4 = dogSpecialProgramVariationDurationRequest.dailyTrainingTimeGoalSec;
        }
        if (obj8 & 4 != 0) {
            obj6 = dogSpecialProgramVariationDurationRequest.durationSec;
        }
        return dogSpecialProgramVariationDurationRequest.copy(obj3, obj4, object6);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.variationId;
    }

    @Override // android.os.Parcelable
    public final long component2() {
        return this.dailyTrainingTimeGoalSec;
    }

    @Override // android.os.Parcelable
    public final long component3() {
        return this.durationSec;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest copy(String string, long l2, long l3) {
        n.f(string, "variationId");
        super(string, l2, obj4, obj11, obj6);
        return dogSpecialProgramVariationDurationRequest;
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
        if (object instanceof DogSpecialProgramVariationDurationRequest == null) {
            return i2;
        }
        if (!n.b(this.variationId, object.variationId)) {
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
    public final String getVariationId() {
        return this.variationId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogSpecialProgramVariationDurationRequest(variationId=");
        stringBuilder.append(this.variationId);
        stringBuilder.append(", dailyTrainingTimeGoalSec=");
        stringBuilder.append(this.dailyTrainingTimeGoalSec);
        stringBuilder.append(", durationSec=");
        stringBuilder.append(this.durationSec);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.variationId);
        parcel.writeLong(this.dailyTrainingTimeGoalSec);
        parcel.writeLong(this.durationSec);
    }
}
