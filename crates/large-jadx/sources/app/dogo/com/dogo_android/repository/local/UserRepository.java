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
import app.dogo.com.dogo_android.v.b.c;
import app.dogo.com.dogo_android.v.c;
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
import i.b.a0;
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
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.p;

/* compiled from: UserRepository.kt */
@Metadata(d1 = "\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J2\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0008\u0010/\u001a\u0004\u0018\u000100J\u0018\u00101\u001a\u0008\u0012\u0004\u0012\u000203022\n\u0008\u0002\u00104\u001a\u0004\u0018\u00010,J\u000e\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020,J\u000e\u00107\u001a\u00020(2\u0006\u00108\u001a\u000203J\u001c\u00109\u001a\u0008\u0012\u0004\u0012\u00020:022\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,J\u0014\u0010=\u001a\u0008\u0012\u0004\u0012\u00020:022\u0006\u0010;\u001a\u00020,J\u0014\u0010>\u001a\u0008\u0012\u0004\u0012\u00020?022\u0006\u0010;\u001a\u00020,J\u000e\u0010@\u001a\u00020A2\u0006\u0010;\u001a\u00020,J\u0016\u0010B\u001a\u00020A2\u0006\u0010;\u001a\u00020,2\u0006\u0010C\u001a\u00020,J\u000c\u0010D\u001a\u0008\u0012\u0004\u0012\u00020:02J\u000e\u0010E\u001a\u00020:2\u0006\u0010;\u001a\u00020,J\u0006\u0010F\u001a\u00020AJ\u000e\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u00020IJ\u0011\u0010K\u001a\u00020,H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u000c\u0010M\u001a\u0008\u0012\u0004\u0012\u00020,02J\u000c\u0010N\u001a\u0008\u0012\u0004\u0012\u00020302J\u000c\u0010O\u001a\u0008\u0012\u0004\u0012\u0002030PJ\u0010\u0010Q\u001a\u00020,2\u0006\u0010R\u001a\u00020\u0003H\u0002J\u0014\u0010S\u001a\u0008\u0012\u0004\u0012\u000203022\u0006\u0010;\u001a\u00020,J\u0006\u0010T\u001a\u00020UJ\u001a\u0010V\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020X0W022\u0006\u0010;\u001a\u00020,J\u0014\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020Z022\u0006\u0010;\u001a\u00020,J\u0014\u0010[\u001a\u0008\u0012\u0004\u0012\u00020\\022\u0006\u0010;\u001a\u00020,J\u0006\u0010]\u001a\u00020:J\u0006\u0010^\u001a\u00020:J\u000c\u0010_\u001a\u0008\u0012\u0004\u0012\u00020`02J\u0011\u0010a\u001a\u00020bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u000e\u0010c\u001a\u00020:2\u0006\u00106\u001a\u00020,J\u000e\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020,J\u000e\u0010f\u001a\u00020:2\u0006\u0010e\u001a\u00020,J\u0006\u0010g\u001a\u00020(J\u0006\u0010h\u001a\u00020(J\u0006\u0010i\u001a\u00020AJ\u000e\u0010j\u001a\u00020(2\u0006\u00106\u001a\u00020,J\u0006\u0010k\u001a\u00020(J\u000e\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020,J\u0006\u0010n\u001a\u00020(J\u0006\u0010o\u001a\u00020(J\u0006\u0010p\u001a\u00020(J\u0011\u0010q\u001a\u00020(H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u0006\u0010r\u001a\u00020AJ\u0006\u0010s\u001a\u00020:J\u0006\u0010t\u001a\u00020(J \u0010u\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0002J\u0006\u0010v\u001a\u00020(J\u000e\u0010w\u001a\u00020(2\u0006\u0010;\u001a\u00020,J\u001a\u0010x\u001a\u00020A2\u0006\u0010y\u001a\u00020z2\n\u0008\u0002\u0010{\u001a\u0004\u0018\u00010,J!\u0010|\u001a\u00020(2\u0006\u0010}\u001a\u00020,2\u0006\u0010~\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u007fJ\u001a\u0010\u0080\u0001\u001a\u00020A2\u0007\u0010\u0081\u0001\u001a\u00020,2\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001J\u0007\u0010\u0084\u0001\u001a\u00020AJ\r\u0010\u0085\u0001\u001a\u0008\u0012\u0004\u0012\u00020z02R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0086\u0001", d2 = {"Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "", "application", "Landroid/content/Context;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "preference", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "userEntityDao", "Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "trickKnowledgeDao", "Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "(Landroid/content/Context;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;Lapp/dogo/com/dogo_android/service/NotificationService;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;)V", "tempUserCache", "Lapp/dogo/com/dogo_android/temp/UserAndDogCache;", "getTempUserCache", "()Lapp/dogo/com/dogo_android/temp/UserAndDogCache;", "addFeedback", "", "score", "", "comment", "", "campaignId", "campaignName", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "addNewDog", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "name", "addParticipatingChallenge", "challengeId", "blockingUpdateUsersDogStreakTrackingProperties", "dogProfile", "checkAndUpdateIfUserUnlockedWorkout", "", "dogId", "source", "checkIfUserUnlockedWorkout", "createDogInviteId", "Lapp/dogo/externalmodel/model/responses/CreateDogInviteResponse;", "deleteDog", "Lio/reactivex/Completable;", "deleteDogParent", "ownerId", "doesCacheExists", "doesDogBelongToUser", "fillCacheFromRoom", "fillFromBundle", "bundle", "Landroid/os/Bundle;", "getCacheBundle", "getCurrentDogId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentDogIdSingle", "getCurrentDogProfile", "getCurrentDogProfileLiveData", "Landroidx/lifecycle/LiveData;", "getCurrentLocaleLanguageOrEn", "context", "getDogProfile", "getDogSelectData", "Lapp/dogo/com/dogo_android/repository/domain/DogSelectData;", "getOwnersInformation", "", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "getPremiumStateForDog", "Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "getPublicDogProfile", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "getShouldShowReminderInDashboard", "getShouldShowReminderOnceInTreeDays", "getUserReadArticlesEvents", "Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse;", "getUserState", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;", "isParticipatingInChallenge", "isPolicyAccepted", "policy", "isPolicyShown", "refreshAdminList", "refreshAmbassadorDogsList", "refreshUserDataIfNeeded", "removeParticipatingChallenge", "resetRecapInformation", "saveArticleRead", "articleId", "saveShouldShowReminderInDashboard", "setExitDialogShown", "setReminderShownInDashboard", "setWorkoutStreakSyncedToTimeMetrics", "setupUserCache", "shouldPreventExit", "trackDevice", "trackScore", "triggerCurrentDogProfileLiveData", "updateCurrentDog", "updateLocalUserData", "userApiModel", "Lapp/dogo/externalmodel/model/responses/UserApiModel;", "newCurrentDogId", "updateMetricsGoalNotReachedState", "date", "durationSec", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePolicy", "policyId", "policyStatus", "Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "updateRemoteDevice", "updateUserCacheFromRemote", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p1, reason: from kotlin metadata */
public final class UserRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final Context apiClient;
    /* renamed from: b, reason: from kotlin metadata */
    private final u2 application;
    /* renamed from: c, reason: from kotlin metadata */
    private final h2 authService;
    /* renamed from: d, reason: from kotlin metadata */
    private final FirebaseFirestore cloudFunctionsService;
    /* renamed from: e, reason: from kotlin metadata */
    private final m2 dogLocalEntityDao;
    /* renamed from: f, reason: from kotlin metadata */
    private final p2 firestore;
    /* renamed from: g, reason: from kotlin metadata */
    private final v2 firestoreService;
    /* renamed from: h, reason: from kotlin metadata */
    private final o3 notificationService;
    /* renamed from: i, reason: from kotlin metadata */
    private final r2 preference;
    /* renamed from: j, reason: from kotlin metadata */
    private final DogoApiClient reminderRepository;
    /* renamed from: k, reason: from kotlin metadata */
    private final q0 remoteConfigService;
    private final i2 l;
    /* renamed from: m, reason: from kotlin metadata */
    private final o2 tracker;
    /* renamed from: n, reason: from kotlin metadata */
    private final e.a.a.a.b.b.w trickKnowledgeDao;
    /* renamed from: o, reason: from kotlin metadata */
    private final o0 userEntityDao;
    /* renamed from: p, reason: from kotlin metadata */
    private final l1 userLocalCacheService;
    public p1(Context context, u2 u2Var, h2 h2Var, FirebaseFirestore firebaseFirestore, m2 m2Var, p2 p2Var, v2 v2Var, o3 o3Var, r2 r2Var, DogoApiClient dogoApiClient, q0 q0Var, i2 i2Var, o2 o2Var, e.a.a.a.b.b.w wVar, o0 o0Var, l1 l1Var) {
        Object context2 = context;
        final Object u2Var22 = u2Var;
        final Object h2Var32 = h2Var;
        final Object firebaseFirestore42 = firebaseFirestore;
        final Object m2Var52 = m2Var;
        final Object p2Var62 = p2Var;
        final Object v2Var72 = v2Var;
        final Object o3Var82 = o3Var;
        final Object r2Var92 = r2Var;
        final Object dogoApiClient102 = dogoApiClient;
        final Object q0Var112 = q0Var;
        final Object i2Var122 = i2Var;
        final Object o2Var132 = o2Var;
        final Object wVar142 = wVar;
        n.f(context2, "application");
        n.f(u2Var22, "userLocalCacheService");
        n.f(h2Var32, "authService");
        n.f(firebaseFirestore42, "firestore");
        n.f(m2Var52, "firestoreService");
        n.f(p2Var62, "preference");
        n.f(v2Var72, "utilities");
        n.f(o3Var82, "tracker");
        n.f(r2Var92, "remoteConfigService");
        n.f(dogoApiClient102, "apiClient");
        n.f(q0Var112, "userEntityDao");
        n.f(i2Var122, "cloudFunctionsService");
        n.f(o2Var132, "notificationService");
        n.f(wVar142, "dogLocalEntityDao");
        n.f(o0Var, "trickKnowledgeDao");
        Object l1Var162 = l1Var;
        n.f(l1Var162, "reminderRepository");
        super();
        Object context3 = this;
        context3.apiClient = context2;
        context3.application = u2Var22;
        context3.authService = h2Var32;
        context3.cloudFunctionsService = firebaseFirestore42;
        context3.dogLocalEntityDao = m2Var52;
        context3.firestore = p2Var62;
        context3.firestoreService = v2Var72;
        context3.notificationService = o3Var82;
        context3.preference = r2Var92;
        context3.reminderRepository = dogoApiClient102;
        context3.remoteConfigService = q0Var112;
        context3.l = i2Var122;
        context3.tracker = o2Var132;
        context3.trickKnowledgeDao = wVar142;
        context3.userEntityDao = o0Var;
        context3.userLocalCacheService = l1Var162;
    }

    /* renamed from: A0, reason: from kotlin metadata */
    private static final f checkAndUpdateIfUserUnlockedWorkout(p1 dogId, UserApiModel source) {
        n.f(dogId, "this$0");
        n.f(source, "it");
        String str3 = null;
        return UserRepository.w0(dogId, source, str3, 2, str3);
    }

    /* renamed from: C, reason: from kotlin metadata */
    private static final List addNewDog(GetDogParentsResponse name) {
        n.f(name, "owners");
        Collection values = name.getParents().values();
        ArrayList arrayList = new ArrayList(p.r(values, 10));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(DogParentUIStateKt.toDogParent((GetDogParentsResponse_DogParentData)it.next()));
        }
        return arrayList;
    }

    /* renamed from: C0, reason: from kotlin metadata */
    private static final g0 deleteDogParent(p1 dogId, UserApiModel ownerId) {
        n.f(dogId, "this$0");
        n.f(ownerId, "it");
        String str3 = null;
        return UserRepository.w0(dogId, ownerId, str3, 2, str3).B(new app.dogo.com.dogo_android.repository.local.w0(ownerId));
    }

    public static /* synthetic */ void b(p1 p1Var, int i, String str, String str2, String str3, InAppFeedbackExtras inAppFeedbackExtras, int i2, Object object) {
        String str32;
        if (i2 & 2 != 0) {
            str32 = "";
        }
        p1Var.a(i, str32, str2, str3, inAppFeedbackExtras);
    }

    public static /* synthetic */ a0 d(p1 p1Var, String str, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        return p1Var.removeParticipatingChallenge(str);
    }

    private static final f e0(p1 p1Var, UserApiModel userApiModel) {
        n.f(p1Var, "this$0");
        n.f(userApiModel, "userApiResponse");
        return p1Var.userLocalCacheService.m(p1Var.authService.v()).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.l0(p1Var, userApiModel));
    }

    private static final f f0(p1 p1Var, UserApiModel userApiModel, RemindersModel remindersModel) {
        n.f(p1Var, "this$0");
        n.f(userApiModel, "$userApiResponse");
        n.f(remindersModel, "localTrainingReminders");
        return p1Var.userLocalCacheService.j(p1Var.authService.v()).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.t0(userApiModel, remindersModel, p1Var));
    }

    private static final f g0(UserApiModel userApiModel, RemindersModel remindersModel, p1 p1Var, List list) {
        i.b.b flatMapCompletable;
        String reminderId;
        boolean empty2;
        boolean hasNext;
        TrainingReminderModel trainingReminderModel = null;
        PottyReminderModel pottyReminderModel;
        String startTime;
        long minutes;
        long value = 0;
        long l;
        long l2;
        String dogId;
        long l3;
        long l4;
        long l5;
        Object userApiModel2 = userApiModel;
        final Object p1Var32 = p1Var;
        Object list42 = list;
        n.f(userApiModel2, "$userApiResponse");
        n.f(remindersModel, "$localTrainingReminders");
        n.f(p1Var32, "this$0");
        n.f(list42, "localPottyReminders");
        String str = null;
        if (!userApiModel.getPottyReminders().isEmpty() || !(userApiModel.getTrainingReminder() != null && !remindersModel.isEmpty())) {
            int i = 2;
            flatMapCompletable = UserRepository.w0(p1Var32, userApiModel2, str, i, str);
        } else {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList(p.r(list42, 10));
                Iterator it = list.iterator();
                startTime = "";
                while (it.hasNext()) {
                    Object item = it.next();
                    startTime = item.getEndTime();
                    String r10 = startTime;
                    Long repeatIntervalMs = item.getRepeatIntervalMs();
                    pottyReminderModel = new PottyReminderModel(item.getReminderId(), item.getStartTime(), startTime, TimeUnit.MILLISECONDS.toMinutes(value), weekdays2, app.dogo.com.dogo_android.util.extensionfunction.j1.U0(item.getDays()), item.getDogId(), item.isActive(), p1Var32.firestoreService.g(), obj2, p1Var32.firestoreService.g(), obj3);
                    arrayList.add(pottyReminderModel);
                }
                if (!(remindersModel.isEmpty())) {
                    if (remindersModel.getId() == null) {
                        n.e(UUID.randomUUID().toString(), "randomUUID().toString()");
                    }
                    startTime = remindersModel.getTime();
                    String r9 = startTime;
                    trainingReminderModel = new TrainingReminderModel(reminderId, startTime, app.dogo.com.dogo_android.util.extensionfunction.j1.U0(remindersModel.getDays()), remindersModel.isActive(), p1Var32.firestoreService.g(), l2, p1Var32.firestoreService.g(), l3);
                }
                flatMapCompletable = p1Var32.reminderRepository.migrateRemindersSingle(new ReminderResponse(trainingReminderModel, arrayList)).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.q0(p1Var32));
            }
        }
        return flatMapCompletable;
    }

    private static final g0 h(p1 p1Var, String str, String str2, DogLocalEntity dogLocalEntity) {
        n.f(p1Var, "this$0");
        n.f(str, "$dogId");
        n.f(str2, "$source");
        n.f(dogLocalEntity, "dogLocalEntity");
        return p1Var.k(str).flatMap(new app.dogo.com.dogo_android.repository.local.x0(dogLocalEntity, p1Var, str, str2));
    }

    private static final f h0(p1 p1Var, UserApiModel userApiModel) {
        n.f(p1Var, "this$0");
        n.f(userApiModel, "it");
        String str3 = null;
        return UserRepository.w0(p1Var, userApiModel, str3, 2, str3);
    }

    private static final g0 i(DogLocalEntity dogLocalEntity, p1 p1Var, String str, String str2, Boolean boolean) {
        i.b.b resetDogStreakInfo;
        n.f(dogLocalEntity, "$dogLocalEntity");
        n.f(p1Var, "this$0");
        n.f(str, "$dogId");
        n.f(str2, "$source");
        n.f(boolean, "workoutUnlocked");
        if (dogLocalEntity.getWorkoutUnlocked() || !boolean.booleanValue()) {
            resetDogStreakInfo = b.f();
        } else {
            resetDogStreakInfo = p1Var.trickKnowledgeDao.resetDogStreakInfo(str, str2);
        }
        return resetDogStreakInfo.B(new app.dogo.com.dogo_android.repository.local.n0(boolean));
    }

    private static final g0 l(p1 p1Var, String str, DogLocalEntity dogLocalEntity) {
        a0 just;
        n.f(p1Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogLocalEntity, "dogLocalEntity");
        if (dogLocalEntity.getWorkoutUnlocked()) {
            just = a0.just(Boolean.valueOf(dogLocalEntity.getWorkoutUnlocked()));
        } else {
            just = p1Var.userEntityDao.insertTrickProgressCompletable(str).map(app.dogo.com.dogo_android.repository.local.u0.a);
        }
        return just;
    }

    /* renamed from: m, reason: from kotlin metadata */
    private static final Boolean fillFromBundle(List bundle) {
        boolean z = true;
        int i2 = 1;
        n.f(bundle, "entities");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = bundle.iterator();
        i2 = 1;
        i2 = 0;
        while (it2.hasNext()) {
            Object item = it2.next();
            int i3 = 4;
        }
        ArrayList arrayList2 = new ArrayList(p.r(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((TrickProgressEntity)it.next().getTrickId());
        }
        if (SessionViewModel.INSTANCE.filterBlacklistedTricks(arrayList2).size() < 3) {
        }
        return Boolean.valueOf(z);
    }

    private static final f p0(p1 p1Var, Throwable th) {
        n.f(p1Var, "this$0");
        n.f(th, "it");
        a.e(th, "App start, remote user data sync failed", new Object[0]);
        return p1Var.r();
    }

    private final void s0(int i, String str, String str2) {
        int i2 = 1;
        int i5 = 9;
        i2 = 1;
        i2 = 0;
        int r2 = i2;
        if (i2 != 0) {
            this.notificationService.logEvent(E_InAppMessaging.c.withParameters(u.a(new EP_FeedbackScore(), Integer.valueOf(i)), u.a(new EP_CampaignId(), str), u.a(new EP_CampaignName(), str2)));
        } else {
            int i4 = 7;
            r2 = i2;
            if (i2 != 0) {
                this.notificationService.logEvent(E_InAppMessaging.b.withParameters(u.a(new EP_FeedbackScore(), Integer.valueOf(i)), u.a(new EP_CampaignId(), str), u.a(new EP_CampaignName(), str2)));
            } else {
                i5 = 9;
                if (9 > i || i > 10) {
                }
                if (this.notificationService != null) {
                    this.notificationService.logEvent(E_InAppMessaging.a.withParameters(u.a(new EP_FeedbackScore(), Integer.valueOf(i)), u.a(new EP_CampaignId(), str), u.a(new EP_CampaignName(), str2)));
                }
            }
        }
    }

    public static /* synthetic */ i.b.b w0(p1 p1Var, UserApiModel userApiModel, String str, int i, Object object) {
        if (i & 2 != 0) {
            i = 0;
        }
        return p1Var.v0(userApiModel, str);
    }

    /* renamed from: y, reason: from kotlin metadata */
    private final String getCurrentLocaleLanguageOrEn(Context context) {
        String language;
        if (context.getResources().getConfiguration().getLocales().get(0).getLanguage() == null) {
            language = "en";
        }
        return language;
    }

    /* renamed from: A, reason: from kotlin metadata */
    /* suspend */ public final DogSelectData doesCacheExists() {
        return new DogSelectData(p.L0(H().m().values()), H().f());
    }

    /* renamed from: B, reason: from kotlin metadata */
    public final a0<List<DogParentUIState.DogParent>> getDogProfile(String dogId) {
        n.f(dogId, "dogId");
        a0 map = this.reminderRepository.getDogParents(dogId).map(app.dogo.com.dogo_android.repository.local.m0.a);
        n.e(map, "apiClient.getDogParents(dogId).map { owners ->\n            owners.parents.values.map { it.toDogParent() }\n        }");
        return map;
    }

    public final a0<UserApiModel> B0() {
        a0 flatMapped = this.reminderRepository.loginUserSingle(new UserLoginRequest(H().i().buildUserDeviceModel())).flatMap(new app.dogo.com.dogo_android.repository.local.v0(this));
        n.e(flatMapped, "apiClient.loginUserSingle(\n            UserLoginRequest(device = tempUserCache.deviceData.buildUserDeviceModel())\n        ).flatMap {\n            updateLocalUserData(it).toSingle { it }\n        }");
        return flatMapped;
    }

    /* renamed from: D, reason: from kotlin metadata */
    public final a0<DogoPremiumStatusEntity> getOwnersInformation(String dogId) {
        n.f(dogId, "dogId");
        return this.application.x(dogId);
    }

    /* renamed from: E, reason: from kotlin metadata */
    public final a0<PublicDogProfile> getPremiumStateForDog(String dogId) {
        n.f(dogId, "dogId");
        return this.application.y(dogId);
    }

    public final boolean F() {
        boolean z2 = false;
        int r0 = this.firestore.Y() && this.G() ? 1 : 0;
        return (this.firestore.Y() && this.G() ? 1 : 0);
    }

    public final boolean G() {
        boolean z2 = true;
        String str;
        long millis;
        long l = 3;
        if (this.preference.h0()) {
            if (!this.userLocalCacheService.o(this.authService.v())) {
                long l3 = this.firestoreService.g() - this.firestore.M();
                l = 3L;
                millis = TimeUnit.DAYS.toMillis(l);
                int r0 = this.preference > millis ? 1 : 0;
            }
        }
        return (this.preference > millis ? 1 : 0);
    }

    public final c H() {
        return this.application.A();
    }

    public final a0<UserReadArticlesResponse> I() {
        return this.reminderRepository.getUserReadArticlesSingle();
    }

    /* renamed from: J, reason: from kotlin metadata */
    public final Object getPublicDogProfile(d<? super UserStateEntity> dogId) {
        return this.remoteConfigService.getUserPottyRemindersWithState(this.authService.v(), dogId);
    }

    /* renamed from: K, reason: from kotlin metadata */
    public final boolean isParticipatingInChallenge(String challengeId) {
        n.f(challengeId, "challengeId");
        return H().o().b().contains(challengeId);
    }

    /* renamed from: L, reason: from kotlin metadata */
    public final boolean isPolicyAccepted(String policy) {
        n.f(policy, "policy");
        return this.application.B(policy);
    }

    /* renamed from: M, reason: from kotlin metadata */
    public final boolean isPolicyShown(String policy) {
        n.f(policy, "policy");
        return this.application.C(policy);
    }

    public final void a(int i, String str, String str2, String str3, InAppFeedbackExtras inAppFeedbackExtras) {
        obj = this;
        str32 = str2;
        str42 = str3;
        n.f(str, "comment");
        n.f(str32, "campaignId");
        n.f(str42, "campaignName");
        obj.s0(i, str32, str42);
        final String str9 = obj.authService.v();
        i2 = !l.z(str9);
        if (!l.z(str9) != 0) {
            long l = 0L;
            String str5 = null;
            inAppFeedbackExtras = null;
            kotlin.d0.d.g gVar = 896;
            int i4 = 0;
            InAppFeedbackModel inAppFeedbackModel = new InAppFeedbackModel(str9, H().f(), str2, str3, i, str, obj.getCurrentLocaleLanguageOrEn(obj.apiClient), l, str11, str5, inAppFeedbackExtras, inAppFeedbackExtras, gVar, i4);
            collection.add(inAppFeedbackModel.toMap());
        }
    }

    public final void b0() {
        this.dogLocalEntityDao.i0();
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final a0<DogProfile> removeParticipatingChallenge(String challengeId) {
        return this.application.b(this.authService.v(), challengeId);
    }

    public final void c0() {
        this.dogLocalEntityDao.l0();
    }

    public final i.b.b d0() {
        i.b.b flatMapCompletable;
        if (!this.application.D(this.authService.v())) {
            str = "{\n            apiClient.getUserApiModelSingle().flatMapCompletable { userApiResponse ->\n                reminderRepository.getTrainingReminderOrEmptyByUserId(authService.currentUserId).flatMapCompletable { localTrainingReminders ->\n                    reminderRepository.getPottyRemindersByUserId(authService.currentUserId).flatMapCompletable { localPottyReminders ->\n                        if (userApiResponse.pottyReminders.isEmpty() && userApiResponse.trainingReminder == null && (!localTrainingReminders.isEmpty() || localPottyReminders.isNotEmpty())) {\n                            val localPottyReminderModelList = localPottyReminders.map {\n                                PottyReminderModel(\n                                    id = it.reminderId,\n                                    startTime = it.startTime,\n                                    endTime = it.endTime ?: \"\",\n                                    intervalMinutes = TimeUnit.MILLISECONDS.toMinutes(it.repeatIntervalMs ?: 0),\n                                    weekdays = it.days.toWeekdays(),\n                                    dogId = it.dogId,\n                                    enabled = it.isActive,\n                                    updateTimeMs = utilities.currentTimeInMillis,\n                                    createTimeMs = utilities.currentTimeInMillis\n                                )\n                            }\n                            val localTrainingReminderModel = if (localTrainingReminders.isEmpty()) {\n                                null\n                            } else {\n                                TrainingReminderModel(\n                                    id = localTrainingReminders.id ?: UUID.randomUUID().toString(),\n                                    time = localTrainingReminders.time ?: \"\",\n                                    weekdays = localTrainingReminders.days.toWeekdays(),\n                                    enabled = localTrainingReminders.isActive,\n                                    updateTimeMs = utilities.currentTimeInMillis,\n                                    createTimeMs = utilities.currentTimeInMillis\n                                )\n                            }\n                            apiClient.migrateRemindersSingle(\n                                ReminderResponse(\n                                    trainingReminder = localTrainingReminderModel,\n                                    pottyReminders = localPottyReminderModelList\n                                )\n                            ).flatMapCompletable {\n                                updateLocalUserData(it)\n                            }\n                        } else {\n                            updateLocalUserData(userApiResponse)\n                        }\n                    }\n                }\n            }\n        }";
            n.e(this.reminderRepository.getUserApiModelSingle().flatMapCompletable(new app.dogo.com.dogo_android.repository.local.k0(this)), str);
        } else {
            str = "{\n            Completable.complete()\n        }";
            n.e(b.f(), str);
        }
        return flatMapCompletable;
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final void saveArticleRead(String articleId) {
        n.f(articleId, "challengeId");
        this.application.g(articleId);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final void updateCurrentDog(DogProfile dogId) {
        n.f(dogId, "dogProfile");
        Object blockingGet = this.trickKnowledgeDao.getWorkoutUnlockSourceOrEmpty(dogId.getId()).blockingGet();
        this.notificationService.setUserProperty(UserProperty.CurrentStreak, Integer.valueOf(blockingGet.getCurrentStreak()));
        this.notificationService.setUserProperty(UserProperty.LongestStreak, Integer.valueOf(Math.max(blockingGet.getLongestStreak(), blockingGet.getCurrentStreak())));
    }

    public final a0<Boolean> g(String str, String str2) {
        n.f(str, "dogId");
        n.f(str2, "source");
        final a0 flatMapped = this.trickKnowledgeDao.getWorkoutUnlockSourceOrEmpty(str).flatMap(new app.dogo.com.dogo_android.repository.local.o0(this, str, str2));
        n.e(flatMapped, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).flatMap { dogLocalEntity ->\n            checkIfUserUnlockedWorkout(dogId).flatMap { workoutUnlocked ->\n                if (!dogLocalEntity.workoutUnlocked && workoutUnlocked) {\n                    dogLocalEntityDao.setWorkoutUnlocked(dogId, source)\n                } else {\n                    Completable.complete()\n                }.toSingle { workoutUnlocked }\n            }\n        }");
        return flatMapped;
    }

    public final void i0() {
        this.l.o(this.authService.v());
    }

    public final i.b.b j0(String str) {
        n.f(str, "articleId");
        i.b.b ignoreElement = this.reminderRepository.saveArticleReadSingle(str, new SaveArticleReadRequest(true)).ignoreElement();
        n.e(ignoreElement, "apiClient.saveArticleReadSingle(articleId, SaveArticleReadRequest(isRead = true)).ignoreElement()");
        return ignoreElement;
    }

    public final a0<Boolean> k(String str) {
        n.f(str, "dogId");
        final a0 flatMapped = this.trickKnowledgeDao.getWorkoutUnlockSourceOrEmpty(str).flatMap(new app.dogo.com.dogo_android.repository.local.p0(this, str));
        n.e(flatMapped, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).flatMap { dogLocalEntity ->\n            if (dogLocalEntity.workoutUnlocked) {\n                Single.just(dogLocalEntity.workoutUnlocked)\n            } else {\n                trickKnowledgeDao.getAllDogTrickKnowledge(dogId).map { entities ->\n                    val knowTrickIds = entities.filter { it.knowledge >= TrickItem.MIN_KNOWLEDGE_REACHED }.map { it.trickId }\n                    val filteredKnowTricks = SessionViewModel.filterBlacklistedTrickIds(knowTrickIds)\n                    val isWorkoutUnlocked = filteredKnowTricks.size >= 3\n                    isWorkoutUnlocked\n                }\n            }\n        }");
        return flatMapped;
    }

    public final void k0() {
        this.firestore.q1(true);
    }

    public final void l0() {
        this.firestore.e();
    }

    public final void m0() {
        this.firestore.q1(false);
    }

    public final a0<CreateDogInviteResponse> n(String str) {
        n.f(str, "dogId");
        return this.reminderRepository.createDogInvite(new CreateDogInviteRequest(str));
    }

    public final Object n0(d<? super kotlin.w> dVar) {
        Object metricsGoalNotReachedState = this.remoteConfigService.updateMetricsGoalNotReachedState(this.authService.v(), true, dVar);
        if (metricsGoalNotReachedState == b.d()) {
            return metricsGoalNotReachedState;
        }
        return w.a;
    }

    public final i.b.b o(String str) {
        n.f(str, "dogId");
        i.b.b bVar2 = this.reminderRepository.deleteDog(str).c(this.application.T(this.authService.v(), str));
        n.e(bVar2, "apiClient.deleteDog(dogId).andThen(\n            userLocalCacheService.removeDog(authService.currentUserId, dogId)\n        )");
        return bVar2;
    }

    public final i.b.b o0() {
        r0();
        i.b.b bVar2 = B0().ignoreElement().t(new app.dogo.com.dogo_android.repository.local.s0(this)).c(a0.just(w.a).ignoreElement());
        n.e(bVar2, "updateUserCacheFromRemote().ignoreElement()\n            .onErrorResumeNext {\n                Timber.e(it, \"App start, remote user data sync failed\")\n                fillCacheFromRoom()\n            }.andThen(\n                Single.just(trackDevice()).ignoreElement()\n            )");
        return bVar2;
    }

    public final i.b.b p(String str, String str2) {
        Object obj;
        n.f(str, "dogId");
        n.f(str2, "ownerId");
        if (n.b(str2, this.authService.v())) {
            i.b.b bVar2 = this.application.T(this.authService.v(), str);
        } else {
            n.e(b.f(), "{\n                Completable.complete()\n            }");
        }
        i.b.b bVar = this.reminderRepository.removeDogParent(str, str2).c(obj);
        n.e(bVar, "apiClient.removeDogParent(dogId, ownerId).andThen(\n            if (ownerId == authService.currentUserId) {\n                userLocalCacheService.removeDog(authService.currentUserId, dogId)\n            } else {\n                Completable.complete()\n            }\n        )");
        return bVar;
    }

    public final a0<Boolean> q() {
        return this.application.j(this.authService.v());
    }

    public final boolean q0() {
        return this.firestore.j0();
    }

    public final i.b.b r() {
        i.b.b bVar;
        try {
            bVar = this.application.m(this.authService.v());
        } catch (Exception e) {
            a.d(e);
            Throwable e2 = b.f();
            n.e(e2, "{\n            Timber.e(e)\n            Completable.complete()\n        }");
        }
        return bVar;
    }

    public final void r0() {
        this.notificationService.setUserProperty(UserProperty.FcmToken, H().i().d());
        this.notificationService.setUserProperty(UserProperty.Locale, LocaleService.supportedLocales.getLocaleString(App.INSTANCE.l().W()));
        String iD = TimeZone.getDefault().getID();
        n.e(iD, "getDefault().id");
        this.notificationService.trackErrorMessage(iD);
    }

    public final boolean s(Bundle bundle) {
        n.f(bundle, "bundle");
        return H().fillFromBundle(bundle);
    }

    public final Bundle t() {
        return H().c();
    }

    public final void t0() {
        H().q();
    }

    public final Object u(d<? super String> dVar) {
        return H().f();
    }

    public final void u0(String str) {
        n.f(str, "dogId");
        this.application.X(this.authService.v(), str);
    }

    public final a0<String> v() {
        a0 just = a0.just(H().f());
        n.e(just, "just(tempUserCache.currentDogId)");
        return just;
    }

    public final i.b.b v0(UserApiModel userApiModel, String str) {
        n.f(userApiModel, "userApiModel");
        return this.application.b0(userApiModel, str);
    }

    public final a0<DogProfile> w() {
        a0 just = a0.just(H().g());
        n.e(just, "just(tempUserCache.currentDogProfile)");
        return just;
    }

    public final LiveData<DogProfile> x() {
        int i = 1;
        int r0 = H().f().length() == 0 ? 1 : 0;
        if (i != 0) {
            r().e();
        }
        return H().h();
    }

    public final Object x0(String str, int i, d<? super kotlin.w> dVar) {
        Object obj = this.remoteConfigService.c(this.authService.v(), str, i, dVar);
        if (obj == b.d()) {
            return obj;
        }
        return w.a;
    }

    public final i.b.b y0(String str, b.c cVar) {
        n.f(str, "policyId");
        n.f(cVar, "policyStatus");
        return this.application.e0(str, cVar);
    }

    public final a0<DogProfile> z(String str) {
        n.f(str, "dogId");
        a0 just = a0.just(H().m().get(str));
        n.e(just, "just(tempUserCache.dogs[dogId])");
        return just;
    }

    public final i.b.b z0() {
        String str;
        app.dogo.com.dogo_android.v.a aVar = H().i();
        str = aVar.b();
        str = "";
        String r7 = str;
        if (aVar.d() == null) {
        }
        UserDeviceUpdateRequest_DeviceUpdate userDeviceUpdateRequest_DeviceUpdate = new UserDeviceUpdateRequest_DeviceUpdate(aVar.f(), str, str2, str, this.tracker.areNotificationsEnabled());
        UserDeviceUpdateRequest userDeviceUpdateRequest = new UserDeviceUpdateRequest(userDeviceUpdateRequest_DeviceUpdate);
        i.b.b flatMapCompletable = this.reminderRepository.updateUserDeviceData(aVar.c(), userDeviceUpdateRequest).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.r0(this));
        n.e(flatMapCompletable, "apiClient.updateUserDeviceData(\n            deviceData.deviceId,\n            UserDeviceUpdateRequest(\n                device = UserDeviceUpdateRequest.DeviceUpdate(\n                    timeZone = deviceData.timezone,\n                    countryCode = deviceData.country ?: \"\",\n                    locale = deviceData.language,\n                    fcmToken = deviceData.fcmToken ?: \"\",\n                    notificationsEnabled = notificationService.areNotificationsEnabled()\n                )\n            )\n        ).flatMapCompletable {\n            updateLocalUserData(it)\n        }");
        return flatMapCompletable;
    }

    /* renamed from: D0, reason: from kotlin metadata */
    private static final UserApiModel addParticipatingChallenge(UserApiModel challengeId) {
        n.f(challengeId, "$it");
        return challengeId;
    }

    /* renamed from: N, reason: from kotlin metadata */
    public static /* synthetic */ f updateLocalUserData(p1 userApiModel, UserApiModel newCurrentDogId) {
        return UserRepository.e0(userApiModel, newCurrentDogId);
    }

    /* renamed from: O, reason: from kotlin metadata */
    public static /* synthetic */ f trackScore(p1 score, UserApiModel campaignId, RemindersModel campaignName) {
        return UserRepository.f0(score, campaignId, campaignName);
    }

    /* renamed from: P, reason: from kotlin metadata */
    public static /* synthetic */ List blockingUpdateUsersDogStreakTrackingProperties(GetDogParentsResponse dogProfile) {
        return UserRepository.addNewDog(dogProfile);
    }

    /* renamed from: Q, reason: from kotlin metadata */
    public static /* synthetic */ Boolean checkIfUserUnlockedWorkout(Boolean dogId) {
        UserRepository.doesDogBelongToUser(dogId);
        return dogId;
    }

    public static /* synthetic */ g0 R(p1 p1Var, String str, String str2, DogLocalEntity dogLocalEntity) {
        return UserRepository.h(p1Var, str, str2, dogLocalEntity);
    }

    public static /* synthetic */ g0 S(p1 p1Var, String str, DogLocalEntity dogLocalEntity) {
        return UserRepository.l(p1Var, str, dogLocalEntity);
    }

    /* renamed from: T, reason: from kotlin metadata */
    /* suspend */ public static /* synthetic */ f updateMetricsGoalNotReachedState(p1 date, UserApiModel durationSec) {
        return UserRepository.h0(date, durationSec);
    }

    /* renamed from: U, reason: from kotlin metadata */
    public static /* synthetic */ f updatePolicy(p1 policyId, UserApiModel policyStatus) {
        return UserRepository.checkAndUpdateIfUserUnlockedWorkout(policyId, policyStatus);
    }

    public static /* synthetic */ f V(p1 p1Var, Throwable th) {
        return UserRepository.p0(p1Var, th);
    }

    public static /* synthetic */ f W(UserApiModel userApiModel, RemindersModel remindersModel, p1 p1Var, List list) {
        return UserRepository.g0(userApiModel, remindersModel, p1Var, list);
    }

    /* renamed from: X, reason: from kotlin metadata */
    public static /* synthetic */ Boolean createDogInviteId(List dogId) {
        return UserRepository.fillFromBundle(dogId);
    }

    public static /* synthetic */ g0 Y(p1 p1Var, UserApiModel userApiModel) {
        return UserRepository.deleteDogParent(p1Var, userApiModel);
    }

    /* renamed from: Z, reason: from kotlin metadata */
    public static /* synthetic */ UserApiModel deleteDog(UserApiModel dogId) {
        UserRepository.addParticipatingChallenge(dogId);
        return dogId;
    }

    /* renamed from: a0, reason: from kotlin metadata */
    public static /* synthetic */ g0 addFeedback(DogLocalEntity score, p1 comment, String campaignId, String campaignName, Boolean extras) {
        return UserRepository.i(score, comment, campaignId, campaignName, extras);
    }

    /* renamed from: j, reason: from kotlin metadata */
    private static final Boolean doesDogBelongToUser(Boolean dogId) {
        n.f(dogId, "$workoutUnlocked");
        return dogId;
    }
}
