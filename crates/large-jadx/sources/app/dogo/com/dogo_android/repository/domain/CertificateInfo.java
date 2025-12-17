package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "Landroid/os/Parcelable;", "programId", "", "certificateImageUrl", "certificatePdfUrl", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;)V", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "getProgramExamSummary", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "getProgramId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CertificateInfo implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.CertificateInfo> CREATOR;
    private final String certificateImageUrl;
    private final String certificatePdfUrl;
    private final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary;
    private final String programId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.CertificateInfo> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.CertificateInfo createFromParcel(Parcel parcel) {
            int cREATOR;
            int obj6;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                obj6 = 0;
            } else {
                obj6 = ProgramExamSummary.CREATOR.createFromParcel(parcel);
            }
            CertificateInfo certificateInfo = new CertificateInfo(parcel.readString(), parcel.readString(), parcel.readString(), (ProgramExamSummary)obj6);
            return certificateInfo;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.CertificateInfo[] newArray(int i) {
            return new CertificateInfo[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        CertificateInfo.Creator creator = new CertificateInfo.Creator();
        CertificateInfo.CREATOR = creator;
    }

    public CertificateInfo(String string, String string2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary4) {
        n.f(string, "programId");
        n.f(string2, "certificateImageUrl");
        n.f(string3, "certificatePdfUrl");
        super();
        this.programId = string;
        this.certificateImageUrl = string2;
        this.certificatePdfUrl = string3;
        this.programExamSummary = programExamSummary4;
    }

    public CertificateInfo(String string, String string2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary4, int i5, g g6) {
        int obj4;
        obj4 = i5 &= 8 != 0 ? 0 : obj4;
        super(string, string2, string3, obj4);
    }

    public static app.dogo.com.dogo_android.repository.domain.CertificateInfo copy$default(app.dogo.com.dogo_android.repository.domain.CertificateInfo certificateInfo, String string2, String string3, String string4, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary5, int i6, Object object7) {
        String obj1;
        String obj2;
        String obj3;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary obj4;
        if (i6 & 1 != 0) {
            obj1 = certificateInfo.programId;
        }
        if (i6 & 2 != 0) {
            obj2 = certificateInfo.certificateImageUrl;
        }
        if (i6 & 4 != 0) {
            obj3 = certificateInfo.certificatePdfUrl;
        }
        if (i6 &= 8 != 0) {
            obj4 = certificateInfo.programExamSummary;
        }
        return certificateInfo.copy(obj1, obj2, obj3, obj4);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.certificateImageUrl;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.certificatePdfUrl;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary component4() {
        return this.programExamSummary;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.CertificateInfo copy(String string, String string2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary4) {
        n.f(string, "programId");
        n.f(string2, "certificateImageUrl");
        n.f(string3, "certificatePdfUrl");
        CertificateInfo certificateInfo = new CertificateInfo(string, string2, string3, programExamSummary4);
        return certificateInfo;
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
        if (!object instanceof CertificateInfo) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (!n.b(this.certificateImageUrl, object.certificateImageUrl)) {
            return i2;
        }
        if (!n.b(this.certificatePdfUrl, object.certificatePdfUrl)) {
            return i2;
        }
        if (!n.b(this.programExamSummary, object.programExamSummary)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getCertificateImageUrl() {
        return this.certificateImageUrl;
    }

    @Override // android.os.Parcelable
    public final String getCertificatePdfUrl() {
        return this.certificatePdfUrl;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary getProgramExamSummary() {
        return this.programExamSummary;
    }

    @Override // android.os.Parcelable
    public final String getProgramId() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = this.programExamSummary;
        if (programExamSummary == null) {
            i = 0;
        } else {
            i = programExamSummary.hashCode();
        }
        return i7 += i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CertificateInfo(programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", certificateImageUrl=");
        stringBuilder.append(this.certificateImageUrl);
        stringBuilder.append(", certificatePdfUrl=");
        stringBuilder.append(this.certificatePdfUrl);
        stringBuilder.append(", programExamSummary=");
        stringBuilder.append(this.programExamSummary);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeString(this.certificateImageUrl);
        parcel.writeString(this.certificatePdfUrl);
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = this.programExamSummary;
        if (programExamSummary == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            programExamSummary.writeToParcel(parcel, i2);
        }
    }
}
