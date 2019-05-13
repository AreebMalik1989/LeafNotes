package github.areebmalik1989.core.domain;

// expanded lombok @Value
public class Identity {

    private final long id;

    public Identity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identity)) return false;

        Identity identity = (Identity) o;

        return getId() == identity.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    @Override
    public String toString() {
        return "Identity{" +
                "id=" + id +
                '}';
    }

    public static Identity nothing() {
        return new Identity(Long.MIN_VALUE);
    }
}
