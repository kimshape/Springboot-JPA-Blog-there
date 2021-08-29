package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!!
//ORM -> Java(다른 언어) Object -> 테이블로 매핑해주는 기술
@Entity // 클래스가 MySQL에 테이블이 생성된다.
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id; //시퀀스,auto_increment

    @Column(nullable = false,length = 200)
    private String content;

    @ManyToOne
    @JoinColumn(name = "BoardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;



}
