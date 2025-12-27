package net.time4j.engine;

/* compiled from: RuleNotFoundException.java */
/* loaded from: classes3.dex */
public class RuleNotFoundException extends ChronoException {

    private static final long serialVersionUID = -5638437652574160520L;
    RuleNotFoundException(w<?> wVar, p<?> pVar) {
        super(RuleNotFoundException.b(wVar, pVar));
    }

    private static String a(w<?> wVar, Object object) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "Cannot find any rule for chronological unit \"";
        String str3 = RuleNotFoundException.c(object);
        String str4 = "\" in: ";
        String name = wVar.l().getName();
        str2 = str + str3 + str4 + name;
        return str2;
    }

    private static String b(w<?> wVar, p<?> pVar) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "Cannot find any rule for chronological element \"";
        String name2 = pVar.name();
        String str3 = "\" in: ";
        String name = wVar.l().getName();
        str2 = str + name2 + str3 + name;
        return str2;
    }

    private static String c(Object object) {
        if (object instanceof Enum) {
            return (Enum)Enum.class.cast(object).name();
        }
        return object.toString();
    }

    RuleNotFoundException(String str) {
        super(str);
    }

    RuleNotFoundException(w<?> wVar, Object object) {
        super(RuleNotFoundException.a(wVar, object));
    }
}
