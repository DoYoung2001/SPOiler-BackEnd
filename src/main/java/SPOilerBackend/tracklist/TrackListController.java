package SPOilerBackend.tracklist;

import SPOilerBackend.Login.LoginUser;
import SPOilerBackend.user.User;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracklist")
@CrossOrigin(origins = "http://localhost:3000")
public class TrackListController {

	private final TrackListService trackListService;
	private static final Logger logger = LoggerFactory.getLogger(TrackListController.class);
	
	public TrackListController(TrackListService trackListService) {
		this.trackListService = trackListService;
	}
	
	// 특정 사용자의 트랙리스트에 트랙 저장
	@PostMapping
	public ResponseEntity<String> saveTrack(@LoginUser User user, @RequestBody TrackListDTO trackListDTO) {
		try {
			trackListService.saveTrack(user, trackListDTO);
			return ResponseEntity.ok("트랙이 사용자 재생 목록에 추가되었습니다.");
		} catch (Exception e) {
			logger.error("Error saving track: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("트랙 저장 중 오류가 발생하였습니다.");
		}
	}
	
	// 특정 사용자의 트랙리스트 조회
	@GetMapping
	public ResponseEntity<List<TrackList>> getTracksByUserId(@LoginUser User user) {
		try {
			List<TrackList> trackList = trackListService.getTracksByUserId(user.getId());
			return ResponseEntity.ok(trackList);
		} catch (Exception e) {
			logger.error("Error fetching tracks: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	// 트랙리스트에서 트랙 삭제
	@DeleteMapping("/{spotifyId}")
	public ResponseEntity<String> deleteTrack(@LoginUser User user, @PathVariable String spotifyId) {
		try {
			boolean deleted = trackListService.deleteTrack(user,spotifyId);
			if (deleted) {
				return ResponseEntity.ok("트랙이 성공적으로 삭제되었습니다.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제할 트랙을 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("트랙 삭제 중 오류가 발생했습니다.");
		}
	}

	// 트랙리스트에서 모든 트랙 삭제
	@DeleteMapping("/clear")
	public ResponseEntity<String> clearAllTracks(@LoginUser User user){
		try {
			trackListService.deleteAllTracks(user);
			return ResponseEntity.ok("모든 트랙이 성공적으로 삭제되었습니다.");
		} catch (Exception e) {
			logger.error("Error clearing all tracks: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("모든 트랙 삭제 중 오류가 발생했습니다.");
		}
	}

}