package app.dogo.com.dogo_android.exam;

import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0016\u0010\t\u001a\u00020\u0004*\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0007J3\u0010\t\u001a\u00020\u0004*\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u00020\u0004*\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001cJ+\u0010\u001d\u001a\u00020\u0004*\u00020\r2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010!¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamFlowBindingAdapters;", "", "()V", "setupExamPlaybackButton", "", "button", "Landroid/widget/Button;", "enabled", "", "setBindingSurfaceTextureListener", "Landroid/view/TextureView;", "callback", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/View;", "progress", "", "progressBar", "Landroid/widget/ProgressBar;", "progressText", "Landroid/widget/TextView;", "completionIndicator", "Landroid/widget/ImageView;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/widget/ProgressBar;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "setupExamButton", "Lapp/dogo/com/dogo_android/exam/VideoRecordingButton;", "examDurationSec", "", "Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;", "(Lapp/dogo/com/dogo_android/exam/VideoRecordingButton;Ljava/lang/Long;Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;)V", "setupExamPlaybackButtonVisibility", "uploadProgress", "retake", "upload", "(Landroid/view/View;Ljava/lang/Integer;Landroid/widget/Button;Landroid/widget/Button;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c {

    public static final app.dogo.com.dogo_android.exam.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    public static final void a(TextureView textureView, TextureView.SurfaceTextureListener textureView$SurfaceTextureListener2) {
        n.f(textureView, "<this>");
        if (surfaceTextureListener2 != null) {
            textureView.setSurfaceTextureListener(surfaceTextureListener2);
        }
    }

    public static final void b(View view, Integer integer2, ProgressBar progressBar3, TextView textView4, ImageView imageView5) {
        int intValue;
        int i2;
        int i;
        Object obj5;
        Object obj6;
        n.f(view, "<this>");
        n.f(progressBar3, "progressBar");
        n.f(textView4, "progressText");
        n.f(imageView5, "completionIndicator");
        int i3 = 8;
        if (integer2 == null) {
            view.setVisibility(i3);
            imageView5.setVisibility(i3);
        } else {
            i = 0;
            if (integer2.intValue() >= 100) {
                view.setVisibility(i3);
                imageView5.setVisibility(i);
            } else {
                progressBar3.setProgress(integer2.intValue());
                obj6 = new StringBuilder();
                obj6.append(integer2);
                obj6.append('%');
                textView4.setText(obj6.toString());
                view.setVisibility(i);
                imageView5.setVisibility(i3);
            }
        }
    }

    public static final void c(app.dogo.com.dogo_android.exam.VideoRecordingButton videoRecordingButton, Long long2, app.dogo.com.dogo_android.exam.VideoRecordingButton.b videoRecordingButton$b3) {
        String str;
        int obj3;
        n.f(videoRecordingButton, "<this>");
        if (long2 != 0) {
            videoRecordingButton.setRecordingListener(b3);
            videoRecordingButton.setMaxRecordingDuration(obj3 *= str);
        }
    }

    private final void d(Button button, boolean z2) {
        int obj2;
        button.setEnabled(z2);
        obj2 = z2 ? 1065353216 : 1052938076;
        button.setAlpha(obj2);
    }

    public static final void e(View view, Integer integer2, Button button3, Button button4) {
        int obj1;
        n.f(view, "<this>");
        n.f(button3, "retake");
        n.f(button4, "upload");
        obj1 = integer2 == null ? 1 : 0;
        final app.dogo.com.dogo_android.exam.c obj2 = c.a;
        obj2.d(button3, obj1);
        obj2.d(button4, obj1);
    }
}
