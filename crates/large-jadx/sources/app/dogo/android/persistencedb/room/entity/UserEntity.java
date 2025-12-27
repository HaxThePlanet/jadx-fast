package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: UserEntity.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008HÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001e", d2 = {"Lapp/dogo/android/persistencedb/room/entity/UserEntity;", "", "id", "", "currentDogId", "abBucket", "", "participatingInChallenges", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "getAbBucket", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCurrentDogId", "()Ljava/lang/String;", "getId", "getParticipatingInChallenges", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lapp/dogo/android/persistencedb/room/entity/UserEntity;", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserEntity {

    private final Long abBucket;
    private final String currentDogId;
    private final String id;
    private final List<String> participatingInChallenges;
    public UserEntity(String str, String str2, Long long, List<String> list) {
        n.f(str, "id");
        n.f(str2, "currentDogId");
        n.f(list, "participatingInChallenges");
        super();
        this.id = str;
        this.currentDogId = str2;
        this.abBucket = long;
        this.participatingInChallenges = list;
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

    public /* synthetic */ UserEntity(String str, String str2, Long long, List list, int i, g gVar) {
        Long l = null;
        i = i & 4 != 0 ? 0 : i;
        if (i & 8 != 0) {
            list = p.g();
        }
        this(str, str2, l, list);
    }

    public static /* synthetic */ UserEntity copy$default(UserEntity userEntity, String str, String str2, Long long, List list, int i, Object object) {
        String id2;
        String currentDogId2;
        Long abBucket2;
        List participatingInChallenges2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return userEntity.copy(id2, currentDogId2, abBucket2, participatingInChallenges2);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.currentDogId;
    }

    /* operator */ public final Long component3() {
        return this.abBucket;
    }

    /* operator */ public final List<String> component4() {
        return this.participatingInChallenges;
    }

    public final UserEntity copy(String id, String currentDogId, Long abBucket, List<String> participatingInChallenges) {
        n.f(id, "id");
        n.f(currentDogId, "currentDogId");
        n.f(participatingInChallenges, "participatingInChallenges");
        return new UserEntity(id, currentDogId, abBucket, participatingInChallenges);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof UserEntity)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.currentDogId, other.currentDogId)) {
            return false;
        }
        if (!n.b(this.abBucket, other.abBucket)) {
            return false;
        }
        return !n.b(this.participatingInChallenges, other.participatingInChallenges) ? z6 : z;
    }

    public int hashCode() {
        int i = 0;
        if (this.abBucket == null) {
            i = 0;
        } else {
            i = this.abBucket.hashCode();
        }
        return (this.id.hashCode() * 31) + this.currentDogId.hashCode() * 31 + i * 31 + this.participatingInChallenges.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserEntity(id=";
        String str3 = ", currentDogId=";
        String str4 = ", abBucket=";
        String str5 = ", participatingInChallenges=";
        str = str2 + this.id + str3 + this.currentDogId + str4 + this.abBucket + str5 + this.participatingInChallenges + 41;
        return str;
    }
}
