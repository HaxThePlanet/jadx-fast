package o.b;

/* compiled from: Action.java */
/* loaded from: classes3.dex */
public class a<E> {

    private final String actionType;
    private final E data;
    public a(String str, E e) {
        super();
        this.actionType = str;
        this.data = e;
    }

    public String getActionType() {
        return this.actionType;
    }

    public <F> F getData(Class<F> cls) {
        if (cls.isInstance(this.data)) {
            return cls.cast(this.data);
        }
        return null;
    }

    public E getRawData() {
        return this.data;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Action{actionType='";
        String str3 = ", data=";
        str = str2 + this.actionType + 39 + str3 + this.data + 125;
        return str;
    }

    public <F> F getData() {
        return this.data;
    }

    public a(String str) {
        super();
        this.actionType = str;
        this.data = null;
    }
}
