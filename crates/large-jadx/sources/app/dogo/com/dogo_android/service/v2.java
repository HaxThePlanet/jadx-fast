package app.dogo.com.dogo_android.service;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.pm.PackageManager;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.text.format.DateUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.e0.a;
import kotlin.k0.h;
import kotlin.k0.l;
import n.a.a;
import net.time4j.f;
import net.time4j.g1.v;
import net.time4j.h;
import net.time4j.k0;
import net.time4j.x;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 I2\u00020\u0001:\u0002IJB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0018\u0010\u001d\u001a\u00020\u000b2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u000bJ\u0010\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u000eJ\u0016\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%J\u001e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J\u0016\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u000bJ\u0010\u0010/\u001a\u00020%2\u0008\u00100\u001a\u0004\u0018\u00010\u000bJ\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u000eJ\u0010\u00103\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0018\u00104\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000cH\u0002J \u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u0002092\u0008\u0010:\u001a\u0004\u0018\u00010;J\u0018\u00106\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;H\u0002J\u000e\u0010=\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000eJ\u000e\u0010>\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000eJ8\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020F2\u0008\u0010G\u001a\u0004\u0018\u00010HR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019¨\u0006K", d2 = {"Lapp/dogo/com/dogo_android/service/Utilities;", "", "packageManager", "Landroid/content/pm/PackageManager;", "(Landroid/content/pm/PackageManager;)V", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "currentAnimations", "", "", "Landroid/animation/Animator;", "currentTimeInMillis", "", "getCurrentTimeInMillis", "()J", "instalationId", "getInstalationId", "()Ljava/lang/String;", "r", "Ljava/util/regex/Pattern;", "getR", "()Ljava/util/regex/Pattern;", "setR", "(Ljava/util/regex/Pattern;)V", "cancelAnimation", "", "id", "convertCountryCodeToFlagUnicode", "countryCode", "fallbackFlagCode", "formatIsoTime", "expirationTimestamp", "getRelativeTimeSpan", "startTimeMillis", "abbreviated", "", "futurePossible", "getRelativeTimeSpanPeriod", "period", "getRelativeTimeSpanWeek", "hideKeyboard", "windowView", "Landroid/view/View;", "isEmojiOnly", "string", "isPackageInstalled", "packageName", "isToday", "timeInMillis", "onAnimEnd", "onAnimStart", "animation", "timeLocalisation", "number", "type", "Lapp/dogo/com/dogo_android/service/Utilities$TimeUnit;", "width", "Lnet/time4j/format/TextWidth;", "timeInMilliseconds", "timeLocalisationNarrow", "timeLocalisationShort", "timeLocalisationWide", "toggleHideHeightAnimation", "animationId", "show", "view", "duration", "originalHeight", "", "valueListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Companion", "TimeUnit", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class v2 {

    public static final app.dogo.com.dogo_android.service.v2.a Companion;
    private final PackageManager a;
    private final Map<String, Animator> b;
    private Pattern c;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u0008R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/service/Utilities$Companion;", "", "()V", "MAX_EMOJI_CHECKER_CHAR_LENGTH", "", "generateMinuteSecondTimeString", "", "seconds", "", "withMinutePadding", "", "getLocalisedTime", "number", "type", "Lapp/dogo/com/dogo_android/service/Utilities$TimeUnit;", "width", "Lnet/time4j/format/TextWidth;", "getRoughMonthDifference", "startTimestampMs", "endTimestampMs", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public static String b(app.dogo.com.dogo_android.service.v2.a v2$a, long l2, boolean z3, int i4, Object object5) {
            int obj3;
            if (object5 &= 2 != 0) {
                obj3 = 0;
            }
            return a.a(l2, z3);
        }

        public final String a(long l, boolean z2) {
            String obj8;
            final int i2 = 1;
            obj8 = obj8 != null ? "%02d:%02d" : "%d:%02d";
            f0 f0Var = f0.a;
            int i3 = 2;
            final Object[] arr = new Object[i3];
            arr[0] = Long.valueOf(TimeUnit.SECONDS.toMinutes(l));
            arr[1] = Long.valueOf(l % seconds);
            String obj6 = String.format(obj8, Arrays.copyOf(arr, i3));
            n.e(obj6, "java.lang.String.format(format, *args)");
            return obj6;
        }

        public final String c(long l, app.dogo.com.dogo_android.service.v2.b v2$b2, v v3) {
            k0 k0Var;
            String obj2;
            String obj3;
            x obj4;
            n.f(v3, "type");
            if (type instanceof f) {
                n.e(k0.d(Locale.getDefault()).e(l, b2, (f)v3.getType()), "{\n                PrettyTime.of(Locale.getDefault()).print(number, type.type, width)\n            }");
            } else {
                n.e(k0.d(Locale.getDefault()).f(l, b2, (h)v3.getType()), "{\n                PrettyTime.of(Locale.getDefault()).print(number, type.type as ClockUnit, width)\n            }");
            }
            return obj2;
        }

        public final int d(long l, long l2) {
            TimeUnit dAYS = TimeUnit.DAYS;
            long millis = dAYS.toMillis(365);
            l -= obj8;
            return (int)obj8;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000c\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/service/Utilities$TimeUnit;", "", "type", "Lnet/time4j/IsoUnit;", "threshold", "", "(Ljava/lang/String;ILnet/time4j/IsoUnit;J)V", "getThreshold", "()J", "getType", "()Lnet/time4j/IsoUnit;", "SECONDS", "MINUTES", "HOURS", "DAYS", "MONTHS", "YEARS", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum b {

        SECONDS(field_3, 1000, 3600000),
        SECONDS(field_3, 1000, 3600000),
        SECONDS(field_3, 1000, 3600000),
        SECONDS(field_3, 1000, 3600000),
        SECONDS(field_3, 1000, 3600000);

        private final long threshold;
        private final x type;
        private static final app.dogo.com.dogo_android.service.v2.b[] $values() {
            app.dogo.com.dogo_android.service.v2.b[] arr = new v2.b[6];
            return arr;
        }

        @Override // java.lang.Enum
        public final long getThreshold() {
            return this.threshold;
        }

        @Override // java.lang.Enum
        public final x getType() {
            return this.type;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/service/Utilities$toggleHideHeightAnimation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements Animator.AnimatorListener {

        final boolean a;
        final View b;
        final app.dogo.com.dogo_android.service.v2 c;
        final String d;
        final ValueAnimator e;
        c(boolean z, View view2, app.dogo.com.dogo_android.service.v2 v23, String string4, ValueAnimator valueAnimator5) {
            this.a = z;
            this.b = view2;
            this.c = v23;
            this.d = string4;
            this.e = valueAnimator5;
            super();
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator) {
            n.f(animator, "animation");
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationEnd(Animator animator) {
            String str;
            boolean obj2;
            n.f(animator, "animation");
            if (!this.a) {
                this.b.setVisibility(8);
            }
            v2.a(this.c, this.d);
            this.e.removeAllListeners();
            this.e.removeAllUpdateListeners();
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            n.f(animator, "animation");
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationStart(Animator animator) {
            boolean z;
            int i;
            n.f(animator, "animation");
            if (this.a) {
                this.b.setVisibility(0);
            }
            v2.b(this.c, this.d, animator);
        }
    }
    static {
        v2.a aVar = new v2.a(0);
        v2.Companion = aVar;
    }

    public v2(PackageManager packageManager) {
        n.f(packageManager, "packageManager");
        super();
        this.a = packageManager;
        HashMap obj2 = new HashMap();
        this.b = obj2;
        obj2 = Pattern.compile("^[\\s\n\r]*(?:(?:[©®‼⁉™ℹ↔-↙↩-↪⌚-⌛⌨⏏⏩-⏳⏸-⏺Ⓜ▪-▫▶◀◻-◾☀-☄☎☑☔-☕☘☝☠☢-☣☦☪☮-☯☸-☺♈-♓♠♣♥-♦♨♻♿⚒-⚔⚖-⚗⚙⚛-⚜⚠-⚡⚪-⚫⚰-⚱⚽-⚾⛄-⛅⛈⛎-⛏⛑⛓-⛔⛩-⛪⛰-⛵⛷-⛺⛽✂✅✈-✍✏✒✔✖✝✡✨✳-✴❄❇❌❎❓-❕❗❣-❤➕-➗➡➰➿⤴-⤵⬅-⬇⬛-⬜⭐⭕〰〽㊗㊙🀄🃏🅰-🅱🅾-🅿🆎🆑-🆚🈁-🈂🈚🈯🈲-🈺🉐-🉑‍🌀-🗿😀-🙏🚀-🛿🤀-🧿󠀠-󠁿]|‍[♀♂]|[🇦-🇿]{2}|.[⃠⃣️]+)+[\\s\n\r]*)+$");
        n.e(obj2, "compile(\"^[\\\\s\\n\\r]*(?:(?:[\\u00a9\\u00ae\\u203c\\u2049\\u2122\\u2139\\u2194-\\u2199\\u21a9-\\u21aa\\u231a-\\u231b\\u2328\\u23cf\\u23e9-\\u23f3\\u23f8-\\u23fa\\u24c2\\u25aa-\\u25ab\\u25b6\\u25c0\\u25fb-\\u25fe\\u2600-\\u2604\\u260e\\u2611\\u2614-\\u2615\\u2618\\u261d\\u2620\\u2622-\\u2623\\u2626\\u262a\\u262e-\\u262f\\u2638-\\u263a\\u2648-\\u2653\\u2660\\u2663\\u2665-\\u2666\\u2668\\u267b\\u267f\\u2692-\\u2694\\u2696-\\u2697\\u2699\\u269b-\\u269c\\u26a0-\\u26a1\\u26aa-\\u26ab\\u26b0-\\u26b1\\u26bd-\\u26be\\u26c4-\\u26c5\\u26c8\\u26ce-\\u26cf\\u26d1\\u26d3-\\u26d4\\u26e9-\\u26ea\\u26f0-\\u26f5\\u26f7-\\u26fa\\u26fd\\u2702\\u2705\\u2708-\\u270d\\u270f\\u2712\\u2714\\u2716\\u271d\\u2721\\u2728\\u2733-\\u2734\\u2744\\u2747\\u274c\\u274e\\u2753-\\u2755\\u2757\\u2763-\\u2764\\u2795-\\u2797\\u27a1\\u27b0\\u27bf\\u2934-\\u2935\\u2b05-\\u2b07\\u2b1b-\\u2b1c\\u2b50\\u2b55\\u3030\\u303d\\u3297\\u3299\\ud83c\\udc04\\ud83c\\udccf\\ud83c\\udd70-\\ud83c\\udd71\\ud83c\\udd7e-\\ud83c\\udd7f\\ud83c\\udd8e\\ud83c\\udd91-\\ud83c\\udd9a\\ud83c\\ude01-\\ud83c\\ude02\\ud83c\\ude1a\\ud83c\\ude2f\\ud83c\\ude32-\\ud83c\\ude3a\\ud83c\\ude50-\\ud83c\\ude51\\u200d\\ud83c\\udf00-\\ud83d\\uddff\\ud83d\\ude00-\\ud83d\\ude4f\\ud83d\\ude80-\\ud83d\\udeff\\ud83e\\udd00-\\ud83e\\uddff\\udb40\\udc20-\\udb40\\udc7f]|\\u200d[\\u2640\\u2642]|[\\ud83c\\udde6-\\ud83c\\uddff]{2}|.[\\u20e0\\u20e3\\ufe0f]+)+[\\\\s\\n\\r]*)+$\")");
        this.c = obj2;
    }

    public static final void a(app.dogo.com.dogo_android.service.v2 v2, String string2) {
        v2.q(string2);
    }

    public static final void b(app.dogo.com.dogo_android.service.v2 v2, String string2, Animator animator3) {
        v2.r(string2, animator3);
    }

    private final void c(String string) {
        Object obj = this.b.get(string);
        n.d(obj);
        (Animator)obj.cancel();
        this.b.remove(string);
    }

    public static void p(View view, ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener2, ValueAnimator valueAnimator3) {
        v2.x(view, animatorUpdateListener2, valueAnimator3);
    }

    private final void q(String string) {
        this.b.remove(string);
    }

    private final void r(String string, Animator animator2) {
        this.b.put(string, animator2);
    }

    private final String t(long l, v v2) {
        long cmp;
        app.dogo.com.dogo_android.service.v2.b mINUTES;
        int threshold;
        cmp = Math.abs(l);
        if (Long.compare(cmp, threshold3) >= 0) {
        } else {
            if (Long.compare(cmp, threshold4) >= 0) {
            } else {
                if (Long.compare(cmp, threshold5) >= 0) {
                } else {
                    if (Long.compare(cmp, threshold6) >= 0) {
                    } else {
                        if (Long.compare(cmp, threshold) >= 0) {
                        } else {
                            mINUTES = v2.b.SECONDS;
                        }
                    }
                }
            }
        }
        return s(l /= threshold2, v2, mINUTES);
    }

    private static final void x(View view, ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener2, ValueAnimator valueAnimator3) {
        n.f(view, "$view");
        n.f(valueAnimator3, "valueAnimator");
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Object animatedValue = valueAnimator3.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = (Integer)animatedValue.intValue();
        view.setLayoutParams(layoutParams);
        if (animatorUpdateListener2 == null) {
        } else {
            animatorUpdateListener2.onAnimationUpdate(valueAnimator3);
        }
    }

    public final String d(String string, String string2) {
        String string3;
        int length;
        int str;
        char[] obj4;
        Object obj5;
        n.f(string2, "fallbackFlagCode");
        int i = 0;
        if (string != null && string.length() == 2) {
            if (string.length() == 2) {
                h hVar = new h("[a-zA-Z]+");
                if (!hVar.d(string)) {
                    a.a("invalid countryCode", new Object[i]);
                } else {
                    obj5 = string.toUpperCase();
                    String str4 = "(this as java.lang.String).toUpperCase()";
                    n.e(obj5, str4);
                    int i2 = 127462;
                    obj4 = string.toUpperCase();
                    n.e(obj4, str4);
                    obj5 = Character.toChars(obj5 += i2);
                    n.e(obj5, "toChars(firstLetter)");
                    string3 = new String(obj5);
                    obj4 = Character.toChars(obj4 += i2);
                    n.e(obj4, "toChars(secondLetter)");
                    obj5 = new String(obj4);
                    obj5 = n.o(string3, obj5);
                }
            } else {
            }
        } else {
        }
        return obj5;
    }

    public final String e(long l) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = new Date(l, obj5);
        return simpleDateFormat.format(date);
    }

    public final Calendar f() {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        n.e(instance, "getInstance(Locale.getDefault())");
        return instance;
    }

    public final long g() {
        return System.currentTimeMillis();
    }

    public final String h() {
        String string = UUID.randomUUID().toString();
        n.e(string, "randomUUID().toString()");
        return string;
    }

    public final String i(long l, boolean z2) {
        int obj10;
        obj10 = obj10 != null ? 262144 : 0;
        return DateUtils.getRelativeTimeSpanString(l, obj1, g(), obj3).toString();
    }

    public final String j(long l, boolean z2, boolean z3) {
        long l2;
        String obj3;
        int obj6;
        if (obj6 == null && Long.compare(l, l2) > 0) {
            if (Long.compare(l, l2) > 0) {
                obj3 = i(obj3 -= l2, z2);
            } else {
                obj3 = i(l, z2);
            }
        } else {
        }
        return obj3;
    }

    public final String k(long l, boolean z2) {
        int obj10;
        obj10 = obj10 != null ? 262144 : 0;
        return DateUtils.getRelativeTimeSpanString(l, obj1, 0, obj3).toString();
    }

    public final String l(long l) {
        return DateUtils.getRelativeTimeSpanString(l, obj1, g(), obj3).toString();
    }

    public final void m(View view) {
        n.f(view, "windowView");
        Object systemService = view.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        (InputMethodManager)systemService.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public final boolean n(String string) {
        n.f(string, "string");
        return this.c.matcher(l.f1(string, 14)).find();
    }

    public final boolean o(String string) {
        n.d(string);
        this.a.getPackageInfo(string, 0);
        return 1;
    }

    public final String s(long l, app.dogo.com.dogo_android.service.v2.b v2$b2, v v3) {
        n.f(v3, "type");
        return v2.Companion.c(l, b2, v3);
    }

    public final String u(long l) {
        return t(l, obj3);
    }

    public final String v(long l) {
        return t(l, obj3);
    }

    public final void w(String string, boolean z2, View view3, long l4, int i5, ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener6) {
        int key;
        int height;
        int i2;
        Object i;
        Object obj2;
        int iArr;
        Object obj;
        ValueAnimator valueAnimator;
        app.dogo.com.dogo_android.service.v2.c obj10;
        ValueAnimator obj12;
        n.f(string, "animationId");
        n.f(view3, "view");
        i2 = 0;
        i = 1;
        key = view3.getVisibility() == 0 ? i : i2;
        if (key == z2) {
            if (this.b.containsKey(string) && this.b.containsKey(string)) {
                if (this.b.containsKey(string)) {
                    c(string);
                }
                android.view.ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                if (layoutParams.height < 0) {
                    layoutParams.height = animatorUpdateListener6;
                }
                iArr = 2;
                if (z2 != 0) {
                    iArr = new int[iArr];
                    iArr[i2] = layoutParams.height;
                    iArr[i] = animatorUpdateListener6;
                    obj12 = ValueAnimator.ofInt(iArr);
                } else {
                    obj12 = new int[iArr];
                    obj12[i2] = layoutParams.height;
                    obj12[i] = i;
                    obj12 = ValueAnimator.ofInt(obj12);
                }
                f2 f2Var = new f2(view3, obj13);
                obj12.addUpdateListener(f2Var);
                obj12.setDuration(l4);
                super(z2, view3, this, string, obj12);
                obj12.addListener(obj10);
                obj12.start();
            }
        } else {
        }
    }
}
