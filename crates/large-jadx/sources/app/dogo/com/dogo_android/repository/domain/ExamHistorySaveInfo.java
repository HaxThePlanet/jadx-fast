package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "Landroid/os/Parcelable;", "dogId", "", "programId", "trickId", "examId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getExamId", "getProgramId", "getTrickId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExamHistorySaveInfo implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo> CREATOR;
    private final String dogId;
    private final String examId;
    private final String programId;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            ExamHistorySaveInfo examHistorySaveInfo = new ExamHistorySaveInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            return examHistorySaveInfo;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo[] newArray(int i) {
            return new ExamHistorySaveInfo[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ExamHistorySaveInfo.Creator creator = new ExamHistorySaveInfo.Creator();
        ExamHistorySaveInfo.CREATOR = creator;
    }

    public ExamHistorySaveInfo(String string, String string2, String string3, String string4) {
        n.f(string, "dogId");
        n.f(string2, "programId");
        n.f(string3, "trickId");
        n.f(string4, "examId");
        super();
        this.dogId = string;
        this.programId = string2;
        this.trickId = string3;
        this.examId = string4;
    }

    public static app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo copy$default(app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo examHistorySaveInfo, String string2, String string3, String string4, String string5, int i6, Object object7) {
        String obj1;
        String obj2;
        String obj3;
        String obj4;
        if (i6 & 1 != 0) {
            obj1 = examHistorySaveInfo.dogId;
        }
        if (i6 & 2 != 0) {
            obj2 = examHistorySaveInfo.programId;
        }
        if (i6 & 4 != 0) {
            obj3 = examHistorySaveInfo.trickId;
        }
        if (i6 &= 8 != 0) {
            obj4 = examHistorySaveInfo.examId;
        }
        return examHistorySaveInfo.copy(obj1, obj2, obj3, obj4);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.examId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo copy(String string, String string2, String string3, String string4) {
        n.f(string, "dogId");
        n.f(string2, "programId");
        n.f(string3, "trickId");
        n.f(string4, "examId");
        ExamHistorySaveInfo examHistorySaveInfo = new ExamHistorySaveInfo(string, string2, string3, string4);
        return examHistorySaveInfo;
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
        if (!object instanceof ExamHistorySaveInfo) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (!n.b(this.examId, object.examId)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final String getExamId() {
        return this.examId;
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
        return i6 += i10;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExamHistorySaveInfo(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", examId=");
        stringBuilder.append(this.examId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeString(this.programId);
        parcel.writeString(this.trickId);
        parcel.writeString(this.examId);
    }
}
