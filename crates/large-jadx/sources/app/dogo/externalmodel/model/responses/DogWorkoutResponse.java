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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u001d\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse;", "Landroid/os/Parcelable;", "workout", "", "Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutTrickModel;", "streak", "Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutStreak;", "(Ljava/util/List;Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutStreak;)V", "getStreak", "()Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutStreak;", "getWorkout", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "WorkoutStreak", "WorkoutTrickModel", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogWorkoutResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.DogWorkoutResponse> CREATOR;
    private final app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak streak;
    private final List<app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel> workout;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.DogWorkoutResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.DogWorkoutResponse createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(DogWorkoutResponse.WorkoutTrickModel.CREATOR.createFromParcel(parcel));
                i++;
            }
            DogWorkoutResponse dogWorkoutResponse = new DogWorkoutResponse(arrayList, (DogWorkoutResponse.WorkoutStreak)DogWorkoutResponse.WorkoutStreak.CREATOR.createFromParcel(parcel));
            return dogWorkoutResponse;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.DogWorkoutResponse[] newArray(int i) {
            return new DogWorkoutResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutStreak;", "Landroid/os/Parcelable;", "currentStreakCount", "", "longestStreakCount", "(II)V", "getCurrentStreakCount", "()I", "getLongestStreakCount", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class WorkoutStreak implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak> CREATOR;
        private final int currentStreakCount;
        private final int longestStreakCount;
        static {
            DogWorkoutResponse.WorkoutStreak.Creator creator = new DogWorkoutResponse.WorkoutStreak.Creator();
            DogWorkoutResponse.WorkoutStreak.CREATOR = creator;
        }

        public WorkoutStreak(int i, int i2) {
            super();
            this.currentStreakCount = i;
            this.longestStreakCount = i2;
        }

        public static app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak copy$default(app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak dogWorkoutResponse$WorkoutStreak, int i2, int i3, int i4, Object object5) {
            int obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = workoutStreak.currentStreakCount;
            }
            if (i4 &= 2 != 0) {
                obj2 = workoutStreak.longestStreakCount;
            }
            return workoutStreak.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final int component1() {
            return this.currentStreakCount;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.longestStreakCount;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak copy(int i, int i2) {
            DogWorkoutResponse.WorkoutStreak workoutStreak = new DogWorkoutResponse.WorkoutStreak(i, i2);
            return workoutStreak;
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
            if (!object instanceof DogWorkoutResponse.WorkoutStreak) {
                return i2;
            }
            if (this.currentStreakCount != object.currentStreakCount) {
                return i2;
            }
            if (this.longestStreakCount != object.longestStreakCount) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getCurrentStreakCount() {
            return this.currentStreakCount;
        }

        @Override // android.os.Parcelable
        public final int getLongestStreakCount() {
            return this.longestStreakCount;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WorkoutStreak(currentStreakCount=");
            stringBuilder.append(this.currentStreakCount);
            stringBuilder.append(", longestStreakCount=");
            stringBuilder.append(this.longestStreakCount);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeInt(this.currentStreakCount);
            parcel.writeInt(this.longestStreakCount);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutTrickModel;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "lastTrainedTimeMs", "", "(Ljava/lang/String;IJ)V", "getKnowledge", "()I", "getLastTrainedTimeMs", "()J", "getTrickId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class WorkoutTrickModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel> CREATOR;
        private final int knowledge;
        private final long lastTrainedTimeMs;
        private final String trickId;
        static {
            DogWorkoutResponse.WorkoutTrickModel.Creator creator = new DogWorkoutResponse.WorkoutTrickModel.Creator();
            DogWorkoutResponse.WorkoutTrickModel.CREATOR = creator;
        }

        public WorkoutTrickModel(String string, int i2, long l3) {
            n.f(string, "trickId");
            super();
            this.trickId = string;
            this.knowledge = i2;
            this.lastTrainedTimeMs = l3;
        }

        public static app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel copy$default(app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel dogWorkoutResponse$WorkoutTrickModel, String string2, int i3, long l4, int i5, Object object6) {
            String obj1;
            int obj2;
            long obj3;
            if (object6 & 1 != 0) {
                obj1 = workoutTrickModel.trickId;
            }
            if (object6 & 2 != 0) {
                obj2 = workoutTrickModel.knowledge;
            }
            if (object6 &= 4 != 0) {
                obj3 = workoutTrickModel.lastTrainedTimeMs;
            }
            return workoutTrickModel.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final long component3() {
            return this.lastTrainedTimeMs;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel copy(String string, int i2, long l3) {
            n.f(string, "trickId");
            DogWorkoutResponse.WorkoutTrickModel workoutTrickModel = new DogWorkoutResponse.WorkoutTrickModel(string, i2, l3, obj5);
            return workoutTrickModel;
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
            if (!object instanceof DogWorkoutResponse.WorkoutTrickModel) {
                return i2;
            }
            if (!n.b(this.trickId, object.trickId)) {
                return i2;
            }
            if (this.knowledge != object.knowledge) {
                return i2;
            }
            if (Long.compare(lastTrainedTimeMs, lastTrainedTimeMs2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getKnowledge() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final long getLastTrainedTimeMs() {
            return this.lastTrainedTimeMs;
        }

        @Override // android.os.Parcelable
        public final String getTrickId() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WorkoutTrickModel(trickId=");
            stringBuilder.append(this.trickId);
            stringBuilder.append(", knowledge=");
            stringBuilder.append(this.knowledge);
            stringBuilder.append(", lastTrainedTimeMs=");
            stringBuilder.append(this.lastTrainedTimeMs);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            parcel.writeInt(this.knowledge);
            parcel.writeLong(this.lastTrainedTimeMs);
        }
    }
    static {
        DogWorkoutResponse.Creator creator = new DogWorkoutResponse.Creator();
        DogWorkoutResponse.CREATOR = creator;
    }

    public DogWorkoutResponse(List<app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel> list, app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak dogWorkoutResponse$WorkoutStreak2) {
        n.f(list, "workout");
        n.f(workoutStreak2, "streak");
        super();
        this.workout = list;
        this.streak = workoutStreak2;
    }

    public DogWorkoutResponse(List list, app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak dogWorkoutResponse$WorkoutStreak2, int i3, g g4) {
        List obj1;
        if (i3 &= 1 != 0) {
            obj1 = p.g();
        }
        super(obj1, workoutStreak2);
    }

    public static app.dogo.externalmodel.model.responses.DogWorkoutResponse copy$default(app.dogo.externalmodel.model.responses.DogWorkoutResponse dogWorkoutResponse, List list2, app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak dogWorkoutResponse$WorkoutStreak3, int i4, Object object5) {
        List obj1;
        app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak obj2;
        if (i4 & 1 != 0) {
            obj1 = dogWorkoutResponse.workout;
        }
        if (i4 &= 2 != 0) {
            obj2 = dogWorkoutResponse.streak;
        }
        return dogWorkoutResponse.copy(obj1, obj2);
    }

    public final List<app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel> component1() {
        return this.workout;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak component2() {
        return this.streak;
    }

    public final app.dogo.externalmodel.model.responses.DogWorkoutResponse copy(List<app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel> list, app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak dogWorkoutResponse$WorkoutStreak2) {
        n.f(list, "workout");
        n.f(workoutStreak2, "streak");
        DogWorkoutResponse dogWorkoutResponse = new DogWorkoutResponse(list, workoutStreak2);
        return dogWorkoutResponse;
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
        if (object instanceof DogWorkoutResponse == null) {
            return i2;
        }
        if (!n.b(this.workout, object.workout)) {
            return i2;
        }
        if (!n.b(this.streak, object.streak)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak getStreak() {
        return this.streak;
    }

    public final List<app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel> getWorkout() {
        return this.workout;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogWorkoutResponse(workout=");
        stringBuilder.append(this.workout);
        stringBuilder.append(", streak=");
        stringBuilder.append(this.streak);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List workout = this.workout;
        parcel.writeInt(workout.size());
        Iterator iterator = workout.iterator();
        for (DogWorkoutResponse.WorkoutTrickModel size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        this.streak.writeToParcel(parcel, i2);
    }
}
