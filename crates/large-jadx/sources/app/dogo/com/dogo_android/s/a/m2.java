package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.s.b.z0;
import i.b.a0;
import i.b.g0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\u000c\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetDogProfileInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "breedRepository", "Lapp/dogo/com/dogo_android/repository/local/BreedRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/BreedRepository;)V", "addBreedTitle", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "dogProfile", "getDogProfile", "dogId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m2 {

    private final p1 a;
    private final z0 b;
    public m2(p1 p1, z0 z02) {
        n.f(p1, "userRepository");
        n.f(z02, "breedRepository");
        super();
        this.a = p1;
        this.b = z02;
    }

    private final a0<DogProfile> a(DogProfile dogProfile) {
        a0 just;
        app.dogo.com.dogo_android.s.a.j jVar;
        if (dogProfile.getCustomBreed() != null) {
            just = a0.just(dogProfile.getCustomBreed());
        } else {
            if (dogProfile.getBreedId() != null) {
                just = this.b.d(dogProfile.getBreedId()).map(j.a);
            } else {
                just = a0.just("");
            }
        }
        l lVar = new l(dogProfile);
        final a0 obj3 = just.map(lVar);
        n.e(obj3, "when {\n            dogProfile.customBreed != null -> Single.just(dogProfile.customBreed)\n            dogProfile.breedId != null -> breedRepository.getBreed(dogProfile.breedId).map { it.name }\n            else -> Single.just(\"\")\n        }.map { dogProfile.copy(breedTitle = it) }");
        return obj3;
    }

    private static final String b(DogBreed dogBreed) {
        n.f(dogBreed, "it");
        return dogBreed.getName();
    }

    private static final DogProfile c(DogProfile dogProfile, String string2) {
        n.f(dogProfile, "$dogProfile");
        n.f(string2, "it");
        return DogProfile.copy$default(dogProfile, 0, 0, 0, 0, 0, string2, 0, 0, 0, 0, 991, 0);
    }

    private static final g0 e(app.dogo.com.dogo_android.s.a.m2 m2, DogProfile dogProfile2) {
        n.f(m2, "this$0");
        n.f(dogProfile2, "dogProfile");
        return m2.a(dogProfile2);
    }

    public static String f(DogBreed dogBreed) {
        return m2.b(dogBreed);
    }

    public static g0 g(app.dogo.com.dogo_android.s.a.m2 m2, DogProfile dogProfile2) {
        return m2.e(m2, dogProfile2);
    }

    public static DogProfile h(DogProfile dogProfile, String string2) {
        return m2.c(dogProfile, string2);
    }

    public final a0<DogProfile> d(String string) {
        n.f(string, "dogId");
        k kVar = new k(this);
        a0 obj2 = this.a.z(string).flatMap(kVar);
        n.e(obj2, "userRepository.getDogProfile(dogId)\n            .flatMap { dogProfile ->\n                addBreedTitle(dogProfile)\n            }");
        return obj2;
    }
}
