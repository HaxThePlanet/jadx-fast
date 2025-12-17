package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ByteIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0017\u0010\u0007\u001a\u00020\u0008*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008\u001a\u0017\u0010\u000b\u001a\u00020\u000c*\u00020\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\u0008\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\u0008\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\u000c\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008¨\u0006\u001f", d2 = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ByteStreamsKt {
    private static final BufferedInputStream buffered(InputStream $this$buffered, int bufferSize) {
        Object bufferedInputStream;
        Intrinsics.checkNotNullParameter($this$buffered, "<this>");
        if ($this$buffered instanceof BufferedInputStream != null) {
            bufferedInputStream = $this$buffered;
        } else {
            bufferedInputStream = new BufferedInputStream($this$buffered, bufferSize);
        }
        return bufferedInputStream;
    }

    private static final BufferedOutputStream buffered(OutputStream $this$buffered, int bufferSize) {
        Object bufferedOutputStream;
        Intrinsics.checkNotNullParameter($this$buffered, "<this>");
        if ($this$buffered instanceof BufferedOutputStream != null) {
            bufferedOutputStream = $this$buffered;
        } else {
            bufferedOutputStream = new BufferedOutputStream($this$buffered, bufferSize);
        }
        return bufferedOutputStream;
    }

    static BufferedInputStream buffered$default(InputStream $this$buffered_u24default, int bufferSize, int i3, Object object4) {
        int obj1;
        Object obj2;
        if (i3 &= 1 != 0) {
            obj1 = 8192;
        }
        Intrinsics.checkNotNullParameter($this$buffered_u24default, "<this>");
        if ($this$buffered_u24default instanceof BufferedInputStream != null) {
            obj2 = $this$buffered_u24default;
        } else {
            obj2 = new BufferedInputStream($this$buffered_u24default, obj1);
        }
        return obj2;
    }

    static BufferedOutputStream buffered$default(OutputStream $this$buffered_u24default, int bufferSize, int i3, Object object4) {
        int obj1;
        Object obj2;
        if (i3 &= 1 != 0) {
            obj1 = 8192;
        }
        Intrinsics.checkNotNullParameter($this$buffered_u24default, "<this>");
        if ($this$buffered_u24default instanceof BufferedOutputStream != null) {
            obj2 = $this$buffered_u24default;
        } else {
            obj2 = new BufferedOutputStream($this$buffered_u24default, obj1);
        }
        return obj2;
    }

    private static final BufferedReader bufferedReader(InputStream $this$bufferedReader, Charset charset) {
        Object inputStreamReader;
        boolean bufferedReader;
        int i;
        Intrinsics.checkNotNullParameter($this$bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        inputStreamReader = new InputStreamReader($this$bufferedReader, charset);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
            inputStreamReader = bufferedReader;
        }
        return inputStreamReader;
    }

    static BufferedReader bufferedReader$default(InputStream $this$bufferedReader_u24default, Charset charset, int i3, Object object4) {
        int i;
        Charset obj2;
        Object obj3;
        boolean obj4;
        if (i3 &= 1 != 0) {
            obj2 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$bufferedReader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj2, "charset");
        obj3 = new InputStreamReader($this$bufferedReader_u24default, obj2);
        if (obj3 instanceof BufferedReader) {
        } else {
            obj4 = new BufferedReader((BufferedReader)(Reader)obj3, 8192);
            obj3 = obj4;
        }
        return obj3;
    }

    private static final BufferedWriter bufferedWriter(OutputStream $this$bufferedWriter, Charset charset) {
        Object outputStreamWriter;
        boolean bufferedWriter;
        int i;
        Intrinsics.checkNotNullParameter($this$bufferedWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        outputStreamWriter = new OutputStreamWriter($this$bufferedWriter, charset);
        if (outputStreamWriter instanceof BufferedWriter) {
        } else {
            bufferedWriter = new BufferedWriter((BufferedWriter)(Writer)outputStreamWriter, 8192);
            outputStreamWriter = bufferedWriter;
        }
        return outputStreamWriter;
    }

    static BufferedWriter bufferedWriter$default(OutputStream $this$bufferedWriter_u24default, Charset charset, int i3, Object object4) {
        int i;
        Charset obj2;
        Object obj3;
        boolean obj4;
        if (i3 &= 1 != 0) {
            obj2 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$bufferedWriter_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj2, "charset");
        obj3 = new OutputStreamWriter($this$bufferedWriter_u24default, obj2);
        if (obj3 instanceof BufferedWriter) {
        } else {
            obj4 = new BufferedWriter((BufferedWriter)(Writer)obj3, 8192);
            obj3 = obj4;
        }
        return obj3;
    }

    private static final ByteArrayInputStream byteInputStream(String $this$byteInputStream, Charset charset) {
        Intrinsics.checkNotNullParameter($this$byteInputStream, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final byte[] bytes = $this$byteInputStream.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return byteArrayInputStream;
    }

    static ByteArrayInputStream byteInputStream$default(String $this$byteInputStream_u24default, Charset charset, int i3, Object object4) {
        Charset obj2;
        if (i3 &= 1 != 0) {
            obj2 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$byteInputStream_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj2, "charset");
        final byte[] obj4 = $this$byteInputStream_u24default.getBytes(obj2);
        Intrinsics.checkNotNullExpressionValue(obj4, "getBytes(...)");
        ByteArrayInputStream obj3 = new ByteArrayInputStream(obj4);
        return obj3;
    }

    public static final long copyTo(InputStream $this$copyTo, OutputStream out, int bufferSize) {
        int bytesCopied;
        int bytes;
        long l;
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        bytesCopied = 0;
        final byte[] bArr = new byte[bufferSize];
        bytes = $this$copyTo.read(bArr);
        while (bytes >= 0) {
            out.write(bArr, 0, bytes);
            bytesCopied += l;
            bytes = $this$copyTo.read(bArr);
        }
        return bytesCopied;
    }

    public static long copyTo$default(InputStream inputStream, OutputStream outputStream2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 8192;
        }
        return ByteStreamsKt.copyTo(inputStream, outputStream2, obj2);
    }

    private static final ByteArrayInputStream inputStream(byte[] $this$inputStream) {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream($this$inputStream);
        return byteArrayInputStream;
    }

    private static final ByteArrayInputStream inputStream(byte[] $this$inputStream, int offset, int length) {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream($this$inputStream, offset, length);
        return byteArrayInputStream;
    }

    public static final ByteIterator iterator(BufferedInputStream $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        ByteStreamsKt.iterator.1 anon = new ByteStreamsKt.iterator.1($this$iterator);
        return (ByteIterator)anon;
    }

    public static final byte[] readBytes(InputStream $this$readBytes) {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, $this$readBytes.available()));
        ByteStreamsKt.copyTo$default($this$readBytes, (OutputStream)byteArrayOutputStream, 0, 2, 0);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] readBytes(InputStream $this$readBytes, int estimatedSize) {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(estimatedSize, $this$readBytes.available()));
        ByteStreamsKt.copyTo$default($this$readBytes, (OutputStream)byteArrayOutputStream, 0, 2, 0);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static byte[] readBytes$default(InputStream inputStream, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 8192;
        }
        return ByteStreamsKt.readBytes(inputStream, obj1);
    }

    private static final InputStreamReader reader(InputStream $this$reader, Charset charset) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader($this$reader, charset);
        return inputStreamReader;
    }

    static InputStreamReader reader$default(InputStream $this$reader_u24default, Charset charset, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$reader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        InputStreamReader obj2 = new InputStreamReader($this$reader_u24default, obj1);
        return obj2;
    }

    private static final OutputStreamWriter writer(OutputStream $this$writer, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter($this$writer, charset);
        return outputStreamWriter;
    }

    static OutputStreamWriter writer$default(OutputStream $this$writer_u24default, Charset charset, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$writer_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        OutputStreamWriter obj2 = new OutputStreamWriter($this$writer_u24default, obj1);
        return obj2;
    }
}
