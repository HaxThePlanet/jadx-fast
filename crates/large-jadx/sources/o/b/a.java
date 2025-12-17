package o.b;

/* loaded from: classes3.dex */
public class a<E>  {

    private final String actionType;
    private final E data;
    public a(String string) {
        super();
        this.actionType = string;
        this.data = 0;
    }

    public a(String string, E e2) {
        super();
        this.actionType = string;
        this.data = e2;
    }

    public String getActionType() {
        return this.actionType;
    }

    public <F> F getData() {
        return this.data;
    }

    public <F> F getData(Class<F> class) {
        if (class.isInstance(this.data)) {
            return class.cast(this.data);
        }
        return 0;
    }

    public E getRawData() {
        return this.data;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Action{actionType='");
        stringBuilder.append(this.actionType);
        stringBuilder.append('\'');
        stringBuilder.append(", data=");
        stringBuilder.append(this.data);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
