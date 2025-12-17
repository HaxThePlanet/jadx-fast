package app.dogo.com.dogo_android.exam.k;

import android.graphics.SurfaceTexture;
import app.dogo.com.dogo_android.exam.VideoRecordingButton.b;
import app.dogo.com.dogo_android.exam.i;
import app.dogo.com.dogo_android.exam.i.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordCallbacks;", "Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;", "Lapp/dogo/com/dogo_android/exam/SimpleSurfaceTextureListener;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface h extends VideoRecordingButton.b, i {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static boolean a(app.dogo.com.dogo_android.exam.k.h h, SurfaceTexture surfaceTexture2) {
            n.f(h, "this");
            n.f(surfaceTexture2, "surfaceTexture");
            return i.a.a(h, surfaceTexture2);
        }

        public static void b(app.dogo.com.dogo_android.exam.k.h h, SurfaceTexture surfaceTexture2, int i3, int i4) {
            n.f(h, "this");
            n.f(surfaceTexture2, "surfaceTexture");
            i.a.b(h, surfaceTexture2, i3, i4);
        }

        public static void c(app.dogo.com.dogo_android.exam.k.h h, SurfaceTexture surfaceTexture2) {
            n.f(h, "this");
            n.f(surfaceTexture2, "surfaceTexture");
            i.a.c(h, surfaceTexture2);
        }
    }
}
