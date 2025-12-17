package androidx.compose.foundation;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\"\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000bJu\u0010\u0008\u001a\u00020\u00132f\u0010\u0008\u001ab\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0011\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00140\t¢\u0006\u0002\u0008\u0015H\u0016¢\u0006\u0002\u0010 JO\u0010!\u001a\u00020\u0013*\u00020\u000b2A\u0010!\u001a=\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u00020\u00130\u0018¢\u0006\u0002\u0008\u0015H\u0016J%\u0010\"\u001a\u00020\u0013*\u00020\u000b2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u001a¢\u0006\u0002\u0008\u0015H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000Rr\u0010\u0008\u001ad\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0011\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\t¢\u0006\u0002\u0008\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016RK\u0010\u0017\u001a?\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0018¢\u0006\u0002\u0008\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001a¢\u0006\u0002\u0008\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006#", d2 = {"Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Landroidx/compose/foundation/SurfaceScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "job", "Lkotlinx/coroutines/Job;", "onSurface", "Lkotlin/Function5;", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroid/view/Surface;", "Lkotlin/ParameterName;", "name", "surface", "", "width", "height", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function5;", "onSurfaceChanged", "Lkotlin/Function3;", "onSurfaceDestroyed", "Lkotlin/Function1;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "dispatchSurfaceChanged", "dispatchSurfaceCreated", "dispatchSurfaceDestroyed", "(Lkotlin/jvm/functions/Function5;)V", "onChanged", "onDestroyed", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
abstract class BaseAndroidExternalSurfaceState implements androidx.compose.foundation.AndroidExternalSurfaceScope, androidx.compose.foundation.SurfaceScope {

    private Job job;
    private Function5<? super androidx.compose.foundation.SurfaceCoroutineScope, ? super Surface, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> onSurface;
    private Function3<? super Surface, ? super Integer, ? super Integer, Unit> onSurfaceChanged;
    private Function1<? super Surface, Unit> onSurfaceDestroyed;
    private final CoroutineScope scope;
    public BaseAndroidExternalSurfaceState(CoroutineScope scope) {
        super();
        this.scope = scope;
    }

    public static final Job access$getJob$p(androidx.compose.foundation.BaseAndroidExternalSurfaceState $this) {
        return $this.job;
    }

    public static final Function5 access$getOnSurface$p(androidx.compose.foundation.BaseAndroidExternalSurfaceState $this) {
        return $this.onSurface;
    }

    @Override // androidx.compose.foundation.AndroidExternalSurfaceScope
    public final void dispatchSurfaceChanged(Surface surface, int width, int height) {
        Integer valueOf2;
        Integer valueOf;
        final Function3 onSurfaceChanged = this.onSurfaceChanged;
        if (onSurfaceChanged != null) {
            onSurfaceChanged.invoke(surface, Integer.valueOf(width), Integer.valueOf(height));
        }
    }

    @Override // androidx.compose.foundation.AndroidExternalSurfaceScope
    public final void dispatchSurfaceCreated(Surface surface, int width, int height) {
        CoroutineScope scope;
        int i;
        CoroutineStart uNDISPATCHED;
        androidx.compose.foundation.BaseAndroidExternalSurfaceState.dispatchSurfaceCreated.1 anon;
        int i3;
        int i4;
        int width2;
        int i5;
        int i2;
        Object obj11;
        Surface obj12;
        Job obj13;
        if (this.onSurface != null) {
            Object obj = this;
            Surface surface2 = surface;
            anon = new BaseAndroidExternalSurfaceState.dispatchSurfaceCreated.1(obj, surface2, width, height, 0);
            obj12 = surface2;
            obj11.job = BuildersKt.launch$default(this.scope, 0, CoroutineStart.UNDISPATCHED, (Function2)anon, 1, 0);
        } else {
            width2 = width;
            i5 = height;
            obj12 = surface;
            obj11 = this;
        }
    }

    @Override // androidx.compose.foundation.AndroidExternalSurfaceScope
    public final void dispatchSurfaceDestroyed(Surface surface) {
        int i;
        Function1 onSurfaceDestroyed = this.onSurfaceDestroyed;
        if (onSurfaceDestroyed != null) {
            onSurfaceDestroyed.invoke(surface);
        }
        Job job = this.job;
        final int i2 = 0;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, i2, 1, i2);
        }
        this.job = i2;
    }

    @Override // androidx.compose.foundation.AndroidExternalSurfaceScope
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public void onChanged(Surface $this$onChanged, Function3<? super Surface, ? super Integer, ? super Integer, Unit> onChanged) {
        this.onSurfaceChanged = onChanged;
    }

    public void onDestroyed(Surface $this$onDestroyed, Function1<? super Surface, Unit> onDestroyed) {
        this.onSurfaceDestroyed = onDestroyed;
    }

    public void onSurface(Function5<? super androidx.compose.foundation.SurfaceCoroutineScope, ? super Surface, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> onSurface) {
        this.onSurface = onSurface;
    }
}
