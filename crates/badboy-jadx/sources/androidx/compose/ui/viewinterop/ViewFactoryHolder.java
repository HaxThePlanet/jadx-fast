package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistry.Entry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.ViewRootForInspector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\n\u0008\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004BI\u0008\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011BG\u0008\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0015J\u0008\u0010/\u001a\u00020\u0019H\u0002J\u0008\u00100\u001a\u00020\u0019H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R<\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u00082\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u0008@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR<\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u00082\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u0008@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u001c\"\u0004\u0008!\u0010\u001eR\"\u0010#\u001a\u0004\u0018\u00010\"2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\"@BX\u0082\u000e¢\u0006\u0008\n\u0000\"\u0004\u0008$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R<\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u00082\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u0008@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010\u001c\"\u0004\u0008+\u0010\u001eR\u0014\u0010,\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008-\u0010.¨\u00061", d2 = {"Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "T", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "context", "Landroid/content/Context;", "factory", "Lkotlin/Function1;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "saveStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "compositeKeyHash", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/saveable/SaveableStateRegistry;ILandroidx/compose/ui/node/Owner;)V", "typedView", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroid/view/View;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/runtime/saveable/SaveableStateRegistry;ILandroidx/compose/ui/node/Owner;)V", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "value", "", "releaseBlock", "getReleaseBlock", "()Lkotlin/jvm/functions/Function1;", "setReleaseBlock", "(Lkotlin/jvm/functions/Function1;)V", "resetBlock", "getResetBlock", "setResetBlock", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "savableRegistryEntry", "setSavableRegistryEntry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;)V", "saveStateKey", "", "Landroid/view/View;", "updateBlock", "getUpdateBlock", "setUpdateBlock", "viewRoot", "getViewRoot", "()Landroid/view/View;", "registerSaveStateProvider", "unregisterSaveStateProvider", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewFactoryHolder<T extends View>  extends androidx.compose.ui.viewinterop.AndroidViewHolder implements ViewRootForInspector {

    public static final int $stable = 8;
    private final int compositeKeyHash;
    private final NestedScrollDispatcher dispatcher;
    private Function1<? super T, Unit> releaseBlock;
    private Function1<? super T, Unit> resetBlock;
    private SaveableStateRegistry.Entry savableRegistryEntry;
    private final String saveStateKey;
    private final SaveableStateRegistry saveStateRegistry;
    private final T typedView;
    private Function1<? super T, Unit> updateBlock;
    static {
        final int i = 8;
    }

    private ViewFactoryHolder(Context context, CompositionContext parentContext, T typedView, NestedScrollDispatcher dispatcher, SaveableStateRegistry saveStateRegistry, int compositeKeyHash, Owner owner) {
        int obj8;
        int obj9;
        Object obj10;
        Object obj11;
        final Object obj = this;
        final View view = typedView;
        final NestedScrollDispatcher nestedScrollDispatcher = dispatcher;
        final int i = compositeKeyHash;
        super(context, parentContext, i, nestedScrollDispatcher, view, owner);
        obj.typedView = view;
        obj.dispatcher = nestedScrollDispatcher;
        obj.saveStateRegistry = saveStateRegistry;
        obj.compositeKeyHash = i;
        setClipChildren(false);
        obj.saveStateKey = String.valueOf(obj.compositeKeyHash);
        obj8 = obj.saveStateRegistry;
        if (obj8 != null) {
            obj8 = obj8.consumeRestored(obj.saveStateKey);
        } else {
            obj8 = obj9;
        }
        if (obj8 instanceof SparseArray != null) {
            obj9 = obj8;
        }
        if (obj9 != null) {
            obj10 = 0;
            obj.typedView.restoreHierarchyState(obj9);
        }
        registerSaveStateProvider();
        obj.updateBlock = AndroidView_androidKt.getNoOpUpdate();
        obj.resetBlock = AndroidView_androidKt.getNoOpUpdate();
        obj.releaseBlock = AndroidView_androidKt.getNoOpUpdate();
    }

    ViewFactoryHolder(Context context, CompositionContext compositionContext2, View view3, NestedScrollDispatcher nestedScrollDispatcher4, SaveableStateRegistry saveableStateRegistry5, int i6, Owner owner7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        int i;
        NestedScrollDispatcher nestedScrollDispatcher;
        int obj10;
        NestedScrollDispatcher obj12;
        i = i8 & 2 != 0 ? obj10 : compositionContext2;
        if (i8 & 8 != 0) {
            obj12 = new NestedScrollDispatcher();
            nestedScrollDispatcher = obj12;
        } else {
            nestedScrollDispatcher = nestedScrollDispatcher4;
        }
        super(context, i, view3, nestedScrollDispatcher, saveableStateRegistry5, i6, owner7);
    }

    public ViewFactoryHolder(Context context, Function1<? super Context, ? extends T> factory, CompositionContext parentContext, SaveableStateRegistry saveStateRegistry, int compositeKeyHash, Owner owner) {
        super(context, parentContext, (View)factory.invoke(context), 0, saveStateRegistry, compositeKeyHash, owner, 8, 0);
    }

    public ViewFactoryHolder(Context context, Function1 function12, CompositionContext compositionContext3, SaveableStateRegistry saveableStateRegistry4, int i5, Owner owner6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int i;
        int obj10;
        i = i7 &= 4 != 0 ? obj10 : compositionContext3;
        super(context, function12, i, saveableStateRegistry4, i5, owner6);
    }

    public static final View access$getTypedView$p(androidx.compose.ui.viewinterop.ViewFactoryHolder $this) {
        return $this.typedView;
    }

    public static final void access$unregisterSaveStateProvider(androidx.compose.ui.viewinterop.ViewFactoryHolder $this) {
        $this.unregisterSaveStateProvider();
    }

    private final void registerSaveStateProvider() {
        Object saveStateRegistry;
        String saveStateKey;
        androidx.compose.ui.viewinterop.ViewFactoryHolder.registerSaveStateProvider.1 anon;
        if (this.saveStateRegistry != null) {
            anon = new ViewFactoryHolder.registerSaveStateProvider.1(this);
            setSavableRegistryEntry(this.saveStateRegistry.registerProvider(this.saveStateKey, (Function0)anon));
        }
    }

    private final void setSavableRegistryEntry(SaveableStateRegistry.Entry value) {
        final SaveableStateRegistry.Entry savableRegistryEntry = this.savableRegistryEntry;
        if (savableRegistryEntry != null) {
            savableRegistryEntry.unregister();
        }
        this.savableRegistryEntry = value;
    }

    private final void unregisterSaveStateProvider() {
        setSavableRegistryEntry(0);
    }

    @Override // androidx.compose.ui.viewinterop.AndroidViewHolder
    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Function1<T, Unit> getReleaseBlock() {
        return this.releaseBlock;
    }

    public final Function1<T, Unit> getResetBlock() {
        return this.resetBlock;
    }

    public final Function1<T, Unit> getUpdateBlock() {
        return this.updateBlock;
    }

    @Override // androidx.compose.ui.viewinterop.AndroidViewHolder
    public View getViewRoot() {
        return (View)this;
    }

    public final void setReleaseBlock(Function1<? super T, Unit> value) {
        this.releaseBlock = value;
        ViewFactoryHolder.releaseBlock.1 anon = new ViewFactoryHolder.releaseBlock.1(this);
        setRelease((Function0)anon);
    }

    public final void setResetBlock(Function1<? super T, Unit> value) {
        this.resetBlock = value;
        ViewFactoryHolder.resetBlock.1 anon = new ViewFactoryHolder.resetBlock.1(this);
        setReset((Function0)anon);
    }

    public final void setUpdateBlock(Function1<? super T, Unit> value) {
        this.updateBlock = value;
        ViewFactoryHolder.updateBlock.1 anon = new ViewFactoryHolder.updateBlock.1(this);
        setUpdate((Function0)anon);
    }
}
