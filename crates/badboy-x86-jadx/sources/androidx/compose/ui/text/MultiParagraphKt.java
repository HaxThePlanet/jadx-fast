package androidx.compose.ui.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0008\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a<\u0010\u000b\u001a\u00020\u000c2\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000c0\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a-\u0010\u0013\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0014*\u0008\u0012\u0004\u0012\u0002H\u00140\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00010\u0010H\u0082\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"findParagraphByIndex", "", "paragraphInfoList", "", "Landroidx/compose/ui/text/ParagraphInfo;", "index", "findParagraphByLineIndex", "lineIndex", "findParagraphByY", "y", "", "findParagraphsByRange", "", "range", "Landroidx/compose/ui/text/TextRange;", "action", "Lkotlin/Function1;", "findParagraphsByRange-Sb-Bc2M", "(Ljava/util/List;JLkotlin/jvm/functions/Function1;)V", "fastBinarySearch", "T", "comparison", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MultiParagraphKt {
    private static final <T> int fastBinarySearch(List<? extends T> $this$fastBinarySearch, Function1<? super T, Integer> comparison) {
        int low;
        int high;
        int i;
        Object obj;
        int intValue;
        final int i2 = 0;
        low = 0;
        size--;
        while (low <= high) {
            i4 >>>= 1;
            intValue = (Number)comparison.invoke($this$fastBinarySearch.get(i)).intValue();
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    public static final int findParagraphByIndex(List<androidx.compose.ui.text.ParagraphInfo> paragraphInfoList, int index) {
        int low$iv;
        int high$iv;
        int i3;
        int i;
        Object obj2;
        Object obj;
        int i4;
        int i2;
        final Object obj3 = paragraphInfoList;
        final int i5 = 0;
        low$iv = 0;
        i3 = 1;
        size -= i3;
        while (low$iv <= high$iv) {
            i6 >>>= i3;
            obj = obj2;
            i4 = 0;
            if ((ParagraphInfo)obj.getStartIndex() > index) {
            } else {
            }
            if (obj.getEndIndex() <= index) {
            } else {
            }
            i2 = 0;
            high$iv = i + -1;
            low$iv = i + 1;
            i2 = -1;
            i2 = i3;
        }
        i = -i3;
        return i;
    }

    public static final int findParagraphByLineIndex(List<androidx.compose.ui.text.ParagraphInfo> paragraphInfoList, int lineIndex) {
        int low$iv;
        int high$iv;
        int i3;
        int i4;
        Object obj2;
        Object obj;
        int i;
        int i2;
        final Object obj3 = paragraphInfoList;
        final int i5 = 0;
        low$iv = 0;
        i3 = 1;
        size -= i3;
        while (low$iv <= high$iv) {
            i6 >>>= i3;
            obj = obj2;
            i = 0;
            if ((ParagraphInfo)obj.getStartLineIndex() > lineIndex) {
            } else {
            }
            if (obj.getEndLineIndex() <= lineIndex) {
            } else {
            }
            i2 = 0;
            high$iv = i4 + -1;
            low$iv = i4 + 1;
            i2 = -1;
            i2 = i3;
        }
        i4 = -i3;
        return i4;
    }

    public static final int findParagraphByY(List<androidx.compose.ui.text.ParagraphInfo> paragraphInfoList, float y) {
        int i4;
        int low$iv;
        int high$iv;
        int i3;
        Object obj;
        Object obj2;
        int i;
        int i2;
        i4 = 0;
        if (Float.compare(y, i5) <= 0) {
            return i4;
        }
        if (Float.compare(y, bottom) >= 0) {
            return CollectionsKt.getLastIndex(paragraphInfoList);
        }
        List list = paragraphInfoList;
        final int i6 = 0;
        low$iv = 0;
        final int i7 = 1;
        size -= i7;
        while (low$iv <= high$iv) {
            i8 >>>= i7;
            obj2 = obj;
            i = 0;
            if (Float.compare(top, y) > 0) {
            } else {
            }
            if (Float.compare(bottom2, y) <= 0) {
            } else {
            }
            i2 = i4;
            high$iv = i3 + -1;
            low$iv = i3 + 1;
            i2 = -1;
            i2 = i7;
        }
        i3 = -i4;
        return i3;
    }

    public static final void findParagraphsByRange-Sb-Bc2M(List<androidx.compose.ui.text.ParagraphInfo> paragraphInfoList, long range, Function1<? super androidx.compose.ui.text.ParagraphInfo, Unit> action) {
        int i;
        Object obj;
        int startIndex;
        int endIndex;
        i = paragraphByIndex;
        while (i < paragraphInfoList.size()) {
            obj = paragraphInfoList.get(i);
            if ((ParagraphInfo)obj.getStartIndex() < TextRange.getMax-impl(range)) {
            }
            if (obj.getStartIndex() != obj.getEndIndex()) {
            }
            i++;
            obj9.invoke(obj);
        }
    }
}
