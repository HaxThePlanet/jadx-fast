package app.dogo.com.dogo_android.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import app.dogo.com.dogo_android.e.o;
import app.dogo.com.dogo_android.e.o.a;
import app.dogo.com.dogo_android.service.p2;
import kotlin.Metadata;
import kotlin.d0.d.n;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0008\u0010\u000b\u001a\u00020\u000cH\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0008\u0010\u0011\u001a\u00020\nH\u0002J\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "", "player", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;", "preference", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "onChangeListener", "Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged;", "initPlayer", "", "isPlayerInit", "", "performClick", "context", "Landroid/content/Context;", "performClickerVibration", "playClickerSound", "releasePlayer", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j {

    private final app.dogo.com.dogo_android.util.i a;
    private final p2 b;
    private final o c;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference$onChangeListener$1", "Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged$SoundChangedListener;", "changed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements o.a {

        final app.dogo.com.dogo_android.util.j a;
        a(app.dogo.com.dogo_android.util.j j) {
            this.a = j;
            super();
        }

        @Override // app.dogo.com.dogo_android.e.o$a
        public void a() {
            this.a.f();
            this.a.a();
        }
    }
    public j(app.dogo.com.dogo_android.util.i i, p2 p22) {
        n.f(i, "player");
        n.f(p22, "preference");
        super();
        this.a = i;
        this.b = p22;
        j.a obj3 = new j.a(this);
        o obj2 = new o(obj3);
        this.c = obj2;
    }

    private final boolean b() {
        return this.a.d();
    }

    private final void d(Context context) {
        int sDK_INT;
        boolean z;
        Vibrator defaultVibrator;
        int i;
        int obj6;
        try {
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 31) {
            } else {
            }
            if (obj6 instanceof VibratorManager != null) {
            } else {
            }
            obj6 = defaultVibrator;
            if (obj6 == null) {
            } else {
            }
            defaultVibrator = obj6.getDefaultVibrator();
            obj6 = context.getSystemService("vibrator");
            if (obj6 instanceof Vibrator) {
            }
            defaultVibrator = obj6;
            if (defaultVibrator != null) {
            } else {
            }
            i = 50;
            if (sDK_INT >= 26) {
            } else {
            }
            defaultVibrator.vibrate(VibrationEffect.createOneShot(i, obj4));
            defaultVibrator.vibrate(i);
            obj6 = new IllegalStateException("Vibrator is not defined");
            a.d(obj6);
            a.d(context);
        }
    }

    private final void e() {
        this.a.a();
    }

    public final void a() {
        final int i2 = 0;
        i.m(this.a, this.b.R(), i2, 2, i2);
        this.b.n0(this.c);
    }

    public final void c(Context context) {
        n.f(context, "context");
        if (!b()) {
            a();
        }
        d(context);
        e();
    }

    public final void f() {
        this.a.h();
        this.b.C1(this.c);
    }
}
