package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0014", d2 = {"Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoCacheUpdate;", "", "dogId", "", "cachedWorkoutTrickIdList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getCachedWorkoutTrickIdList", "()Ljava/util/List;", "getDogId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WorkoutInfoCacheUpdate {

    private final List<String> cachedWorkoutTrickIdList;
    private final String dogId;
    public WorkoutInfoCacheUpdate(String string, List<String> list2) {
        n.f(string, "dogId");
        n.f(list2, "cachedWorkoutTrickIdList");
        super();
        this.dogId = string;
        this.cachedWorkoutTrickIdList = list2;
    }

    public static app.dogo.android.persistencedb.room.entity.WorkoutInfoCacheUpdate copy$default(app.dogo.android.persistencedb.room.entity.WorkoutInfoCacheUpdate workoutInfoCacheUpdate, String string2, List list3, int i4, Object object5) {
        String obj1;
        List obj2;
        if (i4 & 1 != 0) {
            obj1 = workoutInfoCacheUpdate.dogId;
        }
        if (i4 &= 2 != 0) {
            obj2 = workoutInfoCacheUpdate.cachedWorkoutTrickIdList;
        }
        return workoutInfoCacheUpdate.copy(obj1, obj2);
    }

    public final String component1() {
        return this.dogId;
    }

    public final List<String> component2() {
        return this.cachedWorkoutTrickIdList;
    }

    public final app.dogo.android.persistencedb.room.entity.WorkoutInfoCacheUpdate copy(String string, List<String> list2) {
        n.f(string, "dogId");
        n.f(list2, "cachedWorkoutTrickIdList");
        WorkoutInfoCacheUpdate workoutInfoCacheUpdate = new WorkoutInfoCacheUpdate(string, list2);
        return workoutInfoCacheUpdate;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof WorkoutInfoCacheUpdate) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.cachedWorkoutTrickIdList, object.cachedWorkoutTrickIdList)) {
            return i2;
        }
        return i;
    }

    public final List<String> getCachedWorkoutTrickIdList() {
        return this.cachedWorkoutTrickIdList;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkoutInfoCacheUpdate(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", cachedWorkoutTrickIdList=");
        stringBuilder.append(this.cachedWorkoutTrickIdList);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
