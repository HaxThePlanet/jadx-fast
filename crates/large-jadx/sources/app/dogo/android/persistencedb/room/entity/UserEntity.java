package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008HÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001e", d2 = {"Lapp/dogo/android/persistencedb/room/entity/UserEntity;", "", "id", "", "currentDogId", "abBucket", "", "participatingInChallenges", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "getAbBucket", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCurrentDogId", "()Ljava/lang/String;", "getId", "getParticipatingInChallenges", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lapp/dogo/android/persistencedb/room/entity/UserEntity;", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserEntity {

    private final Long abBucket;
    private final String currentDogId;
    private final String id;
    private final List<String> participatingInChallenges;
    public UserEntity(String string, String string2, Long long3, List<String> list4) {
        n.f(string, "id");
        n.f(string2, "currentDogId");
        n.f(list4, "participatingInChallenges");
        super();
        this.id = string;
        this.currentDogId = string2;
        this.abBucket = long3;
        this.participatingInChallenges = list4;
    }

    public UserEntity(String string, String string2, Long long3, List list4, int i5, g g6) {
        int obj3;
        List obj4;
        obj3 = i5 & 4 != 0 ? 0 : obj3;
        if (i5 &= 8 != 0) {
            obj4 = p.g();
        }
        super(string, string2, obj3, obj4);
    }

    public static app.dogo.android.persistencedb.room.entity.UserEntity copy$default(app.dogo.android.persistencedb.room.entity.UserEntity userEntity, String string2, String string3, Long long4, List list5, int i6, Object object7) {
        String obj1;
        String obj2;
        Long obj3;
        List obj4;
        if (i6 & 1 != 0) {
            obj1 = userEntity.id;
        }
        if (i6 & 2 != 0) {
            obj2 = userEntity.currentDogId;
        }
        if (i6 & 4 != 0) {
            obj3 = userEntity.abBucket;
        }
        if (i6 &= 8 != 0) {
            obj4 = userEntity.participatingInChallenges;
        }
        return userEntity.copy(obj1, obj2, obj3, obj4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.currentDogId;
    }

    public final Long component3() {
        return this.abBucket;
    }

    public final List<String> component4() {
        return this.participatingInChallenges;
    }

    public final app.dogo.android.persistencedb.room.entity.UserEntity copy(String string, String string2, Long long3, List<String> list4) {
        n.f(string, "id");
        n.f(string2, "currentDogId");
        n.f(list4, "participatingInChallenges");
        UserEntity userEntity = new UserEntity(string, string2, long3, list4);
        return userEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof UserEntity) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.currentDogId, object.currentDogId)) {
            return i2;
        }
        if (!n.b(this.abBucket, object.abBucket)) {
            return i2;
        }
        if (!n.b(this.participatingInChallenges, object.participatingInChallenges)) {
            return i2;
        }
        return i;
    }

    public final Long getAbBucket() {
        return this.abBucket;
    }

    public final String getCurrentDogId() {
        return this.currentDogId;
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getParticipatingInChallenges() {
        return this.participatingInChallenges;
    }

    public int hashCode() {
        int i;
        Long abBucket = this.abBucket;
        if (abBucket == null) {
            i = 0;
        } else {
            i = abBucket.hashCode();
        }
        return i7 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserEntity(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", currentDogId=");
        stringBuilder.append(this.currentDogId);
        stringBuilder.append(", abBucket=");
        stringBuilder.append(this.abBucket);
        stringBuilder.append(", participatingInChallenges=");
        stringBuilder.append(this.participatingInChallenges);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
