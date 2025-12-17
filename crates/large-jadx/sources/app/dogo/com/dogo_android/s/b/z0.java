package app.dogo.com.dogo_android.s.b;

import app.dogo.android.persistencedb.room.entity.BreedEntity;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.j1;
import e.a.a.a.b.b.q;
import i.b.a0;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0008J\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00082\u0006\u0010\u000c\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/local/BreedRepository;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "breedEntityDao", "Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;)V", "getAllBreeds", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "getBreed", "breedId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class z0 {

    private final p2 a;
    private final q b;
    public z0(p2 p2, q q2) {
        n.f(p2, "preferenceService");
        n.f(q2, "breedEntityDao");
        super();
        this.a = p2;
        this.b = q2;
    }

    private static final List b(String string, List list2) {
        int i;
        n.f(string, "$correctedLocale");
        n.f(list2, "list");
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        Iterator obj3 = list2.iterator();
        for (BreedEntity next2 : obj3) {
            arrayList.add(j1.L0(next2));
        }
        obj3 = new d(string);
        return p.D0(arrayList, obj3);
    }

    private static final int c(String string, DogBreed dogBreed2, DogBreed dogBreed3) {
        n.f(string, "$correctedLocale");
        Locale locale = new Locale(string);
        return Collator.getInstance(locale).compare(dogBreed2.getName(), dogBreed3.getName());
    }

    private static final DogBreed e(BreedEntity breedEntity) {
        n.f(breedEntity, "it");
        return j1.L0(breedEntity);
    }

    public static DogBreed f(BreedEntity breedEntity) {
        return z0.e(breedEntity);
    }

    public static int g(String string, DogBreed dogBreed2, DogBreed dogBreed3) {
        return z0.c(string, dogBreed2, dogBreed3);
    }

    public static List h(String string, List list2) {
        return z0.b(string, list2);
    }

    public final a0<List<DogBreed>> a() {
        String str2 = n2.a.a(this.a.W());
        e eVar = new e(str2);
        a0 a0Var = this.b.d(str2).map(eVar);
        n.e(a0Var, "breedEntityDao.getAllBreeds(correctedLocale).map { list ->\n            list.map { it.toDogBreed() }.sortedWith { breed1, breed2 ->\n                Collator.getInstance(Locale(correctedLocale)).compare(breed1.name, breed2.name)\n            }\n        }");
        return a0Var;
    }

    public final a0<DogBreed> d(String string) {
        n.f(string, "breedId");
        a0 obj3 = this.b.c(string, n2.a.a(this.a.W())).map(c.a);
        n.e(obj3, "breedEntityDao.getBreedOrEmpty(breedId, correctedLocale).map { it.toDogBreed() }");
        return obj3;
    }
}
