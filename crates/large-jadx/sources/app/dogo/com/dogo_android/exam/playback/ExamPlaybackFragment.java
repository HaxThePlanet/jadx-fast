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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.exam.f;
import app.dogo.com.dogo_android.exam.i;
import app.dogo.com.dogo_android.exam.i.a;
import app.dogo.com.dogo_android.h.yc;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.g1;
import java.util.Arrays;
import kotlin.Metadata;
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

/* compiled from: ExamPlaybackFragment.kt */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010\u0019\u001a\u00020\u0018H\u0002J\u0008\u0010\u001a\u001a\u00020\u0018H\u0002J\u0008\u0010\u001b\u001a\u00020\u0018H\u0002J\u0008\u0010\u001c\u001a\u00020\u0018H\u0016J\u0008\u0010\u001d\u001a\u00020\u0018H\u0016J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0006\u0010)\u001a\u00020\u0018J\u000f\u0010*\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020\u00182\n\u0010-\u001a\u00060.j\u0002`/H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u000f\u001a\u0004\u0008\u0014\u0010\u0015¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentExamVideoPlaybackBinding;", "Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackScreen;", "Lapp/dogo/com/dogo_android/exam/SimpleSurfaceTextureListener;", "()V", "mediaPlayer", "Landroid/media/MediaPlayer;", "mediaPlayerPrepared", "", "sharedViewModel", "Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "videoPlaybackSurface", "Landroid/view/Surface;", "viewModel", "Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/exam/playback/ExamPlaybackViewModel;", "viewModel$delegate", "attemptVideoPlayback", "", "cancelFlow", "completeFlow", "initializeMediaPlayer", "onPause", "onResume", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "retake", "showUploadCompleted", "()Lkotlin/Unit;", "showUploadFailure", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class ExamPlaybackFragment extends app.dogo.com.dogo_android.util.m0.b<yc, h> implements i {

    /* renamed from: v, reason: from kotlin metadata */
    private final h mediaPlayer;
    /* renamed from: w, reason: from kotlin metadata */
    private final h mediaPlayerPrepared;
    private MediaPlayer x;
    /* renamed from: y, reason: from kotlin metadata */
    private boolean videoPlaybackSurface;
    private Surface z;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/exam/playback/ExamPlaybackFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends androidx.activity.d {
        b() {
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final f invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(ExamFlowViewModel.class), this.$parameters);
        }

        public c(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<i> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final i invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ExamPlaybackViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { (ExamPlaybackScreen)g.this.C1().b(), (ExamPlaybackScreen)g.this.C1().component1() });
        }

        e() {
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, yc> {

        public static final g.a a = new g$a();
        @Override // kotlin.d0.d.k
        public final yc l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return yc.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, yc.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentExamVideoPlaybackBinding;", 0);
        }
    }
    public g() {
        super(app.dogo.com.dogo_android.exam.playback.g.a.a);
        final m.a.c.j.a aVar2 = null;
        this.mediaPlayer = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.exam.playback.g.d(this, aVar2, new app.dogo.com.dogo_android.exam.playback.g.e(this)));
        this.mediaPlayerPrepared = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.exam.playback.g.c(this, aVar2, aVar2));
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final synchronized void attemptVideoPlayback() {
        Surface surface = new Surface((yc)B1().X.getSurfaceTexture());
        this.z = surface;
        if (this.x != null) {
            this.x.setSurface(surface);
        }
        if (this.x != null) {
            this.x.start();
        }
    }

    private final void H1() {
        androidx.fragment.app.e activity = null;
        ExamFlowCallback r0 = getActivity() instanceof ExamFlowCallback ? (ExamFlowCallback)this.getActivity() : 0;
        if (activity != null) {
            activity.d();
        }
    }

    private final void I1() {
        androidx.fragment.app.e activity = null;
        ExamFlowCallback r0 = getActivity() instanceof ExamFlowCallback ? (ExamFlowCallback)this.getActivity() : 0;
        if (activity != null) {
            activity.cancelFlow();
        }
    }

    private final synchronized void L1() {
        try {
            final MediaPlayer mediaPlayer = new MediaPlayer();
        } catch (Exception e) {
        }
        try {
            mediaPlayer.setDataSource(requireContext(), K1().n());
        } catch (Exception e) {
        }
        mediaPlayer.setLooping(true);
        mediaPlayer.setVideoScalingMode(2);
        mediaPlayer.setOnErrorListener(new app.dogo.com.dogo_android.exam.playback.e(this));
        mediaPlayer.setOnPreparedListener(new app.dogo.com.dogo_android.exam.playback.a(this));
        mediaPlayer.prepareAsync();
        this.x = mediaPlayer;
    }

    private static final boolean M1(g gVar, MediaPlayer mediaPlayer, int i, int i2) {
        n.f(gVar, "this$0");
        i = 2;
        final Object[] arr = new Object[i];
        arr[0] = Integer.valueOf(i);
        final int i6 = 1;
        arr[i6] = Integer.valueOf(i2);
        String formatted = String.format("Playback error %d, extra %d", Arrays.copyOf(arr, i));
        n.e(formatted, "java.lang.String.format(format, *args)");
        a.d(new Exception(formatted));
        androidx.fragment.app.e activity = gVar.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131886123);
        }
        gVar.H1();
        return true;
    }

    /* renamed from: N1, reason: from kotlin metadata */
    private static final void onViewCreated(g view, MediaPlayer savedInstanceState) {
        n.f(view, "this$0");
        view.videoPlaybackSurface = true;
        view.attemptVideoPlayback();
    }

    private static final void U1(g gVar, y yVar) {
        n.f(gVar, "this$0");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success) {
            gVar.Z1();
            gVar.I1();
        } else {
            z = yVar instanceof LoadResult_Error;
            if (yVar instanceof oadResult_Error) {
                gVar.showUploadFailure(yVar.component1());
            }
        }
    }

    private static final void V1(g gVar, View view) {
        n.f(gVar, "this$0");
        gVar.Y1();
    }

    private static final void W1(g gVar, View view) {
        n.f(gVar, "this$0");
        java.util.concurrent.Executor executor = a.i(gVar.requireActivity());
        n.e(executor, "getMainExecutor(requireActivity())");
        gVar.K1().o(executor);
    }

    private static final void X1(g gVar, View view) {
        n.f(gVar, "this$0");
        gVar.H1();
    }

    private final w Z1() {
        int i = 0;
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
            i = 0;
        } else {
            int i2 = 2131886403;
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, i2);
            w wVar = w.a;
        }
        return i;
    }

    /* renamed from: a2, reason: from kotlin metadata */
    private final void showUploadFailure(Exception ex) {
        a.d(new Exception("Upload error", ex));
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131886573);
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public f J1() {
        return (ExamFlowViewModel)this.mediaPlayerPrepared.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public i K1() {
        return (ExamPlaybackViewModel)this.mediaPlayer.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public final void Y1() {
        K1().q();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onPause() {
        super.onPause();
        if (this.x != null) {
            this.x.release();
        }
        this.videoPlaybackSurface = false;
        if (this.z != null) {
            this.z.release();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onResume() {
        super.onResume();
        L1();
        attemptVideoPlayback();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        n.f(surfaceTexture, "surfaceTexture");
        attemptVideoPlayback();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return i.a.a(this, surfaceTexture);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        i.a.b(this, surfaceTexture, i, i2);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        i.a.c(this, surfaceTexture);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        str = "view";
        n.f(view, str);
        super.onViewCreated(view, bundle);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            OnBackPressedDispatcher onBackPressedDispatcher = activity.getOnBackPressedDispatcher();
            if (onBackPressedDispatcher != null) {
                onBackPressedDispatcher.b(getViewLifecycleOwner(), new ExamPlaybackFragment_onViewCreated_1());
            }
        }
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, "viewLifecycleOwner");
        K1().l().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.exam.playback.c(this));
        (yc)B1().Q.setOnClickListener(new app.dogo.com.dogo_android.exam.playback.f(this));
        (yc)B1().S.setOnClickListener(new app.dogo.com.dogo_android.exam.playback.d(this));
        (yc)B1().O.setOnClickListener(new app.dogo.com.dogo_android.exam.playback.b(this));
    }


    public static /* synthetic */ void O1(g gVar, MediaPlayer mediaPlayer) {
        ExamPlaybackFragment.onViewCreated(gVar, mediaPlayer);
    }

    public static /* synthetic */ void P1(g gVar, View view) {
        ExamPlaybackFragment.X1(gVar, view);
    }

    public static /* synthetic */ void Q1(g gVar, y yVar) {
        ExamPlaybackFragment.U1(gVar, yVar);
    }

    public static /* synthetic */ void R1(g gVar, View view) {
        ExamPlaybackFragment.W1(gVar, view);
    }

    public static /* synthetic */ boolean S1(g gVar, MediaPlayer mediaPlayer, int i, int i2) {
        return ExamPlaybackFragment.M1(gVar, mediaPlayer, i, i2);
    }

    public static /* synthetic */ void T1(g gVar, View view) {
        ExamPlaybackFragment.V1(gVar, view);
    }
}
