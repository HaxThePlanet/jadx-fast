package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u001c\u0010\u0007\u001a\u00020\u0008*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\u0008\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\u0008\u001aB\u0010\u001b\u001a\u0002H\u001c\"\u0004\u0008\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u001f", d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TextStreamsKt {
    private static final BufferedReader buffered(Reader $this$buffered, int bufferSize) {
        Object bufferedReader;
        Intrinsics.checkNotNullParameter($this$buffered, "<this>");
        if ($this$buffered instanceof BufferedReader) {
            bufferedReader = $this$buffered;
        } else {
            bufferedReader = new BufferedReader($this$buffered, bufferSize);
        }
        return bufferedReader;
    }

    private static final BufferedWriter buffered(Writer $this$buffered, int bufferSize) {
        Object bufferedWriter;
        Intrinsics.checkNotNullParameter($this$buffered, "<this>");
        if ($this$buffered instanceof BufferedWriter) {
            bufferedWriter = $this$buffered;
        } else {
            bufferedWriter = new BufferedWriter($this$buffered, bufferSize);
        }
        return bufferedWriter;
    }

    static BufferedReader buffered$default(Reader $this$buffered_u24default, int bufferSize, int i3, Object object4) {
        int obj1;
        Object obj2;
        if (i3 &= 1 != 0) {
            obj1 = 8192;
        }
        Intrinsics.checkNotNullParameter($this$buffered_u24default, "<this>");
        if ($this$buffered_u24default instanceof BufferedReader) {
            obj2 = $this$buffered_u24default;
        } else {
            obj2 = new BufferedReader($this$buffered_u24default, obj1);
        }
        return obj2;
    }

    static BufferedWriter buffered$default(Writer $this$buffered_u24default, int bufferSize, int i3, Object object4) {
        int obj1;
        Object obj2;
        if (i3 &= 1 != 0) {
            obj1 = 8192;
        }
        Intrinsics.checkNotNullParameter($this$buffered_u24default, "<this>");
        if ($this$buffered_u24default instanceof BufferedWriter) {
            obj2 = $this$buffered_u24default;
        } else {
            obj2 = new BufferedWriter($this$buffered_u24default, obj1);
        }
        return obj2;
    }

    public static final long copyTo(Reader $this$copyTo, Writer out, int bufferSize) {
        int charsCopied;
        int chars;
        long l;
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        charsCopied = 0;
        final char[] cArr = new char[bufferSize];
        chars = $this$copyTo.read(cArr);
        while (chars >= 0) {
            out.write(cArr, 0, chars);
            charsCopied += l;
            chars = $this$copyTo.read(cArr);
        }
        return charsCopied;
    }

    public static long copyTo$default(Reader reader, Writer writer2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 8192;
        }
        return TextStreamsKt.copyTo(reader, writer2, obj2);
    }

    public static final void forEachLine(Reader $this$forEachLine, Function1<? super String, Unit> action) {
        Object bufferedReader;
        int th;
        Object next;
        Intrinsics.checkNotNullParameter($this$forEachLine, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Object obj = $this$forEachLine;
        final int i = 0;
        if (obj instanceof BufferedReader) {
            bufferedReader = obj;
        } else {
            bufferedReader = new BufferedReader(obj, 8192);
        }
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        final Iterator iterator = TextStreamsKt.lineSequence((BufferedReader)(Closeable)bufferedReader).iterator();
        for (Object next : iterator) {
            action.invoke(next);
        }
        Unit it = Unit.INSTANCE;
        CloseableKt.closeFinally(bufferedReader, 0);
    }

    public static final Sequence<String> lineSequence(BufferedReader $this$lineSequence) {
        Intrinsics.checkNotNullParameter($this$lineSequence, "<this>");
        LinesSequence linesSequence = new LinesSequence($this$lineSequence);
        return SequencesKt.constrainOnce((Sequence)linesSequence);
    }

    public static final byte[] readBytes(URL $this$readBytes) {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        java.io.InputStream stream = $this$readBytes.openStream();
        java.io.InputStream inputStream = stream;
        final int i = 0;
        Intrinsics.checkNotNull((InputStream)inputStream);
        CloseableKt.closeFinally((Closeable)stream, 0);
        return ByteStreamsKt.readBytes(inputStream);
    }

    public static final List<String> readLines(Reader $this$readLines) {
        Intrinsics.checkNotNullParameter($this$readLines, "<this>");
        ArrayList arrayList = new ArrayList();
        TextStreamsKt.readLines.1 anon = new TextStreamsKt.readLines.1(arrayList);
        TextStreamsKt.forEachLine($this$readLines, (Function1)anon);
        return (List)arrayList;
    }

    public static final String readText(Reader $this$readText) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        StringWriter stringWriter = new StringWriter();
        TextStreamsKt.copyTo$default($this$readText, (Writer)stringWriter, 0, 2, 0);
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final String readText(URL $this$readText, Charset charset) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String string = new String(TextStreamsKt.readBytes($this$readText), charset);
        return string;
    }

    static String readText$default(URL $this$readText_u24default, Charset charset, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$readText_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        String obj3 = new String(TextStreamsKt.readBytes($this$readText_u24default), obj1);
        return obj3;
    }

    private static final StringReader reader(String $this$reader) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        StringReader stringReader = new StringReader($this$reader);
        return stringReader;
    }

    public static final <T> T useLines(Reader $this$useLines, Function1<? super Sequence<String>, ? extends T> block) {
        Throwable th;
        Object bufferedReader;
        int apiVersionIsAtLeast2;
        boolean apiVersionIsAtLeast;
        Intrinsics.checkNotNullParameter($this$useLines, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        if ($this$useLines instanceof BufferedReader) {
            bufferedReader = $this$useLines;
        } else {
            bufferedReader = new BufferedReader($this$useLines, 8192);
        }
        final int i3 = 1;
        final int i4 = 0;
        if (PlatformImplementationsKt.apiVersionIsAtLeast(i3, i3, 0)) {
            CloseableKt.closeFinally(bufferedReader, 0);
        } else {
            bufferedReader.close();
        }
        return block.invoke(TextStreamsKt.lineSequence((BufferedReader)(Closeable)bufferedReader));
    }
}
