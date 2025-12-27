package net.time4j.engine;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* compiled from: TimeSpan.java */
/* loaded from: classes3.dex */
public interface j0<U> {

    public static final class a<U> implements Serializable {

        private static final long serialVersionUID = 1564804888291509484L;
        private final long amount;
        private final U unit;
        private a(long j, U u) {
            super();
            Objects.requireNonNull(u, "Missing chronological unit.");
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Temporal amount must be positive or zero: ";
                j = str2 + j;
                throw new IllegalArgumentException(j);
            } else {
                this.amount = j;
                this.unit = u;
                return;
            }
        }

        public static <U> j0.a<U> c(long j, U u) {
            return new j0.a(j, r2, u);
        }

        private void readObject(ObjectInputStream objectInputStream) throws java.lang.ClassNotFoundException, InvalidObjectException, java.io.IOException {
            objectInputStream.defaultReadObject();
            if (this.unit == null) {
                throw new InvalidObjectException("Inconsistent state.");
            } else {
                long l = 0L;
                if (this.amount >= l) {
                    return;
                }
            }
        }

        public long a() {
            return this.amount;
        }

        public U b() {
            return this.unit;
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            boolean z = true;
            int cmp;
            Object cast;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (object instanceof j0.a) {
                cast = j0.a.class.cast(object);
                if (this.amount == cast.amount) {
                    if (!(this.unit.equals(cast.unit))) {
                    }
                }
                return z;
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.unit.hashCode() * 29) + (int)(amount2 ^ (amount2 >>> 32L));
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            str = 80 + this.amount + 123 + this.unit + 125;
            return str;
        }
    }
    boolean a();

    List<j0.a<U>> c();

    boolean isEmpty();
}
