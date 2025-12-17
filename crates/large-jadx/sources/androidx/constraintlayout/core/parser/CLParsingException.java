package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLParsingException extends Exception {

    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;
    @Override // java.lang.Exception
    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mReason);
        stringBuilder.append(" (");
        stringBuilder.append(this.mElementClass);
        stringBuilder.append(" at line ");
        stringBuilder.append(this.mLineNumber);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // java.lang.Exception
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CLParsingException (");
        stringBuilder.append(hashCode());
        stringBuilder.append(") : ");
        stringBuilder.append(a());
        return stringBuilder.toString();
    }
}
