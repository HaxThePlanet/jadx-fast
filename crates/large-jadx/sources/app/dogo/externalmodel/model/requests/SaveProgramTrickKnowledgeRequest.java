package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\r¨\u0006#", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveProgramTrickKnowledgeRequest;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "programId", "moduleId", "lessonId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKnowledge", "()I", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getProgramId", "getTrickId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SaveProgramTrickKnowledgeRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest> CREATOR;
    private final int knowledge;
    private final String lessonId;
    private final String moduleId;
    private final String programId;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
            return saveProgramTrickKnowledgeRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest[] newArray(int i) {
            return new SaveProgramTrickKnowledgeRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SaveProgramTrickKnowledgeRequest.Creator creator = new SaveProgramTrickKnowledgeRequest.Creator();
        SaveProgramTrickKnowledgeRequest.CREATOR = creator;
    }

    public SaveProgramTrickKnowledgeRequest(String string, int i2, String string3, String string4, String string5) {
        n.f(string, "trickId");
        n.f(string3, "programId");
        n.f(string4, "moduleId");
        n.f(string5, "lessonId");
        super();
        this.trickId = string;
        this.knowledge = i2;
        this.programId = string3;
        this.moduleId = string4;
        this.lessonId = string5;
    }

    public static app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest copy$default(app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest saveProgramTrickKnowledgeRequest, String string2, int i3, String string4, String string5, String string6, int i7, Object object8) {
        String obj4;
        int obj5;
        String obj6;
        String obj7;
        String obj8;
        if (i7 & 1 != 0) {
            obj4 = saveProgramTrickKnowledgeRequest.trickId;
        }
        if (i7 & 2 != 0) {
            obj5 = saveProgramTrickKnowledgeRequest.knowledge;
        }
        if (i7 & 4 != 0) {
            obj6 = saveProgramTrickKnowledgeRequest.programId;
        }
        if (i7 & 8 != 0) {
            obj7 = saveProgramTrickKnowledgeRequest.moduleId;
        }
        if (i7 & 16 != 0) {
            obj8 = saveProgramTrickKnowledgeRequest.lessonId;
        }
        return saveProgramTrickKnowledgeRequest.copy(obj4, obj5, obj6, obj7, obj8);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.knowledge;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest copy(String string, int i2, String string3, String string4, String string5) {
        n.f(string, "trickId");
        n.f(string3, "programId");
        n.f(string4, "moduleId");
        n.f(string5, "lessonId");
        super(string, i2, string3, string4, string5);
        return saveProgramTrickKnowledgeRequest;
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
        if (object instanceof SaveProgramTrickKnowledgeRequest == null) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (this.knowledge != object.knowledge) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
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
    public final int getKnowledge() {
        return this.knowledge;
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
    public final String getProgramId() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String getTrickId() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i8 += i13;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SaveProgramTrickKnowledgeRequest(trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", knowledge=");
        stringBuilder.append(this.knowledge);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
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
        parcel.writeString(this.trickId);
        parcel.writeInt(this.knowledge);
        parcel.writeString(this.programId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
