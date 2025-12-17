package app.dogo.com.dogo_android.s.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.LocaleList;
import androidx.lifecycle.LiveData;
import app.dogo.android.network.DogoApiClient;
import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity;
import app.dogo.android.persistencedb.room.entity.UserStateEntity;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.model.inapp.InAppFeedbackModel;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;
import app.dogo.com.dogo_android.repository.domain.DogParentUIStateKt;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.DogSelectData;
import app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.i2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.o2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.v.a;
import app.dogo.com.dogo_android.v.b;
import app.dogo.com.dogo_android.v.b.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.view.dailytraining.l.a;
import app.dogo.com.dogo_android.w.a1;
import app.dogo.com.dogo_android.w.c0;
import app.dogo.com.dogo_android.w.n1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.w2;
import app.dogo.com.dogo_android.w.z0;
import app.dogo.externalmodel.model.PottyReminderModel;
import app.dogo.externalmodel.model.TrainingReminderModel;
import app.dogo.externalmodel.model.requests.CreateDogInviteRequest;
import app.dogo.externalmodel.model.requests.SaveArticleReadRequest;
import app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest;
import app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate;
import app.dogo.externalmodel.model.requests.UserLoginRequest;
import app.dogo.externalmodel.model.responses.CreateDogInviteResponse;
import app.dogo.externalmodel.model.responses.GetDogParentsResponse;
import app.dogo.externalmodel.model.responses.ReminderResponse;
import app.dogo.externalmodel.model.responses.UserApiModel;
import app.dogo.externalmodel.model.responses.UserReadArticlesResponse;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import e.a.a.a.b.b.o0;
import e.a.a.a.b.b.q0;
import e.a.a.a.b.b.w;
import i.b.a0;
import i.b.b;
import i.b.f;
import i.b.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J2\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0008\u0010/\u001a\u0004\u0018\u000100J\u0018\u00101\u001a\u0008\u0012\u0004\u0012\u000203022\n\u0008\u0002\u00104\u001a\u0004\u0018\u00010,J\u000e\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020,J\u000e\u00107\u001a\u00020(2\u0006\u00108\u001a\u000203J\u001c\u00109\u001a\u0008\u0012\u0004\u0012\u00020:022\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,J\u0014\u0010=\u001a\u0008\u0012\u0004\u0012\u00020:022\u0006\u0010;\u001a\u00020,J\u0014\u0010>\u001a\u0008\u0012\u0004\u0012\u00020?022\u0006\u0010;\u001a\u00020,J\u000e\u0010@\u001a\u00020A2\u0006\u0010;\u001a\u00020,J\u0016\u0010B\u001a\u00020A2\u0006\u0010;\u001a\u00020,2\u0006\u0010C\u001a\u00020,J\u000c\u0010D\u001a\u0008\u0012\u0004\u0012\u00020:02J\u000e\u0010E\u001a\u00020:2\u0006\u0010;\u001a\u00020,J\u0006\u0010F\u001a\u00020AJ\u000e\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u00020IJ\u0011\u0010K\u001a\u00020,H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u000c\u0010M\u001a\u0008\u0012\u0004\u0012\u00020,02J\u000c\u0010N\u001a\u0008\u0012\u0004\u0012\u00020302J\u000c\u0010O\u001a\u0008\u0012\u0004\u0012\u0002030PJ\u0010\u0010Q\u001a\u00020,2\u0006\u0010R\u001a\u00020\u0003H\u0002J\u0014\u0010S\u001a\u0008\u0012\u0004\u0012\u000203022\u0006\u0010;\u001a\u00020,J\u0006\u0010T\u001a\u00020UJ\u001a\u0010V\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020X0W022\u0006\u0010;\u001a\u00020,J\u0014\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020Z022\u0006\u0010;\u001a\u00020,J\u0014\u0010[\u001a\u0008\u0012\u0004\u0012\u00020\\022\u0006\u0010;\u001a\u00020,J\u0006\u0010]\u001a\u00020:J\u0006\u0010^\u001a\u00020:J\u000c\u0010_\u001a\u0008\u0012\u0004\u0012\u00020`02J\u0011\u0010a\u001a\u00020bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u000e\u0010c\u001a\u00020:2\u0006\u00106\u001a\u00020,J\u000e\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020,J\u000e\u0010f\u001a\u00020:2\u0006\u0010e\u001a\u00020,J\u0006\u0010g\u001a\u00020(J\u0006\u0010h\u001a\u00020(J\u0006\u0010i\u001a\u00020AJ\u000e\u0010j\u001a\u00020(2\u0006\u00106\u001a\u00020,J\u0006\u0010k\u001a\u00020(J\u000e\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020,J\u0006\u0010n\u001a\u00020(J\u0006\u0010o\u001a\u00020(J\u0006\u0010p\u001a\u00020(J\u0011\u0010q\u001a\u00020(H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u0006\u0010r\u001a\u00020AJ\u0006\u0010s\u001a\u00020:J\u0006\u0010t\u001a\u00020(J \u0010u\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0002J\u0006\u0010v\u001a\u00020(J\u000e\u0010w\u001a\u00020(2\u0006\u0010;\u001a\u00020,J\u001a\u0010x\u001a\u00020A2\u0006\u0010y\u001a\u00020z2\n\u0008\u0002\u0010{\u001a\u0004\u0018\u00010,J!\u0010|\u001a\u00020(2\u0006\u0010}\u001a\u00020,2\u0006\u0010~\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u007fJ\u001a\u0010\u0080\u0001\u001a\u00020A2\u0007\u0010\u0081\u0001\u001a\u00020,2\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001J\u0007\u0010\u0084\u0001\u001a\u00020AJ\r\u0010\u0085\u0001\u001a\u0008\u0012\u0004\u0012\u00020z02R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0086\u0001", d2 = {"Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "", "application", "Landroid/content/Context;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "preference", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "userEntityDao", "Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "trickKnowledgeDao", "Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "(Landroid/content/Context;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;Lapp/dogo/com/dogo_android/service/NotificationService;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;)V", "tempUserCache", "Lapp/dogo/com/dogo_android/temp/UserAndDogCache;", "getTempUserCache", "()Lapp/dogo/com/dogo_android/temp/UserAndDogCache;", "addFeedback", "", "score", "", "comment", "", "campaignId", "campaignName", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "addNewDog", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "name", "addParticipatingChallenge", "challengeId", "blockingUpdateUsersDogStreakTrackingProperties", "dogProfile", "checkAndUpdateIfUserUnlockedWorkout", "", "dogId", "source", "checkIfUserUnlockedWorkout", "createDogInviteId", "Lapp/dogo/externalmodel/model/responses/CreateDogInviteResponse;", "deleteDog", "Lio/reactivex/Completable;", "deleteDogParent", "ownerId", "doesCacheExists", "doesDogBelongToUser", "fillCacheFromRoom", "fillFromBundle", "bundle", "Landroid/os/Bundle;", "getCacheBundle", "getCurrentDogId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentDogIdSingle", "getCurrentDogProfile", "getCurrentDogProfileLiveData", "Landroidx/lifecycle/LiveData;", "getCurrentLocaleLanguageOrEn", "context", "getDogProfile", "getDogSelectData", "Lapp/dogo/com/dogo_android/repository/domain/DogSelectData;", "getOwnersInformation", "", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "getPremiumStateForDog", "Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "getPublicDogProfile", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "getShouldShowReminderInDashboard", "getShouldShowReminderOnceInTreeDays", "getUserReadArticlesEvents", "Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse;", "getUserState", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;", "isParticipatingInChallenge", "isPolicyAccepted", "policy", "isPolicyShown", "refreshAdminList", "refreshAmbassadorDogsList", "refreshUserDataIfNeeded", "removeParticipatingChallenge", "resetRecapInformation", "saveArticleRead", "articleId", "saveShouldShowReminderInDashboard", "setExitDialogShown", "setReminderShownInDashboard", "setWorkoutStreakSyncedToTimeMetrics", "setupUserCache", "shouldPreventExit", "trackDevice", "trackScore", "triggerCurrentDogProfileLiveData", "updateCurrentDog", "updateLocalUserData", "userApiModel", "Lapp/dogo/externalmodel/model/responses/UserApiModel;", "newCurrentDogId", "updateMetricsGoalNotReachedState", "date", "durationSec", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePolicy", "policyId", "policyStatus", "Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "updateRemoteDevice", "updateUserCacheFromRemote", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p1 {

    private final Context a;
    private final u2 b;
    private final h2 c;
    private final FirebaseFirestore d;
    private final m2 e;
    private final p2 f;
    private final v2 g;
    private final o3 h;
    private final r2 i;
    private final DogoApiClient j;
    private final q0 k;
    private final i2 l;
    private final o2 m;
    private final w n;
    private final o0 o;
    private final app.dogo.com.dogo_android.s.b.l1 p;
    public p1(Context context, u2 u22, h2 h23, FirebaseFirestore firebaseFirestore4, m2 m25, p2 p26, v2 v27, o3 o38, r2 r29, DogoApiClient dogoApiClient10, q0 q011, i2 i212, o2 o213, w w14, o0 o015, app.dogo.com.dogo_android.s.b.l1 l116) {
        Object obj = this;
        Object obj3 = context;
        final Object obj4 = u22;
        final Object obj5 = h23;
        final Object obj6 = firebaseFirestore4;
        final Object obj7 = m25;
        final Object obj8 = p26;
        final Object obj9 = v27;
        final Object obj10 = o38;
        final Object obj11 = r29;
        final Object obj12 = dogoApiClient10;
        final Object obj13 = q011;
        final Object obj14 = i212;
        final Object obj15 = o213;
        final Object obj16 = w14;
        n.f(obj3, "application");
        n.f(obj4, "userLocalCacheService");
        n.f(obj5, "authService");
        n.f(obj6, "firestore");
        n.f(obj7, "firestoreService");
        n.f(obj8, "preference");
        n.f(obj9, "utilities");
        n.f(obj10, "tracker");
        n.f(obj11, "remoteConfigService");
        n.f(obj12, "apiClient");
        n.f(obj13, "userEntityDao");
        n.f(obj14, "cloudFunctionsService");
        n.f(obj15, "notificationService");
        n.f(obj16, "dogLocalEntityDao");
        n.f(o015, "trickKnowledgeDao");
        Object obj18 = l116;
        n.f(obj18, "reminderRepository");
        super();
        Object obj2 = this;
        obj2.a = obj3;
        obj2.b = obj4;
        obj2.c = obj5;
        obj2.d = obj6;
        obj2.e = obj7;
        obj2.f = obj8;
        obj2.g = obj9;
        obj2.h = obj10;
        obj2.i = obj11;
        obj2.j = obj12;
        obj2.k = obj13;
        obj2.l = obj14;
        obj2.m = obj15;
        obj2.n = obj16;
        obj2.o = o015;
        obj2.p = obj18;
    }

    private static final f A0(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        n.f(p1, "this$0");
        n.f(userApiModel2, "it");
        int i = 0;
        return p1.w0(p1, userApiModel2, i, 2, i);
    }

    private static final List C(GetDogParentsResponse getDogParentsResponse) {
        int dogParent;
        n.f(getDogParentsResponse, "owners");
        Collection obj2 = getDogParentsResponse.getParents().values();
        ArrayList arrayList = new ArrayList(p.r(obj2, 10));
        obj2 = obj2.iterator();
        for (GetDogParentsResponse.DogParentData next2 : obj2) {
            arrayList.add(DogParentUIStateKt.toDogParent(next2));
        }
        return arrayList;
    }

    private static final g0 C0(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        n.f(p1, "this$0");
        n.f(userApiModel2, "it");
        int i = 0;
        w0 w0Var = new w0(userApiModel2);
        return p1.w0(p1, userApiModel2, i, 2, i).B(w0Var);
    }

    private static final UserApiModel D0(UserApiModel userApiModel) {
        n.f(userApiModel, "$it");
        return userApiModel;
    }

    public static f N(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        return p1.e0(p1, userApiModel2);
    }

    public static f O(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2, RemindersModel remindersModel3) {
        return p1.f0(p1, userApiModel2, remindersModel3);
    }

    public static List P(GetDogParentsResponse getDogParentsResponse) {
        return p1.C(getDogParentsResponse);
    }

    public static Boolean Q(Boolean boolean) {
        p1.j(boolean);
        return boolean;
    }

    public static g0 R(app.dogo.com.dogo_android.s.b.p1 p1, String string2, String string3, DogLocalEntity dogLocalEntity4) {
        return p1.h(p1, string2, string3, dogLocalEntity4);
    }

    public static g0 S(app.dogo.com.dogo_android.s.b.p1 p1, String string2, DogLocalEntity dogLocalEntity3) {
        return p1.l(p1, string2, dogLocalEntity3);
    }

    public static f T(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        return p1.h0(p1, userApiModel2);
    }

    public static f U(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        return p1.A0(p1, userApiModel2);
    }

    public static f V(app.dogo.com.dogo_android.s.b.p1 p1, Throwable throwable2) {
        return p1.p0(p1, throwable2);
    }

    public static f W(UserApiModel userApiModel, RemindersModel remindersModel2, app.dogo.com.dogo_android.s.b.p1 p13, List list4) {
        return p1.g0(userApiModel, remindersModel2, p13, list4);
    }

    public static Boolean X(List list) {
        return p1.m(list);
    }

    public static g0 Y(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        return p1.C0(p1, userApiModel2);
    }

    public static UserApiModel Z(UserApiModel userApiModel) {
        p1.D0(userApiModel);
        return userApiModel;
    }

    public static g0 a0(DogLocalEntity dogLocalEntity, app.dogo.com.dogo_android.s.b.p1 p12, String string3, String string4, Boolean boolean5) {
        return p1.i(dogLocalEntity, p12, string3, string4, boolean5);
    }

    public static void b(app.dogo.com.dogo_android.s.b.p1 p1, int i2, String string3, String string4, String string5, InAppFeedbackExtras inAppFeedbackExtras6, int i7, Object object8) {
        String obj8;
        if (i7 &= 2 != 0) {
            obj8 = "";
        }
        p1.a(i2, obj8, string4, string5, inAppFeedbackExtras6);
    }

    public static a0 d(app.dogo.com.dogo_android.s.b.p1 p1, String string2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return p1.c(obj1);
    }

    private static final f e0(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        n.f(p1, "this$0");
        n.f(userApiModel2, "userApiResponse");
        l0 l0Var = new l0(p1, userApiModel2);
        return p1.p.m(p1.c.v()).flatMapCompletable(l0Var);
    }

    private static final f f0(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2, RemindersModel remindersModel3) {
        n.f(p1, "this$0");
        n.f(userApiModel2, "$userApiResponse");
        n.f(remindersModel3, "localTrainingReminders");
        t0 t0Var = new t0(userApiModel2, remindersModel3, p1);
        return p1.p.j(p1.c.v()).flatMapCompletable(t0Var);
    }

    private static final f g0(UserApiModel userApiModel, RemindersModel remindersModel2, app.dogo.com.dogo_android.s.b.p1 p13, List list4) {
        b flatMapCompletable;
        String string;
        boolean empty;
        int q0Var;
        boolean trainingReminder;
        int active;
        boolean next;
        int trainingReminderModel;
        Object str;
        Object obj;
        String reminderId;
        String startTime;
        Object obj2;
        long minutes;
        long longValue;
        app.dogo.externalmodel.model.TrainingReminderModel.Weekdays l4;
        long l;
        String dogId;
        int i;
        long l3;
        long l2;
        Object obj3 = userApiModel;
        final Object obj4 = p13;
        Object obj5 = list4;
        n.f(obj3, "$userApiResponse");
        n.f(remindersModel2, "$localTrainingReminders");
        n.f(obj4, "this$0");
        n.f(obj5, "localPottyReminders");
        trainingReminderModel = 0;
        if (userApiModel.getPottyReminders().isEmpty() && userApiModel.getTrainingReminder() == null) {
            if (userApiModel.getTrainingReminder() == null) {
                if (remindersModel2.isEmpty()) {
                    if (empty2 ^= 1 != 0) {
                        ArrayList arrayList = new ArrayList(p.r(obj5, 10));
                        Iterator iterator = list4.iterator();
                        str = "";
                        while (iterator.hasNext()) {
                            Object next2 = iterator.next();
                            String endTime = next2.getEndTime();
                            if (endTime == null) {
                            } else {
                            }
                            obj2 = endTime;
                            Long repeatIntervalMs = next2.getRepeatIntervalMs();
                            if (repeatIntervalMs == null) {
                            } else {
                            }
                            longValue = repeatIntervalMs.longValue();
                            super((PottyRemindersItem)next2.getReminderId(), next2.getStartTime(), obj2, TimeUnit.MILLISECONDS.toMinutes(longValue), obj12, j1.U0(next2.getDays()), next2.getDogId(), next2.isActive(), obj4.g.g(), obj17, obj4.g.g(), obj19);
                            arrayList.add(pottyReminderModel);
                            str = "";
                            longValue = 0;
                            obj2 = str;
                        }
                        if (remindersModel2.isEmpty()) {
                        } else {
                            if (remindersModel2.getId() == null) {
                                n.e(UUID.randomUUID().toString(), "randomUUID().toString()");
                            }
                            String time = remindersModel2.getTime();
                            startTime = time == null ? str : time;
                            super(string, startTime, j1.U0(remindersModel2.getDays()), remindersModel2.isActive(), obj4.g.g(), l, obj4.g.g(), i);
                        }
                        trainingReminder = new ReminderResponse(trainingReminderModel, arrayList);
                        q0Var = new q0(obj4);
                        flatMapCompletable = obj4.j.migrateRemindersSingle(trainingReminder).flatMapCompletable(q0Var);
                    } else {
                        flatMapCompletable = p1.w0(obj4, obj3, trainingReminderModel, 2, trainingReminderModel);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return flatMapCompletable;
    }

    private static final g0 h(app.dogo.com.dogo_android.s.b.p1 p1, String string2, String string3, DogLocalEntity dogLocalEntity4) {
        n.f(p1, "this$0");
        n.f(string2, "$dogId");
        n.f(string3, "$source");
        n.f(dogLocalEntity4, "dogLocalEntity");
        x0 x0Var = new x0(dogLocalEntity4, p1, string2, string3);
        return p1.k(string2).flatMap(x0Var);
    }

    private static final f h0(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        n.f(p1, "this$0");
        n.f(userApiModel2, "it");
        int i = 0;
        return p1.w0(p1, userApiModel2, i, 2, i);
    }

    private static final g0 i(DogLocalEntity dogLocalEntity, app.dogo.com.dogo_android.s.b.p1 p12, String string3, String string4, Boolean boolean5) {
        boolean obj1;
        n.f(dogLocalEntity, "$dogLocalEntity");
        n.f(p12, "this$0");
        n.f(string3, "$dogId");
        n.f(string4, "$source");
        n.f(boolean5, "workoutUnlocked");
        if (!dogLocalEntity.getWorkoutUnlocked() && boolean5.booleanValue()) {
            if (boolean5.booleanValue()) {
                obj1 = p12.n.a(string3, string4);
            } else {
                obj1 = b.f();
            }
        } else {
        }
        n0 obj2 = new n0(boolean5);
        return obj1.B(obj2);
    }

    private static final Boolean j(Boolean boolean) {
        n.f(boolean, "$workoutUnlocked");
        return boolean;
    }

    private static final g0 l(app.dogo.com.dogo_android.s.b.p1 p1, String string2, DogLocalEntity dogLocalEntity3) {
        a0 obj1;
        Object obj2;
        n.f(p1, "this$0");
        n.f(string2, "$dogId");
        n.f(dogLocalEntity3, "dogLocalEntity");
        if (dogLocalEntity3.getWorkoutUnlocked()) {
            obj1 = a0.just(Boolean.valueOf(dogLocalEntity3.getWorkoutUnlocked()));
        } else {
            obj1 = p1.o.d(string2).map(u0.a);
        }
        return obj1;
    }

    private static final Boolean m(List list) {
        Object next;
        int trickId;
        int i3;
        int i;
        int knowledge;
        int i2;
        n.f(list, "entities");
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = list.iterator();
        i3 = 1;
        i = 0;
        while (obj6.hasNext()) {
            next = obj6.next();
            if ((TrickProgressEntity)next.getKnowledge() >= 4) {
            } else {
            }
            i3 = i;
            if (i3 != 0) {
            }
            i3 = 1;
            i = 0;
            arrayList.add(next);
        }
        obj6 = new ArrayList(p.r(arrayList, 10));
        Iterator iterator = arrayList.iterator();
        for (TrickProgressEntity next4 : iterator) {
            obj6.add(next4.getTrickId());
        }
        if (l.Companion.c(obj6).size() >= 3) {
        } else {
            i3 = i;
        }
        return Boolean.valueOf(i3);
    }

    private static final f p0(app.dogo.com.dogo_android.s.b.p1 p1, Throwable throwable2) {
        n.f(p1, "this$0");
        n.f(throwable2, "it");
        a.e(throwable2, "App start, remote user data sync failed", new Object[0]);
        return p1.r();
    }

    private final void s0(int i, String string2, String string3) {
        int i3;
        w2 i7;
        int i5;
        int i2;
        int i4;
        int i6;
        int a1Var;
        app.dogo.com.dogo_android.w.h3 obj4;
        Object obj5;
        Object obj6;
        i3 = 1;
        i7 = 0;
        if (i3 <= i && i <= 6) {
            i2 = i <= 6 ? i3 : i7;
        } else {
        }
        if (i2 != 0) {
            n1 n1Var3 = new n1();
            z0 z0Var3 = new z0();
            a1Var = new a1();
            this.h.d(c0.c.d(u.a(n1Var3, Integer.valueOf(i)), u.a(z0Var3, string2), u.a(a1Var, string3)));
        } else {
            if (7 <= i && i <= 8) {
                i6 = i <= 8 ? i3 : i7;
            } else {
            }
            if (i6 != 0) {
                n1 n1Var = new n1();
                z0 z0Var = new z0();
                a1Var = new a1();
                this.h.d(c0.b.d(u.a(n1Var, Integer.valueOf(i)), u.a(z0Var, string2), u.a(a1Var, string3)));
            } else {
                if (9 <= i && i <= 10) {
                    if (i <= 10) {
                    } else {
                        i3 = i7;
                    }
                } else {
                }
                if (i3 != 0) {
                    n1 n1Var2 = new n1();
                    z0 z0Var2 = new z0();
                    a1Var = new a1();
                    this.h.d(c0.a.d(u.a(n1Var2, Integer.valueOf(i)), u.a(z0Var2, string2), u.a(a1Var, string3)));
                }
            }
        }
    }

    public static b w0(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2, String string3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return p1.v0(userApiModel2, obj2);
    }

    private final String y(Context context) {
        String obj2;
        if (context.getResources().getConfiguration().getLocales().get(0).getLanguage() == null) {
            obj2 = "en";
        }
        return obj2;
    }

    public final DogSelectData A() {
        DogSelectData dogSelectData = new DogSelectData(p.L0(H().m().values()), H().f());
        return dogSelectData;
    }

    public final a0<List<DogParentUIState.DogParent>> B(String string) {
        n.f(string, "dogId");
        a0 obj2 = this.j.getDogParents(string).map(m0.a);
        n.e(obj2, "apiClient.getDogParents(dogId).map { owners ->\n            owners.parents.values.map { it.toDogParent() }\n        }");
        return obj2;
    }

    public final a0<UserApiModel> B0() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(H().i().a());
        v0 v0Var = new v0(this);
        a0 flatMap = this.j.loginUserSingle(userLoginRequest).flatMap(v0Var);
        n.e(flatMap, "apiClient.loginUserSingle(\n            UserLoginRequest(device = tempUserCache.deviceData.buildUserDeviceModel())\n        ).flatMap {\n            updateLocalUserData(it).toSingle { it }\n        }");
        return flatMap;
    }

    public final a0<DogoPremiumStatusEntity> D(String string) {
        n.f(string, "dogId");
        return this.b.x(string);
    }

    public final a0<PublicDogProfile> E(String string) {
        n.f(string, "dogId");
        return this.b.y(string);
    }

    public final boolean F() {
        boolean z;
        int i;
        if (this.f.Y() && G()) {
            i = G() ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean G() {
        int i;
        boolean cmp;
        String str;
        long millis;
        int i2;
        if (this.i.h0() && !this.p.o(this.c.v()) && Long.compare(i3, millis) > 0) {
            if (!this.p.o(this.c.v())) {
                i = Long.compare(i3, millis) > 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public final c H() {
        return this.b.A();
    }

    public final a0<UserReadArticlesResponse> I() {
        return this.j.getUserReadArticlesSingle();
    }

    public final Object J(d<? super UserStateEntity> d) {
        return this.k.m(this.c.v(), d);
    }

    public final boolean K(String string) {
        n.f(string, "challengeId");
        return H().o().b().contains(string);
    }

    public final boolean L(String string) {
        n.f(string, "policy");
        return this.b.B(string);
    }

    public final boolean M(String string) {
        n.f(string, "policy");
        return this.b.C(string);
    }

    public final void a(int i, String string2, String string3, String string4, InAppFeedbackExtras inAppFeedbackExtras5) {
        Object obj4;
        int map;
        String str2;
        Object obj;
        Object obj2;
        int i5;
        Object obj3;
        String str;
        int i2;
        int i3;
        int i6;
        int i7;
        int i9;
        int i8;
        InAppFeedbackModel inAppFeedbackModel;
        int i4;
        obj4 = this;
        obj = string3;
        obj2 = string4;
        n.f(string2, "comment");
        n.f(obj, "campaignId");
        n.f(obj2, "campaignName");
        obj4.s0(i, obj, obj2);
        final String str6 = obj4.c.v();
        if (z ^= 1 != 0) {
            super(str6, H().f(), string3, string4, i, string2, obj4.y(obj4.a), 0, obj10, 0, 0, inAppFeedbackExtras5, 896, 0);
            obj4.d.collection("feedback").add(inAppFeedbackModel.toMap());
        }
    }

    public final void b0() {
        this.e.i0();
    }

    public final a0<DogProfile> c(String string) {
        return this.b.b(this.c.v(), string);
    }

    public final void c0() {
        this.e.l0();
    }

    public final b d0() {
        b flatMapCompletable;
        String str;
        if (!this.b.D(this.c.v())) {
            k0 k0Var = new k0(this);
            n.e(this.j.getUserApiModelSingle().flatMapCompletable(k0Var), "{\n            apiClient.getUserApiModelSingle().flatMapCompletable { userApiResponse ->\n                reminderRepository.getTrainingReminderOrEmptyByUserId(authService.currentUserId).flatMapCompletable { localTrainingReminders ->\n                    reminderRepository.getPottyRemindersByUserId(authService.currentUserId).flatMapCompletable { localPottyReminders ->\n                        if (userApiResponse.pottyReminders.isEmpty() && userApiResponse.trainingReminder == null && (!localTrainingReminders.isEmpty() || localPottyReminders.isNotEmpty())) {\n                            val localPottyReminderModelList = localPottyReminders.map {\n                                PottyReminderModel(\n                                    id = it.reminderId,\n                                    startTime = it.startTime,\n                                    endTime = it.endTime ?: \"\",\n                                    intervalMinutes = TimeUnit.MILLISECONDS.toMinutes(it.repeatIntervalMs ?: 0),\n                                    weekdays = it.days.toWeekdays(),\n                                    dogId = it.dogId,\n                                    enabled = it.isActive,\n                                    updateTimeMs = utilities.currentTimeInMillis,\n                                    createTimeMs = utilities.currentTimeInMillis\n                                )\n                            }\n                            val localTrainingReminderModel = if (localTrainingReminders.isEmpty()) {\n                                null\n                            } else {\n                                TrainingReminderModel(\n                                    id = localTrainingReminders.id ?: UUID.randomUUID().toString(),\n                                    time = localTrainingReminders.time ?: \"\",\n                                    weekdays = localTrainingReminders.days.toWeekdays(),\n                                    enabled = localTrainingReminders.isActive,\n                                    updateTimeMs = utilities.currentTimeInMillis,\n                                    createTimeMs = utilities.currentTimeInMillis\n                                )\n                            }\n                            apiClient.migrateRemindersSingle(\n                                ReminderResponse(\n                                    trainingReminder = localTrainingReminderModel,\n                                    pottyReminders = localPottyReminderModelList\n                                )\n                            ).flatMapCompletable {\n                                updateLocalUserData(it)\n                            }\n                        } else {\n                            updateLocalUserData(userApiResponse)\n                        }\n                    }\n                }\n            }\n        }");
        } else {
            n.e(b.f(), "{\n            Completable.complete()\n        }");
        }
        return flatMapCompletable;
    }

    public final void e(String string) {
        n.f(string, "challengeId");
        this.b.g(string);
    }

    public final void f(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        Object obj4 = this.n.i(dogProfile.getId()).blockingGet();
        this.h.q(q3.CurrentStreak, Integer.valueOf((DogLocalEntity)obj4.getCurrentStreak()));
        this.h.q(q3.LongestStreak, Integer.valueOf(Math.max(obj4.getLongestStreak(), obj4.getCurrentStreak())));
    }

    public final a0<Boolean> g(String string, String string2) {
        n.f(string, "dogId");
        n.f(string2, "source");
        o0 o0Var = new o0(this, string, string2);
        final a0 obj3 = this.n.i(string).flatMap(o0Var);
        n.e(obj3, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).flatMap { dogLocalEntity ->\n            checkIfUserUnlockedWorkout(dogId).flatMap { workoutUnlocked ->\n                if (!dogLocalEntity.workoutUnlocked && workoutUnlocked) {\n                    dogLocalEntityDao.setWorkoutUnlocked(dogId, source)\n                } else {\n                    Completable.complete()\n                }.toSingle { workoutUnlocked }\n            }\n        }");
        return obj3;
    }

    public final void i0() {
        this.l.o(this.c.v());
    }

    public final b j0(String string) {
        n.f(string, "articleId");
        SaveArticleReadRequest saveArticleReadRequest = new SaveArticleReadRequest(1);
        b obj4 = this.j.saveArticleReadSingle(string, saveArticleReadRequest).ignoreElement();
        n.e(obj4, "apiClient.saveArticleReadSingle(articleId, SaveArticleReadRequest(isRead = true)).ignoreElement()");
        return obj4;
    }

    public final a0<Boolean> k(String string) {
        n.f(string, "dogId");
        p0 p0Var = new p0(this, string);
        final a0 obj3 = this.n.i(string).flatMap(p0Var);
        n.e(obj3, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).flatMap { dogLocalEntity ->\n            if (dogLocalEntity.workoutUnlocked) {\n                Single.just(dogLocalEntity.workoutUnlocked)\n            } else {\n                trickKnowledgeDao.getAllDogTrickKnowledge(dogId).map { entities ->\n                    val knowTrickIds = entities.filter { it.knowledge >= TrickItem.MIN_KNOWLEDGE_REACHED }.map { it.trickId }\n                    val filteredKnowTricks = SessionViewModel.filterBlacklistedTrickIds(knowTrickIds)\n                    val isWorkoutUnlocked = filteredKnowTricks.size >= 3\n                    isWorkoutUnlocked\n                }\n            }\n        }");
        return obj3;
    }

    public final void k0() {
        this.f.q1(true);
    }

    public final void l0() {
        this.f.e();
    }

    public final void m0() {
        this.f.q1(false);
    }

    public final a0<CreateDogInviteResponse> n(String string) {
        n.f(string, "dogId");
        CreateDogInviteRequest createDogInviteRequest = new CreateDogInviteRequest(string);
        return this.j.createDogInvite(createDogInviteRequest);
    }

    public final Object n0(d<? super w> d) {
        Object obj4 = this.k.e(this.c.v(), true, d);
        if (obj4 == b.d()) {
            return obj4;
        }
        return w.a;
    }

    public final b o(String string) {
        n.f(string, "dogId");
        b obj4 = this.j.deleteDog(string).c(this.b.T(this.c.v(), string));
        n.e(obj4, "apiClient.deleteDog(dogId).andThen(\n            userLocalCacheService.removeDog(authService.currentUserId, dogId)\n        )");
        return obj4;
    }

    public final b o0() {
        s0 s0Var = new s0(this);
        r0();
        b bVar2 = B0().ignoreElement().t(s0Var).c(a0.just(w.a).ignoreElement());
        n.e(bVar2, "updateUserCacheFromRemote().ignoreElement()\n            .onErrorResumeNext {\n                Timber.e(it, \"App start, remote user data sync failed\")\n                fillCacheFromRoom()\n            }.andThen(\n                Single.just(trackDevice()).ignoreElement()\n            )");
        return bVar2;
    }

    public final b p(String string, String string2) {
        String str;
        b obj3;
        Object obj4;
        n.f(string, "dogId");
        n.f(string2, "ownerId");
        if (n.b(string2, this.c.v())) {
            obj3 = this.b.T(this.c.v(), string);
        } else {
            n.e(b.f(), "{\n                Completable.complete()\n            }");
        }
        obj3 = this.j.removeDogParent(string, string2).c(obj3);
        n.e(obj3, "apiClient.removeDogParent(dogId, ownerId).andThen(\n            if (ownerId == authService.currentUserId) {\n                userLocalCacheService.removeDog(authService.currentUserId, dogId)\n            } else {\n                Completable.complete()\n            }\n        )");
        return obj3;
    }

    public final a0<Boolean> q() {
        return this.b.j(this.c.v());
    }

    public final boolean q0() {
        return this.f.j0();
    }

    public final b r() {
        b bVar;
        String str;
        try {
            bVar = this.b.m(this.c.v());
            a.d(th);
            Throwable th = b.f();
            n.e(th, "{\n            Timber.e(e)\n            Completable.complete()\n        }");
            return bVar;
        }
    }

    public final void r0() {
        this.h.q(q3.FcmToken, H().i().d());
        this.h.q(q3.Locale, n2.a.a(App.Companion.l().W()));
        String iD = TimeZone.getDefault().getID();
        n.e(iD, "getDefault().id");
        this.h.w(iD);
    }

    public final boolean s(Bundle bundle) {
        n.f(bundle, "bundle");
        return H().b(bundle);
    }

    public final Bundle t() {
        return H().c();
    }

    public final void t0() {
        H().q();
    }

    public final Object u(d<? super String> d) {
        return H().f();
    }

    public final void u0(String string) {
        n.f(string, "dogId");
        this.b.X(this.c.v(), string);
    }

    public final a0<String> v() {
        a0 just = a0.just(H().f());
        n.e(just, "just(tempUserCache.currentDogId)");
        return just;
    }

    public final b v0(UserApiModel userApiModel, String string2) {
        n.f(userApiModel, "userApiModel");
        return this.b.b0(userApiModel, string2);
    }

    public final a0<DogProfile> w() {
        a0 just = a0.just(H().g());
        n.e(just, "just(tempUserCache.currentDogProfile)");
        return just;
    }

    public final LiveData<DogProfile> x() {
        int i;
        i = H().f().length() == 0 ? 1 : 0;
        if (i != 0) {
            r().e();
        }
        return H().h();
    }

    public final Object x0(String string, int i2, d<? super w> d3) {
        Object obj3 = this.k.c(this.c.v(), string, i2, d3);
        if (obj3 == b.d()) {
            return obj3;
        }
        return w.a;
    }

    public final b y0(String string, b.c b$c2) {
        n.f(string, "policyId");
        n.f(c2, "policyStatus");
        return this.b.e0(string, c2);
    }

    public final a0<DogProfile> z(String string) {
        n.f(string, "dogId");
        a0 obj2 = a0.just(H().m().get(string));
        n.e(obj2, "just(tempUserCache.dogs[dogId])");
        return obj2;
    }

    public final b z0() {
        String str;
        String str2;
        a aVar = H().i();
        String str5 = aVar.b();
        String str7 = "";
        str2 = str5 == null ? str7 : str5;
        if (aVar.d() == null) {
            str = str7;
        }
        super(aVar.f(), str2, aVar.e(), str, this.m.a());
        UserDeviceUpdateRequest userDeviceUpdateRequest = new UserDeviceUpdateRequest(deviceUpdate);
        r0 r0Var = new r0(this);
        b flatMapCompletable = this.j.updateUserDeviceData(aVar.c(), userDeviceUpdateRequest).flatMapCompletable(r0Var);
        n.e(flatMapCompletable, "apiClient.updateUserDeviceData(\n            deviceData.deviceId,\n            UserDeviceUpdateRequest(\n                device = UserDeviceUpdateRequest.DeviceUpdate(\n                    timeZone = deviceData.timezone,\n                    countryCode = deviceData.country ?: \"\",\n                    locale = deviceData.language,\n                    fcmToken = deviceData.fcmToken ?: \"\",\n                    notificationsEnabled = notificationService.areNotificationsEnabled()\n                )\n            )\n        ).flatMapCompletable {\n            updateLocalUserData(it)\n        }");
        return flatMapCompletable;
    }
}
