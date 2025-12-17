package kotlin.text;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ScreenFloatValueRegEx {

    public static final kotlin.text.ScreenFloatValueRegEx INSTANCE;
    public static final kotlin.text.Regex value;
    static {
        ScreenFloatValueRegEx screenFloatValueRegEx = new ScreenFloatValueRegEx();
        ScreenFloatValueRegEx.INSTANCE = screenFloatValueRegEx;
        kotlin.text.ScreenFloatValueRegEx iNSTANCE = ScreenFloatValueRegEx.INSTANCE;
        final int i = 0;
        final String str = "(\\p{Digit}+)";
        final String str2 = "(\\p{XDigit}+)";
        StringBuilder stringBuilder = new StringBuilder();
        String string = stringBuilder.append("[eE][+-]?").append(str).toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        int i2 = 41;
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        Regex regex = new Regex(stringBuilder4.append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((").append(stringBuilder3.append('(').append(str).append("(\\.)?(").append(str).append("?)(").append(string).append(")?)|(\\.(").append(str).append(")(").append(string).append(")?)|((").append(stringBuilder2.append("(0[xX]").append(str2).append("(\\.)?)|(0[xX]").append(str2).append("?(\\.)").append(str2).append(i2).toString()).append(")[pP][+-]?").append(str).append(i2).toString()).append(")[fFdD]?))[\\x00-\\x20]*").toString());
        ScreenFloatValueRegEx.value = regex;
    }
}
