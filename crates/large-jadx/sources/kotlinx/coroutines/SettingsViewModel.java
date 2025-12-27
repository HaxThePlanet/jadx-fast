package app.dogo.com.dogo_android.t;

import androidx.fragment.app.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.a0.c;
import app.dogo.com.dogo_android.k.m;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.repository.domain.SettingsResults;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecord;
import app.dogo.com.dogo_android.s.a.k3;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.j0;
import app.dogo.com.dogo_android.w.k0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import com.google.firebase.auth.AuthResult;
import java.util.Calendar;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = "\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0015\n\u0002\u0010\u000e\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0019\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0006\u0010_\u001a\u00020`J\u0006\u0010a\u001a\u00020`J\u0006\u0010b\u001a\u00020`J\u0018\u0010c\u001a\u00020`2\u0006\u0010d\u001a\u00020A2\u0006\u0010e\u001a\u00020]H\u0002J\u0006\u0010f\u001a\u00020`J\u0006\u0010g\u001a\u00020`J\u0006\u0010h\u001a\u00020`J\u0006\u0010i\u001a\u00020(J\u0006\u0010j\u001a\u00020`J\u0006\u0010k\u001a\u00020`J\u0006\u0010l\u001a\u00020`J\u0008\u0010m\u001a\u00020(H\u0002J\u0006\u0010n\u001a\u00020(J\u000e\u0010o\u001a\u00020`2\u0006\u0010p\u001a\u00020qJ\u0006\u0010r\u001a\u00020`J\u0006\u0010s\u001a\u00020`J\u0006\u0010t\u001a\u00020`J\u0006\u0010u\u001a\u00020`J\u0006\u0010v\u001a\u00020`J\u0006\u0010w\u001a\u00020`J\u0006\u0010x\u001a\u00020`J\u0006\u0010y\u001a\u00020`J\u0006\u0010z\u001a\u00020`J\u0006\u0010{\u001a\u00020`J\u0006\u0010|\u001a\u00020`J\u0006\u0010}\u001a\u00020`J\u0006\u0010~\u001a\u00020`J\u0006\u0010\u007f\u001a\u00020(J\u0016\u0010\u0080\u0001\u001a\u00020`2\r\u0010\u0081\u0001\u001a\u0008\u0012\u0004\u0012\u00020V0'J\u0007\u0010\u0082\u0001\u001a\u00020`J\u0012\u0010\u0083\u0001\u001a\u00020`2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010]J\u0007\u0010\u0085\u0001\u001a\u00020`J\u0019\u0010\u0086\u0001\u001a\u00020`2\u0006\u0010d\u001a\u00020A2\u0006\u0010e\u001a\u00020]H\u0002J\u0007\u0010\u0087\u0001\u001a\u00020AJ\u0007\u0010\u0088\u0001\u001a\u00020`R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u001d\u0010%\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020(0'0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020(0'0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010)R\u0017\u0010.\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010)R\u0017\u00100\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010)R\u0017\u00102\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010)R\u0017\u00104\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010)R\u0017\u00106\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010)R\u0017\u00108\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010)R\u0017\u0010:\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010)R\u0017\u0010<\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010)R\u0017\u0010>\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010)R\u0017\u0010@\u001a\u0008\u0012\u0004\u0012\u00020A0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u0010)R\u0017\u0010C\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010)R\u0017\u0010E\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010)R\u0017\u0010G\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008H\u0010)R\u0017\u0010I\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008J\u0010)R\u0017\u0010K\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010)R\u0017\u0010M\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010)R\u0017\u0010O\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010)R\u0017\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008R\u0010)R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010S\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010)R\u001d\u0010U\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020V0'0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010 R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010X\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008Y\u0010)R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020V0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008[\u0010)R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\\\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010]0'0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008^\u0010 R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "settingsInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SettingsInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "timeUtilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "utilities", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/SettingsInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;)V", "configurationLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/settings/SettingsScreenConfiguration;", "getConfigurationLiveData", "()Landroidx/lifecycle/MutableLiveData;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getCoroutineExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "isPurchaseRestored", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "()Lcom/hadilq/liveevent/LiveEvent;", "lastClickMs", "", "logOutComplete", "getLogOutComplete", "logOutInitiated", "getLogOutInitiated", "loginInitiated", "getLoginInitiated", "openClicker", "getOpenClicker", "openContactUs", "getOpenContactUs", "openDebugMenu", "getOpenDebugMenu", "openFacebook", "getOpenFacebook", "openFaq", "getOpenFaq", "openHelpCenter", "getOpenHelpCenter", "openInstagram", "getOpenInstagram", "openInvite", "", "getOpenInvite", "openLanguageSelect", "getOpenLanguageSelect", "openLegacyExam", "getOpenLegacyExam", "openRateUs", "getOpenRateUs", "openRedeemCode", "getOpenRedeemCode", "openReminder", "getOpenReminder", "openResubscribe", "getOpenResubscribe", "openTiktok", "getOpenTiktok", "openYoutube", "getOpenYoutube", "restorePurchaseInitiated", "getRestorePurchaseInitiated", "result", "Lapp/dogo/com/dogo_android/repository/domain/SettingsResults;", "getResult", "stillLoadingNotifier", "getStillLoadingNotifier", "subscriptionInitiated", "getSubscriptionInitiated", "trainingReminder", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "getTrainingReminder", "changeLanguageButton", "", "clickerButton", "contactUsPressed", "createReminder", "userId", "reminderModel", "debugMenuButton", "facebookButton", "faqButton", "hasZendeskRequestHistory", "helpCenterButton", "instagramButton", "inviteButton", "isClickTimeoutOver", "isZendeskHelpCenterEnabled", "launchRateUsFlow", "activity", "Landroidx/fragment/app/FragmentActivity;", "legacyExamButton", "loadData", "loadTrainingReminder", "logOutButton", "loginButton", "logout", "rateButtonPressed", "redeemCodeButton", "refreshDynamicUiData", "reminderButton", "restorePurchase", "restorePurchaseButton", "resubscribeButton", "shouldShowNewsletter", "subscriptionButton", "data", "tiktokButton", "toggleDailyReminderState", "reminder", "trackLoginCancel", "updateReminder", "versionCode", "youtubeButton", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f0, reason: from kotlin metadata */
public final class SettingsViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final f0.a INSTANCE = new f0$a(0);
    /* renamed from: A, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> authService = new a<>();
    private final f.d.a.a<Boolean> B = new a<>();
    /* renamed from: C, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> connectivityService = new a<>();
    private final f.d.a.a<Boolean> D = new a<>();
    private final f.d.a.a<Boolean> E = new a<>();
    /* renamed from: F, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> lastClickMs = new a<>();
    private final f.d.a.a<Boolean> G = new a<>();
    private final f.d.a.a<String> H = new a<>();
    private final f.d.a.a<Boolean> I = new a<>();
    private final f.d.a.a<Boolean> J = new a<>();
    private final f.d.a.a<Boolean> K = new a<>();
    private long L;
    private final o3 a;
    private final c b;
    private final h2 c;
    private final app.dogo.com.dogo_android.service.r2 d;
    private final p2 e;
    private final k3 f;
    private final j2 g;
    private final q2 h;
    private final p1 i;
    private final v2 j;
    private final n3 k;
    private final l1 l;
    private final x<y<SettingsResults>> m = new x<>();
    /* renamed from: n, reason: from kotlin metadata */
    private final x<y<RemindersModel>> preferenceService = new x<>();
    /* renamed from: o, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> rateItService = new a<>();
    /* renamed from: p, reason: from kotlin metadata */
    private final f.d.a.a<y<Boolean>> rateRepository = new a<>();
    /* renamed from: q, reason: from kotlin metadata */
    private final x<e0> reminderRepository = new x<>();
    /* renamed from: r, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> remoteConfigService = new a<>();
    private final f.d.a.a<Boolean> s = new a<>();
    private final f.d.a.a<y<Boolean>> t = new a<>();
    /* renamed from: u, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> settingsInteractor = new a<>();
    private final f.d.a.a<SettingsResults> v = new a<>();
    /* renamed from: w, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> subscribeInteractor = new a<>();
    private final f.d.a.a<Boolean> x = new a<>();
    /* renamed from: y, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> timeUtilities = new a<>();
    /* renamed from: z, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> tracker = new a<>();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsViewModel$Companion;", "", "()V", "DEBOUNCE_TIMEOUT_MS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f0.this.P().postValue(new LoadResult_Error(th));
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ RemindersModel $reminderModel;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            if (this.$reminderModel.isActive()) {
                f0.this.a.setUserId(this.$reminderModel);
            }
            f0.this.P().postValue(new LoadResult_Success(this.$reminderModel));
        }

        c(RemindersModel remindersModel, f0 f0Var) {
            this.$reminderModel = remindersModel;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f0.this.M().postValue(new LoadResult_Error(th));
        }

        e() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/SettingsResults;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends kotlin.d0.d.p implements kotlin.d0.c.l<SettingsResults, w> {
        @Override // kotlin.d0.d.p
        public final void a(SettingsResults set) {
            f0.this.M().postValue(new LoadResult_Success(set));
        }

        f() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f0.this.P().postValue(new LoadResult_Error(th));
        }

        g() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends kotlin.d0.d.p implements kotlin.d0.c.l<RemindersModel, w> {
        @Override // kotlin.d0.d.p
        public final void a(RemindersModel remindersModel) {
            Object obj = null;
            if (remindersModel.isEmpty()) {
                int i = 0;
            }
            f0.this.P().postValue(new LoadResult_Success(obj));
        }

        h() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f0.this.e.b();
            f0.this.t().postValue(new LoadResult_Error(th));
        }

        i() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/firebase/auth/AuthResult;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class j extends kotlin.d0.d.p implements kotlin.d0.c.l<AuthResult, w> {
        @Override // kotlin.d0.d.p
        public final void a(AuthResult authResult) {
            f0.this.a.logEvent(E_Auth.c);
            f0.this.e.b();
            f0.this.t().postValue(new LoadResult_Success(Boolean.TRUE));
        }

        j() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f0.this.isPurchaseRestored().postValue(new LoadResult_Error(th));
        }

        k() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class l extends kotlin.d0.d.p implements kotlin.d0.c.l<Boolean, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Boolean boolean) {
            f0.this.isPurchaseRestored().postValue(new LoadResult_Success(boolean));
        }

        l() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class m extends kotlin.b0.a implements CoroutineExceptionHandler {
        public m(CoroutineExceptionHandler.a exc) {
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            a.d(exception);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class n extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f0.this.P().postValue(new LoadResult_Error(th));
        }

        n() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class o extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ RemindersModel $reminderModel;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            if (this.$reminderModel.isActive()) {
                f0.this.a.setUserId(this.$reminderModel);
            }
            f0.this.P().postValue(new LoadResult_Success(this.$reminderModel));
        }

        o(RemindersModel remindersModel, f0 f0Var) {
            this.$reminderModel = remindersModel;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.SettingsViewModel$launchRateUsFlow$1", f = "SettingsViewModel.kt", l = 277, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements kotlin.d0.c.p<kotlinx.coroutines.m0, d<? super w>, Object> {

        final /* synthetic */ e $activity;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            com.google.android.play.core.review.ReviewInfo reviewInfo;
            Object obj = b.d();
            int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    f0.this.b.d(this.$activity, (ReviewInfo)reviewInfo, RateItService_RateSource.SETTINGS_RATE.getTag());
                    return w.a;
                }
            }
            q.b(object);
            this.label = i;
            if (f0.this.b.g(this) == obj) {
                return obj;
            }
        }

        d(e eVar, d<? super f0.d> dVar) {
            this.$activity = eVar;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(kotlinx.coroutines.m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.f0.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.f0.d(f0.this, this.$activity, dVar);
        }
    }
    public f0(o3 o3Var, c cVar, h2 h2Var, app.dogo.com.dogo_android.service.r2 r2Var, p2 p2Var, k3 k3Var, j2 j2Var, q2 q2Var, p1 p1Var, v2 v2Var, n3 n3Var, v2 v2Var2, l1 l1Var) {
        n.f(o3Var, "tracker");
        n.f(cVar, "rateRepository");
        n.f(h2Var, "authService");
        n.f(r2Var, "remoteConfigService");
        n.f(p2Var, "preferenceService");
        n.f(k3Var, "settingsInteractor");
        n.f(j2Var, "connectivityService");
        n.f(q2Var, "rateItService");
        n.f(p1Var, "userRepository");
        n.f(v2Var, "timeUtilities");
        n.f(n3Var, "subscribeInteractor");
        n.f(v2Var2, "utilities");
        n.f(l1Var, "reminderRepository");
        super();
        this.a = o3Var;
        this.b = cVar;
        this.c = h2Var;
        this.d = r2Var;
        this.e = p2Var;
        this.f = k3Var;
        this.g = j2Var;
        this.h = q2Var;
        this.i = p1Var;
        this.j = v2Var;
        this.k = n3Var;
        this.l = l1Var;
        x xVar = new x();
        x xVar2 = new x();
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
        x xVar3 = new x();
        f.d.a.a aVar3 = new a();
        f.d.a.a aVar4 = new a();
        f.d.a.a aVar5 = new a();
        f.d.a.a aVar6 = new a();
        f.d.a.a aVar7 = new a();
        f.d.a.a aVar8 = new a();
        f.d.a.a aVar9 = new a();
        f.d.a.a aVar10 = new a();
        f.d.a.a aVar11 = new a();
        f.d.a.a aVar12 = new a();
        f.d.a.a aVar13 = new a();
        f.d.a.a aVar14 = new a();
        f.d.a.a aVar15 = new a();
        f.d.a.a aVar16 = new a();
        f.d.a.a aVar17 = new a();
        f.d.a.a aVar18 = new a();
        f.d.a.a aVar19 = new a();
        f.d.a.a aVar20 = new a();
        f.d.a.a aVar21 = new a();
        f.d.a.a aVar22 = new a();
        f.d.a.a aVar23 = new a();
        e0();
    }

    /* renamed from: U, reason: from kotlin metadata */
    private final boolean changeLanguageButton() {
        boolean z = true;
        long l2 = this.j.g() - this.L;
        if (this.j > 500) {
            this.L = this.j.g();
            int i = 1;
        } else {
            int i2 = 0;
        }
        return z;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ p2 launchRateUsFlow(f0 activity) {
        return activity.e;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ c subscriptionButton(f0 data) {
        return data.b;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ o3 toggleDailyReminderState(f0 reminder) {
        return reminder.a;
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void createReminder(String userId, RemindersModel reminderModel) {
        this.preferenceService.postValue(LoadResult_Loading.a);
        i.b.b bVar5 = this.l.I(userId, reminderModel).q(a.b()).y(a.b());
        n.e(bVar5, "reminderRepository.saveTrainingReminder(userId, reminderModel)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.d(bVar5, new kotlinx.coroutines.f0.b(this), new kotlinx.coroutines.f0.c(reminderModel, this)));
    }

    /* renamed from: n0, reason: from kotlin metadata */
    private final void updateReminder(String userId, RemindersModel reminderModel) {
        this.preferenceService.postValue(LoadResult_Loading.a);
        i.b.b bVar4 = this.l.Z(userId, reminderModel.isActive()).q(a.b()).y(a.b());
        n.e(bVar4, "reminderRepository.updateTrainingReminderState(userId, reminderModel.isActive)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.d(bVar4, new kotlinx.coroutines.f0.n(this), new kotlinx.coroutines.f0.o(reminderModel, this)));
    }

    private final CoroutineExceptionHandler s() {
        return new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> A() {
        return this.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> B() {
        return this.D;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> C() {
        return this.I;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<String> D() {
        return this.H;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> E() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> F() {
        return this.B;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> G() {
        return this.timeUtilities;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> H() {
        return this.authService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> I() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> J() {
        return this.lastClickMs;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> K() {
        return this.E;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> L() {
        return this.subscribeInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<SettingsResults>> M() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> N() {
        return this.rateItService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<SettingsResults> O() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<RemindersModel>> P() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean Q() {
        int i = 0;
        boolean hasZendeskRequestHistory = false;
        LoadResult_Success r0 = this.m.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.m.getValue() : 0;
        int i2 = 0;
        if (this.m != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                hasZendeskRequestHistory = component1.getHasZendeskRequestHistory();
            }
        }
        return hasZendeskRequestHistory;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void R() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_General.b);
            this.D.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void S() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_SocialMedia.b);
            this.I.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void T() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_General.d);
            this.H.postValue(this.d.A());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean V() {
        return this.d.U(this.e.W());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void W(e eVar) {
        n.f(eVar, "activity");
        kotlinx.coroutines.internal.k.d(f0.a(this), s(), null, new kotlinx.coroutines.f0.d(this, eVar, null), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void X() {
        this.m.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.f.a().observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "settingsInteractor.getSettingsAsyncData()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new kotlinx.coroutines.f0.e(this), new kotlinx.coroutines.f0.f(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Y() {
        this.preferenceService.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.l.m(this.c.v()).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "reminderRepository.getTrainingReminderOrEmptyByUserId(authService.currentUserId)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new kotlinx.coroutines.f0.g(this), new kotlinx.coroutines.f0.h(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Z() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_Auth.d);
            this.remoteConfigService.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void a0() {
        if (changeLanguageButton()) {
            this.s.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void b0() {
        this.t.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.c.u0().observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "authService.signOut()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new kotlinx.coroutines.f0.i(this), new kotlinx.coroutines.f0.j(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void c0() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_RateDialog.a);
            this.h.n();
            this.B.postValue(Boolean.valueOf(this.d.C()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void d0() {
        if (changeLanguageButton()) {
            this.timeUtilities.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void e0() {
        Object value;
        Object obj;
        int i = 0;
        boolean canResubscribe = false;
        String str;
        int i2 = 1;
        i = 0;
        LoadResult_Success r0 = this.m.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.m.getValue() : i;
        str = "";
        if (this.c.D()) {
            UserAuthRecord userAuthRecord = this.c.A();
            if (userAuthRecord == null) {
            } else {
                String email = userAuthRecord.getEmail();
            }
            if (this.c == null || l.z(this.c)) {
                i2 = 1;
            }
            if (i2 != 0) {
                UserAuthRecord userAuthRecord2 = this.c.A();
                if (userAuthRecord2 == null) {
                } else {
                    String displayName = userAuthRecord2.getDisplayName();
                }
            }
            if (this.c != null) {
            }
        }
        if (this.m != null) {
        }
        if (i != 0) {
            canResubscribe = i.getCanResubscribe();
        }
        SettingsScreenConfiguration settingsScreenConfiguration = new SettingsScreenConfiguration(canResubscribe, this.c.D(), str);
        r().setValue(settingsScreenConfiguration);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void f0() {
        if (changeLanguageButton()) {
            this.authService.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void g0() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_General.i);
            this.subscribeInteractor.postValue(Boolean.valueOf(this.g.getActiveNetworkType()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h0() {
        if (changeLanguageButton()) {
            this.x.postValue(Boolean.valueOf(this.g.getActiveNetworkType()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean i0() {
        boolean z2 = false;
        String str;
        if (this.c.D()) {
            str = "marketing_emails_v1";
            int r0 = !this.i.M(str) ? 1 : 0;
        }
        return (!this.i.M(str) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<Boolean>> isPurchaseRestored() {
        return this.rateRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j0(y<SettingsResults> yVar) {
        n.f(yVar, "data");
        this.a.logEvent(E_General.k);
        if (changeLanguageButton()) {
            if (yVar instanceof LoadResult_Success) {
                Object component1 = yVar.component1();
                n.d(component1);
                this.v.postValue(component1);
            } else {
                this.rateItService.postValue(Boolean.TRUE);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        if (changeLanguageButton()) {
            this.tracker.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k0() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_SocialMedia.c);
            this.lastClickMs.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        if (changeLanguageButton()) {
            this.settingsInteractor.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l0(RemindersModel remindersModel) {
        boolean z;
        o3 o3Var;
        app.dogo.com.dogo_android.w.t2 t2Var;
        boolean z3 = true;
        int i5 = remindersModel == null ? z3 : active ^ z3;
        if (z) {
            this.a.logEvent(E_Reminders.c);
        } else {
            this.a.logEvent(E_Reminders.d);
        }
        if (remindersModel != null) {
            remindersModel.setActive(z);
            updateReminder(this.c.v(), remindersModel);
        } else {
            Calendar calendar = this.j.f();
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            boolean z2 = false;
            java.util.Map map = null;
            int i = 511;
            kotlin.d0.d.g gVar = null;
            RemindersModel remindersModel2 = new RemindersModel(null, null, str2, str3, str4, str5, str6, z2, map, i, gVar);
            remindersModel2.setId(UUID.randomUUID().toString());
            remindersModel2.setTimeWithInt(calendar.get(11), calendar.get(12));
            remindersModel2.setType(NotificationType.Training.getTag());
            remindersModel2.setRepeating(NotificationRepeating.Weekly.getTag());
            remindersModel2.setActive(z3);
            createReminder(this.c.v(), remindersModel2);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        if (changeLanguageButton()) {
            str = "settings";
            this.a.logEvent(E_General.n.c(new EP_ViewSource(), str));
            this.K.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m0() {
        this.a.logEvent(E_Auth.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        if (changeLanguageButton()) {
            if (App.INSTANCE.u()) {
                this.J.postValue(Boolean.TRUE);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_SocialMedia.a);
            this.G.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p0() {
        if (changeLanguageButton()) {
            this.a.logEvent(E_SocialMedia.d);
            this.E.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        if (changeLanguageButton()) {
            this.connectivityService.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<e0> r() {
        return this.reminderRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void restorePurchase() {
        this.rateRepository.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.k.j().observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "subscribeInteractor.restorePurchase()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new kotlinx.coroutines.f0.k(this), new kotlinx.coroutines.f0.l(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<Boolean>> t() {
        return this.t;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> u() {
        return this.remoteConfigService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> v() {
        return this.s;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> w() {
        return this.settingsInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> x() {
        return this.K;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> y() {
        return this.J;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> z() {
        return this.G;
    }


    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String o0() {
        return "Dogo App \nVersion 7.22.1(70220100)";
    }
}
