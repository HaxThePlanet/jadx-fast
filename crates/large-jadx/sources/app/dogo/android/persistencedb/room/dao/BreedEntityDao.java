package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.BreedEntity;
import i.b.a0;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: BreedEntityDao.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u000cH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u0011\"\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0013", d2 = {"Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;", "", "getAllBreeds", "Lio/reactivex/Single;", "", "Lapp/dogo/android/persistencedb/room/entity/BreedEntity;", "locale", "", "getBreed", "id", "getBreedOrEmpty", "getLatestBreedTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "breed", "", "([Lapp/dogo/android/persistencedb/room/entity/BreedEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q, reason: from kotlin metadata */
public interface BreedEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static a0<BreedEntity> a(q qVar, String str, String str2) {
            n.f(qVar, "this");
            n.f(str, "id");
            n.f(str2, "locale");
            a0 onErrorReturn = qVar.getBreed(str, str2).onErrorReturn(new app.dogo.android.persistencedb.room.dao.a(str, str2));
            n.e(onErrorReturn, "getBreed(id, locale).onErrorReturn {\n            BreedEntity(\n                breedId = id,\n                title = \"\",\n                locale = locale,\n                updatedAt = 0\n            )\n        }");
            return onErrorReturn;
        }

        private static BreedEntity b(String str, String str2, Throwable th) {
            n.f(str, "$id");
            n.f(str2, "$locale");
            n.f(th, "it");
            BreedEntity th32 = new BreedEntity(str, "", str2, 0L, str8, 0, 16, 0);
            return th32;
        }

        public static /* synthetic */ BreedEntity c(String str, String str2, Throwable th) {
            return app.dogo.android.persistencedb.room.dao.q.a.b(str, str2, th);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    a0<BreedEntity> getBreed(String id, String locale);

    /* renamed from: b, reason: from kotlin metadata */
    Object getBreedOrEmpty(BreedEntity[] id, d<? super w> locale);

    a0<BreedEntity> c(String str, String str2);

    /* renamed from: d, reason: from kotlin metadata */
    a0<List<BreedEntity>> getAllBreeds(String locale);

    /* renamed from: e, reason: from kotlin metadata */
    /* suspend */ Object insert(d<? super Long> breed);
}
