package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BundleReader {

    protected static final int BUFFER_CAPACITY = 1024;
    private static final Charset UTF8_CHARSET;
    private ByteBuffer buffer;
    private final InputStream bundleInputStream;
    long bytesRead;
    private final InputStreamReader dataReader;
    com.google.firebase.firestore.bundle.BundleMetadata metadata;
    private final com.google.firebase.firestore.bundle.BundleSerializer serializer;
    static {
        BundleReader.UTF8_CHARSET = Charset.forName("UTF-8");
    }

    public BundleReader(com.google.firebase.firestore.bundle.BundleSerializer bundleSerializer, InputStream inputStream2) {
        super();
        this.serializer = bundleSerializer;
        this.bundleInputStream = inputStream2;
        InputStreamReader obj1 = new InputStreamReader(inputStream2);
        this.dataReader = obj1;
        obj1 = ByteBuffer.allocate(1024);
        this.buffer = obj1;
        obj1.flip();
    }

    private java.lang.IllegalArgumentException abort(String string) {
        close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid bundle: ");
        stringBuilder.append(string);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private com.google.firebase.firestore.bundle.BundleElement decodeBundleElement(String string) {
        JSONObject jSONObject = new JSONObject(string);
        String str = "metadata";
        final int i = 0;
        final String str10 = "BundleElement";
        if (jSONObject.has(str)) {
            Logger.debug(str10, "BundleMetadata element loaded", new Object[i]);
            return this.serializer.decodeBundleMetadata(jSONObject.getJSONObject(str));
        }
        String str2 = "namedQuery";
        if (jSONObject.has(str2)) {
            com.google.firebase.firestore.bundle.NamedQuery obj6 = this.serializer.decodeNamedQuery(jSONObject.getJSONObject(str2));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Query loaded: ");
            stringBuilder.append(obj6.getName());
            Logger.debug(str10, stringBuilder.toString(), new Object[i]);
            return obj6;
        }
        String str4 = "documentMetadata";
        if (jSONObject.has(str4)) {
            obj6 = this.serializer.decodeBundledDocumentMetadata(jSONObject.getJSONObject(str4));
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Document metadata loaded: ");
            stringBuilder4.append(obj6.getKey());
            Logger.debug(str10, stringBuilder4.toString(), new Object[i]);
            return obj6;
        }
        String str5 = "document";
        if (!jSONObject.has(str5)) {
        } else {
            obj6 = this.serializer.decodeDocument(jSONObject.getJSONObject(str5));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Document loaded: ");
            stringBuilder2.append(obj6.getKey());
            Logger.debug(str10, stringBuilder2.toString(), new Object[i]);
            return obj6;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Cannot decode unknown Bundle element: ");
        stringBuilder3.append(string);
        throw abort(stringBuilder3.toString());
    }

    private int indexOfOpenBracket() {
        int i;
        ByteBuffer remaining;
        int i2;
        this.buffer.mark();
        i = 0;
        while (i < this.buffer.remaining()) {
            if (this.buffer.get() != 123) {
                break;
            }
            i++;
        }
        i = -1;
        this.buffer.reset();
        return i;
    }

    private boolean pullMoreData() {
        int i;
        int buffer;
        int remaining;
        this.buffer.compact();
        int read = this.bundleInputStream.read(this.buffer.array(), arrayOffset += position, this.buffer.remaining());
        i = read > 0 ? 1 : 0;
        if (i != 0) {
            buffer = this.buffer;
            buffer.position(position2 += read);
        }
        this.buffer.flip();
        return i;
    }

    private String readJsonString(int i) {
        int i2;
        int pullMoreData;
        ByteBuffer buffer;
        int i3;
        int position;
        int obj6;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (obj6 > 0) {
            i2 = Math.min(obj6, this.buffer.remaining());
            byteArrayOutputStream.write(this.buffer.array(), arrayOffset += position, i2);
            buffer = this.buffer;
            buffer.position(position2 += i2);
            obj6 -= i2;
        }
        return byteArrayOutputStream.toString(BundleReader.UTF8_CHARSET.name());
    }

    private String readLengthPrefix() {
        boolean pullMoreData;
        int indexOfOpenBracket = indexOfOpenBracket();
        int i2 = -1;
        while (indexOfOpenBracket == i2) {
            if (pullMoreData()) {
            }
            indexOfOpenBracket = indexOfOpenBracket();
            i2 = -1;
        }
        if (this.buffer.remaining() == 0) {
            return null;
        }
        if (indexOfOpenBracket == i2) {
        } else {
            byte[] bArr = new byte[indexOfOpenBracket];
            this.buffer.get(bArr);
            return BundleReader.UTF8_CHARSET.decode(ByteBuffer.wrap(bArr)).toString();
        }
        throw abort("Reached the end of bundle when a length string is expected.");
    }

    private com.google.firebase.firestore.bundle.BundleElement readNextElement() {
        String lengthPrefix = readLengthPrefix();
        if (lengthPrefix == null) {
            return null;
        }
        final int int = Integer.parseInt(lengthPrefix);
        this.bytesRead = bytesRead += l;
        return decodeBundleElement(readJsonString(int));
    }

    public void close() {
        this.bundleInputStream.close();
    }

    public com.google.firebase.firestore.bundle.BundleMetadata getBundleMetadata() {
        com.google.firebase.firestore.bundle.BundleMetadata metadata = this.metadata;
        if (metadata != null) {
            return metadata;
        }
        com.google.firebase.firestore.bundle.BundleElement nextElement = readNextElement();
        if (nextElement instanceof BundleMetadata == null) {
        } else {
            this.metadata = (BundleMetadata)nextElement;
            this.bytesRead = 0;
            return nextElement;
        }
        throw abort("Expected first element in bundle to be a metadata object");
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public com.google.firebase.firestore.bundle.BundleElement getNextElement() {
        getBundleMetadata();
        return readNextElement();
    }
}
