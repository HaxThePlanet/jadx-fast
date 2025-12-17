package net.time4j.engine;

/* loaded from: classes3.dex */
public class RuleNotFoundException extends net.time4j.engine.ChronoException {

    private static final long serialVersionUID = -5638437652574160520L;
    RuleNotFoundException(String string) {
        super(string);
    }

    RuleNotFoundException(net.time4j.engine.w<?> w, Object object2) {
        super(RuleNotFoundException.a(w, object2));
    }

    RuleNotFoundException(net.time4j.engine.w<?> w, net.time4j.engine.p<?> p2) {
        super(RuleNotFoundException.b(w, p2));
    }

    private static String a(net.time4j.engine.w<?> w, Object object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find any rule for chronological unit \"");
        stringBuilder.append(RuleNotFoundException.c(object2));
        stringBuilder.append("\" in: ");
        stringBuilder.append(w.l().getName());
        return stringBuilder.toString();
    }

    private static String b(net.time4j.engine.w<?> w, net.time4j.engine.p<?> p2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find any rule for chronological element \"");
        stringBuilder.append(p2.name());
        stringBuilder.append("\" in: ");
        stringBuilder.append(w.l().getName());
        return stringBuilder.toString();
    }

    private static String c(Object object) {
        if (object instanceof Enum) {
            return (Enum)Enum.class.cast(object).name();
        }
        return object.toString();
    }
}
