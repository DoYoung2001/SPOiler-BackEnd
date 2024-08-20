package SPOilerBackend.tracklist;

import SPOilerBackend.user.User;
import jakarta.persistence.*;

@Entity
public class TrackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spotifyId;

    @ManyToOne
    private User user;


    //getter
    public Long getId() {
        return id;
    }

    public String getSpotifyId() {
        return spotifyId;
    }
    
    public User getUser() {
        return user;
    }

    public TrackList(User user, String spotifyId) {
        this.user = user;
        this.spotifyId = spotifyId;
    }

    protected TrackList() {
    }
}