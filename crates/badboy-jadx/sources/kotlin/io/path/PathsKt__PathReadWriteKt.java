package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000b2\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008\u001a\u001e\u0010\u000c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u00010\u001bH\u0087\u0008ø\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\u0008\u001a\u001d\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u001c0(*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u0010,\u001aL\u0010-\u001a\u0002H.\"\u0004\u0008\u0000\u0010.*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\u0004\u0012\u0002H.0\u001bH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000b2\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\u0008¢\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006;", d2 = {"appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", "lines", "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", "text", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", "T", "block", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathReadWriteKt {
    private static final void appendBytes(Path $this$appendBytes, byte[] array) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        OpenOption[] arr = new OpenOption[1];
        Files.write($this$appendBytes, array, StandardOpenOption.APPEND);
    }

    private static final Path appendLines(Path $this$appendLines, Iterable<? extends java.lang.CharSequence> lines, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendLines, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        OpenOption[] arr = new OpenOption[1];
        Path write = Files.write($this$appendLines, lines, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    private static final Path appendLines(Path $this$appendLines, Sequence<? extends java.lang.CharSequence> lines, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendLines, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        OpenOption[] arr = new OpenOption[1];
        Path write = Files.write($this$appendLines, SequencesKt.asIterable(lines), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    static Path appendLines$default(Path $this$appendLines_u24default, Iterable lines, Charset charset, int i4, Object object5) throws IOException {
        Charset obj3;
        if (i4 &= 2 != 0) {
            obj3 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$appendLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(obj3, "charset");
        OpenOption[] obj4 = new OpenOption[1];
        obj4 = Files.write($this$appendLines_u24default, lines, obj3, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(obj4, "write(...)");
        return obj4;
    }

    static Path appendLines$default(Path $this$appendLines_u24default, Sequence lines, Charset charset, int i4, Object object5) throws IOException {
        Charset obj4;
        if (i4 &= 2 != 0) {
            obj4 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$appendLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(obj4, "charset");
        OpenOption[] obj6 = new OpenOption[1];
        Path obj5 = Files.write($this$appendLines_u24default, SequencesKt.asIterable(lines), obj4, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(obj5, "write(...)");
        return obj5;
    }

    public static final void appendText(Path $this$appendText, java.lang.CharSequence text, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        OpenOption[] arr = new OpenOption[1];
        PathsKt.writeText($this$appendText, text, charset, StandardOpenOption.APPEND);
    }

    public static void appendText$default(Path path, java.lang.CharSequence charSequence2, Charset charset3, int i4, Object object5) throws IOException {
        Charset obj2;
        if (i4 &= 2 != 0) {
            obj2 = Charsets.UTF_8;
        }
        PathsKt.appendText(path, charSequence2, obj2);
    }

    private static final BufferedReader bufferedReader(Path $this$bufferedReader, Charset charset, int bufferSize, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream($this$bufferedReader, (OpenOption[])Arrays.copyOf(options, options.length)), charset);
        BufferedReader bufferedReader = new BufferedReader((Reader)inputStreamReader, bufferSize);
        return bufferedReader;
    }

    static BufferedReader bufferedReader$default(Path $this$bufferedReader_u24default, Charset charset, int bufferSize, OpenOption[] options, int i5, Object object6) throws IOException {
        Charset obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj2 = Charsets.UTF_8;
        }
        if (i5 &= 2 != 0) {
            obj3 = 8192;
        }
        Intrinsics.checkNotNullParameter($this$bufferedReader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj2, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStreamReader obj6 = new InputStreamReader(Files.newInputStream($this$bufferedReader_u24default, (OpenOption[])Arrays.copyOf(options, options.length)), obj2);
        BufferedReader obj5 = new BufferedReader((Reader)obj6, obj3);
        return obj5;
    }

    private static final BufferedWriter bufferedWriter(Path $this$bufferedWriter, Charset charset, int bufferSize, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$bufferedWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream($this$bufferedWriter, (OpenOption[])Arrays.copyOf(options, options.length)), charset);
        BufferedWriter bufferedWriter = new BufferedWriter((Writer)outputStreamWriter, bufferSize);
        return bufferedWriter;
    }

    static BufferedWriter bufferedWriter$default(Path $this$bufferedWriter_u24default, Charset charset, int bufferSize, OpenOption[] options, int i5, Object object6) throws IOException {
        Charset obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj2 = Charsets.UTF_8;
        }
        if (i5 &= 2 != 0) {
            obj3 = 8192;
        }
        Intrinsics.checkNotNullParameter($this$bufferedWriter_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj2, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStreamWriter obj6 = new OutputStreamWriter(Files.newOutputStream($this$bufferedWriter_u24default, (OpenOption[])Arrays.copyOf(options, options.length)), obj2);
        BufferedWriter obj5 = new BufferedWriter((Writer)obj6, obj3);
        return obj5;
    }

    private static final void forEachLine(Path $this$forEachLine, Charset charset, Function1<? super String, Unit> action) throws IOException {
        Throwable th;
        boolean apiVersionIsAtLeast;
        Object next;
        Intrinsics.checkNotNullParameter($this$forEachLine, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(action, "action");
        BufferedReader bufferedReader = Files.newBufferedReader($this$forEachLine, charset);
        Intrinsics.checkNotNullExpressionValue(bufferedReader, "newBufferedReader(...)");
        int i = 0;
        final BufferedReader reader = bufferedReader;
        final int i3 = 1;
        final int i4 = 0;
        final int i5 = 0;
        final int i6 = 0;
        final Iterator iterator = TextStreamsKt.lineSequence((BufferedReader)(Closeable)(BufferedReader)reader).iterator();
        for (Object next : iterator) {
            action.invoke(next);
        }
        Unit it = Unit.INSTANCE;
        if (PlatformImplementationsKt.apiVersionIsAtLeast(i3, i3, 0)) {
            CloseableKt.closeFinally(reader, 0);
        } else {
            reader.close();
        }
    }

    static void forEachLine$default(Path $this$forEachLine_u24default, Charset charset, Function1 action, int i4, Object object5) throws IOException {
        Object next;
        Charset obj12;
        boolean obj15;
        obj15 = 1;
        if (i4 &= obj15 != 0) {
            obj12 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$forEachLine_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj12, "charset");
        Intrinsics.checkNotNullParameter(action, "action");
        BufferedReader obj14 = Files.newBufferedReader($this$forEachLine_u24default, obj12);
        Intrinsics.checkNotNullExpressionValue(obj14, "newBufferedReader(...)");
        int i = 0;
        final BufferedReader reader = obj14;
        final int i3 = 0;
        final int i5 = 0;
        final int i6 = 0;
        final Iterator iterator = TextStreamsKt.lineSequence((BufferedReader)(Closeable)(BufferedReader)reader).iterator();
        for (Object next : iterator) {
            action.invoke(next);
        }
        Unit it = Unit.INSTANCE;
        if (PlatformImplementationsKt.apiVersionIsAtLeast(obj15, obj15, 0)) {
            CloseableKt.closeFinally(reader, 0);
        } else {
            reader.close();
        }
    }

    private static final InputStream inputStream(Path $this$inputStream, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStream inputStream = Files.newInputStream($this$inputStream, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(inputStream, "newInputStream(...)");
        return inputStream;
    }

    private static final OutputStream outputStream(Path $this$outputStream, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$outputStream, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream outputStream = Files.newOutputStream($this$outputStream, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(outputStream, "newOutputStream(...)");
        return outputStream;
    }

    private static final byte[] readBytes(Path $this$readBytes) throws IOException {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        byte[] allBytes = Files.readAllBytes($this$readBytes);
        Intrinsics.checkNotNullExpressionValue(allBytes, "readAllBytes(...)");
        return allBytes;
    }

    private static final List<String> readLines(Path $this$readLines, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$readLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        List allLines = Files.readAllLines($this$readLines, charset);
        Intrinsics.checkNotNullExpressionValue(allLines, "readAllLines(...)");
        return allLines;
    }

    static List readLines$default(Path $this$readLines_u24default, Charset charset, int i3, Object object4) throws IOException {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$readLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        List obj2 = Files.readAllLines($this$readLines_u24default, obj1);
        Intrinsics.checkNotNullExpressionValue(obj2, "readAllLines(...)");
        return obj2;
    }

    public static final String readText(Path $this$readText, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        int i = 0;
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream($this$readText, (OpenOption[])Arrays.copyOf(new OpenOption[i], i)), charset);
        int i2 = 0;
        CloseableKt.closeFinally(inputStreamReader, 0);
        return TextStreamsKt.readText((Reader)(InputStreamReader)(Closeable)inputStreamReader);
    }

    public static String readText$default(Path path, Charset charset2, int i3, Object object4) throws IOException {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        return PathsKt.readText(path, obj1);
    }

    private static final InputStreamReader reader(Path $this$reader, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream($this$reader, (OpenOption[])Arrays.copyOf(options, options.length)), charset);
        return inputStreamReader;
    }

    static InputStreamReader reader$default(Path $this$reader_u24default, Charset charset, OpenOption[] options, int i4, Object object5) throws IOException {
        Charset obj1;
        if (i4 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$reader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStreamReader obj3 = new InputStreamReader(Files.newInputStream($this$reader_u24default, (OpenOption[])Arrays.copyOf(options, options.length)), obj1);
        return obj3;
    }

    private static final <T> T useLines(Path $this$useLines, Charset charset, Function1<? super Sequence<String>, ? extends T> block) throws IOException {
        int apiVersionIsAtLeast;
        Intrinsics.checkNotNullParameter($this$useLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        BufferedReader bufferedReader = Files.newBufferedReader($this$useLines, charset);
        final int i2 = 1;
        final BufferedReader reader = bufferedReader;
        final int i3 = 0;
        Intrinsics.checkNotNull((BufferedReader)reader);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(i2, i2, 0)) {
            CloseableKt.closeFinally((Closeable)bufferedReader, 0);
        } else {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return block.invoke(TextStreamsKt.lineSequence(reader));
    }

    static Object useLines$default(Path $this$useLines_u24default, Charset charset, Function1 block, int i4, Object object5) throws IOException {
        Charset obj5;
        int obj8;
        obj8 = 1;
        if (i4 &= obj8 != 0) {
            obj5 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$useLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj5, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        BufferedReader obj7 = Files.newBufferedReader($this$useLines_u24default, obj5);
        final BufferedReader reader = obj7;
        final int i2 = 0;
        Intrinsics.checkNotNull((BufferedReader)reader);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(obj8, obj8, 0)) {
            CloseableKt.closeFinally((Closeable)obj7, 0);
        } else {
            if (obj7 != null) {
                obj7.close();
            }
        }
        return block.invoke(TextStreamsKt.lineSequence(reader));
    }

    private static final void writeBytes(Path $this$writeBytes, byte[] array, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(options, "options");
        Files.write($this$writeBytes, array, (OpenOption[])Arrays.copyOf(options, options.length));
    }

    private static final Path writeLines(Path $this$writeLines, Iterable<? extends java.lang.CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeLines, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        Path write = Files.write($this$writeLines, lines, charset, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    private static final Path writeLines(Path $this$writeLines, Sequence<? extends java.lang.CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeLines, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        Path write = Files.write($this$writeLines, SequencesKt.asIterable(lines), charset, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    static Path writeLines$default(Path $this$writeLines_u24default, Iterable lines, Charset charset, OpenOption[] options, int i5, Object object6) throws IOException {
        Charset obj2;
        if (i5 &= 2 != 0) {
            obj2 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$writeLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(obj2, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        Path obj4 = Files.write($this$writeLines_u24default, lines, obj2, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(obj4, "write(...)");
        return obj4;
    }

    static Path writeLines$default(Path $this$writeLines_u24default, Sequence lines, Charset charset, OpenOption[] options, int i5, Object object6) throws IOException {
        Charset obj2;
        if (i5 &= 2 != 0) {
            obj2 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$writeLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(obj2, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        Path obj4 = Files.write($this$writeLines_u24default, SequencesKt.asIterable(lines), obj2, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(obj4, "write(...)");
        return obj4;
    }

    public static final void writeText(Path $this$writeText, java.lang.CharSequence text, Charset charset, OpenOption... options) throws IOException {
        Object replaceEncoder;
        CharBuffer readOnlyBuffer;
        ByteBuffer byteBufferForEncoding;
        boolean remaining;
        int array;
        int position;
        int i;
        Intrinsics.checkNotNullParameter($this$writeText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream outputStream = Files.newOutputStream($this$writeText, (OpenOption[])Arrays.copyOf(options, options.length));
        OutputStream outputStream2 = outputStream;
        final int i3 = 0;
        if (text instanceof String != null) {
            Intrinsics.checkNotNull((OutputStream)outputStream2);
            FilesKt.writeTextImpl(outputStream2, (String)text, charset);
        } else {
            replaceEncoder = FilesKt.newReplaceEncoder(charset);
            if (text instanceof CharBuffer) {
                readOnlyBuffer = (CharBuffer)text.asReadOnlyBuffer();
            } else {
                readOnlyBuffer = CharBuffer.wrap(text);
            }
            Intrinsics.checkNotNull(replaceEncoder);
            byteBufferForEncoding = FilesKt.byteBufferForEncoding(Math.min(text.length(), 8192), replaceEncoder);
            while (readOnlyBuffer.hasRemaining()) {
                int i6 = 0;
                outputStream2.write(byteBufferForEncoding.array(), 0, byteBufferForEncoding.position());
                byteBufferForEncoding.clear();
            }
        }
        Unit out = Unit.INSTANCE;
        CloseableKt.closeFinally((Closeable)outputStream, 0);
    }

    public static void writeText$default(Path path, java.lang.CharSequence charSequence2, Charset charset3, OpenOption[] openOption4Arr4, int i5, Object object6) throws IOException {
        Charset obj2;
        if (i5 &= 2 != 0) {
            obj2 = Charsets.UTF_8;
        }
        PathsKt.writeText(path, charSequence2, obj2, openOption4Arr4);
    }

    private static final OutputStreamWriter writer(Path $this$writer, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream($this$writer, (OpenOption[])Arrays.copyOf(options, options.length)), charset);
        return outputStreamWriter;
    }

    static OutputStreamWriter writer$default(Path $this$writer_u24default, Charset charset, OpenOption[] options, int i4, Object object5) throws IOException {
        Charset obj1;
        if (i4 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$writer_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStreamWriter obj3 = new OutputStreamWriter(Files.newOutputStream($this$writer_u24default, (OpenOption[])Arrays.copyOf(options, options.length)), obj1);
        return obj3;
    }
}
