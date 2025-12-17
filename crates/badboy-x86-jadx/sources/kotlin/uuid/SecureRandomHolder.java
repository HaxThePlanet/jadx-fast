package kotlin.uuid;

import java.security.SecureRandom;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/uuid/SecureRandomHolder;", "", "()V", "instance", "Ljava/security/SecureRandom;", "getInstance", "()Ljava/security/SecureRandom;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SecureRandomHolder {

    public static final kotlin.uuid.SecureRandomHolder INSTANCE;
    private static final SecureRandom instance;
    static {
        SecureRandomHolder secureRandomHolder = new SecureRandomHolder();
        SecureRandomHolder.INSTANCE = secureRandomHolder;
        SecureRandom secureRandom = new SecureRandom();
        SecureRandomHolder.instance = secureRandom;
    }

    public final SecureRandom getInstance() {
        return SecureRandomHolder.instance;
    }
}
