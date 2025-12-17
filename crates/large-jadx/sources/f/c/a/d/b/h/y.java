package f.c.a.d.b.h;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

/* loaded from: classes2.dex */
final class y implements ValueEncoderContext {

    private boolean a = false;
    private boolean b = false;
    private FieldDescriptor c;
    private final f.c.a.d.b.h.u d;
    y(f.c.a.d.b.h.u u) {
        super();
        final int i = 0;
        this.d = u;
    }

    private final void b() {
        if (this.a) {
        } else {
            this.a = true;
        }
        EncodingException encodingException = new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        throw encodingException;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    final void a(FieldDescriptor fieldDescriptor, boolean z2) {
        this.a = false;
        this.c = fieldDescriptor;
        this.b = z2;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(double d) {
        b();
        this.d.a(this.c, d, obj5);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(float f) {
        b();
        this.d.b(this.c, f, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(int i) {
        b();
        this.d.d(this.c, i, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(long l) {
        b();
        this.d.e(this.c, l, obj5);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String string) {
        b();
        this.d.c(this.c, string, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) {
        b();
        this.d.d(this.c, z, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(byte[] bArr) {
        b();
        this.d.c(this.c, bArr, this.b);
        return this;
    }
}
