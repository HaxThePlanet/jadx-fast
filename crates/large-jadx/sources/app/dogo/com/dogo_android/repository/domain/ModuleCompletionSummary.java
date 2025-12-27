package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ModuleCompletionSummary.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\r¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ModuleCompletionSummary;", "Landroid/os/Parcelable;", "moduleId", "", "lessonCount", "", "passedLessonCount", "moduleNumber", "isCurrentModule", "", "(Ljava/lang/String;IIIZ)V", "()Z", "getLessonCount", "()I", "getModuleId", "()Ljava/lang/String;", "getModuleNumber", "getPassedLessonCount", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ModuleCompletionSummary implements Parcelable {

    public static final Parcelable.Creator<ModuleCompletionSummary> CREATOR = new ModuleCompletionSummary$Creator<>();
    private final boolean isCurrentModule;
    private final int lessonCount;
    private final String moduleId;
    private final int moduleNumber;
    private final int passedLessonCount;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ModuleCompletionSummary> {
        @Override // android.os.Parcelable$Creator
        public final ModuleCompletionSummary createFromParcel(Parcel parcel) {
            int i = 1;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            ModuleCompletionSummary moduleCompletionSummary = new ModuleCompletionSummary(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (parcel.readInt() != 0 ? 1 : 0));
            return moduleCompletionSummary;
        }

        @Override // android.os.Parcelable$Creator
        public final ModuleCompletionSummary[] newArray(int i) {
            return new ModuleCompletionSummary[i];
        }
    }
    public ModuleCompletionSummary(String str, int i, int i2, int i3, boolean z) {
        n.f(str, "moduleId");
        super();
        this.moduleId = str;
        this.lessonCount = i;
        this.passedLessonCount = i2;
        this.moduleNumber = i3;
        this.isCurrentModule = z;
    }

    public final int getLessonCount() {
        return this.lessonCount;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final int getModuleNumber() {
        return this.moduleNumber;
    }

    public final int getPassedLessonCount() {
        return this.passedLessonCount;
    }

    public final boolean isCurrentModule() {
        return this.isCurrentModule;
    }


    public static /* synthetic */ ModuleCompletionSummary copy$default(ModuleCompletionSummary moduleCompletionSummary, String str, int i, int i2, int i3, boolean z, int i4, Object object) {
        String str22;
        int object82;
        int i42;
        int i52;
        boolean z62;
        if (i4 & 1 != 0) {
        }
        if (i4 & 2 != 0) {
        }
        if (i4 & 4 != 0) {
        }
        if (i4 & 8 != 0) {
        }
        if (i4 & 16 != 0) {
        }
        return moduleCompletionSummary.copy(str22, object82, i42, i52, z62);
    }

    /* operator */ public final String component1() {
        return this.moduleId;
    }

    /* operator */ public final int component2() {
        return this.lessonCount;
    }

    /* operator */ public final int component3() {
        return this.passedLessonCount;
    }

    /* operator */ public final int component4() {
        return this.moduleNumber;
    }

    /* operator */ public final boolean component5() {
        return this.isCurrentModule;
    }

    public final ModuleCompletionSummary copy(String moduleId, int lessonCount, int passedLessonCount, int moduleNumber, boolean isCurrentModule) {
        n.f(moduleId, "moduleId");
        ModuleCompletionSummary moduleCompletionSummary = new ModuleCompletionSummary(moduleId, lessonCount, passedLessonCount, moduleNumber, isCurrentModule);
        return moduleCompletionSummary;
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
        final boolean z4 = false;
        if (!(other instanceof ModuleCompletionSummary)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        if (this.lessonCount != other.lessonCount) {
            return false;
        }
        if (this.passedLessonCount != other.passedLessonCount) {
            return false;
        }
        if (this.moduleNumber != other.moduleNumber) {
            return false;
        }
        return this.isCurrentModule != other.isCurrentModule ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isCurrentModule2 = true;
        if (this.isCurrentModule) {
            int i13 = 1;
        }
        return (this.moduleId.hashCode() * 31) + Integer.hashCode(this.lessonCount) * 31 + Integer.hashCode(this.passedLessonCount) * 31 + Integer.hashCode(this.moduleNumber) * 31 + isCurrentModule2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ModuleCompletionSummary(moduleId=";
        String str3 = ", lessonCount=";
        String str4 = ", passedLessonCount=";
        String str5 = ", moduleNumber=";
        String str6 = ", isCurrentModule=";
        str = str2 + this.moduleId + str3 + this.lessonCount + str4 + this.passedLessonCount + str5 + this.moduleNumber + str6 + this.isCurrentModule + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.moduleId);
        parcel.writeInt(this.lessonCount);
        parcel.writeInt(this.passedLessonCount);
        parcel.writeInt(this.moduleNumber);
        parcel.writeInt(this.isCurrentModule);
    }
}
