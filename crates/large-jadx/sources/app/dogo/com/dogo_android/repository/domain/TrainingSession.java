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
import kotlin.y.p;

/* compiled from: TrainingSession.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B9\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\rR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000b¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "Landroid/os/Parcelable;", "trainingTricksList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "exams", "hasUserUnlockedFirstModuleExam", "", "isRepeatedTraining", "(Ljava/util/List;Ljava/util/List;ZZ)V", "getExams", "()Ljava/util/List;", "getHasUserUnlockedFirstModuleExam", "()Z", "getTrainingTricksList", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrainingSession implements Parcelable {

    public static final Parcelable.Creator<TrainingSession> CREATOR = new TrainingSession$Creator<>();
    private final List<TrickItem> exams;
    private final boolean hasUserUnlockedFirstModuleExam;
    private final boolean isRepeatedTraining;
    private final List<TrickItem> trainingTricksList;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TrainingSession> {
        @Override // android.os.Parcelable$Creator
        public final TrainingSession createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = false;
            int i2;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i2 = 0;
            while (i2 != _int) {
                arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                i2 = i2 + 1;
            }
            int _int2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(_int2);
            while (TrickItem.CREATOR != _int2) {
                arrayList2.add(TrickItem.CREATOR.createFromParcel(parcel));
                i2 = i2 + 1;
            }
            int i = 1;
            int r0 = parcel.readInt() != 0 ? i : i2;
            if (parcel.readInt() != 0) {
            }
            return new TrainingSession(arrayList, arrayList2, z, z2);
        }

        @Override // android.os.Parcelable$Creator
        public final TrainingSession[] newArray(int i) {
            return new TrainingSession[i];
        }
    }
    public TrainingSession(List<TrickItem> list, List<TrickItem> list2, boolean z, boolean z2) {
        n.f(list, "trainingTricksList");
        n.f(list2, "exams");
        super();
        this.trainingTricksList = list;
        this.exams = list2;
        this.hasUserUnlockedFirstModuleExam = z;
        this.isRepeatedTraining = z2;
    }

    public final List<TrickItem> getExams() {
        return this.exams;
    }

    public final boolean getHasUserUnlockedFirstModuleExam() {
        return this.hasUserUnlockedFirstModuleExam;
    }

    public final List<TrickItem> getTrainingTricksList() {
        return this.trainingTricksList;
    }

    public final boolean isRepeatedTraining() {
        return this.isRepeatedTraining;
    }

    public /* synthetic */ TrainingSession(List list, List list2, boolean z, boolean z2, int i, g gVar) {
        List list3;
        List list4;
        if (i & 1 != 0) {
            list3 = p.g();
        }
        if (i & 2 != 0) {
            list4 = p.g();
        }
        i = i & 4 != 0 ? 1 : i;
        int i2 = i & 8 != 0 ? 0 : i2;
        this(list3, list4, z, z2);
    }


    public TrainingSession() {
        this(null, null, false, false, 15, null);
    }

    public static /* synthetic */ TrainingSession copy$default(TrainingSession trainingSession, List list, List list2, boolean z, boolean z2, int i, Object object) {
        List trainingTricksList2;
        List exams2;
        boolean hasUserUnlockedFirstModuleExam2;
        boolean isRepeatedTraining2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return trainingSession.copy(trainingTricksList2, exams2, hasUserUnlockedFirstModuleExam2, isRepeatedTraining2);
    }

    /* operator */ public final List<TrickItem> component1() {
        return this.trainingTricksList;
    }

    /* operator */ public final List<TrickItem> component2() {
        return this.exams;
    }

    /* operator */ public final boolean component3() {
        return this.hasUserUnlockedFirstModuleExam;
    }

    /* operator */ public final boolean component4() {
        return this.isRepeatedTraining;
    }

    public final TrainingSession copy(List<TrickItem> trainingTricksList, List<TrickItem> exams, boolean hasUserUnlockedFirstModuleExam, boolean isRepeatedTraining) {
        n.f(trainingTricksList, "trainingTricksList");
        n.f(exams, "exams");
        return new TrainingSession(trainingTricksList, exams, hasUserUnlockedFirstModuleExam, isRepeatedTraining);
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
        final boolean z5 = false;
        if (!(other instanceof TrainingSession)) {
            return false;
        }
        if (!n.b(this.trainingTricksList, other.trainingTricksList)) {
            return false;
        }
        if (!n.b(this.exams, other.exams)) {
            return false;
        }
        if (this.hasUserUnlockedFirstModuleExam != other.hasUserUnlockedFirstModuleExam) {
            return false;
        }
        return this.isRepeatedTraining != other.isRepeatedTraining ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean hasUserUnlockedFirstModuleExam2;
        int i = 1;
        i = 1;
        if (this.hasUserUnlockedFirstModuleExam) {
        }
        if (!(this.isRepeatedTraining)) {
        }
        return (this.trainingTricksList.hashCode() * 31) + this.exams.hashCode() * 31 + hasUserUnlockedFirstModuleExam2 * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrainingSession(trainingTricksList=";
        String str3 = ", exams=";
        String str4 = ", hasUserUnlockedFirstModuleExam=";
        String str5 = ", isRepeatedTraining=";
        str = str2 + this.trainingTricksList + str3 + this.exams + str4 + this.hasUserUnlockedFirstModuleExam + str5 + this.isRepeatedTraining + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.trainingTricksList.size());
        Iterator it = this.trainingTricksList.iterator();
        while (it.hasNext()) {
            (TrickItem)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.exams.size());
        Iterator it2 = this.exams.iterator();
        while (it2.hasNext()) {
            (TrickItem)it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.hasUserUnlockedFirstModuleExam);
        parcel.writeInt(this.isRepeatedTraining);
    }
}
