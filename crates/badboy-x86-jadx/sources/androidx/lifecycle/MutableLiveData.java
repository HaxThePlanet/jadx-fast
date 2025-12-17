package androidx.lifecycle;

/* loaded from: classes5.dex */
public class MutableLiveData<T>  extends androidx.lifecycle.LiveData<T> {
    public MutableLiveData(T t) {
        super(t);
    }

    public void postValue(T t) {
        super.postValue(t);
    }

    public void setValue(T t) {
        super.setValue(t);
    }
}
