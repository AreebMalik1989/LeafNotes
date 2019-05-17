package github.areebmalik1989.core.domain;

public class LeafNote {

    private Identity id;

    private String title;
    private String description;

    public LeafNote() {}

    public LeafNote(Identity id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Identity getId() {
        return id;
    }

    public void setId(Identity id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeafNote)) return false;

        LeafNote leafNote = (LeafNote) o;

        if (!getId().equals(leafNote.getId())) return false;
        if (!getTitle().equals(leafNote.getTitle())) return false;
        return getDescription().equals(leafNote.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LeafNote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
