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

/* compiled from: BreedRepository.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0008J\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00082\u0006\u0010\u000c\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/local/BreedRepository;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "breedEntityDao", "Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;)V", "getAllBreeds", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "getBreed", "breedId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: z0, reason: from kotlin metadata */
public final class BreedRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final p2 breedEntityDao;
    /* renamed from: b, reason: from kotlin metadata */
    private final q preferenceService;
    public z0(p2 p2Var, q qVar) {
        n.f(p2Var, "preferenceService");
        n.f(qVar, "breedEntityDao");
        super();
        this.breedEntityDao = p2Var;
        this.preferenceService = qVar;
    }

    private static final List b(String str, List list) {
        n.f(str, "$correctedLocale");
        n.f(list, "list");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.j1.L0((BreedEntity)it.next()));
        }
        return p.D0(arrayList, new app.dogo.com.dogo_android.repository.local.d(str));
    }

    private static final int c(String str, DogBreed dogBreed, DogBreed dogBreed2) {
        n.f(str, "$correctedLocale");
        return Collator.getInstance(new Locale(str)).compare(dogBreed.getName(), dogBreed2.getName());
    }

    /* renamed from: e, reason: from kotlin metadata */
    private static final DogBreed getBreed(BreedEntity breedId) {
        n.f(breedId, "it");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.L0(breedId);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<List<DogBreed>> getAllBreeds() {
        String str2 = LocaleService.a.a(this.breedEntityDao.W());
        a0 map = this.preferenceService.getAllBreeds(str2).map(new app.dogo.com.dogo_android.repository.local.e(str2));
        n.e(map, "breedEntityDao.getAllBreeds(correctedLocale).map { list ->\n            list.map { it.toDogBreed() }.sortedWith { breed1, breed2 ->\n                Collator.getInstance(Locale(correctedLocale)).compare(breed1.name, breed2.name)\n            }\n        }");
        return map;
    }

    public final a0<DogBreed> d(String str) {
        n.f(str, "breedId");
        a0 map = this.preferenceService.c(str, LocaleService.a.a(this.breedEntityDao.W())).map(app.dogo.com.dogo_android.repository.local.c.a);
        n.e(map, "breedEntityDao.getBreedOrEmpty(breedId, correctedLocale).map { it.toDogBreed() }");
        return map;
    }

    public static /* synthetic */ DogBreed f(BreedEntity breedEntity) {
        return BreedRepository.getBreed(breedEntity);
    }

    public static /* synthetic */ int g(String str, DogBreed dogBreed, DogBreed dogBreed2) {
        return BreedRepository.c(str, dogBreed, dogBreed2);
    }

    public static /* synthetic */ List h(String str, List list) {
        return BreedRepository.b(str, list);
    }
}
