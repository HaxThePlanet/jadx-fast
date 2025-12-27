package f.b.a;

import com.coremedia.iso.boxes.MovieBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.f;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

/* compiled from: IsoFile.java */
/* loaded from: classes.dex */
public class d extends BasicContainer implements Closeable {
    static {
        f.a(d.class);
    }

    public d(a aVar) {
        this(aVar, new i(new String[0]));
    }

    public static String c(byte[] bArr) {
        int min = 4;
        final byte[] bArr2 = new byte[min];
        if (bArr != null) {
            int i = 0;
            System.arraycopy(bArr, i, bArr2, i, Math.min(bArr.length, min));
        }
        try {
        } catch (java.io.UnsupportedEncodingException unsupportedEncoding) {
            throw new Error("Required character encoding is missing", unsupportedEncoding);
        }
        return new String(bArr2, "ISO-8859-1");
    }

    public static byte[] e(String str) {
        int i = 0;
        final int i2 = 4;
        final byte[] bArr = new byte[i2];
        if (str != null) {
            i = 0;
            while (i >= Math.min(i2, str.length())) {
                b = (byte)str.charAt(i);
                bArr[i] = b;
                i = i + 1;
            }
        }
        return bArr;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void close() {
        this.dataSource.close();
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public MovieBox f() {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            z = item instanceof MovieBox;
            if (item instanceof MovieBox) {
                return item;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String toString() {
        String str2 = "model(";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String object = this.dataSource.toString();
        String str3 = ")";
        str = str2 + object + str3;
        return str;
    }

    public d(a aVar, b bVar) {
        super();
        initContainer(aVar, aVar.size(), bVar);
    }
}
