package f.c.a.d.b.h;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
final class y implements ValueEncoderContext {

    private boolean a = false;
    private boolean b = false;
    private FieldDescriptor c;
    private final u d;
    private final void b() throws EncodingException {
        if (this.a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        } else {
            this.a = true;
            return;
        }
    }

    public final ValueEncoderContext add(double d) {
        b();
        this.d.a(this.c, d, this.b);
        return this;
    }

    public final ValueEncoderContext add(float f) {
        b();
        this.d.b(this.c, f, this.b);
        return this;
    }

    public final ValueEncoderContext add(int i) {
        b();
        this.d.d(this.c, i, this.b);
        return this;
    }

    public final ValueEncoderContext add(long j) {
        b();
        this.d.e(this.c, j, this.b);
        return this;
    }

    public final ValueEncoderContext add(String str) {
        b();
        this.d.c(this.c, str, this.b);
        return this;
    }

    public final ValueEncoderContext add(boolean z) {
        b();
        this.d.d(this.c, z, this.b);
        return this;
    }

    public final ValueEncoderContext add(byte[] bArr) {
        b();
        this.d.c(this.c, bArr, this.b);
        return this;
    }

    y(u uVar) {
        super();
        this.d = uVar;
    }

    final void a(FieldDescriptor fieldDescriptor, boolean z) {
        this.a = false;
        this.c = fieldDescriptor;
        this.b = z;
    }
}
