package net.time4j.tz.model;

/* loaded from: classes3.dex */
public enum i {

    UTC_TIME,
    STANDARD_TIME,
    WALL_TIME;

    static enum a extends net.time4j.tz.model.i {
        @Override // net.time4j.tz.model.i
        public char getSymbol() {
            return 117;
        }
    }

    static enum b extends net.time4j.tz.model.i {
        @Override // net.time4j.tz.model.i
        public char getSymbol() {
            return 115;
        }
    }

    static enum c extends net.time4j.tz.model.i {
        @Override // net.time4j.tz.model.i
        public char getSymbol() {
            return 119;
        }
    }
    public static net.time4j.tz.model.i parseSymbol(char c) {
        int i;
        if (c != 103 && c != 115 && c != 117 && c != 119) {
            if (c != 115) {
                if (c != 117) {
                    if (c != 119) {
                        if (c != 122) {
                        } else {
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown offset indicator: ");
                        stringBuilder.append(c);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                        throw illegalArgumentException;
                    }
                    return i.WALL_TIME;
                }
            }
            return i.STANDARD_TIME;
        }
        return i.UTC_TIME;
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        AbstractMethodError abstractMethodError = new AbstractMethodError();
        throw abstractMethodError;
    }
}
