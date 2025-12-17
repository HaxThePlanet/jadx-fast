package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0008\u0003\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002BC\u0012&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0008¢\u0006\u0002\u0010\u000bJ\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\tH\u0002J$\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00152\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00028\u000000J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u0015H\u0002J\u0008\u00104\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020\u0005H\u0002R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u001a\u0010#\u001a\u0008\u0012\u0004\u0012\u00020$0\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0014\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00050(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067", d2 = {"Landroidx/compose/ui/tooling/data/CompositionCallStack;", "T", "Landroidx/compose/ui/tooling/data/SourceContext;", "factory", "Lkotlin/Function3;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "contexts", "", "", "", "(Lkotlin/jvm/functions/Function3;Ljava/util/Map;)V", "<set-?>", "Landroidx/compose/ui/unit/IntRect;", "bounds", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "current", "getCurrent", "()Landroidx/compose/runtime/tooling/CompositionGroup;", "currentCallIndex", "", "depth", "getDepth", "()I", "isInline", "", "()Z", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "name", "getName", "()Ljava/lang/String;", "parameters", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "getParameters", "()Ljava/util/List;", "stack", "Lkotlin/collections/ArrayDeque;", "contextOf", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", "information", "convert", "group", "callIndex", "out", "", "isCall", "parentGroup", "parentDepth", "pop", "push", "", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CompositionCallStack<T>  implements androidx.compose.ui.tooling.data.SourceContext {

    private IntRect bounds;
    private final Map<String, Object> contexts;
    private int currentCallIndex;
    private final Function3<CompositionGroup, androidx.compose.ui.tooling.data.SourceContext, List<? extends T>, T> factory;
    private final ArrayDeque<CompositionGroup> stack;
    public CompositionCallStack(Function3<? super CompositionGroup, ? super androidx.compose.ui.tooling.data.SourceContext, ? super List<? extends T>, ? extends T> factory, Map<String, Object> contexts) {
        super();
        this.factory = factory;
        this.contexts = contexts;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.stack = arrayDeque;
        this.bounds = SlotTreeKt.getEmptyBox();
    }

    private final androidx.compose.ui.tooling.data.SourceInformationContext contextOf(String information) {
        int i2;
        Object sourceInformationContextOf$default;
        int i;
        Map contexts = this.contexts;
        final int i3 = 0;
        final Object obj = contexts.get(information);
        i2 = 0;
        if (obj == null) {
            int i4 = 0;
            contexts.put(information, SlotTreeKt.sourceInformationContextOf$default(information, i2, 2, i2));
        } else {
            sourceInformationContextOf$default = obj;
        }
        if (sourceInformationContextOf$default instanceof SourceInformationContext != null) {
            i2 = sourceInformationContextOf$default;
        }
        return i2;
    }

    private final CompositionGroup getCurrent() {
        return (CompositionGroup)this.stack.last();
    }

    private final boolean isCall(CompositionGroup group) {
        int startsWith$default;
        int i;
        int i2;
        String str;
        final String sourceInfo = group.getSourceInfo();
        if (sourceInfo != null) {
            startsWith$default = StringsKt.startsWith$default(sourceInfo, "C", false, 2, 0);
        }
        return startsWith$default;
    }

    private final CompositionGroup parentGroup(int parentDepth) {
        Object obj;
        int i;
        if (this.stack.size() > parentDepth) {
            obj = this.stack.get(i2--);
        } else {
            obj = 0;
        }
        return obj;
    }

    private final CompositionGroup pop() {
        return (CompositionGroup)this.stack.removeLast();
    }

    private final void push(CompositionGroup group) {
        this.stack.addLast(group);
    }

    public final IntRect convert(CompositionGroup group, int callIndex, List<T> out) {
        IntRect box;
        int childCallIndex;
        int it;
        boolean z;
        Object next;
        Object obj;
        int i;
        boolean call;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        box = SlotTreeKt.getEmptyBox();
        push(group);
        childCallIndex = 0;
        int i3 = 0;
        final Iterator iterator = group.getCompositionGroups().iterator();
        while (iterator.hasNext()) {
            obj = next;
            i = 0;
            box = SlotTreeKt.union(box, convert((CompositionGroup)obj, childCallIndex, (List)arrayList));
            if (isCall(obj)) {
            }
            childCallIndex++;
        }
        if (it instanceof LayoutInfo) {
        } else {
            it = 0;
        }
        if (it != 0) {
            z = 0;
            if (SlotTreeKt.access$boundsOfLayoutNode(it) == null) {
                it = box;
            }
        } else {
        }
        this.currentCallIndex = callIndex;
        this.bounds = it;
        Object invoke = this.factory.invoke(group, this, arrayList);
        if (invoke != null) {
            z = 0;
            out.add(invoke);
        }
        pop();
        return it;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public IntRect getBounds() {
        return this.bounds;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public int getDepth() {
        return this.stack.size();
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public androidx.compose.ui.tooling.data.SourceLocation getLocation() {
        Object it2;
        androidx.compose.ui.tooling.data.SourceInformationContext parentContext;
        int i2;
        int i3;
        androidx.compose.ui.tooling.data.SourceInformationContext it;
        Object parentGroup;
        int i4;
        String sourceFile;
        int i;
        it2 = parentGroup(1);
        int i6 = 0;
        it2 = it2.getSourceInfo();
        if (it2 != null && it2 != null) {
            it2 = it2.getSourceInfo();
            if (it2 != null) {
                i2 = 0;
                it2 = contextOf(it2);
                if (it2 == null) {
                } else {
                    parentContext = it2;
                    i3 = 2;
                    while (i3 < this.stack.size()) {
                        if (parentContext != null) {
                        } else {
                        }
                        sourceFile = i6;
                        if (sourceFile == null) {
                        }
                        parentGroup = parentGroup(i3);
                        parentGroup = parentGroup.getSourceInfo();
                        if (parentGroup != null && parentGroup != null) {
                        } else {
                        }
                        it = i6;
                        parentContext = it;
                        i3 = i4;
                        parentGroup = parentGroup.getSourceInfo();
                        if (parentGroup != null) {
                        } else {
                        }
                        i = 0;
                        it = contextOf(parentGroup);
                        sourceFile = parentContext.getSourceFile();
                    }
                }
                return it2.sourceLocation(this.currentCallIndex, parentContext);
            }
        }
        return i6;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public String getName() {
        int substring;
        int i;
        int str;
        String sourceInfo = getCurrent().getSourceInfo();
        substring = 0;
        if (sourceInfo == null) {
            return substring;
        }
        int i2 = 0;
        str = 2;
        if (StringsKt.startsWith$default(sourceInfo, "CC(", i2, str, substring)) {
            i = 3;
            int indexOf$default = StringsKt.indexOf$default((CharSequence)sourceInfo, ')', 0, false, 6, 0);
            if (indexOf$default > str) {
                Intrinsics.checkNotNullExpressionValue(sourceInfo.substring(i, indexOf$default), "this as java.lang.String…ing(startIndex, endIndex)");
            }
            return substring;
        } else {
            if (StringsKt.startsWith$default(sourceInfo, "C(", i2, str, substring)) {
                i = str;
            }
        }
        return substring;
    }

    public List<androidx.compose.ui.tooling.data.ParameterInformation> getParameters() {
        Object it;
        int i;
        final CompositionGroup current = getCurrent();
        it = current.getSourceInfo();
        i = 0;
        it = contextOf(it);
        if (it != null && it == null) {
            i = 0;
            it = contextOf(it);
            if (it == null) {
            }
            ArrayList arrayList = new ArrayList();
            CollectionsKt.addAll((Collection)(List)arrayList, current.getData());
            return SlotTreeKt.access$extractParameterInfo(arrayList, it);
        }
        return CollectionsKt.emptyList();
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public boolean isInline() {
        String startsWith$default;
        int i2;
        int i3;
        int i;
        String str;
        startsWith$default = getCurrent().getSourceInfo();
        i3 = 1;
        if (startsWith$default != null && StringsKt.startsWith$default(startsWith$default, "CC", false, 2, 0) == i3) {
            i3 = 1;
            if (StringsKt.startsWith$default(startsWith$default, "CC", i2, 2, 0) == i3) {
                i2 = i3;
            }
        }
        return i2;
    }
}
