package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: UserCurrentDogIdUpdate.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/android/persistencedb/room/entity/UserCurrentDogIdUpdate;", "", "id", "", "currentDogId", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurrentDogId", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserCurrentDogIdUpdate {

    private final String currentDogId;
    private final String id;
    public UserCurrentDogIdUpdate(String str, String str2) {
        n.f(str, "id");
        n.f(str2, "currentDogId");
        super();
        this.id = str;
        this.currentDogId = str2;
    }

    public final String getCurrentDogId() {
        return this.currentDogId;
    }

    public final String getId() {
        return this.id;
    }

    public static /* synthetic */ UserCurrentDogIdUpdate copy$default(UserCurrentDogIdUpdate userCurrentDogIdUpdate, String str, String str2, int i, Object object) {
        String id2;
        String currentDogId2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return userCurrentDogIdUpdate.copy(id2, currentDogId2);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.currentDogId;
    }

    public final UserCurrentDogIdUpdate copy(String id, String currentDogId) {
        n.f(id, "id");
        n.f(currentDogId, "currentDogId");
        return new UserCurrentDogIdUpdate(id, currentDogId);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof UserCurrentDogIdUpdate)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        return !n.b(this.currentDogId, other.currentDogId) ? z4 : z;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.currentDogId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserCurrentDogIdUpdate(id=";
        String str3 = ", currentDogId=";
        str = str2 + this.id + str3 + this.currentDogId + 41;
        return str;
    }
}
