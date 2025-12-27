package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramLesson.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u00012B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b\u0012\u0010\u0008\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003Ja\u0010%\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0010\u0008\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0013\u0010'\u001a\u00020\u000b2\u0008\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0006\u0010+\u001a\u00020\u000bJ\t\u0010,\u001a\u00020\u0007HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0014R\u0011\u0010\u000c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "Landroid/os/Parcelable;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "itemNumber", "", "description", "", "type", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;", "isNew", "", "isRecap", "moduleExams", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "isPremiumLocked", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;ILjava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;ZZLjava/util/List;Z)V", "getDescription", "()Ljava/lang/String;", "()Z", "getItemNumber", "()I", "getModuleExams", "()Ljava/util/List;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "isLessonUnlocked", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramLesson implements Parcelable {

    public static final Parcelable.Creator<ProgramLesson> CREATOR = new ProgramLesson$Creator<>();
    private final String description;
    private final boolean isNew;
    private final boolean isPremiumLocked;
    private final boolean isRecap;
    private final int itemNumber;
    private final List<ProgramExam> moduleExams;
    private final ProgramSaveInfo programSaveInfo;
    private final ProgramLesson.Type type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramLesson> {
        @Override // android.os.Parcelable$Creator
        public final ProgramLesson createFromParcel(Parcel parcel) {
            int i;
            boolean z2;
            ArrayList arrayList = null;
            boolean z3;
            Object fromParcel;
            n.f(parcel, "parcel");
            i = 1;
            i = 0;
            int r0 = i;
            int r7 = i;
            if (parcel.readInt() == 0) {
                int i2 = 0;
            } else {
                int _int5 = parcel.readInt();
                arrayList = new ArrayList(_int5);
                while (i != _int5) {
                    arrayList.add(ProgramExam.CREATOR.createFromParcel(parcel));
                    i = i + 1;
                }
            }
            int r9 = i;
            ProgramLesson parcel2 = new ProgramLesson((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), ProgramLesson_Type.valueOf(parcel.readString()), i, z2, arrayList, i);
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramLesson[] newArray(int i) {
            return new ProgramLesson[i];
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;", "", "(Ljava/lang/String;I)V", "ACTIVE", "UNLOCKED", "LOCKED", "COMPLETED", "HEADER", "EXAM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {

        ACTIVE,
        COMPLETED,
        EXAM,
        HEADER,
        LOCKED,
        UNLOCKED;
        private static final /* synthetic */ ProgramLesson.Type[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type[] arr = new ProgramLesson.Type[6];
            return new ProgramLesson.Type[] { ProgramLesson_Type.ACTIVE, ProgramLesson_Type.UNLOCKED, ProgramLesson_Type.LOCKED, ProgramLesson_Type.COMPLETED, ProgramLesson_Type.HEADER, ProgramLesson_Type.EXAM };
        }
    }
    public ProgramLesson(ProgramSaveInfo programSaveInfo, int i, String str, ProgramLesson.Type type, boolean z, boolean z2, List<ProgramExam> list, boolean z3) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(str, "description");
        n.f(type, "type");
        super();
        this.programSaveInfo = programSaveInfo;
        this.itemNumber = i;
        this.description = str;
        this.type = type;
        this.isNew = z;
        this.isRecap = z2;
        this.moduleExams = list;
        this.isPremiumLocked = z3;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getItemNumber() {
        return this.itemNumber;
    }

    public final List<ProgramExam> getModuleExams() {
        return this.moduleExams;
    }

    public final ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    public final ProgramLesson.Type getType() {
        return this.type;
    }

    public final boolean isLessonUnlocked() {
        boolean z = false;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type aCTIVE2;
        if (this.type == ProgramLesson_Type.ACTIVE || !(this.type == ProgramLesson_Type.UNLOCKED && this.type != ProgramLesson_Type.COMPLETED)) {
            int i2 = 1;
        }
        return z;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean isPremiumLocked() {
        return this.isPremiumLocked;
    }

    public final boolean isRecap() {
        return this.isRecap;
    }

    public /* synthetic */ ProgramLesson(ProgramSaveInfo programSaveInfo, int i, String str, ProgramLesson.Type type, boolean z, boolean z2, List list, boolean z3, int i2, g gVar) {
        int i22;
        String str32;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type type42;
        int list72 = 0;
        int i92 = i2;
        i22 = 0;
        int r1 = i92 & 2 != 0 ? i22 : i;
        String r3 = i92 & 4 != 0 ? "" : str;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type r4 = i92 & 8 != 0 ? ProgramLesson_Type.LOCKED : type;
        int r5 = i92 & 16 != 0 ? i22 : z;
        int r6 = i92 & 32 != 0 ? i22 : z2;
        int r7 = i92 & 64 != 0 ? 0 : list;
        if (i92 & 128 == 0) {
            i22 = z3;
        }
        this(programSaveInfo, i22, str32, type42, i22, i22, list72, i22);
    }


    public static /* synthetic */ ProgramLesson copy$default(ProgramLesson programLesson, ProgramSaveInfo programSaveInfo, int i, String str, ProgramLesson.Type type, boolean z, boolean z2, List list, boolean z3, int i2, Object object) {
        boolean z92;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo22;
        int i32;
        String str42;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type type52;
        boolean z62;
        boolean z72;
        List list82;
        Object programLesson2 = programLesson;
        int i102 = i2;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo r2 = i102 & 1 != 0 ? programLesson2.programSaveInfo : programSaveInfo;
        int r3 = i102 & 2 != 0 ? programLesson2.itemNumber : i;
        String r4 = i102 & 4 != 0 ? programLesson2.description : str;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type r5 = i102 & 8 != 0 ? programLesson2.type : type;
        boolean r6 = i102 & 16 != 0 ? programLesson2.isNew : z;
        boolean r7 = i102 & 32 != 0 ? programLesson2.isRecap : z2;
        List r8 = i102 & 64 != 0 ? programLesson2.moduleExams : list;
        boolean r1 = i102 & 128 != 0 ? programLesson2.isPremiumLocked : z3;
        return programLesson.copy(programSaveInfo22, i32, str42, type52, z62, z72, list82, (i102 & 128 != 0 ? programLesson2.isPremiumLocked : z3));
    }

    /* operator */ public final ProgramSaveInfo component1() {
        return this.programSaveInfo;
    }

    /* operator */ public final int component2() {
        return this.itemNumber;
    }

    /* operator */ public final String component3() {
        return this.description;
    }

    /* operator */ public final ProgramLesson.Type component4() {
        return this.type;
    }

    /* operator */ public final boolean component5() {
        return this.isNew;
    }

    /* operator */ public final boolean component6() {
        return this.isRecap;
    }

    /* operator */ public final List<ProgramExam> component7() {
        return this.moduleExams;
    }

    /* operator */ public final boolean component8() {
        return this.isPremiumLocked;
    }

    public final ProgramLesson copy(ProgramSaveInfo programSaveInfo, int itemNumber, String description, ProgramLesson.Type type, boolean isNew, boolean isRecap, List<ProgramExam> moduleExams, boolean isPremiumLocked) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(description, "description");
        n.f(type, "type");
        ProgramLesson programLesson = new ProgramLesson(programSaveInfo, itemNumber, description, type, isNew, isRecap, moduleExams, isPremiumLocked);
        return programLesson;
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
        if (!(other instanceof ProgramLesson)) {
            return false;
        }
        if (!n.b(this.programSaveInfo, other.programSaveInfo)) {
            return false;
        }
        if (this.itemNumber != other.itemNumber) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (this.isNew != other.isNew) {
            return false;
        }
        if (this.isRecap != other.isRecap) {
            return false;
        }
        if (!n.b(this.moduleExams, other.moduleExams)) {
            return false;
        }
        return this.isPremiumLocked != other.isPremiumLocked ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isNew2;
        boolean isRecap2;
        int i2 = 0;
        boolean isPremiumLocked2 = true;
        int i = 1;
        if (this.isNew) {
        }
        if (this.isRecap) {
        }
        if (this.moduleExams == null) {
            i2 = 0;
        } else {
            i2 = this.moduleExams.hashCode();
        }
        if (!(this.isPremiumLocked)) {
        }
        return (this.programSaveInfo.hashCode() * 31) + Integer.hashCode(this.itemNumber) * 31 + this.description.hashCode() * 31 + this.type.hashCode() * 31 + isNew2 * 31 + isRecap2 * 31 + i2 * 31 + isPremiumLocked2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramLesson(programSaveInfo=";
        String str3 = ", itemNumber=";
        String str4 = ", description=";
        String str5 = ", type=";
        String str6 = ", isNew=";
        String str7 = ", isRecap=";
        String str8 = ", moduleExams=";
        String str9 = ", isPremiumLocked=";
        str = str2 + this.programSaveInfo + str3 + this.itemNumber + str4 + this.description + str5 + this.type + str6 + this.isNew + str7 + this.isRecap + str8 + this.moduleExams + str9 + this.isPremiumLocked + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.programSaveInfo.writeToParcel(parcel, flags);
        parcel.writeInt(this.itemNumber);
        parcel.writeString(this.description);
        parcel.writeString(this.type.name());
        parcel.writeInt(this.isNew);
        parcel.writeInt(this.isRecap);
        if (this.moduleExams == null) {
            int i = 0;
            parcel.writeInt(i);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(this.moduleExams.size());
            Iterator it = this.moduleExams.iterator();
            while (it.hasNext()) {
                (ProgramExam)it.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeInt(this.isPremiumLocked);
    }
}
