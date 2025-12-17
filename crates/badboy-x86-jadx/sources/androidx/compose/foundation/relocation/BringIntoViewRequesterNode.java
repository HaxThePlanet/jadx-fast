package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\t\u001a\u00020\nH\u0002J\u0008\u0010\u000b\u001a\u00020\nH\u0016J\u0008\u0010\u000c\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "Landroidx/compose/ui/Modifier$Node;", "requester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "disposeRequester", "", "onAttach", "onDetach", "updateRequester", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BringIntoViewRequesterNode extends Modifier.Node {

    public static final int $stable = 8;
    private androidx.compose.foundation.relocation.BringIntoViewRequester requester;
    private final boolean shouldAutoInvalidate;
    static {
        final int i = 8;
    }

    public BringIntoViewRequesterNode(androidx.compose.foundation.relocation.BringIntoViewRequester requester) {
        super();
        this.requester = requester;
    }

    private final void disposeRequester() {
        boolean modifiers;
        int i;
        if (requester instanceof BringIntoViewRequesterImpl) {
            androidx.compose.foundation.relocation.BringIntoViewRequester requester2 = this.requester;
            Intrinsics.checkNotNull(requester2, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            i = 0;
            (BringIntoViewRequesterImpl)requester2.getModifiers().remove(this);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        updateRequester(this.requester);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        disposeRequester();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void updateRequester(androidx.compose.foundation.relocation.BringIntoViewRequester requester) {
        boolean modifiers;
        int i;
        disposeRequester();
        if (requester instanceof BringIntoViewRequesterImpl) {
            i = 0;
            (BringIntoViewRequesterImpl)requester.getModifiers().add(this);
        }
        this.requester = requester;
    }
}
