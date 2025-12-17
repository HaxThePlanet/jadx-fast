package app.dogo.com.dogo_android.view.dailytraining;

import android.os.Bundle;
import androidx.fragment.app.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.a0.c;
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
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.y.j;
import app.dogo.externalmodel.model.responses.UserApiModel;
import com.google.android.play.core.review.ReviewInfo;
import com.iterable.iterableapi.f0;
import com.iterable.iterableapi.j;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.f;
import i.b.g0;
import i.b.i0.b.a;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.t;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0008\u0010D\u001a\u00020EH\u0002J\u0008\u0010F\u001a\u00020EH\u0002J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020-J\u0016\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u000202J*\u0010O\u001a\u00020H2\u000e\u0008\u0002\u0010P\u001a\u0008\u0012\u0004\u0012\u00020-0Q2\u0008\u0008\u0002\u0010R\u001a\u00020 2\u0008\u0008\u0002\u0010S\u001a\u00020 J\u000e\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u000202J\u0006\u0010V\u001a\u00020HJ\u0012\u0010W\u001a\u00020H2\u0008\u0010'\u001a\u0004\u0018\u00010)H\u0002J\u0006\u0010X\u001a\u000202J,\u0010Y\u001a\u00020Z2\u0006\u0010J\u001a\u00020-2\u0006\u0010[\u001a\u00020-2\u0008\u0008\u0002\u0010\\\u001a\u00020 2\n\u0008\u0002\u0010]\u001a\u0004\u0018\u00010^J\u0008\u0010_\u001a\u0004\u0018\u00010)J\u0006\u0010`\u001a\u00020-J\u0006\u0010a\u001a\u00020 J\u0008\u0010b\u001a\u00020 H\u0002J\u0006\u0010c\u001a\u00020 J\u0008\u0010d\u001a\u00020 H\u0002J\u0006\u0010e\u001a\u00020 J\u0006\u0010f\u001a\u00020 J\u001e\u0010g\u001a\u00020H2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010J\u001a\u00020-J\u0006\u0010l\u001a\u00020 J\u001a\u0010m\u001a\u00020H2\u0008\u0008\u0002\u0010R\u001a\u00020 2\u0008\u0008\u0002\u0010S\u001a\u00020 J,\u0010m\u001a\u00020H2\u000e\u0008\u0002\u0010P\u001a\u0008\u0012\u0004\u0012\u00020-0Q2\u0008\u0008\u0002\u0010R\u001a\u00020 2\u0008\u0008\u0002\u0010S\u001a\u00020 H\u0002J\u000e\u0010n\u001a\u00020H2\u0006\u0010o\u001a\u00020\u001cJ\u001e\u0010p\u001a\u00020H2\u0006\u0010q\u001a\u00020 2\u0006\u0010I\u001a\u00020-2\u0006\u0010r\u001a\u00020 J\u0018\u0010s\u001a\u00020E2\u0006\u0010q\u001a\u00020 2\u0006\u0010I\u001a\u00020-H\u0002J\u0006\u0010t\u001a\u00020HJ\u0006\u0010u\u001a\u00020HJ\u0006\u0010v\u001a\u00020HJ\u0008\u0010w\u001a\u00020HH\u0002J\u0006\u0010x\u001a\u00020HJ\u0006\u0010y\u001a\u00020 J\u0006\u0010z\u001a\u00020 J \u0010{\u001a\u00020H2\u0006\u0010'\u001a\u00020)2\u0006\u0010|\u001a\u00020-2\u0006\u0010}\u001a\u00020AH\u0002J\u0006\u0010~\u001a\u00020HJ\u0019\u0010\u007f\u001a\u0008\u0012\u0004\u0012\u00020)0\u001b2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010)H\u0002R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020 0\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020 0\u001b0$¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u001d\u0010'\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u001b0(¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u0008\u0012\u0004\u0012\u00020-0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0008\u0012\u0004\u0012\u0002020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\u0008\u0012\u0004\u0012\u00020 0$¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010&R\u0017\u00105\u001a\u0008\u0012\u0004\u0012\u00020-06¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0017\u00109\u001a\u0008\u0012\u0004\u0012\u00020:0$¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010&R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b06¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u00108R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u001e06¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u00108R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010@\u001a\u0010\u0012\u000c\u0012\n B*\u0004\u0018\u00010A0A0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001", d2 = {"Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "inAppRateRepository", "Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "breedRepository", "Lapp/dogo/com/dogo_android/repository/local/BreedRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "iterableApi", "Lcom/iterable/iterableapi/IterableApi;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/local/BreedRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lcom/iterable/iterableapi/IterableApi;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "_trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "backendSyncResults", "", "getBackendSyncResults", "()Landroidx/lifecycle/MutableLiveData;", "dogDeleteSpinner", "Lcom/hadilq/liveevent/LiveEvent;", "getDogDeleteSpinner", "()Lcom/hadilq/liveevent/LiveEvent;", "dogProfile", "Landroidx/lifecycle/MediatorLiveData;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getDogProfile", "()Landroidx/lifecycle/MediatorLiveData;", "errorEvent", "", "isDogProfileSetup", "lastClickMs", "", "messageEmitter", "Landroid/os/Bundle;", "onDogDelete", "getOnDogDelete", "onError", "Landroidx/lifecycle/LiveData;", "getOnError", "()Landroidx/lifecycle/LiveData;", "onZendeskOpen", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getOnZendeskOpen", "result", "getResult", "trick", "getTrick", "unreadMessagesCount", "", "kotlin.jvm.PlatformType", "getUnreadMessagesCount", "backedSyncFix", "Lio/reactivex/Completable;", "cacheSyncFix", "changeCurrentProfile", "", "dogId", "source", "emitMessage", "messageActionHideElement", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "message", "fetchDataAndOpenZendeskScreen", "customTags", "", "hasRequestHistory", "hasUnreadMessages", "fillCacheFromBundle", "bundle", "fixUserData", "gatherDataAndTrackCurrentDogUserProperties", "getCacheBundle", "getSubscriptionAppScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "fragmentReturnTag", "initiatedByDogParentFlow", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "getSuccessDogData", "getUserId", "hasUserUnlockedFirstExam", "isClickTimeoutOver", "isContactUsBadgeEnabled", "isExamsEnabled", "isProgramTutorialFinished", "isTrainingMetricStreakScreenShownToday", "launchReviewFlow", "activity", "Landroidx/fragment/app/FragmentActivity;", "info", "Lcom/google/android/play/core/review/ReviewInfo;", "mobileInboxVisible", "openZendeskScreen", "presetSuccessResult", "session", "removeDog", "isCreator", "isLastDog", "removeDogFromUser", "resetSuccessResult", "setFirstExamUnlockedScreenShowed", "setProgramTutorialAsFinished", "setupDogProfileLiveData", "setupOrFixDogProfileLiveData", "shouldShowExamUnlockedScreen", "shouldShowFirstExamUnlockedScreen", "trackCurrentDogUserProperties", "breedName", "ratedTrickCount", "updateUnreadInboxMessagesCount", "wrapDogProfileWithLoadResults", "dog", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends s {

    public static final app.dogo.com.dogo_android.view.dailytraining.l.a Companion;
    private static final List<String> x;
    private static final List<String> y;
    private final p1 a;
    private final r2 b;
    private final o3 c;
    private final p2 d;
    private final c e;
    private final d3 f;
    private final h2 g;
    private final z0 h;
    private final v2 i;
    private final j j;
    private final o1 k;
    private final a<y<Boolean>> l;
    private final a<Boolean> m;
    private final x<y<Boolean>> n;
    private final a<ZendeskConfigurationInfo> o;
    private final v<y<DogProfile>> p;
    private boolean q;
    private final x<Integer> r;
    private long s;
    private final x<y<TrainingSession>> t;
    private final LiveData<y<TrainingSession>> u;
    private final x<TrickItem> v;
    private final a<String> w;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004J(\u0010\u000c\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004H\u0002J\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004J\u001c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0004H\u0002J:\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00042\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0004H\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel$Companion;", "", "()V", "level2BlackList", "", "", "tricksIdBlackList", "createTrainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "allTricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "lessonTricks", "fillTrainingSession", "filterBlacklistedTrickIds", "knownTrickIds", "filterBlacklistedTricks", "knownTricks", "modifyTrainingList", "unknownTricks", "default", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        private final TrainingSession b(List<TrickItem> list, List<TrickItem> list2) {
            List list3;
            Object next;
            int i;
            boolean mastered;
            if (list.isEmpty()) {
                super(0, 0, 0, 0, 15, 0);
                return obj14;
            }
            list3 = p.g();
            ArrayList arrayList = new ArrayList();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((TrickItem)next.isMastered()) {
                }
                arrayList.add(next);
            }
            List obj14 = p.p0(list, arrayList);
            i = 1;
            if (empty2 ^= i != 0) {
                list3 = p.b(p.X(obj14));
            }
            obj14 = d(arrayList).size();
            if (obj14 >= 0 && obj14 <= i) {
                if (obj14 <= i) {
                } else {
                    i = i2;
                }
            } else {
            }
            if (i != 0 && list2 == null) {
                if (list2 == null) {
                    super(0, 0, 0, 0, 15, 0);
                    return obj14;
                }
            }
            super(e(list2, obj14, list3), 0, 0, 0, 14, 0);
            return obj14;
        }

        private final List<TrickItem> d(List<TrickItem> list) {
            String str;
            boolean next;
            boolean contains;
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            Iterator iterator = list.iterator();
            for (TrickItem next3 : iterator) {
                arrayList.add(next3.getId());
            }
            ArrayList arrayList2 = new ArrayList();
            final Iterator obj5 = list.iterator();
            while (obj5.hasNext()) {
                next = obj5.next();
                if (c(arrayList).contains((TrickItem)next.getId())) {
                }
                arrayList2.add(next);
            }
            return arrayList2;
        }

        private final List<TrickItem> e(List<TrickItem> list, List<TrickItem> list2, List<TrickItem> list3) {
            Object next2;
            boolean next;
            boolean ratedByUser;
            ArrayList arrayList;
            Iterator iterator;
            boolean next3;
            if (list != null) {
                ArrayList obj8 = new ArrayList();
                Iterator obj7 = list2.iterator();
                while (obj7.hasNext()) {
                    next2 = obj7.next();
                    if ((TrickItem)next2.isRatedByUser()) {
                    }
                    obj8.add(next2);
                }
                obj7 = new ArrayList();
                obj8 = obj8.iterator();
                for (Object next : obj8) {
                    arrayList = new ArrayList(p.r(list, 10));
                    iterator = list.iterator();
                    for (TrickItem next5 : iterator) {
                        arrayList.add(next5.getId());
                    }
                    if (!arrayList.contains((TrickItem)next.getId())) {
                    }
                    obj7.add(next);
                    arrayList.add((TrickItem)iterator.next().getId());
                }
                return p.U(p.F0(p.u0(list, (TrickItem)p.l0(obj7)), 3));
            }
            return list3;
        }

        public final TrainingSession a(List<TrickItem> list, List<TrickItem> list2) {
            n.f(list, "allTricks");
            return b(list, list2);
        }

        public final List<String> c(List<String> list) {
            Object next2;
            boolean next;
            boolean contains2;
            boolean contains;
            List contains3;
            String str;
            int i3;
            int i;
            int i2;
            n.f(list, "knownTrickIds");
            ArrayList arrayList = new ArrayList();
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                next2 = iterator2.next();
                if (!l.j().contains((String)next2)) {
                }
                arrayList.add(next2);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                contains = next;
                if (l.i().contains((String)contains) && list.contains(l.I(contains, "_01", "_02", false, 4, 0))) {
                } else {
                }
                contains2 = 0;
                if (contains2 == 0) {
                }
                arrayList2.add(next);
                if (list.contains(l.I(contains, "_01", "_02", false, 4, 0))) {
                } else {
                }
                contains2 = 1;
            }
            return arrayList2;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.view.dailytraining.l this$0;
        b(app.dogo.com.dogo_android.view.dailytraining.l l) {
            this.this$0 = l;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            a.d(throwable);
            this.this$0.getOnZendeskOpen().postValue(ZendeskConfigurationInfo.Companion.createEmpty(l.h(this.this$0).v()));
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<ZendeskConfigurationInfo, w> {

        final app.dogo.com.dogo_android.view.dailytraining.l this$0;
        c(app.dogo.com.dogo_android.view.dailytraining.l l) {
            this.this$0 = l;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((ZendeskConfigurationInfo)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(ZendeskConfigurationInfo zendeskConfigurationInfo) {
            this.this$0.getOnZendeskOpen().postValue(zendeskConfigurationInfo);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.view.dailytraining.l this$0;
        d(app.dogo.com.dogo_android.view.dailytraining.l l) {
            this.this$0 = l;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            a.d(throwable);
            y.a aVar = new y.a(throwable);
            this.this$0.B().setValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<w> {

        final app.dogo.com.dogo_android.view.dailytraining.l this$0;
        e(app.dogo.com.dogo_android.view.dailytraining.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            l.k(this.this$0);
            y.c cVar = new y.c(Boolean.TRUE);
            this.this$0.B().setValue(cVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<Throwable, w> {

        public static final app.dogo.com.dogo_android.view.dailytraining.l.f a;
        static {
            l.f fVar = new l.f();
            l.f.a = fVar;
        }

        f() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            RuntimeException runtimeException = new RuntimeException("Failed to track current dog user properties", throwable);
            a.d(runtimeException);
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006 \u0007*\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lkotlin/Triple;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements l<t<? extends DogProfile, ? extends String, ? extends Integer>, w> {

        final app.dogo.com.dogo_android.view.dailytraining.l this$0;
        g(app.dogo.com.dogo_android.view.dailytraining.l l) {
            this.this$0 = l;
            super(1);
        }

        public final void a(t<DogProfile, String, Integer> t) {
            l.l(this.this$0, (DogProfile)t.a(), (String)t.b(), (Number)t.c().intValue());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((t)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.view.dailytraining.l this$0;
        h(app.dogo.com.dogo_android.view.dailytraining.l l) {
            this.this$0 = l;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar2 = new y.a(throwable);
            this.this$0.D().postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements a<w> {

        final boolean $isLastDog;
        final app.dogo.com.dogo_android.view.dailytraining.l this$0;
        i(app.dogo.com.dogo_android.view.dailytraining.l l, boolean z2) {
            this.this$0 = l;
            this.$isLastDog = z2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            y.c cVar = new y.c(Boolean.TRUE);
            this.this$0.D().postValue(cVar);
            this.this$0.F().postValue(Boolean.valueOf(this.$isLastDog));
        }
    }
    static {
        l.a aVar = new l.a(0);
        l.Companion = aVar;
        l.x = p.j(/* result */);
        l.y = p.j(/* result */);
    }

    public l(p1 p1, r2 r22, o3 o33, p2 p24, c c5, d3 d36, h2 h27, z0 z08, v2 v29, j j10, o1 o111) {
        Object obj2;
        int obj3;
        Object obj5;
        n.f(p1, "userRepository");
        n.f(r22, "remoteConfigService");
        n.f(o33, "tracker");
        n.f(p24, "preferenceService");
        n.f(c5, "inAppRateRepository");
        n.f(d36, "isDogPremiumInteractor");
        n.f(h27, "authService");
        n.f(z08, "breedRepository");
        n.f(v29, "utilities");
        n.f(j10, "iterableApi");
        n.f(o111, "tricksRepository");
        super();
        this.a = p1;
        this.b = r22;
        this.c = o33;
        this.d = p24;
        this.e = c5;
        this.f = d36;
        this.g = h27;
        this.h = z08;
        this.i = v29;
        this.j = j10;
        this.k = o111;
        obj3 = new a();
        this.l = obj3;
        obj3 = new a();
        this.m = obj3;
        obj3 = new x();
        this.n = obj3;
        obj3 = new a();
        this.o = obj3;
        obj3 = new v();
        this.p = obj3;
        if (obj3 ^= 1 != 0) {
            p1.b0();
            p1.c0();
            p1.i0();
        } else {
            obj3 = new k1();
            obj5 = "Login in auth object has not finished initializing";
            o33.d(a0.j.d(u.a(obj3, obj5)));
            obj2 = new Exception(obj5);
            a.d(obj2);
        }
        obj2 = new x();
        obj2 = new x(0);
        this.r = obj2;
        obj2 = new x();
        this.t = obj2;
        this.u = obj2;
        obj2 = new x();
        this.v = obj2;
        obj2 = new a();
        this.w = obj2;
    }

    private static final t A(DogProfile dogProfile, Map map2, DogBreed dogBreed3) {
        n.f(map2, "$evaluatedTrick");
        n.f(dogBreed3, "dogBreed");
        t tVar = new t(dogProfile, dogBreed3.getName(), Integer.valueOf(map2.size()));
        return tVar;
    }

    public static j H(app.dogo.com.dogo_android.view.dailytraining.l l, String string2, String string3, boolean z4, ProfilePreview profilePreview5, int i6, Object object7) {
        int obj3;
        int obj4;
        if (i6 & 4 != 0) {
            obj3 = 0;
        }
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        return l.G(string2, string3, obj3, obj4);
    }

    private final boolean M() {
        int i;
        if (Long.compare(i2, i3) > 0) {
            this.s = this.i.g();
            i = 1;
        } else {
            i = 0;
        }
        return i;
    }

    private final boolean O() {
        return this.b.c0();
    }

    public static void R(app.dogo.com.dogo_android.view.dailytraining.l l, DogProfile dogProfile2) {
        l.k0(l, dogProfile2);
    }

    public static f S(app.dogo.com.dogo_android.view.dailytraining.l l, Boolean boolean2) {
        return l.r(l, boolean2);
    }

    public static Boolean T() {
        return l.q();
    }

    public static DogProfile U(DogProfile dogProfile) {
        l.o(dogProfile);
        return dogProfile;
    }

    public static f V(app.dogo.com.dogo_android.view.dailytraining.l l, Boolean boolean2) {
        return l.x(l, boolean2);
    }

    public static g0 W(app.dogo.com.dogo_android.view.dailytraining.l l, DogProfile dogProfile2, Map map3) {
        return l.z(l, dogProfile2, map3);
    }

    public static t X(DogProfile dogProfile, Map map2, DogBreed dogBreed3) {
        return l.A(dogProfile, map2, dogBreed3);
    }

    public static ZendeskConfigurationInfo Y(app.dogo.com.dogo_android.view.dailytraining.l l, List list2, boolean z3, boolean z4, DogProfile dogProfile5, Boolean boolean6) {
        return l.u(l, list2, z3, z4, dogProfile5, boolean6);
    }

    public static f Z(app.dogo.com.dogo_android.view.dailytraining.l l, UserApiModel userApiModel2) {
        return l.n(l, userApiModel2);
    }

    public static void c0(app.dogo.com.dogo_android.view.dailytraining.l l, boolean z2, boolean z3, int i4, Object object5) {
        int obj2;
        int obj3;
        final int i = 0;
        if (i4 & 1 != 0) {
            obj2 = i;
        }
        if (i4 &= 2 != 0) {
            obj3 = i;
        }
        l.openZendeskScreen(obj2, obj3);
    }

    private final b f0(boolean z, String string2) {
        String str;
        b obj2;
        if (z) {
            obj2 = this.a.o(string2);
        } else {
            obj2 = this.a.p(string2, this.g.v());
        }
        return obj2;
    }

    public static final h2 h(app.dogo.com.dogo_android.view.dailytraining.l l) {
        return l.g;
    }

    public static final List i() {
        return l.y;
    }

    public static final List j() {
        return l.x;
    }

    private final void j0() {
        boolean z;
        LiveData liveData;
        app.dogo.com.dogo_android.view.dailytraining.b bVar;
        if (!this.q) {
            this.q = true;
            bVar = new b(this);
            this.p.b(this.a.x(), bVar);
        }
    }

    public static final void k(app.dogo.com.dogo_android.view.dailytraining.l l) {
        l.j0();
    }

    private static final void k0(app.dogo.com.dogo_android.view.dailytraining.l l, DogProfile dogProfile2) {
        Object str;
        Object obj1;
        n.f(l, "this$0");
        if (dogProfile2 == null) {
        } else {
            l.y(dogProfile2);
            l.a.f(dogProfile2);
            l.E().postValue(l.q0(dogProfile2));
        }
    }

    public static final void l(app.dogo.com.dogo_android.view.dailytraining.l l, DogProfile dogProfile2, String string3, int i4) {
        l.o0(dogProfile2, string3, i4);
    }

    private final b m() {
        a.f("Backend sync fix called", new Object[0]);
        j jVar = new j(this);
        b flatMapCompletable = this.a.B0().flatMapCompletable(jVar);
        n.e(flatMapCompletable, "userRepository.updateUserCacheFromRemote().flatMapCompletable {\n            if (userRepository.tempUserCache.getDogCount() == 0) {\n                Timber.i(\"Add new dog fix called\")\n                userRepository.addNewDog().map { dogProfile ->\n                    Timber.i(\"New dog added successfully\")\n                    dogProfile\n                }.ignoreElement()\n            } else {\n                Completable.complete()\n            }\n        }");
        return flatMapCompletable;
    }

    private static final f n(app.dogo.com.dogo_android.view.dailytraining.l l, UserApiModel userApiModel2) {
        int str;
        b obj1;
        app.dogo.com.dogo_android.view.dailytraining.e obj2;
        n.f(l, "this$0");
        n.f(userApiModel2, "it");
        if (l.a.H().j() == 0) {
            a.f("Add new dog fix called", new Object[0]);
            str = 0;
            obj1 = p1.d(l.a, str, 1, str).map(e.a).ignoreElement();
        } else {
            obj1 = b.f();
        }
        return obj1;
    }

    private static final DogProfile o(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        a.f("New dog added successfully", new Object[0]);
        return dogProfile;
    }

    private final void o0(DogProfile dogProfile, String string2, int i3) {
        Object obj5;
        this.c.q(q3.CurrentDogName, dogProfile.getName());
        this.c.q(q3.CurrentDogBreedId, dogProfile.getBreedId());
        if (z ^= 1 != 0) {
        } else {
            obj5 = "";
        }
        this.c.q(q3.CurrentDogBreed, obj5);
        this.c.q(q3.CurrentDogProfileUrl, dogProfile.getAvatar());
        this.c.q(q3.CurrentDogGender, dogProfile.getGender().getTrackTag());
        this.c.j(dogProfile);
        this.c.q(q3.TricksRated, Integer.valueOf(i3));
    }

    private final void openZendeskScreen(List<String> list, boolean z2, boolean z3) {
        if (M()) {
            fetchDataAndOpenZendeskScreen(list, z2, z3);
        }
    }

    private final b p() {
        a.f("Cache fix called", new Object[0]);
        c cVar = new c(this);
        b flatMapCompletable = this.a.r().B(d.a).flatMapCompletable(cVar);
        n.e(flatMapCompletable, "userRepository.fillCacheFromRoom().toSingle { true }.flatMapCompletable {\n            if (userRepository.tempUserCache.getDogCount() == 0) {\n                backedSyncFix()\n            } else {\n                Completable.complete()\n            }\n        }");
        return flatMapCompletable;
    }

    private static final Boolean q() {
        return Boolean.TRUE;
    }

    private final y<DogProfile> q0(DogProfile dogProfile) {
        y cVar;
        String str;
        Object obj3;
        if (dogProfile != null) {
            cVar = new y.c(dogProfile);
        } else {
            obj3 = new Exception("No dog");
            cVar = new y.a(obj3);
        }
        return cVar;
    }

    private static final f r(app.dogo.com.dogo_android.view.dailytraining.l l, Boolean boolean2) {
        b obj1;
        n.f(l, "this$0");
        n.f(boolean2, "it");
        if (l.a.H().j() == 0) {
            obj1 = l.m();
        } else {
            obj1 = b.f();
        }
        return obj1;
    }

    public static void t(app.dogo.com.dogo_android.view.dailytraining.l l, List list2, boolean z3, boolean z4, int i5, Object object6) {
        List obj2;
        int obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj2 = p.g();
        }
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        l.fetchDataAndOpenZendeskScreen(obj2, obj3, obj4);
    }

    private static final ZendeskConfigurationInfo u(app.dogo.com.dogo_android.view.dailytraining.l l, List list2, boolean z3, boolean z4, DogProfile dogProfile5, Boolean boolean6) {
        n.f(l, "this$0");
        n.f(list2, "$customTags");
        n.f(dogProfile5, "dogProfile");
        n.f(boolean6, "isPremium");
        super(l.g.v(), boolean6, dogProfile5, list2, l.b.U(l.d.W()), l.g.D(), z3, z4);
        return obj10;
    }

    private static final f x(app.dogo.com.dogo_android.view.dailytraining.l l, Boolean boolean2) {
        b obj1;
        n.f(l, "this$0");
        n.f(boolean2, "cacheExists");
        if (boolean2.booleanValue()) {
            obj1 = l.p();
        } else {
            obj1 = l.m();
        }
        return obj1;
    }

    private final void y(DogProfile dogProfile) {
        a disposable;
        app.dogo.com.dogo_android.view.dailytraining.l.f fVar;
        app.dogo.com.dogo_android.view.dailytraining.l.g gVar;
        Object obj4;
        if (dogProfile != null) {
            g gVar2 = new g(this, dogProfile);
            obj4 = this.k.f(dogProfile.getId()).flatMap(gVar2).subscribeOn(a.b()).observeOn(a.b());
            n.e(obj4, "tricksRepository.getAllTrickKnowledge(dogProfile.id).flatMap { evaluatedTrick ->\n                    breedRepository.getBreed(dogProfile.breedId ?: dogProfile.name).map { dogBreed ->\n                        Triple(dogProfile, dogBreed.name, evaluatedTrick.size)\n                    }\n                }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            gVar = new l.g(this);
            getDisposable().b(a.g(obj4, l.f.a, gVar));
        }
    }

    private static final g0 z(app.dogo.com.dogo_android.view.dailytraining.l l, DogProfile dogProfile2, Map map3) {
        String breedId;
        n.f(l, "this$0");
        n.f(map3, "evaluatedTrick");
        if (dogProfile2.getBreedId() == null) {
            breedId = dogProfile2.getName();
        }
        h hVar = new h(dogProfile2, map3);
        return l.h.d(breedId).map(hVar);
    }

    public final x<y<Boolean>> B() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Bundle C() {
        return this.a.t();
    }

    public final a<y<Boolean>> D() {
        return this.l;
    }

    public final v<y<DogProfile>> E() {
        return this.p;
    }

    public final a<Boolean> F() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final j G(String string, String string2, boolean z3, ProfilePreview profilePreview4) {
        n.f(string, "source");
        n.f(string2, "fragmentReturnTag");
        return l1.b(this.b, string, string2, z3, profilePreview4, 0, 16, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogProfile I() {
        Object value;
        Object i;
        if (value instanceof y.c) {
        } else {
            value = i;
        }
        if (value == null) {
        } else {
            i = value;
        }
        return i;
    }

    public final x<Integer> J() {
        return this.r;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String K() {
        return this.g.v();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean L() {
        int hasUserUnlockedFirstModuleExam;
        int i;
        if (hasUserUnlockedFirstModuleExam instanceof y.c) {
        } else {
            hasUserUnlockedFirstModuleExam = 0;
        }
        if (hasUserUnlockedFirstModuleExam == 0) {
            i = i2;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean N() {
        boolean z;
        int i;
        if (this.b.Q() && !this.d.h0()) {
            i = !this.d.h0() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean P() {
        return this.d.k0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean Q() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", n2.b(this.d.W()));
        return n.b(this.d.L(), simpleDateFormat.format(this.i.f().getTime()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void a0(e e, ReviewInfo reviewInfo2, String string3) {
        n.f(e, "activity");
        n.f(reviewInfo2, "info");
        n.f(string3, "source");
        this.e.d(e, reviewInfo2, string3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean b0() {
        return this.b.Y();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void d0(TrainingSession trainingSession) {
        n.f(trainingSession, "session");
        y.c cVar = new y.c(trainingSession);
        this.t.setValue(cVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void e0(boolean z, String string2, boolean z3) {
        n.f(string2, "dogId");
        this.l.postValue(y.b.a);
        b obj3 = f0(z, string2).y(a.b()).q(a.a());
        n.e(obj3, "removeDogFromUser(isCreator, dogId)\n                .subscribeOn(Schedulers.io())\n                .observeOn(AndroidSchedulers.mainThread())");
        l.h obj4 = new l.h(this);
        l.i iVar = new l.i(this, z3);
        getDisposable().b(a.d(obj3, obj4, iVar));
    }

    public final void fetchDataAndOpenZendeskScreen(List<String> list, boolean z2, boolean z3) {
        n.f(list, "customTags");
        int i = 0;
        i iVar = new i(this, list, z2, z3);
        a0 obj6 = a0.zip(this.a.w(), d3.b(this.f, i, 1, i), iVar).observeOn(a.b()).subscribeOn(a.b());
        n.e(obj6, "zip(\n                    userRepository.getCurrentDogProfile(),\n                    isDogPremiumInteractor.isCurrentDogPremium(),\n                    { dogProfile, isPremium ->\n                        ZendeskConfigurationInfo(\n                            userId = authService.currentUserId,\n                            dogProfile = dogProfile,\n                            isDogPremium = isPremium,\n                            customTags = customTags,\n                            isUserLoggedIn = authService.isUserSignedIn,\n                            hasUnreadMessages = hasUnreadMessages,\n                            hasRequestHistory = hasRequestHistory,\n                            isHelpCenterEnabled = remoteConfigService.isHelpCenterEnabled(preferenceService.selectedLocale)\n                        )\n                    }\n                )\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        l.b obj7 = new l.b(this);
        l.c obj8 = new l.c(this);
        getDisposable().b(a.g(obj6, obj7, obj8));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void g0() {
        super(0, 0, 0, 0, 15, 0);
        y.c cVar = new y.c(trainingSession2);
        this.t.setValue(cVar);
    }

    public final a<ZendeskConfigurationInfo> getOnZendeskOpen() {
        return this.o;
    }

    public final LiveData<y<TrainingSession>> getResult() {
        return this.u;
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
        if (this.a.H().j() == 0) {
            w();
        } else {
            j0();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m0() {
        Object value;
        int i;
        int repeatedTraining;
        int i2;
        List exams;
        if (value instanceof y.c) {
        } else {
            value = repeatedTraining;
        }
        if (value == null) {
        } else {
            repeatedTraining = value;
        }
        i = 1;
        int i3 = 0;
        if (repeatedTraining == 0) {
            i2 = i3;
        } else {
        }
        if (i2 != 0 && O()) {
            if (O()) {
                if (repeatedTraining == 0) {
                    repeatedTraining = i3;
                } else {
                }
                if (repeatedTraining != 0) {
                } else {
                    i = i3;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean n0() {
        return z ^= 1;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void openZendeskScreen(boolean z, boolean z2) {
        this.d.V0();
        openZendeskScreen(p.g(), z, z2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p0() {
        this.r.postValue(Integer.valueOf(this.j.q().o()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(String string, String string2) {
        n.f(string, "dogId");
        n.f(string2, "source");
        this.a.u0(string);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(Bundle bundle) {
        boolean obj2;
        n.f(bundle, "bundle");
        if (this.a.s(bundle)) {
            j0();
        } else {
            if (this.a.H().j() == 0) {
                w();
            } else {
                j0();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        f fVar = new f(this);
        b bVar2 = this.a.q().flatMapCompletable(fVar).y(a.b()).q(a.a());
        n.e(bVar2, "userRepository.doesCacheExists().flatMapCompletable { cacheExists ->\n                if (cacheExists) {\n                    cacheSyncFix()\n                } else {\n                    backedSyncFix()\n                }\n            }\n                .subscribeOn(Schedulers.io())\n                .observeOn(AndroidSchedulers.mainThread())");
        l.d dVar = new l.d(this);
        l.e eVar = new l.e(this);
        getDisposable().b(a.d(bVar2, dVar, eVar));
    }
}
