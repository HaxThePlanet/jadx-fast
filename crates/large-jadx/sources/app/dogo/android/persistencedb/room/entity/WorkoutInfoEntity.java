package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: WorkoutInfoEntity.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0014", d2 = {"Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoEntity;", "", "dogId", "", "cachedWorkoutTrickIdList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getCachedWorkoutTrickIdList", "()Ljava/util/List;", "getDogId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WorkoutInfoEntity {

    private final List<String> cachedWorkoutTrickIdList;
    private final String dogId;
    public WorkoutInfoEntity(String str, List<String> list) {
        n.f(str, "dogId");
        n.f(list, "cachedWorkoutTrickIdList");
        super();
        this.dogId = str;
        this.cachedWorkoutTrickIdList = list;
    }

    public final List<String> getCachedWorkoutTrickIdList() {
        return this.cachedWorkoutTrickIdList;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public /* synthetic */ WorkoutInfoEntity(String str, List list, int i, g gVar) {
        if (i & 2 != 0) {
            list = p.g();
        }
        this(str, list);
    }

    public static /* synthetic */ WorkoutInfoEntity copy$default(WorkoutInfoEntity workoutInfoEntity, String str, List list, int i, Object object) {
        String dogId2;
        List cachedWorkoutTrickIdList2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return workoutInfoEntity.copy(dogId2, cachedWorkoutTrickIdList2);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final List<String> component2() {
        return this.cachedWorkoutTrickIdList;
    }

    public final WorkoutInfoEntity copy(String dogId, List<String> cachedWorkoutTrickIdList) {
        n.f(dogId, "dogId");
        n.f(cachedWorkoutTrickIdList, "cachedWorkoutTrickIdList");
        return new WorkoutInfoEntity(dogId, cachedWorkoutTrickIdList);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof WorkoutInfoEntity)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        return !n.b(this.cachedWorkoutTrickIdList, other.cachedWorkoutTrickIdList) ? z4 : z;
    }

    public int hashCode() {
        return (this.dogId.hashCode() * 31) + this.cachedWorkoutTrickIdList.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "WorkoutInfoEntity(dogId=";
        String str3 = ", cachedWorkoutTrickIdList=";
        str = str2 + this.dogId + str3 + this.cachedWorkoutTrickIdList + 41;
        return str;
    }
}
