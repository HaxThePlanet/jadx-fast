package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.PolicyEntity;
import app.dogo.android.persistencedb.room.entity.UserEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: UserFullEntity.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0016", d2 = {"Lapp/dogo/android/persistencedb/room/relations/UserFullEntity;", "", "user", "Lapp/dogo/android/persistencedb/room/entity/UserEntity;", "policies", "", "Lapp/dogo/android/persistencedb/room/entity/PolicyEntity;", "(Lapp/dogo/android/persistencedb/room/entity/UserEntity;Ljava/util/List;)V", "getPolicies", "()Ljava/util/List;", "getUser", "()Lapp/dogo/android/persistencedb/room/entity/UserEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final /* data */ class UserFullEntity {

    private final UserEntity a;
    private final List<PolicyEntity> b;
    public h(UserEntity userEntity, List<PolicyEntity> list) {
        n.f(userEntity, "user");
        n.f(list, "policies");
        super();
        this.a = userEntity;
        this.b = list;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final List<PolicyEntity> component1() {
        return this.b;
    }

    public final UserEntity b() {
        return this.a;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof UserFullEntity)) {
            return false;
        }
        if (!n.b(this.a, other.a)) {
            return false;
        }
        return !n.b(this.b, other.b) ? z4 : z;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserFullEntity(user=";
        String str3 = ", policies=";
        str = str2 + this.a + str3 + this.b + 41;
        return str;
    }
}
