package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003Jx\u0010*\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010+J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\u0013\u0010-\u001a\u00020\u001f2\u0008\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\tHÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0011R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0015R\u0011\u0010\u000c\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "Landroid/os/Parcelable;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "allExamsCount", "", "passedExamsCount", "activeExamsCount", "cardBackgroundColor", "", "certificateLaurelsImage", "certificatePaperImage", "certificatePlaceholderUrl", "programName", "certificateRequirements", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActiveExamsCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAllExamsCount", "getCardBackgroundColor", "()Ljava/lang/String;", "getCertificateLaurelsImage", "getCertificatePaperImage", "getCertificatePlaceholderUrl", "getCertificateRequirements", "getPassedExamsCount", "getProgramName", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "allExamsCompleted", "", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramExamSummary implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramExamSummary> CREATOR;
    private final Integer activeExamsCount;
    private final Integer allExamsCount;
    private final String cardBackgroundColor;
    private final String certificateLaurelsImage;
    private final String certificatePaperImage;
    private final String certificatePlaceholderUrl;
    private final String certificateRequirements;
    private final Integer passedExamsCount;
    private final String programName;
    private final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramExamSummary> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary createFromParcel(Parcel parcel) {
            Integer valueOf3;
            Integer valueOf2;
            int valueOf;
            Integer num;
            Integer num2;
            int i;
            n.f(parcel, "parcel");
            int i2 = 0;
            if (parcel.readInt() == 0) {
                num = i2;
            } else {
                num = valueOf3;
            }
            if (parcel.readInt() == 0) {
                num2 = i2;
            } else {
                num2 = valueOf2;
            }
            if (parcel.readInt() == 0) {
                i = i2;
            } else {
                i = valueOf;
            }
            super((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), num, num2, i, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            return programExamSummary;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary[] newArray(int i) {
            return new ProgramExamSummary[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ProgramExamSummary.Creator creator = new ProgramExamSummary.Creator();
        ProgramExamSummary.CREATOR = creator;
    }

    public ProgramExamSummary(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, Integer integer2, Integer integer3, Integer integer4, String string5, String string6, String string7, String string8, String string9, String string10) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string5, "cardBackgroundColor");
        n.f(string6, "certificateLaurelsImage");
        n.f(string7, "certificatePaperImage");
        n.f(string8, "certificatePlaceholderUrl");
        n.f(string9, "programName");
        n.f(string10, "certificateRequirements");
        super();
        this.programSaveInfo = programSaveInfo;
        this.allExamsCount = integer2;
        this.passedExamsCount = integer3;
        this.activeExamsCount = integer4;
        this.cardBackgroundColor = string5;
        this.certificateLaurelsImage = string6;
        this.certificatePaperImage = string7;
        this.certificatePlaceholderUrl = string8;
        this.programName = string9;
        this.certificateRequirements = string10;
    }

    public ProgramExamSummary(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, Integer integer2, Integer integer3, Integer integer4, String string5, String string6, String string7, String string8, String string9, String string10, int i11, g g12) {
        int i;
        int i3;
        int i2;
        String str4;
        String str3;
        String str2;
        String str5;
        String str6;
        String str;
        int i4 = i11;
        i3 = 0;
        i = i4 & 2 != 0 ? i3 : integer2;
        i2 = i4 & 4 != 0 ? i3 : integer3;
        if (i4 & 8 != 0) {
        } else {
            i3 = integer4;
        }
        str3 = "";
        str4 = i4 & 16 != 0 ? str3 : string5;
        str2 = i4 & 32 != 0 ? str3 : string6;
        str5 = i4 & 64 != 0 ? str3 : string7;
        str6 = i4 & 128 != 0 ? str3 : string8;
        str = i4 & 256 != 0 ? str3 : string9;
        if (i4 &= 512 != 0) {
        } else {
            str3 = string10;
        }
        super(programSaveInfo, i, i2, i3, str4, str2, str5, str6, str, str3);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramExamSummary copy$default(app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary, app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo2, Integer integer3, Integer integer4, Integer integer5, String string6, String string7, String string8, String string9, String string10, String string11, int i12, Object object13) {
        String certificateRequirements;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
        Integer allExamsCount;
        Integer passedExamsCount;
        Integer activeExamsCount;
        String cardBackgroundColor;
        String certificateLaurelsImage;
        String certificatePaperImage;
        String certificatePlaceholderUrl;
        String programName;
        Object obj = programExamSummary;
        int i = i12;
        programSaveInfo = i & 1 != 0 ? obj.programSaveInfo : programSaveInfo2;
        allExamsCount = i & 2 != 0 ? obj.allExamsCount : integer3;
        passedExamsCount = i & 4 != 0 ? obj.passedExamsCount : integer4;
        activeExamsCount = i & 8 != 0 ? obj.activeExamsCount : integer5;
        cardBackgroundColor = i & 16 != 0 ? obj.cardBackgroundColor : string6;
        certificateLaurelsImage = i & 32 != 0 ? obj.certificateLaurelsImage : string7;
        certificatePaperImage = i & 64 != 0 ? obj.certificatePaperImage : string8;
        certificatePlaceholderUrl = i & 128 != 0 ? obj.certificatePlaceholderUrl : string9;
        programName = i & 256 != 0 ? obj.programName : string10;
        certificateRequirements = i &= 512 != 0 ? obj.certificateRequirements : string11;
        return programExamSummary.copy(programSaveInfo, allExamsCount, passedExamsCount, activeExamsCount, cardBackgroundColor, certificateLaurelsImage, certificatePaperImage, certificatePlaceholderUrl, programName, certificateRequirements);
    }

    @Override // android.os.Parcelable
    public final boolean allExamsCompleted() {
        return n.b(this.allExamsCount, this.passedExamsCount);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo component1() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public final String component10() {
        return this.certificateRequirements;
    }

    @Override // android.os.Parcelable
    public final Integer component2() {
        return this.allExamsCount;
    }

    @Override // android.os.Parcelable
    public final Integer component3() {
        return this.passedExamsCount;
    }

    @Override // android.os.Parcelable
    public final Integer component4() {
        return this.activeExamsCount;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.cardBackgroundColor;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.certificateLaurelsImage;
    }

    @Override // android.os.Parcelable
    public final String component7() {
        return this.certificatePaperImage;
    }

    @Override // android.os.Parcelable
    public final String component8() {
        return this.certificatePlaceholderUrl;
    }

    @Override // android.os.Parcelable
    public final String component9() {
        return this.programName;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary copy(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, Integer integer2, Integer integer3, Integer integer4, String string5, String string6, String string7, String string8, String string9, String string10) {
        n.f(programSaveInfo, "programSaveInfo");
        final Object obj = string5;
        n.f(obj, "cardBackgroundColor");
        final Object obj2 = string6;
        n.f(obj2, "certificateLaurelsImage");
        final Object obj3 = string7;
        n.f(obj3, "certificatePaperImage");
        final Object obj4 = string8;
        n.f(obj4, "certificatePlaceholderUrl");
        final Object obj5 = string9;
        n.f(obj5, "programName");
        final Object obj6 = string10;
        n.f(obj6, "certificateRequirements");
        super(programSaveInfo, integer2, integer3, integer4, obj, obj2, obj3, obj4, obj5, obj6);
        return programExamSummary;
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
        if (!object instanceof ProgramExamSummary) {
            return i2;
        }
        if (!n.b(this.programSaveInfo, object.programSaveInfo)) {
            return i2;
        }
        if (!n.b(this.allExamsCount, object.allExamsCount)) {
            return i2;
        }
        if (!n.b(this.passedExamsCount, object.passedExamsCount)) {
            return i2;
        }
        if (!n.b(this.activeExamsCount, object.activeExamsCount)) {
            return i2;
        }
        if (!n.b(this.cardBackgroundColor, object.cardBackgroundColor)) {
            return i2;
        }
        if (!n.b(this.certificateLaurelsImage, object.certificateLaurelsImage)) {
            return i2;
        }
        if (!n.b(this.certificatePaperImage, object.certificatePaperImage)) {
            return i2;
        }
        if (!n.b(this.certificatePlaceholderUrl, object.certificatePlaceholderUrl)) {
            return i2;
        }
        if (!n.b(this.programName, object.programName)) {
            return i2;
        }
        if (!n.b(this.certificateRequirements, object.certificateRequirements)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final Integer getActiveExamsCount() {
        return this.activeExamsCount;
    }

    @Override // android.os.Parcelable
    public final Integer getAllExamsCount() {
        return this.allExamsCount;
    }

    @Override // android.os.Parcelable
    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    @Override // android.os.Parcelable
    public final String getCertificateLaurelsImage() {
        return this.certificateLaurelsImage;
    }

    @Override // android.os.Parcelable
    public final String getCertificatePaperImage() {
        return this.certificatePaperImage;
    }

    @Override // android.os.Parcelable
    public final String getCertificatePlaceholderUrl() {
        return this.certificatePlaceholderUrl;
    }

    @Override // android.os.Parcelable
    public final String getCertificateRequirements() {
        return this.certificateRequirements;
    }

    @Override // android.os.Parcelable
    public final Integer getPassedExamsCount() {
        return this.passedExamsCount;
    }

    @Override // android.os.Parcelable
    public final String getProgramName() {
        return this.programName;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i3;
        int i;
        int i2;
        Integer allExamsCount = this.allExamsCount;
        i2 = 0;
        if (allExamsCount == null) {
            i3 = i2;
        } else {
            i3 = allExamsCount.hashCode();
        }
        Integer passedExamsCount = this.passedExamsCount;
        if (passedExamsCount == null) {
            i = i2;
        } else {
            i = passedExamsCount.hashCode();
        }
        Integer activeExamsCount = this.activeExamsCount;
        if (activeExamsCount == null) {
        } else {
            i2 = activeExamsCount.hashCode();
        }
        return i21 += i28;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramExamSummary(programSaveInfo=");
        stringBuilder.append(this.programSaveInfo);
        stringBuilder.append(", allExamsCount=");
        stringBuilder.append(this.allExamsCount);
        stringBuilder.append(", passedExamsCount=");
        stringBuilder.append(this.passedExamsCount);
        stringBuilder.append(", activeExamsCount=");
        stringBuilder.append(this.activeExamsCount);
        stringBuilder.append(", cardBackgroundColor=");
        stringBuilder.append(this.cardBackgroundColor);
        stringBuilder.append(", certificateLaurelsImage=");
        stringBuilder.append(this.certificateLaurelsImage);
        stringBuilder.append(", certificatePaperImage=");
        stringBuilder.append(this.certificatePaperImage);
        stringBuilder.append(", certificatePlaceholderUrl=");
        stringBuilder.append(this.certificatePlaceholderUrl);
        stringBuilder.append(", programName=");
        stringBuilder.append(this.programName);
        stringBuilder.append(", certificateRequirements=");
        stringBuilder.append(this.certificateRequirements);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int obj4;
        n.f(parcel, "out");
        this.programSaveInfo.writeToParcel(parcel, i2);
        obj4 = this.allExamsCount;
        int i = 0;
        final int i3 = 1;
        if (obj4 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj4.intValue());
        }
        obj4 = this.passedExamsCount;
        if (obj4 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj4.intValue());
        }
        obj4 = this.activeExamsCount;
        if (obj4 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj4.intValue());
        }
        parcel.writeString(this.cardBackgroundColor);
        parcel.writeString(this.certificateLaurelsImage);
        parcel.writeString(this.certificatePaperImage);
        parcel.writeString(this.certificatePlaceholderUrl);
        parcel.writeString(this.programName);
        parcel.writeString(this.certificateRequirements);
    }
}
