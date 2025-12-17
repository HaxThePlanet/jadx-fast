package zendesk.messaging;

import g.b.b;

/* loaded from: classes3.dex */
public final class BelvedereMediaHolder_Factory implements b<zendesk.messaging.BelvedereMediaHolder> {

    private static final zendesk.messaging.BelvedereMediaHolder_Factory INSTANCE;
    static {
        BelvedereMediaHolder_Factory belvedereMediaHolder_Factory = new BelvedereMediaHolder_Factory();
        BelvedereMediaHolder_Factory.INSTANCE = belvedereMediaHolder_Factory;
    }

    public static zendesk.messaging.BelvedereMediaHolder_Factory create() {
        return BelvedereMediaHolder_Factory.INSTANCE;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.BelvedereMediaHolder get() {
        BelvedereMediaHolder belvedereMediaHolder = new BelvedereMediaHolder();
        return belvedereMediaHolder;
    }
}
