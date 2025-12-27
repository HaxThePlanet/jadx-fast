package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SaveProgramTrickKnowledgeRequest.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\r¨\u0006#", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveProgramTrickKnowledgeRequest;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "programId", "moduleId", "lessonId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKnowledge", "()I", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getProgramId", "getTrickId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SaveProgramTrickKnowledgeRequest implements Parcelable {

    public static final Parcelable.Creator<SaveProgramTrickKnowledgeRequest> CREATOR = new SaveProgramTrickKnowledgeRequest$Creator<>();
    private final int knowledge;
    private final String lessonId;
    private final String moduleId;
    private final String programId;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SaveProgramTrickKnowledgeRequest> {
        @Override // android.os.Parcelable$Creator
        public final SaveProgramTrickKnowledgeRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            SaveProgramTrickKnowledgeRequest saveProgramTrickKnowledgeRequest = new SaveProgramTrickKnowledgeRequest(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
            return saveProgramTrickKnowledgeRequest;
        }

        @Override // android.os.Parcelable$Creator
        public final SaveProgramTrickKnowledgeRequest[] newArray(int i) {
            return new SaveProgramTrickKnowledgeRequest[i];
        }
    }
    public SaveProgramTrickKnowledgeRequest(String str, int i, String str2, String str3, String str4) {
        n.f(str, "trickId");
        n.f(str2, "programId");
        n.f(str3, "moduleId");
        n.f(str4, "lessonId");
        super();
        this.trickId = str;
        this.knowledge = i;
        this.programId = str2;
        this.moduleId = str3;
        this.lessonId = str4;
    }

    public final int getKnowledge() {
        return this.knowledge;
    }

    public final String getLessonId() {
        return this.lessonId;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final String getTrickId() {
        return this.trickId;
    }


    public static /* synthetic */ SaveProgramTrickKnowledgeRequest copy$default(SaveProgramTrickKnowledgeRequest saveProgramTrickKnowledgeRequest, String str, int i, String str2, String str3, String str4, int i2, Object object) {
        String str22;
        int object82;
        String str42;
        String str52;
        String str62;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        if (i2 & 8 != 0) {
        }
        if (i2 & 16 != 0) {
        }
        return saveProgramTrickKnowledgeRequest.copy(str22, object82, str42, str52, str62);
    }

    /* operator */ public final String component1() {
        return this.trickId;
    }

    /* operator */ public final int component2() {
        return this.knowledge;
    }

    /* operator */ public final String component3() {
        return this.programId;
    }

    /* operator */ public final String component4() {
        return this.moduleId;
    }

    /* operator */ public final String component5() {
        return this.lessonId;
    }

    public final SaveProgramTrickKnowledgeRequest copy(String trickId, int knowledge, String programId, String moduleId, String lessonId) {
        n.f(trickId, "trickId");
        n.f(programId, "programId");
        n.f(moduleId, "moduleId");
        n.f(lessonId, "lessonId");
        SaveProgramTrickKnowledgeRequest saveProgramTrickKnowledgeRequest = new SaveProgramTrickKnowledgeRequest(trickId, knowledge, programId, moduleId, lessonId);
        return saveProgramTrickKnowledgeRequest;
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
        if (!(other instanceof SaveProgramTrickKnowledgeRequest)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        if (this.knowledge != other.knowledge) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        return !n.b(this.lessonId, other.lessonId) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.trickId.hashCode() * 31) + Integer.hashCode(this.knowledge) * 31 + this.programId.hashCode() * 31 + this.moduleId.hashCode() * 31 + this.lessonId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SaveProgramTrickKnowledgeRequest(trickId=";
        String str3 = ", knowledge=";
        String str4 = ", programId=";
        String str5 = ", moduleId=";
        String str6 = ", lessonId=";
        str = str2 + this.trickId + str3 + this.knowledge + str4 + this.programId + str5 + this.moduleId + str6 + this.lessonId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.trickId);
        parcel.writeInt(this.knowledge);
        parcel.writeString(this.programId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
