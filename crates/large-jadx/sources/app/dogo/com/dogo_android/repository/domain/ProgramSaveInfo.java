package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ProgramSaveInfo.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "Landroid/os/Parcelable;", "programId", "", "moduleId", "lessonId", "dogId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getLessonId", "getModuleId", "getProgramId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramSaveInfo implements Parcelable {

    public static final Parcelable.Creator<ProgramSaveInfo> CREATOR = new ProgramSaveInfo$Creator<>();
    private final String dogId;
    private final String lessonId;
    private final String moduleId;
    private final String programId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramSaveInfo> {
        @Override // android.os.Parcelable$Creator
        public final ProgramSaveInfo createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ProgramSaveInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramSaveInfo[] newArray(int i) {
            return new ProgramSaveInfo[i];
        }
    }
    public ProgramSaveInfo(String str, String str2, String str3, String str4) {
        n.f(str, "programId");
        n.f(str2, "moduleId");
        n.f(str3, "lessonId");
        n.f(str4, "dogId");
        super();
        this.programId = str;
        this.moduleId = str2;
        this.lessonId = str3;
        this.dogId = str4;
    }

    public final String getDogId() {
        return this.dogId;
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


    public static /* synthetic */ ProgramSaveInfo copy$default(ProgramSaveInfo programSaveInfo, String str, String str2, String str3, String str4, int i, Object object) {
        String programId2;
        String moduleId2;
        String lessonId2;
        String dogId2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return programSaveInfo.copy(programId2, moduleId2, lessonId2, dogId2);
    }

    /* operator */ public final String component1() {
        return this.programId;
    }

    /* operator */ public final String component2() {
        return this.moduleId;
    }

    /* operator */ public final String component3() {
        return this.lessonId;
    }

    /* operator */ public final String component4() {
        return this.dogId;
    }

    public final ProgramSaveInfo copy(String programId, String moduleId, String lessonId, String dogId) {
        n.f(programId, "programId");
        n.f(moduleId, "moduleId");
        n.f(lessonId, "lessonId");
        n.f(dogId, "dogId");
        return new ProgramSaveInfo(programId, moduleId, lessonId, dogId);
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
        if (!(other instanceof ProgramSaveInfo)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        if (!n.b(this.lessonId, other.lessonId)) {
            return false;
        }
        return !n.b(this.dogId, other.dogId) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.programId.hashCode() * 31) + this.moduleId.hashCode() * 31 + this.lessonId.hashCode() * 31 + this.dogId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramSaveInfo(programId=";
        String str3 = ", moduleId=";
        String str4 = ", lessonId=";
        String str5 = ", dogId=";
        str = str2 + this.programId + str3 + this.moduleId + str4 + this.lessonId + str5 + this.dogId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
        parcel.writeString(this.dogId);
    }
}
