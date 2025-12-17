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
import kotlin.a0.a;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0006\u0010\u0016\u001a\u00020\u000fJ!\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00112\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0014\u0010 \u001a\u00020\u00112\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008J\u001c\u0010!\u001a\u00020\u00112\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u001a2\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;", "", "context", "Landroid/content/Context;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Landroid/content/Context;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "onErrorListener", "Lapp/dogo/com/dogo_android/util/recycle_views/SimpleObjectCallback;", "", "player", "Landroid/media/MediaPlayer;", "soundResId", "", "click", "", "flashSequanceOnNewThread", "", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "cameraId", "isFlashCameraSupported", "isPlayerInit", "onErrorCall", "methodName", "code", "", "(Ljava/lang/String;I)Ljava/lang/Boolean;", "releasePlayer", "sample", "which", "setIfFlashEnabled", "setOnErrorListener", "setSound", "listener", "Landroid/media/MediaPlayer$OnCompletionListener;", "toggleFlashOnOff", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i {

    public static final app.dogo.com.dogo_android.util.i.a Companion;
    private static AtomicBoolean f;
    private final Context a;
    private final o3 b;
    private final int[] c;
    private MediaPlayer d;
    private u<String> e;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer$Companion;", "", "()V", "MEDIA_PLAYER_NULL", "", "SOUND_0_WITH_FLASH_SELECTED", "flashEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFlashEnabled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setFlashEnabled", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final String $cameraId;
        final CameraManager $cameraManager;
        b(CameraManager cameraManager, String string2) {
            this.$cameraManager = cameraManager;
            this.$cameraId = string2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            int i;
            try {
                final String $cameraId = this.$cameraId;
                this.$cameraManager.setTorchMode($cameraId, true);
                i = 250;
                Thread.sleep(i);
                CameraManager $cameraManager2 = this.$cameraManager;
                final int i3 = 0;
                $cameraManager2.setTorchMode($cameraManager2.getCameraIdList()[i3], i3);
                Thread.sleep(i);
                a.d(th);
            }
        }
    }
    static {
        i.a aVar = new i.a(0);
        i.Companion = aVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        i.f = atomicBoolean;
    }

    public i(Context context, o3 o32) {
        n.f(context, "context");
        n.f(o32, "tracker");
        super();
        this.a = context;
        this.b = o32;
        int[] obj2 = new int[6];
        obj2 = new int[]{2131820544, 2131820545, 2131820546, 2131820547, 2131820548, 2131820544};
        this.c = obj2;
    }

    private final void b(CameraManager cameraManager, String string2) {
        i.b bVar = new i.b(cameraManager, string2);
        a.b(false, false, 0, 0, 0, bVar, 31, 0);
    }

    private final boolean c(CameraManager cameraManager, String string2) {
        boolean obj3;
        Object obj4;
        if (this.a.getPackageManager().hasSystemFeature("android.hardware.camera.flash") && n.b(cameraManager.getCameraCharacteristics(string2).get(CameraCharacteristics.FLASH_INFO_AVAILABLE), Boolean.TRUE)) {
            obj3 = n.b(cameraManager.getCameraCharacteristics(string2).get(CameraCharacteristics.FLASH_INFO_AVAILABLE), Boolean.TRUE) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    public static void e(MediaPlayer.OnCompletionListener mediaPlayer$OnCompletionListener, app.dogo.com.dogo_android.util.i i2, MediaPlayer mediaPlayer3) {
        i.n(onCompletionListener, i2, mediaPlayer3);
    }

    private final Boolean f(String string, int i2) {
        int obj2;
        final u uVar = this.e;
        if (uVar == null) {
            obj2 = 0;
        } else {
            obj2 = Boolean.valueOf(uVar.a(string, i2));
        }
        return obj2;
    }

    static Boolean g(app.dogo.com.dogo_android.util.i i, String string2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return i.f(string2, obj2);
    }

    private final void j(int i) {
        int obj3;
        obj3 = i == 5 ? 1 : 0;
        i.f.set(obj3);
    }

    public static void m(app.dogo.com.dogo_android.util.i i, int i2, MediaPlayer.OnCompletionListener mediaPlayer$OnCompletionListener3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        i.l(i2, obj2);
    }

    private static final void n(MediaPlayer.OnCompletionListener mediaPlayer$OnCompletionListener, app.dogo.com.dogo_android.util.i i2, MediaPlayer mediaPlayer3) {
        Object obj1;
        n.f(i2, "this$0");
        if (onCompletionListener == null) {
        } else {
            onCompletionListener.onCompletion(i2.d);
        }
    }

    private final void o(CameraManager cameraManager) {
        int i;
        Object str;
        int i2;
        Object obj4;
        String[] cameraIdList = cameraManager.getCameraIdList();
        n.e(cameraIdList, "cameraManager.cameraIdList");
        i2 = 1;
        final int i4 = 0;
        i = cameraIdList.length == 0 ? i2 : i4;
        if (i ^= i2 != 0) {
            str = cameraManager.getCameraIdList()[i4];
            n.e(str, "cameraId");
            if (c(cameraManager, str)) {
                b(cameraManager, str);
            } else {
                this.b.c(v.b);
            }
        } else {
            obj4 = new RuntimeException("Camera not found");
            a.d(obj4);
        }
    }

    public final boolean a() {
        boolean playing;
        boolean systemService;
        String str;
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer != null && !mediaPlayer.isPlaying() && i.f.get()) {
            if (!mediaPlayer.isPlaying()) {
                if (i.f.get()) {
                    systemService = this.a.getSystemService("camera");
                    Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
                    o((CameraManager)systemService);
                }
                mediaPlayer.start();
                return 1;
            }
        }
        return 0;
    }

    public final boolean d() {
        int i;
        MediaPlayer mediaPlayer;
        i = 0;
        if (this.d != null) {
            try {
                i = 1;
                a.d(th);
            }
        }
        return i;
    }

    public final void h() {
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer == null) {
        } else {
            mediaPlayer.reset();
        }
        MediaPlayer mediaPlayer2 = this.d;
        if (mediaPlayer2 == null) {
        } else {
            mediaPlayer2.release();
        }
        this.d = 0;
    }

    public final void i(int i) {
        MediaPlayer playing;
        Object create;
        int i2;
        int str;
        boolean obj4;
        playing = this.d;
        final int i4 = 0;
        if (playing == null) {
            i2 = i4;
        } else {
        }
        if (i2 != 0) {
            playing = this.d;
            if (playing == null) {
            } else {
                playing.stop();
            }
        }
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer == null) {
        } else {
            mediaPlayer.reset();
        }
        MediaPlayer mediaPlayer2 = this.d;
        if (mediaPlayer2 == null) {
        } else {
            mediaPlayer2.release();
        }
        this.d = MediaPlayer.create(this.a, this.c[i]);
        j(i);
        if (i.f.get()) {
            obj4 = this.a.getSystemService("camera");
            Objects.requireNonNull(obj4, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            o((CameraManager)obj4);
        }
        obj4 = this.d;
        int i3 = 0;
        obj4 = obj4 == null ? i3 : w.a;
        if (obj4 == null) {
            i.g(this, "sample", i4, 2, i3);
        }
    }

    public final void k(u<String> u) {
        n.f(u, "onErrorListener");
        this.e = u;
    }

    public final void l(int i, MediaPlayer.OnCompletionListener mediaPlayer$OnCompletionListener2) {
        int aVar;
        int obj3;
        MediaPlayer.OnCompletionListener obj4;
        this.d = MediaPlayer.create(this.a, this.c[i]);
        j(i);
        obj3 = this.d;
        int i2 = 0;
        if (obj3 == null) {
            obj3 = i2;
        } else {
            aVar = new a(onCompletionListener2, this);
            obj3.setOnCompletionListener(aVar);
            obj3 = w.a;
        }
        if (obj3 == null) {
            i.g(this, "setSound", 0, 2, i2);
        }
    }
}
