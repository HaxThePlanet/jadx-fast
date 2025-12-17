package zendesk.core;

/* loaded from: classes3.dex */
public interface MemoryCache {
    public abstract void clear();

    public abstract boolean contains(String string);

    public abstract <T> T get(String string);

    public abstract <T> T getOrDefault(String string, T t2);

    public abstract void put(String string, Object object2);

    public abstract void remove(String string);
}
