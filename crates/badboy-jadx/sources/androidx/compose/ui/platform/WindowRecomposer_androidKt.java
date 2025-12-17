package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Looper;
import android.provider.Settings.Global;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.R.id;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0016\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u001a\"\u0010\u0018\u001a\u00020\u0011*\u00020\u00082\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007\u001a\u000c\u0010\u001d\u001a\u0004\u0018\u00010\u0006*\u00020\u0008\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00082\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c\"\u0018\u0010\r\u001a\u00020\u0008*\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f\"\u001e\u0010\u0010\u001a\u00020\u0011*\u00020\u00088@X\u0080\u0004¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006\u001e", d2 = {"animationScale", "", "Landroid/content/Context;", "Lkotlinx/coroutines/flow/StateFlow;", "", "value", "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroid/view/View;", "getCompositionContext", "(Landroid/view/View;)Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;)V", "contentChild", "getContentChild", "(Landroid/view/View;)Landroid/view/View;", "windowRecomposer", "Landroidx/compose/runtime/Recomposer;", "getWindowRecomposer$annotations", "(Landroid/view/View;)V", "getWindowRecomposer", "(Landroid/view/View;)Landroidx/compose/runtime/Recomposer;", "getAnimationScaleFlowFor", "applicationContext", "createLifecycleAwareWindowRecomposer", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "findViewTreeCompositionContext", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowRecomposer_androidKt {

    private static final Map<Context, StateFlow<Float>> animationScale;
    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        WindowRecomposer_androidKt.animationScale = (Map)linkedHashMap;
    }

    public static final StateFlow access$getAnimationScaleFlowFor(Context applicationContext) {
        return WindowRecomposer_androidKt.getAnimationScaleFlowFor(applicationContext);
    }

    public static final Recomposer createLifecycleAwareWindowRecomposer(View $this$createLifecycleAwareWindowRecomposer, CoroutineContext coroutineContext, Lifecycle lifecycle) {
        kotlin.coroutines.CoroutineContext.Element context;
        CoroutineContext plus;
        kotlin.coroutines.CoroutineContext.Element motionDurationScaleImpl;
        int lifecycle2;
        int i2;
        Object iNSTANCE;
        PausableMonotonicFrameClock pausableMonotonicFrameClock;
        Object recomposer;
        PausableMonotonicFrameClock pausableMonotonicFrameClock2;
        int i;
        if (coroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key) != null) {
            if (coroutineContext.get((CoroutineContext.Key)MonotonicFrameClock.Key) == null) {
                plus = AndroidUiDispatcher.Companion.getCurrentThread().plus(coroutineContext);
            } else {
                plus = coroutineContext;
            }
        } else {
        }
        kotlin.coroutines.CoroutineContext.Element context2 = plus.get((CoroutineContext.Key)MonotonicFrameClock.Key);
        if ((MonotonicFrameClock)context2 != null) {
            i2 = 0;
            pausableMonotonicFrameClock = new PausableMonotonicFrameClock((MonotonicFrameClock)context2);
            i = 0;
            pausableMonotonicFrameClock.pause();
        } else {
            pausableMonotonicFrameClock = lifecycle2;
        }
        final PausableMonotonicFrameClock pausableMonotonicFrameClock3 = pausableMonotonicFrameClock;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if ((MotionDurationScale)plus.get((CoroutineContext.Key)MotionDurationScale.Key) == null) {
            motionDurationScaleImpl = new MotionDurationScaleImpl();
            pausableMonotonicFrameClock = 0;
            objectRef.element = motionDurationScaleImpl;
        }
        if (pausableMonotonicFrameClock3 != null) {
            iNSTANCE = pausableMonotonicFrameClock3;
        } else {
            iNSTANCE = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext plus3 = plus.plus(iNSTANCE).plus((CoroutineContext)motionDurationScaleImpl);
        Recomposer recomposer2 = new Recomposer(plus3);
        int i4 = 0;
        recomposer2.pauseCompositionFrameClock();
        if (lifecycle == 0) {
            recomposer = ViewTreeLifecycleOwner.get($this$createLifecycleAwareWindowRecomposer);
            if (recomposer != null) {
                lifecycle2 = recomposer.getLifecycle();
            }
        } else {
            lifecycle2 = lifecycle;
        }
        int i3 = 0;
        if (lifecycle2 == 0) {
        } else {
            WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer.1 anon = new WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer.1($this$createLifecycleAwareWindowRecomposer, recomposer2);
            $this$createLifecycleAwareWindowRecomposer.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)anon);
            WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer.2 anon2 = new WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer.2(CoroutineScopeKt.CoroutineScope(plus3), pausableMonotonicFrameClock3, recomposer2, objectRef, $this$createLifecycleAwareWindowRecomposer);
            lifecycle2.addObserver((LifecycleObserver)anon2);
            return recomposer2;
        }
        int obj12 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(stringBuilder.append("ViewTreeLifecycleOwner not found from ").append($this$createLifecycleAwareWindowRecomposer).toString());
        obj12 = new KotlinNothingValueException();
        throw obj12;
    }

    public static Recomposer createLifecycleAwareWindowRecomposer$default(View view, CoroutineContext coroutineContext2, Lifecycle lifecycle3, int i4, Object object5) {
        EmptyCoroutineContext obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = EmptyCoroutineContext.INSTANCE;
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer(view, obj1, obj2);
    }

    public static final CompositionContext findViewTreeCompositionContext(View $this$findViewTreeCompositionContext) {
        CompositionContext found;
        ViewParent parent;
        ViewParent view;
        found = WindowRecomposer_androidKt.getCompositionContext($this$findViewTreeCompositionContext);
        if (found != null) {
            return found;
        }
        parent = $this$findViewTreeCompositionContext.getParent();
        while (found == null) {
            if (parent instanceof View != null) {
            }
            found = WindowRecomposer_androidKt.getCompositionContext((View)parent);
            parent = parent.getParent();
        }
        return found;
    }

    private static final StateFlow<Float> getAnimationScaleFlowFor(Context applicationContext) {
        Object stateIn;
        Float valueOf;
        int animationScaleUri;
        androidx.compose.ui.platform.WindowRecomposer_androidKt.getAnimationScaleFlowFor.1.1.contentObserver.1 anon;
        kotlinx.coroutines.channels.Channel channel;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i3;
        SharingStarted sharingStarted;
        android.content.ContentResolver contentResolver2;
        android.content.ContentResolver contentResolver;
        android.net.Uri uri;
        int i;
        int i2;
        final Object obj2 = applicationContext;
        final Map animationScale2 = WindowRecomposer_androidKt.animationScale;
        final int i8 = 0;
        final int i9 = 0;
        final Map map = animationScale;
        final int i10 = 0;
        final Object obj3 = obj;
        synchronized (animationScale2) {
            i3 = 0;
            android.content.ContentResolver contentResolver3 = obj2.getContentResolver();
            android.net.Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
            int i6 = 0;
            channel = ChannelKt.Channel$default(-1, i6, i6, 6, i6);
            anon = new WindowRecomposer_androidKt.getAnimationScaleFlowFor.1.1.contentObserver.1(channel, HandlerCompat.createAsync(Looper.getMainLooper()));
            WindowRecomposer_androidKt.getAnimationScaleFlowFor.1.1.1 anon2 = new WindowRecomposer_androidKt.getAnimationScaleFlowFor.1.1.1(contentResolver3, uriFor, anon, channel, obj2, 0);
            contentResolver = contentResolver3;
            uri = uriFor;
            map.put(obj2, FlowKt.stateIn(FlowKt.flow((Function2)anon2), CoroutineScopeKt.MainScope(), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, obj16, 0, obj18), Float.valueOf(Settings.Global.getFloat(obj2.getContentResolver(), "animator_duration_scale", 1065353216))));
            return (StateFlow)stateIn;
        }
    }

    public static final CompositionContext getCompositionContext(View $this$compositionContext) {
        Object tag;
        if (tag instanceof CompositionContext != null) {
        } else {
            tag = 0;
        }
        return tag;
    }

    private static final View getContentChild(View $this$contentChild) {
        ViewParent self;
        ViewParent parent;
        int i2;
        int i;
        parent = $this$contentChild.getParent();
        while (parent instanceof View != null) {
            parent = (View)parent.getParent();
        }
        return self;
    }

    public static final Recomposer getWindowRecomposer(View $this$windowRecomposer) {
        String $i$a$CheckPreconditionWindowRecomposer_androidKt$windowRecomposer$1;
        CompositionContext andInstallWindowRecomposer$ui_release;
        StringBuilder append;
        String str;
        int i = 0;
        if (!$this$windowRecomposer.isAttachedToWindow()) {
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Cannot locate windowRecomposer; View ").append($this$windowRecomposer).append(" is not attached to a window").toString());
        }
        View contentChild = WindowRecomposer_androidKt.getContentChild($this$windowRecomposer);
        CompositionContext compositionContext = WindowRecomposer_androidKt.getCompositionContext(contentChild);
        if (compositionContext == null) {
            andInstallWindowRecomposer$ui_release = WindowRecomposerPolicy.INSTANCE.createAndInstallWindowRecomposer$ui_release(contentChild);
            return andInstallWindowRecomposer$ui_release;
        } else {
            if (!compositionContext instanceof Recomposer) {
            } else {
                andInstallWindowRecomposer$ui_release = compositionContext;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
        throw illegalStateException;
    }

    public static void getWindowRecomposer$annotations(View view) {
    }

    public static final void setCompositionContext(View $this$compositionContext, CompositionContext value) {
        $this$compositionContext.setTag(R.id.androidx_compose_ui_view_composition_context, value);
    }
}
