package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a4\u0010\u0000\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007", d2 = {"getLocalPlaceholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "start", "", "end", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MultiParagraphIntrinsicsKt {
    public static final List access$getLocalPlaceholders(List $receiver, int start, int end) {
        return MultiParagraphIntrinsicsKt.getLocalPlaceholders($receiver, start, end);
    }

    private static final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> getLocalPlaceholders(List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> $this$getLocalPlaceholders, int start, int end) {
        int i;
        int i2;
        ArrayList $this$fastFilter$iv;
        int index$iv$iv2;
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i3;
        boolean it;
        int i4;
        int start2;
        int range;
        int i5;
        int start3;
        int end2;
        ArrayList list;
        Object obj3 = $this$getLocalPlaceholders;
        int i8 = 0;
        ArrayList arrayList = new ArrayList(obj3.size());
        Object obj4 = obj3;
        int i10 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < obj4.size()) {
            obj = obj2;
            i3 = 0;
            Object obj5 = obj;
            i4 = 0;
            if (AnnotatedStringKt.intersect(start, end, (AnnotatedString.Range)obj5.getStart(), obj5.getEnd())) {
            }
            index$iv$iv2++;
            (Collection)arrayList.add(obj);
        }
        $this$fastFilter$iv = arrayList;
        int i9 = 0;
        ArrayList arrayList2 = new ArrayList((List)$this$fastFilter$iv.size());
        ArrayList list3 = $this$fastFilter$iv;
        int i11 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list3.size()) {
            i3 = 0;
            i4 = obj;
            start2 = 0;
            if (i <= (AnnotatedString.Range)i4.getStart() && i4.getEnd() <= i2) {
            } else {
            }
            i5 = 0;
            range = new AnnotatedString.Range(i4.getItem(), start4 - start, end2 - start);
            (Collection)arrayList2.add(range);
            index$iv$iv++;
            i = start;
            i2 = end;
            $this$fastFilter$iv = list;
            if (i4.getEnd() <= i2) {
            } else {
            }
            i5 = 1;
        }
        return (List)arrayList2;
    }
}
