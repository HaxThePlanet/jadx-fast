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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u00012B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b\u0012\u0010\u0008\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003Ja\u0010%\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0010\u0008\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0013\u0010'\u001a\u00020\u000b2\u0008\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0006\u0010+\u001a\u00020\u000bJ\t\u0010,\u001a\u00020\u0007HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0014R\u0011\u0010\u000c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "Landroid/os/Parcelable;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "itemNumber", "", "description", "", "type", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;", "isNew", "", "isRecap", "moduleExams", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "isPremiumLocked", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;ILjava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;ZZLjava/util/List;Z)V", "getDescription", "()Ljava/lang/String;", "()Z", "getItemNumber", "()I", "getModuleExams", "()Ljava/util/List;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "isLessonUnlocked", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramLesson implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramLesson> CREATOR;
    private final String description;
    private final boolean isNew;
    private final boolean isPremiumLocked;
    private final boolean isRecap;
    private final int itemNumber;
    private final List<app.dogo.com.dogo_android.repository.domain.ProgramExam> moduleExams;
    private final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
    private final app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramLesson> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramLesson createFromParcel(Parcel parcel) {
            int i4;
            int i2;
            int i;
            ArrayList arrayList;
            int i5;
            int i3;
            Object fromParcel;
            n.f(parcel, "parcel");
            int i6 = 1;
            int i7 = 0;
            i4 = parcel.readInt() != 0 ? i6 : i7;
            i2 = parcel.readInt() != 0 ? i6 : i7;
            if (parcel.readInt() == 0) {
                i = 0;
            } else {
                int int5 = parcel.readInt();
                arrayList = new ArrayList(int5);
                i3 = i7;
                while (i3 != int5) {
                    arrayList.add(ProgramExam.CREATOR.createFromParcel(parcel));
                    i3++;
                }
                i = arrayList;
            }
            i5 = parcel.readInt() != 0 ? i6 : i7;
            super((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), ProgramLesson.Type.valueOf(parcel.readString()), i4, i2, i, i5);
            return obj13;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramLesson[] newArray(int i) {
            return new ProgramLesson[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;", "", "(Ljava/lang/String;I)V", "ACTIVE", "UNLOCKED", "LOCKED", "COMPLETED", "HEADER", "EXAM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum Type {

        ACTIVE,
        UNLOCKED,
        LOCKED,
        COMPLETED,
        HEADER,
        EXAM;
        private static final app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type[] arr = new ProgramLesson.Type[6];
            return arr;
        }
    }
    static {
        ProgramLesson.Creator creator = new ProgramLesson.Creator();
        ProgramLesson.CREATOR = creator;
    }

    public ProgramLesson(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, int i2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type programLesson$Type4, boolean z5, boolean z6, List<app.dogo.com.dogo_android.repository.domain.ProgramExam> list7, boolean z8) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string3, "description");
        n.f(type4, "type");
        super();
        this.programSaveInfo = programSaveInfo;
        this.itemNumber = i2;
        this.description = string3;
        this.type = type4;
        this.isNew = z5;
        this.isRecap = z6;
        this.moduleExams = list7;
        this.isPremiumLocked = z8;
    }

    public ProgramLesson(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, int i2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type programLesson$Type4, boolean z5, boolean z6, List list7, boolean z8, int i9, g g10) {
        int i6;
        int i5;
        String str;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type lOCKED;
        int i;
        int i3;
        int i4;
        int i7 = i9;
        i5 = 0;
        i6 = i7 & 2 != 0 ? i5 : i2;
        str = i7 & 4 != 0 ? "" : string3;
        lOCKED = i7 & 8 != 0 ? ProgramLesson.Type.LOCKED : type4;
        i = i7 & 16 != 0 ? i5 : z5;
        i3 = i7 & 32 != 0 ? i5 : z6;
        i4 = i7 & 64 != 0 ? 0 : list7;
        if (i7 &= 128 != 0) {
        } else {
            i5 = z8;
        }
        super(programSaveInfo, i6, str, lOCKED, i, i3, i4, i5);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramLesson copy$default(app.dogo.com.dogo_android.repository.domain.ProgramLesson programLesson, app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo2, int i3, String string4, app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type programLesson$Type5, boolean z6, boolean z7, List list8, boolean z9, int i10, Object object11) {
        boolean isPremiumLocked;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
        int itemNumber;
        String description;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type type;
        boolean isNew;
        boolean isRecap;
        List moduleExams;
        Object obj = programLesson;
        int i = i10;
        programSaveInfo = i & 1 != 0 ? obj.programSaveInfo : programSaveInfo2;
        itemNumber = i & 2 != 0 ? obj.itemNumber : i3;
        description = i & 4 != 0 ? obj.description : string4;
        type = i & 8 != 0 ? obj.type : type5;
        isNew = i & 16 != 0 ? obj.isNew : z6;
        isRecap = i & 32 != 0 ? obj.isRecap : z7;
        moduleExams = i & 64 != 0 ? obj.moduleExams : list8;
        isPremiumLocked = i &= 128 != 0 ? obj.isPremiumLocked : z9;
        return programLesson.copy(programSaveInfo, itemNumber, description, type, isNew, isRecap, moduleExams, isPremiumLocked);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo component1() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.itemNumber;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type component4() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.isNew;
    }

    @Override // android.os.Parcelable
    public final boolean component6() {
        return this.isRecap;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramExam> component7() {
        return this.moduleExams;
    }

    @Override // android.os.Parcelable
    public final boolean component8() {
        return this.isPremiumLocked;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramLesson copy(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, int i2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type programLesson$Type4, boolean z5, boolean z6, List<app.dogo.com.dogo_android.repository.domain.ProgramExam> list7, boolean z8) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string3, "description");
        n.f(type4, "type");
        super(programSaveInfo, i2, string3, type4, z5, z6, list7, z8);
        return programLesson;
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
        if (!object instanceof ProgramLesson) {
            return i2;
        }
        if (!n.b(this.programSaveInfo, object.programSaveInfo)) {
            return i2;
        }
        if (this.itemNumber != object.itemNumber) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        if (this.isNew != object.isNew) {
            return i2;
        }
        if (this.isRecap != object.isRecap) {
            return i2;
        }
        if (!n.b(this.moduleExams, object.moduleExams)) {
            return i2;
        }
        if (this.isPremiumLocked != object.isPremiumLocked) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final int getItemNumber() {
        return this.itemNumber;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramExam> getModuleExams() {
        return this.moduleExams;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isNew;
        boolean isRecap;
        int i;
        boolean i2;
        i2 = 1;
        if (this.isNew) {
            isNew = i2;
        }
        if (this.isRecap) {
            isRecap = i2;
        }
        List moduleExams = this.moduleExams;
        if (moduleExams == null) {
            i = 0;
        } else {
            i = moduleExams.hashCode();
        }
        boolean isPremiumLocked = this.isPremiumLocked;
        if (isPremiumLocked) {
        } else {
            i2 = isPremiumLocked;
        }
        return i16 += i2;
    }

    @Override // android.os.Parcelable
    public final boolean isLessonUnlocked() {
        int i;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type cOMPLETED;
        app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type type = this.type;
        if (type != ProgramLesson.Type.ACTIVE && type != ProgramLesson.Type.UNLOCKED) {
            if (type != ProgramLesson.Type.UNLOCKED) {
                if (type == ProgramLesson.Type.COMPLETED) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isNew() {
        return this.isNew;
    }

    @Override // android.os.Parcelable
    public final boolean isPremiumLocked() {
        return this.isPremiumLocked;
    }

    @Override // android.os.Parcelable
    public final boolean isRecap() {
        return this.isRecap;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramLesson(programSaveInfo=");
        stringBuilder.append(this.programSaveInfo);
        stringBuilder.append(", itemNumber=");
        stringBuilder.append(this.itemNumber);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", isNew=");
        stringBuilder.append(this.isNew);
        stringBuilder.append(", isRecap=");
        stringBuilder.append(this.isRecap);
        stringBuilder.append(", moduleExams=");
        stringBuilder.append(this.moduleExams);
        stringBuilder.append(", isPremiumLocked=");
        stringBuilder.append(this.isPremiumLocked);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Object moduleExams;
        boolean next;
        int size;
        int obj4;
        n.f(parcel, "out");
        this.programSaveInfo.writeToParcel(parcel, i2);
        parcel.writeInt(this.itemNumber);
        parcel.writeString(this.description);
        parcel.writeString(this.type.name());
        parcel.writeInt(this.isNew);
        parcel.writeInt(this.isRecap);
        moduleExams = this.moduleExams;
        if (moduleExams == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(moduleExams.size());
            moduleExams = moduleExams.iterator();
            for (ProgramExam size : moduleExams) {
                size.writeToParcel(parcel, i2);
            }
        }
        parcel.writeInt(this.isPremiumLocked);
    }
}
