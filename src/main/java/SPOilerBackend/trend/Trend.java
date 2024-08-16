package SPOilerBackend.trend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Trend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long spotifyId;

    private Long count;


    //getter
    public Long getId() {
        return id;
    }

    public Long getSpotifyId() {
        return spotifyId;
    }

    public Long getCount() {
        return count;
    }

    public Trend(Long spotifyId, Long count) {
        this.spotifyId = spotifyId;
        this.count = count;
    }

    protected Trend() {
    }
}
