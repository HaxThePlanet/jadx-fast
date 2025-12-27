package app.dogo.com.dogo_android.exam;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import d.h.e.c;
import d.h.e.d;
import d.h.e.e;
import d.h.e.r;
import d.h.e.v;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: VideoRecordingButton.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nB+\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0008\u0010\u001d\u001a\u00020\u001aH\u0002J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u000eJ\u0010\u0010 \u001a\u00020\u001a2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0008\u0010!\u001a\u00020\u001aH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/exam/VideoRecordingButton;", "Landroid/widget/ProgressBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastTouchTime", "", "progressAnimator", "Landroidx/core/animation/ObjectAnimator;", "recorded", "", "recording", "recordingListener", "Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;", "scaleDownAnimator", "Landroidx/core/animation/AnimatorSet;", "scaleUpAnimator", "cancelRecording", "", "handleTouchEvent", "action", "initialize", "setMaxRecordingDuration", "maxRecordingDuration", "setRecordingListener", "toggleRecording", "Companion", "RecordingListener", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class VideoRecordingButton extends ProgressBar {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final VideoRecordingButton.a INSTANCE = new VideoRecordingButton$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private r lastTouchTime;
    /* renamed from: b, reason: from kotlin metadata */
    private e progressAnimator;
    /* renamed from: c, reason: from kotlin metadata */
    private e recorded;
    /* renamed from: v, reason: from kotlin metadata */
    private long recording;
    /* renamed from: w, reason: from kotlin metadata */
    private VideoRecordingButton.b recordingListener;
    /* renamed from: x, reason: from kotlin metadata */
    private boolean scaleDownAnimator;
    /* renamed from: y, reason: from kotlin metadata */
    private boolean scaleUpAnimator;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$Companion;", "", "()V", "DEFAULT_MAX_RECORDING_DURATION", "", "MIN_TOUCH_HOLD_DURATION_TO_STOP_RECORDING", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;", "", "recordingStarted", "", "recordingStopped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: e0, reason: from kotlin metadata */
        void recordingStarted();

        void r();
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/exam/VideoRecordingButton$initialize$1", "Landroidx/core/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroidx/core/animation/Animator;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends d {

        final /* synthetic */ VideoRecordingButton a;
        c() {
            this.a = videoRecordingButton;
            super();
        }

        @Override // d.h.e.d
        /* renamed from: e, reason: from kotlin metadata */
        public void onAnimationEnd(c animator) {
            n.f(animator, "animator");
            this.a.g();
        }
    }
    public VideoRecordingButton(Context context, AttributeSet set) {
        super(context, set);
        cancelRecording();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ void handleTouchEvent(VideoRecordingButton action) {
        action.g();
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final synchronized void setMaxRecordingDuration(int maxRecordingDuration) {
        if (maxRecordingDuration == 0 && !this.scaleDownAnimator) {
            this.recording = System.currentTimeMillis();
            g();
        }
        long l = System.currentTimeMillis() - this.recording;
        int i = 1;
        if (this.scaleDownAnimator == 1 && this.scaleDownAnimator) {
            long l2 = 1000L;
            if (this.scaleDownAnimator >= l2) {
                g();
            }
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final void cancelRecording() {
        setMax(1000);
        int i2 = 2;
        r rVar = r.d0(this, "progress", 0, 1000);
        rVar.e0(10000L);
        this.lastTouchTime = rVar;
        n.d(rVar);
        rVar.t(null);
        n.d(this.lastTouchTime);
        this.lastTouchTime.c(new VideoRecordingButton_initialize_1(this));
        String str2 = "scaleX";
        r rVar2 = r.c0(this, str2, 1065353216, 1069547520);
        n.e(rVar2, "ofFloat(this, \"scaleX\", minScale, maxScale)");
        final String str6 = "scaleY";
        r rVar5 = r.c0(this, str6, 1065353216, 1069547520);
        n.e(rVar5, "ofFloat(this, \"scaleY\", minScale, maxScale)");
        e eVar2 = new e();
        this.progressAnimator = eVar2;
        final int i6 = 1;
        final int i7 = 0;
        if (eVar2 != null) {
            c[] arr2 = new c[i2];
            eVar2.O(rVar2, rVar5);
        }
        r rVar3 = r.c0(this, str2, 1069547520, 1065353216);
        n.e(rVar3, "ofFloat(this, \"scaleX\", maxScale, minScale)");
        r rVar4 = r.c0(this, str6, 1069547520, 1065353216);
        n.e(rVar4, "ofFloat(this, \"scaleY\", maxScale, minScale)");
        e eVar = new e();
        this.recorded = eVar;
        if (eVar != null) {
            c[] arr = new c[i2];
            eVar.O(rVar3, rVar4);
        }
        setOnTouchListener(new b(this));
    }

    private static final boolean e(VideoRecordingButton videoRecordingButton, View view, MotionEvent motionEvent) {
        n.f(videoRecordingButton, "this$0");
        n.f(motionEvent, "motionEvent");
        videoRecordingButton.setMaxRecordingDuration(motionEvent.getAction());
        return true;
    }

    private final synchronized void g() {
        int i = 0;
        if (this.scaleUpAnimator) {
            return;
        }
        if (this.scaleDownAnimator) {
            if (this.recorded != null) {
                this.recorded.v();
            }
            if (this.lastTouchTime != null) {
                this.lastTouchTime.m();
            }
            if (this.recordingListener != null) {
                this.recordingListener.r();
            }
            this.scaleUpAnimator = true;
        } else {
            if (this.progressAnimator != null) {
                this.progressAnimator.v();
            }
            if (this.lastTouchTime != null) {
                this.lastTouchTime.v();
            }
            if (this.recordingListener != null) {
                App.INSTANCE.r().c(E_Training.e);
                this.recordingListener.recordingStarted();
            }
        }
        if (this.scaleDownAnimator) {
            i = 0;
        }
        this.scaleDownAnimator = i;
    }

    @Override // android.widget.ProgressBar
    public final synchronized void b() {
        if (!this.scaleDownAnimator) {
            return;
        }
        n.d(this.lastTouchTime);
        this.lastTouchTime.m();
        int i = 0;
        setProgress(i);
        n.d(this.progressAnimator);
        this.progressAnimator.m();
        n.d(this.recorded);
        this.recorded.m();
        float f = 1f;
        setScaleX(f);
        setScaleY(f);
        this.scaleDownAnimator = false;
    }

    @Override // android.widget.ProgressBar
    public final synchronized void setMaxRecordingDuration(long j) {
        n.d(this.lastTouchTime);
        this.lastTouchTime.e0(Math.max(j, 1000L));
    }

    @Override // android.widget.ProgressBar
    public final synchronized void setRecordingListener(VideoRecordingButton.b recordingListener) {
        this.recordingListener = recordingListener;
    }


    public static /* synthetic */ boolean f(VideoRecordingButton videoRecordingButton, View view, MotionEvent motionEvent) {
        return VideoRecordingButton.e(videoRecordingButton, view, motionEvent);
    }
}
