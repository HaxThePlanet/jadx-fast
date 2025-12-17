package zendesk.support;

import com.zendesk.service.a;
import com.zendesk.service.f;

/* loaded from: classes3.dex */
abstract class ZendeskCallbackSuccess<E>  extends f<E> {

    private final f callback;
    ZendeskCallbackSuccess(f f) {
        super();
        this.callback = f;
    }

    @Override // com.zendesk.service.f
    public void onError(a a) {
        final f callback = this.callback;
        if (callback != null) {
            callback.onError(a);
        }
    }

    public abstract void onSuccess(E e);
}
