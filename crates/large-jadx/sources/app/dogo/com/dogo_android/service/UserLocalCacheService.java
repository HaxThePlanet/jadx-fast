package app.dogo.com.dogo_android.service;

import app.dogo.android.network.DogoApiClient;
import app.dogo.android.persistencedb.room.entity.DogEntity;
import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import app.dogo.android.persistencedb.room.entity.UserCurrentDogIdUpdate;
import app.dogo.android.persistencedb.room.entity.UserEntity;
import app.dogo.com.dogo_android.model.RemindersModelKt;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.DogProfile.Companion;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile.Companion;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.v.b.a;
import app.dogo.com.dogo_android.v.b.c;
import app.dogo.com.dogo_android.v.b.c.a;
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
import e.a.a.a.b.b.q0;
import e.a.a.a.b.b.u;
import e.a.a.a.b.d.h;
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
import kotlin.d0.d.e0;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;
import kotlin.w;
import kotlin.y.i;
import kotlin.y.j0;

/* compiled from: UserLocalCacheService.kt */
@Metadata(d1 = "\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001dJ)\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001b0%\"\u00020\u001bH\u0002¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010(\u001a\u0008\u0012\u0004\u0012\u00020)0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u001d2\u0008\u0010,\u001a\u0004\u0018\u00010\u001dH\u0002J\u000e\u0010-\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001a2\u0006\u0010+\u001a\u00020\u001dJ\u0014\u00100\u001a\u0008\u0012\u0004\u0012\u0002010\u001a2\u0006\u0010+\u001a\u00020\u001dJ\u0014\u00102\u001a\u0008\u0012\u0004\u0012\u0002030\u001a2\u0006\u0010+\u001a\u00020\u001dJ\u0006\u00104\u001a\u00020\u0005J\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u001dJ\u000e\u00107\u001a\u00020)2\u0006\u00106\u001a\u00020\u001dJ\u000e\u00108\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u00109\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dJ\u000e\u0010:\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001dJ\u0018\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010>\u001a\u00020?H\u0002J\u0016\u0010C\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dJ\u0010\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020BH\u0002J)\u0010F\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001b0%\"\u00020\u001bH\u0002¢\u0006\u0002\u0010&J\u0016\u0010G\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=J\u001a\u0010H\u001a\u00020#2\u0006\u0010E\u001a\u00020B2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020MJ \u0010N\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020QH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R", d2 = {"Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "userAndDogCache", "Lapp/dogo/com/dogo_android/temp/UserAndDogCache;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "fireBaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "dogoPremiumStatusDao", "Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;", "userDao", "Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "dogDao", "Lapp/dogo/android/persistencedb/room/dao/DogEntityDao;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/temp/UserAndDogCache;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;Lapp/dogo/android/persistencedb/room/dao/DogEntityDao;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "addNewDog", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "userId", "", "name", "addParticipatingChallenge", "", "challengeId", "cleanInsertDogsInPersistenceStorage", "Lio/reactivex/Completable;", "dogs", "", "(Ljava/lang/String;[Lapp/dogo/com/dogo_android/repository/domain/DogProfile;)Lio/reactivex/Completable;", "deactivateDevice", "doesCacheExists", "", "downloadAvatarToLocalStorage", "dogId", "avatarUrl", "fillCacheFromRoom", "getCurrentDogNameOrBlank", "getDogNameOrBlank", "getPremiumStateForDog", "Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "getPublicDogProfile", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "getUserAndDogCache", "isPolicyAccepted", "policy", "isPolicyShown", "isUserDataSynced", "removeDog", "removeParticipatingChallenge", "saveDogEntitlementResponseData", "dogApiModel", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "currentTimeMs", "", "saveUserEntitlementResponseData", "userApiResponse", "Lapp/dogo/externalmodel/model/responses/UserApiModel;", "setDogAsCurrent", "updateAbBucketUserProperties", "userApiModel", "updateDogInPersistenceStorage", "updateLocalDogData", "updateLocalUserData", "newCurrentDogId", "updatePolicy", "policyId", "policyStatus", "Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "updateUserInPersistenceStorage", "currentDogId", "user", "Lapp/dogo/com/dogo_android/temp/User;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u2, reason: from kotlin metadata */
public final class UserLocalCacheService {

    /* renamed from: a, reason: from kotlin metadata */
    private final p2 apiClient;
    /* renamed from: b, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.v.c dogDao;
    /* renamed from: c, reason: from kotlin metadata */
    private final DogoApiClient dogoPremiumStatusDao;
    /* renamed from: d, reason: from kotlin metadata */
    private final t2 fireBaseStorageService;
    /* renamed from: e, reason: from kotlin metadata */
    private final l2 preferenceService;
    /* renamed from: f, reason: from kotlin metadata */
    private final e.a.a.a.b.b.a0 reminderRepository;
    /* renamed from: g, reason: from kotlin metadata */
    private final q0 storageService;
    /* renamed from: h, reason: from kotlin metadata */
    private final u tracker;
    /* renamed from: i, reason: from kotlin metadata */
    private final l1 userAndDogCache;
    /* renamed from: j, reason: from kotlin metadata */
    private final v2 userDao;
    /* renamed from: k, reason: from kotlin metadata */
    private final o3 utilities;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ String $avatarUrl;
        final /* synthetic */ String $dogId;
        final /* synthetic */ i.b.c $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            u2.this.apiClient.getChallengeFilters(this.$dogId, this.$avatarUrl);
            this.$emitter.onComplete();
        }

        a(String str, String str2, i.b.c cVar) {
            this.$dogId = str;
            this.$avatarUrl = str2;
            this.$emitter = cVar;
            super(0);
        }
    }
    public u2(p2 p2Var, app.dogo.com.dogo_android.v.c cVar, DogoApiClient dogoApiClient, t2 t2Var, l2 l2Var, e.a.a.a.b.b.a0 a0Var, q0 q0Var, u uVar, l1 l1Var, v2 v2Var, o3 o3Var) {
        n.f(p2Var, "preferenceService");
        n.f(cVar, "userAndDogCache");
        n.f(dogoApiClient, "apiClient");
        n.f(t2Var, "storageService");
        n.f(l2Var, "fireBaseStorageService");
        n.f(a0Var, "dogoPremiumStatusDao");
        n.f(q0Var, "userDao");
        n.f(uVar, "dogDao");
        n.f(l1Var, "reminderRepository");
        n.f(v2Var, "utilities");
        n.f(o3Var, "tracker");
        super();
        this.apiClient = p2Var;
        this.dogDao = cVar;
        this.dogoPremiumStatusDao = dogoApiClient;
        this.fireBaseStorageService = t2Var;
        this.preferenceService = l2Var;
        this.reminderRepository = a0Var;
        this.storageService = q0Var;
        this.tracker = uVar;
        this.userAndDogCache = l1Var;
        this.userDao = v2Var;
        this.utilities = o3Var;
    }

    /* renamed from: V, reason: from kotlin metadata */
    private final i.b.b downloadAvatarToLocalStorage(UserApiModel.DogApiModel dogId, long avatarUrl) {
        Object value;
        long value2 = 9223372036854775807L;
        long l2;
        final String str = "";
        UserApiModel.Entitlement userApiModel_Entitlement = new UserApiModel_Entitlement(Long.valueOf(0L), str, str);
        value = dogId.getEntitlements().get("premium_dog");
        if (value != null) {
        }
        Long expirationTimeMs = value.getExpirationTimeMs();
        if (expirationTimeMs == null) {
            value2 = Long.MAX_VALUE;
        } else {
            value2 = expirationTimeMs.longValue();
        }
        String dogId2 = value.getExpirationDate();
        String r8 = dogId2 == null ? str : dogId2;
        DogoPremiumStatusEntity dogoPremiumStatusEntity = new DogoPremiumStatusEntity(dogId.getId(), "dog", value2, str4, (dogId2 == null ? str : dogId2), avatarUrl, obj2);
        DogoPremiumStatusEntity[] arr = new DogoPremiumStatusEntity[1];
        return this.reminderRepository.getPremiumStateForDog(arr);
    }

    /* renamed from: W, reason: from kotlin metadata */
    private final i.b.b removeDog(UserApiModel userId, long dogId) {
        Object value;
        String str2;
        long value2;
        long l3;
        long l;
        String str = "";
        UserApiModel.Entitlement userApiModel_Entitlement = new UserApiModel_Entitlement(Long.valueOf(0L), str, str);
        if ((UserApiModel_Entitlement)userId.getEntitlements().get("premium") == null) {
        }
        Long expirationTimeMs = value.getExpirationTimeMs();
        value2 = Long.MAX_VALUE;
        value2 = expirationTimeMs == null ? value2 : value2;
        String expirationDate = value.getExpirationDate();
        String r8 = expirationDate == null ? str : expirationDate;
        str2 = "user";
        DogoPremiumStatusEntity dogoPremiumStatusEntity = new DogoPremiumStatusEntity(userId.getId(), "user", value2, str8, (expirationDate == null ? str : expirationDate), dogId, obj2);
        Collection values = userId.getDogs().values();
        ArrayList arrayList = new ArrayList(p.r(values, 10));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Long expirationTimeMs2 = str2.getExpirationTimeMs();
            String expirationDate2 = str2.getExpirationDate();
            String r19 = expirationDate2 == null ? str : expirationDate2;
            str4 = "dog";
            DogoPremiumStatusEntity dogoPremiumStatusEntity2 = new DogoPremiumStatusEntity(item.getId(), "dog", value2, str9, (expirationDate2 == null ? str : expirationDate2), dogId, obj5);
            arrayList.add(dogoPremiumStatusEntity2);
        }
        Object[] array = p.u0(arrayList, dogoPremiumStatusEntity).toArray(new DogoPremiumStatusEntity[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return this.reminderRepository.getPremiumStateForDog((DogoPremiumStatusEntity[])Arrays.copyOf(array, array.length));
    }

    /* renamed from: Y, reason: from kotlin metadata */
    private final void getPremiumStateForDog(UserApiModel dogId) {
        long abTestBucket3 = dogId.getAbTestBucket();
        long abTestBucket = 0L;
        if (abTestBucket3 > abTestBucket) {
            this.utilities.setUserProperty(UserProperty.AbTestBucket, Long.valueOf(dogId.getAbTestBucket()));
        }
    }

    /* renamed from: Z, reason: from kotlin metadata */
    private final i.b.b saveDogEntitlementResponseData(String dogApiModel, DogProfile... currentTimeMs) {
        List list = i.a0(currentTimeMs);
        final ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((DogProfile)it.next().toDogEntity(dogApiModel));
        }
        Object[] array = arrayList.toArray(new DogEntity[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return this.tracker.getDog((DogEntity[])Arrays.copyOf(array, array.length));
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ p2 getPublicDogProfile(u2 dogId) {
        return dogId.apiClient;
    }

    public static /* synthetic */ i.b.a0 c(u2 u2Var, String str, String str2, int i, Object object) {
        if (i & 2 != 0) {
            i = 0;
        }
        return u2Var.b(str, str);
    }

    public static /* synthetic */ i.b.b c0(u2 u2Var, UserApiModel userApiModel, String str, int i, Object object) {
        if (i & 2 != 0) {
            i = 0;
        }
        return u2Var.b0(userApiModel, str);
    }

    private static final g0 d(u2 u2Var, String str, DogCreateResponse dogCreateResponse) {
        n.f(u2Var, "this$0");
        n.f(str, "$userId");
        n.f(dogCreateResponse, "it");
        return u2Var.a0(str, dogCreateResponse.getDog()).B(new z1(dogCreateResponse)).map(new b2(u2Var, str));
    }

    private static final f d0(UserApiModel userApiModel, u2 u2Var, String str, String str2) {
        Long num;
        int i3;
        long l;
        b.c.a iNSTANCE22;
        n.f(userApiModel, "$userApiModel");
        n.f(u2Var, "this$0");
        n.f(str2, "currentSavedDogId");
        Collection values = userApiModel.getDogs().values();
        int i = 10;
        ArrayList arrayList = new ArrayList(p.r(values, i));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(DogProfile.INSTANCE.fromApiDog((UserApiModel_DogApiModel)it.next()));
        }
        Map policies = userApiModel.getPolicies();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(policies.size()));
        Iterator it2 = policies.entrySet().iterator();
        while (it2.hasNext()) {
            Object item4 = it2.next();
            linkedHashMap.put(item4.getKey(), User_PolicyStatus.INSTANCE.a((UserApiModel_Policy)item4.getValue().getStatus()));
        }
        app.dogo.com.dogo_android.v.b user = new User(userApiModel.getId(), linkedHashMap, p.N0(userApiModel.getChallenges().getParticipatedInChallengeIds()), Long.valueOf(userApiModel.getAbTestBucket()));
        app.dogo.externalmodel.model.TrainingReminderModel trainingReminder = userApiModel.getTrainingReminder();
        if (trainingReminder != null) {
            u2Var.utilities.onConversionDataFail(RemindersModelKt.toItem(trainingReminder));
        }
        u2Var.getPremiumStateForDog(userApiModel);
        i3 = 1;
        i3 = 0;
        if (str != null) {
            int r5 = i3;
            if (i3 == 0) {
                if (l.z(str2) ^ i3 != 0) {
                    Object str42 = str2;
                } else {
                    Object obj = p.Z(arrayList);
                    str = obj == null ? "" : str;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str7 = "user cache updated, with ";
        int size = arrayList.size();
        String str8 = " dogs";
        str10 = str7 + size + str8;
        a.f(str7 + size + str8, new Object[i3]);
        u2Var.dogDao.updateLocalSessionCache(user, str, arrayList);
        e0 e0Var = new e0(5);
        e0Var.a((obj == null ? "" : str));
        Object[] array = arrayList.toArray(new DogProfile[i3]);
        String str9 = "null cannot be cast to non-null type kotlin.Array<T>";
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        e0Var.a((obj == null ? "" : str));
        e0Var.a(u2Var.removeDog(userApiModel, u2Var.userDao.g(), obj2));
        ArrayList arrayList2 = new ArrayList(p.r(arrayList, i));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            Object item2 = it4.next();
            arrayList2.add(u2Var.updateDogInPersistenceStorage(item2.getId(), item2.getAvatar()));
        }
        Object[] array2 = arrayList2.toArray(new b[i3]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        e0Var.b(array2);
        e0Var.a(u2Var.userAndDogCache.R(userApiModel.getId(), new ReminderResponse(userApiModel.getTrainingReminder(), userApiModel.getPottyReminders())));
        return b.p((f[])e0Var.d(new f[e0Var.c()]));
    }

    /* renamed from: e, reason: from kotlin metadata */
    private static final DogProfile isPolicyAccepted(DogCreateResponse policy) {
        n.f(policy, "$it");
        return DogProfile.INSTANCE.fromApiDog(policy.getDog());
    }

    private static final DogProfile f(u2 u2Var, String str, DogProfile dogProfile) {
        n.f(u2Var, "this$0");
        n.f(str, "$userId");
        n.f(dogProfile, "dogProfile");
        u2Var.updatePolicy(str, dogProfile.getId());
        return dogProfile;
    }

    /* renamed from: f0, reason: from kotlin metadata */
    private static final f saveUserEntitlementResponseData(u2 userApiResponse, UserApiModel currentTimeMs) {
        n.f(userApiResponse, "this$0");
        n.f(currentTimeMs, "it");
        String str3 = null;
        return UserLocalCacheService.c0(userApiResponse, currentTimeMs, str3, 2, str3);
    }

    private final i.b.b g0(String str, String str2, app.dogo.com.dogo_android.v.b bVar) {
        return this.storageService.getTrainingReminderOrEmpty(bVar.toUserFullEntity(str, str2));
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final i.b.b setDogAsCurrent(String userId, DogProfile... dogId) {
        List list = i.a0(dogId);
        final ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((DogProfile)it.next().toDogEntity(userId));
        }
        Object[] array = arrayList.toArray(new DogEntity[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return this.tracker.deleteDog((DogEntity[])Arrays.copyOf(array, array.length));
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final i.b.b updateDogInPersistenceStorage(String userId, String dogs) {
        final i.b.b bVar = b.g(new d2(this, userId, dogs));
        n.e(bVar, "create { emitter ->\n            val currentAvatarUrl = preferenceService.getDogAvatarUrlFor(dogId)\n            if (avatarUrl != null && avatarUrl.isNotBlank() && avatarUrl != currentAvatarUrl) {\n                val localAvatarUri = storageService.createUriForFile(dogId, StorageService.DOG_AVATAR_FILE_NAME)\n                if (localAvatarUri != null) {\n                    fireBaseStorageService.downloadFile(StoragePath.DogAvatar.setId(dogId), localAvatarUri) {\n                        preferenceService.setDogAvatarUrlFor(dogId, avatarUrl)\n                        emitter.onComplete()\n                    }\n                } else {\n                    emitter.onComplete()\n                }\n            } else {\n                emitter.onComplete()\n            }\n        }");
        return bVar;
    }

    private static final void l(u2 u2Var, String str, String str2, i.b.c cVar) {
        int i;
        n.f(u2Var, "this$0");
        n.f(str, "$dogId");
        n.f(cVar, "emitter");
        if (str2 != null) {
            i = !l.z(str2);
            if (!l.z(str2) == 0 || n.b(str2, u2Var.apiClient.q(str))) {
                cVar.onComplete();
            } else {
                android.net.Uri fileExist = u2Var.fireBaseStorageService.fileExist(str, "avatar.jpg");
                if (fileExist != null) {
                    u2Var.preferenceService.downloadLogic(StoragePath.DogAvatar.setId(str), fileExist, new u2.a(u2Var, str, str2, cVar));
                } else {
                    cVar.onComplete();
                }
            }
        }
    }

    private static final f n(u2 u2Var, String str, h hVar) {
        n.f(u2Var, "this$0");
        n.f(str, "$userId");
        n.f(hVar, "userEntity");
        return u2Var.tracker.clearDogData().map(new y1(u2Var, hVar)).flatMapCompletable(new v1(u2Var, str));
    }

    private static final w o(u2 u2Var, h hVar, List list) {
        n.f(u2Var, "this$0");
        n.f(hVar, "$userEntity");
        n.f(list, "dogEntities");
        Object[] array = list.toArray(new DogEntity[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        u2Var.dogDao.updateLocalSessionCache(User.INSTANCE.fromEntity(hVar), hVar.b().getCurrentDogId(), DogProfile.INSTANCE.fromEntities((DogEntity[])Arrays.copyOf(array, array.length)));
        return w.a;
    }

    private static final f p(u2 u2Var, String str, w wVar) {
        n.f(u2Var, "this$0");
        n.f(str, "$userId");
        n.f(wVar, "it");
        return u2Var.userAndDogCache.O(str);
    }

    /* renamed from: r, reason: from kotlin metadata */
    private static final g0 updateLocalDogData(u2 userId, String dogApiModel) {
        n.f(userId, "this$0");
        n.f(dogApiModel, "it");
        return userId.tracker.clearAndInsertDogs(dogApiModel).map(q1.a);
    }

    /* renamed from: s, reason: from kotlin metadata */
    private static final String isPolicyShown(DogEntity policy) {
        String name;
        n.f(policy, "dog");
        if (policy.getName() == null) {
            name = "";
        }
        return name;
    }

    /* renamed from: w, reason: from kotlin metadata */
    private static final String updateAbBucketUserProperties(DogEntity userApiModel) {
        String name;
        n.f(userApiModel, "dog");
        if (userApiModel.getName() == null) {
            name = "";
        }
        return name;
    }

    private static final PublicDogProfile z(PublicDogResponse publicDogResponse) {
        n.f(publicDogResponse, "it");
        return PublicDogProfile.INSTANCE.fromApiModel(publicDogResponse.getDog());
    }

    /* renamed from: A, reason: from kotlin metadata */
    public final app.dogo.com.dogo_android.v.c getUserAndDogCache() {
        return this.dogDao;
    }

    public final boolean B(String str) {
        n.f(str, "policy");
        return this.dogDao.o().equals(str);
    }

    public final boolean C(String str) {
        n.f(str, "policy");
        return this.dogDao.o().isPolicyAccepted(str);
    }

    public final boolean D(String str) {
        n.f(str, "userId");
        return this.dogDao.isSynced(str);
    }

    /* renamed from: T, reason: from kotlin metadata */
    public final i.b.b updateLocalUserData(String userApiModel, String newCurrentDogId) {
        String str;
        n.f(userApiModel, "userId");
        n.f(newCurrentDogId, "dogId");
        this.dogDao.m().remove(newCurrentDogId);
        if (n.b(this.dogDao.f(), newCurrentDogId)) {
            Object obj = p.Y(this.dogDao.m().values());
            str = "";
            if (obj != null) {
                str = obj.getId();
                if (str != null) {
                }
            }
            updatePolicy(userApiModel, str);
        }
        f[] arr = new f[2];
        i.b.b bVar = b.p(new f[] { this.tracker.deleteDog(newCurrentDogId), this.userAndDogCache.c(newCurrentDogId) });
        n.e(bVar, "mergeArray(dogDao.deleteDog(dogId), reminderRepository.deactivatePottyRemindersForDog(dogId))");
        return bVar;
    }

    public final void U(String str) {
        n.f(str, "challengeId");
        this.dogDao.removeParticipatingChallenge(str);
    }

    /* renamed from: X, reason: from kotlin metadata */
    public final void updatePolicy(String policyId, String policyStatus) {
        n.f(policyId, "userId");
        n.f(policyStatus, "dogId");
        this.storageService.getReminders(new UserCurrentDogIdUpdate(policyId, policyStatus));
        this.dogDao.updateLocalSessionCache(policyStatus);
    }

    public final i.b.b a0(String str, UserApiModel.DogApiModel dogApiModel) {
        n.f(str, "userId");
        n.f(dogApiModel, "dogApiModel");
        DogProfile apiDog = DogProfile.INSTANCE.fromApiDog(dogApiModel);
        this.dogDao.t(apiDog);
        f[] arr = new f[3];
        int i2 = 1;
        final DogProfile[] arr2 = new DogProfile[i2];
        final int i3 = 0;
        arr2[i3] = apiDog;
        arr[i3] = saveDogEntitlementResponseData(str, arr2);
        arr[i2] = updateDogInPersistenceStorage(apiDog.getId(), apiDog.getAvatar());
        arr[2] = downloadAvatarToLocalStorage(dogApiModel, this.userDao.g());
        i.b.b bVar = b.p(arr);
        n.e(bVar, "mergeArray(\n            updateDogInPersistenceStorage(userId, dog),\n            downloadAvatarToLocalStorage(dog.id, dog.avatar),\n            saveDogEntitlementResponseData(dogApiModel, utilities.currentTimeInMillis)\n        )");
        return bVar;
    }

    public final i.b.a0<DogProfile> b(String str, String str2) {
        n.f(str, "userId");
        RemoteDogModel remoteDogModel = new RemoteDogModel(str2, null, null, null, null, null, null, 126, null);
        final i.b.a0 flatMapped = this.dogoPremiumStatusDao.createDog(new DogCreateRequest(remoteDogModel)).flatMap(new u1(this, str));
        n.e(flatMapped, "apiClient.createDog(\n            DogCreateRequest(\n                dog = RemoteDogModel(name = name)\n            )\n        ).flatMap {\n            updateLocalDogData(userId, it.dog)\n                .toSingle { DogProfile.fromApiDog(it.dog) }\n                .map { dogProfile ->\n                    setDogAsCurrent(userId, dogProfile.id)\n                    dogProfile\n                }\n        }");
        return flatMapped;
    }

    public final i.b.b b0(UserApiModel userApiModel, String str) {
        n.f(userApiModel, "userApiModel");
        final i.b.b flatMapCompletable = this.storageService.getUserPottyReminders(userApiModel.getId()).flatMapCompletable(new t1(userApiModel, this, str));
        n.e(flatMapCompletable, "userDao.getCurrentDogId(userApiModel.id).flatMapCompletable { currentSavedDogId ->\n            val dogs = userApiModel.dogs.values.map { DogProfile.fromApiDog(it) }\n            val userData = User(\n                id = userApiModel.id,\n                policies = userApiModel.policies.mapValues { User.PolicyStatus.enumFromApiPolicyStatus(it.value.status) },\n                participating = userApiModel.challenges.participatedInChallengeIds.toMutableList(),\n                abTestBucket = userApiModel.abTestBucket\n            )\n            userApiModel.trainingReminder?.let {\n                tracker.setTrainingReminderUserProperties(it.toItem())\n            }\n            updateAbBucketUserProperties(userApiModel)\n            val currentDogId = when {\n                newCurrentDogId != null && dogs.any { it.id == newCurrentDogId } -> {\n                    newCurrentDogId\n                }\n                currentSavedDogId.isNotBlank() -> {\n                    currentSavedDogId\n                }\n                else -> {\n                    dogs.firstOrNull()?.id ?: \"\"\n                }\n            }\n            Timber.i(\"user cache updated, with ${dogs.size} dogs\")\n            userAndDogCache.updateLocalSessionCache(userData, currentDogId, dogs)\n            val premiumCacheUpdate = saveUserEntitlementResponseData(userApiModel, utilities.currentTimeInMillis)\n            Completable.mergeArray(\n                updateUserInPersistenceStorage(userApiModel.id, currentDogId, userData),\n                cleanInsertDogsInPersistenceStorage(userApiModel.id, *dogs.toTypedArray()),\n                premiumCacheUpdate,\n                *dogs.map { downloadAvatarToLocalStorage(it.id, it.avatar) }.toTypedArray(),\n                reminderRepository.updateCacheFromResponse(\n                    userApiModel.id,\n                    ReminderResponse(\n                        trainingReminder = userApiModel.trainingReminder,\n                        pottyReminders = userApiModel.pottyReminders\n                    )\n                )\n            )\n        }");
        return flatMapCompletable;
    }

    public final i.b.b e0(String str, b.c cVar) {
        n.f(str, "policyId");
        n.f(cVar, "policyStatus");
        i.b.b flatMapCompletable = this.dogoPremiumStatusDao.updatePolicies(new UserPolicyUpdateRequest(j0.e(new Pair(str, new UserPolicyUpdateRequest_UserPolicy(str, cVar.getTag()))))).flatMapCompletable(new s1(this));
        n.e(flatMapCompletable, "apiClient.updatePolicies(\n            UserPolicyUpdateRequest(\n                mapOf(\n                    Pair(\n                        policyId,\n                        UserPolicyUpdateRequest.UserPolicy(policyId, policyStatus.tag)\n                    )\n                )\n            )\n        ).flatMapCompletable {\n            updateLocalUserData(it)\n        }");
        return flatMapCompletable;
    }

    public final void g(String str) {
        n.f(str, "challengeId");
        this.dogDao.addParticipatingChallenge(str);
    }

    public final i.b.b i(String str) {
        n.f(str, "userId");
        f[] arr = new f[2];
        i.b.b bVar2 = b.p(new f[] { this.dogoPremiumStatusDao.logoutUserSingle(new UserLogoutRequest(this.dogDao.i().c())), this.userAndDogCache.a(str) });
        n.e(bVar2, "mergeArray(\n            apiClient.logoutUserSingle(\n                UserLogoutRequest(\n                    deviceId = userAndDogCache.deviceData.deviceId\n                )\n            ),\n            reminderRepository.cancelAllNotifications(userId)\n        )");
        return bVar2;
    }

    public final i.b.a0<Boolean> j(String str) {
        n.f(str, "userId");
        return this.storageService.getUserStateEntity(str);
    }

    public final i.b.b m(String str) {
        n.f(str, "userId");
        final i.b.b flatMapCompletable = this.storageService.fullInsert(str).flatMapCompletable(new r1(this, str));
        n.e(flatMapCompletable, "userDao.getUser(userId).flatMapCompletable { userEntity ->\n            dogDao.getAllDogs().map { dogEntities ->\n                userAndDogCache.updateLocalSessionCache(\n                    User.fromEntity(userEntity),\n                    userEntity.user.currentDogId,\n                    DogProfile.fromEntities(*dogEntities.toTypedArray())\n                )\n            }.flatMapCompletable {\n                reminderRepository.updateAppStateFromRoom(userId)\n            }\n        }");
        return flatMapCompletable;
    }

    public final i.b.a0<String> q(String str) {
        n.f(str, "userId");
        i.b.a0 onErrorReturn = this.storageService.getUserPottyReminders(str).flatMap(new x1(this)).onErrorReturn(e2.a);
        n.e(onErrorReturn, "userDao.getCurrentDogId(userId).flatMap {\n            dogDao.getDog(it).map { dog ->\n                dog.name ?: \"\"\n            }\n        }.onErrorReturn { \"\" }");
        return onErrorReturn;
    }

    public final i.b.a0<String> u(String str) {
        n.f(str, "dogId");
        i.b.a0 onErrorReturn = this.tracker.clearAndInsertDogs(str).map(c2.a).onErrorReturn(w1.a);
        n.e(onErrorReturn, "dogDao.getDog(dogId).map { dog ->\n            dog.name ?: \"\"\n        }.onErrorReturn { \"\" }");
        return onErrorReturn;
    }

    public final i.b.a0<DogoPremiumStatusEntity> x(String str) {
        n.f(str, "dogId");
        return this.reminderRepository.insert(str);
    }

    public final i.b.a0<PublicDogProfile> y(String str) {
        n.f(str, "dogId");
        i.b.a0 map = this.dogoPremiumStatusDao.getPublicDog(str).map(a2.a);
        n.e(map, "apiClient.getPublicDog(dogId).map {\n            PublicDogProfile.fromApiModel(it.dog)\n        }");
        return map;
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static /* synthetic */ String addParticipatingChallenge(DogEntity challengeId) {
        return UserLocalCacheService.isPolicyShown(challengeId);
    }

    /* renamed from: F, reason: from kotlin metadata */
    public static /* synthetic */ f updateUserInPersistenceStorage(u2 userId, String currentDogId, h user) {
        return UserLocalCacheService.n(userId, currentDogId, user);
    }

    /* renamed from: G, reason: from kotlin metadata */
    public static /* synthetic */ f addNewDog(u2 userId, UserApiModel name) {
        return UserLocalCacheService.saveUserEntitlementResponseData(userId, name);
    }

    public static /* synthetic */ f H(UserApiModel userApiModel, u2 u2Var, String str, String str2) {
        return UserLocalCacheService.d0(userApiModel, u2Var, str, str2);
    }

    public static /* synthetic */ g0 I(u2 u2Var, String str, DogCreateResponse dogCreateResponse) {
        return UserLocalCacheService.d(u2Var, str, dogCreateResponse);
    }

    public static /* synthetic */ f J(u2 u2Var, String str, w wVar) {
        return UserLocalCacheService.p(u2Var, str, wVar);
    }

    /* renamed from: K, reason: from kotlin metadata */
    public static /* synthetic */ String deactivateDevice(Throwable userId) {
        return UserLocalCacheService.removeParticipatingChallenge(userId);
    }

    /* renamed from: L, reason: from kotlin metadata */
    public static /* synthetic */ g0 cleanInsertDogsInPersistenceStorage(u2 userId, String dogs) {
        return UserLocalCacheService.updateLocalDogData(userId, dogs);
    }

    public static /* synthetic */ w M(u2 u2Var, h hVar, List list) {
        return UserLocalCacheService.o(u2Var, hVar, list);
    }

    /* renamed from: N, reason: from kotlin metadata */
    public static /* synthetic */ DogProfile doesCacheExists(DogCreateResponse userId) {
        return UserLocalCacheService.isPolicyAccepted(userId);
    }

    /* renamed from: O, reason: from kotlin metadata */
    public static /* synthetic */ PublicDogProfile fillCacheFromRoom(PublicDogResponse userId) {
        return UserLocalCacheService.z(userId);
    }

    public static /* synthetic */ DogProfile P(u2 u2Var, String str, DogProfile dogProfile) {
        UserLocalCacheService.f(u2Var, str, dogProfile);
        return dogProfile;
    }

    /* renamed from: Q, reason: from kotlin metadata */
    public static /* synthetic */ String getCurrentDogNameOrBlank(DogEntity userId) {
        return UserLocalCacheService.updateAbBucketUserProperties(userId);
    }

    public static /* synthetic */ void R(u2 u2Var, String str, String str2, i.b.c cVar) {
        UserLocalCacheService.l(u2Var, str, str2, cVar);
    }

    /* renamed from: S, reason: from kotlin metadata */
    public static /* synthetic */ String getDogNameOrBlank(Throwable dogId) {
        return UserLocalCacheService.isUserDataSynced(dogId);
    }

    /* renamed from: t, reason: from kotlin metadata */
    private static final String isUserDataSynced(Throwable userId) {
        n.f(userId, "it");
        return "";
    }

    /* renamed from: v, reason: from kotlin metadata */
    private static final String removeParticipatingChallenge(Throwable challengeId) {
        n.f(challengeId, "it");
        return "";
    }
}
