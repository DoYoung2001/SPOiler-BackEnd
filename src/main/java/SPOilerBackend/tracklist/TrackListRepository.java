package SPOilerBackend.tracklist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackListRepository extends JpaRepository <TrackList, Long > {
	List<TrackList> findByUserId(Long userId);
}