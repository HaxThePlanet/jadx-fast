package net.time4j.engine;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public interface j0<U>  {

    public static final class a implements Serializable {

        private static final long serialVersionUID = 1564804888291509484L;
        private final long amount;
        private final U unit;
        private a(long l, U u2) {
            super();
            Objects.requireNonNull(obj5, "Missing chronological unit.");
            if (Long.compare(l, i) < 0) {
            } else {
                this.amount = l;
                this.unit = obj5;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Temporal amount must be positive or zero: ");
            stringBuilder.append(l);
            IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder.toString());
            throw obj5;
        }

        public static <U> net.time4j.engine.j0.a<U> c(long l, U u2) {
            j0.a aVar = new j0.a(l, u2, obj3);
            return aVar;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            long amount;
            int i;
            Object obj5;
            objectInputStream.defaultReadObject();
            if (this.unit == null) {
            } else {
                if (Long.compare(amount, i) < 0) {
                } else {
                }
            }
            obj5 = new InvalidObjectException("Inconsistent state.");
            throw obj5;
        }

        @Override // java.io.Serializable
        public long a() {
            return this.amount;
        }

        public U b() {
            return this.unit;
        }

        @Override // java.io.Serializable
        public boolean equals(Object object) {
            int i;
            int unit;
            Object obj8;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object instanceof j0.a) {
                obj8 = j0.a.class.cast(object);
                if (Long.compare(amount, amount2) == 0 && this.unit.equals(obj8.unit)) {
                    if (this.unit.equals(obj8.unit)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
                return i;
            }
            return i2;
        }

        @Override // java.io.Serializable
        public int hashCode() {
            long amount = this.amount;
            return i2 += i5;
        }

        @Override // java.io.Serializable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('P');
            stringBuilder.append(this.amount);
            stringBuilder.append('{');
            stringBuilder.append(this.unit);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    public abstract boolean a();

    public abstract List<net.time4j.engine.j0.a<U>> c();

    public abstract boolean isEmpty();
}
