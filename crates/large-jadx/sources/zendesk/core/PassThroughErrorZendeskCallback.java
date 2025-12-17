package zendesk.core;

import com.zendesk.service.a;
import com.zendesk.service.f;

/* loaded from: classes3.dex */
abstract class PassThroughErrorZendeskCallback<E>  extends f<E> {

    private final f callback;
    PassThroughErrorZendeskCallback(f f) {
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
