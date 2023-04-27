package com.kbstar.service;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Marker;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.AdmMapper;
import com.kbstar.mapper.MarkerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service

public class MarkerService implements KBService<Integer, Marker> {
@Autowired

    MarkerMapper mapper;
    @Override
    public void register(Marker marker) throws Exception {
        mapper.insert(marker);
    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(Marker marker) throws Exception {
         mapper.update(marker);
    }

    @Override
    public Marker get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<Marker> get() throws Exception {
        return mapper.selectall();
    }
}

