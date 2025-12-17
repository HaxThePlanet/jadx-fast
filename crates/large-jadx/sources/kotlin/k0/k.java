package kotlin.k0;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class k {

    public static final kotlin.k0.h a;
    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[eE][+-]?");
        String str5 = "(\\p{Digit}+)";
        stringBuilder.append(str5);
        String string = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        String str7 = "(0[xX]";
        stringBuilder3.append(str7);
        String str9 = "(\\p{XDigit}+)";
        stringBuilder3.append(str9);
        stringBuilder3.append("(\\.)?)|");
        stringBuilder3.append(str7);
        stringBuilder3.append(str9);
        stringBuilder3.append("?(\\.)");
        stringBuilder3.append(str9);
        int i = 41;
        stringBuilder3.append(i);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append('(');
        stringBuilder4.append(str5);
        stringBuilder4.append("(\\.)?(");
        stringBuilder4.append(str5);
        stringBuilder4.append("?)(");
        stringBuilder4.append(string);
        String str13 = ")?)|";
        stringBuilder4.append(str13);
        stringBuilder4.append("(\\.(");
        stringBuilder4.append(str5);
        stringBuilder4.append(")(");
        stringBuilder4.append(string);
        stringBuilder4.append(str13);
        stringBuilder4.append("((");
        stringBuilder4.append(stringBuilder3.toString());
        stringBuilder4.append(")[pP][+-]?");
        stringBuilder4.append(str5);
        stringBuilder4.append(i);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
        stringBuilder2.append(stringBuilder4.toString());
        stringBuilder2.append(")[fFdD]?))[\\x00-\\x20]*");
        h hVar = new h(stringBuilder2.toString());
        k.a = hVar;
    }
}
