package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramExamSummary.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003Jx\u0010*\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010+J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\u0013\u0010-\u001a\u00020\u001f2\u0008\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\tHÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0011R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0015R\u0011\u0010\u000c\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "Landroid/os/Parcelable;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "allExamsCount", "", "passedExamsCount", "activeExamsCount", "cardBackgroundColor", "", "certificateLaurelsImage", "certificatePaperImage", "certificatePlaceholderUrl", "programName", "certificateRequirements", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActiveExamsCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAllExamsCount", "getCardBackgroundColor", "()Ljava/lang/String;", "getCertificateLaurelsImage", "getCertificatePaperImage", "getCertificatePlaceholderUrl", "getCertificateRequirements", "getPassedExamsCount", "getProgramName", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "allExamsCompleted", "", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramExamSummary implements Parcelable {

    public static final Parcelable.Creator<ProgramExamSummary> CREATOR = new ProgramExamSummary$Creator<>();
    private final Integer activeExamsCount;
    private final Integer allExamsCount;
    private final String cardBackgroundColor;
    private final String certificateLaurelsImage;
    private final String certificatePaperImage;
    private final String certificatePlaceholderUrl;
    private final String certificateRequirements;
    private final Integer passedExamsCount;
    private final String programName;
    private final ProgramSaveInfo programSaveInfo;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramExamSummary> {
        @Override // android.os.Parcelable$Creator
        public final ProgramExamSummary createFromParcel(Parcel parcel) {
            Integer num;
            Integer num2;
            int i;
            n.f(parcel, "parcel");
            i = 0;
            if (parcel.readInt() == 0) {
            } else {
            }
            if (parcel.readInt() == 0) {
            } else {
            }
            if (parcel.readInt() == 0) {
            } else {
            }
            ProgramExamSummary programExamSummary = new ProgramExamSummary((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), num, num2, i, string, string2, string3, string4, string5, parcel2);
            return programExamSummary;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramExamSummary[] newArray(int i) {
            return new ProgramExamSummary[i];
        }
    }
    public ProgramExamSummary(ProgramSaveInfo programSaveInfo, Integer integer, Integer integer2, Integer integer3, String str, String str2, String str3, String str4, String str5, String str6) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(str, "cardBackgroundColor");
        n.f(str2, "certificateLaurelsImage");
        n.f(str3, "certificatePaperImage");
        n.f(str4, "certificatePlaceholderUrl");
        n.f(str5, "programName");
        n.f(str6, "certificateRequirements");
        super();
        this.programSaveInfo = programSaveInfo;
        this.allExamsCount = integer;
        this.passedExamsCount = integer2;
        this.activeExamsCount = integer3;
        this.cardBackgroundColor = str;
        this.certificateLaurelsImage = str2;
        this.certificatePaperImage = str3;
        this.certificatePlaceholderUrl = str4;
        this.programName = str5;
        this.certificateRequirements = str6;
    }

    public final boolean allExamsCompleted() {
        return n.b(this.allExamsCount, this.passedExamsCount);
    }

    public final Integer getActiveExamsCount() {
        return this.activeExamsCount;
    }

    public final Integer getAllExamsCount() {
        return this.allExamsCount;
    }

    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    public final String getCertificateLaurelsImage() {
        return this.certificateLaurelsImage;
    }

    public final String getCertificatePaperImage() {
        return this.certificatePaperImage;
    }

    public final String getCertificatePlaceholderUrl() {
        return this.certificatePlaceholderUrl;
    }

    public final String getCertificateRequirements() {
        return this.certificateRequirements;
    }

    public final Integer getPassedExamsCount() {
        return this.passedExamsCount;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    public /* synthetic */ ProgramExamSummary(ProgramSaveInfo programSaveInfo, Integer integer, Integer integer2, Integer integer3, String str, String str2, String str3, String str4, String str5, String str6, int i, g gVar) {
        int integer22;
        String str52;
        int i112 = i;
        integer22 = 0;
        int r1 = i112 & 2 != 0 ? integer22 : integer;
        int r3 = i112 & 4 != 0 ? integer22 : integer2;
        if (i112 & 8 == 0) {
            integer22 = integer3;
        }
        str52 = "";
        String r4 = i112 & 16 != 0 ? str52 : str;
        String r6 = i112 & 32 != 0 ? str52 : str2;
        String r7 = i112 & 64 != 0 ? str52 : str3;
        String r8 = i112 & 128 != 0 ? str52 : str4;
        String r9 = i112 & 256 != 0 ? str52 : str5;
        if (i112 & 512 == 0) {
            str52 = str6;
        }
        this(programSaveInfo, integer22, integer22, integer22, str52, str52, str52, str52, str52, str52);
    }


    public static /* synthetic */ ProgramExamSummary copy$default(ProgramExamSummary programExamSummary, ProgramSaveInfo programSaveInfo, Integer integer, Integer integer2, Integer integer3, String str, String str2, String str3, String str4, String str5, String str6, int i, Object object) {
        String str112;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo22;
        Integer integer32;
        Integer integer42;
        Integer integer52;
        String str62;
        String str72;
        String str82;
        String str92;
        String str102;
        Object programExamSummary2 = programExamSummary;
        int i122 = i;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo r2 = i122 & 1 != 0 ? programExamSummary2.programSaveInfo : programSaveInfo;
        Integer r3 = i122 & 2 != 0 ? programExamSummary2.allExamsCount : integer;
        Integer r4 = i122 & 4 != 0 ? programExamSummary2.passedExamsCount : integer2;
        Integer r5 = i122 & 8 != 0 ? programExamSummary2.activeExamsCount : integer3;
        String r6 = i122 & 16 != 0 ? programExamSummary2.cardBackgroundColor : str;
        String r7 = i122 & 32 != 0 ? programExamSummary2.certificateLaurelsImage : str2;
        String r8 = i122 & 64 != 0 ? programExamSummary2.certificatePaperImage : str3;
        String r9 = i122 & 128 != 0 ? programExamSummary2.certificatePlaceholderUrl : str4;
        String r10 = i122 & 256 != 0 ? programExamSummary2.programName : str5;
        String r1 = i122 & 512 != 0 ? programExamSummary2.certificateRequirements : str6;
        return programExamSummary.copy(programSaveInfo22, integer32, integer42, integer52, str62, str72, str82, str92, str102, (i122 & 512 != 0 ? programExamSummary2.certificateRequirements : str6));
    }

    /* operator */ public final ProgramSaveInfo component1() {
        return this.programSaveInfo;
    }

    /* operator */ public final String component10() {
        return this.certificateRequirements;
    }

    /* operator */ public final Integer component2() {
        return this.allExamsCount;
    }

    /* operator */ public final Integer component3() {
        return this.passedExamsCount;
    }

    /* operator */ public final Integer component4() {
        return this.activeExamsCount;
    }

    /* operator */ public final String component5() {
        return this.cardBackgroundColor;
    }

    /* operator */ public final String component6() {
        return this.certificateLaurelsImage;
    }

    /* operator */ public final String component7() {
        return this.certificatePaperImage;
    }

    /* operator */ public final String component8() {
        return this.certificatePlaceholderUrl;
    }

    /* operator */ public final String component9() {
        return this.programName;
    }

    public final ProgramExamSummary copy(ProgramSaveInfo programSaveInfo, Integer allExamsCount, Integer passedExamsCount, Integer activeExamsCount, String cardBackgroundColor, String certificateLaurelsImage, String certificatePaperImage, String certificatePlaceholderUrl, String programName, String certificateRequirements) {
        n.f(programSaveInfo, "programSaveInfo");
        final Object cardBackgroundColor2 = cardBackgroundColor;
        n.f(cardBackgroundColor2, "cardBackgroundColor");
        final Object certificateLaurelsImage2 = certificateLaurelsImage;
        n.f(certificateLaurelsImage2, "certificateLaurelsImage");
        final Object certificatePaperImage2 = certificatePaperImage;
        n.f(certificatePaperImage2, "certificatePaperImage");
        final Object certificatePlaceholderUrl2 = certificatePlaceholderUrl;
        n.f(certificatePlaceholderUrl2, "certificatePlaceholderUrl");
        final Object programName2 = programName;
        n.f(programName2, "programName");
        final Object certificateRequirements2 = certificateRequirements;
        n.f(certificateRequirements2, "certificateRequirements");
        ProgramExamSummary programExamSummary = new ProgramExamSummary(programSaveInfo, allExamsCount, passedExamsCount, activeExamsCount, cardBackgroundColor2, certificateLaurelsImage2, certificatePaperImage2, certificatePlaceholderUrl2, programName2, certificateRequirements2);
        return programExamSummary;
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
        final boolean z12 = false;
        if (!(other instanceof ProgramExamSummary)) {
            return false;
        }
        if (!n.b(this.programSaveInfo, other.programSaveInfo)) {
            return false;
        }
        if (!n.b(this.allExamsCount, other.allExamsCount)) {
            return false;
        }
        if (!n.b(this.passedExamsCount, other.passedExamsCount)) {
            return false;
        }
        if (!n.b(this.activeExamsCount, other.activeExamsCount)) {
            return false;
        }
        if (!n.b(this.cardBackgroundColor, other.cardBackgroundColor)) {
            return false;
        }
        if (!n.b(this.certificateLaurelsImage, other.certificateLaurelsImage)) {
            return false;
        }
        if (!n.b(this.certificatePaperImage, other.certificatePaperImage)) {
            return false;
        }
        if (!n.b(this.certificatePlaceholderUrl, other.certificatePlaceholderUrl)) {
            return false;
        }
        if (!n.b(this.programName, other.programName)) {
            return false;
        }
        return !n.b(this.certificateRequirements, other.certificateRequirements) ? z12 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.allExamsCount == null) {
        } else {
            i = this.allExamsCount.hashCode();
        }
        if (this.passedExamsCount == null) {
        } else {
            i = this.passedExamsCount.hashCode();
        }
        if (this.activeExamsCount != null) {
            i = this.activeExamsCount.hashCode();
        }
        return (this.programSaveInfo.hashCode() * 31) + i * 31 + i * 31 + i * 31 + this.cardBackgroundColor.hashCode() * 31 + this.certificateLaurelsImage.hashCode() * 31 + this.certificatePaperImage.hashCode() * 31 + this.certificatePlaceholderUrl.hashCode() * 31 + this.programName.hashCode() * 31 + this.certificateRequirements.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramExamSummary(programSaveInfo=";
        String str3 = ", allExamsCount=";
        String str4 = ", passedExamsCount=";
        String str5 = ", activeExamsCount=";
        String str6 = ", cardBackgroundColor=";
        String str7 = ", certificateLaurelsImage=";
        String str8 = ", certificatePaperImage=";
        String str9 = ", certificatePlaceholderUrl=";
        String str10 = ", programName=";
        String str11 = ", certificateRequirements=";
        str = str2 + this.programSaveInfo + str3 + this.allExamsCount + str4 + this.passedExamsCount + str5 + this.activeExamsCount + str6 + this.cardBackgroundColor + str7 + this.certificateLaurelsImage + str8 + this.certificatePaperImage + str9 + this.certificatePlaceholderUrl + str10 + this.programName + str11 + this.certificateRequirements + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.programSaveInfo.writeToParcel(parcel, flags);
        int i = 0;
        final int i2 = 1;
        if (this.allExamsCount == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.allExamsCount.intValue());
        }
        if (this.passedExamsCount == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.passedExamsCount.intValue());
        }
        if (this.activeExamsCount == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.activeExamsCount.intValue());
        }
        parcel.writeString(this.cardBackgroundColor);
        parcel.writeString(this.certificateLaurelsImage);
        parcel.writeString(this.certificatePaperImage);
        parcel.writeString(this.certificatePlaceholderUrl);
        parcel.writeString(this.programName);
        parcel.writeString(this.certificateRequirements);
    }
}
