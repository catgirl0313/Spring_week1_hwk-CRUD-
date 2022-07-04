package com.sparta.spring_week01.service;

import com.sparta.spring_week01.models.Hanghae;
import com.sparta.spring_week01.models.HanghaeRepository;
import com.sparta.spring_week01.models.HanghaeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class HanghaeService {
    private final HanghaeRepository hanghaeRepository;

    @Transactional
    public Long update(Long id, HanghaeRequestDto requestDto) {

        Hanghae hanghae = hanghaeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않습니다.")
        );

        if (!hanghae.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("일치하지 않습니다.");
        }

        hanghae.update(requestDto);

        return hanghae.getId();

    }
}

