package okhttp3;

import java.io.IOException;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\u0008\u000b\u0010\u000c¨\u0006\r", d2 = {"Lokhttp3/Callback;", "", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "Lkotlin/w;", "onFailure", "(Lokhttp3/Call;Ljava/io/IOException;)V", "Lokhttp3/Response;", "response", "onResponse", "(Lokhttp3/Call;Lokhttp3/Response;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface Callback {
    public abstract void onFailure(okhttp3.Call call, IOException iOException2);

    public abstract void onResponse(okhttp3.Call call, okhttp3.Response response2);
}
