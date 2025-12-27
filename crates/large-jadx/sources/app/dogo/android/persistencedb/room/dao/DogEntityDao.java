package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.DogEntity;
import i.b.a0;
import i.b.b;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogEntityDao.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0004\u0008g\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0008\u001a\u00020\u0003H'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH'J\u0014\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u000e0\rH'J\u0016\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0010\u001a\u00020\u000bH'J!\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H'¢\u0006\u0002\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/android/persistencedb/room/dao/DogEntityDao;", "", "clearAndInsertDogs", "Lio/reactivex/Completable;", "dogs", "", "Lapp/dogo/android/persistencedb/room/entity/DogEntity;", "([Lapp/dogo/android/persistencedb/room/entity/DogEntity;)Lio/reactivex/Completable;", "clearDogData", "deleteDog", "dogId", "", "getAllDogs", "Lio/reactivex/Single;", "", "getDog", "id", "insert", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u, reason: from kotlin metadata */
public interface DogEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static b a(u uVar, DogEntity... dogEntityArr) {
            n.f(uVar, "this");
            n.f(dogEntityArr, "dogs");
            b bVar2 = uVar.e().c(uVar.getDog((DogEntity[])Arrays.copyOf(dogEntityArr, dogEntityArr.length)));
            n.e(bVar2, "clearDogData().andThen(insert(*dogs))");
            return bVar2;
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    a0<List<DogEntity>> clearDogData();

    /* renamed from: b, reason: from kotlin metadata */
    a0<DogEntity> clearAndInsertDogs(String dogs);

    /* renamed from: c, reason: from kotlin metadata */
    b deleteDog(DogEntity... dogId);

    /* renamed from: d, reason: from kotlin metadata */
    b getDog(DogEntity... id);

    b deleteDog(String str);

    b e();
}
