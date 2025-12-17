package net.time4j.tz;

import java.io.Serializable;

/* loaded from: classes3.dex */
class e implements net.time4j.tz.k, Serializable {

    private static final long serialVersionUID = -4889632013137688471L;
    private final String tzid;
    e(String string) {
        super();
        this.tzid = string;
    }

    @Override // net.time4j.tz.k
    public String a() {
        return this.tzid;
    }

    @Override // net.time4j.tz.k
    public boolean equals(Object object) {
        if (object instanceof e) {
            return this.tzid.equals(object.tzid);
        }
        return 0;
    }

    @Override // net.time4j.tz.k
    public int hashCode() {
        return this.tzid.hashCode();
    }

    @Override // net.time4j.tz.k
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append("@");
        stringBuilder.append(this.tzid);
        return stringBuilder.toString();
    }
}
