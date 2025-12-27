package app.dogo.externalmodel.model.responses;

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

/* compiled from: DogWorkoutResponse.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u001d\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse;", "Landroid/os/Parcelable;", "workout", "", "Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutTrickModel;", "streak", "Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutStreak;", "(Ljava/util/List;Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutStreak;)V", "getStreak", "()Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutStreak;", "getWorkout", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "WorkoutStreak", "WorkoutTrickModel", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogWorkoutResponse implements Parcelable {

    public static final Parcelable.Creator<DogWorkoutResponse> CREATOR = new DogWorkoutResponse$Creator<>();
    private final DogWorkoutResponse.WorkoutStreak streak;
    private final List<DogWorkoutResponse.WorkoutTrickModel> workout;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogWorkoutResponse> {
        @Override // android.os.Parcelable$Creator
        public final DogWorkoutResponse createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(DogWorkoutResponse_WorkoutTrickModel.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new DogWorkoutResponse(arrayList, (DogWorkoutResponse_WorkoutStreak)DogWorkoutResponse_WorkoutStreak.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public final DogWorkoutResponse[] newArray(int i) {
            return new DogWorkoutResponse[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutStreak;", "Landroid/os/Parcelable;", "currentStreakCount", "", "longestStreakCount", "(II)V", "getCurrentStreakCount", "()I", "getLongestStreakCount", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class WorkoutStreak implements Parcelable {

        public static final Parcelable.Creator<DogWorkoutResponse.WorkoutStreak> CREATOR = new DogWorkoutResponse$WorkoutStreak$Creator<>();
        private final int currentStreakCount;
        private final int longestStreakCount;
        public WorkoutStreak(int i, int i2) {
            super();
            this.currentStreakCount = i;
            this.longestStreakCount = i2;
        }

        public final int getCurrentStreakCount() {
            return this.currentStreakCount;
        }

        public final int getLongestStreakCount() {
            return this.longestStreakCount;
        }


        public static /* synthetic */ DogWorkoutResponse.WorkoutStreak copy$default(DogWorkoutResponse.WorkoutStreak workoutStreak, int i, int i2, int i3, Object object) {
            int currentStreakCount2;
            int longestStreakCount2;
            if (i3 & 1 != 0) {
            }
            if (i3 & 2 != 0) {
            }
            return workoutStreak.copy(currentStreakCount2, longestStreakCount2);
        }

        /* operator */ public final int component1() {
            return this.currentStreakCount;
        }

        /* operator */ public final int component2() {
            return this.longestStreakCount;
        }

        public final DogWorkoutResponse.WorkoutStreak copy(int currentStreakCount, int longestStreakCount) {
            return new DogWorkoutResponse_WorkoutStreak(currentStreakCount, longestStreakCount);
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
            final boolean z3 = false;
            if (!(other instanceof DogWorkoutResponse_WorkoutStreak)) {
                return false;
            }
            if (this.currentStreakCount != other.currentStreakCount) {
                return false;
            }
            return this.longestStreakCount != other.longestStreakCount ? z3 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (Integer.hashCode(this.currentStreakCount) * 31) + Integer.hashCode(this.longestStreakCount);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "WorkoutStreak(currentStreakCount=";
            String str3 = ", longestStreakCount=";
            str = str2 + this.currentStreakCount + str3 + this.longestStreakCount + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeInt(this.currentStreakCount);
            parcel.writeInt(this.longestStreakCount);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutTrickModel;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "lastTrainedTimeMs", "", "(Ljava/lang/String;IJ)V", "getKnowledge", "()I", "getLastTrainedTimeMs", "()J", "getTrickId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class WorkoutTrickModel implements Parcelable {

        public static final Parcelable.Creator<DogWorkoutResponse.WorkoutTrickModel> CREATOR = new DogWorkoutResponse$WorkoutTrickModel$Creator<>();
        private final int knowledge;
        private final long lastTrainedTimeMs;
        private final String trickId;
        public WorkoutTrickModel(String str, int i, long j) {
            n.f(str, "trickId");
            super();
            this.trickId = str;
            this.knowledge = i;
            this.lastTrainedTimeMs = j;
        }

        public final int getKnowledge() {
            return this.knowledge;
        }

        public final long getLastTrainedTimeMs() {
            return this.lastTrainedTimeMs;
        }

        public final String getTrickId() {
            return this.trickId;
        }


        public static /* synthetic */ DogWorkoutResponse.WorkoutTrickModel copy$default(DogWorkoutResponse.WorkoutTrickModel workoutTrickModel, String str, int i, long j, int i2, Object object) {
            String trickId2;
            int knowledge2;
            long lastTrainedTimeMs2;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            if (i2 & 4 != 0) {
            }
            return workoutTrickModel.copy(trickId2, knowledge2, lastTrainedTimeMs2);
        }

        /* operator */ public final String component1() {
            return this.trickId;
        }

        /* operator */ public final int component2() {
            return this.knowledge;
        }

        /* operator */ public final long component3() {
            return this.lastTrainedTimeMs;
        }

        public final DogWorkoutResponse.WorkoutTrickModel copy(String trickId, int knowledge, long lastTrainedTimeMs) {
            n.f(trickId, "trickId");
            return new DogWorkoutResponse_WorkoutTrickModel(trickId, knowledge, lastTrainedTimeMs, r5);
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
            if (!(other instanceof DogWorkoutResponse_WorkoutTrickModel)) {
                return false;
            }
            if (!n.b(this.trickId, other.trickId)) {
                return false;
            }
            if (this.knowledge != other.knowledge) {
                return false;
            }
            return this.lastTrainedTimeMs != other.lastTrainedTimeMs ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.trickId.hashCode() * 31) + Integer.hashCode(this.knowledge) * 31 + Long.hashCode(this.lastTrainedTimeMs);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "WorkoutTrickModel(trickId=";
            String str3 = ", knowledge=";
            String str4 = ", lastTrainedTimeMs=";
            str = str2 + this.trickId + str3 + this.knowledge + str4 + this.lastTrainedTimeMs + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            parcel.writeInt(this.knowledge);
            parcel.writeLong(this.lastTrainedTimeMs);
        }
    }
    public DogWorkoutResponse(List<DogWorkoutResponse.WorkoutTrickModel> list, DogWorkoutResponse.WorkoutStreak workoutStreak) {
        n.f(list, "workout");
        n.f(workoutStreak, "streak");
        super();
        this.workout = list;
        this.streak = workoutStreak;
    }

    public final DogWorkoutResponse.WorkoutStreak getStreak() {
        return this.streak;
    }

    public final List<DogWorkoutResponse.WorkoutTrickModel> getWorkout() {
        return this.workout;
    }

    public /* synthetic */ DogWorkoutResponse(List list, DogWorkoutResponse.WorkoutStreak workoutStreak, int i, g gVar) {
        List list2;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        this(list2, workoutStreak);
    }


    public static /* synthetic */ DogWorkoutResponse copy$default(DogWorkoutResponse dogWorkoutResponse, List list, DogWorkoutResponse.WorkoutStreak workoutStreak, int i, Object object) {
        List workout2;
        app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak streak2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return dogWorkoutResponse.copy(workout2, streak2);
    }

    /* operator */ public final List<DogWorkoutResponse.WorkoutTrickModel> component1() {
        return this.workout;
    }

    /* operator */ public final DogWorkoutResponse.WorkoutStreak component2() {
        return this.streak;
    }

    public final DogWorkoutResponse copy(List<DogWorkoutResponse.WorkoutTrickModel> workout, DogWorkoutResponse.WorkoutStreak streak) {
        n.f(workout, "workout");
        n.f(streak, "streak");
        return new DogWorkoutResponse(workout, streak);
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
        if (!(other instanceof DogWorkoutResponse)) {
            return false;
        }
        if (!n.b(this.workout, other.workout)) {
            return false;
        }
        return !n.b(this.streak, other.streak) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.workout.hashCode() * 31) + this.streak.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogWorkoutResponse(workout=";
        String str3 = ", streak=";
        str = str2 + this.workout + str3 + this.streak + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.workout.size());
        Iterator it = this.workout.iterator();
        while (it.hasNext()) {
            (DogWorkoutResponse_WorkoutTrickModel)it.next().writeToParcel(parcel, flags);
        }
        this.streak.writeToParcel(parcel, flags);
    }
}
