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
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000cHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020\n2\u0008\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0013R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000f¨\u0006*", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Program;", "Landroid/os/Parcelable;", "name", "", "description", "certificatePaperImage", "lessons", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "isPremiumLocked", "", "examSumamry", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;)V", "getCertificatePaperImage", "()Ljava/lang/String;", "getDescription", "getExamSumamry", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "()Z", "getLessons", "()Ljava/util/List;", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Program implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.Program> CREATOR;
    private final String certificatePaperImage;
    private final String description;
    private final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary examSumamry;
    private final boolean isPremiumLocked;
    private final List<app.dogo.com.dogo_android.repository.domain.ProgramLesson> lessons;
    private final String name;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.Program> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.Program createFromParcel(Parcel parcel) {
            int int;
            int i;
            int i2;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int2);
            int i3 = 0;
            i = i3;
            while (i != int2) {
                arrayList.add(ProgramLesson.CREATOR.createFromParcel(parcel));
                i++;
            }
            i2 = parcel.readInt() != 0 ? int : i3;
            super(parcel.readString(), parcel.readString(), parcel.readString(), arrayList, i2, (ProgramExamSummary)ProgramExamSummary.CREATOR.createFromParcel(parcel));
            return obj9;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.Program[] newArray(int i) {
            return new Program[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        Program.Creator creator = new Program.Creator();
        Program.CREATOR = creator;
    }

    public Program(String string, String string2, String string3, List<app.dogo.com.dogo_android.repository.domain.ProgramLesson> list4, boolean z5, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary6) {
        n.f(string, "name");
        n.f(string2, "description");
        n.f(string3, "certificatePaperImage");
        n.f(list4, "lessons");
        n.f(programExamSummary6, "examSumamry");
        super();
        this.name = string;
        this.description = string2;
        this.certificatePaperImage = string3;
        this.lessons = list4;
        this.isPremiumLocked = z5;
        this.examSumamry = programExamSummary6;
    }

    public static app.dogo.com.dogo_android.repository.domain.Program copy$default(app.dogo.com.dogo_android.repository.domain.Program program, String string2, String string3, String string4, List list5, boolean z6, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary7, int i8, Object object9) {
        String obj5;
        String obj6;
        String obj7;
        List obj8;
        boolean obj9;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary obj10;
        if (i8 & 1 != 0) {
            obj5 = program.name;
        }
        if (i8 & 2 != 0) {
            obj6 = program.description;
        }
        if (i8 & 4 != 0) {
            obj7 = program.certificatePaperImage;
        }
        if (i8 & 8 != 0) {
            obj8 = program.lessons;
        }
        if (i8 & 16 != 0) {
            obj9 = program.isPremiumLocked;
        }
        if (i8 & 32 != 0) {
            obj10 = program.examSumamry;
        }
        return program.copy(obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.certificatePaperImage;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramLesson> component4() {
        return this.lessons;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.isPremiumLocked;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary component6() {
        return this.examSumamry;
    }

    public final app.dogo.com.dogo_android.repository.domain.Program copy(String string, String string2, String string3, List<app.dogo.com.dogo_android.repository.domain.ProgramLesson> list4, boolean z5, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary6) {
        n.f(string, "name");
        n.f(string2, "description");
        n.f(string3, "certificatePaperImage");
        n.f(list4, "lessons");
        n.f(programExamSummary6, "examSumamry");
        super(string, string2, string3, list4, z5, programExamSummary6);
        return program;
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
        if (!object instanceof Program) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (!n.b(this.certificatePaperImage, object.certificatePaperImage)) {
            return i2;
        }
        if (!n.b(this.lessons, object.lessons)) {
            return i2;
        }
        if (this.isPremiumLocked != object.isPremiumLocked) {
            return i2;
        }
        if (!n.b(this.examSumamry, object.examSumamry)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getCertificatePaperImage() {
        return this.certificatePaperImage;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary getExamSumamry() {
        return this.examSumamry;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramLesson> getLessons() {
        return this.lessons;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isPremiumLocked;
        if (this.isPremiumLocked) {
            isPremiumLocked = 1;
        }
        return i10 += i15;
    }

    @Override // android.os.Parcelable
    public final boolean isPremiumLocked() {
        return this.isPremiumLocked;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Program(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", certificatePaperImage=");
        stringBuilder.append(this.certificatePaperImage);
        stringBuilder.append(", lessons=");
        stringBuilder.append(this.lessons);
        stringBuilder.append(", isPremiumLocked=");
        stringBuilder.append(this.isPremiumLocked);
        stringBuilder.append(", examSumamry=");
        stringBuilder.append(this.examSumamry);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.certificatePaperImage);
        List lessons = this.lessons;
        parcel.writeInt(lessons.size());
        Iterator iterator = lessons.iterator();
        for (ProgramLesson size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.isPremiumLocked);
        this.examSumamry.writeToParcel(parcel, i2);
    }
}
