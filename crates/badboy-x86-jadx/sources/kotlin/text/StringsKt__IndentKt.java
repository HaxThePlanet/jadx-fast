package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0008\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\u0008\u0007\u001a\u0014\u0010\u0008\u001a\u00020\u0002*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\u0008\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\u0008¢\u0006\u0002\u0008\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0002\u001a\u000c\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015", d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__IndentKt extends kotlin.text.StringsKt__AppendableKt {
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String indent) {
        int i;
        kotlin.jvm.internal.Lambda iNSTANCE;
        i = (CharSequence)indent.length() == 0 ? 1 : 0;
        if (i != 0) {
            iNSTANCE = StringsKt__IndentKt.getIndentFunction.1.INSTANCE;
        } else {
            iNSTANCE = new StringsKt__IndentKt.getIndentFunction.2(indent);
        }
        return iNSTANCE;
    }

    private static final int indentWidth$StringsKt__IndentKt(String $this$indentWidth) {
        int length;
        int it;
        int i;
        char charAt;
        int i2;
        boolean whitespace;
        java.lang.CharSequence charSequence = $this$indentWidth;
        length = 0;
        it = 0;
        i = -1;
        while (it < (CharSequence)charSequence.length()) {
            i2 = 0;
            it++;
            i = -1;
        }
        it = i;
        int i3 = 0;
        if (it == i) {
            it = length;
        }
        return it;
    }

    public static final String prependIndent(String $this$prependIndent, String indent) {
        Intrinsics.checkNotNullParameter($this$prependIndent, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        StringsKt__IndentKt.prependIndent.1 anon = new StringsKt__IndentKt.prependIndent.1(indent);
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence((CharSequence)$this$prependIndent), (Function1)anon), (CharSequence)"\n", 0, 0, 0, 0, 0, 62, 0);
    }

    public static String prependIndent$default(String string, String string2, int i3, Object object4) {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = "    ";
        }
        return StringsKt.prependIndent(string, obj1);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> $this$reindent, int resultSizeEstimate, Function1<? super String, String> indentAddFunction, Function1<? super String, String> indentCutFunction) {
        int i2;
        Object $i$f$reindent2;
        int lastIndex3;
        Object lastIndex2;
        int index$iv$iv;
        Object next;
        int i4;
        Object apiVersionIsAtLeast;
        int i5;
        Object value;
        int i;
        int blank;
        int i3;
        int $i$f$reindent;
        int lastIndex;
        i2 = 0;
        lastIndex3 = CollectionsKt.getLastIndex($this$reindent);
        int i7 = 0;
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        int i10 = 0;
        index$iv$iv = 0;
        Iterator iterator = (Iterable)$this$reindent.iterator();
        for (Object next : iterator) {
            i5 = 0;
            value = apiVersionIsAtLeast;
            blank = index$iv$iv;
            i3 = 0;
            if (blank != 0) {
            } else {
            }
            $i$f$reindent = i2;
            $i$f$reindent2 = blank;
            if (StringsKt.isBlank((CharSequence)(String)value)) {
            } else {
            }
            i = $i$f$reindent2;
            $i$f$reindent2 = invoke;
            if ((String)$i$f$reindent2 != null) {
            } else {
            }
            lastIndex = lastIndex3;
            lastIndex2 = indentAddFunction;
            if (value != null) {
            }
            index$iv$iv = i4;
            i2 = $i$f$reindent;
            lastIndex3 = lastIndex;
            $i$f$reindent2 = 0;
            (Collection)arrayList.add(value);
            lastIndex = lastIndex3;
            $i$f$reindent2 = indentAddFunction.invoke((String)$i$f$reindent2);
            if ((String)$i$f$reindent2 == null) {
            } else {
            }
            value = $i$f$reindent2;
            lastIndex = lastIndex3;
            value = i;
            lastIndex2 = indentAddFunction;
            $i$f$reindent = i2;
            if (blank == lastIndex3) {
            } else {
            }
            CollectionsKt.throwIndexOverflow();
        }
        int $i$f$reindent3 = i2;
        StringBuilder stringBuilder = new StringBuilder(resultSizeEstimate);
        String string = (StringBuilder)CollectionsKt.joinTo$default((Iterable)(List)arrayList, (Appendable)stringBuilder, (CharSequence)"\n", 0, 0, 0, 0, 0, 124, 0).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String replaceIndent(String $this$replaceIndent, String newIndent) {
        Object it$iv$iv$iv;
        int index$iv;
        int intValue;
        Object next2;
        boolean next3;
        Object valueOf;
        int i2;
        boolean blank2;
        int i;
        Object next;
        int i7;
        Object obj;
        int i4;
        Object value$iv;
        Object obj2;
        int blank;
        int i3;
        int i5;
        int i6;
        it$iv$iv$iv = $this$replaceIndent;
        Intrinsics.checkNotNullParameter(it$iv$iv$iv, "<this>");
        final Object obj4 = newIndent;
        Intrinsics.checkNotNullParameter(obj4, "newIndent");
        List lines = StringsKt.lines((CharSequence)it$iv$iv$iv);
        int i9 = 0;
        ArrayList arrayList2 = new ArrayList();
        int i13 = 0;
        Iterator iterator = (Iterable)lines.iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            i2 = 0;
            if (!StringsKt.isBlank((CharSequence)(String)next2)) {
            }
            (Collection)arrayList2.add(next2);
        }
        int i8 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)(List)arrayList2, 10));
        int i14 = 0;
        Iterator iterator2 = arrayList2.iterator();
        for (Object next3 : iterator2) {
            i2 = 0;
            (Collection)arrayList.add(Integer.valueOf(StringsKt__IndentKt.indentWidth$StringsKt__IndentKt((String)next3)));
        }
        Comparable minOrNull = CollectionsKt.minOrNull((Iterable)(List)arrayList);
        if ((Integer)minOrNull != null) {
            intValue = (Integer)minOrNull.intValue();
        } else {
            intValue = 0;
        }
        List list5 = lines;
        int i15 = 0;
        int i16 = 0;
        ArrayList arrayList3 = new ArrayList();
        int i17 = 0;
        int i19 = 0;
        i = 0;
        Iterator iterator3 = (Iterable)list5.iterator();
        while (iterator3.hasNext()) {
            if (i < 0) {
            }
            i4 = 0;
            value$iv = obj;
            blank = i;
            i3 = 0;
            if (blank != 0) {
            } else {
            }
            index$iv = blank;
            if (StringsKt.isBlank((CharSequence)(String)value$iv)) {
            } else {
            }
            i5 = 0;
            i6 = index$iv;
            index$iv = StringsKt.drop(value$iv, intValue);
            if (index$iv != null) {
            }
            if (value$iv != null) {
            }
            it$iv$iv$iv = $this$replaceIndent;
            i = i7;
            value$iv = 0;
            (Collection)arrayList3.add(value$iv);
            index$iv = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(obj4).invoke(index$iv);
            if ((String)index$iv == null) {
            } else {
            }
            value$iv = index$iv;
            value$iv = obj2;
            if (blank == CollectionsKt.getLastIndex(list5)) {
            } else {
            }
            CollectionsKt.throwIndexOverflow();
        }
        StringBuilder stringBuilder = new StringBuilder(length += i11);
        String string = (StringBuilder)CollectionsKt.joinTo$default((Iterable)(List)arrayList3, (Appendable)stringBuilder, (CharSequence)"\n", 0, 0, 0, 0, 0, 124, 0).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static String replaceIndent$default(String string, String string2, int i3, Object object4) {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = "";
        }
        return StringsKt.replaceIndent(string, obj1);
    }

    public static final String replaceIndentByMargin(String $this$replaceIndentByMargin, String newIndent, String marginPrefix) {
        Object destination$iv$iv$iv;
        ArrayList list;
        ArrayList firstNonWhitespaceIndex;
        int line;
        Object substring;
        int index$iv;
        int startsWith$default;
        int i6;
        int i5;
        Object next;
        int i7;
        Object obj;
        int i;
        int i3;
        Object value$iv;
        int i8;
        int i9;
        int i10;
        int i4;
        int charAt;
        Object obj2;
        int i2;
        boolean whitespace;
        destination$iv$iv$iv = $this$replaceIndentByMargin;
        substring = marginPrefix;
        Intrinsics.checkNotNullParameter(destination$iv$iv$iv, "<this>");
        final Object obj7 = newIndent;
        Intrinsics.checkNotNullParameter(obj7, "newIndent");
        Intrinsics.checkNotNullParameter(substring, "marginPrefix");
        if (StringsKt.isBlank((CharSequence)substring)) {
        } else {
            final List lines = StringsKt.lines((CharSequence)destination$iv$iv$iv);
            final List list2 = lines;
            final int i16 = 0;
            final int i17 = 0;
            firstNonWhitespaceIndex = new ArrayList();
            int i18 = 0;
            int i19 = 0;
            index$iv = 0;
            Iterator iterator = (Iterable)list2.iterator();
            while (iterator.hasNext()) {
                if (index$iv < 0) {
                }
                i = index$iv;
                i3 = 0;
                value$iv = obj;
                i8 = 0;
                i9 = 0;
                if (index$iv != 0) {
                } else {
                }
                if (StringsKt.isBlank((CharSequence)(String)value$iv)) {
                } else {
                }
                startsWith$default = firstNonWhitespaceIndex;
                Object destination$iv$iv$iv3 = value$iv;
                i10 = 0;
                i6 = destination$iv$iv$iv3;
                i5 = 0;
                obj2 = destination$iv$iv$iv3;
                line = charAt;
                int i12 = -1;
                while (line < (CharSequence)i6.length()) {
                    i2 = 0;
                    line++;
                    substring = marginPrefix;
                    i12 = -1;
                }
                line = i12;
                if (line == i12) {
                } else {
                }
                list = startsWith$default;
                i4 = index$iv;
                index$iv = line;
                firstNonWhitespaceIndex = obj2;
                if (StringsKt.startsWith$default(firstNonWhitespaceIndex, marginPrefix, index$iv, false, 4, 0)) {
                } else {
                }
                substring = i9;
                if (substring != null) {
                }
                if (value$iv != null) {
                }
                substring = marginPrefix;
                firstNonWhitespaceIndex = list;
                index$iv = i7;
                destination$iv$iv$iv = $this$replaceIndentByMargin;
                substring = 0;
                list.add(value$iv);
                firstNonWhitespaceIndex = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(obj7).invoke(substring);
                if ((String)firstNonWhitespaceIndex == null) {
                } else {
                }
                value$iv = firstNonWhitespaceIndex;
                Intrinsics.checkNotNull(firstNonWhitespaceIndex, "null cannot be cast to non-null type java.lang.String");
                Intrinsics.checkNotNullExpressionValue(firstNonWhitespaceIndex.substring(length3 += index$iv), "substring(...)");
                i4 = index$iv;
                list = startsWith$default;
                substring = i9;
                index$iv = line;
                firstNonWhitespaceIndex = obj2;
                i2 = 0;
                if (!CharsKt.isWhitespace(i6.charAt(line))) {
                } else {
                }
                line++;
                substring = marginPrefix;
                list = firstNonWhitespaceIndex;
                value$iv = i9;
                if (index$iv == CollectionsKt.getLastIndex(list2) && StringsKt.isBlank((CharSequence)value$iv)) {
                } else {
                }
                CollectionsKt.throwIndexOverflow();
            }
            StringBuilder stringBuilder = new StringBuilder(length2 + i14);
            String string = (StringBuilder)CollectionsKt.joinTo$default((Iterable)(List)firstNonWhitespaceIndex, (Appendable)stringBuilder, (CharSequence)"\n", 0, 0, 0, 0, 0, 124, 0).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        int i11 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        throw illegalArgumentException;
    }

    public static String replaceIndentByMargin$default(String string, String string2, String string3, int i4, Object object5) {
        String obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = "";
        }
        if (i4 &= 2 != 0) {
            obj2 = "|";
        }
        return StringsKt.replaceIndentByMargin(string, obj1, obj2);
    }

    public static final String trimIndent(String $this$trimIndent) {
        Intrinsics.checkNotNullParameter($this$trimIndent, "<this>");
        return StringsKt.replaceIndent($this$trimIndent, "");
    }

    public static final String trimMargin(String $this$trimMargin, String marginPrefix) {
        Intrinsics.checkNotNullParameter($this$trimMargin, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return StringsKt.replaceIndentByMargin($this$trimMargin, "", marginPrefix);
    }

    public static String trimMargin$default(String string, String string2, int i3, Object object4) {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = "|";
        }
        return StringsKt.trimMargin(string, obj1);
    }
}
