package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.LocaleList.Companion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u0016\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\"\u0010\t\u001a\u00020\u00012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0086\u0008\u001a(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0000\u001a\u0008\u0010\u0016\u001a\u00020\u0001H\u0000\u001aD\u0010\u0017\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u001a0\u0019\u0018\u00010\u0018\"\u0004\u0008\u0000\u0010\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u0002H\u001a0\u0019\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0000\u001a\u0014\u0010#\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010$\u001a\u00020%\u001a\u0014\u0010&\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010$\u001a\u00020%\u001a,\u0010'\u001a\u0012\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020(0\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a*\u0010)\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a*\u0010*\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001aa\u0010+\u001a\u0008\u0012\u0004\u0012\u0002H\u001a0\u0018\"\u0004\u0008\u0000\u0010\u001a*\u00020\u00012\u0006\u0010,\u001a\u00020\u00062>\u0008\u0004\u0010-\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u0002H\u001a0.H\u0080\u0008\u001a \u00102\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00190\u0018*\u00020\u00012\u0006\u0010,\u001a\u00020\u0006H\u0000\u001a\u001c\u00103\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a\u0014\u00104\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010$\u001a\u00020%\u001a\u0014\u00105\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010$\u001a\u00020%\u001a?\u00106\u001a\u0002H7\"\u0008\u0008\u0000\u00107*\u00020(*\u00020\u000c2\u0006\u00108\u001a\u0002092\u0019\u0008\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008¢\u0006\u0002\u0010:\u001a?\u00106\u001a\u0002H7\"\u0008\u0008\u0000\u00107*\u00020(*\u00020\u000c2\u0006\u0010;\u001a\u00020<2\u0019\u0008\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008¢\u0006\u0002\u0010=\u001aG\u00106\u001a\u0002H7\"\u0008\u0008\u0000\u00107*\u00020(*\u00020\u000c2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0019\u0008\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008¢\u0006\u0002\u0010@\u001a=\u0010A\u001a\u0002H7\"\u0008\u0008\u0000\u00107*\u00020(*\u00020\u000c2\u0006\u0010B\u001a\u00020C2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\u0008\u000eH\u0086\u0008¢\u0006\u0002\u0010D\u001a?\u0010E\u001a\u0002H7\"\u0008\u0008\u0000\u00107*\u00020(*\u00020\u000c2\u0006\u0010F\u001a\u00020\u00062\u0019\u0008\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\u0008\u000eH\u0086\u0008¢\u0006\u0002\u0010G\u001a=\u0010E\u001a\u0002H7\"\u0008\u0008\u0000\u00107*\u00020(*\u00020\u000c2\u0006\u0010F\u001a\u00020\u00082\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\u0008\u000eH\u0086\u0008¢\u0006\u0002\u0010H\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I", d2 = {"EmptyAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "AnnotatedString", "text", "", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "buildAnnotatedString", "builder", "Lkotlin/Function1;", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "Lkotlin/ExtensionFunctionType;", "contains", "", "baseStart", "", "baseEnd", "targetStart", "targetEnd", "emptyAnnotatedString", "filterRanges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "ranges", "start", "end", "intersect", "lStart", "lEnd", "rStart", "rEnd", "capitalize", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "getLocalAnnotations", "", "getLocalParagraphStyles", "getLocalSpanStyles", "mapEachParagraphStyle", "defaultParagraphStyle", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "annotatedString", "normalizedParagraphStyles", "substringWithoutParagraphStyles", "toLowerCase", "toUpperCase", "withAnnotation", "R", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/UrlAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tag", "annotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/LinkAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withStyle", "style", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnnotatedStringKt {

    private static final androidx.compose.ui.text.AnnotatedString EmptyAnnotatedString;
    static {
        AnnotatedString annotatedString = new AnnotatedString("", 0, 0, 6, 0);
        AnnotatedStringKt.EmptyAnnotatedString = annotatedString;
    }

    public static final androidx.compose.ui.text.AnnotatedString AnnotatedString(String text, androidx.compose.ui.text.ParagraphStyle paragraphStyle) {
        AnnotatedString.Range range = new AnnotatedString.Range(paragraphStyle, 0, text.length());
        AnnotatedString annotatedString = new AnnotatedString(text, CollectionsKt.emptyList(), CollectionsKt.listOf(range));
        return annotatedString;
    }

    public static final androidx.compose.ui.text.AnnotatedString AnnotatedString(String text, androidx.compose.ui.text.SpanStyle spanStyle, androidx.compose.ui.text.ParagraphStyle paragraphStyle) {
        List emptyList;
        int length;
        final int i = 0;
        AnnotatedString.Range range = new AnnotatedString.Range(spanStyle, i, text.length());
        if (paragraphStyle == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            AnnotatedString.Range range2 = new AnnotatedString.Range(paragraphStyle, i, text.length());
            emptyList = CollectionsKt.listOf(range2);
        }
        AnnotatedString annotatedString = new AnnotatedString(text, CollectionsKt.listOf(range), emptyList);
        return annotatedString;
    }

    public static androidx.compose.ui.text.AnnotatedString AnnotatedString$default(String string, androidx.compose.ui.text.SpanStyle spanStyle2, androidx.compose.ui.text.ParagraphStyle paragraphStyle3, int i4, Object object5) {
        int obj2;
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return AnnotatedStringKt.AnnotatedString(string, spanStyle2, obj2);
    }

    public static final List access$filterRanges(List ranges, int start, int end) {
        return AnnotatedStringKt.filterRanges(ranges, start, end);
    }

    public static final List access$getLocalAnnotations(androidx.compose.ui.text.AnnotatedString $receiver, int start, int end) {
        return AnnotatedStringKt.getLocalAnnotations($receiver, start, end);
    }

    public static final List access$getLocalParagraphStyles(androidx.compose.ui.text.AnnotatedString $receiver, int start, int end) {
        return AnnotatedStringKt.getLocalParagraphStyles($receiver, start, end);
    }

    public static final List access$getLocalSpanStyles(androidx.compose.ui.text.AnnotatedString $receiver, int start, int end) {
        return AnnotatedStringKt.getLocalSpanStyles($receiver, start, end);
    }

    public static final androidx.compose.ui.text.AnnotatedString access$substringWithoutParagraphStyles(androidx.compose.ui.text.AnnotatedString $receiver, int start, int end) {
        return AnnotatedStringKt.substringWithoutParagraphStyles($receiver, start, end);
    }

    public static final androidx.compose.ui.text.AnnotatedString buildAnnotatedString(Function1<? super androidx.compose.ui.text.AnnotatedString.Builder, Unit> builder) {
        final int i = 0;
        AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, 0);
        builder.invoke(builder2);
        return builder2.toAnnotatedString();
    }

    public static final androidx.compose.ui.text.AnnotatedString capitalize(androidx.compose.ui.text.AnnotatedString $this$capitalize, LocaleList localeList) {
        AnnotatedStringKt.capitalize.1 anon = new AnnotatedStringKt.capitalize.1(localeList);
        return JvmAnnotatedString_jvmKt.transform($this$capitalize, (Function3)anon);
    }

    public static androidx.compose.ui.text.AnnotatedString capitalize$default(androidx.compose.ui.text.AnnotatedString annotatedString, LocaleList localeList2, int i3, Object object4) {
        LocaleList obj1;
        if (i3 &= 1 != 0) {
            obj1 = LocaleList.Companion.getCurrent();
        }
        return AnnotatedStringKt.capitalize(annotatedString, obj1);
    }

    public static final boolean contains(int baseStart, int baseEnd, int targetStart, int targetEnd) {
        int i;
        int i2;
        int i4;
        int i3;
        i = 0;
        if (baseStart <= targetStart && targetEnd <= baseEnd) {
            if (targetEnd <= baseEnd) {
                i2 = 1;
                if (baseEnd == targetEnd) {
                    i4 = targetStart == targetEnd ? i2 : i;
                    i3 = baseStart == baseEnd ? i2 : i;
                    if (i4 == i3) {
                        i = i2;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final androidx.compose.ui.text.AnnotatedString decapitalize(androidx.compose.ui.text.AnnotatedString $this$decapitalize, LocaleList localeList) {
        AnnotatedStringKt.decapitalize.1 anon = new AnnotatedStringKt.decapitalize.1(localeList);
        return JvmAnnotatedString_jvmKt.transform($this$decapitalize, (Function3)anon);
    }

    public static androidx.compose.ui.text.AnnotatedString decapitalize$default(androidx.compose.ui.text.AnnotatedString annotatedString, LocaleList localeList2, int i3, Object object4) {
        LocaleList obj1;
        if (i3 &= 1 != 0) {
            obj1 = LocaleList.Companion.getCurrent();
        }
        return AnnotatedStringKt.decapitalize(annotatedString, obj1);
    }

    public static final androidx.compose.ui.text.AnnotatedString emptyAnnotatedString() {
        return AnnotatedStringKt.EmptyAnnotatedString;
    }

    private static final <T> List<androidx.compose.ui.text.AnnotatedString.Range<T>> filterRanges(List<? extends androidx.compose.ui.text.AnnotatedString.Range<? extends T>> ranges, int start, int end) {
        int i3;
        int i4;
        ArrayList list5;
        ArrayList $i$a$IfEmptyAnnotatedStringKt$filterRanges$4;
        boolean intersect;
        Object obj4;
        int i;
        ArrayList arrayList;
        ArrayList list3;
        int index$iv$iv;
        int index$iv$iv2;
        int size;
        Object obj2;
        Object obj3;
        int i2;
        Object obj;
        int range;
        Object obj7;
        ArrayList list;
        int i5;
        ArrayList list4;
        ArrayList list2;
        final int i6 = start;
        final int i7 = end;
        i3 = i6 <= i7 ? 1 : 0;
        if (i3 == 0) {
        } else {
            if (ranges == null) {
                return 0;
            }
            Object obj5 = obj4;
            int i15 = 0;
            ArrayList arrayList2 = new ArrayList(obj5.size());
            Object obj6 = obj5;
            int i17 = 0;
            index$iv$iv2 = 0;
            while (index$iv$iv2 < obj6.size()) {
                obj3 = obj2;
                i2 = 0;
                obj = obj3;
                range = 0;
                if (AnnotatedStringKt.intersect(i6, i7, (AnnotatedString.Range)obj.getStart(), obj.getEnd())) {
                }
                index$iv$iv2++;
                obj4 = obj7;
                i4 = 0;
                (Collection)arrayList2.add(obj3);
            }
            Object nonNullRange = obj4;
            list5 = arrayList2;
            i = 0;
            arrayList = new ArrayList((List)list5.size());
            int i16 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list5.size()) {
                obj2 = 0;
                i2 = size;
                obj = 0;
                range = new AnnotatedString.Range((AnnotatedString.Range)i2.getItem(), i10 -= i6, i13 -= i6, i2.getTag());
                (Collection)arrayList.add(range);
                index$iv$iv++;
                list5 = list;
                i = i5;
                arrayList = list4;
                list3 = list2;
            }
            ArrayList $this$fastMap$iv = list5;
            int i18 = i;
            ArrayList list7 = list3;
            if ((Collection)(List)arrayList.isEmpty()) {
                int i9 = 0;
                $i$a$IfEmptyAnnotatedStringKt$filterRanges$4 = 0;
            }
            return (List)$i$a$IfEmptyAnnotatedStringKt$filterRanges$4;
        }
        int i8 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("start (").append(i6).append(") should be less than or equal to end (").append(i7).append(')').toString().toString());
        throw illegalArgumentException;
    }

    private static final List<androidx.compose.ui.text.AnnotatedString.Range<? extends Object>> getLocalAnnotations(androidx.compose.ui.text.AnnotatedString $this$getLocalAnnotations, int start, int end) {
        int i;
        int length;
        List list;
        boolean intersect;
        ArrayList list5;
        List annotations$ui_text_release;
        int i2;
        ArrayList arrayList;
        int index$iv$iv2;
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i5;
        Object obj3;
        int i3;
        int start2;
        List list4;
        List $this$fastFilter$iv;
        List list2;
        int i4;
        ArrayList list3;
        i = start;
        final int i6 = end;
        length = 0;
        if (i == i6) {
            return length;
        }
        annotations$ui_text_release = $this$getLocalAnnotations.getAnnotations$ui_text_release();
        if (annotations$ui_text_release == null) {
            return length;
        }
        if (i == 0 && i6 >= $this$getLocalAnnotations.getText().length()) {
            if (i6 >= $this$getLocalAnnotations.getText().length()) {
                return annotations$ui_text_release;
            }
        }
        list = annotations$ui_text_release;
        int i7 = 0;
        ArrayList arrayList2 = new ArrayList(list.size());
        List list7 = list;
        int i10 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < list7.size()) {
            obj = obj2;
            i5 = 0;
            obj3 = obj;
            i3 = 0;
            if (AnnotatedStringKt.intersect(i, i6, (AnnotatedString.Range)obj3.getStart(), obj3.getEnd())) {
            }
            index$iv$iv2++;
            list = list4;
            (Collection)arrayList2.add(obj);
        }
        $this$fastFilter$iv = list;
        list5 = arrayList2;
        i2 = 0;
        arrayList = new ArrayList((List)list5.size());
        ArrayList list8 = list5;
        int i11 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list8.size()) {
            i5 = 0;
            i3 = obj;
            start2 = 0;
            AnnotatedString.Range range = new AnnotatedString.Range(i3.getItem(), coerceIn -= i, coerceIn2 -= i, (AnnotatedString.Range)i3.getTag());
            (Collection)arrayList.add(range);
            index$iv$iv++;
            i = start;
            list5 = $this$fastFilter$iv;
            annotations$ui_text_release = list2;
            i2 = i4;
            arrayList = list3;
        }
        return (List)arrayList;
    }

    private static final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>> getLocalParagraphStyles(androidx.compose.ui.text.AnnotatedString $this$getLocalParagraphStyles, int start, int end) {
        int length;
        List list3;
        boolean intersect;
        ArrayList list2;
        List paragraphStylesOrNull$ui_text_release;
        int i3;
        ArrayList arrayList;
        int index$iv$iv;
        int index$iv$iv2;
        Object obj2;
        Object obj;
        int i;
        Object obj3;
        int i4;
        int start2;
        List list4;
        List $this$fastFilter$iv;
        List list;
        int i2;
        ArrayList list5;
        final int i5 = start;
        final int i6 = end;
        length = 0;
        if (i5 == i6) {
            return length;
        }
        paragraphStylesOrNull$ui_text_release = $this$getLocalParagraphStyles.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release == null) {
            return length;
        }
        if (i5 == 0 && i6 >= $this$getLocalParagraphStyles.getText().length()) {
            if (i6 >= $this$getLocalParagraphStyles.getText().length()) {
                return paragraphStylesOrNull$ui_text_release;
            }
        }
        list3 = paragraphStylesOrNull$ui_text_release;
        int i7 = 0;
        ArrayList arrayList2 = new ArrayList(list3.size());
        List list7 = list3;
        int i10 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list7.size()) {
            obj = obj2;
            i = 0;
            obj3 = obj;
            i4 = 0;
            if (AnnotatedStringKt.intersect(i5, i6, (AnnotatedString.Range)obj3.getStart(), obj3.getEnd())) {
            }
            index$iv$iv++;
            list3 = list4;
            (Collection)arrayList2.add(obj);
        }
        $this$fastFilter$iv = list3;
        list2 = arrayList2;
        i3 = 0;
        arrayList = new ArrayList((List)list2.size());
        ArrayList list8 = list2;
        int i11 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < list8.size()) {
            i = 0;
            i4 = obj;
            start2 = 0;
            AnnotatedString.Range $this$fastMap$iv = new AnnotatedString.Range((AnnotatedString.Range)i4.getItem(), coerceIn -= i5, coerceIn2 -= i5);
            (Collection)arrayList.add($this$fastMap$iv);
            index$iv$iv2++;
            list2 = $this$fastFilter$iv;
            paragraphStylesOrNull$ui_text_release = list;
            i3 = i2;
            arrayList = list5;
        }
        ArrayList $this$fastMap$iv2 = list2;
        return (List)arrayList;
    }

    private static final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> getLocalSpanStyles(androidx.compose.ui.text.AnnotatedString $this$getLocalSpanStyles, int start, int end) {
        int length;
        List list;
        boolean intersect;
        ArrayList list4;
        List spanStylesOrNull$ui_text_release;
        int i;
        ArrayList arrayList;
        int index$iv$iv2;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i2;
        Object obj3;
        int i3;
        int start2;
        List list5;
        List $this$fastFilter$iv;
        List list2;
        int i4;
        ArrayList list3;
        final int i5 = start;
        final int i6 = end;
        length = 0;
        if (i5 == i6) {
            return length;
        }
        spanStylesOrNull$ui_text_release = $this$getLocalSpanStyles.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release == null) {
            return length;
        }
        if (i5 == 0 && i6 >= $this$getLocalSpanStyles.getText().length()) {
            if (i6 >= $this$getLocalSpanStyles.getText().length()) {
                return spanStylesOrNull$ui_text_release;
            }
        }
        list = spanStylesOrNull$ui_text_release;
        int i7 = 0;
        ArrayList arrayList2 = new ArrayList(list.size());
        List list7 = list;
        int i10 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < list7.size()) {
            obj2 = obj;
            i2 = 0;
            obj3 = obj2;
            i3 = 0;
            if (AnnotatedStringKt.intersect(i5, i6, (AnnotatedString.Range)obj3.getStart(), obj3.getEnd())) {
            }
            index$iv$iv2++;
            list = list5;
            (Collection)arrayList2.add(obj2);
        }
        $this$fastFilter$iv = list;
        list4 = arrayList2;
        i = 0;
        arrayList = new ArrayList((List)list4.size());
        ArrayList list8 = list4;
        int i11 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list8.size()) {
            i2 = 0;
            i3 = obj2;
            start2 = 0;
            AnnotatedString.Range $this$fastMap$iv = new AnnotatedString.Range((AnnotatedString.Range)i3.getItem(), coerceIn -= i5, coerceIn2 -= i5);
            (Collection)arrayList.add($this$fastMap$iv);
            index$iv$iv++;
            list4 = $this$fastFilter$iv;
            spanStylesOrNull$ui_text_release = list2;
            i = i4;
            arrayList = list3;
        }
        ArrayList $this$fastMap$iv2 = list4;
        return (List)arrayList;
    }

    public static final boolean intersect(int lStart, int lEnd, int rStart, int rEnd) {
        int contains;
        int i;
        if (Math.max(lStart, rStart) >= Math.min(lEnd, rEnd) && !AnnotatedStringKt.contains(lStart, lEnd, rStart, rEnd)) {
            if (!AnnotatedStringKt.contains(lStart, lEnd, rStart, rEnd)) {
                if (AnnotatedStringKt.contains(rStart, rEnd, lStart, lEnd)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final <T> List<T> mapEachParagraphStyle(androidx.compose.ui.text.AnnotatedString $this$mapEachParagraphStyle, androidx.compose.ui.text.ParagraphStyle defaultParagraphStyle, Function2<? super androidx.compose.ui.text.AnnotatedString, ? super androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>, ? extends T> block) {
        int i2;
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i;
        ArrayList list;
        Object paragraphStyleRange;
        int i3;
        androidx.compose.ui.text.AnnotatedString str;
        Object obj4;
        int i4;
        i2 = 0;
        List normalizedParagraphStyles = AnnotatedStringKt.normalizedParagraphStyles($this$mapEachParagraphStyle, defaultParagraphStyle);
        final int i5 = 0;
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        List list2 = normalizedParagraphStyles;
        final int i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list2.size()) {
            i = 0;
            Object obj3 = obj;
            i3 = 0;
            (Collection)arrayList.add(block.invoke(AnnotatedStringKt.access$substringWithoutParagraphStyles($this$mapEachParagraphStyle, (AnnotatedString.Range)obj3.getStart(), obj3.getEnd()), obj3));
            index$iv$iv++;
            i2 = i4;
        }
        return (List)arrayList;
    }

    public static final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>> normalizedParagraphStyles(androidx.compose.ui.text.AnnotatedString $this$normalizedParagraphStyles, androidx.compose.ui.text.ParagraphStyle defaultParagraphStyle) {
        List paragraphStylesOrNull$ui_text_release;
        int lastOffset;
        Object range2;
        boolean empty;
        int i2;
        int index$iv;
        Object obj;
        int component3;
        int i;
        Object component1;
        int component2;
        androidx.compose.ui.text.AnnotatedString.Range range;
        androidx.compose.ui.text.ParagraphStyle merge;
        final Object obj2 = defaultParagraphStyle;
        int length = $this$normalizedParagraphStyles.getText().length();
        if ($this$normalizedParagraphStyles.getParagraphStylesOrNull$ui_text_release() == null) {
            paragraphStylesOrNull$ui_text_release = CollectionsKt.emptyList();
        }
        lastOffset = 0;
        ArrayList arrayList = new ArrayList();
        range2 = paragraphStylesOrNull$ui_text_release;
        i2 = 0;
        index$iv = 0;
        while (index$iv < range2.size()) {
            Object obj3 = obj;
            i = 0;
            component2 = obj3.component2();
            component3 = obj3.component3();
            if (component2 != lastOffset) {
            }
            range = new AnnotatedString.Range(obj2.merge((ParagraphStyle)(AnnotatedString.Range)obj3.component1()), component2, component3);
            (List)arrayList.add(range);
            lastOffset = component3;
            index$iv++;
            range = new AnnotatedString.Range(obj2, lastOffset, component2);
            arrayList.add(range);
        }
        if (lastOffset != length) {
            range2 = new AnnotatedString.Range(obj2, lastOffset, length);
            arrayList.add(range2);
        }
        if (arrayList.isEmpty()) {
            i2 = 0;
            empty = new AnnotatedString.Range(obj2, i2, i2);
            arrayList.add(empty);
        }
        return arrayList;
    }

    private static final androidx.compose.ui.text.AnnotatedString substringWithoutParagraphStyles(androidx.compose.ui.text.AnnotatedString $this$substringWithoutParagraphStyles, int start, int end) {
        String substring;
        String str;
        if (start != end) {
            Intrinsics.checkNotNullExpressionValue($this$substringWithoutParagraphStyles.getText().substring(start, end), "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            substring = "";
        }
        AnnotatedString annotatedString = new AnnotatedString(substring, AnnotatedStringKt.getLocalSpanStyles($this$substringWithoutParagraphStyles, start, end), 0, 0, 12, 0);
        return annotatedString;
    }

    public static final androidx.compose.ui.text.AnnotatedString toLowerCase(androidx.compose.ui.text.AnnotatedString $this$toLowerCase, LocaleList localeList) {
        AnnotatedStringKt.toLowerCase.1 anon = new AnnotatedStringKt.toLowerCase.1(localeList);
        return JvmAnnotatedString_jvmKt.transform($this$toLowerCase, (Function3)anon);
    }

    public static androidx.compose.ui.text.AnnotatedString toLowerCase$default(androidx.compose.ui.text.AnnotatedString annotatedString, LocaleList localeList2, int i3, Object object4) {
        LocaleList obj1;
        if (i3 &= 1 != 0) {
            obj1 = LocaleList.Companion.getCurrent();
        }
        return AnnotatedStringKt.toLowerCase(annotatedString, obj1);
    }

    public static final androidx.compose.ui.text.AnnotatedString toUpperCase(androidx.compose.ui.text.AnnotatedString $this$toUpperCase, LocaleList localeList) {
        AnnotatedStringKt.toUpperCase.1 anon = new AnnotatedStringKt.toUpperCase.1(localeList);
        return JvmAnnotatedString_jvmKt.transform($this$toUpperCase, (Function3)anon);
    }

    public static androidx.compose.ui.text.AnnotatedString toUpperCase$default(androidx.compose.ui.text.AnnotatedString annotatedString, LocaleList localeList2, int i3, Object object4) {
        LocaleList obj1;
        if (i3 &= 1 != 0) {
            obj1 = LocaleList.Companion.getCurrent();
        }
        return AnnotatedStringKt.toUpperCase(annotatedString, obj1);
    }

    public static final <R> R withAnnotation(androidx.compose.ui.text.AnnotatedString.Builder $this$withAnnotation, androidx.compose.ui.text.TtsAnnotation ttsAnnotation, Function1<? super androidx.compose.ui.text.AnnotatedString.Builder, ? extends R> block) {
        final int i = 0;
        $this$withAnnotation.pop($this$withAnnotation.pushTtsAnnotation(ttsAnnotation));
        return block.invoke($this$withAnnotation);
    }

    @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(...))
    public static final <R> R withAnnotation(androidx.compose.ui.text.AnnotatedString.Builder $this$withAnnotation, androidx.compose.ui.text.UrlAnnotation urlAnnotation, Function1<? super androidx.compose.ui.text.AnnotatedString.Builder, ? extends R> block) {
        final int i = 0;
        $this$withAnnotation.pop($this$withAnnotation.pushUrlAnnotation(urlAnnotation));
        return block.invoke($this$withAnnotation);
    }

    public static final <R> R withAnnotation(androidx.compose.ui.text.AnnotatedString.Builder $this$withAnnotation, String tag, String annotation, Function1<? super androidx.compose.ui.text.AnnotatedString.Builder, ? extends R> block) {
        final int i = 0;
        $this$withAnnotation.pop($this$withAnnotation.pushStringAnnotation(tag, annotation));
        return block.invoke($this$withAnnotation);
    }

    public static final <R> R withLink(androidx.compose.ui.text.AnnotatedString.Builder $this$withLink, androidx.compose.ui.text.LinkAnnotation link, Function1<? super androidx.compose.ui.text.AnnotatedString.Builder, ? extends R> block) {
        final int i = 0;
        $this$withLink.pop($this$withLink.pushLink(link));
        return block.invoke($this$withLink);
    }

    public static final <R> R withStyle(androidx.compose.ui.text.AnnotatedString.Builder $this$withStyle, androidx.compose.ui.text.ParagraphStyle style, Function1<? super androidx.compose.ui.text.AnnotatedString.Builder, ? extends R> block) {
        final int i = 0;
        $this$withStyle.pop($this$withStyle.pushStyle(style));
        return block.invoke($this$withStyle);
    }

    public static final <R> R withStyle(androidx.compose.ui.text.AnnotatedString.Builder $this$withStyle, androidx.compose.ui.text.SpanStyle style, Function1<? super androidx.compose.ui.text.AnnotatedString.Builder, ? extends R> block) {
        final int i = 0;
        $this$withStyle.pop($this$withStyle.pushStyle(style));
        return block.invoke($this$withStyle);
    }
}
