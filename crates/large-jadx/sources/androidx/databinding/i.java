package androidx.databinding;

import java.io.Serializable;

/* loaded from: classes.dex */
public class i<T>  extends androidx.databinding.b implements Serializable {

    static final long serialVersionUID = 1L;
    private T mValue;
    public i(T t) {
        super();
        this.mValue = t;
    }

    public T d() {
        return this.mValue;
    }

    public void e(T t) {
        if (t != this.mValue) {
            this.mValue = t;
            notifyChange();
        }
    }
}
