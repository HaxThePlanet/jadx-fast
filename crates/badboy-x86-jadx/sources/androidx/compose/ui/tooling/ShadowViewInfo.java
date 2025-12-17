package androidx.compose.ui.tooling;

import androidx.compose.ui.layout.LayoutInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0008\u0002\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0000J\u0006\u0010\u001c\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00000\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Landroidx/compose/ui/tooling/ShadowViewInfo;", "", "viewInfo", "Landroidx/compose/ui/tooling/ViewInfo;", "(Landroidx/compose/ui/tooling/ViewInfo;)V", "parent", "(Landroidx/compose/ui/tooling/ShadowViewInfo;Landroidx/compose/ui/tooling/ViewInfo;)V", "_children", "", "allNodes", "Lkotlin/sequences/Sequence;", "getAllNodes", "()Lkotlin/sequences/Sequence;", "children", "", "getChildren", "()Ljava/util/List;", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "getParent", "()Landroidx/compose/ui/tooling/ShadowViewInfo;", "setParent", "(Landroidx/compose/ui/tooling/ShadowViewInfo;)V", "findRoot", "setNewParent", "", "toViewInfo", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ShadowViewInfo {

    private final List<androidx.compose.ui.tooling.ShadowViewInfo> _children;
    private final Sequence<androidx.compose.ui.tooling.ShadowViewInfo> allNodes;
    private androidx.compose.ui.tooling.ShadowViewInfo parent;
    private final androidx.compose.ui.tooling.ViewInfo viewInfo;
    private ShadowViewInfo(androidx.compose.ui.tooling.ShadowViewInfo parent, androidx.compose.ui.tooling.ViewInfo viewInfo) {
        Object next;
        Object obj;
        int i;
        androidx.compose.ui.tooling.ShadowViewInfo shadowViewInfo;
        super();
        this.parent = parent;
        this.viewInfo = viewInfo;
        List children = this.viewInfo.getChildren();
        int i2 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)children, 10));
        final int i5 = 0;
        final Iterator iterator = children.iterator();
        for (Object next : iterator) {
            i = 0;
            shadowViewInfo = new ShadowViewInfo(this, (ViewInfo)next);
            (Collection)arrayList.add(shadowViewInfo);
        }
        this._children = CollectionsKt.toMutableList((Collection)(List)arrayList);
        ShadowViewInfo.allNodes.1 anon = new ShadowViewInfo.allNodes.1(this, 0);
        this.allNodes = SequencesKt.sequence((Function2)anon);
    }

    public ShadowViewInfo(androidx.compose.ui.tooling.ViewInfo viewInfo) {
        super(0, viewInfo);
    }

    public final androidx.compose.ui.tooling.ShadowViewInfo findRoot() {
        Object root;
        if (this.parent == null) {
            root = this;
        } else {
            androidx.compose.ui.tooling.ShadowViewInfo parent2 = this.parent;
            Intrinsics.checkNotNull(parent2);
            root = parent2.findRoot();
        }
        return root;
    }

    public final Sequence<androidx.compose.ui.tooling.ShadowViewInfo> getAllNodes() {
        return this.allNodes;
    }

    public final List<androidx.compose.ui.tooling.ShadowViewInfo> getChildren() {
        return this._children;
    }

    public final LayoutInfo getLayoutInfo() {
        Object layoutInfo;
        if (layoutInfo instanceof LayoutInfo) {
        } else {
            layoutInfo = 0;
        }
        return layoutInfo;
    }

    public final androidx.compose.ui.tooling.ShadowViewInfo getParent() {
        return this.parent;
    }

    public final void setNewParent(androidx.compose.ui.tooling.ShadowViewInfo parent) {
        Object _children;
        _children = this.parent;
        _children = _children._children;
        if (_children != null && _children != null) {
            _children = _children._children;
            if (_children != null) {
                _children.remove(this);
            }
        }
        parent._children.add(this);
        this.parent = parent;
    }

    public final void setParent(androidx.compose.ui.tooling.ShadowViewInfo <set-?>) {
        this.parent = <set-?>;
    }

    public final androidx.compose.ui.tooling.ViewInfo toViewInfo() {
        Object next;
        androidx.compose.ui.tooling.ViewInfo it;
        int i;
        List _children = this._children;
        int i2 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)_children, 10));
        final int i4 = 0;
        final Iterator iterator = _children.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)arrayList.add((ShadowViewInfo)next.toViewInfo());
        }
        ViewInfo viewInfo5 = new ViewInfo(this.viewInfo.getFileName(), this.viewInfo.getLineNumber(), this.viewInfo.getBounds(), this.viewInfo.getLocation(), (List)arrayList, this.viewInfo.getLayoutInfo());
        return viewInfo5;
    }
}
