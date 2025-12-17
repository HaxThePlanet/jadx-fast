package zendesk.core;

/* loaded from: classes3.dex */
interface Serializer {
    public abstract <E> E deserialize(Object object, Class<E> class2);

    public abstract String serialize(Object object);
}
