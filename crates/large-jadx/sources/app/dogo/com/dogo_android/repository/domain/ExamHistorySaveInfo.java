package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ExamHistorySaveInfo.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "Landroid/os/Parcelable;", "dogId", "", "programId", "trickId", "examId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getExamId", "getProgramId", "getTrickId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ExamHistorySaveInfo implements Parcelable {

    public static final Parcelable.Creator<ExamHistorySaveInfo> CREATOR = new ExamHistorySaveInfo$Creator<>();
    private final String dogId;
    private final String examId;
    private final String programId;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamHistorySaveInfo> {
        @Override // android.os.Parcelable$Creator
        public final ExamHistorySaveInfo createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ExamHistorySaveInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final ExamHistorySaveInfo[] newArray(int i) {
            return new ExamHistorySaveInfo[i];
        }
    }
    public ExamHistorySaveInfo(String str, String str2, String str3, String str4) {
        n.f(str, "dogId");
        n.f(str2, "programId");
        n.f(str3, "trickId");
        n.f(str4, "examId");
        super();
        this.dogId = str;
        this.programId = str2;
        this.trickId = str3;
        this.examId = str4;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getExamId() {
        return this.examId;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final String getTrickId() {
        return this.trickId;
    }


    public static /* synthetic */ ExamHistorySaveInfo copy$default(ExamHistorySaveInfo examHistorySaveInfo, String str, String str2, String str3, String str4, int i, Object object) {
        String dogId2;
        String programId2;
        String trickId2;
        String examId2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return examHistorySaveInfo.copy(dogId2, programId2, trickId2, examId2);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final String component2() {
        return this.programId;
    }

    /* operator */ public final String component3() {
        return this.trickId;
    }

    /* operator */ public final String component4() {
        return this.examId;
    }

    public final ExamHistorySaveInfo copy(String dogId, String programId, String trickId, String examId) {
        n.f(dogId, "dogId");
        n.f(programId, "programId");
        n.f(trickId, "trickId");
        n.f(examId, "examId");
        return new ExamHistorySaveInfo(dogId, programId, trickId, examId);
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
        if (!(other instanceof ExamHistorySaveInfo)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        return !n.b(this.examId, other.examId) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.dogId.hashCode() * 31) + this.programId.hashCode() * 31 + this.trickId.hashCode() * 31 + this.examId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ExamHistorySaveInfo(dogId=";
        String str3 = ", programId=";
        String str4 = ", trickId=";
        String str5 = ", examId=";
        str = str2 + this.dogId + str3 + this.programId + str4 + this.trickId + str5 + this.examId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeString(this.programId);
        parcel.writeString(this.trickId);
        parcel.writeString(this.examId);
    }
}
