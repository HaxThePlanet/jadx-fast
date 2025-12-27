package net.time4j.tz;

import java.io.Serializable;

/* compiled from: NamedID.java */
/* loaded from: classes3.dex */
class e implements k, Serializable {

    private static final long serialVersionUID = -4889632013137688471L;
    private final String tzid;
    e(String str) {
        super();
        this.tzid = str;
    }

    public String a() {
        return this.tzid;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (object instanceof e) {
            return this.tzid.equals(object.tzid);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.tzid.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = getClass().getName();
        String str2 = "@";
        str = name + str2 + this.tzid;
        return str;
    }
}
