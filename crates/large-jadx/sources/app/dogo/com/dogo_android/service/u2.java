package app.dogo.com.dogo_android.service;

import app.dogo.android.network.DogoApiClient;
import app.dogo.android.persistencedb.room.entity.DogEntity;
import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import app.dogo.android.persistencedb.room.entity.UserCurrentDogIdUpdate;
import app.dogo.android.persistencedb.room.entity.UserEntity;
import app.dogo.com.dogo_android.k.p;
import app.dogo.com.dogo_android.model.RemindersModelKt;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.DogProfile.Companion;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile.Companion;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.v.a;
import app.dogo.com.dogo_android.v.b;
import app.dogo.com.dogo_android.v.b.a;
import app.dogo.com.dogo_android.v.b.c;
import app.dogo.com.dogo_android.v.b.c.a;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.externalmodel.model.RemoteDogModel;
import app.dogo.externalmodel.model.requests.DogCreateRequest;
import app.dogo.externalmodel.model.requests.UserLogoutRequest;
import app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest;
import app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy;
import app.dogo.externalmodel.model.responses.DogCreateResponse;
import app.dogo.externalmodel.model.responses.PublicDogResponse;
import app.dogo.externalmodel.model.responses.ReminderResponse;
import app.dogo.externalmodel.model.responses.UserApiModel;
import app.dogo.externalmodel.model.responses.UserApiModel.Challenges;
import app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel;
import app.dogo.externalmodel.model.responses.UserApiModel.Entitlement;
import app.dogo.externalmodel.model.responses.UserApiModel.Policy;
import e.a.a.a.b.b.a0;
import e.a.a.a.b.b.q0;
import e.a.a.a.b.b.u;
import e.a.a.a.b.d.h;
import i.b.a0;
import i.b.b;
import i.b.c;
import i.b.f;
import i.b.g0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.e0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.o;
import kotlin.w;
import kotlin.y.i;
import kotlin.y.j0;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001dJ)\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001b0%\"\u00020\u001bH\u0002¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010(\u001a\u0008\u0012\u0004\u0012\u00020)0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u001d2\u0008\u0010,\u001a\u0004\u0018\u00010\u001dH\u0002J\u000e\u0010-\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001a2\u0006\u0010+\u001a\u00020\u001dJ\u0014\u00100\u001a\u0008\u0012\u0004\u0012\u0002010\u001a2\u0006\u0010+\u001a\u00020\u001dJ\u0014\u00102\u001a\u0008\u0012\u0004\u0012\u0002030\u001a2\u0006\u0010+\u001a\u00020\u001dJ\u0006\u00104\u001a\u00020\u0005J\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u001dJ\u000e\u00107\u001a\u00020)2\u0006\u00106\u001a\u00020\u001dJ\u000e\u00108\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u00109\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dJ\u000e\u0010:\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001dJ\u0018\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010>\u001a\u00020?H\u0002J\u0016\u0010C\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dJ\u0010\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020BH\u0002J)\u0010F\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001b0%\"\u00020\u001bH\u0002¢\u0006\u0002\u0010&J\u0016\u0010G\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=J\u001a\u0010H\u001a\u00020#2\u0006\u0010E\u001a\u00020B2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020MJ \u0010N\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020QH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R", d2 = {"Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "userAndDogCache", "Lapp/dogo/com/dogo_android/temp/UserAndDogCache;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "fireBaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "dogoPremiumStatusDao", "Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;", "userDao", "Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "dogDao", "Lapp/dogo/android/persistencedb/room/dao/DogEntityDao;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/temp/UserAndDogCache;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;Lapp/dogo/android/persistencedb/room/dao/DogEntityDao;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "addNewDog", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "userId", "", "name", "addParticipatingChallenge", "", "challengeId", "cleanInsertDogsInPersistenceStorage", "Lio/reactivex/Completable;", "dogs", "", "(Ljava/lang/String;[Lapp/dogo/com/dogo_android/repository/domain/DogProfile;)Lio/reactivex/Completable;", "deactivateDevice", "doesCacheExists", "", "downloadAvatarToLocalStorage", "dogId", "avatarUrl", "fillCacheFromRoom", "getCurrentDogNameOrBlank", "getDogNameOrBlank", "getPremiumStateForDog", "Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "getPublicDogProfile", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "getUserAndDogCache", "isPolicyAccepted", "policy", "isPolicyShown", "isUserDataSynced", "removeDog", "removeParticipatingChallenge", "saveDogEntitlementResponseData", "dogApiModel", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "currentTimeMs", "", "saveUserEntitlementResponseData", "userApiResponse", "Lapp/dogo/externalmodel/model/responses/UserApiModel;", "setDogAsCurrent", "updateAbBucketUserProperties", "userApiModel", "updateDogInPersistenceStorage", "updateLocalDogData", "updateLocalUserData", "newCurrentDogId", "updatePolicy", "policyId", "policyStatus", "Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "updateUserInPersistenceStorage", "currentDogId", "user", "Lapp/dogo/com/dogo_android/temp/User;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class u2 {

    private final app.dogo.com.dogo_android.service.p2 a;
    private final c b;
    private final DogoApiClient c;
    private final app.dogo.com.dogo_android.service.t2 d;
    private final app.dogo.com.dogo_android.service.l2 e;
    private final a0 f;
    private final q0 g;
    private final u h;
    private final l1 i;
    private final app.dogo.com.dogo_android.service.v2 j;
    private final o3 k;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<w> {

        final String $avatarUrl;
        final String $dogId;
        final c $emitter;
        final app.dogo.com.dogo_android.service.u2 this$0;
        a(app.dogo.com.dogo_android.service.u2 u2, String string2, String string3, c c4) {
            this.this$0 = u2;
            this.$dogId = string2;
            this.$avatarUrl = string3;
            this.$emitter = c4;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            u2.a(this.this$0).E0(this.$dogId, this.$avatarUrl);
            this.$emitter.onComplete();
        }
    }
    public u2(app.dogo.com.dogo_android.service.p2 p2, c c2, DogoApiClient dogoApiClient3, app.dogo.com.dogo_android.service.t2 t24, app.dogo.com.dogo_android.service.l2 l25, a0 a06, q0 q07, u u8, l1 l19, app.dogo.com.dogo_android.service.v2 v210, o3 o311) {
        n.f(p2, "preferenceService");
        n.f(c2, "userAndDogCache");
        n.f(dogoApiClient3, "apiClient");
        n.f(t24, "storageService");
        n.f(l25, "fireBaseStorageService");
        n.f(a06, "dogoPremiumStatusDao");
        n.f(q07, "userDao");
        n.f(u8, "dogDao");
        n.f(l19, "reminderRepository");
        n.f(v210, "utilities");
        n.f(o311, "tracker");
        super();
        this.a = p2;
        this.b = c2;
        this.c = dogoApiClient3;
        this.d = t24;
        this.e = l25;
        this.f = a06;
        this.g = q07;
        this.h = u8;
        this.i = l19;
        this.j = v210;
        this.k = o311;
    }

    public static String E(DogEntity dogEntity) {
        return u2.s(dogEntity);
    }

    public static f F(app.dogo.com.dogo_android.service.u2 u2, String string2, h h3) {
        return u2.n(u2, string2, h3);
    }

    public static f G(app.dogo.com.dogo_android.service.u2 u2, UserApiModel userApiModel2) {
        return u2.f0(u2, userApiModel2);
    }

    public static f H(UserApiModel userApiModel, app.dogo.com.dogo_android.service.u2 u22, String string3, String string4) {
        return u2.d0(userApiModel, u22, string3, string4);
    }

    public static g0 I(app.dogo.com.dogo_android.service.u2 u2, String string2, DogCreateResponse dogCreateResponse3) {
        return u2.d(u2, string2, dogCreateResponse3);
    }

    public static f J(app.dogo.com.dogo_android.service.u2 u2, String string2, w w3) {
        return u2.p(u2, string2, w3);
    }

    public static String K(Throwable throwable) {
        return u2.v(throwable);
    }

    public static g0 L(app.dogo.com.dogo_android.service.u2 u2, String string2) {
        return u2.r(u2, string2);
    }

    public static w M(app.dogo.com.dogo_android.service.u2 u2, h h2, List list3) {
        return u2.o(u2, h2, list3);
    }

    public static DogProfile N(DogCreateResponse dogCreateResponse) {
        return u2.e(dogCreateResponse);
    }

    public static PublicDogProfile O(PublicDogResponse publicDogResponse) {
        return u2.z(publicDogResponse);
    }

    public static DogProfile P(app.dogo.com.dogo_android.service.u2 u2, String string2, DogProfile dogProfile3) {
        u2.f(u2, string2, dogProfile3);
        return dogProfile3;
    }

    public static String Q(DogEntity dogEntity) {
        return u2.w(dogEntity);
    }

    public static void R(app.dogo.com.dogo_android.service.u2 u2, String string2, String string3, c c4) {
        u2.l(u2, string2, string3, c4);
    }

    public static String S(Throwable throwable) {
        return u2.t(throwable);
    }

    private final b V(UserApiModel.DogApiModel userApiModel$DogApiModel, long l2) {
        Object entitlement;
        long longValue;
        String str;
        final String str2 = "";
        entitlement = new UserApiModel.Entitlement(Long.valueOf(0), str2, str2);
        Object obj = dogApiModel.getEntitlements().get("premium_dog");
        if ((UserApiModel.Entitlement)obj == null) {
        } else {
            entitlement = obj;
        }
        Long obj12 = entitlement.getExpirationTimeMs();
        if (obj12 == null) {
            longValue = Long.MAX_VALUE;
        } else {
            longValue = obj12.longValue();
        }
        obj12 = entitlement.getExpirationDate();
        str = obj12 == null ? str2 : obj12;
        super(dogApiModel.getId(), "dog", longValue, obj7, str, l2, obj10);
        DogoPremiumStatusEntity[] obj13 = new DogoPremiumStatusEntity[1];
        return this.f.a(dogoPremiumStatusEntity);
    }

    private final b W(UserApiModel userApiModel, long l2) {
        Object obj;
        int expirationDate;
        long longValue;
        String str;
        long dogoPremiumStatusEntity;
        String longValue2;
        String str3;
        long l3;
        String str4;
        String str2;
        long l;
        int i;
        Object obj4;
        String str5 = "";
        UserApiModel.Entitlement entitlement = new UserApiModel.Entitlement(Long.valueOf(0), str5, str5);
        if ((UserApiModel.Entitlement)userApiModel.getEntitlements().get("premium") == null) {
            obj = entitlement;
        }
        Long expirationTimeMs = obj.getExpirationTimeMs();
        final long l4 = Long.MAX_VALUE;
        if (expirationTimeMs == null) {
            dogoPremiumStatusEntity = l4;
        } else {
            dogoPremiumStatusEntity = longValue;
        }
        String expirationDate2 = obj.getExpirationDate();
        str3 = expirationDate2 == null ? str5 : expirationDate2;
        super(userApiModel.getId(), "user", dogoPremiumStatusEntity, obj7, str3, l2, obj10);
        Collection values = userApiModel.getDogs().values();
        ArrayList arrayList = new ArrayList(p.r(values, 10));
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if ((UserApiModel.Entitlement)(UserApiModel.DogApiModel)next2.getEntitlements().get("premium_dog") == null) {
            }
            Long expirationTimeMs2 = str.getExpirationTimeMs();
            if (expirationTimeMs2 == null) {
            } else {
            }
            l = longValue2;
            expirationDate = str.getExpirationDate();
            if (expirationDate == 0) {
            } else {
            }
            i = expirationDate;
            super(next2.getId(), "dog", l, obj18, i, l2, obj21);
            arrayList.add(dogoPremiumStatusEntity);
            i = str5;
            l = l4;
            str = entitlement;
        }
        Object[] array = p.u0(arrayList, dogoPremiumStatusEntity3).toArray(new DogoPremiumStatusEntity[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return obj2.f.a((DogoPremiumStatusEntity[])Arrays.copyOf((DogoPremiumStatusEntity[])array, array.length));
    }

    private final void Y(UserApiModel userApiModel) {
        int cmp;
        q3 abTestBucket2;
        int abTestBucket;
        Long obj5;
        if (Long.compare(abTestBucket3, abTestBucket) > 0) {
            this.k.q(q3.AbTestBucket, Long.valueOf(userApiModel.getAbTestBucket()));
        }
    }

    private final b Z(String string, DogProfile... dogProfile2Arr2) {
        int dogEntity;
        List obj5 = i.a0(dogProfile2Arr2);
        ArrayList arrayList = new ArrayList(p.r(obj5, 10));
        obj5 = obj5.iterator();
        for (DogProfile next2 : obj5) {
            arrayList.add(next2.toDogEntity(string));
        }
        Object[] obj4 = arrayList.toArray(new DogEntity[0]);
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Array<T>");
        return this.h.d((DogEntity[])Arrays.copyOf((DogEntity[])obj4, obj4.length));
    }

    public static final app.dogo.com.dogo_android.service.p2 a(app.dogo.com.dogo_android.service.u2 u2) {
        return u2.a;
    }

    public static a0 c(app.dogo.com.dogo_android.service.u2 u2, String string2, String string3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return u2.b(string2, obj2);
    }

    public static b c0(app.dogo.com.dogo_android.service.u2 u2, UserApiModel userApiModel2, String string3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return u2.b0(userApiModel2, obj2);
    }

    private static final g0 d(app.dogo.com.dogo_android.service.u2 u2, String string2, DogCreateResponse dogCreateResponse3) {
        n.f(u2, "this$0");
        n.f(string2, "$userId");
        n.f(dogCreateResponse3, "it");
        z1 z1Var = new z1(dogCreateResponse3);
        b2 b2Var = new b2(u2, string2);
        return u2.a0(string2, dogCreateResponse3.getDog()).B(z1Var).map(b2Var);
    }

    private static final f d0(UserApiModel userApiModel, app.dogo.com.dogo_android.service.u2 u22, String string3, String string4) {
        Object trainingReminder;
        ArrayList arrayList;
        int i;
        int apiDog;
        Object list;
        DogProfile.Companion companion2;
        int i2;
        Long valueOf;
        boolean iterator;
        long key;
        b.c.a companion;
        Object obj11;
        n.f(userApiModel, "$userApiModel");
        n.f(u22, "this$0");
        n.f(string4, "currentSavedDogId");
        Collection values = userApiModel.getDogs().values();
        i = 10;
        arrayList = new ArrayList(p.r(values, i));
        Iterator iterator2 = values.iterator();
        for (UserApiModel.DogApiModel next4 : iterator2) {
            arrayList.add(DogProfile.Companion.fromApiDog(next4));
        }
        Map policies = userApiModel.getPolicies();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(policies.size()));
        Iterator iterator3 = policies.entrySet().iterator();
        for (Map.Entry next6 : iterator3) {
            linkedHashMap.put(next6.getKey(), b.c.Companion.a((UserApiModel.Policy)next6.getValue().getStatus()));
        }
        b bVar = new b(userApiModel.getId(), linkedHashMap, p.N0(userApiModel.getChallenges().getParticipatedInChallengeIds()), Long.valueOf(userApiModel.getAbTestBucket()));
        trainingReminder = userApiModel.getTrainingReminder();
        if (trainingReminder == null) {
        } else {
            u22.k.o(RemindersModelKt.toItem(trainingReminder));
        }
        u22.Y(userApiModel);
        int i3 = 1;
        int i5 = 0;
        if (string3 != null) {
            if (arrayList.isEmpty()) {
                valueOf = i5;
            } else {
                iterator = arrayList.iterator();
                for (DogProfile next7 : iterator) {
                }
            }
            if (valueOf != 0) {
            } else {
                if (obj11 ^= i3 != 0) {
                    obj11 = string4;
                } else {
                    obj11 = p.Z(arrayList);
                    if ((DogProfile)obj11 == null) {
                        obj11 = str4;
                    } else {
                    }
                }
            }
        } else {
        }
        StringBuilder obj12 = new StringBuilder();
        obj12.append("user cache updated, with ");
        obj12.append(arrayList.size());
        obj12.append(" dogs");
        a.f(obj12.toString(), new Object[i5]);
        u22.b.u(bVar, obj11, arrayList);
        e0 e0Var = new e0(5);
        e0Var.a(u22.g0(userApiModel.getId(), obj11, bVar));
        Object[] array = arrayList.toArray(new DogProfile[i5]);
        String str7 = "null cannot be cast to non-null type kotlin.Array<T>";
        Objects.requireNonNull(array, str7);
        e0Var.a(u22.h(userApiModel.getId(), (DogProfile[])Arrays.copyOf((DogProfile[])array, array.length)));
        e0Var.a(u22.W(userApiModel, u22.j.g()));
        obj11 = new ArrayList(p.r(arrayList, i));
        obj12 = arrayList.iterator();
        for (DogProfile next2 : obj12) {
            obj11.add(u22.k(next2.getId(), next2.getAvatar()));
        }
        obj11 = obj11.toArray(new b[i5]);
        Objects.requireNonNull(obj11, str7);
        e0Var.b(obj11);
        obj12 = new ReminderResponse(userApiModel.getTrainingReminder(), userApiModel.getPottyReminders());
        e0Var.a(u22.i.R(userApiModel.getId(), obj12));
        return b.p((f[])e0Var.d(new f[e0Var.c()]));
    }

    private static final DogProfile e(DogCreateResponse dogCreateResponse) {
        n.f(dogCreateResponse, "$it");
        return DogProfile.Companion.fromApiDog(dogCreateResponse.getDog());
    }

    private static final DogProfile f(app.dogo.com.dogo_android.service.u2 u2, String string2, DogProfile dogProfile3) {
        n.f(u2, "this$0");
        n.f(string2, "$userId");
        n.f(dogProfile3, "dogProfile");
        u2.X(string2, dogProfile3.getId());
        return dogProfile3;
    }

    private static final f f0(app.dogo.com.dogo_android.service.u2 u2, UserApiModel userApiModel2) {
        n.f(u2, "this$0");
        n.f(userApiModel2, "it");
        int i = 0;
        return u2.c0(u2, userApiModel2, i, 2, i);
    }

    private final b g0(String string, String string2, b b3) {
        return this.g.s(b3.e(string, string2));
    }

    private final b h(String string, DogProfile... dogProfile2Arr2) {
        int dogEntity;
        List obj5 = i.a0(dogProfile2Arr2);
        ArrayList arrayList = new ArrayList(p.r(obj5, 10));
        obj5 = obj5.iterator();
        for (DogProfile next2 : obj5) {
            arrayList.add(next2.toDogEntity(string));
        }
        Object[] obj4 = arrayList.toArray(new DogEntity[0]);
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Array<T>");
        return this.h.c((DogEntity[])Arrays.copyOf((DogEntity[])obj4, obj4.length));
    }

    private final b k(String string, String string2) {
        d2 d2Var = new d2(this, string, string2);
        final b obj2 = b.g(d2Var);
        n.e(obj2, "create { emitter ->\n            val currentAvatarUrl = preferenceService.getDogAvatarUrlFor(dogId)\n            if (avatarUrl != null && avatarUrl.isNotBlank() && avatarUrl != currentAvatarUrl) {\n                val localAvatarUri = storageService.createUriForFile(dogId, StorageService.DOG_AVATAR_FILE_NAME)\n                if (localAvatarUri != null) {\n                    fireBaseStorageService.downloadFile(StoragePath.DogAvatar.setId(dogId), localAvatarUri) {\n                        preferenceService.setDogAvatarUrlFor(dogId, avatarUrl)\n                        emitter.onComplete()\n                    }\n                } else {\n                    emitter.onComplete()\n                }\n            } else {\n                emitter.onComplete()\n            }\n        }");
        return obj2;
    }

    private static final void l(app.dogo.com.dogo_android.service.u2 u2, String string2, String string3, c c4) {
        Object str2;
        int str;
        p pVar;
        app.dogo.com.dogo_android.service.u2.a aVar;
        n.f(u2, "this$0");
        n.f(string2, "$dogId");
        n.f(c4, "emitter");
        if (string3 != null && z ^= 1 != 0 && !n.b(string3, u2.a.q(string2))) {
            if (z ^= 1 != 0) {
                if (!n.b(string3, str2)) {
                    str2 = u2.d.b(string2, "avatar.jpg");
                    if (str2 != null) {
                        aVar = new u2.a(u2, string2, string3, c4);
                        u2.e.b(p.DogAvatar.setId(string2), str2, aVar);
                    } else {
                        c4.onComplete();
                    }
                } else {
                    c4.onComplete();
                }
            } else {
            }
        } else {
        }
    }

    private static final f n(app.dogo.com.dogo_android.service.u2 u2, String string2, h h3) {
        n.f(u2, "this$0");
        n.f(string2, "$userId");
        n.f(h3, "userEntity");
        y1 y1Var = new y1(u2, h3);
        v1 v1Var = new v1(u2, string2);
        return u2.h.a().map(y1Var).flatMapCompletable(v1Var);
    }

    private static final w o(app.dogo.com.dogo_android.service.u2 u2, h h2, List list3) {
        n.f(u2, "this$0");
        n.f(h2, "$userEntity");
        n.f(list3, "dogEntities");
        Object[] obj5 = list3.toArray(new DogEntity[0]);
        Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.Array<T>");
        u2.b.u(b.Companion.a(h2), h2.b().getCurrentDogId(), DogProfile.Companion.fromEntities((DogEntity[])Arrays.copyOf((DogEntity[])obj5, obj5.length)));
        return w.a;
    }

    private static final f p(app.dogo.com.dogo_android.service.u2 u2, String string2, w w3) {
        n.f(u2, "this$0");
        n.f(string2, "$userId");
        n.f(w3, "it");
        return u2.i.O(string2);
    }

    private static final g0 r(app.dogo.com.dogo_android.service.u2 u2, String string2) {
        n.f(u2, "this$0");
        n.f(string2, "it");
        return u2.h.b(string2).map(q1.a);
    }

    private static final String s(DogEntity dogEntity) {
        String obj1;
        n.f(dogEntity, "dog");
        if (dogEntity.getName() == null) {
            obj1 = "";
        }
        return obj1;
    }

    private static final String t(Throwable throwable) {
        n.f(throwable, "it");
        return "";
    }

    private static final String v(Throwable throwable) {
        n.f(throwable, "it");
        return "";
    }

    private static final String w(DogEntity dogEntity) {
        String obj1;
        n.f(dogEntity, "dog");
        if (dogEntity.getName() == null) {
            obj1 = "";
        }
        return obj1;
    }

    private static final PublicDogProfile z(PublicDogResponse publicDogResponse) {
        n.f(publicDogResponse, "it");
        return PublicDogProfile.Companion.fromApiModel(publicDogResponse.getDog());
    }

    public final c A() {
        return this.b;
    }

    public final boolean B(String string) {
        n.f(string, "policy");
        return this.b.o().c(string);
    }

    public final boolean C(String string) {
        n.f(string, "policy");
        return this.b.o().d(string);
    }

    public final boolean D(String string) {
        n.f(string, "userId");
        return this.b.p(string);
    }

    public final b T(String string, String string2) {
        boolean z;
        String str;
        n.f(string, "userId");
        n.f(string2, "dogId");
        this.b.m().remove(string2);
        if (n.b(this.b.f(), string2)) {
            z = p.Y(this.b.m().values());
            str = "";
            if ((DogProfile)z == null) {
            } else {
                z = (DogProfile)z.getId();
                if (z == null) {
                } else {
                    str = z;
                }
            }
            X(string, str);
        }
        f[] obj3 = new f[2];
        obj3 = b.p(this.h.deleteDog(string2), this.i.c(string2));
        n.e(obj3, "mergeArray(dogDao.deleteDog(dogId), reminderRepository.deactivatePottyRemindersForDog(dogId))");
        return obj3;
    }

    public final void U(String string) {
        n.f(string, "challengeId");
        this.b.r(string);
    }

    public final void X(String string, String string2) {
        n.f(string, "userId");
        n.f(string2, "dogId");
        UserCurrentDogIdUpdate userCurrentDogIdUpdate = new UserCurrentDogIdUpdate(string, string2);
        this.g.o(userCurrentDogIdUpdate);
        this.b.s(string2);
    }

    public final b a0(String string, UserApiModel.DogApiModel userApiModel$DogApiModel2) {
        n.f(string, "userId");
        n.f(dogApiModel2, "dogApiModel");
        DogProfile apiDog = DogProfile.Companion.fromApiDog(dogApiModel2);
        this.b.t(apiDog);
        f[] arr = new f[3];
        int i2 = 1;
        final DogProfile[] arr2 = new DogProfile[i2];
        final int i3 = 0;
        arr2[i3] = apiDog;
        arr[i3] = Z(string, arr2);
        arr[i2] = k(apiDog.getId(), apiDog.getAvatar());
        arr[2] = V(dogApiModel2, this.j.g());
        b obj6 = b.p(arr);
        n.e(obj6, "mergeArray(\n            updateDogInPersistenceStorage(userId, dog),\n            downloadAvatarToLocalStorage(dog.id, dog.avatar),\n            saveDogEntitlementResponseData(dogApiModel, utilities.currentTimeInMillis)\n        )");
        return obj6;
    }

    public final a0<DogProfile> b(String string, String string2) {
        n.f(string, "userId");
        super(string2, 0, 0, 0, 0, 0, 0, 126, 0);
        DogCreateRequest dogCreateRequest = new DogCreateRequest(remoteDogModel2);
        u1 u1Var = new u1(this, string);
        final a0 obj14 = this.c.createDog(dogCreateRequest).flatMap(u1Var);
        n.e(obj14, "apiClient.createDog(\n            DogCreateRequest(\n                dog = RemoteDogModel(name = name)\n            )\n        ).flatMap {\n            updateLocalDogData(userId, it.dog)\n                .toSingle { DogProfile.fromApiDog(it.dog) }\n                .map { dogProfile ->\n                    setDogAsCurrent(userId, dogProfile.id)\n                    dogProfile\n                }\n        }");
        return obj14;
    }

    public final b b0(UserApiModel userApiModel, String string2) {
        n.f(userApiModel, "userApiModel");
        t1 t1Var = new t1(userApiModel, this, string2);
        final b obj3 = this.g.u(userApiModel.getId()).flatMapCompletable(t1Var);
        n.e(obj3, "userDao.getCurrentDogId(userApiModel.id).flatMapCompletable { currentSavedDogId ->\n            val dogs = userApiModel.dogs.values.map { DogProfile.fromApiDog(it) }\n            val userData = User(\n                id = userApiModel.id,\n                policies = userApiModel.policies.mapValues { User.PolicyStatus.enumFromApiPolicyStatus(it.value.status) },\n                participating = userApiModel.challenges.participatedInChallengeIds.toMutableList(),\n                abTestBucket = userApiModel.abTestBucket\n            )\n            userApiModel.trainingReminder?.let {\n                tracker.setTrainingReminderUserProperties(it.toItem())\n            }\n            updateAbBucketUserProperties(userApiModel)\n            val currentDogId = when {\n                newCurrentDogId != null && dogs.any { it.id == newCurrentDogId } -> {\n                    newCurrentDogId\n                }\n                currentSavedDogId.isNotBlank() -> {\n                    currentSavedDogId\n                }\n                else -> {\n                    dogs.firstOrNull()?.id ?: \"\"\n                }\n            }\n            Timber.i(\"user cache updated, with ${dogs.size} dogs\")\n            userAndDogCache.updateLocalSessionCache(userData, currentDogId, dogs)\n            val premiumCacheUpdate = saveUserEntitlementResponseData(userApiModel, utilities.currentTimeInMillis)\n            Completable.mergeArray(\n                updateUserInPersistenceStorage(userApiModel.id, currentDogId, userData),\n                cleanInsertDogsInPersistenceStorage(userApiModel.id, *dogs.toTypedArray()),\n                premiumCacheUpdate,\n                *dogs.map { downloadAvatarToLocalStorage(it.id, it.avatar) }.toTypedArray(),\n                reminderRepository.updateCacheFromResponse(\n                    userApiModel.id,\n                    ReminderResponse(\n                        trainingReminder = userApiModel.trainingReminder,\n                        pottyReminders = userApiModel.pottyReminders\n                    )\n                )\n            )\n        }");
        return obj3;
    }

    public final b e0(String string, b.c b$c2) {
        n.f(string, "policyId");
        n.f(c2, "policyStatus");
        UserPolicyUpdateRequest.UserPolicy userPolicy = new UserPolicyUpdateRequest.UserPolicy(string, c2.getTag());
        o oVar = new o(string, userPolicy);
        UserPolicyUpdateRequest userPolicyUpdateRequest = new UserPolicyUpdateRequest(j0.e(oVar));
        s1 obj6 = new s1(this);
        b obj5 = this.c.updatePolicies(userPolicyUpdateRequest).flatMapCompletable(obj6);
        n.e(obj5, "apiClient.updatePolicies(\n            UserPolicyUpdateRequest(\n                mapOf(\n                    Pair(\n                        policyId,\n                        UserPolicyUpdateRequest.UserPolicy(policyId, policyStatus.tag)\n                    )\n                )\n            )\n        ).flatMapCompletable {\n            updateLocalUserData(it)\n        }");
        return obj5;
    }

    public final void g(String string) {
        n.f(string, "challengeId");
        this.b.a(string);
    }

    public final b i(String string) {
        n.f(string, "userId");
        f[] arr = new f[2];
        UserLogoutRequest userLogoutRequest = new UserLogoutRequest(this.b.i().c());
        b obj5 = b.p(this.c.logoutUserSingle(userLogoutRequest), this.i.a(string));
        n.e(obj5, "mergeArray(\n            apiClient.logoutUserSingle(\n                UserLogoutRequest(\n                    deviceId = userAndDogCache.deviceData.deviceId\n                )\n            ),\n            reminderRepository.cancelAllNotifications(userId)\n        )");
        return obj5;
    }

    public final a0<Boolean> j(String string) {
        n.f(string, "userId");
        return this.g.w(string);
    }

    public final b m(String string) {
        n.f(string, "userId");
        r1 r1Var = new r1(this, string);
        final b obj3 = this.g.h(string).flatMapCompletable(r1Var);
        n.e(obj3, "userDao.getUser(userId).flatMapCompletable { userEntity ->\n            dogDao.getAllDogs().map { dogEntities ->\n                userAndDogCache.updateLocalSessionCache(\n                    User.fromEntity(userEntity),\n                    userEntity.user.currentDogId,\n                    DogProfile.fromEntities(*dogEntities.toTypedArray())\n                )\n            }.flatMapCompletable {\n                reminderRepository.updateAppStateFromRoom(userId)\n            }\n        }");
        return obj3;
    }

    public final a0<String> q(String string) {
        n.f(string, "userId");
        x1 x1Var = new x1(this);
        a0 obj2 = this.g.u(string).flatMap(x1Var).onErrorReturn(e2.a);
        n.e(obj2, "userDao.getCurrentDogId(userId).flatMap {\n            dogDao.getDog(it).map { dog ->\n                dog.name ?: \"\"\n            }\n        }.onErrorReturn { \"\" }");
        return obj2;
    }

    public final a0<String> u(String string) {
        n.f(string, "dogId");
        a0 obj2 = this.h.b(string).map(c2.a).onErrorReturn(w1.a);
        n.e(obj2, "dogDao.getDog(dogId).map { dog ->\n            dog.name ?: \"\"\n        }.onErrorReturn { \"\" }");
        return obj2;
    }

    public final a0<DogoPremiumStatusEntity> x(String string) {
        n.f(string, "dogId");
        return this.f.c(string);
    }

    public final a0<PublicDogProfile> y(String string) {
        n.f(string, "dogId");
        a0 obj2 = this.c.getPublicDog(string).map(a2.a);
        n.e(obj2, "apiClient.getPublicDog(dogId).map {\n            PublicDogProfile.fromApiModel(it.dog)\n        }");
        return obj2;
    }
}
