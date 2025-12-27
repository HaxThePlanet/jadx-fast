package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SaveProgramQuestionRequest.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveProgramQuestionRequest;", "Landroid/os/Parcelable;", "questionId", "", "moduleId", "lessonId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getQuestionId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SaveProgramQuestionRequest implements Parcelable {

    public static final Parcelable.Creator<SaveProgramQuestionRequest> CREATOR = new SaveProgramQuestionRequest$Creator<>();
    private final String lessonId;
    private final String moduleId;
    private final String questionId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SaveProgramQuestionRequest> {
        @Override // android.os.Parcelable$Creator
        public final SaveProgramQuestionRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new SaveProgramQuestionRequest(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final SaveProgramQuestionRequest[] newArray(int i) {
            return new SaveProgramQuestionRequest[i];
        }
    }
    public SaveProgramQuestionRequest(String str, String str2, String str3) {
        n.f(str, "questionId");
        n.f(str2, "moduleId");
        n.f(str3, "lessonId");
        super();
        this.questionId = str;
        this.moduleId = str2;
        this.lessonId = str3;
    }

    public final String getLessonId() {
        return this.lessonId;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getQuestionId() {
        return this.questionId;
    }


    public static /* synthetic */ SaveProgramQuestionRequest copy$default(SaveProgramQuestionRequest saveProgramQuestionRequest, String str, String str2, String str3, int i, Object object) {
        String questionId2;
        String moduleId2;
        String lessonId2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return saveProgramQuestionRequest.copy(questionId2, moduleId2, lessonId2);
    }

    /* operator */ public final String component1() {
        return this.questionId;
    }

    /* operator */ public final String component2() {
        return this.moduleId;
    }

    /* operator */ public final String component3() {
        return this.lessonId;
    }

    public final SaveProgramQuestionRequest copy(String questionId, String moduleId, String lessonId) {
        n.f(questionId, "questionId");
        n.f(moduleId, "moduleId");
        n.f(lessonId, "lessonId");
        return new SaveProgramQuestionRequest(questionId, moduleId, lessonId);
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
        if (!(other instanceof SaveProgramQuestionRequest)) {
            return false;
        }
        if (!n.b(this.questionId, other.questionId)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        return !n.b(this.lessonId, other.lessonId) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.questionId.hashCode() * 31) + this.moduleId.hashCode() * 31 + this.lessonId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SaveProgramQuestionRequest(questionId=";
        String str3 = ", moduleId=";
        String str4 = ", lessonId=";
        str = str2 + this.questionId + str3 + this.moduleId + str4 + this.lessonId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.questionId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
