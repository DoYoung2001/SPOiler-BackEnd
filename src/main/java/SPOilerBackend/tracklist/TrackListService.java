package SPOilerBackend.tracklist;

import SPOilerBackend.user.User;
import SPOilerBackend.user.UserRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrackListService {
	
	private final TrackListRepository trackListRepository;
	private final UserRepository userRepository;
	
	public TrackListService(TrackListRepository trackListRepository,
		UserRepository userRepository) {
		this.trackListRepository = trackListRepository;
		this.userRepository = userRepository;
	}
	
	// 특정 사용자의 트랙리스트에 트랙 저장
	public void saveTrack(User user, TrackListDTO trackListDTO) {
		TrackList trackList = new TrackList(
			user,
			trackListDTO.spotifyId()
		);
		trackListRepository.save(trackList);
	}
	
	// 특정 사용자의 트랙리스트 조회
	public List<TrackList> getTracksByUserId(Long userId) {
		return trackListRepository.findByUserId(userId);
	}
	
	// 트랙리스트에서 트랙 삭제
	@Transactional
	public boolean deleteTrack(User user, String spotifyId) {
		if (trackListRepository.existsBySpotifyIdAndUserId(spotifyId, user.getId())) {
			trackListRepository.deleteBySpotifyIdAndUserId(spotifyId, user.getId());
			return true;
		}
		return false;

	}


	// 트랙리스트에서 모든 트랙 삭제
	@Transactional
	public void deleteAllTracks(User user) {
		trackListRepository.deleteByUserId(user.getId());
	}



}