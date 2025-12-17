package kotlin.io.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\u0008\u001a5\u0010\u0008\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\u0008\u001a%\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\u0008\u001a%\u0010\u000c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\u0008¨\u0006\u000e", d2 = {"platformCharsToBytes", "", "Lkotlin/io/encoding/Base64;", "source", "", "startIndex", "", "endIndex", "platformEncodeIntoByteArray", "destination", "destinationOffset", "platformEncodeToByteArray", "platformEncodeToString", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class Base64JVMKt {
    private static final byte[] platformCharsToBytes(kotlin.io.encoding.Base64 $this$platformCharsToBytes, java.lang.CharSequence source, int startIndex, int endIndex) {
        byte[] charsToBytesImpl$kotlin_stdlib;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter($this$platformCharsToBytes, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof String != null) {
            $this$platformCharsToBytes.checkSourceBounds$kotlin_stdlib(source.length(), startIndex, endIndex);
            String substring = (String)source.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            Intrinsics.checkNotNullExpressionValue(substring.getBytes(Charsets.ISO_8859_1), "getBytes(...)");
        } else {
            charsToBytesImpl$kotlin_stdlib = $this$platformCharsToBytes.charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return charsToBytesImpl$kotlin_stdlib;
    }

    private static final int platformEncodeIntoByteArray(kotlin.io.encoding.Base64 $this$platformEncodeIntoByteArray, byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$platformEncodeIntoByteArray, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return $this$platformEncodeIntoByteArray.encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, destinationOffset, startIndex, endIndex);
    }

    private static final byte[] platformEncodeToByteArray(kotlin.io.encoding.Base64 $this$platformEncodeToByteArray, byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$platformEncodeToByteArray, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return $this$platformEncodeToByteArray.encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex);
    }

    private static final String platformEncodeToString(kotlin.io.encoding.Base64 $this$platformEncodeToString, byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$platformEncodeToString, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        String string = new String($this$platformEncodeToString.encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1);
        return string;
    }
}
