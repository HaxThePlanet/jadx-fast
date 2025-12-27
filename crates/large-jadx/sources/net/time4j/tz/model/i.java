package net.time4j.tz.model;

/* compiled from: OffsetIndicator.java */
/* loaded from: classes3.dex */
public enum i {

    STANDARD_TIME,
    UTC_TIME,
    WALL_TIME;

    enum a extends i {
        @Override // net.time4j.tz.model.i
        public char getSymbol() {
            return 117;
        }
    }

    enum b extends i {
        @Override // net.time4j.tz.model.i
        public char getSymbol() {
            return 115;
        }
    }

    enum c extends i {
        @Override // net.time4j.tz.model.i
        public char getSymbol() {
            return 119;
        }
    }
    public static i parseSymbol(char c) {
        char c2 = 'g';
        c2 = 'u';
        c2 = 'z';
        if (!(c == 'g' || c != 115 || c != 'u' || c != 119 || c == 'z')) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Unknown offset indicator: ";
            c = str + c;
            throw new IllegalArgumentException(c);
        }
        return i.UTC_TIME;
    }

    @Override // java.lang.Enum
    public char getSymbol() throws java.lang.AbstractMethodError {
        throw new AbstractMethodError();
    }
}
