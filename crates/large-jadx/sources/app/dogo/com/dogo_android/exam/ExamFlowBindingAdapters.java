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

/* compiled from: ExamFlowBindingAdapters.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0016\u0010\t\u001a\u00020\u0004*\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0007J3\u0010\t\u001a\u00020\u0004*\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u00020\u0004*\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001cJ+\u0010\u001d\u001a\u00020\u0004*\u00020\r2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010!¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamFlowBindingAdapters;", "", "()V", "setupExamPlaybackButton", "", "button", "Landroid/widget/Button;", "enabled", "", "setBindingSurfaceTextureListener", "Landroid/view/TextureView;", "callback", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/View;", "progress", "", "progressBar", "Landroid/widget/ProgressBar;", "progressText", "Landroid/widget/TextView;", "completionIndicator", "Landroid/widget/ImageView;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/widget/ProgressBar;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "setupExamButton", "Lapp/dogo/com/dogo_android/exam/VideoRecordingButton;", "examDurationSec", "", "Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;", "(Lapp/dogo/com/dogo_android/exam/VideoRecordingButton;Ljava/lang/Long;Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;)V", "setupExamPlaybackButtonVisibility", "uploadProgress", "retake", "upload", "(Landroid/view/View;Ljava/lang/Integer;Landroid/widget/Button;Landroid/widget/Button;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class ExamFlowBindingAdapters {

    public static final c a = new c();
    private c() {
        super();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final void setupExamPlaybackButton(TextureView button, TextureView.SurfaceTextureListener enabled) {
        n.f(button, "<this>");
        if (enabled != null) {
            button.setSurfaceTextureListener(enabled);
        }
    }

    public static final void b(View view, Integer integer, ProgressBar progressBar, TextView textView, ImageView imageView) {
        n.f(view, "<this>");
        n.f(progressBar, "progressBar");
        n.f(textView, "progressText");
        n.f(imageView, "completionIndicator");
        int i3 = 8;
        if (integer == null) {
            view.setVisibility(i3);
            imageView.setVisibility(i3);
        } else {
            int i = 100;
            int i2 = 0;
            if (integer.intValue() >= 100) {
                view.setVisibility(i3);
                imageView.setVisibility(i2);
            } else {
                progressBar.setProgress(integer.intValue());
                StringBuilder stringBuilder = new StringBuilder();
                str = integer + 37;
                textView.setText(str);
                view.setVisibility(i2);
                imageView.setVisibility(i3);
            }
        }
    }

    /* renamed from: c, reason: from kotlin metadata */
    public static final void setupExamPlaybackButtonVisibility(VideoRecordingButton uploadProgress, Long retake, VideoRecordingButton.b upload) {
        str = "<this>";
        n.f(uploadProgress, str);
        if (retake != null) {
            uploadProgress.setRecordingListener(upload);
            l = retake.longValue() * (long)1000;
            uploadProgress.setMaxRecordingDuration(l);
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final void setupExamButton(Button examDurationSec, boolean callback) {
        int i = 1065353216;
        examDurationSec.setEnabled(callback);
        callback = callback != null ? 1065353216 : 1052938076;
        examDurationSec.setAlpha((callback != null ? 1065353216 : 1052938076));
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final void setBindingSurfaceTextureListener(View progress, Integer progressBar, Button progressText, Button completionIndicator) {
        boolean z = true;
        n.f(progress, "<this>");
        n.f(progressText, "retake");
        n.f(completionIndicator, "upload");
        progress = progressBar == null ? 1 : 0;
        final app.dogo.com.dogo_android.exam.c cVar = ExamFlowBindingAdapters.a;
        ExamFlowBindingAdapters.a.setupExamButton(progressText, progress);
        ExamFlowBindingAdapters.a.setupExamButton(completionIndicator, progress);
    }

}
