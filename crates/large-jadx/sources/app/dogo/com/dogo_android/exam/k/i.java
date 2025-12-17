package app.dogo.com.dogo_android.exam.k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.AudioRecord;
import android.media.AudioRecord.Builder;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.r;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.VideoRecordingButton;
import app.dogo.com.dogo_android.exam.d;
import app.dogo.com.dogo_android.exam.f;
import app.dogo.com.dogo_android.exam.j.h;
import app.dogo.com.dogo_android.h.ad;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.m0.b;
import f.d.a.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 X2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001XB\u0005¢\u0006\u0002\u0010\u0005J\u0008\u0010\u001e\u001a\u00020\u001fH\u0002J\u0008\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0002J\u0008\u0010$\u001a\u00020\u001fH\u0002J\u001d\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010(J\u0008\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u000202H\u0002J\u0008\u00103\u001a\u00020\u001fH\u0016J\u0008\u00104\u001a\u00020\u001fH\u0016J \u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020+H\u0016J\u001a\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020<2\u0008\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0008\u0010?\u001a\u00020\u001fH\u0016J\u0008\u0010@\u001a\u00020\u001fH\u0016J\u0008\u0010A\u001a\u00020\u001fH\u0002J\u001a\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020+2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010F\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u000bH\u0002J\u001c\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020+2\n\u0010K\u001a\u00060Lj\u0002`MH\u0002J)\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00072\u0012\u0010P\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00110&\"\u00020\u0011H\u0002¢\u0006\u0002\u0010QJ \u0010R\u001a\u00020\u001f2\u000e\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110S2\u0006\u0010T\u001a\u00020UH\u0002J\u0008\u0010V\u001a\u00020\u001fH\u0002J\u0008\u0010W\u001a\u00020\u001fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u0018\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006Y", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentExamVideoRecordingBinding;", "Lapp/dogo/com/dogo_android/exam/record/ExamRecordScreen;", "Lapp/dogo/com/dogo_android/exam/record/ExamRecordCallbacks;", "()V", "cameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "isAudioAvailable", "", "()Z", "isCompatAdjustmentsNeeded", "mediaRecorder", "Landroid/media/MediaRecorder;", "previewSurface", "Landroid/view/Surface;", "recordingSurface", "sharedViewModel", "Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/exam/record/ExamRecordViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/exam/record/ExamRecordViewModel;", "viewModel$delegate", "attemptPreview", "", "cancelFlow", "createCameraCaptureSession", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "disableSwitchButtonForFewSecs", "getCameraSupportedSurfaceTextureSizes", "", "Landroid/util/Size;", "(Landroid/hardware/camera2/CameraManager;)[Landroid/util/Size;", "getMediaRecorder", "getSensorOrientation", "", "initializeMediaRecorder", "logMediaRecorderEvent", "what", "extra", "nextScreen", "data", "Landroid/net/Uri;", "onPause", "onResume", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "recordingStarted", "recordingStopped", "refreshCamera", "selectCamera", "", "cameraCharacteristic", "selectPreviewSize", "selectRecordingSize", "setRecordingButtonEnabled", "enabled", "showError", "res", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "startCameraCapture", "session", "surfaces", "(Landroid/hardware/camera2/CameraCaptureSession;[Landroid/view/Surface;)V", "startCaptureSession", "", "stateCallback", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "stop", "switchCamera", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends b<ad, app.dogo.com.dogo_android.exam.k.j> implements app.dogo.com.dogo_android.exam.k.h {

    private static final List<String> C;
    public static final app.dogo.com.dogo_android.exam.k.i.b Companion;
    private MediaRecorder A;
    private Surface B;
    private final h v;
    private final h w;
    private CameraDevice x;
    private Surface y;
    private CameraCaptureSession z;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordFragment$Companion;", "", "()V", "DEBOUNCE_TIMEOUT_MS", "", "compatibilityDeviceModels", "", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n", d2 = {"app/dogo/com/dogo_android/exam/record/ExamRecordFragment$attemptPreview$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends CameraDevice.StateCallback {

        final app.dogo.com.dogo_android.exam.k.i a;
        final CameraManager b;
        c(app.dogo.com.dogo_android.exam.k.i i, CameraManager cameraManager2) {
            this.a = i;
            this.b = cameraManager2;
            super();
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            n.f(cameraDevice, "cameraDevice");
            IllegalStateException illegalStateException = new IllegalStateException("Camera disconnected");
            i.O1(this.a, 2131886123, illegalStateException);
            i.G1(this.a);
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onError(CameraDevice cameraDevice, int i2) {
            n.f(cameraDevice, "cameraDevice");
            Exception exception = new Exception(n.o("Camera error ", Integer.valueOf(i2)));
            i.O1(this.a, 2131886123, exception);
            i.G1(this.a);
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            int i;
            int surface;
            int width;
            app.dogo.com.dogo_android.exam.k.i obj3;
            n.f(cameraDevice, "cameraDevice");
            i.L1(this.a, cameraDevice);
            obj3 = i.J1(this.a, this.b);
            if (obj3 == null) {
                Toast.makeText(this.a.getContext(), 2131886123, 1).show();
                i.G1(this.a);
            } else {
                SurfaceTexture surfaceTexture = view.O.getSurfaceTexture();
                if (surfaceTexture == null) {
                } else {
                    surfaceTexture.setDefaultBufferSize(obj3.getWidth(), obj3.getHeight());
                }
                surface = new Surface(surfaceTexture);
                i.M1(this.a, surface);
                i.H1(this.a, this.b);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007", d2 = {"app/dogo/com/dogo_android/exam/record/ExamRecordFragment$createCameraCaptureSession$stateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onConfigureFailed", "", "cameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigured", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends CameraCaptureSession.StateCallback {

        final app.dogo.com.dogo_android.exam.k.i a;
        d(app.dogo.com.dogo_android.exam.k.i i) {
            this.a = i;
            super();
        }

        @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            n.f(cameraCaptureSession, "cameraCaptureSession");
            Exception exception = new Exception("Couldn't configure camera capture session");
            i.O1(this.a, 2131886123, exception);
            i.G1(this.a);
        }

        @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            app.dogo.com.dogo_android.exam.k.i iVar;
            int i2;
            Surface[] arr;
            int i;
            n.f(cameraCaptureSession, "cameraCaptureSession");
            Surface surface = i.I1(this.a);
            if (surface == null) {
            } else {
                iVar = this.a;
                i.K1(iVar, cameraCaptureSession);
                i2 = 1;
                arr = new Surface[i2];
                arr[0] = surface;
                i.P1(iVar, cameraCaptureSession, arr);
                i.N1(iVar, i2);
            }
        }
    }

    @Metadata(d1 = "\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\n", d2 = {"app/dogo/com/dogo_android/exam/record/ExamRecordFragment$startCameraCapture$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureFailed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "failure", "Landroid/hardware/camera2/CaptureFailure;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class h extends CameraCaptureSession.CaptureCallback {
        @Override // android.hardware.camera2.CameraCaptureSession$CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest2, CaptureFailure captureFailure3) {
            n.f(cameraCaptureSession, "session");
            n.f(captureRequest2, "request");
            n.f(captureFailure3, "failure");
            Exception obj2 = new Exception(n.o("Camera capture failure ", Integer.valueOf(captureFailure3.getReason())));
            a.d(obj2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class f extends p implements a<f> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public f(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final f invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(f.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends p implements a<app.dogo.com.dogo_android.exam.k.k> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public g(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.exam.k.k invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(k.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements a<a> {

        final app.dogo.com.dogo_android.exam.k.i this$0;
        i(app.dogo.com.dogo_android.exam.k.i i) {
            this.this$0 = i;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b((j)this.this$0.C1().a());
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.exam.record.ExamRecordFragment$disableSwitchButtonForFewSecs$1", f = "ExamRecordFragment.kt", l = 114, m = "invokeSuspend")
    static final class e extends k implements p<m0, d<? super w>, Object> {

        Object L$0;
        int label;
        final app.dogo.com.dogo_android.exam.k.i this$0;
        e(app.dogo.com.dogo_android.exam.k.i i, d<? super app.dogo.com.dogo_android.exam.k.i.e> d2) {
            this.this$0 = i;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (i.e)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            i.e obj2 = new i.e(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            int label;
            int i;
            Object obj7;
            Object obj = b.d();
            label = this.label;
            final int i4 = 0;
            final int i5 = 1;
            if (label != 0) {
                if (label != i5) {
                } else {
                    l$0 = this.L$0;
                    q.b(object);
                    l$0.setImageTintList(ColorStateList.valueOf(this.this$0.getResources().getColor(2131100379, i4)));
                    l$0.setClickable(i5);
                    return w.a;
                }
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
            }
            q.b(object);
            obj7 = obj7.U;
            n.e(obj7, "binding.switchCameraButton");
            obj7.setImageTintList(ColorStateList.valueOf(this.this$0.getResources().getColor(2131099767, i4)));
            obj7.setClickable(false);
            this.L$0 = obj7;
            this.label = i5;
            if (x0.a(1000, obj5) == obj) {
                return obj;
            }
            l$0 = obj7;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, ad> {

        public static final app.dogo.com.dogo_android.exam.k.i.a a;
        static {
            i.a aVar = new i.a();
            i.a.a = aVar;
        }

        a() {
            super(3, ad.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentExamVideoRecordingBinding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final ad l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return ad.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
        i.b bVar = new i.b(0);
        i.Companion = bVar;
        i.C = p.j(/* result */);
    }

    public i() {
        super(i.a.a);
        i.i iVar = new i.i(this);
        final int i = 0;
        i.g gVar = new i.g(this, i, iVar);
        this.v = j.a(m.SYNCHRONIZED, gVar);
        i.f fVar = new i.f(this, i, i);
        this.w = j.a(m.NONE, fVar);
    }

    private final void A2() {
        boolean z;
        MediaRecorder mediaRecorder;
        Boolean fALSE;
        Exception exception;
        String str;
        view.R.b();
        CameraCaptureSession cameraCaptureSession = this.z;
        synchronized (this) {
            try {
                cameraCaptureSession.close();
                int i = 0;
                this.z = i;
                CameraDevice cameraDevice = this.x;
                if (cameraDevice == null) {
                } else {
                }
                cameraDevice.close();
                this.x = i;
                Surface surface2 = this.y;
                if (surface2 == null) {
                } else {
                }
                surface2.release();
                this.y = i;
                if (n.b(Y1().n().getValue(), Boolean.TRUE)) {
                }
                mediaRecorder = this.A;
                if (mediaRecorder == null) {
                } else {
                }
                mediaRecorder.stop();
                exception = new Exception("Couldn't stop media recorder", th2);
                x2(2131886123, exception);
                R1();
                Y1().n().postValue(Boolean.FALSE);
                MediaRecorder mediaRecorder2 = this.A;
                if (mediaRecorder2 == null) {
                } else {
                }
                mediaRecorder2.release();
                this.A = i;
                Surface surface = this.B;
                if (surface == null) {
                } else {
                }
                surface.release();
                int i2 = 0;
                Y1().r(i2);
                w2(i2);
                throw th;
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
        }
    }

    private final void B2() {
        Y1().s();
        q2();
        T1();
    }

    public static final void G1(app.dogo.com.dogo_android.exam.k.i i) {
        i.R1();
    }

    public static final void H1(app.dogo.com.dogo_android.exam.k.i i, CameraManager cameraManager2) {
        i.S1(cameraManager2);
    }

    public static final Surface I1(app.dogo.com.dogo_android.exam.k.i i) {
        return i.y;
    }

    public static final Size J1(app.dogo.com.dogo_android.exam.k.i i, CameraManager cameraManager2) {
        return i.s2(cameraManager2);
    }

    public static final void K1(app.dogo.com.dogo_android.exam.k.i i, CameraCaptureSession cameraCaptureSession2) {
        i.z = cameraCaptureSession2;
    }

    public static final void L1(app.dogo.com.dogo_android.exam.k.i i, CameraDevice cameraDevice2) {
        i.x = cameraDevice2;
    }

    public static final void M1(app.dogo.com.dogo_android.exam.k.i i, Surface surface2) {
        i.y = surface2;
    }

    public static final void N1(app.dogo.com.dogo_android.exam.k.i i, boolean z2) {
        i.w2(z2);
    }

    public static final void O1(app.dogo.com.dogo_android.exam.k.i i, int i2, Exception exception3) {
        i.x2(i2, exception3);
    }

    public static final void P1(app.dogo.com.dogo_android.exam.k.i i, CameraCaptureSession cameraCaptureSession2, Surface... surface3Arr3) {
        i.y2(cameraCaptureSession2, surface3Arr3);
    }

    private final void Q1() {
        boolean illegalStateException;
        Exception exception;
        String str;
        int i;
        app.dogo.com.dogo_android.exam.k.i.c cVar;
        synchronized (this) {
            try {
                if (!Y1().m()) {
                }
                Y1().r(true);
                illegalStateException = a.k(requireContext(), CameraManager.class);
                exception = 0;
                if ((CameraManager)illegalStateException != null) {
                } else {
                }
                str = r2(Y1().j(), (CameraManager)illegalStateException);
                str = exception;
                if (str != null) {
                } else {
                }
                if (illegalStateException == null) {
                } else {
                }
                cVar = new i.c(this, illegalStateException);
                illegalStateException.openCamera(str, cVar, exception);
                exception = new Exception("Couldn't open camera", th);
                x2(obj3, exception);
                R1();
                illegalStateException = new IllegalStateException("Missing selected camera");
                x2(2131886123, illegalStateException);
                R1();
                throw th;
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
        }
    }

    private final void R1() {
        androidx.fragment.app.e activity;
        if (activity instanceof d) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.d();
        }
    }

    private final void S1(CameraManager cameraManager) {
        app.dogo.com.dogo_android.exam.k.i.d dVar;
        Surface surface;
        String str;
        List obj4;
        synchronized (this) {
            try {
                obj4 = new Surface[2];
                dVar = new i.d(this);
                z2(p.j(this.y, this.B), dVar);
                Exception exception = new Exception("Couldn't create camera capture session", cameraManager);
                x2(2131886123, exception);
                R1();
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
        }
    }

    private final void T1() {
        final int i = 0;
        i.e eVar = new i.e(this, i);
        k.d(r.a(this), i, 0, eVar, 3, 0);
    }

    private final Size[] U1(CameraManager cameraManager) {
        int sCALER_STREAM_CONFIGURATION_MAP;
        int i;
        CameraDevice cameraDevice;
        String str;
        int obj5;
        if (!StreamConfigurationMap.isOutputSupportedFor(SurfaceTexture.class)) {
            obj5 = new Exception("SurfaceTexture not supported for output");
            a.d(obj5);
        } else {
            CameraDevice cameraDevice2 = this.x;
            n.d(cameraDevice2);
            obj5 = cameraManager.getCameraCharacteristics(cameraDevice2.getId());
            n.e(obj5, "cameraManager.getCameraCharacteristics(cameraDevice!!.id)");
            obj5 = obj5.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if ((StreamConfigurationMap)obj5 == null) {
                obj5 = i;
            } else {
                obj5 = (StreamConfigurationMap)obj5.getOutputSizes(SurfaceTexture.class);
            }
            if (obj5 != null) {
                sCALER_STREAM_CONFIGURATION_MAP = obj5.length == 0 ? 1 : 0;
                if (sCALER_STREAM_CONFIGURATION_MAP != null) {
                    obj5 = new Exception("No supported output sizes");
                    a.d(obj5);
                } else {
                    i = obj5;
                }
            } else {
            }
        }
        return i;
    }

    private final MediaRecorder V1() {
        MediaRecorder mediaRecorder;
        Context requireContext;
        if (Build.VERSION.SDK_INT >= 31) {
            mediaRecorder = new MediaRecorder(requireContext());
        } else {
            mediaRecorder = new MediaRecorder();
        }
        return mediaRecorder;
    }

    private final int W1(CameraManager cameraManager) {
        String str2;
        Exception exception;
        CameraDevice cameraDevice;
        String str;
        int obj5;
        try {
            CameraDevice cameraDevice2 = this.x;
            n.d(cameraDevice2);
            obj5 = cameraManager.getCameraCharacteristics(cameraDevice2.getId());
            n.e(obj5, "cameraManager.getCameraCharacteristics(cameraDevice!!.id)");
            obj5 = obj5.get(CameraCharacteristics.SENSOR_ORIENTATION);
            n.d(obj5);
            n.e(obj5, "{\n            val cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraDevice!!.id)\n            cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)!!\n        }");
            obj5 = (Number)obj5.intValue();
            cameraDevice = this.x;
            n.d(cameraDevice);
            cameraDevice = cameraDevice.getId();
            cameraDevice = n.o("Camera disconnected, ID = ", cameraDevice);
            exception = new Exception(cameraDevice, cameraManager);
            x2(2131886123, exception);
            R1();
            cameraManager = null;
            return obj5;
        }
    }

    private final boolean Z1(CameraManager cameraManager) {
        boolean z;
        Size height;
        Object path;
        MediaRecorder mediaRecorder2;
        int i;
        Object aVar;
        MediaRecorder mediaRecorder;
        MediaRecorder mediaRecorder3;
        String str;
        int width;
        int obj7;
        z = c2();
        synchronized (this) {
            try {
                aVar = new Exception("Audio unavailable");
                x2(2131886516, aVar);
                Y1().p();
                MediaRecorder mediaRecorder8 = V1();
                this.A = mediaRecorder8;
                if (mediaRecorder8 == null) {
                } else {
                }
                aVar = new c(this);
                mediaRecorder8.setOnErrorListener(aVar);
                MediaRecorder mediaRecorder9 = this.A;
                if (mediaRecorder9 == null) {
                } else {
                }
                aVar = new a(this);
                mediaRecorder9.setOnInfoListener(aVar);
                int i2 = 1;
                if (z) {
                }
                aVar = this.A;
                if (aVar == null) {
                } else {
                }
                aVar.setAudioSource(i2);
                MediaRecorder mediaRecorder10 = this.A;
                int i4 = 2;
                if (mediaRecorder10 == null) {
                } else {
                }
                mediaRecorder10.setVideoSource(i4);
                mediaRecorder = this.A;
                if (mediaRecorder == null) {
                } else {
                }
                mediaRecorder.setOutputFormat(i4);
                if (z) {
                }
                MediaRecorder mediaRecorder7 = this.A;
                if (mediaRecorder7 == null) {
                } else {
                }
                mediaRecorder7.setAudioEncoder(3);
                z = this.A;
                if (z == null) {
                } else {
                }
                z.setAudioEncodingBitRate(128000);
                MediaRecorder mediaRecorder4 = this.A;
                if (mediaRecorder4 == null) {
                } else {
                }
                mediaRecorder4.setVideoEncoder(i4);
                MediaRecorder mediaRecorder5 = this.A;
                if (mediaRecorder5 == null) {
                } else {
                }
                mediaRecorder5.setVideoFrameRate(30);
                MediaRecorder mediaRecorder6 = this.A;
                if (mediaRecorder6 == null) {
                } else {
                }
                mediaRecorder6.setVideoEncodingBitRate(1200000);
                height = u2(cameraManager);
                int i3 = 0;
                if (height == null) {
                }
                obj7 = new IllegalStateException("No Recording file found");
                x2(2131886123, obj7);
                R1();
                return i3;
                final MediaRecorder mediaRecorder11 = this.A;
                if (mediaRecorder11 == null) {
                } else {
                }
                mediaRecorder11.setVideoSize(height.getWidth(), height.getHeight());
                path = Y1().o();
                if (path == null) {
                }
                IllegalStateException illegalStateException = new IllegalStateException("No Recording file found");
                x2(2131886526, illegalStateException);
                R1();
                return i3;
                mediaRecorder3 = this.A;
                if (mediaRecorder3 == null) {
                } else {
                }
                mediaRecorder3.setOutputFile(path.getPath());
                mediaRecorder2 = this.A;
                if (mediaRecorder2 == null) {
                } else {
                }
                mediaRecorder2.setOrientationHint(W1(cameraManager));
                if (!d2()) {
                }
                obj7 = MediaCodec.createPersistentInputSurface();
                this.B = obj7;
                mediaRecorder2 = this.A;
                if (mediaRecorder2 == null) {
                } else {
                }
                n.d(obj7);
                mediaRecorder2.setInputSurface(obj7);
                obj7 = this.A;
                if (obj7 == null) {
                } else {
                }
                obj7.prepare();
                if (d2()) {
                }
                obj7 = this.A;
                if (obj7 == null) {
                } else {
                }
                obj7 = 0;
                obj7 = obj7.getSurface();
                this.B = obj7;
                Exception exception = new Exception("Couldn't prepare media recorder", cameraManager);
                x2(obj3, exception);
                R1();
                return i2;
                throw cameraManager;
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        }
    }

    private static final void a2(app.dogo.com.dogo_android.exam.k.i i, MediaRecorder mediaRecorder2, int i3, int i4) {
        n.f(i, "this$0");
        n.f(mediaRecorder2, "$noName_0");
        i.l2(i3, i4);
    }

    private static final void b2(app.dogo.com.dogo_android.exam.k.i i, MediaRecorder mediaRecorder2, int i3, int i4) {
        n.f(i, "this$0");
        n.f(mediaRecorder2, "$noName_0");
        i.l2(i3, i4);
    }

    private final boolean c2() {
        int i2;
        int recordingState;
        int i3;
        int i;
        int i4 = 0;
        AudioRecord.Builder builder = new AudioRecord.Builder();
        i3 = 1;
        AudioRecord build = builder.setAudioSource(i3).build();
        build.startRecording();
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.microphone") && build.getRecordingState() == 3) {
            i4 = 0;
            builder = new AudioRecord.Builder();
            i3 = 1;
            build = builder.setAudioSource(i3).build();
            build.startRecording();
            if (build.getRecordingState() == 3) {
                i2 = i3;
            }
            if (build == null) {
            } else {
                build.release();
            }
            return i2;
        }
        return 0;
    }

    private final boolean d2() {
        return i.C.contains(Build.MODEL);
    }

    public static void e2(app.dogo.com.dogo_android.exam.k.i i, MediaRecorder mediaRecorder2, int i3, int i4) {
        i.b2(i, mediaRecorder2, i3, i4);
    }

    public static int f2(double d, int i2, Size size3, Size size4) {
        return i.t2(d, i2, size3, size4);
    }

    public static void g2(app.dogo.com.dogo_android.exam.k.i i, MediaRecorder mediaRecorder2, int i3, int i4) {
        i.a2(i, mediaRecorder2, i3, i4);
    }

    public static int h2(int i, Size size2, Size size3) {
        return i.v2(i, size2, size3);
    }

    public static void i2(app.dogo.com.dogo_android.exam.k.i i, y y2) {
        i.p2(i, y2);
    }

    public static void j2(app.dogo.com.dogo_android.exam.k.i i, View view2) {
        i.n2(i, view2);
    }

    public static void k2(app.dogo.com.dogo_android.exam.k.i i, View view2) {
        i.o2(i, view2);
    }

    private final void l2(int i, int i2) {
        Object[] arr = new Object[2];
        a.f("Media recorder event: what = %d, extra = %d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    private final void m2(Uri uri) {
        h hVar;
        app.dogo.com.dogo_android.exam.g gVar;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            hVar = new h(uri, (j)C1().a());
            g1.n(activity, hVar);
        }
    }

    private static final void n2(app.dogo.com.dogo_android.exam.k.i i, View view2) {
        n.f(i, "this$0");
        i.B2();
    }

    private static final void o2(app.dogo.com.dogo_android.exam.k.i i, View view2) {
        n.f(i, "this$0");
        i.R1();
    }

    private static final void p2(app.dogo.com.dogo_android.exam.k.i i, y y2) {
        Object obj2;
        n.f(i, "this$0");
        if (y2 instanceof y.c) {
            i.m2((Uri)(y.c)y2.a());
        }
    }

    private final void q2() {
        A2();
        Q1();
    }

    private final String r2(int i, CameraManager cameraManager2) {
        String[] cameraIdList;
        int i2;
        Object obj;
        Throwable intValue;
        Object lENS_FACING;
        String str;
        int obj8;
        Exception obj9;
        try {
            cameraIdList = cameraManager2.getCameraIdList();
            n.e(cameraIdList, "cameraManager.cameraIdList");
            i2 = 0;
            while (i2 < cameraIdList.length) {
                obj = cameraIdList[i2];
                i2++;
                CameraCharacteristics cameraCharacteristics = cameraManager2.getCameraCharacteristics(obj);
                n.e(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraId)");
                intValue = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            }
            obj = cameraIdList[i2];
            i2++;
            cameraCharacteristics = cameraManager2.getCameraCharacteristics(obj);
            n.e(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraId)");
            intValue = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if ((Integer)intValue == null) {
            } else {
            }
            if ((Integer)intValue.intValue() == i) {
            } else {
            }
            return obj;
            obj = n.o("Camera disconnected, ID = ", obj);
            lENS_FACING = new Exception(obj, intValue);
            a.d(lENS_FACING);
            cameraManager2 = new Exception("Couldn't query the list of cameras", i);
            a.d(cameraManager2);
            return null;
        } catch (Exception e) {
        }
    }

    private final Size s2(CameraManager cameraManager) {
        int i;
        int height;
        int obj9;
        final Size[] objArr = U1(cameraManager);
        if (objArr == null) {
            return null;
        }
        obj9 = W1(cameraManager);
        final int i2 = 0;
        if (obj9 != 90) {
            if (obj9 == 270) {
                obj9 = 1;
            } else {
                obj9 = i2;
            }
        } else {
        }
        TextureView view2 = view.O;
        n.e(view2, "binding.cameraPreviewTextureView");
        if (obj9 != null) {
            height = view2.getHeight();
        } else {
            height = view2.getWidth();
        }
        if (obj9 != null) {
            obj9 = view2.getWidth();
        } else {
            obj9 = view2.getHeight();
        }
        obj9 = new b(d /= d2, obj5, height *= obj9);
        Arrays.sort(objArr, obj9);
        return objArr[i2];
    }

    private static final int t2(double d, int i2, Size size3, Size size4) {
        n.f(size4, "size1");
        n.f(obj10, "size2");
        double d3 = Math.abs(d - i);
        double obj6 = Math.abs(d -= i4);
        if (Double.compare(d6, l) < 0) {
            return n.h(Math.abs(size3 - obj6), Math.abs(size3 -= obj7));
        }
        return Double.compare(d3, obj1);
    }

    private final Size u2(CameraManager cameraManager) {
        Size[] obj3 = U1(cameraManager);
        if (obj3 == null) {
            return null;
        }
        d dVar = new d(921600);
        Arrays.sort(obj3, dVar);
        return obj3[0];
    }

    private static final int v2(int i, Size size2, Size size3) {
        n.f(size2, "size1");
        n.f(size3, "size2");
        return n.h(Math.abs(i - i2), Math.abs(i -= i3));
    }

    private final void w2(boolean z) {
        view.R.setEnabled(z);
    }

    private final void x2(int i, Exception exception2) {
        a.d(exception2);
        final androidx.fragment.app.e obj2 = getActivity();
        if (obj2 == null) {
        } else {
            g1.g0(obj2, i);
        }
    }

    private final void y2(CameraCaptureSession cameraCaptureSession, Surface... surface2Arr2) {
        app.dogo.com.dogo_android.exam.k.i.h hVar;
        int i2;
        int i;
        Object obj;
        Throwable obj5;
        CaptureRequest obj6;
        CaptureRequest.Builder captureRequest = cameraCaptureSession.getDevice().createCaptureRequest(3);
        n.e(captureRequest, "session.device.createCaptureRequest(CameraDevice.TEMPLATE_RECORD)");
        i2 = 0;
        synchronized (this) {
            try {
                while (i2 < surface2Arr2.length) {
                    i2++;
                    captureRequest.addTarget(surface2Arr2[i2]);
                }
                i2++;
                captureRequest.addTarget(surface2Arr2[i2]);
                hVar = new i.h();
                cameraCaptureSession.setRepeatingRequest(captureRequest.build(), hVar, 0);
                surface2Arr2 = 2131886123;
                Exception exception = new Exception("Couldn't start camera capture", cameraCaptureSession);
                x2(surface2Arr2, exception);
                R1();
                throw cameraCaptureSession;
            } catch (Throwable th) {
            }
        }
    }

    private final void z2(List<? extends Surface> list, CameraCaptureSession.StateCallback cameraCaptureSession$StateCallback2) {
        CameraDevice cameraDevice;
        int i;
        ArrayList arrayList;
        SessionConfiguration sessionConfiguration;
        int next;
        OutputConfiguration outputConfiguration;
        Object obj6;
        if (Build.VERSION.SDK_INT >= 28) {
            cameraDevice = this.x;
            if (cameraDevice == null) {
            } else {
                obj6 = p.U(list);
                arrayList = new ArrayList(p.r(obj6, 10));
                obj6 = obj6.iterator();
                for (Surface next : obj6) {
                    outputConfiguration = new OutputConfiguration(next);
                    arrayList.add(outputConfiguration);
                }
                sessionConfiguration = new SessionConfiguration(0, arrayList, a.i(requireActivity()), stateCallback2);
                cameraDevice.createCaptureSession(sessionConfiguration);
            }
        } else {
            cameraDevice = this.x;
            if (cameraDevice == null) {
            } else {
                cameraDevice.createCaptureSession(list, stateCallback2, 0);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s D1() {
        return X1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s E1() {
        return Y1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public f X1() {
        return (f)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.exam.k.k Y1() {
        return (k)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void e0() {
        String str;
        Object[] arr;
        Surface[] arr2;
        Y1().n().postValue(Boolean.TRUE);
        MediaRecorder mediaRecorder = this.A;
        synchronized (this) {
            try {
                mediaRecorder.start();
                Surface surface = this.y;
                arr = this.B;
                final CameraCaptureSession cameraCaptureSession = this.z;
                final int i = 0;
                if (surface != null && arr != null && cameraCaptureSession != null) {
                } else {
                }
                if (arr != null) {
                } else {
                }
                if (cameraCaptureSession != null) {
                } else {
                }
                arr2 = new Surface[2];
                arr2[i] = surface;
                arr2[1] = arr;
                y2(cameraCaptureSession, arr2);
                a.c("Recording could not be started", new Object[i]);
                throw th;
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onPause() {
        A2();
        super.onPause();
        return;
        synchronized (this) {
            A2();
            super.onPause();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onResume() {
        super.onResume();
        Q1();
        return;
        synchronized (this) {
            super.onResume();
            Q1();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        n.f(surfaceTexture, "surfaceTexture");
        Q1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return h.a.a(this, surfaceTexture);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        h.a.b(this, surfaceTexture, i2, i3);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        h.a.c(this, surfaceTexture);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle2) {
        boolean obj2;
        String obj3;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        obj3 = new f(this);
        obj2.U.setOnClickListener(obj3);
        if (!requireContext().getPackageManager().hasSystemFeature("android.hardware.camera.front")) {
            obj2.U.setVisibility(8);
        }
        obj3 = new g(this);
        obj2.P.setOnClickListener(obj3);
        obj3 = getViewLifecycleOwner();
        n.e(obj3, "viewLifecycleOwner");
        e eVar = new e(this);
        Y1().l().observe(obj3, eVar);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void r() {
        Y1().i();
        A2();
        return;
        synchronized (this) {
            Y1().i();
            A2();
        }
    }
}
