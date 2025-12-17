package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0017\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0080\u0008\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\rJ\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0001HÆ\u0003JO\u0010!\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010%\u001a\u00020#J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0008\u0010'\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006(", d2 = {"Landroidx/compose/ui/tooling/ViewInfo;", "", "fileName", "", "lineNumber", "", "bounds", "Landroidx/compose/ui/unit/IntRect;", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "children", "", "layoutInfo", "(Ljava/lang/String;ILandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/tooling/data/SourceLocation;Ljava/util/List;Ljava/lang/Object;)V", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "getChildren", "()Ljava/util/List;", "getFileName", "()Ljava/lang/String;", "getLayoutInfo", "()Ljava/lang/Object;", "getLineNumber", "()I", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "allChildren", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hasBounds", "hashCode", "toString", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewInfo {

    public static final int $stable = 8;
    private final IntRect bounds;
    private final List<androidx.compose.ui.tooling.ViewInfo> children;
    private final String fileName;
    private final Object layoutInfo;
    private final int lineNumber;
    private final SourceLocation location;
    static {
        final int i = 8;
    }

    public ViewInfo(String fileName, int lineNumber, IntRect bounds, SourceLocation location, List<androidx.compose.ui.tooling.ViewInfo> children, Object layoutInfo) {
        super();
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.bounds = bounds;
        this.location = location;
        this.children = children;
        this.layoutInfo = layoutInfo;
    }

    public static androidx.compose.ui.tooling.ViewInfo copy$default(androidx.compose.ui.tooling.ViewInfo viewInfo, String string2, int i3, IntRect intRect4, SourceLocation sourceLocation5, List list6, Object object7, int i8, Object object9) {
        String obj1;
        int obj2;
        IntRect obj3;
        SourceLocation obj4;
        List obj5;
        Object obj6;
        if (i8 & 1 != 0) {
            obj1 = viewInfo.fileName;
        }
        if (i8 & 2 != 0) {
            obj2 = viewInfo.lineNumber;
        }
        if (i8 & 4 != 0) {
            obj3 = viewInfo.bounds;
        }
        if (i8 & 8 != 0) {
            obj4 = viewInfo.location;
        }
        if (i8 & 16 != 0) {
            obj5 = viewInfo.children;
        }
        if (i8 &= 32 != 0) {
            obj6 = viewInfo.layoutInfo;
        }
        return viewInfo.copy(obj1, obj2, obj3, obj4, obj5, obj6);
    }

    public final List<androidx.compose.ui.tooling.ViewInfo> allChildren() {
        Object next;
        List it;
        int i;
        final int i2 = 0;
        ArrayList arrayList = new ArrayList();
        final int i3 = 0;
        final Iterator iterator = (Iterable)this.children.iterator();
        for (Object next : iterator) {
            i = 0;
            CollectionsKt.addAll((Collection)arrayList, (Iterable)(ViewInfo)next.allChildren());
        }
        return CollectionsKt.plus((Collection)this.children, (Iterable)(List)arrayList);
    }

    public final String component1() {
        return this.fileName;
    }

    public final int component2() {
        return this.lineNumber;
    }

    public final IntRect component3() {
        return this.bounds;
    }

    public final SourceLocation component4() {
        return this.location;
    }

    public final List<androidx.compose.ui.tooling.ViewInfo> component5() {
        return this.children;
    }

    public final Object component6() {
        return this.layoutInfo;
    }

    public final androidx.compose.ui.tooling.ViewInfo copy(String string, int i2, IntRect intRect3, SourceLocation sourceLocation4, List<androidx.compose.ui.tooling.ViewInfo> list5, Object object6) {
        ViewInfo viewInfo = new ViewInfo(string, i2, intRect3, sourceLocation4, list5, object6);
        return viewInfo;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ViewInfo) {
            return i2;
        }
        Object obj = object;
        if (Intrinsics.areEqual(this.fileName, obj.fileName) == null) {
            return i2;
        }
        if (this.lineNumber != obj.lineNumber) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.bounds, obj.bounds)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.location, obj.location)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.children, obj.children)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.layoutInfo, obj.layoutInfo)) {
            return i2;
        }
        return i;
    }

    public final IntRect getBounds() {
        return this.bounds;
    }

    public final List<androidx.compose.ui.tooling.ViewInfo> getChildren() {
        return this.children;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Object getLayoutInfo() {
        return this.layoutInfo;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final SourceLocation getLocation() {
        return this.location;
    }

    public final boolean hasBounds() {
        int bottom;
        int i;
        if (this.bounds.getBottom() != 0 && this.bounds.getRight() != 0) {
            i = this.bounds.getRight() != 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public int hashCode() {
        int i2;
        Object layoutInfo;
        int i;
        if (this.location == null) {
            i2 = i;
        } else {
            i2 = this.location.hashCode();
        }
        if (this.layoutInfo == null) {
        } else {
            i = this.layoutInfo.hashCode();
        }
        return i12 += i;
    }

    public String toString() {
        String string;
        int i;
        int length;
        StringBuilder stringBuilder = new StringBuilder();
        string = 40;
        SourceLocation location = this.location;
        if (location != null) {
            i = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            if (stringBuilder2.append(string).append(location.getOffset()).append('L').append(location.getLength()).toString() == null) {
                string = "<none>";
            }
        } else {
        }
        int i5 = 0;
        return StringsKt.trimMargin$default(stringBuilder.append(string).append(this.fileName).append(':').append(this.lineNumber).append(",\n            |bounds=(top=").append(this.bounds.getTop()).append(", left=").append(this.bounds.getLeft()).append(",\n            |location=").append(string).append("\n            |bottom=").append(this.bounds.getBottom()).append(", right=").append(this.bounds.getRight()).append("),\n            |childrenCount=").append(this.children.size()).append(')').toString(), i5, 1, i5);
    }
}
