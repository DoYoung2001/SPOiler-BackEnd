package SPOilerBackend.tracklist;

import SPOilerBackend.user.User;
import jakarta.persistence.*;

@Entity
public class TrackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long spotifyId;

    private String trackName;

    @ManyToOne
    private User user;


    //getter
    public Long getId() {
        return id;
    }

    public Long getSpotifyId() {
        return spotifyId;
    }

    public String getTrackName() {
        return trackName;
    }

    public User getUser() {
        return user;
    }

    public TrackList(Long spotifyId, String trackName, User user) {
        this.spotifyId = spotifyId;
        this.trackName = trackName;
        this.user = user;
    }

    protected TrackList() {
    }
}
