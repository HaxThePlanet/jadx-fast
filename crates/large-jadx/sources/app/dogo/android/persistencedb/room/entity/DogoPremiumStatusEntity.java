package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "", "id", "", "ownerType", "expirationTimeMs", "", "expirationDate", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "getExpirationDate", "()Ljava/lang/String;", "getExpirationTimeMs", "()J", "getId", "getOwnerType", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogoPremiumStatusEntity {

    public static final app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity.Companion Companion = null;
    public static final String PREMIUM_OWNER_DOG = "dog";
    public static final String PREMIUM_OWNER_USER = "user";
    public static final long RENEWAL_GRACE_PERIOD_MS = 1800000L;
    private final String expirationDate;
    private final long expirationTimeMs;
    private final String id;
    private final String ownerType;
    private final long updatedAt;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity$Companion;", "", "()V", "PREMIUM_OWNER_DOG", "", "PREMIUM_OWNER_USER", "RENEWAL_GRACE_PERIOD_MS", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        DogoPremiumStatusEntity.Companion companion = new DogoPremiumStatusEntity.Companion(0);
        DogoPremiumStatusEntity.Companion = companion;
    }

    public DogoPremiumStatusEntity(String string, String string2, long l3, String string4, long l5) {
        n.f(string, "id");
        n.f(string2, "ownerType");
        n.f(l5, "expirationDate");
        super();
        this.id = string;
        this.ownerType = string2;
        this.expirationTimeMs = l3;
        this.expirationDate = l5;
        this.updatedAt = obj7;
    }

    public static app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity copy$default(app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity dogoPremiumStatusEntity, String string2, String string3, long l4, String string5, long l6, int i7, Object object8) {
        String obj6;
        String obj7;
        long obj8;
        String obj10;
        long obj11;
        if (obj13 & 1 != 0) {
            obj6 = dogoPremiumStatusEntity.id;
        }
        if (obj13 & 2 != 0) {
            obj7 = dogoPremiumStatusEntity.ownerType;
        }
        String obj14 = obj7;
        if (obj13 & 4 != 0) {
            obj8 = dogoPremiumStatusEntity.expirationTimeMs;
        }
        if (obj13 & 8 != 0) {
            obj10 = dogoPremiumStatusEntity.expirationDate;
        }
        if (obj13 & 16 != 0) {
            obj11 = dogoPremiumStatusEntity.updatedAt;
        }
        return dogoPremiumStatusEntity.copy(obj6, obj14, obj8, obj11, obj10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.ownerType;
    }

    public final long component3() {
        return this.expirationTimeMs;
    }

    public final String component4() {
        return this.expirationDate;
    }

    public final long component5() {
        return this.updatedAt;
    }

    public final app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity copy(String string, String string2, long l3, String string4, long l5) {
        n.f(string, "id");
        n.f(string2, "ownerType");
        n.f(l5, "expirationDate");
        super(string, string2, l3, obj5, l5, obj15, obj8);
        return dogoPremiumStatusEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DogoPremiumStatusEntity) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.ownerType, object.ownerType)) {
            return i2;
        }
        if (Long.compare(expirationTimeMs, expirationTimeMs2) != 0) {
            return i2;
        }
        if (!n.b(this.expirationDate, object.expirationDate)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        return i;
    }

    public final String getExpirationDate() {
        return this.expirationDate;
    }

    public final long getExpirationTimeMs() {
        return this.expirationTimeMs;
    }

    public final String getId() {
        return this.id;
    }

    public final String getOwnerType() {
        return this.ownerType;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return i8 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogoPremiumStatusEntity(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", ownerType=");
        stringBuilder.append(this.ownerType);
        stringBuilder.append(", expirationTimeMs=");
        stringBuilder.append(this.expirationTimeMs);
        stringBuilder.append(", expirationDate=");
        stringBuilder.append(this.expirationDate);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
