package androidx.compose.ui.tooling;

import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRect.Companion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\u001a.\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0008\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u001a2\u0010\u0006\u001a\u00020\u0007*\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0014\u0008\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¨\u0006\n", d2 = {"filterTree", "", "Landroidx/compose/ui/tooling/ViewInfo;", "filter", "Lkotlin/Function1;", "", "toDebugString", "", "indentation", "", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewInfoUtil_androidKt {
    private static final List<androidx.compose.ui.tooling.ViewInfo> filterTree(List<androidx.compose.ui.tooling.ViewInfo> $this$filterTree, Function1<? super androidx.compose.ui.tooling.ViewInfo, Boolean> filter) {
        Iterable list$iv$iv;
        List listOf;
        Object next;
        Object obj;
        int i3;
        List filterTree;
        int i2;
        ArrayList arrayList;
        List list;
        int i;
        Iterator iterator;
        boolean next2;
        Object $this$flatMap$iv;
        androidx.compose.ui.tooling.ViewInfo viewInfo;
        String fileName;
        int lineNumber;
        IntRect bounds;
        int location;
        ArrayList list2;
        int layoutInfo;
        final Function1 function1 = filter;
        final int i4 = 0;
        ArrayList arrayList2 = new ArrayList();
        final int i5 = 0;
        final Iterator iterator2 = (Iterable)$this$filterTree.iterator();
        for (Object next : iterator2) {
            obj = next;
            i3 = 0;
            i2 = 0;
            arrayList = new ArrayList();
            i = 0;
            iterator = (Iterable)ViewInfoUtil_androidKt.filterTree((ViewInfo)obj.getChildren(), function1).iterator();
            while (iterator.hasNext()) {
                Object obj2 = next2;
                viewInfo = 0;
                if ((ViewInfo)obj2.getLocation() == null) {
                } else {
                }
                fileName = CollectionsKt.listOf(obj2);
                CollectionsKt.addAll((Collection)arrayList, (Iterable)fileName);
                list$iv$iv = $this$flatMap$iv;
                fileName = obj2.getChildren();
            }
            list2 = $this$flatMap$iv2;
            if ((Boolean)function1.invoke(obj).booleanValue()) {
            } else {
            }
            viewInfo = new ViewInfo("<root>", -1, IntRect.Companion.getZero(), 0, list2, 0);
            listOf = CollectionsKt.listOf(viewInfo);
            CollectionsKt.addAll((Collection)arrayList2, (Iterable)listOf);
            list$iv$iv = $this$flatMap$iv;
            viewInfo = new ViewInfo(obj.getFileName(), obj.getLineNumber(), obj.getBounds(), obj.getLocation(), list2, obj.getLayoutInfo());
            listOf = CollectionsKt.listOf(viewInfo);
            obj2 = next2;
            viewInfo = 0;
            if ((ViewInfo)obj2.getLocation() == null) {
            } else {
            }
            fileName = CollectionsKt.listOf(obj2);
            CollectionsKt.addAll(arrayList, (Iterable)fileName);
            list$iv$iv = $this$flatMap$iv;
            fileName = obj2.getChildren();
        }
        Object $this$flatMap$iv5 = list$iv$iv;
        return (List)arrayList2;
    }

    static List filterTree$default(List list, Function1 function12, int i3, Object object4) {
        androidx.compose.ui.tooling.ViewInfoUtil_androidKt.filterTree.1 obj1;
        if (i3 &= 1 != 0) {
            obj1 = ViewInfoUtil_androidKt.filterTree.1.INSTANCE;
        }
        return ViewInfoUtil_androidKt.filterTree(list, obj1);
    }

    public static final String toDebugString(List<androidx.compose.ui.tooling.ViewInfo> $this$toDebugString, int indentation, Function1<? super androidx.compose.ui.tooling.ViewInfo, Boolean> filter) {
        int i3;
        Object append3;
        int i;
        StringBuilder append2;
        androidx.compose.ui.tooling.ViewInfoUtil_androidKt.toDebugString.4 iNSTANCE;
        androidx.compose.ui.tooling.ViewInfoUtil_androidKt.toDebugString.4 str;
        int i2;
        int append;
        int lineNumber;
        String str2;
        int i4;
        final int i5 = indentation;
        final Function1 function1 = filter;
        String repeat = StringsKt.repeat((CharSequence)".", i5);
        StringBuilder stringBuilder = new StringBuilder();
        Function1[] arr = new Function1[3];
        int i7 = 0;
        Iterator iterator = (Iterable)CollectionsKt.sortedWith((Iterable)ViewInfoUtil_androidKt.filterTree($this$toDebugString, function1), ComparisonsKt.compareBy(ViewInfoUtil_androidKt.toDebugString.2.INSTANCE, ViewInfoUtil_androidKt.toDebugString.3.INSTANCE, ViewInfoUtil_androidKt.toDebugString.4.INSTANCE)).iterator();
        while (iterator.hasNext()) {
            str = iNSTANCE;
            i2 = 0;
            str2 = "append('\\n')";
            i4 = 10;
            append3 = "append(value)";
            if ((ViewInfo)str.getLocation() != null) {
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            StringBuilder append11 = stringBuilder.append(stringBuilder2.append(repeat).append("|<root>").toString());
            Intrinsics.checkNotNullExpressionValue(append11, append3);
            Intrinsics.checkNotNullExpressionValue(append11.append(i4), str2);
            String string3 = StringsKt.trim((CharSequence)ViewInfoUtil_androidKt.toDebugString(str.getChildren(), i5 + 1, function1)).toString();
            if ((CharSequence)string3.length() > 0) {
            } else {
            }
            append = 0;
            if (append != 0) {
            }
            i3 = 0;
            i = 1;
            append = stringBuilder.append(string3);
            Intrinsics.checkNotNullExpressionValue(append, append3);
            Intrinsics.checkNotNullExpressionValue(append.append(i4), str2);
            append = 1;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder append8 = stringBuilder.append(stringBuilder3.append(repeat).append('|').append(str.getFileName()).append(':').append(str.getLineNumber()).toString());
            Intrinsics.checkNotNullExpressionValue(append8, append3);
            Intrinsics.checkNotNullExpressionValue(append8.append(i4), str2);
        }
        return stringBuilder.toString();
    }

    public static String toDebugString$default(List list, int i2, Function1 function13, int i4, Object object5) {
        int obj1;
        androidx.compose.ui.tooling.ViewInfoUtil_androidKt.toDebugString.1 obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = ViewInfoUtil_androidKt.toDebugString.1.INSTANCE;
        }
        return ViewInfoUtil_androidKt.toDebugString(list, obj1, obj2);
    }
}
