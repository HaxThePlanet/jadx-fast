package zendesk.core;

/* loaded from: classes3.dex */
public interface BaseStorage {
    public abstract void clear();

    public abstract <E> E get(String string, Class<E> class2);

    public abstract String get(String string);

    public abstract void put(String string, Object object2);

    public abstract void put(String string, String string2);

    public abstract void remove(String string);
}
