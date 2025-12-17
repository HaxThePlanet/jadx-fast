package app.dogo.com.dogo_android.util.exceptions;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0008\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/ExceptionForTaskChain;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCodeNumber", "", "(I)V", "getErrorCodeNumber", "()I", "message", "", "getMessage", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExceptionForTaskChain extends Exception {

    private final int errorCodeNumber;
    public ExceptionForTaskChain(int i) {
        super();
        this.errorCodeNumber = i;
    }

    @Override // java.lang.Exception
    public final int a() {
        return this.errorCodeNumber;
    }

    @Override // java.lang.Exception
    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getMessage());
        stringBuilder.append(" error code : ");
        stringBuilder.append(this.errorCodeNumber);
        return stringBuilder.toString();
    }
}
