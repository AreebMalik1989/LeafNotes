package github.areebmalik1989.leafnotes.data.entity;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;

import static github.areebmalik1989.leafnotes.data.entity.IdConverter.convertId;

public class LeafNoteData {

    private long id;
    private String title;
    private String description;

    public LeafNoteData() {}

    public LeafNoteData(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public LeafNoteData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        if (!(o instanceof LeafNoteData)) return false;

        LeafNoteData that = (LeafNoteData) o;

        if (getId() != that.getId()) return false;
        if (!getTitle().equals(that.getTitle())) return false;
        return getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LeafNoteData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static LeafNoteData from(LeafNote leafNote) {
        return new LeafNoteData(
                convertId(leafNote.getId()),
                leafNote.getTitle(),
                leafNote.getDescription());
    }

    public LeafNote fromThis() {
        return new LeafNote(
                new Identity(id),
                title,
                description);
    }
}
