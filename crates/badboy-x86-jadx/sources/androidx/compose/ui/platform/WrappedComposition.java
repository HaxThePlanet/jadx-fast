package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionServiceKey;
import androidx.compose.runtime.CompositionServices;
import androidx.compose.ui.R.id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0019\u001a\u00020\u0012H\u0016J#\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\u0008\u0000\u0010\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0008\u0013H\u0016¢\u0006\u0002\u0010&R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000eR\u001b\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0008\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006'", d2 = {"Landroidx/compose/ui/platform/WrappedComposition;", "Landroidx/compose/runtime/Composition;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/compose/runtime/CompositionServices;", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "original", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/Composition;)V", "addedToLifecycle", "Landroidx/lifecycle/Lifecycle;", "disposed", "", "hasInvalidations", "getHasInvalidations", "()Z", "isDisposed", "lastContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "getOriginal", "()Landroidx/compose/runtime/Composition;", "getOwner", "()Landroidx/compose/ui/platform/AndroidComposeView;", "dispose", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "setContent", "content", "(Lkotlin/jvm/functions/Function2;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class WrappedComposition implements Composition, LifecycleEventObserver, CompositionServices {

    private Lifecycle addedToLifecycle;
    private boolean disposed;
    private Function2<? super Composer, ? super Integer, Unit> lastContent;
    private final Composition original;
    private final androidx.compose.ui.platform.AndroidComposeView owner;
    public WrappedComposition(androidx.compose.ui.platform.AndroidComposeView owner, Composition original) {
        super();
        this.owner = owner;
        this.original = original;
        this.lastContent = ComposableSingletons.Wrapper_androidKt.INSTANCE.getLambda-1$ui_release();
    }

    public static final Lifecycle access$getAddedToLifecycle$p(androidx.compose.ui.platform.WrappedComposition $this) {
        return $this.addedToLifecycle;
    }

    public static final boolean access$getDisposed$p(androidx.compose.ui.platform.WrappedComposition $this) {
        return $this.disposed;
    }

    public static final void access$setAddedToLifecycle$p(androidx.compose.ui.platform.WrappedComposition $this, Lifecycle <set-?>) {
        $this.addedToLifecycle = <set-?>;
    }

    public static final void access$setLastContent$p(androidx.compose.ui.platform.WrappedComposition $this, Function2 <set-?>) {
        $this.lastContent = <set-?>;
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        boolean addedToLifecycle;
        int wrapped_composition_tag;
        int i;
        this.disposed = true;
        this.owner.getView().setTag(R.id.wrapped_composition_tag, 0);
        addedToLifecycle = this.addedToLifecycle;
        if (!this.disposed && addedToLifecycle != null) {
            this.disposed = true;
            this.owner.getView().setTag(R.id.wrapped_composition_tag, 0);
            addedToLifecycle = this.addedToLifecycle;
            if (addedToLifecycle != null) {
                addedToLifecycle.removeObserver((LifecycleObserver)this);
            }
        }
        this.original.dispose();
    }

    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        Composition original;
        int compositionService;
        if (original instanceof CompositionServices) {
        } else {
            original = compositionService;
        }
        if (original != null) {
            compositionService = original.getCompositionService(key);
        }
        return compositionService;
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        return this.original.getHasInvalidations();
    }

    @Override // androidx.compose.runtime.Composition
    public final Composition getOriginal() {
        return this.original;
    }

    @Override // androidx.compose.runtime.Composition
    public final androidx.compose.ui.platform.AndroidComposeView getOwner() {
        return this.owner;
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.original.isDisposed();
    }

    @Override // androidx.compose.runtime.Composition
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Lifecycle.Event lastContent;
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event == Lifecycle.Event.ON_CREATE && !this.disposed) {
                if (!this.disposed) {
                    setContent(this.lastContent);
                }
            }
        }
    }

    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        WrappedComposition.setContent.1 anon = new WrappedComposition.setContent.1(this, content);
        this.owner.setOnViewTreeOwnersAvailable((Function1)anon);
    }
}
