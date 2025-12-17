package zendesk.support.request;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Xml;
import android.view.View;
import f.g.c.a;
import f.g.e.g;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.a.a;
import o.a.b;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;

/* loaded from: classes3.dex */
class DocumentRenderer {

    private final ActionHandlerRegistry actionHandlerRegistry;
    private final b configHelper;
    private final a configuration;
    private final zendesk.support.request.DocumentRenderer.Style.Factory styleFactory;

    static class HtmlParser {

        private static final Set<String> UNCLOSED_TAGS;
        private final XmlPullParser xpp;
        static {
            HashSet hashSet = new HashSet(Arrays.asList(/* result */));
            DocumentRenderer.HtmlParser.UNCLOSED_TAGS = hashSet;
        }

        HtmlParser() {
            XmlPullParser pullParser;
            XmlPullParserFactory instance;
            String fEATURE_RELAXED;
            String str;
            super();
            final int i3 = 0;
            instance = XmlPullParserFactory.newInstance();
            instance.setValidating(false);
            instance.setFeature(Xml.FEATURE_RELAXED, true);
            this.xpp = instance.newPullParser();
        }

        HtmlParser(XmlPullParser xmlPullParser) {
            super();
            this.xpp = xmlPullParser;
        }

        private zendesk.support.request.DocumentRenderer.Node endTag(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node) {
            return node.getParent();
        }

        private Map<String, String> getAttributes() {
            int i;
            int attributeName;
            String attributeValue;
            int attributeCount = this.xpp.getAttributeCount();
            HashMap hashMap = new HashMap(Math.max(0, attributeCount));
            if (attributeCount > 0) {
            }
            return hashMap;
        }

        private zendesk.support.request.DocumentRenderer.Node startDocument() {
            return DocumentRenderer.Node.withTag(DocumentRenderer.Node.Type.Document.getTag(), 0, getAttributes());
        }

        private zendesk.support.request.DocumentRenderer.Node startTag(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node) {
            zendesk.support.request.DocumentRenderer.Node obj4;
            String name = this.xpp.getName();
            zendesk.support.request.DocumentRenderer.Node tag = DocumentRenderer.Node.withTag(name, node, getAttributes());
            node.addChild(tag);
            if (DocumentRenderer.HtmlParser.UNCLOSED_TAGS.contains(name)) {
            } else {
                obj4 = tag;
            }
            return obj4;
        }

        private void text(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node) {
            Object content;
            boolean attributes;
            content = this.xpp.getText();
            if (g.c(content)) {
                node.addChild(DocumentRenderer.Node.withContent(node, content, getAttributes()));
            }
        }

        zendesk.support.request.DocumentRenderer.RichRenderingDocument parse(String string, String string2) {
            int i;
            int i2;
            int eventType;
            int document;
            int endTag;
            int i3;
            String obj8;
            final int i4 = 0;
            StringReader stringReader = new StringReader(string);
            this.xpp.setInput(stringReader);
            eventType = this.xpp.getEventType();
            endTag = document;
            while (eventType != 1) {
                if (eventType == 0) {
                } else {
                }
                if (eventType == 2) {
                } else {
                }
                if (eventType == 3) {
                } else {
                }
                if (eventType == 4) {
                }
                eventType = this.xpp.next();
                text(endTag);
                endTag = endTag(endTag);
                endTag = startTag(endTag);
                endTag = document;
            }
            if (document == endTag) {
                DocumentRenderer.RichRenderingDocument richRenderingDocument = new DocumentRenderer.RichRenderingDocument(document, string2);
                return richRenderingDocument;
            }
            obj8 = new DocumentRenderer.RichRenderingDocument(i4, string2);
            return obj8;
        }
    }

    static class Node {

        private final Map<String, String> attributes;
        private final List<zendesk.support.request.DocumentRenderer.Node> children;
        private final zendesk.support.request.DocumentRenderer.Node parent;
        private final String text;
        private final zendesk.support.request.DocumentRenderer.Node.Type type;
        private Node(zendesk.support.request.DocumentRenderer.Node.Type documentRenderer$Node$Type, String string2, List<zendesk.support.request.DocumentRenderer.Node> list3, zendesk.support.request.DocumentRenderer.Node documentRenderer$Node4, Map<String, String> map5) {
            super();
            this.type = type;
            this.text = string2;
            this.children = list3;
            this.parent = node4;
            this.attributes = map5;
        }

        static List access$000(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node) {
            return node.children;
        }

        static Map access$100(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node) {
            return node.attributes;
        }

        static zendesk.support.request.DocumentRenderer.Node withContent(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node, String string2, Map<String, String> map3) {
            ArrayList arrayList = new ArrayList();
            super(DocumentRenderer.Node.Type.Text, string2, arrayList, node, map3);
            return node4;
        }

        static zendesk.support.request.DocumentRenderer.Node withTag(String string, zendesk.support.request.DocumentRenderer.Node documentRenderer$Node2, Map<String, String> map3) {
            ArrayList arrayList = new ArrayList();
            super(DocumentRenderer.Node.Type.forTag(string), 0, arrayList, node2, map3);
            return node4;
        }

        void addChild(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node) {
            this.children.add(node);
        }

        Map<String, String> getAttributes() {
            return this.attributes;
        }

        List<zendesk.support.request.DocumentRenderer.Node> getChildren() {
            return this.children;
        }

        public zendesk.support.request.DocumentRenderer.Node getParent() {
            return this.parent;
        }

        public java.lang.CharSequence getText() {
            return this.text;
        }

        public zendesk.support.request.DocumentRenderer.Node.Type getType() {
            return this.type;
        }
    }

    static class RichRenderingDocument {

        private final String fallbackText;
        private final zendesk.support.request.DocumentRenderer.Node tree;
        RichRenderingDocument(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node, String string2) {
            super();
            this.tree = node;
            this.fallbackText = string2;
        }

        String getFallbackText() {
            return this.fallbackText;
        }

        zendesk.support.request.DocumentRenderer.Node getNodeTree() {
            return this.tree;
        }

        boolean isValid() {
            zendesk.support.request.DocumentRenderer.Node empty;
            int i;
            empty = this.tree;
            if (empty != null && !empty.getChildren().isEmpty()) {
                i = !empty.getChildren().isEmpty() ? 1 : 0;
            } else {
            }
            return i;
        }
    }

    interface Style {
        public abstract Spannable applyStyle(List<java.lang.CharSequence> list, Map<String, String> map2);
    }

    static class ZendeskUrlSpan extends URLSpan {

        private final b configHelper;
        private final a configuration;
        private final ActionHandlerRegistry registry;
        ZendeskUrlSpan(String string, ActionHandlerRegistry actionHandlerRegistry2, b b3, a a4) {
            super(string);
            this.registry = actionHandlerRegistry2;
            this.configHelper = b3;
            this.configuration = a4;
        }

        @Override // android.text.style.URLSpan
        public void onClick(View view) {
            String uRL = getURL();
            if (g.e(uRL)) {
                super.onClick(view);
            }
            ActionHandler handlerByAction = this.registry.handlerByAction(uRL);
            if (handlerByAction == null) {
                super.onClick(view);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("help_center_view_article", uRL);
            this.configHelper.d(hashMap, this.configuration);
            handlerByAction.handle(hashMap, view.getContext());
        }
    }
    DocumentRenderer(Context context, ActionHandlerRegistry actionHandlerRegistry2, b b3, a a4) {
        super();
        DocumentRenderer.Style.Factory factory = new DocumentRenderer.Style.Factory(context);
        this.styleFactory = factory;
        this.actionHandlerRegistry = actionHandlerRegistry2;
        this.configHelper = b3;
        this.configuration = a4;
    }

    DocumentRenderer(zendesk.support.request.DocumentRenderer.Style.Factory documentRenderer$Style$Factory, ActionHandlerRegistry actionHandlerRegistry2, b b3, a a4) {
        super();
        this.styleFactory = factory;
        this.actionHandlerRegistry = actionHandlerRegistry2;
        this.configHelper = b3;
        this.configuration = a4;
    }

    private Spannable installClickableLinks(Spannable spannable) {
        return replaceUrlSpans(DocumentRenderer.linkifyAll(spannable));
    }

    private static Spannable linkifyAll(Spannable spannable) {
        boolean links;
        int length;
        int i2;
        Object obj;
        int spanStart;
        int spanEnd;
        int i;
        SpannableString spannableString = new SpannableString(spannable);
        if (Linkify.addLinks(spannableString, 15)) {
            links = spannableString.getSpans(0, spannableString.length(), URLSpan.class);
            while (i2 < links.length) {
                obj = (URLSpan[])links[i2];
                spannable.setSpan(obj, spannableString.getSpanStart(obj), spannableString.getSpanEnd(obj), 33);
                i2++;
            }
        }
        return spannable;
    }

    private java.lang.CharSequence render(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node) {
        return DocumentRenderer.Style.SpannableHelper.trimSpannable(installClickableLinks(reduce(node)));
    }

    private Spannable replaceUrlSpans(Spannable spannable) {
        int i2;
        zendesk.support.request.DocumentRenderer.ZendeskUrlSpan zendeskUrlSpan;
        int i;
        int spanStart;
        int spanEnd;
        ActionHandlerRegistry actionHandlerRegistry;
        b configHelper;
        a configuration;
        SpannableString spannableString = new SpannableString(spannable);
        Object[] obj11 = spannableString.getSpans(0, spannableString.length(), URLSpan.class);
        while (i2 < obj11.length) {
            Object obj2 = (URLSpan[])obj11[i2];
            spannableString.removeSpan(obj2);
            zendeskUrlSpan = new DocumentRenderer.ZendeskUrlSpan(obj2.getURL(), this.actionHandlerRegistry, this.configHelper, this.configuration);
            spannableString.setSpan(zendeskUrlSpan, spannableString.getSpanStart(obj2), spannableString.getSpanEnd(obj2), 33);
            i2++;
        }
        return spannableString;
    }

    Spannable reduce(zendesk.support.request.DocumentRenderer.Node documentRenderer$Node) {
        zendesk.support.request.DocumentRenderer.Node.Type type;
        Iterator iterator;
        int reduce;
        boolean next;
        String valueOf;
        String str;
        String str2;
        zendesk.support.request.DocumentRenderer.Node.Type type2 = node.getType();
        List children = node.getChildren();
        if (type2 == DocumentRenderer.Node.Type.Text) {
            return this.styleFactory.getStyledText(node.getText());
        }
        if (type2 != DocumentRenderer.Node.Type.Ol) {
            if (type2 == DocumentRenderer.Node.Type.Ul) {
                type = 0;
                iterator = DocumentRenderer.Node.access$000(node).iterator();
                for (DocumentRenderer.Node next4 : iterator) {
                    DocumentRenderer.Node.access$100(next4).put("_parent", type2.name());
                    DocumentRenderer.Node.access$100(next4).put("_index", String.valueOf(type++));
                }
            }
        } else {
        }
        ArrayList arrayList = new ArrayList(children.size());
        Iterator iterator2 = children.iterator();
        for (DocumentRenderer.Node next3 : iterator2) {
            arrayList.add(reduce(next3));
        }
        return this.styleFactory.getStyleForType(type2).applyStyle(arrayList, node.getAttributes());
    }

    java.lang.CharSequence render(zendesk.support.request.DocumentRenderer.RichRenderingDocument documentRenderer$RichRenderingDocument) {
        boolean spannableString;
        Object obj2;
        if (richRenderingDocument.isValid()) {
            obj2 = render(richRenderingDocument.getNodeTree());
        } else {
            spannableString = new SpannableString(richRenderingDocument.getFallbackText());
            obj2 = installClickableLinks(spannableString);
        }
        return obj2;
    }
}
