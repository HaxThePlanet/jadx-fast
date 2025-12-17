package app.dogo.android.persistencedb.room.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001eB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001f", d2 = {"Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;", "Landroid/os/Parcelable;", "userId", "", "isWorkoutStreakSyncedToTrainingMetrics", "", "lastSeenGoalNotReachedState", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;", "(Ljava/lang/String;ZLapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;)V", "()Z", "getLastSeenGoalNotReachedState", "()Lapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "GoalNotReachedState", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserStateEntity implements Parcelable {

    public static final Parcelable.Creator<app.dogo.android.persistencedb.room.entity.UserStateEntity> CREATOR;
    private final boolean isWorkoutStreakSyncedToTrainingMetrics;
    private final app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState lastSeenGoalNotReachedState;
    private final String userId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.android.persistencedb.room.entity.UserStateEntity> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.android.persistencedb.room.entity.UserStateEntity createFromParcel(Parcel parcel) {
            int i;
            Parcelable.Creator cREATOR;
            Object obj5;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                obj5 = 0;
            } else {
                obj5 = UserStateEntity.GoalNotReachedState.CREATOR.createFromParcel(parcel);
            }
            UserStateEntity userStateEntity = new UserStateEntity(parcel.readString(), i, (UserStateEntity.GoalNotReachedState)obj5);
            return userStateEntity;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.android.persistencedb.room.entity.UserStateEntity[] newArray(int i) {
            return new UserStateEntity[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001a", d2 = {"Lapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;", "Landroid/os/Parcelable;", "date", "", "durationSec", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "getDurationSec", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GoalNotReachedState implements Parcelable {

        public static final Parcelable.Creator<app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState> CREATOR;
        private final String date;
        private final int durationSec;
        static {
            UserStateEntity.GoalNotReachedState.Creator creator = new UserStateEntity.GoalNotReachedState.Creator();
            UserStateEntity.GoalNotReachedState.CREATOR = creator;
        }

        public GoalNotReachedState(String string, int i2) {
            n.f(string, "date");
            super();
            this.date = string;
            this.durationSec = i2;
        }

        public static app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState copy$default(app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState userStateEntity$GoalNotReachedState, String string2, int i3, int i4, Object object5) {
            String obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = goalNotReachedState.date;
            }
            if (i4 &= 2 != 0) {
                obj2 = goalNotReachedState.durationSec;
            }
            return goalNotReachedState.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.date;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.durationSec;
        }

        @Override // android.os.Parcelable
        public final app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState copy(String string, int i2) {
            n.f(string, "date");
            UserStateEntity.GoalNotReachedState goalNotReachedState = new UserStateEntity.GoalNotReachedState(string, i2);
            return goalNotReachedState;
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
            if (!object instanceof UserStateEntity.GoalNotReachedState) {
                return i2;
            }
            if (!n.b(this.date, object.date)) {
                return i2;
            }
            if (this.durationSec != object.durationSec) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getDate() {
            return this.date;
        }

        @Override // android.os.Parcelable
        public final int getDurationSec() {
            return this.durationSec;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GoalNotReachedState(date=");
            stringBuilder.append(this.date);
            stringBuilder.append(", durationSec=");
            stringBuilder.append(this.durationSec);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.date);
            parcel.writeInt(this.durationSec);
        }
    }
    static {
        UserStateEntity.Creator creator = new UserStateEntity.Creator();
        UserStateEntity.CREATOR = creator;
    }

    public UserStateEntity(String string, boolean z2, app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState userStateEntity$GoalNotReachedState3) {
        n.f(string, "userId");
        super();
        this.userId = string;
        this.isWorkoutStreakSyncedToTrainingMetrics = z2;
        this.lastSeenGoalNotReachedState = goalNotReachedState3;
    }

    public UserStateEntity(String string, boolean z2, app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState userStateEntity$GoalNotReachedState3, int i4, g g5) {
        int obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(string, obj2, obj3);
    }

    public static app.dogo.android.persistencedb.room.entity.UserStateEntity copy$default(app.dogo.android.persistencedb.room.entity.UserStateEntity userStateEntity, String string2, boolean z3, app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState userStateEntity$GoalNotReachedState4, int i5, Object object6) {
        String obj1;
        boolean obj2;
        app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState obj3;
        if (i5 & 1 != 0) {
            obj1 = userStateEntity.userId;
        }
        if (i5 & 2 != 0) {
            obj2 = userStateEntity.isWorkoutStreakSyncedToTrainingMetrics;
        }
        if (i5 &= 4 != 0) {
            obj3 = userStateEntity.lastSeenGoalNotReachedState;
        }
        return userStateEntity.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.userId;
    }

    @Override // android.os.Parcelable
    public final boolean component2() {
        return this.isWorkoutStreakSyncedToTrainingMetrics;
    }

    @Override // android.os.Parcelable
    public final app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState component3() {
        return this.lastSeenGoalNotReachedState;
    }

    @Override // android.os.Parcelable
    public final app.dogo.android.persistencedb.room.entity.UserStateEntity copy(String string, boolean z2, app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState userStateEntity$GoalNotReachedState3) {
        n.f(string, "userId");
        UserStateEntity userStateEntity = new UserStateEntity(string, z2, goalNotReachedState3);
        return userStateEntity;
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
        if (!object instanceof UserStateEntity) {
            return i2;
        }
        if (!n.b(this.userId, object.userId)) {
            return i2;
        }
        if (this.isWorkoutStreakSyncedToTrainingMetrics != object.isWorkoutStreakSyncedToTrainingMetrics) {
            return i2;
        }
        if (!n.b(this.lastSeenGoalNotReachedState, object.lastSeenGoalNotReachedState)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState getLastSeenGoalNotReachedState() {
        return this.lastSeenGoalNotReachedState;
    }

    @Override // android.os.Parcelable
    public final String getUserId() {
        return this.userId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isWorkoutStreakSyncedToTrainingMetrics;
        int i;
        if (this.isWorkoutStreakSyncedToTrainingMetrics) {
            isWorkoutStreakSyncedToTrainingMetrics = 1;
        }
        app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState lastSeenGoalNotReachedState = this.lastSeenGoalNotReachedState;
        if (lastSeenGoalNotReachedState == null) {
            i = 0;
        } else {
            i = lastSeenGoalNotReachedState.hashCode();
        }
        return i5 += i;
    }

    @Override // android.os.Parcelable
    public final boolean isWorkoutStreakSyncedToTrainingMetrics() {
        return this.isWorkoutStreakSyncedToTrainingMetrics;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserStateEntity(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", isWorkoutStreakSyncedToTrainingMetrics=");
        stringBuilder.append(this.isWorkoutStreakSyncedToTrainingMetrics);
        stringBuilder.append(", lastSeenGoalNotReachedState=");
        stringBuilder.append(this.lastSeenGoalNotReachedState);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        parcel.writeString(this.userId);
        parcel.writeInt(this.isWorkoutStreakSyncedToTrainingMetrics);
        app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState lastSeenGoalNotReachedState = this.lastSeenGoalNotReachedState;
        if (lastSeenGoalNotReachedState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            lastSeenGoalNotReachedState.writeToParcel(parcel, i2);
        }
    }
}
