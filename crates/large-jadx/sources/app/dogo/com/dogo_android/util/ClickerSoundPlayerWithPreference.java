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

/* compiled from: ClickerSoundPlayerWithPreference.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0008\u0010\u000b\u001a\u00020\u000cH\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0008\u0010\u0011\u001a\u00020\nH\u0002J\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "", "player", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;", "preference", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "onChangeListener", "Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged;", "initPlayer", "", "isPlayerInit", "", "performClick", "context", "Landroid/content/Context;", "performClickerVibration", "playClickerSound", "releasePlayer", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class ClickerSoundPlayerWithPreference {

    /* renamed from: a, reason: from kotlin metadata */
    private final i onChangeListener;
    /* renamed from: b, reason: from kotlin metadata */
    private final p2 player;
    /* renamed from: c, reason: from kotlin metadata */
    private final o preference = new o();

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference$onChangeListener$1", "Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged$SoundChangedListener;", "changed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements o.a {

        final /* synthetic */ j a;
        a() {
            this.a = jVar;
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public void changed() {
            this.a.f();
            this.a.a();
        }
    }
    public j(i iVar, p2 p2Var) {
        n.f(iVar, "player");
        n.f(p2Var, "preference");
        super();
        this.onChangeListener = iVar;
        this.player = p2Var;
        final o clickerSoundChanged = new ClickerSoundChanged(new ClickerSoundPlayerWithPreference_onChangeListener_1(this));
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean initPlayer() {
        return this.onChangeListener.d();
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final void performClick(Context context) {
        Vibrator defaultVibrator = null;
        int i;
        try {
            sDK_INT2 = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 31) {
                z = context.getSystemService("vibrator_manager") instanceof VibratorManager;
                context = context.getSystemService("vibrator_manager") instanceof VibratorManager ? (VibratorManager)context.getSystemService("vibrator_manager") : 0;
                if (i != 0) {
                    defaultVibrator = i.getDefaultVibrator();
                }
            } else {
                Object context2 = context.getSystemService("vibrator");
                z = context2 instanceof Vibrator;
                if (context2 instanceof Vibrator) {
                }
            }
            long l = 50L;
            if (Build.VERSION.SDK_INT >= 26) {
                defaultVibrator.vibrate(VibrationEffect.createOneShot(l, -1));
            } else {
                defaultVibrator.vibrate(l);
            }
            a.d(new IllegalStateException("Vibrator is not defined"));
        } catch (Exception e) {
            a.d(e);
        }
    }

    private final void e() {
        this.onChangeListener.click();
    }

    public final void a() {
        final android.media.MediaPlayer.OnCompletionListener onCompletionListener = null;
        ClickerSoundPlayer.m(this.onChangeListener, this.player.R(), onCompletionListener, 2, onCompletionListener);
        this.player.n0(this.preference);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final void performClickerVibration(Context context) {
        n.f(context, "context");
        if (!initPlayer()) {
            a();
        }
        performClick(context);
        e();
    }

    public final void f() {
        this.onChangeListener.h();
        this.player.C1(this.preference);
    }
}
