package okhttp3.internal.ws;

import kotlin.Metadata;
import l.i;
import l.i.a;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0001\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"", "LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION", "I", "Ll/i;", "EMPTY_DEFLATE_BLOCK", "Ll/i;", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class MessageDeflaterKt {

    private static final i EMPTY_DEFLATE_BLOCK = null;
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;
    static {
        MessageDeflaterKt.EMPTY_DEFLATE_BLOCK = i.v.b("000000ffff");
    }

    public static final i access$getEMPTY_DEFLATE_BLOCK$p() {
        return MessageDeflaterKt.EMPTY_DEFLATE_BLOCK;
    }
}
