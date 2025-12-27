package app.dogo.com.dogo_android.exam.k;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.FileObserver;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.h;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import f.d.a.a;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ExamRecordViewModel.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 52\u00020\u0001:\u00015B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010/\u001a\u000200J\u0008\u00101\u001a\u0004\u0018\u000102J\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u000200R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001fR\u001a\u0010 \u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u001f\"\u0004\u0008\"\u0010#R\u001f\u0010$\u001a\u0010\u0012\u000c\u0012\n &*\u0004\u0018\u00010\u001e0\u001e0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "examUploadData", "Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "packageManager", "Landroid/content/pm/PackageManager;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "frozenFrameFix", "Lapp/dogo/com/dogo_android/exam/FrozenFrameFix;", "(Lapp/dogo/com/dogo_android/exam/ExamUploadData;Landroid/content/pm/PackageManager;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/exam/FrozenFrameFix;)V", "cameraId", "", "getCameraId", "()I", "setCameraId", "(I)V", "getExamUploadData", "()Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "finaliseCompleted", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Landroid/net/Uri;", "getFinaliseCompleted", "()Lcom/hadilq/liveevent/LiveEvent;", "isSwitchCameraVisible", "", "()Z", "previewing", "getPreviewing", "setPreviewing", "(Z)V", "recording", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getRecording", "()Landroidx/lifecycle/MutableLiveData;", "sessionStartTimeMs", "", "getSessionStartTimeMs", "()J", "setSessionStartTimeMs", "(J)V", "finaliseRecording", "", "getRecordingFile", "Ljava/io/File;", "initiateCaptureSession", "toggleCamera", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class ExamRecordViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final k.a INSTANCE = new k$a(0);
    private final app.dogo.com.dogo_android.exam.g a;
    private final o3 b;
    private final v2 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.t2 frozenFrameFix;
    private final h e;
    private int f;
    private long g;
    private boolean h;
    /* renamed from: i, reason: from kotlin metadata */
    private final boolean storageService;
    /* renamed from: j, reason: from kotlin metadata */
    private final a<y<Uri>> timeUtils;
    /* renamed from: k, reason: from kotlin metadata */
    private final x<Boolean> tracker;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordViewModel$Companion;", "", "()V", "CAMERA_BACK", "", "CAMERA_FRONT", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/exam/record/ExamRecordViewModel$finaliseRecording$recordingFileObserver$1", "Landroid/os/FileObserver;", "onEvent", "", "event", "", "path", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends FileObserver {

        final /* synthetic */ k a;
        final /* synthetic */ File b;
        b(File file, String str) {
            this.a = kVar;
            this.b = file;
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public void onEvent(int event, String path) {
            if (event != 8) {
                return;
            }
            stopWatching();
            try {
                this.a.l().postValue(new LoadResult_Success(Uri.fromFile(this.a.e.b(this.b))));
            } catch (java.io.IOException unused) {
                event = this.a.l();
                path = new LoadResult_Error(new IllegalArgumentException("No Recording file found"));
                this.a.postValue(path);
            }
        }
    }
    public /* synthetic */ k(app.dogo.com.dogo_android.exam.g gVar, PackageManager packageManager, o3 o3Var, v2 v2Var, app.dogo.com.dogo_android.service.t2 t2Var, h hVar, int i, kotlin.d0.d.g gVar2) {
        h hVar62;
        if (i & 32 != 0) {
            hVar62 = new FrozenFrameFix();
        }
        this(gVar, packageManager, o3Var, v2Var, t2Var, hVar62);
    }

    public static final /* synthetic */ h h(k kVar) {
        return kVar.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final void finaliseRecording() {
        this.timeUtils.postValue(LoadResult_Loading.a);
        File file = o();
        if (file != null) {
            new ExamRecordViewModel_finaliseRecording_recordingFileObserver_1(this, file, file.getAbsolutePath()).startWatching();
        } else {
            str = "Couldn't fix frozen frame";
            this.timeUtils.postValue(new LoadResult_Error(new IllegalStateException(str)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int j() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final app.dogo.com.dogo_android.exam.g k() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a<y<Uri>> l() {
        return this.timeUtils;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> n() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final synchronized File o() {
        return this.frozenFrameFix.i(this.g);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.g = this.c.g();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.storageService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r(boolean z) {
        this.h = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        this.b.d(E_TrainingProgram.z.h());
        int i2 = 1;
        if (this.f == 0) {
            this.f = i2;
        } else {
            if (this.f == i2) {
                int i = 0;
                this.f = i;
            }
        }
    }

    public k(app.dogo.com.dogo_android.exam.g gVar, PackageManager packageManager, o3 o3Var, v2 v2Var, app.dogo.com.dogo_android.service.t2 t2Var, h hVar) {
        n.f(gVar, "examUploadData");
        n.f(packageManager, "packageManager");
        n.f(o3Var, "tracker");
        n.f(v2Var, "timeUtils");
        n.f(t2Var, "storageService");
        n.f(hVar, "frozenFrameFix");
        super();
        this.a = gVar;
        this.b = o3Var;
        this.c = v2Var;
        this.frozenFrameFix = t2Var;
        this.e = hVar;
        this.f = 1;
        this.storageService = packageManager.hasSystemFeature("android.hardware.camera.front");
        this.timeUtils = new a();
        this.tracker = new x(Boolean.FALSE);
    }

}
