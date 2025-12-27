package app.dogo.com.dogo_android.service;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
import kotlin.k0.l;
import net.time4j.f;
import net.time4j.g1.v;
import net.time4j.k0;
import net.time4j.x;

/* compiled from: Utilities.kt */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 I2\u00020\u0001:\u0002IJB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0018\u0010\u001d\u001a\u00020\u000b2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u000bJ\u0010\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u000eJ\u0016\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%J\u001e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J\u0016\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u000bJ\u0010\u0010/\u001a\u00020%2\u0008\u00100\u001a\u0004\u0018\u00010\u000bJ\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u000eJ\u0010\u00103\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0018\u00104\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000cH\u0002J \u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u0002092\u0008\u0010:\u001a\u0004\u0018\u00010;J\u0018\u00106\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;H\u0002J\u000e\u0010=\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000eJ\u000e\u0010>\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000eJ8\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020F2\u0008\u0010G\u001a\u0004\u0018\u00010HR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019¨\u0006K", d2 = {"Lapp/dogo/com/dogo_android/service/Utilities;", "", "packageManager", "Landroid/content/pm/PackageManager;", "(Landroid/content/pm/PackageManager;)V", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "currentAnimations", "", "", "Landroid/animation/Animator;", "currentTimeInMillis", "", "getCurrentTimeInMillis", "()J", "instalationId", "getInstalationId", "()Ljava/lang/String;", "r", "Ljava/util/regex/Pattern;", "getR", "()Ljava/util/regex/Pattern;", "setR", "(Ljava/util/regex/Pattern;)V", "cancelAnimation", "", "id", "convertCountryCodeToFlagUnicode", "countryCode", "fallbackFlagCode", "formatIsoTime", "expirationTimestamp", "getRelativeTimeSpan", "startTimeMillis", "abbreviated", "", "futurePossible", "getRelativeTimeSpanPeriod", "period", "getRelativeTimeSpanWeek", "hideKeyboard", "windowView", "Landroid/view/View;", "isEmojiOnly", "string", "isPackageInstalled", "packageName", "isToday", "timeInMillis", "onAnimEnd", "onAnimStart", "animation", "timeLocalisation", "number", "type", "Lapp/dogo/com/dogo_android/service/Utilities$TimeUnit;", "width", "Lnet/time4j/format/TextWidth;", "timeInMilliseconds", "timeLocalisationNarrow", "timeLocalisationShort", "timeLocalisationWide", "toggleHideHeightAnimation", "animationId", "show", "view", "duration", "originalHeight", "", "valueListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Companion", "TimeUnit", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v2, reason: from kotlin metadata */
public final class Utilities {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final v2.a INSTANCE = new v2$a(0);
    private final PackageManager a;
    /* renamed from: b, reason: from kotlin metadata */
    private final Map<String, Animator> currentAnimations = new HashMap<>();
    private Pattern c;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u0008R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/service/Utilities$Companion;", "", "()V", "MAX_EMOJI_CHECKER_CHAR_LENGTH", "", "generateMinuteSecondTimeString", "", "seconds", "", "withMinutePadding", "", "getLocalisedTime", "number", "type", "Lapp/dogo/com/dogo_android/service/Utilities$TimeUnit;", "width", "Lnet/time4j/format/TextWidth;", "getRoughMonthDifference", "startTimestampMs", "endTimestampMs", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public static /* synthetic */ String b(v2.a aVar, long j, boolean z, int i, Object object) {
            if (i & 2 != 0) {
                i = 0;
            }
            return aVar.generateMinuteSecondTimeString(j, i);
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final String generateMinuteSecondTimeString(long seconds, boolean withMinutePadding) {
            String str;
            final long l2 = 1L;
            withMinutePadding = withMinutePadding ? "%02d:%02d" : "%d:%02d";
            int i = 2;
            final Object[] arr = new Object[i];
            String formatted = String.format((withMinutePadding ? "%02d:%02d" : "%d:%02d"), Arrays.copyOf(arr, i));
            n.e(formatted, "java.lang.String.format(format, *args)");
            return formatted;
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final String getLocalisedTime(long number, v2.b type, v width) {
            String str;
            n.f(type, "type");
            if (type.getType() instanceof f) {
                str2 = "{\n                PrettyTime.of(Locale.getDefault()).print(number, type.type, width)\n            }";
                n.e(k0.d(Locale.getDefault()).e(number, (f)type.getType(), width), str2);
            } else {
                str2 = "{\n                PrettyTime.of(Locale.getDefault()).print(number, type.type as ClockUnit, width)\n            }";
                n.e(k0.d(Locale.getDefault()).f(number, (h)type.getType(), width), str2);
            }
            return str;
        }

        /* renamed from: d, reason: from kotlin metadata */
        public final int getRoughMonthDifference(long startTimestampMs, long endTimestampMs) {
            TimeUnit dAYS2 = TimeUnit.DAYS;
            long millis = dAYS2.toMillis(365L);
            startTimestampMs -= endTimestampMs;
            return (int)(l2 / millis) * (long)12 + (a.d((float)(l2 % millis) / (float)dAYS2.toMillis(30L) * 1f));
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000c\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/service/Utilities$TimeUnit;", "", "type", "Lnet/time4j/IsoUnit;", "threshold", "", "(Ljava/lang/String;ILnet/time4j/IsoUnit;J)V", "getThreshold", "()J", "getType", "()Lnet/time4j/IsoUnit;", "SECONDS", "MINUTES", "HOURS", "DAYS", "MONTHS", "YEARS", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum b {

        SECONDS(field_3, 1000, /* unknown */),
        SECONDS(field_3, 1000, /* unknown */),
        SECONDS(field_3, 1000, /* unknown */),
        SECONDS(field_3, 1000, /* unknown */),
        SECONDS(field_3, 1000, /* unknown */);

        private final long threshold;
        private final x type;
        @Override // java.lang.Enum
        public final long getThreshold() {
            return this.threshold;
        }

        @Override // java.lang.Enum
        public final x getType() {
            return this.type;
        }

        private static final /* synthetic */ v2.b[] $values() {
            app.dogo.com.dogo_android.service.v2.b[] arr = new v2.b[6];
            return new v2.b[] { Utilities_TimeUnit.SECONDS, Utilities_TimeUnit.MINUTES, Utilities_TimeUnit.HOURS, Utilities_TimeUnit.DAYS, Utilities_TimeUnit.MONTHS, Utilities_TimeUnit.YEARS };
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/service/Utilities$toggleHideHeightAnimation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements Animator.AnimatorListener {

        final /* synthetic */ boolean a;
        final /* synthetic */ View b;
        final /* synthetic */ v2 c;
        final /* synthetic */ String d;
        final /* synthetic */ ValueAnimator e;
        c(boolean z, View view, v2 v2Var, String str, ValueAnimator valueAnimator) {
            this.a = z;
            this.b = view;
            this.c = v2Var;
            this.d = str;
            this.e = valueAnimator;
            super();
        }

        public void onAnimationEnd(Animator animation) {
            str = "animation";
            n.f(animation, str);
            if (!this.a) {
                this.b.setVisibility(8);
            }
            this.c.formatIsoTime(this.d);
            this.e.removeAllListeners();
            this.e.removeAllUpdateListeners();
        }

        public void onAnimationStart(Animator animation) {
            n.f(animation, "animation");
            if (this.a) {
                int i = 0;
                this.b.setVisibility(i);
            }
            this.c.getRelativeTimeSpan(this.d, animation);
        }

        public void onAnimationCancel(Animator animation) {
            n.f(animation, "animation");
        }

        public void onAnimationRepeat(Animator animation) {
            n.f(animation, "animation");
        }
    }
    public v2(PackageManager packageManager) {
        n.f(packageManager, "packageManager");
        super();
        this.a = packageManager;
        HashMap hashMap = new HashMap();
        Pattern pattern = Pattern.compile("^[\\s\n\r]*(?:(?:[©®‼⁉™ℹ↔-↙↩-↪⌚-⌛⌨⏏⏩-⏳⏸-⏺Ⓜ▪-▫▶◀◻-◾☀-☄☎☑☔-☕☘☝☠☢-☣☦☪☮-☯☸-☺♈-♓♠♣♥-♦♨♻♿⚒-⚔⚖-⚗⚙⚛-⚜⚠-⚡⚪-⚫⚰-⚱⚽-⚾⛄-⛅⛈⛎-⛏⛑⛓-⛔⛩-⛪⛰-⛵⛷-⛺⛽✂✅✈-✍✏✒✔✖✝✡✨✳-✴❄❇❌❎❓-❕❗❣-❤➕-➗➡➰➿⤴-⤵⬅-⬇⬛-⬜⭐⭕〰〽㊗㊙🀄🃏🅰-🅱🅾-🅿🆎🆑-🆚🈁-🈂🈚🈯🈲-🈺🉐-🉑‍🌀-🗿😀-🙏🚀-🛿🤀-🧿󠀠-󠁿]|‍[♀♂]|[🇦-🇿]{2}|.[⃠⃣️]+)+[\\s\n\r]*)+$");
        n.e(pattern, "compile(\"^[\\\\s\\n\\r]*(?:(?:[\\u00a9\\u00ae\\u203c\\u2049\\u2122\\u2139\\u2194-\\u2199\\u21a9-\\u21aa\\u231a-\\u231b\\u2328\\u23cf\\u23e9-\\u23f3\\u23f8-\\u23fa\\u24c2\\u25aa-\\u25ab\\u25b6\\u25c0\\u25fb-\\u25fe\\u2600-\\u2604\\u260e\\u2611\\u2614-\\u2615\\u2618\\u261d\\u2620\\u2622-\\u2623\\u2626\\u262a\\u262e-\\u262f\\u2638-\\u263a\\u2648-\\u2653\\u2660\\u2663\\u2665-\\u2666\\u2668\\u267b\\u267f\\u2692-\\u2694\\u2696-\\u2697\\u2699\\u269b-\\u269c\\u26a0-\\u26a1\\u26aa-\\u26ab\\u26b0-\\u26b1\\u26bd-\\u26be\\u26c4-\\u26c5\\u26c8\\u26ce-\\u26cf\\u26d1\\u26d3-\\u26d4\\u26e9-\\u26ea\\u26f0-\\u26f5\\u26f7-\\u26fa\\u26fd\\u2702\\u2705\\u2708-\\u270d\\u270f\\u2712\\u2714\\u2716\\u271d\\u2721\\u2728\\u2733-\\u2734\\u2744\\u2747\\u274c\\u274e\\u2753-\\u2755\\u2757\\u2763-\\u2764\\u2795-\\u2797\\u27a1\\u27b0\\u27bf\\u2934-\\u2935\\u2b05-\\u2b07\\u2b1b-\\u2b1c\\u2b50\\u2b55\\u3030\\u303d\\u3297\\u3299\\ud83c\\udc04\\ud83c\\udccf\\ud83c\\udd70-\\ud83c\\udd71\\ud83c\\udd7e-\\ud83c\\udd7f\\ud83c\\udd8e\\ud83c\\udd91-\\ud83c\\udd9a\\ud83c\\ude01-\\ud83c\\ude02\\ud83c\\ude1a\\ud83c\\ude2f\\ud83c\\ude32-\\ud83c\\ude3a\\ud83c\\ude50-\\ud83c\\ude51\\u200d\\ud83c\\udf00-\\ud83d\\uddff\\ud83d\\ude00-\\ud83d\\ude4f\\ud83d\\ude80-\\ud83d\\udeff\\ud83e\\udd00-\\ud83e\\uddff\\udb40\\udc20-\\udb40\\udc7f]|\\u200d[\\u2640\\u2642]|[\\ud83c\\udde6-\\ud83c\\uddff]{2}|.[\\u20e0\\u20e3\\ufe0f]+)+[\\\\s\\n\\r]*)+$\")");
        this.c = pattern;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ void convertCountryCodeToFlagUnicode(v2 countryCode, String fallbackFlagCode) {
        countryCode.formatIsoTime(fallbackFlagCode);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final /* synthetic */ void getRelativeTimeSpan(v2 startTimeMillis, String abbreviated, Animator futurePossible) {
        startTimeMillis.getRelativeTimeSpan(abbreviated, futurePossible);
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final void cancelAnimation(String id) {
        Object value = this.currentAnimations.get(id);
        n.d(value);
        value.cancel();
        this.currentAnimations.remove(id);
    }

    /* renamed from: q, reason: from kotlin metadata */
    private final void formatIsoTime(String expirationTimestamp) {
        this.currentAnimations.remove(expirationTimestamp);
    }

    /* renamed from: r, reason: from kotlin metadata */
    private final void getRelativeTimeSpan(String startTimeMillis, Animator abbreviated) {
        this.currentAnimations.put(startTimeMillis, abbreviated);
    }

    /* renamed from: t, reason: from kotlin metadata */
    private final String getRelativeTimeSpanPeriod(long period, v abbreviated) {
        Object obj;
        long abs = Math.abs(period);
        long threshold2 = Utilities_TimeUnit.YEARS.getThreshold();
        if (abs < threshold2) {
            long threshold3 = Utilities_TimeUnit.MONTHS.getThreshold();
            if (abs < threshold3) {
                long threshold4 = Utilities_TimeUnit.DAYS.getThreshold();
                if (abs < threshold4) {
                    long threshold5 = Utilities_TimeUnit.HOURS.getThreshold();
                    if (abs < threshold5) {
                        long threshold6 = Utilities_TimeUnit.MINUTES.getThreshold();
                        if (abs < threshold6) {
                            app.dogo.com.dogo_android.service.v2.b sECONDS2 = Utilities_TimeUnit.SECONDS;
                        }
                    }
                }
            }
        }
        return s(period / obj.getThreshold(), obj, abbreviated);
    }

    private static final void x(View view, ValueAnimator.AnimatorUpdateListener list, ValueAnimator valueAnimator) {
        n.f(view, "$view");
        n.f(valueAnimator, "valueAnimator");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = animatedValue.intValue();
        view.setLayoutParams(layoutParams);
        if (list != null) {
            list.onAnimationUpdate(valueAnimator);
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final String onAnimStart(String id, String animation) throws java.io.UnsupportedEncodingException {
        int length;
        int i = 2;
        String str2;
        n.f(animation, "fallbackFlagCode");
        int i2 = 0;
        if (id != null) {
            i = 2;
            if (id.length() == 2) {
                str = "[a-zA-Z]+";
                if (!new Regex(str).d(id)) {
                    string = "invalid countryCode";
                    a.a(string, new Object[i2]);
                } else {
                    String str7 = id.toUpperCase();
                    String str5 = "(this as java.lang.String).toUpperCase()";
                    n.e(str7, str5);
                    int i3 = 127462;
                    String str6 = id.toUpperCase();
                    n.e(str6, str5);
                    length = 1;
                    char[] chars2 = Character.toChars((Character.codePointAt(str7, i2)) - 65 + i3);
                    n.e(chars2, "toChars(firstLetter)");
                    char[] chars = Character.toChars((Character.codePointAt(str6, length)) - 65 + i3);
                    n.e(chars, "toChars(secondLetter)");
                    str2 = n.o(new String(chars2), new String(chars));
                }
            }
        }
        return str2;
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final String getRelativeTimeSpanWeek(long startTimeMillis) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date(startTimeMillis, r5));
    }

    public final Calendar f() {
        Calendar time = Calendar.getInstance(Locale.getDefault());
        n.e(time, "getInstance(Locale.getDefault())");
        return time;
    }

    public final long g() {
        return System.currentTimeMillis();
    }

    public final String h() {
        String uuid2 = UUID.randomUUID().toString();
        n.e(uuid2, "randomUUID().toString()");
        return uuid2;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public final String timeLocalisation(long timeInMilliseconds, boolean width) {
        int i = 262144;
        width = width ? 262144 : 0;
        return DateUtils.getRelativeTimeSpanString(timeInMilliseconds, l, g(), l3, 1000, obj, (width ? 262144 : 0)).toString();
    }

    public final String j(long j, boolean z, boolean z2) {
        long l;
        String timeLocalisation;
        int cmp;
        if (!z2) {
            l = g();
            if (j > l) {
                l = 1L;
                timeLocalisation = timeLocalisation(g() - l, z);
            } else {
                timeLocalisation = timeLocalisation(j, z);
            }
        }
        return timeLocalisation;
    }

    public final String k(long j, boolean z) {
        int i = 262144;
        z = z ? 262144 : 0;
        return DateUtils.getRelativeTimeSpanString(j, l, 0, l2, 1000, obj, (z ? 262144 : 0)).toString();
    }

    /* renamed from: l, reason: from kotlin metadata */
    public final String hideKeyboard(long windowView) {
        return DateUtils.getRelativeTimeSpanString(windowView, g(), 604800000L, 0).toString();
    }

    /* renamed from: m, reason: from kotlin metadata */
    public final void isEmojiOnly(View string) {
        n.f(string, "windowView");
        Object systemService = string.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        systemService.hideSoftInputFromWindow(string.getWindowToken(), 0);
    }

    /* renamed from: n, reason: from kotlin metadata */
    public final boolean isPackageInstalled(String packageName) {
        n.f(packageName, "string");
        return this.c.matcher(l.f1(packageName, 14)).find();
    }

    /* renamed from: o, reason: from kotlin metadata */
    public final boolean isToday(String timeInMillis) {
        try {
            n.d(timeInMillis);
            this.a.getPackageInfo(timeInMillis, 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public final String s(long j, v2.b bVar, v vVar) {
        n.f(bVar, "type");
        return Utilities.INSTANCE.getLocalisedTime(j, bVar, vVar);
    }

    /* renamed from: u, reason: from kotlin metadata */
    public final String onAnimEnd(long id) {
        return getRelativeTimeSpanPeriod(id, v.SHORT);
    }

    /* renamed from: v, reason: from kotlin metadata */
    public final String timeLocalisationNarrow(long number) {
        return getRelativeTimeSpanPeriod(number, v.WIDE);
    }

    /* renamed from: w, reason: from kotlin metadata */
    public final void toggleHideHeightAnimation(String animationId, boolean show, View view, long duration, int originalHeight, ValueAnimator.AnimatorUpdateListener valueListener) {
        int i;
        ValueAnimator valueListener2;
        n.f(animationId, "animationId");
        n.f(view, "view");
        i = 0;
        i = 1;
        int r0 = i;
        if (i == show) {
            if (this.currentAnimations.containsKey(animationId)) {
                if (this.currentAnimations.containsKey(animationId)) {
                    cancelAnimation(animationId);
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams.height < 0) {
                    layoutParams.height = originalHeight;
                }
                int i2 = 2;
                if (show != 0) {
                    int[] iArr = new int[i2];
                    valueListener2 = ValueAnimator.ofInt(new int[] { layoutParams.height, originalHeight });
                } else {
                    int[] iArr2 = new int[i2];
                    valueListener2 = ValueAnimator.ofInt(new int[] { layoutParams.height, i });
                }
                valueListener2.addUpdateListener(new f2(view, valueListener));
                valueListener2.setDuration(duration);
                Utilities_toggleHideHeightAnimation_2 duration2 = new Utilities_toggleHideHeightAnimation_2(show, view, this, animationId, valueListener2);
                valueListener2.addListener(duration2);
                valueListener2.start();
            }
        }
    }


    /* renamed from: p, reason: from kotlin metadata */
    public static /* synthetic */ void timeLocalisation(View number, ValueAnimator.AnimatorUpdateListener type, ValueAnimator width) {
        Utilities.x(number, type, width);
    }
}
