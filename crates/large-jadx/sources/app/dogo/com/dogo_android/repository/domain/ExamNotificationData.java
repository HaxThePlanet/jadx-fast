package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ExamNotificationData.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BC\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\r¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ExamNotificationData;", "Landroid/os/Parcelable;", "trickName", "", "trickId", "dogId", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "isDogPremium", "", "examId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;ZLjava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getExamId", "()Z", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrickId", "getTrickName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ExamNotificationData implements Parcelable {

    public static final Parcelable.Creator<ExamNotificationData> CREATOR = new ExamNotificationData$Creator<>();
    private final String dogId;
    private final String examId;
    private final boolean isDogPremium;
    private final ProgramSaveInfo programSaveInfo;
    private final String trickId;
    private final String trickName;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamNotificationData> {
        @Override // android.os.Parcelable$Creator
        public final ExamNotificationData createFromParcel(Parcel parcel) {
            int i = 0;
            int i2 = 0;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                i = 0;
            } else {
                Object fromParcel = ProgramSaveInfo.CREATOR.createFromParcel(parcel);
            }
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            r1 = new ExamNotificationData(parcel.readString(), parcel.readString(), parcel.readString(), (ProgramSaveInfo)i, (parcel.readInt() != 0 ? 1 : 0), parcel.readString());
            return examNotificationData;
        }

        @Override // android.os.Parcelable$Creator
        public final ExamNotificationData[] newArray(int i) {
            return new ExamNotificationData[i];
        }
    }
    public ExamNotificationData(String str, String str2, String str3, ProgramSaveInfo programSaveInfo, boolean z, String str4) {
        n.f(str, "trickName");
        n.f(str2, "trickId");
        n.f(str3, "dogId");
        n.f(str4, "examId");
        super();
        this.trickName = str;
        this.trickId = str2;
        this.dogId = str3;
        this.programSaveInfo = programSaveInfo;
        this.isDogPremium = z;
        this.examId = str4;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getExamId() {
        return this.examId;
    }

    public final ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    public final String getTrickId() {
        return this.trickId;
    }

    public final String getTrickName() {
        return this.trickName;
    }

    public final boolean isDogPremium() {
        return this.isDogPremium;
    }

    public /* synthetic */ ExamNotificationData(String str, String str2, String str3, ProgramSaveInfo programSaveInfo, boolean z, String str4, int i, g gVar) {
        String str22;
        int programSaveInfo42 = 0;
        int z52 = 0;
        str22 = "";
        gVar = i & 1 != 0 ? str22 : str;
        String r1 = i & 2 != 0 ? str22 : str2;
        String r2 = i & 4 != 0 ? str22 : str3;
        programSaveInfo42 = i & 8 != 0 ? 0 : programSaveInfo42;
        z52 = i & 16 != 0 ? 0 : z52;
        i = i & 32 != 0 ? str22 : str4;
        this(str22, str22, str22, programSaveInfo42, z52, (i & 32 != 0 ? str22 : str4));
    }


    public ExamNotificationData() {
        this(null, null, null, null, false, null, 63, null);
    }

    public static /* synthetic */ ExamNotificationData copy$default(ExamNotificationData examNotificationData, String str, String str2, String str3, ProgramSaveInfo programSaveInfo, boolean z, String str4, int i, Object object) {
        String str22;
        String object92;
        String str42;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo52;
        boolean z62;
        String str72;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        if (i & 32 != 0) {
        }
        return examNotificationData.copy(str22, object92, str42, programSaveInfo52, z62, str72);
    }

    /* operator */ public final String component1() {
        return this.trickName;
    }

    /* operator */ public final String component2() {
        return this.trickId;
    }

    /* operator */ public final String component3() {
        return this.dogId;
    }

    /* operator */ public final ProgramSaveInfo component4() {
        return this.programSaveInfo;
    }

    /* operator */ public final boolean component5() {
        return this.isDogPremium;
    }

    /* operator */ public final String component6() {
        return this.examId;
    }

    public final ExamNotificationData copy(String trickName, String trickId, String dogId, ProgramSaveInfo programSaveInfo, boolean isDogPremium, String examId) {
        n.f(trickName, "trickName");
        n.f(trickId, "trickId");
        n.f(dogId, "dogId");
        n.f(examId, "examId");
        ExamNotificationData examNotificationData = new ExamNotificationData(trickName, trickId, dogId, programSaveInfo, isDogPremium, examId);
        return examNotificationData;
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
        final boolean z7 = false;
        if (!(other instanceof ExamNotificationData)) {
            return false;
        }
        if (!n.b(this.trickName, other.trickName)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.programSaveInfo, other.programSaveInfo)) {
            return false;
        }
        if (this.isDogPremium != other.isDogPremium) {
            return false;
        }
        return !n.b(this.examId, other.examId) ? z7 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        boolean isDogPremium2 = true;
        if (this.programSaveInfo == null) {
            i = 0;
        } else {
            i = this.programSaveInfo.hashCode();
        }
        if (this.isDogPremium) {
            int i16 = 1;
        }
        return (this.trickName.hashCode() * 31) + this.trickId.hashCode() * 31 + this.dogId.hashCode() * 31 + i * 31 + isDogPremium2 * 31 + this.examId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ExamNotificationData(trickName=";
        String str3 = ", trickId=";
        String str4 = ", dogId=";
        String str5 = ", programSaveInfo=";
        String str6 = ", isDogPremium=";
        String str7 = ", examId=";
        str = str2 + this.trickName + str3 + this.trickId + str4 + this.dogId + str5 + this.programSaveInfo + str6 + this.isDogPremium + str7 + this.examId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.trickName);
        parcel.writeString(this.trickId);
        parcel.writeString(this.dogId);
        if (this.programSaveInfo == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.programSaveInfo.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.isDogPremium);
        parcel.writeString(this.examId);
    }
}
