package github.areebmalik1989.leafnotes.presenter.entities;


import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;

import java.util.List;
import java.util.stream.Collectors;

import static github.areebmalik1989.leafnotes.data.entity.IdConverter.convertId;

public class LeafNoteResponse {

    private final long id;
    private final String title;
    private final String description;

    public LeafNoteResponse(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeafNoteResponse)) return false;

        LeafNoteResponse that = (LeafNoteResponse) o;

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
        return "LeafNoteResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static LeafNoteResponse from(LeafNote leafNote) {
        return new LeafNoteResponse(
                convertId(leafNote.getId()),
                leafNote.getTitle(),
                leafNote.getDescription()
        );
    }

    public static List<LeafNoteResponse> from(List<LeafNote> leafNotes) {
        return leafNotes
                .parallelStream()
                .map(LeafNoteResponse::from)
                .collect(Collectors.toList());
    }
}
