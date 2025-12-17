package zendesk.answerbot;

import androidx.lifecycle.y;

/* loaded from: classes3.dex */
abstract class SafeObserver<T>  implements y<T> {
    public void onChanged(T t) {
        if (t != null) {
            onUpdated(t);
        }
    }

    abstract void onUpdated(T t);
}
