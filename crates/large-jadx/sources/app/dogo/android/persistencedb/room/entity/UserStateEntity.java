package app.dogo.android.persistencedb.room.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: UserStateEntity.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001eB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001f", d2 = {"Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;", "Landroid/os/Parcelable;", "userId", "", "isWorkoutStreakSyncedToTrainingMetrics", "", "lastSeenGoalNotReachedState", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;", "(Ljava/lang/String;ZLapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;)V", "()Z", "getLastSeenGoalNotReachedState", "()Lapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "GoalNotReachedState", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserStateEntity implements Parcelable {

    public static final Parcelable.Creator<UserStateEntity> CREATOR = new UserStateEntity$Creator<>();
    private final boolean isWorkoutStreakSyncedToTrainingMetrics;
    private final UserStateEntity.GoalNotReachedState lastSeenGoalNotReachedState;
    private final String userId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserStateEntity> {
        @Override // android.os.Parcelable$Creator
        public final UserStateEntity createFromParcel(Parcel parcel) {
            boolean z = true;
            app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState goalNotReachedState = null;
            n.f(parcel, "parcel");
            int r2 = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                int i3 = 0;
            } else {
                Object fromParcel = UserStateEntity_GoalNotReachedState.CREATOR.createFromParcel(parcel);
            }
            UserStateEntity userStateEntity = new UserStateEntity(parcel.readString(), z, (UserStateEntity_GoalNotReachedState)goalNotReachedState);
            return userStateEntity;
        }

        @Override // android.os.Parcelable$Creator
        public final UserStateEntity[] newArray(int i) {
            return new UserStateEntity[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001a", d2 = {"Lapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;", "Landroid/os/Parcelable;", "date", "", "durationSec", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "getDurationSec", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GoalNotReachedState implements Parcelable {

        public static final Parcelable.Creator<UserStateEntity.GoalNotReachedState> CREATOR = new UserStateEntity$GoalNotReachedState$Creator<>();
        private final String date;
        private final int durationSec;
        public GoalNotReachedState(String str, int i) {
            n.f(str, "date");
            super();
            this.date = str;
            this.durationSec = i;
        }

        public final String getDate() {
            return this.date;
        }

        public final int getDurationSec() {
            return this.durationSec;
        }


        public static /* synthetic */ UserStateEntity.GoalNotReachedState copy$default(UserStateEntity.GoalNotReachedState goalNotReachedState, String str, int i, int i2, Object object) {
            String date2;
            int durationSec2;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            return goalNotReachedState.copy(date2, durationSec2);
        }

        /* operator */ public final String component1() {
            return this.date;
        }

        /* operator */ public final int component2() {
            return this.durationSec;
        }

        public final UserStateEntity.GoalNotReachedState copy(String date, int durationSec) {
            n.f(date, "date");
            return new UserStateEntity_GoalNotReachedState(date, durationSec);
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
            if (!(other instanceof UserStateEntity_GoalNotReachedState)) {
                return false;
            }
            if (!n.b(this.date, other.date)) {
                return false;
            }
            return this.durationSec != other.durationSec ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.date.hashCode() * 31) + Integer.hashCode(this.durationSec);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "GoalNotReachedState(date=";
            String str3 = ", durationSec=";
            str = str2 + this.date + str3 + this.durationSec + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.date);
            parcel.writeInt(this.durationSec);
        }
    }
    public UserStateEntity(String str, boolean z, UserStateEntity.GoalNotReachedState goalNotReachedState) {
        n.f(str, "userId");
        super();
        this.userId = str;
        this.isWorkoutStreakSyncedToTrainingMetrics = z;
        this.lastSeenGoalNotReachedState = goalNotReachedState;
    }

    public final UserStateEntity.GoalNotReachedState getLastSeenGoalNotReachedState() {
        return this.lastSeenGoalNotReachedState;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isWorkoutStreakSyncedToTrainingMetrics() {
        return this.isWorkoutStreakSyncedToTrainingMetrics;
    }

    public /* synthetic */ UserStateEntity(String str, boolean z, UserStateEntity.GoalNotReachedState goalNotReachedState, int i, g gVar) {
        i = i & 2 != 0 ? 0 : i;
        int i2 = i & 4 != 0 ? 0 : i2;
        this(str, z, goalNotReachedState);
    }


    public static /* synthetic */ UserStateEntity copy$default(UserStateEntity userStateEntity, String str, boolean z, UserStateEntity.GoalNotReachedState goalNotReachedState, int i, Object object) {
        String userId2;
        boolean isWorkoutStreakSyncedToTrainingMetrics2;
        app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState lastSeenGoalNotReachedState2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return userStateEntity.copy(userId2, isWorkoutStreakSyncedToTrainingMetrics2, lastSeenGoalNotReachedState2);
    }

    /* operator */ public final String component1() {
        return this.userId;
    }

    /* operator */ public final boolean component2() {
        return this.isWorkoutStreakSyncedToTrainingMetrics;
    }

    /* operator */ public final UserStateEntity.GoalNotReachedState component3() {
        return this.lastSeenGoalNotReachedState;
    }

    public final UserStateEntity copy(String userId, boolean isWorkoutStreakSyncedToTrainingMetrics, UserStateEntity.GoalNotReachedState lastSeenGoalNotReachedState) {
        n.f(userId, "userId");
        return new UserStateEntity(userId, isWorkoutStreakSyncedToTrainingMetrics, lastSeenGoalNotReachedState);
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
        if (!(other instanceof UserStateEntity)) {
            return false;
        }
        if (!n.b(this.userId, other.userId)) {
            return false;
        }
        if (this.isWorkoutStreakSyncedToTrainingMetrics != other.isWorkoutStreakSyncedToTrainingMetrics) {
            return false;
        }
        return !n.b(this.lastSeenGoalNotReachedState, other.lastSeenGoalNotReachedState) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isWorkoutStreakSyncedToTrainingMetrics2 = true;
        int i = 0;
        if (this.isWorkoutStreakSyncedToTrainingMetrics) {
            int i7 = 1;
        }
        if (this.lastSeenGoalNotReachedState == null) {
            i = 0;
        } else {
            i = this.lastSeenGoalNotReachedState.hashCode();
        }
        return (this.userId.hashCode() * 31) + isWorkoutStreakSyncedToTrainingMetrics2 * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserStateEntity(userId=";
        String str3 = ", isWorkoutStreakSyncedToTrainingMetrics=";
        String str4 = ", lastSeenGoalNotReachedState=";
        str = str2 + this.userId + str3 + this.isWorkoutStreakSyncedToTrainingMetrics + str4 + this.lastSeenGoalNotReachedState + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.userId);
        parcel.writeInt(this.isWorkoutStreakSyncedToTrainingMetrics);
        if (this.lastSeenGoalNotReachedState == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.lastSeenGoalNotReachedState.writeToParcel(parcel, flags);
        }
    }
}
