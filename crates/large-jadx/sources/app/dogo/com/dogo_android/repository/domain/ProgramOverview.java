package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u000c\u001a\u00020\u0007\u0012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000f\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000f\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u007f\u0010(\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00072\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001J\u0013\u0010*\u001a\u00020+2\u0008\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u000c\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0014R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0016R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0016¨\u00065", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "Landroid/os/Parcelable;", "mirrorableImage", "", "certificatePreview", "programName", "examCount", "", "enrolledUsersCount", "skillList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "averageDurationWeeks", "dogSkillOverview", "userSkillOverview", "programId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;ILjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAverageDurationWeeks", "()I", "getCertificatePreview", "()Ljava/lang/String;", "getDogSkillOverview", "()Ljava/util/List;", "getEnrolledUsersCount", "getExamCount", "getMirrorableImage", "getProgramId", "getProgramName", "getSkillList", "getUserSkillOverview", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramOverview implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramOverview> CREATOR;
    private final int averageDurationWeeks;
    private final String certificatePreview;
    private final List<String> dogSkillOverview;
    private final int enrolledUsersCount;
    private final int examCount;
    private final String mirrorableImage;
    private final String programId;
    private final String programName;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> skillList;
    private final List<String> userSkillOverview;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramOverview> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramOverview createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                i++;
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), arrayList, parcel.readInt(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readString());
            return obj13;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramOverview[] newArray(int i) {
            return new ProgramOverview[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ProgramOverview.Creator creator = new ProgramOverview.Creator();
        ProgramOverview.CREATOR = creator;
    }

    public ProgramOverview(String string, String string2, String string3, int i4, int i5, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list6, int i7, List<String> list8, List<String> list9, String string10) {
        n.f(string, "mirrorableImage");
        n.f(string2, "certificatePreview");
        n.f(string3, "programName");
        n.f(list6, "skillList");
        n.f(list8, "dogSkillOverview");
        n.f(list9, "userSkillOverview");
        n.f(string10, "programId");
        super();
        this.mirrorableImage = string;
        this.certificatePreview = string2;
        this.programName = string3;
        this.examCount = i4;
        this.enrolledUsersCount = i5;
        this.skillList = list6;
        this.averageDurationWeeks = i7;
        this.dogSkillOverview = list8;
        this.userSkillOverview = list9;
        this.programId = string10;
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramOverview copy$default(app.dogo.com.dogo_android.repository.domain.ProgramOverview programOverview, String string2, String string3, String string4, int i5, int i6, List list7, int i8, List list9, List list10, String string11, int i12, Object object13) {
        String programId;
        String mirrorableImage;
        String certificatePreview;
        String programName;
        int examCount;
        int enrolledUsersCount;
        List skillList;
        int averageDurationWeeks;
        List dogSkillOverview;
        List userSkillOverview;
        Object obj = programOverview;
        int i = i12;
        mirrorableImage = i & 1 != 0 ? obj.mirrorableImage : string2;
        certificatePreview = i & 2 != 0 ? obj.certificatePreview : string3;
        programName = i & 4 != 0 ? obj.programName : string4;
        examCount = i & 8 != 0 ? obj.examCount : i5;
        enrolledUsersCount = i & 16 != 0 ? obj.enrolledUsersCount : i6;
        skillList = i & 32 != 0 ? obj.skillList : list7;
        averageDurationWeeks = i & 64 != 0 ? obj.averageDurationWeeks : i8;
        dogSkillOverview = i & 128 != 0 ? obj.dogSkillOverview : list9;
        userSkillOverview = i & 256 != 0 ? obj.userSkillOverview : list10;
        programId = i &= 512 != 0 ? obj.programId : string11;
        return programOverview.copy(mirrorableImage, certificatePreview, programName, examCount, enrolledUsersCount, skillList, averageDurationWeeks, dogSkillOverview, userSkillOverview, programId);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.mirrorableImage;
    }

    @Override // android.os.Parcelable
    public final String component10() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.certificatePreview;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.programName;
    }

    @Override // android.os.Parcelable
    public final int component4() {
        return this.examCount;
    }

    @Override // android.os.Parcelable
    public final int component5() {
        return this.enrolledUsersCount;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component6() {
        return this.skillList;
    }

    @Override // android.os.Parcelable
    public final int component7() {
        return this.averageDurationWeeks;
    }

    public final List<String> component8() {
        return this.dogSkillOverview;
    }

    public final List<String> component9() {
        return this.userSkillOverview;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramOverview copy(String string, String string2, String string3, int i4, int i5, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list6, int i7, List<String> list8, List<String> list9, String string10) {
        n.f(string, "mirrorableImage");
        n.f(string2, "certificatePreview");
        n.f(string3, "programName");
        final Object obj = list6;
        n.f(obj, "skillList");
        final Object obj2 = list8;
        n.f(obj2, "dogSkillOverview");
        final Object obj3 = list9;
        n.f(obj3, "userSkillOverview");
        final Object obj4 = string10;
        n.f(obj4, "programId");
        super(string, string2, string3, i4, i5, obj, i7, obj2, obj3, obj4);
        return programOverview;
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
        if (object instanceof ProgramOverview == null) {
            return i2;
        }
        if (!n.b(this.mirrorableImage, object.mirrorableImage)) {
            return i2;
        }
        if (!n.b(this.certificatePreview, object.certificatePreview)) {
            return i2;
        }
        if (!n.b(this.programName, object.programName)) {
            return i2;
        }
        if (this.examCount != object.examCount) {
            return i2;
        }
        if (this.enrolledUsersCount != object.enrolledUsersCount) {
            return i2;
        }
        if (!n.b(this.skillList, object.skillList)) {
            return i2;
        }
        if (this.averageDurationWeeks != object.averageDurationWeeks) {
            return i2;
        }
        if (!n.b(this.dogSkillOverview, object.dogSkillOverview)) {
            return i2;
        }
        if (!n.b(this.userSkillOverview, object.userSkillOverview)) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getAverageDurationWeeks() {
        return this.averageDurationWeeks;
    }

    @Override // android.os.Parcelable
    public final String getCertificatePreview() {
        return this.certificatePreview;
    }

    public final List<String> getDogSkillOverview() {
        return this.dogSkillOverview;
    }

    @Override // android.os.Parcelable
    public final int getEnrolledUsersCount() {
        return this.enrolledUsersCount;
    }

    @Override // android.os.Parcelable
    public final int getExamCount() {
        return this.examCount;
    }

    @Override // android.os.Parcelable
    public final String getMirrorableImage() {
        return this.mirrorableImage;
    }

    @Override // android.os.Parcelable
    public final String getProgramId() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String getProgramName() {
        return this.programName;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getSkillList() {
        return this.skillList;
    }

    public final List<String> getUserSkillOverview() {
        return this.userSkillOverview;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i18 += i28;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramOverview(mirrorableImage=");
        stringBuilder.append(this.mirrorableImage);
        stringBuilder.append(", certificatePreview=");
        stringBuilder.append(this.certificatePreview);
        stringBuilder.append(", programName=");
        stringBuilder.append(this.programName);
        stringBuilder.append(", examCount=");
        stringBuilder.append(this.examCount);
        stringBuilder.append(", enrolledUsersCount=");
        stringBuilder.append(this.enrolledUsersCount);
        stringBuilder.append(", skillList=");
        stringBuilder.append(this.skillList);
        stringBuilder.append(", averageDurationWeeks=");
        stringBuilder.append(this.averageDurationWeeks);
        stringBuilder.append(", dogSkillOverview=");
        stringBuilder.append(this.dogSkillOverview);
        stringBuilder.append(", userSkillOverview=");
        stringBuilder.append(this.userSkillOverview);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        parcel.writeString(this.mirrorableImage);
        parcel.writeString(this.certificatePreview);
        parcel.writeString(this.programName);
        parcel.writeInt(this.examCount);
        parcel.writeInt(this.enrolledUsersCount);
        List skillList = this.skillList;
        parcel.writeInt(skillList.size());
        Iterator iterator = skillList.iterator();
        for (TrickItem size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.averageDurationWeeks);
        parcel.writeStringList(this.dogSkillOverview);
        parcel.writeStringList(this.userSkillOverview);
        parcel.writeString(this.programId);
    }
}
