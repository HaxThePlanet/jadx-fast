package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0005¨\u0006\u000c", d2 = {"Landroidx/compose/ui/focus/FocusRequesterNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/ui/focus/FocusRequester;)V", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "onAttach", "", "onDetach", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusRequesterNode extends Modifier.Node implements androidx.compose.ui.focus.FocusRequesterModifierNode {

    private androidx.compose.ui.focus.FocusRequester focusRequester;
    public FocusRequesterNode(androidx.compose.ui.focus.FocusRequester focusRequester) {
        super();
        this.focusRequester = focusRequester;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.ui.focus.FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        super.onAttach();
        final int i = 0;
        this.focusRequester.getFocusRequesterNodes$ui_release().add(this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        final int i = 0;
        this.focusRequester.getFocusRequesterNodes$ui_release().remove(this);
        super.onDetach();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFocusRequester(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.focusRequester = <set-?>;
    }
}
