class 1Mdat implements com.coremedia.iso.boxes.a {

    com.coremedia.iso.boxes.b parent;
    long size_ = -1;
    1Mdat(b bVar, long j, long j2, com.googlecode.mp4parser.e.f fVar) {
        this.val$startSample = j;
        this.val$endSample = j2;
        this.val$track = fVar;
        super();
    }

    public void getBox(java.nio.channels.WritableByteChannel writableByteChannel) throws java.io.IOException {
        java.nio.ByteBuffer allocate = ByteBuffer.allocate(8);
        g.g(allocate, (long)b.a(getSize()));
        allocate.put(d.e(getType()));
        allocate.rewind();
        writableByteChannel.write(allocate);
        b.this.a(this.val$startSample, this.val$endSample, this.val$track);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    public long getOffset() {
        throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
    }

    public com.coremedia.iso.boxes.b getParent() {
        return this.parent;
    }

    public long getSize() {
        if (this.size_ == -1) {
            b.this.a(this.val$startSample, this.val$endSample, this.val$track);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.size_;
        }
    }

    public void setParent(com.coremedia.iso.boxes.b bVar) {
        this.parent = bVar;
    }

    public String getType() {
        return "mdat";
    }

    public void parse(com.googlecode.mp4parser.a aVar, java.nio.ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
    }
}
