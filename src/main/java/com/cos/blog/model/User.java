package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!!
//ORM -> Java(다른 언어) Object -> 테이블로 매핑해주는 기술
@Entity // user 클래스가 MySQL에 테이블이 생성이 된다.
//@DynamicInsert // insert시에 null값을 제외
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; //시퀀스 auto_increment
    @Column(nullable = false, length = 30)
    private String username;
    @Column(nullable = false, length = 100) // length를 길게잡은 이유? => 123456... =>해쉬 (비밀번호 암호화)
    private String password;
    @Column(nullable = false, length = 50)
    private String email;

    // @ColumnDefault("'user'")
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum을 쓰는게 좋다. // admin,user,manager
    @CreationTimestamp // 시간이 자동입력
    private Timestamp createDate;

}
