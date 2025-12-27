package app.dogo.com.dogo_android.view.dailytraining;

import android.os.Bundle;
import androidx.fragment.app.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.d;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo.Companion;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.s.b.z0;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.l1;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.externalmodel.model.responses.UserApiModel;
import com.google.android.play.core.review.ReviewInfo;
import com.iterable.iterableapi.f0;
import i.b.b;
import i.b.f;
import i.b.g0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.t;
import kotlin.u;
import kotlin.w;

/* compiled from: SessionViewModel.kt */
@Metadata(d1 = "\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0008\u0010D\u001a\u00020EH\u0002J\u0008\u0010F\u001a\u00020EH\u0002J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020-J\u0016\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u000202J*\u0010O\u001a\u00020H2\u000e\u0008\u0002\u0010P\u001a\u0008\u0012\u0004\u0012\u00020-0Q2\u0008\u0008\u0002\u0010R\u001a\u00020 2\u0008\u0008\u0002\u0010S\u001a\u00020 J\u000e\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u000202J\u0006\u0010V\u001a\u00020HJ\u0012\u0010W\u001a\u00020H2\u0008\u0010'\u001a\u0004\u0018\u00010)H\u0002J\u0006\u0010X\u001a\u000202J,\u0010Y\u001a\u00020Z2\u0006\u0010J\u001a\u00020-2\u0006\u0010[\u001a\u00020-2\u0008\u0008\u0002\u0010\\\u001a\u00020 2\n\u0008\u0002\u0010]\u001a\u0004\u0018\u00010^J\u0008\u0010_\u001a\u0004\u0018\u00010)J\u0006\u0010`\u001a\u00020-J\u0006\u0010a\u001a\u00020 J\u0008\u0010b\u001a\u00020 H\u0002J\u0006\u0010c\u001a\u00020 J\u0008\u0010d\u001a\u00020 H\u0002J\u0006\u0010e\u001a\u00020 J\u0006\u0010f\u001a\u00020 J\u001e\u0010g\u001a\u00020H2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010J\u001a\u00020-J\u0006\u0010l\u001a\u00020 J\u001a\u0010m\u001a\u00020H2\u0008\u0008\u0002\u0010R\u001a\u00020 2\u0008\u0008\u0002\u0010S\u001a\u00020 J,\u0010m\u001a\u00020H2\u000e\u0008\u0002\u0010P\u001a\u0008\u0012\u0004\u0012\u00020-0Q2\u0008\u0008\u0002\u0010R\u001a\u00020 2\u0008\u0008\u0002\u0010S\u001a\u00020 H\u0002J\u000e\u0010n\u001a\u00020H2\u0006\u0010o\u001a\u00020\u001cJ\u001e\u0010p\u001a\u00020H2\u0006\u0010q\u001a\u00020 2\u0006\u0010I\u001a\u00020-2\u0006\u0010r\u001a\u00020 J\u0018\u0010s\u001a\u00020E2\u0006\u0010q\u001a\u00020 2\u0006\u0010I\u001a\u00020-H\u0002J\u0006\u0010t\u001a\u00020HJ\u0006\u0010u\u001a\u00020HJ\u0006\u0010v\u001a\u00020HJ\u0008\u0010w\u001a\u00020HH\u0002J\u0006\u0010x\u001a\u00020HJ\u0006\u0010y\u001a\u00020 J\u0006\u0010z\u001a\u00020 J \u0010{\u001a\u00020H2\u0006\u0010'\u001a\u00020)2\u0006\u0010|\u001a\u00020-2\u0006\u0010}\u001a\u00020AH\u0002J\u0006\u0010~\u001a\u00020HJ\u0019\u0010\u007f\u001a\u0008\u0012\u0004\u0012\u00020)0\u001b2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010)H\u0002R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020 0\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020 0\u001b0$¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u001d\u0010'\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u001b0(¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u0008\u0012\u0004\u0012\u00020-0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0008\u0012\u0004\u0012\u0002020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\u0008\u0012\u0004\u0012\u00020 0$¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010&R\u0017\u00105\u001a\u0008\u0012\u0004\u0012\u00020-06¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0017\u00109\u001a\u0008\u0012\u0004\u0012\u00020:0$¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010&R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b06¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u00108R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u001e06¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u00108R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010@\u001a\u0010\u0012\u000c\u0012\n B*\u0004\u0018\u00010A0A0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001", d2 = {"Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "inAppRateRepository", "Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "breedRepository", "Lapp/dogo/com/dogo_android/repository/local/BreedRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "iterableApi", "Lcom/iterable/iterableapi/IterableApi;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/local/BreedRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lcom/iterable/iterableapi/IterableApi;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "_trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "backendSyncResults", "", "getBackendSyncResults", "()Landroidx/lifecycle/MutableLiveData;", "dogDeleteSpinner", "Lcom/hadilq/liveevent/LiveEvent;", "getDogDeleteSpinner", "()Lcom/hadilq/liveevent/LiveEvent;", "dogProfile", "Landroidx/lifecycle/MediatorLiveData;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getDogProfile", "()Landroidx/lifecycle/MediatorLiveData;", "errorEvent", "", "isDogProfileSetup", "lastClickMs", "", "messageEmitter", "Landroid/os/Bundle;", "onDogDelete", "getOnDogDelete", "onError", "Landroidx/lifecycle/LiveData;", "getOnError", "()Landroidx/lifecycle/LiveData;", "onZendeskOpen", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getOnZendeskOpen", "result", "getResult", "trick", "getTrick", "unreadMessagesCount", "", "kotlin.jvm.PlatformType", "getUnreadMessagesCount", "backedSyncFix", "Lio/reactivex/Completable;", "cacheSyncFix", "changeCurrentProfile", "", "dogId", "source", "emitMessage", "messageActionHideElement", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "message", "fetchDataAndOpenZendeskScreen", "customTags", "", "hasRequestHistory", "hasUnreadMessages", "fillCacheFromBundle", "bundle", "fixUserData", "gatherDataAndTrackCurrentDogUserProperties", "getCacheBundle", "getSubscriptionAppScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "fragmentReturnTag", "initiatedByDogParentFlow", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "getSuccessDogData", "getUserId", "hasUserUnlockedFirstExam", "isClickTimeoutOver", "isContactUsBadgeEnabled", "isExamsEnabled", "isProgramTutorialFinished", "isTrainingMetricStreakScreenShownToday", "launchReviewFlow", "activity", "Landroidx/fragment/app/FragmentActivity;", "info", "Lcom/google/android/play/core/review/ReviewInfo;", "mobileInboxVisible", "openZendeskScreen", "presetSuccessResult", "session", "removeDog", "isCreator", "isLastDog", "removeDogFromUser", "resetSuccessResult", "setFirstExamUnlockedScreenShowed", "setProgramTutorialAsFinished", "setupDogProfileLiveData", "setupOrFixDogProfileLiveData", "shouldShowExamUnlockedScreen", "shouldShowFirstExamUnlockedScreen", "trackCurrentDogUserProperties", "breedName", "ratedTrickCount", "updateUnreadInboxMessagesCount", "wrapDogProfileWithLoadResults", "dog", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class SessionViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final l.a INSTANCE = new l$a(0);
    private static final List<String> x;
    private static final List<String> y;
    /* renamed from: a, reason: from kotlin metadata */
    private final p1 authService;
    private final r2 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 breedRepository;
    private final p2 d;
    private final app.dogo.com.dogo_android.a0.c e;
    /* renamed from: f, reason: from kotlin metadata */
    private final d3 errorEvent;
    /* renamed from: g, reason: from kotlin metadata */
    private final h2 inAppRateRepository;
    /* renamed from: h, reason: from kotlin metadata */
    private final z0 isDogPremiumInteractor;
    /* renamed from: i, reason: from kotlin metadata */
    private final v2 isDogProfileSetup;
    /* renamed from: j, reason: from kotlin metadata */
    private final com.iterable.iterableapi.j iterableApi;
    /* renamed from: k, reason: from kotlin metadata */
    private final o1 lastClickMs;
    /* renamed from: l, reason: from kotlin metadata */
    private final f.d.a.a<y<Boolean>> messageEmitter = new a<>();
    private final f.d.a.a<Boolean> m = new a<>();
    private final x<y<Boolean>> n = new x<>();
    private final f.d.a.a<ZendeskConfigurationInfo> o = new a<>();
    /* renamed from: p, reason: from kotlin metadata */
    private final v<y<DogProfile>> preferenceService = new v<>();
    /* renamed from: q, reason: from kotlin metadata */
    private boolean remoteConfigService;
    private final x<Integer> r = new x<>();
    /* renamed from: s, reason: from kotlin metadata */
    private long tracker;
    private final x<y<TrainingSession>> t = new x<>();
    /* renamed from: u, reason: from kotlin metadata */
    private final LiveData<y<TrainingSession>> tricksRepository = new x<>();
    private final x<TrickItem> v = new x<>();
    /* renamed from: w, reason: from kotlin metadata */
    private final f.d.a.a<String> userRepository = new a<>();

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004J(\u0010\u000c\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004H\u0002J\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004J\u001c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0004H\u0002J:\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0004H\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel$Companion;", "", "()V", "level2BlackList", "", "", "tricksIdBlackList", "createTrainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "allTricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "lessonTricks", "fillTrainingSession", "filterBlacklistedTrickIds", "knownTrickIds", "filterBlacklistedTricks", "knownTricks", "modifyTrainingList", "unknownTricks", "default", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: b, reason: from kotlin metadata */
        private final TrainingSession createTrainingSession(List<TrickItem> allTricks, List<TrickItem> lessonTricks) {
            List list;
            int i = 1;
            if (allTricks.isEmpty()) {
                TrainingSession allTricks2 = new TrainingSession(null, null, false, false, 15, null);
                return allTricks2;
            }
            list = p.g();
            ArrayList arrayList = new ArrayList();
            Iterator it = allTricks.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            List list2 = p.p0(allTricks, arrayList);
            i = 1;
            if (list2.isEmpty() ^ i) {
                list = p.b(p.X(list2));
            }
            int size = filterBlacklistedTrickIds(arrayList).size();
            if (size < 0 || size > i) {
                i = 0;
            }
            if (i != 0 && lessonTricks == null) {
                TrainingSession allTricks4 = new TrainingSession(null, null, false, false, 15, null);
                return allTricks4;
            }
            TrainingSession allTricks3 = new TrainingSession(modifyTrainingList(lessonTricks, list2, list), null, false, false, 14, null);
            return allTricks3;
        }

        /* renamed from: d, reason: from kotlin metadata */
        private final List<TrickItem> filterBlacklistedTrickIds(List<TrickItem> knownTrickIds) {
            ArrayList arrayList = new ArrayList(p.r(knownTrickIds, 10));
            Iterator it = knownTrickIds.iterator();
            while (it.hasNext()) {
                arrayList.add((TrickItem)it.next().getId());
            }
            ArrayList arrayList2 = new ArrayList();
            final Iterator it2 = knownTrickIds.iterator();
            while (it2.hasNext()) {
                Object item = it2.next();
            }
            return arrayList2;
        }

        /* renamed from: e, reason: from kotlin metadata */
        private final List<TrickItem> modifyTrainingList(List<TrickItem> lessonTricks, List<TrickItem> unknownTricks, List<TrickItem> default_) {
            boolean ratedByUser;
            boolean hasNext2;
            if (lessonTricks != null) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = unknownTricks.iterator();
                while (it2.hasNext()) {
                    Object item = it2.next();
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    Object item2 = it3.next();
                    ArrayList arrayList = new ArrayList(p.r(lessonTricks, 10));
                    Iterator it = lessonTricks.iterator();
                    while (it.hasNext()) {
                        arrayList.add((TrickItem)it.next().getId());
                    }
                    arrayList.add((TrickItem)it.next().getId());
                }
                return p.U(p.F0(p.u0(lessonTricks, (TrickItem)p.l0(arrayList2)), 3));
            }
            return default_;
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final TrainingSession fillTrainingSession(List<TrickItem> allTricks, List<TrickItem> lessonTricks) {
            n.f(allTricks, "allTricks");
            return createTrainingSession(allTricks, lessonTricks);
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final List<String> filterBlacklistedTricks(List<String> knownTricks) {
            boolean contains;
            List list;
            boolean contains2;
            String str;
            boolean z;
            int i;
            Object obj;
            n.f(knownTricks, "knownTrickIds");
            ArrayList arrayList = new ArrayList();
            Iterator it2 = knownTricks.iterator();
            while (it2.hasNext()) {
                Object item = it2.next();
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object item2 = it.next();
            }
            return arrayList2;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.d(th);
            l.this.getOnZendeskOpen().postValue(ZendeskConfigurationInfo.Companion.createEmpty(l.this.inAppRateRepository.v()));
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.l<ZendeskConfigurationInfo, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(ZendeskConfigurationInfo zendeskConfigurationInfo) {
            l.this.getOnZendeskOpen().postValue(zendeskConfigurationInfo);
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.d(th);
            l.this.B().setValue(new LoadResult_Error(th));
        }

        d() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            l.this.j0();
            l.this.B().setValue(new LoadResult_Success(Boolean.TRUE));
        }

        e() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {

        public static final l.f a = new l$f();
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.d(new RuntimeException("Failed to track current dog user properties", th));
        }


        f() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006 \u0007*\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lkotlin/Triple;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.l<t<? extends DogProfile, ? extends String, ? extends Integer>, w> {
        @Override // kotlin.d0.d.p
        public final void a(t<DogProfile, String, Integer> tVar) {
            l.this.removeDog((DogProfile)tVar.a(), (String)tVar.b(), (Number)tVar.c().intValue());
        }

        g() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            l.this.D().postValue(new LoadResult_Error(th));
        }

        h() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ boolean $isLastDog;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            l.this.D().postValue(new LoadResult_Success(Boolean.TRUE));
            l.this.F().postValue(Boolean.valueOf(this.$isLastDog));
        }

        i(boolean z) {
            this.$isLastDog = z;
            super(0);
        }
    }
    static {
        SessionViewModel.x = p.j(new String[] { "id_bite_01", "id_biting_program_01", "id_clicker", "id_collar_01", "id_come_06", "id_crate_01", "id_crate_02", "id_crate_03", "id_crate_04", "id_crate_program_02", "id_crate_program_03", "id_down_04", "id_gotcha_program_01", "id_guarding_program_01", "id_guarding_program_02", "id_handling_01", "id_handling_02", "id_handling_03", "id_handling_04", "id_leaveit_02", "id_loose_leash_01", "id_loose_leash_02", "id_meet_greet_01", "id_moving_obejcts_01", "id_muzzle_01", "id_name_circle_01", "id_potty_01", "id_potty_1", "id_prevent_jumping_program_01", "id_resource_01", "id_settle_down_01", "id_sit_and_stay_03", "id_sit_and_stay_04", "id_speedy_obedience_01", "id_talk_me_01", "id_talk_me_02", "id_tug_01", "id_unwrap_01", "id_walkingonaleash_01", "id_walkingonaleash_02", "id_which_hand_01" });
        SessionViewModel.y = p.j(new String[] { "id_name_01", "id_sit_01", "id_down_01", "id_come_01", "id_place_01", "id_give_back_01" });
    }

    public l(p1 p1Var, r2 r2Var, o3 o3Var, p2 p2Var, app.dogo.com.dogo_android.a0.c cVar, d3 d3Var, h2 h2Var, z0 z0Var, v2 v2Var, com.iterable.iterableapi.j jVar, o1 o1Var) {
        n.f(p1Var, "userRepository");
        n.f(r2Var, "remoteConfigService");
        n.f(o3Var, "tracker");
        n.f(p2Var, "preferenceService");
        n.f(cVar, "inAppRateRepository");
        n.f(d3Var, "isDogPremiumInteractor");
        n.f(h2Var, "authService");
        n.f(z0Var, "breedRepository");
        n.f(v2Var, "utilities");
        n.f(jVar, "iterableApi");
        n.f(o1Var, "tricksRepository");
        super();
        this.authService = p1Var;
        this.b = r2Var;
        this.breedRepository = o3Var;
        this.d = p2Var;
        this.e = cVar;
        this.errorEvent = d3Var;
        this.inAppRateRepository = h2Var;
        this.isDogPremiumInteractor = z0Var;
        this.isDogProfileSetup = v2Var;
        this.iterableApi = jVar;
        this.lastClickMs = o1Var;
        f.d.a.a aVar2 = new a();
        f.d.a.a aVar3 = new a();
        x xVar5 = new x();
        f.d.a.a aVar4 = new a();
        v vVar = new v();
        i = !l.z(h2Var.v());
        if (!l.z(h2Var.v()) != 0) {
            p1Var.b0();
            p1Var.c0();
            p1Var.i0();
        } else {
            str = "Login in auth object has not finished initializing";
            o3Var.logEvent(E_General.j.d(u.a(new EP_ErrorMessage(), str)));
            a.d(new Exception(str));
        }
        x xVar = new x();
        x xVar2 = new x(null);
        x xVar3 = new x();
        x xVar4 = new x();
        f.d.a.a aVar = new a();
    }

    /* renamed from: A, reason: from kotlin metadata */
    private static final t fetchDataAndOpenZendeskScreen(DogProfile customTags, Map hasRequestHistory, DogBreed hasUnreadMessages) {
        n.f(hasRequestHistory, "$evaluatedTrick");
        n.f(hasUnreadMessages, "dogBreed");
        return new Triple(customTags, hasUnreadMessages.getName(), Integer.valueOf(hasRequestHistory.size()));
    }

    public static /* synthetic */ app.dogo.com.dogo_android.y.j H(l lVar, String str, String str2, boolean z, ProfilePreview profilePreview, int i, Object object) {
        if (i & 4 != 0) {
            i = 0;
        }
        if (i & 8 != 0) {
            int i2 = 0;
        }
        return lVar.G(str, str2, z, profilePreview);
    }

    /* renamed from: M, reason: from kotlin metadata */
    private final boolean backedSyncFix() {
        boolean z = true;
        long l2 = this.isDogProfileSetup.g() - this.tracker;
        if (this.isDogProfileSetup > 500) {
            this.tracker = this.isDogProfileSetup.g();
            int i = 1;
        } else {
            int i2 = 0;
        }
        return z;
    }

    private final boolean O() {
        return this.b.c0();
    }

    public static /* synthetic */ void c0(l lVar, boolean z, boolean z2, int i, Object object) {
        boolean z4;
        i = 0;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        lVar.openZendeskScreen(z, z4);
    }

    private final b f0(boolean z, String str) {
        b bVar;
        if (z) {
            bVar = this.authService.o(str);
        } else {
            bVar = this.authService.p(str, this.inAppRateRepository.v());
        }
        return bVar;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ h2 gatherDataAndTrackCurrentDogUserProperties(l dogProfile) {
        return dogProfile.inAppRateRepository;
    }

    public static final /* synthetic */ List i() {
        return SessionViewModel.y;
    }

    public static final /* synthetic */ List j() {
        return SessionViewModel.x;
    }

    private final void j0() {
        if (this.remoteConfigService == null) {
            this.remoteConfigService = true;
            this.preferenceService.b(this.authService.x(), new b(this));
        }
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final /* synthetic */ void presetSuccessResult(l session) {
        session.j0();
    }

    private static final void k0(l lVar, DogProfile dogProfile) {
        str = "this$0";
        n.f(lVar, str);
        if (dogProfile != null) {
            lVar.y(dogProfile);
            lVar.authService.f(dogProfile);
            lVar.E().postValue(lVar.q0(dogProfile));
        }
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static final /* synthetic */ void getSubscriptionAppScreen(l source, DogProfile fragmentReturnTag, String initiatedByDogParentFlow, int profilePreview) {
        source.removeDog(fragmentReturnTag, initiatedByDogParentFlow, profilePreview);
    }

    private final b m() {
        a.f("Backend sync fix called", new Object[0]);
        b flatMapCompletable = this.authService.B0().flatMapCompletable(new j(this));
        n.e(flatMapCompletable, "userRepository.updateUserCacheFromRemote().flatMapCompletable {\n            if (userRepository.tempUserCache.getDogCount() == 0) {\n                Timber.i(\"Add new dog fix called\")\n                userRepository.addNewDog().map { dogProfile ->\n                    Timber.i(\"New dog added successfully\")\n                    dogProfile\n                }.ignoreElement()\n            } else {\n                Completable.complete()\n            }\n        }");
        return flatMapCompletable;
    }

    private static final f n(l lVar, UserApiModel userApiModel) {
        b ignoreElement;
        n.f(lVar, "this$0");
        str = "it";
        n.f(userApiModel, str);
        if (lVar.authService.H().j() == 0) {
            a.f("Add new dog fix called", new Object[0]);
            String str = null;
            ignoreElement = UserRepository.d(lVar.authService, str, 1, str).map(e.a).ignoreElement();
        } else {
            ignoreElement = b.f();
        }
        return ignoreElement;
    }

    /* renamed from: o, reason: from kotlin metadata */
    private static final DogProfile wrapDogProfileWithLoadResults(DogProfile dog) {
        n.f(dog, "dogProfile");
        a.f("New dog added successfully", new Object[0]);
        return dog;
    }

    /* renamed from: o0, reason: from kotlin metadata */
    private final void removeDog(DogProfile isCreator, String dogId, int isLastDog) {
        String str;
        this.breedRepository.setUserProperty(UserProperty.CurrentDogName, isCreator.getName());
        this.breedRepository.setUserProperty(UserProperty.CurrentDogBreedId, isCreator.getBreedId());
        if (!l.z(dogId) == 0) {
            str = "";
        }
        this.breedRepository.setUserProperty(UserProperty.CurrentDogBreed, str);
        this.breedRepository.setUserProperty(UserProperty.CurrentDogProfileUrl, isCreator.getAvatar());
        this.breedRepository.setUserProperty(UserProperty.CurrentDogGender, isCreator.getGender().getTrackTag());
        this.breedRepository.onAttributionFailure(isCreator);
        this.breedRepository.setUserProperty(UserProperty.TricksRated, Integer.valueOf(isLastDog));
    }

    private final void openZendeskScreen(List<String> list, boolean z, boolean z2) {
        if (backedSyncFix()) {
            fetchDataAndOpenZendeskScreen(list, z, z2);
        }
    }

    private final b p() {
        a.f("Cache fix called", new Object[0]);
        b flatMapCompletable = this.authService.r().B(d.a).flatMapCompletable(new c(this));
        n.e(flatMapCompletable, "userRepository.fillCacheFromRoom().toSingle { true }.flatMapCompletable {\n            if (userRepository.tempUserCache.getDogCount() == 0) {\n                backedSyncFix()\n            } else {\n                Completable.complete()\n            }\n        }");
        return flatMapCompletable;
    }

    private static final Boolean q() {
        return Boolean.TRUE;
    }

    private final y<DogProfile> q0(DogProfile dogProfile) {
        y.c loadResult_Success;
        if (dogProfile != null) {
            loadResult_Success = new LoadResult_Success(dogProfile);
        } else {
            str = "No dog";
            y.a loadResult_Error = new LoadResult_Error(new Exception(str));
        }
        return loadResult_Success;
    }

    private static final f r(l lVar, Boolean boolean) {
        b bVar;
        n.f(lVar, "this$0");
        n.f(boolean, "it");
        if (lVar.authService.H().j() == 0) {
            bVar = lVar.m();
        } else {
            bVar = b.f();
        }
        return bVar;
    }

    public static /* synthetic */ void t(l lVar, List list, boolean z, boolean z2, int i, Object object) {
        if (i & 1 != 0) {
            list = p.g();
        }
        i = 0;
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        lVar.fetchDataAndOpenZendeskScreen(list, z, z2);
    }

    private static final ZendeskConfigurationInfo u(l lVar, List list, boolean z, boolean z2, DogProfile dogProfile, Boolean boolean) {
        n.f(lVar, "this$0");
        n.f(list, "$customTags");
        n.f(dogProfile, "dogProfile");
        n.f(boolean, "isPremium");
        ZendeskConfigurationInfo lVar2 = new ZendeskConfigurationInfo(lVar.inAppRateRepository.v(), boolean, dogProfile, list, lVar.b.U(lVar.d.W()), lVar.inAppRateRepository.D(), z, z2);
        return lVar2;
    }

    private static final f x(l lVar, Boolean boolean) {
        b bVar;
        n.f(lVar, "this$0");
        n.f(boolean, "cacheExists");
        if (boolean.booleanValue()) {
            bVar = lVar.p();
        } else {
            bVar = lVar.m();
        }
        return bVar;
    }

    private final void y(DogProfile dogProfile) {
        if (dogProfile != null) {
            i.b.a0 observable2 = this.lastClickMs.f(dogProfile.getId()).flatMap(new g(this, dogProfile)).subscribeOn(a.b()).observeOn(a.b());
            n.e(observable2, "tricksRepository.getAllTrickKnowledge(dogProfile.id).flatMap { evaluatedTrick ->\n                    breedRepository.getBreed(dogProfile.breedId ?: dogProfile.name).map { dogBreed ->\n                        Triple(dogProfile, dogBreed.name, evaluatedTrick.size)\n                    }\n                }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, l.f.a, new l.g(this)));
        }
    }

    /* renamed from: z, reason: from kotlin metadata */
    private static final g0 trackCurrentDogUserProperties(l dogProfile, DogProfile breedName, Map ratedTrickCount) {
        String breedId;
        n.f(dogProfile, "this$0");
        n.f(ratedTrickCount, "evaluatedTrick");
        if (breedName.getBreedId() == null) {
            breedId = breedName.getName();
        }
        return dogProfile.isDogPremiumInteractor.d(breedId).map(new h(breedName, ratedTrickCount));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> B() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Bundle C() {
        return this.authService.t();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<Boolean>> D() {
        return this.messageEmitter;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final v<y<DogProfile>> E() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> F() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final app.dogo.com.dogo_android.y.j G(String str, String str2, boolean z, ProfilePreview profilePreview) {
        n.f(str, "source");
        n.f(str2, "fragmentReturnTag");
        return app.dogo.com.dogo_android.util.extensionfunction.l1.b(this.b, str, str2, z, profilePreview, null, 16, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogProfile I() {
        Object value;
        LoadResult_Success r0 = this.preferenceService.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.preferenceService.getValue() : 0;
        if (this.preferenceService != null) {
        }
        return value;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> J() {
        return this.r;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String K() {
        return this.inAppRateRepository.v();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean L() {
        int i = 0;
        boolean z2 = true;
        LoadResult_Success r0 = this.tricksRepository.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.tricksRepository.getValue() : 0;
        int r1 = 0;
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean N() {
        boolean z2 = false;
        if (this.b.Q()) {
            int r0 = !this.d.h0() ? 1 : 0;
        }
        return (!this.d.h0() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean P() {
        return this.d.k0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean Q() {
        return n.b(this.d.L(), new SimpleDateFormat("yyyy-MM-dd", LocaleService.b(this.d.W())).format(this.isDogProfileSetup.f().getTime()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void a0(e eVar, ReviewInfo reviewInfo, String str) {
        n.f(eVar, "activity");
        n.f(reviewInfo, "info");
        n.f(str, "source");
        this.e.d(eVar, reviewInfo, str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean b0() {
        return this.b.Y();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void d0(TrainingSession trainingSession) {
        n.f(trainingSession, "session");
        this.t.setValue(new LoadResult_Success(trainingSession));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void e0(boolean z, String str, boolean z2) {
        n.f(str, "dogId");
        this.messageEmitter.postValue(LoadResult_Loading.a);
        b bVar4 = f0(z, str).y(a.b()).q(a.a());
        n.e(bVar4, "removeDogFromUser(isCreator, dogId)\n                .subscribeOn(Schedulers.io())\n                .observeOn(AndroidSchedulers.mainThread())");
        getDisposable().b(a.d(bVar4, new l.h(this), new l.i(this, z2)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void fetchDataAndOpenZendeskScreen(List<String> list, boolean z, boolean z2) {
        n.f(list, "customTags");
        String str2 = null;
        i.b.a0 observable2 = a0.zip(this.authService.w(), IsDogPremiumInteractor.b(this.errorEvent, str2, 1, str2), new i(this, list, z, z2)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "zip(\n                    userRepository.getCurrentDogProfile(),\n                    isDogPremiumInteractor.isCurrentDogPremium(),\n                    { dogProfile, isPremium ->\n                        ZendeskConfigurationInfo(\n                            userId = authService.currentUserId,\n                            dogProfile = dogProfile,\n                            isDogPremium = isPremium,\n                            customTags = customTags,\n                            isUserLoggedIn = authService.isUserSignedIn,\n                            hasUnreadMessages = hasUnreadMessages,\n                            hasRequestHistory = hasRequestHistory,\n                            isHelpCenterEnabled = remoteConfigService.isHelpCenterEnabled(preferenceService.selectedLocale)\n                        )\n                    }\n                )\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new l.b(this), new l.c(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void g0() {
        TrainingSession trainingSession = new TrainingSession(null, null, false, false, 15, null);
        this.t.setValue(new LoadResult_Success(trainingSession));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<ZendeskConfigurationInfo> getOnZendeskOpen() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<TrainingSession>> getResult() {
        return this.tricksRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h0() {
        this.d.L0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i0() {
        this.d.l1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l0() {
        if (this.authService.H().j() == 0) {
            w();
        } else {
            j0();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m0() {
        Object value;
        boolean z2 = true;
        int i = 0;
        i = 0;
        LoadResult_Success r0 = this.tricksRepository.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.tricksRepository.getValue() : 0;
        if (this.tricksRepository != null) {
        }
        i = 1;
        i = 0;
        int r3 = i;
        if (i != 0 && this.O()) {
            int r2 = i;
            if (i == 0) {
            }
        }
        return z2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean n0() {
        return !this.d.v();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p0() {
        this.r.postValue(Integer.valueOf(this.iterableApi.q().o()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(String str, String str2) {
        n.f(str, "dogId");
        n.f(str2, "source");
        this.authService.u0(str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(Bundle bundle) {
        n.f(bundle, "bundle");
        if (this.authService.s(bundle)) {
            j0();
        } else {
            if (this.authService.H().j() == 0) {
                w();
            } else {
                j0();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        b bVar2 = this.authService.q().flatMapCompletable(new f(this)).y(a.b()).q(a.a());
        n.e(bVar2, "userRepository.doesCacheExists().flatMapCompletable { cacheExists ->\n                if (cacheExists) {\n                    cacheSyncFix()\n                } else {\n                    backedSyncFix()\n                }\n            }\n                .subscribeOn(Schedulers.io())\n                .observeOn(AndroidSchedulers.mainThread())");
        getDisposable().b(a.d(bVar2, new l.d(this), new l.e(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void openZendeskScreen(boolean z, boolean z2) {
        this.d.V0();
        openZendeskScreen(p.g(), z, z2);
    }

    /* renamed from: R, reason: from kotlin metadata */
    public static /* synthetic */ void changeCurrentProfile(l dogId, DogProfile source) {
        SessionViewModel.k0(dogId, source);
    }

    /* renamed from: S, reason: from kotlin metadata */
    public static /* synthetic */ f emitMessage(l messageActionHideElement, Boolean message) {
        return SessionViewModel.r(messageActionHideElement, message);
    }

    public static /* synthetic */ Boolean T() {
        return SessionViewModel.q();
    }

    /* renamed from: U, reason: from kotlin metadata */
    public static /* synthetic */ DogProfile fillCacheFromBundle(DogProfile bundle) {
        SessionViewModel.wrapDogProfileWithLoadResults(bundle);
        return bundle;
    }

    /* renamed from: V, reason: from kotlin metadata */
    public static /* synthetic */ f openZendeskScreen(l hasRequestHistory, Boolean hasUnreadMessages) {
        return SessionViewModel.x(hasRequestHistory, hasUnreadMessages);
    }

    /* renamed from: W, reason: from kotlin metadata */
    public static /* synthetic */ g0 launchReviewFlow(l activity, DogProfile info, Map source) {
        return SessionViewModel.trackCurrentDogUserProperties(activity, info, source);
    }

    /* renamed from: X, reason: from kotlin metadata */
    public static /* synthetic */ t openZendeskScreen(DogProfile customTags, Map hasRequestHistory, DogBreed hasUnreadMessages) {
        return SessionViewModel.fetchDataAndOpenZendeskScreen(customTags, hasRequestHistory, hasUnreadMessages);
    }

    public static /* synthetic */ ZendeskConfigurationInfo Y(l lVar, List list, boolean z, boolean z2, DogProfile dogProfile, Boolean boolean) {
        return SessionViewModel.u(lVar, list, z, z2, dogProfile, boolean);
    }

    /* renamed from: Z, reason: from kotlin metadata */
    public static /* synthetic */ f removeDogFromUser(l isCreator, UserApiModel dogId) {
        return SessionViewModel.n(isCreator, dogId);
    }
}
