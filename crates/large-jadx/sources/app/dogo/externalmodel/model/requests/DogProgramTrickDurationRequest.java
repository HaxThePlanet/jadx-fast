package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogProgramTrickDurationRequest.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\r¨\u0006!", d2 = {"Lapp/dogo/externalmodel/model/requests/DogProgramTrickDurationRequest;", "Landroid/os/Parcelable;", "moduleId", "", "lessonId", "dailyTrainingTimeGoalSec", "", "durationSec", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getDailyTrainingTimeGoalSec", "()J", "getDurationSec", "getLessonId", "()Ljava/lang/String;", "getModuleId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogProgramTrickDurationRequest implements Parcelable {

    public static final Parcelable.Creator<DogProgramTrickDurationRequest> CREATOR = new DogProgramTrickDurationRequest$Creator<>();
    private final long dailyTrainingTimeGoalSec;
    private final long durationSec;
    private final String lessonId;
    private final String moduleId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogProgramTrickDurationRequest> {
        @Override // android.os.Parcelable$Creator
        public final DogProgramTrickDurationRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogProgramTrickDurationRequest dogProgramTrickDurationRequest = new DogProgramTrickDurationRequest(parcel.readString(), parcel.readString(), parcel.readLong(), l, parcel.readLong(), obj);
            return dogProgramTrickDurationRequest;
        }

        @Override // android.os.Parcelable$Creator
        public final DogProgramTrickDurationRequest[] newArray(int i) {
            return new DogProgramTrickDurationRequest[i];
        }
    }
    public DogProgramTrickDurationRequest(String str, String str2, long j, long j2) {
        n.f(str, "moduleId");
        n.f(str2, "lessonId");
        super();
        this.moduleId = str;
        this.lessonId = str2;
        this.dailyTrainingTimeGoalSec = j;
        this.durationSec = j2;
    }

    public final long getDailyTrainingTimeGoalSec() {
        return this.dailyTrainingTimeGoalSec;
    }

    public final long getDurationSec() {
        return this.durationSec;
    }

    public final String getLessonId() {
        return this.lessonId;
    }

    public final String getModuleId() {
        return this.moduleId;
    }


    public static /* synthetic */ DogProgramTrickDurationRequest copy$default(DogProgramTrickDurationRequest dogProgramTrickDurationRequest, String str, String str2, long j, long j2, int i, Object object) {
        String str22;
        String str32;
        long j42;
        long i62;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return dogProgramTrickDurationRequest.copy(str22, str32, j42, i62);
    }

    /* operator */ public final String component1() {
        return this.moduleId;
    }

    /* operator */ public final String component2() {
        return this.lessonId;
    }

    /* operator */ public final long component3() {
        return this.dailyTrainingTimeGoalSec;
    }

    /* operator */ public final long component4() {
        return this.durationSec;
    }

    public final DogProgramTrickDurationRequest copy(String moduleId, String lessonId, long dailyTrainingTimeGoalSec, long durationSec) {
        n.f(moduleId, "moduleId");
        n.f(lessonId, "lessonId");
        DogProgramTrickDurationRequest dogProgramTrickDurationRequest = new DogProgramTrickDurationRequest(moduleId, lessonId, dailyTrainingTimeGoalSec, l, durationSec, obj2);
        return dogProgramTrickDurationRequest;
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
        if (!(other instanceof DogProgramTrickDurationRequest)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        if (!n.b(this.lessonId, other.lessonId)) {
            return false;
        }
        if (this.dailyTrainingTimeGoalSec != other.dailyTrainingTimeGoalSec) {
            return false;
        }
        return this.durationSec != other.durationSec ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.moduleId.hashCode() * 31) + this.lessonId.hashCode() * 31 + Long.hashCode(this.dailyTrainingTimeGoalSec) * 31 + Long.hashCode(this.durationSec);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogProgramTrickDurationRequest(moduleId=";
        String str3 = ", lessonId=";
        String str4 = ", dailyTrainingTimeGoalSec=";
        String str5 = ", durationSec=";
        str = str2 + this.moduleId + str3 + this.lessonId + str4 + this.dailyTrainingTimeGoalSec + str5 + this.durationSec + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
        parcel.writeLong(this.dailyTrainingTimeGoalSec);
        parcel.writeLong(this.durationSec);
    }
}
