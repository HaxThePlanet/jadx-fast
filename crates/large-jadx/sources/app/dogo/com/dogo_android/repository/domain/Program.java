package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: Program.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000cHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020\n2\u0008\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0013R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000f¨\u0006*", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Program;", "Landroid/os/Parcelable;", "name", "", "description", "certificatePaperImage", "lessons", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "isPremiumLocked", "", "examSumamry", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;)V", "getCertificatePaperImage", "()Ljava/lang/String;", "getDescription", "getExamSumamry", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "()Z", "getLessons", "()Ljava/util/List;", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Program implements Parcelable {

    public static final Parcelable.Creator<Program> CREATOR = new Program$Creator<>();
    private final String certificatePaperImage;
    private final String description;
    private final ProgramExamSummary examSumamry;
    private final boolean isPremiumLocked;
    private final List<ProgramLesson> lessons;
    private final String name;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Program> {
        @Override // android.os.Parcelable$Creator
        public final Program createFromParcel(Parcel parcel) {
            int i;
            boolean z;
            n.f(parcel, "parcel");
            int _int2 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int2);
            i = 0;
            while (i != _int2) {
                arrayList.add(ProgramLesson.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            int _int = parcel.readInt() != 0 ? _int : i;
            Program parcel2 = new Program(parcel.readString(), parcel.readString(), parcel.readString(), arrayList, z, (ProgramExamSummary)ProgramExamSummary.CREATOR.createFromParcel(parcel));
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final Program[] newArray(int i) {
            return new Program[i];
        }
    }
    public Program(String str, String str2, String str3, List<ProgramLesson> list, boolean z, ProgramExamSummary programExamSummary) {
        n.f(str, "name");
        n.f(str2, "description");
        n.f(str3, "certificatePaperImage");
        n.f(list, "lessons");
        n.f(programExamSummary, "examSumamry");
        super();
        this.name = str;
        this.description = str2;
        this.certificatePaperImage = str3;
        this.lessons = list;
        this.isPremiumLocked = z;
        this.examSumamry = programExamSummary;
    }

    public final String getCertificatePaperImage() {
        return this.certificatePaperImage;
    }

    public final String getDescription() {
        return this.description;
    }

    public final ProgramExamSummary getExamSumamry() {
        return this.examSumamry;
    }

    public final List<ProgramLesson> getLessons() {
        return this.lessons;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isPremiumLocked() {
        return this.isPremiumLocked;
    }


    public static /* synthetic */ Program copy$default(Program program, String str, String str2, String str3, List list, boolean z, ProgramExamSummary programExamSummary, int i, Object object) {
        String str22;
        String object92;
        String str42;
        List list52;
        boolean z62;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary72;
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
        return program.copy(str22, object92, str42, list52, z62, programExamSummary72);
    }

    /* operator */ public final String component1() {
        return this.name;
    }

    /* operator */ public final String component2() {
        return this.description;
    }

    /* operator */ public final String component3() {
        return this.certificatePaperImage;
    }

    /* operator */ public final List<ProgramLesson> component4() {
        return this.lessons;
    }

    /* operator */ public final boolean component5() {
        return this.isPremiumLocked;
    }

    /* operator */ public final ProgramExamSummary component6() {
        return this.examSumamry;
    }

    public final Program copy(String name, String description, String certificatePaperImage, List<ProgramLesson> lessons, boolean isPremiumLocked, ProgramExamSummary examSumamry) {
        n.f(name, "name");
        n.f(description, "description");
        n.f(certificatePaperImage, "certificatePaperImage");
        n.f(lessons, "lessons");
        n.f(examSumamry, "examSumamry");
        Program program = new Program(name, description, certificatePaperImage, lessons, isPremiumLocked, examSumamry);
        return program;
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
        if (!(other instanceof Program)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (!n.b(this.certificatePaperImage, other.certificatePaperImage)) {
            return false;
        }
        if (!n.b(this.lessons, other.lessons)) {
            return false;
        }
        if (this.isPremiumLocked != other.isPremiumLocked) {
            return false;
        }
        return !n.b(this.examSumamry, other.examSumamry) ? z7 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isPremiumLocked2 = true;
        if (this.isPremiumLocked) {
            int i16 = 1;
        }
        return (this.name.hashCode() * 31) + this.description.hashCode() * 31 + this.certificatePaperImage.hashCode() * 31 + this.lessons.hashCode() * 31 + isPremiumLocked2 * 31 + this.examSumamry.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Program(name=";
        String str3 = ", description=";
        String str4 = ", certificatePaperImage=";
        String str5 = ", lessons=";
        String str6 = ", isPremiumLocked=";
        String str7 = ", examSumamry=";
        str = str2 + this.name + str3 + this.description + str4 + this.certificatePaperImage + str5 + this.lessons + str6 + this.isPremiumLocked + str7 + this.examSumamry + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.certificatePaperImage);
        parcel.writeInt(this.lessons.size());
        Iterator it = this.lessons.iterator();
        while (it.hasNext()) {
            (ProgramLesson)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.isPremiumLocked);
        this.examSumamry.writeToParcel(parcel, flags);
    }
}
