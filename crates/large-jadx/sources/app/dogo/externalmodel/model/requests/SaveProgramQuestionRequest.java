package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveProgramQuestionRequest;", "Landroid/os/Parcelable;", "questionId", "", "moduleId", "lessonId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getQuestionId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SaveProgramQuestionRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest> CREATOR;
    private final String lessonId;
    private final String moduleId;
    private final String questionId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            SaveProgramQuestionRequest saveProgramQuestionRequest = new SaveProgramQuestionRequest(parcel.readString(), parcel.readString(), parcel.readString());
            return saveProgramQuestionRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest[] newArray(int i) {
            return new SaveProgramQuestionRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SaveProgramQuestionRequest.Creator creator = new SaveProgramQuestionRequest.Creator();
        SaveProgramQuestionRequest.CREATOR = creator;
    }

    public SaveProgramQuestionRequest(String string, String string2, String string3) {
        n.f(string, "questionId");
        n.f(string2, "moduleId");
        n.f(string3, "lessonId");
        super();
        this.questionId = string;
        this.moduleId = string2;
        this.lessonId = string3;
    }

    public static app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest copy$default(app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest saveProgramQuestionRequest, String string2, String string3, String string4, int i5, Object object6) {
        String obj1;
        String obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = saveProgramQuestionRequest.questionId;
        }
        if (i5 & 2 != 0) {
            obj2 = saveProgramQuestionRequest.moduleId;
        }
        if (i5 &= 4 != 0) {
            obj3 = saveProgramQuestionRequest.lessonId;
        }
        return saveProgramQuestionRequest.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.questionId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest copy(String string, String string2, String string3) {
        n.f(string, "questionId");
        n.f(string2, "moduleId");
        n.f(string3, "lessonId");
        SaveProgramQuestionRequest saveProgramQuestionRequest = new SaveProgramQuestionRequest(string, string2, string3);
        return saveProgramQuestionRequest;
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
        if (object instanceof SaveProgramQuestionRequest == null) {
            return i2;
        }
        if (!n.b(this.questionId, object.questionId)) {
            return i2;
        }
        if (!n.b(this.moduleId, object.moduleId)) {
            return i2;
        }
        if (!n.b(this.lessonId, object.lessonId)) {
            return i2;
        }
        return i;
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
    public final String getQuestionId() {
        return this.questionId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SaveProgramQuestionRequest(questionId=");
        stringBuilder.append(this.questionId);
        stringBuilder.append(", moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", lessonId=");
        stringBuilder.append(this.lessonId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.questionId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
