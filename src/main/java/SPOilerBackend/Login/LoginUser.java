package SPOilerBackend.Login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // requestparam에 쓰인다~
@Retention(RetentionPolicy.RUNTIME) //실행할 때 적용된다~
//실행됐을 때 로그인 했는지 확인해주고 로그인할 때 토큰 발급도 해준다
public @interface LoginUser {

}