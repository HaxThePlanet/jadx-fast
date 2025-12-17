package com.google.android.play.core.splitinstall;

import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
final class b0 {
    static final com.google.android.play.core.splitinstall.k0 a(XmlPullParser xmlPullParser, com.google.android.play.core.splitinstall.i0 i02) {
        int eventType;
        int i;
        String str2;
        String eventType2;
        String str;
        try {
            while (xmlPullParser.next() != 1) {
                i = 2;
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("splits")) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                str2 = 3;
                while (xmlPullParser.next() != str2) {
                    if (xmlPullParser.getEventType() == i) {
                    }
                    str2 = 3;
                    if (xmlPullParser.getName().equals("module")) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    eventType = b0.b("name", xmlPullParser, i02);
                    if (eventType) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    while (xmlPullParser.next() != str2) {
                        if (xmlPullParser.getEventType() == i) {
                        }
                        if (xmlPullParser.getName().equals("language") != null) {
                        } else {
                        }
                        b0.c(xmlPullParser, i02);
                        while (xmlPullParser.next() != str2) {
                            if (xmlPullParser.getEventType() == i) {
                            }
                            if (xmlPullParser.getName().equals("entry") != null) {
                            } else {
                            }
                            b0.c(xmlPullParser, i02);
                            eventType2 = b0.b("key", xmlPullParser, i02);
                            str = b0.b("split", xmlPullParser, i02);
                            b0.c(xmlPullParser, i02);
                            if (eventType2 != null && str != null) {
                            }
                            if (str != null) {
                            }
                            i02.a(eventType, eventType2, str);
                        }
                        if (xmlPullParser.getEventType() == i) {
                        }
                        if (xmlPullParser.getName().equals("entry") != null) {
                        } else {
                        }
                        b0.c(xmlPullParser, i02);
                        eventType2 = b0.b("key", xmlPullParser, i02);
                        str = b0.b("split", xmlPullParser, i02);
                        b0.c(xmlPullParser, i02);
                        if (eventType2 != null && str != null) {
                        }
                        if (str != null) {
                        }
                        i02.a(eventType, eventType2, str);
                    }
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("language") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    while (xmlPullParser.next() != str2) {
                        if (xmlPullParser.getEventType() == i) {
                        }
                        if (xmlPullParser.getName().equals("entry") != null) {
                        } else {
                        }
                        b0.c(xmlPullParser, i02);
                        eventType2 = b0.b("key", xmlPullParser, i02);
                        str = b0.b("split", xmlPullParser, i02);
                        b0.c(xmlPullParser, i02);
                        if (eventType2 != null && str != null) {
                        }
                        if (str != null) {
                        }
                        i02.a(eventType, eventType2, str);
                    }
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("entry") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    eventType2 = b0.b("key", xmlPullParser, i02);
                    str = b0.b("split", xmlPullParser, i02);
                    b0.c(xmlPullParser, i02);
                    if (eventType2 != null && str != null) {
                    }
                    if (str != null) {
                    }
                    i02.a(eventType, eventType2, str);
                }
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("module")) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                eventType = b0.b("name", xmlPullParser, i02);
                if (eventType) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                while (xmlPullParser.next() != str2) {
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("language") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    while (xmlPullParser.next() != str2) {
                        if (xmlPullParser.getEventType() == i) {
                        }
                        if (xmlPullParser.getName().equals("entry") != null) {
                        } else {
                        }
                        b0.c(xmlPullParser, i02);
                        eventType2 = b0.b("key", xmlPullParser, i02);
                        str = b0.b("split", xmlPullParser, i02);
                        b0.c(xmlPullParser, i02);
                        if (eventType2 != null && str != null) {
                        }
                        if (str != null) {
                        }
                        i02.a(eventType, eventType2, str);
                    }
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("entry") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    eventType2 = b0.b("key", xmlPullParser, i02);
                    str = b0.b("split", xmlPullParser, i02);
                    b0.c(xmlPullParser, i02);
                    if (eventType2 != null && str != null) {
                    }
                    if (str != null) {
                    }
                    i02.a(eventType, eventType2, str);
                }
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("language") != null) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                while (xmlPullParser.next() != str2) {
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("entry") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    eventType2 = b0.b("key", xmlPullParser, i02);
                    str = b0.b("split", xmlPullParser, i02);
                    b0.c(xmlPullParser, i02);
                    if (eventType2 != null && str != null) {
                    }
                    if (str != null) {
                    }
                    i02.a(eventType, eventType2, str);
                }
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("entry") != null) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                eventType2 = b0.b("key", xmlPullParser, i02);
                str = b0.b("split", xmlPullParser, i02);
                b0.c(xmlPullParser, i02);
                if (eventType2 != null && str != null) {
                }
                if (str != null) {
                }
                i02.a(eventType, eventType2, str);
            }
            i = 2;
            if (xmlPullParser.getEventType() == i) {
            }
            if (xmlPullParser.getName().equals("splits")) {
            } else {
            }
            str2 = 3;
            while (xmlPullParser.next() != str2) {
                if (xmlPullParser.getEventType() == i) {
                }
                str2 = 3;
                if (xmlPullParser.getName().equals("module")) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                eventType = b0.b("name", xmlPullParser, i02);
                if (eventType) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                while (xmlPullParser.next() != str2) {
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("language") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    while (xmlPullParser.next() != str2) {
                        if (xmlPullParser.getEventType() == i) {
                        }
                        if (xmlPullParser.getName().equals("entry") != null) {
                        } else {
                        }
                        b0.c(xmlPullParser, i02);
                        eventType2 = b0.b("key", xmlPullParser, i02);
                        str = b0.b("split", xmlPullParser, i02);
                        b0.c(xmlPullParser, i02);
                        if (eventType2 != null && str != null) {
                        }
                        if (str != null) {
                        }
                        i02.a(eventType, eventType2, str);
                    }
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("entry") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    eventType2 = b0.b("key", xmlPullParser, i02);
                    str = b0.b("split", xmlPullParser, i02);
                    b0.c(xmlPullParser, i02);
                    if (eventType2 != null && str != null) {
                    }
                    if (str != null) {
                    }
                    i02.a(eventType, eventType2, str);
                }
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("language") != null) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                while (xmlPullParser.next() != str2) {
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("entry") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    eventType2 = b0.b("key", xmlPullParser, i02);
                    str = b0.b("split", xmlPullParser, i02);
                    b0.c(xmlPullParser, i02);
                    if (eventType2 != null && str != null) {
                    }
                    if (str != null) {
                    }
                    i02.a(eventType, eventType2, str);
                }
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("entry") != null) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                eventType2 = b0.b("key", xmlPullParser, i02);
                str = b0.b("split", xmlPullParser, i02);
                b0.c(xmlPullParser, i02);
                if (eventType2 != null && str != null) {
                }
                if (str != null) {
                }
                i02.a(eventType, eventType2, str);
            }
            if (xmlPullParser.getEventType() == i) {
            }
            if (xmlPullParser.getName().equals("module")) {
            } else {
            }
            eventType = b0.b("name", xmlPullParser, i02);
            if (eventType) {
            } else {
            }
            while (xmlPullParser.next() != str2) {
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("language") != null) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                while (xmlPullParser.next() != str2) {
                    if (xmlPullParser.getEventType() == i) {
                    }
                    if (xmlPullParser.getName().equals("entry") != null) {
                    } else {
                    }
                    b0.c(xmlPullParser, i02);
                    eventType2 = b0.b("key", xmlPullParser, i02);
                    str = b0.b("split", xmlPullParser, i02);
                    b0.c(xmlPullParser, i02);
                    if (eventType2 != null && str != null) {
                    }
                    if (str != null) {
                    }
                    i02.a(eventType, eventType2, str);
                }
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("entry") != null) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                eventType2 = b0.b("key", xmlPullParser, i02);
                str = b0.b("split", xmlPullParser, i02);
                b0.c(xmlPullParser, i02);
                if (eventType2 != null && str != null) {
                }
                if (str != null) {
                }
                i02.a(eventType, eventType2, str);
            }
            if (xmlPullParser.getEventType() == i) {
            }
            if (xmlPullParser.getName().equals("language") != null) {
            } else {
            }
            while (xmlPullParser.next() != str2) {
                if (xmlPullParser.getEventType() == i) {
                }
                if (xmlPullParser.getName().equals("entry") != null) {
                } else {
                }
                b0.c(xmlPullParser, i02);
                eventType2 = b0.b("key", xmlPullParser, i02);
                str = b0.b("split", xmlPullParser, i02);
                b0.c(xmlPullParser, i02);
                if (eventType2 != null && str != null) {
                }
                if (str != null) {
                }
                i02.a(eventType, eventType2, str);
            }
            if (xmlPullParser.getEventType() == i) {
            }
            if (xmlPullParser.getName().equals("entry") != null) {
            } else {
            }
            eventType2 = b0.b("key", xmlPullParser, i02);
            str = b0.b("split", xmlPullParser, i02);
            b0.c(xmlPullParser, i02);
            if (eventType2 != null && str != null) {
            }
            if (str != null) {
            }
            i02.a(eventType, eventType2, str);
            b0.c(xmlPullParser, i02);
            b0.c(xmlPullParser, i02);
            b0.c(xmlPullParser, i02);
            b0.c(xmlPullParser, i02);
            b0.c(xmlPullParser, i02);
            return i02.b();
            i02 = "SplitInstall";
            Log.e(i02, "Error while parsing splits.xml", xmlPullParser);
            xmlPullParser = null;
            return xmlPullParser;
        }
    }

    private static final String b(String string, XmlPullParser xmlPullParser2, com.google.android.play.core.splitinstall.i0 i03) {
        boolean equals;
        int obj3;
        obj3 = 0;
        while (obj3 < xmlPullParser2.getAttributeCount()) {
            obj3++;
        }
        return null;
    }

    private static final void c(XmlPullParser xmlPullParser, com.google.android.play.core.splitinstall.i0 i02) {
        int next;
        int i;
        int obj3;
        obj3 = 1;
        while (obj3 != null) {
            next = xmlPullParser.next();
            if (next != 2) {
            } else {
            }
            obj3++;
            if (next != 3) {
            } else {
            }
            obj3--;
        }
    }
}
