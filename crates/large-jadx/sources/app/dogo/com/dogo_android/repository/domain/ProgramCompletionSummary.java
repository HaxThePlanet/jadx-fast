package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ProgramCompletionSummary.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;", "Landroid/os/Parcelable;", "moduleProgress", "", "Lapp/dogo/com/dogo_android/repository/domain/ModuleCompletionSummary;", "programBackgroundColor", "", "(Ljava/util/List;Ljava/lang/String;)V", "getModuleProgress", "()Ljava/util/List;", "getProgramBackgroundColor", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramCompletionSummary implements Parcelable {

    public static final Parcelable.Creator<ProgramCompletionSummary> CREATOR = new ProgramCompletionSummary$Creator<>();
    private final List<ModuleCompletionSummary> moduleProgress;
    private final String programBackgroundColor;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramCompletionSummary> {
        @Override // android.os.Parcelable$Creator
        public final ProgramCompletionSummary createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(ModuleCompletionSummary.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new ProgramCompletionSummary(arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramCompletionSummary[] newArray(int i) {
            return new ProgramCompletionSummary[i];
        }
    }
    public ProgramCompletionSummary(List<ModuleCompletionSummary> list, String str) {
        n.f(list, "moduleProgress");
        n.f(str, "programBackgroundColor");
        super();
        this.moduleProgress = list;
        this.programBackgroundColor = str;
    }

    public final List<ModuleCompletionSummary> getModuleProgress() {
        return this.moduleProgress;
    }

    public final String getProgramBackgroundColor() {
        return this.programBackgroundColor;
    }


    public static /* synthetic */ ProgramCompletionSummary copy$default(ProgramCompletionSummary programCompletionSummary, List list, String str, int i, Object object) {
        List moduleProgress2;
        String programBackgroundColor2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return programCompletionSummary.copy(moduleProgress2, programBackgroundColor2);
    }

    /* operator */ public final List<ModuleCompletionSummary> component1() {
        return this.moduleProgress;
    }

    /* operator */ public final String component2() {
        return this.programBackgroundColor;
    }

    public final ProgramCompletionSummary copy(List<ModuleCompletionSummary> moduleProgress, String programBackgroundColor) {
        n.f(moduleProgress, "moduleProgress");
        n.f(programBackgroundColor, "programBackgroundColor");
        return new ProgramCompletionSummary(moduleProgress, programBackgroundColor);
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
        if (!(other instanceof ProgramCompletionSummary)) {
            return false;
        }
        if (!n.b(this.moduleProgress, other.moduleProgress)) {
            return false;
        }
        return !n.b(this.programBackgroundColor, other.programBackgroundColor) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.moduleProgress.hashCode() * 31) + this.programBackgroundColor.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramCompletionSummary(moduleProgress=";
        String str3 = ", programBackgroundColor=";
        str = str2 + this.moduleProgress + str3 + this.programBackgroundColor + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.moduleProgress.size());
        Iterator it = this.moduleProgress.iterator();
        while (it.hasNext()) {
            (ModuleCompletionSummary)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.programBackgroundColor);
    }
}
