package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.node.RootForTest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008g\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0008\u0010\u000b\u001a\u00020\u000cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0008X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/node/RootForTest;", "hasPendingMeasureOrLayout", "", "getHasPendingMeasureOrLayout", "()Z", "isLifecycleInResumedState", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "invalidateDescendants", "", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewRootForTest extends RootForTest {

    public static final androidx.compose.ui.platform.ViewRootForTest.Companion Companion;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0007\u0010\u0002\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/ui/platform/ViewRootForTest$Companion;", "", "()V", "onViewCreatedCallback", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/ViewRootForTest;", "", "getOnViewCreatedCallback$annotations", "getOnViewCreatedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnViewCreatedCallback", "(Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.platform.ViewRootForTest.Companion $$INSTANCE;
        private static Function1<? super androidx.compose.ui.platform.ViewRootForTest, Unit> onViewCreatedCallback;
        static {
            ViewRootForTest.Companion companion = new ViewRootForTest.Companion();
            ViewRootForTest.Companion.$$INSTANCE = companion;
        }

        public static void getOnViewCreatedCallback$annotations() {
        }

        public final Function1<androidx.compose.ui.platform.ViewRootForTest, Unit> getOnViewCreatedCallback() {
            return ViewRootForTest.Companion.onViewCreatedCallback;
        }

        public final void setOnViewCreatedCallback(Function1<? super androidx.compose.ui.platform.ViewRootForTest, Unit> <set-?>) {
            ViewRootForTest.Companion.onViewCreatedCallback = <set-?>;
        }
    }
    static {
        ViewRootForTest.Companion = ViewRootForTest.Companion.$$INSTANCE;
    }

    @Override // androidx.compose.ui.node.RootForTest
    public abstract boolean getHasPendingMeasureOrLayout();

    @Override // androidx.compose.ui.node.RootForTest
    public abstract View getView();

    @Override // androidx.compose.ui.node.RootForTest
    public abstract void invalidateDescendants();

    @Override // androidx.compose.ui.node.RootForTest
    public abstract boolean isLifecycleInResumedState();
}
