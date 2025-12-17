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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;", "Landroid/os/Parcelable;", "moduleProgress", "", "Lapp/dogo/com/dogo_android/repository/domain/ModuleCompletionSummary;", "programBackgroundColor", "", "(Ljava/util/List;Ljava/lang/String;)V", "getModuleProgress", "()Ljava/util/List;", "getProgramBackgroundColor", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramCompletionSummary implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary> CREATOR;
    private final List<app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary> moduleProgress;
    private final String programBackgroundColor;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(ModuleCompletionSummary.CREATOR.createFromParcel(parcel));
                i++;
            }
            ProgramCompletionSummary programCompletionSummary = new ProgramCompletionSummary(arrayList, parcel.readString());
            return programCompletionSummary;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary[] newArray(int i) {
            return new ProgramCompletionSummary[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ProgramCompletionSummary.Creator creator = new ProgramCompletionSummary.Creator();
        ProgramCompletionSummary.CREATOR = creator;
    }

    public ProgramCompletionSummary(List<app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary> list, String string2) {
        n.f(list, "moduleProgress");
        n.f(string2, "programBackgroundColor");
        super();
        this.moduleProgress = list;
        this.programBackgroundColor = string2;
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary copy$default(app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary, List list2, String string3, int i4, Object object5) {
        List obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = programCompletionSummary.moduleProgress;
        }
        if (i4 &= 2 != 0) {
            obj2 = programCompletionSummary.programBackgroundColor;
        }
        return programCompletionSummary.copy(obj1, obj2);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary> component1() {
        return this.moduleProgress;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.programBackgroundColor;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary copy(List<app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary> list, String string2) {
        n.f(list, "moduleProgress");
        n.f(string2, "programBackgroundColor");
        ProgramCompletionSummary programCompletionSummary = new ProgramCompletionSummary(list, string2);
        return programCompletionSummary;
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
        if (!object instanceof ProgramCompletionSummary) {
            return i2;
        }
        if (!n.b(this.moduleProgress, object.moduleProgress)) {
            return i2;
        }
        if (!n.b(this.programBackgroundColor, object.programBackgroundColor)) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary> getModuleProgress() {
        return this.moduleProgress;
    }

    @Override // android.os.Parcelable
    public final String getProgramBackgroundColor() {
        return this.programBackgroundColor;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramCompletionSummary(moduleProgress=");
        stringBuilder.append(this.moduleProgress);
        stringBuilder.append(", programBackgroundColor=");
        stringBuilder.append(this.programBackgroundColor);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List moduleProgress = this.moduleProgress;
        parcel.writeInt(moduleProgress.size());
        Iterator iterator = moduleProgress.iterator();
        for (ModuleCompletionSummary size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.programBackgroundColor);
    }
}
