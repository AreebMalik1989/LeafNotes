package github.areebmalik1989.core.domain;

public class LeafNote {

    private String title;
    private String description;

    private long createdTime;
    private long modifiedTime;

    public LeafNote() {}

    public LeafNote(long id, String title, String description, long createdTime, long modifiedTime) {
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeafNote)) return false;

        LeafNote leafNote = (LeafNote) o;

        if (getCreatedTime() != leafNote.getCreatedTime()) return false;
        if (getModifiedTime() != leafNote.getModifiedTime()) return false;
        if (!getTitle().equals(leafNote.getTitle())) return false;
        return getDescription().equals(leafNote.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + (int) (getCreatedTime() ^ (getCreatedTime() >>> 32));
        result = 31 * result + (int) (getModifiedTime() ^ (getModifiedTime() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "LeafNote{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}