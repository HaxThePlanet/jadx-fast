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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nB+\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0008\u0010\u001d\u001a\u00020\u001aH\u0002J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u000eJ\u0010\u0010 \u001a\u00020\u001a2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0008\u0010!\u001a\u00020\u001aH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/exam/VideoRecordingButton;", "Landroid/widget/ProgressBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastTouchTime", "", "progressAnimator", "Landroidx/core/animation/ObjectAnimator;", "recorded", "", "recording", "recordingListener", "Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;", "scaleDownAnimator", "Landroidx/core/animation/AnimatorSet;", "scaleUpAnimator", "cancelRecording", "", "handleTouchEvent", "action", "initialize", "setMaxRecordingDuration", "maxRecordingDuration", "setRecordingListener", "toggleRecording", "Companion", "RecordingListener", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VideoRecordingButton extends ProgressBar {

    public static final app.dogo.com.dogo_android.exam.VideoRecordingButton.a Companion;
    private r a;
    private e b;
    private e c;
    private long v;
    private app.dogo.com.dogo_android.exam.VideoRecordingButton.b w;
    private boolean x;
    private boolean y;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$Companion;", "", "()V", "DEFAULT_MAX_RECORDING_DURATION", "", "MIN_TOUCH_HOLD_DURATION_TO_STOP_RECORDING", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/exam/VideoRecordingButton$RecordingListener;", "", "recordingStarted", "", "recordingStopped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void e0();

        public abstract void r();
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/exam/VideoRecordingButton$initialize$1", "Landroidx/core/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroidx/core/animation/Animator;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends d {

        final app.dogo.com.dogo_android.exam.VideoRecordingButton a;
        c(app.dogo.com.dogo_android.exam.VideoRecordingButton videoRecordingButton) {
            this.a = videoRecordingButton;
            super();
        }

        @Override // d.h.e.d
        public void e(c c) {
            n.f(c, "animator");
            VideoRecordingButton.a(this.a);
        }
    }
    static {
        VideoRecordingButton.a aVar = new VideoRecordingButton.a(0);
        VideoRecordingButton.Companion = aVar;
    }

    public VideoRecordingButton(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        d();
    }

    public static final void a(app.dogo.com.dogo_android.exam.VideoRecordingButton videoRecordingButton) {
        videoRecordingButton.g();
    }

    private final void c(int i) {
        boolean currentTimeMillis;
        int i2;
        int obj5;
        synchronized (this) {
            if (!this.x) {
                this.v = System.currentTimeMillis();
                g();
            }
            try {
                if (i == 1 && this.x && Long.compare(i3, i2) >= 0) {
                }
                if (this.x) {
                }
                if (Long.compare(i3, i2) >= 0) {
                }
                g();
                throw i;
            }
        }
    }

    private final void d() {
        c[] arr;
        c[] arr2;
        setMax(1000);
        arr = 2;
        int[] iArr = new int[arr];
        iArr = new int[]{0, 1000};
        r rVar = r.d0(this, "progress", iArr);
        rVar.e0(10000);
        this.a = rVar;
        n.d(rVar);
        rVar.t(0);
        r rVar2 = this.a;
        n.d(rVar2);
        VideoRecordingButton.c cVar = new VideoRecordingButton.c(this);
        rVar2.c(cVar);
        float[] fArr = new float[arr];
        fArr = new int[]{1065353216, 1069547520};
        String str2 = "scaleX";
        r rVar3 = r.c0(this, str2, fArr);
        n.e(rVar3, "ofFloat(this, \"scaleX\", minScale, maxScale)");
        float[] fArr4 = new float[arr];
        fArr4 = new int[]{1065353216, 1069547520};
        final String str6 = "scaleY";
        r rVar6 = r.c0(this, str6, fArr4);
        n.e(rVar6, "ofFloat(this, \"scaleY\", minScale, maxScale)");
        e eVar2 = new e();
        this.b = eVar2;
        final int i4 = 1;
        final int i5 = 0;
        if (eVar2 == null) {
        } else {
            arr2 = new c[arr];
            arr2[i5] = rVar3;
            arr2[i4] = rVar6;
            eVar2.O(arr2);
        }
        float[] fArr2 = new float[arr];
        fArr2 = new int[]{1069547520, 1065353216};
        r rVar4 = r.c0(this, str2, fArr2);
        n.e(rVar4, "ofFloat(this, \"scaleX\", maxScale, minScale)");
        float[] fArr3 = new float[arr];
        fArr3 = new int[]{1069547520, 1065353216};
        r rVar5 = r.c0(this, str6, fArr3);
        n.e(rVar5, "ofFloat(this, \"scaleY\", maxScale, minScale)");
        e eVar = new e();
        this.c = eVar;
        if (eVar == null) {
        } else {
            arr = new c[arr];
            arr[i5] = rVar4;
            arr[i4] = rVar5;
            eVar.O(arr);
        }
        b bVar = new b(this);
        setOnTouchListener(bVar);
    }

    private static final boolean e(app.dogo.com.dogo_android.exam.VideoRecordingButton videoRecordingButton, View view2, MotionEvent motionEvent3) {
        n.f(videoRecordingButton, "this$0");
        n.f(motionEvent3, "motionEvent");
        videoRecordingButton.c(motionEvent3.getAction());
        return 1;
    }

    public static boolean f(app.dogo.com.dogo_android.exam.VideoRecordingButton videoRecordingButton, View view2, MotionEvent motionEvent3) {
        return VideoRecordingButton.e(videoRecordingButton, view2, motionEvent3);
    }

    private final void g() {
        Object rVar;
        int i;
        app.dogo.com.dogo_android.w.t2 t2Var;
        synchronized (this) {
            try {
                app.dogo.com.dogo_android.exam.VideoRecordingButton.b bVar = this.w;
            }
            e eVar = this.c;
            if (eVar == null) {
            } else {
                eVar.v();
            }
            rVar = this.a;
            if (rVar == null) {
                try {
                    rVar.m();
                    if (bVar == null) {
                    } else {
                    }
                    bVar.r();
                    this.y = true;
                    e eVar2 = this.b;
                    if (eVar2 == null) {
                    } else {
                    }
                    eVar2.v();
                    rVar = this.a;
                    if (rVar == null) {
                    } else {
                    }
                    rVar.v();
                    if (bVar != null) {
                    }
                    App.Companion.r().c(p0.e);
                    bVar.e0();
                    if (!this.x) {
                    } else {
                    }
                    i = 0;
                    this.x = i;
                    throw th;
                }
            } else {
            }
        }
    }

    @Override // android.widget.ProgressBar
    public final void b() {
        synchronized (this) {
            try {
                r rVar = this.a;
                n.d(rVar);
                rVar.m();
                int i = 0;
                setProgress(i);
                e eVar = this.b;
                n.d(eVar);
                eVar.m();
                e eVar2 = this.c;
                n.d(eVar2);
                eVar2.m();
                int i2 = 1065353216;
                setScaleX(i2);
                setScaleY(i2);
                this.x = i;
            }
        }
    }

    @Override // android.widget.ProgressBar
    public final void setMaxRecordingDuration(long l) {
        final r rVar = this.a;
        n.d(rVar);
        rVar.e0(Math.max(l, obj5));
        return;
        synchronized (this) {
            rVar = this.a;
            n.d(rVar);
            rVar.e0(Math.max(l, obj5));
        }
    }

    @Override // android.widget.ProgressBar
    public final void setRecordingListener(app.dogo.com.dogo_android.exam.VideoRecordingButton.b videoRecordingButton$b) {
        this.w = b;
        return;
        synchronized (this) {
            this.w = b;
        }
    }
}
