package app.dogo.com.dogo_android.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.result.c;
import androidx.activity.result.f.b;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.lifecycle.r;
import app.dogo.com.dogo_android.h.ig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.i;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.h;
import kotlin.b0.k.a.k;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlin.y.i;
import kotlin.y.p;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.y1;
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 a2\u00020\u0001:\u0001aB\u0005¢\u0006\u0002\u0010\u0002J3\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\u000c2\u000c\u0010G\u001a\u0008\u0012\u0004\u0012\u0002020H2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u0010\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u000202H\u0002J\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0002J\u0012\u0010Q\u001a\u00020R2\u0008\u0010S\u001a\u0004\u0018\u00010TH\u0016J$\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020W2\u0008\u0010X\u001a\u0004\u0018\u00010Y2\u0008\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0008\u0010Z\u001a\u00020RH\u0016J\u0008\u0010[\u001a\u00020RH\u0016J\u001a\u0010\\\u001a\u00020R2\u0006\u0010]\u001a\u00020#2\u0008\u0010S\u001a\u0004\u0018\u00010TH\u0017J-\u0010^\u001a\u00020\u000c2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010O\u001a\u00020P2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010\u000eH\u0083@ø\u0001\u0000¢\u0006\u0002\u0010`R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u0008\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001c\u0010\u0008\u001a\u0004\u0008\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008!\u0010\u0008\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008(\u0010\u0008\u001a\u0004\u0008&\u0010'R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008+\u0010\u0008\u001a\u0004\u0008*\u0010'R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u00080\u0010\u0008\u001a\u0004\u0008.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u00085\u0010\u0008\u001a\u0004\u00083\u00104R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008D\u0010\u0008\u001a\u0004\u0008B\u0010C\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006b", d2 = {"Lapp/dogo/com/dogo_android/camerax/RecordVideoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "animationTask", "Ljava/lang/Runnable;", "getAnimationTask", "()Ljava/lang/Runnable;", "animationTask$delegate", "Lkotlin/Lazy;", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentRecordVideoBinding;", "camera", "Landroid/hardware/camera2/CameraDevice;", "cameraHandler", "Landroid/os/Handler;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "getCameraManager", "()Landroid/hardware/camera2/CameraManager;", "cameraManager$delegate", "cameraThread", "Landroid/os/HandlerThread;", "capture", "Landroid/widget/ImageButton;", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getCharacteristics", "()Landroid/hardware/camera2/CameraCharacteristics;", "characteristics$delegate", "outputFile", "Ljava/io/File;", "getOutputFile", "()Ljava/io/File;", "outputFile$delegate", "overlay", "Landroid/view/View;", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "getPreviewRequest", "()Landroid/hardware/camera2/CaptureRequest;", "previewRequest$delegate", "recordRequest", "getRecordRequest", "recordRequest$delegate", "recorder", "Landroid/media/MediaRecorder;", "getRecorder", "()Landroid/media/MediaRecorder;", "recorder$delegate", "recorderSurface", "Landroid/view/Surface;", "getRecorderSurface", "()Landroid/view/Surface;", "recorderSurface$delegate", "recordingStartMillis", "", "screenKey", "Lapp/dogo/com/dogo_android/camerax/RecordVideoScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/camerax/RecordVideoScreen;", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "viewFinder", "Landroid/view/SurfaceView;", "viewModel", "Lapp/dogo/com/dogo_android/camerax/RecordVideoViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/camerax/RecordVideoViewModel;", "viewModel$delegate", "createCaptureSession", "device", "targets", "", "handler", "(Landroid/hardware/camera2/CameraDevice;Ljava/util/List;Landroid/os/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRecorder", "surface", "initializeCamera", "Lkotlinx/coroutines/Job;", "cameraId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onStop", "onViewCreated", "view", "openCamera", "manager", "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;Landroid/os/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends Fragment {

    public static final app.dogo.com.dogo_android.c.g.a Companion;
    private static final String[] K;
    private final Handler A;
    private final h B;
    private SurfaceView C;
    private View D;
    private CameraCaptureSession E;
    private CameraDevice F;
    private ImageButton G;
    private final h H;
    private final h I;
    private long J;
    private final h a;
    private ig b;
    private final h c;
    private final h v;
    private final h w;
    private final h x;
    private final h y;
    private final HandlerThread z;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000cR\u000e\u0010\r\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/camerax/RecordVideoFragment$Companion;", "", "()V", "ANIMATION_FAST_MILLIS", "", "ANIMATION_SLOW_MILLIS", "MIN_REQUIRED_RECORDING_TIME_MILLIS", "PERMISSIONS_REQUEST_CODE", "", "PERMISSIONS_REQUIRED", "", "", "[Ljava/lang/String;", "RECORDER_VIDEO_BITRATE", "createFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "extension", "hasPermissions", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public static final File a(app.dogo.com.dogo_android.c.g.a g$a, Context context2, String string3) {
            return a.b(context2, string3);
        }

        private final File b(Context context, String string2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS", Locale.US);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VID_");
            Date date = new Date();
            stringBuilder.append(simpleDateFormat.format(date));
            stringBuilder.append('.');
            stringBuilder.append(string2);
            File file = new File(context.getFilesDir(), stringBuilder.toString());
            return file;
        }

        public final boolean c(Context context) {
            int i2;
            int i3;
            int i;
            int i4;
            n.f(context, "context");
            String[] strArr = g.K1();
            i2 = 0;
            i3 = i2;
            while (i3 < strArr.length) {
                if (a.a(context, strArr[i3]) == 0) {
                } else {
                }
                i = i2;
                i3++;
            }
            i2 = i;
            return i2;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007", d2 = {"app/dogo/com/dogo_android/camerax/RecordVideoFragment$createCaptureSession$2$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onConfigureFailed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigured", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends CameraCaptureSession.StateCallback {

        final d<CameraCaptureSession> a;
        final CameraDevice b;
        e(d<? super CameraCaptureSession> d, CameraDevice cameraDevice2) {
            this.a = d;
            this.b = cameraDevice2;
            super();
        }

        @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            n.f(cameraCaptureSession, "session");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Camera ");
            stringBuilder.append(this.b.getId());
            stringBuilder.append(" session configuration failed");
            RuntimeException obj3 = new RuntimeException(stringBuilder.toString());
            a.d(obj3);
            kotlin.p.a aVar = p.a;
            obj3 = q.a(obj3);
            p.a(obj3);
            this.a.resumeWith(obj3);
        }

        @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            n.f(cameraCaptureSession, "session");
            final kotlin.p.a aVar = p.a;
            p.a(cameraCaptureSession);
            this.a.resumeWith(cameraCaptureSession);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000c", d2 = {"app/dogo/com/dogo_android/camerax/RecordVideoFragment$onViewCreated$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class g implements SurfaceHolder.Callback {

        final app.dogo.com.dogo_android.c.g a;
        g(app.dogo.com.dogo_android.c.g g) {
            this.a = g;
            super();
        }

        public static void a(app.dogo.com.dogo_android.c.g g) {
            g.g.b(g);
        }

        private static final void b(app.dogo.com.dogo_android.c.g g) {
            Object str;
            n.f(g, "this$0");
            String[] cameraIdList = g.G1(g).getCameraIdList();
            n.e(cameraIdList, "cameraManager.cameraIdList");
            if ((String)i.x(cameraIdList) == null) {
                str = "";
            }
            g.S1(g, str);
        }

        @Override // android.view.SurfaceHolder$Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            n.f(surfaceHolder, "holder");
        }

        @Override // android.view.SurfaceHolder$Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Object requireContext;
            Object eVar;
            boolean obj3;
            n.f(surfaceHolder, "holder");
            requireContext = this.a.requireContext();
            n.e(requireContext, "requireContext()");
            if (g.Companion.c(requireContext)) {
                obj3 = g.R1(this.a);
                if (obj3 == null) {
                } else {
                    eVar = new e(this.a);
                    obj3.post(eVar);
                }
                n.w("viewFinder");
                throw 0;
            }
        }

        @Override // android.view.SurfaceHolder$Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            n.f(surfaceHolder, "holder");
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n", d2 = {"app/dogo/com/dogo_android/camerax/RecordVideoFragment$openCamera$2$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "device", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class h extends CameraDevice.StateCallback {

        final p<CameraDevice> a;
        final String b;
        final app.dogo.com.dogo_android.c.g c;
        h(p<? super CameraDevice> p, String string2, app.dogo.com.dogo_android.c.g g3) {
            this.a = p;
            this.b = string2;
            this.c = g3;
            super();
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            n.f(cameraDevice, "device");
            StringBuilder obj2 = new StringBuilder();
            obj2.append("Camera ");
            obj2.append(this.b);
            obj2.append(" has been disconnected");
            a.i(obj2.toString(), new Object[0]);
            this.c.requireActivity().finish();
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onError(CameraDevice cameraDevice, int i2) {
            String str;
            boolean obj5;
            Object obj6;
            n.f(cameraDevice, "device");
            obj5 = 1;
            if (i2 != obj5) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            str = i2 != 5 ? "Unknown" : "Fatal (service)";
                        } else {
                            str = "Fatal (device)";
                        }
                    } else {
                        str = "Device policy";
                    }
                } else {
                    str = "Maximum cameras in use";
                }
            } else {
                str = "Camera in use";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Camera ");
            stringBuilder.append(this.b);
            stringBuilder.append(" error: (");
            stringBuilder.append(i2);
            stringBuilder.append(") ");
            stringBuilder.append(str);
            RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
            obj5 = new Object[obj5];
            obj5[0] = runtimeException;
            a.c(runtimeException.getMessage(), obj5);
            if (this.a.a()) {
                obj6 = p.a;
                obj6 = q.a(runtimeException);
                p.a(obj6);
                this.a.resumeWith(obj6);
            }
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            n.f(cameraDevice, "device");
            final kotlin.p.a aVar = p.a;
            p.a(cameraDevice);
            this.a.resumeWith(cameraDevice);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Ljava/lang/Runnable;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<Runnable> {

        final app.dogo.com.dogo_android.c.g this$0;
        b(app.dogo.com.dogo_android.c.g g) {
            this.this$0 = g;
            super(0);
        }

        private static final void b(app.dogo.com.dogo_android.c.g g) {
            n.f(g, "this$0");
            View view = g.J1(g);
            int i = 0;
            String str2 = "overlay";
            if (view == null) {
            } else {
                int i4 = 255;
                int argb = Color.argb(150, i4, i4, i4);
                ColorDrawable colorDrawable = new ColorDrawable(argb);
                view.setForeground(colorDrawable);
                View view2 = g.J1(g);
                if (view2 == null) {
                } else {
                    b bVar = new b(g);
                    view2.postDelayed(bVar, 50);
                }
                n.w(str2);
                throw i;
            }
            n.w(str2);
            throw i;
        }

        private static final void c(app.dogo.com.dogo_android.c.g g) {
            n.f(g, "this$0");
            View view = g.J1(g);
            String str2 = "overlay";
            final int i2 = 0;
            if (view == null) {
            } else {
                view.setForeground(i2);
                View view2 = g.J1(g);
                if (view2 == null) {
                } else {
                    view2.postDelayed(g.D1(g), 50);
                }
                n.w(str2);
                throw i2;
            }
            n.w(str2);
            throw i2;
        }

        public static void e(app.dogo.com.dogo_android.c.g g) {
            g.b.c(g);
        }

        public static void f(app.dogo.com.dogo_android.c.g g) {
            g.b.b(g);
        }

        @Override // kotlin.d0.d.p
        public final Runnable a() {
            c cVar = new c(this.this$0);
            return cVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/hardware/camera2/CameraManager;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<CameraManager> {

        final app.dogo.com.dogo_android.c.g this$0;
        c(app.dogo.com.dogo_android.c.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final CameraManager a() {
            Object systemService = this.this$0.requireContext().getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            return (CameraManager)systemService;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/hardware/camera2/CameraCharacteristics;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<CameraCharacteristics> {

        final app.dogo.com.dogo_android.c.g this$0;
        d(app.dogo.com.dogo_android.c.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final CameraCharacteristics a() {
            Object str;
            String[] cameraIdList = g.G1(this.this$0).getCameraIdList();
            n.e(cameraIdList, "cameraManager.cameraIdList");
            if ((String)i.x(cameraIdList) == null) {
                str = "";
            }
            CameraCharacteristics cameraCharacteristics = g.G1(this.this$0).getCameraCharacteristics(str);
            n.e(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraManager.cameraIdList.first() ?: \"\")");
            return cameraCharacteristics;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Ljava/io/File;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements a<File> {

        final app.dogo.com.dogo_android.c.g this$0;
        i(app.dogo.com.dogo_android.c.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final File a() {
            Context requireContext = this.this$0.requireContext();
            n.e(requireContext, "requireContext()");
            return g.a.a(g.Companion, requireContext, "mp4");
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/hardware/camera2/CaptureRequest;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class j extends p implements a<CaptureRequest> {

        final app.dogo.com.dogo_android.c.g this$0;
        j(app.dogo.com.dogo_android.c.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final CaptureRequest a() {
            CameraCaptureSession cameraCaptureSession = g.Q1(this.this$0);
            int i = 0;
            if (cameraCaptureSession == null) {
            } else {
                CaptureRequest.Builder captureRequest = cameraCaptureSession.getDevice().createCaptureRequest(1);
                SurfaceView view = g.R1(this.this$0);
                if (view == null) {
                } else {
                    captureRequest.addTarget(view.getHolder().getSurface());
                    CaptureRequest build = captureRequest.build();
                    n.e(build, "session.device.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW).apply {\n            // Add the preview surface target\n            addTarget(viewFinder.holder.surface)\n        }.build()");
                    return build;
                }
                n.w("viewFinder");
                throw i;
            }
            n.w("session");
            throw i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/hardware/camera2/CaptureRequest;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends p implements a<CaptureRequest> {

        final app.dogo.com.dogo_android.c.g this$0;
        k(app.dogo.com.dogo_android.c.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final CaptureRequest a() {
            CameraCaptureSession cameraCaptureSession = g.Q1(this.this$0);
            int i = 0;
            if (cameraCaptureSession == null) {
            } else {
                CaptureRequest.Builder captureRequest = cameraCaptureSession.getDevice().createCaptureRequest(3);
                app.dogo.com.dogo_android.c.g this$02 = this.this$0;
                SurfaceView view = g.R1(this$02);
                if (view == null) {
                } else {
                    captureRequest.addTarget(view.getHolder().getSurface());
                    captureRequest.addTarget(g.O1(this$02));
                    Range range = new Range(20, 30);
                    captureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    CaptureRequest build = captureRequest.build();
                    n.e(build, "session.device.createCaptureRequest(CameraDevice.TEMPLATE_RECORD).apply {\n            // Add the preview and recording surface targets\n            addTarget(viewFinder.holder.surface)\n            addTarget(recorderSurface)\n            // Sets user requested FPS for all targets\n            set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, Range(20, 30))\n        }.build()");
                    return build;
                }
                n.w("viewFinder");
                throw i;
            }
            n.w("session");
            throw i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/media/MediaRecorder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class l extends p implements a<MediaRecorder> {

        final app.dogo.com.dogo_android.c.g this$0;
        l(app.dogo.com.dogo_android.c.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final MediaRecorder a() {
            app.dogo.com.dogo_android.c.g this$0 = this.this$0;
            return g.C1(this$0, g.O1(this$0));
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/view/Surface;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class m extends p implements a<Surface> {

        final app.dogo.com.dogo_android.c.g this$0;
        m(app.dogo.com.dogo_android.c.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final Surface a() {
            final Surface persistentInputSurface = MediaCodec.createPersistentInputSurface();
            n.e(persistentInputSurface, "createPersistentInputSurface()");
            MediaRecorder mediaRecorder = g.C1(this.this$0, persistentInputSurface);
            mediaRecorder.prepare();
            mediaRecorder.release();
            return persistentInputSurface;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class n extends p implements a<app.dogo.com.dogo_android.c.i> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public n(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.c.i invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(i.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.camerax.RecordVideoFragment$initializeCamera$1", f = "RecordVideoFragment.kt", l = {250, 256}, m = "invokeSuspend")
    static final class f extends k implements p<m0, d<? super w>, Object> {

        final String $cameraId;
        Object L$0;
        int label;
        final app.dogo.com.dogo_android.c.g this$0;
        f(app.dogo.com.dogo_android.c.g g, String string2, d<? super app.dogo.com.dogo_android.c.g.f> d3) {
            this.this$0 = g;
            this.$cameraId = string2;
            super(2, d3);
        }

        private static final boolean e(app.dogo.com.dogo_android.c.g g, View view2, MotionEvent motionEvent3) {
            View action;
            androidx.lifecycle.l lVar;
            kotlinx.coroutines.h0 h0Var2;
            int i3;
            app.dogo.com.dogo_android.c.g.f.b bVar;
            int i5;
            int i4;
            androidx.lifecycle.l lVar2;
            kotlinx.coroutines.h0 h0Var;
            int i6;
            app.dogo.com.dogo_android.c.g.f.a aVar;
            int i;
            int i2;
            final app.dogo.com.dogo_android.c.g gVar = g;
            action = motionEvent3.getAction();
            final int i7 = 0;
            final int i8 = 1;
            if (action != 0) {
                if (action != i8) {
                } else {
                    bVar = new g.f.b(gVar, view2, i7);
                    k.d(r.a(g), c1.b(), 0, bVar, 2, 0);
                }
            } else {
                aVar = new g.f.a(gVar, i7);
                k.d(r.a(g), c1.b(), 0, aVar, 2, 0);
            }
            return i8;
        }

        public static boolean f(app.dogo.com.dogo_android.c.g g, View view2, MotionEvent motionEvent3) {
            return g.f.e(g, view2, motionEvent3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (g.f)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g.f obj3 = new g.f(this.this$0, this.$cameraId, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            int label;
            Object this$0;
            int i;
            Object $cameraId;
            Handler handler;
            Object obj8;
            Object obj = b.d();
            label = this.label;
            final int i3 = 2;
            i = 1;
            final int i4 = 0;
            if (label != 0) {
                if (label != i) {
                    if (label != i3) {
                    } else {
                        l$0 = this.L$0;
                        q.b(object);
                        g.W1(l$0, (CameraCaptureSession)obj8);
                        obj8 = g.Q1(this.this$0);
                        if (obj8 == null) {
                        } else {
                            obj8.setRepeatingRequest(g.L1(this.this$0), i4, g.F1(this.this$0));
                            obj8 = g.H1(this.this$0);
                            if (obj8 == null) {
                            } else {
                                d dVar = new d(this.this$0);
                                obj8.setOnTouchListener(dVar);
                                return w.a;
                            }
                            n.w("capture");
                            throw i4;
                        }
                        n.w("session");
                        throw i4;
                    }
                    obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj8;
                }
                this$0 = this.L$0;
                q.b(object);
            } else {
                q.b(object);
                this$0 = this.this$0;
                this.L$0 = this$0;
                this.label = i;
                if (g.T1(this$0, g.G1(this$0), this.$cameraId, g.F1(this.this$0), this) == obj) {
                    return obj;
                }
            }
            g.U1(this$0, (CameraDevice)obj8);
            obj8 = new Surface[i3];
            SurfaceView view = g.R1(this.this$0);
            if (view == null) {
            } else {
                obj8[0] = view.getHolder().getSurface();
                obj8[i] = g.O1(this.this$0);
                label = this.this$0;
                i = g.E1(label);
                if (i == null) {
                } else {
                    this.L$0 = label;
                    this.label = i3;
                    if (g.B1(label, i, p.j(obj8), g.F1(this.this$0), this) == obj) {
                        return obj;
                    }
                    l$0 = label;
                }
                n.w("camera");
                throw i4;
            }
            n.w("viewFinder");
            throw i4;
        }
    }
    static {
        g.a aVar = new g.a(0);
        g.Companion = aVar;
        g.K = /* result */;
    }

    public g() {
        super();
        final int i = 0;
        g.n nVar = new g.n(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, nVar);
        g.c cVar = new g.c(this);
        this.c = j.b(cVar);
        g.d dVar = new g.d(this);
        this.v = j.b(dVar);
        g.i iVar = new g.i(this);
        this.w = j.b(iVar);
        g.m mVar = new g.m(this);
        this.x = j.b(mVar);
        g.l lVar = new g.l(this);
        this.y = j.b(lVar);
        HandlerThread handlerThread = new HandlerThread("CameraThread");
        handlerThread.start();
        w wVar = w.a;
        this.z = handlerThread;
        Handler handler = new Handler(handlerThread.getLooper());
        this.A = handler;
        g.b bVar = new g.b(this);
        this.B = j.b(bVar);
        g.j jVar = new g.j(this);
        this.H = j.b(jVar);
        g.k kVar = new g.k(this);
        this.I = j.b(kVar);
    }

    public static final Object B1(app.dogo.com.dogo_android.c.g g, CameraDevice cameraDevice2, List list3, Handler handler4, d d5) {
        return g.X1(cameraDevice2, list3, handler4, d5);
    }

    public static final MediaRecorder C1(app.dogo.com.dogo_android.c.g g, Surface surface2) {
        return g.Y1(surface2);
    }

    public static final Runnable D1(app.dogo.com.dogo_android.c.g g) {
        return g.Z1();
    }

    public static final CameraDevice E1(app.dogo.com.dogo_android.c.g g) {
        return g.F;
    }

    public static final Handler F1(app.dogo.com.dogo_android.c.g g) {
        return g.A;
    }

    public static final CameraManager G1(app.dogo.com.dogo_android.c.g g) {
        return g.a2();
    }

    public static final ImageButton H1(app.dogo.com.dogo_android.c.g g) {
        return g.G;
    }

    public static final File I1(app.dogo.com.dogo_android.c.g g) {
        return g.b2();
    }

    public static final View J1(app.dogo.com.dogo_android.c.g g) {
        return g.D;
    }

    public static final String[] K1() {
        return g.K;
    }

    public static final CaptureRequest L1(app.dogo.com.dogo_android.c.g g) {
        return g.c2();
    }

    public static final CaptureRequest M1(app.dogo.com.dogo_android.c.g g) {
        return g.d2();
    }

    public static final MediaRecorder N1(app.dogo.com.dogo_android.c.g g) {
        return g.e2();
    }

    public static final Surface O1(app.dogo.com.dogo_android.c.g g) {
        return g.f2();
    }

    public static final long P1(app.dogo.com.dogo_android.c.g g) {
        return g.J;
    }

    public static final CameraCaptureSession Q1(app.dogo.com.dogo_android.c.g g) {
        return g.E;
    }

    public static final SurfaceView R1(app.dogo.com.dogo_android.c.g g) {
        return g.C;
    }

    public static final y1 S1(app.dogo.com.dogo_android.c.g g, String string2) {
        return g.h2(string2);
    }

    public static final Object T1(app.dogo.com.dogo_android.c.g g, CameraManager cameraManager2, String string3, Handler handler4, d d5) {
        return g.m2(cameraManager2, string3, handler4, d5);
    }

    public static final void U1(app.dogo.com.dogo_android.c.g g, CameraDevice cameraDevice2) {
        g.F = cameraDevice2;
    }

    public static final void V1(app.dogo.com.dogo_android.c.g g, long l2) {
        g.J = l2;
    }

    public static final void W1(app.dogo.com.dogo_android.c.g g, CameraCaptureSession cameraCaptureSession2) {
        g.E = cameraCaptureSession2;
    }

    private final Object X1(CameraDevice cameraDevice, List<? extends Surface> list2, Handler handler3, d<? super CameraCaptureSession> d4) {
        i iVar = new i(b.c(d4));
        g.e eVar = new g.e(iVar, cameraDevice);
        cameraDevice.createCaptureSession(list2, eVar, handler3);
        final Object obj3 = iVar.b();
        if (obj3 == b.d()) {
            h.c(d4);
        }
        return obj3;
    }

    private final MediaRecorder Y1(Surface surface) {
        MediaRecorder mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(1);
        int i2 = 2;
        mediaRecorder.setVideoSource(i2);
        mediaRecorder.setOutputFormat(i2);
        mediaRecorder.setOutputFile(b2().getAbsolutePath());
        mediaRecorder.setVideoEncodingBitRate(10000000);
        mediaRecorder.setVideoFrameRate(30);
        mediaRecorder.setVideoEncoder(i2);
        mediaRecorder.setAudioEncoder(3);
        mediaRecorder.setInputSurface(surface);
        return mediaRecorder;
    }

    private final Runnable Z1() {
        return (Runnable)this.B.getValue();
    }

    private final CameraManager a2() {
        return (CameraManager)this.c.getValue();
    }

    private final File b2() {
        return (File)this.w.getValue();
    }

    private final CaptureRequest c2() {
        return (CaptureRequest)this.H.getValue();
    }

    private final CaptureRequest d2() {
        return (CaptureRequest)this.I.getValue();
    }

    private final MediaRecorder e2() {
        return (MediaRecorder)this.y.getValue();
    }

    private final Surface f2() {
        return (Surface)this.x.getValue();
    }

    private final app.dogo.com.dogo_android.c.i g2() {
        return (i)this.a.getValue();
    }

    private final y1 h2(String string) {
        final int i = 0;
        g.f fVar = new g.f(this, string, i);
        return k.d(r.a(this), c1.c(), i, fVar, 2, 0);
    }

    public static void i2(app.dogo.com.dogo_android.c.g g) {
        g.l2(g);
    }

    public static void j2(app.dogo.com.dogo_android.c.g g, Map map2) {
        g.k2(g, map2);
    }

    private static final void k2(app.dogo.com.dogo_android.c.g g, Map map2) {
        boolean aVar;
        Boolean tRUE;
        Object obj3;
        int obj4;
        n.f(g, "this$0");
        n.e(map2, "isSuccess");
        final int i = 1;
        if (map2.isEmpty()) {
            obj4 = i;
        } else {
            obj4 = map2.entrySet().iterator();
            for (Map.Entry next : obj4) {
            }
        }
        if (obj4 != null) {
            obj4 = g.C;
            if (obj4 == null) {
            } else {
                aVar = new a(g);
                obj4.post(aVar);
            }
            n.w("viewFinder");
            throw 0;
        }
        Toast.makeText(g.getContext(), "Permission request denied", i).show();
    }

    private static final void l2(app.dogo.com.dogo_android.c.g g) {
        Object str;
        n.f(g, "this$0");
        String[] cameraIdList = g.a2().getCameraIdList();
        n.e(cameraIdList, "cameraManager.cameraIdList");
        if ((String)i.x(cameraIdList) == null) {
            str = "";
        }
        g.h2(str);
    }

    private final Object m2(CameraManager cameraManager, String string2, Handler handler3, d<? super CameraDevice> d4) {
        q qVar = new q(b.c(d4), 1);
        qVar.B();
        g.h hVar = new g.h(qVar, string2, this);
        cameraManager.openCamera(string2, hVar, handler3);
        final Object obj4 = qVar.y();
        if (obj4 == b.d()) {
            h.c(d4);
        }
        return obj4;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Context requireContext;
        String str;
        boolean obj3;
        super.onCreate(bundle);
        requireContext = requireContext();
        n.e(requireContext, "requireContext()");
        if (g.Companion.c(requireContext)) {
        } else {
            obj3 = new b();
            f fVar = new f(this);
            obj3 = registerForActivityResult(obj3, fVar);
            n.e(obj3, "registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { isSuccess ->\n                if (isSuccess.all { it.value == true }) {\n                    viewFinder.post { initializeCamera(cameraManager.cameraIdList.first() ?: \"\") }\n                } else {\n                    Toast.makeText(context, \"Permission request denied\", Toast.LENGTH_LONG).show()\n                }\n            }");
            obj3.a(/* result */);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ig obj2 = ig.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(g2());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    obj2 = obj2.w();
                    n.e(obj2, "binding.root");
                    return obj2;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.z.quitSafely();
        e2().release();
        f2().release();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        CameraDevice cameraDevice;
        String arr;
        super.onStop();
        cameraDevice = this.F;
        if (cameraDevice == null) {
        } else {
            cameraDevice.close();
        }
        n.w("camera");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        View obj3 = view.findViewById(2131362931);
        n.e(obj3, "view.findViewById(R.id.overlay)");
        this.D = obj3;
        obj3 = view.findViewById(2131363547);
        n.e(obj3, "view.findViewById(R.id.view_finder)");
        this.C = (SurfaceView)obj3;
        View obj2 = view.findViewById(2131362110);
        n.e(obj2, "view.findViewById(R.id.capture_button)");
        this.G = (ImageButton)obj2;
        obj2 = this.C;
        if (obj2 == null) {
        } else {
            obj3 = new g.g(this);
            obj2.getHolder().addCallback(obj3);
        }
        n.w("viewFinder");
        throw 0;
    }
}
