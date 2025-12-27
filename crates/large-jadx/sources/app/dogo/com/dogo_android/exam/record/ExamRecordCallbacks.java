package app.dogo.com.dogo_android.exam.k;

import android.graphics.SurfaceTexture;
import app.dogo.com.dogo_android.exam.VideoRecordingButton.b;
import app.dogo.com.dogo_android.exam.i;
import app.dogo.com.dogo_android.exam.i.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ExamRecordCallbacks.kt */
@Metadata(d1 = "\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/exam/record/ExamRecordCallbacks;", "Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;", "Lapp/dogo/com/dogo_android/exam/SimpleSurfaceTextureListener;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public interface ExamRecordCallbacks extends VideoRecordingButton.b, i {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static boolean a(h hVar, SurfaceTexture surfaceTexture) {
            n.f(hVar, "this");
            n.f(surfaceTexture, "surfaceTexture");
            return i.a.a(hVar, surfaceTexture);
        }

        public static void b(h hVar, SurfaceTexture surfaceTexture, int i, int i2) {
            n.f(hVar, "this");
            n.f(surfaceTexture, "surfaceTexture");
            i.a.b(hVar, surfaceTexture, i, i2);
        }

        public static void c(h hVar, SurfaceTexture surfaceTexture) {
            n.f(hVar, "this");
            n.f(surfaceTexture, "surfaceTexture");
            i.a.c(hVar, surfaceTexture);
        }
    }
}
