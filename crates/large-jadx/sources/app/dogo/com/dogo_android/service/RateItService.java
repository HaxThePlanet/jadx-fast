package app.dogo.com.dogo_android.service;

import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.view.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.y.p;

/* compiled from: RateItService.kt */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u000f\u0018\u00002\u00020\u0001:\u0001DB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fJ\u0010\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u00103\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0006\u00104\u001a\u00020-J\u0010\u00105\u001a\u00020\u00102\u0008\u00100\u001a\u0004\u0018\u000106J\u0010\u00107\u001a\u00020\u00102\u0008\u00100\u001a\u0004\u0018\u000106J\u0006\u00108\u001a\u00020-J\u0006\u00109\u001a\u00020-J\u0006\u0010:\u001a\u00020-J\u0010\u0010:\u001a\u00020-2\u0008\u00100\u001a\u0004\u0018\u000106J\u0006\u0010;\u001a\u00020-J\u0010\u0010;\u001a\u00020-2\u0008\u00100\u001a\u0004\u0018\u000106J\u0010\u0010<\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u0010=\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u0010>\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0016\u0010?\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fJ\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020\u001fH\u0002J\u0006\u0010B\u001a\u00020-J\u0006\u0010C\u001a\u00020-R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\"\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010!\"\u0004\u0008&\u0010#R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010!\"\u0004\u0008)\u0010#R\u000e\u0010*\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E", d2 = {"Lapp/dogo/com/dogo_android/service/RateItService;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/service/AuthService;)V", "completedTricksCount", "", "didUserRate", "", "didUserShared", "isRateTimeoutEnded", "()Z", "isShareTimeoutEnded", "lastRatePopUpCall", "", "lastSharePopupCall", "listOfRatedTricksCount", "", "photoLikeThreshold", "photosLiked", "photosLikedShare", "rateItPopUpCallLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateItPopUpCallLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setRateItPopUpCallLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "reminderPopUpCallLiveData", "getReminderPopUpCallLiveData", "setReminderPopUpCallLiveData", "sharePopUpCallLiveData", "getSharePopUpCallLiveData", "setSharePopUpCallLiveData", "timeoutLengthMs", "trickThreshold", "callDialog", "", "launcher", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "source", "checkTriggerCondition", "checkTriggerConditionForReminders", "checkTriggerConditionForSharingApp", "incrementTrickCompletedCount", "isTimeToRateFor", "", "isTimeToShareAppFor", "markPhotoLiked", "markPhotoLikedForShare", "markUserRated", "markUserShared", "shouldTriggerRateUsPopUp", "shouldTriggerReminderPopUp", "shouldTriggerSharePopUp", "showShareDialog", "triggerLiveDataPopUpIfNeeded", "enumSource", "updateLastRateUsPopUpCallTime", "updateLastSharePopUpCallTime", "RateSource", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q2, reason: from kotlin metadata */
public final class RateItService {

    /* renamed from: a, reason: from kotlin metadata */
    private final p2 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final v2 completedTricksCount;
    /* renamed from: c, reason: from kotlin metadata */
    private final r2 didUserRate;
    /* renamed from: d, reason: from kotlin metadata */
    private final l1 didUserShared;
    private final h2 e;
    private final int f = 3;
    /* renamed from: g, reason: from kotlin metadata */
    private final int lastRatePopUpCall = 10;
    /* renamed from: h, reason: from kotlin metadata */
    private final List<Integer> lastSharePopupCall;
    /* renamed from: i, reason: from kotlin metadata */
    private boolean listOfRatedTricksCount;
    /* renamed from: j, reason: from kotlin metadata */
    private boolean photoLikeThreshold;
    /* renamed from: k, reason: from kotlin metadata */
    private int photosLiked;
    /* renamed from: l, reason: from kotlin metadata */
    private final long photosLikedShare;
    /* renamed from: m, reason: from kotlin metadata */
    private int preferenceService;
    private int n;
    private long o;
    /* renamed from: p, reason: from kotlin metadata */
    private long reminderRepository;
    /* renamed from: q, reason: from kotlin metadata */
    private x<q2.a> remoteConfigService = new x<>();
    private x<q2.a> r = new x<>();
    /* renamed from: s, reason: from kotlin metadata */
    private x<q2.a> timeoutLengthMs = new x<>();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0001\u0018\u0000 \r2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000c¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "PHOTO_LIKE", "LESSON_LIST_SECOND_ITEM", "SETTINGS_RATE", "USER_SCORE_RATE", "TRICK_LIST", "UNDEFINED", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum a {

        LESSON_LIST_SECOND_ITEM,
        PHOTO_LIKE,
        SETTINGS_RATE,
        TRICK_LIST,
        UNDEFINED,
        USER_SCORE_RATE;

        private final String tag;
        @Override // java.lang.Enum
        public final String getTag() {
            return this.tag;
        }

        private static final /* synthetic */ q2.a[] $values() {
            app.dogo.com.dogo_android.service.q2.a[] arr = new q2.a[6];
            return new q2.a[] { RateItService_RateSource.PHOTO_LIKE, RateItService_RateSource.LESSON_LIST_SECOND_ITEM, RateItService_RateSource.SETTINGS_RATE, RateItService_RateSource.USER_SCORE_RATE, RateItService_RateSource.TRICK_LIST, RateItService_RateSource.UNDEFINED };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[RateItService_RateSource.values().length];
            iArr[RateItService_RateSource.TRICK_LIST.ordinal()] = 1;
            iArr[RateItService_RateSource.PHOTO_LIKE.ordinal()] = 2;
            iArr[RateItService_RateSource.LESSON_LIST_SECOND_ITEM.ordinal()] = 3;
            iArr[RateItService_RateSource.USER_SCORE_RATE.ordinal()] = 4;
            iArr[RateItService_RateSource.SETTINGS_RATE.ordinal()] = 5;
            q2.b.a = iArr;
        }
    }
    public q2(p2 p2Var, v2 v2Var, r2 r2Var, l1 l1Var, h2 h2Var) {
        n.f(p2Var, "preferenceService");
        n.f(v2Var, "utilities");
        n.f(r2Var, "remoteConfigService");
        n.f(l1Var, "reminderRepository");
        n.f(h2Var, "authService");
        super();
        this.authService = p2Var;
        this.completedTricksCount = v2Var;
        this.didUserRate = r2Var;
        this.didUserShared = l1Var;
        this.e = h2Var;
        Integer[] arr = new Integer[3];
        int i10 = 2;
        arr[i10] = 15;
        this.lastSharePopupCall = p.j(arr);
        this.photosLikedShare = TimeUnit.DAYS.toMillis(1L);
        x xVar = new x();
        x xVar2 = new x();
        x xVar3 = new x();
        this.listOfRatedTricksCount = p2Var.c0();
        this.photoLikeThreshold = p2Var.e0();
        this.photosLiked = p2Var.o();
        this.preferenceService = p2Var.S();
        this.n = p2Var.X();
        this.o = p2Var.I();
        this.reminderRepository = p2Var.J();
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean checkTriggerCondition(q2.a source) {
        boolean z = false;
        int lastRatePopUpCall2 = 3;
        int photosLiked2;
        photosLiked2 = q2.b.a[source.ordinal()];
        int i2 = 0;
        final int i = 1;
        if (photosLiked2 == i || photosLiked2 == 2 || photosLiked2 == 3 || photosLiked2 == 4 || photosLiked2 == 5) {
        }
        return z;
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean checkTriggerConditionForReminders(q2.a source) {
        int photosLiked2;
        final boolean z = false;
        if (source == RateItService_RateSource.TRICK_LIST) {
            if (this.authService.K() == this.photosLiked) {
                return false;
            }
            Iterator it = this.lastSharePopupCall.iterator();
            while (it.hasNext()) {
                if ((Number)it.next().intValue() == this.photosLiked) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean checkTriggerConditionForSharingApp(q2.a source) {
        boolean z = false;
        int i2 = 5;
        long l2;
        int cmp;
        cmp = q2.b.a[source.ordinal()];
        int i3 = 0;
        final int i = 1;
        if (cmp == i || cmp == 2 || cmp == 5) {
        }
        return z;
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final boolean incrementTrickCompletedCount() {
        boolean z = true;
        long l2 = this.completedTricksCount.g() - this.o;
        int r0 = this.completedTricksCount > this.photosLikedShare ? 1 : 0;
        return (this.completedTricksCount > this.photosLikedShare ? 1 : 0);
    }

    private final boolean i() {
        boolean z = true;
        long l2 = this.completedTricksCount.g() - this.reminderRepository;
        int r0 = this.completedTricksCount > this.photosLikedShare ? 1 : 0;
        return (this.completedTricksCount > this.photosLikedShare ? 1 : 0);
    }

    /* renamed from: r, reason: from kotlin metadata */
    private final boolean isTimeToRateFor(q2.a source) {
        boolean listOfRatedTricksCount2;
        boolean z = true;
        if (!this.listOfRatedTricksCount) {
            source = !this.authService.d0(source) && checkTriggerCondition(source) && this.incrementTrickCompletedCount() ? 1 : 0;
        }
        return (!this.authService.d0(source) && checkTriggerCondition(source) && this.incrementTrickCompletedCount() ? 1 : 0);
    }

    /* renamed from: s, reason: from kotlin metadata */
    private final boolean isTimeToShareAppFor(q2.a source) {
        boolean z2 = false;
        source = !this.didUserShared.o(this.e.v()) && checkTriggerConditionForReminders(source) ? 1 : 0;
        return (!this.didUserShared.o(this.e.v()) && checkTriggerConditionForReminders(source) ? 1 : 0);
    }

    /* renamed from: t, reason: from kotlin metadata */
    private final boolean markUserRated(q2.a source) {
        boolean photoLikeThreshold2;
        boolean z2 = true;
        if (!this.photoLikeThreshold) {
            source = !this.authService.f0(source) && checkTriggerConditionForSharingApp(source) && this.i() ? 1 : 0;
        }
        return (!this.authService.f0(source) && checkTriggerConditionForSharingApp(source) && this.i() ? 1 : 0);
    }

    /* renamed from: v, reason: from kotlin metadata */
    private final void markUserShared(q2.a source) {
        if (isTimeToRateFor(source)) {
            this.remoteConfigService.postValue(source);
        } else {
            if (markUserRated(source)) {
                this.r.postValue(source);
            } else {
                if (isTimeToShareAppFor(source)) {
                    this.authService.b1(this.photosLiked);
                    this.timeoutLengthMs.postValue(source);
                }
            }
        }
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final void callDialog(a0 launcher, q2.a source) {
        n.f(launcher, "launcher");
        n.f(source, "source");
        app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(launcher, new RatePromptV2Screen(source.getTag()));
    }

    public final x<q2.a> e() {
        return this.remoteConfigService;
    }

    public final x<q2.a> f() {
        return this.r;
    }

    public final void g() {
        this.photosLiked++;
        this.authService.getDogHasPottyProblems(i);
        markUserShared(RateItService_RateSource.TRICK_LIST);
    }

    /* renamed from: j, reason: from kotlin metadata */
    public final boolean shouldTriggerRateUsPopUp(String source) {
        boolean listOfRatedTricksCount2;
        boolean z2 = true;
        app.dogo.com.dogo_android.service.q2.a aVar = RateItService_RateSource.INSTANCE.a(source);
        if (!this.listOfRatedTricksCount) {
            source = !this.authService.d0(aVar) && checkTriggerCondition(aVar) && this.incrementTrickCompletedCount() ? 1 : 0;
        }
        return (!this.authService.d0(aVar) && checkTriggerCondition(aVar) && this.incrementTrickCompletedCount() ? 1 : 0);
    }

    /* renamed from: k, reason: from kotlin metadata */
    public final boolean shouldTriggerReminderPopUp(String source) {
        boolean photoLikeThreshold2;
        boolean z3 = true;
        app.dogo.com.dogo_android.service.q2.a aVar = RateItService_RateSource.INSTANCE.a(source);
        if (!this.photoLikeThreshold) {
            source = !this.authService.f0(aVar) && checkTriggerConditionForSharingApp(aVar) && this.i() ? 1 : 0;
        }
        return (!this.authService.f0(aVar) && checkTriggerConditionForSharingApp(aVar) && this.i() ? 1 : 0);
    }

    public final void l() {
        if (!this.listOfRatedTricksCount) {
            pHOTO_LIKE2 = RateItService_RateSource.PHOTO_LIKE;
            if (!this.authService.d0(pHOTO_LIKE2) && !this.checkTriggerCondition(RateItService_RateSource.PHOTO_LIKE)) {
                this.preferenceService++;
                this.authService.m1(i);
                markUserShared(RateItService_RateSource.PHOTO_LIKE);
            }
        }
    }

    public final void m() {
        if (!this.photoLikeThreshold) {
            pHOTO_LIKE2 = RateItService_RateSource.PHOTO_LIKE;
            if (!this.authService.f0(pHOTO_LIKE2) && !this.checkTriggerConditionForSharingApp(RateItService_RateSource.PHOTO_LIKE)) {
                this.n++;
                this.authService.p1(i2);
                markUserShared(RateItService_RateSource.PHOTO_LIKE);
            }
        }
    }

    public final void n() {
        if (!this.listOfRatedTricksCount) {
            boolean z = true;
            this.authService.w1(z);
            this.listOfRatedTricksCount = z;
        }
    }

    /* renamed from: o, reason: from kotlin metadata */
    public final void shouldTriggerSharePopUp(String source) {
        if (!this.listOfRatedTricksCount) {
            boolean z = true;
            this.authService.setRecommendedProgramFor(RateItService_RateSource.INSTANCE.a(source), z);
            this.listOfRatedTricksCount = z;
        }
    }

    public final void p() {
        if (!this.photoLikeThreshold) {
            boolean z = true;
            this.authService.y1(z);
            this.photoLikeThreshold = z;
        }
    }

    /* renamed from: q, reason: from kotlin metadata */
    public final void triggerLiveDataPopUpIfNeeded(String enumSource) {
        if (!this.photoLikeThreshold) {
            boolean z = true;
            this.authService.setUserRateSate(RateItService_RateSource.INSTANCE.a(enumSource), z);
            this.photoLikeThreshold = z;
        }
    }

    /* renamed from: u, reason: from kotlin metadata */
    public final void showShareDialog(a0 launcher, q2.a source) {
        n.f(launcher, "launcher");
        n.f(source, "source");
        app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(launcher, new SharePromptScreen(source.getTag()));
    }

    public final void w() {
        long l = this.completedTricksCount.g();
        this.o = l;
        this.authService.Z0(l);
        this.remoteConfigService.postValue(null);
    }

    public final void x() {
        long l = this.completedTricksCount.g();
        this.reminderRepository = l;
        this.authService.a1(l);
        this.r.postValue(null);
    }
}
