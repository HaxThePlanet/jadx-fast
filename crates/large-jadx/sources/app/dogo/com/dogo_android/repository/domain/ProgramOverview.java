package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ProgramOverview.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u000c\u001a\u00020\u0007\u0012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000f\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000f\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u007f\u0010(\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00072\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001J\u0013\u0010*\u001a\u00020+2\u0008\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u000c\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0014R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0016R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0016¨\u00065", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "Landroid/os/Parcelable;", "mirrorableImage", "", "certificatePreview", "programName", "examCount", "", "enrolledUsersCount", "skillList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "averageDurationWeeks", "dogSkillOverview", "userSkillOverview", "programId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;ILjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAverageDurationWeeks", "()I", "getCertificatePreview", "()Ljava/lang/String;", "getDogSkillOverview", "()Ljava/util/List;", "getEnrolledUsersCount", "getExamCount", "getMirrorableImage", "getProgramId", "getProgramName", "getSkillList", "getUserSkillOverview", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramOverview implements Parcelable {

    public static final Parcelable.Creator<ProgramOverview> CREATOR = new ProgramOverview$Creator<>();
    private final int averageDurationWeeks;
    private final String certificatePreview;
    private final List<String> dogSkillOverview;
    private final int enrolledUsersCount;
    private final int examCount;
    private final String mirrorableImage;
    private final String programId;
    private final String programName;
    private final List<TrickItem> skillList;
    private final List<String> userSkillOverview;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramOverview> {
        @Override // android.os.Parcelable$Creator
        public final ProgramOverview createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            ProgramOverview parcel2 = new ProgramOverview(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), arrayList, parcel.readInt(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readString());
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramOverview[] newArray(int i) {
            return new ProgramOverview[i];
        }
    }
    public ProgramOverview(String str, String str2, String str3, int i, int i2, List<TrickItem> list, int i3, List<String> list2, List<String> list3, String str4) {
        n.f(str, "mirrorableImage");
        n.f(str2, "certificatePreview");
        n.f(str3, "programName");
        n.f(list, "skillList");
        n.f(list2, "dogSkillOverview");
        n.f(list3, "userSkillOverview");
        n.f(str4, "programId");
        super();
        this.mirrorableImage = str;
        this.certificatePreview = str2;
        this.programName = str3;
        this.examCount = i;
        this.enrolledUsersCount = i2;
        this.skillList = list;
        this.averageDurationWeeks = i3;
        this.dogSkillOverview = list2;
        this.userSkillOverview = list3;
        this.programId = str4;
    }

    public final int getAverageDurationWeeks() {
        return this.averageDurationWeeks;
    }

    public final String getCertificatePreview() {
        return this.certificatePreview;
    }

    public final List<String> getDogSkillOverview() {
        return this.dogSkillOverview;
    }

    public final int getEnrolledUsersCount() {
        return this.enrolledUsersCount;
    }

    public final int getExamCount() {
        return this.examCount;
    }

    public final String getMirrorableImage() {
        return this.mirrorableImage;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final List<TrickItem> getSkillList() {
        return this.skillList;
    }

    public final List<String> getUserSkillOverview() {
        return this.userSkillOverview;
    }


    public static /* synthetic */ ProgramOverview copy$default(ProgramOverview programOverview, String str, String str2, String str3, int i, int i2, List list, int i3, List list2, List list3, String str4, int i4, Object object) {
        String str112;
        String str22;
        String str32;
        String str42;
        int i52;
        int i62;
        List list72;
        int i82;
        List list92;
        List list102;
        Object programOverview2 = programOverview;
        int i122 = i4;
        String r2 = i122 & 1 != 0 ? programOverview2.mirrorableImage : str;
        String r3 = i122 & 2 != 0 ? programOverview2.certificatePreview : str2;
        String r4 = i122 & 4 != 0 ? programOverview2.programName : str3;
        int r5 = i122 & 8 != 0 ? programOverview2.examCount : i;
        int r6 = i122 & 16 != 0 ? programOverview2.enrolledUsersCount : i2;
        List r7 = i122 & 32 != 0 ? programOverview2.skillList : list;
        int r8 = i122 & 64 != 0 ? programOverview2.averageDurationWeeks : i3;
        List r9 = i122 & 128 != 0 ? programOverview2.dogSkillOverview : list2;
        List r10 = i122 & 256 != 0 ? programOverview2.userSkillOverview : list3;
        String r1 = i122 & 512 != 0 ? programOverview2.programId : str4;
        return programOverview.copy(str22, str32, str42, i52, i62, list72, i82, list92, list102, (i122 & 512 != 0 ? programOverview2.programId : str4));
    }

    /* operator */ public final String component1() {
        return this.mirrorableImage;
    }

    /* operator */ public final String component10() {
        return this.programId;
    }

    /* operator */ public final String component2() {
        return this.certificatePreview;
    }

    /* operator */ public final String component3() {
        return this.programName;
    }

    /* operator */ public final int component4() {
        return this.examCount;
    }

    /* operator */ public final int component5() {
        return this.enrolledUsersCount;
    }

    /* operator */ public final List<TrickItem> component6() {
        return this.skillList;
    }

    /* operator */ public final int component7() {
        return this.averageDurationWeeks;
    }

    /* operator */ public final List<String> component8() {
        return this.dogSkillOverview;
    }

    /* operator */ public final List<String> component9() {
        return this.userSkillOverview;
    }

    public final ProgramOverview copy(String mirrorableImage, String certificatePreview, String programName, int examCount, int enrolledUsersCount, List<TrickItem> skillList, int averageDurationWeeks, List<String> dogSkillOverview, List<String> userSkillOverview, String programId) {
        n.f(mirrorableImage, "mirrorableImage");
        n.f(certificatePreview, "certificatePreview");
        n.f(programName, "programName");
        final Object skillList2 = skillList;
        n.f(skillList2, "skillList");
        final Object dogSkillOverview2 = dogSkillOverview;
        n.f(dogSkillOverview2, "dogSkillOverview");
        final Object userSkillOverview2 = userSkillOverview;
        n.f(userSkillOverview2, "userSkillOverview");
        final Object programId2 = programId;
        n.f(programId2, "programId");
        ProgramOverview programOverview = new ProgramOverview(mirrorableImage, certificatePreview, programName, examCount, enrolledUsersCount, skillList2, averageDurationWeeks, dogSkillOverview2, userSkillOverview2, programId2);
        return programOverview;
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
        final boolean z9 = false;
        if (!(other instanceof ProgramOverview)) {
            return false;
        }
        if (!n.b(this.mirrorableImage, other.mirrorableImage)) {
            return false;
        }
        if (!n.b(this.certificatePreview, other.certificatePreview)) {
            return false;
        }
        if (!n.b(this.programName, other.programName)) {
            return false;
        }
        if (this.examCount != other.examCount) {
            return false;
        }
        if (this.enrolledUsersCount != other.enrolledUsersCount) {
            return false;
        }
        if (!n.b(this.skillList, other.skillList)) {
            return false;
        }
        if (this.averageDurationWeeks != other.averageDurationWeeks) {
            return false;
        }
        if (!n.b(this.dogSkillOverview, other.dogSkillOverview)) {
            return false;
        }
        if (!n.b(this.userSkillOverview, other.userSkillOverview)) {
            return false;
        }
        return !n.b(this.programId, other.programId) ? z9 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.mirrorableImage.hashCode() * 31) + this.certificatePreview.hashCode() * 31 + this.programName.hashCode() * 31 + Integer.hashCode(this.examCount) * 31 + Integer.hashCode(this.enrolledUsersCount) * 31 + this.skillList.hashCode() * 31 + Integer.hashCode(this.averageDurationWeeks) * 31 + this.dogSkillOverview.hashCode() * 31 + this.userSkillOverview.hashCode() * 31 + this.programId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramOverview(mirrorableImage=";
        String str3 = ", certificatePreview=";
        String str4 = ", programName=";
        String str5 = ", examCount=";
        String str6 = ", enrolledUsersCount=";
        String str7 = ", skillList=";
        String str8 = ", averageDurationWeeks=";
        String str9 = ", dogSkillOverview=";
        String str10 = ", userSkillOverview=";
        String str11 = ", programId=";
        str = str2 + this.mirrorableImage + str3 + this.certificatePreview + str4 + this.programName + str5 + this.examCount + str6 + this.enrolledUsersCount + str7 + this.skillList + str8 + this.averageDurationWeeks + str9 + this.dogSkillOverview + str10 + this.userSkillOverview + str11 + this.programId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.mirrorableImage);
        parcel.writeString(this.certificatePreview);
        parcel.writeString(this.programName);
        parcel.writeInt(this.examCount);
        parcel.writeInt(this.enrolledUsersCount);
        parcel.writeInt(this.skillList.size());
        Iterator it = this.skillList.iterator();
        while (it.hasNext()) {
            (TrickItem)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.averageDurationWeeks);
        parcel.writeStringList(this.dogSkillOverview);
        parcel.writeStringList(this.userSkillOverview);
        parcel.writeString(this.programId);
    }
}
