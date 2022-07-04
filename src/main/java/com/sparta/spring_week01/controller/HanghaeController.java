package com.sparta.spring_week01.controller;

import com.sparta.spring_week01.models.Hanghae;
import com.sparta.spring_week01.models.HanghaeRepository;
import com.sparta.spring_week01.models.HanghaeRequestDto;
import com.sparta.spring_week01.service.HanghaeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HanghaeController {
    public final HanghaeService hanghaeService;
    public final HanghaeRepository hanghaeRepository;

    @PostMapping("/api/hanghaes")
    public Hanghae creatHanghae(@RequestBody HanghaeRequestDto requestDto){
        Hanghae hanghae = new Hanghae(requestDto);
        return hanghaeRepository.save(hanghae);
    }

    @GetMapping("/api/hanghaes")
    public List<Hanghae> readHanghae() {
        return hanghaeRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/hanghaes/{id}")
    public Optional<Hanghae> findById(@PathVariable Long id) {
        return hanghaeRepository.findById(id);
    }

    @PutMapping("/api/hanghaes/{id}")
    public Long updateHanghae(@PathVariable Long id, @RequestBody HanghaeRequestDto requestDto){
        return hanghaeService.update(id, requestDto);
    }

    @DeleteMapping("/api/hanghaes/{id}")//1)param :{id} 2)query : ?id=? 3)requestbody : ajax {data} jason
    public Long deleteHanghae(@PathVariable Long id, @RequestBody HanghaeRequestDto requestDto){
        Hanghae hanghae = hanghaeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않습니다.")
        );
        if (!hanghae.getPassword().equals(requestDto.getPassword())) {
        throw new IllegalArgumentException("일치하지 않습니다.");
    }
        hanghaeRepository.deleteById(id);
        return id;
    }
}

//    @DeleteMapping("/api/hanghaes/{id}")//1)param :{id} 2)query : ?id=? 3)requestbody : ajax {data} jason
//    public Long deleteHanghae(@PathVariable Long id){
//        hanghaeRepository.deleteById(id);
//        return id;
//    }

//     if (!hanghae.getPassword().equals(requestDto.getPassword())) {
//        throw new IllegalArgumentException("일치하지 않습니다.");
//    }

//        hanghae.update(requestDto);
//
//        return hanghae.getId();

