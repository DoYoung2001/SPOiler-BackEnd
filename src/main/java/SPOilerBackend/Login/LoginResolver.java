package SPOilerBackend.Login;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.NoSuchElementException;

//@Component // 다른 곳에서 주입받으려면 필요
//public class LoginResolver implements HandlerMethodArgumentResolver {

//    private final JwtProvider jwtProvider;
//    private final UserRepository userRepository;

//    public LoginResolver(JwtProvider jwtProvider, UserRepository userRepository) {
//        this.jwtProvider = jwtProvider;
//        this.userRepository = userRepository;
//    }

//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        return parameter.hasParameterAnnotation(LoginUser.class);
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        String token = extractToken(webRequest.getHeader(HttpHeaders.AUTHORIZATION));
//
//        //여기부터 중복 코드
//        if (token == null) {
//            throw new LoginFailedException("로그인 정보가 유효하지 않습니다.");
//        }
//        if (!jwtProvider.isValidToken(token)) {
//            throw new LoginFailedException("로그인 정보가 유효하지 않습니다.");
//        }
//        String userEmail = jwtProvider.getSubject(token);
//        //여기까지 중복 코드
//
//        //email-> user로
//        return userRepository.findByEmail(userEmail)
//                .orElseThrow(()-> new NoSuchElementException("다시 입력해주세요."));
//    }
//
//    //코드 경량화를 위한 함수
//    private String extractToken(String bearerToken){
//        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//}

