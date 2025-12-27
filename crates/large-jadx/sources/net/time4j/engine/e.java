package net.time4j.engine;

import java.io.Serializable;

/* compiled from: BasicElement.java */
/* loaded from: classes3.dex */
public abstract class e<V extends Comparable<V>> implements p<V>, Serializable {

    private final int hash;
    private final int identity = -1;
    private final String name;
    protected e(String str) {
        super();
        if (str.trim().isEmpty()) {
            throw new IllegalArgumentException("Element name is empty or contains only white space.");
        } else {
            this.name = str;
            int i2 = str.hashCode();
            this.hash = i2;
            if (j()) {
            }
            return;
        }
    }

    public int b(o oVar, o oVar2) {
        return (Comparable)oVar.p(this).compareTo(oVar2.p(this));
    }

    @Override // java.lang.Object
    public final boolean equals(Object object) {
        boolean z = true;
        int identity2;
        int identity22;
        boolean z2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object == null) {
            return false;
        }
        if (getClass() == object.getClass()) {
            if (this.identity != object.identity || this.identity == -1) {
            }
            return z;
        }
        return false;
    }

    protected String g(w<?> wVar) {
        if (h()) {
            if (f.class.isAssignableFrom(wVar.l())) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Accessing the local element [";
                String str2 = "] from a global type requires a timezone.\n";
                String str3 = "- Try to apply a zonal query like \"";
                String str4 = ".atUTC()\".\n";
                String str5 = "- Or try to first convert the global type to ";
                String str6 = "a zonal timestamp: ";
                String str7 = "\"moment.toZonalTimestamp(...)\".\n";
                String str8 = "- If used in formatting then consider ";
                String str9 = "\"ChronoFormatter.withTimezone(TZID)\".";
                str10 = str + this.name + str2 + str3 + this.name + str4 + str5 + str6 + str7 + str8 + str9;
                return str10;
            }
        }
        return null;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.hash;
    }

    public final String name() {
        return this.name;
    }

    @Override // java.lang.Object
    public String toString() {
        String name = getClass().getName();
        int i2 = name.length() + 32;
        final StringBuilder stringBuilder = new StringBuilder(i2);
        str = i2 + name + 64 + this.name;
        return str;
    }

    protected <T extends q<T>> y<T, V> d(w<T> wVar) {
        return null;
    }

    protected boolean e(e<?> eVar) {
        return true;
    }

    protected p<?> f() {
        return null;
    }

    public char getSymbol() {
        return 0;
    }

    public boolean h() {
        return true;
    }

    public boolean isLenient() {
        return false;
    }

    protected boolean j() {
        return false;
    }
}
