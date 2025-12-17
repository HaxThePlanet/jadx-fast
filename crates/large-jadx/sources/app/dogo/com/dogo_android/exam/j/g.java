package app.dogo.com.dogo_android.exam.j;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.exam.d;
import app.dogo.com.dogo_android.exam.f;
import app.dogo.com.dogo_android.exam.i;
import app.dogo.com.dogo_android.exam.i.a;
import app.dogo.com.dogo_android.h.yc;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.m0.b;
import f.d.a.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.f0;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010\u0019\u001a\u00020\u0018H\u0002J\u0008\u0010\u001a\u001a\u00020\u0018H\u0002J\u0008\u0010\u001b\u001a\u00020\u0018H\u0002J\u0008\u0010\u001c\u001a\u00020\u0018H\u0016J\u0008\u0010\u001d\u001a\u00020\u0018H\u0016J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0006\u0010)\u001a\u00020\u0018J\u000f\u0010*\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020\u00182\n\u0010-\u001a\u00060.j\u0002`/H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u000f\u001a\u0004\u0008\u0014\u0010\u0015¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentExamVideoPlaybackBinding;", "Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackScreen;", "Lapp/dogo/com/dogo_android/exam/SimpleSurfaceTextureListener;", "()V", "mediaPlayer", "Landroid/media/MediaPlayer;", "mediaPlayerPrepared", "", "sharedViewModel", "Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "videoPlaybackSurface", "Landroid/view/Surface;", "viewModel", "Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackViewModel;", "viewModel$delegate", "attemptVideoPlayback", "", "cancelFlow", "completeFlow", "initializeMediaPlayer", "onPause", "onResume", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "retake", "showUploadCompleted", "()Lkotlin/Unit;", "showUploadFailure", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends b<yc, app.dogo.com.dogo_android.exam.j.h> implements i {

    private final h v;
    private final h w;
    private MediaPlayer x;
    private boolean y;
    private Surface z;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/exam/playback/ExamPlaybackFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {
        b() {
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<f> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public c(Fragment fragment, a a2, a a3) {
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
    public static final class d extends p implements a<app.dogo.com.dogo_android.exam.j.i> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.exam.j.i invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(i.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.exam.j.g this$0;
        e(app.dogo.com.dogo_android.exam.j.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b((h)this.this$0.C1().b(), (h)this.this$0.C1().a());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, yc> {

        public static final app.dogo.com.dogo_android.exam.j.g.a a;
        static {
            g.a aVar = new g.a();
            g.a.a = aVar;
        }

        a() {
            super(3, yc.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentExamVideoPlaybackBinding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final yc l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return yc.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
    }

    public g() {
        super(g.a.a);
        g.e eVar = new g.e(this);
        final int i = 0;
        g.d dVar = new g.d(this, i, eVar);
        this.v = j.a(m.SYNCHRONIZED, dVar);
        g.c cVar = new g.c(this, i, i);
        this.w = j.a(m.NONE, cVar);
    }

    private final void G1() {
        boolean available;
        MediaPlayer mediaPlayer;
        synchronized (this) {
            try {
                if (view.X.isAvailable()) {
                }
                Surface surface = new Surface(view3.X.getSurfaceTexture());
                this.z = surface;
                mediaPlayer = this.x;
                if (mediaPlayer == null) {
                } else {
                }
                mediaPlayer.setSurface(surface);
                available = this.x;
                if (available == null) {
                } else {
                }
                available.start();
                throw th;
            }
        }
    }

    private final void H1() {
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

    private final void I1() {
        androidx.fragment.app.e activity;
        if (activity instanceof d) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.c();
        }
    }

    private final void L1() {
        int i;
        android.net.Uri uri;
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(requireContext(), K1().n());
        synchronized (this) {
            mediaPlayer.setLooping(true);
            mediaPlayer.setVideoScalingMode(2);
            e eVar = new e(this);
            mediaPlayer.setOnErrorListener(eVar);
            a aVar = new a(this);
            mediaPlayer.setOnPreparedListener(aVar);
            mediaPlayer.prepareAsync();
            this.x = mediaPlayer;
        }
    }

    private static final boolean M1(app.dogo.com.dogo_android.exam.j.g g, MediaPlayer mediaPlayer2, int i3, int i4) {
        String obj5;
        n.f(g, "this$0");
        f0 f0Var = f0.a;
        int i = 2;
        final Object[] arr = new Object[i];
        arr[0] = Integer.valueOf(i3);
        final int obj6 = 1;
        arr[obj6] = Integer.valueOf(i4);
        obj5 = String.format("Playback error %d, extra %d", Arrays.copyOf(arr, i));
        n.e(obj5, "java.lang.String.format(format, *args)");
        Exception obj4 = new Exception(obj5);
        a.d(obj4);
        obj4 = g.getActivity();
        if (obj4 == null) {
        } else {
            g1.g0(obj4, 2131886123);
        }
        g.H1();
        return obj6;
    }

    private static final void N1(app.dogo.com.dogo_android.exam.j.g g, MediaPlayer mediaPlayer2) {
        n.f(g, "this$0");
        g.y = true;
        g.G1();
    }

    public static void O1(app.dogo.com.dogo_android.exam.j.g g, MediaPlayer mediaPlayer2) {
        g.N1(g, mediaPlayer2);
    }

    public static void P1(app.dogo.com.dogo_android.exam.j.g g, View view2) {
        g.X1(g, view2);
    }

    public static void Q1(app.dogo.com.dogo_android.exam.j.g g, y y2) {
        g.U1(g, y2);
    }

    public static void R1(app.dogo.com.dogo_android.exam.j.g g, View view2) {
        g.W1(g, view2);
    }

    public static boolean S1(app.dogo.com.dogo_android.exam.j.g g, MediaPlayer mediaPlayer2, int i3, int i4) {
        return g.M1(g, mediaPlayer2, i3, i4);
    }

    public static void T1(app.dogo.com.dogo_android.exam.j.g g, View view2) {
        g.V1(g, view2);
    }

    private static final void U1(app.dogo.com.dogo_android.exam.j.g g, y y2) {
        boolean z;
        Object obj2;
        n.f(g, "this$0");
        if (y2 instanceof y.c) {
            g.Z1();
            g.I1();
        } else {
            if (y2 instanceof y.a) {
                g.a2((y.a)y2.a());
            }
        }
    }

    private static final void V1(app.dogo.com.dogo_android.exam.j.g g, View view2) {
        n.f(g, "this$0");
        g.Y1();
    }

    private static final void W1(app.dogo.com.dogo_android.exam.j.g g, View view2) {
        n.f(g, "this$0");
        java.util.concurrent.Executor obj1 = a.i(g.requireActivity());
        n.e(obj1, "getMainExecutor(requireActivity())");
        g.K1().o(obj1);
    }

    private static final void X1(app.dogo.com.dogo_android.exam.j.g g, View view2) {
        n.f(g, "this$0");
        g.H1();
    }

    private final w Z1() {
        int i2;
        int i;
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
            i2 = 0;
        } else {
            g1.g0(activity, 2131886403);
            i2 = w.a;
        }
        return i2;
    }

    private final void a2(Exception exception) {
        Exception exception2;
        exception2 = new Exception("Upload error", exception);
        a.d(exception2);
        final androidx.fragment.app.e obj3 = getActivity();
        if (obj3 == null) {
        } else {
            g1.g0(obj3, 2131886573);
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s D1() {
        return J1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s E1() {
        return K1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public f J1() {
        return (f)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.exam.j.i K1() {
        return (i)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public final void Y1() {
        K1().q();
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.O(activity);
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onPause() {
        super.onPause();
        MediaPlayer mediaPlayer = this.x;
        if (mediaPlayer == null) {
        } else {
            mediaPlayer.release();
        }
        this.y = false;
        Surface surface = this.z;
        if (surface == null) {
        } else {
            surface.release();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onResume() {
        super.onResume();
        L1();
        G1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        n.f(surfaceTexture, "surfaceTexture");
        G1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return i.a.a(this, surfaceTexture);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        i.a.b(this, surfaceTexture, i2, i3);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        i.a.c(this, surfaceTexture);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle2) {
        Object bVar;
        Object obj2;
        Object obj3;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        obj2 = getActivity();
        if (obj2 == null) {
        } else {
            obj2 = obj2.getOnBackPressedDispatcher();
            if (obj2 == null) {
            } else {
                bVar = new g.b();
                obj2.b(getViewLifecycleOwner(), bVar);
            }
        }
        obj3 = getViewLifecycleOwner();
        n.e(obj3, "viewLifecycleOwner");
        c cVar = new c(this);
        K1().l().observe(obj3, cVar);
        obj3 = new f(this);
        obj2.Q.setOnClickListener(obj3);
        obj3 = new d(this);
        obj2.S.setOnClickListener(obj3);
        obj3 = new b(this);
        obj2.O.setOnClickListener(obj3);
    }
}
