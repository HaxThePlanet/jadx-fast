package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: PolicyEntity.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0015", d2 = {"Lapp/dogo/android/persistencedb/room/entity/PolicyEntity;", "", "id", "", "status", "ownerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getOwnerId", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyEntity {

    private final String id;
    private final String ownerId;
    private final String status;
    public PolicyEntity(String str, String str2, String str3) {
        n.f(str, "id");
        n.f(str2, "status");
        n.f(str3, "ownerId");
        super();
        this.id = str;
        this.status = str2;
        this.ownerId = str3;
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

    public static /* synthetic */ PolicyEntity copy$default(PolicyEntity policyEntity, String str, String str2, String str3, int i, Object object) {
        String id2;
        String status2;
        String ownerId2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return policyEntity.copy(id2, status2, ownerId2);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.status;
    }

    /* operator */ public final String component3() {
        return this.ownerId;
    }

    public final PolicyEntity copy(String id, String status, String ownerId) {
        n.f(id, "id");
        n.f(status, "status");
        n.f(ownerId, "ownerId");
        return new PolicyEntity(id, status, ownerId);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof PolicyEntity)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.status, other.status)) {
            return false;
        }
        return !n.b(this.ownerId, other.ownerId) ? z5 : z;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.status.hashCode() * 31 + this.ownerId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PolicyEntity(id=";
        String str3 = ", status=";
        String str4 = ", ownerId=";
        str = str2 + this.id + str3 + this.status + str4 + this.ownerId + 41;
        return str;
    }
}
