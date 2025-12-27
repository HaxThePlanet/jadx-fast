package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import i.b.a0;
import i.b.b;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogoPremiumStatusDao.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0016\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H'J!\u0010\u000f\u001a\u00020\r2\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00040\u0011\"\u00020\u0004H'¢\u0006\u0002\u0010\u0012¨\u0006\u0013", d2 = {"Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;", "", "getDogPremium", "Lio/reactivex/Single;", "Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "id", "", "ownerType", "getPremiumStateForDog", "dogId", "getPremiumStateForUser", "userId", "insert", "Lio/reactivex/Completable;", "dogoPremiumStatus", "insertAll", "dogoPremiumStatuses", "", "([Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;)Lio/reactivex/Completable;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a0, reason: from kotlin metadata */
public interface DogoPremiumStatusDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static a0<DogoPremiumStatusEntity> a(a0 a0Var, String str) {
            n.f(a0Var, "this");
            n.f(str, "dogId");
            a0 onErrorReturn = a0Var.getDogPremium(str, "dog").onErrorReturn(new app.dogo.android.persistencedb.room.dao.g(str));
            n.e(onErrorReturn, "getDogPremium(dogId, DogoPremiumStatusEntity.PREMIUM_OWNER_DOG)\n            .onErrorReturn { DogoPremiumStatusEntity(dogId, DogoPremiumStatusEntity.PREMIUM_OWNER_DOG, 0, \"\", 0) }");
            return onErrorReturn;
        }

        private static DogoPremiumStatusEntity b(String str, Throwable th) {
            n.f(str, "$dogId");
            n.f(th, "it");
            DogoPremiumStatusEntity th22 = new DogoPremiumStatusEntity(str, "dog", 0L, str6, "", 0, obj);
            return th22;
        }

        public static /* synthetic */ DogoPremiumStatusEntity c(String str, Throwable th) {
            return app.dogo.android.persistencedb.room.dao.a0.a.b(str, th);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    b getPremiumStateForDog(DogoPremiumStatusEntity... dogId);

    /* renamed from: b, reason: from kotlin metadata */
    b getPremiumStateForUser(DogoPremiumStatusEntity userId);

    /* renamed from: c, reason: from kotlin metadata */
    a0<DogoPremiumStatusEntity> insert(String dogoPremiumStatus);

    /* renamed from: d, reason: from kotlin metadata */
    a0<DogoPremiumStatusEntity> getDogPremium(String id, String ownerType);
}
