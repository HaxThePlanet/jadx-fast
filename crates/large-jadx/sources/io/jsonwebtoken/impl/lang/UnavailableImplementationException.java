package io.jsonwebtoken.impl.lang;

/* loaded from: classes3.dex */
public final class UnavailableImplementationException extends RuntimeException {

    private static final String DEFAULT_NOT_FOUND_MESSAGE = "Unable to find an implementation for %s using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.";
    UnavailableImplementationException(Class class) {
        Object[] arr = new Object[1];
        super(String.format("Unable to find an implementation for %s using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.", class));
    }
}
