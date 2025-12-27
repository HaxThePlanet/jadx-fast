package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultCompressionCodecResolver.java */
/* loaded from: classes3.dex */
public class DefaultCompressionCodecResolver implements CompressionCodecResolver {

    private static final String MISSING_COMPRESSION_MESSAGE = "Unable to find an implementation for compression algorithm [%s] using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.";
    private final Map<String, CompressionCodec> codecs;
    public DefaultCompressionCodecResolver() {
        super();
        HashMap hashMap = new HashMap();
        Iterator it = Services.loadAll(CompressionCodec.class).iterator();
        while (it.hasNext()) {
            Object item = it.next();
            hashMap.put(item.getAlgorithmName().toUpperCase(), item);
        }
        CompressionCodec dEFLATE2 = CompressionCodecs.DEFLATE;
        hashMap.put(dEFLATE2.getAlgorithmName().toUpperCase(), dEFLATE2);
        CompressionCodec gZIP2 = CompressionCodecs.GZIP;
        hashMap.put(gZIP2.getAlgorithmName().toUpperCase(), gZIP2);
        this.codecs = Collections.unmodifiableMap(hashMap);
    }

    private CompressionCodec byName(String str) throws CompressionException {
        Assert.hasText(str, "'name' must not be empty");
        Object value = this.codecs.get(str.toUpperCase());
        if (value == null) {
            Object[] arr = new Object[1];
            throw new CompressionException(String.format("Unable to find an implementation for compression algorithm [%s] using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.", new Object[] { str }));
        } else {
            return value;
        }
    }

    private String getAlgorithmFromHeader(Header header) {
        Assert.notNull(header, "header cannot be null.");
        return header.getCompressionAlgorithm();
    }

    public CompressionCodec resolveCompressionCodec(Header header) {
        String algorithmFromHeader = getAlgorithmFromHeader(header);
        if (!Strings.hasText(algorithmFromHeader)) {
            return null;
        }
        return byName(algorithmFromHeader);
    }
}
