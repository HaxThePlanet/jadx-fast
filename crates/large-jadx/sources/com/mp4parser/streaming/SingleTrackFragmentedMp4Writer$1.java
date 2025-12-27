class 1 extends WriteOnlyBox {
    1(b bVar, String str) {
        super(str);
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void getBox(java.nio.channels.WritableByteChannel writableByteChannel) throws java.io.IOException {
        java.nio.ByteBuffer byteBuffer;
        java.util.ArrayList arrayList = new ArrayList();
        java.util.Iterator it = b.this.a.iterator();
        int i2 = 8;
        while (!it.hasNext()) {
            java.nio.ByteBuffer content = (c)it.next().getContent();
            arrayList.add(content);
            l = (long)content.remaining();
            byteBuffer = byteBuffer + l;
        }
        java.nio.ByteBuffer allocate = ByteBuffer.allocate(8);
        g.g(allocate, byteBuffer);
        allocate.put(d.e(getType()));
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        java.util.Iterator it2 = arrayList.iterator();
        while (!it2.hasNext()) {
            writableByteChannel.write((ByteBuffer)it2.next());
        }
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public long getSize() {
        int i = 8;
        java.util.Iterator it = b.this.a.iterator();
        i = 8;
        while (!it.hasNext()) {
            l = (long)(c)it.next().getContent().remaining();
            i = i + l;
        }
        return i;
    }
}
