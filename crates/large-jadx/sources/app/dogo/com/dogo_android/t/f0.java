package app.dogo.com.dogo_android.t;

import androidx.fragment.app.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.a0.c;
import app.dogo.com.dogo_android.k.l;
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
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.j0;
import app.dogo.com.dogo_android.w.k0;
import app.dogo.com.dogo_android.w.m0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import com.google.firebase.auth.AuthResult;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.util.Calendar;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
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
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0015\n\u0002\u0010\u000e\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0019\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0006\u0010_\u001a\u00020`J\u0006\u0010a\u001a\u00020`J\u0006\u0010b\u001a\u00020`J\u0018\u0010c\u001a\u00020`2\u0006\u0010d\u001a\u00020A2\u0006\u0010e\u001a\u00020]H\u0002J\u0006\u0010f\u001a\u00020`J\u0006\u0010g\u001a\u00020`J\u0006\u0010h\u001a\u00020`J\u0006\u0010i\u001a\u00020(J\u0006\u0010j\u001a\u00020`J\u0006\u0010k\u001a\u00020`J\u0006\u0010l\u001a\u00020`J\u0008\u0010m\u001a\u00020(H\u0002J\u0006\u0010n\u001a\u00020(J\u000e\u0010o\u001a\u00020`2\u0006\u0010p\u001a\u00020qJ\u0006\u0010r\u001a\u00020`J\u0006\u0010s\u001a\u00020`J\u0006\u0010t\u001a\u00020`J\u0006\u0010u\u001a\u00020`J\u0006\u0010v\u001a\u00020`J\u0006\u0010w\u001a\u00020`J\u0006\u0010x\u001a\u00020`J\u0006\u0010y\u001a\u00020`J\u0006\u0010z\u001a\u00020`J\u0006\u0010{\u001a\u00020`J\u0006\u0010|\u001a\u00020`J\u0006\u0010}\u001a\u00020`J\u0006\u0010~\u001a\u00020`J\u0006\u0010\u007f\u001a\u00020(J\u0016\u0010\u0080\u0001\u001a\u00020`2\r\u0010\u0081\u0001\u001a\u0008\u0012\u0004\u0012\u00020V0'J\u0007\u0010\u0082\u0001\u001a\u00020`J\u0012\u0010\u0083\u0001\u001a\u00020`2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010]J\u0007\u0010\u0085\u0001\u001a\u00020`J\u0019\u0010\u0086\u0001\u001a\u00020`2\u0006\u0010d\u001a\u00020A2\u0006\u0010e\u001a\u00020]H\u0002J\u0007\u0010\u0087\u0001\u001a\u00020AJ\u0007\u0010\u0088\u0001\u001a\u00020`R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u001d\u0010%\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020(0'0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020(0'0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010)R\u0017\u0010.\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010)R\u0017\u00100\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010)R\u0017\u00102\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010)R\u0017\u00104\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010)R\u0017\u00106\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010)R\u0017\u00108\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010)R\u0017\u0010:\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010)R\u0017\u0010<\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010)R\u0017\u0010>\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010)R\u0017\u0010@\u001a\u0008\u0012\u0004\u0012\u00020A0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u0010)R\u0017\u0010C\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010)R\u0017\u0010E\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010)R\u0017\u0010G\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008H\u0010)R\u0017\u0010I\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008J\u0010)R\u0017\u0010K\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010)R\u0017\u0010M\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010)R\u0017\u0010O\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010)R\u0017\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008R\u0010)R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010S\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010)R\u001d\u0010U\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020V0'0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010 R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010X\u001a\u0008\u0012\u0004\u0012\u00020(0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008Y\u0010)R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020V0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008[\u0010)R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\\\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010]0'0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008^\u0010 R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "settingsInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SettingsInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "timeUtilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "utilities", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/SettingsInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;)V", "configurationLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/settings/SettingsScreenConfiguration;", "getConfigurationLiveData", "()Landroidx/lifecycle/MutableLiveData;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getCoroutineExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "isPurchaseRestored", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "()Lcom/hadilq/liveevent/LiveEvent;", "lastClickMs", "", "logOutComplete", "getLogOutComplete", "logOutInitiated", "getLogOutInitiated", "loginInitiated", "getLoginInitiated", "openClicker", "getOpenClicker", "openContactUs", "getOpenContactUs", "openDebugMenu", "getOpenDebugMenu", "openFacebook", "getOpenFacebook", "openFaq", "getOpenFaq", "openHelpCenter", "getOpenHelpCenter", "openInstagram", "getOpenInstagram", "openInvite", "", "getOpenInvite", "openLanguageSelect", "getOpenLanguageSelect", "openLegacyExam", "getOpenLegacyExam", "openRateUs", "getOpenRateUs", "openRedeemCode", "getOpenRedeemCode", "openReminder", "getOpenReminder", "openResubscribe", "getOpenResubscribe", "openTiktok", "getOpenTiktok", "openYoutube", "getOpenYoutube", "restorePurchaseInitiated", "getRestorePurchaseInitiated", "result", "Lapp/dogo/com/dogo_android/repository/domain/SettingsResults;", "getResult", "stillLoadingNotifier", "getStillLoadingNotifier", "subscriptionInitiated", "getSubscriptionInitiated", "trainingReminder", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "getTrainingReminder", "changeLanguageButton", "", "clickerButton", "contactUsPressed", "createReminder", "userId", "reminderModel", "debugMenuButton", "facebookButton", "faqButton", "hasZendeskRequestHistory", "helpCenterButton", "instagramButton", "inviteButton", "isClickTimeoutOver", "isZendeskHelpCenterEnabled", "launchRateUsFlow", "activity", "Landroidx/fragment/app/FragmentActivity;", "legacyExamButton", "loadData", "loadTrainingReminder", "logOutButton", "loginButton", "logout", "rateButtonPressed", "redeemCodeButton", "refreshDynamicUiData", "reminderButton", "restorePurchase", "restorePurchaseButton", "resubscribeButton", "shouldShowNewsletter", "subscriptionButton", "data", "tiktokButton", "toggleDailyReminderState", "reminder", "trackLoginCancel", "updateReminder", "versionCode", "youtubeButton", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f0 extends s {

    public static final app.dogo.com.dogo_android.t.f0.a Companion;
    private final a<Boolean> A;
    private final a<Boolean> B;
    private final a<Boolean> C;
    private final a<Boolean> D;
    private final a<Boolean> E;
    private final a<Boolean> F;
    private final a<Boolean> G;
    private final a<String> H;
    private final a<Boolean> I;
    private final a<Boolean> J;
    private final a<Boolean> K;
    private long L;
    private final o3 a;
    private final c b;
    private final h2 c;
    private final r2 d;
    private final p2 e;
    private final k3 f;
    private final j2 g;
    private final q2 h;
    private final p1 i;
    private final v2 j;
    private final n3 k;
    private final l1 l;
    private final x<y<SettingsResults>> m;
    private final x<y<RemindersModel>> n;
    private final a<Boolean> o;
    private final a<y<Boolean>> p;
    private final x<app.dogo.com.dogo_android.t.e0> q;
    private final a<Boolean> r;
    private final a<Boolean> s;
    private final a<y<Boolean>> t;
    private final a<Boolean> u;
    private final a<SettingsResults> v;
    private final a<Boolean> w;
    private final a<Boolean> x;
    private final a<Boolean> y;
    private final a<Boolean> z;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsViewModel$Companion;", "", "()V", "DEBOUNCE_TIMEOUT_MS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        b(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
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
            y.a aVar = new y.a(throwable);
            this.this$0.P().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final RemindersModel $reminderModel;
        final app.dogo.com.dogo_android.t.f0 this$0;
        c(RemindersModel remindersModel, app.dogo.com.dogo_android.t.f0 f02) {
            this.$reminderModel = remindersModel;
            this.this$0 = f02;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            boolean active;
            RemindersModel $reminderModel;
            if (this.$reminderModel.isActive()) {
                f0.j(this.this$0).t(this.$reminderModel);
            }
            y.c cVar = new y.c(this.$reminderModel);
            this.this$0.P().postValue(cVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        e(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
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
            y.a aVar = new y.a(throwable);
            this.this$0.M().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/SettingsResults;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<SettingsResults, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        f(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(SettingsResults settingsResults) {
            y.c cVar = new y.c(settingsResults);
            this.this$0.M().postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((SettingsResults)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        g(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
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
            y.a aVar = new y.a(throwable);
            this.this$0.P().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements l<RemindersModel, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        h(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(RemindersModel remindersModel) {
            int obj3;
            if (remindersModel.isEmpty()) {
                obj3 = 0;
            }
            y.c cVar = new y.c(obj3);
            this.this$0.P().postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((RemindersModel)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        i(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
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
            f0.h(this.this$0).b();
            y.a aVar2 = new y.a(throwable);
            this.this$0.t().postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/firebase/auth/AuthResult;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class j extends p implements l<AuthResult, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        j(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(AuthResult authResult) {
            f0.j(this.this$0).c(p.c);
            f0.h(this.this$0).b();
            y.c cVar = new y.c(Boolean.TRUE);
            this.this$0.t().postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((AuthResult)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        k(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
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
            y.a aVar = new y.a(throwable);
            this.this$0.isPurchaseRestored().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class l extends p implements l<Boolean, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        l(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Boolean)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Boolean boolean) {
            y.c cVar = new y.c(boolean);
            this.this$0.isPurchaseRestored().postValue(cVar);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class m extends a implements CoroutineExceptionHandler {
        public m(CoroutineExceptionHandler.a coroutineExceptionHandler$a) {
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            a.d(throwable2);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class n extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.t.f0 this$0;
        n(app.dogo.com.dogo_android.t.f0 f0) {
            this.this$0 = f0;
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
            y.a aVar = new y.a(throwable);
            this.this$0.P().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class o extends p implements a<w> {

        final RemindersModel $reminderModel;
        final app.dogo.com.dogo_android.t.f0 this$0;
        o(RemindersModel remindersModel, app.dogo.com.dogo_android.t.f0 f02) {
            this.$reminderModel = remindersModel;
            this.this$0 = f02;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            boolean active;
            RemindersModel $reminderModel;
            if (this.$reminderModel.isActive()) {
                f0.j(this.this$0).t(this.$reminderModel);
            }
            y.c cVar = new y.c(this.$reminderModel);
            this.this$0.P().postValue(cVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.SettingsViewModel$launchRateUsFlow$1", f = "SettingsViewModel.kt", l = 277, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super w>, Object> {

        final e $activity;
        int label;
        final app.dogo.com.dogo_android.t.f0 this$0;
        d(app.dogo.com.dogo_android.t.f0 f0, e e2, d<? super app.dogo.com.dogo_android.t.f0.d> d3) {
            this.this$0 = f0;
            this.$activity = e2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (f0.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f0.d obj3 = new f0.d(this.this$0, this.$activity, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj4;
            Object obj = b.d();
            int label = this.label;
            int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    f0.i(this.this$0).d(this.$activity, (ReviewInfo)obj4, q2.a.SETTINGS_RATE.getTag());
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            this.label = i;
            if (f0.i(this.this$0).g(this) == obj) {
                return obj;
            }
        }
    }
    static {
        f0.a aVar = new f0.a(0);
        f0.Companion = aVar;
    }

    public f0(o3 o3, c c2, h2 h23, r2 r24, p2 p25, k3 k36, j2 j27, q2 q28, p1 p19, v2 v210, n3 n311, v2 v212, l1 l113) {
        n.f(o3, "tracker");
        n.f(c2, "rateRepository");
        n.f(h23, "authService");
        n.f(r24, "remoteConfigService");
        n.f(p25, "preferenceService");
        n.f(k36, "settingsInteractor");
        n.f(j27, "connectivityService");
        n.f(q28, "rateItService");
        n.f(p19, "userRepository");
        n.f(v210, "timeUtilities");
        n.f(n311, "subscribeInteractor");
        n.f(v212, "utilities");
        n.f(l113, "reminderRepository");
        super();
        this.a = o3;
        this.b = c2;
        this.c = h23;
        this.d = r24;
        this.e = p25;
        this.f = k36;
        this.g = j27;
        this.h = q28;
        this.i = p19;
        this.j = v210;
        this.k = n311;
        this.l = l113;
        x obj2 = new x();
        this.m = obj2;
        obj2 = new x();
        this.n = obj2;
        obj2 = new a();
        this.o = obj2;
        obj2 = new a();
        this.p = obj2;
        obj2 = new x();
        this.q = obj2;
        obj2 = new a();
        this.r = obj2;
        obj2 = new a();
        this.s = obj2;
        obj2 = new a();
        this.t = obj2;
        obj2 = new a();
        this.u = obj2;
        obj2 = new a();
        this.v = obj2;
        obj2 = new a();
        this.w = obj2;
        obj2 = new a();
        this.x = obj2;
        obj2 = new a();
        this.y = obj2;
        obj2 = new a();
        this.z = obj2;
        obj2 = new a();
        this.A = obj2;
        obj2 = new a();
        this.B = obj2;
        obj2 = new a();
        this.C = obj2;
        obj2 = new a();
        this.D = obj2;
        obj2 = new a();
        this.E = obj2;
        obj2 = new a();
        this.F = obj2;
        obj2 = new a();
        this.G = obj2;
        obj2 = new a();
        this.H = obj2;
        obj2 = new a();
        obj2 = new a();
        this.I = obj2;
        obj2 = new a();
        this.J = obj2;
        obj2 = new a();
        this.K = obj2;
        e0();
    }

    private final boolean U() {
        int i;
        if (Long.compare(i2, i3) > 0) {
            this.L = this.j.g();
            i = 1;
        } else {
            i = 0;
        }
        return i;
    }

    public static final p2 h(app.dogo.com.dogo_android.t.f0 f0) {
        return f0.e;
    }

    public static final c i(app.dogo.com.dogo_android.t.f0 f0) {
        return f0.b;
    }

    public static final o3 j(app.dogo.com.dogo_android.t.f0 f0) {
        return f0.a;
    }

    private final void n(String string, RemindersModel remindersModel2) {
        this.n.postValue(y.b.a);
        b obj4 = this.l.I(string, remindersModel2).q(a.b()).y(a.b());
        n.e(obj4, "reminderRepository.saveTrainingReminder(userId, reminderModel)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        f0.b bVar2 = new f0.b(this);
        f0.c cVar = new f0.c(remindersModel2, this);
        getDisposable().b(a.d(obj4, bVar2, cVar));
    }

    private final void n0(String string, RemindersModel remindersModel2) {
        this.n.postValue(y.b.a);
        b obj4 = this.l.Z(string, remindersModel2.isActive()).q(a.b()).y(a.b());
        n.e(obj4, "reminderRepository.updateTrainingReminderState(userId, reminderModel.isActive)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        f0.n nVar = new f0.n(this);
        f0.o oVar = new f0.o(remindersModel2, this);
        getDisposable().b(a.d(obj4, nVar, oVar));
    }

    private final CoroutineExceptionHandler s() {
        f0.m mVar = new f0.m(CoroutineExceptionHandler.r);
        return mVar;
    }

    public final a<Boolean> A() {
        return this.C;
    }

    public final a<Boolean> B() {
        return this.D;
    }

    public final a<Boolean> C() {
        return this.I;
    }

    public final a<String> D() {
        return this.H;
    }

    public final a<Boolean> E() {
        return this.z;
    }

    public final a<Boolean> F() {
        return this.B;
    }

    public final a<Boolean> G() {
        return this.y;
    }

    public final a<Boolean> H() {
        return this.A;
    }

    public final a<Boolean> I() {
        return this.x;
    }

    public final a<Boolean> J() {
        return this.F;
    }

    public final a<Boolean> K() {
        return this.E;
    }

    public final a<Boolean> L() {
        return this.w;
    }

    public final x<y<SettingsResults>> M() {
        return this.m;
    }

    public final a<Boolean> N() {
        return this.o;
    }

    public final a<SettingsResults> O() {
        return this.v;
    }

    public final x<y<RemindersModel>> P() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean Q() {
        int value;
        boolean hasZendeskRequestHistory;
        if (value instanceof y.c) {
        } else {
            value = 0;
        }
        hasZendeskRequestHistory = 0;
        if (value == null) {
        } else {
            value = value.a();
            if ((SettingsResults)value == null) {
            } else {
                hasZendeskRequestHistory = (SettingsResults)value.getHasZendeskRequestHistory();
            }
        }
        return hasZendeskRequestHistory;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void R() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.a.c(a0.b);
            this.D.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void S() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.a.c(m0.b);
            this.I.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void T() {
        boolean z;
        String str;
        if (U()) {
            this.a.c(a0.d);
            this.H.postValue(this.d.A());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean V() {
        return this.d.U(this.e.W());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void W(e e) {
        n.f(e, "activity");
        f0.d dVar = new f0.d(this, e, 0);
        k.d(f0.a(this), s(), 0, dVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void X() {
        this.m.postValue(y.b.a);
        a0 subscribeOn = this.f.a().observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "settingsInteractor.getSettingsAsyncData()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        f0.e eVar = new f0.e(this);
        f0.f fVar = new f0.f(this);
        getDisposable().b(a.g(subscribeOn, eVar, fVar));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Y() {
        this.n.postValue(y.b.a);
        a0 subscribeOn = this.l.m(this.c.v()).observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "reminderRepository.getTrainingReminderOrEmptyByUserId(authService.currentUserId)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        f0.g gVar = new f0.g(this);
        f0.h hVar = new f0.h(this);
        getDisposable().b(a.g(subscribeOn, gVar, hVar));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Z() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.a.c(p.d);
            this.r.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void a0() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.s.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void b0() {
        this.t.postValue(y.b.a);
        a0 subscribeOn = this.c.u0().observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "authService.signOut()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        f0.i iVar = new f0.i(this);
        f0.j jVar = new f0.j(this);
        getDisposable().b(a.g(subscribeOn, iVar, jVar));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void c0() {
        boolean z;
        Boolean valueOf;
        if (U()) {
            this.a.c(j0.a);
            this.h.n();
            this.B.postValue(Boolean.valueOf(this.d.C()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void d0() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.y.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void e0() {
        Object value;
        String displayName;
        int i;
        int canResubscribe;
        String str;
        boolean z;
        i = 0;
        if (value instanceof y.c) {
        } else {
            value = i;
        }
        str = "";
        if (this.c.D()) {
            UserAuthRecord userAuthRecord = this.c.A();
            if (userAuthRecord == null) {
                displayName = i;
            } else {
                displayName = userAuthRecord.getEmail();
            }
            if (displayName != null) {
                if (l.z(displayName)) {
                    z = 1;
                } else {
                    z = canResubscribe;
                }
            } else {
            }
            if (z != 0) {
                UserAuthRecord userAuthRecord2 = this.c.A();
                if (userAuthRecord2 == null) {
                    displayName = i;
                } else {
                    displayName = userAuthRecord2.getDisplayName();
                }
            }
            if (displayName == null) {
            } else {
                str = displayName;
            }
        }
        if (value == null) {
        } else {
            i = value;
        }
        if (i == 0) {
        } else {
            canResubscribe = i.getCanResubscribe();
        }
        e0 e0Var = new e0(canResubscribe, this.c.D(), str);
        r().setValue(e0Var);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void f0() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.A.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void g0() {
        boolean z;
        Boolean valueOf;
        if (U()) {
            this.a.c(a0.i);
            this.w.postValue(Boolean.valueOf(this.g.a()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h0() {
        boolean z;
        Boolean valueOf;
        if (U()) {
            this.x.postValue(Boolean.valueOf(this.g.a()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean i0() {
        boolean z;
        int i;
        String str;
        if (this.c.D() && !this.i.M("marketing_emails_v1")) {
            i = !this.i.M("marketing_emails_v1") ? 1 : 0;
        } else {
        }
        return i;
    }

    public final a<y<Boolean>> isPurchaseRestored() {
        return this.p;
    }

    public final void j0(y<SettingsResults> y) {
        boolean tRUE;
        Object obj3;
        n.f(y, "data");
        this.a.d(a0.k);
        if (U()) {
            if (y instanceof y.c) {
                obj3 = (y.c)y.a();
                n.d(obj3);
                this.v.postValue(obj3);
            } else {
                this.o.postValue(Boolean.TRUE);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.z.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k0() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.a.c(m0.c);
            this.F.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.u.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l0(RemindersModel remindersModel) {
        String i11;
        int i9;
        o3 o3Var;
        app.dogo.com.dogo_android.w.t2 t2Var;
        int i2;
        int i;
        int i10;
        int i3;
        int i4;
        int i5;
        int i6;
        int i8;
        int i7;
        RemindersModel remindersModel2;
        Object obj15;
        i11 = 1;
        if (remindersModel == null) {
            i9 = i11;
        } else {
            active ^= i11;
        }
        if (i9 != 0) {
            this.a.c(k0.c);
        } else {
            this.a.c(k0.d);
        }
        if (remindersModel != null) {
            remindersModel.setActive(i9);
            n0(this.c.v(), remindersModel);
        } else {
            obj15 = this.j.f();
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, 0);
            remindersModel2.setId(UUID.randomUUID().toString());
            remindersModel2.setTimeWithInt(obj15.get(11), obj15.get(12));
            remindersModel2.setType(m.Training.getTag());
            remindersModel2.setRepeating(l.Weekly.getTag());
            remindersModel2.setActive(i11);
            n(this.c.v(), remindersModel2);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        boolean z;
        Boolean tRUE;
        r2 r2Var;
        String str;
        if (U()) {
            r2Var = new r2();
            this.a.d(a0.n.c(r2Var, "settings"));
            this.K.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m0() {
        this.a.c(p.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        boolean z;
        Boolean tRUE;
        if (U() && App.Companion.u()) {
            if (App.Companion.u()) {
                this.J.postValue(Boolean.TRUE);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String o0() {
        return "Dogo App \nVersion 7.22.1(70220100)";
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.a.c(m0.a);
            this.G.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p0() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.a.c(m0.d);
            this.E.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        boolean z;
        Boolean tRUE;
        if (U()) {
            this.C.postValue(Boolean.TRUE);
        }
    }

    public final x<app.dogo.com.dogo_android.t.e0> r() {
        return this.q;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void restorePurchase() {
        this.p.postValue(y.b.a);
        a0 subscribeOn = this.k.j().observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "subscribeInteractor.restorePurchase()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        f0.k kVar = new f0.k(this);
        f0.l lVar = new f0.l(this);
        getDisposable().b(a.g(subscribeOn, kVar, lVar));
    }

    public final a<y<Boolean>> t() {
        return this.t;
    }

    public final a<Boolean> u() {
        return this.r;
    }

    public final a<Boolean> v() {
        return this.s;
    }

    public final a<Boolean> w() {
        return this.u;
    }

    public final a<Boolean> x() {
        return this.K;
    }

    public final a<Boolean> y() {
        return this.J;
    }

    public final a<Boolean> z() {
        return this.G;
    }
}
