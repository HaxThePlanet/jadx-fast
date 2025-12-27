package app.dogo.com.dogo_android.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import app.dogo.com.dogo_android.util.n0.u;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.v;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: ClickerSoundPlayer.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0006\u0010\u0016\u001a\u00020\u000fJ!\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00112\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0014\u0010 \u001a\u00020\u00112\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008J\u001c\u0010!\u001a\u00020\u00112\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u001a2\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;", "", "context", "Landroid/content/Context;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Landroid/content/Context;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "onErrorListener", "Lapp/dogo/com/dogo_android/util/recycle_views/SimpleObjectCallback;", "", "player", "Landroid/media/MediaPlayer;", "soundResId", "", "click", "", "flashSequanceOnNewThread", "", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "cameraId", "isFlashCameraSupported", "isPlayerInit", "onErrorCall", "methodName", "code", "", "(Ljava/lang/String;I)Ljava/lang/Boolean;", "releasePlayer", "sample", "which", "setIfFlashEnabled", "setOnErrorListener", "setSound", "listener", "Landroid/media/MediaPlayer$OnCompletionListener;", "toggleFlashOnOff", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class ClickerSoundPlayer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final i.a INSTANCE = new i$a(0);
    private static AtomicBoolean f;
    /* renamed from: a, reason: from kotlin metadata */
    private final Context context;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 onErrorListener;
    /* renamed from: c, reason: from kotlin metadata */
    private final int[] player;
    /* renamed from: d, reason: from kotlin metadata */
    private MediaPlayer soundResId;
    /* renamed from: e, reason: from kotlin metadata */
    private u<String> tracker;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer$Companion;", "", "()V", "MEDIA_PLAYER_NULL", "", "SOUND_0_WITH_FLASH_SELECTED", "flashEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFlashEnabled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setFlashEnabled", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {

        final /* synthetic */ String $cameraId;
        final /* synthetic */ CameraManager $cameraManager;
        @Override // kotlin.d0.d.p
        public final void invoke() throws android.hardware.camera2.CameraAccessException, java.lang.InterruptedException {
            try {
                this.$cameraManager.setTorchMode(this.$cameraId, true);
                int i = 250;
                Thread.sleep(i);
                final int i3 = 0;
                this.$cameraManager.setTorchMode(this.$cameraManager.getCameraIdList()[i3], false);
                Thread.sleep(i);
            } catch (Exception e) {
                a.d(e);
            }
        }

        b(CameraManager cameraManager, String str) {
            this.$cameraManager = cameraManager;
            this.$cameraId = str;
            super(0);
        }
    }
    static {
        ClickerSoundPlayer.f = new AtomicBoolean(false);
    }

    public i(Context context, o3 o3Var) {
        n.f(context, "context");
        n.f(o3Var, "tracker");
        super();
        this.context = context;
        this.onErrorListener = o3Var;
        this.player = new int[] { R.raw.click_sound_1, R.raw.click_sound_2, R.raw.click_sound_3, R.raw.click_sound_4, R.raw.click_sound_5, R.raw.click_sound_1 };
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final void flashSequanceOnNewThread(CameraManager cameraManager, String cameraId) {
        a.b(false, false, null, null, 0, new i.b(cameraManager, cameraId), 31, null);
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean isFlashCameraSupported(CameraManager cameraManager, String cameraId) throws android.hardware.camera2.CameraAccessException {
        boolean z2 = false;
        Boolean tRUE2;
        if (this.context.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            cameraManager = n.b(cameraManager.getCameraCharacteristics(cameraId).get(CameraCharacteristics.FLASH_INFO_AVAILABLE), Boolean.TRUE) ? 1 : 0;
        }
        return (n.b(cameraManager.getCameraCharacteristics(cameraId).get(CameraCharacteristics.FLASH_INFO_AVAILABLE), Boolean.TRUE) ? 1 : 0);
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final Boolean onErrorCall(String methodName, int code) {
        int i = 0;
        if (this.tracker == null) {
            i = 0;
        } else {
            Boolean str = Boolean.valueOf(this.tracker.a(methodName, code));
        }
        return i;
    }

    static /* synthetic */ Boolean g(i iVar, String str, int i, int i2, Object object) {
        if (i2 & 2 != 0) {
            i = 1;
        }
        return iVar.onErrorCall(str, i);
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final void sample(int which) {
        boolean z = true;
        which = which == 5 ? 1 : 0;
        ClickerSoundPlayer.f.set((which == 5 ? 1 : 0));
    }

    public static /* synthetic */ void m(i iVar, int i, MediaPlayer.OnCompletionListener list, int i2, Object object) {
        MediaPlayer.OnCompletionListener onCompletionListener = null;
        if (i2 & 2 != 0) {
            i = 0;
        }
        iVar.setSound(i, onCompletionListener);
    }

    private static final void n(MediaPlayer.OnCompletionListener list, i iVar, MediaPlayer mediaPlayer) {
        n.f(iVar, "this$0");
        if (list != null) {
            list.onCompletion(iVar.soundResId);
        }
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final void setIfFlashEnabled(CameraManager which) throws android.hardware.camera2.CameraAccessException {
        int i;
        String[] cameraIdList = which.getCameraIdList();
        n.e(cameraIdList, "cameraManager.cameraIdList");
        i = 1;
        i = 0;
        int r0 = i;
        if (i ^ i == 0) {
            str = "Camera not found";
            a.d(new RuntimeException(str));
        } else {
            String str = which.getCameraIdList()[i];
            n.e(str, "cameraId");
            if (isFlashCameraSupported(which, str)) {
                flashSequanceOnNewThread(which, str);
            } else {
                this.onErrorListener.c(E_Clicker.b);
            }
        }
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean click() {
        if (this.soundResId != null && !this.soundResId.isPlaying()) {
            if (ClickerSoundPlayer.f.get()) {
                Object systemService = this.context.getSystemService("camera");
                str = "null cannot be cast to non-null type android.hardware.camera2.CameraManager";
                Objects.requireNonNull(systemService, str);
                setIfFlashEnabled(systemService);
            }
            this.soundResId.start();
            return true;
        }
        return false;
    }

    public final boolean d() {
        boolean z = false;
        int i = 0;
        try {
        } catch (Exception e) {
            a.d(e);
        }
        if (this.soundResId != null) {
            int i2 = 1;
        }
        return z;
    }

    public final void h() {
        if (this.soundResId != null) {
            this.soundResId.reset();
        }
        if (this.soundResId != null) {
            this.soundResId.release();
        }
        this.soundResId = null;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public final void setOnErrorListener(int onErrorListener) {
        MediaPlayer soundResId2;
        int i = 1;
        w wVar;
        i = 1;
        i = 0;
        int r1 = i;
        if (i != 0) {
            if (this.soundResId != null) {
                this.soundResId.stop();
            }
        }
        if (this.soundResId != null) {
            this.soundResId.reset();
        }
        if (this.soundResId != null) {
            this.soundResId.release();
        }
        this.soundResId = MediaPlayer.create(this.context, this.player[onErrorListener]);
        sample(onErrorListener);
        if (ClickerSoundPlayer.f.get()) {
            Object systemService = this.context.getSystemService("camera");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            setIfFlashEnabled(systemService);
        }
        Object obj = null;
        int i4 = this.soundResId == null ? obj : w.a;
        if (ClickerSoundPlayer.f == null) {
            ClickerSoundPlayer.g(this, "sample", i, 2, obj);
        }
    }

    /* renamed from: k, reason: from kotlin metadata */
    public final void toggleFlashOnOff(u<String> cameraManager) {
        n.f(cameraManager, "onErrorListener");
        this.tracker = cameraManager;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public final void setSound(int which, MediaPlayer.OnCompletionListener listener) {
        int i;
        int i2;
        this.soundResId = MediaPlayer.create(this.context, this.player[which]);
        sample(which);
        Object obj = null;
        if (this.soundResId == null) {
            i2 = obj;
        } else {
            this.soundResId.setOnCompletionListener(new a(listener, this));
            w wVar = w.a;
        }
        if (this.soundResId == 0) {
            i2 = 0;
            int i3 = 2;
            ClickerSoundPlayer.g(this, "setSound", i2, i3, obj);
        }
    }

    public static /* synthetic */ void e(MediaPlayer.OnCompletionListener list, i iVar, MediaPlayer mediaPlayer) {
        ClickerSoundPlayer.n(list, iVar, mediaPlayer);
    }
}
