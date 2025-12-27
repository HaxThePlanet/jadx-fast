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
import kotlin.b0.k.a.f;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.y1;

/* compiled from: RecordVideoFragment.kt */
@Metadata(d1 = "\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 a2\u00020\u0001:\u0001aB\u0005¢\u0006\u0002\u0010\u0002J3\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\u000c2\u000c\u0010G\u001a\u0008\u0012\u0004\u0012\u0002020H2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u0010\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u000202H\u0002J\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0002J\u0012\u0010Q\u001a\u00020R2\u0008\u0010S\u001a\u0004\u0018\u00010TH\u0016J$\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020W2\u0008\u0010X\u001a\u0004\u0018\u00010Y2\u0008\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0008\u0010Z\u001a\u00020RH\u0016J\u0008\u0010[\u001a\u00020RH\u0016J\u001a\u0010\\\u001a\u00020R2\u0006\u0010]\u001a\u00020#2\u0008\u0010S\u001a\u0004\u0018\u00010TH\u0017J-\u0010^\u001a\u00020\u000c2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010O\u001a\u00020P2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010\u000eH\u0083@ø\u0001\u0000¢\u0006\u0002\u0010`R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u0008\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001c\u0010\u0008\u001a\u0004\u0008\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008!\u0010\u0008\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008(\u0010\u0008\u001a\u0004\u0008&\u0010'R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008+\u0010\u0008\u001a\u0004\u0008*\u0010'R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u00080\u0010\u0008\u001a\u0004\u0008.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u00085\u0010\u0008\u001a\u0004\u00083\u00104R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008D\u0010\u0008\u001a\u0004\u0008B\u0010C\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006b", d2 = {"Lapp/dogo/com/dogo_android/camerax/RecordVideoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "animationTask", "Ljava/lang/Runnable;", "getAnimationTask", "()Ljava/lang/Runnable;", "animationTask$delegate", "Lkotlin/Lazy;", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentRecordVideoBinding;", "camera", "Landroid/hardware/camera2/CameraDevice;", "cameraHandler", "Landroid/os/Handler;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "getCameraManager", "()Landroid/hardware/camera2/CameraManager;", "cameraManager$delegate", "cameraThread", "Landroid/os/HandlerThread;", "capture", "Landroid/widget/ImageButton;", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getCharacteristics", "()Landroid/hardware/camera2/CameraCharacteristics;", "characteristics$delegate", "outputFile", "Ljava/io/File;", "getOutputFile", "()Ljava/io/File;", "outputFile$delegate", "overlay", "Landroid/view/View;", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "getPreviewRequest", "()Landroid/hardware/camera2/CaptureRequest;", "previewRequest$delegate", "recordRequest", "getRecordRequest", "recordRequest$delegate", "recorder", "Landroid/media/MediaRecorder;", "getRecorder", "()Landroid/media/MediaRecorder;", "recorder$delegate", "recorderSurface", "Landroid/view/Surface;", "getRecorderSurface", "()Landroid/view/Surface;", "recorderSurface$delegate", "recordingStartMillis", "", "screenKey", "Lapp/dogo/com/dogo_android/camerax/RecordVideoScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/camerax/RecordVideoScreen;", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "viewFinder", "Landroid/view/SurfaceView;", "viewModel", "Lapp/dogo/com/dogo_android/camerax/RecordVideoViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/camerax/RecordVideoViewModel;", "viewModel$delegate", "createCaptureSession", "device", "targets", "", "handler", "(Landroid/hardware/camera2/CameraDevice;Ljava/util/List;Landroid/os/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRecorder", "surface", "initializeCamera", "Lkotlinx/coroutines/Job;", "cameraId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onStop", "onViewCreated", "view", "openCamera", "manager", "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;Landroid/os/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class RecordVideoFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final g.a INSTANCE = new g$a(0);
    private static final String[] K;
    private final Handler A = new Handler();
    /* renamed from: B, reason: from kotlin metadata */
    private final kotlin.h binding;
    /* renamed from: C, reason: from kotlin metadata */
    private SurfaceView camera;
    /* renamed from: D, reason: from kotlin metadata */
    private View cameraHandler;
    private CameraCaptureSession E;
    /* renamed from: F, reason: from kotlin metadata */
    private CameraDevice cameraThread;
    /* renamed from: G, reason: from kotlin metadata */
    private ImageButton capture;
    private final kotlin.h H;
    private final kotlin.h I;
    /* renamed from: J, reason: from kotlin metadata */
    private long overlay;
    private final kotlin.h a;
    private ig b;
    private final kotlin.h c;
    private final kotlin.h v;
    /* renamed from: w, reason: from kotlin metadata */
    private final kotlin.h recordingStartMillis;
    private final kotlin.h x;
    /* renamed from: y, reason: from kotlin metadata */
    private final kotlin.h session;
    /* renamed from: z, reason: from kotlin metadata */
    private final HandlerThread viewFinder = new HandlerThread("CameraThread");

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000cR\u000e\u0010\r\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/camerax/RecordVideoFragment$Companion;", "", "()V", "ANIMATION_FAST_MILLIS", "", "ANIMATION_SLOW_MILLIS", "MIN_REQUIRED_RECORDING_TIME_MILLIS", "PERMISSIONS_REQUEST_CODE", "", "PERMISSIONS_REQUIRED", "", "", "[Ljava/lang/String;", "RECORDER_VIDEO_BITRATE", "createFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "extension", "hasPermissions", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public static final /* synthetic */ File a(g.a aVar, Context context, String str) {
            return aVar.createFile(context, str);
        }

        /* renamed from: b, reason: from kotlin metadata */
        private final File createFile(Context context, String extension) throws java.io.IOException {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "VID_";
            String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS", Locale.US).format(new Date());
            extension = str2 + format + 46 + extension;
            return new File(context.getFilesDir(), extension);
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean hasPermissions(Context context) {
            boolean z = false;
            int i;
            int i2;
            n.f(context, "context");
            String[] onDestroy = RecordVideoFragment.K;
            i = 0;
            i = 1;
            for (String str2 : onDestroy) {
                if (i == 0) {
                    break;
                }
            }
            return z;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007", d2 = {"app/dogo/com/dogo_android/camerax/RecordVideoFragment$createCaptureSession$2$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onConfigureFailed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigured", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends CameraCaptureSession.StateCallback {

        final /* synthetic */ d<CameraCaptureSession> a;
        final /* synthetic */ CameraDevice b;
        e(d<? super CameraCaptureSession> dVar, CameraDevice cameraDevice) {
            this.a = dVar;
            this.b = cameraDevice;
            super();
        }

        @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
        public void onConfigureFailed(CameraCaptureSession session) {
            n.f(session, "session");
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Camera ";
            String id = this.b.getId();
            String str3 = " session configuration failed";
            r0 = str2 + id + str3;
            RuntimeException runtimeException = new RuntimeException(r0);
            a.d(runtimeException);
            Object obj = q.a(runtimeException);
            Result.a(obj);
            this.a.resumeWith(obj);
        }

        @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
        public void onConfigured(CameraCaptureSession session) {
            n.f(session, "session");
            Result.a(session);
            this.a.resumeWith(session);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000c", d2 = {"app/dogo/com/dogo_android/camerax/RecordVideoFragment$onViewCreated$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class g implements SurfaceHolder.Callback {

        final /* synthetic */ g a;
        g() {
            this.a = gVar;
            super();
        }

        /* renamed from: b, reason: from kotlin metadata */
        private static final void surfaceDestroyed(g holder) throws android.hardware.camera2.CameraAccessException {
            String str;
            n.f(holder, "this$0");
            String[] cameraIdList = holder.a2().getCameraIdList();
            n.e(cameraIdList, "cameraManager.cameraIdList");
            if ((String)i.x(cameraIdList) == null) {
                str = "";
            }
            holder.h2(str);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            n.f(surfaceHolder, "holder");
            Context requireContext = this.a.requireContext();
            str = "requireContext()";
            n.e(requireContext, str);
            if (RecordVideoFragment.INSTANCE.hasPermissions(requireContext)) {
                SurfaceView surfaceView = this.a.camera;
                if (surfaceView == null) {
                    n.w("viewFinder");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                } else {
                    surfaceView.post(new app.dogo.com.dogo_android.camerax.e(this.a));
                }
            }
        }

        /* renamed from: a, reason: from kotlin metadata */
        public static /* synthetic */ void surfaceCreated(g holder) {
            RecordVideoFragment_onViewCreated_1.surfaceDestroyed(holder);
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            n.f(holder, "holder");
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            n.f(surfaceHolder, "holder");
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n", d2 = {"app/dogo/com/dogo_android/camerax/RecordVideoFragment$openCamera$2$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "device", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class h extends CameraDevice.StateCallback {

        final /* synthetic */ kotlinx.coroutines.p<CameraDevice> a;
        final /* synthetic */ String b;
        final /* synthetic */ g c;
        h(kotlinx.coroutines.p<? super CameraDevice> pVar, String str, g gVar) {
            this.a = pVar;
            this.b = str;
            this.c = gVar;
            super();
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onDisconnected(CameraDevice device) {
            n.f(device, "device");
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Camera ";
            String str4 = " has been disconnected";
            str5 = str2 + this.b + str4;
            a.i(str5, new Object[0]);
            this.c.requireActivity().finish();
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onError(CameraDevice device, int error) {
            String str;
            n.f(device, "device");
            int i6 = 1;
            if (error == i6) {
                str = "Camera in use";
            } else {
                if (error == 2) {
                    str = "Maximum cameras in use";
                } else {
                    if (error == 3) {
                        str = "Device policy";
                    } else {
                        if (error != 4) {
                            String r0 = error != 5 ? "Unknown" : "Fatal (service)";
                        } else {
                            r0 = "Fatal (device)";
                        }
                    }
                }
            }
            final StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Camera ";
            String str5 = " error: (";
            String str6 = ") ";
            error = str3 + this.b + str5 + error + str6 + r0;
            final RuntimeException runtimeException = new RuntimeException(str3 + str4 + str5 + error + str6 + (error != 5 ? "Unknown" : "Fatal (service)"));
            Object[] arr = new Object[i6];
            a.c(runtimeException.getMessage(), new Object[] { runtimeException });
            if (this.a.a()) {
                Object obj = q.a(runtimeException);
                Result.a(obj);
                this.a.resumeWith(obj);
            }
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onOpened(CameraDevice device) {
            n.f(device, "device");
            Result.a(device);
            this.a.resumeWith(device);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Ljava/lang/Runnable;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<Runnable> {
        private static final void b(g gVar) throws b {
            n.f(gVar, "this$0");
            View view = gVar.cameraHandler;
            int i = 0;
            String str2 = "overlay";
            if (view == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                int i4 = 255;
                int argb = Color.argb(150, i4, i4, i4);
                view.setForeground(new ColorDrawable(argb));
                View view2 = gVar.cameraHandler;
                if (view2 == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    view2.postDelayed(new app.dogo.com.dogo_android.camerax.b(gVar), 50L);
                    return;
                }
            }
        }

        private static final void c(g gVar) {
            n.f(gVar, "this$0");
            View view = gVar.cameraHandler;
            String str2 = "overlay";
            final android.graphics.drawable.Drawable drawable = null;
            if (view == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) drawable;
            } else {
                view.setForeground(drawable);
                View view2 = gVar.cameraHandler;
                if (view2 == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) drawable;
                } else {
                    view2.postDelayed(gVar.Z1(), 50L);
                    return;
                }
            }
        }

        @Override // kotlin.d0.d.p
        public final Runnable a() {
            return new app.dogo.com.dogo_android.camerax.c(g.this);
        }

        b() {
            super(0);
        }

        public static /* synthetic */ void e(g gVar) {
            app.dogo.com.dogo_android.camerax.g.b.c(gVar);
        }

        public static /* synthetic */ void f(g gVar) {
            app.dogo.com.dogo_android.camerax.g.b.b(gVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/hardware/camera2/CameraManager;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<CameraManager> {
        @Override // kotlin.d0.d.p
        public final CameraManager a() {
            Object systemService = g.this.requireContext().getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            return systemService;
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/hardware/camera2/CameraCharacteristics;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<CameraCharacteristics> {
        @Override // kotlin.d0.d.p
        public final CameraCharacteristics a() throws android.hardware.camera2.CameraAccessException {
            String str;
            String[] cameraIdList = g.this.a2().getCameraIdList();
            n.e(cameraIdList, "cameraManager.cameraIdList");
            if ((String)i.x(cameraIdList) == null) {
                str = "";
            }
            CameraCharacteristics cameraCharacteristics = g.this.a2().getCameraCharacteristics(str);
            n.e(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraManager.cameraIdList.first() ?: \"\")");
            return cameraCharacteristics;
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Ljava/io/File;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends kotlin.d0.d.p implements kotlin.d0.c.a<File> {
        @Override // kotlin.d0.d.p
        public final File a() {
            Context requireContext = g.this.requireContext();
            n.e(requireContext, "requireContext()");
            return RecordVideoFragment.INSTANCE.createFile(requireContext, "mp4");
        }

        i() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/hardware/camera2/CaptureRequest;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class j extends kotlin.d0.d.p implements kotlin.d0.c.a<CaptureRequest> {
        @Override // kotlin.d0.d.p
        public final CaptureRequest a() throws android.hardware.camera2.CameraAccessException {
            CameraCaptureSession cameraCaptureSession = g.this.E;
            int i = 0;
            if (cameraCaptureSession == null) {
                n.w("session");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                CaptureRequest.Builder captureRequest = cameraCaptureSession.getDevice().createCaptureRequest(1);
                SurfaceView surfaceView = g.this.camera;
                if (surfaceView == null) {
                    n.w("viewFinder");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    captureRequest.addTarget(surfaceView.getHolder().getSurface());
                    CaptureRequest builder = captureRequest.build();
                    n.e(builder, "session.device.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW).apply {\n            // Add the preview surface target\n            addTarget(viewFinder.holder.surface)\n        }.build()");
                    return builder;
                }
            }
        }

        j() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/hardware/camera2/CaptureRequest;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends kotlin.d0.d.p implements kotlin.d0.c.a<CaptureRequest> {
        @Override // kotlin.d0.d.p
        public final CaptureRequest a() throws android.hardware.camera2.CameraAccessException {
            CameraCaptureSession cameraCaptureSession = g.this.E;
            int i = 0;
            if (cameraCaptureSession == null) {
                n.w("session");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                CaptureRequest.Builder captureRequest = cameraCaptureSession.getDevice().createCaptureRequest(3);
                SurfaceView surfaceView = g.this.camera;
                if (surfaceView == null) {
                    n.w("viewFinder");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    captureRequest.addTarget(surfaceView.getHolder().getSurface());
                    captureRequest.addTarget(g.this.f2());
                    captureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range(20, 30));
                    CaptureRequest builder = captureRequest.build();
                    n.e(builder, "session.device.createCaptureRequest(CameraDevice.TEMPLATE_RECORD).apply {\n            // Add the preview and recording surface targets\n            addTarget(viewFinder.holder.surface)\n            addTarget(recorderSurface)\n            // Sets user requested FPS for all targets\n            set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, Range(20, 30))\n        }.build()");
                    return builder;
                }
            }
        }

        k() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/media/MediaRecorder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class l extends kotlin.d0.d.p implements kotlin.d0.c.a<MediaRecorder> {
        @Override // kotlin.d0.d.p
        public final MediaRecorder a() {
            return g.this.Y1(g.this.f2());
        }

        l() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Landroid/view/Surface;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class m extends kotlin.d0.d.p implements kotlin.d0.c.a<Surface> {
        @Override // kotlin.d0.d.p
        public final Surface a() throws java.io.IOException {
            final Surface persistentInputSurface = MediaCodec.createPersistentInputSurface();
            n.e(persistentInputSurface, "createPersistentInputSurface()");
            MediaRecorder onViewCreated = g.this.Y1(persistentInputSurface);
            onViewCreated.prepare();
            onViewCreated.release();
            return persistentInputSurface;
        }

        m() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class n extends kotlin.d0.d.p implements kotlin.d0.c.a<i> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final i invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(RecordVideoViewModel.class), this.$parameters);
        }

        public n(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.camerax.RecordVideoFragment$initializeCamera$1", f = "RecordVideoFragment.kt", l = {250, 256}, m = "invokeSuspend")
    static final class f extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ String $cameraId;
        Object L$0;
        int label;
        private static final boolean e(g gVar, View view, MotionEvent motionEvent) {
            final Object gVar2 = gVar;
            int action = motionEvent.getAction();
            final d dVar = null;
            final int i3 = 1;
            if (action == 0) {
                kotlinx.coroutines.o0 o0Var2 = null;
                int i2 = 2;
                Object obj2 = null;
                kotlinx.coroutines.internal.k.d(r.a(gVar), Dispatchers.b(), o0Var2, new app.dogo.com.dogo_android.camerax.g.f.a(gVar2, dVar), i2, obj2);
            } else {
                if (action == i3) {
                    kotlinx.coroutines.o0 o0Var = null;
                    int i = 2;
                    Object obj = null;
                    kotlinx.coroutines.internal.k.d(r.a(gVar), Dispatchers.b(), o0Var, new app.dogo.com.dogo_android.camerax.g.f.b(gVar2, view, dVar), i, obj);
                }
            }
            return true;
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) throws android.hardware.camera2.CameraAccessException {
            app.dogo.com.dogo_android.c.g gVar;
            app.dogo.com.dogo_android.c.g gVar2;
            Handler onCreate2;
            CameraCaptureSession cameraCaptureSession;
            CameraDevice cameraDevice;
            Object obj = b.d();
            final int i3 = 2;
            int i = 1;
            final android.hardware.camera2.CameraCaptureSession.CaptureCallback captureCallback = null;
            if (this.label != 0) {
                if (this.label != i) {
                    if (this.label != i3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(object);
                        gVar.E = (CameraCaptureSession)cameraCaptureSession;
                        CameraCaptureSession cameraCaptureSession2 = g.this.E;
                        if (cameraCaptureSession2 == null) {
                            n.w("session");
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) captureCallback;
                        } else {
                            cameraCaptureSession2.setRepeatingRequest(g.this.c2(), captureCallback, g.this.A);
                            ImageButton imageButton = g.this.capture;
                            if (imageButton == null) {
                                n.w("capture");
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) captureCallback;
                            } else {
                                imageButton.setOnTouchListener(new app.dogo.com.dogo_android.camerax.d(g.this));
                                return w.a;
                            }
                        }
                    }
                }
                q.b(object);
            } else {
                q.b(object);
                this.L$0 = g.this;
                this.label = i;
                if (g.this.m2(g.this.a2(), this.$cameraId, g.this.A, this) == obj) {
                    return obj;
                }
            }
            gVar2.cameraThread = (CameraDevice)cameraDevice;
            Surface[] arr = new Surface[i3];
            SurfaceView surfaceView = g.this.camera;
            if (surfaceView == null) {
                n.w("viewFinder");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) captureCallback;
            } else {
                CameraDevice initializeCamera = g.this.cameraThread;
                if (initializeCamera == null) {
                    n.w("camera");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) captureCallback;
                } else {
                    this.L$0 = g.this;
                    this.label = i3;
                    if (g.this.X1(initializeCamera, p.j(new Surface[] { surfaceView.getHolder().getSurface(), g.this.f2() }), g.this.A, this) == obj) {
                        return obj;
                    }
                }
            }
        }

        f(String str, d<? super g.f> dVar) {
            this.$cameraId = str;
            super(2, dVar);
        }

        public static /* synthetic */ boolean f(g gVar, View view, MotionEvent motionEvent) {
            return app.dogo.com.dogo_android.camerax.g.f.e(gVar, view, motionEvent);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.camerax.g.f)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.camerax.g.f(g.this, this.$cameraId, dVar);
        }
    }
    static {
        RecordVideoFragment.K = new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" };
    }

    public g() {
        super();
        final m.a.c.j.a aVar = null;
        this.a = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.camerax.g.n(this, aVar, aVar));
        this.c = j.b(new app.dogo.com.dogo_android.camerax.g.c(this));
        this.v = j.b(new app.dogo.com.dogo_android.camerax.g.d(this));
        this.recordingStartMillis = j.b(new app.dogo.com.dogo_android.camerax.g.i(this));
        this.x = j.b(new app.dogo.com.dogo_android.camerax.g.m(this));
        this.session = j.b(new app.dogo.com.dogo_android.camerax.g.l(this));
        HandlerThread handlerThread = new HandlerThread("CameraThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.binding = j.b(new app.dogo.com.dogo_android.camerax.g.b(this));
        this.H = j.b(new app.dogo.com.dogo_android.camerax.g.j(this));
        this.I = j.b(new app.dogo.com.dogo_android.camerax.g.k(this));
    }

    public static final /* synthetic */ Object B1(g gVar, CameraDevice cameraDevice, List list, Handler handler, d dVar) {
        return gVar.X1(cameraDevice, list, handler, dVar);
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ MediaRecorder onViewCreated(g view, Surface savedInstanceState) {
        return view.Y1(savedInstanceState);
    }

    /* renamed from: D1, reason: from kotlin metadata */
    public static final /* synthetic */ Runnable createRecorder(g surface) {
        return surface.Z1();
    }

    /* renamed from: E1, reason: from kotlin metadata */
    public static final /* synthetic */ CameraDevice initializeCamera(g cameraId) {
        return cameraId.cameraThread;
    }

    /* renamed from: F1, reason: from kotlin metadata */
    public static final /* synthetic */ Handler onCreate(g savedInstanceState) {
        return savedInstanceState.A;
    }

    public static final /* synthetic */ CameraManager G1(g gVar) {
        return gVar.a2();
    }

    public static final /* synthetic */ ImageButton H1(g gVar) {
        return gVar.capture;
    }

    public static final /* synthetic */ File I1(g gVar) {
        return gVar.b2();
    }

    public static final /* synthetic */ View J1(g gVar) {
        return gVar.cameraHandler;
    }

    /* renamed from: K1, reason: from kotlin metadata */
    public static final /* synthetic */ String[] onDestroy() {
        return RecordVideoFragment.K;
    }

    public static final /* synthetic */ CaptureRequest L1(g gVar) {
        return gVar.c2();
    }

    public static final /* synthetic */ CaptureRequest M1(g gVar) {
        return gVar.d2();
    }

    public static final /* synthetic */ MediaRecorder N1(g gVar) {
        return gVar.e2();
    }

    public static final /* synthetic */ Surface O1(g gVar) {
        return gVar.f2();
    }

    public static final /* synthetic */ long P1(g gVar) {
        return gVar.overlay;
    }

    public static final /* synthetic */ CameraCaptureSession Q1(g gVar) {
        return gVar.E;
    }

    public static final /* synthetic */ SurfaceView R1(g gVar) {
        return gVar.camera;
    }

    public static final /* synthetic */ y1 S1(g gVar, String str) {
        return gVar.h2(str);
    }

    public static final /* synthetic */ Object T1(g gVar, CameraManager cameraManager, String str, Handler handler, d dVar) {
        return gVar.m2(cameraManager, str, handler, dVar);
    }

    public static final /* synthetic */ void U1(g gVar, CameraDevice cameraDevice) {
        gVar.cameraThread = cameraDevice;
    }

    public static final /* synthetic */ void V1(g gVar, long j) {
        gVar.overlay = j;
    }

    public static final /* synthetic */ void W1(g gVar, CameraCaptureSession cameraCaptureSession) {
        gVar.E = cameraCaptureSession;
    }

    private final Object X1(CameraDevice cameraDevice, List<? extends Surface> list, Handler handler, d<? super CameraCaptureSession> dVar) throws android.hardware.camera2.CameraAccessException {
        final kotlin.b0.i safeContinuation = new SafeContinuation(b.c(dVar));
        cameraDevice.createCaptureSession(list, new RecordVideoFragment_createCaptureSession_2_1(safeContinuation, cameraDevice), handler);
        final Object obj = safeContinuation.b();
        if (obj == b.d()) {
            h.c(dVar);
        }
        return obj;
    }

    private final MediaRecorder Y1(Surface surface) {
        final MediaRecorder mediaRecorder = new MediaRecorder();
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
        return (Runnable)this.binding.getValue();
    }

    private final CameraManager a2() {
        return (CameraManager)this.c.getValue();
    }

    private final File b2() {
        return (File)this.recordingStartMillis.getValue();
    }

    private final CaptureRequest c2() {
        return (CaptureRequest)this.H.getValue();
    }

    private final CaptureRequest d2() {
        return (CaptureRequest)this.I.getValue();
    }

    private final MediaRecorder e2() {
        return (MediaRecorder)this.session.getValue();
    }

    private final Surface f2() {
        return (Surface)this.x.getValue();
    }

    private final i g2() {
        return (RecordVideoViewModel)this.a.getValue();
    }

    private final y1 h2(String str) {
        final d dVar = null;
        return kotlinx.coroutines.internal.k.d(r.a(this), Dispatchers.c(), dVar, new app.dogo.com.dogo_android.camerax.g.f(this, str, dVar), 2, null);
    }

    private static final void k2(g gVar, Map map) throws android.content.res.Resources.NotFoundException {
        boolean hasNext;
        Boolean tRUE2;
        int i = 0;
        n.f(gVar, "this$0");
        n.e(map, "isSuccess");
        i = 1;
        map = i;
        if (i != 0) {
            if (gVar.camera == null) {
                n.w("viewFinder");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                gVar.camera.post(new app.dogo.com.dogo_android.camerax.a(gVar));
                return;
            }
        }
        Toast.makeText(gVar.getContext(), "Permission request denied", i).show();
    }

    private static final void l2(g gVar) throws android.hardware.camera2.CameraAccessException {
        String str;
        n.f(gVar, "this$0");
        String[] cameraIdList = gVar.a2().getCameraIdList();
        n.e(cameraIdList, "cameraManager.cameraIdList");
        if ((String)i.x(cameraIdList) == null) {
            str = "";
        }
        gVar.h2(str);
    }

    private final Object m2(CameraManager cameraManager, String str, Handler handler, d<? super CameraDevice> dVar) throws android.hardware.camera2.CameraAccessException {
        final kotlinx.coroutines.q cancellableContinuationImpl = new CancellableContinuationImpl(b.c(dVar), 1);
        cancellableContinuationImpl.B();
        cameraManager.openCamera(str, new RecordVideoFragment_openCamera_2_1(cancellableContinuationImpl, str, this), handler);
        final Object obj = cancellableContinuationImpl.y();
        if (obj == b.d()) {
            h.c(dVar);
        }
        return obj;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context requireContext = requireContext();
        str = "requireContext()";
        n.e(requireContext, str);
        if (!(RecordVideoFragment.INSTANCE.hasPermissions(requireContext))) {
            c registerForActivityResult = registerForActivityResult(new b(), new app.dogo.com.dogo_android.camerax.f(this));
            n.e(registerForActivityResult, "registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { isSuccess ->\n                if (isSuccess.all { it.value == true }) {\n                    viewFinder.post { initializeCamera(cameraManager.cameraIdList.first() ?: \"\") }\n                } else {\n                    Toast.makeText(context, \"Permission request denied\", Toast.LENGTH_LONG).show()\n                }\n            }");
            str = "android.permission.RECORD_AUDIO";
            registerForActivityResult.a(new String[] { "android.permission.CAMERA", str });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ig igVar = ig.T(inflater, container, false);
        n.e(igVar, "inflate(inflater, container, false)");
        this.b = igVar;
        int i = 0;
        String str4 = "binding";
        if (igVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            igVar.V(g2());
            if (this.b == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.M(getViewLifecycleOwner());
                if (this.b == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    View view = this.b.w();
                    n.e(view, "binding.root");
                    return view;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.viewFinder.quitSafely();
        e2().release();
        f2().release();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        try {
            this.cameraThread.close();
            n.w("camera");
        } catch (Throwable th) {
            String arr = "Error closing camera ";
            th = n.o(arr, th);
            arr = null;
            arr = new Object[arr];
            a.c(th, arr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        View viewById2 = view.findViewById(2131362931);
        n.e(viewById2, "view.findViewById(R.id.overlay)");
        this.cameraHandler = viewById2;
        View viewById3 = view.findViewById(2131363547);
        n.e(viewById3, "view.findViewById(R.id.view_finder)");
        this.camera = viewById3;
        View viewById = view.findViewById(2131362110);
        n.e(viewById, "view.findViewById(R.id.capture_button)");
        this.capture = viewById;
        if (this.camera == null) {
            n.w("viewFinder");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            this.camera.getHolder().addCallback(new RecordVideoFragment_onViewCreated_1(this));
            return;
        }
    }

    public static /* synthetic */ void i2(g gVar) {
        RecordVideoFragment.l2(gVar);
    }

    public static /* synthetic */ void j2(g gVar, Map map) {
        RecordVideoFragment.k2(gVar, map);
    }
}
