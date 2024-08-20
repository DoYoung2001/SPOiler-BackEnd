package SPOilerBackend.tracklist;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackListRepository extends JpaRepository <TrackList, Long > {
	List<TrackList> findByUserId(Long userId);
//	Optional<TrackList> findBySpotifyIdAndUserId(String spotifyId, Long userId);
	void deleteByUserId(Long userId);

	boolean existsBySpotifyIdAndUserId(String spotifyId, Long userId);

	void deleteBySpotifyIdAndUserId(String spotifyId, Long userId);
}