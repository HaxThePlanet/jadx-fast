package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\r¨\u0006!", d2 = {"Lapp/dogo/externalmodel/model/requests/DogProgramTrickDurationRequest;", "Landroid/os/Parcelable;", "moduleId", "", "lessonId", "dailyTrainingTimeGoalSec", "", "durationSec", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getDailyTrainingTimeGoalSec", "()J", "getDurationSec", "getLessonId", "()Ljava/lang/String;", "getModuleId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogProgramTrickDurationRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest> CREATOR;
    private final long dailyTrainingTimeGoalSec;
    private final long durationSec;
    private final String lessonId;
    private final String moduleId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readString(), parcel.readLong(), obj5, parcel.readLong(), obj7);
            return dogProgramTrickDurationRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest[] newArray(int i) {
            return new DogProgramTrickDurationRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogProgramTrickDurationRequest.Creator creator = new DogProgramTrickDurationRequest.Creator();
        DogProgramTrickDurationRequest.CREATOR = creator;
    }

    public DogProgramTrickDurationRequest(String string, String string2, long l3, long l4) {
        n.f(string, "moduleId");
        n.f(string2, "lessonId");
        super();
        this.moduleId = string;
        this.lessonId = string2;
        this.dailyTrainingTimeGoalSec = l3;
        this.durationSec = obj6;
    }

    public static app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest copy$default(app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest dogProgramTrickDurationRequest, String string2, String string3, long l4, long l5, int i6, Object object7) {
        String obj5;
        String obj6;
        long obj7;
        long obj9;
        if (obj11 & 1 != 0) {
            obj5 = dogProgramTrickDurationRequest.moduleId;
        }
        if (obj11 & 2 != 0) {
            obj6 = dogProgramTrickDurationRequest.lessonId;
        }
        String obj12 = obj6;
        if (obj11 & 4 != 0) {
            obj7 = dogProgramTrickDurationRequest.dailyTrainingTimeGoalSec;
        }
        if (obj11 & 8 != 0) {
            obj9 = dogProgramTrickDurationRequest.durationSec;
        }
        return dogProgramTrickDurationRequest.copy(obj5, obj12, obj7, object7);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final long component3() {
        return this.dailyTrainingTimeGoalSec;
    }

    @Override // android.os.Parcelable
    public final long component4() {
        return this.durationSec;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest copy(String string, String string2, long l3, long l4) {
        n.f(string, "moduleId");
        n.f(string2, "lessonId");
        super(string, string2, l3, obj5, obj13, obj7);
        return dogProgramTrickDurationRequest;
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
        if (object instanceof DogProgramTrickDurationRequest == null) {
            return i2;
        }
        if (!n.b(this.moduleId, object.moduleId)) {
            return i2;
        }
        if (!n.b(this.lessonId, object.lessonId)) {
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
    public final String getLessonId() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final String getModuleId() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i6 += i10;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogProgramTrickDurationRequest(moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", lessonId=");
        stringBuilder.append(this.lessonId);
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
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
        parcel.writeLong(this.dailyTrainingTimeGoalSec);
        parcel.writeLong(this.durationSec);
    }
}
