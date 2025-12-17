package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\u0008\u001a!\u0010\u0013\u001a\u00020\u0014*\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\u0008\u001aB\u0010\u0015\u001a\u00020\u0007*\u00020\u000826\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001aJ\u0010\u0015\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\u001c\u001a\u00020\u000326\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001a7\u0010\u001d\u001a\u00020\u0007*\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u00070\u001e\u001a\r\u0010 \u001a\u00020!*\u00020\u0008H\u0087\u0008\u001a\u0014\u0010\"\u001a\n #*\u0004\u0018\u00010\u00050\u0005*\u00020\u000fH\u0000\u001a\r\u0010$\u001a\u00020%*\u00020\u0008H\u0087\u0008\u001a\u0017\u0010&\u001a\u00020'*\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u001a\n\u0010(\u001a\u00020\n*\u00020\u0008\u001a\u001a\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\r0**\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010+\u001a\u00020\r*\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0017\u0010,\u001a\u00020-*\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u001aL\u0010.\u001a\u0002H/\"\u0004\u0008\u0000\u0010/*\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0018\u00100\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r01\u0012\u0004\u0012\u0002H/0\u001eH\u0086\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00102\u001a\u0012\u00103\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u00104\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u001c\u00105\u001a\u00020\u0007*\u0002062\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0017\u00107\u001a\u000208*\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00069", d2 = {"byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "", "encoder", "Ljava/nio/charset/CharsetEncoder;", "appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "newReplaceEncoder", "kotlin.jvm.PlatformType", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writeTextImpl", "Ljava/io/OutputStream;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt extends kotlin.io.FilesKt__FilePathComponentsKt {
    public static final void appendBytes(File $this$appendBytes, byte[] array) {
        Intrinsics.checkNotNullParameter($this$appendBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream($this$appendBytes, 1);
        final int i3 = 0;
        (FileOutputStream)(Closeable)fileOutputStream.write(array);
        Unit it = Unit.INSTANCE;
        CloseableKt.closeFinally(fileOutputStream, 0);
    }

    public static final void appendText(File $this$appendText, String text, Charset charset) {
        Intrinsics.checkNotNullParameter($this$appendText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream($this$appendText, 1);
        final int i3 = 0;
        FilesKt.writeTextImpl((OutputStream)(FileOutputStream)(Closeable)fileOutputStream, text, charset);
        Unit it = Unit.INSTANCE;
        CloseableKt.closeFinally(fileOutputStream, 0);
    }

    public static void appendText$default(File file, String string2, Charset charset3, int i4, Object object5) {
        Charset obj2;
        if (i4 &= 2 != 0) {
            obj2 = Charsets.UTF_8;
        }
        FilesKt.appendText(file, string2, obj2);
    }

    private static final BufferedReader bufferedReader(File $this$bufferedReader, Charset charset, int bufferSize) {
        Object inputStreamReader;
        boolean bufferedReader;
        Intrinsics.checkNotNullParameter($this$bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileInputStream fileInputStream = new FileInputStream($this$bufferedReader);
        inputStreamReader = new InputStreamReader((InputStream)fileInputStream, charset);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, bufferSize);
            inputStreamReader = bufferedReader;
        }
        return inputStreamReader;
    }

    static BufferedReader bufferedReader$default(File $this$bufferedReader_u24default, Charset charset, int bufferSize, int i4, Object object5) {
        Charset obj1;
        int obj2;
        Object obj3;
        BufferedReader obj4;
        if (i4 & 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        if (i4 &= 2 != 0) {
            obj2 = 8192;
        }
        Intrinsics.checkNotNullParameter($this$bufferedReader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        obj4 = new FileInputStream($this$bufferedReader_u24default);
        obj3 = new InputStreamReader((InputStream)obj4, obj1);
        if (obj3 instanceof BufferedReader) {
        } else {
            obj4 = new BufferedReader((BufferedReader)(Reader)obj3, obj2);
            obj3 = obj4;
        }
        return obj3;
    }

    private static final BufferedWriter bufferedWriter(File $this$bufferedWriter, Charset charset, int bufferSize) {
        Object outputStreamWriter;
        boolean bufferedWriter;
        Intrinsics.checkNotNullParameter($this$bufferedWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream($this$bufferedWriter);
        outputStreamWriter = new OutputStreamWriter((OutputStream)fileOutputStream, charset);
        if (outputStreamWriter instanceof BufferedWriter) {
        } else {
            bufferedWriter = new BufferedWriter((BufferedWriter)(Writer)outputStreamWriter, bufferSize);
            outputStreamWriter = bufferedWriter;
        }
        return outputStreamWriter;
    }

    static BufferedWriter bufferedWriter$default(File $this$bufferedWriter_u24default, Charset charset, int bufferSize, int i4, Object object5) {
        Charset obj1;
        int obj2;
        Object obj3;
        BufferedWriter obj4;
        if (i4 & 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        if (i4 &= 2 != 0) {
            obj2 = 8192;
        }
        Intrinsics.checkNotNullParameter($this$bufferedWriter_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        obj4 = new FileOutputStream($this$bufferedWriter_u24default);
        obj3 = new OutputStreamWriter((OutputStream)obj4, obj1);
        if (obj3 instanceof BufferedWriter) {
        } else {
            obj4 = new BufferedWriter((BufferedWriter)(Writer)obj3, obj2);
            obj3 = obj4;
        }
        return obj3;
    }

    public static final ByteBuffer byteBufferForEncoding(int chunkSize, CharsetEncoder encoder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        ByteBuffer allocate = ByteBuffer.allocate(chunkSize * i);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(...)");
        return allocate;
    }

    public static final void forEachBlock(File $this$forEachBlock, int blockSize, Function2<? super byte[], ? super Integer, Unit> action) {
        int read;
        Integer valueOf;
        Intrinsics.checkNotNullParameter($this$forEachBlock, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        byte[] bArr = new byte[RangesKt.coerceAtLeast(blockSize, 512)];
        FileInputStream fileInputStream = new FileInputStream($this$forEachBlock);
        final int i3 = 0;
        read = (FileInputStream)(Closeable)fileInputStream.read(bArr);
        while (read <= 0) {
            action.invoke(bArr, Integer.valueOf(read));
            read = inputStream.read(bArr);
        }
        Unit input2 = Unit.INSTANCE;
        CloseableKt.closeFinally(fileInputStream, 0);
    }

    public static final void forEachBlock(File $this$forEachBlock, Function2<? super byte[], ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachBlock, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        FilesKt.forEachBlock($this$forEachBlock, 4096, action);
    }

    public static final void forEachLine(File $this$forEachLine, Charset charset, Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachLine, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(action, "action");
        FileInputStream fileInputStream = new FileInputStream($this$forEachLine);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)fileInputStream, charset);
        BufferedReader bufferedReader = new BufferedReader((Reader)inputStreamReader);
        TextStreamsKt.forEachLine((Reader)bufferedReader, action);
    }

    public static void forEachLine$default(File file, Charset charset2, Function1 function13, int i4, Object object5) {
        Charset obj1;
        if (i4 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        FilesKt.forEachLine(file, obj1, function13);
    }

    private static final FileInputStream inputStream(File $this$inputStream) {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        FileInputStream fileInputStream = new FileInputStream($this$inputStream);
        return fileInputStream;
    }

    public static final CharsetEncoder newReplaceEncoder(Charset $this$newReplaceEncoder) {
        Intrinsics.checkNotNullParameter($this$newReplaceEncoder, "<this>");
        return $this$newReplaceEncoder.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private static final FileOutputStream outputStream(File $this$outputStream) {
        Intrinsics.checkNotNullParameter($this$outputStream, "<this>");
        FileOutputStream fileOutputStream = new FileOutputStream($this$outputStream);
        return fileOutputStream;
    }

    private static final PrintWriter printWriter(File $this$printWriter, Charset charset) {
        Object outputStreamWriter;
        boolean bufferedWriter;
        int i;
        Intrinsics.checkNotNullParameter($this$printWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream($this$printWriter);
        outputStreamWriter = new OutputStreamWriter((OutputStream)fileOutputStream, charset);
        if (outputStreamWriter instanceof BufferedWriter) {
        } else {
            bufferedWriter = new BufferedWriter((BufferedWriter)(Writer)outputStreamWriter, 8192);
            outputStreamWriter = bufferedWriter;
        }
        PrintWriter printWriter = new PrintWriter((Writer)outputStreamWriter);
        return printWriter;
    }

    static PrintWriter printWriter$default(File $this$printWriter_u24default, Charset charset, int i3, Object object4) {
        boolean bufferedWriter;
        int i;
        Charset obj3;
        Object obj5;
        if (i3 &= 1 != 0) {
            obj3 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$printWriter_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj3, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream($this$printWriter_u24default);
        obj5 = new OutputStreamWriter((OutputStream)fileOutputStream, obj3);
        if (obj5 instanceof BufferedWriter) {
        } else {
            bufferedWriter = new BufferedWriter((BufferedWriter)(Writer)obj5, 8192);
            obj5 = bufferedWriter;
        }
        PrintWriter obj4 = new PrintWriter((Writer)obj5);
        return obj4;
    }

    public static final byte[] readBytes(File $this$readBytes) {
        int offset;
        int remaining;
        byte[] result;
        long read;
        byte[] copyInto;
        int copyOf;
        kotlin.io.ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream;
        byte[] buffer;
        int i;
        byte[] copyOf2;
        int size;
        int i2;
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        FileInputStream fileInputStream = new FileInputStream($this$readBytes);
        final FileInputStream inputStream = fileInputStream;
        final int i3 = 0;
        offset = 0;
        long length = $this$readBytes.length();
        read = length;
        int i5 = 0;
        buffer = "File ";
        if (Long.compare(read, i6) > 0) {
        } else {
            result = new byte[(int)length];
            while (remaining > 0) {
                read = (FileInputStream)inputStream.read(result, offset, remaining);
                if (read >= 0) {
                }
                remaining -= read;
                offset += read;
            }
            copyInto = "copyOf(...)";
            int i4 = 0;
            if (remaining > 0) {
                copyOf = Arrays.copyOf(result, offset);
                Intrinsics.checkNotNullExpressionValue(copyOf, copyInto);
                result = copyOf;
                CloseableKt.closeFinally((Closeable)fileInputStream, i4);
                return result;
            } else {
                copyOf = inputStream.read();
                if (copyOf == -1) {
                } else {
                    exposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
                    exposingBufferByteArrayOutputStream.write(copyOf);
                    i2 = 0;
                    ByteStreamsKt.copyTo$default((InputStream)inputStream, (OutputStream)exposingBufferByteArrayOutputStream, i2, 2, i4);
                    length3 += size2;
                    if (i < 0) {
                    } else {
                        copyOf2 = Arrays.copyOf(result, i);
                        Intrinsics.checkNotNullExpressionValue(copyOf2, copyInto);
                        result = copyInto;
                    }
                }
            }
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                OutOfMemoryError outOfMemoryError = new OutOfMemoryError(stringBuilder2.append(buffer).append($this$readBytes).append(" is too big to fit in memory.").toString());
                throw outOfMemoryError;
                StringBuilder stringBuilder = new StringBuilder();
                OutOfMemoryError remaining2 = new OutOfMemoryError(stringBuilder.append(buffer).append($this$readBytes).append(" is too big (").append(read).append(" bytes) to fit in memory.").toString());
                throw remaining2;
                throw input;
                CloseableKt.closeFinally(obj0, input);
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    public static final List<String> readLines(File $this$readLines, Charset charset) {
        Intrinsics.checkNotNullParameter($this$readLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        ArrayList arrayList = new ArrayList();
        FilesKt__FileReadWriteKt.readLines.1 anon = new FilesKt__FileReadWriteKt.readLines.1(arrayList);
        FilesKt.forEachLine($this$readLines, charset, (Function1)anon);
        return (List)arrayList;
    }

    public static List readLines$default(File file, Charset charset2, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        return FilesKt.readLines(file, obj1);
    }

    public static final String readText(File $this$readText, Charset charset) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileInputStream fileInputStream = new FileInputStream($this$readText);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)fileInputStream, charset);
        final int i = 0;
        CloseableKt.closeFinally(inputStreamReader, 0);
        return TextStreamsKt.readText((Reader)(InputStreamReader)(Closeable)inputStreamReader);
    }

    public static String readText$default(File file, Charset charset2, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        return FilesKt.readText(file, obj1);
    }

    private static final InputStreamReader reader(File $this$reader, Charset charset) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileInputStream fileInputStream = new FileInputStream($this$reader);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)fileInputStream, charset);
        return inputStreamReader;
    }

    static InputStreamReader reader$default(File $this$reader_u24default, Charset charset, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$reader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        FileInputStream obj3 = new FileInputStream($this$reader_u24default);
        InputStreamReader obj2 = new InputStreamReader((InputStream)obj3, obj1);
        return obj2;
    }

    public static final <T> T useLines(File $this$useLines, Charset charset, Function1<? super Sequence<String>, ? extends T> block) {
        Throwable th;
        Object inputStreamReader;
        boolean bufferedReader;
        boolean apiVersionIsAtLeast;
        int i;
        Intrinsics.checkNotNullParameter($this$useLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        FileInputStream fileInputStream = new FileInputStream($this$useLines);
        inputStreamReader = new InputStreamReader((InputStream)fileInputStream, charset);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
            inputStreamReader = bufferedReader;
        }
        int i4 = 1;
        final int i5 = 0;
        if (PlatformImplementationsKt.apiVersionIsAtLeast(i4, i4, 0)) {
            CloseableKt.closeFinally(inputStreamReader, 0);
        } else {
            inputStreamReader.close();
        }
        return block.invoke(TextStreamsKt.lineSequence((BufferedReader)(Closeable)inputStreamReader));
    }

    public static Object useLines$default(File $this$useLines_u24default, Charset charset, Function1 block, int i4, Object object5) {
        Object inputStreamReader;
        boolean bufferedReader;
        int th;
        Charset obj6;
        boolean obj9;
        obj9 = 1;
        if (i4 &= obj9 != 0) {
            obj6 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$useLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj6, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        int obj8 = 0;
        FileInputStream fileInputStream = new FileInputStream($this$useLines_u24default);
        inputStreamReader = new InputStreamReader((InputStream)fileInputStream, obj6);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
            inputStreamReader = bufferedReader;
        }
        final int i2 = 0;
        if (PlatformImplementationsKt.apiVersionIsAtLeast(obj9, obj9, 0)) {
            CloseableKt.closeFinally(inputStreamReader, 0);
        } else {
            inputStreamReader.close();
        }
        return block.invoke(TextStreamsKt.lineSequence((BufferedReader)(Closeable)inputStreamReader));
    }

    public static final void writeBytes(File $this$writeBytes, byte[] array) {
        Intrinsics.checkNotNullParameter($this$writeBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream($this$writeBytes);
        final int i2 = 0;
        (FileOutputStream)(Closeable)fileOutputStream.write(array);
        Unit it = Unit.INSTANCE;
        CloseableKt.closeFinally(fileOutputStream, 0);
    }

    public static final void writeText(File $this$writeText, String text, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writeText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream($this$writeText);
        final int i2 = 0;
        FilesKt.writeTextImpl((OutputStream)(FileOutputStream)(Closeable)fileOutputStream, text, charset);
        Unit it = Unit.INSTANCE;
        CloseableKt.closeFinally(fileOutputStream, 0);
    }

    public static void writeText$default(File file, String string2, Charset charset3, int i4, Object object5) {
        Charset obj2;
        if (i4 &= 2 != 0) {
            obj2 = Charsets.UTF_8;
        }
        FilesKt.writeText(file, string2, obj2);
    }

    public static final void writeTextImpl(OutputStream $this$writeTextImpl, String text, Charset charset) {
        int startIndex;
        int leftover;
        int i4;
        int i2;
        int position;
        int i3;
        int i;
        int limit;
        boolean underflow;
        Intrinsics.checkNotNullParameter($this$writeTextImpl, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        int i5 = 8192;
        if (text.length() < i5 * 2) {
            byte[] bytes = text.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            $this$writeTextImpl.write(bytes);
        }
        CharsetEncoder replaceEncoder = FilesKt.newReplaceEncoder(charset);
        CharBuffer allocate = CharBuffer.allocate(i5);
        Intrinsics.checkNotNull(replaceEncoder);
        final ByteBuffer byteBufferForEncoding = FilesKt.byteBufferForEncoding(i5, replaceEncoder);
        startIndex = 0;
        leftover = 0;
        while (startIndex < text.length()) {
            i4 = Math.min(i5 - leftover, length3 -= startIndex);
            i2 = startIndex + i4;
            char[] array = allocate.array();
            Intrinsics.checkNotNullExpressionValue(array, "array(...)");
            text.getChars(startIndex, i2, array, leftover);
            allocate.limit(i4 + leftover);
            i = 0;
            if (i2 == text.length()) {
            } else {
            }
            i3 = i;
            int i10 = 0;
            $this$writeTextImpl.write(byteBufferForEncoding.array(), i, byteBufferForEncoding.position());
            if (allocate.position() != allocate.limit()) {
            } else {
            }
            leftover = 0;
            allocate.clear();
            byteBufferForEncoding.clear();
            startIndex = i2;
            allocate.put(i, allocate.get());
            leftover = 1;
            i3 = 1;
        }
    }

    private static final OutputStreamWriter writer(File $this$writer, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream($this$writer);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)fileOutputStream, charset);
        return outputStreamWriter;
    }

    static OutputStreamWriter writer$default(File $this$writer_u24default, Charset charset, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$writer_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        FileOutputStream obj3 = new FileOutputStream($this$writer_u24default);
        OutputStreamWriter obj2 = new OutputStreamWriter((OutputStream)obj3, obj1);
        return obj2;
    }
}
