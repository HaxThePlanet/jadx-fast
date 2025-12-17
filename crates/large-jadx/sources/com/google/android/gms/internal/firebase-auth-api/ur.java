package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public class ur<MessageType extends com.google.android.gms.internal.firebase-auth-api.xr<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.firebase-auth-api.ur<MessageType, BuilderType>>  extends com.google.android.gms.internal.firebase-auth-api.iq<MessageType, BuilderType> {

    private final MessageType a;
    protected MessageType b;
    protected boolean c = false;
    protected ur(MessageType messagetype) {
        super();
        this.a = messagetype;
        final int i2 = 0;
        this.b = (xr)messagetype.q(4, i2, i2);
        int obj3 = 0;
    }

    private static final void b(MessageType messagetype, MessageType messagetype2) {
        h0.a().b(messagetype.getClass()).e(messagetype, messagetype2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.iq
    protected final com.google.android.gms.internal.firebase-auth-api.iq a(com.google.android.gms.internal.firebase-auth-api.jq jq) {
        d((xr)jq);
        return this;
    }

    public final BuilderType c() {
        final int i2 = 0;
        Object obj = this.a.q(5, i2, i2);
        (ur)obj.d(f());
        return obj;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.iq
    public final Object clone() {
        return c();
    }

    public final BuilderType d(MessageType messagetype) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        ur.b(this.b, messagetype);
        return this;
    }

    public final MessageType e() {
        final com.google.android.gms.internal.firebase-auth-api.xr xrVar = f();
        if (!xrVar.j()) {
        } else {
            return xrVar;
        }
        zzaby zzaby = new zzaby(xrVar);
        throw zzaby;
    }

    public MessageType f() {
        if (this.c) {
            return this.b;
        }
        com.google.android.gms.internal.firebase-auth-api.xr xrVar2 = this.b;
        h0.a().b(xrVar2.getClass()).c(xrVar2);
        this.c = true;
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.iq
    protected void h() {
        final int i2 = 0;
        Object obj = this.b.q(4, i2, i2);
        ur.b((xr)obj, this.b);
        this.b = obj;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.iq
    public com.google.android.gms.internal.firebase-auth-api.y i() {
        return f();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.iq
    public final com.google.android.gms.internal.firebase-auth-api.y p() {
        return this.a;
    }
}
