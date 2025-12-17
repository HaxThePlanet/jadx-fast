package kotlin;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\u000c\n\u0002\u0008\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0001H\u0087\u0008\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0008", d2 = {"code", "", "", "getCode$annotations", "(C)V", "getCode", "(C)I", "Char", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CharCodeKt {
    private static final char Char(int code) {
        int i;
        if (code < 0) {
        } else {
            if (code > 65535) {
            } else {
                return (char)code;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Invalid Char code: ").append(code).toString());
        throw illegalArgumentException;
    }

    private static final int getCode(char $this$code) {
        return $this$code;
    }

    public static void getCode$annotations(char c) {
    }
}
