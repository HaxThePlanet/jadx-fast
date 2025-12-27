package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogProgramVariationDurationRequest.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000e¨\u0006$", d2 = {"Lapp/dogo/externalmodel/model/requests/DogProgramVariationDurationRequest;", "Landroid/os/Parcelable;", "moduleId", "", "lessonId", "variationId", "dailyTrainingTimeGoalSec", "", "durationSec", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getDailyTrainingTimeGoalSec", "()J", "getDurationSec", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getVariationId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogProgramVariationDurationRequest implements Parcelable {

    public static final Parcelable.Creator<DogProgramVariationDurationRequest> CREATOR = new DogProgramVariationDurationRequest$Creator<>();
    private final long dailyTrainingTimeGoalSec;
    private final long durationSec;
    private final String lessonId;
    private final String moduleId;
    private final String variationId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogProgramVariationDurationRequest> {
        @Override // android.os.Parcelable$Creator
        public final DogProgramVariationDurationRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogProgramVariationDurationRequest dogProgramVariationDurationRequest = new DogProgramVariationDurationRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), l, parcel.readLong(), obj);
            return dogProgramVariationDurationRequest;
        }

        @Override // android.os.Parcelable$Creator
        public final DogProgramVariationDurationRequest[] newArray(int i) {
            return new DogProgramVariationDurationRequest[i];
        }
    }
    public DogProgramVariationDurationRequest(String str, String str2, String str3, long j, long j2) {
        n.f(str, "moduleId");
        n.f(str2, "lessonId");
        n.f(str3, "variationId");
        super();
        this.moduleId = str;
        this.lessonId = str2;
        this.variationId = str3;
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

    public final String getVariationId() {
        return this.variationId;
    }


    public static /* synthetic */ DogProgramVariationDurationRequest copy$default(DogProgramVariationDurationRequest dogProgramVariationDurationRequest, String str, String str2, String str3, long j, long j2, int i, Object object) {
        String str22;
        String str32;
        String str42;
        long j52;
        long i72;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        return dogProgramVariationDurationRequest.copy(str22, str32, str42, j52, i72);
    }

    /* operator */ public final String component1() {
        return this.moduleId;
    }

    /* operator */ public final String component2() {
        return this.lessonId;
    }

    /* operator */ public final String component3() {
        return this.variationId;
    }

    /* operator */ public final long component4() {
        return this.dailyTrainingTimeGoalSec;
    }

    /* operator */ public final long component5() {
        return this.durationSec;
    }

    public final DogProgramVariationDurationRequest copy(String moduleId, String lessonId, String variationId, long dailyTrainingTimeGoalSec, long durationSec) {
        n.f(moduleId, "moduleId");
        n.f(lessonId, "lessonId");
        n.f(variationId, "variationId");
        DogProgramVariationDurationRequest dogProgramVariationDurationRequest = new DogProgramVariationDurationRequest(moduleId, lessonId, variationId, dailyTrainingTimeGoalSec, l, durationSec, obj2);
        return dogProgramVariationDurationRequest;
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
        final boolean z6 = false;
        if (!(other instanceof DogProgramVariationDurationRequest)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        if (!n.b(this.lessonId, other.lessonId)) {
            return false;
        }
        if (!n.b(this.variationId, other.variationId)) {
            return false;
        }
        if (this.dailyTrainingTimeGoalSec != other.dailyTrainingTimeGoalSec) {
            return false;
        }
        return this.durationSec != other.durationSec ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.moduleId.hashCode() * 31) + this.lessonId.hashCode() * 31 + this.variationId.hashCode() * 31 + Long.hashCode(this.dailyTrainingTimeGoalSec) * 31 + Long.hashCode(this.durationSec);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogProgramVariationDurationRequest(moduleId=";
        String str3 = ", lessonId=";
        String str4 = ", variationId=";
        String str5 = ", dailyTrainingTimeGoalSec=";
        String str6 = ", durationSec=";
        str = str2 + this.moduleId + str3 + this.lessonId + str4 + this.variationId + str5 + this.dailyTrainingTimeGoalSec + str6 + this.durationSec + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
        parcel.writeString(this.variationId);
        parcel.writeLong(this.dailyTrainingTimeGoalSec);
        parcel.writeLong(this.durationSec);
    }
}
