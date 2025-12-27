package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogoPremiumStatusEntity.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "", "id", "", "ownerType", "expirationTimeMs", "", "expirationDate", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "getExpirationDate", "()Ljava/lang/String;", "getExpirationTimeMs", "()J", "getId", "getOwnerType", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogoPremiumStatusEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final DogoPremiumStatusEntity.Companion INSTANCE = null;
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
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
    public DogoPremiumStatusEntity(String str, String str2, long j, String str3, long j2) {
        n.f(str, "id");
        n.f(str2, "ownerType");
        n.f(str3, "expirationDate");
        super();
        this.id = str;
        this.ownerType = str2;
        this.expirationTimeMs = j;
        this.expirationDate = str3;
        this.updatedAt = j2;
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

    static {
        DogoPremiumStatusEntity.INSTANCE = new DogoPremiumStatusEntity_Companion(null);
    }

    public static /* synthetic */ DogoPremiumStatusEntity copy$default(DogoPremiumStatusEntity dogoPremiumStatusEntity, String str, String str2, long j, String str3, long j2, int i, Object object) {
        String str22;
        String str32;
        long j42;
        String j62;
        String i72;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        return dogoPremiumStatusEntity.copy(str22, str32, j42, j62, i72);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.ownerType;
    }

    /* operator */ public final long component3() {
        return this.expirationTimeMs;
    }

    /* operator */ public final String component4() {
        return this.expirationDate;
    }

    /* operator */ public final long component5() {
        return this.updatedAt;
    }

    public final DogoPremiumStatusEntity copy(String id, String ownerType, long expirationTimeMs, String expirationDate, long updatedAt) {
        n.f(id, "id");
        n.f(ownerType, "ownerType");
        n.f(expirationDate, "expirationDate");
        DogoPremiumStatusEntity dogoPremiumStatusEntity = new DogoPremiumStatusEntity(id, ownerType, expirationTimeMs, str4, expirationDate, updatedAt, obj2);
        return dogoPremiumStatusEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof DogoPremiumStatusEntity)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.ownerType, other.ownerType)) {
            return false;
        }
        if (this.expirationTimeMs != other.expirationTimeMs) {
            return false;
        }
        if (!n.b(this.expirationDate, other.expirationDate)) {
            return false;
        }
        return this.updatedAt != other.updatedAt ? z6 : z;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.ownerType.hashCode() * 31 + Long.hashCode(this.expirationTimeMs) * 31 + this.expirationDate.hashCode() * 31 + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogoPremiumStatusEntity(id=";
        String str3 = ", ownerType=";
        String str4 = ", expirationTimeMs=";
        String str5 = ", expirationDate=";
        String str6 = ", updatedAt=";
        str = str2 + this.id + str3 + this.ownerType + str4 + this.expirationTimeMs + str5 + this.expirationDate + str6 + this.updatedAt + 41;
        return str;
    }
}
