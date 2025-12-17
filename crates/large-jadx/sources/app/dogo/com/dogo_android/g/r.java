package app.dogo.com.dogo_android.g;

import android.app.ActivityManager.ProcessErrorStateInfo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
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
import app.dogo.com.dogo_android.s.a.q3;
import app.dogo.com.dogo_android.s.a.r3;
import app.dogo.com.dogo_android.s.a.s3;
import app.dogo.com.dogo_android.s.a.x2;
import app.dogo.com.dogo_android.s.a.y1;
import app.dogo.com.dogo_android.s.a.z2;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.subscription.benefits.RxJavaDogo;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.j0.a;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.h0;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.s0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.v2;
import app.dogo.com.dogo_android.w.w1;
import app.dogo.com.dogo_android.w.x;
import app.dogo.com.dogo_android.y.i;
import app.dogo.com.dogo_android.y.k;
import app.dogo.com.dogo_android.y.k.b;
import e.a.a.a.b.b.w;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.j0.a;
import i.b.j0.b;
import i.b.r0.a;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001BÑ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\u0008\u0008\u0002\u00100\u001a\u000201\u0012\u0008\u0008\u0002\u00102\u001a\u000203¢\u0006\u0002\u00104J\u000e\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020BJ\u0006\u0010[\u001a\u00020=J\u0017\u0010\\\u001a\u00020:2\u0008\u0010]\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0002\u0010^J\u0006\u0010_\u001a\u00020=J\u000e\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020BJ\u0006\u0010b\u001a\u00020cJ\u0008\u0010d\u001a\u00020=H\u0002J\u0017\u0010e\u001a\u00020=2\u0008\u0010]\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0002\u0010fJ\u0006\u0010g\u001a\u00020hJ\u0006\u0010i\u001a\u00020hJ\u0006\u0010j\u001a\u00020hJ\u000e\u0010k\u001a\u00020h2\u0006\u0010l\u001a\u00020cJ\u0006\u0010m\u001a\u00020hJ\u0006\u0010n\u001a\u00020hJ\u0006\u0010o\u001a\u00020hJ\u0019\u0010p\u001a\u00020q2\u0006\u0010a\u001a\u00020BH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010rJ\r\u0010s\u001a\u0004\u0018\u00010=¢\u0006\u0002\u0010tJ\u0006\u0010u\u001a\u00020=J\u0010\u0010v\u001a\u00020h2\u0006\u0010w\u001a\u00020:H\u0002J\u0006\u0010x\u001a\u00020=J\u0006\u0010y\u001a\u00020hJ\u0006\u0010z\u001a\u00020hJ\u0006\u0010{\u001a\u00020hJ\u0006\u0010|\u001a\u00020hJ\u000e\u0010}\u001a\u00020h2\u0006\u0010~\u001a\u00020BJ\u0006\u0010\u007f\u001a\u00020hJ\u0007\u0010\u0080\u0001\u001a\u00020hJ\u0010\u0010\u0081\u0001\u001a\u00020h2\u0007\u0010\u0082\u0001\u001a\u00020BJ\u0007\u0010\u0083\u0001\u001a\u00020hJ\u0007\u0010\u0084\u0001\u001a\u00020hJ\u0007\u0010\u0085\u0001\u001a\u00020hJ\u0010\u0010\u0086\u0001\u001a\u00020h2\u0007\u0010\u0087\u0001\u001a\u00020BJ\u0010\u0010\u0088\u0001\u001a\u00020h2\u0007\u0010\u0089\u0001\u001a\u00020BJ\u0007\u0010\u008a\u0001\u001a\u00020hJ\u0007\u0010\u008b\u0001\u001a\u00020hJ\u0010\u0010\u008c\u0001\u001a\u00020h2\u0007\u0010\u008d\u0001\u001a\u00020BJ\u0007\u0010\u008e\u0001\u001a\u00020hJ\u0013\u0010\u008f\u0001\u001a\u00020h2\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0002J\u0007\u0010\u0092\u0001\u001a\u00020hJ\u0007\u0010\u0093\u0001\u001a\u00020hJ\u0007\u0010\u0094\u0001\u001a\u00020hJ\u0007\u0010\u0095\u0001\u001a\u00020hJ\u0012\u0010\u0096\u0001\u001a\u00020h2\u0007\u0010\u0097\u0001\u001a\u000208H\u0002R\u001a\u00105\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002080706X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0004\n\u0002\u0010;R\u0017\u0010<\u001a\u0008\u0012\u0004\u0012\u00020=06¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u0008\u0012\u0004\u0012\u00020B0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010C\u001a\u00020D¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010FR\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010G\u001a\u0008\u0012\u0004\u0012\u00020B0H¢\u0006\u0008\n\u0000\u001a\u0004\u0008I\u0010JR\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010K\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u000208070H¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010JR\u0017\u0010M\u001a\u0008\u0012\u0004\u0012\u00020B0A¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010OR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010R\u001a\u0008\u0012\u0004\u0012\u00020S06¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010?R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010W\u001a\u0008\u0012\u0004\u0012\u00020=0A¢\u0006\u0008\n\u0000\u001a\u0004\u0008X\u0010OR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0098\u0001", d2 = {"Lapp/dogo/com/dogo_android/dashboard/DashboardViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "getDashboardProgramCardTypeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardProgramCardTypeInteractor;", "getDashboardExamCardInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardExamCardInteractor;", "getRecommendedProgramRequestInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "dogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "shouldShowWorkoutUnlockedInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "specialOfferInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "zendeskInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;", "getLibraryTrickListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "pottyProgramCardInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramCardInteractor;", "bitingProgramCardInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramCardInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "getProgramOverviewInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;", "timeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "lessonItemHelper", "Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardProgramCardTypeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardExamCardInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramCardInteractor;Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramCardInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;Lkotlinx/coroutines/CoroutineDispatcher;Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;)V", "_results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "couponEndTimeMs", "", "Ljava/lang/Long;", "discountVisible", "", "getDiscountVisible", "()Landroidx/lifecycle/MutableLiveData;", "errorEvent", "Lcom/hadilq/liveevent/LiveEvent;", "", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "onError", "Landroidx/lifecycle/LiveData;", "getOnError", "()Landroidx/lifecycle/LiveData;", "results", "getResults", "shouldShowWorkoutUnlocked", "getShouldShowWorkoutUnlocked", "()Lcom/hadilq/liveevent/LiveEvent;", "tick", "Ljava/util/concurrent/atomic/AtomicLong;", "timer", "Lapp/dogo/com/dogo_android/repository/domain/CouponTimer;", "getTimer", "timerDisposable", "Lio/reactivex/disposables/Disposable;", "workoutCardShown", "getWorkoutCardShown", "didDogIdChange", "newDogId", "getHasZendeskHistoryData", "getRemainingCouponDurationMs", "endTimeMs", "(Ljava/lang/Long;)J", "getShouldShowReminderScreen", "getWorkoutUnlockSourceBlocking", "dogId", "getZendeskUnreadMessagesData", "", "isContactUsLocked", "isDiscountStillValid", "(Ljava/lang/Long;)Z", "loadList", "", "refreshTimerDuration", "retry", "saveTemporaryRecentTricksScrollPosition", "position", "setAuthenticationScreenShowed", "setClosedResubscribeCard", "setReminderScreenShown", "setupProgramItem", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisplayUnlockHelplineScreen", "()Ljava/lang/Boolean;", "shouldShowAuthenticationScreen", "startTimer", "durationInSeconds", "toggleTrainingMetricsTooltipState", "trackBitingProgramClicked", "trackContactUsClicked", "trackDogProfileClick", "trackExamCardClick", "trackExplorePrograms", "source", "trackHelpClick", "trackLessonContinue", "trackLessonNextStart", "lessonId", "trackLogActivityClicked", "trackMetricsTooltipMoreTap", "trackMobileInboxClicked", "trackPottyTrackerCardTapped", "action", "trackRecentlyViewedTrickClicked", "trickId", "trackResubscribeCardClick", "trackReviewProgram", "trackSpecialProgramClicked", "type", "trackSubscriptionCardClick", "trackUserWorkoutProperties", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "trackWorkoutCardShown", "trackWorkoutExploreClicked", "trackWorkoutInfoClicked", "trackWorkoutStartClicked", "triggerWorkoutUnlockIfNeeded", "dashboard", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r extends s {

    private final LiveData<y<Dashboard>> A;
    private final a<String> B;
    private final a<Boolean> C;
    private final CoroutineExceptionHandler D;
    private final AtomicLong E;
    private final x<CouponTimer> F;
    private final x<Boolean> G;
    private b H;
    private Long I;
    private final a<String> J;
    private final o3 a;
    private final j1 b;
    private final l2 c;
    private final k2 d;
    private final z2 e;
    private final p1 f;
    private final n3 g;
    private final d3 h;
    private final v2 i;
    private final p2 j;
    private final l3 k;
    private final r3 l;
    private final w m;
    private final m3 n;
    private final h2 o;
    private final r2 p;
    private final s3 q;
    private final q2 r;
    private final f3 s;
    private final y1 t;
    private final j2 u;
    private final x2 v;
    private final q3 w;
    private final h0 x;
    private final a y;
    private final x<y<Dashboard>> z;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[DashboardProgram.CardType.RECOMMENDED_PROGRAM.ordinal()] = 1;
            iArr[DashboardProgram.CardType.RECOMMENDED_PROGRAM_V2.ordinal()] = 2;
            iArr[DashboardProgram.CardType.LESSON.ordinal()] = 3;
            iArr[DashboardProgram.CardType.PROGRAM_COMPLETED.ordinal()] = 4;
            iArr[DashboardProgram.CardType.QUESTIONNAIRE.ordinal()] = 5;
            r.a.a = iArr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dashboard.DashboardViewModel", f = "DashboardViewModel.kt", l = {376, 377, 397}, m = "setupProgramItem")
    static final class c extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        Object result;
        final app.dogo.com.dogo_android.g.r this$0;
        c(app.dogo.com.dogo_android.g.r r, d<? super app.dogo.com.dogo_android.g.r.c> d2) {
            this.this$0 = r;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return r.A(this.this$0, 0, this);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.g.r a;
        public d(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.g.r r2) {
            this.a = r2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            r.y(this.a).postValue(aVar);
            r.z(this.a, Long.valueOf(0));
            this.a.O();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.g.r this$0;
        e(app.dogo.com.dogo_android.g.r r) {
            this.this$0 = r;
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
            r.k(this.this$0).postValue(throwable.getMessage());
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements a<w> {

        final app.dogo.com.dogo_android.g.r this$0;
        f(app.dogo.com.dogo_android.g.r r) {
            this.this$0 = r;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            CouponTimer couponTimer = new CouponTimer(0, obj3);
            this.this$0.getTimer().postValue(couponTimer);
            this.this$0.getDiscountVisible().postValue(Boolean.FALSE);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements l<Long, w> {

        final app.dogo.com.dogo_android.g.r this$0;
        g(app.dogo.com.dogo_android.g.r r) {
            this.this$0 = r;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Long)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Long long) {
            CouponTimer couponTimer = new CouponTimer(i *= l, obj1);
            this.this$0.getTimer().postValue(couponTimer);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dashboard.DashboardViewModel$loadList$1", f = "DashboardViewModel.kt", l = {107, 135, 136, 137, 145, 147}, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

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
        final app.dogo.com.dogo_android.g.r this$0;
        b(app.dogo.com.dogo_android.g.r r, d<? super app.dogo.com.dogo_android.g.r.b> d2) {
            this.this$0 = r;
            super(2, d2);
        }

        private static final WorkoutSession e(String string, Throwable throwable2) {
            a.d(throwable2);
            super(string, 0, 0, 0, 0, 0, 0, obj8, 126, 0);
            return obj12;
        }

        private static final WorkoutSession f(app.dogo.com.dogo_android.g.r r, WorkoutSession workoutSession2) {
            n.e(workoutSession2, "it");
            return r.w(r).L(workoutSession2);
        }

        public static WorkoutSession m(String string, Throwable throwable2) {
            return r.b.e(string, throwable2);
        }

        public static WorkoutSession n(app.dogo.com.dogo_android.g.r r, WorkoutSession workoutSession2) {
            return r.b.f(r, workoutSession2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (r.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            r.b obj2 = new r.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int condition;
            Object obj15;
            ProgramLessonItem programSaveInfo2;
            boolean streaksEnabled;
            int this$0;
            Object obj10;
            Object aVar;
            Object obj6;
            int i$02;
            boolean booleanValue3;
            boolean z$1;
            WorkoutSession workoutSessionUnlocked;
            Object aVar2;
            boolean z$0;
            CouponDiscount unknownHostException;
            Object l$9;
            Object blockingGet;
            int i$0;
            Object l$8;
            Object obj23;
            Object currentLessonId;
            int i;
            boolean booleanValue;
            Object l$62;
            Object i$03;
            ProgramLessonItem programSaveInfo;
            CouponDiscount couponDiscount;
            Object l$7;
            Object l$5;
            Object l$2;
            Object l$6;
            Object l$4;
            Object l$33;
            String programId;
            String lessonId;
            int endTimeMs;
            Object l$52;
            int l$3;
            Object l$42;
            Object l$22;
            Object obj9;
            Object l$32;
            Object l$1;
            Object obj14;
            Object l$23;
            Object l$02;
            Object l$12;
            Object obj3;
            Object l$0;
            Object recentlyViewedTricks;
            Object obj18;
            Object obj11;
            Object l$63;
            int i2;
            Object obj13;
            Object l$53;
            boolean str;
            boolean z4;
            boolean z5;
            Dashboard dashboard;
            Object obj5;
            boolean z6;
            boolean z8;
            boolean z3;
            Object obj16;
            Object obj12;
            Object obj8;
            Object obj24;
            int i3;
            boolean booleanValue4;
            Object obj7;
            int intValue;
            boolean booleanValue2;
            boolean z;
            Object obj22;
            boolean z2;
            Object obj4;
            Object obj20;
            Object obj21;
            Object obj19;
            boolean z7;
            java.util.List fillPottyCheckmarksList;
            Object obj;
            Object obj17;
            Object obj40;
            final Object obj25 = this;
            Object obj26 = b.d();
            int i6 = 2;
            currentLessonId = "dashboard";
            switch (label) {
                case 0:
                    q.b(object);
                    r.y(obj25.this$0).postValue(y.b.a);
                    r.u(obj25.this$0).s(currentLessonId);
                    unknownHostException = new UnknownHostException();
                    aVar2 = new y.a(unknownHostException);
                    r.y(obj25.this$0).postValue(aVar2);
                    r.v(obj25.this$0).d0().e();
                    obj25.label = 1;
                    return obj26;
                    return w.a;
                case 1:
                    q.b(object);
                    obj6 = object;
                    break;
                case 2:
                    i$02 = obj25.I$0;
                    blockingGet = obj25.L$7;
                    l$62 = obj25.L$6;
                    l$5 = obj25.L$5;
                    l$4 = obj25.L$4;
                    l$3 = obj25.L$3;
                    l$22 = obj25.L$2;
                    l$1 = obj25.L$1;
                    l$02 = obj25.L$0;
                    q.b(object);
                    obj3 = object;
                    i2 = 0;
                    recentlyViewedTricks = new RecentlyViewedTricks((List)obj3, i2, i6, i2);
                    obj25.L$0 = l$02;
                    obj25.L$1 = l$1;
                    obj25.L$2 = l$22;
                    obj25.L$3 = l$3;
                    obj25.L$4 = l$4;
                    obj25.L$5 = l$5;
                    obj25.L$6 = l$62;
                    obj25.L$7 = blockingGet;
                    obj25.L$8 = recentlyViewedTricks;
                    obj25.I$0 = i$02;
                    obj25.label = 3;
                    return obj26;
                    l$0 = l$02;
                    l$12 = l$1;
                    l$23 = l$22;
                    l$32 = l$3;
                    l$42 = l$4;
                    l$52 = l$5;
                    l$6 = l$62;
                    l$7 = blockingGet;
                    l$8 = recentlyViewedTricks;
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$23;
                    obj25.L$3 = l$32;
                    obj25.L$4 = l$42;
                    obj25.L$5 = l$52;
                    obj25.L$6 = l$6;
                    obj25.L$7 = l$7;
                    obj25.L$8 = l$8;
                    obj25.L$9 = (Dashboard.PottyProgramCard)l$9;
                    obj25.I$0 = i$02;
                    obj25.label = 4;
                    return obj26;
                    str = r.o(obj25.this$0).S();
                    java.util.List list = r.o(obj25.this$0).m();
                    obj40 = z9;
                    z3 = str;
                    this$0 = 0;
                    z3 = str;
                    this$0 = 1;
                    n.e(l$42, "correctedWorkoutSession");
                    r.B(obj25.this$0, l$42);
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$23;
                    obj25.L$3 = l$32;
                    obj25.L$4 = l$42;
                    obj25.L$5 = l$52;
                    obj25.L$6 = l$6;
                    obj25.L$7 = l$7;
                    obj25.L$8 = l$8;
                    obj25.L$9 = l$9;
                    obj25.L$10 = (Dashboard.BitingProgramCard)obj18;
                    obj25.L$11 = list;
                    obj25.I$0 = i$02;
                    obj25.Z$0 = z3;
                    obj25.Z$1 = obj40;
                    obj25.Z$2 = r.o(obj25.this$0).T();
                    obj25.label = 5;
                    Object obj27 = obj29;
                    return obj27;
                    z5 = obj27;
                    z$1 = l$7;
                    i$03 = i10;
                    z8 = obj40;
                    obj11 = l$9;
                    z$0 = l$6;
                    l$2 = l$23;
                    obj14 = obj;
                    obj13 = l$8;
                    obj23 = l$52;
                    l$33 = l$32;
                    obj9 = obj17;
                    obj40 = z4;
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$2;
                    obj25.L$3 = l$33;
                    obj25.L$4 = l$42;
                    obj25.L$5 = obj23;
                    obj25.L$6 = z$0;
                    obj25.L$7 = z$1;
                    obj25.L$8 = obj13;
                    obj25.L$9 = obj11;
                    obj25.L$10 = obj14;
                    obj25.L$11 = obj9;
                    obj25.L$12 = (TrainingTimeMetrics)obj10;
                    obj25.I$0 = i$03;
                    obj25.Z$0 = obj40;
                    obj25.Z$1 = z8;
                    obj25.Z$2 = z6;
                    obj25.label = 6;
                    Object obj28 = z5;
                    return obj28;
                    z = obj40;
                    l$53 = obj23;
                    i$0 = i$03;
                    obj24 = l$2;
                    obj12 = l$33;
                    obj7 = l$42;
                    obj22 = obj9;
                    obj21 = obj14;
                    obj8 = l$12;
                    obj20 = obj11;
                    obj4 = obj13;
                    z2 = z6;
                    z7 = z8;
                    obj19 = obj16;
                    recentlyViewedTricks = z$1;
                    l$63 = z$0;
                    obj5 = l$0;
                    i3 = 1;
                    i3 = 0;
                    n.e(l$53, "showWorkoutUnlocked");
                    n.e(l$63, "updatedZendeskMessageCount");
                    n.e(recentlyViewedTricks, "hasZendeskHistory");
                    super(obj5, n2.a.a(r.n(obj25.this$0).W()), (DashboardProgram)obj15, obj12, obj8, obj24, i3, l$53.booleanValue(), obj7, l$63.intValue(), recentlyViewedTricks.booleanValue(), z, obj22, z2, obj4, obj20, obj21, obj19, z7, obj20.getProgramProgress().fillPottyCheckmarksList());
                    programSaveInfo = obj15.getLessonItem();
                    programId = 0;
                    programSaveInfo = programSaveInfo.getProgramSaveInfo();
                    programId = programSaveInfo.getProgramId();
                    r.u(obj25.this$0).q(q3.CurrentProgramId, programId);
                    programSaveInfo2 = obj15.getLessonItem();
                    lessonId = 0;
                    programSaveInfo2 = programSaveInfo2.getProgramSaveInfo();
                    lessonId = programSaveInfo2.getLessonId();
                    r.u(obj25.this$0).q(q3.CurrentLessonId, lessonId);
                    y.c cVar = new y.c(dashboard2);
                    r.y(obj25.this$0).postValue(cVar);
                    unknownHostException = dashboard2.getCouponDiscount();
                    endTimeMs = 0;
                    endTimeMs = unknownHostException.getEndTimeMs();
                    r.z(obj25.this$0, endTimeMs);
                    r.C(obj25.this$0, dashboard2);
                    obj25.this$0.O();
                    workoutSessionUnlocked = dashboard2.getWorkoutSession();
                    couponDiscount = 0;
                    unknownHostException = 1;
                    couponDiscount = unknownHostException;
                    obj25.this$0.I().postValue(b.a(couponDiscount));
                    return w.a;
                case 3:
                    i$02 = obj25.I$0;
                    q.b(object);
                    l$0 = l$05;
                    i2 = 0;
                    l$12 = l$15;
                    l$23 = l$24;
                    l$32 = l$34;
                    l$42 = l$43;
                    l$52 = l$54;
                    l$6 = l$64;
                    l$7 = l$72;
                    l$8 = l$82;
                    l$9 = object;
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$23;
                    obj25.L$3 = l$32;
                    obj25.L$4 = l$42;
                    obj25.L$5 = l$52;
                    obj25.L$6 = l$6;
                    obj25.L$7 = l$7;
                    obj25.L$8 = l$8;
                    obj25.L$9 = (Dashboard.PottyProgramCard)l$9;
                    obj25.I$0 = i$02;
                    obj25.label = 4;
                    return obj26;
                    str = r.o(obj25.this$0).S();
                    list = r.o(obj25.this$0).m();
                    obj40 = z9;
                    z3 = str;
                    this$0 = 0;
                    z3 = str;
                    this$0 = 1;
                    n.e(l$42, "correctedWorkoutSession");
                    r.B(obj25.this$0, l$42);
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$23;
                    obj25.L$3 = l$32;
                    obj25.L$4 = l$42;
                    obj25.L$5 = l$52;
                    obj25.L$6 = l$6;
                    obj25.L$7 = l$7;
                    obj25.L$8 = l$8;
                    obj25.L$9 = l$9;
                    obj25.L$10 = (Dashboard.BitingProgramCard)obj18;
                    obj25.L$11 = list;
                    obj25.I$0 = i$02;
                    obj25.Z$0 = z3;
                    obj25.Z$1 = obj40;
                    obj25.Z$2 = r.o(obj25.this$0).T();
                    obj25.label = 5;
                    obj27 = obj29;
                    return obj27;
                    z5 = obj27;
                    z$1 = l$7;
                    i$03 = i10;
                    z8 = obj40;
                    obj11 = l$9;
                    z$0 = l$6;
                    l$2 = l$23;
                    obj14 = obj;
                    obj13 = l$8;
                    obj23 = l$52;
                    l$33 = l$32;
                    obj9 = obj17;
                    obj40 = z4;
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$2;
                    obj25.L$3 = l$33;
                    obj25.L$4 = l$42;
                    obj25.L$5 = obj23;
                    obj25.L$6 = z$0;
                    obj25.L$7 = z$1;
                    obj25.L$8 = obj13;
                    obj25.L$9 = obj11;
                    obj25.L$10 = obj14;
                    obj25.L$11 = obj9;
                    obj25.L$12 = (TrainingTimeMetrics)obj10;
                    obj25.I$0 = i$03;
                    obj25.Z$0 = obj40;
                    obj25.Z$1 = z8;
                    obj25.Z$2 = z6;
                    obj25.label = 6;
                    obj28 = z5;
                    return obj28;
                    z = obj40;
                    l$53 = obj23;
                    i$0 = i$03;
                    obj24 = l$2;
                    obj12 = l$33;
                    obj7 = l$42;
                    obj22 = obj9;
                    obj21 = obj14;
                    obj8 = l$12;
                    obj20 = obj11;
                    obj4 = obj13;
                    z2 = z6;
                    z7 = z8;
                    obj19 = obj16;
                    recentlyViewedTricks = z$1;
                    l$63 = z$0;
                    obj5 = l$0;
                    i3 = 1;
                    i3 = 0;
                    n.e(l$53, "showWorkoutUnlocked");
                    n.e(l$63, "updatedZendeskMessageCount");
                    n.e(recentlyViewedTricks, "hasZendeskHistory");
                    super(obj5, n2.a.a(r.n(obj25.this$0).W()), (DashboardProgram)obj15, obj12, obj8, obj24, i3, l$53.booleanValue(), obj7, l$63.intValue(), recentlyViewedTricks.booleanValue(), z, obj22, z2, obj4, obj20, obj21, obj19, z7, obj20.getProgramProgress().fillPottyCheckmarksList());
                    programSaveInfo = obj15.getLessonItem();
                    programId = 0;
                    programSaveInfo = programSaveInfo.getProgramSaveInfo();
                    programId = programSaveInfo.getProgramId();
                    r.u(obj25.this$0).q(q3.CurrentProgramId, programId);
                    programSaveInfo2 = obj15.getLessonItem();
                    lessonId = 0;
                    programSaveInfo2 = programSaveInfo2.getProgramSaveInfo();
                    lessonId = programSaveInfo2.getLessonId();
                    r.u(obj25.this$0).q(q3.CurrentLessonId, lessonId);
                    cVar = new y.c(dashboard2);
                    r.y(obj25.this$0).postValue(cVar);
                    unknownHostException = dashboard2.getCouponDiscount();
                    endTimeMs = 0;
                    endTimeMs = unknownHostException.getEndTimeMs();
                    r.z(obj25.this$0, endTimeMs);
                    r.C(obj25.this$0, dashboard2);
                    obj25.this$0.O();
                    workoutSessionUnlocked = dashboard2.getWorkoutSession();
                    couponDiscount = 0;
                    unknownHostException = 1;
                    couponDiscount = unknownHostException;
                    obj25.this$0.I().postValue(b.a(couponDiscount));
                    return w.a;
                case 4:
                    i$02 = obj25.I$0;
                    l$9 = obj25.L$9;
                    l$8 = obj25.L$8;
                    l$7 = obj25.L$7;
                    l$6 = obj25.L$6;
                    l$52 = obj25.L$5;
                    l$42 = obj25.L$4;
                    l$32 = obj25.L$3;
                    l$23 = obj25.L$2;
                    l$12 = obj25.L$1;
                    l$0 = obj25.L$0;
                    q.b(object);
                    obj18 = object;
                    i2 = 0;
                    str = r.o(obj25.this$0).S();
                    list = r.o(obj25.this$0).m();
                    obj40 = z9;
                    z3 = str;
                    this$0 = 0;
                    z3 = str;
                    this$0 = 1;
                    n.e(l$42, "correctedWorkoutSession");
                    r.B(obj25.this$0, l$42);
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$23;
                    obj25.L$3 = l$32;
                    obj25.L$4 = l$42;
                    obj25.L$5 = l$52;
                    obj25.L$6 = l$6;
                    obj25.L$7 = l$7;
                    obj25.L$8 = l$8;
                    obj25.L$9 = l$9;
                    obj25.L$10 = (Dashboard.BitingProgramCard)obj18;
                    obj25.L$11 = list;
                    obj25.I$0 = i$02;
                    obj25.Z$0 = z3;
                    obj25.Z$1 = obj40;
                    obj25.Z$2 = r.o(obj25.this$0).T();
                    obj25.label = 5;
                    obj27 = obj29;
                    return obj27;
                    z5 = obj27;
                    z$1 = l$7;
                    i$03 = i10;
                    z8 = obj40;
                    obj11 = l$9;
                    z$0 = l$6;
                    l$2 = l$23;
                    obj14 = obj;
                    obj13 = l$8;
                    obj23 = l$52;
                    l$33 = l$32;
                    obj9 = obj17;
                    obj40 = z4;
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$2;
                    obj25.L$3 = l$33;
                    obj25.L$4 = l$42;
                    obj25.L$5 = obj23;
                    obj25.L$6 = z$0;
                    obj25.L$7 = z$1;
                    obj25.L$8 = obj13;
                    obj25.L$9 = obj11;
                    obj25.L$10 = obj14;
                    obj25.L$11 = obj9;
                    obj25.L$12 = (TrainingTimeMetrics)obj10;
                    obj25.I$0 = i$03;
                    obj25.Z$0 = obj40;
                    obj25.Z$1 = z8;
                    obj25.Z$2 = z6;
                    obj25.label = 6;
                    obj28 = z5;
                    return obj28;
                    z = obj40;
                    l$53 = obj23;
                    i$0 = i$03;
                    obj24 = l$2;
                    obj12 = l$33;
                    obj7 = l$42;
                    obj22 = obj9;
                    obj21 = obj14;
                    obj8 = l$12;
                    obj20 = obj11;
                    obj4 = obj13;
                    z2 = z6;
                    z7 = z8;
                    obj19 = obj16;
                    recentlyViewedTricks = z$1;
                    l$63 = z$0;
                    obj5 = l$0;
                    i3 = 1;
                    i3 = 0;
                    n.e(l$53, "showWorkoutUnlocked");
                    n.e(l$63, "updatedZendeskMessageCount");
                    n.e(recentlyViewedTricks, "hasZendeskHistory");
                    super(obj5, n2.a.a(r.n(obj25.this$0).W()), (DashboardProgram)obj15, obj12, obj8, obj24, i3, l$53.booleanValue(), obj7, l$63.intValue(), recentlyViewedTricks.booleanValue(), z, obj22, z2, obj4, obj20, obj21, obj19, z7, obj20.getProgramProgress().fillPottyCheckmarksList());
                    programSaveInfo = obj15.getLessonItem();
                    programId = 0;
                    programSaveInfo = programSaveInfo.getProgramSaveInfo();
                    programId = programSaveInfo.getProgramId();
                    r.u(obj25.this$0).q(q3.CurrentProgramId, programId);
                    programSaveInfo2 = obj15.getLessonItem();
                    lessonId = 0;
                    programSaveInfo2 = programSaveInfo2.getProgramSaveInfo();
                    lessonId = programSaveInfo2.getLessonId();
                    r.u(obj25.this$0).q(q3.CurrentLessonId, lessonId);
                    cVar = new y.c(dashboard2);
                    r.y(obj25.this$0).postValue(cVar);
                    unknownHostException = dashboard2.getCouponDiscount();
                    endTimeMs = 0;
                    endTimeMs = unknownHostException.getEndTimeMs();
                    r.z(obj25.this$0, endTimeMs);
                    r.C(obj25.this$0, dashboard2);
                    obj25.this$0.O();
                    workoutSessionUnlocked = dashboard2.getWorkoutSession();
                    couponDiscount = 0;
                    unknownHostException = 1;
                    couponDiscount = unknownHostException;
                    obj25.this$0.I().postValue(b.a(couponDiscount));
                    return w.a;
                case 5:
                    i$03 = obj25.I$0;
                    q.b(object);
                    z8 = z$12;
                    z$0 = l$65;
                    l$12 = obj30;
                    z6 = z17;
                    z5 = obj26;
                    obj10 = object;
                    l$0 = l$04;
                    z$1 = l$73;
                    obj14 = l$10;
                    l$33 = l$35;
                    obj13 = l$83;
                    obj9 = l$11;
                    l$2 = l$25;
                    z4 = z$02;
                    obj23 = obj;
                    obj11 = l$92;
                    l$42 = obj17;
                    obj40 = z4;
                    obj25.L$0 = l$0;
                    obj25.L$1 = l$12;
                    obj25.L$2 = l$2;
                    obj25.L$3 = l$33;
                    obj25.L$4 = l$42;
                    obj25.L$5 = obj23;
                    obj25.L$6 = z$0;
                    obj25.L$7 = z$1;
                    obj25.L$8 = obj13;
                    obj25.L$9 = obj11;
                    obj25.L$10 = obj14;
                    obj25.L$11 = obj9;
                    obj25.L$12 = (TrainingTimeMetrics)obj10;
                    obj25.I$0 = i$03;
                    obj25.Z$0 = obj40;
                    obj25.Z$1 = z8;
                    obj25.Z$2 = z6;
                    obj25.label = 6;
                    obj28 = z5;
                    return obj28;
                    z = obj40;
                    l$53 = obj23;
                    i$0 = i$03;
                    obj24 = l$2;
                    obj12 = l$33;
                    obj7 = l$42;
                    obj22 = obj9;
                    obj21 = obj14;
                    obj8 = l$12;
                    obj20 = obj11;
                    obj4 = obj13;
                    z2 = z6;
                    z7 = z8;
                    obj19 = obj16;
                    recentlyViewedTricks = z$1;
                    l$63 = z$0;
                    obj5 = l$0;
                    i3 = 1;
                    i3 = 0;
                    n.e(l$53, "showWorkoutUnlocked");
                    n.e(l$63, "updatedZendeskMessageCount");
                    n.e(recentlyViewedTricks, "hasZendeskHistory");
                    super(obj5, n2.a.a(r.n(obj25.this$0).W()), (DashboardProgram)obj15, obj12, obj8, obj24, i3, l$53.booleanValue(), obj7, l$63.intValue(), recentlyViewedTricks.booleanValue(), z, obj22, z2, obj4, obj20, obj21, obj19, z7, obj20.getProgramProgress().fillPottyCheckmarksList());
                    programSaveInfo = obj15.getLessonItem();
                    programId = 0;
                    programSaveInfo = programSaveInfo.getProgramSaveInfo();
                    programId = programSaveInfo.getProgramId();
                    r.u(obj25.this$0).q(q3.CurrentProgramId, programId);
                    programSaveInfo2 = obj15.getLessonItem();
                    lessonId = 0;
                    programSaveInfo2 = programSaveInfo2.getProgramSaveInfo();
                    lessonId = programSaveInfo2.getLessonId();
                    r.u(obj25.this$0).q(q3.CurrentLessonId, lessonId);
                    cVar = new y.c(dashboard2);
                    r.y(obj25.this$0).postValue(cVar);
                    unknownHostException = dashboard2.getCouponDiscount();
                    endTimeMs = 0;
                    endTimeMs = unknownHostException.getEndTimeMs();
                    r.z(obj25.this$0, endTimeMs);
                    r.C(obj25.this$0, dashboard2);
                    obj25.this$0.O();
                    workoutSessionUnlocked = dashboard2.getWorkoutSession();
                    couponDiscount = 0;
                    unknownHostException = 1;
                    couponDiscount = unknownHostException;
                    obj25.this$0.I().postValue(b.a(couponDiscount));
                    return w.a;
                case 6:
                    i$0 = obj25.I$0;
                    recentlyViewedTricks = obj25.L$7;
                    l$63 = obj25.L$6;
                    l$53 = obj25.L$5;
                    q.b(object);
                    z7 = z$1;
                    z = z$0;
                    obj7 = i$03;
                    obj24 = l$2;
                    obj12 = l$33;
                    obj19 = l$42;
                    obj22 = obj9;
                    obj21 = obj14;
                    obj20 = l$12;
                    obj4 = l$0;
                    z2 = z5;
                    obj8 = obj31;
                    obj5 = l$03;
                    obj15 = object;
                    i3 = 1;
                    i3 = 0;
                    n.e(l$53, "showWorkoutUnlocked");
                    n.e(l$63, "updatedZendeskMessageCount");
                    n.e(recentlyViewedTricks, "hasZendeskHistory");
                    super(obj5, n2.a.a(r.n(obj25.this$0).W()), (DashboardProgram)obj15, obj12, obj8, obj24, i3, l$53.booleanValue(), obj7, l$63.intValue(), recentlyViewedTricks.booleanValue(), z, obj22, z2, obj4, obj20, obj21, obj19, z7, obj20.getProgramProgress().fillPottyCheckmarksList());
                    programSaveInfo = obj15.getLessonItem();
                    programId = 0;
                    programSaveInfo = programSaveInfo.getProgramSaveInfo();
                    programId = programSaveInfo.getProgramId();
                    r.u(obj25.this$0).q(q3.CurrentProgramId, programId);
                    programSaveInfo2 = obj15.getLessonItem();
                    lessonId = 0;
                    programSaveInfo2 = programSaveInfo2.getProgramSaveInfo();
                    lessonId = programSaveInfo2.getLessonId();
                    r.u(obj25.this$0).q(q3.CurrentLessonId, lessonId);
                    cVar = new y.c(dashboard2);
                    r.y(obj25.this$0).postValue(cVar);
                    unknownHostException = dashboard2.getCouponDiscount();
                    endTimeMs = 0;
                    endTimeMs = unknownHostException.getEndTimeMs();
                    r.z(obj25.this$0, endTimeMs);
                    r.C(obj25.this$0, dashboard2);
                    obj25.this$0.O();
                    workoutSessionUnlocked = dashboard2.getWorkoutSession();
                    couponDiscount = 0;
                    unknownHostException = 1;
                    couponDiscount = unknownHostException;
                    obj25.this$0.I().postValue(b.a(couponDiscount));
                    return w.a;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
            }
            l$02 = obj6;
            if (l.z((String)l$02)) {
            } else {
                Object blockingGet2 = r.r(obj25.this$0).o().blockingGet();
                n.e(blockingGet2, "subscribeInteractor.revenueCatShowResubscribe().blockingGet()");
                if ((Boolean)blockingGet2.booleanValue() && !r.n(obj25.this$0).n()) {
                    i$02 = !r.n(obj25.this$0).n() ? 1 : 0;
                } else {
                }
                l$1 = blockingGet6;
                int i8 = 0;
                if ((Boolean)l$1.booleanValue()) {
                    if (i$02 != 0) {
                        l$3 = booleanValue;
                    } else {
                        l$3 = 0;
                    }
                } else {
                }
                r.v(obj25.this$0).g(l$02, currentLessonId);
                i iVar = new i(l$02);
                j jVar = new j(obj25.this$0);
                obj25.L$0 = l$02;
                obj25.L$1 = l$1;
                obj25.L$2 = (Boolean)d3.b(r.j(obj25.this$0), i8, 1, i8).blockingGet();
                obj25.L$3 = l$3;
                obj25.L$4 = (WorkoutSession)r.w(obj25.this$0).d().onErrorReturn(iVar).map(jVar).blockingGet();
                obj25.L$5 = (Boolean)r.p(obj25.this$0).d().blockingGet();
                obj25.L$6 = (Integer)r.x(obj25.this$0).f().blockingGet();
                obj25.L$7 = (Boolean)r.x(obj25.this$0).j().blockingGet();
                obj25.I$0 = i$02;
                obj25.label = i6;
                if (r.l(obj25.this$0).e(obj25) == obj26) {
                    return obj26;
                }
            }
            InvalidParameterException invalidParameterException = new InvalidParameterException("Dog Id is Empty");
            throw invalidParameterException;
        }
    }
    public r(o3 o3, j1 j12, l2 l23, k2 k24, z2 z25, p1 p16, n3 n37, d3 d38, v2 v29, p2 p210, l3 l311, r3 r312, w w13, m3 m314, h2 h215, r2 r216, s3 s317, q2 q218, f3 f319, y1 y120, j2 j221, x2 x222, q3 q323, h0 h024, a a25) {
        Object obj = this;
        Object obj4 = o3;
        Object obj5 = j12;
        final Object obj6 = l23;
        final Object obj7 = k24;
        final Object obj8 = z25;
        final Object obj9 = p16;
        final Object obj10 = n37;
        final Object obj11 = d38;
        final Object obj12 = v29;
        final Object obj13 = p210;
        final Object obj14 = l311;
        final Object obj15 = r312;
        final Object obj16 = w13;
        final Object obj17 = m314;
        Object obj2 = r216;
        n.f(obj4, "tracker");
        n.f(obj5, "programRepository");
        n.f(obj6, "getDashboardProgramCardTypeInteractor");
        n.f(obj7, "getDashboardExamCardInteractor");
        n.f(obj8, "getRecommendedProgramRequestInteractor");
        n.f(obj9, "userRepository");
        n.f(obj10, "subscribeInteractor");
        n.f(obj11, "dogPremiumInteractor");
        n.f(obj12, "timeUtils");
        n.f(obj13, "preferenceService");
        n.f(obj14, "shouldShowWorkoutUnlockedInteractor");
        n.f(obj15, "workoutSessionInteractor");
        n.f(obj16, "dogLocalEntityDao");
        n.f(obj17, "specialOfferInteractor");
        n.f(h215, "authService");
        n.f(r216, "remoteConfigService");
        n.f(s317, "zendeskInteractor");
        n.f(q218, "getLibraryTrickListInteractor");
        n.f(f319, "pottyProgramCardInteractor");
        n.f(y120, "bitingProgramCardInteractor");
        n.f(j221, "connectivityService");
        n.f(x222, "getProgramOverviewInteractor");
        n.f(q323, "timeInteractor");
        n.f(h024, "dispatcher");
        n.f(a25, "lessonItemHelper");
        super();
        Object obj3 = this;
        obj3.a = obj4;
        obj3.b = obj5;
        obj3.c = obj6;
        obj3.d = obj7;
        obj3.e = obj8;
        obj3.f = obj9;
        obj3.g = obj10;
        obj3.h = obj11;
        obj3.i = obj12;
        obj3.j = obj13;
        obj3.k = obj14;
        obj3.l = obj15;
        obj3.m = obj16;
        obj3.n = obj17;
        obj3.o = h215;
        obj3.p = r216;
        obj3.q = s317;
        obj3.r = q218;
        obj3.s = f319;
        obj3.t = y120;
        obj3.u = j221;
        obj3.v = x222;
        obj3.w = q323;
        obj3.x = h024;
        obj3.y = a25;
        x xVar = new x();
        obj3.z = xVar;
        obj3.A = xVar;
        a aVar2 = new a();
        obj3.B = aVar2;
        a aVar3 = new a();
        obj3.C = aVar3;
        r.d dVar = new r.d(CoroutineExceptionHandler.r, obj3);
        obj3.D = dVar;
        AtomicLong atomicLong = new AtomicLong(0, obj6);
        obj3.E = atomicLong;
        x xVar2 = new x();
        obj3.F = xVar2;
        x xVar3 = new x(Boolean.FALSE);
        obj3.G = xVar3;
        a aVar4 = new a();
        obj3.J = aVar4;
    }

    public r(o3 o3, j1 j12, l2 l23, k2 k24, z2 z25, p1 p16, n3 n37, d3 d38, v2 v29, p2 p210, l3 l311, r3 r312, w w13, m3 m314, h2 h215, r2 r216, s3 s317, q2 q218, f3 f319, y1 y120, j2 j221, x2 x222, q3 q323, h0 h024, a a25, int i26, g g27) {
        h0 i;
        int aVar;
        h0 h0Var;
        a aVar2;
        if (i26 & i2 != 0) {
            h0Var = i;
        } else {
            h0Var = h024;
        }
        if (i26 & i3 != 0) {
            aVar = new a();
            aVar2 = aVar;
        } else {
            aVar2 = a25;
        }
        super(o3, j12, l23, k24, z25, p16, n37, d38, v29, p210, l311, r312, w13, m314, h215, r216, s317, q218, f319, y120, j221, x222, q323, h0Var, aVar2);
    }

    public static final Object A(app.dogo.com.dogo_android.g.r r, String string2, d d3) {
        return r.T(string2, d3);
    }

    public static final void B(app.dogo.com.dogo_android.g.r r, WorkoutSession workoutSession2) {
        r.o0(workoutSession2);
    }

    public static final void C(app.dogo.com.dogo_android.g.r r, Dashboard dashboard2) {
        r.t0(dashboard2);
    }

    private final boolean L() {
        return this.p.T();
    }

    public static boolean M(app.dogo.com.dogo_android.g.r r, long l2) {
        return r.X(r, l2);
    }

    private final Object T(String string, d<? super DashboardProgram> d2) {
        Object result;
        DashboardProgram dashboardProgram;
        boolean cVar;
        Object l$0;
        x2 x2Var;
        int label;
        int l$4;
        Object programModel;
        int i4;
        Object l$3;
        r2 lessonId;
        Object l$12;
        Object string2;
        int illegalStateException;
        int i;
        int i5;
        int qUESTIONNAIRE;
        Object l$2;
        Object l$02;
        Object l$1;
        k.b bVar;
        DashboardProgram.CardType rECOMMENDED_BIG;
        Object stringBuilder;
        app.dogo.externalmodel.model.responses.ProgramProgress programProgress;
        Object obj;
        boolean surveyAnswered;
        String str;
        int lESSON;
        int i11;
        boolean z;
        int i8;
        long i3;
        int i2;
        int intValue;
        app.dogo.com.dogo_android.repository.domain.ProgramOverview programOverview;
        int i7;
        int i6;
        int i9;
        DashboardProgram.CardType pROGRAM_COMPLETED;
        int i12;
        int i10;
        Object obj2;
        final app.dogo.com.dogo_android.g.r rVar = this;
        Object obj3 = d2;
        cVar = obj3;
        label = cVar.label;
        i4 = Integer.MIN_VALUE;
        if (obj3 instanceof r.c && label & i4 != 0) {
            cVar = obj3;
            label = cVar.label;
            i4 = Integer.MIN_VALUE;
            if (label & i4 != 0) {
                cVar.label = label -= i4;
            } else {
                cVar = new r.c(rVar, obj3);
            }
        } else {
        }
        result = cVar.result;
        Object obj4 = b.d();
        int label2 = cVar.label;
        i = 3;
        i5 = 2;
        qUESTIONNAIRE = 1;
        if (label2 != 0) {
            if (label2 != qUESTIONNAIRE) {
                if (label2 != i5) {
                    if (label2 != i) {
                    } else {
                        l$4 = cVar.L$4;
                        l$2 = cVar.L$2;
                        l$1 = cVar.L$1;
                        l$0 = cVar.L$0;
                        q.b(result);
                        obj = l$3;
                        int i13 = r.a.a[obj.ordinal()];
                        if (i13 != qUESTIONNAIRE && i13 != i5) {
                            if (i13 != i5) {
                                if (i13 != i) {
                                    if (i13 != 4) {
                                        if (i13 != 5) {
                                        } else {
                                            super(0, 0, 0, 0, DashboardProgram.CardType.QUESTIONNAIRE, 15, 0);
                                        }
                                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                                        throw noWhenBranchMatchedException;
                                    }
                                    n.d(l$2);
                                    super(0, j1.c(l$2.a(), ProgramDescriptionItem.State.RECOMMENDED_BIG, false, false, 0, obj16, 0, 0, l$0.v.a(l$2.a()), 62), l$0.d.b(l$1, l$2.a(), l$2.c(), ""), 0, DashboardProgram.CardType.PROGRAM_COMPLETED, 9, 0);
                                } else {
                                    n.d(l$2);
                                    rECOMMENDED_BIG = l$0.y.e(l$2, l$1, 0, qUESTIONNAIRE);
                                    super(rECOMMENDED_BIG, 0, l$0.d.b(l$1, l$2.a(), l$2.c(), rECOMMENDED_BIG.getProgramSaveInfo().getLessonId()), j1.H(l$2.a(), l$2.c(), rECOMMENDED_BIG.getProgramSaveInfo().getLessonId(), l$0.b), DashboardProgram.CardType.LESSON, 2, 0);
                                }
                            } else {
                                super(0, j1.c(l$4.a(), ProgramDescriptionItem.State.RECOMMENDED_BIG, false, l$0.p.d0(), 0, obj20, 0, (Number)result.intValue(), l$0.v.a(l$4.a()), 26), 0, 0, obj, 13, 0);
                            }
                        } else {
                        }
                        return dashboardProgram;
                    }
                    IllegalStateException illegalStateException2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException2;
                }
                string2 = cVar.L$2;
                q.b(result);
                l$1 = l$13;
                l$02 = obj2;
            } else {
                l$12 = cVar.L$1;
                l$02 = cVar.L$0;
                q.b(result);
                cVar.L$0 = l$02;
                cVar.L$1 = l$12;
                cVar.L$2 = (RecommendedOrderedPrograms)result;
                cVar.label = i5;
                Object obj5 = l$02.b.o(l$12, cVar);
                if (obj5 == obj4) {
                    return obj4;
                }
                string2 = result;
                result = obj5;
                l$1 = obj2;
            }
        } else {
            q.b(result);
            cVar.L$0 = rVar;
            cVar.L$1 = string;
            cVar.label = qUESTIONNAIRE;
            if (rVar.e.d(cVar) == obj4) {
                return obj4;
            }
            l$02 = rVar;
        }
        bVar = (i)result.a();
        if (bVar == null) {
            programProgress = 0;
        } else {
            programProgress = bVar.c();
        }
        rECOMMENDED_BIG = l$02.c.a(programProgress, string2.isSurveyAnswered());
        stringBuilder = result.d().values().iterator();
        for (Object surveyAnswered : stringBuilder) {
        }
        surveyAnswered = 0;
        if ((k.b)surveyAnswered == 0) {
            result = p.W(result.d().values());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find recommended program ");
            stringBuilder.append(string2.getRecommendedProgramId());
            stringBuilder.append(", Defaulting to ");
            stringBuilder.append((k.b)result.b());
            illegalStateException = new IllegalStateException(stringBuilder.toString());
            a.d(illegalStateException);
            surveyAnswered = result;
        }
        cVar.L$0 = l$02;
        cVar.L$1 = l$1;
        cVar.L$2 = bVar;
        cVar.L$3 = rECOMMENDED_BIG;
        cVar.L$4 = surveyAnswered;
        cVar.label = i;
        if (l$02.e.b(surveyAnswered.a().getId(), cVar) == obj4) {
            return obj4;
        }
        l$0 = l$02;
        l$2 = bVar;
        l$4 = surveyAnswered;
        obj = rECOMMENDED_BIG;
    }

    private final void W(long l) {
        Object obj4;
        h hVar = new h(this, l, obj4);
        i.b.h obj3 = RxJavaDogo.INSTANCE.timerWithStart(l).repeatUntil(hVar);
        n.e(obj3, "RxJavaDogo.timerWithStart(durationInSeconds)\n            .repeatUntil { tick.get() >= durationInSeconds }");
        obj4 = new r.e(this);
        r.f fVar = new r.f(this);
        r.g gVar = new r.g(this);
        obj3 = a.e(obj3, obj4, fVar, gVar);
        this.H = obj3;
        if (obj3 == null) {
        } else {
            getDisposable().b(obj3);
        }
    }

    private static final boolean X(app.dogo.com.dogo_android.g.r r, long l2) {
        int obj2;
        n.f(r, "this$0");
        obj2 = Long.compare(l, l2) >= 0 ? 1 : 0;
        return obj2;
    }

    private final long getRemainingCouponDurationMs(Long long) {
        int longValue;
        if (long == null) {
            longValue = 0;
        } else {
            longValue = long.longValue();
        }
        return longValue -= l;
    }

    public static final y1 h(app.dogo.com.dogo_android.g.r r) {
        return r.t;
    }

    public static final j2 i(app.dogo.com.dogo_android.g.r r) {
        return r.u;
    }

    private final boolean isDiscountStillValid(Long long) {
        int longValue;
        int obj5;
        if (long == null) {
            longValue = 0;
        } else {
            longValue = long.longValue();
        }
        obj5 = Long.compare(l, longValue) < 0 ? 1 : 0;
        return obj5;
    }

    public static final d3 j(app.dogo.com.dogo_android.g.r r) {
        return r.h;
    }

    public static final a k(app.dogo.com.dogo_android.g.r r) {
        return r.J;
    }

    public static final q2 l(app.dogo.com.dogo_android.g.r r) {
        return r.r;
    }

    public static final f3 m(app.dogo.com.dogo_android.g.r r) {
        return r.s;
    }

    public static final p2 n(app.dogo.com.dogo_android.g.r r) {
        return r.j;
    }

    public static final r2 o(app.dogo.com.dogo_android.g.r r) {
        return r.p;
    }

    private final void o0(WorkoutSession workoutSession) {
        this.a.q(q3.CurrentStreak, Integer.valueOf(workoutSession.getCurrentStreak()));
        this.a.q(q3.LongestStreak, Integer.valueOf(workoutSession.getLongestStreak()));
        this.a.q(q3.LastWorkoutTime, Long.valueOf(workoutSession.getLastAchievedStreakTimestampMs()));
    }

    public static final l3 p(app.dogo.com.dogo_android.g.r r) {
        return r.k;
    }

    public static final m3 q(app.dogo.com.dogo_android.g.r r) {
        return r.n;
    }

    public static final n3 r(app.dogo.com.dogo_android.g.r r) {
        return r.g;
    }

    public static final AtomicLong s(app.dogo.com.dogo_android.g.r r) {
        return r.E;
    }

    public static final q3 t(app.dogo.com.dogo_android.g.r r) {
        return r.w;
    }

    private final void t0(Dashboard dashboard) {
        boolean showWorkoutUnlocked;
        String obj2;
        if (dashboard.getShowWorkoutUnlocked()) {
            this.B.postValue(dashboard.getDogId());
        }
    }

    public static final o3 u(app.dogo.com.dogo_android.g.r r) {
        return r.a;
    }

    public static final p1 v(app.dogo.com.dogo_android.g.r r) {
        return r.f;
    }

    public static final r3 w(app.dogo.com.dogo_android.g.r r) {
        return r.l;
    }

    public static final s3 x(app.dogo.com.dogo_android.g.r r) {
        return r.q;
    }

    public static final x y(app.dogo.com.dogo_android.g.r r) {
        return r.z;
    }

    public static final void z(app.dogo.com.dogo_android.g.r r, Long long2) {
        r.I = long2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean D(String string) {
        n.f(string, "newDogId");
        Object value = this.z.getValue();
        if (value instanceof y.c) {
            return obj3 ^= 1;
        }
        return value instanceof y.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean E() {
        int value;
        boolean hasZendeskHistory;
        if (value instanceof y.c) {
        } else {
            value = 0;
        }
        hasZendeskHistory = 0;
        if (value == null) {
        } else {
            value = value.a();
            if ((Dashboard)value == null) {
            } else {
                hasZendeskHistory = (Dashboard)value.getHasZendeskHistory();
            }
        }
        return hasZendeskHistory;
    }

    public final LiveData<y<Dashboard>> F() {
        return this.A;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean G() {
        return this.f.F();
    }

    public final a<String> H() {
        return this.B;
    }

    public final a<Boolean> I() {
        return this.C;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String J(String string) {
        Object obj2;
        n.f(string, "dogId");
        obj2 = this.m.g(string).blockingGet();
        n.e((String)obj2, "source");
        if (z ^= 1 != 0) {
        } else {
            obj2 = "dashboard";
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int K() {
        int value;
        int updatedZendeskMessageCount;
        if (value instanceof y.c) {
        } else {
            value = 0;
        }
        updatedZendeskMessageCount = 0;
        if (value == null) {
        } else {
            value = value.a();
            if ((Dashboard)value == null) {
            } else {
                updatedZendeskMessageCount = (Dashboard)value.getUpdatedZendeskMessageCount();
            }
        }
        return updatedZendeskMessageCount;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void N() {
        int i = 0;
        r.b bVar = new r.b(this, i);
        k.d(f0.a(this), this.x.plus(this.D), i, bVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void O() {
        x discountVisible;
        Boolean discountStillValid;
        long l;
        int i;
        Long num = this.I;
        b bVar = this.H;
        if (bVar == null) {
        } else {
            bVar.dispose();
        }
        discountStillValid = isDiscountStillValid(num);
        if (discountStillValid) {
            long remainingCouponDurationMs = getRemainingCouponDurationMs(num);
            getDiscountVisible().postValue(Boolean.TRUE);
            CouponTimer couponTimer = new CouponTimer(remainingCouponDurationMs, discountStillValid);
            getTimer().postValue(couponTimer);
            this.E.set(0);
            W(remainingCouponDurationMs /= l);
        } else {
            getDiscountVisible().postValue(Boolean.FALSE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void P(int i) {
        int value;
        y.c valueOf;
        Dashboard copy$default;
        Object obj;
        int i14;
        int i13;
        int i3;
        int i4;
        int i7;
        int i9;
        int i22;
        int i11;
        int i2;
        int i8;
        int i15;
        int i18;
        int i5;
        int i20;
        RecentlyViewedTricks view;
        int i10;
        int i12;
        int i16;
        int i21;
        int i17;
        int i19;
        int i6;
        final Object obj2 = this;
        copy$default = 0;
        if (value instanceof y.c) {
        } else {
            value = copy$default;
        }
        if (value == null) {
        } else {
            obj = value;
            if ((Dashboard)obj == null) {
            } else {
                RecentlyViewedTricks recentlyViewed = (Dashboard)obj.getRecentlyViewed();
                if (recentlyViewed == null) {
                } else {
                    copy$default = RecentlyViewedTricks.copy$default(recentlyViewed, copy$default, Integer.valueOf(i), 1, copy$default);
                }
                valueOf = new y.c(Dashboard.copy$default(obj, 0, 0, 0, 0, 0, 0, false, false, 0, 0, false, false, 0, false, copy$default, 0, 0, 0, false, 0, 1032191, 0));
                obj2.z.setValue(valueOf);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Q() {
        this.j.w0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void R() {
        this.j.B0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void S() {
        this.f.m0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Boolean U() {
        int value;
        Boolean userPremium;
        int valueOf;
        valueOf = 0;
        if (value instanceof y.c) {
        } else {
            value = valueOf;
        }
        if (value == null) {
            userPremium = valueOf;
        } else {
        }
        if (!L()) {
            valueOf = Boolean.FALSE;
        } else {
            if (userPremium == null) {
            } else {
                valueOf = Boolean.valueOf(booleanValue ^= 1);
            }
        }
        return valueOf;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean V() {
        int i;
        boolean z;
        if (!this.o.D() && !this.j.i() && this.j.O()) {
            if (!this.j.i()) {
                i = this.j.O() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean Y() {
        z ^= 1;
        this.j.u1(i);
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Z() {
        r2 r2Var = new r2();
        this.a.d(x.s.c(r2Var, "dashboard"));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void a0() {
        r2 r2Var = new r2();
        this.a.d(a0.n.c(r2Var, "dashboard_navigation_bar"));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void b0() {
        this.a.d(x.e);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void c0() {
        this.a.d(x.h);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void d0(String string) {
        n.f(string, "source");
        r2 r2Var = new r2();
        this.a.d(x.b.c(r2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void e0() {
        this.a.d(x.d);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void f0(String string) {
        n.f(string, "lessonId");
        w1 w1Var = new w1();
        this.a.d(x.c.c(w1Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void g0() {
        o2 o2Var = new o2();
        this.a.d(x.t.d(u.a(o2Var, "time_metric")));
    }

    public final x<Boolean> getDiscountVisible() {
        return this.G;
    }

    public final x<CouponTimer> getTimer() {
        return this.F;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h0() {
        this.a.d(x.p);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i0(String string) {
        n.f(string, "action");
        s0 s0Var = new s0();
        this.a.d(h0.e.d(u.a(s0Var, string)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j0(String string) {
        n.f(string, "trickId");
        n2 n2Var = new n2();
        this.a.d(x.q.c(n2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k0() {
        this.a.d(x.j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l0() {
        r2 r2Var = new r2();
        this.a.d(x.a.c(r2Var, "dashboard"));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m0(String string) {
        n.f(string, "type");
        r2 r2Var = new r2();
        o2 o2Var = new o2();
        this.a.d(x.r.c(r2Var, "dashboard", o2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n0() {
        this.a.d(x.i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p0() {
        this.a.d(x.n);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q0() {
        this.a.d(x.l);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r0() {
        this.a.d(x.k);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s0() {
        this.a.d(x.m);
    }
}
