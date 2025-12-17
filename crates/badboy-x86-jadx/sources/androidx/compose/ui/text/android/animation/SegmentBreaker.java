package androidx.compose.ui.text.android.animation;

import android.text.Layout;
import android.text.TextPaint;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.LayoutCompat_androidKt;
import androidx.compose.ui.text.android.LayoutHelper;
import java.text.Bidi;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019", d2 = {"Landroidx/compose/ui/text/android/animation/SegmentBreaker;", "", "()V", "breakInWords", "", "", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "breakOffsets", "segmentType", "Landroidx/compose/ui/text/android/animation/SegmentType;", "breakSegmentWithChar", "Landroidx/compose/ui/text/android/animation/Segment;", "dropSpaces", "", "breakSegmentWithDocument", "breakSegmentWithLine", "breakSegmentWithParagraph", "breakSegmentWithWord", "breakSegments", "breakWithBreakIterator", "text", "", "breaker", "Ljava/text/BreakIterator;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SegmentBreaker {

    public static final int $stable;
    public static final androidx.compose.ui.text.android.animation.SegmentBreaker INSTANCE;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal4;
            int ordinal5;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[SegmentType.Document.ordinal()] = 1;
            iArr[SegmentType.Paragraph.ordinal()] = 2;
            iArr[SegmentType.Line.ordinal()] = 3;
            iArr[SegmentType.Word.ordinal()] = 4;
            iArr[SegmentType.Character.ordinal()] = 5;
            SegmentBreaker.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        SegmentBreaker segmentBreaker = new SegmentBreaker();
        SegmentBreaker.INSTANCE = segmentBreaker;
    }

    private final List<Integer> breakInWords(LayoutHelper layoutHelper) {
        int paraIndex;
        List analyzeBidi;
        int paragraphStart;
        int i;
        int runCount;
        Object valueOf2;
        int intValue;
        int i2;
        Integer valueOf;
        TreeSet treeSet = new TreeSet();
        int i3 = 0;
        analyzeBidi = breakWithBreakIterator;
        paragraphStart = 0;
        i = 0;
        while (i < analyzeBidi.size()) {
            i2 = 0;
            treeSet.add(Integer.valueOf((Number)analyzeBidi.get(i).intValue()));
            i++;
        }
        paraIndex = 0;
        while (paraIndex < layoutHelper.getParagraphCount()) {
            analyzeBidi = layoutHelper.analyzeBidi(paraIndex);
            if (analyzeBidi == null) {
            } else {
            }
            i = 0;
            while (i < analyzeBidi.getRunCount()) {
                treeSet.add(Integer.valueOf(runStart += paragraphStart));
                i++;
            }
            paraIndex++;
            treeSet.add(Integer.valueOf(runStart += paragraphStart));
            i++;
        }
        return CollectionsKt.toList((Iterable)treeSet);
    }

    private final List<androidx.compose.ui.text.android.animation.Segment> breakSegmentWithChar(LayoutHelper layoutHelper, boolean dropSpaces) {
        List breakOffsets;
        int result$iv;
        int i6;
        int i5;
        int i;
        int arrayList;
        int lineEndSpace;
        int rtlCharAt;
        Object current$iv;
        int i$iv;
        int lastIndex;
        Object obj;
        int i9;
        Layout layout;
        int intValue2;
        int intValue;
        int i2;
        int lineTop;
        int i4;
        int lineBottom;
        int i7;
        ArrayList list2;
        List $this$fastZipWithNext$iv;
        List list;
        int i8;
        int i3;
        Layout layout2;
        final LayoutHelper layoutHelper2 = layoutHelper;
        ArrayList arrayList2 = new ArrayList();
        breakOffsets = this.breakOffsets(layoutHelper2, SegmentType.Character);
        i5 = 0;
        if (breakOffsets.size() != 0) {
            if (breakOffsets.size() == 1) {
                $this$fastZipWithNext$iv = breakOffsets;
                i8 = i5;
                CollectionsKt.emptyList();
            } else {
                arrayList = new ArrayList();
                current$iv = breakOffsets.get(0);
                i$iv = 0;
                while (i$iv < CollectionsKt.getLastIndex(breakOffsets)) {
                    obj = breakOffsets.get(i$iv + 1);
                    intValue = (Number)obj.intValue();
                    intValue2 = (Number)current$iv.intValue();
                    i9 = 0;
                    layout = layoutHelper2.getLayout();
                    if (dropSpaces && intValue == intValue2 + 1 && layoutHelper2.isLineEndSpace(layout.getText().charAt(intValue2))) {
                    } else {
                    }
                    int lineForOffset = LayoutCompat_androidKt.getLineForOffset(layout, intValue2, rtlCharAt);
                    list = breakOffsets;
                    if (layout.getParagraphDirection(lineForOffset) == -1) {
                    } else {
                    }
                    breakOffsets = 0;
                    rtlCharAt = layout.isRtlCharAt(intValue2);
                    if (rtlCharAt == breakOffsets) {
                    } else {
                    }
                    i6 = 0;
                    i3 = i5;
                    list2 = arrayList;
                    result$iv = (int)f;
                    if (rtlCharAt == breakOffsets) {
                    } else {
                    }
                    i = 0;
                    i5 = (int)f2;
                    lineEndSpace = i7;
                    layout = segment;
                    arrayList = layout2;
                    super(intValue2, intValue, Math.min(result$iv, i5), layout.getLineTop(lineEndSpace), Math.max(result$iv, i5), layout.getLineBottom(lineEndSpace));
                    (List)arrayList2.add(layout);
                    ArrayList list3 = list2;
                    list3.add(Unit.INSTANCE);
                    current$iv = obj;
                    i$iv++;
                    arrayList = list3;
                    breakOffsets = list;
                    i5 = i3;
                    lineEndSpace = 1;
                    rtlCharAt = 0;
                    result$iv = this;
                    i = 1;
                    i6 = 1;
                    breakOffsets = 1;
                    if (intValue == intValue2 + 1) {
                    } else {
                    }
                    if (layoutHelper2.isLineEndSpace(layout.getText().charAt(intValue2))) {
                    } else {
                    }
                    list = breakOffsets;
                    i3 = i5;
                    list2 = arrayList;
                }
                $this$fastZipWithNext$iv = breakOffsets;
                i8 = i5;
                result$iv = arrayList;
            }
        } else {
            $this$fastZipWithNext$iv = breakOffsets;
            i8 = i5;
        }
        return arrayList2;
    }

    private final List<androidx.compose.ui.text.android.animation.Segment> breakSegmentWithDocument(LayoutHelper layoutHelper) {
        Segment segment = new Segment(0, layoutHelper.getLayout().getText().length(), 0, 0, layoutHelper.getLayout().getWidth(), layoutHelper.getLayout().getHeight());
        return CollectionsKt.listOf(segment);
    }

    private final List<androidx.compose.ui.text.android.animation.Segment> breakSegmentWithLine(LayoutHelper layoutHelper, boolean dropSpaces) {
        int i;
        androidx.compose.ui.text.android.animation.Segment segment;
        int lineStart;
        int lineEnd;
        int i2;
        double lineTop;
        int width;
        double lineBottom;
        ArrayList arrayList = new ArrayList();
        final Layout layout = layoutHelper.getLayout();
        i = 0;
        while (i < layoutHelper.getLayout().getLineCount()) {
            if (dropSpaces) {
            } else {
            }
            i2 = 0;
            if (dropSpaces) {
            } else {
            }
            width = layout.getWidth();
            segment = new Segment(layout.getLineStart(i), layout.getLineEnd(i), i2, layout.getLineTop(i), width, layout.getLineBottom(i));
            (List)arrayList.add(segment);
            i++;
            width = (int)f2;
            i2 = (int)f;
        }
        return arrayList;
    }

    private final List<androidx.compose.ui.text.android.animation.Segment> breakSegmentWithParagraph(LayoutHelper layoutHelper) {
        int i;
        androidx.compose.ui.text.android.animation.Segment segment;
        int paragraphStart;
        int paragraphEnd;
        int i2;
        int lineTop;
        int width;
        int lineBottom;
        int lineForOffset2;
        int lineForOffset;
        ArrayList arrayList = new ArrayList();
        final Layout layout = layoutHelper.getLayout();
        i = 0;
        while (i < layoutHelper.getParagraphCount()) {
            paragraphStart = layoutHelper.getParagraphStart(i);
            paragraphEnd = layoutHelper.getParagraphEnd(i);
            segment = new Segment(paragraphStart, paragraphEnd, 0, layout.getLineTop(LayoutCompat_androidKt.getLineForOffset(layout, paragraphStart, false)), layout.getWidth(), layout.getLineBottom(LayoutCompat_androidKt.getLineForOffset(layout, paragraphEnd, true)));
            (List)arrayList.add(segment);
            i++;
        }
        return arrayList;
    }

    private final List<androidx.compose.ui.text.android.animation.Segment> breakSegmentWithWord(LayoutHelper layoutHelper, boolean dropSpaces) {
        LayoutHelper lineEnd;
        int i2;
        int wsWidth;
        int i12;
        List breakOffsets;
        int i13;
        double d;
        int left;
        int i10;
        int right;
        int size;
        Object arrayList;
        int i8;
        int i4;
        int i3;
        Object current$iv;
        int i$iv;
        int lastIndex;
        Object obj;
        int intValue2;
        androidx.compose.ui.text.android.animation.Segment lineNo;
        int intValue;
        int i14;
        int i5;
        int lineTop;
        int i11;
        int lineBottom;
        int i7;
        int i9;
        int i;
        int i6;
        int wsWidth2;
        List list;
        List list2;
        int startPos;
        lineEnd = layoutHelper;
        final Layout layout = lineEnd.getLayout();
        String str = " ";
        i2 = (int)f;
        breakOffsets = this.breakOffsets(lineEnd, SegmentType.Word);
        i10 = 0;
        if (breakOffsets.size() != 0) {
            if (breakOffsets.size() == 1) {
                wsWidth2 = i2;
                list2 = breakOffsets;
                i = i10;
                arrayList = CollectionsKt.emptyList();
            } else {
                arrayList = new ArrayList();
                current$iv = breakOffsets.get(0);
                i$iv = 0;
                while (i$iv < CollectionsKt.getLastIndex(breakOffsets)) {
                    obj = breakOffsets.get(i$iv + 1);
                    intValue2 = (Number)obj.intValue();
                    intValue = (Number)current$iv.intValue();
                    i7 = 0;
                    int lineForOffset = LayoutCompat_androidKt.getLineForOffset(layout, intValue, i3);
                    if (layout.getParagraphDirection(lineForOffset) == -1) {
                    } else {
                    }
                    i4 = 0;
                    boolean rtlCharAt = layout.isRtlCharAt(intValue);
                    i6 = i2;
                    if (rtlCharAt == i4) {
                    } else {
                    }
                    wsWidth = 0;
                    i12 = (int)f2;
                    if (rtlCharAt == i4) {
                    } else {
                    }
                    i13 = 0;
                    int i16 = (int)f3;
                    left = Math.min(i12, i16);
                    right = Math.max(i12, i16);
                    if (dropSpaces && intValue2 != 0) {
                    } else {
                    }
                    startPos = i12;
                    i5 = left;
                    i11 = right;
                    lineNo = segment;
                    int i15 = i20;
                    super(intValue, intValue2, i5, layout.getLineTop(lineForOffset), i11, layout.getLineBottom(lineForOffset));
                    (List)arrayList.add(lineNo);
                    current$iv = obj;
                    i$iv++;
                    d = this;
                    lineEnd = layoutHelper;
                    i10 = i9;
                    i2 = i6;
                    breakOffsets = list;
                    i8 = 1;
                    i3 = 0;
                    if (intValue2 != 0) {
                    } else {
                    }
                    startPos = i12;
                    if (layout.getText().charAt(intValue2 + -1) == 32 && layout.getLineEnd(lineForOffset) != intValue2) {
                    } else {
                    }
                    if (layout.getLineEnd(lineForOffset) != intValue2) {
                    } else {
                    }
                    if (rtlCharAt) {
                    } else {
                    }
                    i5 = left;
                    i11 = right;
                    i5 = left;
                    i11 = right;
                    i13 = 1;
                    wsWidth = 1;
                    i4 = 1;
                }
                wsWidth2 = i2;
                list2 = breakOffsets;
                i = i10;
            }
        } else {
            wsWidth2 = i2;
            list2 = breakOffsets;
            i = i10;
        }
        return arrayList;
    }

    private final List<Integer> breakWithBreakIterator(java.lang.CharSequence text, BreakIterator breaker) {
        CharSequenceCharacterIterator valueOf;
        Integer valueOf2;
        int i2 = 0;
        CharSequenceCharacterIterator charSequenceCharacterIterator = new CharSequenceCharacterIterator(text, i2, text.length());
        Integer[] arr = new Integer[1];
        arr[i2] = Integer.valueOf(i2);
        List mutableListOf = CollectionsKt.mutableListOf(arr);
        breaker.setText((CharacterIterator)charSequenceCharacterIterator);
        while (breaker.next() != -1) {
            mutableListOf.add(Integer.valueOf(breaker.current()));
        }
        return mutableListOf;
    }

    public final List<Integer> breakOffsets(LayoutHelper layoutHelper, androidx.compose.ui.text.android.animation.SegmentType segmentType) {
        List breakWithBreakIterator;
        int i;
        int valueOf2;
        Integer i2;
        int paragraphCount;
        Integer valueOf;
        final Layout layout2 = layoutHelper.getLayout();
        final java.lang.CharSequence text = layout2.getText();
        i = 1;
        valueOf2 = 0;
        i2 = Integer.valueOf(valueOf2);
        switch (i3) {
            case 1:
                Integer[] arr = new Integer[2];
                arr[valueOf2] = i2;
                arr[i] = Integer.valueOf(text.length());
                breakWithBreakIterator = CollectionsKt.listOf(arr);
                break;
            case 2:
                Integer[] arr2 = new Integer[i];
                arr2[valueOf2] = i2;
                valueOf2 = 0;
                i2 = 0;
                CollectionsKt.mutableListOf(arr2).add(Integer.valueOf(layoutHelper.getParagraphEnd(i2)));
                i2++;
                break;
            case 3:
                Integer[] arr3 = new Integer[i];
                arr3[valueOf2] = i2;
                valueOf2 = 0;
                i2 = 0;
                CollectionsKt.mutableListOf(arr3).add(Integer.valueOf(layout2.getLineEnd(i2)));
                i2++;
                break;
            case 4:
                breakWithBreakIterator = breakInWords(layoutHelper);
                break;
            case 5:
                breakWithBreakIterator = breakWithBreakIterator(text, BreakIterator.getCharacterInstance(Locale.getDefault()));
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return breakWithBreakIterator;
    }

    public final List<androidx.compose.ui.text.android.animation.Segment> breakSegments(LayoutHelper layoutHelper, androidx.compose.ui.text.android.animation.SegmentType segmentType, boolean dropSpaces) {
        List breakSegmentWithWord;
        switch (i) {
            case 1:
                breakSegmentWithWord = breakSegmentWithDocument(layoutHelper);
                break;
            case 2:
                breakSegmentWithWord = breakSegmentWithParagraph(layoutHelper);
                break;
            case 3:
                breakSegmentWithWord = breakSegmentWithLine(layoutHelper, dropSpaces);
                break;
            case 4:
                breakSegmentWithWord = breakSegmentWithWord(layoutHelper, dropSpaces);
                break;
            case 5:
                breakSegmentWithWord = breakSegmentWithChar(layoutHelper, dropSpaces);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return breakSegmentWithWord;
    }
}
