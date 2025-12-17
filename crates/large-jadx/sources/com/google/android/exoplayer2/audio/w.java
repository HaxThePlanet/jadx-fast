package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public abstract class w implements com.google.android.exoplayer2.audio.AudioProcessor {

    protected com.google.android.exoplayer2.audio.AudioProcessor.a b;
    protected com.google.android.exoplayer2.audio.AudioProcessor.a c;
    private com.google.android.exoplayer2.audio.AudioProcessor.a d;
    private com.google.android.exoplayer2.audio.AudioProcessor.a e;
    private ByteBuffer f;
    private ByteBuffer g;
    private boolean h;
    public w() {
        super();
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.f = byteBuffer;
        this.g = byteBuffer;
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar = AudioProcessor.a.e;
        this.d = aVar;
        this.e = aVar;
        this.b = aVar;
        this.c = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean a() {
        int i;
        i = this.e != AudioProcessor.a.e ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer b() {
        this.g = AudioProcessor.a;
        return this.g;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean c() {
        boolean z;
        int i;
        ByteBuffer byteBuffer;
        if (this.h && this.g == AudioProcessor.a) {
            i = this.g == AudioProcessor.a ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final com.google.android.exoplayer2.audio.AudioProcessor.a e(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a) {
        com.google.android.exoplayer2.audio.AudioProcessor.a obj1;
        this.d = a;
        this.e = h(a);
        obj1 = a() ? this.e : AudioProcessor.a.e;
        return obj1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void f() {
        this.h = true;
        j();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.g = AudioProcessor.a;
        this.h = false;
        this.b = this.d;
        this.c = this.e;
        i();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    protected final boolean g() {
        return this.g.hasRemaining();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    protected abstract com.google.android.exoplayer2.audio.AudioProcessor.a h(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a);

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    protected void i() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    protected void j() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    protected void k() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    protected final ByteBuffer l(int i) {
        ByteOrder nativeOrder;
        ByteBuffer obj2;
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        obj2 = this.f;
        this.g = obj2;
        return obj2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f = AudioProcessor.a;
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar = AudioProcessor.a.e;
        this.d = aVar;
        this.e = aVar;
        this.b = aVar;
        this.c = aVar;
        k();
    }
}
