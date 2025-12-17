package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000c\u0008\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0008\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u0002H\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000cH\u0000¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\u0008\u001a\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\u0008\u001a\u001f\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0087\u0008\u001a7\u0010\u0010\u001a\u0002H\u0001\"\u000c\u0008\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015", d2 = {"append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendLine", "", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__AppendableKt {
    public static final <T extends java.lang.Appendable> T append(T $this$append, java.lang.CharSequence... value) {
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        i = 0;
        while (i < value.length) {
            $this$append.append(value[i]);
            i++;
        }
        return $this$append;
    }

    public static final <T> void appendElement(java.lang.Appendable $this$appendElement, T element, Function1<? super T, ? extends java.lang.CharSequence> transform) {
        String charValue;
        int i;
        Intrinsics.checkNotNullParameter($this$appendElement, "<this>");
        if (transform != null) {
            $this$appendElement.append((CharSequence)transform.invoke(element));
        } else {
            i = element == null ? 1 : element instanceof CharSequence;
            if (i != 0) {
                $this$appendElement.append((CharSequence)element);
            } else {
                if (element instanceof Character) {
                    $this$appendElement.append((Character)element.charValue());
                } else {
                    $this$appendElement.append((CharSequence)String.valueOf(element));
                }
            }
        }
    }

    private static final java.lang.Appendable appendLine(java.lang.Appendable $this$appendLine) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        java.lang.Appendable append = $this$appendLine.append('\n');
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    private static final java.lang.Appendable appendLine(java.lang.Appendable $this$appendLine, char value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        java.lang.Appendable append = $this$appendLine.append(value);
        final String str2 = "append(...)";
        Intrinsics.checkNotNullExpressionValue(append, str2);
        java.lang.Appendable append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, str2);
        return append2;
    }

    private static final java.lang.Appendable appendLine(java.lang.Appendable $this$appendLine, java.lang.CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        java.lang.Appendable append = $this$appendLine.append(value);
        final String str2 = "append(...)";
        Intrinsics.checkNotNullExpressionValue(append, str2);
        java.lang.Appendable append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, str2);
        return append2;
    }

    public static final <T extends java.lang.Appendable> T appendRange(T $this$appendRange, java.lang.CharSequence value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$appendRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        java.lang.Appendable append = $this$appendRange.append(value, startIndex, endIndex);
        Intrinsics.checkNotNull(append, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return append;
    }
}
