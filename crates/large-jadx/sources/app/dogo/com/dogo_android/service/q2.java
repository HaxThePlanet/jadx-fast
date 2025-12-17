package app.dogo.com.dogo_android.service;

import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.view.n;
import app.dogo.com.dogo_android.view.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u000f\u0018\u00002\u00020\u0001:\u0001DB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fJ\u0010\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u00103\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0006\u00104\u001a\u00020-J\u0010\u00105\u001a\u00020\u00102\u0008\u00100\u001a\u0004\u0018\u000106J\u0010\u00107\u001a\u00020\u00102\u0008\u00100\u001a\u0004\u0018\u000106J\u0006\u00108\u001a\u00020-J\u0006\u00109\u001a\u00020-J\u0006\u0010:\u001a\u00020-J\u0010\u0010:\u001a\u00020-2\u0008\u00100\u001a\u0004\u0018\u000106J\u0006\u0010;\u001a\u00020-J\u0010\u0010;\u001a\u00020-2\u0008\u00100\u001a\u0004\u0018\u000106J\u0010\u0010<\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u0010=\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u0010>\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001fH\u0002J\u0016\u0010?\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fJ\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020\u001fH\u0002J\u0006\u0010B\u001a\u00020-J\u0006\u0010C\u001a\u00020-R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\"\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010!\"\u0004\u0008&\u0010#R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010!\"\u0004\u0008)\u0010#R\u000e\u0010*\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E", d2 = {"Lapp/dogo/com/dogo_android/service/RateItService;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/service/AuthService;)V", "completedTricksCount", "", "didUserRate", "", "didUserShared", "isRateTimeoutEnded", "()Z", "isShareTimeoutEnded", "lastRatePopUpCall", "", "lastSharePopupCall", "listOfRatedTricksCount", "", "photoLikeThreshold", "photosLiked", "photosLikedShare", "rateItPopUpCallLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateItPopUpCallLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setRateItPopUpCallLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "reminderPopUpCallLiveData", "getReminderPopUpCallLiveData", "setReminderPopUpCallLiveData", "sharePopUpCallLiveData", "getSharePopUpCallLiveData", "setSharePopUpCallLiveData", "timeoutLengthMs", "trickThreshold", "callDialog", "", "launcher", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "source", "checkTriggerCondition", "checkTriggerConditionForReminders", "checkTriggerConditionForSharingApp", "incrementTrickCompletedCount", "isTimeToRateFor", "", "isTimeToShareAppFor", "markPhotoLiked", "markPhotoLikedForShare", "markUserRated", "markUserShared", "shouldTriggerRateUsPopUp", "shouldTriggerReminderPopUp", "shouldTriggerSharePopUp", "showShareDialog", "triggerLiveDataPopUpIfNeeded", "enumSource", "updateLastRateUsPopUpCallTime", "updateLastSharePopUpCallTime", "RateSource", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q2 {

    private final app.dogo.com.dogo_android.service.p2 a;
    private final app.dogo.com.dogo_android.service.v2 b;
    private final app.dogo.com.dogo_android.service.r2 c;
    private final l1 d;
    private final app.dogo.com.dogo_android.service.h2 e;
    private final int f = 3;
    private final int g = 10;
    private final List<Integer> h;
    private boolean i;
    private boolean j;
    private int k;
    private final long l;
    private int m;
    private int n;
    private long o;
    private long p;
    private x<app.dogo.com.dogo_android.service.q2.a> q;
    private x<app.dogo.com.dogo_android.service.q2.a> r;
    private x<app.dogo.com.dogo_android.service.q2.a> s;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0001\u0018\u0000 \r2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000c¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "PHOTO_LIKE", "LESSON_LIST_SECOND_ITEM", "SETTINGS_RATE", "USER_SCORE_RATE", "TRICK_LIST", "UNDEFINED", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum a {

        PHOTO_LIKE("photoLike"),
        LESSON_LIST_SECOND_ITEM("photoLike"),
        SETTINGS_RATE("photoLike"),
        USER_SCORE_RATE("photoLike"),
        TRICK_LIST("photoLike"),
        UNDEFINED("photoLike");

        private final String tag;
        private static final app.dogo.com.dogo_android.service.q2.a[] $values() {
            app.dogo.com.dogo_android.service.q2.a[] arr = new q2.a[6];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getTag() {
            return this.tag;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[q2.a.TRICK_LIST.ordinal()] = 1;
            iArr[q2.a.PHOTO_LIKE.ordinal()] = 2;
            iArr[q2.a.LESSON_LIST_SECOND_ITEM.ordinal()] = 3;
            iArr[q2.a.USER_SCORE_RATE.ordinal()] = 4;
            iArr[q2.a.SETTINGS_RATE.ordinal()] = 5;
            q2.b.a = iArr;
        }
    }
    public q2(app.dogo.com.dogo_android.service.p2 p2, app.dogo.com.dogo_android.service.v2 v22, app.dogo.com.dogo_android.service.r2 r23, l1 l14, app.dogo.com.dogo_android.service.h2 h25) {
        n.f(p2, "preferenceService");
        n.f(v22, "utilities");
        n.f(r23, "remoteConfigService");
        n.f(l14, "reminderRepository");
        n.f(h25, "authService");
        super();
        this.a = p2;
        this.b = v22;
        this.c = r23;
        this.d = l14;
        this.e = h25;
        Integer[] obj3 = new Integer[3];
        int obj5 = 2;
        obj3[obj5] = 15;
        this.h = p.j(obj3);
        this.l = TimeUnit.DAYS.toMillis(1);
        obj3 = new x();
        this.q = obj3;
        obj3 = new x();
        this.r = obj3;
        obj3 = new x();
        this.s = obj3;
        this.i = p2.c0();
        this.j = p2.e0();
        this.k = p2.o();
        this.m = p2.S();
        this.n = p2.X();
        this.o = p2.I();
        this.p = p2.J();
    }

    private final boolean b(app.dogo.com.dogo_android.service.q2.a q2$a) {
        int i;
        int i2;
        int obj4;
        obj4 = q2.b.a[a.ordinal()];
        i = 0;
        final int i3 = 1;
        if (obj4 != i3 && obj4 != 2 && obj4 != 3 && obj4 != 4 && obj4 != 5) {
            if (obj4 != 2) {
                if (obj4 != 3) {
                    if (obj4 != 4) {
                        if (obj4 != 5) {
                        } else {
                            i = i3;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean c(app.dogo.com.dogo_android.service.q2.a q2$a) {
        app.dogo.com.dogo_android.service.q2.a tRICK_LIST;
        int intValue;
        int i;
        Object obj4;
        final int i2 = 0;
        if (a == q2.a.TRICK_LIST && this.a.K() == this.k) {
            if (this.a.K() == this.k) {
                return i2;
            }
            obj4 = this.h.iterator();
            for (Number next : obj4) {
            }
        }
        return i2;
    }

    private final boolean d(app.dogo.com.dogo_android.service.q2.a q2$a) {
        int i;
        long l2;
        long l;
        int obj7;
        obj7 = q2.b.a[a.ordinal()];
        i = 0;
        final int i2 = 1;
        if (obj7 != i2 && obj7 != 2 && obj7 != 5) {
            if (obj7 != 2) {
                if (obj7 != 5) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean h() {
        int i;
        i = Long.compare(i2, l3) > 0 ? 1 : 0;
        return i;
    }

    private final boolean i() {
        int i;
        i = Long.compare(i2, l3) > 0 ? 1 : 0;
        return i;
    }

    private final boolean r(app.dogo.com.dogo_android.service.q2.a q2$a) {
        boolean z;
        app.dogo.com.dogo_android.service.q2.a obj3;
        if (!this.i && !this.a.d0(a) && b(a) && h()) {
            if (!this.a.d0(a)) {
                if (b(a)) {
                    obj3 = h() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private final boolean s(app.dogo.com.dogo_android.service.q2.a q2$a) {
        int obj3;
        if (!this.d.o(this.e.v()) && c(a)) {
            obj3 = c(a) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    private final boolean t(app.dogo.com.dogo_android.service.q2.a q2$a) {
        boolean z;
        app.dogo.com.dogo_android.service.q2.a obj3;
        if (!this.j && !this.a.f0(a) && d(a) && i()) {
            if (!this.a.f0(a)) {
                if (d(a)) {
                    obj3 = i() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private final void v(app.dogo.com.dogo_android.service.q2.a q2$a) {
        x xVar;
        int i;
        if (r(a)) {
            this.q.postValue(a);
        } else {
            if (t(a)) {
                this.r.postValue(a);
            } else {
                if (s(a)) {
                    this.a.b1(this.k);
                    this.s.postValue(a);
                }
            }
        }
    }

    public final void a(a0 a0, app.dogo.com.dogo_android.service.q2.a q2$a2) {
        n.f(a0, "launcher");
        n.f(a2, "source");
        n nVar = new n(a2.getTag());
        g1.X(a0, nVar);
    }

    public final x<app.dogo.com.dogo_android.service.q2.a> e() {
        return this.q;
    }

    public final x<app.dogo.com.dogo_android.service.q2.a> f() {
        return this.r;
    }

    public final void g() {
        i++;
        this.k = i2;
        this.a.C0(i2);
        v(q2.a.TRICK_LIST);
    }

    public final boolean j(String string) {
        boolean z;
        app.dogo.com.dogo_android.service.q2.a obj3;
        obj3 = q2.a.Companion.a(string);
        if (!this.i && !this.a.d0(obj3) && b(obj3) && h()) {
            if (!this.a.d0(obj3)) {
                if (b(obj3)) {
                    obj3 = h() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public final boolean k(String string) {
        boolean z;
        app.dogo.com.dogo_android.service.q2.a obj3;
        obj3 = q2.a.Companion.a(string);
        if (!this.j && !this.a.f0(obj3) && d(obj3) && i()) {
            if (!this.a.f0(obj3)) {
                if (d(obj3)) {
                    obj3 = i() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public final void l() {
        boolean z;
        app.dogo.com.dogo_android.service.q2.a pHOTO_LIKE;
        app.dogo.com.dogo_android.service.p2 p2Var;
        pHOTO_LIKE = q2.a.PHOTO_LIKE;
        if (!this.i && !this.a.d0(pHOTO_LIKE) && !b(pHOTO_LIKE)) {
            pHOTO_LIKE = q2.a.PHOTO_LIKE;
            if (!this.a.d0(pHOTO_LIKE)) {
                if (!b(pHOTO_LIKE)) {
                    i++;
                    this.m = z;
                    this.a.m1(z);
                    v(pHOTO_LIKE);
                }
            }
        }
    }

    public final void m() {
        boolean z;
        app.dogo.com.dogo_android.service.q2.a pHOTO_LIKE;
        app.dogo.com.dogo_android.service.p2 p2Var;
        pHOTO_LIKE = q2.a.PHOTO_LIKE;
        if (!this.j && !this.a.f0(pHOTO_LIKE) && !d(pHOTO_LIKE)) {
            pHOTO_LIKE = q2.a.PHOTO_LIKE;
            if (!this.a.f0(pHOTO_LIKE)) {
                if (!d(pHOTO_LIKE)) {
                    i++;
                    this.n = z;
                    this.a.p1(z);
                    v(pHOTO_LIKE);
                }
            }
        }
    }

    public final void n() {
        boolean z;
        int i;
        if (!this.i) {
            i = 1;
            this.a.w1(i);
            this.i = i;
        }
    }

    public final void o(String string) {
        boolean z;
        int i;
        if (!this.i) {
            i = 1;
            this.a.v1(q2.a.Companion.a(string), i);
            this.i = i;
        }
    }

    public final void p() {
        boolean z;
        int i;
        if (!this.j) {
            i = 1;
            this.a.y1(i);
            this.j = i;
        }
    }

    public final void q(String string) {
        boolean z;
        int i;
        if (!this.j) {
            i = 1;
            this.a.x1(q2.a.Companion.a(string), i);
            this.j = i;
        }
    }

    public final void u(a0 a0, app.dogo.com.dogo_android.service.q2.a q2$a2) {
        n.f(a0, "launcher");
        n.f(a2, "source");
        q qVar = new q(a2.getTag());
        g1.X(a0, qVar);
    }

    public final void w() {
        long l = this.b.g();
        this.o = l;
        this.a.Z0(l);
        this.q.postValue(0);
    }

    public final void x() {
        long l = this.b.g();
        this.p = l;
        this.a.a1(l);
        this.r.postValue(0);
    }
}
