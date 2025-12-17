package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.ui.R.id;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a0\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000fH\u0002¢\u0006\u0002\u0010\u0010\u001a,\u0010\u0011\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000fH\u0000¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "createSubcomposition", "Landroidx/compose/runtime/ReusableComposition;", "container", "Landroidx/compose/ui/node/LayoutNode;", "parent", "Landroidx/compose/runtime/CompositionContext;", "doSetContent", "Landroidx/compose/runtime/Composition;", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "setContent", "Landroidx/compose/ui/platform/AbstractComposeView;", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Wrapper_androidKt {

    private static final ViewGroup.LayoutParams DefaultLayoutParams;
    static {
        final int i = -2;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(i, i);
        Wrapper_androidKt.DefaultLayoutParams = layoutParams;
    }

    public static final ReusableComposition createSubcomposition(LayoutNode container, CompositionContext parent) {
        UiApplier uiApplier = new UiApplier(container);
        return CompositionKt.ReusableComposition((Applier)uiApplier, parent);
    }

    private static final Composition doSetContent(androidx.compose.ui.platform.AndroidComposeView owner, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        boolean debugInspectorInfoEnabled;
        java.util.Set setFromMap;
        int wrappedComposition2;
        boolean wrappedComposition;
        boolean effectCoroutineContext;
        int i;
        View view;
        int wrapped_composition_tag;
        if (InspectableValueKt.isDebugInspectorInfoEnabled() && owner.getTag(R.id.inspection_slot_table_set) == null) {
            if (owner.getTag(R.id.inspection_slot_table_set) == null) {
                WeakHashMap weakHashMap = new WeakHashMap();
                owner.setTag(R.id.inspection_slot_table_set, Collections.newSetFromMap((Map)weakHashMap));
            }
        }
        UiApplier uiApplier = new UiApplier(owner.getRoot());
        if (wrappedComposition2 instanceof WrappedComposition) {
        } else {
            wrappedComposition2 = 0;
        }
        if (wrappedComposition2 == 0) {
            wrappedComposition2 = new WrappedComposition(owner, CompositionKt.Composition((Applier)uiApplier, parent));
            i = 0;
            owner.getView().setTag(R.id.wrapped_composition_tag, wrappedComposition2);
        }
        wrappedComposition2.setContent(content);
        if (!Intrinsics.areEqual(owner.getCoroutineContext(), parent.getEffectCoroutineContext())) {
            owner.setCoroutineContext(parent.getEffectCoroutineContext());
        }
        return (Composition)wrappedComposition2;
    }

    public static final Composition setContent(androidx.compose.ui.platform.AbstractComposeView $this$setContent, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        int childCount;
        int androidComposeView;
        boolean z;
        View view;
        ViewGroup.LayoutParams defaultLayoutParams;
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        androidComposeView = 0;
        if ($this$setContent.getChildCount() > 0) {
            childCount = $this$setContent.getChildAt(0);
            if (childCount instanceof AndroidComposeView != null) {
                androidComposeView = childCount;
            }
        } else {
            $this$setContent.removeAllViews();
        }
        if (androidComposeView == null) {
            androidComposeView = new AndroidComposeView($this$setContent.getContext(), parent.getEffectCoroutineContext());
            z = 0;
            $this$setContent.addView(androidComposeView.getView(), Wrapper_androidKt.DefaultLayoutParams);
        }
        return Wrapper_androidKt.doSetContent(androidComposeView, parent, content);
    }
}
