package com.sparta.spring_week01.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Hanghae extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false)
    private String name; // 작성자명

    @Column(nullable = false)
    private  String password; //비밀번호

    @Column(nullable = false)
    private String content; //작성내용

//    @Column(nullable = true)
//    private String day;

    public Hanghae(HanghaeRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
       // this.day = requestDto.getDay();
    }

    public Hanghae(String title, String name, String password, String content, String day) {
        this.title = title;
        this.name = name;
        this.password = password;
        this.content = content;
      //  this.day = day;
    }

    public void update(HanghaeRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
       // this.day = requestDto.getDay();
    }



}
