package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0015", d2 = {"Lapp/dogo/android/persistencedb/room/entity/PolicyEntity;", "", "id", "", "status", "ownerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getOwnerId", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PolicyEntity {

    private final String id;
    private final String ownerId;
    private final String status;
    public PolicyEntity(String string, String string2, String string3) {
        n.f(string, "id");
        n.f(string2, "status");
        n.f(string3, "ownerId");
        super();
        this.id = string;
        this.status = string2;
        this.ownerId = string3;
    }

    public static app.dogo.android.persistencedb.room.entity.PolicyEntity copy$default(app.dogo.android.persistencedb.room.entity.PolicyEntity policyEntity, String string2, String string3, String string4, int i5, Object object6) {
        String obj1;
        String obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = policyEntity.id;
        }
        if (i5 & 2 != 0) {
            obj2 = policyEntity.status;
        }
        if (i5 &= 4 != 0) {
            obj3 = policyEntity.ownerId;
        }
        return policyEntity.copy(obj1, obj2, obj3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.ownerId;
    }

    public final app.dogo.android.persistencedb.room.entity.PolicyEntity copy(String string, String string2, String string3) {
        n.f(string, "id");
        n.f(string2, "status");
        n.f(string3, "ownerId");
        PolicyEntity policyEntity = new PolicyEntity(string, string2, string3);
        return policyEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof PolicyEntity) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.status, object.status)) {
            return i2;
        }
        if (!n.b(this.ownerId, object.ownerId)) {
            return i2;
        }
        return i;
    }

    public final String getId() {
        return this.id;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return i4 += i7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PolicyEntity(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", ownerId=");
        stringBuilder.append(this.ownerId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
