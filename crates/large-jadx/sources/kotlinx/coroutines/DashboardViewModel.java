package app.dogo.com.dogo_android.g;

import android.app.ActivityManager.ProcessErrorStateInfo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.repository.domain.Dashboard;
import app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard;
import app.dogo.com.dogo_android.repository.domain.DashboardProgram;
import app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.a.f3;
import app.dogo.com.dogo_android.s.a.k2;
import app.dogo.com.dogo_android.s.a.l2;
import app.dogo.com.dogo_android.s.a.l3;
import app.dogo.com.dogo_android.s.a.m3;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.a.q2;
import app.dogo.com.dogo_android.s.a.r3;
import app.dogo.com.dogo_android.s.a.s3;
import app.dogo.com.dogo_android.s.a.x2;
import app.dogo.com.dogo_android.s.a.y1;
import app.dogo.com.dogo_android.s.a.z2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.subscription.benefits.RxJavaDogo;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.s0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w1;
import app.dogo.com.dogo_android.y.i;
import app.dogo.com.dogo_android.y.k.b;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.m0;

/* compiled from: DashboardViewModel.kt */
@Metadata(d1 = "\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001BÑ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\u0008\u0008\u0002\u00100\u001a\u000201\u0012\u0008\u0008\u0002\u00102\u001a\u000203¢\u0006\u0002\u00104J\u000e\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020BJ\u0006\u0010[\u001a\u00020=J\u0017\u0010\\\u001a\u00020:2\u0008\u0010]\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0002\u0010^J\u0006\u0010_\u001a\u00020=J\u000e\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020BJ\u0006\u0010b\u001a\u00020cJ\u0008\u0010d\u001a\u00020=H\u0002J\u0017\u0010e\u001a\u00020=2\u0008\u0010]\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0002\u0010fJ\u0006\u0010g\u001a\u00020hJ\u0006\u0010i\u001a\u00020hJ\u0006\u0010j\u001a\u00020hJ\u000e\u0010k\u001a\u00020h2\u0006\u0010l\u001a\u00020cJ\u0006\u0010m\u001a\u00020hJ\u0006\u0010n\u001a\u00020hJ\u0006\u0010o\u001a\u00020hJ\u0019\u0010p\u001a\u00020q2\u0006\u0010a\u001a\u00020BH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010rJ\r\u0010s\u001a\u0004\u0018\u00010=¢\u0006\u0002\u0010tJ\u0006\u0010u\u001a\u00020=J\u0010\u0010v\u001a\u00020h2\u0006\u0010w\u001a\u00020:H\u0002J\u0006\u0010x\u001a\u00020=J\u0006\u0010y\u001a\u00020hJ\u0006\u0010z\u001a\u00020hJ\u0006\u0010{\u001a\u00020hJ\u0006\u0010|\u001a\u00020hJ\u000e\u0010}\u001a\u00020h2\u0006\u0010~\u001a\u00020BJ\u0006\u0010\u007f\u001a\u00020hJ\u0007\u0010\u0080\u0001\u001a\u00020hJ\u0010\u0010\u0081\u0001\u001a\u00020h2\u0007\u0010\u0082\u0001\u001a\u00020BJ\u0007\u0010\u0083\u0001\u001a\u00020hJ\u0007\u0010\u0084\u0001\u001a\u00020hJ\u0007\u0010\u0085\u0001\u001a\u00020hJ\u0010\u0010\u0086\u0001\u001a\u00020h2\u0007\u0010\u0087\u0001\u001a\u00020BJ\u0010\u0010\u0088\u0001\u001a\u00020h2\u0007\u0010\u0089\u0001\u001a\u00020BJ\u0007\u0010\u008a\u0001\u001a\u00020hJ\u0007\u0010\u008b\u0001\u001a\u00020hJ\u0010\u0010\u008c\u0001\u001a\u00020h2\u0007\u0010\u008d\u0001\u001a\u00020BJ\u0007\u0010\u008e\u0001\u001a\u00020hJ\u0013\u0010\u008f\u0001\u001a\u00020h2\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0002J\u0007\u0010\u0092\u0001\u001a\u00020hJ\u0007\u0010\u0093\u0001\u001a\u00020hJ\u0007\u0010\u0094\u0001\u001a\u00020hJ\u0007\u0010\u0095\u0001\u001a\u00020hJ\u0012\u0010\u0096\u0001\u001a\u00020h2\u0007\u0010\u0097\u0001\u001a\u000208H\u0002R\u001a\u00105\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002080706X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0004\n\u0002\u0010;R\u0017\u0010<\u001a\u0008\u0012\u0004\u0012\u00020=06¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u0008\u0012\u0004\u0012\u00020B0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010C\u001a\u00020D¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010FR\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010G\u001a\u0008\u0012\u0004\u0012\u00020B0H¢\u0006\u0008\n\u0000\u001a\u0004\u0008I\u0010JR\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010K\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u000208070H¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010JR\u0017\u0010M\u001a\u0008\u0012\u0004\u0012\u00020B0A¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010OR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010R\u001a\u0008\u0012\u0004\u0012\u00020S06¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010?R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010W\u001a\u0008\u0012\u0004\u0012\u00020=0A¢\u0006\u0008\n\u0000\u001a\u0004\u0008X\u0010OR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0098\u0001", d2 = {"Lapp/dogo/com/dogo_android/dashboard/DashboardViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "getDashboardProgramCardTypeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardProgramCardTypeInteractor;", "getDashboardExamCardInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardExamCardInteractor;", "getRecommendedProgramRequestInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "dogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "shouldShowWorkoutUnlockedInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "specialOfferInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "zendeskInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;", "getLibraryTrickListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "pottyProgramCardInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramCardInteractor;", "bitingProgramCardInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramCardInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "getProgramOverviewInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;", "timeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "lessonItemHelper", "Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardProgramCardTypeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardExamCardInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramCardInteractor;Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramCardInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;Lkotlinx/coroutines/CoroutineDispatcher;Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;)V", "_results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "couponEndTimeMs", "", "Ljava/lang/Long;", "discountVisible", "", "getDiscountVisible", "()Landroidx/lifecycle/MutableLiveData;", "errorEvent", "Lcom/hadilq/liveevent/LiveEvent;", "", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "onError", "Landroidx/lifecycle/LiveData;", "getOnError", "()Landroidx/lifecycle/LiveData;", "results", "getResults", "shouldShowWorkoutUnlocked", "getShouldShowWorkoutUnlocked", "()Lcom/hadilq/liveevent/LiveEvent;", "tick", "Ljava/util/concurrent/atomic/AtomicLong;", "timer", "Lapp/dogo/com/dogo_android/repository/domain/CouponTimer;", "getTimer", "timerDisposable", "Lio/reactivex/disposables/Disposable;", "workoutCardShown", "getWorkoutCardShown", "didDogIdChange", "newDogId", "getHasZendeskHistoryData", "getRemainingCouponDurationMs", "endTimeMs", "(Ljava/lang/Long;)J", "getShouldShowReminderScreen", "getWorkoutUnlockSourceBlocking", "dogId", "getZendeskUnreadMessagesData", "", "isContactUsLocked", "isDiscountStillValid", "(Ljava/lang/Long;)Z", "loadList", "", "refreshTimerDuration", "retry", "saveTemporaryRecentTricksScrollPosition", "position", "setAuthenticationScreenShowed", "setClosedResubscribeCard", "setReminderScreenShown", "setupProgramItem", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisplayUnlockHelplineScreen", "()Ljava/lang/Boolean;", "shouldShowAuthenticationScreen", "startTimer", "durationInSeconds", "toggleTrainingMetricsTooltipState", "trackBitingProgramClicked", "trackContactUsClicked", "trackDogProfileClick", "trackExamCardClick", "trackExplorePrograms", "source", "trackHelpClick", "trackLessonContinue", "trackLessonNextStart", "lessonId", "trackLogActivityClicked", "trackMetricsTooltipMoreTap", "trackMobileInboxClicked", "trackPottyTrackerCardTapped", "action", "trackRecentlyViewedTrickClicked", "trickId", "trackResubscribeCardClick", "trackReviewProgram", "trackSpecialProgramClicked", "type", "trackSubscriptionCardClick", "trackUserWorkoutProperties", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "trackWorkoutCardShown", "trackWorkoutExploreClicked", "trackWorkoutInfoClicked", "trackWorkoutStartClicked", "triggerWorkoutUnlockIfNeeded", "dashboard", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r, reason: from kotlin metadata */
public final class DashboardViewModel extends s {

    /* renamed from: A, reason: from kotlin metadata */
    private final LiveData<y<Dashboard>> authService;
    /* renamed from: B, reason: from kotlin metadata */
    private final f.d.a.a<String> bitingProgramCardInteractor;
    /* renamed from: C, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> connectivityService;
    /* renamed from: D, reason: from kotlin metadata */
    private final CoroutineExceptionHandler couponEndTimeMs;
    private final AtomicLong E;
    /* renamed from: F, reason: from kotlin metadata */
    private final androidx.lifecycle.x<CouponTimer> dispatcher;
    /* renamed from: G, reason: from kotlin metadata */
    private final androidx.lifecycle.x<Boolean> dogLocalEntityDao;
    /* renamed from: H, reason: from kotlin metadata */
    private i.b.j0.b dogPremiumInteractor;
    /* renamed from: I, reason: from kotlin metadata */
    private Long errorEvent;
    /* renamed from: J, reason: from kotlin metadata */
    private final f.d.a.a<String> getDashboardExamCardInteractor;
    /* renamed from: a, reason: from kotlin metadata */
    private final o3 getDashboardProgramCardTypeInteractor;
    /* renamed from: b, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 getLibraryTrickListInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final l2 getProgramOverviewInteractor;
    /* renamed from: d, reason: from kotlin metadata */
    private final k2 getRecommendedProgramRequestInteractor;
    private final z2 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final p1 lessonItemHelper;
    private final n3 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final d3 pottyProgramCardInteractor;
    /* renamed from: i, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.v2 preferenceService;
    /* renamed from: j, reason: from kotlin metadata */
    private final p2 programRepository;
    /* renamed from: k, reason: from kotlin metadata */
    private final l3 remoteConfigService;
    private final r3 l;
    private final e.a.a.a.b.b.w m;
    /* renamed from: n, reason: from kotlin metadata */
    private final m3 shouldShowWorkoutUnlockedInteractor;
    /* renamed from: o, reason: from kotlin metadata */
    private final h2 specialOfferInteractor;
    /* renamed from: p, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.r2 subscribeInteractor;
    /* renamed from: q, reason: from kotlin metadata */
    private final s3 tick;
    /* renamed from: r, reason: from kotlin metadata */
    private final q2 timeInteractor;
    /* renamed from: s, reason: from kotlin metadata */
    private final f3 timeUtils;
    private final y1 t;
    /* renamed from: u, reason: from kotlin metadata */
    private final j2 timerDisposable;
    /* renamed from: v, reason: from kotlin metadata */
    private final x2 tracker;
    /* renamed from: w, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.a.q3 userRepository;
    private final kotlinx.coroutines.h0 x;
    /* renamed from: y, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.util.j0.a workoutSessionInteractor;
    /* renamed from: z, reason: from kotlin metadata */
    private final androidx.lifecycle.x<y<Dashboard>> zendeskInteractor;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DashboardProgram_CardType.values().length];
            iArr[DashboardProgram_CardType.RECOMMENDED_PROGRAM.ordinal()] = 1;
            iArr[DashboardProgram_CardType.RECOMMENDED_PROGRAM_V2.ordinal()] = 2;
            iArr[DashboardProgram_CardType.LESSON.ordinal()] = 3;
            iArr[DashboardProgram_CardType.PROGRAM_COMPLETED.ordinal()] = 4;
            iArr[DashboardProgram_CardType.QUESTIONNAIRE.ordinal()] = 5;
            kotlinx.coroutines.r.a.a = iArr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dashboard.DashboardViewModel", f = "DashboardViewModel.kt", l = {376, 377, 397}, m = "setupProgramItem")
    static final class c extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super r.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return r.this.T(0, this);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ r a;
        public d(CoroutineExceptionHandler.a exc, r rVar) {
            this.a = rVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.zendeskInteractor.postValue(new LoadResult_Error(exception));
            this.a.errorEvent = Long.valueOf(0L);
            this.a.O();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            r.this.getDashboardExamCardInteractor.postValue(th.getMessage());
        }

        e() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends kotlin.d0.d.p implements kotlin.d0.c.a<kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            r.this.getTimer().postValue(new CouponTimer(0L, r3));
            r.this.getDiscountVisible().postValue(Boolean.FALSE);
        }

        f() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.l<Long, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Long long) {
            r.this.getTimer().postValue(new CouponTimer((long.longValue() - r.this.E.incrementAndGet()) * (long)1000, r1));
        }

        g() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dashboard.DashboardViewModel$loadList$1", f = "DashboardViewModel.kt", l = {107, 135, 136, 137, 145, 147}, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super kotlin.w>, Object> {

        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        private static final WorkoutSession e(String str, Throwable th) {
            a.d(th);
            WorkoutSession th22 = new WorkoutSession(str, null, 0, 0, false, false, 0L, i7, 126, 0);
            return th22;
        }

        private static final WorkoutSession f(r rVar, WorkoutSession workoutSession) {
            n.e(workoutSession, "it");
            return rVar.l.L(workoutSession);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) throws InvalidParameterException {
            int condition2;
            Object object2;
            ProgramLessonItem lessonItem;
            int i = 0;
            int i2 = 0;
            WorkoutSession workoutSession;
            Object blockingGet;
            CouponDiscount couponDiscount;
            Object blockingGet3;
            Object obj6;
            RecentlyViewedTricks recentlyViewedTricks;
            boolean z = false;
            ProgramLessonItem lessonItem2;
            Object blockingGet5;
            Object blockingGet4;
            String programId = null;
            String lessonId = null;
            Long endTimeMs = null;
            Object obj9;
            int i4 = 0;
            Object obj10;
            java.util.List list;
            Object blockingGet2;
            Object obj11;
            java.util.List list2;
            Object obj12;
            String str;
            Integer num = null;
            boolean object4 = true;
            Object obj;
            boolean streaksEnabled;
            boolean object3;
            CouponDiscount couponDiscount2;
            Boolean bool2;
            Boolean bool3;
            boolean z2 = false;
            WorkoutSession workoutSession2;
            RecentlyViewedTricks recentlyViewedTricks2;
            Dashboard.PottyProgramCard pottyProgramCard;
            app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard bitingProgramCard;
            app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics;
            final Object object5 = this;
            obj = b.d();
            int i9 = 2;
            String str8 = "dashboard";
            switch (object5.label) {
                case 0:
                    q.b(object);
                    DashboardViewModel.y(object5.this$0).postValue(LoadResult_Loading.a);
                    DashboardViewModel.u(object5.this$0).setTrainingReminderUserProperties(str8);
                    DashboardViewModel.y(object5.this$0).postValue(new LoadResult_Error(new UnknownHostException()));
                    DashboardViewModel.v(object5.this$0).d0().e();
                    int i3 = 1;
                    object5.label = 1;
                    return obj;
                case 1:
                    q.b(object);
                    object2 = object;
                    break;
                case 2:
                    q.b(object);
                    object2 = object;
                    num = null;
                    recentlyViewedTricks = new RecentlyViewedTricks((List)(ist)list2, num, i9, num);
                    object5.L$0 = obj11;
                    object5.L$1 = blockingGet2;
                    object5.L$2 = blockingGet5;
                    object5.L$3 = obj9;
                    object5.L$4 = blockingGet4;
                    object5.L$5 = object2;
                    object5.L$6 = blockingGet3;
                    object5.L$7 = blockingGet;
                    object5.L$8 = recentlyViewedTricks;
                    object5.I$0 = i2;
                    object5.label = 3;
                    return obj;
                case 3:
                    q.b(object);
                    int i16 = 0;
                    object2 = object;
                    object5.L$0 = obj11;
                    object5.L$1 = blockingGet2;
                    object5.L$2 = blockingGet5;
                    object5.L$3 = obj9;
                    object5.L$4 = blockingGet4;
                    object5.L$5 = object2;
                    object5.L$6 = blockingGet3;
                    object5.L$7 = blockingGet;
                    object5.L$8 = recentlyViewedTricks;
                    object5.L$9 = (Dashboard_PottyProgramCard)(Dashboard_PottyProgramCard)object2;
                    object5.I$0 = i2;
                    int i6 = 4;
                    object5.label = 4;
                    return obj;
                case 4:
                    q.b(object);
                    object2 = object;
                    int i5 = 0;
                    object4 = DashboardViewModel.trackPottyTrackerCardTapped(object5.this$0).S();
                    list = DashboardViewModel.trackPottyTrackerCardTapped(object5.this$0).m();
                    i = 0;
                    object4 = true;
                    i = 1;
                    n.e(blockingGet4, "correctedWorkoutSession");
                    object5.this$0.trackRecentlyViewedTrickClicked(blockingGet4);
                    object5.L$0 = obj11;
                    object5.L$1 = blockingGet2;
                    object5.L$2 = blockingGet5;
                    object5.L$3 = obj9;
                    object5.L$4 = blockingGet4;
                    object5.L$5 = object2;
                    object5.L$6 = blockingGet3;
                    object5.L$7 = blockingGet;
                    object5.L$8 = obj6;
                    object5.L$9 = object2;
                    object5.L$10 = object2;
                    object5.L$11 = list;
                    object5.I$0 = i2;
                    object5.Z$0 = object4;
                    object5.Z$1 = object3;
                    object5.Z$2 = DashboardViewModel.trackPottyTrackerCardTapped(object5.this$0).T();
                    object5.label = 5;
                    return obj;
                case 5:
                    q.b(object);
                    object2 = object;
                    object5.L$0 = str;
                    object5.L$1 = blockingGet2;
                    object5.L$2 = blockingGet5;
                    object5.L$3 = obj9;
                    object5.L$4 = blockingGet4;
                    object5.L$5 = object2;
                    object5.L$6 = blockingGet3;
                    object5.L$7 = blockingGet;
                    object5.L$8 = obj6;
                    object5.L$9 = object2;
                    object5.L$10 = object2;
                    object5.L$11 = list;
                    object5.L$12 = object2;
                    object5.I$0 = i2;
                    object5.Z$0 = object4;
                    object5.Z$1 = object3;
                    object5.Z$2 = streaksEnabled;
                    object5.label = 6;
                    return obj;
                case 6:
                    q.b(object);
                    object2 = object;
                    int i18 = 1;
                    int i17 = 0;
                    n.e(object2, "showWorkoutUnlocked");
                    n.e(blockingGet3, "updatedZendeskMessageCount");
                    n.e(blockingGet, "hasZendeskHistory");
                    Dashboard dashboard = new Dashboard(str, LocaleService.a.a(DashboardViewModel.trackLessonNextStart(object5.this$0).W()), object2, couponDiscount2, bool2, bool3, z2, object5.this$0.booleanValue(), workoutSession2, object5.this$0.intValue(), object5.this$0.booleanValue(), object4, list, streaksEnabled, recentlyViewedTricks2, pottyProgramCard, bitingProgramCard, trainingTimeMetrics, object3, pottyProgramCard.getProgramProgress().fillPottyCheckmarksList());
                    lessonItem2 = object2.getLessonItem();
                    int i14 = 0;
                    Object programSaveInfo2 = lessonItem2.getProgramSaveInfo();
                    programId = programSaveInfo2.getProgramId();
                    DashboardViewModel.u(object5.this$0).setUserProperty(UserProperty.CurrentProgramId, programId);
                    lessonItem = object2.getLessonItem();
                    int i13 = 0;
                    Object programSaveInfo = lessonItem.getProgramSaveInfo();
                    lessonId = programSaveInfo.getLessonId();
                    DashboardViewModel.u(object5.this$0).setUserProperty(UserProperty.CurrentLessonId, lessonId);
                    DashboardViewModel.y(object5.this$0).postValue(new LoadResult_Success(dashboard));
                    couponDiscount = dashboard.getCouponDiscount();
                    int i12 = 0;
                    endTimeMs = couponDiscount.getEndTimeMs();
                    object5.this$0.errorEvent = endTimeMs;
                    object5.this$0.t0(dashboard);
                    object5.this$0.O();
                    workoutSession = dashboard.getWorkoutSession();
                    int i10 = 0;
                    couponDiscount = 1;
                    object5.this$0.I().postValue(b.a(object5.L$6));
                    return w.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            java.lang.CharSequence charSequence = object2;
            if (l.z(charSequence)) {
                throw new InvalidParameterException("Dog Id is Empty");
            } else {
                Object blockingGet7 = object5.this$0.g.o().blockingGet();
                n.e(blockingGet7, "subscribeInteractor.revenueCatShowResubscribe().blockingGet()");
                if (blockingGet7.booleanValue()) {
                    int r2 = !object5.this$0.programRepository.n() ? 1 : 0;
                }
                String str11 = null;
                if (!blockingGet2.booleanValue() || object5.Z$1 != 0) {
                }
                object5.this$0.lessonItemHelper.g(charSequence, str8);
                object5.L$0 = charSequence;
                object5.L$1 = blockingGet2;
                object5.L$2 = (Boolean)IsDogPremiumInteractor.b(DashboardViewModel.saveTemporaryRecentTricksScrollPosition(object5.this$0), str11, 1, str11).blockingGet();
                object5.L$3 = i4;
                object5.L$4 = (WorkoutSession)blockingGet4;
                object5.L$5 = (Boolean)object2;
                object5.L$6 = (Integer)blockingGet3;
                object5.L$7 = (Boolean)object5.this$0.tick.j().blockingGet();
                object5.I$0 = i2;
                object5.label = i9;
                if (object5.this$0.timeInteractor.e(object5) == object5.this$0) {
                    return obj;
                }
            }
        }

        b(kotlin.b0.d<? super r.b> dVar) {
            super(2, dVar);
        }

        public static /* synthetic */ WorkoutSession m(String str, Throwable th) {
            return kotlinx.coroutines.r.b.e(str, th);
        }

        public static /* synthetic */ WorkoutSession n(r rVar, WorkoutSession workoutSession) {
            return kotlinx.coroutines.r.b.f(rVar, workoutSession);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super kotlin.w> dVar) {
            return (kotlinx.coroutines.r.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<kotlin.w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.r.b(r.this, dVar);
        }
    }
    public /* synthetic */ r(o3 o3Var, app.dogo.com.dogo_android.s.b.j1 j1Var, l2 l2Var, k2 k2Var, z2 z2Var, p1 p1Var, n3 n3Var, d3 d3Var, app.dogo.com.dogo_android.service.v2 v2Var, p2 p2Var, l3 l3Var, r3 r3Var, e.a.a.a.b.b.w wVar, m3 m3Var, h2 h2Var, app.dogo.com.dogo_android.service.r2 r2Var, s3 s3Var, q2 q2Var, f3 f3Var, y1 y1Var, j2 j2Var, x2 x2Var, app.dogo.com.dogo_android.s.a.q3 q3Var, kotlinx.coroutines.h0 h0Var, app.dogo.com.dogo_android.util.j0.a aVar, int i, kotlin.d0.d.g gVar) {
        kotlinx.coroutines.h0 h0Var242;
        app.dogo.com.dogo_android.util.j0.a aVar252;
        h0Var242 = i & 8388608 != 0 ? h0Var242 : h0Var;
        i = i & (0x01000000 /* Unknown resource */);
        LessonItemHelper r26 = i & 0x01000000 /* Unknown resource */ != 0 ? new essonItemHelper() : aVar;
        this(o3Var, j1Var, l2Var, k2Var, z2Var, p1Var, n3Var, d3Var, v2Var, p2Var, l3Var, r3Var, wVar, m3Var, h2Var, r2Var, s3Var, q2Var, f3Var, y1Var, j2Var, x2Var, q3Var, h0Var242, (i & 0x01000000 /* Unknown resource */ != 0 ? new essonItemHelper() : aVar));
    }

    public static final /* synthetic */ Object A(r rVar, String str, kotlin.b0.d dVar) {
        return rVar.T(str, dVar);
    }

    public static final /* synthetic */ void B(r rVar, WorkoutSession workoutSession) {
        rVar.trackRecentlyViewedTrickClicked(workoutSession);
    }

    public static final /* synthetic */ void C(r rVar, Dashboard dashboard) {
        rVar.t0(dashboard);
    }

    /* renamed from: L, reason: from kotlin metadata */
    private final boolean getHasZendeskHistoryData() {
        return this.subscribeInteractor.T();
    }

    private final Object T(String str, kotlin.b0.d<? super DashboardProgram> dVar) throws NoWhenBranchMatchedException {
        Object result2;
        DashboardProgram dashboardProgram;
        Object dVar22;
        app.dogo.com.dogo_android.g.r rVar;
        int label2;
        int i;
        int i2 = -2147483648;
        String str4;
        int i3;
        k.b component1;
        DashboardProgram.CardType cardType;
        Iterator it;
        app.dogo.externalmodel.model.responses.ProgramProgress programProgress = null;
        String str5;
        rVar = this;
        dVar22 = dVar;
        z = dVar22 instanceof kotlinx.coroutines.r.c;
        if (dVar22 instanceof kotlinx.coroutines.r.c) {
            i2 = Integer.MIN_VALUE;
            i3 = label2 & i2;
            if (label2 & i2 != 0) {
                dVar22.label -= i2;
            } else {
                app.dogo.com.dogo_android.g.r.c cVar = new kotlinx.coroutines.r.c(rVar, dVar22);
            }
        }
        Object obj5 = b.d();
        int i4 = 3;
        int i5 = 2;
        int i6 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i6) {
                if (dVar22.label != i5) {
                    if (dVar22.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar22.result);
                        int i11 = kotlinx.coroutines.r.a.a[cardType.ordinal()];
                        if (dVar22.result == i6 || dVar22.result == i5) {
                            ProgramLessonItem programLessonItem = null;
                            ProgramDescriptionItem.State state = null;
                            boolean z3 = false;
                            boolean z4 = false;
                            int i9 = 26;
                            Object obj4 = null;
                            app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = null;
                            app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary = null;
                            int i7 = 13;
                            kotlin.d0.d.g gVar = null;
                            dashboardProgram = new DashboardProgram(programLessonItem, app.dogo.com.dogo_android.util.extensionfunction.j1.c(i.a(), ProgramDescriptionItem_State.RECOMMENDED_BIG, state, rVar.subscribeInteractor.d0(), z3, z4, (Number)result2.intValue(), rVar.tracker.a(i.a()), i9, obj4), programExamSummary, programCompletionSummary, cardType, i7, gVar);
                        } else {
                            if (dVar22.result != i4) {
                                if (dVar22.result != 4 && dVar22.result == 5) {
                                    dashboardProgram = new DashboardProgram(null, null, null, null, DashboardProgram_CardType.QUESTIONNAIRE, 15, null);
                                }
                                n.d(component1);
                                int i8 = 62;
                                app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary2 = null;
                                int i10 = 9;
                                kotlin.d0.d.g gVar2 = null;
                                dashboardProgram = new DashboardProgram(null, app.dogo.com.dogo_android.util.extensionfunction.j1.c(component1.a(), ProgramDescriptionItem_State.RECOMMENDED_BIG, null, false, false, false, 0, rVar.tracker.a(component1.a()), i8, null), rVar.getRecommendedProgramRequestInteractor.b(str4, component1.a(), component1.c(), ""), programCompletionSummary2, DashboardProgram_CardType.PROGRAM_COMPLETED, i10, gVar2);
                            } else {
                                n.d(component1);
                                ProgramLessonItem lessonItem = rVar.workoutSessionInteractor.generateLessonItem(component1, str4, null, true);
                                dashboardProgram = new DashboardProgram(lessonItem, null, rVar.getRecommendedProgramRequestInteractor.b(str4, component1.a(), component1.c(), lessonItem.getProgramSaveInfo().getLessonId()), app.dogo.com.dogo_android.util.extensionfunction.j1.H(component1.a(), component1.c(), lessonItem.getProgramSaveInfo().getLessonId(), rVar.getLibraryTrickListInteractor), DashboardProgram_CardType.LESSON, 2, null);
                            }
                        }
                        return dashboardProgram;
                    }
                }
                q.b(dVar22.result);
            } else {
                q.b(dVar22.result);
                dVar22.L$0 = rVar;
                dVar22.L$1 = str4;
                dVar22.L$2 = result2;
                dVar22.label = i5;
                result2 = rVar.getLibraryTrickListInteractor.o(str4, dVar22);
                if (result2 == obj5) {
                    return obj5;
                }
            }
        } else {
            q.b(dVar22.result);
            dVar22.L$0 = rVar;
            dVar22.L$1 = str;
            dVar22.label = i6;
            if (rVar.e.d(dVar22) == obj5) {
                return obj5;
            }
        }
        component1 = result2.component1();
        if (component1 == null) {
            int i16 = 0;
        } else {
            programProgress = component1.c();
        }
        cardType = rVar.getProgramOverviewInteractor.a(programProgress, result2.isSurveyAnswered());
        it = result2.d().values().iterator();
        while (it.hasNext()) {
            if (b.a(n.b((DogoProgram_ClassicProgram)item.a().getId(), result2.getRecommendedProgramId())).booleanValue()) {
                break;
            }
        }
        i = 0;
        if ((DogoProgram_ClassicProgram)i == 0) {
            result2 = p.W(result2.d().values());
            StringBuilder stringBuilder = new StringBuilder();
            String str11 = "Could not find recommended program ";
            String recommendedProgramId = result2.getRecommendedProgramId();
            String str8 = ", Defaulting to ";
            String str9 = result2.b();
            str10 = str11 + recommendedProgramId + str8 + str9;
            a.d(new IllegalStateException(str10));
        }
        dVar22.L$0 = rVar;
        dVar22.L$1 = str4;
        dVar22.L$2 = component1;
        dVar22.L$3 = cardType;
        dVar22.L$4 = i;
        dVar22.label = i4;
        if (rVar.e.b(i.a().getId(), dVar22) == obj5) {
            return obj5;
        }
    }

    /* renamed from: W, reason: from kotlin metadata */
    private final void didDogIdChange(long newDogId) {
        i.b.h repeatUntil = RxJavaDogo.INSTANCE.timerWithStart(newDogId).repeatUntil(new kotlinx.coroutines.h(this, newDogId, r4));
        n.e(repeatUntil, "RxJavaDogo.timerWithStart(durationInSeconds)\n            .repeatUntil { tick.get() >= durationInSeconds }");
        i.b.j0.b bVar = a.e(repeatUntil, new kotlinx.coroutines.r.e(this), new kotlinx.coroutines.r.f(this), new kotlinx.coroutines.r.g(this));
        this.dogPremiumInteractor = bVar;
        if (bVar != null) {
            getDisposable().b(bVar);
        }
    }

    private static final boolean X(r rVar, long j) {
        boolean z = true;
        n.f(rVar, "this$0");
        long l = rVar.E.get();
        rVar = l >= j ? 1 : 0;
        return (l >= j ? 1 : 0);
    }

    private final long getRemainingCouponDurationMs(Long endTimeMs) {
        int i = 0;
        if (endTimeMs == null) {
            i = 0;
        } else {
            long value = endTimeMs.longValue();
        }
        return i - this.preferenceService.g();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ y1 getWorkoutUnlockSourceBlocking(r dogId) {
        return dogId.t;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ j2 isDiscountStillValid(r endTimeMs) {
        return endTimeMs.timerDisposable;
    }

    private final boolean isDiscountStillValid(Long long) {
        int i = 0;
        boolean z = false;
        long l = this.preferenceService.g();
        if (long == null) {
            i = 0;
        } else {
            long value = long.longValue();
        }
        long = l < i ? 1 : 0;
        return (l < i ? 1 : 0);
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ d3 saveTemporaryRecentTricksScrollPosition(r position) {
        return position.pottyProgramCardInteractor;
    }

    /* renamed from: k, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ f.d.a.a setupProgramItem(r dogId) {
        return dogId.getDashboardExamCardInteractor;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static final /* synthetic */ q2 startTimer(r durationInSeconds) {
        return durationInSeconds.timeInteractor;
    }

    /* renamed from: m, reason: from kotlin metadata */
    public static final /* synthetic */ f3 trackExplorePrograms(r source) {
        return source.timeUtils;
    }

    /* renamed from: n, reason: from kotlin metadata */
    public static final /* synthetic */ p2 trackLessonNextStart(r lessonId) {
        return lessonId.programRepository;
    }

    /* renamed from: o, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.service.r2 trackPottyTrackerCardTapped(r action) {
        return action.subscribeInteractor;
    }

    /* renamed from: o0, reason: from kotlin metadata */
    private final void trackRecentlyViewedTrickClicked(WorkoutSession trickId) {
        this.getDashboardProgramCardTypeInteractor.setUserProperty(UserProperty.CurrentStreak, Integer.valueOf(trickId.getCurrentStreak()));
        this.getDashboardProgramCardTypeInteractor.setUserProperty(UserProperty.LongestStreak, Integer.valueOf(trickId.getLongestStreak()));
        this.getDashboardProgramCardTypeInteractor.setUserProperty(UserProperty.LastWorkoutTime, Long.valueOf(trickId.getLastAchievedStreakTimestampMs()));
    }

    /* renamed from: p, reason: from kotlin metadata */
    public static final /* synthetic */ l3 trackSpecialProgramClicked(r type) {
        return type.remoteConfigService;
    }

    /* renamed from: q, reason: from kotlin metadata */
    public static final /* synthetic */ m3 trackUserWorkoutProperties(r workoutSession) {
        return workoutSession.shouldShowWorkoutUnlockedInteractor;
    }

    /* renamed from: r, reason: from kotlin metadata */
    public static final /* synthetic */ n3 triggerWorkoutUnlockIfNeeded(r dashboard) {
        return dashboard.g;
    }

    public static final /* synthetic */ AtomicLong s(r rVar) {
        return rVar.E;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.s.a.q3 t(r rVar) {
        return rVar.userRepository;
    }

    private final void t0(Dashboard dashboard) {
        if (dashboard.getShowWorkoutUnlocked()) {
            this.bitingProgramCardInteractor.postValue(dashboard.getDogId());
        }
    }

    public static final /* synthetic */ o3 u(r rVar) {
        return rVar.getDashboardProgramCardTypeInteractor;
    }

    public static final /* synthetic */ p1 v(r rVar) {
        return rVar.lessonItemHelper;
    }

    public static final /* synthetic */ r3 w(r rVar) {
        return rVar.l;
    }

    public static final /* synthetic */ s3 x(r rVar) {
        return rVar.tick;
    }

    public static final /* synthetic */ androidx.lifecycle.x y(r rVar) {
        return rVar.zendeskInteractor;
    }

    public static final /* synthetic */ void z(r rVar, Long long) {
        rVar.errorEvent = long;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean D(String str) {
        n.f(str, "newDogId");
        Object value = this.zendeskInteractor.getValue();
        if (value instanceof LoadResult_Success) {
            return !(n.b((Dashboard)value.component1().getDogId(), str));
        }
        return value instanceof LoadResult_Error;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean E() {
        int i = 0;
        boolean hasZendeskHistory = false;
        LoadResult_Success r0 = this.zendeskInteractor.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.zendeskInteractor.getValue() : 0;
        int i2 = 0;
        if (this.zendeskInteractor != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                hasZendeskHistory = component1.getHasZendeskHistory();
            }
        }
        return hasZendeskHistory;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<Dashboard>> F() {
        return this.authService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean G() {
        return this.lessonItemHelper.F();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<String> H() {
        return this.bitingProgramCardInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> I() {
        return this.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String J(String str) {
        Object blockingGet;
        n.f(str, "dogId");
        blockingGet = this.m.getDogLocalEntityOrEmpty(str).blockingGet();
        n.e(blockingGet, "source");
        if (!l.z(blockingGet) == 0) {
            String str4 = "dashboard";
        }
        return blockingGet;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int K() {
        int i = 0;
        int updatedZendeskMessageCount = 0;
        LoadResult_Success r0 = this.zendeskInteractor.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.zendeskInteractor.getValue() : 0;
        updatedZendeskMessageCount = 0;
        if (this.zendeskInteractor != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                updatedZendeskMessageCount = component1.getUpdatedZendeskMessageCount();
            }
        }
        return updatedZendeskMessageCount;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void N() {
        kotlin.b0.d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.x.plus(this.couponEndTimeMs), dVar, new kotlinx.coroutines.r.b(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void O() {
        if (this.dogPremiumInteractor != null) {
            this.dogPremiumInteractor.dispose();
        }
        boolean discountStillValid = isDiscountStillValid(this.errorEvent);
        if (discountStillValid) {
            long remainingCouponDurationMs = getRemainingCouponDurationMs(this.errorEvent);
            getDiscountVisible().postValue(Boolean.TRUE);
            getTimer().postValue(new CouponTimer(remainingCouponDurationMs, discountStillValid));
            long l2 = 0L;
            this.E.set(l2);
            l = (long)1000;
            didDogIdChange(remainingCouponDurationMs / l);
        } else {
            getDiscountVisible().postValue(Boolean.FALSE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void P(int i) {
        int i2;
        RecentlyViewedTricks copy$default2 = null;
        final Object i6 = this;
        java.util.List list3 = null;
        LoadResult_Success r1 = (LoadResult)i6.zendeskInteractor.getValue() instanceof LoadResult_Success ? (oadResult_Success)i6.zendeskInteractor.getValue() : list3;
        if (i6.zendeskInteractor != 0) {
            dashboard = i2.component1();
            if (dashboard != null) {
                RecentlyViewedTricks recentlyViewed = dashboard.getRecentlyViewed();
                if (recentlyViewed != null) {
                    int i3 = 1;
                    copy$default2 = RecentlyViewedTricks.copy$default(recentlyViewed, list3, Integer.valueOf(i), i3, list3);
                }
                String str = null;
                String str2 = null;
                DashboardProgram dashboardProgram = null;
                CouponDiscount couponDiscount = null;
                Boolean bool = null;
                Boolean bool2 = null;
                boolean z = false;
                boolean z2 = false;
                WorkoutSession workoutSession = null;
                int i4 = 0;
                boolean z3 = false;
                boolean z4 = false;
                java.util.List list = null;
                boolean z5 = false;
                Dashboard.PottyProgramCard pottyProgramCard = null;
                app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard bitingProgramCard = null;
                app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics = null;
                boolean z6 = false;
                java.util.List list2 = null;
                int i5 = 1032191;
                Object obj = null;
                i6.zendeskInteractor.setValue(new LoadResult_Success(Dashboard.copy$default(dashboard, str, str2, dashboardProgram, couponDiscount, bool, bool2, z, z2, workoutSession, i4, z3, z4, list, z5, copy$default2, pottyProgramCard, bitingProgramCard, trainingTimeMetrics, z6, list2, i5, obj)));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Q() {
        this.programRepository.w0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void R() {
        this.programRepository.B0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void S() {
        this.lessonItemHelper.m0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Boolean U() {
        int i;
        Boolean userPremium;
        i = 0;
        LoadResult_Success r0 = this.zendeskInteractor.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.zendeskInteractor.getValue() : i;
        r0 = i;
        if (!this.getHasZendeskHistoryData()) {
            Boolean fALSE2 = Boolean.FALSE;
        } else {
            if (this.zendeskInteractor != null) {
                Boolean str = Boolean.valueOf(!userPremium.booleanValue());
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean V() {
        boolean z2 = true;
        if (!this.specialOfferInteractor.D()) {
            if (!this.programRepository.i()) {
                int r0 = this.programRepository.O() ? 1 : 0;
            }
        }
        return (this.programRepository.O() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean Y() {
        int i = !this.programRepository.l0();
        this.programRepository.u1(i);
        return false /* type inference gap: i */;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Z() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.s.c(new EP_ViewSource(), "dashboard"));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void a0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_General.n.c(new EP_ViewSource(), "dashboard_navigation_bar"));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void b0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.e);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void c0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.h);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void d0(String str) {
        n.f(str, "source");
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.b.c(new EP_ViewSource(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void e0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.d);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void f0(String str) {
        n.f(str, "lessonId");
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.c.c(new EP_LessonId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void g0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.t.withParameters(u.a(new EP_Type(), "time_metric")));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<Boolean> getDiscountVisible() {
        return this.dogLocalEntityDao;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<CouponTimer> getTimer() {
        return this.dispatcher;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.p);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i0(String str) {
        n.f(str, "action");
        this.getDashboardProgramCardTypeInteractor.logEvent(E_PottyProgram.e.withParameters(u.a(new EP_Action(), str)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j0(String str) {
        n.f(str, "trickId");
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.q.c(new EP_TrickId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.a.c(new EP_ViewSource(), "dashboard"));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m0(String str) {
        n.f(str, "type");
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.r.c(new EP_ViewSource(), "dashboard", new EP_Type(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.n);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.l);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.k);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s0() {
        this.getDashboardProgramCardTypeInteractor.logEvent(E_Dashboard.m);
    }

    public r(o3 o3Var, app.dogo.com.dogo_android.s.b.j1 j1Var, l2 l2Var, k2 k2Var, z2 z2Var, p1 p1Var, n3 n3Var, d3 d3Var, app.dogo.com.dogo_android.service.v2 v2Var, p2 p2Var, l3 l3Var, r3 r3Var, e.a.a.a.b.b.w wVar, m3 m3Var, h2 h2Var, app.dogo.com.dogo_android.service.r2 r2Var, s3 s3Var, q2 q2Var, f3 f3Var, y1 y1Var, j2 j2Var, x2 x2Var, app.dogo.com.dogo_android.s.a.q3 q3Var, kotlinx.coroutines.h0 h0Var, app.dogo.com.dogo_android.util.j0.a aVar) {
        Object o3Var2 = o3Var;
        Object j1Var22 = j1Var;
        final Object l2Var32 = l2Var;
        final Object k2Var42 = k2Var;
        final Object z2Var52 = z2Var;
        final Object p1Var62 = p1Var;
        final Object n3Var72 = n3Var;
        final Object d3Var82 = d3Var;
        final Object v2Var92 = v2Var;
        final Object p2Var102 = p2Var;
        final Object l3Var112 = l3Var;
        final Object r3Var122 = r3Var;
        final Object wVar132 = wVar;
        final Object m3Var142 = m3Var;
        n.f(o3Var2, "tracker");
        n.f(j1Var22, "programRepository");
        n.f(l2Var32, "getDashboardProgramCardTypeInteractor");
        n.f(k2Var42, "getDashboardExamCardInteractor");
        n.f(z2Var52, "getRecommendedProgramRequestInteractor");
        n.f(p1Var62, "userRepository");
        n.f(n3Var72, "subscribeInteractor");
        n.f(d3Var82, "dogPremiumInteractor");
        n.f(v2Var92, "timeUtils");
        n.f(p2Var102, "preferenceService");
        n.f(l3Var112, "shouldShowWorkoutUnlockedInteractor");
        n.f(r3Var122, "workoutSessionInteractor");
        n.f(wVar132, "dogLocalEntityDao");
        n.f(m3Var142, "specialOfferInteractor");
        n.f(h2Var, "authService");
        n.f(r2Var, "remoteConfigService");
        n.f(s3Var, "zendeskInteractor");
        n.f(q2Var, "getLibraryTrickListInteractor");
        n.f(f3Var, "pottyProgramCardInteractor");
        n.f(y1Var, "bitingProgramCardInteractor");
        n.f(j2Var, "connectivityService");
        n.f(x2Var, "getProgramOverviewInteractor");
        n.f(q3Var, "timeInteractor");
        n.f(h0Var, "dispatcher");
        n.f(aVar, "lessonItemHelper");
        super();
        Object o3Var3 = this;
        o3Var3.getDashboardProgramCardTypeInteractor = o3Var2;
        o3Var3.getLibraryTrickListInteractor = j1Var22;
        o3Var3.getProgramOverviewInteractor = l2Var32;
        o3Var3.getRecommendedProgramRequestInteractor = k2Var42;
        o3Var3.e = z2Var52;
        o3Var3.lessonItemHelper = p1Var62;
        o3Var3.g = n3Var72;
        o3Var3.pottyProgramCardInteractor = d3Var82;
        o3Var3.preferenceService = v2Var92;
        o3Var3.programRepository = p2Var102;
        o3Var3.remoteConfigService = l3Var112;
        o3Var3.l = r3Var122;
        o3Var3.m = wVar132;
        o3Var3.shouldShowWorkoutUnlockedInteractor = m3Var142;
        o3Var3.specialOfferInteractor = h2Var;
        o3Var3.subscribeInteractor = r2Var;
        o3Var3.tick = s3Var;
        o3Var3.timeInteractor = q2Var;
        o3Var3.timeUtils = f3Var;
        o3Var3.t = y1Var;
        o3Var3.timerDisposable = j2Var;
        o3Var3.tracker = x2Var;
        o3Var3.userRepository = q3Var;
        o3Var3.x = h0Var;
        o3Var3.workoutSessionInteractor = aVar;
        androidx.lifecycle.x xVar = new x();
        o3Var3.zendeskInteractor = xVar;
        o3Var3.authService = xVar;
        o3Var3.bitingProgramCardInteractor = new a();
        o3Var3.connectivityService = new a();
        o3Var3.couponEndTimeMs = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, o3Var3);
        o3Var3.E = new AtomicLong(0L, l2Var32);
        o3Var3.dispatcher = new x();
        o3Var3.dogLocalEntityDao = new x(Boolean.FALSE);
        o3Var3.getDashboardExamCardInteractor = new a();
    }

    public static /* synthetic */ boolean M(r rVar, long j) {
        return DashboardViewModel.X(rVar, j);
    }
}
