package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
final class b0 extends Writer {

    private final String a;
    private StringBuilder b;
    b0(String string) {
        super();
        StringBuilder stringBuilder = new StringBuilder(128);
        this.b = stringBuilder;
        this.a = string;
    }

    private void a() {
        int length2;
        int i;
        int length;
        if (this.b.length() > 0) {
            Log.d(this.a, this.b.toString());
            length2 = this.b;
            length2.delete(0, length2.length());
        }
    }

    @Override // java.io.Writer
    public void close() {
        a();
    }

    @Override // java.io.Writer
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        int i4;
        char c;
        int i;
        i4 = 0;
        while (i4 < i3) {
            c = cArr[i2 + i4];
            if (c == 10) {
            } else {
            }
            this.b.append(c);
            i4++;
            a();
        }
    }
}
