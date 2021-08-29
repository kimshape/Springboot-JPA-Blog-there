package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

    @GetMapping("/userlist")
    public List<User>list(){
        return userRepository.findAll();
    }

    //{id}주소로 파라미터를 전달 받을 수 있음.
    //http://localhost:8000/blog/dummy/user/3l
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        //user/4를 찾으면 내가 db에서 못찾아오게 되면 user가 null이 될 것 아냐?
        //그럼 return null 이 리턴 되잖아...... 그럼 프로그램에 문재,.,,
        //Optional로 너의 User객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해!

        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없다. ID : " + id);
            }
        });
        //요청 : 웹브라우저
        //user 객체 = 자바 오브젝트
        //변환 (웹브라우저가 이해할 수 있는 데이터로) ->
        //부트 는 MessageConverter....
        //user 오브젝트를 json으로 자동 변환시켜줌
        return user;
    }

    // http://localhost:8000/blog/dummy/join (요청)
    // http의 body에 username,password,email데이터를 가지고(요청)
    @PostMapping("/dummy/join")
    public String join(User user) { //key=value (약속된 규칙)
        System.out.println("id : " + user.getId());
        System.out.println("username : " + user.getUsername());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());
        System.out.println("role : " + user.getRole());
        System.out.println("createDate" + user.getCreateDate());

        user.setRole(RoleType.User);
        userRepository.save(user);
        return "회원가입 완료";

    }
}
