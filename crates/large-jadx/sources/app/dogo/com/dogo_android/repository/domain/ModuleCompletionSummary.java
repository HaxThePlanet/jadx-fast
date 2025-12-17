package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\r¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ModuleCompletionSummary;", "Landroid/os/Parcelable;", "moduleId", "", "lessonCount", "", "passedLessonCount", "moduleNumber", "isCurrentModule", "", "(Ljava/lang/String;IIIZ)V", "()Z", "getLessonCount", "()I", "getModuleId", "()Ljava/lang/String;", "getModuleNumber", "getPassedLessonCount", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ModuleCompletionSummary implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary> CREATOR;
    private final boolean isCurrentModule;
    private final int lessonCount;
    private final String moduleId;
    private final int moduleNumber;
    private final int passedLessonCount;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary createFromParcel(Parcel parcel) {
            int obj8;
            n.f(parcel, "parcel");
            obj8 = parcel.readInt() != 0 ? 1 : 0;
            super(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), obj8);
            return moduleCompletionSummary;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary[] newArray(int i) {
            return new ModuleCompletionSummary[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ModuleCompletionSummary.Creator creator = new ModuleCompletionSummary.Creator();
        ModuleCompletionSummary.CREATOR = creator;
    }

    public ModuleCompletionSummary(String string, int i2, int i3, int i4, boolean z5) {
        n.f(string, "moduleId");
        super();
        this.moduleId = string;
        this.lessonCount = i2;
        this.passedLessonCount = i3;
        this.moduleNumber = i4;
        this.isCurrentModule = z5;
    }

    public static app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary copy$default(app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary moduleCompletionSummary, String string2, int i3, int i4, int i5, boolean z6, int i7, Object object8) {
        String obj4;
        int obj5;
        int obj6;
        int obj7;
        boolean obj8;
        if (i7 & 1 != 0) {
            obj4 = moduleCompletionSummary.moduleId;
        }
        if (i7 & 2 != 0) {
            obj5 = moduleCompletionSummary.lessonCount;
        }
        if (i7 & 4 != 0) {
            obj6 = moduleCompletionSummary.passedLessonCount;
        }
        if (i7 & 8 != 0) {
            obj7 = moduleCompletionSummary.moduleNumber;
        }
        if (i7 & 16 != 0) {
            obj8 = moduleCompletionSummary.isCurrentModule;
        }
        return moduleCompletionSummary.copy(obj4, obj5, obj6, obj7, obj8);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.lessonCount;
    }

    @Override // android.os.Parcelable
    public final int component3() {
        return this.passedLessonCount;
    }

    @Override // android.os.Parcelable
    public final int component4() {
        return this.moduleNumber;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.isCurrentModule;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary copy(String string, int i2, int i3, int i4, boolean z5) {
        n.f(string, "moduleId");
        super(string, i2, i3, i4, z5);
        return moduleCompletionSummary;
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
        if (!object instanceof ModuleCompletionSummary) {
            return i2;
        }
        if (!n.b(this.moduleId, object.moduleId)) {
            return i2;
        }
        if (this.lessonCount != object.lessonCount) {
            return i2;
        }
        if (this.passedLessonCount != object.passedLessonCount) {
            return i2;
        }
        if (this.moduleNumber != object.moduleNumber) {
            return i2;
        }
        if (this.isCurrentModule != object.isCurrentModule) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getLessonCount() {
        return this.lessonCount;
    }

    @Override // android.os.Parcelable
    public final String getModuleId() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final int getModuleNumber() {
        return this.moduleNumber;
    }

    @Override // android.os.Parcelable
    public final int getPassedLessonCount() {
        return this.passedLessonCount;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isCurrentModule;
        if (this.isCurrentModule) {
            isCurrentModule = 1;
        }
        return i8 += isCurrentModule;
    }

    @Override // android.os.Parcelable
    public final boolean isCurrentModule() {
        return this.isCurrentModule;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ModuleCompletionSummary(moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", lessonCount=");
        stringBuilder.append(this.lessonCount);
        stringBuilder.append(", passedLessonCount=");
        stringBuilder.append(this.passedLessonCount);
        stringBuilder.append(", moduleNumber=");
        stringBuilder.append(this.moduleNumber);
        stringBuilder.append(", isCurrentModule=");
        stringBuilder.append(this.isCurrentModule);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.moduleId);
        parcel.writeInt(this.lessonCount);
        parcel.writeInt(this.passedLessonCount);
        parcel.writeInt(this.moduleNumber);
        parcel.writeInt(this.isCurrentModule);
    }
}
