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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B9\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\rR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000b¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "Landroid/os/Parcelable;", "trainingTricksList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "exams", "hasUserUnlockedFirstModuleExam", "", "isRepeatedTraining", "(Ljava/util/List;Ljava/util/List;ZZ)V", "getExams", "()Ljava/util/List;", "getHasUserUnlockedFirstModuleExam", "()Z", "getTrainingTricksList", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrainingSession implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrainingSession> CREATOR;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> exams;
    private final boolean hasUserUnlockedFirstModuleExam;
    private final boolean isRepeatedTraining;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> trainingTricksList;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrainingSession> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrainingSession createFromParcel(Parcel parcel) {
            int i2;
            int i4;
            int i3;
            Object fromParcel2;
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i4 = 0;
            i3 = i4;
            while (i3 != int) {
                arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                i3++;
            }
            int int2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(int2);
            i = i4;
            while (i != int2) {
                arrayList2.add(TrickItem.CREATOR.createFromParcel(parcel));
                i++;
            }
            int i5 = 1;
            i2 = parcel.readInt() != 0 ? i5 : i4;
            if (parcel.readInt() != 0) {
                i4 = i5;
            }
            TrainingSession obj7 = new TrainingSession(arrayList, arrayList2, i2, i4);
            return obj7;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrainingSession[] newArray(int i) {
            return new TrainingSession[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        TrainingSession.Creator creator = new TrainingSession.Creator();
        TrainingSession.CREATOR = creator;
    }

    public TrainingSession() {
        super(0, 0, 0, 0, 15, 0);
    }

    public TrainingSession(List<app.dogo.com.dogo_android.repository.domain.TrickItem> list, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list2, boolean z3, boolean z4) {
        n.f(list, "trainingTricksList");
        n.f(list2, "exams");
        super();
        this.trainingTricksList = list;
        this.exams = list2;
        this.hasUserUnlockedFirstModuleExam = z3;
        this.isRepeatedTraining = z4;
    }

    public TrainingSession(List list, List list2, boolean z3, boolean z4, int i5, g g6) {
        List obj1;
        List obj2;
        int obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj1 = p.g();
        }
        if (i5 & 2 != 0) {
            obj2 = p.g();
        }
        obj3 = i5 & 4 != 0 ? 1 : obj3;
        obj4 = i5 &= 8 != 0 ? 0 : obj4;
        super(obj1, obj2, obj3, obj4);
    }

    public static app.dogo.com.dogo_android.repository.domain.TrainingSession copy$default(app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession, List list2, List list3, boolean z4, boolean z5, int i6, Object object7) {
        List obj1;
        List obj2;
        boolean obj3;
        boolean obj4;
        if (i6 & 1 != 0) {
            obj1 = trainingSession.trainingTricksList;
        }
        if (i6 & 2 != 0) {
            obj2 = trainingSession.exams;
        }
        if (i6 & 4 != 0) {
            obj3 = trainingSession.hasUserUnlockedFirstModuleExam;
        }
        if (i6 &= 8 != 0) {
            obj4 = trainingSession.isRepeatedTraining;
        }
        return trainingSession.copy(obj1, obj2, obj3, obj4);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component1() {
        return this.trainingTricksList;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component2() {
        return this.exams;
    }

    @Override // android.os.Parcelable
    public final boolean component3() {
        return this.hasUserUnlockedFirstModuleExam;
    }

    @Override // android.os.Parcelable
    public final boolean component4() {
        return this.isRepeatedTraining;
    }

    public final app.dogo.com.dogo_android.repository.domain.TrainingSession copy(List<app.dogo.com.dogo_android.repository.domain.TrickItem> list, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list2, boolean z3, boolean z4) {
        n.f(list, "trainingTricksList");
        n.f(list2, "exams");
        TrainingSession trainingSession = new TrainingSession(list, list2, z3, z4);
        return trainingSession;
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
        if (!object instanceof TrainingSession) {
            return i2;
        }
        if (!n.b(this.trainingTricksList, object.trainingTricksList)) {
            return i2;
        }
        if (!n.b(this.exams, object.exams)) {
            return i2;
        }
        if (this.hasUserUnlockedFirstModuleExam != object.hasUserUnlockedFirstModuleExam) {
            return i2;
        }
        if (this.isRepeatedTraining != object.isRepeatedTraining) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getExams() {
        return this.exams;
    }

    @Override // android.os.Parcelable
    public final boolean getHasUserUnlockedFirstModuleExam() {
        return this.hasUserUnlockedFirstModuleExam;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getTrainingTricksList() {
        return this.trainingTricksList;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean hasUserUnlockedFirstModuleExam;
        int i;
        if (this.hasUserUnlockedFirstModuleExam) {
            hasUserUnlockedFirstModuleExam = i;
        }
        boolean isRepeatedTraining = this.isRepeatedTraining;
        if (isRepeatedTraining) {
        } else {
            i = isRepeatedTraining;
        }
        return i7 += i;
    }

    @Override // android.os.Parcelable
    public final boolean isRepeatedTraining() {
        return this.isRepeatedTraining;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrainingSession(trainingTricksList=");
        stringBuilder.append(this.trainingTricksList);
        stringBuilder.append(", exams=");
        stringBuilder.append(this.exams);
        stringBuilder.append(", hasUserUnlockedFirstModuleExam=");
        stringBuilder.append(this.hasUserUnlockedFirstModuleExam);
        stringBuilder.append(", isRepeatedTraining=");
        stringBuilder.append(this.isRepeatedTraining);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        int size2;
        n.f(parcel, "out");
        List trainingTricksList = this.trainingTricksList;
        parcel.writeInt(trainingTricksList.size());
        Iterator iterator = trainingTricksList.iterator();
        for (TrickItem size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        List exams = this.exams;
        parcel.writeInt(exams.size());
        Iterator iterator2 = exams.iterator();
        for (TrickItem size2 : iterator2) {
            size2.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.hasUserUnlockedFirstModuleExam);
        parcel.writeInt(this.isRepeatedTraining);
    }
}
