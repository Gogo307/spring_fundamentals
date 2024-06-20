package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "comments ")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatic ++
    private long id;

    @Column(nullable = false)
    private boolean approved;

    @Column(nullable = false)
    private Instant created;

    @Column(name = "text_content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false, fetch = FetchType.LAZY) // TODO : only to match the scheme, not needed
    private Route route;

    public Comment(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
