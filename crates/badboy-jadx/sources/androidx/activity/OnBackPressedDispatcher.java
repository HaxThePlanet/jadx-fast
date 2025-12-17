package androidx.activity;

import android.os.Build.VERSION;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0018\u00002\u00020\u0001:\u0004)*+,B\u0013\u0008\u0017\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000cH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u000cH\u0007J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u000cH\u0001¢\u0006\u0002\u0008\u001aJ\u0008\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0008\u0010\n\u001a\u00020\u0007H\u0007J\u0008\u0010 \u001a\u00020\u0014H\u0003J\u0008\u0010!\u001a\u00020\u0014H\u0007J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000eH\u0007J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0007H\u0003J\u0008\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "onHasEnabledCallbacksChanged", "Landroidx/core/util/Consumer;", "", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "backInvokedCallbackRegistered", "hasEnabledCallbacks", "inProgressCallback", "Landroidx/activity/OnBackPressedCallback;", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackPressedCallbacks", "Lkotlin/collections/ArrayDeque;", "addCallback", "", "onBackPressedCallback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addCancellableCallback", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "dispatchOnBackCancelled", "dispatchOnBackProgressed", "backEvent", "Landroidx/activity/BackEventCompat;", "dispatchOnBackStarted", "onBackCancelled", "onBackPressed", "onBackProgressed", "onBackStarted", "setOnBackInvokedDispatcher", "invoker", "updateBackInvokedCallbackState", "shouldBeRegistered", "updateEnabledCallbacks", "Api33Impl", "Api34Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnBackPressedDispatcher {

    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private androidx.activity.OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    private final ArrayDeque<androidx.activity.OnBackPressedCallback> onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0001J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\u0001¨\u0006\u000e", d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "()V", "createOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackInvoked", "Lkotlin/Function0;", "", "registerOnBackInvokedCallback", "dispatcher", "priority", "", "callback", "unregisterOnBackInvokedCallback", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api33Impl {

        public static final androidx.activity.OnBackPressedDispatcher.Api33Impl INSTANCE;
        public static void $r8$lambda$uALQStkfKNo5swuEpG7lymZRBFs(Function0 function0) {
            OnBackPressedDispatcher.Api33Impl.createOnBackInvokedCallback$lambda$0(function0);
        }

        static {
            OnBackPressedDispatcher.Api33Impl api33Impl = new OnBackPressedDispatcher.Api33Impl();
            OnBackPressedDispatcher.Api33Impl.INSTANCE = api33Impl;
        }

        private static final void createOnBackInvokedCallback$lambda$0(Function0 $onBackInvoked) {
            $onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback createOnBackInvokedCallback(Function0<Unit> onBackInvoked) {
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            OnBackPressedDispatcher.Api33Impl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new OnBackPressedDispatcher.Api33Impl$$ExternalSyntheticLambda0(onBackInvoked);
            return externalSyntheticLambda0;
        }

        public final void registerOnBackInvokedCallback(Object dispatcher, int priority, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            (OnBackInvokedDispatcher)dispatcher.registerOnBackInvokedCallback(priority, (OnBackInvokedCallback)callback);
        }

        public final void unregisterOnBackInvokedCallback(Object dispatcher, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            (OnBackInvokedDispatcher)dispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback)callback);
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002Jh\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u00062!\u0010\u000c\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u00062\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u000e¨\u0006\u0010", d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", "()V", "createOnBackAnimationCallback", "Landroid/window/OnBackInvokedCallback;", "onBackStarted", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "backEvent", "", "onBackProgressed", "onBackInvoked", "Lkotlin/Function0;", "onBackCancelled", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api34Impl {

        public static final androidx.activity.OnBackPressedDispatcher.Api34Impl INSTANCE;
        static {
            OnBackPressedDispatcher.Api34Impl api34Impl = new OnBackPressedDispatcher.Api34Impl();
            OnBackPressedDispatcher.Api34Impl.INSTANCE = api34Impl;
        }

        public final OnBackInvokedCallback createOnBackAnimationCallback(Function1<? super androidx.activity.BackEventCompat, Unit> onBackStarted, Function1<? super androidx.activity.BackEventCompat, Unit> onBackProgressed, Function0<Unit> onBackInvoked, Function0<Unit> onBackCancelled) {
            Intrinsics.checkNotNullParameter(onBackStarted, "onBackStarted");
            Intrinsics.checkNotNullParameter(onBackProgressed, "onBackProgressed");
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            Intrinsics.checkNotNullParameter(onBackCancelled, "onBackCancelled");
            OnBackPressedDispatcher.Api34Impl.createOnBackAnimationCallback.1 anon = new OnBackPressedDispatcher.Api34Impl.createOnBackAnimationCallback.1(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
            return (OnBackInvokedCallback)anon;
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "currentCancellable", "cancel", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, androidx.activity.Cancellable {

        private androidx.activity.Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final androidx.activity.OnBackPressedCallback onBackPressedCallback;
        final androidx.activity.OnBackPressedDispatcher this$0;
        public LifecycleOnBackPressedCancellable(androidx.activity.OnBackPressedDispatcher this$0, Lifecycle lifecycle, androidx.activity.OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = this$0;
            super();
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            this.lifecycle.addObserver((LifecycleObserver)this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void cancel() {
            this.lifecycle.removeObserver((LifecycleObserver)this);
            this.onBackPressedCallback.removeCancellable((Cancellable)this);
            androidx.activity.Cancellable currentCancellable = this.currentCancellable;
            if (currentCancellable != null) {
                currentCancellable.cancel();
            }
            this.currentCancellable = 0;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            Object cancellableCallback$activity_release;
            androidx.activity.OnBackPressedCallback onBackPressedCallback;
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            } else {
                if (event == Lifecycle.Event.ON_STOP) {
                    cancellableCallback$activity_release = this.currentCancellable;
                    if (cancellableCallback$activity_release != null) {
                        cancellableCallback$activity_release.cancel();
                    }
                } else {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        cancel();
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "cancel", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class OnBackPressedCancellable implements androidx.activity.Cancellable {

        private final androidx.activity.OnBackPressedCallback onBackPressedCallback;
        final androidx.activity.OnBackPressedDispatcher this$0;
        public OnBackPressedCancellable(androidx.activity.OnBackPressedDispatcher this$0, androidx.activity.OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = this$0;
            super();
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            boolean equal;
            OnBackPressedDispatcher.access$getOnBackPressedCallbacks$p(this.this$0).remove(this.onBackPressedCallback);
            int i = 0;
            if (Intrinsics.areEqual(OnBackPressedDispatcher.access$getInProgressCallback$p(this.this$0), this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                OnBackPressedDispatcher.access$setInProgressCallback$p(this.this$0, i);
            }
            this.onBackPressedCallback.removeCancellable((Cancellable)this);
            Function0 enabledChangedCallback$activity_release = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(i);
        }
    }
    public OnBackPressedDispatcher() {
        final int i = 0;
        super(i, 1, i);
    }

    public OnBackPressedDispatcher(Runnable fallbackOnBackPressed) {
        super(fallbackOnBackPressed, 0);
    }

    public OnBackPressedDispatcher(Runnable runnable, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public OnBackPressedDispatcher(Runnable fallbackOnBackPressed, Consumer<Boolean> onHasEnabledCallbacksChanged) {
        OnBackInvokedCallback onBackInvokedCallback;
        Lambda anon4;
        androidx.activity.OnBackPressedDispatcher.2 anon;
        androidx.activity.OnBackPressedDispatcher.3 anon2;
        androidx.activity.OnBackPressedDispatcher.4 anon3;
        super();
        this.fallbackOnBackPressed = fallbackOnBackPressed;
        this.onHasEnabledCallbacksChanged = onHasEnabledCallbacksChanged;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.onBackPressedCallbacks = arrayDeque;
        if (Build.VERSION.SDK_INT >= 33) {
            if (Build.VERSION.SDK_INT >= 34) {
                anon4 = new OnBackPressedDispatcher.1(this);
                anon = new OnBackPressedDispatcher.2(this);
                anon2 = new OnBackPressedDispatcher.3(this);
                anon3 = new OnBackPressedDispatcher.4(this);
                onBackInvokedCallback = OnBackPressedDispatcher.Api34Impl.INSTANCE.createOnBackAnimationCallback((Function1)anon4, (Function1)anon, (Function0)anon2, (Function0)anon3);
            } else {
                anon4 = new OnBackPressedDispatcher.5(this);
                onBackInvokedCallback = OnBackPressedDispatcher.Api33Impl.INSTANCE.createOnBackInvokedCallback((Function0)anon4);
            }
            this.onBackInvokedCallback = onBackInvokedCallback;
        }
    }

    public static final androidx.activity.OnBackPressedCallback access$getInProgressCallback$p(androidx.activity.OnBackPressedDispatcher $this) {
        return $this.inProgressCallback;
    }

    public static final ArrayDeque access$getOnBackPressedCallbacks$p(androidx.activity.OnBackPressedDispatcher $this) {
        return $this.onBackPressedCallbacks;
    }

    public static final void access$onBackCancelled(androidx.activity.OnBackPressedDispatcher $this) {
        $this.onBackCancelled();
    }

    public static final void access$onBackProgressed(androidx.activity.OnBackPressedDispatcher $this, androidx.activity.BackEventCompat backEvent) {
        $this.onBackProgressed(backEvent);
    }

    public static final void access$onBackStarted(androidx.activity.OnBackPressedDispatcher $this, androidx.activity.BackEventCompat backEvent) {
        $this.onBackStarted(backEvent);
    }

    public static final void access$setInProgressCallback$p(androidx.activity.OnBackPressedDispatcher $this, androidx.activity.OnBackPressedCallback <set-?>) {
        $this.inProgressCallback = <set-?>;
    }

    public static final void access$updateEnabledCallbacks(androidx.activity.OnBackPressedDispatcher $this) {
        $this.updateEnabledCallbacks();
    }

    private final void onBackCancelled() {
        Object $this$lastOrNull$iv;
        int i2;
        ListIterator listIterator;
        Object element$iv;
        boolean it;
        int i;
        final int i3 = 0;
        if (this.inProgressCallback == null) {
            ArrayDeque onBackPressedCallbacks = this.onBackPressedCallbacks;
            i2 = 0;
            listIterator = onBackPressedCallbacks.listIterator((List)onBackPressedCallbacks.size());
            while (listIterator.hasPrevious()) {
                i = 0;
            }
            element$iv = i3;
            $this$lastOrNull$iv = element$iv;
        }
        this.inProgressCallback = i3;
        if ($this$lastOrNull$iv != null) {
            $this$lastOrNull$iv.handleOnBackCancelled();
        }
    }

    private final void onBackProgressed(androidx.activity.BackEventCompat backEvent) {
        Object $this$lastOrNull$iv;
        int i2;
        ListIterator listIterator;
        Object element$iv;
        boolean it;
        int i;
        if (this.inProgressCallback == null) {
            ArrayDeque onBackPressedCallbacks = this.onBackPressedCallbacks;
            i2 = 0;
            listIterator = onBackPressedCallbacks.listIterator((List)onBackPressedCallbacks.size());
            while (listIterator.hasPrevious()) {
                i = 0;
            }
            element$iv = 0;
            $this$lastOrNull$iv = element$iv;
        }
        if ($this$lastOrNull$iv != null) {
            $this$lastOrNull$iv.handleOnBackProgressed(backEvent);
        }
    }

    private final void onBackStarted(androidx.activity.BackEventCompat backEvent) {
        Object element$iv;
        boolean it;
        int i;
        ArrayDeque onBackPressedCallbacks = this.onBackPressedCallbacks;
        int i2 = 0;
        ListIterator listIterator = onBackPressedCallbacks.listIterator((List)onBackPressedCallbacks.size());
        while (listIterator.hasPrevious()) {
            i = 0;
        }
        element$iv = 0;
        Object $this$lastOrNull$iv = element$iv;
        if (this.inProgressCallback != null) {
            onBackCancelled();
        }
        this.inProgressCallback = (OnBackPressedCallback)$this$lastOrNull$iv;
        if ($this$lastOrNull$iv != null) {
            $this$lastOrNull$iv.handleOnBackStarted(backEvent);
        }
    }

    private final void updateBackInvokedCallbackState(boolean shouldBeRegistered) {
        int i;
        boolean backInvokedCallbackRegistered;
        final OnBackInvokedDispatcher invokedDispatcher = this.invokedDispatcher;
        final OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (invokedDispatcher != null && onBackInvokedCallback != null) {
            if (onBackInvokedCallback != null) {
                i = 0;
                if (shouldBeRegistered && !this.backInvokedCallbackRegistered) {
                    if (!this.backInvokedCallbackRegistered) {
                        OnBackPressedDispatcher.Api33Impl.INSTANCE.registerOnBackInvokedCallback(invokedDispatcher, i, onBackInvokedCallback);
                        this.backInvokedCallbackRegistered = true;
                    } else {
                        if (!shouldBeRegistered && this.backInvokedCallbackRegistered) {
                            if (this.backInvokedCallbackRegistered) {
                                OnBackPressedDispatcher.Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(invokedDispatcher, onBackInvokedCallback);
                                this.backInvokedCallbackRegistered = i;
                            }
                        }
                    }
                } else {
                }
            }
        }
    }

    private final void updateEnabledCallbacks() {
        ArrayDeque onBackPressedCallbacks;
        int valueOf;
        boolean iterator;
        int i2;
        boolean next;
        boolean it;
        int i;
        onBackPressedCallbacks = this.onBackPressedCallbacks;
        valueOf = 0;
        i2 = 0;
        if (onBackPressedCallbacks instanceof Collection != null && (Collection)(Iterable)onBackPressedCallbacks.isEmpty()) {
            if ((Collection)onBackPressedCallbacks.isEmpty()) {
            } else {
                iterator = onBackPressedCallbacks.iterator();
                for (Object next : iterator) {
                    i = 0;
                }
            }
        } else {
        }
        this.hasEnabledCallbacks = i2;
        Consumer onHasEnabledCallbacksChanged = this.onHasEnabledCallbacksChanged;
        if (i2 != this.hasEnabledCallbacks && onHasEnabledCallbacksChanged != null) {
            onHasEnabledCallbacksChanged = this.onHasEnabledCallbacksChanged;
            if (onHasEnabledCallbacksChanged != null) {
                onHasEnabledCallbacksChanged.accept(Boolean.valueOf(i2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                updateBackInvokedCallbackState(i2);
            }
        }
    }

    public final void addCallback(androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    public final void addCallback(LifecycleOwner owner, androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
        }
        OnBackPressedDispatcher.LifecycleOnBackPressedCancellable lifecycleOnBackPressedCancellable = new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback);
        onBackPressedCallback.addCancellable((Cancellable)lifecycleOnBackPressedCancellable);
        updateEnabledCallbacks();
        OnBackPressedDispatcher.addCallback.1 anon = new OnBackPressedDispatcher.addCallback.1(this);
        onBackPressedCallback.setEnabledChangedCallback$activity_release((Function0)anon);
    }

    public final androidx.activity.Cancellable addCancellableCallback$activity_release(androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        OnBackPressedDispatcher.OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedDispatcher.OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable((Cancellable)onBackPressedCancellable);
        updateEnabledCallbacks();
        OnBackPressedDispatcher.addCancellableCallback.1 anon = new OnBackPressedDispatcher.addCancellableCallback.1(this);
        onBackPressedCallback.setEnabledChangedCallback$activity_release((Function0)anon);
        return (Cancellable)onBackPressedCancellable;
    }

    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    public final void dispatchOnBackProgressed(androidx.activity.BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        onBackProgressed(backEvent);
    }

    public final void dispatchOnBackStarted(androidx.activity.BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        onBackStarted(backEvent);
    }

    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    public final void onBackPressed() {
        Object $this$lastOrNull$iv;
        int i;
        ListIterator listIterator;
        Object element$iv;
        boolean it;
        int i2;
        int i3 = 0;
        if (this.inProgressCallback == null) {
            ArrayDeque onBackPressedCallbacks = this.onBackPressedCallbacks;
            i = 0;
            listIterator = onBackPressedCallbacks.listIterator((List)onBackPressedCallbacks.size());
            while (listIterator.hasPrevious()) {
                i2 = 0;
            }
            element$iv = i3;
            $this$lastOrNull$iv = element$iv;
        }
        this.inProgressCallback = i3;
        if ($this$lastOrNull$iv != null) {
            $this$lastOrNull$iv.handleOnBackPressed();
        }
        Runnable fallbackOnBackPressed = this.fallbackOnBackPressed;
        if (fallbackOnBackPressed != null) {
            fallbackOnBackPressed.run();
        }
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher invoker) {
        Intrinsics.checkNotNullParameter(invoker, "invoker");
        this.invokedDispatcher = invoker;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }
}
