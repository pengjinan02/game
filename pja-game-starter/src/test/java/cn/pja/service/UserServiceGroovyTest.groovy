package cn.pja.service

import cn.pja.starter.model.vo.UserVO
import cn.pja.starter.service.UserService
import cn.pja.starter.start.MainApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


/**
 @author 彭金安
 @DATE 2021/10/2
 */
//@RunWith(SpringRunner.class) 这个注解不能加，不然会报No runnable methods。。也不知道为啥
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceGroovyTest extends Specification{

    @Autowired
    UserService userService

    def "selectUserByUid"() {
        when :
        UserVO userVO = userService.selectUserByUid("123")
        println userVO
        then :
        userVO != null

    }

    def "getDubboString"() {
        when :
        String message = userService.getDubboString("彭金安");
        then :
        message !=null
    }


}
