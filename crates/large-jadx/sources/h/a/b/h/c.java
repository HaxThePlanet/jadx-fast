package h.a.b.h;

import androidx.recyclerview.widget.RecyclerView.e0;

/* compiled from: AbstractSectionableItem.java */
/* loaded from: classes2.dex */
public abstract class c<VH extends RecyclerView.e0, H extends g> extends a<VH> implements h<VH, H> {

    protected H header;
    public c(H h) {
        super();
        this.header = h;
    }

    @Override // h.a.b.h.a
    public H getHeader() {
        return this.header;
    }

    @Override // h.a.b.h.a
    public void setHeader(H h) {
        this.header = h;
    }
}
