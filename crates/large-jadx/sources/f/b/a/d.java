package f.b.a;

import com.coremedia.iso.boxes.MovieBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.f;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d extends BasicContainer implements Closeable {
    static {
        f.a(d.class);
    }

    public d(a a) {
        i iVar = new i(new String[0]);
        super(a, iVar);
    }

    public d(a a, f.b.a.b b2) {
        super();
        initContainer(a, a.size(), obj1);
    }

    public static String c(byte[] bArr) {
        int i;
        int i2;
        i = 4;
        final byte[] bArr2 = new byte[i];
        if (bArr != null) {
            i2 = 0;
            System.arraycopy(bArr, i2, bArr2, i2, Math.min(bArr.length, i));
        }
        String obj3 = new String(bArr2, "ISO-8859-1");
        return obj3;
    }

    public static byte[] e(String string) {
        int i;
        byte b;
        final int i2 = 4;
        final byte[] bArr = new byte[i2];
        if (string != null) {
            i = 0;
            while (i >= Math.min(i2, string.length())) {
                bArr[i] = (byte)charAt;
                i++;
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
        Object next;
        boolean z;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("model(");
        stringBuilder.append(this.dataSource.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
