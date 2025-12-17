package app.dogo.com.dogo_android.exam.k;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.FileObserver;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.g;
import app.dogo.com.dogo_android.exam.h;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import f.d.a.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 52\u00020\u0001:\u00015B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010/\u001a\u000200J\u0008\u00101\u001a\u0004\u0018\u000102J\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u000200R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001fR\u001a\u0010 \u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u001f\"\u0004\u0008\"\u0010#R\u001f\u0010$\u001a\u0010\u0012\u000c\u0012\n &*\u0004\u0018\u00010\u001e0\u001e0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "examUploadData", "Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "packageManager", "Landroid/content/pm/PackageManager;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "frozenFrameFix", "Lapp/dogo/com/dogo_android/exam/FrozenFrameFix;", "(Lapp/dogo/com/dogo_android/exam/ExamUploadData;Landroid/content/pm/PackageManager;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/exam/FrozenFrameFix;)V", "cameraId", "", "getCameraId", "()I", "setCameraId", "(I)V", "getExamUploadData", "()Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "finaliseCompleted", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Landroid/net/Uri;", "getFinaliseCompleted", "()Lcom/hadilq/liveevent/LiveEvent;", "isSwitchCameraVisible", "", "()Z", "previewing", "getPreviewing", "setPreviewing", "(Z)V", "recording", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getRecording", "()Landroidx/lifecycle/MutableLiveData;", "sessionStartTimeMs", "", "getSessionStartTimeMs", "()J", "setSessionStartTimeMs", "(J)V", "finaliseRecording", "", "getRecordingFile", "Ljava/io/File;", "initiateCaptureSession", "toggleCamera", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends s {

    public static final app.dogo.com.dogo_android.exam.k.k.a Companion;
    private final g a;
    private final o3 b;
    private final v2 c;
    private final t2 d;
    private final h e;
    private int f;
    private long g;
    private boolean h;
    private final boolean i;
    private final a<y<Uri>> j;
    private final x<Boolean> k;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordViewModel$Companion;", "", "()V", "CAMERA_BACK", "", "CAMERA_FRONT", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/exam/record/ExamRecordViewModel$finaliseRecording$recordingFileObserver$1", "Landroid/os/FileObserver;", "onEvent", "", "event", "", "path", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends FileObserver {

        final app.dogo.com.dogo_android.exam.k.k a;
        final File b;
        b(app.dogo.com.dogo_android.exam.k.k k, File file2, String string3) {
            this.a = k;
            this.b = file2;
            super(string3, 8);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String string2) {
            y.c cVar;
            String str;
            Uri obj3;
            a obj4;
            if (i != 8) {
            }
            stopWatching();
            cVar = new y.c(Uri.fromFile(k.h(this.a).b(this.b)));
            this.a.l().postValue(cVar);
        }
    }
    static {
        k.a aVar = new k.a(0);
        k.Companion = aVar;
    }

    public k(g g, PackageManager packageManager2, o3 o33, v2 v24, t2 t25, h h6) {
        n.f(g, "examUploadData");
        n.f(packageManager2, "packageManager");
        n.f(o33, "tracker");
        n.f(v24, "timeUtils");
        n.f(t25, "storageService");
        n.f(h6, "frozenFrameFix");
        super();
        this.a = g;
        this.b = o33;
        this.c = v24;
        this.d = t25;
        this.e = h6;
        this.f = 1;
        this.i = packageManager2.hasSystemFeature("android.hardware.camera.front");
        a obj2 = new a();
        this.j = obj2;
        obj2 = new x(Boolean.FALSE);
        this.k = obj2;
    }

    public k(g g, PackageManager packageManager2, o3 o33, v2 v24, t2 t25, h h6, int i7, g g8) {
        h obj13;
        if (i7 &= 32 != 0) {
            obj13 = new h();
        }
        super(g, packageManager2, o33, v24, t25, obj13);
    }

    public static final h h(app.dogo.com.dogo_android.exam.k.k k) {
        return k.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        Object file;
        Object absolutePath;
        Object illegalStateException;
        String str;
        this.j.postValue(y.b.a);
        file = o();
        if (file != null) {
            illegalStateException = new k.b(this, file, file.getAbsolutePath());
            illegalStateException.startWatching();
        } else {
            illegalStateException = new IllegalStateException("Couldn't fix frozen frame");
            absolutePath = new y.a(illegalStateException);
            this.j.postValue(absolutePath);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int j() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final g k() {
        return this.a;
    }

    public final a<y<Uri>> l() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m() {
        return this.h;
    }

    public final x<Boolean> n() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final File o() {
        return this.d.i(this.g);
        synchronized (this) {
            return this.d.i(this.g);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.g = this.c.g();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r(boolean z) {
        this.h = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        int i;
        this.b.d(q0.z.h());
        i = this.f;
        int i2 = 1;
        if (i == 0) {
            this.f = i2;
        } else {
            if (i == i2) {
                this.f = 0;
            }
        }
    }
}
