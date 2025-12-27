package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.s.b.z0;
import i.b.a0;
import i.b.g0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: GetDogProfileInteractor.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\u000c\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetDogProfileInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "breedRepository", "Lapp/dogo/com/dogo_android/repository/local/BreedRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/BreedRepository;)V", "addBreedTitle", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "dogProfile", "getDogProfile", "dogId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m2, reason: from kotlin metadata */
public final class GetDogProfileInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 breedRepository;
    /* renamed from: b, reason: from kotlin metadata */
    private final z0 userRepository;
    public m2(p1 p1Var, z0 z0Var) {
        n.f(p1Var, "userRepository");
        n.f(z0Var, "breedRepository");
        super();
        this.breedRepository = p1Var;
        this.userRepository = z0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final a0<DogProfile> addBreedTitle(DogProfile dogProfile) {
        a0 just;
        if (dogProfile.getCustomBreed() != null) {
            just = a0.just(dogProfile.getCustomBreed());
        } else {
            if (dogProfile.getBreedId() != null) {
                just = this.userRepository.d(dogProfile.getBreedId()).map(kotlinx.coroutines.j.a);
            } else {
                just = a0.just("");
            }
        }
        final a0 map = just.map(new kotlinx.coroutines.l(dogProfile));
        n.e(map, "when {\n            dogProfile.customBreed != null -> Single.just(dogProfile.customBreed)\n            dogProfile.breedId != null -> breedRepository.getBreed(dogProfile.breedId).map { it.name }\n            else -> Single.just(\"\")\n        }.map { dogProfile.copy(breedTitle = it) }");
        return map;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private static final String getDogProfile(DogBreed dogId) {
        n.f(dogId, "it");
        return dogId.getName();
    }

    private static final DogProfile c(DogProfile dogProfile, String str) {
        n.f(dogProfile, "$dogProfile");
        n.f(str, "it");
        return DogProfile.copy$default(dogProfile, null, null, null, null, null, str, null, null, null, d.UNKNOWN, 991, null);
    }

    private static final g0 e(m2 m2Var, DogProfile dogProfile) {
        n.f(m2Var, "this$0");
        n.f(dogProfile, "dogProfile");
        return m2Var.addBreedTitle(dogProfile);
    }

    public final a0<DogProfile> d(String str) {
        n.f(str, "dogId");
        a0 flatMapped = this.breedRepository.z(str).flatMap(new kotlinx.coroutines.k(this));
        n.e(flatMapped, "userRepository.getDogProfile(dogId)\n            .flatMap { dogProfile ->\n                addBreedTitle(dogProfile)\n            }");
        return flatMapped;
    }

    public static /* synthetic */ String f(DogBreed dogBreed) {
        return GetDogProfileInteractor.getDogProfile(dogBreed);
    }

    public static /* synthetic */ g0 g(m2 m2Var, DogProfile dogProfile) {
        return GetDogProfileInteractor.e(m2Var, dogProfile);
    }

    public static /* synthetic */ DogProfile h(DogProfile dogProfile, String str) {
        return GetDogProfileInteractor.c(dogProfile, str);
    }
}
