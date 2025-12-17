package androidx.compose.ui.text;

import android.text.Editable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n \n*\u0004\u0018\u00010\t0\t2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u0096\u0001J&\u0010\u000f\u001a\u00020\u00072\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\u0019\u0010\u0014\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0008\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J)\u0010\u0019\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n \n*\u0004\u0018\u00010\t0\t2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0096\u0001J)\u0010\u001a\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n \n*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n \n*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0007H\u0096\u0001J0\u0010\u001f\u001a\u00020\u00072\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0008\u0010 \u001a\u0004\u0018\u00010\u0018H\u0016J)\u0010!\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n \n*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Landroidx/compose/ui/text/AnnotationContentHandler;", "Lorg/xml/sax/ContentHandler;", "contentHandler", "output", "Landroid/text/Editable;", "(Lorg/xml/sax/ContentHandler;Landroid/text/Editable;)V", "characters", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "", "p2", "endDocument", "endElement", "uri", "", "localName", "qName", "endPrefixMapping", "handleAnnotationEnd", "handleAnnotationStart", "attributes", "Lorg/xml/sax/Attributes;", "ignorableWhitespace", "processingInstruction", "setDocumentLocator", "Lorg/xml/sax/Locator;", "skippedEntity", "startDocument", "startElement", "atts", "startPrefixMapping", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AnnotationContentHandler implements ContentHandler {

    private final ContentHandler contentHandler;
    private final Editable output;
    public AnnotationContentHandler(ContentHandler contentHandler, Editable output) {
        super();
        this.contentHandler = contentHandler;
        this.output = output;
    }

    private final void handleAnnotationEnd() {
        int index$iv;
        Object[] objArr;
        int i2;
        int length2;
        int spanStart;
        Object length;
        Object output;
        int i;
        int i3;
        int i4;
        int i7 = 0;
        int i6 = 0;
        ArrayList arrayList = new ArrayList();
        objArr = spans;
        i2 = 0;
        spanStart = i7;
        while (spanStart < objArr.length) {
            length = objArr[spanStart];
            i = 0;
            if (this.output.getSpanFlags((AnnotationSpan)length) == 17) {
            } else {
            }
            i3 = i7;
            if (i3 != 0) {
            }
            spanStart++;
            (Collection)arrayList.add(length);
            i3 = 1;
        }
        int i5 = 0;
        index$iv = 0;
        while (index$iv < (List)arrayList.size()) {
            i2 = objArr;
            length2 = 0;
            spanStart = this.output.getSpanStart((AnnotationSpan)i2);
            length = this.output.length();
            this.output.removeSpan(i2);
            if (spanStart != length) {
            }
            index$iv++;
            this.output.setSpan(i2, spanStart, length, 33);
        }
    }

    private final void handleAnnotationStart(Attributes attributes) {
        int i2;
        String localName;
        String str;
        int length;
        int output;
        int annotationSpan;
        int i;
        i2 = 0;
        while (i2 < attributes.getLength()) {
            if (attributes.getLocalName(i2) == null) {
            }
            String value = attributes.getValue(i2);
            if (value == null) {
            } else {
            }
            str = value;
            annotationSpan = 1;
            if ((CharSequence)localName.length() > 0) {
            } else {
            }
            length = output;
            if (length != 0 && (CharSequence)str.length() > 0) {
            }
            i2++;
            if ((CharSequence)str.length() > 0) {
            }
            if (output != null) {
            }
            length = this.output.length();
            annotationSpan = new AnnotationSpan(localName, str);
            this.output.setSpan(annotationSpan, length, length, 17);
            output = annotationSpan;
            length = annotationSpan;
            localName = str;
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i2, int i3) {
        this.contentHandler.characters(cArr, i2, i3);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() {
        this.contentHandler.endDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String uri, String localName, String qName) {
        boolean contentHandler;
        if (Intrinsics.areEqual(localName, "annotation")) {
            handleAnnotationEnd();
        } else {
            this.contentHandler.endElement(uri, localName, qName);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String string) {
        this.contentHandler.endPrefixMapping(string);
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i2, int i3) {
        this.contentHandler.ignorableWhitespace(cArr, i2, i3);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String string, String string2) {
        this.contentHandler.processingInstruction(string, string2);
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.contentHandler.setDocumentLocator(locator);
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String string) {
        this.contentHandler.skippedEntity(string);
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() {
        this.contentHandler.startDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String uri, String localName, String qName, Attributes atts) {
        ContentHandler contentHandler;
        int i;
        if (Intrinsics.areEqual(localName, "annotation")) {
            if (atts != null) {
                i = 0;
                handleAnnotationStart(atts);
            }
        } else {
            this.contentHandler.startElement(uri, localName, qName, atts);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String string, String string2) {
        this.contentHandler.startPrefixMapping(string, string2);
    }
}
