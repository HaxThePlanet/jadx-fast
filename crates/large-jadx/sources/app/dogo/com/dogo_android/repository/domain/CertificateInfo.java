package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: CertificateInfo.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "Landroid/os/Parcelable;", "programId", "", "certificateImageUrl", "certificatePdfUrl", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;)V", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "getProgramExamSummary", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "getProgramId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CertificateInfo implements Parcelable {

    public static final Parcelable.Creator<CertificateInfo> CREATOR = new CertificateInfo$Creator<>();
    private final String certificateImageUrl;
    private final String certificatePdfUrl;
    private final ProgramExamSummary programExamSummary;
    private final String programId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CertificateInfo> {
        @Override // android.os.Parcelable$Creator
        public final CertificateInfo createFromParcel(Parcel parcel) {
            app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i = 0;
            } else {
                Object fromParcel = ProgramExamSummary.CREATOR.createFromParcel(parcel);
            }
            CertificateInfo certificateInfo = new CertificateInfo(parcel.readString(), parcel.readString(), parcel.readString(), (ProgramExamSummary)programExamSummary);
            return certificateInfo;
        }

        @Override // android.os.Parcelable$Creator
        public final CertificateInfo[] newArray(int i) {
            return new CertificateInfo[i];
        }
    }
    public CertificateInfo(String str, String str2, String str3, ProgramExamSummary programExamSummary) {
        n.f(str, "programId");
        n.f(str2, "certificateImageUrl");
        n.f(str3, "certificatePdfUrl");
        super();
        this.programId = str;
        this.certificateImageUrl = str2;
        this.certificatePdfUrl = str3;
        this.programExamSummary = programExamSummary;
    }

    public final String getCertificateImageUrl() {
        return this.certificateImageUrl;
    }

    public final String getCertificatePdfUrl() {
        return this.certificatePdfUrl;
    }

    public final ProgramExamSummary getProgramExamSummary() {
        return this.programExamSummary;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public /* synthetic */ CertificateInfo(String str, String str2, String str3, ProgramExamSummary programExamSummary, int i, g gVar) {
        i = i & 8 != 0 ? 0 : i;
        this(str, str2, str3, programExamSummary);
    }


    public static /* synthetic */ CertificateInfo copy$default(CertificateInfo certificateInfo, String str, String str2, String str3, ProgramExamSummary programExamSummary, int i, Object object) {
        String programId2;
        String certificateImageUrl2;
        String certificatePdfUrl2;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return certificateInfo.copy(programId2, certificateImageUrl2, certificatePdfUrl2, programExamSummary2);
    }

    /* operator */ public final String component1() {
        return this.programId;
    }

    /* operator */ public final String component2() {
        return this.certificateImageUrl;
    }

    /* operator */ public final String component3() {
        return this.certificatePdfUrl;
    }

    /* operator */ public final ProgramExamSummary component4() {
        return this.programExamSummary;
    }

    public final CertificateInfo copy(String programId, String certificateImageUrl, String certificatePdfUrl, ProgramExamSummary programExamSummary) {
        n.f(programId, "programId");
        n.f(certificateImageUrl, "certificateImageUrl");
        n.f(certificatePdfUrl, "certificatePdfUrl");
        return new CertificateInfo(programId, certificateImageUrl, certificatePdfUrl, programExamSummary);
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
        if (!(other instanceof CertificateInfo)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (!n.b(this.certificateImageUrl, other.certificateImageUrl)) {
            return false;
        }
        if (!n.b(this.certificatePdfUrl, other.certificatePdfUrl)) {
            return false;
        }
        return !n.b(this.programExamSummary, other.programExamSummary) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.programExamSummary == null) {
            i = 0;
        } else {
            i = this.programExamSummary.hashCode();
        }
        return (this.programId.hashCode() * 31) + this.certificateImageUrl.hashCode() * 31 + this.certificatePdfUrl.hashCode() * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CertificateInfo(programId=";
        String str3 = ", certificateImageUrl=";
        String str4 = ", certificatePdfUrl=";
        String str5 = ", programExamSummary=";
        str = str2 + this.programId + str3 + this.certificateImageUrl + str4 + this.certificatePdfUrl + str5 + this.programExamSummary + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeString(this.certificateImageUrl);
        parcel.writeString(this.certificatePdfUrl);
        if (this.programExamSummary == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.programExamSummary.writeToParcel(parcel, flags);
        }
    }
}
