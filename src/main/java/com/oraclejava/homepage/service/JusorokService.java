package com.oraclejava.homepage.service;

import java.util.List;

import com.oraclejava.homepage.dto.Jusorok;
import com.oraclejava.homepage.repository.JusorokRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JusorokService {
    
    Logger logger = LoggerFactory.getLogger(JusorokService.class);

    @Autowired
    // JusorokMapper jusorokMapper;
    JusorokRepository jusorokRepository;

    public Jusorok create(Jusorok jusorok) {
        if (jusorokRepository.findById(jusorok.getNum()).isEmpty()) {
            return jusorokRepository.save(jusorok);
        } else {
            logger.warn("이미 등록된 주소입니다.");
            return null;
        }
    }

    public List<Jusorok> findAll() {
        List<Jusorok> list = jusorokRepository.findAll();

        return list;
    }

    public Jusorok delete(int num) {
        Jusorok s_jusorok = jusorokRepository.findById(num).get();
        jusorokRepository.delete(s_jusorok);
        return s_jusorok;
    }

    public Jusorok findOne(int num) {
        return jusorokRepository.getOne(num);
    }
}
