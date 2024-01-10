package com.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitDataComponent initDataComponent;

    @PostConstruct
    public void intData() {
        initDataComponent.initDataSetting();
    }
}
