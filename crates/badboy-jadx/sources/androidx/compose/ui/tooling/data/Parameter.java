package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/ui/tooling/data/Parameter;", "", "sortedIndex", "", "inlineClass", "", "(ILjava/lang/String;)V", "getInlineClass", "()Ljava/lang/String;", "getSortedIndex", "()I", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Parameter {

    private final String inlineClass;
    private final int sortedIndex;
    public Parameter(int sortedIndex, String inlineClass) {
        super();
        this.sortedIndex = sortedIndex;
        this.inlineClass = inlineClass;
    }

    public Parameter(int i, String string2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(i, obj2);
    }

    public final String getInlineClass() {
        return this.inlineClass;
    }

    public final int getSortedIndex() {
        return this.sortedIndex;
    }
}
