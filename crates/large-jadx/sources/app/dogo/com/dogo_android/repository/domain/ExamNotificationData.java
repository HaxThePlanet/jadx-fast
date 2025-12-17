package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BC\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\r¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ExamNotificationData;", "Landroid/os/Parcelable;", "trickName", "", "trickId", "dogId", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "isDogPremium", "", "examId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;ZLjava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getExamId", "()Z", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrickId", "getTrickName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExamNotificationData implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ExamNotificationData> CREATOR;
    private final String dogId;
    private final String examId;
    private final boolean isDogPremium;
    private final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
    private final String trickId;
    private final String trickName;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ExamNotificationData> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ExamNotificationData createFromParcel(Parcel parcel) {
            int fromParcel;
            int i;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                fromParcel = 0;
            } else {
                fromParcel = ProgramSaveInfo.CREATOR.createFromParcel(parcel);
            }
            i = parcel.readInt() != 0 ? 1 : 0;
            super(parcel.readString(), parcel.readString(), parcel.readString(), (ProgramSaveInfo)fromParcel, i, parcel.readString());
            return examNotificationData;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ExamNotificationData[] newArray(int i) {
            return new ExamNotificationData[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ExamNotificationData.Creator creator = new ExamNotificationData.Creator();
        ExamNotificationData.CREATOR = creator;
    }

    public ExamNotificationData() {
        super(0, 0, 0, 0, 0, 0, 63, 0);
    }

    public ExamNotificationData(String string, String string2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo4, boolean z5, String string6) {
        n.f(string, "trickName");
        n.f(string2, "trickId");
        n.f(string3, "dogId");
        n.f(string6, "examId");
        super();
        this.trickName = string;
        this.trickId = string2;
        this.dogId = string3;
        this.programSaveInfo = programSaveInfo4;
        this.isDogPremium = z5;
        this.examId = string6;
    }

    public ExamNotificationData(String string, String string2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo4, boolean z5, String string6, int i7, g g8) {
        String str;
        String str2;
        int obj9;
        int obj10;
        String obj12;
        String obj13;
        final String str3 = "";
        obj13 = i7 & 1 != 0 ? str3 : string;
        str = i7 & 2 != 0 ? str3 : string2;
        str2 = i7 & 4 != 0 ? str3 : string3;
        obj9 = i7 & 8 != 0 ? 0 : obj9;
        obj10 = i7 & 16 != 0 ? 0 : obj10;
        obj12 = i7 & 32 != 0 ? str3 : string6;
        super(obj13, str, str2, obj9, obj10, obj12);
    }

    public static app.dogo.com.dogo_android.repository.domain.ExamNotificationData copy$default(app.dogo.com.dogo_android.repository.domain.ExamNotificationData examNotificationData, String string2, String string3, String string4, app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo5, boolean z6, String string7, int i8, Object object9) {
        String obj5;
        String obj6;
        String obj7;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo obj8;
        boolean obj9;
        String obj10;
        if (i8 & 1 != 0) {
            obj5 = examNotificationData.trickName;
        }
        if (i8 & 2 != 0) {
            obj6 = examNotificationData.trickId;
        }
        if (i8 & 4 != 0) {
            obj7 = examNotificationData.dogId;
        }
        if (i8 & 8 != 0) {
            obj8 = examNotificationData.programSaveInfo;
        }
        if (i8 & 16 != 0) {
            obj9 = examNotificationData.isDogPremium;
        }
        if (i8 & 32 != 0) {
            obj10 = examNotificationData.examId;
        }
        return examNotificationData.copy(obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.trickName;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo component4() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.isDogPremium;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.examId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ExamNotificationData copy(String string, String string2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo4, boolean z5, String string6) {
        n.f(string, "trickName");
        n.f(string2, "trickId");
        n.f(string3, "dogId");
        n.f(string6, "examId");
        super(string, string2, string3, programSaveInfo4, z5, string6);
        return examNotificationData;
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
        if (object instanceof ExamNotificationData == null) {
            return i2;
        }
        if (!n.b(this.trickName, object.trickName)) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.programSaveInfo, object.programSaveInfo)) {
            return i2;
        }
        if (this.isDogPremium != object.isDogPremium) {
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
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public final String getTrickId() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final String getTrickName() {
        return this.trickName;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        boolean isDogPremium;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo = this.programSaveInfo;
        if (programSaveInfo == null) {
            i = 0;
        } else {
            i = programSaveInfo.hashCode();
        }
        if (this.isDogPremium) {
            isDogPremium = 1;
        }
        return i11 += i15;
    }

    @Override // android.os.Parcelable
    public final boolean isDogPremium() {
        return this.isDogPremium;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExamNotificationData(trickName=");
        stringBuilder.append(this.trickName);
        stringBuilder.append(", trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", programSaveInfo=");
        stringBuilder.append(this.programSaveInfo);
        stringBuilder.append(", isDogPremium=");
        stringBuilder.append(this.isDogPremium);
        stringBuilder.append(", examId=");
        stringBuilder.append(this.examId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        parcel.writeString(this.trickName);
        parcel.writeString(this.trickId);
        parcel.writeString(this.dogId);
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo = this.programSaveInfo;
        if (programSaveInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            programSaveInfo.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.isDogPremium);
        parcel.writeString(this.examId);
    }
}
