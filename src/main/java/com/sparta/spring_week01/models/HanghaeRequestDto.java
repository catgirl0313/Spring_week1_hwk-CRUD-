package com.sparta.spring_week01.models;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@RequiredArgsConstructor
@Setter
@Getter
public class HanghaeRequestDto {
    private String title; // 제목
    private String name; // 작성자명
    private String password; //비밀번호
    private String content; //작성내용
   // private String day; //작성날짜

}
