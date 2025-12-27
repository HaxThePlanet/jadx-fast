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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.r;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.VideoRecordingButton;
import app.dogo.com.dogo_android.h.ad;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;

/* compiled from: ExamRecordFragment.kt */
@Metadata(d1 = "\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 X2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001XB\u0005¢\u0006\u0002\u0010\u0005J\u0008\u0010\u001e\u001a\u00020\u001fH\u0002J\u0008\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0002J\u0008\u0010$\u001a\u00020\u001fH\u0002J\u001d\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010(J\u0008\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u000202H\u0002J\u0008\u00103\u001a\u00020\u001fH\u0016J\u0008\u00104\u001a\u00020\u001fH\u0016J \u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020+H\u0016J\u001a\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020<2\u0008\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0008\u0010?\u001a\u00020\u001fH\u0016J\u0008\u0010@\u001a\u00020\u001fH\u0016J\u0008\u0010A\u001a\u00020\u001fH\u0002J\u001a\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020+2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010F\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u000bH\u0002J\u001c\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020+2\n\u0010K\u001a\u00060Lj\u0002`MH\u0002J)\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00072\u0012\u0010P\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00110&\"\u00020\u0011H\u0002¢\u0006\u0002\u0010QJ \u0010R\u001a\u00020\u001f2\u000e\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110S2\u0006\u0010T\u001a\u00020UH\u0002J\u0008\u0010V\u001a\u00020\u001fH\u0002J\u0008\u0010W\u001a\u00020\u001fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u0018\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006Y", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentExamVideoRecordingBinding;", "Lapp/dogo/com/dogo_android/exam/record/ExamRecordScreen;", "Lapp/dogo/com/dogo_android/exam/record/ExamRecordCallbacks;", "()V", "cameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "isAudioAvailable", "", "()Z", "isCompatAdjustmentsNeeded", "mediaRecorder", "Landroid/media/MediaRecorder;", "previewSurface", "Landroid/view/Surface;", "recordingSurface", "sharedViewModel", "Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/exam/record/ExamRecordViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/exam/record/ExamRecordViewModel;", "viewModel$delegate", "attemptPreview", "", "cancelFlow", "createCameraCaptureSession", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "disableSwitchButtonForFewSecs", "getCameraSupportedSurfaceTextureSizes", "", "Landroid/util/Size;", "(Landroid/hardware/camera2/CameraManager;)[Landroid/util/Size;", "getMediaRecorder", "getSensorOrientation", "", "initializeMediaRecorder", "logMediaRecorderEvent", "what", "extra", "nextScreen", "data", "Landroid/net/Uri;", "onPause", "onResume", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "recordingStarted", "recordingStopped", "refreshCamera", "selectCamera", "", "cameraCharacteristic", "selectPreviewSize", "selectRecordingSize", "setRecordingButtonEnabled", "enabled", "showError", "res", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "startCameraCapture", "session", "surfaces", "(Landroid/hardware/camera2/CameraCaptureSession;[Landroid/view/Surface;)V", "startCaptureSession", "", "stateCallback", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "stop", "switchCamera", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class ExamRecordFragment extends app.dogo.com.dogo_android.util.m0.b<ad, j> implements h {

    private static final List<String> C;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final i.b INSTANCE = new i$b(0);
    /* renamed from: A, reason: from kotlin metadata */
    private MediaRecorder cameraCaptureSession;
    /* renamed from: B, reason: from kotlin metadata */
    private Surface cameraDevice;
    private final kotlin.h v;
    private final kotlin.h w;
    /* renamed from: x, reason: from kotlin metadata */
    private CameraDevice mediaRecorder;
    /* renamed from: y, reason: from kotlin metadata */
    private Surface previewSurface;
    /* renamed from: z, reason: from kotlin metadata */
    private CameraCaptureSession recordingSurface;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordFragment$Companion;", "", "()V", "DEBOUNCE_TIMEOUT_MS", "", "compatibilityDeviceModels", "", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        private b() {
            super();
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n", d2 = {"app/dogo/com/dogo_android/exam/record/ExamRecordFragment$attemptPreview$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends CameraDevice.StateCallback {

        final /* synthetic */ i a;
        final /* synthetic */ CameraManager b;
        c(CameraManager cameraManager) {
            this.a = iVar;
            this.b = cameraManager;
            super();
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            n.f(cameraDevice, "cameraDevice");
            this.a.x2(R.string.alert.something.failed, new IllegalStateException("Camera disconnected"));
            this.a.R1();
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onError(CameraDevice cameraDevice, int error) {
            n.f(cameraDevice, "cameraDevice");
            this.a.x2(R.string.alert.something.failed, new Exception(n.o("Camera error ", Integer.valueOf(error))));
            this.a.R1();
        }

        @Override // android.hardware.camera2.CameraDevice$StateCallback
        public void onOpened(CameraDevice cameraDevice) throws android.content.res.Resources.NotFoundException {
            n.f(cameraDevice, "cameraDevice");
            this.a.mediaRecorder = cameraDevice;
            Size onViewCreated = this.a.setRecordingButtonEnabled(this.b);
            if (onViewCreated == null) {
                int i = 2131886123;
                int i2 = 1;
                Toast.makeText(this.a.getContext(), i, i2).show();
                this.a.R1();
            } else {
                SurfaceTexture surfaceTexture = (ad)this.a.B1().O.getSurfaceTexture();
                if (surfaceTexture != null) {
                    surfaceTexture.setDefaultBufferSize(onViewCreated.getWidth(), onViewCreated.getHeight());
                }
                this.a.previewSurface = new Surface(surfaceTexture);
                this.a.getSensorOrientation(this.b);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007", d2 = {"app/dogo/com/dogo_android/exam/record/ExamRecordFragment$createCameraCaptureSession$stateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onConfigureFailed", "", "cameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigured", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends CameraCaptureSession.StateCallback {

        final /* synthetic */ i a;
        d() {
            this.a = iVar;
            super();
        }

        @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            n.f(cameraCaptureSession, "cameraCaptureSession");
            this.a.x2(R.string.alert.something.failed, new Exception("Couldn't configure camera capture session"));
            this.a.R1();
        }

        @Override // android.hardware.camera2.CameraCaptureSession$StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            n.f(cameraCaptureSession, "cameraCaptureSession");
            Surface cameraSupportedSurfaceTextureSizes = this.a.previewSurface;
            if (cameraSupportedSurfaceTextureSizes != null) {
                this.a.recordingSurface = cameraCaptureSession;
                int i = 1;
                Surface[] arr = new Surface[i];
                int i2 = 0;
                arr[i2] = cameraSupportedSurfaceTextureSizes;
                this.a.y2(cameraCaptureSession, arr);
                this.a.w2(i);
            }
        }
    }

    @Metadata(d1 = "\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\n", d2 = {"app/dogo/com/dogo_android/exam/record/ExamRecordFragment$startCameraCapture$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureFailed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "failure", "Landroid/hardware/camera2/CaptureFailure;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class h extends CameraCaptureSession.CaptureCallback {
        h() {
            super();
        }

        @Override // android.hardware.camera2.CameraCaptureSession$CaptureCallback
        public void onCaptureFailed(CameraCaptureSession session, CaptureRequest request, CaptureFailure failure) {
            n.f(session, "session");
            n.f(request, "request");
            n.f(failure, "failure");
            a.d(new Exception(n.o("Camera capture failure ", Integer.valueOf(failure.getReason()))));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class f extends kotlin.d0.d.p implements kotlin.d0.c.a<app.dogo.com.dogo_android.exam.f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.exam.f invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(ExamFlowViewModel.class), this.$parameters);
        }

        public f(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends kotlin.d0.d.p implements kotlin.d0.c.a<k> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final k invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ExamRecordViewModel.class), this.$parameters);
        }

        public g(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { (ExamRecordScreen)i.this.C1().component1() });
        }

        i() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.exam.record.ExamRecordFragment$disableSwitchButtonForFewSecs$1", f = "ExamRecordFragment.kt", l = 114, m = "invokeSuspend")
    static final class e extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super w>, Object> {

        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) throws android.content.res.Resources.NotFoundException {
            Object obj;
            Object obj2 = b.d();
            final android.content.res.Resources.Theme theme = null;
            final int i4 = 1;
            if (this.label != 0 && this.label == i4) {
                q.b(object);
                obj.setImageTintList(ColorStateList.valueOf(i.this.getResources().getColor(2131100379, theme)));
                obj.setClickable(true);
                return w.a;
            }
            q.b(object);
            n.e(object2, "binding.switchCameraButton");
            object2.setImageTintList(ColorStateList.valueOf(i.this.getResources().getColor(2131099767, theme)));
            object2.setClickable(false);
            int i = 1000;
            this.L$0 = object2;
            this.label = i4;
            if (kotlinx.coroutines.internal.x0.a(i, this) == obj2) {
                return obj2;
            }
        }

        e(kotlin.b0.d<? super i.e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.exam.record.i.e)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.exam.record.i.e(i.this, dVar);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends kotlin.d0.d.k implements kotlin.d0.c.q<LayoutInflater, ViewGroup, Boolean, ad> {

        public static final i.a a = new i$a();
        @Override // kotlin.d0.d.k
        public final ad l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return ad.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, ad.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentExamVideoRecordingBinding;", 0);
        }
    }
    static {
        ExamRecordFragment.C = p.j(new String[] { "SM-G975F", "LM-X210", "Aristo2", "Moto C" });
    }

    public i() {
        super(app.dogo.com.dogo_android.exam.record.i.a.a);
        final m.a.c.j.a aVar2 = null;
        this.v = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.exam.record.i.g(this, aVar2, new app.dogo.com.dogo_android.exam.record.i.i(this)));
        this.w = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.exam.record.i.f(this, aVar2, aVar2));
    }

    /* renamed from: A2, reason: from kotlin metadata */
    private final synchronized void attemptPreview() {
        Exception obj2;
        String obj4;
        try {
            (ad)B1().R.b();
            if (this.recordingSurface != null) {
                this.recordingSurface.close();
            }
            CameraCaptureSession cameraCaptureSession = null;
            this.recordingSurface = cameraCaptureSession;
            if (this.mediaRecorder != null) {
                this.mediaRecorder.close();
            }
            this.mediaRecorder = cameraCaptureSession;
            if (this.previewSurface != null) {
                this.previewSurface.release();
            }
            this.previewSurface = cameraCaptureSession;
        } catch (Exception e) {
        }
        if (n.b(Y1().n().getValue(), Boolean.TRUE)) {
            try {
                this.cameraCaptureSession.stop();
            } catch (Exception e) {
            }
            Y1().n().postValue(Boolean.FALSE);
        }
        if (this.cameraCaptureSession != null) {
            this.cameraCaptureSession.release();
        }
        this.cameraCaptureSession = cameraCaptureSession;
        if (this.cameraDevice != null) {
            this.cameraDevice.release();
        }
        boolean z2 = false;
        Y1().r(z2);
        w2(z2);
    }

    private final void B2() {
        Y1().s();
        q2();
        T1();
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static final /* synthetic */ void createCameraCaptureSession(i cameraManager) {
        cameraManager.R1();
    }

    /* renamed from: H1, reason: from kotlin metadata */
    public static final /* synthetic */ void logMediaRecorderEvent(i what, CameraManager extra) {
        what.getSensorOrientation(extra);
    }

    /* renamed from: I1, reason: from kotlin metadata */
    public static final /* synthetic */ Surface getCameraSupportedSurfaceTextureSizes(i cameraManager) {
        return cameraManager.previewSurface;
    }

    /* renamed from: J1, reason: from kotlin metadata */
    public static final /* synthetic */ Size onViewCreated(i view, CameraManager savedInstanceState) {
        return view.setRecordingButtonEnabled(savedInstanceState);
    }

    /* renamed from: K1, reason: from kotlin metadata */
    public static final /* synthetic */ void selectCamera(i cameraCharacteristic, CameraCaptureSession cameraManager) {
        cameraCharacteristic.recordingSurface = cameraManager;
    }

    /* renamed from: L1, reason: from kotlin metadata */
    public static final /* synthetic */ void showError(i res, CameraDevice exception) {
        res.mediaRecorder = exception;
    }

    /* renamed from: M1, reason: from kotlin metadata */
    public static final /* synthetic */ void startCameraCapture(i session, Surface surfaces) {
        session.previewSurface = surfaces;
    }

    /* renamed from: N1, reason: from kotlin metadata */
    public static final /* synthetic */ void startCaptureSession(i surfaces, boolean stateCallback) {
        surfaces.w2(stateCallback);
    }

    /* renamed from: O1, reason: from kotlin metadata */
    public static final /* synthetic */ void onSurfaceTextureAvailable(i surfaceTexture, int width, Exception height) {
        surfaceTexture.x2(width, height);
    }

    public static final /* synthetic */ void P1(i iVar, CameraCaptureSession cameraCaptureSession, Surface... surfaceArr) {
        iVar.y2(cameraCaptureSession, surfaceArr);
    }

    private final synchronized void Q1() {
        String str2;
        try {
            Y1().r(true);
            Object obj = a.k(requireContext(), CameraManager.class);
            android.os.Handler handler = null;
            str2 = r2(Y1().j(), obj);
        } catch (Exception e) {
        }
    }

    private final void R1() {
        androidx.fragment.app.e activity = null;
        ExamFlowCallback r0 = getActivity() instanceof ExamFlowCallback ? (ExamFlowCallback)this.getActivity() : 0;
        if (activity != null) {
            activity.d();
        }
    }

    /* renamed from: S1, reason: from kotlin metadata */
    private final synchronized void getSensorOrientation(CameraManager cameraManager) {
        try {
        } catch (Exception e) {
        }
        if (!selectPreviewSize(cameraManager)) {
            return;
        }
        try {
            Surface[] arr = new Surface[2];
            z2(p.j(new Surface[] { this.previewSurface, this.cameraDevice }), new ExamRecordFragment_createCameraCaptureSession_stateCallback_1(this));
        } catch (Exception e) {
        }
    }

    private final void T1() {
        final kotlin.b0.d dVar = null;
        kotlinx.coroutines.internal.k.d(r.a(this), dVar, null, new app.dogo.com.dogo_android.exam.record.i.e(this, dVar), 3, null);
    }

    /* renamed from: U1, reason: from kotlin metadata */
    private final Size[] initializeMediaRecorder(CameraManager cameraManager) throws android.hardware.camera2.CameraAccessException {
        android.hardware.camera2.CameraCharacteristics.Key sCALER_STREAM_CONFIGURATION_MAP2;
        int i = 1;
        int cameraManager2 = 0;
        cameraManager2 = 0;
        if (!StreamConfigurationMap.isOutputSupportedFor(SurfaceTexture.class)) {
            str = "SurfaceTexture not supported for output";
            a.d(new Exception(str));
        } else {
            try {
                n.d(this.mediaRecorder);
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(this.mediaRecorder.getId());
                n.e(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraDevice!!.id)");
                Object obj4 = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (obj4 == null) {
                } else {
                    sCALER_STREAM_CONFIGURATION_MAP2 = SurfaceTexture.class;
                    Size[] outputSizes = obj4.getOutputSizes(sCALER_STREAM_CONFIGURATION_MAP2);
                }
                Exception exception2 = cameraManager2.length == 0 ? 1 : 0;
                str = "No supported output sizes";
                a.d(new Exception(str));
            } catch (Exception e) {
                n.d(this.mediaRecorder);
                CameraDevice cameraDevice = this.mediaRecorder.getId();
                cameraDevice = n.o("Camera disconnected, ID = ", this.mediaRecorder);
                a.d((cameraManager2.length == 0 ? 1 : 0));
            }
        }
        return cameraManager2;
    }

    private final MediaRecorder V1() {
        MediaRecorder mediaRecorder;
        if (Build.VERSION.SDK_INT >= 31) {
            mediaRecorder = new MediaRecorder(requireContext());
        } else {
            mediaRecorder = new MediaRecorder();
        }
        return mediaRecorder;
    }

    /* renamed from: W1, reason: from kotlin metadata */
    private final int nextScreen(CameraManager data) throws android.hardware.camera2.CameraAccessException {
        int intValue;
        try {
            n.d(this.mediaRecorder);
            CameraCharacteristics cameraCharacteristics = data.getCameraCharacteristics(this.mediaRecorder.getId());
            n.e(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraDevice!!.id)");
            Object obj4 = cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
            n.d(obj4);
            str = "{\n            val cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraDevice!!.id)\n            cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)!!\n        }";
            n.e(obj4, str);
            intValue = obj4.intValue();
        } catch (Exception e) {
            n.d(this.mediaRecorder);
            CameraDevice cameraDevice = this.mediaRecorder.getId();
            cameraDevice = n.o("Camera disconnected, ID = ", this.mediaRecorder);
            x2(2131886123, new Exception(cameraDevice, e));
            R1();
            e = null;
        }
        return intValue;
    }

    /* renamed from: Z1, reason: from kotlin metadata */
    private final synchronized boolean selectPreviewSize(CameraManager cameraManager) {
        MediaRecorder cameraCaptureSession2;
        Exception exception;
        app.dogo.com.dogo_android.exam.k.c cVar;
        app.dogo.com.dogo_android.exam.k.a aVar;
        int i2 = 3;
        MediaRecorder cameraCaptureSession22;
        int i3 = 30;
        Surface surface = null;
        try {
            boolean z = c2();
            if (!z) {
                int i = 2131886516;
                str = "Audio unavailable";
                x2(i, new Exception(str));
            }
            Y1().p();
            MediaRecorder mediaRecorder = V1();
            this.cameraCaptureSession = mediaRecorder;
            if (mediaRecorder != null) {
                mediaRecorder.setOnErrorListener(new app.dogo.com.dogo_android.exam.record.c(this));
            }
            if (this.cameraCaptureSession != null) {
                this.cameraCaptureSession.setOnInfoListener(new app.dogo.com.dogo_android.exam.record.a(this));
            }
            int i4 = 1;
            cameraCaptureSession211.setVideoSource(i7);
            if (this.cameraCaptureSession != null) {
                this.cameraCaptureSession.setOutputFormat(i7);
            }
            if (z) {
                if (this.cameraCaptureSession != null) {
                    i2 = 3;
                    this.cameraCaptureSession.setAudioEncoder(i2);
                }
                if (this.cameraCaptureSession != null) {
                    this.cameraCaptureSession.setAudioEncodingBitRate(128000);
                }
            }
            if (this.cameraCaptureSession != null) {
                this.cameraCaptureSession.setVideoEncoder(i7);
            }
            if (this.cameraCaptureSession != null) {
                i3 = 30;
                this.cameraCaptureSession.setVideoFrameRate(i3);
            }
            if (this.cameraCaptureSession != null) {
                i3 = 1200000;
                this.cameraCaptureSession.setVideoEncodingBitRate(i3);
            }
            Size size = u2(cameraManager);
            boolean z4 = false;
            x2(2131886123, new IllegalStateException("No Recording file found"));
            R1();
        } catch (java.io.IOException ioException) {
        }
        try {
            if (this.cameraCaptureSession != null) {
                this.cameraCaptureSession.setVideoSize(size.getWidth(), size.getHeight());
            }
            File file = Y1().o();
            x2(2131886526, new IllegalStateException("No Recording file found"));
            R1();
        } catch (java.io.IOException ioException) {
        }
        try {
            if (this.cameraCaptureSession != null) {
                this.cameraCaptureSession.setOutputFile(file.getPath());
            }
            if (this.cameraCaptureSession != null) {
                this.cameraCaptureSession.setOrientationHint(nextScreen(ioException));
            }
            if (!d2()) {
                Surface persistentInputSurface = MediaCodec.createPersistentInputSurface();
                this.cameraDevice = persistentInputSurface;
                if (this.cameraCaptureSession != null) {
                    n.d(persistentInputSurface);
                    this.cameraCaptureSession.setInputSurface(persistentInputSurface);
                }
            }
        } catch (java.io.IOException ioException) {
        }
        try {
            if (this.cameraCaptureSession != null) {
                this.cameraCaptureSession.prepare();
            }
            if (this.cameraCaptureSession == null) {
                int i9 = 0;
            } else {
                surface = this.cameraCaptureSession.getSurface();
            }
            this.cameraDevice = surface;
        } catch (java.io.IOException ioException) {
        }
        return true;
    }

    private static final void a2(i iVar, MediaRecorder mediaRecorder, int i, int i2) {
        n.f(iVar, "this$0");
        n.f(mediaRecorder, "$noName_0");
        iVar.l2(i, i2);
    }

    private static final void b2(i iVar, MediaRecorder mediaRecorder, int i, int i2) {
        n.f(iVar, "this$0");
        n.f(mediaRecorder, "$noName_0");
        iVar.l2(i, i2);
    }

    private final boolean c2() {
        boolean z = false;
        z = false;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.microphone")) {
            try {
                final int i = 1;
                AudioRecord builder = new AudioRecord.Builder().setAudioSource(i).build();
                builder.startRecording();
            } catch (Throwable th) {
            }
            if (builder.getRecordingState() == 3) {
            }
            if (builder != null) {
                builder.release();
            }
            return z;
        }
        return false;
    }

    private final boolean d2() {
        return ExamRecordFragment.C.contains(Build.MODEL);
    }

    private final void l2(int i, int i2) {
        Object[] arr = new Object[2];
        a.f("Media recorder event: what = %d, extra = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i2) });
    }

    /* renamed from: m2, reason: from kotlin metadata */
    private final void selectRecordingSize(Uri cameraManager) {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new ExamPlaybackScreen(cameraManager, (ExamRecordScreen)C1().component1()));
        }
    }

    private static final void n2(i iVar, View view) {
        n.f(iVar, "this$0");
        iVar.B2();
    }

    private static final void o2(i iVar, View view) {
        n.f(iVar, "this$0");
        iVar.R1();
    }

    private static final void p2(i iVar, y yVar) {
        n.f(iVar, "this$0");
        if (yVar instanceof LoadResult_Success) {
            iVar.selectRecordingSize((Uri)yVar.component1());
        }
    }

    private final void q2() {
        attemptPreview();
        Q1();
    }

    private final String r2(int i, CameraManager cameraManager) throws android.hardware.camera2.CameraAccessException {
        int i2 = 0;
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            n.e(cameraIdList, "cameraManager.cameraIdList");
            i2 = 0;
            String str = cameraIdList[i2];
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: s2, reason: from kotlin metadata */
    private final Size setRecordingButtonEnabled(CameraManager enabled) {
        int i = 90;
        int height;
        int i2 = 1;
        int height2;
        final Size[] initializeMediaRecorder = initializeMediaRecorder(enabled);
        if (initializeMediaRecorder == null) {
            return null;
        }
        int nextScreen = nextScreen(enabled);
        i = 90;
        i2 = 0;
        if (nextScreen == 90 || nextScreen == 270) {
            i2 = 1;
        }
        n.e(textureView, "binding.cameraPreviewTextureView");
        if (i2 != 0) {
            height = textureView.getHeight();
        } else {
            height = textureView.getWidth();
        }
        if (i2 != 0) {
            height2 = textureView.getWidth();
        } else {
            height2 = textureView.getHeight();
        }
        Arrays.sort(initializeMediaRecorder, new app.dogo.com.dogo_android.exam.record.b((double)height / (double)height2, r5, height * height2));
        return initializeMediaRecorder[i2];
    }

    private static final int t2(double d, int i, Size size, Size size2) {
        n.f(size, "size1");
        n.f(size2, "size2");
        double abs = Math.abs(d - (double)size.getWidth() / (double)size.getHeight());
        double abs3 = Math.abs(d - (double)size2.getWidth() / (double)size2.getHeight());
        double abs2 = Math.abs(abs - abs3);
        if (abs2 < 4576918229304087675L) {
            return n.h(Math.abs(i - (size.getWidth() * size.getHeight())), Math.abs(i - (size2.getWidth() * size2.getHeight())));
        }
        return Double.compare(abs, abs3);
    }

    private final Size u2(CameraManager cameraManager) {
        Size[] initializeMediaRecorder = initializeMediaRecorder(cameraManager);
        if (initializeMediaRecorder == null) {
            return null;
        }
        Arrays.sort(initializeMediaRecorder, new app.dogo.com.dogo_android.exam.record.d(921600));
        return initializeMediaRecorder[0];
    }

    private static final int v2(int i, Size size, Size size2) {
        n.f(size, "size1");
        n.f(size2, "size2");
        return n.h(Math.abs(i - (size.getWidth() * size.getHeight())), Math.abs(i - (size2.getWidth() * size2.getHeight())));
    }

    private final void w2(boolean z) {
        (ad)B1().R.setEnabled(z);
    }

    private final void x2(int i, Exception exc) {
        a.d(exc);
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, i);
        }
    }

    private final synchronized void y2(CameraCaptureSession cameraCaptureSession, Surface... surfaceArr) {
        int i = 0;
        try {
            CaptureRequest.Builder captureRequest = cameraCaptureSession.getDevice().createCaptureRequest(3);
            n.e(captureRequest, "session.device.createCaptureRequest(CameraDevice.TEMPLATE_RECORD)");
            i = 0;
            for (Object obj : surfaceArr) {
                captureRequest.addTarget(obj);
            }
            android.os.Handler handler = null;
            cameraCaptureSession.setRepeatingRequest(captureRequest.build(), new ExamRecordFragment_startCameraCapture_1(), handler);
        } catch (Throwable th) {
        }
    }

    private final void z2(List<? extends Surface> list, CameraCaptureSession.StateCallback stateCallback) throws android.hardware.camera2.CameraAccessException {
        OutputConfiguration outputConfiguration;
        if (Build.VERSION.SDK_INT >= 28) {
            if (this.mediaRecorder != null) {
                List list2 = p.U(list);
                ArrayList arrayList = new ArrayList(p.r(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new OutputConfiguration((Surface)it.next()));
                }
                this.mediaRecorder.createCaptureSession(new SessionConfiguration(0, arrayList, a.i(requireActivity()), stateCallback));
            }
        } else {
            if (this.mediaRecorder != null) {
                android.os.Handler handler = null;
                this.mediaRecorder.createCaptureSession(list, stateCallback, handler);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.exam.f X1() {
        return (ExamFlowViewModel)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public k Y1() {
        return (ExamRecordViewModel)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public synchronized void e0() {
        Y1().n().postValue(Boolean.TRUE);
        if (this.cameraCaptureSession != null) {
            this.cameraCaptureSession.start();
        }
        final int i2 = 0;
        if (this.previewSurface == null || this.cameraDevice == null || this.recordingSurface == null) {
            a.c("Recording could not be started", new Object[i2]);
        } else {
            Surface[] arr = new Surface[2];
            int i = 1;
            arr[i] = this.cameraDevice;
            y2(this.recordingSurface, arr);
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public synchronized void onPause() {
        attemptPreview();
        super.onPause();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public synchronized void onResume() {
        super.onResume();
        Q1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        n.f(surfaceTexture, "surfaceTexture");
        Q1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return app.dogo.com.dogo_android.exam.record.h.a.a(this, surfaceTexture);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        app.dogo.com.dogo_android.exam.record.h.a.b(this, surfaceTexture, i, i2);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        app.dogo.com.dogo_android.exam.record.h.a.c(this, surfaceTexture);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        (ad)B1().U.setOnClickListener(new app.dogo.com.dogo_android.exam.record.f(this));
        str = "android.hardware.camera.front";
        if (!requireContext().getPackageManager().hasSystemFeature(str)) {
            (ad)B1().U.setVisibility(8);
        }
        (ad)B1().P.setOnClickListener(new app.dogo.com.dogo_android.exam.record.g(this));
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        n.e(viewLifecycleOwner, "viewLifecycleOwner");
        Y1().l().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.exam.record.e(this));
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public synchronized void r() {
        Y1().finaliseRecording();
        attemptPreview();
    }

    public static /* synthetic */ void e2(i iVar, MediaRecorder mediaRecorder, int i, int i2) {
        ExamRecordFragment.b2(iVar, mediaRecorder, i, i2);
    }

    public static /* synthetic */ int f2(double d, int i, Size size, Size size2) {
        return ExamRecordFragment.t2(d, i, size, size2);
    }

    public static /* synthetic */ void g2(i iVar, MediaRecorder mediaRecorder, int i, int i2) {
        ExamRecordFragment.a2(iVar, mediaRecorder, i, i2);
    }

    public static /* synthetic */ int h2(int i, Size size, Size size2) {
        return ExamRecordFragment.v2(i, size, size2);
    }

    public static /* synthetic */ void i2(i iVar, y yVar) {
        ExamRecordFragment.p2(iVar, yVar);
    }

    public static /* synthetic */ void j2(i iVar, View view) {
        ExamRecordFragment.n2(iVar, view);
    }

    public static /* synthetic */ void k2(i iVar, View view) {
        ExamRecordFragment.o2(iVar, view);
    }
}
