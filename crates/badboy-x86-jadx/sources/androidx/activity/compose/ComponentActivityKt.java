package androidx.activity.compose;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a.\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0002\u0008\t¢\u0006\u0002\u0010\n\u001a\u000c\u0010\u000b\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"DefaultActivityContentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setContent", "", "Landroidx/activity/ComponentActivity;", "parent", "Landroidx/compose/runtime/CompositionContext;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/activity/ComponentActivity;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setOwners", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComponentActivityKt {

    private static final ViewGroup.LayoutParams DefaultActivityContentLayoutParams;
    static {
        final int i = -2;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(i, i);
        ComponentActivityKt.DefaultActivityContentLayoutParams = layoutParams;
    }

    public static final void setContent(ComponentActivity $this$setContent, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        View childAt;
        int i5;
        ComposeView view;
        ComposeView composeView;
        ViewGroup.LayoutParams defaultActivityContentLayoutParams;
        int i;
        int i2;
        int i3;
        int i4;
        if (childAt instanceof ComposeView != null) {
        } else {
            childAt = 0;
        }
        if (childAt != null) {
            i5 = childAt;
            view = 0;
            i5.setParentCompositionContext(parent);
            i5.setContent(content);
        } else {
            composeView = new ComposeView((Context)$this$setContent, 0, 0, 6, 0);
            i5 = 0;
            composeView.setParentCompositionContext(parent);
            composeView.setContent(content);
            ComponentActivityKt.setOwners($this$setContent);
            $this$setContent.setContentView((View)composeView, ComponentActivityKt.DefaultActivityContentLayoutParams);
        }
    }

    public static void setContent$default(ComponentActivity componentActivity, CompositionContext compositionContext2, Function2 function23, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        ComponentActivityKt.setContent(componentActivity, obj1, function23);
    }

    private static final void setOwners(ComponentActivity $this$setOwners) {
        androidx.lifecycle.LifecycleOwner lifecycleOwner;
        androidx.lifecycle.ViewModelStoreOwner view;
        androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner;
        View decorView = $this$setOwners.getWindow().getDecorView();
        if (ViewTreeLifecycleOwner.get(decorView) == null) {
            ViewTreeLifecycleOwner.set(decorView, (LifecycleOwner)$this$setOwners);
        }
        if (ViewTreeViewModelStoreOwner.get(decorView) == null) {
            ViewTreeViewModelStoreOwner.set(decorView, (ViewModelStoreOwner)$this$setOwners);
        }
        if (ViewTreeSavedStateRegistryOwner.get(decorView) == null) {
            ViewTreeSavedStateRegistryOwner.set(decorView, (SavedStateRegistryOwner)$this$setOwners);
        }
    }
}
