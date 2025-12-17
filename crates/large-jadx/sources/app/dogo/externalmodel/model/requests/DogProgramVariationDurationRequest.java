package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000e¨\u0006$", d2 = {"Lapp/dogo/externalmodel/model/requests/DogProgramVariationDurationRequest;", "Landroid/os/Parcelable;", "moduleId", "", "lessonId", "variationId", "dailyTrainingTimeGoalSec", "", "durationSec", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getDailyTrainingTimeGoalSec", "()J", "getDurationSec", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getVariationId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogProgramVariationDurationRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest> CREATOR;
    private final long dailyTrainingTimeGoalSec;
    private final long durationSec;
    private final String lessonId;
    private final String moduleId;
    private final String variationId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), obj6, parcel.readLong(), obj8);
            return dogProgramVariationDurationRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest[] newArray(int i) {
            return new DogProgramVariationDurationRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogProgramVariationDurationRequest.Creator creator = new DogProgramVariationDurationRequest.Creator();
        DogProgramVariationDurationRequest.CREATOR = creator;
    }

    public DogProgramVariationDurationRequest(String string, String string2, String string3, long l4, long l5) {
        n.f(string, "moduleId");
        n.f(string2, "lessonId");
        n.f(string3, "variationId");
        super();
        this.moduleId = string;
        this.lessonId = string2;
        this.variationId = string3;
        this.dailyTrainingTimeGoalSec = l4;
        this.durationSec = obj7;
    }

    public static app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest copy$default(app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest dogProgramVariationDurationRequest, String string2, String string3, String string4, long l5, long l6, int i7, Object object8) {
        String obj6;
        String obj7;
        String obj8;
        long obj9;
        long obj11;
        if (obj13 & 1 != 0) {
            obj6 = dogProgramVariationDurationRequest.moduleId;
        }
        if (obj13 & 2 != 0) {
            obj7 = dogProgramVariationDurationRequest.lessonId;
        }
        String obj14 = obj7;
        if (obj13 & 4 != 0) {
            obj8 = dogProgramVariationDurationRequest.variationId;
        }
        if (obj13 & 8 != 0) {
            obj9 = dogProgramVariationDurationRequest.dailyTrainingTimeGoalSec;
        }
        if (obj13 & 16 != 0) {
            obj11 = dogProgramVariationDurationRequest.durationSec;
        }
        return dogProgramVariationDurationRequest.copy(obj6, obj14, obj8, obj9, object8);
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
    public final String component3() {
        return this.variationId;
    }

    @Override // android.os.Parcelable
    public final long component4() {
        return this.dailyTrainingTimeGoalSec;
    }

    @Override // android.os.Parcelable
    public final long component5() {
        return this.durationSec;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest copy(String string, String string2, String string3, long l4, long l5) {
        n.f(string, "moduleId");
        n.f(string2, "lessonId");
        n.f(string3, "variationId");
        super(string, string2, string3, l4, obj6, obj15, obj8);
        return dogProgramVariationDurationRequest;
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
        if (object instanceof DogProgramVariationDurationRequest == null) {
            return i2;
        }
        if (!n.b(this.moduleId, object.moduleId)) {
            return i2;
        }
        if (!n.b(this.lessonId, object.lessonId)) {
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
    public final String getLessonId() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final String getModuleId() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final String getVariationId() {
        return this.variationId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i8 += i13;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogProgramVariationDurationRequest(moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", lessonId=");
        stringBuilder.append(this.lessonId);
        stringBuilder.append(", variationId=");
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
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
        parcel.writeString(this.variationId);
        parcel.writeLong(this.dailyTrainingTimeGoalSec);
        parcel.writeLong(this.durationSec);
    }
}
