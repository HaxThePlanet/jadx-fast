package net.time4j.engine;

import java.util.Locale;

/* loaded from: classes3.dex */
public enum l0 implements net.time4j.engine.p<String> {

    ERROR_MESSAGE;
    @Override // java.lang.Enum
    public int compare(Object object, Object object2) {
        return compare((o)object, (o)object2);
    }

    @Override // java.lang.Enum
    public int compare(net.time4j.engine.o o, net.time4j.engine.o o2) {
        int obj1;
        obj1 = o.v(this);
        obj1 = obj1 == o2.v(this) ? 0 : obj1 != null ? 1 : -1;
        return obj1;
    }

    @Override // java.lang.Enum
    public Object getDefaultMaximum() {
        return getDefaultMaximum();
    }

    @Override // java.lang.Enum
    public String getDefaultMaximum() {
        return String.valueOf('\uffff');
    }

    @Override // java.lang.Enum
    public Object getDefaultMinimum() {
        return getDefaultMinimum();
    }

    @Override // java.lang.Enum
    public String getDefaultMinimum() {
        return "";
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return name();
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        return 0;
    }

    public Class<String> getType() {
        return String.class;
    }

    @Override // java.lang.Enum
    public boolean isDateElement() {
        return 0;
    }

    @Override // java.lang.Enum
    public boolean isLenient() {
        return 0;
    }

    @Override // java.lang.Enum
    public boolean isTimeElement() {
        return 0;
    }
}
