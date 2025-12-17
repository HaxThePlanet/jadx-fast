package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import i.b.a0;
import i.b.b;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0016\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H'J!\u0010\u000f\u001a\u00020\r2\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00040\u0011\"\u00020\u0004H'¢\u0006\u0002\u0010\u0012¨\u0006\u0013", d2 = {"Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;", "", "getDogPremium", "Lio/reactivex/Single;", "Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "id", "", "ownerType", "getPremiumStateForDog", "dogId", "getPremiumStateForUser", "userId", "insert", "Lio/reactivex/Completable;", "dogoPremiumStatus", "insertAll", "dogoPremiumStatuses", "", "([Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;)Lio/reactivex/Completable;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface a0 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static a0<DogoPremiumStatusEntity> a(e.a.a.a.b.b.a0 a0, String string2) {
            n.f(a0, "this");
            n.f(string2, "dogId");
            g gVar = new g(string2);
            a0 obj1 = a0.d(string2, "dog").onErrorReturn(gVar);
            n.e(obj1, "getDogPremium(dogId, DogoPremiumStatusEntity.PREMIUM_OWNER_DOG)\n            .onErrorReturn { DogoPremiumStatusEntity(dogId, DogoPremiumStatusEntity.PREMIUM_OWNER_DOG, 0, \"\", 0) }");
            return obj1;
        }

        private static DogoPremiumStatusEntity b(String string, Throwable throwable2) {
            n.f(string, "$dogId");
            n.f(throwable2, "it");
            super(string, "dog", 0, obj5, "", 0, obj8);
            return obj10;
        }

        public static DogoPremiumStatusEntity c(String string, Throwable throwable2) {
            return a0.a.b(string, throwable2);
        }
    }
    public abstract b a(DogoPremiumStatusEntity... dogoPremiumStatusEntityArr);

    public abstract b b(DogoPremiumStatusEntity dogoPremiumStatusEntity);

    public abstract a0<DogoPremiumStatusEntity> c(String string);

    public abstract a0<DogoPremiumStatusEntity> d(String string, String string2);
}
