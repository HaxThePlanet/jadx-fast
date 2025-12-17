package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ4\u0010\u001d\u001a\u00020\u001e2\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bJ\u0008\u0010\u001f\u001a\u00020\u001eH\u0002J\u000c\u0010 \u001a\u00020\u001e*\u00020!H\u0016R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/CollectionInfo;", "indexForKeyMapping", "Lkotlin/Function1;", "", "", "isVertical", "()Z", "scrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "scrollToIndexAction", "shouldAutoInvalidate", "getShouldAutoInvalidate", "update", "", "updateCachedSemanticsValues", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyLayoutSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {

    private final Function1<Object, Integer> indexForKeyMapping;
    private Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProviderLambda;
    private Orientation orientation;
    private boolean reverseScrolling;
    private ScrollAxisRange scrollAxisRange;
    private Function1<? super Integer, Boolean> scrollToIndexAction;
    private androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState state;
    private boolean userScrollEnabled;
    public LazyLayoutSemanticsModifierNode(Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProviderLambda, androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState state, Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling) {
        super();
        this.itemProviderLambda = itemProviderLambda;
        this.state = state;
        this.orientation = orientation;
        this.userScrollEnabled = userScrollEnabled;
        this.reverseScrolling = reverseScrolling;
        LazyLayoutSemanticsModifierNode.indexForKeyMapping.1 anon = new LazyLayoutSemanticsModifierNode.indexForKeyMapping.1(this);
        this.indexForKeyMapping = (Function1)anon;
        updateCachedSemanticsValues();
    }

    public static final Function0 access$getItemProviderLambda$p(androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode $this) {
        return $this.itemProviderLambda;
    }

    public static final androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState access$getState$p(androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode $this) {
        return $this.state;
    }

    private final CollectionInfo getCollectionInfo() {
        return this.state.collectionInfo();
    }

    private final boolean isVertical() {
        int i;
        i = this.orientation == Orientation.Vertical ? 1 : 0;
        return i;
    }

    private final void updateCachedSemanticsValues() {
        androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.3 anon;
        LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.1 anon2 = new LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.1(this);
        LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.2 anon3 = new LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.2(this);
        ScrollAxisRange scrollAxisRange = new ScrollAxisRange((Function0)anon2, (Function0)anon3, this.reverseScrolling);
        this.scrollAxisRange = scrollAxisRange;
        if (this.userScrollEnabled) {
            anon = new LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.3(this);
        } else {
            anon = 0;
        }
        this.scrollToIndexAction = anon;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        ScrollAxisRange scrollAxisRange;
        String str;
        int i = 1;
        SemanticsPropertiesKt.setTraversalGroup($this$applySemantics, i);
        SemanticsPropertiesKt.indexForKey($this$applySemantics, this.indexForKeyMapping);
        str = "scrollAxisRange";
        final int i2 = 0;
        if (isVertical()) {
            if (this.scrollAxisRange == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                scrollAxisRange = i2;
            }
            SemanticsPropertiesKt.setVerticalScrollAxisRange($this$applySemantics, scrollAxisRange);
        } else {
            if (this.scrollAxisRange == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                scrollAxisRange = i2;
            }
            SemanticsPropertiesKt.setHorizontalScrollAxisRange($this$applySemantics, scrollAxisRange);
        }
        Function1 scrollToIndexAction = this.scrollToIndexAction;
        if (scrollToIndexAction != null) {
            str = 0;
            SemanticsPropertiesKt.scrollToIndex$default($this$applySemantics, i2, scrollToIndexAction, i, i2);
        }
        LazyLayoutSemanticsModifierNode.applySemantics.2 anon = new LazyLayoutSemanticsModifierNode.applySemantics.2(this);
        SemanticsPropertiesKt.getScrollViewportLength$default($this$applySemantics, i2, (Function0)anon, i, i2);
        SemanticsPropertiesKt.setCollectionInfo($this$applySemantics, getCollectionInfo());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public final void update(Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProviderLambda, androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState state, Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling) {
        Object orientation2;
        boolean userScrollEnabled2;
        this.itemProviderLambda = itemProviderLambda;
        this.state = state;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        }
        if (this.userScrollEnabled == userScrollEnabled) {
            if (this.reverseScrolling != reverseScrolling) {
                this.userScrollEnabled = userScrollEnabled;
                this.reverseScrolling = reverseScrolling;
                updateCachedSemanticsValues();
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
            }
        } else {
        }
    }
}
